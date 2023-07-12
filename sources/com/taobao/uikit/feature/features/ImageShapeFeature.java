package com.taobao.uikit.feature.features;

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
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.ShapeDrawable;
import android.graphics.drawable.shapes.OvalShape;
import android.graphics.drawable.shapes.RoundRectShape;
import android.graphics.drawable.shapes.Shape;
import android.os.Build;
import android.util.AttributeSet;
import android.widget.ImageView;
import com.taobao.uikit.base.R;
import com.taobao.uikit.feature.callback.CanvasCallback;
import com.taobao.uikit.feature.callback.ImageCallback;
import com.taobao.uikit.feature.callback.LayoutCallback;
import com.taobao.uikit.feature.view.IGetBitmap;

/* compiled from: Taobao */
/* loaded from: classes11.dex */
public class ImageShapeFeature extends AbsFeature<ImageView> implements LayoutCallback, ImageCallback, CanvasCallback {
    public static final int RoundRectShape = 1;
    public static final int RoundShape = 0;
    private float[] mCornerRadiusArray;
    private RectF mRectF;
    private Shape mShape;
    private Paint mStrokePaint;
    private Path mStrokePath;
    private final Matrix mMatrix = new Matrix();
    private boolean mIsRound = true;
    private boolean mStrokeEnable = false;
    private float mStrokeWidth = 0.0f;

    /* compiled from: Taobao */
    /* loaded from: classes11.dex */
    private static class MyShapeDrawable extends ShapeDrawable {
        public MyShapeDrawable() {
        }

        public MyShapeDrawable(Shape shape) {
            super(shape);
        }
    }

    private Bitmap getBitmap(Drawable drawable) {
        if (drawable instanceof BitmapDrawable) {
            return ((BitmapDrawable) drawable).getBitmap();
        }
        if (drawable instanceof IGetBitmap) {
            return ((IGetBitmap) drawable).getBitmap();
        }
        return null;
    }

    private void initCornerRadius(TypedArray typedArray) {
        float dimension = typedArray.getDimension(R.styleable.ImageShapeFeature_uik_cornerRadius, 0.0f);
        float dimension2 = typedArray.getDimension(R.styleable.ImageShapeFeature_uik_topLeftRadius, dimension);
        float dimension3 = typedArray.getDimension(R.styleable.ImageShapeFeature_uik_bottomLeftRadius, dimension);
        float dimension4 = typedArray.getDimension(R.styleable.ImageShapeFeature_uik_topRightRadius, dimension);
        float dimension5 = typedArray.getDimension(R.styleable.ImageShapeFeature_uik_bottomRightRadius, dimension);
        this.mCornerRadiusArray = new float[]{dimension2, dimension2, dimension4, dimension4, dimension5, dimension5, dimension3, dimension3};
    }

    private void initShape(int i) {
        if (i != 0) {
            if (1 == i) {
                this.mShape = new RoundRectShape(this.mCornerRadiusArray, new RectF(0.0f, 0.0f, 0.0f, 0.0f), null);
                this.mIsRound = false;
                return;
            }
            return;
        }
        this.mShape = new OvalShape();
        T t = this.mHost;
        if (t != 0) {
            ((ImageView) t).setScaleType(ImageView.ScaleType.CENTER_INSIDE);
        }
        this.mIsRound = true;
    }

    private void invalidateHost() {
        T t = this.mHost;
        if (t != 0) {
            ((ImageView) t).invalidate();
        }
    }

    private void requestLayoutHost() {
        T t = this.mHost;
        if (t != 0) {
            ((ImageView) t).requestLayout();
        }
    }

    @Override // com.taobao.uikit.feature.callback.CanvasCallback
    public void afterDispatchDraw(Canvas canvas) {
    }

    @Override // com.taobao.uikit.feature.callback.CanvasCallback
    public void afterDraw(Canvas canvas) {
    }

    @Override // com.taobao.uikit.feature.callback.CanvasCallback
    public void afterOnDraw(Canvas canvas) {
        if (this.mStrokeEnable) {
            canvas.drawPath(this.mStrokePath, this.mStrokePaint);
        }
    }

    @Override // com.taobao.uikit.feature.callback.LayoutCallback
    public void afterOnLayout(boolean z, int i, int i2, int i3, int i4) {
        if (z) {
            if (this.mIsRound) {
                int i5 = i3 - i;
                int i6 = i4 - i2;
                this.mStrokePath.addCircle(i5 * 0.5f, i6 * 0.5f, (Math.min(i5, i6) - this.mStrokeWidth) * 0.5f, Path.Direction.CCW);
            } else if (this.mCornerRadiusArray != null) {
                float f = this.mStrokeWidth * 0.5f;
                this.mRectF.set(f, f, (i3 - i) - f, (i4 - i2) - f);
                this.mStrokePath.addRoundRect(this.mRectF, this.mCornerRadiusArray, Path.Direction.CCW);
            }
            getHost().setImageDrawable(getHost().getDrawable());
        }
    }

    @Override // com.taobao.uikit.feature.callback.CanvasCallback
    public void beforeDispatchDraw(Canvas canvas) {
    }

    @Override // com.taobao.uikit.feature.callback.CanvasCallback
    public void beforeDraw(Canvas canvas) {
    }

    @Override // com.taobao.uikit.feature.callback.CanvasCallback
    public void beforeOnDraw(Canvas canvas) {
    }

