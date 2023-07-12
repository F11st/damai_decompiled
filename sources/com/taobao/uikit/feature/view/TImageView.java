package com.taobao.uikit.feature.view;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.widget.ImageView;
import com.taobao.uikit.feature.callback.CanvasCallback;
import com.taobao.uikit.feature.callback.FocusCallback;
import com.taobao.uikit.feature.callback.ImageCallback;
import com.taobao.uikit.feature.callback.ImageSaveCallback;
import com.taobao.uikit.feature.callback.LayoutCallback;
import com.taobao.uikit.feature.callback.MeasureCallback;
import com.taobao.uikit.feature.callback.ScrollCallback;
import com.taobao.uikit.feature.callback.TouchEventCallback;
import com.taobao.uikit.feature.features.AbsFeature;
import com.taobao.uikit.utils.FeatureList;
import com.taobao.uikit.utils.IFeatureList;

/* compiled from: Taobao */
/* loaded from: classes11.dex */
public class TImageView extends ImageView implements ViewHelper, IFeatureList<ImageView> {
    private FeatureList<ImageView> mFeatureList;

    public TImageView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        FeatureList<ImageView> featureList = new FeatureList<>(this);
        this.mFeatureList = featureList;
        featureList.init(context, attributeSet, i);
    }

    @Override // com.taobao.uikit.utils.IFeatureList
    public boolean addFeature(AbsFeature<? super ImageView> absFeature) {
        return this.mFeatureList.addFeature(absFeature);
    }

    @Override // com.taobao.uikit.utils.IFeatureList
    public void clearFeatures() {
        this.mFeatureList.clearFeatures();
    }

    @Override // android.view.View
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

    @Override // android.view.View
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

    @Override // android.view.View
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

    @Override // android.view.View
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

    @Override // com.taobao.uikit.utils.IFeatureList
    public AbsFeature<? super ImageView> findFeature(Class<? extends AbsFeature<? super ImageView>> cls) {
        return this.mFeatureList.findFeature(cls);
    }

    @Override // com.taobao.uikit.utils.IFeatureList
    public void init(Context context, AttributeSet attributeSet, int i) {
        this.mFeatureList.init(context, attributeSet, i);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.widget.ImageView, android.view.View
    public void onDraw(Canvas canvas) {
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

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.view.View
    public void onLayout(boolean z, int i, int i2, int i3, int i4) {
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

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.widget.ImageView, android.view.View
    public void onMeasure(int i, int i2) {
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
    public boolean onTouchEvent(MotionEvent motionEvent) {
        int size = this.mFeatureList.size();
        for (int i = 0; i < size; i++) {
            AbsFeature absFeature = this.mFeatureList.get(i);
            if (absFeature instanceof TouchEventCallback) {
                ((TouchEventCallback) absFeature).beforeOnTouchEvent(motionEvent);
            }
        }
        boolean onTouchEvent = super.onTouchEvent(motionEvent);
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

    @Override // android.view.View
    public boolean performLongClick() {
        int size = this.mFeatureList.size();
        for (int i = 0; i < size; i++) {
            AbsFeature absFeature = this.mFeatureList.get(i);
            if (absFeature instanceof ImageSaveCallback) {
                ((ImageSaveCallback) absFeature).beforePerformLongClick();
            }
        }
        boolean performLongClick = super.performLongClick();
        for (int i2 = size - 1; i2 >= 0; i2--) {
            AbsFeature absFeature2 = this.mFeatureList.get(i2);
            if (absFeature2 instanceof ImageSaveCallback) {
                ((ImageSaveCallback) absFeature2).afterPerformLongClick();
            }
        }
        return performLongClick;
    }

    @Override // com.taobao.uikit.utils.IFeatureList
    public boolean removeFeature(Class<? extends AbsFeature<? super ImageView>> cls) {
        return this.mFeatureList.removeFeature(cls);
    }

    @Override // android.widget.ImageView
    public void setImageDrawable(Drawable drawable) {
        FeatureList<ImageView> featureList = this.mFeatureList;
        if (featureList != null) {
            int size = featureList.size();
            for (int i = 0; i < size; i++) {
                if (this.mFeatureList.get(i) instanceof ImageCallback) {
                    drawable = ((ImageCallback) this.mFeatureList.get(i)).wrapImageDrawable(drawable);
                }
            }
        }
        super.setImageDrawable(drawable);
    }

    @Override // android.widget.ImageView
    public void setImageResource(int i) {
        Drawable drawable = getResources().getDrawable(i);
        FeatureList<ImageView> featureList = this.mFeatureList;
        if (featureList != null) {
            int size = featureList.size();
            for (int i2 = 0; i2 < size; i2++) {
                if (this.mFeatureList.get(i2) instanceof ImageCallback) {
                    drawable = ((ImageCallback) this.mFeatureList.get(i2)).wrapImageDrawable(drawable);
                }
            }
        }
        super.setImageDrawable(drawable);
    }

    @Override // com.taobao.uikit.feature.view.ViewHelper
    public void setMeasuredDimension(long j, long j2) {
        super.setMeasuredDimension((int) j, (int) j2);
    }

    public TImageView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public TImageView(Context context) {
        super(context);
        this.mFeatureList = new FeatureList<>(this);
    }
}
