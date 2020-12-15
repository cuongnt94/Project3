package com.timesheet.service.impl;

import com.timesheet.service.TimesheetService;
import com.timesheet.vo.TimesheetRequest;
import com.timesheet.vo.TimesheetResponse;
import com.timesheet.vo.shortTimesheetRequest;
import com.timesheet.vo.shortTimesheetResponse;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Description: <br>
 *
 * @author: Billy <br>
 * @createDate: 2020-12-14 <br>
 */
@Service
public class TimesheetServiceImpl implements TimesheetService {

    @Override
    public List<shortTimesheetResponse> getShortTimesheetResponseByEmpId(shortTimesheetRequest request) {
        return null;
    }

    @Override
    public TimesheetResponse createTimesheet(TimesheetRequest request) {
        return null;
    }

    @Override
    public TimesheetResponse getTimesheetByTimesheetId(TimesheetRequest request) {
        return null;
    }

    @Override
    public TimesheetResponse updateTimesheetByTimesheetId(TimesheetRequest request) {
        return null;
    }
}
