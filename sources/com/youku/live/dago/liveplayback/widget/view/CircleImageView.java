package com.youku.live.dago.liveplayback.widget.view;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Bitmap;
import android.graphics.BitmapShader;
import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.RectF;
import android.graphics.Shader;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.util.AttributeSet;
import android.widget.ImageView;
import androidx.annotation.ColorInt;
import androidx.annotation.ColorRes;
import androidx.annotation.DrawableRes;
import androidx.appcompat.widget.AppCompatImageView;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import com.youku.live.dago.liveplayback.R;

/* compiled from: Taobao */
/* loaded from: classes2.dex */
public class CircleImageView extends AppCompatImageView {
    private static transient /* synthetic */ IpChange $ipChange = null;
    private static final int COLORDRAWABLE_DIMENSION = 2;
    private static final int DEFAULT_BORDER_COLOR = -16777216;
    private static final boolean DEFAULT_BORDER_OVERLAY = false;
    private static final int DEFAULT_BORDER_WIDTH = 0;
    private static final int DEFAULT_FILL_COLOR = 0;
    private Bitmap mBitmap;
    private int mBitmapHeight;
    private final Paint mBitmapPaint;
    private BitmapShader mBitmapShader;
    private int mBitmapWidth;
    private int mBorderColor;
    private boolean mBorderOverlay;
    private final Paint mBorderPaint;
    private float mBorderRadius;
    private final RectF mBorderRect;
    private int mBorderWidth;
    private ColorFilter mColorFilter;
    private float mDrawableRadius;
    private final RectF mDrawableRect;
    private int mFillColor;
    private final Paint mFillPaint;
    private boolean mReady;
    private boolean mSetupPending;
    private final Matrix mShaderMatrix;
    private static final ImageView.ScaleType SCALE_TYPE = ImageView.ScaleType.CENTER_CROP;
    private static final Bitmap.Config BITMAP_CONFIG = Bitmap.Config.ARGB_8888;

    public CircleImageView(Context context) {
        super(context);
        this.mDrawableRect = new RectF();
        this.mBorderRect = new RectF();
        this.mShaderMatrix = new Matrix();
        this.mBitmapPaint = new Paint();
        this.mBorderPaint = new Paint();
        this.mFillPaint = new Paint();
        this.mBorderColor = -16777216;
        this.mBorderWidth = 0;
        this.mFillColor = 0;
        init();
    }

