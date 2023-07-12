package cn.damai.homepage.ui.view;

import android.content.Context;
import android.graphics.Canvas;
import android.util.AttributeSet;
import com.airbnb.lottie.LottieAnimationView;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;

/* compiled from: Taobao */
/* loaded from: classes5.dex */
public class SafeLottieAnimationView extends LottieAnimationView {
    private static transient /* synthetic */ IpChange $ipChange;
    private int failCount;
    private OnLottieDrawFailListener mListener;

    /* compiled from: Taobao */
    /* loaded from: classes14.dex */
    public interface OnLottieDrawFailListener {
        void onDrawLottieFail(Throwable th, int i);
    }

    public SafeLottieAnimationView(Context context) {
        super(context);
        this.failCount = 0;
    }

    @Override // android.widget.ImageView, android.view.View
    protected void onDraw(Canvas canvas) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-85210461")) {
            ipChange.ipc$dispatch("-85210461", new Object[]{this, canvas});
            return;
        }
        try {
            super.onDraw(canvas);
        } catch (Exception e) {
            this.failCount++;
            if (this.mListener != null) {
                this.mListener.onDrawLottieFail(e, this.failCount);
            }
        }
    }

    public void setListener(OnLottieDrawFailListener onLottieDrawFailListener) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1530184818")) {
            ipChange.ipc$dispatch("-1530184818", new Object[]{this, onLottieDrawFailListener});
        } else {
            this.mListener = onLottieDrawFailListener;
        }
    }

    public SafeLottieAnimationView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.failCount = 0;
    }

    public SafeLottieAnimationView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.failCount = 0;
    }
}
