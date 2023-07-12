package com.youku.arch.v3;

import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import com.youku.arch.v3.util.LogUtil;
import com.youku.middlewareservice.provider.info.AppInfoProviderProxy;
import java.util.concurrent.atomic.AtomicInteger;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;
import tb.b41;
import tb.k50;

/* compiled from: Taobao */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\n\u0018\u0000 \u00102\u00020\u0001:\u0001\u0010B\u0007¢\u0006\u0004\b\u000e\u0010\u000fJ\u0006\u0010\u0003\u001a\u00020\u0002J\u0006\u0010\u0005\u001a\u00020\u0004J\u0006\u0010\u0006\u001a\u00020\u0004R\"\u0010\b\u001a\u00020\u00078\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\b\u0010\t\u001a\u0004\b\n\u0010\u000b\"\u0004\b\f\u0010\r¨\u0006\u0011"}, d2 = {"Lcom/youku/arch/v3/ChildState;", "", "", "hasChanged", "Ltb/wt2;", "clearChanged", "setChanged", "Ljava/util/concurrent/atomic/AtomicInteger;", "changeCount", "Ljava/util/concurrent/atomic/AtomicInteger;", "getChangeCount", "()Ljava/util/concurrent/atomic/AtomicInteger;", "setChangeCount", "(Ljava/util/concurrent/atomic/AtomicInteger;)V", "<init>", "()V", "Companion", "konearch_release"}, k = 1, mv = {1, 5, 1})
/* loaded from: classes2.dex */
public final class ChildState {
    private static transient /* synthetic */ IpChange $ipChange = null;
    @NotNull
    public static final Companion Companion = new Companion(null);
    @NotNull
    public static final String TAG = "OneArch.ChildState";
    @NotNull
    private AtomicInteger changeCount = new AtomicInteger(0);

    /* compiled from: Taobao */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0005\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0005\u0010\u0006R\u0016\u0010\u0003\u001a\u00020\u00028\u0006@\u0006X\u0086T¢\u0006\u0006\n\u0004\b\u0003\u0010\u0004¨\u0006\u0007"}, d2 = {"Lcom/youku/arch/v3/ChildState$Companion;", "", "", "TAG", "Ljava/lang/String;", "<init>", "()V", "konearch_release"}, k = 1, mv = {1, 5, 1})
    /* loaded from: classes2.dex */
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(k50 k50Var) {
            this();
        }
    }

    public final void clearChanged() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1371799248")) {
            ipChange.ipc$dispatch("-1371799248", new Object[]{this});
            return;
        }
        this.changeCount.decrementAndGet();
        if (AppInfoProviderProxy.isDebuggable()) {
            LogUtil.v(TAG, b41.r("clearChanged ", Integer.valueOf(this.changeCount.get())));
        }
    }

    @NotNull
    public final AtomicInteger getChangeCount() {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "1178998904") ? (AtomicInteger) ipChange.ipc$dispatch("1178998904", new Object[]{this}) : this.changeCount;
    }

    public final boolean hasChanged() {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "543910337") ? ((Boolean) ipChange.ipc$dispatch("543910337", new Object[]{this})).booleanValue() : this.changeCount.get() > 0;
    }

    public final void setChangeCount(@NotNull AtomicInteger atomicInteger) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "852223264")) {
            ipChange.ipc$dispatch("852223264", new Object[]{this, atomicInteger});
            return;
        }
        b41.i(atomicInteger, "<set-?>");
        this.changeCount = atomicInteger;
    }

    public final void setChanged() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "330824069")) {
            ipChange.ipc$dispatch("330824069", new Object[]{this});
            return;
        }
        this.changeCount.incrementAndGet();
        if (AppInfoProviderProxy.isDebuggable()) {
            LogUtil.v(TAG, b41.r("setChanged ", Integer.valueOf(this.changeCount.get())));
        }
    }
}
