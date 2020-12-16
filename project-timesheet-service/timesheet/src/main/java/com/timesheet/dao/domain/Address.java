package com.timesheet.dao.domain;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Address {
    private String addressLine1;
    private String addressLine2;
    private String city;
    private String zip;
    private String country;

}