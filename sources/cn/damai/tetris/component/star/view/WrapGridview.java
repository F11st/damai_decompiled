package cn.damai.tetris.component.star.view;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.widget.GridView;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;

/* compiled from: Taobao */
/* loaded from: classes16.dex */
public class WrapGridview extends GridView {
    private static transient /* synthetic */ IpChange $ipChange;

    public WrapGridview(Context context) {
        super(context);
    }

    @Override // android.widget.GridView, android.widget.AbsListView, android.view.View
    protected void onMeasure(int i, int i2) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1055750151")) {
            ipChange.ipc$dispatch("1055750151", new Object[]{this, Integer.valueOf(i), Integer.valueOf(i2)});
        } else {
            super.onMeasure(i, View.MeasureSpec.makeMeasureSpec(536870911, Integer.MIN_VALUE));
        }
    }

    public WrapGridview(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    public WrapGridview(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
    }
}
