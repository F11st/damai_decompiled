package com.youku.arch.v3.loader;

import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import kotlin.Metadata;
import org.jetbrains.annotations.Nullable;

/* compiled from: Taobao */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\r\b\u0016\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u000f\u0010\u0010J\b\u0010\u0003\u001a\u00020\u0002H\u0016J\u0012\u0010\u0006\u001a\u00020\u00022\b\u0010\u0005\u001a\u0004\u0018\u00010\u0004H\u0016J\b\u0010\u0007\u001a\u00020\u0002H\u0016J\b\u0010\b\u001a\u00020\u0002H\u0016J\b\u0010\t\u001a\u00020\u0002H\u0016J\u0012\u0010\n\u001a\u00020\u00022\b\u0010\u0005\u001a\u0004\u0018\u00010\u0004H\u0016J\b\u0010\u000b\u001a\u00020\u0002H\u0016J\b\u0010\f\u001a\u00020\u0002H\u0016J\b\u0010\r\u001a\u00020\u0002H\u0016J\u0012\u0010\u000e\u001a\u00020\u00022\b\u0010\u0005\u001a\u0004\u0018\u00010\u0004H\u0016¨\u0006\u0011"}, d2 = {"Lcom/youku/arch/v3/loader/LoadingViewAdapter;", "Lcom/youku/arch/v3/loader/ILoadingViewListener;", "Ltb/wt2;", "onNextPageLoading", "", "message", "onLoadNextFailure", "onLoadNextSuccess", "onAllPageLoaded", "onLoading", "onFailure", "onNoData", "onNoNetwork", "onSuccess", "onFailureWithData", "<init>", "()V", "konearch_release"}, k = 1, mv = {1, 5, 1})
/* loaded from: classes2.dex */
public class LoadingViewAdapter implements ILoadingViewListener {
    private static transient /* synthetic */ IpChange $ipChange;

    @Override // com.youku.arch.v3.loader.ILoadingViewListener
    public void onAllPageLoaded() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "152469914")) {
            ipChange.ipc$dispatch("152469914", new Object[]{this});
        }
    }

    @Override // com.youku.arch.v3.loader.ILoadingViewListener
    public void onFailure(@Nullable String str) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1482182161")) {
            ipChange.ipc$dispatch("-1482182161", new Object[]{this, str});
        }
    }

    @Override // com.youku.arch.v3.loader.ILoadingViewListener
    public void onFailureWithData(@Nullable String str) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "148474431")) {
            ipChange.ipc$dispatch("148474431", new Object[]{this, str});
        }
    }

    @Override // com.youku.arch.v3.loader.ILoadingViewListener
    public void onLoadNextFailure(@Nullable String str) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "667225480")) {
            ipChange.ipc$dispatch("667225480", new Object[]{this, str});
        }
    }

    @Override // com.youku.arch.v3.loader.ILoadingViewListener
    public void onLoadNextSuccess() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "480717349")) {
            ipChange.ipc$dispatch("480717349", new Object[]{this});
        }
    }

    @Override // com.youku.arch.v3.loader.ILoadingViewListener
    public void onLoading() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-543976845")) {
            ipChange.ipc$dispatch("-543976845", new Object[]{this});
        }
    }

    @Override // com.youku.arch.v3.loader.ILoadingViewListener
    public void onNextPageLoading() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1921352245")) {
            ipChange.ipc$dispatch("1921352245", new Object[]{this});
        }
    }

    @Override // com.youku.arch.v3.loader.ILoadingViewListener
    public void onNoData() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1598226032")) {
            ipChange.ipc$dispatch("-1598226032", new Object[]{this});
        }
    }

    @Override // com.youku.arch.v3.loader.ILoadingViewListener
    public void onNoNetwork() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "801702498")) {
            ipChange.ipc$dispatch("801702498", new Object[]{this});
        }
    }

    @Override // com.youku.arch.v3.loader.ILoadingViewListener
    public void onSuccess() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1685788084")) {
            ipChange.ipc$dispatch("-1685788084", new Object[]{this});
        }
    }
}
