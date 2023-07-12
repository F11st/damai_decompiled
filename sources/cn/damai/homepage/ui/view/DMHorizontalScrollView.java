package cn.damai.homepage.ui.view;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.HorizontalScrollView;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;

/* compiled from: Taobao */
/* loaded from: classes14.dex */
public class DMHorizontalScrollView extends HorizontalScrollView {
    private static transient /* synthetic */ IpChange $ipChange;
    private OnScrollChangeListener listener;

    /* compiled from: Taobao */
    /* loaded from: classes14.dex */
    public interface OnScrollChangeListener {
        void onScrollChanged(DMHorizontalScrollView dMHorizontalScrollView, int i, int i2, int i3, int i4);
    }

    public DMHorizontalScrollView(Context context) {
        super(context);
    }

    @Override // android.view.View
    protected void onScrollChanged(int i, int i2, int i3, int i4) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "868797593")) {
            ipChange.ipc$dispatch("868797593", new Object[]{this, Integer.valueOf(i), Integer.valueOf(i2), Integer.valueOf(i3), Integer.valueOf(i4)});
            return;
        }
        super.onScrollChanged(i, i2, i3, i4);
        OnScrollChangeListener onScrollChangeListener = this.listener;
        if (onScrollChangeListener != null) {
            onScrollChangeListener.onScrollChanged(this, i, i2, i3, i4);
        }
    }

    public void setOnScrollChangeListener(OnScrollChangeListener onScrollChangeListener) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "387434930")) {
            ipChange.ipc$dispatch("387434930", new Object[]{this, onScrollChangeListener});
        } else {
            this.listener = onScrollChangeListener;
        }
    }

    public DMHorizontalScrollView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    public DMHorizontalScrollView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
    }
}
