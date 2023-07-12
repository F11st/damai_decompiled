package com.taobao.monitor.impl.trace;

import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;
import tb.de0;
import tb.fu0;
import tb.pb1;

/* compiled from: Taobao */
/* loaded from: classes11.dex */
public class AbsDispatcher<LISTENER> implements IDispatcher<LISTENER> {
    private final Class a = d();
    protected final List<LISTENER> b = new ArrayList();

    /* compiled from: Taobao */
    /* loaded from: classes11.dex */
    protected interface ListenerCaller<LISTENER> {
        void callListener(LISTENER listener);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public AbsDispatcher() {
        pb1.d("AbsDispatcher", getClass().getSimpleName(), " init");
    }

    private void a(Runnable runnable) {
        fu0.e().d().post(runnable);
    }

    private boolean b(LISTENER listener) {
        return e(listener, this.a);
    }

    private Class d() {
        Type[] actualTypeArguments;
        try {
            Type genericSuperclass = getClass().getGenericSuperclass();
            if ((genericSuperclass instanceof ParameterizedType) && (actualTypeArguments = ((ParameterizedType) genericSuperclass).getActualTypeArguments()) != null && actualTypeArguments.length != 0) {
                return (Class) actualTypeArguments[0];
            }
        } catch (Throwable unused) {
        }
        return Object.class;
    }

    private boolean e(LISTENER listener, Class cls) {
        if (cls == null) {
            return false;
        }
        return cls.isInstance(listener);
    }

    @Override // com.taobao.monitor.impl.trace.IDispatcher
    public final void addListener(final LISTENER listener) {
        if ((this instanceof de0) || listener == null || !b(listener)) {
            return;
        }
        a(new Runnable() { // from class: com.taobao.monitor.impl.trace.AbsDispatcher.1
            /* JADX WARN: Multi-variable type inference failed */
            @Override // java.lang.Runnable
            public void run() {
                if (AbsDispatcher.this.b.contains(listener)) {
                    return;
                }
                AbsDispatcher.this.b.add(listener);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final void c(final ListenerCaller<LISTENER> listenerCaller) {
        a(new Runnable() { // from class: com.taobao.monitor.impl.trace.AbsDispatcher.3
            @Override // java.lang.Runnable
            public void run() {
                for (LISTENER listener : AbsDispatcher.this.b) {
                    listenerCaller.callListener(listener);
                }
            }
        });
    }

    @Override // com.taobao.monitor.impl.trace.IDispatcher
    public final void removeListener(final LISTENER listener) {
        if ((this instanceof de0) || listener == null) {
            return;
        }
        a(new Runnable() { // from class: com.taobao.monitor.impl.trace.AbsDispatcher.2
            @Override // java.lang.Runnable
            public void run() {
                AbsDispatcher.this.b.remove(listener);
            }
        });
    }
}
