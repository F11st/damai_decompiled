package com.youku.arch.v3.page.state;

import android.content.Context;
import android.view.ViewGroup;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import com.youku.arch.v3.loader.ILoadingViewListener;
import io.flutter.wpkbridge.WPKFactory;
import kotlin.Metadata;
import kotlin.jvm.JvmField;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import tb.b41;

/* compiled from: Taobao */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000`\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\f\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u00002\u00020\u0001:\u0001;B\u0011\u0012\b\u00108\u001a\u0004\u0018\u000107¢\u0006\u0004\b9\u0010:J\u000e\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002J\u0018\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u00022\b\u0010\u0007\u001a\u0004\u0018\u00010\u0006J\u0018\u0010\n\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u00022\b\u0010\t\u001a\u0004\u0018\u00010\bJ\u0016\u0010\n\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\f\u001a\u00020\u000bJ\u0018\u0010\n\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u00022\b\u0010\u000e\u001a\u0004\u0018\u00010\rJ\u0006\u0010\u000f\u001a\u00020\u0002J\u0010\u0010\u0012\u001a\u00020\u00042\b\u0010\u0011\u001a\u0004\u0018\u00010\u0010J\b\u0010\u0013\u001a\u00020\u0004H\u0016J\u0012\u0010\u0014\u001a\u00020\u00042\b\u0010\u0007\u001a\u0004\u0018\u00010\u0006H\u0016J\b\u0010\u0015\u001a\u00020\u0004H\u0016J\b\u0010\u0016\u001a\u00020\u0004H\u0016J\b\u0010\u0017\u001a\u00020\u0004H\u0016J\b\u0010\u0018\u001a\u00020\u0004H\u0016J\u0012\u0010\u0019\u001a\u00020\u00042\b\u0010\u0007\u001a\u0004\u0018\u00010\u0006H\u0016J\u0012\u0010\u001a\u001a\u00020\u00042\b\u0010\u0007\u001a\u0004\u0018\u00010\u0006H\u0016J\b\u0010\u001b\u001a\u00020\u0004H\u0016J\b\u0010\u001c\u001a\u00020\u0004H\u0016R\u0018\u0010\u001e\u001a\u0004\u0018\u00010\u001d8\u0006@\u0007X\u0087\u0004¢\u0006\u0006\n\u0004\b\u001e\u0010\u001fR\u0016\u0010 \u001a\u00020\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0006\n\u0004\b \u0010!R$\u0010#\u001a\u0004\u0018\u00010\"8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b#\u0010$\u001a\u0004\b%\u0010&\"\u0004\b'\u0010(R\"\u0010*\u001a\u00020)8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b*\u0010+\u001a\u0004\b*\u0010,\"\u0004\b-\u0010.R\u0018\u00100\u001a\u0004\u0018\u00010/8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b0\u00101R(\u00106\u001a\u0004\u0018\u00010/2\b\u00100\u001a\u0004\u0018\u00010/8F@FX\u0086\u000e¢\u0006\f\u001a\u0004\b2\u00103\"\u0004\b4\u00105¨\u0006<"}, d2 = {"Lcom/youku/arch/v3/page/state/PageStateManager;", "Lcom/youku/arch/v3/loader/ILoadingViewListener;", "Lcom/youku/arch/v3/page/state/State;", "state", "Ltb/wt2;", "setState", "", "message", "Lcom/youku/arch/v3/page/state/IStateView;", "view", "setStateProperty", "", "layoutId", "Lcom/youku/arch/v3/page/state/OnCreateStateViewListener;", "listener", "getCurrentState", "Lcom/youku/arch/v3/page/state/OnConfigStateViewListener;", "onConfigStateViewListener", "setOnConfigStateViewListener", "onNextPageLoading", "onLoadNextFailure", "onLoadNextSuccess", "onAllPageLoaded", "onLoading", "onSuccess", "onFailure", "onFailureWithData", "onNoData", "onNoNetwork", "Lcom/youku/arch/v3/page/state/StateView;", "stateView", "Lcom/youku/arch/v3/page/state/StateView;", "currentState", "Lcom/youku/arch/v3/page/state/State;", "Lcom/youku/arch/v3/page/state/PageStateManager$OnStateChangeListener;", "onStateChangeListener", "Lcom/youku/arch/v3/page/state/PageStateManager$OnStateChangeListener;", "getOnStateChangeListener", "()Lcom/youku/arch/v3/page/state/PageStateManager$OnStateChangeListener;", "setOnStateChangeListener", "(Lcom/youku/arch/v3/page/state/PageStateManager$OnStateChangeListener;)V", "", "isStateViewEnable", "Z", "()Z", "setStateViewEnable", "(Z)V", "Landroid/view/ViewGroup;", "customView", "Landroid/view/ViewGroup;", "getContentView", "()Landroid/view/ViewGroup;", "setContentView", "(Landroid/view/ViewGroup;)V", "contentView", "Landroid/content/Context;", WPKFactory.INIT_KEY_CONTEXT, "<init>", "(Landroid/content/Context;)V", "OnStateChangeListener", "konearch_release"}, k = 1, mv = {1, 5, 1})
/* loaded from: classes2.dex */
public final class PageStateManager implements ILoadingViewListener {
    private static transient /* synthetic */ IpChange $ipChange;
    @Nullable
    private ViewGroup customView;
    @Nullable
    private OnStateChangeListener onStateChangeListener;
    @JvmField
    @Nullable
    public final StateView stateView;
    @JvmField
    @NotNull
    public State currentState = State.SUCCESS;
    private boolean isStateViewEnable = true;

    /* compiled from: Taobao */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\bf\u0018\u00002\u00020\u0001J&\u0010\b\u001a\u00020\u00072\b\u0010\u0003\u001a\u0004\u0018\u00010\u00022\b\u0010\u0004\u001a\u0004\u0018\u00010\u00022\b\u0010\u0006\u001a\u0004\u0018\u00010\u0005H&¨\u0006\t"}, d2 = {"Lcom/youku/arch/v3/page/state/PageStateManager$OnStateChangeListener;", "", "Lcom/youku/arch/v3/page/state/State;", "oldState", "newState", "", "message", "Ltb/wt2;", "onStateChanged", "konearch_release"}, k = 1, mv = {1, 5, 1})
    /* loaded from: classes2.dex */
    public interface OnStateChangeListener {
        void onStateChanged(@Nullable State state, @Nullable State state2, @Nullable String str);
    }

    public PageStateManager(@Nullable Context context) {
        StateView stateView = new StateView(context, null, 0, 6, null);
        this.stateView = stateView;
        stateView.setLayoutParams(new ViewGroup.LayoutParams(-1, -1));
    }

    @Nullable
    public final ViewGroup getContentView() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-991635164")) {
            return (ViewGroup) ipChange.ipc$dispatch("-991635164", new Object[]{this});
        }
        if (this.isStateViewEnable) {
            return this.stateView;
        }
        return this.customView;
    }

    @NotNull
    public final State getCurrentState() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "480594562")) {
            return (State) ipChange.ipc$dispatch("480594562", new Object[]{this});
        }
        if (this.isStateViewEnable) {
            StateView stateView = this.stateView;
            State currentState = stateView == null ? null : stateView.getCurrentState();
            return currentState == null ? State.LOADING : currentState;
        }
        return this.currentState;
    }

    @Nullable
    public final OnStateChangeListener getOnStateChangeListener() {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "-1779678020") ? (OnStateChangeListener) ipChange.ipc$dispatch("-1779678020", new Object[]{this}) : this.onStateChangeListener;
    }

    public final boolean isStateViewEnable() {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "989367366") ? ((Boolean) ipChange.ipc$dispatch("989367366", new Object[]{this})).booleanValue() : this.isStateViewEnable;
    }

    @Override // com.youku.arch.v3.loader.ILoadingViewListener
    public void onAllPageLoaded() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1897851141")) {
            ipChange.ipc$dispatch("-1897851141", new Object[]{this});
        } else {
            setState(State.SUCCESS);
        }
    }

    @Override // com.youku.arch.v3.loader.ILoadingViewListener
    public void onFailure(@Nullable String str) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1893744080")) {
            ipChange.ipc$dispatch("1893744080", new Object[]{this, str});
        } else {
            setState(State.FAILED, str);
        }
    }

    @Override // com.youku.arch.v3.loader.ILoadingViewListener
    public void onFailureWithData(@Nullable String str) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1837325024")) {
            ipChange.ipc$dispatch("-1837325024", new Object[]{this, str});
        } else {
            setState(State.FAILED_WITH_DATA, str);
        }
    }

    @Override // com.youku.arch.v3.loader.ILoadingViewListener
    public void onLoadNextFailure(@Nullable String str) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1318573975")) {
            ipChange.ipc$dispatch("-1318573975", new Object[]{this, str});
        } else {
            setState(State.LOAD_NEXT_FAILED, str);
        }
    }

    @Override // com.youku.arch.v3.loader.ILoadingViewListener
    public void onLoadNextSuccess() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1512172358")) {
            ipChange.ipc$dispatch("1512172358", new Object[]{this});
        } else {
            setState(State.SUCCESS);
        }
    }

    @Override // com.youku.arch.v3.loader.ILoadingViewListener
    public void onLoading() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1624114324")) {
            ipChange.ipc$dispatch("1624114324", new Object[]{this});
        } else {
            setState(State.LOADING);
        }
    }

    @Override // com.youku.arch.v3.loader.ILoadingViewListener
    public void onNextPageLoading() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1342160042")) {
            ipChange.ipc$dispatch("-1342160042", new Object[]{this});
        }
    }

    @Override // com.youku.arch.v3.loader.ILoadingViewListener
    public void onNoData() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "827017039")) {
            ipChange.ipc$dispatch("827017039", new Object[]{this});
        } else {
            setState(State.NO_DATA);
        }
    }

    @Override // com.youku.arch.v3.loader.ILoadingViewListener
    public void onNoNetwork() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1278177347")) {
            ipChange.ipc$dispatch("1278177347", new Object[]{this});
        } else {
            setState(State.NO_NETWORK);
        }
    }

    @Override // com.youku.arch.v3.loader.ILoadingViewListener
    public void onSuccess() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "482303085")) {
            ipChange.ipc$dispatch("482303085", new Object[]{this});
        } else {
            setState(State.SUCCESS);
        }
    }

    public final void setContentView(@Nullable ViewGroup viewGroup) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "127587100")) {
            ipChange.ipc$dispatch("127587100", new Object[]{this, viewGroup});
        } else {
            this.customView = viewGroup;
        }
    }

    public final void setOnConfigStateViewListener(@Nullable OnConfigStateViewListener onConfigStateViewListener) {
        StateView stateView;
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1978138057")) {
            ipChange.ipc$dispatch("1978138057", new Object[]{this, onConfigStateViewListener});
        } else if (!this.isStateViewEnable || (stateView = this.stateView) == null) {
        } else {
            stateView.setOnConfigStateViewListener(onConfigStateViewListener);
        }
    }

    public final void setOnStateChangeListener(@Nullable OnStateChangeListener onStateChangeListener) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1512326382")) {
            ipChange.ipc$dispatch("1512326382", new Object[]{this, onStateChangeListener});
        } else {
            this.onStateChangeListener = onStateChangeListener;
        }
    }

    public final void setState(@NotNull State state) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1308431879")) {
            ipChange.ipc$dispatch("-1308431879", new Object[]{this, state});
            return;
        }
        b41.i(state, "state");
        setState(state, null);
    }

    public final void setStateProperty(@NotNull State state, @Nullable IStateView iStateView) {
        StateView stateView;
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-79816033")) {
            ipChange.ipc$dispatch("-79816033", new Object[]{this, state, iStateView});
            return;
        }
        b41.i(state, "state");
        if (!this.isStateViewEnable || (stateView = this.stateView) == null) {
            return;
        }
        stateView.setStateProperty(state, iStateView);
    }

    public final void setStateViewEnable(boolean z) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-581989550")) {
            ipChange.ipc$dispatch("-581989550", new Object[]{this, Boolean.valueOf(z)});
        } else {
            this.isStateViewEnable = z;
        }
    }

    public final void setState(@NotNull State state, @Nullable String str) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1778849917")) {
            ipChange.ipc$dispatch("-1778849917", new Object[]{this, state, str});
            return;
        }
        b41.i(state, "state");
        if (this.isStateViewEnable) {
            StateView stateView = this.stateView;
            if (stateView == null) {
                return;
            }
            stateView.setState(state);
            return;
        }
        OnStateChangeListener onStateChangeListener = this.onStateChangeListener;
        if (onStateChangeListener != null) {
            onStateChangeListener.onStateChanged(this.currentState, state, str);
        }
        this.currentState = state;
    }

    public final void setStateProperty(@NotNull State state, int i) {
        StateView stateView;
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1474750945")) {
            ipChange.ipc$dispatch("-1474750945", new Object[]{this, state, Integer.valueOf(i)});
            return;
        }
        b41.i(state, "state");
        if (!this.isStateViewEnable || (stateView = this.stateView) == null) {
            return;
        }
        stateView.setStateProperty(state, i);
    }

    public final void setStateProperty(@NotNull State state, @Nullable OnCreateStateViewListener onCreateStateViewListener) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1790956203")) {
            ipChange.ipc$dispatch("-1790956203", new Object[]{this, state, onCreateStateViewListener});
            return;
        }
        b41.i(state, "state");
        StateView stateView = this.stateView;
        if (stateView == null) {
            return;
        }
        stateView.setStateProperty(state, onCreateStateViewListener);
    }
}
