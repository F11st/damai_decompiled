package com.youku.widget;

import android.content.Context;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.graphics.Bitmap;
import android.graphics.BitmapShader;
import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.Shader;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.LayerDrawable;
import android.net.Uri;
import android.util.AttributeSet;
import android.widget.ImageView;
import com.baseproject.ui.R$styleable;

/* compiled from: Taobao */
/* loaded from: classes3.dex */
public class DonutCircleImageView extends ImageView {
    public static final String TAG = "DonutCircleImageView";
    private static final ImageView.ScaleType[] sScaleTypeArray = {ImageView.ScaleType.MATRIX, ImageView.ScaleType.FIT_XY, ImageView.ScaleType.FIT_START, ImageView.ScaleType.FIT_CENTER, ImageView.ScaleType.FIT_END, ImageView.ScaleType.CENTER, ImageView.ScaleType.CENTER_CROP, ImageView.ScaleType.CENTER_INSIDE};
    private float mBorder;
    private int mBorderColor;
    private Drawable mDrawable;
    private int mResource;
    private ImageView.ScaleType mScaleType;
    private float multiR;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: Taobao */
    /* loaded from: classes3.dex */
    public static class DonutCircleDrawable extends Drawable {
        private static final String TAG = "DonutCircleDrawable";
        private float border;
        private Paint borderPaint;
        private Bitmap mBitmap;
        private final int mBitmapHeight;
        private final Paint mBitmapPaint;
        private final RectF mBitmapRect;
        private BitmapShader mBitmapShader;
        private final int mBitmapWidth;
        private int mBorderColor;
        private boolean mBoundsConfigured;
        private Path mPath;
        private ImageView.ScaleType mScaleType;
        private float multiR;
        private final float constant = (float) Math.sqrt(2.0d);
        private RectF mBounds = new RectF();

        public DonutCircleDrawable(Bitmap bitmap, Resources resources) {
            RectF rectF = new RectF();
            this.mBitmapRect = rectF;
            this.mScaleType = ImageView.ScaleType.FIT_CENTER;
            this.multiR = 1.04f;
            this.border = 0.0f;
            this.mBorderColor = 0;
            this.mPath = new Path();
            this.mBoundsConfigured = false;
            this.mBitmap = bitmap;
            Shader.TileMode tileMode = Shader.TileMode.CLAMP;
            this.mBitmapShader = new BitmapShader(bitmap, tileMode, tileMode);
            if (bitmap != null) {
                this.mBitmapWidth = bitmap.getScaledWidth(resources.getDisplayMetrics());
                this.mBitmapHeight = bitmap.getScaledHeight(resources.getDisplayMetrics());
            } else {
                this.mBitmapHeight = -1;
                this.mBitmapWidth = -1;
            }
            rectF.set(0.0f, 0.0f, this.mBitmapWidth, this.mBitmapHeight);
            Paint paint = new Paint(3);
            this.mBitmapPaint = paint;
            paint.setStyle(Paint.Style.FILL);
            paint.setShader(this.mBitmapShader);
            Paint paint2 = new Paint();
            this.borderPaint = paint2;
            paint2.setAntiAlias(true);
            this.borderPaint.setStyle(Paint.Style.STROKE);
        }

        private void configureBounds(Canvas canvas) {
            Rect clipBounds = canvas.getClipBounds();
            canvas.getMatrix();
            ImageView.ScaleType scaleType = ImageView.ScaleType.CENTER;
            ImageView.ScaleType scaleType2 = this.mScaleType;
            if (scaleType == scaleType2) {
                this.mBounds.set(clipBounds);
            } else if (ImageView.ScaleType.CENTER_CROP == scaleType2) {
                this.mBounds.set(clipBounds);
            } else if (ImageView.ScaleType.FIT_XY == scaleType2) {
                Matrix matrix = new Matrix();
                matrix.setRectToRect(this.mBitmapRect, new RectF(clipBounds), Matrix.ScaleToFit.FILL);
                this.mBitmapShader.setLocalMatrix(matrix);
                this.mBounds.set(clipBounds);
            } else if (ImageView.ScaleType.FIT_START != scaleType2 && ImageView.ScaleType.FIT_END != scaleType2 && ImageView.ScaleType.FIT_CENTER != scaleType2 && ImageView.ScaleType.CENTER_INSIDE != scaleType2) {
                if (ImageView.ScaleType.MATRIX == scaleType2) {
                    this.mBounds.set(this.mBitmapRect);
                }
            } else {
                this.mBounds.set(this.mBitmapRect);
            }
        }

