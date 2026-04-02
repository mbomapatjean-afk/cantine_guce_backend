package com.guce.cantine.dto;

import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;

@Getter
@Setter
public class CommandeRequest {
    private Long userId;
    private Long menuId;
    private LocalDate dateChoix;
    private String qrCode;
}