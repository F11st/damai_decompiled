package com.baseproject.basecard.widget;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.RectF;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.util.TypedValue;
import android.view.View;
import android.widget.ImageView;
import com.baseproject.ui.R$dimen;
import com.baseproject.ui.R$styleable;
import com.taobao.uikit.extend.feature.view.TUrlImageView;
import com.youku.uplayer.AliMediaPlayer;
import com.youku.utils.YoukuUIUtil;

/* compiled from: Taobao */
/* loaded from: classes10.dex */
public class WithCornerMaskImageView extends TUrlImageView {
    private static final Bitmap.Config BITMAP_CONFIG = Bitmap.Config.ARGB_8888;
    private static final int COLORDRAWABLE_DIMENSION = 1;
    public static final int RATIO_TYPE_CHILD_BRAND_ZONE = 7;
    public static final int RATIO_TYPE_FREQUENCY = 6;
    public static final int RATIO_TYPE_HOME = 2;
    public static final int RATIO_TYPE_HOME_PAD_SLIDE = 3;
    public static final int RATIO_TYPE_NORMAL = 0;
    public static final int RATIO_TYPE_NORMAL_IMG = 5;
    public static final int RATIO_TYPE_OLYMPIC_ = 8;
    public static final int RATIO_TYPE_PORTRAIT = 4;
    public static final int RATIO_TYPE_WIDE = 1;
    public static final String TAG = "WithCornerMaskImageView";
    private boolean isCustomOnDraw;
    private boolean isNeedGifCorner;
    private Drawable mDrawable;
    private boolean mIsCanDrawCorner;
    private boolean mIsRightCorner;
    private int mMaskColor;
    private Path mMaskPath;
    private Paint mPaint;
    private float mRadius;
    private int mRoundPx;
    private RectF mTmpOval;
    private int ratio_type;

    public WithCornerMaskImageView(Context context, int i) {
        super(context);
        this.mRadius = 6.0f;
        this.mMaskColor = -1;
        this.mPaint = new Paint(1);
        this.mTmpOval = new RectF();
        this.ratio_type = i;
        this.mRadius = context.getResources().getDimensionPixelSize(R$dimen.home_img_corer_size);
    }

    private void addArc(Path path, float f, float f2, float f3, float f4, float f5, float f6) {
        if (this.mTmpOval == null) {
            this.mTmpOval = new RectF();
        }
        this.mTmpOval.set(f, f2, f3, f4);
        path.arcTo(this.mTmpOval, f5, f6);
    }

    private void initattrs(AttributeSet attributeSet) {
        this.ratio_type = getContext().obtainStyledAttributes(attributeSet, R$styleable.ChannelCellImageLayout).getInt(R$styleable.ChannelCellImageLayout_ratio, 0);
        this.mIsRightCorner = getContext().obtainStyledAttributes(attributeSet, R$styleable.WithCornerMaskImageView).getBoolean(R$styleable.WithCornerMaskImageView_is_right_corner, false);
    }

    private void recreateMask(int i, int i2) {
        if (i == 0 || i2 == 0) {
            return;
        }
        if (this.mMaskPath == null) {
            this.mMaskPath = new Path();
        }
        this.mMaskPath.reset();
        float f = this.mRadius * 2.0f;
        this.mMaskPath.moveTo(-2.0f, -2.0f);
        float f2 = i + 2;
        this.mMaskPath.lineTo(f2, -2.0f);
        float f3 = i2 + 2;
        this.mMaskPath.lineTo(f2, f3);
        this.mMaskPath.lineTo(-2.0f, f3);
        this.mMaskPath.close();
        this.mMaskPath.moveTo(this.mRadius, 0.0f);
        addArc(this.mMaskPath, 0.0f, 0.0f, f, f, -90.0f, -90.0f);
        float f4 = i2;
        this.mMaskPath.lineTo(0.0f, f4 - this.mRadius);
        float f5 = f4 - f;
        addArc(this.mMaskPath, 0.0f, f5, f, f4, 180.0f, -90.0f);
        float f6 = i;
        this.mMaskPath.lineTo(f6 - this.mRadius, f4);
        float f7 = f6 - f;
        addArc(this.mMaskPath, f7, f5, f6, f4, 90.0f, -90.0f);
        this.mMaskPath.lineTo(f6, this.mRadius);
        addArc(this.mMaskPath, f7, 0.0f, f6, f, 0.0f, -90.0f);
        this.mMaskPath.lineTo(this.mRadius, 0.0f);
        this.mMaskPath.close();
    }

