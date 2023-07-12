package com.alibaba.pictures.bricks.view;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.LinearGradient;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.RectF;
import android.graphics.Shader;
import android.util.AttributeSet;
import android.widget.LinearLayout;
import androidx.annotation.Nullable;
import com.alibaba.pictures.R$styleable;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;

/* compiled from: Taobao */
/* loaded from: classes7.dex */
public class BricksStrokeLinearLayout extends LinearLayout {
    private static transient /* synthetic */ IpChange $ipChange;
    private int cornerRadius;
    private int[] gradientColors;
    private boolean isStrokeChanged;
    private RectF mBounds;
    private Path mClipPath;
    private RectF mTemp;
    private int strokeColor;
    private Paint strokePaint;
    private int strokeWidth;

    public BricksStrokeLinearLayout(Context context) {
        this(context, null);
    }

    private void clearRule() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1567564763")) {
            ipChange.ipc$dispatch("-1567564763", new Object[]{this});
            return;
        }
        this.mClipPath = null;
        this.strokePaint = null;
    }

    private void drawStrokeIfNeed(Canvas canvas, RectF rectF) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1359724183")) {
            ipChange.ipc$dispatch("-1359724183", new Object[]{this, canvas, rectF});
        } else if (this.strokeWidth <= 0 || rectF == null || this.cornerRadius < 0) {
        } else {
            ensureStrokePaint();
            Paint paint = this.strokePaint;
            if (paint != null) {
                float f = this.strokeWidth / 2.0f;
                RectF rectF2 = this.mTemp;
                rectF2.top = rectF.top + f;
                rectF2.bottom = rectF.bottom - f;
                rectF2.left = rectF.left + f;
                rectF2.right = rectF.right - f;
                int i = this.cornerRadius;
                canvas.drawRoundRect(rectF2, i, i, paint);
            }
        }
    }

    private void ensureStrokePaint() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "2097988550")) {
            ipChange.ipc$dispatch("2097988550", new Object[]{this});
        } else if (this.strokePaint != null) {
        } else {
            int width = getWidth();
            int height = getHeight();
            if (this.strokeWidth <= 0 || width <= 0 || height <= 0) {
                return;
            }
            Paint paint = new Paint(1);
            this.strokePaint = paint;
            paint.setStyle(Paint.Style.STROKE);
            this.strokePaint.setStrokeWidth(this.strokeWidth);
            int[] iArr = this.gradientColors;
            if (iArr != null && iArr.length >= 2) {
                this.strokePaint.setShader(new LinearGradient(0.0f, 0.0f, 0.0f, height, this.gradientColors, (float[]) null, Shader.TileMode.CLAMP));
            } else {
                this.strokePaint.setColor(this.strokeColor);
            }
        }
    }

    private void tryMakeClipPath(RectF rectF) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "41662017")) {
            ipChange.ipc$dispatch("41662017", new Object[]{this, rectF});
        } else if (this.mClipPath != null || rectF.width() <= 0.0f || rectF.height() <= 0.0f || this.cornerRadius <= 0) {
        } else {
            Path path = new Path();
            this.mClipPath = path;
            int i = this.cornerRadius;
            path.addRoundRect(rectF, i, i, Path.Direction.CW);
        }
    }

    @Override // android.view.View
    public void draw(Canvas canvas) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1263080307")) {
            ipChange.ipc$dispatch("-1263080307", new Object[]{this, canvas});
            return;
        }
        this.mBounds.set(0.0f, 0.0f, getWidth(), getHeight());
        tryMakeClipPath(this.mBounds);
        try {
            if (this.mClipPath != null) {
                canvas.save();
                canvas.clipPath(this.mClipPath);
                super.draw(canvas);
                canvas.restore();
            } else {
                super.draw(canvas);
            }
            drawStrokeIfNeed(canvas, this.mBounds);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override // android.view.View
    protected void onSizeChanged(int i, int i2, int i3, int i4) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "612422234")) {
            ipChange.ipc$dispatch("612422234", new Object[]{this, Integer.valueOf(i), Integer.valueOf(i2), Integer.valueOf(i3), Integer.valueOf(i4)});
        } else {
            clearRule();
        }
    }

    public void setCornerAndStroke(int i, int i2, int i3) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1455451361")) {
            ipChange.ipc$dispatch("-1455451361", new Object[]{this, Integer.valueOf(i), Integer.valueOf(i2), Integer.valueOf(i3)});
            return;
        }
        if (i2 < 0) {
            i2 = 0;
        }
        if (i < 0) {
            i = 0;
        }
        this.strokeWidth = i2;
        this.cornerRadius = i;
        this.strokeColor = i3;
        this.gradientColors = null;
        clearRule();
        invalidate();
    }

    public BricksStrokeLinearLayout(Context context, @Nullable AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public BricksStrokeLinearLayout(Context context, @Nullable AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.mBounds = new RectF();
        this.mTemp = new RectF();
        this.isStrokeChanged = false;
        setWillNotDraw(false);
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R$styleable.BricksStrokeLinearLayout);
        this.cornerRadius = obtainStyledAttributes.getDimensionPixelSize(R$styleable.BricksStrokeLinearLayout_sl_corners_radius, 0);
        this.strokeWidth = obtainStyledAttributes.getDimensionPixelSize(R$styleable.BricksStrokeLinearLayout_sl_stroke_width, 0);
        this.strokeColor = obtainStyledAttributes.getColor(R$styleable.BricksStrokeLinearLayout_sl_stroke_color, -1);
        obtainStyledAttributes.recycle();
    }

    public void setCornerAndStroke(int i, int i2, int[] iArr) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "2126213746")) {
            ipChange.ipc$dispatch("2126213746", new Object[]{this, Integer.valueOf(i), Integer.valueOf(i2), iArr});
            return;
        }
        if (i2 < 0) {
            i2 = 0;
        }
        if (i < 0) {
            i = 0;
        }
        this.strokeWidth = i2;
        this.cornerRadius = i;
        this.gradientColors = iArr;
        clearRule();
        invalidate();
    }
}
