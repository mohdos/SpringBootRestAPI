package com.moabdelnaby.internapi;

import javax.persistence.*;

@Entity
@Table(name="Items")
public class Item {

    @Id
    private Integer id;
    private String name;

    public Item(Integer id, String name)
    {
        this.name = name;
        this.id = id;
    }

    public Item() {

    }

    public String getName()
    {
        return this.name;
    }

    public Integer getId()
    {
        return this.id;
    }

    @Override
    public String toString() {
        return "Item{" +
                "id=" + id +
                ", name='" + name + '\'' +
                '}';
    }
}