        private void drawDonutCirclePath() {
            float centerX = this.mBounds.centerX();
            float centerY = this.mBounds.centerY();
            float f = centerX > centerY ? centerY : centerX;
            float f2 = this.constant;
            float f3 = ((((this.multiR * 2.0f) - (f2 / 2.0f)) * f) * f2) / 2.0f;
            float f4 = f - (this.border / 2.0f);
            this.mPath.reset();
            float f5 = centerY - f4;
            this.mPath.moveTo(centerX, f5);
            float f6 = centerX + f3;
            float f7 = centerY - f3;
            this.mPath.quadTo(f6, f7, centerX + f4, centerY);
            float f8 = centerY + f3;
            this.mPath.quadTo(f6, f8, centerX, centerY + f4);
            float f9 = centerX - f3;
            this.mPath.quadTo(f9, f8, centerX - f4, centerY);
            this.mPath.quadTo(f9, f7, centerX, f5);
            this.mPath.close();
        }

        private void drawDonutPath() {
            float centerX = this.mBounds.centerX();
            float centerY = this.mBounds.centerY();
            float f = centerX > centerY ? centerY : centerX;
            float f2 = this.constant;
            float f3 = ((((this.multiR * 2.0f) - (f2 / 2.0f)) * f) * f2) / 2.0f;
            this.mPath.reset();
            float f4 = centerY - f;
            this.mPath.moveTo(centerX, f4);
            float f5 = centerX + f3;
            float f6 = centerY - f3;
            this.mPath.quadTo(f5, f6, centerX + f, centerY);
            float f7 = centerY + f3;
            this.mPath.quadTo(f5, f7, centerX, centerY + f);
            float f8 = centerX - f3;
            this.mPath.quadTo(f8, f7, centerX - f, centerY);
            this.mPath.quadTo(f8, f6, centerX, f4);
            this.mPath.close();
        }

        public static Bitmap drawableToBitmap(Drawable drawable) {
            if (drawable == null) {
                return null;
            }
            if (drawable instanceof BitmapDrawable) {
                return ((BitmapDrawable) drawable).getBitmap();
            }
            try {
                Bitmap createBitmap = Bitmap.createBitmap(Math.max(drawable.getIntrinsicWidth(), 2), Math.max(drawable.getIntrinsicHeight(), 2), Bitmap.Config.ARGB_8888);
                Canvas canvas = new Canvas(createBitmap);
                drawable.setBounds(0, 0, canvas.getWidth(), canvas.getHeight());
                drawable.draw(canvas);
                return createBitmap;
            } catch (IllegalArgumentException e) {
                e.printStackTrace();
                return null;
            }
        }

        public static DonutCircleDrawable fromBitmap(Bitmap bitmap, Resources resources) {
            if (bitmap != null) {
                return new DonutCircleDrawable(bitmap, resources);
            }
            return null;
        }

        public static Drawable fromDrawable(Drawable drawable, Resources resources) {
            if (drawable == null || (drawable instanceof DonutCircleDrawable)) {
                return drawable;
            }
            if (drawable instanceof LayerDrawable) {
                LayerDrawable layerDrawable = (LayerDrawable) drawable;
                int numberOfLayers = layerDrawable.getNumberOfLayers();
                for (int i = 0; i < numberOfLayers; i++) {
                    layerDrawable.setDrawableByLayerId(layerDrawable.getId(i), fromDrawable(layerDrawable.getDrawable(i), resources));
                }
                return layerDrawable;
            }
            Bitmap drawableToBitmap = drawableToBitmap(drawable);
            return drawableToBitmap != null ? new DonutCircleDrawable(drawableToBitmap, resources) : drawable;
        }

        @Override // android.graphics.drawable.Drawable
        public void draw(Canvas canvas) {
            canvas.save();
            if (!this.mBoundsConfigured) {
                configureBounds(canvas);
                this.mBoundsConfigured = true;
            }
            drawDonutPath();
            canvas.drawPath(this.mPath, this.mBitmapPaint);
            float f = this.border;
            if (f > 0.0f) {
                this.borderPaint.setStrokeWidth(f);
                this.borderPaint.setColor(this.mBorderColor);
                drawDonutCirclePath();
                canvas.drawPath(this.mPath, this.borderPaint);
            }
            canvas.restore();
        }

        @Override // android.graphics.drawable.Drawable
        public int getIntrinsicHeight() {
            return this.mBitmapHeight;
        }

        @Override // android.graphics.drawable.Drawable
        public int getIntrinsicWidth() {
            return this.mBitmapWidth;
        }

        @Override // android.graphics.drawable.Drawable
        public int getOpacity() {
            Bitmap bitmap = this.mBitmap;
            return (bitmap == null || bitmap.hasAlpha() || this.mBitmapPaint.getAlpha() < 255) ? -3 : -1;
        }

        public ImageView.ScaleType getScaleType() {
            return this.mScaleType;
        }

        @Override // android.graphics.drawable.Drawable
        public void setAlpha(int i) {
            this.mBitmapPaint.setAlpha(i);
            invalidateSelf();
        }

        public void setBorder(float f) {
            this.border = f;
            invalidateSelf();
        }

        public void setBorderColor(int i) {
            this.mBorderColor = i;
            invalidateSelf();
        }

        @Override // android.graphics.drawable.Drawable
        public void setColorFilter(ColorFilter colorFilter) {
            this.mBitmapPaint.setColorFilter(colorFilter);
            invalidateSelf();
        }

