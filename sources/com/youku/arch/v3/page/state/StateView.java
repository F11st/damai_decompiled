package com.youku.arch.v3.page.state;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.widget.FrameLayout;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import com.taobao.weex.ui.component.list.template.TemplateDom;
import io.flutter.wpkbridge.WPKFactory;
import java.util.HashMap;
import kotlin.Metadata;
import kotlin.jvm.JvmOverloads;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import tb.b41;
import tb.k50;

/* compiled from: Taobao */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000L\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u00002\u00020\u0001:\u0001#B)\b\u0007\u0012\b\u0010\u001d\u001a\u0004\u0018\u00010\u001c\u0012\n\b\u0002\u0010\u001f\u001a\u0004\u0018\u00010\u001e\u0012\b\b\u0002\u0010 \u001a\u00020\u0006¢\u0006\u0004\b!\u0010\"J\b\u0010\u0003\u001a\u00020\u0002H\u0014J\u0016\u0010\b\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u0006J\u0018\u0010\b\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\b\u0010\n\u001a\u0004\u0018\u00010\tJ\u0018\u0010\b\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\b\u0010\f\u001a\u0004\u0018\u00010\u000bJ\u0010\u0010\r\u001a\u0004\u0018\u00010\t2\u0006\u0010\u0005\u001a\u00020\u0004J\u000e\u0010\u000e\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004J\u0010\u0010\u0011\u001a\u00020\u00022\b\u0010\u0010\u001a\u0004\u0018\u00010\u000fR\u0018\u0010\u0010\u001a\u0004\u0018\u00010\u000f8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u0010\u0010\u0012R$\u0010\u0014\u001a\u00020\u00042\u0006\u0010\u0013\u001a\u00020\u00048\u0006@BX\u0086\u000e¢\u0006\f\n\u0004\b\u0014\u0010\u0015\u001a\u0004\b\u0016\u0010\u0017R\"\u0010\u001a\u001a\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00190\u00188\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u001a\u0010\u001b¨\u0006$"}, d2 = {"Lcom/youku/arch/v3/page/state/StateView;", "Landroid/widget/FrameLayout;", "Ltb/wt2;", "onFinishInflate", "Lcom/youku/arch/v3/page/state/State;", "state", "", "layoutId", "setStateProperty", "Lcom/youku/arch/v3/page/state/IStateView;", "view", "Lcom/youku/arch/v3/page/state/OnCreateStateViewListener;", "listener", "getStateView", "setState", "Lcom/youku/arch/v3/page/state/OnConfigStateViewListener;", "onConfigStateViewListener", "setOnConfigStateViewListener", "Lcom/youku/arch/v3/page/state/OnConfigStateViewListener;", "<set-?>", "currentState", "Lcom/youku/arch/v3/page/state/State;", "getCurrentState", "()Lcom/youku/arch/v3/page/state/State;", "Ljava/util/HashMap;", "Lcom/youku/arch/v3/page/state/StateView$StateProperty;", "statePropertyMap", "Ljava/util/HashMap;", "Landroid/content/Context;", WPKFactory.INIT_KEY_CONTEXT, "Landroid/util/AttributeSet;", TemplateDom.KEY_ATTRS, "defStyle", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "StateProperty", "konearch_release"}, k = 1, mv = {1, 5, 1})
/* loaded from: classes2.dex */
public final class StateView extends FrameLayout {
    private static transient /* synthetic */ IpChange $ipChange;
    @NotNull
    private State currentState;
    @Nullable
    private OnConfigStateViewListener onConfigStateViewListener;
    @NotNull
    private final HashMap<State, StateProperty> statePropertyMap;