    @Override // com.taobao.uikit.feature.callback.LayoutCallback
    public void beforeOnLayout(boolean z, int i, int i2, int i3, int i4) {
    }

    @Override // com.taobao.uikit.feature.features.AbsFeature
    public void constructor(Context context, AttributeSet attributeSet, int i) {
        int i2 = -7829368;
        if (attributeSet != null) {
            TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R.styleable.ImageShapeFeature, i, 0);
            int i3 = obtainStyledAttributes.getInt(R.styleable.ImageShapeFeature_uik_shapeType, 0);
            initCornerRadius(obtainStyledAttributes);
            initShape(i3);
            i2 = obtainStyledAttributes.getColor(R.styleable.ImageShapeFeature_uik_strokeColor, -7829368);
            this.mStrokeWidth = obtainStyledAttributes.getDimension(R.styleable.ImageShapeFeature_uik_strokeWidth, 0.0f);
            this.mStrokeEnable = obtainStyledAttributes.getBoolean(R.styleable.ImageShapeFeature_uik_strokeEnable, false);
            obtainStyledAttributes.recycle();
        }
        Paint paint = new Paint();
        this.mStrokePaint = paint;
        paint.setStyle(Paint.Style.STROKE);
        this.mStrokePaint.setAntiAlias(true);
        this.mStrokePaint.setColor(i2);
        this.mStrokePaint.setStrokeWidth(this.mStrokeWidth);
        this.mStrokePath = new Path();
        this.mRectF = new RectF();
    }

    public void setCornerRadius(float f, float f2, float f3, float f4) {
        this.mCornerRadiusArray = new float[]{f, f, f2, f2, f4, f4, f3, f3};
        if (this.mShape instanceof RoundRectShape) {
            this.mShape = new RoundRectShape(this.mCornerRadiusArray, new RectF(0.0f, 0.0f, 0.0f, 0.0f), null);
            requestLayoutHost();
            invalidateHost();
        }
    }

    public void setShape(int i) {
        initShape(i);
        requestLayoutHost();
        invalidateHost();
    }

    public void setStrokeColor(int i) {
        this.mStrokePaint.setColor(i);
        invalidateHost();
    }

    public void setStrokeEnable(boolean z) {
        this.mStrokeEnable = z;
        requestLayoutHost();
        invalidateHost();
    }

    public void setStrokeWidth(float f) {
        this.mStrokeWidth = f;
        this.mStrokePaint.setStrokeWidth(f);
        requestLayoutHost();
        invalidateHost();
    }

    @Override // com.taobao.uikit.feature.callback.ImageCallback
    public Drawable wrapImageDrawable(Drawable drawable) {
        MyShapeDrawable myShapeDrawable;
        float f;
        float f2;
        if (getHost().getWidth() > 0 || getHost().getHeight() > 0) {
            Drawable drawable2 = getHost().getDrawable();
            if (drawable2 instanceof MyShapeDrawable) {
                myShapeDrawable = (MyShapeDrawable) drawable2;
            } else {
                myShapeDrawable = new MyShapeDrawable(this.mShape);
                if (Build.VERSION.SDK_INT <= 16) {
                    myShapeDrawable.setPadding(new Rect(0, 0, 0, 0));
                }
            }
            int width = getHost().getWidth();
            int height = getHost().getHeight();
            if (myShapeDrawable.getIntrinsicHeight() <= 0 && myShapeDrawable.getIntrinsicWidth() <= 0) {
                if (this.mIsRound) {
                    width = Math.min(width, height);
                    height = width;
                }
                myShapeDrawable.setIntrinsicWidth(width);
                myShapeDrawable.setIntrinsicHeight(height);
            }
            if (!(drawable instanceof BitmapDrawable) && !(drawable instanceof IGetBitmap)) {
                if (!(drawable instanceof ColorDrawable)) {
                    return drawable;
                }
                myShapeDrawable.getPaint().setShader(null);
                myShapeDrawable.getPaint().setColor(((ColorDrawable) drawable).getColor());
            } else {
                Bitmap bitmap = getBitmap(drawable);
                if (bitmap != null) {
                    int width2 = bitmap.getWidth();
                    int height2 = bitmap.getHeight();
                    Shader.TileMode tileMode = Shader.TileMode.CLAMP;
                    BitmapShader bitmapShader = new BitmapShader(bitmap, tileMode, tileMode);
                    float f3 = 0.0f;
                    if (width2 * height > height2 * width) {
                        f = height / height2;
                        f3 = (width - (width2 * f)) * 0.5f;
                        f2 = 0.0f;
                    } else {
                        f = width / width2;
                        f2 = (height - (height2 * f)) * 0.5f;
                    }
                    this.mMatrix.reset();
                    this.mMatrix.setScale(f, f);
                    this.mMatrix.postTranslate(f3 + 0.5f, f2 + 0.5f);
                    bitmapShader.setLocalMatrix(this.mMatrix);
                    myShapeDrawable.getPaint().setShader(bitmapShader);
                } else {
                    myShapeDrawable.getPaint().setShader(null);
                }
            }
            myShapeDrawable.invalidateSelf();
            return myShapeDrawable;
        }
        return drawable;
    }

    @Override // com.taobao.uikit.feature.features.AbsFeature
    public void setHost(ImageView imageView) {
        super.setHost((ImageShapeFeature) imageView);
        if (this.mShape instanceof OvalShape) {
            imageView.setScaleType(ImageView.ScaleType.CENTER_INSIDE);
        }
    }
}
