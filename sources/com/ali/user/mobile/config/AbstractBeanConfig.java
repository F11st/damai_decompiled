package com.ali.user.mobile.config;

import com.ali.user.mobile.service.ServiceConstants;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/* compiled from: Taobao */
/* loaded from: classes17.dex */
public class AbstractBeanConfig {
    protected Map<String, String> beanMap = new ConcurrentHashMap();

    public String getBeanClassName(String str) {
        if (this.beanMap.isEmpty()) {
            init();
        }
        return this.beanMap.get(str);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void init() {
        this.beanMap.put(ServiceConstants.ServiceInterface.STORAGE_SERVICE, ServiceConstants.ServiceInstance.STORAGE_SERVICE_INSTANCE);
    }
}
