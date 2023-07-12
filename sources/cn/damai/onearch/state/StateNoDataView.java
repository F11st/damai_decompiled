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
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import com.youku.arch.v3.page.state.IStateView;
import io.flutter.wpkbridge.WPKFactory;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import tb.b41;

/* compiled from: Taobao */
/* loaded from: classes6.dex */
public final class StateNoDataView extends RelativeLayout implements IStateView {
    private static transient /* synthetic */ IpChange $ipChange;
    @Nullable
    private View contentView;
    @Nullable
    private TextView des;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public StateNoDataView(@NotNull Context context) {
        super(context);
        b41.i(context, WPKFactory.INIT_KEY_CONTEXT);
        this.contentView = this;
        View inflate = LayoutInflater.from(context).inflate(R$layout.layout_cms_state_view, (ViewGroup) this, true);
        ImageView imageView = (ImageView) inflate.findViewById(R$id.iv_error_tip);
        if (imageView != null) {
            imageView.setImageResource(R$drawable.common_error_ticket_empty);
        }
        TextView textView = (TextView) inflate.findViewById(R$id.btn_refresh);
        if (textView != null) {
            textView.setVisibility(8);
        }
        TextView textView2 = (TextView) inflate.findViewById(R$id.tv_report);
        if (textView2 != null) {
            textView2.setVisibility(8);
        }
        TextView textView3 = (TextView) inflate.findViewById(R$id.tv_error_tip);
        if (textView3 != null) {
            textView3.setText("这里空空如也");
        } else {
            textView3 = null;
        }
        this.des = textView3;
    }

    @Override // com.youku.arch.v3.page.state.IStateView
    @Nullable
    public View getContentView() {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "2111780388") ? (View) ipChange.ipc$dispatch("2111780388", new Object[]{this}) : this.contentView;
    }

    @Override // com.youku.arch.v3.page.state.IStateView
    public void setContentView(@Nullable View view) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "862485412")) {
            ipChange.ipc$dispatch("862485412", new Object[]{this, view});
        } else {
            this.contentView = view;
        }
    }

    @Override // com.youku.arch.v3.page.state.IStateView
    public void update(@Nullable String str, @Nullable String str2) {
        TextView textView;
        IpChange ipChange = $ipChange;
        boolean z = true;
        if (AndroidInstantRuntime.support(ipChange, "-624068331")) {
            ipChange.ipc$dispatch("-624068331", new Object[]{this, str, str2});
            return;
        }
        if (str2 != null && str2.length() != 0) {
            z = false;
        }
        if (z || (textView = this.des) == null) {
            return;
        }
        textView.setText(str2);
    }
}
