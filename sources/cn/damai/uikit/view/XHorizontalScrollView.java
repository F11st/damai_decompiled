package cn.damai.uikit.view;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.HorizontalScrollView;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;

/* compiled from: Taobao */
/* loaded from: classes8.dex */
public class XHorizontalScrollView extends HorizontalScrollView {
    private static transient /* synthetic */ IpChange $ipChange;
    private OnScrollListener mListener;

    /* compiled from: Taobao */
    /* loaded from: classes8.dex */
    public interface OnScrollListener {
        void onScrollChanged(int i, int i2, int i3, int i4);
    }

    public XHorizontalScrollView(Context context) {
        super(context);
    }

    @Override // android.view.View
    protected void onScrollChanged(int i, int i2, int i3, int i4) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-670960839")) {
            ipChange.ipc$dispatch("-670960839", new Object[]{this, Integer.valueOf(i), Integer.valueOf(i2), Integer.valueOf(i3), Integer.valueOf(i4)});
            return;
        }
        super.onScrollChanged(i, i2, i3, i4);
        OnScrollListener onScrollListener = this.mListener;
        if (onScrollListener != null) {
            onScrollListener.onScrollChanged(i, i2, i3, i4);
        }
    }

    public void setListener(OnScrollListener onScrollListener) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1000550914")) {
            ipChange.ipc$dispatch("1000550914", new Object[]{this, onScrollListener});
        } else {
            this.mListener = onScrollListener;
        }
    }

    public XHorizontalScrollView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    public XHorizontalScrollView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
    }
}
