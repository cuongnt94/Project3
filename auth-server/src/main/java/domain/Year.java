package domain;

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
public class Year {
    @Id
    @ApiModelProperty(notes = "The database generated timesheet ID")
    private String yearId;
    @ApiModelProperty(notes = "The database generated empID")
    private String empId;
    private String year;
    private Month[] months;
    private int floatingDays;
    private int vacationDays;
    public Year(String empId, String year){
        this.floatingDays = 7;
        this.vacationDays = 7;
        this.empId = empId;
        this.year = year;
        this.months = new Month[13];

        this.months[1] = new Month("January","01");
        this.months[2] = new Month("February","");
        this.months[3] = new Month("March","");
        this.months[4] = new Month("April","");
        this.months[5] = new Month("May","25");
        this.months[6] = new Month("June","");
        this.months[7] = new Month("July","04");
        this.months[8] = new Month("August","");
        this.months[9] = new Month("September","07");
        this.months[10] = new Month("October","");
        this.months[11] = new Month("November","11,26");
        this.months[12] = new Month("December","24,25");

    }
}
