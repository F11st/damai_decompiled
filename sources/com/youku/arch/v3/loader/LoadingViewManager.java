package com.youku.arch.v3.loader;

import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: Taobao */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\r\n\u0002\u0010!\n\u0002\b\u0005\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0015\u0010\u0016J\b\u0010\u0003\u001a\u00020\u0002H\u0016J\u0012\u0010\u0006\u001a\u00020\u00022\b\u0010\u0005\u001a\u0004\u0018\u00010\u0004H\u0016J\b\u0010\u0007\u001a\u00020\u0002H\u0016J\b\u0010\b\u001a\u00020\u0002H\u0016J\b\u0010\t\u001a\u00020\u0002H\u0016J\u0012\u0010\n\u001a\u00020\u00022\b\u0010\u0005\u001a\u0004\u0018\u00010\u0004H\u0016J\b\u0010\u000b\u001a\u00020\u0002H\u0016J\b\u0010\f\u001a\u00020\u0002H\u0016J\b\u0010\r\u001a\u00020\u0002H\u0016J\u0012\u0010\u000e\u001a\u00020\u00022\b\u0010\u0005\u001a\u0004\u0018\u00010\u0004H\u0016J\u0010\u0010\u0010\u001a\u00020\u00022\b\u0010\u000f\u001a\u0004\u0018\u00010\u0001J\u0010\u0010\u0011\u001a\u00020\u00022\b\u0010\u000f\u001a\u0004\u0018\u00010\u0001R\u001e\u0010\u0013\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00010\u00128\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0013\u0010\u0014¨\u0006\u0017"}, d2 = {"Lcom/youku/arch/v3/loader/LoadingViewManager;", "Lcom/youku/arch/v3/loader/ILoadingViewListener;", "Ltb/wt2;", "onNextPageLoading", "", "message", "onLoadNextFailure", "onLoadNextSuccess", "onAllPageLoaded", "onLoading", "onFailure", "onNoData", "onNoNetwork", "onSuccess", "onFailureWithData", "listener", "addLoadingStateListener", "removeLoadingStateListener", "", "listeners", "Ljava/util/List;", "<init>", "()V", "konearch_release"}, k = 1, mv = {1, 5, 1})
/* loaded from: classes2.dex */
public final class LoadingViewManager implements ILoadingViewListener {
    private static transient /* synthetic */ IpChange $ipChange;
    @NotNull
    private final List<ILoadingViewListener> listeners = new ArrayList();

    public final void addLoadingStateListener(@Nullable ILoadingViewListener iLoadingViewListener) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1208207906")) {
            ipChange.ipc$dispatch("-1208207906", new Object[]{this, iLoadingViewListener});
        } else if (iLoadingViewListener == null) {
        } else {
            this.listeners.add(iLoadingViewListener);
        }
    }

    @Override // com.youku.arch.v3.loader.ILoadingViewListener
    public void onAllPageLoaded() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "873470972")) {
            ipChange.ipc$dispatch("873470972", new Object[]{this});
            return;
        }
        for (ILoadingViewListener iLoadingViewListener : this.listeners) {
            if (iLoadingViewListener != null) {
                iLoadingViewListener.onAllPageLoaded();
            }
        }
    }

    @Override // com.youku.arch.v3.loader.ILoadingViewListener
    public void onFailure(@Nullable String str) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1160956241")) {
            ipChange.ipc$dispatch("1160956241", new Object[]{this, str});
            return;
        }
        for (ILoadingViewListener iLoadingViewListener : this.listeners) {
            if (iLoadingViewListener != null) {
                iLoadingViewListener.onFailure(str);
            }
        }
    }

    @Override // com.youku.arch.v3.loader.ILoadingViewListener
    public void onFailureWithData(@Nullable String str) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-745529439")) {
            ipChange.ipc$dispatch("-745529439", new Object[]{this, str});
            return;
        }
        for (ILoadingViewListener iLoadingViewListener : this.listeners) {
            if (iLoadingViewListener != null) {
                iLoadingViewListener.onFailureWithData(str);
            }
        }
    }

    @Override // com.youku.arch.v3.loader.ILoadingViewListener
    public void onLoadNextFailure(@Nullable String str) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-226778390")) {
            ipChange.ipc$dispatch("-226778390", new Object[]{this, str});
            return;
        }
        for (ILoadingViewListener iLoadingViewListener : this.listeners) {
            if (iLoadingViewListener != null) {
                iLoadingViewListener.onLoadNextFailure(str);
            }
        }
    }

    @Override // com.youku.arch.v3.loader.ILoadingViewListener
    public void onLoadNextSuccess() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1872999431")) {
            ipChange.ipc$dispatch("1872999431", new Object[]{this});
            return;
        }
        for (ILoadingViewListener iLoadingViewListener : this.listeners) {
            if (iLoadingViewListener != null) {
                iLoadingViewListener.onLoadNextSuccess();
            }
        }
    }

    @Override // com.youku.arch.v3.loader.ILoadingViewListener
    public void onLoading() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1025434027")) {
            ipChange.ipc$dispatch("-1025434027", new Object[]{this});
            return;
        }
        for (ILoadingViewListener iLoadingViewListener : this.listeners) {
            if (iLoadingViewListener != null) {
                iLoadingViewListener.onLoading();
            }
        }
    }

    @Override // com.youku.arch.v3.loader.ILoadingViewListener
    public void onNextPageLoading() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-981332969")) {
            ipChange.ipc$dispatch("-981332969", new Object[]{this});
            return;
        }
        for (ILoadingViewListener iLoadingViewListener : this.listeners) {
            if (iLoadingViewListener != null) {
                iLoadingViewListener.onNextPageLoading();
            }
        }
    }

    @Override // com.youku.arch.v3.loader.ILoadingViewListener
    public void onNoData() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1434284398")) {
            ipChange.ipc$dispatch("1434284398", new Object[]{this});
            return;
        }
        for (ILoadingViewListener iLoadingViewListener : this.listeners) {
            if (iLoadingViewListener != null) {
                iLoadingViewListener.onNoData();
            }
        }
    }

    @Override // com.youku.arch.v3.loader.ILoadingViewListener
    public void onNoNetwork() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1977818564")) {
            ipChange.ipc$dispatch("1977818564", new Object[]{this});
            return;
        }
        for (ILoadingViewListener iLoadingViewListener : this.listeners) {
            if (iLoadingViewListener != null) {
                iLoadingViewListener.onNoNetwork();
            }
        }
    }

    @Override // com.youku.arch.v3.loader.ILoadingViewListener
    public void onSuccess() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "2127722030")) {
            ipChange.ipc$dispatch("2127722030", new Object[]{this});
            return;
        }
        for (ILoadingViewListener iLoadingViewListener : this.listeners) {
            if (iLoadingViewListener != null) {
                iLoadingViewListener.onSuccess();
            }
        }
    }

    public final void removeLoadingStateListener(@Nullable ILoadingViewListener iLoadingViewListener) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "285634331")) {
            ipChange.ipc$dispatch("285634331", new Object[]{this, iLoadingViewListener});
        } else if (iLoadingViewListener == null) {
        } else {
            this.listeners.remove(iLoadingViewListener);
        }
    }
}
