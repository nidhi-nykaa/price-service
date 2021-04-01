package com.nykaa.marketplace.service;

import com.nykaa.marketplace.cache.AppConfigCache;
import com.nykaa.marketplace.constants.PriceConstants;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.context.annotation.ClassPathScanningCandidateComponentProvider;
import org.springframework.core.type.filter.AnnotationTypeFilter;
import org.springframework.stereotype.Service;

import java.util.*;
import java.util.stream.Collectors;

@Service("startUpService")
public class StartupService {
    private static final Logger LOG = LoggerFactory.getLogger(StartupService.class);

    public void load() {
        LOG.info("loading template cache....");
      //  loadTemplates();
        loadAppCache();
    }
    public void loadAppCache() {
        AppConfigCache.populateDataInCacheManager();
    }

   /* public void loadTemplates() {
     LOG.info("loading templates");
        ClassPathScanningCandidateComponentProvider provider = new ClassPathScanningCandidateComponentProvider(false);
        provider.addIncludeFilter(new AnnotationTypeFilter(HeadersCache.class));
        Map<String, List<String>> templateHeadersMap = new HashMap<>();
        try {
            for (BeanDefinition beanDef : provider.findCandidateComponents(PriceConstants.TEMPLATES_BASE_PACKAGE)) {
                Class<?> templatesClass = Class.forName(beanDef.getBeanClassName());
                LOG.info("templatesClass is {}",templatesClass);
                Class templateClass = Class.forName(templatesClass.getName());
                EnumSet templatesEnumSet = EnumSet.allOf(templateClass);
                List<Object> templateEnumList = new ArrayList<>(templatesEnumSet.size());
                for (Object template : templatesEnumSet) {
                    templateEnumList.add(template);
                }
                List<String> templateList = templateEnumList.stream().map(Object -> Objects.toString(Object.toString(), null)).collect(Collectors.toList());
                LOG.info("templateList is {}",templateList);
                templateHeadersMap.put(templatesClass.getSimpleName(), templateList);
            }
            TemplateMappingCache.getConfig().setTemplateMap(templateHeadersMap);
        }catch (ClassNotFoundException e) {
            LOG.error("Exception occured while loading tempalte ", e);
        }
    }*/
}
