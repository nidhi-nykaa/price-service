package com.nykaa.marketplace.dto;

import java.util.List;

public class PriceUploadConfig {
    private List<Headers> headers;

    private List<Data> data;

    public void setHeaders(List<Headers> headers){
        this.headers = headers;
    }
    public List<Headers> getHeaders(){
        return this.headers;
    }
    public void setData(List<Data> data){
        this.data = data;
    }
    public List<Data> getData(){
        return this.data;
    }

}
