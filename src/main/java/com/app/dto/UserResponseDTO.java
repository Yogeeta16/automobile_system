package com.app.dto;


import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@NoArgsConstructor
public class UserResponseDTO {
    private Long uid;
    private String uname;
    private String email;
    private String city;
    private String contactNo;
}
