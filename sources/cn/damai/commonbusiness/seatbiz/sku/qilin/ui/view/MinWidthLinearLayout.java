package cn.damai.commonbusiness.seatbiz.sku.qilin.ui.view;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.LinearLayout;
import androidx.annotation.Nullable;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;

/* compiled from: Taobao */
/* loaded from: classes.dex */
public class MinWidthLinearLayout extends LinearLayout {
    private static transient /* synthetic */ IpChange $ipChange;
    private boolean isAttached;
    private int mMinWidth;

    public MinWidthLinearLayout(Context context) {
        super(context);
        this.isAttached = false;
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onAttachedToWindow() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-451454805")) {
            ipChange.ipc$dispatch("-451454805", new Object[]{this});
            return;
        }
        super.onAttachedToWindow();
        this.isAttached = true;
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onDetachedFromWindow() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-965922546")) {
            ipChange.ipc$dispatch("-965922546", new Object[]{this});
            return;
        }
        super.onDetachedFromWindow();
        this.isAttached = false;
    }

    @Override // android.widget.LinearLayout, android.view.View
    protected void onMeasure(int i, int i2) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1062019086")) {
            ipChange.ipc$dispatch("-1062019086", new Object[]{this, Integer.valueOf(i), Integer.valueOf(i2)});
            return;
        }
        super.onMeasure(i, i2);
        int measuredWidth = getMeasuredWidth();
        int i3 = this.mMinWidth;
        if (measuredWidth < i3) {
            setMeasuredDimension(i3, getMeasuredHeight());
        }
    }

    public void setMinWidth(int i) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1831839928")) {
            ipChange.ipc$dispatch("-1831839928", new Object[]{this, Integer.valueOf(i)});
            return;
        }
        this.mMinWidth = i;
        if (this.isAttached) {
            requestLayout();
        }
    }

    public MinWidthLinearLayout(Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet);
        this.isAttached = false;
    }

    public MinWidthLinearLayout(Context context, @Nullable AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.isAttached = false;
    }
}
