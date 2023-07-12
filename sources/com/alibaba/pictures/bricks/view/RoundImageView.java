package com.alibaba.pictures.bricks.view;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Bitmap;
import android.graphics.BitmapShader;
import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.Shader;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.GradientDrawable;
import android.os.Bundle;
import android.os.Parcelable;
import android.util.AttributeSet;
import android.util.Log;
import android.util.TypedValue;
import android.widget.ImageView;
import com.alibaba.pictures.R$styleable;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import com.taobao.phenix.animate.AnimatedImageDrawable;
import tb.s60;

/* compiled from: Taobao */
/* loaded from: classes7.dex */
public class RoundImageView extends ImageView {
    private static transient /* synthetic */ IpChange $ipChange = null;
    private static final int BODER_RADIUS_DEFAULT = 10;
    private static final String STATE_BORDER_RADIUS = "state_border_radius";
    private static final String STATE_INSTANCE = "state_instance";
    private static final String STATE_TYPE = "state_type";
    public static final int TYPE_CIRCLE = 0;
    public static final int TYPE_ROUND = 1;
    private boolean isGifRoundCornerSupport;
    private Paint mBitmapPaint;
    private BitmapShader mBitmapShader;
    private Paint mBorderPaint;
    private int mBorderRadius;
    private int mBorderWidth;
    private boolean mClipLeftBottomRadius;
    private boolean mClipLeftTopRadius;
    private boolean mClipRightBottomRadius;
    private boolean mClipRightTopRadius;
    private Path mGifClipPath;
    private RectF mGifClipRectF;
    private Matrix mMatrix;
    private int mRadius;
    private RectF mRoundRect;
    private int mWidth;
    private int type;

