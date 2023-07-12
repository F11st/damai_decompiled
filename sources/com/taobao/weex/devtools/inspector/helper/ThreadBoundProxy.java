package com.taobao.weex.devtools.inspector.helper;

import com.taobao.weex.devtools.common.ThreadBound;
import com.taobao.weex.devtools.common.UncheckedCallable;
import com.taobao.weex.devtools.common.Util;

/* compiled from: Taobao */
/* loaded from: classes11.dex */
public abstract class ThreadBoundProxy implements ThreadBound {
    private final ThreadBound mEnforcer;

    public ThreadBoundProxy(ThreadBound threadBound) {
        this.mEnforcer = (ThreadBound) Util.throwIfNull(threadBound);
    }

    @Override // com.taobao.weex.devtools.common.ThreadBound
    public final boolean checkThreadAccess() {
        return this.mEnforcer.checkThreadAccess();
    }

    @Override // com.taobao.weex.devtools.common.ThreadBound
    public final <V> V postAndWait(UncheckedCallable<V> uncheckedCallable) {
        return (V) this.mEnforcer.postAndWait(uncheckedCallable);
    }

    @Override // com.taobao.weex.devtools.common.ThreadBound
    public final void postDelayed(Runnable runnable, long j) {
        this.mEnforcer.postDelayed(runnable, j);
    }

    @Override // com.taobao.weex.devtools.common.ThreadBound
    public final void removeCallbacks(Runnable runnable) {
        this.mEnforcer.removeCallbacks(runnable);
    }

    @Override // com.taobao.weex.devtools.common.ThreadBound
    public final void verifyThreadAccess() {
        this.mEnforcer.verifyThreadAccess();
    }

    @Override // com.taobao.weex.devtools.common.ThreadBound
    public final void postAndWait(Runnable runnable) {
        this.mEnforcer.postAndWait(runnable);
    }
}
