package com.youku.arch.v3.page.state;

import android.view.View;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import kotlin.Metadata;
import org.jetbrains.annotations.Nullable;

/* compiled from: Taobao */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\b\u0018\u00002\u00020\u0001B\u0011\u0012\b\u0010\b\u001a\u0004\u0018\u00010\u0007¢\u0006\u0004\b\u000e\u0010\rJ\u001c\u0010\u0006\u001a\u00020\u00052\b\u0010\u0003\u001a\u0004\u0018\u00010\u00022\b\u0010\u0004\u001a\u0004\u0018\u00010\u0002H\u0016R$\u0010\b\u001a\u0004\u0018\u00010\u00078\u0016@\u0016X\u0096\u000e¢\u0006\u0012\n\u0004\b\b\u0010\t\u001a\u0004\b\n\u0010\u000b\"\u0004\b\f\u0010\r¨\u0006\u000f"}, d2 = {"Lcom/youku/arch/v3/page/state/StateSuccessView;", "Lcom/youku/arch/v3/page/state/IStateView;", "", "code", "msg", "Ltb/wt2;", "update", "Landroid/view/View;", "contentView", "Landroid/view/View;", "getContentView", "()Landroid/view/View;", "setContentView", "(Landroid/view/View;)V", "<init>", "konearch_release"}, k = 1, mv = {1, 5, 1})
/* loaded from: classes2.dex */
public final class StateSuccessView implements IStateView {
    private static transient /* synthetic */ IpChange $ipChange;
    @Nullable
    private View contentView;

    public StateSuccessView(@Nullable View view) {
        this.contentView = view;
    }

    @Override // com.youku.arch.v3.page.state.IStateView
    @Nullable
    public View getContentView() {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "-1175930689") ? (View) ipChange.ipc$dispatch("-1175930689", new Object[]{this}) : this.contentView;
    }

    @Override // com.youku.arch.v3.page.state.IStateView
    public void setContentView(@Nullable View view) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "2022657129")) {
            ipChange.ipc$dispatch("2022657129", new Object[]{this, view});
        } else {
            this.contentView = view;
        }
    }

    @Override // com.youku.arch.v3.page.state.IStateView
    public void update(@Nullable String str, @Nullable String str2) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1462454800")) {
            ipChange.ipc$dispatch("-1462454800", new Object[]{this, str, str2});
        }
    }
}
