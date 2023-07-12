package com.ali.user.open.core.registry.impl;

import com.ali.user.open.core.registry.ServiceRegistration;
import com.ali.user.open.core.registry.ServiceRegistry;
import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;
import java.util.Map;

/* compiled from: Taobao */
/* loaded from: classes9.dex */
public class ProxyEnabledServiceRegistryDelegator implements ServiceRegistry {
    private ServiceRegistry delegator;

    public ProxyEnabledServiceRegistryDelegator(ServiceRegistry serviceRegistry) {
        this.delegator = serviceRegistry;
    }

    @Override // com.ali.user.open.core.registry.ServiceRegistry
    public <T> T getService(final Class<T> cls, final Map<String, String> map) {
        T t = (T) this.delegator.getService(cls, map);
        return (t == null && map != null && cls.isInterface()) ? cls.cast(Proxy.newProxyInstance(getClass().getClassLoader(), new Class[]{cls}, new InvocationHandler() { // from class: com.ali.user.open.core.registry.impl.ProxyEnabledServiceRegistryDelegator.1
            @Override // java.lang.reflect.InvocationHandler
            public Object invoke(Object obj, Method method, Object[] objArr) throws Throwable {
                Object service = ProxyEnabledServiceRegistryDelegator.this.delegator.getService(cls, map);
                if (service == null) {
                    return null;
                }
                return method.invoke(service, objArr);
            }
        })) : t;
    }

    @Override // com.ali.user.open.core.registry.ServiceRegistry
    public <T> T[] getServices(Class<T> cls, Map<String, String> map) {
        return (T[]) this.delegator.getServices(cls, map);
    }

    @Override // com.ali.user.open.core.registry.ServiceRegistry
    public ServiceRegistration registerService(Class<?>[] clsArr, Object obj, Map<String, String> map) {
        return this.delegator.registerService(clsArr, obj, map);
    }

    @Override // com.ali.user.open.core.registry.ServiceRegistry
    public Object unregisterService(ServiceRegistration serviceRegistration) {
        return this.delegator.unregisterService(serviceRegistration);
    }
}
