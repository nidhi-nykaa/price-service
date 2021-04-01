package com.nykaa.marketplace.cache;

import com.google.gson.Gson;
import com.nykaa.cs.dto.PropertyDTO;
import com.nykaa.cs.service.PropertyService;
import com.nykaa.marketplace.constants.PriceConstants;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.slf4j.MDC;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.Cache;
import org.springframework.cache.CacheManager;
import org.springframework.util.CollectionUtils;
import org.springframework.util.StringUtils;

import java.util.List;

public class AppConfigCache {
    private static PropertyService staticPropertyService;
    private static CacheManager staticCacheManager;

    private static final Logger LOG = LoggerFactory.getLogger(AppConfigCache.class);

    public static void populateDataInCacheManager() {
        clearSystemPropertyCache();
        setValueForNewConfig();
    }

    private static Boolean clearSystemPropertyCache() {
        Cache cache = staticCacheManager.getCache(PriceConstants.CacheNames.SystemPropertyConfigCache);
        if (cache != null) {
            cache.clear();
        }
        return true;
    }

    private static void setDataInCacheManager(String key, String value) {
        if (!StringUtils.isEmpty(value)) {
            Cache cache = staticCacheManager.getCache(PriceConstants.CacheNames.SystemPropertyConfigCache);
            if (cache != null) {
                cache.put(key, value);
            }
        }
    }

    private static void setValueForNewConfig() {
        List<PropertyDTO> propertyDTOList = staticPropertyService.getAllSystemProperties();
        if (!CollectionUtils.isEmpty(propertyDTOList)) {
            propertyDTOList.forEach(propertyDTO -> {
                setDataInCacheManager(propertyDTO.getName(), propertyDTO.getValue());
            });
        }
    }

    public static <T> T getSystemConfigOnKey(String key, Class<T> classOfT) {
        String value = getValueFromNewConfig(key);
        if (!StringUtils.isEmpty(value)) {
            return classConverterFromConfigValue(value, classOfT);
        }
        return null;
    }

    private static <T> T getValueFromNewConfig(String name) {
        try {
            String val = staticCacheManager.getCache(PriceConstants.CacheNames.SystemPropertyConfigCache).get(name, String.class);
            if (StringUtils.isEmpty(val)) {
                val = staticPropertyService.getSystemPropertyValue(name);
                setDataInCacheManager(name, val);
            }
            return (T) val;
        } catch (Exception ex) {
            LOG.error("something went wrong while fetching value of customVariable from new config" + ex.getMessage());
            return null;
        }
    }

    private static <T> T classConverterFromConfigValue(String value, Class<T> classOfT) {
        Gson gson = new Gson();
        return gson.fromJson(value, classOfT);
    }
}
