package com.youku.live.dago.widgetlib.interactive.gift.star;

import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Bitmap;
import android.graphics.BitmapShader;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffXfermode;
import android.graphics.Rect;
import android.graphics.Shader;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.view.WindowManager;
import android.view.animation.LinearInterpolator;
import androidx.appcompat.widget.AppCompatImageView;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import com.youku.danmaku.engine.danmaku.model.android.DanmakuFactory;
import com.youku.live.dago.widgetlib.R;
import com.youku.live.dago.widgetlib.ailpbaselib.utils.AppContextUtils;
import com.youku.live.dago.widgetlib.interactive.utils.DensityUtil;
import java.util.ArrayList;
import tb.v;

/* compiled from: Taobao */
/* loaded from: classes2.dex */
public class LoadingImageView extends AppCompatImageView {
    private static transient /* synthetic */ IpChange $ipChange = null;
    private static final float DEFAULT_AMPLITUDE_RATIO = 0.05f;
    private static final float DEFAULT_WATER_LEVEL_RATIO = 0.5f;
    private static final float DEFAULT_WAVE_LENGTH_RATIO = 1.0f;
    private static final float DEFAULT_WAVE_SHIFT_RATIO = 0.0f;
    private Canvas bitmapCanvas;
    private float mAmplitudeRatio;
    private AnimatorSet mAnimatorSet;
    private Bitmap mBitmap;
    private Paint mBorderPaint;
    private float mDefaultAmplitude;
    private double mDefaultAngularFrequency;
    private float mDefaultWaterLevel;
    private int mDefaultWaveLength;
    private int mFrontProgressColor;
    private Paint mImagePaint;
    private float mOffsetX;
    private int mProgressColor;
    private Matrix mShaderMatrix;
    private final Bitmap mSrc;
    private Rect mSrcRect;
    private Paint mViewPaint;
    private float mWaterLevelRatio;
    private float mWaveLengthRatio;
    private BitmapShader mWaveShader;
    private float mWaveShiftRatio;
    private Rect rect;
    private WindowManager window;

