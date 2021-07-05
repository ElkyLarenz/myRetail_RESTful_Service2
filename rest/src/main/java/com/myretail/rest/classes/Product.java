package com.myretail.rest.classes;

import org.bson.types.Decimal128;

public class Product {
    
    private int id;
    private String name;
    private Decimal128 value;
    private String currency_code;
    //private Object[] current_price;

    public int getId()
    {
        return id;
    }

    public void setId(int id)
    {
        this.id = id;
    }

    public String getName()
    {
        return name;
    }

    public void setName(String name)
    {
        this.name = name;
    }

    public Decimal128 getValue()
    {
        return value;
    }

    public void setValue(Decimal128 value)
    {
        this.value = value;
    }

    public String getCurrency_code()
    {
        return currency_code;
    }

    public void setCurrency_code(String currency_code)
    {
        this.currency_code = currency_code;
    }

    // public Object[] getCurrent_price()
    // {
    //     return current_price;
    // }

    // public void setCurrent_price(Decimal128 value, String currency_code)
    // {
    //     this.value = value;
    //     this. currency_code = currency_code;
    //     this.current_price[0] = value;
    //     this.current_price[1] = currency_code;
    // }

    @Override
    public String toString()
    {
        return String.format(
            "id: " + id + " " +
            "name: " + name + " " +
            "value: " + value + " " +
            "currency_code: " + currency_code
        );
    }

}
