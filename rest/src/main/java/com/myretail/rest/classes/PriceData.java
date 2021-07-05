package com.myretail.rest.classes;

import com.fasterxml.jackson.annotation.JsonIgnore;

import org.bson.types.Decimal128;

public class PriceData {

    @JsonIgnore
    private String id;
    private Decimal128 value;
    private String currency_code;

    public String getId()
    {
        return id;
    }

    public void setId(String id)
    {
        this.id = id;
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

    @Override
    public String toString()
    {
        return String.format(
            "id: " + id + " " +
            "value: " + value + " " +
            "currency_code: " + currency_code
        );
    }
    
}
