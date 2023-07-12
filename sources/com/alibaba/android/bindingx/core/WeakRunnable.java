package com.alibaba.android.bindingx.core;

import androidx.annotation.NonNull;
import java.lang.ref.WeakReference;
import tb.bb1;

/* compiled from: Taobao */
/* loaded from: classes5.dex */
public class WeakRunnable implements Runnable {
    private final WeakReference<Runnable> mDelegateRunnable;

    public WeakRunnable(@NonNull Runnable runnable) {
        this.mDelegateRunnable = new WeakReference<>(runnable);
    }

    @Override // java.lang.Runnable
    public void run() {
        Runnable runnable = this.mDelegateRunnable.get();
        if (runnable != null) {
            try {
                runnable.run();
            } catch (Throwable th) {
                bb1.b(th.getMessage());
            }
        }
    }
}
