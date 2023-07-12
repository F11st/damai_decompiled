package com.scwang.smartrefresh.header;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Point;
import android.util.AttributeSet;
import androidx.annotation.NonNull;
import androidx.core.graphics.ColorUtils;
import com.scwang.smartrefresh.header.fungame.FunGameView;
import com.scwang.smartrefresh.layout.api.RefreshKernel;
import com.scwang.smartrefresh.layout.util.DensityUtil;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* compiled from: Taobao */
/* loaded from: classes6.dex */
public class FunGameHitBlockHeader extends FunGameView {
    protected static final int BLOCK_HORIZONTAL_NUM = 3;
    protected static final float BLOCK_POSITION_RATIO = 0.08f;
    protected static final int BLOCK_VERTICAL_NUM = 5;
    protected static final float BLOCK_WIDTH_RATIO = 0.01806f;
    protected static final int DEFAULT_ANGLE = 30;
    static final float DIVIDING_LINE_SIZE = 1.0f;
    protected static final float RACKET_POSITION_RATIO = 0.8f;
    protected static final int SPEED = 3;
    protected float BALL_RADIUS;
    protected int angle;
    protected float blockHeight;
    protected int blockHorizontalNum;
    protected float blockLeft;
    protected Paint blockPaint;
    protected float blockWidth;
    protected float cx;
    protected float cy;
    protected boolean isLeft;
    protected List<Point> pointList;
    protected float racketLeft;
    protected int speed;

    public FunGameHitBlockHeader(Context context) {
        this(context, null);
    }

    protected boolean checkTouchBlock(float f, float f2) {
        int i = (int) ((((f - this.blockLeft) - this.BALL_RADIUS) - this.speed) / this.blockWidth);
        if (i == this.blockHorizontalNum) {
            i--;
        }
        int i2 = (int) (f2 / this.blockHeight);
        if (i2 == 5) {
            i2--;
        }
        Point point = new Point();
        point.set(i, i2);
        boolean z = false;
        Iterator<Point> it = this.pointList.iterator();
        while (true) {
            if (!it.hasNext()) {
                break;
            } else if (it.next().equals(com.alibaba.wireless.security.aopsdk.replace.android.graphics.Point.getx(point), com.alibaba.wireless.security.aopsdk.replace.android.graphics.Point.gety(point))) {
                z = true;
                break;
            }
        }
        if (!z) {
            this.pointList.add(point);
        }
        return !z;
    }

    protected boolean checkTouchRacket(float f) {
        float f2 = f - this.controllerPosition;
        return f2 >= 0.0f && f2 <= ((float) this.controllerSize);
    }

    protected void drawBallPath(Canvas canvas, int i) {
        int i2;
        this.mPaint.setColor(this.mModelColor);
        float f = this.cx;
        if (f <= this.blockLeft + (this.blockHorizontalNum * this.blockWidth) + ((i2 - 1) * 1.0f) + this.BALL_RADIUS && checkTouchBlock(f, this.cy)) {
            this.isLeft = false;
        }
        float f2 = this.cx;
        float f3 = this.blockLeft;
        float f4 = this.BALL_RADIUS;
        if (f2 <= f3 + f4) {
            this.isLeft = false;
        }
        float f5 = this.racketLeft;
        if (f2 + f4 < f5 || f2 - f4 >= f5 + this.blockWidth) {
            if (f2 > i) {
                this.status = 2;
            }
        } else if (checkTouchRacket(this.cy)) {
            if (this.pointList.size() == this.blockHorizontalNum * 5) {
                this.status = 2;
                return;
            }
            this.isLeft = true;
        }
        float f6 = this.cy;
        float f7 = this.BALL_RADIUS;
        if (f6 <= f7 + 1.0f) {
            this.angle = 150;
        } else if (f6 >= (this.mHeaderHeight - f7) - 1.0f) {
            this.angle = 210;
        }
        if (this.isLeft) {
            this.cx -= this.speed;
        } else {
            this.cx += this.speed;
        }
        float tan = f6 - (((float) Math.tan(Math.toRadians(this.angle))) * this.speed);
        this.cy = tan;
        canvas.drawCircle(this.cx, tan, this.BALL_RADIUS, this.mPaint);
        invalidate();
    }

