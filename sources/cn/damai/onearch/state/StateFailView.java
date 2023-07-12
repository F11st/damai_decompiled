package cn.damai.onearch.state;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import android.widget.TextView;
import cn.damai.common.net.mtop.Util;
import cn.damai.commonbusiness.R$id;
import cn.damai.commonbusiness.R$layout;
import cn.damai.onearch.state.StateFailView;
import com.alient.onearch.adapter.state.StateViewManager;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import com.youku.arch.v3.page.state.IStateView;
import io.flutter.wpkbridge.WPKFactory;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import tb.b41;
import tb.ff0;

/* compiled from: Taobao */
/* loaded from: classes6.dex */
public final class StateFailView extends RelativeLayout implements IStateView {
    private static transient /* synthetic */ IpChange $ipChange;
    @Nullable
    private View contentView;
    @Nullable
    private String errorCode;
    @Nullable
    private String errorMsg;
    @Nullable
    private TextView errorTip;
    @Nullable
    private StateViewManager.IStateViewListener listener;
    @Nullable
    private TextView refreshBtn;
    @Nullable
    private TextView reportBtn;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public StateFailView(@NotNull final Context context) {
        super(context);
        b41.i(context, WPKFactory.INIT_KEY_CONTEXT);
        this.contentView = this;
        View inflate = LayoutInflater.from(context).inflate(R$layout.layout_cms_state_view, (ViewGroup) this, true);
        TextView textView = (TextView) inflate.findViewById(R$id.btn_refresh);
        textView.setOnClickListener(new View.OnClickListener() { // from class: tb.fg2
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                StateFailView.m66lambda1$lambda0(StateFailView.this, view);
            }
        });
        this.refreshBtn = textView;
        TextView textView2 = (TextView) inflate.findViewById(R$id.tv_report);
        textView2.setOnClickListener(new View.OnClickListener() { // from class: tb.eg2
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                StateFailView.m67lambda3$lambda2(context, this, view);
            }
        });
        this.reportBtn = textView2;
        this.errorTip = (TextView) inflate.findViewById(R$id.tv_error_tip);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: lambda-1$lambda-0  reason: not valid java name */
    public static final void m66lambda1$lambda0(StateFailView stateFailView, View view) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1891213279")) {
            ipChange.ipc$dispatch("-1891213279", new Object[]{stateFailView, view});
            return;
        }
        b41.i(stateFailView, "this$0");
        StateViewManager.IStateViewListener iStateViewListener = stateFailView.listener;
        if (iStateViewListener != null) {
            iStateViewListener.onRefreshClick();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: lambda-3$lambda-2  reason: not valid java name */
    public static final void m67lambda3$lambda2(Context context, StateFailView stateFailView, View view) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "367656429")) {
            ipChange.ipc$dispatch("367656429", new Object[]{context, stateFailView, view});
            return;
        }
        b41.i(context, "$context");
        b41.i(stateFailView, "this$0");
        new ff0(context, stateFailView.errorCode, stateFailView.errorMsg, null, null, 24, null).f();
    }

    @Override // com.youku.arch.v3.page.state.IStateView
    @Nullable
    public View getContentView() {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "636652727") ? (View) ipChange.ipc$dispatch("636652727", new Object[]{this}) : this.contentView;
    }

    @Nullable
    public final StateViewManager.IStateViewListener getListener() {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "1120268985") ? (StateViewManager.IStateViewListener) ipChange.ipc$dispatch("1120268985", new Object[]{this}) : this.listener;
    }

    @Override // com.youku.arch.v3.page.state.IStateView
    public void setContentView(@Nullable View view) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1916799119")) {
            ipChange.ipc$dispatch("-1916799119", new Object[]{this, view});
        } else {
            this.contentView = view;
        }
    }

    public final void setListener(@Nullable StateViewManager.IStateViewListener iStateViewListener) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "190615357")) {
            ipChange.ipc$dispatch("190615357", new Object[]{this, iStateViewListener});
        } else {
            this.listener = iStateViewListener;
        }
    }

    @Override // com.youku.arch.v3.page.state.IStateView
    public void update(@Nullable String str, @Nullable String str2) {
        TextView textView;
        IpChange ipChange = $ipChange;
        boolean z = true;
        if (AndroidInstantRuntime.support(ipChange, "444593128")) {
            ipChange.ipc$dispatch("444593128", new Object[]{this, str, str2});
            return;
        }
        String errorMsg = Util.getErrorMsg(str, str2);
        if (errorMsg != null && errorMsg.length() != 0) {
            z = false;
        }
        if (!z && (textView = this.errorTip) != null) {
            textView.setText(errorMsg);
        }
        this.errorCode = str;
        this.errorMsg = errorMsg;
    }
}
