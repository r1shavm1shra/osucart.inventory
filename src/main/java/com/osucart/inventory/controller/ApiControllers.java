package com.osucart.inventory.controller;

import com.osucart.inventory.Model.Inventory;
import com.osucart.inventory.Repo.InventoryRepo;
import org.springframework.beans.factory.annotation.Autowired;
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

    @DeleteMapping("/delete/{id}")
    public String deleteInventory(@PathVariable long id)
    {
        inventoryRepo.deleteById(id);
        return "deleted...";
    }

}
