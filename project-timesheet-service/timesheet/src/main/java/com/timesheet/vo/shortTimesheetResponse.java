package com.timesheet.vo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * Description: <br>
 *
 * @author: Billy <br>
 * @createDate: 2020-12-14 <br>
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class shortTimesheetResponse {

    private String WeekEndingDate;
    private Integer TotalHours;
    private String SubmissionStatus;
    private String ApprovalStatus;
    private String Comment;

}
