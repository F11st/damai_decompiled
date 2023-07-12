package com.taobao.application.common.impl;

import com.taobao.application.common.IAppLaunchListener;
import java.util.ArrayList;
import java.util.List;

/* compiled from: Taobao */
/* loaded from: classes11.dex */
class AppLaunchListenerGroup implements IAppLaunchListener, IListenerGroup<IAppLaunchListener> {
    private final List<IAppLaunchListener> a = new ArrayList(2);

    private void c(Runnable runnable) {
        a.g().h(runnable);
    }

    @Override // com.taobao.application.common.impl.IListenerGroup
    /* renamed from: b */
    public void addListener(final IAppLaunchListener iAppLaunchListener) {
        if (iAppLaunchListener != null) {
            c(new Runnable() { // from class: com.taobao.application.common.impl.AppLaunchListenerGroup.1
                @Override // java.lang.Runnable
                public void run() {
                    if (AppLaunchListenerGroup.this.a.contains(iAppLaunchListener)) {
                        return;
                    }
                    AppLaunchListenerGroup.this.a.add(iAppLaunchListener);
                }
            });
            return;
        }
        throw new IllegalArgumentException();
    }

    @Override // com.taobao.application.common.impl.IListenerGroup
    /* renamed from: d */
    public void removeListener(final IAppLaunchListener iAppLaunchListener) {
        if (iAppLaunchListener != null) {
            c(new Runnable() { // from class: com.taobao.application.common.impl.AppLaunchListenerGroup.2
                @Override // java.lang.Runnable
                public void run() {
                    AppLaunchListenerGroup.this.a.remove(iAppLaunchListener);
                }
            });
            return;
        }
        throw new IllegalArgumentException();
    }

    @Override // com.taobao.application.common.IAppLaunchListener
    public void onLaunchChanged(final int i, final int i2) {
        c(new Runnable() { // from class: com.taobao.application.common.impl.AppLaunchListenerGroup.3
            @Override // java.lang.Runnable
            public void run() {
                for (IAppLaunchListener iAppLaunchListener : AppLaunchListenerGroup.this.a) {
                    iAppLaunchListener.onLaunchChanged(i, i2);
                }
            }
        });
    }
}
