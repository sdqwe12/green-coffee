package com.mh.green2nd.store;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.persistence.*;
import lombok.Data;
import lombok.RequiredArgsConstructor;

@Entity
@Table(name = "store")
@Data
@RequiredArgsConstructor
public class Store {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "name")
    private String name;

    @Column(name = "address")
    private String address;

    @Column(name = "phone")
    private String phone;

    @Column(name = "open")
    private String open;

    @Column(name = "close")
    private String close;

    @Column(name = "holiday")
    private String holiday;

    @Column(name = "status", nullable = false, columnDefinition = "영업중")
    @Schema(title = "status",description = "영업중, 휴무중, 영업종료", defaultValue = "영업중")
    private String status;

}
