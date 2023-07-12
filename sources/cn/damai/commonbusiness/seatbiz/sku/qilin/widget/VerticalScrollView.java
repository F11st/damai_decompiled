package cn.damai.commonbusiness.seatbiz.sku.qilin.widget;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.ScrollView;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;

/* compiled from: Taobao */
/* loaded from: classes.dex */
public class VerticalScrollView extends ScrollView {
    private static transient /* synthetic */ IpChange $ipChange;
    private OnScrollListener onScrollListener;

    /* compiled from: Taobao */
    /* loaded from: classes.dex */
    public interface OnScrollListener {
        void onScroll(int i);
    }

    public VerticalScrollView(Context context) {
        super(context);
    }

    @Override // android.view.View
    protected void onScrollChanged(int i, int i2, int i3, int i4) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-994488828")) {
            ipChange.ipc$dispatch("-994488828", new Object[]{this, Integer.valueOf(i), Integer.valueOf(i2), Integer.valueOf(i3), Integer.valueOf(i4)});
            return;
        }
        super.onScrollChanged(i, i2, i3, i4);
        OnScrollListener onScrollListener = this.onScrollListener;
        if (onScrollListener != null) {
            onScrollListener.onScroll(i2);
        }
    }

    public void setOnScrollListener(OnScrollListener onScrollListener) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1864616650")) {
            ipChange.ipc$dispatch("-1864616650", new Object[]{this, onScrollListener});
        } else {
            this.onScrollListener = onScrollListener;
        }
    }

    public VerticalScrollView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }
}
