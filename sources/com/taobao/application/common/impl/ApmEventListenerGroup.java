package com.taobao.application.common.impl;

import com.taobao.application.common.IApmEventListener;
import java.util.ArrayList;
import java.util.Iterator;

/* compiled from: Taobao */
/* loaded from: classes11.dex */
public class ApmEventListenerGroup implements IApmEventListener, IListenerGroup<IApmEventListener> {
    private final ArrayList<IApmEventListener> a = new ArrayList<>();

    private void c(Runnable runnable) {
        C6674a.g().h(runnable);
    }

    @Override // com.taobao.application.common.impl.IListenerGroup
    /* renamed from: b */
    public void addListener(final IApmEventListener iApmEventListener) {
        if (iApmEventListener != null) {
            c(new Runnable() { // from class: com.taobao.application.common.impl.ApmEventListenerGroup.2
                @Override // java.lang.Runnable
                public void run() {
                    if (ApmEventListenerGroup.this.a.contains(iApmEventListener)) {
                        return;
                    }
                    ApmEventListenerGroup.this.a.add(iApmEventListener);
                }
            });
            return;
        }
        throw new IllegalArgumentException();
    }

    @Override // com.taobao.application.common.impl.IListenerGroup
    /* renamed from: d */
    public void removeListener(final IApmEventListener iApmEventListener) {
        if (iApmEventListener != null) {
            c(new Runnable() { // from class: com.taobao.application.common.impl.ApmEventListenerGroup.3
                @Override // java.lang.Runnable
                public void run() {
                    ApmEventListenerGroup.this.a.remove(iApmEventListener);
                }
            });
            return;
        }
        throw new IllegalArgumentException();
    }

    @Override // com.taobao.application.common.IApmEventListener
    public void onEvent(final int i) {
        c(new Runnable() { // from class: com.taobao.application.common.impl.ApmEventListenerGroup.1
            @Override // java.lang.Runnable
            public void run() {
                Iterator it = ApmEventListenerGroup.this.a.iterator();
                while (it.hasNext()) {
                    ((IApmEventListener) it.next()).onEvent(i);
                }
            }
        });
    }
}
