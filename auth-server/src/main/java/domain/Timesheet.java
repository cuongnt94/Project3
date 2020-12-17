package domain;

import org.springframework.data.annotation.Id;
import com.querydsl.core.annotations.QueryEntity;
import io.swagger.annotations.ApiModelProperty;
import lombok.*;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import java.time.LocalDate;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@ToString
@QueryEntity
@Document
public class Timesheet {

    @Id
    @ApiModelProperty(notes = "The database generated timesheet ID")
    private String timesheetId;

    @ApiModelProperty(notes = "The database generated empID")
    private String empId;
    @ApiModelProperty(notes = "The database generated comment")
    private String comment;
    @ApiModelProperty(notes = "The database generated approvalStatus")
    private String approvalStatus;
    @ApiModelProperty(notes = "The database generated weekEndDate")
    private String weekEndDate;
    private Day[] days;
    public Timesheet(String empId, LocalDate startingDate){
        this.empId = empId;
        this.comment = "";
        this.approvalStatus = "";
        generateDays(startingDate);
        this.weekEndDate = days[6].getDate();
    }
    public void generateDays(LocalDate StartingDate){
        Day[] days = new Day[7];
        StartingDate.plusDays(1);

        for(int i = 0; i < days.length; i ++){
            Day d = new Day(null,
                    null,
                    0,
                    false,
                    false,
                    StartingDate.plusDays(i).toString());
            days[i] = d;
        }
        this.days = days;
    }
}
