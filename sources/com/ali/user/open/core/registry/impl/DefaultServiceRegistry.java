package com.ali.user.open.core.registry.impl;

import com.ali.user.open.core.registry.ServiceRegistration;
import com.ali.user.open.core.registry.ServiceRegistry;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.UUID;
import java.util.concurrent.locks.ReadWriteLock;
import java.util.concurrent.locks.ReentrantReadWriteLock;

/* compiled from: Taobao */
/* loaded from: classes9.dex */
public class DefaultServiceRegistry implements ServiceRegistry {
    private Map<Class<?>, List<ServiceEntry>> typeServiceEntries = new HashMap();
    private Map<ServiceRegistration, ServiceEntry> registrationServiceEntries = new HashMap();
    private ReadWriteLock lock = new ReentrantReadWriteLock();

    /* compiled from: Taobao */
    /* loaded from: classes9.dex */
    static class InternalServiceRegistration implements ServiceRegistration {
        private Map<String, String> properties;
        private ServiceRegistry serviceRegistry;
        private final String uuid = UUID.randomUUID().toString();

        public InternalServiceRegistration(ServiceRegistry serviceRegistry, Map<String, String> map) {
            this.serviceRegistry = serviceRegistry;
            this.properties = map;
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (obj != null && getClass() == obj.getClass()) {
                return this.uuid.equals(((InternalServiceRegistration) obj).uuid);
            }
            return false;
        }

        public int hashCode() {
            String str = this.uuid;
            return 31 + (str == null ? 0 : str.hashCode());
        }

        @Override // com.ali.user.open.core.registry.ServiceRegistration
        public void setProperties(Map<String, String> map) {
            if (map == null) {
                return;
            }
            for (Map.Entry<String, String> entry : map.entrySet()) {
                if (entry.getKey() != null && entry.getValue() != null) {
                    this.properties.put(entry.getKey(), entry.getValue());
                }
            }
        }

        @Override // com.ali.user.open.core.registry.ServiceRegistration
        public void unregister() {
            this.serviceRegistry.unregisterService(this);
        }
    }

    /* compiled from: Taobao */
    /* loaded from: classes9.dex */
    static class ServiceEntry {
        public Object instance;
        public Map<String, String> properties;
        public Class<?>[] types;

