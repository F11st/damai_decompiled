package com.youku.live.dago.widgetlib.interactive.gift.view;

import android.content.Context;
import android.util.AttributeSet;
import android.view.GestureDetector;
import android.view.MotionEvent;
import android.widget.FrameLayout;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;

/* compiled from: Taobao */
/* loaded from: classes2.dex */
public class TitleClickView extends FrameLayout {
    private static transient /* synthetic */ IpChange $ipChange;
    private GestureDetector gestureDetector;
    private DoubleSingleClickListener mDoubleSingleClickListener;

    /* compiled from: Taobao */
    /* loaded from: classes2.dex */
    public interface DoubleSingleClickListener {
        void onDoubleTap(MotionEvent motionEvent);

        void onSingleTapConfirmed(MotionEvent motionEvent);
    }

    public TitleClickView(Context context) {
        this(context, null);
    }

    public void setDoubleSingleClickListener(DoubleSingleClickListener doubleSingleClickListener) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1795536508")) {
            ipChange.ipc$dispatch("-1795536508", new Object[]{this, doubleSingleClickListener});
        } else {
            this.mDoubleSingleClickListener = doubleSingleClickListener;
        }
    }

    public TitleClickView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public TitleClickView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        setClickable(true);
    }
}
