package in.srain.cube.views.ptr.header;

import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.PointF;
import android.view.animation.Animation;
import android.view.animation.Transformation;
import java.util.Random;

/* compiled from: Taobao */
/* loaded from: classes3.dex */
public class StoreHouseBarItem extends Animation {
    public int index;
    private PointF mCEndPoint;
    private PointF mCStartPoint;
    private float mFromAlpha;
    private final Paint mPaint;
    private float mToAlpha;
    public PointF midPoint;
    public float translationX;

    public StoreHouseBarItem(int i, PointF pointF, PointF pointF2, int i2, int i3) {
        Paint paint = new Paint();
        this.mPaint = paint;
        this.mFromAlpha = 1.0f;
        this.mToAlpha = 0.4f;
        this.index = i;
        this.midPoint = new PointF((pointF.x + pointF2.x) / 2.0f, (pointF.y + pointF2.y) / 2.0f);
        float f = pointF.x;
        PointF pointF3 = this.midPoint;
        this.mCStartPoint = new PointF(f - pointF3.x, pointF.y - pointF3.y);
        float f2 = pointF2.x;
        PointF pointF4 = this.midPoint;
        this.mCEndPoint = new PointF(f2 - pointF4.x, pointF2.y - pointF4.y);
        setColor(i2);
        setLineWidth(i3);
        paint.setAntiAlias(true);
        paint.setStyle(Paint.Style.STROKE);
    }

    @Override // android.view.animation.Animation
    protected void applyTransformation(float f, Transformation transformation) {
        float f2 = this.mFromAlpha;
        setAlpha(f2 + ((this.mToAlpha - f2) * f));
    }

    public void draw(Canvas canvas) {
        PointF pointF = this.mCStartPoint;
        float f = pointF.x;
        float f2 = pointF.y;
        PointF pointF2 = this.mCEndPoint;
        canvas.drawLine(f, f2, pointF2.x, pointF2.y, this.mPaint);
    }

    public void resetPosition(int i) {
        this.translationX = (-new Random().nextInt(i)) + i;
    }

    public void setAlpha(float f) {
        this.mPaint.setAlpha((int) (f * 255.0f));
    }

    public void setColor(int i) {
        this.mPaint.setColor(i);
    }

    public void setLineWidth(int i) {
        this.mPaint.setStrokeWidth(i);
    }

    public void start(float f, float f2) {
        this.mFromAlpha = f;
        this.mToAlpha = f2;
        super.start();
    }
}
