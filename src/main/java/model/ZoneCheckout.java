package model;

import lombok.AllArgsConstructor;
import lombok.Data;
import org.springframework.data.annotation.Id;

@Data
@AllArgsConstructor
public class ZoneCheckout {
    @Id
    private String checkoutID;
    private String checkoutName;
    private int checkoutAmount;
}
