package com.myretail.rest.classes;

import org.bson.types.Decimal128;

public class PriceData {

    private String id;
    private Decimal128 price;
    private String currencyCode;

    public String getId()
    {
        return id;
    }

    public void setId(String id)
    {
        this.id = id;
    }

    public Decimal128 getPrice()
    {
        return price;
    }

    public void setPrice(Decimal128 price)
    {
        this.price = price;
    }

    public String getCurrencyCode()
    {
        return currencyCode;
    }

    public void setCurrencyCode(String currencyCode)
    {
        this.currencyCode = currencyCode;
    }

    @Override
    public String toString()
    {
        return String.format(
            "id: " + id + " " +
            "price: " + price + " " +
            "currencyCode: " + currencyCode
        );
    }
    
}
