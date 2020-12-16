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
}