    @Override // com.taobao.uikit.extend.feature.view.TUrlImageView, android.widget.ImageView
    public Drawable getDrawable() {
        boolean z = TUrlImageView.sTemporaryDrawableGetting;
        try {
            TUrlImageView.sTemporaryDrawableGetting = true;
            return super.getDrawable();
        } finally {
            TUrlImageView.sTemporaryDrawableGetting = z;
        }
    }

    public boolean isRightCorner() {
        return this.mIsRightCorner;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.taobao.uikit.feature.view.TImageView, android.widget.ImageView, android.view.View
    public void onDraw(Canvas canvas) {
        Drawable drawable;
        if (this.isCustomOnDraw && (drawable = getDrawable()) != null) {
            drawable.setBounds(0, 0, getWidth(), getHeight());
        }
        super.onDraw(canvas);
        if (!this.mIsRightCorner && this.isNeedGifCorner && this.mMaskPath != null) {
            this.mPaint.setStyle(Paint.Style.FILL);
            this.mPaint.setColor(this.mMaskColor);
            canvas.drawPath(this.mMaskPath, this.mPaint);
        }
        if (this.mDrawable != null) {
            canvas.save();
            canvas.clipRect(this.mDrawable.getBounds());
            this.mDrawable.draw(canvas);
            canvas.restore();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.taobao.uikit.feature.view.TImageView, android.widget.ImageView, android.view.View
    public void onMeasure(int i, int i2) {
        int i3;
        if (this.ratio_type == 5) {
            super.onMeasure(i, i2);
            return;
        }
        setMeasuredDimension(ImageView.getDefaultSize(0, i), ImageView.getDefaultSize(0, i2));
        int measuredWidth = getMeasuredWidth();
        int i4 = this.ratio_type;
        if (i4 == 1) {
            if (YoukuUIUtil.isPad(getContext())) {
                i3 = ((measuredWidth * 9) / 16) / 2;
            } else {
                i3 = (measuredWidth * 1) / 3;
            }
        } else if (i4 == 2) {
            if (YoukuUIUtil.isPad(getContext())) {
                i3 = ((measuredWidth * 9) / 16) / 2;
            } else {
                i3 = (measuredWidth * 7) / 15;
            }
        } else if (i4 == 3) {
            i3 = (measuredWidth * 7) / 15;
        } else if (i4 == 4) {
            i3 = (measuredWidth * 3) / 2;
        } else if (i4 == 7) {
            i3 = (measuredWidth * AliMediaPlayer.UPLAYER_PROPERTY_DRM_LICENSE_URI) / 219;
        } else if (i4 == 6) {
            i3 = (measuredWidth * 9) / 16;
        } else if (i4 == 8) {
            i3 = (measuredWidth * 5) / 7;
        } else {
            i3 = (measuredWidth * 9) / 16;
        }
        super.onMeasure(View.MeasureSpec.makeMeasureSpec(measuredWidth, 1073741824), View.MeasureSpec.makeMeasureSpec(i3, 1073741824));
    }

    @Override // android.view.View
    protected void onSizeChanged(int i, int i2, int i3, int i4) {
        super.onSizeChanged(i, i2, i3, i4);
        if (i3 == i && i4 == i2) {
            return;
        }
        recreateMask(i, i2);
    }

    public void setCanDrawCorner(boolean z) {
        this.mIsCanDrawCorner = z;
    }

    public void setCustomOnDraw(boolean z) {
        this.isCustomOnDraw = z;
    }

    public void setMask(Drawable drawable) {
        this.mDrawable = drawable;
    }

    public void setMaskColor(int i) {
        if ((i & (-16777216)) == 0) {
            i |= -16777216;
        }
        this.mMaskColor = i;
        invalidate();
    }

    public void setNeedGifCorner(boolean z) {
        this.isNeedGifCorner = z;
    }

    public void setRadius(float f, int i) {
        this.mRadius = TypedValue.applyDimension(i, f, getContext().getResources().getDisplayMetrics());
        recreateMask(getWidth(), getHeight());
        invalidate();
    }

    public void setRightCorner(boolean z) {
        this.mIsRightCorner = z;
    }

    public void setRadius(float f) {
        setRadius(f, 1);
    }

    public WithCornerMaskImageView(Context context) {
        super(context);
        this.mRadius = 6.0f;
        this.mMaskColor = -1;
        this.mPaint = new Paint(1);
        this.mTmpOval = new RectF();
        this.mRadius = context.getResources().getDimensionPixelSize(R$dimen.home_img_corer_size);
    }

    public WithCornerMaskImageView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.mRadius = 6.0f;
        this.mMaskColor = -1;
        this.mPaint = new Paint(1);
        this.mTmpOval = new RectF();
        initattrs(attributeSet);
        this.mRadius = context.getResources().getDimensionPixelSize(R$dimen.home_img_corer_size);
    }
}
