package cn.damai.trade.oldtradeorder.ui.orderdetail.detail.helper;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.widget.ListView;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;

/* compiled from: Taobao */
/* loaded from: classes16.dex */
public class MainListView extends ListView {
    private static transient /* synthetic */ IpChange $ipChange;

    public MainListView(Context context) {
        super(context);
    }

    @Override // android.widget.ListView, android.widget.AbsListView, android.view.View
    protected void onMeasure(int i, int i2) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-528068464")) {
            ipChange.ipc$dispatch("-528068464", new Object[]{this, Integer.valueOf(i), Integer.valueOf(i2)});
        } else {
            super.onMeasure(i, View.MeasureSpec.makeMeasureSpec(536870911, Integer.MIN_VALUE));
        }
    }

    public MainListView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    public MainListView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
    }
}
