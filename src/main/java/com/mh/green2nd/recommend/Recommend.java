package com.mh.green2nd.recommend;

import jakarta.persistence.*;
import lombok.*;

@Data
@Getter
@Setter
@Entity
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "recommend")
public class Recommend {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long recommendId;

    @Column(name = "menu_category")
    private String menuCategory;

    @Column(name = "menu_name")
    private String menuName;

    @Column(name = "menu_ename")
    private String menuEname;

    @Column(name = "menu_price")
    private int menuPrice;

    @Column(name = "menu_explain")
    private String menuExplain;

    @Column(name = "menu_image_url")
    private String menuImageUrl;

}