    protected void drawColorBlock(Canvas canvas) {
        boolean z;
        int i = 0;
        while (true) {
            int i2 = this.blockHorizontalNum;
            if (i >= i2 * 5) {
                return;
            }
            int i3 = i / i2;
            int i4 = i % i2;
            Iterator<Point> it = this.pointList.iterator();
            while (true) {
                if (!it.hasNext()) {
                    z = false;
                    break;
                } else if (it.next().equals(i4, i3)) {
                    z = true;
                    break;
                }
            }
            if (!z) {
                this.blockPaint.setColor(ColorUtils.setAlphaComponent(this.lModelColor, 255 / (i4 + 1)));
                float f = this.blockLeft;
                float f2 = this.blockWidth;
                float f3 = f + (i4 * (f2 + 1.0f));
                float f4 = i3;
                float f5 = this.blockHeight;
                float f6 = (f4 * (f5 + 1.0f)) + 1.0f;
                canvas.drawRect(f3, f6, f3 + f2, f6 + f5, this.blockPaint);
            }
            i++;
        }
    }

    @Override // com.scwang.smartrefresh.header.fungame.FunGameView
    protected void drawGame(Canvas canvas, int i, int i2) {
        drawColorBlock(canvas);
        drawRacket(canvas);
        int i3 = this.status;
        if (i3 == 1 || i3 == 3 || i3 == 4 || isInEditMode()) {
            drawBallPath(canvas, i);
        }
    }

    protected void drawRacket(Canvas canvas) {
        this.mPaint.setColor(this.rModelColor);
        float f = this.racketLeft;
        float f2 = this.controllerPosition;
        canvas.drawRect(f, f2, f + this.blockWidth, f2 + this.controllerSize, this.mPaint);
    }

    @Override // com.scwang.smartrefresh.header.fungame.FunGameView, com.scwang.smartrefresh.header.fungame.FunGameBase, com.scwang.smartrefresh.layout.internal.InternalAbstract, com.scwang.smartrefresh.layout.api.RefreshInternal
    public void onInitialized(@NonNull RefreshKernel refreshKernel, int i, int i2) {
        int measuredWidth = getMeasuredWidth();
        float f = (i / 5) - 1.0f;
        this.blockHeight = f;
        float f2 = measuredWidth;
        this.blockWidth = BLOCK_WIDTH_RATIO * f2;
        this.blockLeft = BLOCK_POSITION_RATIO * f2;
        this.racketLeft = f2 * 0.8f;
        this.controllerSize = (int) (f * 1.6f);
        super.onInitialized(refreshKernel, i, i2);
    }

    @Override // com.scwang.smartrefresh.header.fungame.FunGameView
    protected void resetConfigParams() {
        this.cx = this.racketLeft - (this.BALL_RADIUS * 3.0f);
        this.cy = (int) (this.mHeaderHeight * 0.5f);
        this.controllerPosition = 1.0f;
        this.angle = 30;
        this.isLeft = true;
        List<Point> list = this.pointList;
        if (list == null) {
            this.pointList = new ArrayList();
        } else {
            list.clear();
        }
    }

    public FunGameHitBlockHeader(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public FunGameHitBlockHeader(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R$styleable.FunGameHitBlockHeader);
        this.speed = obtainStyledAttributes.getInt(R$styleable.FunGameHitBlockHeader_fghBallSpeed, DensityUtil.dp2px(3.0f));
        this.blockHorizontalNum = obtainStyledAttributes.getInt(R$styleable.FunGameHitBlockHeader_fghBlockHorizontalNum, 3);
        obtainStyledAttributes.recycle();
        Paint paint = new Paint(1);
        this.blockPaint = paint;
        paint.setStyle(Paint.Style.FILL);
        this.BALL_RADIUS = DensityUtil.dp2px(4.0f);
    }
}
