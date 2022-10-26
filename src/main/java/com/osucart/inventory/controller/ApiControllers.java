package com.osucart.inventory.controller;

import com.osucart.inventory.Model.Inventory;
import com.osucart.inventory.Repo.InventoryRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;
@CrossOrigin
@RestController
public class ApiControllers {
    @Autowired
    private InventoryRepo inventoryRepo;
    @GetMapping
    public String hello()
    {
        return "Hello World";
    }

    @GetMapping("/products")
    public List<Inventory> getAll()
    {
        System.out.println(org.hibernate.Version.getVersionString());
        return inventoryRepo.findAll();
    }
    @GetMapping("/products/{id}")
    public Optional<Inventory> getById(@PathVariable long id)
    {
        return inventoryRepo.findById(id);
    }
    @PostMapping("/saveInventory")
    public String saveInventory(@RequestBody Inventory inventory){
        inventoryRepo.save(inventory);
        return "Saved...";
    }

    @PostMapping("/saveBulkInventory")
    public String saveBulkInventory(@RequestBody List<Inventory> inventoryList)
    {
        inventoryRepo.saveAll(inventoryList);
        return "Saved...";
    }


    @PostMapping("/decrementInventoryCount")
    public boolean decrementInventoryCount(@RequestBody List<Inventory> inventoryList)
    {
        boolean result = false;
        try{
            result = transactionHelper(inventoryList);
        }
        catch (Exception e)
        {

        }
        return result;
    }
    @Transactional(rollbackFor=Exception.class)
    public boolean transactionHelper(List<Inventory> inventoryList)
    {
        int items = 0;
        for(Inventory inventory: inventoryList) {
            items = inventoryRepo.updateQuantityForItem(inventory.getId(), inventory.getQuantity());
            if (items==0)
                throw new RuntimeException();
        }
        return true;
    }

    @DeleteMapping("/delete/{id}")
    public String deleteInventory(@PathVariable long id)
    {
        inventoryRepo.deleteById(id);
        return "deleted...";
    }

}
