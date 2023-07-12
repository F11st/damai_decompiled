package cn.damai.commonbusiness.photoselect.imageselected.view;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.PointF;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffXfermode;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.Xfermode;
import android.util.AttributeSet;
import android.util.DisplayMetrics;
import android.view.MotionEvent;
import android.view.WindowManager;
import android.widget.ImageView;
import androidx.appcompat.widget.AppCompatImageView;
import com.alibaba.wireless.security.aopsdk.replace.android.view.Display;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import tb.v;

/* compiled from: Taobao */
/* loaded from: classes4.dex */
public class ClipImageView extends AppCompatImageView {
    private static transient /* synthetic */ IpChange $ipChange;
    private int CURR_MODE;
    private final int MODE_DRAG;
    private final int MODE_NONE;
    private final int MODE_POINTER_UP;
    private final int MODE_ZOOM;
    private boolean isCutImage;
    private int mBitmapHeight;
    private int mBitmapWidth;
    private float mCircleCenterX;
    private float mCircleCenterY;
    private float mCircleX;
    private float mCircleY;
    private PointF mDownPoint;
    private Paint mFrontGroundPaint;
    private float mLastDistance;
    private Matrix mMatrix;
    private PointF mMiddlePoint;
    private int mTargetHeight;
    private int mTargetWidth;
    private Matrix mTempMatrix;
    private Xfermode mXfermode;
    private Rect r;
    private RectF rf;

    public ClipImageView(Context context) {
        super(context);
        this.MODE_NONE = 0;
        this.MODE_DRAG = 1;
        this.MODE_ZOOM = 2;
        this.MODE_POINTER_UP = 3;
        this.CURR_MODE = 0;
        this.mFrontGroundPaint = new Paint();
        setRadius();
    }

