package cn.damai.commonbusiness.seatbiz.sku.qilin.widget;

import android.content.Context;
import android.util.AttributeSet;
import androidx.core.widget.NestedScrollView;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;

/* compiled from: Taobao */
/* loaded from: classes.dex */
public class VerticalNestedScrollView extends NestedScrollView {
    private static transient /* synthetic */ IpChange $ipChange;
    private OnScrollListener onScrollListener;

    /* compiled from: Taobao */
    /* loaded from: classes.dex */
    public interface OnScrollListener {
        void onScroll(int i);
    }

    public VerticalNestedScrollView(Context context) {
        super(context);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // androidx.core.widget.NestedScrollView, android.view.View
    public void onScrollChanged(int i, int i2, int i3, int i4) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1171032013")) {
            ipChange.ipc$dispatch("1171032013", new Object[]{this, Integer.valueOf(i), Integer.valueOf(i2), Integer.valueOf(i3), Integer.valueOf(i4)});
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
        if (AndroidInstantRuntime.support(ipChange, "439259734")) {
            ipChange.ipc$dispatch("439259734", new Object[]{this, onScrollListener});
        } else {
            this.onScrollListener = onScrollListener;
        }
    }

    public VerticalNestedScrollView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }
}
