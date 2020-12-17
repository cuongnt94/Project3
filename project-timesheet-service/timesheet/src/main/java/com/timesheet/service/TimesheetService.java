package com.timesheet.service;

import com.timesheet.vo.TimesheetRequest;
import com.timesheet.vo.TimesheetResponse;
import com.timesheet.vo.shortTimesheetRequest;
import com.timesheet.vo.shortTimesheetResponse;

import java.util.List;

/**
 * Description: <br>
 *
 * @author: Billy <br>
 * @createDate: 2020-12-14 <br>
 */
public interface TimesheetService {

     List<shortTimesheetResponse> getShortTimesheetResponseByEmpId(shortTimesheetRequest request);

     TimesheetResponse createTimesheet(TimesheetRequest request);

     TimesheetResponse getTimesheetByTimesheetId(TimesheetRequest request);

     TimesheetResponse updateTimesheetByTimesheetId(TimesheetRequest request);
}
