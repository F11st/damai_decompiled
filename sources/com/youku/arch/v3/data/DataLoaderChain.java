package com.youku.arch.v3.data;

import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import com.youku.arch.v3.data.RequestContext;
import java.util.List;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;
import tb.b41;

/* compiled from: Taobao */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\f\b\u0000\u0018\u0000*\b\b\u0000\u0010\u0002*\u00020\u00012\b\u0012\u0004\u0012\u00028\u00000\u0003B%\b\u0016\u0012\u0012\u0010\b\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00000\u00070\u0006\u0012\u0006\u0010\u000b\u001a\u00020\n¢\u0006\u0004\b\u0013\u0010\u0014B-\b\u0016\u0012\u0012\u0010\b\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00000\u00070\u0006\u0012\u0006\u0010\u000b\u001a\u00020\n\u0012\u0006\u0010\r\u001a\u00028\u0000¢\u0006\u0004\b\u0013\u0010\u0015J\b\u0010\u0005\u001a\u00020\u0004H\u0016R\"\u0010\b\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00000\u00070\u00068\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\b\u0010\tR\u0016\u0010\u000b\u001a\u00020\n8\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u000b\u0010\fR\"\u0010\r\u001a\u00028\u00008\u0016@\u0016X\u0096.¢\u0006\u0012\n\u0004\b\r\u0010\u000e\u001a\u0004\b\u000f\u0010\u0010\"\u0004\b\u0011\u0010\u0012¨\u0006\u0016"}, d2 = {"Lcom/youku/arch/v3/data/DataLoaderChain;", "Lcom/youku/arch/v3/data/RequestContext;", "T", "Lcom/youku/arch/v3/data/Chain;", "Ltb/wt2;", "proceed", "", "Lcom/youku/arch/v3/data/DataLoader;", "interceptors", "Ljava/util/List;", "", "index", "I", "param", "Lcom/youku/arch/v3/data/RequestContext;", "getParam", "()Lcom/youku/arch/v3/data/RequestContext;", "setParam", "(Lcom/youku/arch/v3/data/RequestContext;)V", "<init>", "(Ljava/util/List;I)V", "(Ljava/util/List;ILcom/youku/arch/v3/data/RequestContext;)V", "konearch_release"}, k = 1, mv = {1, 5, 1})
/* loaded from: classes2.dex */
public final class DataLoaderChain<T extends RequestContext> implements Chain<T> {
    private static transient /* synthetic */ IpChange $ipChange;
    private final int index;
    @NotNull
    private final List<DataLoader<T>> interceptors;
    public T param;

    /* JADX WARN: Multi-variable type inference failed */
    public DataLoaderChain(@NotNull List<? extends DataLoader<T>> list, int i) {
        b41.i(list, "interceptors");
        this.interceptors = list;
        this.index = i;
    }

    @Override // com.youku.arch.v3.data.Chain
    public void proceed() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1705829")) {
            ipChange.ipc$dispatch("-1705829", new Object[]{this});
        } else if (this.index < this.interceptors.size()) {
            this.interceptors.get(this.index).process(new DataLoaderChain(this.interceptors, this.index + 1, getParam()));
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.youku.arch.v3.data.Chain
    public /* bridge */ /* synthetic */ void setParam(Object obj) {
        setParam((DataLoaderChain<T>) ((RequestContext) obj));
    }

    @Override // com.youku.arch.v3.data.Chain
    @NotNull
    public T getParam() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-493346269")) {
            return (T) ipChange.ipc$dispatch("-493346269", new Object[]{this});
        }
        T t = this.param;
        if (t != null) {
            return t;
        }
        b41.A("param");
        return null;
    }

    public void setParam(@NotNull T t) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1058432813")) {
            ipChange.ipc$dispatch("-1058432813", new Object[]{this, t});
            return;
        }
        b41.i(t, "<set-?>");
        this.param = t;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public DataLoaderChain(@NotNull List<? extends DataLoader<T>> list, int i, @NotNull T t) {
        b41.i(list, "interceptors");
        b41.i(t, "param");
        this.interceptors = list;
        this.index = i;
        setParam((DataLoaderChain<T>) t);
    }
}
