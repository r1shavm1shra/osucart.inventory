package com.osucart.inventory.Repo;

import com.osucart.inventory.Model.Inventory;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

public interface InventoryRepo extends JpaRepository<Inventory, Long> {

    @Transactional
    @Modifying(flushAutomatically = true)
    @Query(value = "update inventory i set i.quantity = i.quantity - :quantity where i.id=:id and (i.quantity-:quantity)>=0",
    nativeQuery = true)
    int updateQuantityForItem(Long id,
                                   @Param("quantity") Long quantity);
}
