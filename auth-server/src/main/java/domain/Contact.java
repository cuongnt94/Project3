package domain;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Contact {
    private String phone;
    private String email;
    private String Emergency1Name;
    private String Emergency1Phone;
    private String Emergency2Name;
    private String Emergency2Phone;
}
