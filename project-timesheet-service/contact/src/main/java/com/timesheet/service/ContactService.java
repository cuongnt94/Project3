package com.timesheet.service;

import com.timesheet.vo.ContactRequest;
import com.timesheet.vo.ContactResponse;

/**
 * Description: <br>
 *
 * @author: Billy <br>
 * @createDate: 2020-12-15 <br>
 */
public interface ContactService {

    ContactResponse getContactByEmpId(ContactRequest request);

    ContactResponse updateContactByEmpId(ContactRequest request);

}
