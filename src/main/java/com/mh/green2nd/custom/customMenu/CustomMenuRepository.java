package com.mh.green2nd.custom.customMenu;

import com.mh.green2nd.user.User;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;


//public interface CustomMenuRepository extends JpaRepository<CustomMenu, Long>{
//    void delete(CustomMenu customMenu);
//
//}

public interface CustomMenuRepository extends JpaRepository<CustomMenu, Long> {
    Page<CustomMenu> findByCustom_User(User user, Pageable pageable);
    void delete(CustomMenu customMenu);
}
