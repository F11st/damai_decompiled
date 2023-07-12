package cn.damai.baseview.pull.refresh;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.widget.LinearLayout;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;

/* compiled from: Taobao */
/* loaded from: classes.dex */
public class HeaderView extends LinearLayout {
    private static transient /* synthetic */ IpChange $ipChange;
    private View view;

    public HeaderView(Context context) {
        super(context);
        this.view = null;
    }

    @Override // android.view.ViewGroup
    public void addView(View view) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1847672483")) {
            ipChange.ipc$dispatch("-1847672483", new Object[]{this, view});
            return;
        }
        super.addView(view, new LinearLayout.LayoutParams(-1, -1));
        this.view = view;
    }

    public View getView() {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "353517890") ? (View) ipChange.ipc$dispatch("353517890", new Object[]{this}) : this.view;
    }

    public HeaderView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.view = null;
    }
}
