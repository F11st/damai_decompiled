package cn.damai.seat.view;

import android.animation.Animator;
import android.animation.TypeEvaluator;
import android.animation.ValueAnimator;
import android.content.Context;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.Point;
import android.graphics.RectF;
import android.os.Handler;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.GestureDetector;
import android.view.MotionEvent;
import android.view.ScaleGestureDetector;
import android.view.View;
import android.view.animation.DecelerateInterpolator;
import androidx.annotation.Nullable;
import androidx.collection.SparseArrayCompat;
import cn.damai.commonbusiness.seatbiz.seat.common.bean.seat.SeatNew;
import cn.damai.seat.R$drawable;
import cn.damai.seat.R$string;
import cn.damai.seat.bean.SeatProfile;
import com.ali.user.mobile.utils.ScreenUtil;
import com.alibaba.wireless.security.aopsdk.replace.android.util.DisplayMetrics;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import java.util.ArrayList;
import java.util.List;
import tb.cb1;
import tb.g92;
import tb.m62;
import tb.n92;
import tb.wh2;

/* compiled from: Taobao */
/* loaded from: classes16.dex */
public class SeatView extends View {
    private static transient /* synthetic */ IpChange $ipChange = null;
    private static final int ANIMATE_TIME = 300;
    private static final int AUTO_SCALE_LEVEL_SEAT_18 = 3;
    private static final int AUTO_SCALE_LEVEL_SEAT_30 = 2;
    private static final int AUTO_SCALE_LEVEL_SEAT_9 = 4;
    private static final int AUTO_SCALE_LEVEL_SEAT_ALL = 1;
    private static final int OVERVIEW_STAY_TIME = 500;
    private static final String TAG = "QILIN_SEAT";
    private int column;
    private int currentScaleLevel;
    private float defaultImgH;
    private float defaultImgW;
    private float dragMoveCoefficient;
    private boolean firstScale;
    GestureDetector gestureDetector;
    private Handler handler;
    private Runnable hideOverviewRunnable;
    float initialOffsetRectY;
    float initialOffsetY;
    private boolean isDrawOverview;
    private boolean isDrawOverviewBitmap;
    private boolean isFling;
    private boolean isOnClick;
    private boolean isScaling;
    private Paint lineNumberPaint;
    private Paint.FontMetrics lineNumberPaintFontMetrics;
    private Context mContext;
    private float mCurrentScale;
    private float mDefaultImgScaleX;
    private float mDefaultImgScaleY;
    private float mDefaultLeftRightPadding;
    private float mDefaultSeatViewHeight;
    private float mDefaultSeatViewWidth;
    private boolean mFirstDraw;
    private g92 mIconProvider;
    private OnSeatClickListener mListener;
    private Bitmap mLockedSeat;
    private int mMaxMoveOffset;
    private float mMinTranslateX;
    private int mOverViewOffsetX;
    private int mOverViewOffsetY;
    private float mOverviewH;
    private float mOverviewScale;
    private float mOverviewSeatHeight;
    private float mOverviewSeatWidth;
    private float mOverviewSpacing;
    private float mOverviewVerSpacing;
    private float mOverviewW;
    private int mPhoneScreenWidth;
    private float mScale18;
    private List<SeatNew> mSeatList;
    private SeatProfile mSeatProfile;
    private boolean mSelectdSeat;
    private long mSelectedPriceId;
    private float mSpacing;
    private float mVerSpacing;
    private int mViewHeight;
    private int mViewWidth;
    private Matrix matrix;
    private float[] matrixValues;
    private float maxOffsetScale;
    private float maxScale;
    private float minOffsetScale;
    private float minScale;
    private Bitmap noseat;
    private Bitmap noseatAlpha;
    private int numberMargin;
    private int numberWidth;
    private float offsetScale;
    private float overscreenOverviewVerSpacing;
    private int overviewBackgroundColor;
    private Bitmap overviewBitmap;
    private Paint overviewPaint;
    private float overviewSeatBottomVerSpacing;
    private float overviewSeatLeftRightSpacing;
    private Paint paint;
    private Paint pathPaint;
    private RectF rectF;
    private float redBorderBottomBoundary;
    private float redBorderLeftBoundary;
    private Paint redBorderPaint;
    private float redBorderRightBoundary;
    private float redBorderTopBoundary;
    private int row;
    private List<String> rowNumList;
    private SparseArrayCompat<List<String>> rowNumRegionList;
    ScaleGestureDetector scaleGestureDetector;
    private float scaleX;
    private float scaleY;
    private Bitmap screenBitmap;
    private String screenName;
    private Bitmap screenOverviewBitmap;
    private RectF screenRectF;
    private int seatViewPaddingBottom;
    private Matrix tempMatrix;
    private int unavailableSeatColor;
    private float zoom;

    /* compiled from: Taobao */
    /* loaded from: classes16.dex */
    public interface OnSeatClickListener {
        void onSeatClick(SeatNew seatNew, boolean z);
    }

    /* compiled from: Taobao */
    /* loaded from: classes16.dex */
    public class a implements ScaleGestureDetector.OnScaleGestureListener {
        private static transient /* synthetic */ IpChange $ipChange;

        a() {
        }

        /* JADX WARN: Removed duplicated region for block: B:19:0x0066  */
        /* JADX WARN: Removed duplicated region for block: B:30:0x00b4  */
        /* JADX WARN: Removed duplicated region for block: B:42:0x00ec  */
        @Override // android.view.ScaleGestureDetector.OnScaleGestureListener
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct code enable 'Show inconsistent code' option in preferences
        */
        public boolean onScale(android.view.ScaleGestureDetector r8) {
            /*
                Method dump skipped, instructions count: 252
                To view this dump change 'Code comments level' option to 'DEBUG'
            */
            throw new UnsupportedOperationException("Method not decompiled: cn.damai.seat.view.SeatView.a.onScale(android.view.ScaleGestureDetector):boolean");
        }

