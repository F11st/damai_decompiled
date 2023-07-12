package com.youku.arch.v3.core;

import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import io.flutter.wpkbridge.WPKFactory;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;
import tb.b41;
import tb.k50;

/* compiled from: Taobao */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\b\n\u0002\b\u000f\n\u0002\u0010\u000b\n\u0002\b\b\u0018\u0000*\u0004\b\u0000\u0010\u00012\u00020\u0002B5\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\b\b\u0002\u0010\t\u001a\u00020\b\u0012\u0006\u0010\u000f\u001a\u00028\u0000\u0012\b\b\u0002\u0010\u0015\u001a\u00020\b\u0012\b\b\u0002\u0010\u0019\u001a\u00020\u0018¢\u0006\u0004\b\u001e\u0010\u001fR\u0019\u0010\u0004\u001a\u00020\u00038\u0006@\u0006¢\u0006\f\n\u0004\b\u0004\u0010\u0005\u001a\u0004\b\u0006\u0010\u0007R\"\u0010\t\u001a\u00020\b8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\t\u0010\n\u001a\u0004\b\u000b\u0010\f\"\u0004\b\r\u0010\u000eR\"\u0010\u000f\u001a\u00028\u00008\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u000f\u0010\u0010\u001a\u0004\b\u0011\u0010\u0012\"\u0004\b\u0013\u0010\u0014R\"\u0010\u0015\u001a\u00020\b8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u0015\u0010\n\u001a\u0004\b\u0016\u0010\f\"\u0004\b\u0017\u0010\u000eR\"\u0010\u0019\u001a\u00020\u00188\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u0019\u0010\u001a\u001a\u0004\b\u0019\u0010\u001b\"\u0004\b\u001c\u0010\u001d¨\u0006 "}, d2 = {"Lcom/youku/arch/v3/core/Config;", "T", "", "Lcom/youku/arch/v3/core/IContext;", WPKFactory.INIT_KEY_CONTEXT, "Lcom/youku/arch/v3/core/IContext;", "getContext", "()Lcom/youku/arch/v3/core/IContext;", "", "type", "I", "getType", "()I", "setType", "(I)V", "data", "Ljava/lang/Object;", "getData", "()Ljava/lang/Object;", "setData", "(Ljava/lang/Object;)V", "index", "getIndex", "setIndex", "", "isMerge", "Z", "()Z", "setMerge", "(Z)V", "<init>", "(Lcom/youku/arch/v3/core/IContext;ILjava/lang/Object;IZ)V", "konearch_release"}, k = 1, mv = {1, 5, 1})
/* loaded from: classes2.dex */
public final class Config<T> {
    private static transient /* synthetic */ IpChange $ipChange;
    @NotNull
    private final IContext context;
    private T data;
    private int index;
    private boolean isMerge;
    private int type;

    public Config(@NotNull IContext iContext, int i, T t, int i2, boolean z) {
        b41.i(iContext, WPKFactory.INIT_KEY_CONTEXT);
        this.context = iContext;
        this.type = i;
        this.data = t;
        this.index = i2;
        this.isMerge = z;
    }

    @NotNull
    public final IContext getContext() {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "59806001") ? (IContext) ipChange.ipc$dispatch("59806001", new Object[]{this}) : this.context;
    }

    public final T getData() {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "238866698") ? (T) ipChange.ipc$dispatch("238866698", new Object[]{this}) : this.data;
    }

    public final int getIndex() {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "-527796903") ? ((Integer) ipChange.ipc$dispatch("-527796903", new Object[]{this})).intValue() : this.index;
    }

    public final int getType() {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "-1843629685") ? ((Integer) ipChange.ipc$dispatch("-1843629685", new Object[]{this})).intValue() : this.type;
    }

    public final boolean isMerge() {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "972603230") ? ((Boolean) ipChange.ipc$dispatch("972603230", new Object[]{this})).booleanValue() : this.isMerge;
    }

    public final void setData(T t) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1073624712")) {
            ipChange.ipc$dispatch("-1073624712", new Object[]{this, t});
        } else {
            this.data = t;
        }
    }

    public final void setIndex(int i) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1927779631")) {
            ipChange.ipc$dispatch("-1927779631", new Object[]{this, Integer.valueOf(i)});
        } else {
            this.index = i;
        }
    }

    public final void setMerge(boolean z) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "506790664")) {
            ipChange.ipc$dispatch("506790664", new Object[]{this, Boolean.valueOf(z)});
        } else {
            this.isMerge = z;
        }
    }

    public final void setType(int i) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1406495369")) {
            ipChange.ipc$dispatch("-1406495369", new Object[]{this, Integer.valueOf(i)});
        } else {
            this.type = i;
        }
    }

    public /* synthetic */ Config(IContext iContext, int i, Object obj, int i2, boolean z, int i3, k50 k50Var) {
        this(iContext, (i3 & 2) != 0 ? -1 : i, obj, (i3 & 8) != 0 ? 0 : i2, (i3 & 16) != 0 ? false : z);
    }
}
