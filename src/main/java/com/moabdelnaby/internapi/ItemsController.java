package com.moabdelnaby.internapi;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.sql.Array;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@RestController
public class ItemsController {

    @Autowired
    private ItemsRepository itemsRepository;

    @GetMapping("/items")
    public List<Item> items(@RequestParam(value = "id", defaultValue = "-1") Integer id)
    {
        if (id != -1)
        {
            List<Item> items = new ArrayList<Item>();

            Optional<Item> optionalItem = itemsRepository.findById(id);
            if (optionalItem.isEmpty())
            {
                items.add(new Item(404, "This id is not available in the database"));
            }
            else
            {
                items.add(optionalItem.get());
            }
            return items;
        }

        return itemsRepository.findAll();
    }
}
