package com.app.dto;

import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Data
@Setter
@Getter
@NoArgsConstructor
public class UserRequestDTO {
    
    private String uname;

    private String email;

    private String password;

   
    private String city;

    private String contactNo;
}