package com.nykaa.service.impl;

import com.nykaa.cs.service.ServiceMetaData;
import org.springframework.stereotype.Service;

@Service
public class ServiceMetaDataImpl implements ServiceMetaData {

    @Override
    public String getApplicationName() {
        return "Price Service";
    }

    @Override
    public void reloadSystemCache() {
        System.out.println("reloading cache");
    }
}
