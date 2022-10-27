package model;

import lombok.AllArgsConstructor;
import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.List;

@Data
@AllArgsConstructor
@Document (collection = "InventoryDatabase")
public class Item {
    @Id
    private String itemBarcode;
    private String itemName;
    private int itemAmount;
    private List<ZoneCheckout> itemCheckout;
}
