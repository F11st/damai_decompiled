package cn.damai.onearch.state;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import cn.damai.commonbusiness.R$drawable;
import cn.damai.commonbusiness.R$id;
import cn.damai.commonbusiness.R$layout;
import cn.damai.onearch.state.StateNoNetworkView;
import com.alient.onearch.adapter.state.StateViewManager;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import com.youku.arch.v3.page.state.IStateView;
import io.flutter.wpkbridge.WPKFactory;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import tb.b41;

/* compiled from: Taobao */
/* loaded from: classes6.dex */
public final class StateNoNetworkView extends RelativeLayout implements IStateView {
    private static transient /* synthetic */ IpChange $ipChange;
    @Nullable
    private View contentView;
    @Nullable
    private StateViewManager.IStateViewListener listener;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public StateNoNetworkView(@NotNull Context context) {
        super(context);
        b41.i(context, WPKFactory.INIT_KEY_CONTEXT);
        this.contentView = this;
        View inflate = LayoutInflater.from(context).inflate(R$layout.layout_cms_state_view, (ViewGroup) this, true);
        TextView textView = (TextView) inflate.findViewById(R$id.btn_refresh);
        if (textView != null) {
            textView.setOnClickListener(new View.OnClickListener() { // from class: tb.gg2
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    StateNoNetworkView.m68lambda1$lambda0(StateNoNetworkView.this, view);
                }
            });
        }
        TextView textView2 = (TextView) inflate.findViewById(R$id.tv_report);
        if (textView2 != null) {
            textView2.setVisibility(8);
        }
        ImageView imageView = (ImageView) inflate.findViewById(R$id.iv_error_tip);
        if (imageView != null) {
            imageView.setImageResource(R$drawable.common_error_net);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: lambda-1$lambda-0  reason: not valid java name */
    public static final void m68lambda1$lambda0(StateNoNetworkView stateNoNetworkView, View view) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1483585253")) {
            ipChange.ipc$dispatch("-1483585253", new Object[]{stateNoNetworkView, view});
            return;
        }
        b41.i(stateNoNetworkView, "this$0");
        StateViewManager.IStateViewListener iStateViewListener = stateNoNetworkView.listener;
        if (iStateViewListener != null) {
            iStateViewListener.onRefreshClick();
        }
    }

    @Override // com.youku.arch.v3.page.state.IStateView
    @Nullable
    public View getContentView() {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "1263464708") ? (View) ipChange.ipc$dispatch("1263464708", new Object[]{this}) : this.contentView;
    }

    @Nullable
    public final StateViewManager.IStateViewListener getListener() {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "1554884870") ? (StateViewManager.IStateViewListener) ipChange.ipc$dispatch("1554884870", new Object[]{this}) : this.listener;
    }

    @Override // com.youku.arch.v3.page.state.IStateView
    public void setContentView(@Nullable View view) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "334503108")) {
            ipChange.ipc$dispatch("334503108", new Object[]{this, view});
        } else {
            this.contentView = view;
        }
    }

    public final void setListener(@Nullable StateViewManager.IStateViewListener iStateViewListener) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "778805904")) {
            ipChange.ipc$dispatch("778805904", new Object[]{this, iStateViewListener});
        } else {
            this.listener = iStateViewListener;
        }
    }

    @Override // com.youku.arch.v3.page.state.IStateView
    public void update(@Nullable String str, @Nullable String str2) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1534663669")) {
            ipChange.ipc$dispatch("1534663669", new Object[]{this, str, str2});
        }
    }
}
