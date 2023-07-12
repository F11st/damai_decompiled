package cn.damai.commonbusiness.coupondialog;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffXfermode;
import android.graphics.RectF;
import android.util.AttributeSet;
import android.widget.LinearLayout;
import cn.damai.commonbusiness.R$styleable;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;

/* compiled from: Taobao */
/* loaded from: classes14.dex */
public class CouponStyleLinearLayout extends LinearLayout {
    private static transient /* synthetic */ IpChange $ipChange = null;
    private static final int CIRCLE = 0;
    public static final int DRAW_HORIZONTAL = 0;
    public static final int DRAW_VERTICAL = 1;

    /* renamed from: DRAW_ＡROUND  reason: contains not printable characters */
    public static final int f0DRAW_ROUND = 2;
    private static final int ELLIPSE = 1;
    private static final int SQUARE = 3;
    private static final int TRIANGLE = 2;
    private int drawType;
    private Bitmap mBitmap;
    private Canvas mCanvas;
    private int mCircleNum_H;
    private int mCircleNum_V;
    private float mGap;
    private int mOrientation;
    private Paint mPaint;
    private int mPaintColor;
    private float mRadius;
    private float mRemain_H;
    private float mRemain_V;

    public CouponStyleLinearLayout(Context context) {
        this(context, null);
    }

