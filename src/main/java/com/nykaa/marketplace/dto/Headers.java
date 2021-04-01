package com.nykaa.marketplace.dto;

public class Headers {
    private String name;

    private String datatype;

    private String validators;

    public void setName(String name){
        this.name = name;
    }
    public String getName(){
        return this.name;
    }
    public void setDatatype(String datatype){
        this.datatype = datatype;
    }
    public String getDatatype(){
        return this.datatype;
    }
    public void setValidators(String validators){
        this.validators = validators;
    }
    public String getValidators(){
        return this.validators;
    }
}
