package com.nykaa.service;

import com.nykaa.cache.AppConfigCache;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

@Service("startUpService")
public class StartUpService {
    private static final Logger LOG = LoggerFactory.getLogger(StartUpService.class);

    public void load() {
        LOG.info("loading template cache....");
       // loadAppCache();
    }
    public void loadAppCache() {
        AppConfigCache.populateDataInCacheManager();
    }
}