    public RoundImageView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.mGifClipPath = new Path();
        this.mGifClipRectF = new RectF();
        this.mMatrix = new Matrix();
        Paint paint = new Paint();
        this.mBitmapPaint = paint;
        paint.setAntiAlias(true);
        Paint paint2 = new Paint();
        this.mBorderPaint = paint2;
        paint2.setStyle(Paint.Style.STROKE);
        this.mBorderPaint.setAntiAlias(true);
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R$styleable.BricksRoundImageView);
        this.mBorderRadius = obtainStyledAttributes.getDimensionPixelSize(R$styleable.BricksRoundImageView_borderRadius, (int) TypedValue.applyDimension(1, 10.0f, getResources().getDisplayMetrics()));
        this.mClipLeftTopRadius = obtainStyledAttributes.getBoolean(R$styleable.BricksRoundImageView_clipLeftTopRadius, false);
        this.mClipRightTopRadius = obtainStyledAttributes.getBoolean(R$styleable.BricksRoundImageView_clipRightTopRadius, false);
        this.mClipLeftBottomRadius = obtainStyledAttributes.getBoolean(R$styleable.BricksRoundImageView_clipLeftBottomRadius, false);
        this.mClipRightBottomRadius = obtainStyledAttributes.getBoolean(R$styleable.BricksRoundImageView_clipRightBottomRadius, false);
        this.type = obtainStyledAttributes.getInt(R$styleable.BricksRoundImageView_type, 0);
        this.isGifRoundCornerSupport = obtainStyledAttributes.getBoolean(R$styleable.BricksRoundImageView_supportGifRoundCorner, false);
        obtainStyledAttributes.recycle();
    }

    private void clipBottomLeft(Canvas canvas) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1889437774")) {
            ipChange.ipc$dispatch("-1889437774", new Object[]{this, canvas});
            return;
        }
        float f = this.mRoundRect.bottom;
        int i = this.mBorderRadius;
        canvas.drawRect(new Rect(0, ((int) f) - i, i, (int) f), this.mBitmapPaint);
    }

    private void clipBottomRight(Canvas canvas) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1131892111")) {
            ipChange.ipc$dispatch("-1131892111", new Object[]{this, canvas});
            return;
        }
        RectF rectF = this.mRoundRect;
        float f = rectF.right;
        int i = this.mBorderRadius;
        float f2 = rectF.bottom;
        canvas.drawRect(new Rect(((int) f) - i, ((int) f2) - i, (int) f, (int) f2), this.mBitmapPaint);
    }

    private void clipTopLeft(Canvas canvas) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1145783356")) {
            ipChange.ipc$dispatch("1145783356", new Object[]{this, canvas});
            return;
        }
        int i = this.mBorderRadius;
        canvas.drawRect(new Rect(0, 0, i, i), this.mBitmapPaint);
    }

    private void clipTopRight(Canvas canvas) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1529317593")) {
            ipChange.ipc$dispatch("-1529317593", new Object[]{this, canvas});
            return;
        }
        float f = this.mRoundRect.right;
        int i = this.mBorderRadius;
        canvas.drawRect(new Rect(((int) f) - i, 0, (int) f, i), this.mBitmapPaint);
    }

    private Bitmap drawableToBitamp(Drawable drawable) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1608876953")) {
            return (Bitmap) ipChange.ipc$dispatch("-1608876953", new Object[]{this, drawable});
        }
        if (drawable instanceof BitmapDrawable) {
            return ((BitmapDrawable) drawable).getBitmap();
        }
        int intrinsicWidth = drawable.getIntrinsicWidth();
        int intrinsicHeight = drawable.getIntrinsicHeight();
        Bitmap createBitmap = Bitmap.createBitmap(getWidth(), getHeight(), Bitmap.Config.ARGB_8888);
        Canvas canvas = new Canvas(createBitmap);
        drawable.setBounds(0, 0, intrinsicWidth, intrinsicHeight);
        drawable.draw(canvas);
        return createBitmap;
    }

    private void setUpShader() {
        Bitmap drawableToBitamp;
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-367866317")) {
            ipChange.ipc$dispatch("-367866317", new Object[]{this});
            return;
        }
        Drawable drawable = getDrawable();
        if (drawable == null || (drawableToBitamp = drawableToBitamp(drawable)) == null) {
            return;
        }
        Shader.TileMode tileMode = Shader.TileMode.CLAMP;
        this.mBitmapShader = new BitmapShader(drawableToBitamp, tileMode, tileMode);
        int i = this.type;
        float f = 1.0f;
        if (i == 0) {
            f = (this.mWidth * 1.0f) / Math.min(drawableToBitamp.getWidth(), drawableToBitamp.getHeight());
        } else if (i == 1) {
            Log.e("TAG", "b'w = " + drawableToBitamp.getWidth() + " , b'h = " + drawableToBitamp.getHeight());
            if (drawableToBitamp.getWidth() != getWidth() || drawableToBitamp.getHeight() != getHeight()) {
                f = Math.max((getWidth() * 1.0f) / drawableToBitamp.getWidth(), (getHeight() * 1.0f) / drawableToBitamp.getHeight());
            }
        }
        this.mMatrix.setScale(f, f);
        this.mBitmapShader.setLocalMatrix(this.mMatrix);
        this.mBitmapPaint.setShader(this.mBitmapShader);
    }

    public int dp2px(float f) {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "1831199404") ? ((Integer) ipChange.ipc$dispatch("1831199404", new Object[]{this, Float.valueOf(f)})).intValue() : (int) TypedValue.applyDimension(1, f, getResources().getDisplayMetrics());
    }

    @Override // android.widget.ImageView, android.view.View
    protected void onDraw(Canvas canvas) {
        int i;
        Paint paint;
        IpChange ipChange = $ipChange;
        boolean z = false;
        if (AndroidInstantRuntime.support(ipChange, "-101226573")) {
            ipChange.ipc$dispatch("-101226573", new Object[]{this, canvas});
            return;
        }
        Drawable drawable = getDrawable();
        if (drawable != null && !(drawable instanceof GradientDrawable) && !(drawable instanceof AnimatedImageDrawable)) {
            setUpShader();
            if (this.type == 1) {
                RectF rectF = this.mRoundRect;
                if (rectF == null || (paint = this.mBitmapPaint) == null) {
                    return;
                }
                int i2 = this.mBorderRadius;
                canvas.drawRoundRect(rectF, i2, i2, paint);
                if (this.mBorderWidth > 0) {
                    RectF rectF2 = this.mRoundRect;
                    int i3 = this.mBorderRadius;
                    canvas.drawRoundRect(rectF2, i3, i3, this.mBorderPaint);
                }
                if (this.mClipLeftTopRadius) {
                    clipTopLeft(canvas);
                }
                if (this.mClipRightTopRadius) {
                    clipTopRight(canvas);
                }
                if (this.mClipLeftBottomRadius) {
                    clipBottomLeft(canvas);
                }
                if (this.mClipRightBottomRadius) {
                    clipBottomRight(canvas);
                    return;
                }
                return;
            }
            int i4 = this.mRadius;
            canvas.drawCircle(i4, i4, i4, this.mBitmapPaint);
            if (this.mBorderWidth > 0) {
                int i5 = this.mRadius;
                canvas.drawCircle(i5, i5, i5, this.mBorderPaint);
            }
        } else if (drawable instanceof AnimatedImageDrawable) {
            int width = getWidth();
            int height = getHeight();
            if (this.isGifRoundCornerSupport && (i = this.mBorderRadius) > 0 && width > i * 2 && height > i * 2) {
                z = true;
            }
            if (z) {
                canvas.save();
                this.mGifClipRectF.set(0.0f, 0.0f, width, height);
                Path path = this.mGifClipPath;
                RectF rectF3 = this.mGifClipRectF;
                int i6 = this.mBorderRadius;
                path.addRoundRect(rectF3, i6, i6, Path.Direction.CW);
                canvas.clipPath(this.mGifClipPath);
            }
            super.onDraw(canvas);
            if (z) {
                canvas.restore();
            }
        } else {
            super.onDraw(canvas);
        }
    }

    @Override // android.widget.ImageView, android.view.View
    protected void onMeasure(int i, int i2) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-407737770")) {
            ipChange.ipc$dispatch("-407737770", new Object[]{this, Integer.valueOf(i), Integer.valueOf(i2)});
            return;
        }
        super.onMeasure(i, i2);
        if (this.type == 0) {
            int min = Math.min(getMeasuredWidth(), getMeasuredHeight());
            this.mWidth = min;
            this.mRadius = min / 2;
            setMeasuredDimension(min, min);
        }
    }

    @Override // android.view.View
    protected void onRestoreInstanceState(Parcelable parcelable) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-69137173")) {
            ipChange.ipc$dispatch("-69137173", new Object[]{this, parcelable});
        } else if (parcelable instanceof Bundle) {
            Bundle bundle = (Bundle) parcelable;
            super.onRestoreInstanceState(bundle.getParcelable(STATE_INSTANCE));
            this.type = bundle.getInt(STATE_TYPE);
            this.mBorderRadius = bundle.getInt(STATE_BORDER_RADIUS);
        } else {
            super.onRestoreInstanceState(parcelable);
        }
    }

    @Override // android.view.View
    protected Parcelable onSaveInstanceState() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-75620040")) {
            return (Parcelable) ipChange.ipc$dispatch("-75620040", new Object[]{this});
        }
        Bundle bundle = new Bundle();
        bundle.putParcelable(STATE_INSTANCE, super.onSaveInstanceState());
        bundle.putInt(STATE_TYPE, this.type);
        bundle.putInt(STATE_BORDER_RADIUS, this.mBorderRadius);
        return bundle;
    }

    @Override // android.view.View
    protected void onSizeChanged(int i, int i2, int i3, int i4) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-519179775")) {
            ipChange.ipc$dispatch("-519179775", new Object[]{this, Integer.valueOf(i), Integer.valueOf(i2), Integer.valueOf(i3), Integer.valueOf(i4)});
            return;
        }
        super.onSizeChanged(i, i2, i3, i4);
        if (this.type == 1) {
            this.mRoundRect = new RectF(0.0f, 0.0f, i, i2);
        }
    }

    public void setBorder(float f, int i) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "631406058")) {
            ipChange.ipc$dispatch("631406058", new Object[]{this, Float.valueOf(f), Integer.valueOf(i)});
        } else if (f <= 0.0f) {
        } else {
            this.mBorderPaint.setColor(i);
            int a = s60.INSTANCE.a(getContext(), f);
            this.mBorderWidth = a;
            this.mBorderPaint.setStrokeWidth(a);
            invalidate();
        }
    }

    public void setBorderRadius(int i) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "227706030")) {
            ipChange.ipc$dispatch("227706030", new Object[]{this, Integer.valueOf(i)});
            return;
        }
        int dp2px = dp2px(i);
        if (this.mBorderRadius != dp2px) {
            this.mBorderRadius = dp2px;
            invalidate();
        }
    }

    public void setGifRoundCornerSupport(boolean z) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1179461197")) {
            ipChange.ipc$dispatch("1179461197", new Object[]{this, Boolean.valueOf(z)});
        } else if (this.isGifRoundCornerSupport != z) {
            this.isGifRoundCornerSupport = z;
            invalidate();
        }
    }

    public void setType(int i) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-2081305590")) {
            ipChange.ipc$dispatch("-2081305590", new Object[]{this, Integer.valueOf(i)});
        } else if (this.type != i) {
            this.type = i;
            if (i != 1 && i != 0) {
                this.type = 0;
            }
            requestLayout();
        }
    }

    public void setBorder(int i, int i2) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "631495431")) {
            ipChange.ipc$dispatch("631495431", new Object[]{this, Integer.valueOf(i), Integer.valueOf(i2)});
        } else if (i <= 0) {
        } else {
            this.mBorderPaint.setColor(i2);
            this.mBorderWidth = i;
            this.mBorderPaint.setStrokeWidth(i);
            invalidate();
        }
    }

    public RoundImageView(Context context) {
        this(context, null);
    }
}