    private void drawHorCircle() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1814377852")) {
            ipChange.ipc$dispatch("1814377852", new Object[]{this});
            return;
        }
        for (int i = 0; i < this.mCircleNum_H; i++) {
            float f = this.mGap;
            float f2 = this.mRadius;
            float f3 = f + f2 + (this.mRemain_H / 2.0f) + ((f + (2.0f * f2)) * i);
            this.mCanvas.drawCircle(f3, 0.0f, f2, this.mPaint);
            this.mCanvas.drawCircle(f3, getHeight(), this.mRadius, this.mPaint);
        }
    }

    private void drawHorEllipse() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1816896288")) {
            ipChange.ipc$dispatch("-1816896288", new Object[]{this});
            return;
        }
        for (int i = 0; i < this.mCircleNum_H; i++) {
            float f = this.mGap;
            float f2 = this.mRadius;
            float f3 = f + f2 + (this.mRemain_H / 2.0f) + ((f + (f2 * 2.0f)) * i);
            RectF rectF = new RectF();
            float f4 = this.mRadius;
            rectF.left = f3 - f4;
            rectF.right = f3 + f4;
            rectF.top = 0.0f;
            rectF.bottom = f4;
            this.mCanvas.drawOval(rectF, this.mPaint);
            rectF.top = getHeight() - this.mRadius;
            rectF.bottom = getHeight();
            this.mCanvas.drawOval(rectF, this.mPaint);
        }
    }

    private void drawHorSquare() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1961682417")) {
            ipChange.ipc$dispatch("-1961682417", new Object[]{this});
            return;
        }
        for (int i = 0; i < this.mCircleNum_H; i++) {
            float f = this.mGap;
            float f2 = this.mRadius;
            float f3 = f + f2 + (this.mRemain_H / 2.0f) + ((f + (f2 * 2.0f)) * i);
            this.mCanvas.drawRect(0.0f, f3, 0.0f, f2, this.mPaint);
            RectF rectF = new RectF();
            float f4 = this.mRadius;
            rectF.left = f3 - (f4 / 2.0f);
            rectF.right = f3 + (f4 / 2.0f);
            rectF.top = 0.0f;
            rectF.bottom = f4;
            this.mCanvas.drawRect(rectF, this.mPaint);
            rectF.top = getHeight() - this.mRadius;
            rectF.bottom = getHeight();
            this.mCanvas.drawRect(rectF, this.mPaint);
        }
    }

    private void drawHorTriangle() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-598252668")) {
            ipChange.ipc$dispatch("-598252668", new Object[]{this});
            return;
        }
        for (int i = 0; i < this.mCircleNum_H; i++) {
            float f = this.mGap;
            float f2 = this.mRadius;
            float f3 = f + f2 + (this.mRemain_H / 2.0f) + ((f + (f2 * 2.0f)) * i);
            Path path = new Path();
            path.moveTo(f3 - this.mRadius, 0.0f);
            path.lineTo(this.mRadius + f3, 0.0f);
            path.lineTo(f3, this.mRadius);
            path.lineTo(f3 - this.mRadius, 0.0f);
            path.close();
            this.mCanvas.drawPath(path, this.mPaint);
            path.moveTo(f3 - this.mRadius, getHeight());
            path.lineTo(this.mRadius + f3, getHeight());
            path.lineTo(f3, getHeight() - this.mRadius);
            path.lineTo(f3 - this.mRadius, getHeight());
            path.close();
            this.mCanvas.drawPath(path, this.mPaint);
        }
    }

    private void drawVelCircle() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1295294058")) {
            ipChange.ipc$dispatch("1295294058", new Object[]{this});
            return;
        }
        for (int i = 0; i < this.mCircleNum_V; i++) {
            float f = this.mGap;
            float f2 = this.mRadius;
            float f3 = f + f2 + (this.mRemain_V / 2.0f) + ((f + (2.0f * f2)) * i);
            this.mCanvas.drawCircle(0.0f, f3, f2, this.mPaint);
            this.mCanvas.drawCircle(getWidth(), f3, this.mRadius, this.mPaint);
        }
    }

    private void drawVelEllipse() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-728624718")) {
            ipChange.ipc$dispatch("-728624718", new Object[]{this});
            return;
        }
        for (int i = 0; i < this.mCircleNum_V; i++) {
            float f = this.mGap;
            float f2 = this.mRadius;
            float f3 = f + f2 + (this.mRemain_V / 2.0f) + ((f + (f2 * 2.0f)) * i);
            RectF rectF = new RectF();
            rectF.left = 0.0f;
            float f4 = this.mRadius;
            rectF.right = f4;
            rectF.top = f3 - f4;
            rectF.bottom = f3 + f4;
            this.mCanvas.drawOval(rectF, this.mPaint);
            rectF.left = getWidth() - this.mRadius;
            rectF.right = getWidth();
            this.mCanvas.drawOval(rectF, this.mPaint);
        }
    }

    private void drawVelSquare() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1814201085")) {
            ipChange.ipc$dispatch("1814201085", new Object[]{this});
            return;
        }
        for (int i = 0; i < this.mCircleNum_V; i++) {
            float f = this.mGap;
            float f2 = this.mRadius;
            float f3 = f + f2 + (this.mRemain_V / 2.0f) + ((f + (f2 * 2.0f)) * i);
            RectF rectF = new RectF();
            rectF.left = 0.0f;
            float f4 = this.mRadius;
            rectF.right = f4 / 2.0f;
            rectF.top = f3 - (f4 / 2.0f);
            rectF.bottom = f3 + f4;
            this.mCanvas.drawRect(rectF, this.mPaint);
            rectF.left = getWidth() - this.mRadius;
            rectF.right = getWidth();
            this.mCanvas.drawRect(rectF, this.mPaint);
        }
    }

    private void drawVelTriangle() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1221572366")) {
            ipChange.ipc$dispatch("-1221572366", new Object[]{this});
            return;
        }
        for (int i = 0; i < this.mCircleNum_V; i++) {
            float f = this.mGap;
            float f2 = this.mRadius;
            float f3 = f + f2 + (this.mRemain_V / 2.0f) + ((f + (f2 * 2.0f)) * i);
            Path path = new Path();
            path.moveTo(0.0f, f3 - this.mRadius);
            path.lineTo(0.0f, this.mRadius + f3);
            path.lineTo(this.mRadius, f3);
            path.lineTo(0.0f, f3 - this.mRadius);
            path.close();
            this.mCanvas.drawPath(path, this.mPaint);
            path.moveTo(getWidth(), f3 - this.mRadius);
            path.lineTo(getWidth(), this.mRadius + f3);
            path.lineTo(getWidth() - this.mRadius, f3);
            path.lineTo(getWidth(), f3 - this.mRadius);
            path.close();
            this.mCanvas.drawPath(path, this.mPaint);
        }
    }

    private void initDrawCanvas(int i, int i2) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1887979797")) {
            ipChange.ipc$dispatch("-1887979797", new Object[]{this, Integer.valueOf(i), Integer.valueOf(i2)});
            return;
        }
        if (getBackground() == null) {
            setBackgroundColor(0);
        }
        this.mBitmap = Bitmap.createBitmap(i, i2, Bitmap.Config.ARGB_8888);
        Canvas canvas = new Canvas(this.mBitmap);
        this.mCanvas = canvas;
        canvas.drawColor(this.mPaintColor);
    }

    private void initPaint() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1350099973")) {
            ipChange.ipc$dispatch("1350099973", new Object[]{this});
            return;
        }
        Paint paint = new Paint(1);
        this.mPaint = paint;
        paint.setDither(true);
        this.mPaint.setXfermode(new PorterDuffXfermode(PorterDuff.Mode.DST_OUT));
        this.mPaint.setStyle(Paint.Style.FILL);
    }

    private void measureHorNum(int i) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1594793513")) {
            ipChange.ipc$dispatch("1594793513", new Object[]{this, Integer.valueOf(i)});
            return;
        }
        if (this.mRemain_H == 0.0f) {
            float f = this.mGap;
            this.mRemain_H = (i - f) % ((this.mRadius * 2.0f) + f);
        }
        float f2 = this.mGap;
        this.mCircleNum_H = (int) ((i - f2) / ((this.mRadius * 2.0f) + f2));
    }

    private void measureVelNum(int i) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-2128647529")) {
            ipChange.ipc$dispatch("-2128647529", new Object[]{this, Integer.valueOf(i)});
            return;
        }
        if (this.mRemain_V == 0.0f) {
            float f = this.mGap;
            this.mRemain_V = (i - f) % ((this.mRadius * 2.0f) + f);
        }
        float f2 = this.mGap;
        this.mCircleNum_V = (int) ((i - f2) / ((this.mRadius * 2.0f) + f2));
    }

    @Override // android.widget.LinearLayout, android.view.View
    protected void onDraw(Canvas canvas) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-320738607")) {
            ipChange.ipc$dispatch("-320738607", new Object[]{this, canvas});
            return;
        }
        super.onDraw(canvas);
        canvas.drawBitmap(this.mBitmap, 0.0f, 0.0f, (Paint) null);
        int i = this.mOrientation;
        if (i == 0) {
            int i2 = this.drawType;
            if (i2 == 0) {
                drawHorCircle();
            } else if (i2 == 1) {
                drawHorEllipse();
            } else if (i2 == 2) {
                drawHorTriangle();
            } else if (i2 == 3) {
                drawHorSquare();
            }
        } else if (i == 1) {
            int i3 = this.drawType;
            if (i3 == 0) {
                drawVelCircle();
            } else if (i3 == 1) {
                drawVelEllipse();
            } else if (i3 == 2) {
                drawVelTriangle();
            } else if (i3 == 3) {
                drawVelSquare();
            }
        } else if (i != 2) {
        } else {
            int i4 = this.drawType;
            if (i4 == 0) {
                drawHorCircle();
                drawVelCircle();
            } else if (i4 == 1) {
                drawHorEllipse();
                drawVelEllipse();
            } else if (i4 == 2) {
                drawHorTriangle();
                drawVelTriangle();
            } else if (i4 == 3) {
                drawHorSquare();
                drawVelSquare();
            }
        }
    }

    @Override // android.view.View
    protected void onSizeChanged(int i, int i2, int i3, int i4) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-456449633")) {
            ipChange.ipc$dispatch("-456449633", new Object[]{this, Integer.valueOf(i), Integer.valueOf(i2), Integer.valueOf(i3), Integer.valueOf(i4)});
            return;
        }
        super.onSizeChanged(i, i2, i3, i4);
        initDrawCanvas(i, i2);
        int i5 = this.mOrientation;
        if (i5 == 0) {
            measureHorNum(i);
        } else if (i5 == 1) {
            measureVelNum(i2);
        } else if (i5 != 2) {
        } else {
            measureHorNum(i);
            measureVelNum(i2);
        }
    }

    @Override // android.widget.LinearLayout
    public void setOrientation(int i) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "799159610")) {
            ipChange.ipc$dispatch("799159610", new Object[]{this, Integer.valueOf(i)});
        }
    }

    public CouponStyleLinearLayout(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public CouponStyleLinearLayout(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        if (attributeSet != null) {
            TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R$styleable.CouponStyleLinearLayout, 0, 0);
            this.drawType = obtainStyledAttributes.getInt(R$styleable.CouponStyleLinearLayout_drawType, 0);
            this.mOrientation = obtainStyledAttributes.getInt(R$styleable.CouponStyleLinearLayout_orientation_dm, 0);
            this.mGap = obtainStyledAttributes.getDimensionPixelOffset(R$styleable.CouponStyleLinearLayout_mGap, 5);
            this.mRadius = obtainStyledAttributes.getDimensionPixelOffset(R$styleable.CouponStyleLinearLayout_mRadius, 10);
            this.mPaintColor = obtainStyledAttributes.getColor(R$styleable.CouponStyleLinearLayout_BgColor, -4144960);
            obtainStyledAttributes.recycle();
        }
        initPaint();
    }
}