        @Override // android.view.ScaleGestureDetector.OnScaleGestureListener
        public boolean onScaleBegin(ScaleGestureDetector scaleGestureDetector) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "-147299547")) {
                return ((Boolean) ipChange.ipc$dispatch("-147299547", new Object[]{this, scaleGestureDetector})).booleanValue();
            }
            return true;
        }

        @Override // android.view.ScaleGestureDetector.OnScaleGestureListener
        public void onScaleEnd(ScaleGestureDetector scaleGestureDetector) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "-532793197")) {
                ipChange.ipc$dispatch("-532793197", new Object[]{this, scaleGestureDetector});
                return;
            }
            SeatView.this.firstScale = true;
            SeatView.this.autoScale();
        }
    }

    /* compiled from: Taobao */
    /* loaded from: classes16.dex */
    public class b extends GestureDetector.SimpleOnGestureListener {
        private static transient /* synthetic */ IpChange $ipChange;

        b() {
        }

        @Override // android.view.GestureDetector.SimpleOnGestureListener, android.view.GestureDetector.OnGestureListener
        public boolean onFling(MotionEvent motionEvent, MotionEvent motionEvent2, float f, float f2) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "-502597269")) {
                return ((Boolean) ipChange.ipc$dispatch("-502597269", new Object[]{this, motionEvent, motionEvent2, Float.valueOf(f), Float.valueOf(f2)})).booleanValue();
            }
            if (!SeatView.this.isScaling) {
                SeatView.this.flingAnimate(motionEvent, motionEvent2, f, f2);
                return true;
            }
            return super.onFling(motionEvent, motionEvent2, f, f2);
        }

        @Override // android.view.GestureDetector.SimpleOnGestureListener, android.view.GestureDetector.OnGestureListener
        public boolean onScroll(MotionEvent motionEvent, MotionEvent motionEvent2, float f, float f2) {
            IpChange ipChange = $ipChange;
            int i = 0;
            if (AndroidInstantRuntime.support(ipChange, "1233084754")) {
                return ((Boolean) ipChange.ipc$dispatch("1233084754", new Object[]{this, motionEvent, motionEvent2, Float.valueOf(f), Float.valueOf(f2)})).booleanValue();
            }
            if (!SeatView.this.isScaling) {
                SeatView.this.isDrawOverview = true;
                int i2 = (int) ((-f) * SeatView.this.dragMoveCoefficient);
                float f3 = (int) ((-f2) * SeatView.this.dragMoveCoefficient);
                int i3 = (SeatView.this.getTranslateY() + f3 > ((float) SeatView.this.mMaxMoveOffset) || (SeatView.this.getTranslateY() + f3) + SeatView.this.getCurrentBitmapHeight() <= ((float) SeatView.this.mMaxMoveOffset)) ? 0 : 0;
                float f4 = i2;
                if (SeatView.this.getTranslateX() + f4 <= SeatView.this.mMaxMoveOffset && SeatView.this.getTranslateX() + f4 + SeatView.this.getCurrentBitmapWidth() > SeatView.this.mMaxMoveOffset) {
                    i = i2;
                }
                SeatView.this.matrix.postTranslate(i, i3);
                SeatView.this.invalidate();
                return true;
            }
            return super.onScroll(motionEvent, motionEvent2, f, f2);
        }

        @Override // android.view.GestureDetector.SimpleOnGestureListener, android.view.GestureDetector.OnGestureListener
        public boolean onSingleTapUp(MotionEvent motionEvent) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "-1938388484")) {
                return ((Boolean) ipChange.ipc$dispatch("-1938388484", new Object[]{this, motionEvent})).booleanValue();
            }
            SeatView.this.isOnClick = true;
            if (SeatView.this.column <= 30) {
                SeatView.this.seatTabClickEvent(motionEvent);
                if (SeatView.this.currentScaleLevel != 4) {
                    SeatView.this.currentScaleLevel = 4;
                    SeatView.this.scaleX = (int) motionEvent.getX();
                    SeatView.this.scaleY = (int) motionEvent.getY();
                    SeatView seatView = SeatView.this;
                    seatView.zoomAnimate(seatView.getMatrixScaleX(), SeatView.this.maxScale);
                }
                return super.onSingleTapUp(motionEvent);
            }
            if (SeatView.this.column > 30) {
                if (SeatView.this.currentScaleLevel == 1) {
                    SeatView.this.currentScaleLevel = 3;
                    SeatView.this.scaleX = (int) motionEvent.getX();
                    SeatView.this.scaleY = (int) motionEvent.getY();
                    SeatView seatView2 = SeatView.this;
                    seatView2.zoomAnimate(seatView2.getMatrixScaleX(), SeatView.this.mScale18);
                    return super.onSingleTapUp(motionEvent);
                } else if (SeatView.this.currentScaleLevel == 3) {
                    SeatView.this.seatTabClickEvent(motionEvent);
                    SeatView.this.currentScaleLevel = 4;
                    SeatView.this.scaleX = (int) motionEvent.getX();
                    SeatView.this.scaleY = (int) motionEvent.getY();
                    SeatView seatView3 = SeatView.this;
                    seatView3.zoomAnimate(seatView3.getMatrixScaleX(), SeatView.this.maxScale);
                    return super.onSingleTapUp(motionEvent);
                }
            }
            SeatView.this.seatTabClickEvent(motionEvent);
            return true;
        }
    }

    /* compiled from: Taobao */
    /* loaded from: classes16.dex */
    public class c implements ValueAnimator.AnimatorUpdateListener {
        private static transient /* synthetic */ IpChange $ipChange;

        c() {
        }

        @Override // android.animation.ValueAnimator.AnimatorUpdateListener
        public void onAnimationUpdate(ValueAnimator valueAnimator) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "-1473738615")) {
                ipChange.ipc$dispatch("-1473738615", new Object[]{this, valueAnimator});
            } else {
                SeatView.this.move((Point) valueAnimator.getAnimatedValue());
            }
        }
    }

    /* compiled from: Taobao */
    /* loaded from: classes16.dex */
    public class d implements TypeEvaluator {
        private static transient /* synthetic */ IpChange $ipChange;

        d(SeatView seatView) {
        }

        @Override // android.animation.TypeEvaluator
        public Object evaluate(float f, Object obj, Object obj2) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "-831390531")) {
                return ipChange.ipc$dispatch("-831390531", new Object[]{this, Float.valueOf(f), obj, obj2});
            }
            Point point = (Point) obj;
            Point point2 = (Point) obj2;
            int xVar = com.alibaba.wireless.security.aopsdk.replace.android.graphics.Point.getx(point);
            int yVar = com.alibaba.wireless.security.aopsdk.replace.android.graphics.Point.gety(point);
            return new Point((int) (xVar + ((com.alibaba.wireless.security.aopsdk.replace.android.graphics.Point.getx(point2) - xVar) * f)), (int) (yVar + (f * (com.alibaba.wireless.security.aopsdk.replace.android.graphics.Point.gety(point2) - yVar))));
        }
    }

    /* compiled from: Taobao */
    /* loaded from: classes16.dex */
    public class e implements Animator.AnimatorListener, ValueAnimator.AnimatorUpdateListener {
        private static transient /* synthetic */ IpChange $ipChange;

        e() {
        }

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationCancel(Animator animator) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "-1339056167")) {
                ipChange.ipc$dispatch("-1339056167", new Object[]{this, animator});
            }
        }

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationEnd(Animator animator) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "-565947914")) {
                ipChange.ipc$dispatch("-565947914", new Object[]{this, animator});
            } else {
                SeatView.this.autoScroll();
            }
        }

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationRepeat(Animator animator) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "974519448")) {
                ipChange.ipc$dispatch("974519448", new Object[]{this, animator});
            }
        }

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationStart(Animator animator) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "140499407")) {
                ipChange.ipc$dispatch("140499407", new Object[]{this, animator});
            }
        }

        @Override // android.animation.ValueAnimator.AnimatorUpdateListener
        public void onAnimationUpdate(ValueAnimator valueAnimator) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "947826887")) {
                ipChange.ipc$dispatch("947826887", new Object[]{this, valueAnimator});
                return;
            }
            SeatView.this.zoom = ((Float) valueAnimator.getAnimatedValue()).floatValue();
            SeatView seatView = SeatView.this;
            seatView.zoom(seatView.zoom);
            cb1.b(SeatView.TAG, "zoom:" + SeatView.this.zoom);
        }
    }

    public SeatView(Context context) {
        this(context, null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void autoScale() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1012762707")) {
            ipChange.ipc$dispatch("-1012762707", new Object[]{this});
            return;
        }
        float matrixScaleX = getMatrixScaleX();
        float f = this.maxScale;
        if (matrixScaleX > f) {
            this.currentScaleLevel = 4;
            zoomAnimate(matrixScaleX, f);
            return;
        }
        float f2 = this.minScale;
        if (matrixScaleX < f2) {
            this.currentScaleLevel = 1;
            zoomAnimate(matrixScaleX, f2);
            return;
        }
        autoScroll();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Removed duplicated region for block: B:35:0x00b9  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public void autoScroll() {
        /*
            Method dump skipped, instructions count: 234
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: cn.damai.seat.view.SeatView.autoScroll():void");
    }

    private void drawRowNumBar(Canvas canvas, int i, List<String> list) {
        boolean z;
        int i2;
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1167553204")) {
            ipChange.ipc$dispatch("1167553204", new Object[]{this, canvas, Integer.valueOf(i), list});
        } else if (i >= 0 && list != null && !list.isEmpty()) {
            int i3 = 0;
            while (true) {
                if (i3 >= list.size()) {
                    z = false;
                    break;
                } else if (!TextUtils.isEmpty(list.get(i3))) {
                    z = true;
                    break;
                } else {
                    i3++;
                }
            }
            if (z) {
                long currentTimeMillis = System.currentTimeMillis();
                this.lineNumberPaint.setColor(Color.parseColor("#4D000000"));
                float matrixScaleY = getMatrixScaleY();
                float f = this.defaultImgH * matrixScaleY;
                float f2 = this.mVerSpacing * matrixScaleY;
                RectF rectF = this.rectF;
                float translateY = (int) getTranslateY();
                float f3 = i;
                rectF.top = (((f3 * f) + translateY) + (f3 * f2)) - m62.a(this.mContext, 10.0f);
                this.rectF.bottom = ((list.size() + i) * f) + translateY + (f2 * ((list.size() + i) - 1)) + m62.a(this.mContext, 10.0f);
                RectF rectF2 = this.rectF;
                float f4 = this.numberMargin;
                rectF2.left = f4;
                rectF2.right = this.numberWidth + f4;
                canvas.drawRoundRect(rectF2, m62.a(this.mContext, 42.0f), m62.a(this.mContext, 42.0f), this.lineNumberPaint);
                cb1.b(TAG, "--------------------- rowNum right = " + this.rectF.right + " , left = " + this.rectF.left);
                this.lineNumberPaint.setColor(-1);
                for (int i4 = 0; i4 < list.size(); i4++) {
                    float f5 = i4 + i;
                    float f6 = this.defaultImgH;
                    float f7 = this.mVerSpacing;
                    float f8 = (((f5 * f6) + ((i2 - 1) * f7) + f6) * matrixScaleY) + translateY;
                    Paint.FontMetrics fontMetrics = this.lineNumberPaintFontMetrics;
                    float f9 = (((f8 + (((((f5 * f6) + (f5 * f7)) * matrixScaleY) + translateY) + (f / 2.0f))) - fontMetrics.bottom) - fontMetrics.top) / 2.0f;
                    if (!TextUtils.isEmpty(list.get(i4))) {
                        RectF rectF3 = this.rectF;
                        canvas.drawText(list.get(i4), (rectF3.right + rectF3.left) / 2.0f, f9, this.lineNumberPaint);
                    }
                }
                cb1.b(TAG, "drawNumberTime:" + (System.currentTimeMillis() - currentTimeMillis));
            }
        }
    }

    private void drawScreen(Canvas canvas) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1628561517")) {
            ipChange.ipc$dispatch("-1628561517", new Object[]{this, canvas});
            return;
        }
        this.pathPaint.setColor(-1);
        canvas.drawRoundRect(this.screenRectF, 0.0f, 0.0f, this.pathPaint);
        Bitmap bitmap = this.screenBitmap;
        canvas.drawBitmap(bitmap, (this.screenRectF.right - bitmap.getWidth()) / 2.0f, 0.0f, this.paint);
        this.pathPaint.setColor(Color.parseColor("#666666"));
        this.pathPaint.setTextSize(m62.a(this.mContext, 12.0f));
        String str = this.screenName;
        Paint paint = this.pathPaint;
        float f = this.screenRectF.top;
        canvas.drawText(str, (this.screenRectF.right - this.pathPaint.measureText(str)) / 2.0f, getBaseLine(paint, f, this.screenBitmap.getHeight() + f), this.pathPaint);
    }

    private void drawSeat(Canvas canvas) {
        float f;
        Bitmap a2;
        Bitmap a3;
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1023887508")) {
            ipChange.ipc$dispatch("-1023887508", new Object[]{this, canvas});
            return;
        }
        this.zoom = getMatrixScaleX();
        long currentTimeMillis = System.currentTimeMillis();
        float translateX = getTranslateX();
        float translateY = getTranslateY();
        float f2 = this.zoom;
        float f3 = this.defaultImgH * f2;
        float f4 = this.defaultImgW * f2;
        float f5 = this.mDefaultImgScaleX * f2;
        float f6 = this.mDefaultImgScaleY * f2;
        float f7 = this.mVerSpacing * f2;
        float f8 = this.mSpacing * f2;
        float currentLeftRightPadding = translateX + getCurrentLeftRightPadding();
        int i = this.unavailableSeatColor;
        boolean z = this.mSelectedPriceId != -1;
        int i2 = 0;
        while (i2 < this.mSeatList.size()) {
            SeatNew seatNew = this.mSeatList.get(i2);
            long j = currentTimeMillis;
            int i3 = seatNew.x;
            SeatProfile seatProfile = this.mSeatProfile;
            int i4 = i2;
            float f9 = ((i3 - seatProfile.minX) * (f3 + f7)) + translateY;
            float f10 = ((seatNew.y - seatProfile.minY) * (f4 + f8)) + currentLeftRightPadding;
            if (f10 <= this.mViewWidth && f10 + f4 >= 0.0f) {
                f = currentLeftRightPadding;
                if (f9 <= this.mViewHeight + this.seatViewPaddingBottom && f9 + f3 >= translateY) {
                    this.tempMatrix.setTranslate(f10, f9);
                    this.tempMatrix.preScale(f5, f6);
                    int i5 = seatNew.state;
                    if (i5 != 2) {
                        if (i5 == 4) {
                            canvas.drawBitmap(this.mLockedSeat, this.tempMatrix, this.paint);
                        } else if (i5 != 8) {
                            if (seatNew.packageCombinedId == 0) {
                                canvas.drawBitmap(this.mIconProvider.a(i, seatNew.angle, (byte) 10, false), this.tempMatrix, this.paint);
                            } else {
                                canvas.drawBitmap(this.mIconProvider.a(i, seatNew.angle, (byte) 12, false), this.tempMatrix, this.paint);
                            }
                        } else if (z) {
                            canvas.drawBitmap(this.noseatAlpha, this.tempMatrix, this.paint);
                        } else {
                            canvas.drawBitmap(this.noseat, this.tempMatrix, this.paint);
                        }
                    } else if (seatNew.isSelected) {
                        int i6 = seatNew.seatColor;
                        if (seatNew.packageCombinedId == 0) {
                            a3 = this.mIconProvider.a(i6, seatNew.angle, (byte) 11, false);
                        } else {
                            a3 = this.mIconProvider.a(i6, seatNew.angle, (byte) 13, false);
                        }
                        canvas.drawBitmap(a3, this.tempMatrix, this.paint);
                        i = i6;
                    } else {
                        boolean isNeedAddAlpha = isNeedAddAlpha(seatNew);
                        if (seatNew.packageCombinedId == 0) {
                            a2 = this.mIconProvider.a(seatNew.seatColor, seatNew.angle, (byte) 10, isNeedAddAlpha);
                        } else {
                            a2 = this.mIconProvider.a(seatNew.seatColor, seatNew.angle, (byte) 12, isNeedAddAlpha);
                        }
                        canvas.drawBitmap(a2, this.tempMatrix, this.paint);
                    }
                }
            } else {
                f = currentLeftRightPadding;
            }
            i2 = i4 + 1;
            currentTimeMillis = j;
            currentLeftRightPadding = f;
        }
        long currentTimeMillis2 = System.currentTimeMillis();
        cb1.b(TAG, "seatDrawTime:" + (currentTimeMillis2 - currentTimeMillis) + " , transX = " + getTranslateX() + " , transY = " + getTranslateY());
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Code restructure failed: missing block: B:43:0x00d9, code lost:
        if (r6 > r12) goto L39;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public void flingAnimate(android.view.MotionEvent r10, android.view.MotionEvent r11, float r12, float r13) {
        /*
            Method dump skipped, instructions count: 249
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: cn.damai.seat.view.SeatView.flingAnimate(android.view.MotionEvent, android.view.MotionEvent, float, float):void");
    }

    private float getBaseLine(Paint paint, float f, float f2) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1991208846")) {
            return ((Float) ipChange.ipc$dispatch("-1991208846", new Object[]{this, paint, Float.valueOf(f), Float.valueOf(f2)})).floatValue();
        }
        Paint.FontMetrics fontMetrics = paint.getFontMetrics();
        return (int) ((((f2 + f) - fontMetrics.bottom) - fontMetrics.top) / 2.0f);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public float getCurrentBitmapHeight() {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "1133530265") ? ((Float) ipChange.ipc$dispatch("1133530265", new Object[]{this})).floatValue() : this.mDefaultSeatViewHeight * getMatrixScaleY();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public float getCurrentBitmapWidth() {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "-1714174780") ? ((Float) ipChange.ipc$dispatch("-1714174780", new Object[]{this})).floatValue() : this.mDefaultSeatViewWidth * getMatrixScaleX();
    }

    private float getCurrentLeftRightPadding() {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "803757331") ? ((Float) ipChange.ipc$dispatch("803757331", new Object[]{this})).floatValue() : getMatrixScaleX() * this.mDefaultLeftRightPadding;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public float getMatrixScaleX() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-205721581")) {
            return ((Float) ipChange.ipc$dispatch("-205721581", new Object[]{this})).floatValue();
        }
        this.matrix.getValues(this.matrixValues);
        return this.matrixValues[0];
    }

    private float getMatrixScaleY() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-205691790")) {
            return ((Float) ipChange.ipc$dispatch("-205691790", new Object[]{this})).floatValue();
        }
        this.matrix.getValues(this.matrixValues);
        return this.matrixValues[4];
    }

    /* JADX INFO: Access modifiers changed from: private */
    public float getTranslateX() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1766981608")) {
            return ((Float) ipChange.ipc$dispatch("-1766981608", new Object[]{this})).floatValue();
        }
        this.matrix.getValues(this.matrixValues);
        return this.matrixValues[2];
    }

    /* JADX INFO: Access modifiers changed from: private */
    public float getTranslateY() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1766951817")) {
            return ((Float) ipChange.ipc$dispatch("-1766951817", new Object[]{this})).floatValue();
        }
        this.matrix.getValues(this.matrixValues);
        return this.matrixValues[5];
    }

    private int getViewUsedHeight() {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "1122896444") ? ((Integer) ipChange.ipc$dispatch("1122896444", new Object[]{this})).intValue() : getHeight() - this.seatViewPaddingBottom;
    }

    private void initData(Context context) {
        int i;
        int i2;
        int i3;
        float f;
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1407089088")) {
            ipChange.ipc$dispatch("1407089088", new Object[]{this, context});
            return;
        }
        this.mFirstDraw = true;
        this.isDrawOverviewBitmap = true;
        int i4 = DisplayMetrics.getwidthPixels(m62.b(context));
        this.mPhoneScreenWidth = i4;
        this.mMaxMoveOffset = i4 / 2;
        this.mSpacing = m62.a(context, 4.0f);
        this.mVerSpacing = m62.a(context, 4.0f);
        this.mDefaultLeftRightPadding = m62.a(context, 8.0f);
        float a2 = m62.a(context, 8.0f);
        this.defaultImgW = a2;
        this.defaultImgH = a2 / (this.noseat.getWidth() / this.noseat.getHeight());
        this.mDefaultImgScaleX = this.defaultImgW / this.noseat.getWidth();
        this.mDefaultImgScaleY = this.defaultImgH / this.noseat.getHeight();
        int i5 = this.column;
        float f2 = this.defaultImgW;
        float f3 = this.mSpacing;
        float f4 = this.mDefaultLeftRightPadding;
        float f5 = (i5 * f2) + ((i5 - 1) * f3) + (f4 * 2.0f);
        this.mDefaultSeatViewWidth = f5;
        this.mDefaultSeatViewHeight = (this.row * this.defaultImgH) + ((i - 1) * this.mVerSpacing);
        float f6 = this.mPhoneScreenWidth;
        float f7 = f6 / f5;
        this.minScale = f7;
        this.currentScaleLevel = 1;
        if (i5 <= 18) {
            this.mScale18 = f7;
        } else {
            this.mScale18 = f6 / (((18.0f * f2) + (17.0f * f3)) + (f4 * 2.0f));
        }
        float f8 = f6 / (((f2 * 9.0f) + (f3 * 8.0f)) + (f4 * 2.0f));
        this.maxScale = f8;
        if (f8 <= f7) {
            this.minScale = f8;
            this.currentScaleLevel = 4;
        }
        if (i5 <= 9) {
            this.mScale18 = f8;
            this.currentScaleLevel = 4;
        }
        float f9 = this.minScale;
        float f10 = this.offsetScale;
        this.minOffsetScale = (1.0f - f10) * f9;
        this.maxOffsetScale = f8 * (f10 + 1.0f);
        this.mCurrentScale = f9;
        float a3 = m62.a(context, 4.0f);
        float f11 = a3 / this.defaultImgW;
        this.mOverviewScale = f11;
        this.mOverviewSeatHeight = a3;
        this.mOverviewSeatWidth = a3;
        this.mOverviewSpacing = this.mSpacing * f11;
        this.mOverviewVerSpacing = this.mVerSpacing * f11;
        float a4 = m62.a(context, 6.0f);
        this.overviewSeatBottomVerSpacing = a4;
        this.overviewSeatLeftRightSpacing = a4;
        float f12 = this.mOverviewVerSpacing;
        this.overscreenOverviewVerSpacing = m62.a(context, 2.0f) + f12;
        float height = (this.row * this.mOverviewSeatHeight) + ((i2 - 1) * f12) + this.overviewSeatBottomVerSpacing + this.screenOverviewBitmap.getHeight() + this.overscreenOverviewVerSpacing;
        this.mOverviewH = height;
        float f13 = (this.column * this.mOverviewSeatWidth) + ((i3 - 1) * this.mOverviewSpacing) + (this.overviewSeatLeftRightSpacing * 2.0f);
        this.mOverviewW = f13;
        float f14 = this.overviewSeatLeftRightSpacing;
        float height2 = this.screenOverviewBitmap.getHeight() + f14;
        float f15 = f14 * 2.0f;
        float f16 = this.mPhoneScreenWidth * 0.4f;
        float f17 = this.mOverviewW;
        if (f17 > f16 || this.mOverviewH > f16) {
            float max = f16 / Math.max(f17, this.mOverviewH);
            this.mOverviewH *= max;
            this.mOverviewW *= max;
        }
        float width = this.screenOverviewBitmap.getWidth() + m62.a(context, 24.0f);
        float f18 = this.mOverviewW;
        if (f18 < width) {
            float f19 = this.mOverviewH * (width / f18);
            this.mOverviewH = f19;
            this.mOverviewW = width;
            if (f19 > f16) {
                this.mOverviewH = f16;
                f = (f16 - height2) / (height - f15);
            } else {
                f = (width - f15) / (f13 - f15);
            }
        } else {
            f = (f18 - f15) / (f13 - f15);
        }
        float f20 = this.mOverviewScale * f;
        this.mOverviewScale = f20;
        float f21 = a3 * f;
        this.mOverviewSeatHeight = f21;
        this.mOverviewSeatWidth = f21;
        this.mOverviewSpacing = this.mSpacing * f20;
        this.mOverviewVerSpacing = this.mVerSpacing * f20;
        this.overscreenOverviewVerSpacing *= f;
        this.overviewBitmap = Bitmap.createBitmap((int) this.mOverviewW, (int) this.mOverviewH, Bitmap.Config.ARGB_8888);
        this.mOverViewOffsetX = ScreenUtil.dip2px(this.mContext, 9.0f);
        Bitmap bitmap = this.screenBitmap;
        if (bitmap != null) {
            this.mOverViewOffsetY = bitmap.getHeight();
        } else {
            this.mOverViewOffsetY = ScreenUtil.dip2px(this.mContext, 9.0f);
        }
        this.rectF = new RectF();
        this.numberWidth = m62.a(context, 20.0f);
        this.numberMargin = m62.a(context, 10.0f);
        RectF rectF = new RectF();
        this.screenRectF = rectF;
        rectF.left = 0.0f;
        rectF.top = 0.0f;
        rectF.right = this.mPhoneScreenWidth;
        rectF.bottom = m62.a(context, 30.0f);
        this.screenName = context.getString(R$string.trade_seat_stage);
    }

    private void initPaintData(Context context) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-938181160")) {
            ipChange.ipc$dispatch("-938181160", new Object[]{this, context});
            return;
        }
        this.paint = new Paint(1);
        Paint paint = new Paint(1);
        this.pathPaint = paint;
        paint.setStyle(Paint.Style.FILL);
        Paint paint2 = new Paint();
        this.redBorderPaint = paint2;
        paint2.setAntiAlias(true);
        this.redBorderPaint.setColor(Color.parseColor("#fa1155"));
        this.redBorderPaint.setStyle(Paint.Style.STROKE);
        this.redBorderPaint.setStrokeWidth(m62.a(context, 2.0f));
        this.overviewBackgroundColor = Color.parseColor("#66000000");
        Paint paint3 = new Paint(1);
        this.lineNumberPaint = paint3;
        paint3.setTextSize(getResources().getDisplayMetrics().density * 12.0f);
        this.lineNumberPaintFontMetrics = this.lineNumberPaint.getFontMetrics();
        this.lineNumberPaint.setTextAlign(Paint.Align.CENTER);
    }

    private void initSeatImageData() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "832716152")) {
            ipChange.ipc$dispatch("832716152", new Object[]{this});
            return;
        }
        try {
            this.noseat = this.mIconProvider.d(0.0f, (byte) 14, false);
            this.noseatAlpha = this.mIconProvider.d(0.0f, (byte) 14, true);
            this.mLockedSeat = this.mIconProvider.b(0.0f);
            Resources resources = getResources();
            this.screenBitmap = BitmapFactory.decodeResource(resources, R$drawable.trade_seat_stage);
            this.screenOverviewBitmap = BitmapFactory.decodeResource(resources, R$drawable.trade_seat_overview_screen);
            this.unavailableSeatColor = Color.parseColor("#e9e9e9");
        } catch (Exception e2) {
            e2.printStackTrace();
        }
    }

    private boolean isNeedAddAlpha(SeatNew seatNew) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-328260684")) {
            return ((Boolean) ipChange.ipc$dispatch("-328260684", new Object[]{this, seatNew})).booleanValue();
        }
        long j = this.mSelectedPriceId;
        if (j == -1) {
            return false;
        }
        return (seatNew.isPackaged ? seatNew.packagedPriceIndexId : seatNew.priceLevel) != j;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void move(Point point) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-98010668")) {
            ipChange.ipc$dispatch("-98010668", new Object[]{this, point});
            return;
        }
        this.matrix.postTranslate(com.alibaba.wireless.security.aopsdk.replace.android.graphics.Point.getx(point) - getTranslateX(), com.alibaba.wireless.security.aopsdk.replace.android.graphics.Point.gety(point) - getTranslateY());
        invalidate();
    }

    private void moveAnimate(Point point, Point point2, long j) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-319786394")) {
            ipChange.ipc$dispatch("-319786394", new Object[]{this, point, point2, Long.valueOf(j)});
            return;
        }
        ValueAnimator ofObject = ValueAnimator.ofObject(new d(this), point, point2);
        ofObject.setInterpolator(new DecelerateInterpolator());
        ofObject.addUpdateListener(new c());
        ofObject.setDuration(j);
        ofObject.start();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void seatTabClickEvent(MotionEvent motionEvent) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1429514587")) {
            ipChange.ipc$dispatch("1429514587", new Object[]{this, motionEvent});
            return;
        }
        int x = (int) motionEvent.getX();
        int y = (int) motionEvent.getY();
        try {
            float translateX = getTranslateX() + getCurrentLeftRightPadding();
            float translateY = getTranslateY();
            float matrixScaleY = getMatrixScaleY();
            float matrixScaleX = getMatrixScaleX();
            float f = this.defaultImgH * matrixScaleY;
            float f2 = this.defaultImgW * matrixScaleX;
            float f3 = this.mVerSpacing * matrixScaleY;
            float f4 = this.mSpacing * matrixScaleX;
            int size = this.mSeatList.size();
            int i = 0;
            while (i < size) {
                SeatNew seatNew = this.mSeatList.get(i);
                int i2 = seatNew.x;
                SeatProfile seatProfile = this.mSeatProfile;
                float f5 = ((i2 - seatProfile.minX) * (f + f3)) + translateY;
                float f6 = f5 + f;
                float f7 = ((seatNew.y - seatProfile.minY) * (f2 + f4)) + translateX;
                float f8 = f7 + f2;
                float f9 = translateX;
                float f10 = x;
                if (f10 >= f7 && f10 <= f8) {
                    float f11 = y;
                    if (f11 >= f5 && f11 <= f6) {
                        if (this.mListener == null || seatNew.state != n92.SEAT_STATUS_AVAILABLE.shortValue()) {
                            return;
                        }
                        boolean z = seatNew.isSelected;
                        if (!z) {
                            this.isDrawOverview = true;
                            this.mSelectdSeat = true;
                        }
                        this.mListener.onSeatClick(seatNew, !z);
                        return;
                    }
                }
                i++;
                translateX = f9;
            }
        } catch (Exception e2) {
            e2.printStackTrace();
        }
    }

    private void setRowNumListWithSeatData(List<SeatNew> list) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1685046440")) {
            ipChange.ipc$dispatch("-1685046440", new Object[]{this, list});
            return;
        }
        this.rowNumList.clear();
        this.rowNumRegionList.clear();
        if (list == null || list.size() == 0) {
            return;
        }
        int i = -1;
        int i2 = 0;
        for (int size = list.size() - 1; size >= 0; size--) {
            SeatNew seatNew = list.get(size);
            int i3 = seatNew.x;
            if (i != i3) {
                if (i == -1) {
                    i2++;
                    Integer b2 = wh2.b(seatNew.rn);
                    this.rowNumList.add(b2 != null ? b2 + "" : "");
                    this.rowNumRegionList.put(i2, this.rowNumList);
                    i = seatNew.x;
                } else {
                    int i4 = i3 - i;
                    if (i4 == 1) {
                        i2++;
                        Integer b3 = wh2.b(seatNew.rn);
                        this.rowNumList.add(b3 != null ? b3 + "" : "");
                    } else {
                        for (int i5 = 0; i5 < i4; i5++) {
                            i2++;
                            if (i5 == i4 - 1) {
                                if (i4 == 2) {
                                    this.rowNumList.add("");
                                    Integer b4 = wh2.b(seatNew.rn);
                                    this.rowNumList.add(b4 == null ? "" : b4 + "");
                                } else {
                                    this.rowNumList = new ArrayList();
                                    Integer b5 = wh2.b(seatNew.rn);
                                    this.rowNumList.add(b5 == null ? "" : b5 + "");
                                    this.rowNumRegionList.put(i2, this.rowNumList);
                                }
                            }
                        }
                    }
                    i = seatNew.x;
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void zoom(float f) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1559466575")) {
            ipChange.ipc$dispatch("-1559466575", new Object[]{this, Float.valueOf(f)});
            return;
        }
        float matrixScaleX = f / getMatrixScaleX();
        this.matrix.postScale(matrixScaleX, matrixScaleX, this.scaleX, this.scaleY);
        invalidate();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void zoomAnimate(float f, float f2) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-376808230")) {
            ipChange.ipc$dispatch("-376808230", new Object[]{this, Float.valueOf(f), Float.valueOf(f2)});
            return;
        }
        ValueAnimator ofFloat = ValueAnimator.ofFloat(f, f2);
        ofFloat.setInterpolator(new DecelerateInterpolator());
        e eVar = new e();
        ofFloat.addUpdateListener(eVar);
        ofFloat.addListener(eVar);
        ofFloat.setDuration(300L);
        ofFloat.start();
    }

    void drawNumber(Canvas canvas) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "68058352")) {
            ipChange.ipc$dispatch("68058352", new Object[]{this, canvas});
        } else if (this.rowNumRegionList.size() != 0) {
            for (int i = 0; i < this.rowNumRegionList.size(); i++) {
                drawRowNumBar(canvas, this.rowNumRegionList.keyAt(i) - 1, this.rowNumRegionList.valueAt(i));
            }
        }
    }

    Bitmap drawOverview() {
        Bitmap bitmap;
        int i;
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-2123513981")) {
            return (Bitmap) ipChange.ipc$dispatch("-2123513981", new Object[]{this});
        }
        this.isDrawOverviewBitmap = false;
        this.overviewPaint.setColor(this.overviewBackgroundColor);
        this.overviewPaint.setStyle(Paint.Style.FILL);
        this.overviewBitmap.eraseColor(0);
        Canvas canvas = new Canvas(this.overviewBitmap);
        float dip2px = ScreenUtil.dip2px(this.mContext, 2.0f);
        canvas.drawRoundRect(new RectF(0.0f, 0.0f, this.mOverviewW, this.mOverviewH), dip2px, dip2px, this.overviewPaint);
        canvas.drawBitmap(this.screenOverviewBitmap, (this.mOverviewW - bitmap.getWidth()) / 2.0f, 0.0f, this.paint);
        float height = this.screenOverviewBitmap.getHeight() + this.overscreenOverviewVerSpacing;
        float f = (this.mOverviewW - ((this.mOverviewSeatWidth * this.column) + (this.mOverviewSpacing * (i - 1)))) / 2.0f;
        for (int i2 = 0; i2 < this.mSeatList.size(); i2++) {
            SeatNew seatNew = this.mSeatList.get(i2);
            int i3 = seatNew.y;
            SeatProfile seatProfile = this.mSeatProfile;
            float f2 = ((i3 - seatProfile.minY) * (this.mOverviewSeatWidth + this.mOverviewSpacing)) + f;
            float f3 = ((seatNew.x - seatProfile.minX) * (this.mOverviewSeatHeight + this.mOverviewVerSpacing)) + height;
            int i4 = seatNew.state;
            if (i4 != 2) {
                if (i4 == 4) {
                    this.overviewPaint.setColor(this.unavailableSeatColor);
                } else if (i4 != 8) {
                    this.overviewPaint.setColor(this.unavailableSeatColor);
                } else {
                    this.overviewPaint.setColor(this.unavailableSeatColor);
                }
            } else if (seatNew.isSelected) {
                this.overviewPaint.setColor(Color.parseColor("#47A231"));
            } else {
                this.overviewPaint.setColor(seatNew.seatColor);
            }
            canvas.drawRect(f2, f3, this.mOverviewSeatWidth + f2, f3 + this.mOverviewSeatHeight, this.overviewPaint);
        }
        return this.overviewBitmap;
    }

    public void init(Context context) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "565854838")) {
            ipChange.ipc$dispatch("565854838", new Object[]{this, context});
            return;
        }
        this.mContext = context;
        initSeatImageData();
        initPaintData(context);
        initData(context);
    }

    @Override // android.view.View
    protected void onDraw(Canvas canvas) {
        List<SeatNew> list;
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1649842298")) {
            ipChange.ipc$dispatch("-1649842298", new Object[]{this, canvas});
            return;
        }
        long currentTimeMillis = System.currentTimeMillis();
        if (this.mSeatProfile == null || (list = this.mSeatList) == null || list.isEmpty()) {
            return;
        }
        try {
            if (this.mFirstDraw) {
                this.mViewWidth = getWidth();
                this.mViewHeight = getViewUsedHeight();
                this.initialOffsetY = m62.a(this.mContext, 10.0f) + this.mVerSpacing + this.screenRectF.bottom;
                this.initialOffsetRectY = this.mOverviewH + m62.a(this.mContext, 10.0f);
                this.mMinTranslateX = 0.0f;
                if (this.currentScaleLevel == 4) {
                    float f = this.minScale;
                    float f2 = this.maxScale;
                    if (f == f2) {
                        float f3 = this.mDefaultSeatViewWidth * f2;
                        int i = this.mPhoneScreenWidth;
                        if (f3 < i) {
                            this.mMinTranslateX = (i - f3) / 2.0f;
                        }
                    }
                }
                this.matrix.setTranslate(this.mMinTranslateX, this.initialOffsetY);
                float f4 = this.mCurrentScale;
                if (f4 != 1.0f) {
                    this.matrix.preScale(f4, f4);
                }
                float f5 = this.mOverviewSeatWidth;
                int i2 = this.column;
                float f6 = this.mOverviewW;
                this.redBorderLeftBoundary = (((getWidth() - this.mOverViewOffsetX) - f6) + ((f6 - ((f5 * i2) + (this.mOverviewSpacing * (i2 - 1)))) / 2.0f)) - this.redBorderPaint.getStrokeWidth();
                this.redBorderTopBoundary = ((this.screenOverviewBitmap.getHeight() + this.overscreenOverviewVerSpacing) + this.mOverViewOffsetY) - this.redBorderPaint.getStrokeWidth();
                this.redBorderRightBoundary = (this.column * (this.mOverviewSeatWidth + this.mOverviewSpacing)) + this.redBorderPaint.getStrokeWidth() + this.redBorderLeftBoundary;
                this.redBorderBottomBoundary = (this.row * (this.mOverviewSeatHeight + this.mOverviewVerSpacing)) + this.redBorderPaint.getStrokeWidth() + this.redBorderTopBoundary;
                this.mFirstDraw = false;
            }
            drawSeat(canvas);
            if (this.currentScaleLevel == 4) {
                drawNumber(canvas);
            }
            drawScreen(canvas);
            if (this.isDrawOverview) {
                long currentTimeMillis2 = System.currentTimeMillis();
                if (this.isDrawOverviewBitmap) {
                    drawOverview();
                }
                canvas.drawBitmap(this.overviewBitmap, (getWidth() - this.mOverviewW) - this.mOverViewOffsetX, this.mOverViewOffsetY, (Paint) null);
                drawOverview(canvas);
                cb1.b(TAG, "OverviewDrawTime:" + (System.currentTimeMillis() - currentTimeMillis2));
            }
            cb1.b(TAG, "totalDrawTime:" + (System.currentTimeMillis() - currentTimeMillis) + " ,scale = " + getMatrixScaleX() + " ,padding = " + getCurrentLeftRightPadding() + " , seatSize = " + (this.defaultImgW * getMatrixScaleX()));
        } catch (Exception e2) {
            e2.printStackTrace();
        }
    }

    @Override // android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1794049119")) {
            return ((Boolean) ipChange.ipc$dispatch("-1794049119", new Object[]{this, motionEvent})).booleanValue();
        }
        this.scaleGestureDetector.onTouchEvent(motionEvent);
        this.gestureDetector.onTouchEvent(motionEvent);
        int action = motionEvent.getAction();
        if (action == 0) {
            this.mSelectdSeat = false;
            this.handler.removeCallbacks(this.hideOverviewRunnable);
        } else if (action == 1) {
            if (!this.mSelectdSeat) {
                this.handler.postDelayed(this.hideOverviewRunnable, 500L);
            }
            if (!this.isScaling && !this.isFling) {
                autoScroll();
            }
            this.isScaling = false;
            this.isFling = false;
            this.isOnClick = false;
        }
        return true;
    }

    public void setData(SeatProfile seatProfile) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "2044560055")) {
            ipChange.ipc$dispatch("2044560055", new Object[]{this, seatProfile});
        } else if (seatProfile == null) {
        } else {
            this.mSeatProfile = seatProfile;
            List<SeatNew> list = seatProfile.seatList;
            this.mSeatList = list;
            this.row = (seatProfile.maxX - seatProfile.minX) + 1;
            this.column = (seatProfile.maxY - seatProfile.minY) + 1;
            setRowNumListWithSeatData(list);
        }
    }

    public void setListener(OnSeatClickListener onSeatClickListener) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-329690922")) {
            ipChange.ipc$dispatch("-329690922", new Object[]{this, onSeatClickListener});
        } else {
            this.mListener = onSeatClickListener;
        }
    }

    public void setProvider(g92 g92Var) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1814151514")) {
            ipChange.ipc$dispatch("-1814151514", new Object[]{this, g92Var});
        } else {
            this.mIconProvider = g92Var;
        }
    }

    public void setSelectedPriceId(long j) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1050070519")) {
            ipChange.ipc$dispatch("-1050070519", new Object[]{this, Long.valueOf(j)});
        } else {
            this.mSelectedPriceId = j;
        }
    }

    public void setSelectedPriceIdAndZoomToSeat(long j) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "2052422911")) {
            ipChange.ipc$dispatch("2052422911", new Object[]{this, Long.valueOf(j)});
            return;
        }
        this.mSelectedPriceId = j;
        if (j == -1) {
            invalidate();
            return;
        }
        this.isDrawOverview = false;
        float matrixScaleX = getMatrixScaleX();
        this.currentScaleLevel = 1;
        zoomAnimate(matrixScaleX, this.minScale);
    }

    public void updateData(SeatProfile seatProfile) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-2019080150")) {
            ipChange.ipc$dispatch("-2019080150", new Object[]{this, seatProfile});
            return;
        }
        this.mSeatProfile = seatProfile;
        invalidate();
    }

    public SeatView(Context context, @Nullable AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public SeatView(Context context, @Nullable AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.mFirstDraw = true;
        this.mMinTranslateX = 0.0f;
        this.currentScaleLevel = 3;
        this.offsetScale = 0.25f;
        this.dragMoveCoefficient = 0.75f;
        this.isDrawOverviewBitmap = true;
        this.firstScale = true;
        this.overviewPaint = new Paint();
        this.matrix = new Matrix();
        this.tempMatrix = new Matrix();
        this.matrixValues = new float[9];
        this.mSeatList = new ArrayList();
        this.mSelectedPriceId = -1L;
        this.rowNumList = new ArrayList();
        this.rowNumRegionList = new SparseArrayCompat<>();
        this.handler = new Handler();
        this.scaleGestureDetector = new ScaleGestureDetector(getContext(), new a());
        this.gestureDetector = new GestureDetector(getContext(), new b());
        this.hideOverviewRunnable = new Runnable() { // from class: cn.damai.seat.view.SeatView.3
            private static transient /* synthetic */ IpChange $ipChange;

            @Override // java.lang.Runnable
            public void run() {
                IpChange ipChange = $ipChange;
                if (AndroidInstantRuntime.support(ipChange, "-431060786")) {
                    ipChange.ipc$dispatch("-431060786", new Object[]{this});
                    return;
                }
                SeatView.this.isDrawOverview = false;
                SeatView.this.invalidate();
            }
        };
        this.seatViewPaddingBottom = m62.a(context, 48.0f);
    }

    private void moveAnimate(Point point, Point point2) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "959514654")) {
            ipChange.ipc$dispatch("959514654", new Object[]{this, point, point2});
        } else {
            moveAnimate(point, point2, 300L);
        }
    }

    private void drawOverview(Canvas canvas) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1372496544")) {
            ipChange.ipc$dispatch("-1372496544", new Object[]{this, canvas});
            return;
        }
        float matrixScaleX = this.redBorderLeftBoundary + (((-getTranslateX()) / getMatrixScaleX()) * this.mOverviewScale);
        float f = this.redBorderLeftBoundary;
        if (matrixScaleX < f) {
            matrixScaleX = f;
        }
        float translateX = getTranslateX();
        int i = this.column;
        int matrixScaleX2 = (int) (translateX + (((i * this.defaultImgW) + (this.mSpacing * (i - 1))) * getMatrixScaleX()));
        float width = this.redBorderRightBoundary - (((matrixScaleX2 > getWidth() ? matrixScaleX2 - getWidth() : 0) / getMatrixScaleX()) * this.mOverviewScale);
        float matrixScaleX3 = this.redBorderTopBoundary + (((getTranslateY() > this.screenRectF.bottom ? 0.0f : -(getTranslateY() - this.screenRectF.bottom)) / getMatrixScaleX()) * this.mOverviewScale);
        float f2 = this.redBorderTopBoundary;
        if (matrixScaleX3 < f2) {
            matrixScaleX3 = f2;
        }
        float translateY = getTranslateY();
        int i2 = this.row;
        int matrixScaleY = (int) (translateY + (((i2 * this.defaultImgH) + (this.mVerSpacing * (i2 - 1))) * getMatrixScaleY()));
        float height = this.redBorderBottomBoundary - (((matrixScaleY > getHeight() ? matrixScaleY - getHeight() : 0) / getMatrixScaleX()) * this.mOverviewScale);
        if (matrixScaleX >= width) {
            matrixScaleX = width - this.redBorderPaint.getStrokeWidth();
        }
        canvas.drawRect(matrixScaleX, height <= matrixScaleX3 ? height - this.redBorderPaint.getStrokeWidth() : matrixScaleX3, width, height, this.redBorderPaint);
    }
}
