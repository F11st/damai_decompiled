package cn.damai.uikit.view;

import android.content.Context;
import android.graphics.Color;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.annotation.Nullable;
import cn.damai.uikit.R$id;
import cn.damai.uikit.R$layout;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import tb.ns;
import tb.q60;

/* compiled from: Taobao */
/* loaded from: classes8.dex */
public class DMActionButtonBgView extends LinearLayout {
    private static transient /* synthetic */ IpChange $ipChange;
    Context context;
    View partent;
    TextView submit_btn;

    public DMActionButtonBgView(Context context) {
        this(context, null);
    }

    private void initView() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-515432035")) {
            ipChange.ipc$dispatch("-515432035", new Object[]{this});
            return;
        }
        View inflate = LayoutInflater.from(this.context).inflate(R$layout.action_button_bg_layout, this);
        this.partent = inflate;
        this.submit_btn = (TextView) inflate.findViewById(R$id.submit_btn);
        setDefaultBackground();
    }

    private void setDefaultBackground() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "48799973")) {
            ipChange.ipc$dispatch("48799973", new Object[]{this});
        } else {
            ns.d(this.partent, new int[]{Color.parseColor("#FF7F81"), Color.parseColor("#FF2869")}, q60.a(this.context, 25.0f), Color.parseColor("#4bFF2D79"), q60.a(this.context, 2.0f), 0, q60.a(this.context, 2.0f));
        }
    }

    private void setUnsuedBackground() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "416931598")) {
            ipChange.ipc$dispatch("416931598", new Object[]{this});
        } else {
            ns.d(this.partent, new int[]{Color.parseColor("#66FF7F81"), Color.parseColor("#66FF2D79")}, q60.a(this.context, 25.0f), Color.parseColor("#1AFF2D79"), q60.a(this.context, 2.0f), 0, q60.a(this.context, 2.0f));
        }
    }

    public TextView getEventTv() {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "1389599360") ? (TextView) ipChange.ipc$dispatch("1389599360", new Object[]{this}) : this.submit_btn;
    }

    public void setBackground(boolean z) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1564253580")) {
            ipChange.ipc$dispatch("1564253580", new Object[]{this, Boolean.valueOf(z)});
        } else if (z) {
            setDefaultBackground();
        } else {
            setUnsuedBackground();
        }
    }

    public void update(String str, View.OnClickListener onClickListener) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-2036072858")) {
            ipChange.ipc$dispatch("-2036072858", new Object[]{this, str, onClickListener});
        } else if (TextUtils.isEmpty(str)) {
        } else {
            this.submit_btn.setText(str.trim());
            if (onClickListener != null) {
                this.submit_btn.setOnClickListener(onClickListener);
            }
        }
    }

    public DMActionButtonBgView(Context context, @Nullable AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public DMActionButtonBgView(Context context, @Nullable AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.context = context;
        setOrientation(1);
        initView();
    }

    public void update(String str) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "577684723")) {
            ipChange.ipc$dispatch("577684723", new Object[]{this, str});
        } else if (TextUtils.isEmpty(str)) {
        } else {
            this.submit_btn.setText(str.trim());
        }
    }

    public void update(String str, int i) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "728386672")) {
            ipChange.ipc$dispatch("728386672", new Object[]{this, str, Integer.valueOf(i)});
        } else if (TextUtils.isEmpty(str)) {
        } else {
            this.submit_btn.setText(str.trim());
            this.submit_btn.setTextSize(1, i);
        }
    }
}
