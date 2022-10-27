package controller;

import model.Item;
import model.ZoneCheckout;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import repository.InventoryRepository;

import java.util.List;

@RestController
public class InventoryController {
    @Autowired
    private InventoryRepository inventoryRepository;

    @GetMapping("/findItem/{id}")
    public Item getInventory(@PathVariable String id)
    {
        return inventoryRepository.findItemByID(id);
    }
    @GetMapping("/findItem")
    public List<Item> getAllItem()
    {
        return inventoryRepository.findAll();
    }
    @PostMapping("/addItem")
    public String addItem(@RequestBody Item item)
    {
        inventoryRepository.save(item);
        return "This item has been added successfully";
    }
    @PutMapping("/checkout/{id}")
    public String checkoutItem(@PathVariable String id, @RequestBody ZoneCheckout zoneCheckout)
    {
        Item checkout = inventoryRepository.findItemByID(id);
        int itemAmount = checkout.getItemAmount();
        int checkoutAmount = zoneCheckout.getCheckoutAmount();
        if(checkoutAmount > itemAmount)
        {
            return "Does not have enough " + checkout.getItemName() + " in stock";
        }
        else{
            List<ZoneCheckout> listCheckout = checkout.getItemCheckout();
            listCheckout.add(zoneCheckout);
            checkout.setItemAmount(itemAmount - checkoutAmount);
            checkout.setItemCheckout(listCheckout);
            inventoryRepository.save(checkout);
            return "This item has been checked out successfully";
        }
    }
    @DeleteMapping("/delete/{id}")
    public String deleteItem(@PathVariable String id)
    {
        inventoryRepository.deleteById(id);
        return "This item has been removed successfully";
    }
}
