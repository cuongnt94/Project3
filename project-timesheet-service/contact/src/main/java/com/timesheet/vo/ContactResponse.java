package com.timesheet.vo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

/**
 * Description: <br>
 *
 * @author: Billy <br>
 * @createDate: 2020-12-15 <br>
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class ContactResponse {

    private String Phone;
    private String Email;
    private String Address;
    private String EmergencyContact1Name;
    private String EmergencyContact1Phone;
    private String EmergencyContact2Name;
    private String EmergencyContact2Phone;

}
