package com.timesheet.vo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * Description: <br>
 *
 * @author: Billy <br>
 * @createDate: 2020-12-18 <br>
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class JWTPayload {

    private String EmpId;
    private String other;
}
