package com.mh.green2nd.custom;

import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Data;

@Data
@Entity
@Tag(name = "Custom", description = "Custom API")
public class Custom {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
}
