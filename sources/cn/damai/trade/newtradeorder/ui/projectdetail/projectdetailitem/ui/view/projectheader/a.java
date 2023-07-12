package cn.damai.trade.newtradeorder.ui.projectdetail.projectdetailitem.ui.view.projectheader;

import android.app.Activity;
import android.text.TextUtils;
import android.view.View;
import android.widget.TextView;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;

/* compiled from: Taobao */
/* loaded from: classes16.dex */
public abstract class a {
    private static transient /* synthetic */ IpChange $ipChange;
    protected Activity a;
    protected long b;
    protected View c;
    protected OnHeadClickListener d;

    public a(Activity activity, long j, View view, OnHeadClickListener onHeadClickListener) {
        this.a = activity;
        this.c = view.findViewById(a());
        this.d = onHeadClickListener;
        this.b = j;
    }

    public abstract int a();

    public String b(int i) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1661541188")) {
            return (String) ipChange.ipc$dispatch("-1661541188", new Object[]{this, Integer.valueOf(i)});
        }
        Activity activity = this.a;
        if (activity != null) {
            return activity.getString(i);
        }
        return null;
    }

    public void c(TextView textView, String str) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-2066781893")) {
            ipChange.ipc$dispatch("-2066781893", new Object[]{this, textView, str});
        } else if (TextUtils.isEmpty(str)) {
            textView.setVisibility(8);
        } else {
            textView.setVisibility(0);
            textView.setText(str);
        }
    }
}
