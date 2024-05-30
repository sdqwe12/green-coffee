package com.mh.green2nd.custom;

import com.mh.green2nd.user.User;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
@Tag(name = "Custom 커스텀", description = "즐겨찾기 = 커스텀 = 나만의메뉴")
public class Custom {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @OneToOne
    @JoinColumn(name = "user_id")
    private User user;

//    @OneToMany(cascade = CascadeType.ALL, mappedBy = "custom")
//    private

}
