package com.example.hw;

import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;

@Component
public class ForeignKeyBasedRun {

    @PersistenceContext
    private EntityManager entityManager;

    @Transactional
    public void sampleRun() {
        // Create and persist CorruptedItem
        CorruptedItem corrupt = new CorruptedItem();
        corrupt.setReason("broken");
        entityManager.persist(corrupt);

        // Create and persist Item
        Item item = new Item();
        item.setName("Barby");
        item.setCatalog("Toy");
        item.setPrice(15000L);
        item.setCorruptedItem(corrupt);
        entityManager.persist(item);

        // Persist another Item
        Item item2 = new Item();
        item2.setName("Ken");
        entityManager.persist(item2);

        // Remove an Item
		/*
		 * Item managedItem = entityManager.find(Item.class, item.getId()); if
		 * (managedItem != null) { entityManager.remove(managedItem); }
		 */
    }
}
