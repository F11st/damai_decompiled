package com.taobao.uikit.feature.view;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Rect;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ScrollView;
import com.taobao.uikit.feature.callback.CanvasCallback;
import com.taobao.uikit.feature.callback.FocusCallback;
import com.taobao.uikit.feature.callback.InterceptTouchEventCallback;
import com.taobao.uikit.feature.callback.LayoutCallback;
import com.taobao.uikit.feature.callback.MeasureCallback;
import com.taobao.uikit.feature.callback.ScrollCallback;
import com.taobao.uikit.feature.callback.SetClipToPaddingCallBack;
import com.taobao.uikit.feature.callback.TouchEventCallback;
import com.taobao.uikit.feature.features.AbsFeature;
import com.taobao.uikit.utils.FeatureList;
import com.taobao.uikit.utils.IFeatureList;
import java.util.ArrayList;
import java.util.List;

/* compiled from: Taobao */
/* loaded from: classes11.dex */
public class TScrollView extends ScrollView implements ViewHelper, ViewGroupHelper, IFeatureList<ScrollView> {
    private FeatureList<ScrollView> mFeatureList;
    private List<ViewGroup.OnHierarchyChangeListener> mOnHierarchyChangeListeners;
    private boolean mScrollable;

    public TScrollView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.mFeatureList = new FeatureList<>(this);
        this.mOnHierarchyChangeListeners = new ArrayList();
        this.mScrollable = true;
        this.mFeatureList.init(context, attributeSet, i);
        super.setOnHierarchyChangeListener(new ViewGroup.OnHierarchyChangeListener() { // from class: com.taobao.uikit.feature.view.TScrollView.1
            @Override // android.view.ViewGroup.OnHierarchyChangeListener
            public void onChildViewAdded(View view, View view2) {
                int size = TScrollView.this.mOnHierarchyChangeListeners.size();
                for (int i2 = 0; i2 < size; i2++) {
                    ((ViewGroup.OnHierarchyChangeListener) TScrollView.this.mOnHierarchyChangeListeners.get(i2)).onChildViewAdded(view, view2);
                }
            }

            @Override // android.view.ViewGroup.OnHierarchyChangeListener
            public void onChildViewRemoved(View view, View view2) {
                int size = TScrollView.this.mOnHierarchyChangeListeners.size();
                for (int i2 = 0; i2 < size; i2++) {
                    ((ViewGroup.OnHierarchyChangeListener) TScrollView.this.mOnHierarchyChangeListeners.get(i2)).onChildViewRemoved(view, view2);
                }
            }
        });
    }

    @Override // com.taobao.uikit.utils.IFeatureList
    public boolean addFeature(AbsFeature<? super ScrollView> absFeature) {
        return this.mFeatureList.addFeature(absFeature);
    }

    @Override // com.taobao.uikit.utils.IFeatureList
    public void clearFeatures() {
        this.mFeatureList.clearFeatures();
    }

    @Override // android.widget.ScrollView, android.view.View
    public void computeScroll() {
        int size = this.mFeatureList.size();
        for (int i = 0; i < size; i++) {
            AbsFeature absFeature = this.mFeatureList.get(i);
            if (absFeature instanceof ScrollCallback) {
                ((ScrollCallback) absFeature).beforeComputeScroll();
            }
        }
        super.computeScroll();
        for (int i2 = size - 1; i2 >= 0; i2--) {
            AbsFeature absFeature2 = this.mFeatureList.get(i2);
            if (absFeature2 instanceof ScrollCallback) {
                ((ScrollCallback) absFeature2).afterComputeScroll();
            }
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void dispatchDraw(Canvas canvas) {
        int size = this.mFeatureList.size();
        for (int i = 0; i < size; i++) {
            AbsFeature absFeature = this.mFeatureList.get(i);
            if (absFeature instanceof CanvasCallback) {
                ((CanvasCallback) absFeature).beforeDispatchDraw(canvas);
            }
        }
        super.dispatchDraw(canvas);
        for (int i2 = size - 1; i2 >= 0; i2--) {
            AbsFeature absFeature2 = this.mFeatureList.get(i2);
            if (absFeature2 instanceof CanvasCallback) {
                ((CanvasCallback) absFeature2).afterDispatchDraw(canvas);
            }
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    public boolean dispatchTouchEvent(MotionEvent motionEvent) {
        int size = this.mFeatureList.size();
        for (int i = 0; i < size; i++) {
            AbsFeature absFeature = this.mFeatureList.get(i);
            if (absFeature instanceof TouchEventCallback) {
                ((TouchEventCallback) absFeature).beforeDispatchTouchEvent(motionEvent);
            }
        }
        boolean dispatchTouchEvent = super.dispatchTouchEvent(motionEvent);
        for (int i2 = size - 1; i2 >= 0; i2--) {
            AbsFeature absFeature2 = this.mFeatureList.get(i2);
            if (absFeature2 instanceof TouchEventCallback) {
                ((TouchEventCallback) absFeature2).afterDispatchTouchEvent(motionEvent);
            }
        }
        return dispatchTouchEvent;
    }

    @Override // android.widget.ScrollView, android.view.View
    public void draw(Canvas canvas) {
        int size = this.mFeatureList.size();
        for (int i = 0; i < size; i++) {
            AbsFeature absFeature = this.mFeatureList.get(i);
            if (absFeature instanceof CanvasCallback) {
                ((CanvasCallback) absFeature).beforeDraw(canvas);
            }
        }
        super.draw(canvas);
        for (int i2 = size - 1; i2 >= 0; i2--) {
            AbsFeature absFeature2 = this.mFeatureList.get(i2);
            if (absFeature2 instanceof CanvasCallback) {
                ((CanvasCallback) absFeature2).afterDraw(canvas);
            }
        }
    }

    @Override // com.taobao.uikit.feature.view.ViewGroupHelper
    public boolean drawChild(Canvas canvas, View view, long j, int i) {
        return super.drawChild(canvas, view, j);
    }

    @Override // com.taobao.uikit.utils.IFeatureList
    public AbsFeature<? super ScrollView> findFeature(Class<? extends AbsFeature<? super ScrollView>> cls) {
        return this.mFeatureList.findFeature(cls);
    }

    @Override // com.taobao.uikit.utils.IFeatureList
    public void init(Context context, AttributeSet attributeSet, int i) {
        this.mFeatureList.init(context, attributeSet, i);
    }

    public boolean isScrollable() {
        return this.mScrollable;
    }

    @Override // com.taobao.uikit.feature.view.ViewGroupHelper
    public void measureChild(View view, int i, int i2, int i3) {
        super.measureChild(view, i, i2);
    }

    @Override // android.view.View
    protected void onDraw(Canvas canvas) {
        int size = this.mFeatureList.size();
        for (int i = 0; i < size; i++) {
            AbsFeature absFeature = this.mFeatureList.get(i);
            if (absFeature instanceof CanvasCallback) {
                ((CanvasCallback) absFeature).beforeOnDraw(canvas);
            }
        }
        super.onDraw(canvas);
        for (int i2 = size - 1; i2 >= 0; i2--) {
            AbsFeature absFeature2 = this.mFeatureList.get(i2);
            if (absFeature2 instanceof CanvasCallback) {
                ((CanvasCallback) absFeature2).afterOnDraw(canvas);
            }
        }
    }

    @Override // android.view.View
    protected void onFocusChanged(boolean z, int i, Rect rect) {
        int size = this.mFeatureList.size();
        for (int i2 = 0; i2 < size; i2++) {
            AbsFeature absFeature = this.mFeatureList.get(i2);
            if (absFeature instanceof FocusCallback) {
                ((FocusCallback) absFeature).beforeOnFocusChanged(z, i, rect);
            }
        }
        super.onFocusChanged(z, i, rect);
        for (int i3 = size - 1; i3 >= 0; i3--) {
            AbsFeature absFeature2 = this.mFeatureList.get(i3);
            if (absFeature2 instanceof FocusCallback) {
                ((FocusCallback) absFeature2).afterOnFocusChanged(z, i, rect);
            }
        }
    }

    @Override // android.widget.ScrollView, android.view.ViewGroup
    public boolean onInterceptTouchEvent(MotionEvent motionEvent) {
        boolean onInterceptTouchEvent = super.onInterceptTouchEvent(motionEvent);
        for (int size = this.mFeatureList.size() - 1; size >= 0; size--) {
            AbsFeature absFeature = this.mFeatureList.get(size);
            if (absFeature instanceof InterceptTouchEventCallback) {
                onInterceptTouchEvent |= ((InterceptTouchEventCallback) absFeature).onInterceptTouchEvent(motionEvent);
            }
        }
        return onInterceptTouchEvent;
    }

    @Override // android.widget.ScrollView, android.widget.FrameLayout, android.view.ViewGroup, android.view.View
    protected void onLayout(boolean z, int i, int i2, int i3, int i4) {
        int size = this.mFeatureList.size();
        for (int i5 = 0; i5 < size; i5++) {
            AbsFeature absFeature = this.mFeatureList.get(i5);
            if (absFeature instanceof LayoutCallback) {
                ((LayoutCallback) absFeature).beforeOnLayout(z, i, i2, i3, i4);
            }
        }
        super.onLayout(z, i, i2, i3, i4);
        for (int i6 = size - 1; i6 >= 0; i6--) {
            AbsFeature absFeature2 = this.mFeatureList.get(i6);
            if (absFeature2 instanceof LayoutCallback) {
                ((LayoutCallback) absFeature2).afterOnLayout(z, i, i2, i3, i4);
            }
        }
    }

    @Override // android.widget.ScrollView, android.widget.FrameLayout, android.view.View
    protected void onMeasure(int i, int i2) {
        int size = this.mFeatureList.size();
        for (int i3 = 0; i3 < size; i3++) {
            AbsFeature absFeature = this.mFeatureList.get(i3);
            if (absFeature instanceof MeasureCallback) {
                ((MeasureCallback) absFeature).beforeOnMeasure(i, i2);
            }
        }
        super.onMeasure(i, i2);
        for (int i4 = size - 1; i4 >= 0; i4--) {
            AbsFeature absFeature2 = this.mFeatureList.get(i4);
            if (absFeature2 instanceof MeasureCallback) {
                ((MeasureCallback) absFeature2).afterOnMeasure(i, i2);
            }
        }
    }

    @Override // android.view.View
    protected void onScrollChanged(int i, int i2, int i3, int i4) {
        int size = this.mFeatureList.size();
        for (int i5 = 0; i5 < size; i5++) {
            AbsFeature absFeature = this.mFeatureList.get(i5);
            if (absFeature instanceof ScrollCallback) {
                ((ScrollCallback) absFeature).beforeOnScrollChanged(i, i2, i3, i4);
            }
        }
        super.onScrollChanged(i, i2, i3, i4);
        for (int i6 = size - 1; i6 >= 0; i6--) {
            AbsFeature absFeature2 = this.mFeatureList.get(i6);
            if (absFeature2 instanceof ScrollCallback) {
                ((ScrollCallback) absFeature2).afterOnScrollChanged(i, i2, i3, i4);
            }
        }
    }

    @Override // android.widget.ScrollView, android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        int size = this.mFeatureList.size();
        for (int i = 0; i < size; i++) {
            AbsFeature absFeature = this.mFeatureList.get(i);
            if (absFeature instanceof TouchEventCallback) {
                ((TouchEventCallback) absFeature).beforeOnTouchEvent(motionEvent);
            }
        }
        boolean onTouchEvent = this.mScrollable ? super.onTouchEvent(motionEvent) : false;
        for (int i2 = size - 1; i2 >= 0; i2--) {
            AbsFeature absFeature2 = this.mFeatureList.get(i2);
            if (absFeature2 instanceof TouchEventCallback) {
                ((TouchEventCallback) absFeature2).afterOnTouchEvent(motionEvent);
            }
        }
        return onTouchEvent;
    }

    @Override // android.view.View
    public void onWindowFocusChanged(boolean z) {
        int size = this.mFeatureList.size();
        for (int i = 0; i < size; i++) {
            AbsFeature absFeature = this.mFeatureList.get(i);
            if (absFeature instanceof FocusCallback) {
                ((FocusCallback) absFeature).beforeOnWindowFocusChanged(z);
            }
        }
        super.onWindowFocusChanged(z);
        for (int i2 = size - 1; i2 >= 0; i2--) {
            AbsFeature absFeature2 = this.mFeatureList.get(i2);
            if (absFeature2 instanceof FocusCallback) {
                ((FocusCallback) absFeature2).afterOnWindowFocusChanged(z);
            }
        }
    }

    @Override // com.taobao.uikit.utils.IFeatureList
    public boolean removeFeature(Class<? extends AbsFeature<? super ScrollView>> cls) {
        return this.mFeatureList.removeFeature(cls);
    }

    @Override // android.view.ViewGroup
    public void setClipToPadding(boolean z) {
        FeatureList<ScrollView> featureList = this.mFeatureList;
        if (featureList == null) {
            super.setClipToPadding(z);
            return;
        }
        int size = featureList.size();
        for (int i = 0; i < size; i++) {
            AbsFeature absFeature = this.mFeatureList.get(i);
            if (absFeature instanceof SetClipToPaddingCallBack) {
                ((SetClipToPaddingCallBack) absFeature).beforeSetClipToPadding(z);
            }
        }
        super.setClipToPadding(z);
        for (int i2 = size - 1; i2 >= 0; i2--) {
            AbsFeature absFeature2 = this.mFeatureList.get(i2);
            if (absFeature2 instanceof SetClipToPaddingCallBack) {
                ((SetClipToPaddingCallBack) absFeature2).afterSetClipToPadding(z);
            }
        }
    }

    @Override // com.taobao.uikit.feature.view.ViewHelper
    public void setMeasuredDimension(long j, long j2) {
        super.setMeasuredDimension((int) j, (int) j2);
    }

    @Override // android.view.ViewGroup
    public void setOnHierarchyChangeListener(ViewGroup.OnHierarchyChangeListener onHierarchyChangeListener) {
        this.mOnHierarchyChangeListeners.add(onHierarchyChangeListener);
    }

    public void setScrollingEnabled(boolean z) {
        this.mScrollable = z;
    }

    public TScrollView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public TScrollView(Context context) {
        this(context, null);
    }
}
