package com.taobao.android.dinamicx.widget.recycler;

import android.content.Context;
import android.graphics.Canvas;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import androidx.annotation.NonNull;
import tb.ry;

/* compiled from: Taobao */
/* loaded from: classes12.dex */
public class StickyLayout extends FrameLayout {
    private IEleSectionHeightListener mHeightListener;
    private ViewGroup mOuterRecyclerView;

    public StickyLayout(@NonNull Context context) {
        super(context);
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void dispatchDraw(Canvas canvas) {
    }

    @Override // android.view.ViewGroup, android.view.ViewParent
    public void onDescendantInvalidated(@NonNull View view, @NonNull View view2) {
        super.onDescendantInvalidated(view, view2);
        ViewGroup viewGroup = this.mOuterRecyclerView;
        if (viewGroup != null) {
            viewGroup.invalidate();
        }
    }

    @Override // android.view.ViewGroup
    public boolean onInterceptTouchEvent(MotionEvent motionEvent) {
        try {
            ViewGroup viewGroup = this.mOuterRecyclerView;
            if (viewGroup != null) {
                if (viewGroup.onInterceptTouchEvent(motionEvent)) {
                    return true;
                }
            }
            return false;
        } catch (Throwable th) {
            ry.b(th);
            return super.onInterceptTouchEvent(motionEvent);
        }
    }

    @Override // android.widget.FrameLayout, android.view.ViewGroup, android.view.View
    protected void onLayout(boolean z, int i, int i2, int i3, int i4) {
        for (int i5 = 0; i5 < getChildCount(); i5++) {
            View childAt = getChildAt(i5);
            if (childAt.isLayoutRequested()) {
                childAt.layout(childAt.getLeft(), childAt.getTop(), childAt.getLeft() + childAt.getMeasuredWidth(), childAt.getTop() + childAt.getMeasuredHeight());
            }
        }
    }

    @Override // android.widget.FrameLayout, android.view.View
    protected void onMeasure(int i, int i2) {
        IEleSectionHeightListener iEleSectionHeightListener;
        boolean z = false;
        for (int i3 = 0; i3 < getChildCount(); i3++) {
            View childAt = getChildAt(i3);
            int measuredHeight = childAt.getMeasuredHeight();
            childAt.measure(i, View.MeasureSpec.makeMeasureSpec(0, 0));
            if (measuredHeight != childAt.getMeasuredHeight()) {
                z = true;
            }
        }
        setMeasuredDimension(View.MeasureSpec.getSize(i), View.MeasureSpec.getSize(i2));
        if (!z || (iEleSectionHeightListener = this.mHeightListener) == null) {
            return;
        }
        iEleSectionHeightListener.onSectionHeightUpdated();
    }

    @Override // android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        try {
            ViewGroup viewGroup = this.mOuterRecyclerView;
            if (viewGroup != null) {
                if (viewGroup.dispatchTouchEvent(motionEvent)) {
                    return true;
                }
            }
            return false;
        } catch (Throwable th) {
            ry.b(th);
            return super.onTouchEvent(motionEvent);
        }
    }

    public void setHeightUpdateListener(IEleSectionHeightListener iEleSectionHeightListener) {
        this.mHeightListener = iEleSectionHeightListener;
    }

    public void setRecyclerView(ViewGroup viewGroup) {
        this.mOuterRecyclerView = viewGroup;
    }
}
