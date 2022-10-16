package com.osucart.inventory.Repo;

import com.osucart.inventory.Model.Inventory;
import org.springframework.data.jpa.repository.JpaRepository;

public interface InventoryRepo extends JpaRepository<Inventory, Long> {
}
