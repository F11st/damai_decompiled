package com.youku.arch.v3.page;

import android.view.View;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import com.youku.arch.v3.page.GenericFragment;
import com.youku.arch.v3.page.GenericFragment$initPageStateManager$1$1;
import com.youku.arch.v3.page.state.OnConfigStateViewListener;
import com.youku.arch.v3.page.state.State;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import tb.b41;

/* compiled from: Taobao */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001d\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u001a\u0010\u0007\u001a\u00020\u00062\b\u0010\u0003\u001a\u0004\u0018\u00010\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0016¨\u0006\b"}, d2 = {"com/youku/arch/v3/page/GenericFragment$initPageStateManager$1$1", "Lcom/youku/arch/v3/page/state/OnConfigStateViewListener;", "Landroid/view/View;", "view", "Lcom/youku/arch/v3/page/state/State;", "state", "Ltb/wt2;", "onConfigStateView", "konearch_release"}, k = 1, mv = {1, 5, 1})
/* loaded from: classes2.dex */
public final class GenericFragment$initPageStateManager$1$1 implements OnConfigStateViewListener {
    private static transient /* synthetic */ IpChange $ipChange;
    final /* synthetic */ GenericFragment this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    public GenericFragment$initPageStateManager$1$1(GenericFragment genericFragment) {
        this.this$0 = genericFragment;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: onConfigStateView$lambda-0  reason: not valid java name */
    public static final void m1254onConfigStateView$lambda0(GenericFragment genericFragment, State state, View view) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1953884319")) {
            ipChange.ipc$dispatch("1953884319", new Object[]{genericFragment, state, view});
            return;
        }
        b41.i(genericFragment, "this$0");
        b41.i(state, "$state");
        if (genericFragment.getPageStateManager().currentState == state) {
            genericFragment.getPageContainer().reload();
            genericFragment.getPageStateManager().setState(State.LOADING);
        }
    }

    @Override // com.youku.arch.v3.page.state.OnConfigStateViewListener
    public void onConfigStateView(@Nullable View view, @NotNull final State state) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1530698098")) {
            ipChange.ipc$dispatch("-1530698098", new Object[]{this, view, state});
            return;
        }
        b41.i(state, "state");
        if ((state == State.FAILED || state == State.NO_NETWORK) && view != null) {
            final GenericFragment genericFragment = this.this$0;
            view.setOnClickListener(new View.OnClickListener() { // from class: tb.ot0
                @Override // android.view.View.OnClickListener
                public final void onClick(View view2) {
                    GenericFragment$initPageStateManager$1$1.m1254onConfigStateView$lambda0(GenericFragment.this, state, view2);
                }
            });
        }
    }
}