    public LoadingImageView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.mAmplitudeRatio = DEFAULT_AMPLITUDE_RATIO;
        this.mWaveLengthRatio = 1.0f;
        this.mWaveShiftRatio = 0.0f;
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R.styleable.dago_little_star_imageview, 0, 0);
        BitmapDrawable bitmapDrawable = (BitmapDrawable) obtainStyledAttributes.getDrawable(R.styleable.dago_little_star_imageview_lf_star_src);
        if (bitmapDrawable != null) {
            bitmapDrawable.setAntiAlias(true);
        }
        this.mProgressColor = obtainStyledAttributes.getColor(R.styleable.dago_little_star_imageview_lf_star_backColor, Color.parseColor("#b2ffc805"));
        this.mFrontProgressColor = obtainStyledAttributes.getColor(R.styleable.dago_little_star_imageview_lf_star_frontColor, Color.parseColor("#80ffc805"));
        this.mSrc = drawableToBitamp(bitmapDrawable);
        obtainStyledAttributes.recycle();
        init();
    }

    private void createShader() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1805590476")) {
            ipChange.ipc$dispatch("1805590476", new Object[]{this});
            return;
        }
        this.mDefaultAngularFrequency = 6.283185307179586d / getWidth();
        this.mDefaultAmplitude = getHeight() * DEFAULT_AMPLITUDE_RATIO;
        this.mDefaultWaterLevel = getHeight() * 0.5f;
        this.mDefaultWaveLength = getHeight();
        Bitmap createBitmap = Bitmap.createBitmap(getWidth(), getHeight(), Bitmap.Config.ARGB_8888);
        Canvas canvas = new Canvas(createBitmap);
        Paint paint = new Paint();
        paint.setAntiAlias(true);
        int width = getWidth() + 1;
        int height = 1 + getHeight();
        float[] fArr = new float[width];
        paint.setColor(this.mProgressColor);
        for (int i = 0; i < width; i++) {
            float sin = (float) (this.mDefaultWaterLevel + (this.mDefaultAmplitude * Math.sin(i * this.mDefaultAngularFrequency)));
            float f = i;
            canvas.drawLine(f, sin, f, height, paint);
            fArr[i] = sin;
        }
        paint.setColor(this.mFrontProgressColor);
        int i2 = this.mDefaultWaveLength / 4;
        for (int i3 = 0; i3 < width; i3++) {
            float f2 = i3;
            canvas.drawLine(f2, fArr[(i3 + i2) % width], f2, height, paint);
        }
        BitmapShader bitmapShader = new BitmapShader(createBitmap, Shader.TileMode.REPEAT, Shader.TileMode.CLAMP);
        this.mWaveShader = bitmapShader;
        this.mViewPaint.setShader(bitmapShader);
    }

    private Bitmap drawableToBitamp(Drawable drawable) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-168677569")) {
            return (Bitmap) ipChange.ipc$dispatch("-168677569", new Object[]{this, drawable});
        }
        if (drawable == null) {
            return null;
        }
        int intrinsicWidth = drawable.getIntrinsicWidth();
        int intrinsicHeight = drawable.getIntrinsicHeight();
        Bitmap createBitmap = Bitmap.createBitmap(intrinsicWidth, intrinsicHeight, drawable.getOpacity() != -1 ? Bitmap.Config.ARGB_8888 : Bitmap.Config.RGB_565);
        Canvas canvas = new Canvas(createBitmap);
        drawable.setBounds(0, 0, intrinsicWidth, intrinsicHeight);
        drawable.draw(canvas);
        return createBitmap;
    }

    private void init() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1757791139")) {
            ipChange.ipc$dispatch("-1757791139", new Object[]{this});
            return;
        }
        this.window = (WindowManager) getContext().getSystemService(v.ATTACH_MODE_WINDOW);
        this.mShaderMatrix = new Matrix();
        this.mViewPaint = new Paint();
        this.mViewPaint.setXfermode(new PorterDuffXfermode(PorterDuff.Mode.SRC_ATOP));
        this.mViewPaint.setDither(true);
        this.mViewPaint.setFilterBitmap(true);
        this.mViewPaint.setAntiAlias(true);
        Paint paint = new Paint();
        this.mImagePaint = paint;
        paint.setDither(true);
        this.mImagePaint.setFilterBitmap(true);
        this.mImagePaint.setAntiAlias(true);
        Paint paint2 = new Paint();
        this.mBorderPaint = paint2;
        paint2.setDither(true);
        this.mBorderPaint.setFilterBitmap(true);
        this.mBorderPaint.setAntiAlias(true);
        this.mBorderPaint.setStyle(Paint.Style.STROKE);
        this.mBorderPaint.setStrokeWidth(0.0f);
        initAnimation();
    }

    private void initAnimation() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "300669353")) {
            ipChange.ipc$dispatch("300669353", new Object[]{this});
            return;
        }
        ArrayList arrayList = new ArrayList();
        ObjectAnimator ofFloat = ObjectAnimator.ofFloat(this, "waveShiftRatio", 0.0f, 1.0f);
        ofFloat.setRepeatCount(-1);
        ofFloat.setDuration(1000L);
        ofFloat.setInterpolator(new LinearInterpolator());
        arrayList.add(ofFloat);
        ObjectAnimator ofFloat2 = ObjectAnimator.ofFloat(this, "amplitudeRatio", 0.02f, DEFAULT_AMPLITUDE_RATIO);
        ofFloat2.setRepeatCount(-1);
        ofFloat2.setRepeatMode(2);
        ofFloat2.setDuration(DanmakuFactory.DEFAULT_DANMAKU_DURATION_V);
        ofFloat2.setInterpolator(new LinearInterpolator());
        arrayList.add(ofFloat2);
        AnimatorSet animatorSet = new AnimatorSet();
        this.mAnimatorSet = animatorSet;
        animatorSet.playTogether(arrayList);
    }

    @Override // android.widget.ImageView, android.view.View
    protected void onAttachedToWindow() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1923283297")) {
            ipChange.ipc$dispatch("-1923283297", new Object[]{this});
            return;
        }
        super.onAttachedToWindow();
        if (this.window == null) {
            this.window = (WindowManager) getContext().getSystemService(v.ATTACH_MODE_WINDOW);
        }
        this.mAnimatorSet.start();
    }

    @Override // android.widget.ImageView, android.view.View
    protected void onDetachedFromWindow() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1946104322")) {
            ipChange.ipc$dispatch("1946104322", new Object[]{this});
            return;
        }
        super.onDetachedFromWindow();
        this.mAnimatorSet.cancel();
    }

    @Override // android.widget.ImageView, android.view.View
    protected void onDraw(Canvas canvas) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1059023397")) {
            ipChange.ipc$dispatch("-1059023397", new Object[]{this, canvas});
            return;
        }
        super.onDraw(canvas);
        int rotation = this.window.getDefaultDisplay().getRotation();
        if (this.mBitmap == null) {
            this.mBitmap = Bitmap.createBitmap(getWidth(), getHeight(), Bitmap.Config.ARGB_4444);
            this.bitmapCanvas = new Canvas(this.mBitmap);
        }
        this.bitmapCanvas.drawBitmap(this.mSrc, this.mSrcRect, this.rect, this.mImagePaint);
        if (this.mWaveShader != null) {
            if (this.mViewPaint.getShader() == null) {
                this.mViewPaint.setShader(this.mWaveShader);
            }
            this.mShaderMatrix.setScale(this.mWaveLengthRatio / 1.0f, this.mAmplitudeRatio / DEFAULT_AMPLITUDE_RATIO, 0.0f, this.mDefaultWaterLevel);
            this.mShaderMatrix.postTranslate(this.mWaveShiftRatio * getWidth(), (0.5f - this.mWaterLevelRatio) * getHeight());
            this.mShaderMatrix.postRotate(rotation, getWidth() / 2.0f, getHeight() / 2.0f);
            this.mWaveShader.setLocalMatrix(this.mShaderMatrix);
            this.bitmapCanvas.drawRect(0.0f, 0.0f, getWidth() - 0.0f, getHeight() - 0.0f, this.mViewPaint);
        } else {
            this.mViewPaint.setShader(null);
        }
        canvas.drawBitmap(this.mBitmap, 0.0f, 0.0f, (Paint) null);
    }

    @Override // android.widget.ImageView, android.view.View
    protected void onMeasure(int i, int i2) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "47332478")) {
            ipChange.ipc$dispatch("47332478", new Object[]{this, Integer.valueOf(i), Integer.valueOf(i2)});
            return;
        }
        super.onMeasure(i, i2);
        setMeasuredDimension(i, i2);
    }

    @Override // android.view.View
    protected void onSizeChanged(int i, int i2, int i3, int i4) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "159483433")) {
            ipChange.ipc$dispatch("159483433", new Object[]{this, Integer.valueOf(i), Integer.valueOf(i2), Integer.valueOf(i3), Integer.valueOf(i4)});
            return;
        }
        super.onSizeChanged(i, i2, i3, i4);
        createShader();
        int dip2px = DensityUtil.dip2px(AppContextUtils.getApp(), 3.0f);
        int dip2px2 = DensityUtil.dip2px(AppContextUtils.getApp(), 1.0f);
        this.mSrcRect = new Rect(0, 0, this.mSrc.getWidth(), this.mSrc.getHeight());
        int width = (this.mSrc.getWidth() / 3) * 2;
        int height = (this.mSrc.getHeight() / 3) * 2;
        int width2 = (getWidth() - width) / 2;
        int height2 = (getHeight() - height) / 2;
        this.rect = new Rect(width2 - dip2px, height2 - dip2px2, width2 + width, height2 + height);
    }

    public void setAmplitudeRatio(float f) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-641866195")) {
            ipChange.ipc$dispatch("-641866195", new Object[]{this, Float.valueOf(f)});
            return;
        }
        this.mAmplitudeRatio = f;
        postInvalidate();
    }

    public void setOffsetX(float f) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1657225686")) {
            ipChange.ipc$dispatch("1657225686", new Object[]{this, Float.valueOf(f)});
        } else {
            this.mOffsetX = f;
        }
    }

    public void setWaterLevelRatio(float f) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "353562767")) {
            ipChange.ipc$dispatch("353562767", new Object[]{this, Float.valueOf(f)});
            return;
        }
        this.mWaterLevelRatio = f % 1.0f;
        postInvalidate();
    }

    public void setWaveShiftRatio(float f) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1363926119")) {
            ipChange.ipc$dispatch("1363926119", new Object[]{this, Float.valueOf(f)});
            return;
        }
        this.mWaveShiftRatio = f;
        postInvalidate();
    }
}