    private float getDistance(MotionEvent motionEvent) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-583793178")) {
            return ((Float) ipChange.ipc$dispatch("-583793178", new Object[]{this, motionEvent})).floatValue();
        }
        float x = motionEvent.getX(0) - motionEvent.getX(1);
        float y = motionEvent.getY(0) - motionEvent.getY(1);
        return (float) Math.sqrt((x * x) + (y * y));
    }

    public static int getScreenHeight(Context context) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1253179384")) {
            return ((Integer) ipChange.ipc$dispatch("1253179384", new Object[]{context})).intValue();
        }
        DisplayMetrics displayMetrics = new DisplayMetrics();
        Display.getMetrics(((WindowManager) context.getSystemService(v.ATTACH_MODE_WINDOW)).getDefaultDisplay(), displayMetrics);
        return com.alibaba.wireless.security.aopsdk.replace.android.util.DisplayMetrics.getheightPixels(displayMetrics);
    }

    public static int getScreenWidth(Context context) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1151890463")) {
            return ((Integer) ipChange.ipc$dispatch("-1151890463", new Object[]{context})).intValue();
        }
        DisplayMetrics displayMetrics = new DisplayMetrics();
        Display.getMetrics(((WindowManager) context.getSystemService(v.ATTACH_MODE_WINDOW)).getDefaultDisplay(), displayMetrics);
        return com.alibaba.wireless.security.aopsdk.replace.android.util.DisplayMetrics.getwidthPixels(displayMetrics);
    }

    private void init() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1304733518")) {
            ipChange.ipc$dispatch("1304733518", new Object[]{this});
            return;
        }
        this.mDownPoint = new PointF();
        this.mMiddlePoint = new PointF();
        this.mMatrix = new Matrix();
        this.mTempMatrix = new Matrix();
        this.mFrontGroundPaint.setColor(Color.parseColor("#ac000000"));
        this.mFrontGroundPaint.setAntiAlias(true);
        this.mXfermode = new PorterDuffXfermode(PorterDuff.Mode.DST_OUT);
        setScaleType(ImageView.ScaleType.MATRIX);
        post(new Runnable() { // from class: cn.damai.commonbusiness.photoselect.imageselected.view.ClipImageView.1
            private static transient /* synthetic */ IpChange $ipChange;

            @Override // java.lang.Runnable
            public void run() {
                IpChange ipChange2 = $ipChange;
                if (AndroidInstantRuntime.support(ipChange2, "-365655980")) {
                    ipChange2.ipc$dispatch("-365655980", new Object[]{this});
                } else {
                    ClipImageView.this.center();
                }
            }
        });
    }

    private void midPoint(PointF pointF, MotionEvent motionEvent) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-666648538")) {
            ipChange.ipc$dispatch("-666648538", new Object[]{this, pointF, motionEvent});
        } else {
            pointF.set((motionEvent.getX(0) + motionEvent.getX(1)) / 2.0f, (motionEvent.getY(0) + motionEvent.getY(1)) / 2.0f);
        }
    }

    private void setRadius() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-2090770920")) {
            ipChange.ipc$dispatch("-2090770920", new Object[]{this});
            return;
        }
        int screenWidth = getScreenWidth(getContext());
        int screenHeight = getScreenHeight(getContext());
        if (screenWidth > screenHeight) {
            this.mTargetWidth = screenHeight;
            this.mTargetHeight = screenHeight;
            return;
        }
        this.mTargetWidth = screenWidth;
        this.mTargetHeight = screenWidth;
    }

    protected void center() {
        float f;
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-626120791")) {
            ipChange.ipc$dispatch("-626120791", new Object[]{this});
            return;
        }
        float f2 = this.mBitmapHeight;
        float f3 = this.mBitmapWidth;
        float width = getWidth();
        float height = getHeight();
        if (f3 >= f2) {
            f = width / f3;
            int i = this.mTargetHeight;
            if (f * f2 < i) {
                f = i / f2;
            }
        } else {
            f = f2 <= height ? width / f3 : height / f2;
            int i2 = this.mTargetWidth;
            if (f * f3 < i2) {
                f = i2 / f3;
            }
        }
        this.mMatrix.postScale(f, f);
        this.mMatrix.postTranslate((width - (f3 * f)) / 2.0f, (height - (f2 * f)) / 2.0f);
        setImageMatrix(this.mMatrix);
    }

    public Bitmap clipImage() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "662045247")) {
            return (Bitmap) ipChange.ipc$dispatch("662045247", new Object[]{this});
        }
        this.isCutImage = true;
        Paint paint = new Paint();
        setDrawingCacheEnabled(true);
        Bitmap drawingCache = getDrawingCache();
        Bitmap createBitmap = Bitmap.createBitmap(this.mTargetWidth, this.mTargetHeight, Bitmap.Config.ARGB_8888);
        new Canvas(createBitmap).drawBitmap(drawingCache, (Rect) null, new RectF(((-drawingCache.getWidth()) / 2) + (this.mTargetWidth / 2), ((-getHeight()) / 2) + (this.mTargetHeight / 2), (drawingCache.getWidth() / 2) + (this.mTargetWidth / 2), (getHeight() / 2) + (this.mTargetHeight / 2)), paint);
        setDrawingCacheEnabled(false);
        if (drawingCache != createBitmap) {
            drawingCache.recycle();
        }
        this.isCutImage = false;
        return createBitmap;
    }

    @Override // android.widget.ImageView, android.view.View
    protected void onDraw(Canvas canvas) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-2048140214")) {
            ipChange.ipc$dispatch("-2048140214", new Object[]{this, canvas});
            return;
        }
        super.onDraw(canvas);
        if (this.isCutImage) {
            return;
        }
        RectF rectF = this.rf;
        if (rectF == null || rectF.isEmpty()) {
            this.r = new Rect(0, 0, getWidth(), getHeight());
            this.rf = new RectF(this.r);
        }
        int saveLayer = canvas.saveLayer(this.rf, null, 31);
        canvas.drawRect(this.r, this.mFrontGroundPaint);
        this.mFrontGroundPaint.setXfermode(this.mXfermode);
        float f = this.mCircleCenterX;
        int i = this.mTargetWidth;
        float f2 = this.mCircleCenterY;
        int i2 = this.mTargetHeight;
        canvas.drawRect(f - (i / 2), f2 - (i2 / 2), f + (i / 2), f2 + (i2 / 2), this.mFrontGroundPaint);
        canvas.restoreToCount(saveLayer);
        this.mFrontGroundPaint.setXfermode(null);
    }

    @Override // android.view.View
    protected void onLayout(boolean z, int i, int i2, int i3, int i4) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-2080941217")) {
            ipChange.ipc$dispatch("-2080941217", new Object[]{this, Boolean.valueOf(z), Integer.valueOf(i), Integer.valueOf(i2), Integer.valueOf(i3), Integer.valueOf(i4)});
            return;
        }
        super.onLayout(z, i, i2, i3, i4);
        this.mCircleCenterX = getWidth() / 2;
        float height = getHeight() / 2;
        this.mCircleCenterY = height;
        this.mCircleX = this.mCircleCenterX - (this.mTargetWidth / 2);
        this.mCircleY = height - (this.mTargetHeight / 2);
    }

    @Override // android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-817208739")) {
            return ((Boolean) ipChange.ipc$dispatch("-817208739", new Object[]{this, motionEvent})).booleanValue();
        }
        Matrix matrix = this.mMatrix;
        if (matrix == null) {
            return super.onTouchEvent(motionEvent);
        }
        float[] fArr = new float[9];
        matrix.getValues(fArr);
        float f = fArr[2];
        float f2 = fArr[5];
        float f3 = (this.mBitmapWidth * fArr[0]) + f;
        float f4 = (this.mBitmapHeight * fArr[4]) + f2;
        int action = motionEvent.getAction() & 255;
        if (action == 0) {
            this.CURR_MODE = 1;
            this.mDownPoint.set(motionEvent.getX(), motionEvent.getY());
        } else if (action == 1) {
            this.CURR_MODE = 0;
        } else if (action == 2) {
            int i = this.CURR_MODE;
            if (i != 1 && i != 3) {
                float distance = getDistance(motionEvent);
                if (distance > 10.0f) {
                    float f5 = distance / this.mLastDistance;
                    float f6 = this.mCircleX;
                    if (f >= f6) {
                        this.mMiddlePoint.x = 0.0f;
                    }
                    if (f3 <= f6 + this.mTargetWidth) {
                        this.mMiddlePoint.x = f3;
                    }
                    float f7 = this.mCircleY;
                    if (f2 >= f7) {
                        this.mMiddlePoint.y = 0.0f;
                    }
                    if (f4 <= f7 + this.mTargetHeight) {
                        this.mMiddlePoint.y = f4;
                    }
                    this.mTempMatrix.set(this.mMatrix);
                    Matrix matrix2 = this.mTempMatrix;
                    PointF pointF = this.mMiddlePoint;
                    matrix2.postScale(f5, f5, pointF.x, pointF.y);
                    float[] fArr2 = new float[9];
                    this.mTempMatrix.getValues(fArr2);
                    float f8 = fArr2[2];
                    float f9 = fArr2[5];
                    float f10 = (this.mBitmapWidth * fArr2[0]) + f8;
                    float f11 = (this.mBitmapHeight * fArr2[4]) + f9;
                    float f12 = this.mCircleX;
                    if (f8 <= f12 && f10 >= f12 + this.mTargetWidth) {
                        float f13 = this.mCircleY;
                        if (f9 <= f13 && f11 >= f13 + this.mTargetHeight) {
                            Matrix matrix3 = this.mMatrix;
                            PointF pointF2 = this.mMiddlePoint;
                            matrix3.postScale(f5, f5, pointF2.x, pointF2.y);
                            this.mLastDistance = getDistance(motionEvent);
                        }
                    }
                    return true;
                }
            } else if (i == 1) {
                float x = motionEvent.getX() - this.mDownPoint.x;
                float y = motionEvent.getY() - this.mDownPoint.y;
                float f14 = this.mCircleX;
                if (f + x > f14) {
                    x = 0.0f;
                }
                if (f3 + x < f14 + this.mTargetWidth) {
                    x = 0.0f;
                }
                float f15 = this.mCircleY;
                if (f2 + y > f15) {
                    y = 0.0f;
                }
                this.mMatrix.postTranslate(x, f4 + y >= f15 + ((float) this.mTargetHeight) ? y : 0.0f);
                this.mDownPoint.set(motionEvent.getX(), motionEvent.getY());
            } else {
                this.CURR_MODE = 1;
                this.mDownPoint.set(motionEvent.getX(), motionEvent.getY());
            }
        } else if (action != 5) {
            if (action == 6) {
                this.CURR_MODE = 3;
            }
        } else if (getDistance(motionEvent) > 10.0f) {
            this.CURR_MODE = 2;
            midPoint(this.mMiddlePoint, motionEvent);
            this.mLastDistance = getDistance(motionEvent);
        }
        setImageMatrix(this.mMatrix);
        return true;
    }

    public void setBitmapData(Bitmap bitmap) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "898212349")) {
            ipChange.ipc$dispatch("898212349", new Object[]{this, bitmap});
        } else if (bitmap == null) {
        } else {
            this.mBitmapHeight = bitmap.getHeight();
            this.mBitmapWidth = bitmap.getWidth();
            setImageBitmap(bitmap);
            init();
        }
    }

    public ClipImageView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.MODE_NONE = 0;
        this.MODE_DRAG = 1;
        this.MODE_ZOOM = 2;
        this.MODE_POINTER_UP = 3;
        this.CURR_MODE = 0;
        this.mFrontGroundPaint = new Paint();
        setRadius();
    }
}
