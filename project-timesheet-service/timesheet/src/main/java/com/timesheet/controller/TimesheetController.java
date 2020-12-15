package com.timesheet.controller;

import com.alibaba.fastjson.JSON;
import com.timesheet.service.TimesheetService;
import com.timesheet.vo.TimesheetRequest;
import com.timesheet.vo.TimesheetResponse;
import com.timesheet.vo.shortTimesheetRequest;
import com.timesheet.vo.shortTimesheetResponse;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * Description: <br>
 *
 * @author: Billy <br>
 * @createDate: 2020-12-14 <br>
 */
@Slf4j
@RestController
public class TimesheetController {

    private final TimesheetService timesheetService;

    @Autowired
    public TimesheetController(TimesheetService timesheetService) {
        this.timesheetService = timesheetService;
    }

    @PostMapping("/getShortTimesheet")
    public List<shortTimesheetResponse> getShortTimesheetResponseByEmpId(@RequestBody shortTimesheetRequest request) throws Exception {
        log.info("timesheet: getShortTimesheetResponseByEmpId -> {}", JSON.toJSONString(request));

        return timesheetService.getShortTimesheetResponseByEmpId(request);
    }

    @PostMapping("/createTimesheet")
    public TimesheetResponse createTimesheet(@RequestBody TimesheetRequest request) throws Exception {
        log.info("timesheet: getTimesheetByTimesheetId -> {}", JSON.toJSONString(request));

        return null;
    }

    @PostMapping("/getTimesheet")
    public TimesheetResponse getTimesheetByTimesheetId(@RequestBody TimesheetRequest request) throws Exception {
        log.info("timesheet: getTimesheetByTimesheetId -> {}", JSON.toJSONString(request));

        return null;
    }

    @PutMapping("/UpdateTimesheet")
    public TimesheetResponse updateTimesheet (@RequestBody TimesheetRequest request) throws Exception {
        log.info("timesheet: updateTimesheet -> {}", JSON.toJSONString(request));

        return null;
    }
}