    private Bitmap getBitmapFromDrawable(Drawable drawable) {
        Bitmap createBitmap;
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "683778150")) {
            return (Bitmap) ipChange.ipc$dispatch("683778150", new Object[]{this, drawable});
        }
        if (drawable == null) {
            return null;
        }
        if (drawable instanceof BitmapDrawable) {
            return ((BitmapDrawable) drawable).getBitmap();
        }
        try {
            if (drawable instanceof ColorDrawable) {
                createBitmap = Bitmap.createBitmap(2, 2, BITMAP_CONFIG);
            } else {
                createBitmap = Bitmap.createBitmap(drawable.getIntrinsicWidth(), drawable.getIntrinsicHeight(), BITMAP_CONFIG);
            }
            Canvas canvas = new Canvas(createBitmap);
            drawable.setBounds(0, 0, canvas.getWidth(), canvas.getHeight());
            drawable.draw(canvas);
            return createBitmap;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    private void init() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-771192407")) {
            ipChange.ipc$dispatch("-771192407", new Object[]{this});
            return;
        }
        super.setScaleType(SCALE_TYPE);
        this.mReady = true;
        if (this.mSetupPending) {
            setup();
            this.mSetupPending = false;
        }
    }

    private void setup() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1263505644")) {
            ipChange.ipc$dispatch("-1263505644", new Object[]{this});
        } else if (!this.mReady) {
            this.mSetupPending = true;
        } else if (getWidth() == 0 && getHeight() == 0) {
        } else {
            if (this.mBitmap == null) {
                invalidate();
                return;
            }
            Bitmap bitmap = this.mBitmap;
            Shader.TileMode tileMode = Shader.TileMode.CLAMP;
            this.mBitmapShader = new BitmapShader(bitmap, tileMode, tileMode);
            this.mBitmapPaint.setAntiAlias(true);
            this.mBitmapPaint.setShader(this.mBitmapShader);
            this.mBorderPaint.setStyle(Paint.Style.STROKE);
            this.mBorderPaint.setAntiAlias(true);
            this.mBorderPaint.setColor(this.mBorderColor);
            this.mBorderPaint.setStrokeWidth(this.mBorderWidth);
            this.mFillPaint.setStyle(Paint.Style.FILL);
            this.mFillPaint.setAntiAlias(true);
            this.mFillPaint.setColor(this.mFillColor);
            this.mBitmapHeight = this.mBitmap.getHeight();
            this.mBitmapWidth = this.mBitmap.getWidth();
            this.mBorderRect.set(0.0f, 0.0f, getWidth(), getHeight());
            this.mBorderRadius = Math.min((this.mBorderRect.height() - this.mBorderWidth) / 2.0f, (this.mBorderRect.width() - this.mBorderWidth) / 2.0f);
            this.mDrawableRect.set(this.mBorderRect);
            if (!this.mBorderOverlay) {
                RectF rectF = this.mDrawableRect;
                int i = this.mBorderWidth;
                rectF.inset(i, i);
            }
            this.mDrawableRadius = Math.min(this.mDrawableRect.height() / 2.0f, this.mDrawableRect.width() / 2.0f);
            updateShaderMatrix();
            invalidate();
        }
    }

    private void updateShaderMatrix() {
        float width;
        float height;
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1340437482")) {
            ipChange.ipc$dispatch("1340437482", new Object[]{this});
            return;
        }
        this.mShaderMatrix.set(null);
        float f = 0.0f;
        if (this.mBitmapWidth * this.mDrawableRect.height() > this.mDrawableRect.width() * this.mBitmapHeight) {
            width = this.mDrawableRect.height() / this.mBitmapHeight;
            f = (this.mDrawableRect.width() - (this.mBitmapWidth * width)) * 0.5f;
            height = 0.0f;
        } else {
            width = this.mDrawableRect.width() / this.mBitmapWidth;
            height = (this.mDrawableRect.height() - (this.mBitmapHeight * width)) * 0.5f;
        }
        this.mShaderMatrix.setScale(width, width);
        Matrix matrix = this.mShaderMatrix;
        RectF rectF = this.mDrawableRect;
        matrix.postTranslate(((int) (f + 0.5f)) + rectF.left, ((int) (height + 0.5f)) + rectF.top);
        this.mBitmapShader.setLocalMatrix(this.mShaderMatrix);
    }

    public int getBorderColor() {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "-2002440533") ? ((Integer) ipChange.ipc$dispatch("-2002440533", new Object[]{this})).intValue() : this.mBorderColor;
    }

    public int getBorderWidth() {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "1534226792") ? ((Integer) ipChange.ipc$dispatch("1534226792", new Object[]{this})).intValue() : this.mBorderWidth;
    }

    public int getFillColor() {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "1566142338") ? ((Integer) ipChange.ipc$dispatch("1566142338", new Object[]{this})).intValue() : this.mFillColor;
    }

    @Override // android.widget.ImageView
    public ImageView.ScaleType getScaleType() {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "1868190853") ? (ImageView.ScaleType) ipChange.ipc$dispatch("1868190853", new Object[]{this}) : SCALE_TYPE;
    }

    public boolean isBorderOverlay() {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "-1182229509") ? ((Boolean) ipChange.ipc$dispatch("-1182229509", new Object[]{this})).booleanValue() : this.mBorderOverlay;
    }

    @Override // android.widget.ImageView, android.view.View
    protected void onDraw(Canvas canvas) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1835509489")) {
            ipChange.ipc$dispatch("-1835509489", new Object[]{this, canvas});
        } else if (this.mBitmap == null) {
        } else {
            if (this.mFillColor != 0) {
                canvas.drawCircle(getWidth() / 2.0f, getHeight() / 2.0f, this.mDrawableRadius, this.mFillPaint);
            }
            canvas.drawCircle(getWidth() / 2.0f, getHeight() / 2.0f, this.mDrawableRadius, this.mBitmapPaint);
            if (this.mBorderWidth != 0) {
                canvas.drawCircle(getWidth() / 2.0f, getHeight() / 2.0f, this.mBorderRadius, this.mBorderPaint);
            }
        }
    }

    @Override // android.view.View
    protected void onSizeChanged(int i, int i2, int i3, int i4) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "284177501")) {
            ipChange.ipc$dispatch("284177501", new Object[]{this, Integer.valueOf(i), Integer.valueOf(i2), Integer.valueOf(i3), Integer.valueOf(i4)});
            return;
        }
        super.onSizeChanged(i, i2, i3, i4);
        setup();
    }

    @Override // android.widget.ImageView
    public void setAdjustViewBounds(boolean z) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-2043865874")) {
            ipChange.ipc$dispatch("-2043865874", new Object[]{this, Boolean.valueOf(z)});
        }
    }

    public void setBorderColor(@ColorInt int i) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1026050881")) {
            ipChange.ipc$dispatch("-1026050881", new Object[]{this, Integer.valueOf(i)});
        } else if (i == this.mBorderColor) {
        } else {
            this.mBorderColor = i;
            this.mBorderPaint.setColor(i);
            invalidate();
        }
    }

    public void setBorderColorResource(@ColorRes int i) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "336000237")) {
            ipChange.ipc$dispatch("336000237", new Object[]{this, Integer.valueOf(i)});
        } else {
            setBorderColor(getContext().getResources().getColor(i));
        }
    }

    public void setBorderOverlay(boolean z) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1690261373")) {
            ipChange.ipc$dispatch("1690261373", new Object[]{this, Boolean.valueOf(z)});
        } else if (z == this.mBorderOverlay) {
        } else {
            this.mBorderOverlay = z;
            setup();
        }
    }

    public void setBorderWidth(int i) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1236453794")) {
            ipChange.ipc$dispatch("1236453794", new Object[]{this, Integer.valueOf(i)});
        } else if (i == this.mBorderWidth) {
        } else {
            this.mBorderWidth = i;
            setup();
        }
    }

    @Override // android.widget.ImageView
    public void setColorFilter(ColorFilter colorFilter) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1919855736")) {
            ipChange.ipc$dispatch("1919855736", new Object[]{this, colorFilter});
        } else if (colorFilter == this.mColorFilter) {
        } else {
            this.mColorFilter = colorFilter;
            this.mBitmapPaint.setColorFilter(colorFilter);
            invalidate();
        }
    }

    public void setFillColor(@ColorInt int i) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-525640760")) {
            ipChange.ipc$dispatch("-525640760", new Object[]{this, Integer.valueOf(i)});
        } else if (i == this.mFillColor) {
        } else {
            this.mFillColor = i;
            this.mFillPaint.setColor(i);
            invalidate();
        }
    }

    public void setFillColorResource(@ColorRes int i) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1985248522")) {
            ipChange.ipc$dispatch("-1985248522", new Object[]{this, Integer.valueOf(i)});
        } else {
            setFillColor(getContext().getResources().getColor(i));
        }
    }

    @Override // androidx.appcompat.widget.AppCompatImageView, android.widget.ImageView
    public void setImageBitmap(Bitmap bitmap) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1157427907")) {
            ipChange.ipc$dispatch("-1157427907", new Object[]{this, bitmap});
            return;
        }
        super.setImageBitmap(bitmap);
        this.mBitmap = bitmap;
        setup();
    }

    @Override // androidx.appcompat.widget.AppCompatImageView, android.widget.ImageView
    public void setImageDrawable(Drawable drawable) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "785154982")) {
            ipChange.ipc$dispatch("785154982", new Object[]{this, drawable});
            return;
        }
        super.setImageDrawable(drawable);
        this.mBitmap = getBitmapFromDrawable(drawable);
        setup();
    }

    @Override // androidx.appcompat.widget.AppCompatImageView, android.widget.ImageView
    public void setImageResource(@DrawableRes int i) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1092405967")) {
            ipChange.ipc$dispatch("-1092405967", new Object[]{this, Integer.valueOf(i)});
            return;
        }
        super.setImageResource(i);
        this.mBitmap = getBitmapFromDrawable(getDrawable());
        setup();
    }

    @Override // androidx.appcompat.widget.AppCompatImageView, android.widget.ImageView
    public void setImageURI(Uri uri) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1242908873")) {
            ipChange.ipc$dispatch("1242908873", new Object[]{this, uri});
            return;
        }
        super.setImageURI(uri);
        this.mBitmap = uri != null ? getBitmapFromDrawable(getDrawable()) : null;
        setup();
    }

    @Override // android.widget.ImageView
    public void setScaleType(ImageView.ScaleType scaleType) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1010613775")) {
            ipChange.ipc$dispatch("-1010613775", new Object[]{this, scaleType});
        }
    }

    public CircleImageView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public CircleImageView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.mDrawableRect = new RectF();
        this.mBorderRect = new RectF();
        this.mShaderMatrix = new Matrix();
        this.mBitmapPaint = new Paint();
        this.mBorderPaint = new Paint();
        this.mFillPaint = new Paint();
        this.mBorderColor = -16777216;
        this.mBorderWidth = 0;
        this.mFillColor = 0;
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R.styleable.CircleImageView, i, 0);
        this.mBorderWidth = obtainStyledAttributes.getDimensionPixelSize(R.styleable.CircleImageView_civ_border_width, 0);
        this.mBorderColor = obtainStyledAttributes.getColor(R.styleable.CircleImageView_civ_border_color, -16777216);
        this.mBorderOverlay = obtainStyledAttributes.getBoolean(R.styleable.CircleImageView_civ_border_overlay, false);
        this.mFillColor = obtainStyledAttributes.getColor(R.styleable.CircleImageView_civ_fill_color, 0);
        obtainStyledAttributes.recycle();
        init();
    }
}
