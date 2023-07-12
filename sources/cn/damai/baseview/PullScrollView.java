package cn.damai.baseview;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.ScrollView;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import tb.q60;

/* compiled from: Taobao */
/* loaded from: classes.dex */
public class PullScrollView extends ScrollView {
    private static transient /* synthetic */ IpChange $ipChange;
    private OnScrollListener onScrollListener;

    /* compiled from: Taobao */
    /* loaded from: classes.dex */
    public interface OnScrollListener {
        void isScrollIng(int i);

        void onScroll(PullScrollView pullScrollView);
    }

    public PullScrollView(Context context) {
        this(context, null);
    }

    @Override // android.widget.ScrollView, android.view.View
    public int computeVerticalScrollRange() {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "-501763238") ? ((Integer) ipChange.ipc$dispatch("-501763238", new Object[]{this})).intValue() : super.computeVerticalScrollRange();
    }

    @Override // android.view.View
    protected void onScrollChanged(int i, int i2, int i3, int i4) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "433961112")) {
            ipChange.ipc$dispatch("433961112", new Object[]{this, Integer.valueOf(i), Integer.valueOf(i2), Integer.valueOf(i3), Integer.valueOf(i4)});
            return;
        }
        super.onScrollChanged(i, i2, i3, i4);
        OnScrollListener onScrollListener = this.onScrollListener;
        if (onScrollListener != null) {
            onScrollListener.isScrollIng(q60.d(getContext(), getScrollY()));
            if (getHeight() + getScrollY() >= computeVerticalScrollRange()) {
                this.onScrollListener.onScroll(this);
            }
        }
    }

    public void setOnScrollListener(OnScrollListener onScrollListener) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-930840076")) {
            ipChange.ipc$dispatch("-930840076", new Object[]{this, onScrollListener});
        } else {
            this.onScrollListener = onScrollListener;
        }
    }

    public PullScrollView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public PullScrollView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
    }
}
