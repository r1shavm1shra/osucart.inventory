package com.osucart.inventory.Model;

import com.vladmihalcea.hibernate.type.json.JsonType;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.Type;
import org.hibernate.annotations.TypeDef;

import javax.persistence.*;
import java.util.List;


@Getter
@Setter
@Entity
@TypeDef(name = "json", typeClass = JsonType.class)
public class Inventory {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;


    @Type(type = "json")
    @Column(columnDefinition = "json")
    private Item item;

}
@Getter
@Setter
class Item
{
    public String brand;
    public String title;
    public List<String> images;
    public List<String> features;
    public String category;
    public Price price;
    public Rating rating;

}
@Getter
@Setter
class Price
{
    public String currency;
    public float value;
    public int discount;

}
@Getter
@Setter
class Rating
{
    public int count;
    public int value;
}