package com.ihsan.useralbum.dto.request;

import com.ihsan.useralbum.repository.entity.EUserType;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
public class UserSaveRequestDto {


    private  String name;

    private  String surName;

    private  String email;

    private String userName;

    //private  String telephone;

    private String password;

    private EUserType userType;


}