        @Override // android.graphics.drawable.Drawable
        public void setDither(boolean z) {
            this.mBitmapPaint.setDither(z);
            invalidateSelf();
        }

        @Override // android.graphics.drawable.Drawable
        public void setFilterBitmap(boolean z) {
            this.mBitmapPaint.setFilterBitmap(z);
            invalidateSelf();
        }

        public void setMultiR(float f) {
            this.multiR = f;
            invalidateSelf();
        }

        public void setScaleType(ImageView.ScaleType scaleType) {
            if (scaleType == null) {
                return;
            }
            this.mScaleType = scaleType;
        }
    }

    public DonutCircleImageView(Context context) {
        super(context);
        this.mResource = 0;
        this.mScaleType = ImageView.ScaleType.FIT_CENTER;
        this.multiR = 1.04f;
        this.mBorder = 0.0f;
        this.mBorderColor = 0;
    }

    private Drawable resolveResource() {
        Resources resources = getResources();
        Drawable drawable = null;
        if (resources == null) {
            return null;
        }
        int i = this.mResource;
        if (i != 0) {
            try {
                drawable = resources.getDrawable(i);
            } catch (Resources.NotFoundException unused) {
                this.mResource = 0;
            }
        }
        return DonutCircleDrawable.fromDrawable(drawable, getResources());
    }

    private void setBorderColor(int i) {
        this.mBorderColor = i;
        updateDrawable();
    }

    private void updateDrawable() {
        Drawable drawable = this.mDrawable;
        if (drawable == null) {
            return;
        }
        ((DonutCircleDrawable) drawable).setScaleType(this.mScaleType);
        ((DonutCircleDrawable) this.mDrawable).setMultiR(this.multiR);
        float f = this.mBorder;
        if (f > 0.0f) {
            ((DonutCircleDrawable) this.mDrawable).setBorder(f);
            ((DonutCircleDrawable) this.mDrawable).setBorderColor(this.mBorderColor);
        }
    }

    @Override // android.widget.ImageView, android.view.View
    protected void drawableStateChanged() {
        super.drawableStateChanged();
        invalidate();
    }

    @Override // android.widget.ImageView
    public ImageView.ScaleType getScaleType() {
        return this.mScaleType;
    }

    public void setBorder(float f) {
        this.mBorder = f;
        updateDrawable();
    }

    @Override // android.widget.ImageView
    public void setImageBitmap(Bitmap bitmap) {
        this.mResource = 0;
        DonutCircleDrawable fromBitmap = DonutCircleDrawable.fromBitmap(bitmap, getResources());
        this.mDrawable = fromBitmap;
        super.setImageDrawable(fromBitmap);
        updateDrawable();
    }

    @Override // android.widget.ImageView
    public void setImageDrawable(Drawable drawable) {
        this.mResource = 0;
        Drawable fromDrawable = DonutCircleDrawable.fromDrawable(drawable, getResources());
        this.mDrawable = fromDrawable;
        super.setImageDrawable(fromDrawable);
        updateDrawable();
    }

    @Override // android.widget.ImageView
    public void setImageResource(int i) {
        if (this.mResource != i) {
            this.mResource = i;
            Drawable resolveResource = resolveResource();
            this.mDrawable = resolveResource;
            super.setImageDrawable(resolveResource);
            updateDrawable();
        }
    }

    @Override // android.widget.ImageView
    public void setImageURI(Uri uri) {
        super.setImageURI(uri);
        setImageDrawable(getDrawable());
    }

    public void setMultiR(float f) {
        this.multiR = f;
        updateDrawable();
    }

    @Override // android.widget.ImageView
    public void setScaleType(ImageView.ScaleType scaleType) {
        super.setScaleType(scaleType);
        this.mScaleType = scaleType;
        updateDrawable();
    }

    public DonutCircleImageView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public DonutCircleImageView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.mResource = 0;
        this.mScaleType = ImageView.ScaleType.FIT_CENTER;
        this.multiR = 1.04f;
        this.mBorder = 0.0f;
        this.mBorderColor = 0;
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R$styleable.DonutCircleImageView, i, 0);
        int i2 = obtainStyledAttributes.getInt(R$styleable.DonutCircleImageView_android_scaleType, -1);
        if (i2 >= 0) {
            setScaleType(sScaleTypeArray[i2]);
        }
        float f = obtainStyledAttributes.getFloat(R$styleable.DonutCircleImageView_multiRadius, 0.0f);
        if (f > 0.0f) {
            setMultiR(f);
        }
        float dimension = obtainStyledAttributes.getDimension(R$styleable.DonutCircleImageView_donutBorderWidth, 0.0f);
        int color = obtainStyledAttributes.getColor(R$styleable.DonutCircleImageView_donutBorderColor, 436207616);
        if (dimension > 0.0f) {
            setBorder(dimension);
            setBorderColor(color);
        }
        obtainStyledAttributes.recycle();
        updateDrawable();
    }
}
