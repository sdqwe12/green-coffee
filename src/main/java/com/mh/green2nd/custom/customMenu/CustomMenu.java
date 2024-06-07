package com.mh.green2nd.custom.customMenu;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.mh.green2nd.custom.Custom;
import com.mh.green2nd.menu.Menu;
import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.persistence.*;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import lombok.*;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "custommenu")
public class CustomMenu {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "custommenu_id", nullable = false)
    private Long customMenuId;

    @ManyToOne
    @JoinColumn(name = "custom_id")
    @JsonBackReference
    private Custom custom;

    @ManyToOne
    @JoinColumn(name = "menu_id")
//    @JsonIgnore
    private Menu menu;

//    public Long getMenuId() {
//        return this.menu.getId();
//    }

    @JsonIgnore
    @Column(columnDefinition = "integer default 1")
    private int quantity;

    @Schema(description = "나만의 메뉴 이름")
    @Column(nullable = false, length = 20)
    private String myname;

    @Max(2)
    @Min(0)
    private int size;

    @Max(2)
    @Min(0)
    private int ice;

    @Max(3)
    @Min(0)
    private int shot;

    @Max(3)
    @Min(0)
    private int cream;

}
