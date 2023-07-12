package com.youku.live.dago.widgetlib.interactive.gift.view.rc;

import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.PointF;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffXfermode;
import android.graphics.RectF;
import android.graphics.Region;
import android.os.Build;
import android.util.AttributeSet;
import android.view.View;
import android.widget.Checkable;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import com.youku.live.dago.widgetlib.R;
import java.util.ArrayList;

/* compiled from: Taobao */
/* loaded from: classes2.dex */
public class RCHelper {
    private static transient /* synthetic */ IpChange $ipChange;
    public Region mAreaRegion;
    public boolean mChecked;
    public boolean mClipBackground;
    public Path mClipPath;
    public int mDefaultStrokeColor;
    public RectF mLayer;
    public OnCheckedChangeListener mOnCheckedChangeListener;
    public Paint mPaint;
    public int mStrokeColor;
    public ColorStateList mStrokeColorStateList;
    public int mStrokeWidth;
    public float[] radii = new float[8];
    public boolean mRoundAsCircle = false;

    /* compiled from: Taobao */
    /* loaded from: classes2.dex */
    public interface OnCheckedChangeListener {
        void onCheckedChanged(View view, boolean z);
    }

    public void drawableStateChanged(View view) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1573858086")) {
            ipChange.ipc$dispatch("-1573858086", new Object[]{this, view});
        } else if (view instanceof RCAttrs) {
            ArrayList arrayList = new ArrayList();
            if (view instanceof Checkable) {
                arrayList.add(16842911);
                if (((Checkable) view).isChecked()) {
                    arrayList.add(16842912);
                }
            }
            if (view.isEnabled()) {
                arrayList.add(16842910);
            }
            if (view.isFocused()) {
                arrayList.add(16842908);
            }
            if (view.isPressed()) {
                arrayList.add(16842919);
            }
            if (view.isHovered()) {
                arrayList.add(16843623);
            }
            if (view.isSelected()) {
                arrayList.add(16842913);
            }
            if (view.isActivated()) {
                arrayList.add(16843518);
            }
            if (view.hasWindowFocus()) {
                arrayList.add(16842909);
            }
            ColorStateList colorStateList = this.mStrokeColorStateList;
            if (colorStateList == null || !colorStateList.isStateful()) {
                return;
            }
            int[] iArr = new int[arrayList.size()];
            for (int i = 0; i < arrayList.size(); i++) {
                iArr[i] = ((Integer) arrayList.get(i)).intValue();
            }
            ((RCAttrs) view).setStrokeColor(this.mStrokeColorStateList.getColorForState(iArr, this.mDefaultStrokeColor));
        }
    }

    public void initAttrs(Context context, AttributeSet attributeSet) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1661075269")) {
            ipChange.ipc$dispatch("1661075269", new Object[]{this, context, attributeSet});
            return;
        }
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R.styleable.Dago_Pgc_RCAttrs);
        this.mRoundAsCircle = obtainStyledAttributes.getBoolean(R.styleable.Dago_Pgc_RCAttrs_round_as_circle, false);
        ColorStateList colorStateList = obtainStyledAttributes.getColorStateList(R.styleable.Dago_Pgc_RCAttrs_dago_pgc_stroke_color);
        this.mStrokeColorStateList = colorStateList;
        if (colorStateList != null) {
            this.mStrokeColor = colorStateList.getDefaultColor();
            this.mDefaultStrokeColor = this.mStrokeColorStateList.getDefaultColor();
        } else {
            this.mStrokeColor = -1;
            this.mDefaultStrokeColor = -1;
        }
        this.mStrokeWidth = obtainStyledAttributes.getDimensionPixelSize(R.styleable.Dago_Pgc_RCAttrs_dago_pgc_stroke_width, 0);
        this.mClipBackground = obtainStyledAttributes.getBoolean(R.styleable.Dago_Pgc_RCAttrs_clip_background, false);
        int dimensionPixelSize = obtainStyledAttributes.getDimensionPixelSize(R.styleable.Dago_Pgc_RCAttrs_round_corner, 0);
        int dimensionPixelSize2 = obtainStyledAttributes.getDimensionPixelSize(R.styleable.Dago_Pgc_RCAttrs_round_corner_top_left, dimensionPixelSize);
        int dimensionPixelSize3 = obtainStyledAttributes.getDimensionPixelSize(R.styleable.Dago_Pgc_RCAttrs_round_corner_top_right, dimensionPixelSize);
        int dimensionPixelSize4 = obtainStyledAttributes.getDimensionPixelSize(R.styleable.Dago_Pgc_RCAttrs_round_corner_bottom_left, dimensionPixelSize);
        int dimensionPixelSize5 = obtainStyledAttributes.getDimensionPixelSize(R.styleable.Dago_Pgc_RCAttrs_round_corner_bottom_right, dimensionPixelSize);
        obtainStyledAttributes.recycle();
        float[] fArr = this.radii;
        float f = dimensionPixelSize2;
        fArr[0] = f;
        fArr[1] = f;
        float f2 = dimensionPixelSize3;
        fArr[2] = f2;
        fArr[3] = f2;
        float f3 = dimensionPixelSize5;
        fArr[4] = f3;
        fArr[5] = f3;
        float f4 = dimensionPixelSize4;
        fArr[6] = f4;
        fArr[7] = f4;
        this.mLayer = new RectF();
        this.mClipPath = new Path();
        this.mAreaRegion = new Region();
        Paint paint = new Paint();
        this.mPaint = paint;
        paint.setColor(-1);
        this.mPaint.setAntiAlias(true);
    }

    public void onClipDraw(Canvas canvas) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1185054081")) {
            ipChange.ipc$dispatch("-1185054081", new Object[]{this, canvas});
            return;
        }
        if (this.mStrokeWidth > 0) {
            this.mPaint.setXfermode(new PorterDuffXfermode(PorterDuff.Mode.DST_OUT));
            this.mPaint.setColor(-1);
            this.mPaint.setStrokeWidth(this.mStrokeWidth * 2);
            this.mPaint.setStyle(Paint.Style.STROKE);
            canvas.drawPath(this.mClipPath, this.mPaint);
            this.mPaint.setXfermode(new PorterDuffXfermode(PorterDuff.Mode.SRC_OVER));
            this.mPaint.setColor(this.mStrokeColor);
            this.mPaint.setStyle(Paint.Style.STROKE);
            canvas.drawPath(this.mClipPath, this.mPaint);
        }
        this.mPaint.setColor(-1);
        this.mPaint.setStyle(Paint.Style.FILL);
        if (Build.VERSION.SDK_INT <= 19) {
            this.mPaint.setXfermode(new PorterDuffXfermode(PorterDuff.Mode.DST_IN));
            canvas.drawPath(this.mClipPath, this.mPaint);
            return;
        }
        this.mPaint.setXfermode(new PorterDuffXfermode(PorterDuff.Mode.DST_OUT));
        Path path = new Path();
        path.addRect(0.0f, 0.0f, (int) this.mLayer.width(), (int) this.mLayer.height(), Path.Direction.CW);
        path.op(this.mClipPath, Path.Op.DIFFERENCE);
        canvas.drawPath(path, this.mPaint);
    }

    public void onSizeChanged(View view, int i, int i2) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "667871029")) {
            ipChange.ipc$dispatch("667871029", new Object[]{this, view, Integer.valueOf(i), Integer.valueOf(i2)});
            return;
        }
        this.mLayer.set(0.0f, 0.0f, i, i2);
        refreshRegion(view);
    }

    public void refreshRegion(View view) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1899054960")) {
            ipChange.ipc$dispatch("1899054960", new Object[]{this, view});
            return;
        }
        int width = (int) this.mLayer.width();
        int height = (int) this.mLayer.height();
        RectF rectF = new RectF();
        rectF.left = view.getPaddingLeft();
        rectF.top = view.getPaddingTop();
        rectF.right = width - view.getPaddingRight();
        rectF.bottom = height - view.getPaddingBottom();
        this.mClipPath.reset();
        if (this.mRoundAsCircle) {
            float height2 = (rectF.width() >= rectF.height() ? rectF.height() : rectF.width()) / 2.0f;
            float f = height / 2;
            PointF pointF = new PointF(width / 2, f);
            if (Build.VERSION.SDK_INT <= 19) {
                this.mClipPath.addCircle(pointF.x, pointF.y, height2, Path.Direction.CW);
                this.mClipPath.moveTo(0.0f, 0.0f);
                this.mClipPath.moveTo(width, height);
            } else {
                float f2 = f - height2;
                this.mClipPath.moveTo(rectF.left, f2);
                this.mClipPath.addCircle(pointF.x, f2 + height2, height2, Path.Direction.CW);
            }
        } else {
            this.mClipPath.addRoundRect(rectF, this.radii, Path.Direction.CW);
        }
        this.mAreaRegion.setPath(this.mClipPath, new Region((int) rectF.left, (int) rectF.top, (int) rectF.right, (int) rectF.bottom));
    }
}
