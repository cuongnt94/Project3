package com.timesheet.controller;

import com.alibaba.fastjson.JSON;
import com.timesheet.service.ContactService;
import com.timesheet.vo.ContactRequest;
import com.timesheet.vo.ContactResponse;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Description: <br>
 *
 * @author: Billy <br>
 * @createDate: 2020-12-15 <br>
 */
@Slf4j
@RestController
public class ContactController {

    private final ContactService contactService;

    @Autowired
    public ContactController(ContactService contactService) {
        this.contactService = contactService;
    }

    @PostMapping("/getcontact")
    public ContactResponse getContactByEmpId(ContactRequest request) throws Exception {
        log.info("contact: getContactByEmpId -> {}", JSON.toJSONString(request));

        return contactService.getContactByEmpId(request);
    }

    public ContactResponse updateContactByEmpId(ContactRequest request) throws Exception {
        log.info("contact: updateContactByEmpId -> {}", JSON.toJSONString(request));

        return contactService.updateContactByEmpId(request);
    }
}
