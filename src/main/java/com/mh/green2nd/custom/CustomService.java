package com.mh.green2nd.custom;

import com.mh.green2nd.cart.Cart;
import com.mh.green2nd.cart.CartRepository;
import com.mh.green2nd.cart.cartMenu.CartMenu;
import com.mh.green2nd.cart.cartMenu.CartMenuRepository;
import com.mh.green2nd.cart.cartMenu.CartMenuService;
import com.mh.green2nd.custom.customMenu.CustomMenu;
import com.mh.green2nd.custom.customMenu.CustomMenuRepository;
import com.mh.green2nd.jwt.TokenManager;
import com.mh.green2nd.menu.Menu;
import com.mh.green2nd.menu.MenuRepository;
import com.mh.green2nd.user.User;
import com.mh.green2nd.user.UserRepository;
import jakarta.persistence.EntityNotFoundException;
import lombok.Data;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Collections;
import java.util.List;
import java.util.Optional;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;


@Data
@Service
@RequiredArgsConstructor

public class CustomService {

    private final CustomRepository customRepository;
    private final CartRepository cartRepository;
    private final UserRepository userRepository;
    private final MenuRepository menuRepository;
    private final CartMenuRepository cartMenuRepository;
    private final CartMenuService cartMenuService;
    private final TokenManager tokenManager;
    private final CustomMenuRepository customMenuRepository;


    public CustomResDto addToCustom(CustomReqDto customReqDto, User user) {
        User customUser = userRepository.findById(user.getUser_id())
                .orElseThrow(
                        () -> new IllegalArgumentException("해당 사용자가 없습니다."));

        Menu menu = menuRepository.findById(customReqDto.getMenuId())
                .orElseThrow(
                        () -> new IllegalArgumentException("해당 메뉴가 없습니다."));

        // 사용자의 나만의메뉴 가져오기
        Custom custom = customRepository.findByUser(customUser).orElse(new Custom());
        if (custom.getCustomMenus().isEmpty()) {
            custom.setUser(customUser);
        }

        // 나만의 메뉴에 이미 존재하는 이름인지
        CustomMenu existingCustomMenu = custom.getCustomMenus().stream()
                .filter(customMenu -> customMenu.getMyname() != null && customMenu.getMyname().equals(customReqDto.getMyname()))
                .findFirst()
                .orElse(null);

        // 이미 존재하는 이름이라면
        if (existingCustomMenu != null) {
            throw new IllegalArgumentException("이미 같은 이름의 나만의 메뉴가 있습니다. 다른 이름을 사용해주세요.");
        } else {
            CustomMenu customMenu = new CustomMenu();
            customMenu.setMenu(menu);
            customMenu.setCustom(custom);
            customMenu.setMyname(customReqDto.getMyname());

            // myname 필드의 값을 출력합니다.
            System.out.println(" 서비스의 myname 오냐: " + customMenu.getMyname());

            customMenu.setSize(customReqDto.getSize());
            customMenu.setIce(customReqDto.getIce());
            customMenu.setShot(customReqDto.getShot());
            customMenu.setCream(customReqDto.getCream());

            custom.getCustomMenus().add(customMenu);
        }

        customRepository.save(custom);
        CustomResDto customResDto = new CustomResDto();
        return customResDto;
    }

//    public List<CustomMenu> searchToCustom(User user) {
//        // 사용자의 이메일로 사용자 정보를 가져옵니다.
//        User customUser = userRepository.findByEmail(user.getEmail());
//
//        // 사용자의 ID를 기반으로 해당 사용자의 장바구니 아이템을 조회합니다.
//        Optional<Custom> optionalCustom = customRepository.findByUser(customUser);
//
//        // 만약 optionalCart가 비어있다면 빈 리스트를 반환합니다.
//        if (optionalCustom.isEmpty()) {
//            return Collections.emptyList();
//        }
//
//        // Optional에서 Cart 객체를 가져옵니다.
//        Custom custom = optionalCustom.get();
//
//        // Cart 객체에서 장바구니 아이템 목록을 가져옵니다.
//        List<CustomMenu> customMenus = custom.getCustomMenus();
//
//        return customMenus;
//    }

    public Page<CustomMenu> searchToCustom(User user, int page, int size) {
        Pageable pageable = PageRequest.of(page, size);
        return customMenuRepository.findByCustom_User(user, pageable);
    }


    @Transactional
    public void removeFromCustom(CustomDeleteDto customDeleteDto, User user) {
        // 현재 인증된 사용자의 커스텀 메뉴를 가져옵니다.
        Custom custom = customRepository.findByUser(user)
                .orElseThrow(() -> new EntityNotFoundException("Custom not found for user: " + user.getUser_id()));

        // 커스텀 메뉴에서 해당 항목을 찾습니다.
        CustomMenu customMenu = custom.getCustomMenusList().stream()
                .filter(cm -> cm.getMyname() != null && cm.getMyname().equals(customDeleteDto.getMyname()))
                .findFirst()
                .orElseThrow(() -> new EntityNotFoundException("Menu not found in custom: " + customDeleteDto.getMyname()));

        // myname 필드의 값을 출력합니다.
        System.out.println("myname: " + customMenu.getMyname());

        // 커스텀 메뉴에서 해당 항목을 삭제합니다.
        custom.getCustomMenusList().remove(customMenu);
        customMenuRepository.delete(customMenu);
    }



    /*



     */


}
