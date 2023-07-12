package cn.damai.tetris.component.home.widget.banner;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapShader;
import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.RectF;
import android.graphics.Shader;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.GradientDrawable;
import android.os.Bundle;
import android.os.Parcelable;
import android.util.AttributeSet;
import android.util.TypedValue;
import androidx.appcompat.widget.AppCompatImageView;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;

/* compiled from: Taobao */
/* loaded from: classes7.dex */
public class BannerImageView extends AppCompatImageView {
    private static transient /* synthetic */ IpChange $ipChange = null;
    private static final int BODER_RADIUS_DEFAULT = 6;
    private static final String STATE_BORDER_RADIUS = "state_border_radius";
    private static final String STATE_INSTANCE = "state_instance";
    private Paint mBitmapPaint;
    private BitmapShader mBitmapShader;
    private Paint mBorderPaint;
    private int mBorderRadius;
    private int mBorderWidth;
    private Matrix mMatrix;
    private RectF mRoundRect;

    public BannerImageView(Context context) {
        this(context, null);
    }

    private void drawCanvas(Canvas canvas) {
        Paint paint;
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "707931891")) {
            ipChange.ipc$dispatch("707931891", new Object[]{this, canvas});
            return;
        }
        RectF rectF = this.mRoundRect;
        if (rectF == null || (paint = this.mBitmapPaint) == null) {
            return;
        }
        int i = this.mBorderRadius;
        canvas.drawRoundRect(rectF, i, i, paint);
        if (this.mBorderWidth > 0) {
            RectF rectF2 = this.mRoundRect;
            int i2 = this.mBorderRadius;
            canvas.drawRoundRect(rectF2, i2, i2, this.mBorderPaint);
        }
    }

    private Bitmap drawableToBitamp(Drawable drawable) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1237551744")) {
            return (Bitmap) ipChange.ipc$dispatch("-1237551744", new Object[]{this, drawable});
        }
        if (drawable instanceof BitmapDrawable) {
            return ((BitmapDrawable) drawable).getBitmap();
        }
        int intrinsicWidth = drawable.getIntrinsicWidth();
        int intrinsicHeight = drawable.getIntrinsicHeight();
        Bitmap createBitmap = Bitmap.createBitmap(intrinsicWidth, intrinsicHeight, Bitmap.Config.ARGB_8888);
        Canvas canvas = new Canvas(createBitmap);
        drawable.setBounds(0, 0, intrinsicWidth, intrinsicHeight);
        drawable.draw(canvas);
        return createBitmap;
    }

    private void setUpShader() {
        Bitmap drawableToBitamp;
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1324186118")) {
            ipChange.ipc$dispatch("-1324186118", new Object[]{this});
            return;
        }
        Drawable drawable = getDrawable();
        if (drawable == null || (drawableToBitamp = drawableToBitamp(drawable)) == null) {
            return;
        }
        int width = (getWidth() - getPaddingLeft()) - getPaddingRight();
        int height = (getHeight() - getPaddingTop()) - getPaddingBottom();
        Shader.TileMode tileMode = Shader.TileMode.CLAMP;
        this.mBitmapShader = new BitmapShader(drawableToBitamp, tileMode, tileMode);
        float f = 1.0f;
        if (drawableToBitamp.getWidth() != width || drawableToBitamp.getHeight() != height) {
            f = Math.max((width * 1.0f) / drawableToBitamp.getWidth(), (height * 1.0f) / drawableToBitamp.getHeight());
        }
        this.mMatrix.setScale(f, f);
        this.mBitmapShader.setLocalMatrix(this.mMatrix);
        this.mBitmapPaint.setShader(this.mBitmapShader);
    }

    public int dp2px(float f) {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "-595187067") ? ((Integer) ipChange.ipc$dispatch("-595187067", new Object[]{this, Float.valueOf(f)})).intValue() : (int) TypedValue.applyDimension(1, f, getResources().getDisplayMetrics());
    }

    @Override // android.widget.ImageView, android.view.View
    protected void onDraw(Canvas canvas) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1843164666")) {
            ipChange.ipc$dispatch("1843164666", new Object[]{this, canvas});
        } else if (getDrawable() != null && !(getDrawable() instanceof GradientDrawable)) {
            setUpShader();
            if (getImageMatrix() == null && getPaddingTop() == 0 && getPaddingLeft() == 0) {
                drawCanvas(canvas);
                return;
            }
            int saveCount = canvas.getSaveCount();
            canvas.save();
            if (getCropToPadding()) {
                int scrollX = getScrollX();
                int scrollY = getScrollY();
                canvas.clipRect(getPaddingLeft() + scrollX, getPaddingTop() + scrollY, ((scrollX + getRight()) - getLeft()) - getPaddingRight(), ((scrollY + getBottom()) - getTop()) - getPaddingBottom());
            }
            canvas.translate(getPaddingLeft(), getPaddingTop());
            if (getImageMatrix() != null) {
                canvas.concat(getImageMatrix());
            }
            drawCanvas(canvas);
            canvas.restoreToCount(saveCount);
        } else {
            super.onDraw(canvas);
        }
    }

    @Override // android.view.View
    protected void onRestoreInstanceState(Parcelable parcelable) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "649073394")) {
            ipChange.ipc$dispatch("649073394", new Object[]{this, parcelable});
        } else if (parcelable instanceof Bundle) {
            Bundle bundle = (Bundle) parcelable;
            super.onRestoreInstanceState(bundle.getParcelable(STATE_INSTANCE));
            this.mBorderRadius = bundle.getInt(STATE_BORDER_RADIUS);
        } else {
            super.onRestoreInstanceState(parcelable);
        }
    }

    @Override // android.view.View
    protected Parcelable onSaveInstanceState() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1649885887")) {
            return (Parcelable) ipChange.ipc$dispatch("1649885887", new Object[]{this});
        }
        Bundle bundle = new Bundle();
        bundle.putParcelable(STATE_INSTANCE, super.onSaveInstanceState());
        bundle.putInt(STATE_BORDER_RADIUS, this.mBorderRadius);
        return bundle;
    }

    @Override // android.view.View
    protected void onSizeChanged(int i, int i2, int i3, int i4) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-534742904")) {
            ipChange.ipc$dispatch("-534742904", new Object[]{this, Integer.valueOf(i), Integer.valueOf(i2), Integer.valueOf(i3), Integer.valueOf(i4)});
            return;
        }
        super.onSizeChanged(i, i2, i3, i4);
        this.mRoundRect = new RectF(0.0f, 0.0f, (getWidth() - getPaddingLeft()) - getPaddingRight(), (getHeight() - getPaddingTop()) - getPaddingBottom());
    }

    public void setBorder(float f, int i) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-324913743")) {
            ipChange.ipc$dispatch("-324913743", new Object[]{this, Float.valueOf(f), Integer.valueOf(i)});
        } else if (f <= 0.0f) {
        } else {
            this.mBorderPaint.setColor(i);
            int dp2px = dp2px(f);
            this.mBorderWidth = dp2px;
            this.mBorderPaint.setStrokeWidth(dp2px);
            invalidate();
        }
    }

    public void setBorderRadius(int i) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1751224647")) {
            ipChange.ipc$dispatch("1751224647", new Object[]{this, Integer.valueOf(i)});
            return;
        }
        int dp2px = dp2px(i);
        if (this.mBorderRadius != dp2px) {
            this.mBorderRadius = dp2px;
            invalidate();
        }
    }

    public BannerImageView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.mMatrix = new Matrix();
        Paint paint = new Paint();
        this.mBitmapPaint = paint;
        paint.setAntiAlias(true);
        Paint paint2 = new Paint();
        this.mBorderPaint = paint2;
        paint2.setStyle(Paint.Style.STROKE);
        this.mBorderPaint.setAntiAlias(true);
        this.mBorderRadius = dp2px(6.0f);
    }
}
