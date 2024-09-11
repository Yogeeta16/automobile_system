package com.app.dto;

import com.app.entities.Company;

import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Data
@Setter
@Getter
@NoArgsConstructor

public class VehicleRequestDTO {
   
    private String vname;

 
    private Company company;

    private String vnumber;

    private String vtype;

    private Long uid;  
}