        ServiceEntry() {
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:19:0x0044 A[Catch: all -> 0x008c, TryCatch #0 {all -> 0x008c, blocks: (B:3:0x0009, B:5:0x0014, B:10:0x001e, B:13:0x0025, B:14:0x0029, B:16:0x002f, B:17:0x003e, B:19:0x0044, B:21:0x0058, B:25:0x0065, B:30:0x007f), top: B:35:0x0009 }] */
    @Override // com.ali.user.open.core.registry.ServiceRegistry
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public <T> T getService(java.lang.Class<T> r10, java.util.Map<java.lang.String, java.lang.String> r11) {
        /*
            r9 = this;
            java.util.concurrent.locks.ReadWriteLock r0 = r9.lock
            java.util.concurrent.locks.Lock r0 = r0.readLock()
            r0.lock()
            java.util.Map<java.lang.Class<?>, java.util.List<com.ali.user.open.core.registry.impl.DefaultServiceRegistry$ServiceEntry>> r0 = r9.typeServiceEntries     // Catch: java.lang.Throwable -> L8c
            java.lang.Object r0 = r0.get(r10)     // Catch: java.lang.Throwable -> L8c
            java.util.List r0 = (java.util.List) r0     // Catch: java.lang.Throwable -> L8c
            r1 = 0
            if (r0 == 0) goto L75
            int r2 = r0.size()     // Catch: java.lang.Throwable -> L8c
            if (r2 != 0) goto L1b
            goto L75
        L1b:
            r2 = 0
            if (r11 == 0) goto L7f
            int r3 = r11.size()     // Catch: java.lang.Throwable -> L8c
            if (r3 != 0) goto L25
            goto L7f
        L25:
            java.util.Iterator r0 = r0.iterator()     // Catch: java.lang.Throwable -> L8c
        L29:
            boolean r3 = r0.hasNext()     // Catch: java.lang.Throwable -> L8c
            if (r3 == 0) goto L75
            java.lang.Object r3 = r0.next()     // Catch: java.lang.Throwable -> L8c
            com.ali.user.open.core.registry.impl.DefaultServiceRegistry$ServiceEntry r3 = (com.ali.user.open.core.registry.impl.DefaultServiceRegistry.ServiceEntry) r3     // Catch: java.lang.Throwable -> L8c
            r4 = 1
            java.util.Set r5 = r11.entrySet()     // Catch: java.lang.Throwable -> L8c
            java.util.Iterator r5 = r5.iterator()     // Catch: java.lang.Throwable -> L8c
        L3e:
            boolean r6 = r5.hasNext()     // Catch: java.lang.Throwable -> L8c
            if (r6 == 0) goto L63
            java.lang.Object r6 = r5.next()     // Catch: java.lang.Throwable -> L8c
            java.util.Map$Entry r6 = (java.util.Map.Entry) r6     // Catch: java.lang.Throwable -> L8c
            java.util.Map<java.lang.String, java.lang.String> r7 = r3.properties     // Catch: java.lang.Throwable -> L8c
            java.lang.Object r8 = r6.getKey()     // Catch: java.lang.Throwable -> L8c
            java.lang.Object r7 = r7.get(r8)     // Catch: java.lang.Throwable -> L8c
            java.lang.String r7 = (java.lang.String) r7     // Catch: java.lang.Throwable -> L8c
            if (r7 == 0) goto L62
            java.lang.Object r6 = r6.getValue()     // Catch: java.lang.Throwable -> L8c
            boolean r6 = r7.equals(r6)     // Catch: java.lang.Throwable -> L8c
            if (r6 != 0) goto L3e
        L62:
            r4 = 0
        L63:
            if (r4 == 0) goto L29
            java.lang.Object r11 = r3.instance     // Catch: java.lang.Throwable -> L8c
            java.lang.Object r10 = r10.cast(r11)     // Catch: java.lang.Throwable -> L8c
        L6b:
            java.util.concurrent.locks.ReadWriteLock r11 = r9.lock
            java.util.concurrent.locks.Lock r11 = r11.readLock()
            r11.unlock()
            return r10
        L75:
            java.util.concurrent.locks.ReadWriteLock r10 = r9.lock
            java.util.concurrent.locks.Lock r10 = r10.readLock()
            r10.unlock()
            return r1
        L7f:
            java.lang.Object r11 = r0.get(r2)     // Catch: java.lang.Throwable -> L8c
            com.ali.user.open.core.registry.impl.DefaultServiceRegistry$ServiceEntry r11 = (com.ali.user.open.core.registry.impl.DefaultServiceRegistry.ServiceEntry) r11     // Catch: java.lang.Throwable -> L8c
            java.lang.Object r11 = r11.instance     // Catch: java.lang.Throwable -> L8c
            java.lang.Object r10 = r10.cast(r11)     // Catch: java.lang.Throwable -> L8c
            goto L6b
        L8c:
            r10 = move-exception
            java.util.concurrent.locks.ReadWriteLock r11 = r9.lock
            java.util.concurrent.locks.Lock r11 = r11.readLock()
            r11.unlock()
            throw r10
        */
        throw new UnsupportedOperationException("Method not decompiled: com.ali.user.open.core.registry.impl.DefaultServiceRegistry.getService(java.lang.Class, java.util.Map):java.lang.Object");
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:18:0x004c A[Catch: all -> 0x00c3, TryCatch #0 {all -> 0x00c3, blocks: (B:3:0x0009, B:5:0x0014, B:9:0x001e, B:12:0x0025, B:13:0x0032, B:15:0x0038, B:16:0x0046, B:18:0x004c, B:20:0x0060, B:25:0x006f, B:26:0x0079, B:29:0x0091, B:31:0x00a1, B:35:0x00bc), top: B:40:0x0009 }] */
    @Override // com.ali.user.open.core.registry.ServiceRegistry
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public <T> T[] getServices(java.lang.Class<T> r9, java.util.Map<java.lang.String, java.lang.String> r10) {
        /*
            r8 = this;
            java.util.concurrent.locks.ReadWriteLock r0 = r8.lock
            java.util.concurrent.locks.Lock r0 = r0.readLock()
            r0.lock()
            java.util.Map<java.lang.Class<?>, java.util.List<com.ali.user.open.core.registry.impl.DefaultServiceRegistry$ServiceEntry>> r0 = r8.typeServiceEntries     // Catch: java.lang.Throwable -> Lc3
            java.lang.Object r0 = r0.get(r9)     // Catch: java.lang.Throwable -> Lc3
            java.util.List r0 = (java.util.List) r0     // Catch: java.lang.Throwable -> Lc3
            r1 = 0
            if (r0 == 0) goto Lbc
            int r2 = r0.size()     // Catch: java.lang.Throwable -> Lc3
            if (r2 != 0) goto L1c
            goto Lbc
        L1c:
            if (r10 == 0) goto L91
            int r2 = r10.size()     // Catch: java.lang.Throwable -> Lc3
            if (r2 != 0) goto L25
            goto L91
        L25:
            java.util.ArrayList r2 = new java.util.ArrayList     // Catch: java.lang.Throwable -> Lc3
            int r3 = r0.size()     // Catch: java.lang.Throwable -> Lc3
            r2.<init>(r3)     // Catch: java.lang.Throwable -> Lc3
            java.util.Iterator r0 = r0.iterator()     // Catch: java.lang.Throwable -> Lc3
        L32:
            boolean r3 = r0.hasNext()     // Catch: java.lang.Throwable -> Lc3
            if (r3 == 0) goto L79
            java.lang.Object r3 = r0.next()     // Catch: java.lang.Throwable -> Lc3
            com.ali.user.open.core.registry.impl.DefaultServiceRegistry$ServiceEntry r3 = (com.ali.user.open.core.registry.impl.DefaultServiceRegistry.ServiceEntry) r3     // Catch: java.lang.Throwable -> Lc3
            java.util.Set r4 = r10.entrySet()     // Catch: java.lang.Throwable -> Lc3
            java.util.Iterator r4 = r4.iterator()     // Catch: java.lang.Throwable -> Lc3
        L46:
            boolean r5 = r4.hasNext()     // Catch: java.lang.Throwable -> Lc3
            if (r5 == 0) goto L6c
            java.lang.Object r5 = r4.next()     // Catch: java.lang.Throwable -> Lc3
            java.util.Map$Entry r5 = (java.util.Map.Entry) r5     // Catch: java.lang.Throwable -> Lc3
            java.util.Map<java.lang.String, java.lang.String> r6 = r3.properties     // Catch: java.lang.Throwable -> Lc3
            java.lang.Object r7 = r5.getKey()     // Catch: java.lang.Throwable -> Lc3
            java.lang.Object r6 = r6.get(r7)     // Catch: java.lang.Throwable -> Lc3
            java.lang.String r6 = (java.lang.String) r6     // Catch: java.lang.Throwable -> Lc3
            if (r6 == 0) goto L6a
            java.lang.Object r5 = r5.getValue()     // Catch: java.lang.Throwable -> Lc3
            boolean r5 = r6.equals(r5)     // Catch: java.lang.Throwable -> Lc3
            if (r5 != 0) goto L46
        L6a:
            r4 = 0
            goto L6d
        L6c:
            r4 = 1
        L6d:
            if (r4 == 0) goto L32
            java.lang.Object r3 = r3.instance     // Catch: java.lang.Throwable -> Lc3
            java.lang.Object r3 = r9.cast(r3)     // Catch: java.lang.Throwable -> Lc3
            r2.add(r3)     // Catch: java.lang.Throwable -> Lc3
            goto L32
        L79:
            int r10 = r2.size()     // Catch: java.lang.Throwable -> Lc3
            java.lang.Object r9 = java.lang.reflect.Array.newInstance(r9, r10)     // Catch: java.lang.Throwable -> Lc3
            java.lang.Object[] r9 = (java.lang.Object[]) r9     // Catch: java.lang.Throwable -> Lc3
            java.lang.Object[] r9 = r2.toArray(r9)     // Catch: java.lang.Throwable -> Lc3
        L87:
            java.util.concurrent.locks.ReadWriteLock r10 = r8.lock
            java.util.concurrent.locks.Lock r10 = r10.readLock()
            r10.unlock()
            return r9
        L91:
            int r10 = r0.size()     // Catch: java.lang.Throwable -> Lc3
            java.lang.Object r10 = java.lang.reflect.Array.newInstance(r9, r10)     // Catch: java.lang.Throwable -> Lc3
            java.lang.Object[] r10 = (java.lang.Object[]) r10     // Catch: java.lang.Throwable -> Lc3
            int r2 = r0.size()     // Catch: java.lang.Throwable -> Lc3
        L9f:
            if (r1 >= r2) goto Lb2
            java.lang.Object r3 = r0.get(r1)     // Catch: java.lang.Throwable -> Lc3
            com.ali.user.open.core.registry.impl.DefaultServiceRegistry$ServiceEntry r3 = (com.ali.user.open.core.registry.impl.DefaultServiceRegistry.ServiceEntry) r3     // Catch: java.lang.Throwable -> Lc3
            java.lang.Object r3 = r3.instance     // Catch: java.lang.Throwable -> Lc3
            java.lang.Object r3 = r9.cast(r3)     // Catch: java.lang.Throwable -> Lc3
            r10[r1] = r3     // Catch: java.lang.Throwable -> Lc3
            int r1 = r1 + 1
            goto L9f
        Lb2:
            java.util.concurrent.locks.ReadWriteLock r9 = r8.lock
            java.util.concurrent.locks.Lock r9 = r9.readLock()
            r9.unlock()
            return r10
        Lbc:
            java.lang.Object r9 = java.lang.reflect.Array.newInstance(r9, r1)     // Catch: java.lang.Throwable -> Lc3
            java.lang.Object[] r9 = (java.lang.Object[]) r9     // Catch: java.lang.Throwable -> Lc3
            goto L87
        Lc3:
            r9 = move-exception
            java.util.concurrent.locks.ReadWriteLock r10 = r8.lock
            java.util.concurrent.locks.Lock r10 = r10.readLock()
            r10.unlock()
            throw r9
        */
        throw new UnsupportedOperationException("Method not decompiled: com.ali.user.open.core.registry.impl.DefaultServiceRegistry.getServices(java.lang.Class, java.util.Map):java.lang.Object[]");
    }

    @Override // com.ali.user.open.core.registry.ServiceRegistry
    public ServiceRegistration registerService(Class<?>[] clsArr, Object obj, Map<String, String> map) {
        if (clsArr != null && clsArr.length != 0 && obj != null) {
            ServiceEntry serviceEntry = new ServiceEntry();
            serviceEntry.instance = obj;
            serviceEntry.types = clsArr;
            serviceEntry.properties = Collections.synchronizedMap(new HashMap());
            if (map != null) {
                for (Map.Entry<String, String> entry : map.entrySet()) {
                    if (entry.getKey() != null && entry.getValue() != null) {
                        serviceEntry.properties.put(entry.getKey(), entry.getValue());
                    }
                }
            }
            this.lock.writeLock().lock();
            try {
                for (Class<?> cls : clsArr) {
                    List<ServiceEntry> list = this.typeServiceEntries.get(cls);
                    if (list == null) {
                        list = new ArrayList<>(2);
                        this.typeServiceEntries.put(cls, list);
                    }
                    list.add(serviceEntry);
                }
                InternalServiceRegistration internalServiceRegistration = new InternalServiceRegistration(this, serviceEntry.properties);
                this.registrationServiceEntries.put(internalServiceRegistration, serviceEntry);
                return internalServiceRegistration;
            } finally {
                this.lock.writeLock().unlock();
            }
        }
        throw new IllegalArgumentException("service types and instance must not be null");
    }

    @Override // com.ali.user.open.core.registry.ServiceRegistry
    public Object unregisterService(ServiceRegistration serviceRegistration) {
        if (serviceRegistration == null) {
            return null;
        }
        this.lock.writeLock().lock();
        try {
            ServiceEntry remove = this.registrationServiceEntries.remove(serviceRegistration);
            if (remove == null) {
                return null;
            }
            Class<?>[] clsArr = remove.types;
            if (clsArr != null) {
                for (Class<?> cls : clsArr) {
                    List<ServiceEntry> list = this.typeServiceEntries.get(cls);
                    Iterator<ServiceEntry> it = list.iterator();
                    while (true) {
                        if (it.hasNext()) {
                            if (it.next() == remove) {
                                it.remove();
                                break;
                            }
                        } else {
                            break;
                        }
                    }
                    if (list.size() == 0) {
                        this.typeServiceEntries.remove(cls);
                    }
                }
            }
            return remove.instance;
        } finally {
            this.lock.writeLock().unlock();
        }
    }
}