    /* compiled from: Taobao */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\b\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\t\b\u0002\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0017\u0010\u0018R$\u0010\u0003\u001a\u0004\u0018\u00010\u00028\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR\"\u0010\n\u001a\u00020\t8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\n\u0010\u000b\u001a\u0004\b\f\u0010\r\"\u0004\b\u000e\u0010\u000fR$\u0010\u0011\u001a\u0004\u0018\u00010\u00108\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u0011\u0010\u0012\u001a\u0004\b\u0013\u0010\u0014\"\u0004\b\u0015\u0010\u0016¨\u0006\u0019"}, d2 = {"Lcom/youku/arch/v3/page/state/StateView$StateProperty;", "", "Lcom/youku/arch/v3/page/state/IStateView;", "view", "Lcom/youku/arch/v3/page/state/IStateView;", "getView", "()Lcom/youku/arch/v3/page/state/IStateView;", "setView", "(Lcom/youku/arch/v3/page/state/IStateView;)V", "", "layoutId", "I", "getLayoutId", "()I", "setLayoutId", "(I)V", "Lcom/youku/arch/v3/page/state/OnCreateStateViewListener;", "createStateViewListener", "Lcom/youku/arch/v3/page/state/OnCreateStateViewListener;", "getCreateStateViewListener", "()Lcom/youku/arch/v3/page/state/OnCreateStateViewListener;", "setCreateStateViewListener", "(Lcom/youku/arch/v3/page/state/OnCreateStateViewListener;)V", "<init>", "()V", "konearch_release"}, k = 1, mv = {1, 5, 1})
    /* loaded from: classes2.dex */
    public static final class StateProperty {
        private static transient /* synthetic */ IpChange $ipChange;
        @Nullable
        private OnCreateStateViewListener createStateViewListener;
        private int layoutId;
        @Nullable
        private IStateView view;

        @Nullable
        public final OnCreateStateViewListener getCreateStateViewListener() {
            IpChange ipChange = $ipChange;
            return AndroidInstantRuntime.support(ipChange, "245636323") ? (OnCreateStateViewListener) ipChange.ipc$dispatch("245636323", new Object[]{this}) : this.createStateViewListener;
        }

        public final int getLayoutId() {
            IpChange ipChange = $ipChange;
            return AndroidInstantRuntime.support(ipChange, "641873094") ? ((Integer) ipChange.ipc$dispatch("641873094", new Object[]{this})).intValue() : this.layoutId;
        }

        @Nullable
        public final IStateView getView() {
            IpChange ipChange = $ipChange;
            return AndroidInstantRuntime.support(ipChange, "-1115214330") ? (IStateView) ipChange.ipc$dispatch("-1115214330", new Object[]{this}) : this.view;
        }

        public final void setCreateStateViewListener(@Nullable OnCreateStateViewListener onCreateStateViewListener) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "392199905")) {
                ipChange.ipc$dispatch("392199905", new Object[]{this, onCreateStateViewListener});
            } else {
                this.createStateViewListener = onCreateStateViewListener;
            }
        }

        public final void setLayoutId(int i) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "-665988196")) {
                ipChange.ipc$dispatch("-665988196", new Object[]{this, Integer.valueOf(i)});
            } else {
                this.layoutId = i;
            }
        }

        public final void setView(@Nullable IStateView iStateView) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "2127232092")) {
                ipChange.ipc$dispatch("2127232092", new Object[]{this, iStateView});
            } else {
                this.view = iStateView;
            }
        }
    }

    @JvmOverloads
    public StateView(@Nullable Context context) {
        this(context, null, 0, 6, null);
    }

    @JvmOverloads
    public StateView(@Nullable Context context, @Nullable AttributeSet attributeSet) {
        this(context, attributeSet, 0, 4, null);
    }

    public /* synthetic */ StateView(Context context, AttributeSet attributeSet, int i, int i2, k50 k50Var) {
        this(context, (i2 & 2) != 0 ? null : attributeSet, (i2 & 4) != 0 ? 0 : i);
    }

    @NotNull
    public final State getCurrentState() {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "1906762467") ? (State) ipChange.ipc$dispatch("1906762467", new Object[]{this}) : this.currentState;
    }

    @Nullable
    public final IStateView getStateView(@NotNull State state) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1418682140")) {
            return (IStateView) ipChange.ipc$dispatch("1418682140", new Object[]{this, state});
        }
        b41.i(state, "state");
        StateProperty stateProperty = this.statePropertyMap.get(state);
        if (stateProperty == null) {
            return null;
        }
        return stateProperty.getView();
    }

    @Override // android.view.View
    protected void onFinishInflate() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-648331301")) {
            ipChange.ipc$dispatch("-648331301", new Object[]{this});
            return;
        }
        super.onFinishInflate();
        View childAt = getChildAt(0);
        if (childAt == null) {
            return;
        }
        setStateProperty(State.SUCCESS, new StateSuccessView(childAt));
    }

    public final void setOnConfigStateViewListener(@Nullable OnConfigStateViewListener onConfigStateViewListener) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-190562838")) {
            ipChange.ipc$dispatch("-190562838", new Object[]{this, onConfigStateViewListener});
        } else {
            this.onConfigStateViewListener = onConfigStateViewListener;
        }
    }

    public final void setState(@NotNull State state) {
        View contentView;
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1823645466")) {
            ipChange.ipc$dispatch("1823645466", new Object[]{this, state});
            return;
        }
        b41.i(state, "state");
        State state2 = this.currentState;
        this.currentState = state;
        StateProperty stateProperty = this.statePropertyMap.get(state);
        if (stateProperty != null) {
            IStateView view = stateProperty.getView();
            if (view == null) {
                OnCreateStateViewListener createStateViewListener = stateProperty.getCreateStateViewListener();
                stateProperty.getLayoutId();
                if (createStateViewListener != null) {
                    view = createStateViewListener.onCreateStateView(this, state);
                } else {
                    stateProperty.getLayoutId();
                }
                if (view != null) {
                    addView(view.getContentView());
                    stateProperty.setView(view);
                }
            } else {
                if (stateProperty.getLayoutId() <= 0 && stateProperty.getCreateStateViewListener() == null && indexOfChild(view.getContentView()) < 0) {
                    addView(view.getContentView());
                }
                View contentView2 = view.getContentView();
                if (contentView2 != null) {
                    contentView2.setVisibility(0);
                }
            }
            OnConfigStateViewListener onConfigStateViewListener = this.onConfigStateViewListener;
            if (onConfigStateViewListener != null) {
                onConfigStateViewListener.onConfigStateView(view == null ? null : view.getContentView(), state);
            }
        }
        StateProperty stateProperty2 = this.statePropertyMap.get(state2);
        if (stateProperty2 == null || stateProperty == null || stateProperty2 == stateProperty) {
            return;
        }
        IStateView view2 = stateProperty2.getView();
        IStateView view3 = stateProperty.getView();
        if (view2 == null || view2 == view3 || (contentView = view2.getContentView()) == null) {
            return;
        }
        contentView.setVisibility(8);
    }

    public final void setStateProperty(@NotNull State state, int i) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-323185122")) {
            ipChange.ipc$dispatch("-323185122", new Object[]{this, state, Integer.valueOf(i)});
            return;
        }
        b41.i(state, "state");
        StateProperty stateProperty = this.statePropertyMap.get(state);
        if (stateProperty == null) {
            stateProperty = new StateProperty();
        }
        stateProperty.setLayoutId(i);
        this.statePropertyMap.put(state, stateProperty);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    @JvmOverloads
    public StateView(@Nullable Context context, @Nullable AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        b41.f(context);
        State state = State.SUCCESS;
        this.currentState = state;
        this.statePropertyMap = new HashMap<>();
        setStateProperty(State.FAILED, -1);
        setStateProperty(state, -1);
        setStateProperty(State.LOADING, -1);
        setStateProperty(State.NO_DATA, -1);
        setStateProperty(State.NO_NETWORK, -1);
        setState(state);
    }

    public final void setStateProperty(@NotNull State state, @Nullable IStateView iStateView) {
        View contentView;
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "700542878")) {
            ipChange.ipc$dispatch("700542878", new Object[]{this, state, iStateView});
            return;
        }
        b41.i(state, "state");
        StateProperty stateProperty = this.statePropertyMap.get(state);
        if (stateProperty == null) {
            stateProperty = new StateProperty();
            this.statePropertyMap.put(state, stateProperty);
        }
        if (stateProperty.getView() != iStateView) {
            ViewParent parent = (iStateView == null || (contentView = iStateView.getContentView()) == null) ? null : contentView.getParent();
            ViewGroup viewGroup = parent instanceof ViewGroup ? (ViewGroup) parent : null;
            if (viewGroup != null) {
                IStateView view = stateProperty.getView();
                viewGroup.removeView(view == null ? null : view.getContentView());
            }
            stateProperty.setView(iStateView);
        }
        View contentView2 = iStateView != null ? iStateView.getContentView() : null;
        if (contentView2 == null) {
            return;
        }
        contentView2.setVisibility(this.currentState != state ? 8 : 0);
    }

    public final void setStateProperty(@NotNull State state, @Nullable OnCreateStateViewListener onCreateStateViewListener) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1116317066")) {
            ipChange.ipc$dispatch("-1116317066", new Object[]{this, state, onCreateStateViewListener});
            return;
        }
        b41.i(state, "state");
        StateProperty stateProperty = this.statePropertyMap.get(state);
        if (stateProperty == null) {
            stateProperty = new StateProperty();
        }
        stateProperty.setCreateStateViewListener(onCreateStateViewListener);
        this.statePropertyMap.put(state, stateProperty);
    }
}
