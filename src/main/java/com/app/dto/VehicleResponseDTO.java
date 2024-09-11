package com.app.dto;

import com.app.entities.Company;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@NoArgsConstructor
public class VehicleResponseDTO {
    private Long id;
    private String vname;
    private Company company;
    private String vnumber;
    private String vtype;
    private Long uid;  
}
