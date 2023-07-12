package cn.damai.uikit.pulltorefresh.library;

import android.content.Context;
import android.os.Parcelable;
import android.util.AttributeSet;
import android.widget.ScrollView;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;

/* compiled from: Taobao */
/* loaded from: classes8.dex */
public class DMScrollerView extends ScrollView {
    private static transient /* synthetic */ IpChange $ipChange;
    private OnScrollListener onScrollListener;

    /* compiled from: Taobao */
    /* loaded from: classes8.dex */
    public interface OnScrollListener {
        void onScroll(int i, int i2, int i3, int i4);
    }

    public DMScrollerView(Context context) {
        super(context);
    }

    @Override // android.widget.ScrollView, android.view.View
    protected void onRestoreInstanceState(Parcelable parcelable) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1188142773")) {
            ipChange.ipc$dispatch("-1188142773", new Object[]{this, parcelable});
            return;
        }
        try {
            super.onRestoreInstanceState(parcelable);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override // android.view.View
    protected void onScrollChanged(int i, int i2, int i3, int i4) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1141709715")) {
            ipChange.ipc$dispatch("-1141709715", new Object[]{this, Integer.valueOf(i), Integer.valueOf(i2), Integer.valueOf(i3), Integer.valueOf(i4)});
            return;
        }
        super.onScrollChanged(i, i2, i3, i4);
        OnScrollListener onScrollListener = this.onScrollListener;
        if (onScrollListener != null) {
            onScrollListener.onScroll(i, i2, i3, i4);
        }
    }

    public void setOnScrollListener(OnScrollListener onScrollListener) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-279709994")) {
            ipChange.ipc$dispatch("-279709994", new Object[]{this, onScrollListener});
        } else {
            this.onScrollListener = onScrollListener;
        }
    }

    public DMScrollerView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    public DMScrollerView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
    }
}
