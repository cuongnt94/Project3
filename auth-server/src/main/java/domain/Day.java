package domain;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Day {
    private String startingTime;
    private String endingTime;
    private double totalHours;
    private boolean floatingDay;
    private boolean vacationDay;
    private String date;

//    public Day(String startingTime, String endingTime, double totalHours, boolean floatingDay, boolean vacationDay, String date){
//        this.startingTime = startingTime;
//        this.endingTime = endingTime;
//        this.totalHours = totalHours;
//        this.floatingDay = floatingDay;
//        this.vacationDay = vacationDay;
//        this.date = date;
//
//    }
//    public String getDate(){
//        return date;
//    }
}
