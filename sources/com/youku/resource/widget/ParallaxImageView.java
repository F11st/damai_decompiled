package com.youku.resource.widget;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Bitmap;
import android.graphics.Matrix;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.util.AttributeSet;
import android.widget.ImageView;
import com.youku.resource.R;

/* compiled from: Taobao */
/* loaded from: classes3.dex */
public class ParallaxImageView extends YKImageView {
    private boolean DEFAULT_CENTER_CROP;
    private final float DEFAULT_PARALLAX_RATIO;
    private ParallaxImageListener listener;
    private boolean needToTranslate;
    private float parallaxRatio;
    private int recyclerViewHeight;
    private int recyclerViewYPos;
    private int rowHeight;
    private int rowYPos;
    private boolean shouldCenterCrop;

    /* compiled from: Taobao */
    /* loaded from: classes3.dex */
    public interface ParallaxImageListener {
        int[] requireValuesForTranslate();
    }

    public ParallaxImageView(Context context) {
        super(context);
        this.DEFAULT_PARALLAX_RATIO = 1.0f;
        this.parallaxRatio = 1.0f;
        this.DEFAULT_CENTER_CROP = true;
        this.shouldCenterCrop = true;
        this.needToTranslate = true;
        this.rowHeight = -1;
        this.rowYPos = -1;
        this.recyclerViewHeight = -1;
        this.recyclerViewYPos = -1;
        init(context, null);
    }

    private void calculateAndMove() {
        float f;
        float f2 = ((this.recyclerViewYPos + this.recyclerViewHeight) / 2) - this.rowYPos;
        int intrinsicHeight = getDrawable().getIntrinsicHeight();
        if (this.shouldCenterCrop) {
            f = recomputeImageMatrix();
            intrinsicHeight = (int) (intrinsicHeight * f);
        } else {
            f = 1.0f;
        }
        float f3 = intrinsicHeight - this.rowHeight;
        moveTo(((((f2 / this.recyclerViewHeight) * f3) * this.parallaxRatio) / 2.0f) - (f3 / 2.0f), f);
    }

    private boolean ensureTranslate() {
        if (this.needToTranslate) {
            this.needToTranslate = !doTranslate();
        }
        return !this.needToTranslate;
    }

    private boolean getValues() {
        int[] requireValuesForTranslate = getListener().requireValuesForTranslate();
        if (requireValuesForTranslate == null) {
            return false;
        }
        this.rowHeight = requireValuesForTranslate[0];
        this.rowYPos = requireValuesForTranslate[1];
        this.recyclerViewHeight = requireValuesForTranslate[2];
        this.recyclerViewYPos = requireValuesForTranslate[3];
        return true;
    }

    private void init(Context context, AttributeSet attributeSet) {
        setScaleType(ImageView.ScaleType.MATRIX);
        if (attributeSet != null) {
            TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R.styleable.ParallaxImageView, 0, 0);
            this.parallaxRatio = obtainStyledAttributes.getFloat(R.styleable.ParallaxImageView_parallax_ratio, 1.0f);
            this.shouldCenterCrop = obtainStyledAttributes.getBoolean(R.styleable.ParallaxImageView_center_crop, this.DEFAULT_CENTER_CROP);
            obtainStyledAttributes.recycle();
        }
    }

    private void moveTo(float f, float f2) {
        Matrix imageMatrix = getImageMatrix();
        if (f2 != 1.0f) {
            imageMatrix.setScale(f2, f2);
        }
        float[] fArr = new float[9];
        imageMatrix.getValues(fArr);
        imageMatrix.postTranslate(0.0f, f - fArr[5]);
        setImageMatrix(imageMatrix);
        invalidate();
    }

    private float recomputeImageMatrix() {
        float f;
        float f2;
        int width = (getWidth() - getPaddingLeft()) - getPaddingRight();
        int height = (getHeight() - getPaddingTop()) - getPaddingBottom();
        int intrinsicWidth = getDrawable().getIntrinsicWidth();
        int intrinsicHeight = getDrawable().getIntrinsicHeight();
        if (intrinsicWidth * height > intrinsicHeight * width) {
            f = height;
            f2 = intrinsicHeight;
        } else {
            f = width;
            f2 = intrinsicWidth;
        }
        return f / f2;
    }

    public void centerCrop(boolean z) {
        this.shouldCenterCrop = z;
    }

    public synchronized boolean doTranslate() {
        if (getDrawable() == null) {
            return false;
        }
        if (getListener() == null || !getValues()) {
            return false;
        }
        calculateAndMove();
        return true;
    }

    public ParallaxImageListener getListener() {
        return this.listener;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.taobao.uikit.feature.view.TImageView, android.view.View
    public void onLayout(boolean z, int i, int i2, int i3, int i4) {
        super.onLayout(z, i, i2, i3, i4);
        ensureTranslate();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.youku.resource.widget.YKImageView, com.youku.resource.widget.YKRatioImageView, com.taobao.uikit.feature.view.TImageView, android.widget.ImageView, android.view.View
    public void onMeasure(int i, int i2) {
        super.onMeasure(i, i2);
        ensureTranslate();
    }

    public void reuse() {
        this.needToTranslate = true;
    }

    @Override // android.widget.ImageView
    public void setImageBitmap(Bitmap bitmap) {
        super.setImageBitmap(bitmap);
        ensureTranslate();
    }

    @Override // com.youku.resource.widget.YKImageView, com.youku.resource.widget.YKRatioImageView, com.taobao.uikit.extend.feature.view.TUrlImageView, com.taobao.uikit.feature.view.TImageView, android.widget.ImageView
    public void setImageDrawable(Drawable drawable) {
        super.setImageDrawable(drawable);
        ensureTranslate();
    }

    @Override // com.youku.resource.widget.YKImageView, com.taobao.uikit.feature.view.TImageView, android.widget.ImageView
    public void setImageResource(int i) {
        super.setImageResource(i);
        ensureTranslate();
    }

    @Override // android.widget.ImageView
    public void setImageURI(Uri uri) {
        super.setImageURI(uri);
        ensureTranslate();
    }

    public void setListener(ParallaxImageListener parallaxImageListener) {
        this.listener = parallaxImageListener;
    }

    public void setParallaxRatio(float f) {
        this.parallaxRatio = f;
    }

    public ParallaxImageView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.DEFAULT_PARALLAX_RATIO = 1.0f;
        this.parallaxRatio = 1.0f;
        this.DEFAULT_CENTER_CROP = true;
        this.shouldCenterCrop = true;
        this.needToTranslate = true;
        this.rowHeight = -1;
        this.rowYPos = -1;
        this.recyclerViewHeight = -1;
        this.recyclerViewYPos = -1;
        init(context, attributeSet);
    }
}
