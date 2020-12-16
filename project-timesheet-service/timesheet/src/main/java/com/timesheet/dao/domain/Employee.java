package com.timesheet.dao.domain;

import org.springframework.data.annotation.Id;
import com.querydsl.core.annotations.QueryEntity;
import io.swagger.annotations.ApiModelProperty;
import lombok.*;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@ToString
@QueryEntity
@Document
public class Employee {
    @Id
    @ApiModelProperty(notes = "The database generated employee ID")
    private String empId;

    @ApiModelProperty(notes = "Employee username", required = true)
    private String username;

    @ApiModelProperty(notes = "Employee password", required = true)
    private String password;


    private Address address;

    private Contact contact;


}
