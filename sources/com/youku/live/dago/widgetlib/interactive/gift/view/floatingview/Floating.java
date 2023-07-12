package com.youku.live.dago.widgetlib.interactive.gift.view.floatingview;

import android.content.Context;
import android.graphics.Rect;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import com.youku.live.dago.widgetlib.interactive.gift.view.floatingview.transition.YumFloating;
import tb.pa1;

/* compiled from: Taobao */
/* loaded from: classes2.dex */
public class Floating {
    private static transient /* synthetic */ IpChange $ipChange;
    private ViewGroup mFloatingDecorView;

    /* compiled from: Taobao */
    /* loaded from: classes2.dex */
    public static class FloatingDecorView extends FrameLayout {
        public FloatingDecorView(Context context) {
            this(context, null);
        }

        public FloatingDecorView(Context context, AttributeSet attributeSet) {
            this(context, attributeSet, 0);
        }

        public FloatingDecorView(Context context, AttributeSet attributeSet, int i) {
            super(context, attributeSet, i);
        }
    }

    public Floating(Context context) {
    }

    public void setFloatingDecorView(ViewGroup viewGroup) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-356761885")) {
            ipChange.ipc$dispatch("-356761885", new Object[]{this, viewGroup});
        } else {
            this.mFloatingDecorView = viewGroup;
        }
    }

    public void startFloating(FloatingElement floatingElement) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "2096977688")) {
            ipChange.ipc$dispatch("2096977688", new Object[]{this, floatingElement});
            return;
        }
        View view = floatingElement.anchorView;
        View view2 = floatingElement.targetView;
        if (view2 == null) {
            view2 = LayoutInflater.from(view.getContext()).inflate(floatingElement.targetViewLayoutResId, this.mFloatingDecorView, false);
        }
        Rect rect = new Rect();
        view.getGlobalVisibleRect(rect);
        int[] iArr = new int[2];
        this.mFloatingDecorView.getLocationOnScreen(iArr);
        rect.offset(-iArr[0], -iArr[1]);
        view2.measure(View.MeasureSpec.makeMeasureSpec(pa1.MAX_CAPACITY_MASK, Integer.MIN_VALUE), View.MeasureSpec.makeMeasureSpec(pa1.MAX_CAPACITY_MASK, Integer.MIN_VALUE));
        int measuredHeight = rect.top + ((view.getMeasuredHeight() - view2.getMeasuredHeight()) / 2) + floatingElement.offsetY;
        int measuredWidth = rect.left + ((view.getMeasuredWidth() - view2.getMeasuredWidth()) / 2) + floatingElement.offsetX;
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-2, -2);
        layoutParams.topMargin = measuredHeight;
        layoutParams.leftMargin = measuredWidth;
        this.mFloatingDecorView.addView(view2, layoutParams);
        floatingElement.floatingTransition.applyFloating(new YumFloating(view2));
    }
}
