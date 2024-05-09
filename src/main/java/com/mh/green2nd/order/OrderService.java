package com.mh.green2nd.order;

import com.mh.green2nd.cart.cartMenu.CartMenu;
import com.mh.green2nd.cart.cartMenu.CartMenuRepository;
import com.mh.green2nd.menu.Menu;
import com.mh.green2nd.order.dto.OrderReqDto;
import com.mh.green2nd.order.orderitem.OrderMenu;
import com.mh.green2nd.order.orderitem.OrderMenuRepository;
import com.mh.green2nd.user.User;
import com.mh.green2nd.user.UserRepository;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class OrderService {

    private final OrderRepository orderRepository;
    private final OrderMenuRepository orderMenuRepository;
    private final CartMenuRepository cartMenuRepository;
    private final UserRepository userRepository;

    @Transactional
    public void createNewOrder(OrderReqDto[] orderReqDtoArrary, User jwtUser) {

        User dbUser = userRepository.findById(jwtUser.getUser_id()).orElseThrow(()->{
            return new IllegalArgumentException("해당 유저가 없습니다.");
        });

        // 주문한메뉴  order 테이블추가
        Order order = new Order();
        order.setUser(dbUser);
        orderRepository.save(order);

        for(OrderReqDto orderReqDto : orderReqDtoArrary){
            OrderMenu orderMenu = new OrderMenu();
            orderMenu.setOrder(order);
            Menu menu = cartMenuRepository.findById(
                                        orderReqDto.getCartmenu_id())
                                        .get().getMenu();
            orderMenu.setMenu(menu);
            orderMenu.setQuantity(orderReqDto.getQuantity());
            orderMenuRepository.save(orderMenu);
        }

        for (OrderReqDto orderReqDto : orderReqDtoArrary) {
            CartMenu cartMenu = cartMenuRepository.findById(orderReqDto.getCartmenu_id())
                    .orElseThrow(() -> new IllegalArgumentException("해당 상품이 존재하지 않습니다."));
            System.out.println("장바구니안에 있는 메뉴 "+cartMenu.getMenu());
            System.out.println("장바구니안에 있는 수량"+cartMenu.getQuantity());
            System.out.println("주문한 수량"+orderReqDto.getQuantity());
            System.out.println("장바구니메뉴id"+orderReqDto.getCartmenu_id());
            // 장바구니안에 있는 메뉴 삭제
            cartMenuRepository.deleteById(orderReqDto.getCartmenu_id());
        }
    }

    // 주문내역 보여주기
    public List<OrderDetail> viewmenu() {
        List<Order> orders = orderRepository.findAll();
        List<OrderDetail> orderDetails = new ArrayList<>();

        for (Order order : orders) {
            OrderDetail detail = new OrderDetail();
            detail.setOrderId(order.get);
            detail.setCustomerName(order.getCustomer().getName());
            detail.setOrderStatus(order.getStatus());
            detail.setTotalAmount(order.getTotalAmount());

            orderDetails.add(detail);
        }

        return orderDetails;
    }
//    private Order convertToEntity(OrderDto orderDto) {
//        // 여기에서 OrdersDto를 Orders 엔티티로 변환하는 코드 작성
//    }
//
//    private OrderDto convertToDto(com.mh.green2nd.order.Order order) {
//        // 여기에서 Orders 엔티티를 OrdersDto로 변환하는 코드 작성
//    }
//
//
//    public static Optional<OrderDto> neworder(Long ordersId) {
//    }
}

