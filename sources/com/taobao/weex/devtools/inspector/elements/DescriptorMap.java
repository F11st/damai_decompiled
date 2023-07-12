package com.taobao.weex.devtools.inspector.elements;

import com.taobao.weex.devtools.common.Util;
import com.taobao.weex.devtools.inspector.elements.Descriptor;
import java.util.IdentityHashMap;
import java.util.Map;
import javax.annotation.Nullable;

/* compiled from: Taobao */
/* loaded from: classes11.dex */
public final class DescriptorMap {
    private Descriptor.Host mHost;
    private boolean mIsInitializing;
    private final Map<Class<?>, Descriptor> mMap = new IdentityHashMap();

    @Nullable
    private Descriptor getImpl(Class<?> cls) {
        while (cls != null) {
            Descriptor descriptor = this.mMap.get(cls);
            if (descriptor != null) {
                return descriptor;
            }
            cls = cls.getSuperclass();
        }
        return null;
    }

    public DescriptorMap beginInit() {
        Util.throwIf(this.mIsInitializing);
        this.mIsInitializing = true;
        return this;
    }

    public DescriptorMap endInit() {
        Util.throwIfNot(this.mIsInitializing);
        Util.throwIfNull(this.mHost);
        this.mIsInitializing = false;
        for (Class<?> cls : this.mMap.keySet()) {
            Descriptor descriptor = this.mMap.get(cls);
            if (descriptor instanceof ChainedDescriptor) {
                ((ChainedDescriptor) descriptor).setSuper(getImpl(cls.getSuperclass()));
            }
            descriptor.initialize(this.mHost);
        }
        return this;
    }

    @Nullable
    public Descriptor get(Class<?> cls) {
        Util.throwIfNull(cls);
        Util.throwIf(this.mIsInitializing);
        return getImpl(cls);
    }

    public DescriptorMap register(Class<?> cls, Descriptor descriptor) {
        Util.throwIfNull(cls);
        Util.throwIfNull(descriptor);
        Util.throwIf(descriptor.isInitialized());
        Util.throwIfNot(this.mIsInitializing);
        if (!this.mMap.containsKey(cls)) {
            if (!this.mMap.containsValue(descriptor)) {
                this.mMap.put(cls, descriptor);
                return this;
            }
            throw new UnsupportedOperationException();
        }
        throw new UnsupportedOperationException();
    }

    public DescriptorMap setHost(Descriptor.Host host) {
        Util.throwIfNull(host);
        Util.throwIfNot(this.mIsInitializing);
        Util.throwIfNotNull(this.mHost);
        this.mHost = host;
        return this;
    }
}
