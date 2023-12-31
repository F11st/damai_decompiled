package cn.damai.seat.view;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.TypeEvaluator;
import android.animation.ValueAnimator;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.DashPathEffect;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.Picture;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.drawable.PictureDrawable;
import android.os.Handler;
import android.text.TextPaint;
import android.text.TextUtils;
import android.view.MotionEvent;
import android.view.VelocityTracker;
import android.view.View;
import android.view.ViewConfiguration;
import android.view.animation.DecelerateInterpolator;
import androidx.annotation.Nullable;
import androidx.collection.ArrayMap;
import cn.damai.commonbusiness.seatbiz.seat.common.bean.region.Region;
import cn.damai.commonbusiness.seatbiz.seat.common.bean.region.RegionData;
import cn.damai.commonbusiness.seatbiz.seat.common.bean.seat.SeatNew;
import cn.damai.commonbusiness.seatbiz.seat.qilin.bean.PriceLevel;
import cn.damai.commonbusiness.seatbiz.seat.qilin.bean.SeatBox;
import cn.damai.commonbusiness.seatbiz.seat.qilin.bean.TbParams;
import cn.damai.commonbusiness.seatbiz.view.svgview.core.model.PointLocation;
import cn.damai.commonbusiness.seatbiz.view.svgview.core.model.RegionBound;
import cn.damai.seat.listener.RegionSeatRequestChecker;
import com.ali.user.mobile.utils.ScreenUtil;
import com.alibaba.wireless.security.aopsdk.replace.android.util.DisplayMetrics;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import tb.ad0;
import tb.bb;
import tb.cb2;
import tb.f92;
import tb.g92;
import tb.h12;
import tb.hs;
import tb.m62;
import tb.n92;
import tb.t92;

/* compiled from: Taobao */
/* loaded from: classes16.dex */
public class RegionSeatView extends View {
    private static transient /* synthetic */ IpChange $ipChange;
    public static boolean isShowSvgRegionBound;
    private float bestRegionImageWidth;
    private float bigVenueInitRegionImageWidth;
    private c drawSeat;
    private Runnable hideOverviewRunnable;
    private boolean isDrawOverview;
    private boolean isFirstDraw;
    private boolean isReportDrawError;
    private boolean isSeatStateChanged;
    private boolean isShow;
    private boolean isShowOverview;
    private boolean isSmallVenueStyle;
    private boolean isVenueMode;
    private boolean mAlwaysInTapRegion;
    private Rect mBackgroundRect;
    private float mBigVenueScale36Width;
    private int mClickScaleOffset;
    private Picture mColorRegionPicture;
    private Context mContext;
    private float mDLeft;
    private float mDTop;
    private float mDWidth;
    private float mDownX;
    private float mDownY;
    private Handler mHandler;
    private g92 mIconProvider;
    private ArrayMap<String, List<SeatNew>> mInScreenSeatData;
    private float mLastFocusX;
    private float mLastFocusY;
    private OnSeatViewListener mListener;
    private List<Picture> mLocationPics4Test;
    private int mMaximumFlingVelocity;
    private int mMinimumFlingVelocity;
    private ad0 mMonitor;
    private int mOverViewOffset;
    private RectF mOverviewRect;
    private final Map<String, List<Picture>> mPackageSeatWrapLineMap;
    private Paint mPaint;
    private Paint mPaintJust4Test;
    private TbParams mParams;
    private List<RegionBound> mRegionBounds;
    private RegionData mRegionData;
    private ArrayMap<String, String> mRegionVid2IdMap;
    private Picture mSVGVenueLayerPicture;
    private float mScale09;
    private float mScale18;
    private float mScale36;
    private float mScale50;
    private float mScaleDistance;
    private boolean mScaling;
    private SeatBox mSeatBox;
    private RectF mSeatRect;
    private RegionSeatRequestChecker mSeatRequestChecker;
    private PriceLevel mSelectPrice;
    private List<List<PointLocation>> mSvgRegionLocations;
    private float mSvgScale;
    private TextPaint mTextPaintJust4Test;
    private int mTouchSlop;
    private int mTouchSlopSquare;
    private VelocityTracker mVelocityTracker;
    private int maxOverViewRectWidth;
    private float maxRegionImageWidth;
    private float minRegionImageDrawSeatWidth;
    private float minRegionImageWidth;
    private int overviewBackgroundColor;
    private Bitmap overviewBitmap;
    private Canvas overviewCanvas;
    private Paint overviewPaint;
    private float overviewSpacing;
    private Paint packageSeatBorderPaint;
    private float rectH;
    private float rectW;
    private float redBorderBottomBoundary;
    private float redBorderLeftBoundary;
    private Paint redBorderPaint;
    private float redBorderRightBoundary;
    private float redBorderTopBoundary;
    private float regionImageHeight;
    private float regionImageWidth;
    private PictureDrawable regionPictureDataWithoutColor;
    private List<Region> regions;
    private Paint seatPaint;
    private int seatViewPaddingBottom;
    private int unavailableSeatColor;
    private int viewHeight;
    private int viewWidth;

    /* compiled from: Taobao */
    /* loaded from: classes16.dex */
    public interface OnSeatViewListener {
        void onSeatSelectChanged(SeatNew seatNew, boolean z);

        void onShowBack2Venue(boolean z, boolean z2, boolean z3, Bitmap bitmap, int i, int i2);

        void onVenueModeChanged(boolean z);
    }

    /* compiled from: Taobao */
    /* loaded from: classes16.dex */
    public class a extends AnimatorListenerAdapter {
        private static transient /* synthetic */ IpChange $ipChange;

        a() {
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationEnd(Animator animator) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "-1389391445")) {
                ipChange.ipc$dispatch("-1389391445", new Object[]{this, animator});
                return;
            }
            RegionSeatView.this.isDrawOverview = false;
            RegionSeatView.this.notifyOverViewChanged(true);
        }
    }

    /* compiled from: Taobao */
    /* loaded from: classes16.dex */
    public class b extends AnimatorListenerAdapter {
        private static transient /* synthetic */ IpChange $ipChange;

        b() {
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationEnd(Animator animator) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "-1397150804")) {
                ipChange.ipc$dispatch("-1397150804", new Object[]{this, animator});
            } else {
                RegionSeatView.this.notifyOverViewChanged(false);
            }
        }
    }

    /* compiled from: Taobao */
    /* loaded from: classes16.dex */
    public class c {
        private static transient /* synthetic */ IpChange $ipChange;
        float a = 0.0f;
        float b = 0.0f;
        float c = 0.0f;
        float d = 0.0f;
        float e = 1.0f;
        int f = 20;
        int g = 24;

        c() {
        }

        public void a(float f) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "-814038725")) {
                ipChange.ipc$dispatch("-814038725", new Object[]{this, Float.valueOf(f)});
                return;
            }
            this.a = f;
            this.e = f / RegionSeatView.this.regionImageWidth;
            float f2 = RegionSeatView.this.regionImageHeight;
            float f3 = this.e;
            this.b = f2 * f3;
            this.g = (int) (this.f * f3);
        }
    }

    /* compiled from: Taobao */
    /* loaded from: classes16.dex */
    public class d implements ValueAnimator.AnimatorUpdateListener {
        private static transient /* synthetic */ IpChange $ipChange;

        d() {
        }

        @Override // android.animation.ValueAnimator.AnimatorUpdateListener
        public void onAnimationUpdate(ValueAnimator valueAnimator) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "-1624042624")) {
                ipChange.ipc$dispatch("-1624042624", new Object[]{this, valueAnimator});
                return;
            }
            f fVar = (f) valueAnimator.getAnimatedValue();
            RegionSeatView.this.scrollView(fVar.a, fVar.b);
        }
    }

    /* compiled from: Taobao */
    /* loaded from: classes16.dex */
    public class e implements TypeEvaluator {
        private static transient /* synthetic */ IpChange $ipChange;

        e() {
        }

        @Override // android.animation.TypeEvaluator
        public Object evaluate(float f, Object obj, Object obj2) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "1398956461")) {
                return ipChange.ipc$dispatch("1398956461", new Object[]{this, Float.valueOf(f), obj, obj2});
            }
            f fVar = (f) obj;
            f fVar2 = (f) obj2;
            float f2 = fVar.a;
            float f3 = f2 + ((fVar2.a - f2) * f);
            float f4 = fVar.b;
            float f5 = fVar.c;
            return new f(RegionSeatView.this, f3, f4 + ((fVar2.b - f4) * f), f5 + (f * (fVar2.c - f5)));
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: Taobao */
    /* loaded from: classes16.dex */
    public class f {
        public float a;
        public float b;
        public float c;

        f(RegionSeatView regionSeatView, float f, float f2, float f3) {
            this.a = f;
            this.b = f2;
            this.c = f3;
        }
    }

    /* compiled from: Taobao */
    /* loaded from: classes16.dex */
    public class g implements ValueAnimator.AnimatorUpdateListener {
        private static transient /* synthetic */ IpChange $ipChange;

        g() {
        }

        @Override // android.animation.ValueAnimator.AnimatorUpdateListener
        public void onAnimationUpdate(ValueAnimator valueAnimator) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "1696637339")) {
                ipChange.ipc$dispatch("1696637339", new Object[]{this, valueAnimator});
                return;
            }
            f fVar = (f) valueAnimator.getAnimatedValue();
            RegionSeatView.this.drawSeat.c = fVar.a;
            RegionSeatView.this.drawSeat.d = fVar.b;
            RegionSeatView.this.drawSeat.a(fVar.c);
            RegionSeatView.this.invalidate();
        }
    }

    public RegionSeatView(Context context, RegionData regionData, g92 g92Var, TbParams tbParams) {
        super(context);
        this.mHandler = new Handler();
        this.drawSeat = new c();
        this.viewWidth = 0;
        this.viewHeight = 0;
        this.mSvgScale = 1.0f;
        this.isFirstDraw = true;
        this.isDrawOverview = false;
        this.isShowOverview = true;
        this.isSeatStateChanged = true;
        this.mPackageSeatWrapLineMap = new HashMap();
        this.mMonitor = new ad0();
        this.isReportDrawError = false;
        this.mLocationPics4Test = new ArrayList();
        this.hideOverviewRunnable = new Runnable() { // from class: cn.damai.seat.view.RegionSeatView.1
            private static transient /* synthetic */ IpChange $ipChange;

            @Override // java.lang.Runnable
            public void run() {
                IpChange ipChange = $ipChange;
                if (AndroidInstantRuntime.support(ipChange, "-972654020")) {
                    ipChange.ipc$dispatch("-972654020", new Object[]{this});
                    return;
                }
                RegionSeatView.this.isDrawOverview = false;
                RegionSeatView.this.invalidate();
                RegionSeatView.this.notifyOverViewChanged(true);
            }
        };
        this.mContext = context;
        this.mRegionData = regionData;
        this.mIconProvider = g92Var;
        this.mParams = tbParams;
        initView(context);
        if (t92.c(f92.k(tbParams), false)) {
            setLayerType(2, null);
        } else {
            setLayerType(1, null);
        }
    }

    private void autoScale(MotionEvent motionEvent) {
        float f2;
        float y;
        float y2;
        float f3;
        float f4;
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1463967186")) {
            ipChange.ipc$dispatch("-1463967186", new Object[]{this, motionEvent});
            return;
        }
        c cVar = this.drawSeat;
        float f5 = cVar.c;
        float f6 = cVar.d;
        float f7 = cVar.a;
        float f8 = this.isSmallVenueStyle ? this.bestRegionImageWidth : this.mBigVenueScale36Width;
        if (f7 < f8) {
            f2 = f8 / f7;
            f5 = motionEvent.getX() - ((motionEvent.getX() - f5) * f2);
            y = motionEvent.getY();
            y2 = motionEvent.getY();
        } else {
            f8 = this.maxRegionImageWidth;
            if (f7 < f8) {
                f2 = f8 / f7;
                f5 = motionEvent.getX() - ((motionEvent.getX() - f5) * f2);
                y = motionEvent.getY();
                y2 = motionEvent.getY();
            }
            float x = motionEvent.getX();
            float y3 = motionEvent.getY();
            f3 = (this.viewWidth / 2) - x;
            f4 = (this.viewHeight / 2) - y3;
            c cVar2 = this.drawSeat;
            f fVar = new f(this, cVar2.c, cVar2.d, cVar2.a);
            if (Math.abs(f3) <= this.mClickScaleOffset || Math.abs(f4) > this.mClickScaleOffset || Math.abs(f7 - this.drawSeat.a) > 0.0f) {
                zoomAnimate(fVar, new f(this, f5 + f3, f6 + f4, f7));
            }
            return;
        }
        f6 = y - ((y2 - f6) * f2);
        f7 = f8;
        float x2 = motionEvent.getX();
        float y32 = motionEvent.getY();
        f3 = (this.viewWidth / 2) - x2;
        f4 = (this.viewHeight / 2) - y32;
        c cVar22 = this.drawSeat;
        f fVar2 = new f(this, cVar22.c, cVar22.d, cVar22.a);
        if (Math.abs(f3) <= this.mClickScaleOffset) {
        }
        zoomAnimate(fVar2, new f(this, f5 + f3, f6 + f4, f7));
    }

    private void click(float f2, float f3) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "865825292")) {
            ipChange.ipc$dispatch("865825292", new Object[]{this, Float.valueOf(f2), Float.valueOf(f3)});
            return;
        }
        try {
            if (this.isShow && this.mListener != null) {
                int size = this.mInScreenSeatData.size();
                boolean z = false;
                boolean z2 = false;
                for (int i = 0; i < size; i++) {
                    List<SeatNew> valueAt = this.mInScreenSeatData.valueAt(i);
                    if (valueAt != null) {
                        int size2 = valueAt.size();
                        int i2 = 0;
                        while (true) {
                            if (i2 >= size2) {
                                break;
                            }
                            SeatNew seatNew = valueAt.get(i2);
                            float f4 = seatNew.currentY;
                            int i3 = this.drawSeat.g;
                            if (f3 >= f4 - (i3 / 2) && f3 <= f4 + (i3 / 2)) {
                                float f5 = seatNew.currentX;
                                if (f2 >= f5 - (i3 / 2) && f2 <= f5 + (i3 / 2)) {
                                    if (seatNew.isSelected) {
                                        this.mListener.onSeatSelectChanged(seatNew, false);
                                    } else if (seatNew.state == 2) {
                                        this.isDrawOverview = true;
                                        this.mListener.onSeatSelectChanged(seatNew, true);
                                        z2 = true;
                                    }
                                    invalidate();
                                    z = true;
                                }
                            }
                            i2++;
                        }
                        if (z) {
                            break;
                        }
                    }
                }
                if (z && z2) {
                    return;
                }
                this.mHandler.postDelayed(this.hideOverviewRunnable, 500L);
            }
        } catch (Exception e2) {
            e2.printStackTrace();
        }
    }

    private void computeOffset2AdjustBounds(float[] fArr) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1784911499")) {
            ipChange.ipc$dispatch("-1784911499", new Object[]{this, fArr});
            return;
        }
        fArr[0] = 0.0f;
        fArr[1] = 0.0f;
        c cVar = this.drawSeat;
        if (cVar != null) {
            float f2 = cVar.a;
            if (f2 > 0.0f) {
                float f3 = cVar.c;
                float f4 = f2 + f3;
                float f5 = cVar.d;
                float f6 = cVar.b + f5;
                if ((f3 > 0.0f || f4 < ((float) this.viewWidth)) && (f3 < 0.0f || f4 > ((float) this.viewWidth))) {
                    boolean z = (f2 / 2.0f) + f3 > ((float) this.viewWidth) / 2.0f;
                    float min = Math.min(Math.abs(f3), Math.abs(f4 - this.viewWidth));
                    if (z) {
                        min = -min;
                    }
                    fArr[0] = min;
                }
                if ((f5 > 0.0f || f6 < ((float) this.viewHeight)) && (f5 < 0.0f || f6 > ((float) this.viewHeight))) {
                    boolean z2 = (this.drawSeat.b / 2.0f) + f5 > ((float) this.viewHeight) / 2.0f;
                    float min2 = Math.min(Math.abs(f5), Math.abs(f6 - this.viewHeight));
                    if (z2) {
                        min2 = -min2;
                    }
                    fArr[1] = min2;
                }
            }
        }
    }

    private void flingAnimate(float f2, float f3) {
        float max;
        float max2;
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1828560335")) {
            ipChange.ipc$dispatch("-1828560335", new Object[]{this, Float.valueOf(f2), Float.valueOf(f3)});
            return;
        }
        float f4 = f2 * 1.2f;
        float f5 = f3 * 1.2f;
        c cVar = this.drawSeat;
        f fVar = new f(this, cVar.c, cVar.d, cVar.a);
        c cVar2 = this.drawSeat;
        float f6 = 400;
        float f7 = cVar2.c + ((f4 / 1000.0f) * f6 * 0.5f);
        float f8 = cVar2.d + ((f5 / 1000.0f) * f6 * 0.5f);
        if (f4 > 0.0f) {
            float f9 = cVar2.a;
            int i = this.viewWidth;
            max = f9 > ((float) i) ? Math.min(f7, 0.0f) : Math.min(f7, i - f9);
        } else {
            float f10 = cVar2.a;
            int i2 = this.viewWidth;
            max = f10 > ((float) i2) ? Math.max(f7, i2 - f10) : Math.max(0.0f, f7);
        }
        if (f5 > 0.0f) {
            float f11 = this.drawSeat.b;
            int i3 = this.viewHeight;
            max2 = f11 > ((float) i3) ? Math.min(f8, 0.0f) : Math.min(f8, i3 - f11);
        } else {
            float f12 = this.drawSeat.b;
            int i4 = this.viewHeight;
            max2 = f12 > ((float) i4) ? Math.max(f8, i4 - f12) : Math.max(f8, 0.0f);
        }
        ValueAnimator ofObject = ValueAnimator.ofObject(new e(), fVar, new f(this, max, max2, this.drawSeat.a));
        ofObject.setInterpolator(new DecelerateInterpolator());
        ofObject.addUpdateListener(new d());
        ofObject.setDuration(400);
        ofObject.start();
    }

    private ArrayMap<String, List<SeatNew>> getAllRegion() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "2025888448")) {
            return (ArrayMap) ipChange.ipc$dispatch("2025888448", new Object[]{this});
        }
        if (this.mSeatBox == null) {
            return this.mInScreenSeatData;
        }
        this.mInScreenSeatData.clear();
        for (int i = 0; i < this.mSeatBox.seatNewMap.size(); i++) {
            this.mInScreenSeatData.put(this.mSeatBox.seatNewMap.keyAt(i), this.mSeatBox.seatNewMap.valueAt(i));
        }
        return this.mInScreenSeatData;
    }

    private ArrayMap<String, List<SeatNew>> getCurrentShownRegion() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1715727685")) {
            return (ArrayMap) ipChange.ipc$dispatch("1715727685", new Object[]{this});
        }
        if (this.mSeatBox == null) {
            return this.mInScreenSeatData;
        }
        List<String> currentRegionIdsInScreen = getCurrentRegionIdsInScreen();
        if (currentRegionIdsInScreen != null && !currentRegionIdsInScreen.isEmpty()) {
            this.mInScreenSeatData.clear();
            for (int i = 0; i < currentRegionIdsInScreen.size(); i++) {
                String str = currentRegionIdsInScreen.get(i);
                this.mInScreenSeatData.put(str, this.mSeatBox.seatNewMap.get(str));
            }
            return this.mInScreenSeatData;
        }
        if (this.mInScreenSeatData.isEmpty()) {
            this.mInScreenSeatData = getAllRegion();
        }
        return this.mInScreenSeatData;
    }

    private Bitmap getOverviewBitmap(Picture picture) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1949993367")) {
            return (Bitmap) ipChange.ipc$dispatch("-1949993367", new Object[]{this, picture});
        }
        Bitmap bitmap = this.overviewBitmap;
        if (bitmap == null) {
            this.overviewBitmap = Bitmap.createBitmap((int) this.rectW, (int) this.rectH, Bitmap.Config.ARGB_8888);
        } else {
            bitmap.eraseColor(0);
        }
        if (this.overviewCanvas == null) {
            this.overviewCanvas = new Canvas(this.overviewBitmap);
        }
        this.overviewPaint.setColor(this.overviewBackgroundColor);
        this.overviewPaint.setStyle(Paint.Style.FILL);
        float dip2px = ScreenUtil.dip2px(this.mContext, 6.0f);
        this.overviewCanvas.drawRoundRect(new RectF(0.0f, 0.0f, this.rectW, this.rectH), dip2px, dip2px, this.overviewPaint);
        RectF rectF = this.mOverviewRect;
        float f2 = this.overviewSpacing;
        rectF.set(f2, f2, this.rectW - f2, this.rectH - f2);
        this.overviewCanvas.drawPicture(picture, this.mOverviewRect);
        return this.overviewBitmap;
    }

    private int getViewUsedHeight() {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "714914792") ? ((Integer) ipChange.ipc$dispatch("714914792", new Object[]{this})).intValue() : getHeight() - this.seatViewPaddingBottom;
    }

    private boolean isNeedAddAlpha(SeatNew seatNew) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "102640480")) {
            return ((Boolean) ipChange.ipc$dispatch("102640480", new Object[]{this, seatNew})).booleanValue();
        }
        PriceLevel priceLevel = this.mSelectPrice;
        if (priceLevel != null) {
            long j = seatNew.isPackaged ? seatNew.packagedPriceIndexId : seatNew.priceLevel;
            if (priceLevel.isSinglePrice() || this.mSelectPrice.isTaoPiao()) {
                return j != this.mSelectPrice.getPriceId();
            }
            Long valueOf = Long.valueOf(j);
            HashSet<Long> subPriceIds = this.mSelectPrice.getSubPriceIds();
            if (cb2.d(subPriceIds)) {
                return true;
            }
            return !subPriceIds.contains(valueOf);
        }
        return false;
    }

    private boolean needAutoScale() {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "133093779") ? ((Boolean) ipChange.ipc$dispatch("133093779", new Object[]{this})).booleanValue() : this.drawSeat.a < this.maxRegionImageWidth;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Code restructure failed: missing block: B:13:0x0033, code lost:
        if ((r1 - (0.05f * r6)) > r6) goto L23;
     */
    /* JADX WARN: Code restructure failed: missing block: B:16:0x003c, code lost:
        if (r1.a >= r11.minRegionImageDrawSeatWidth) goto L23;
     */
    /* JADX WARN: Code restructure failed: missing block: B:17:0x003e, code lost:
        r1 = true;
     */
    /* JADX WARN: Code restructure failed: missing block: B:18:0x0040, code lost:
        r1 = false;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public void notifyOverViewChanged(boolean r12) {
        /*
            r11 = this;
            com.android.alibaba.ip.runtime.IpChange r0 = cn.damai.seat.view.RegionSeatView.$ipChange
            java.lang.String r1 = "2067512082"
            boolean r2 = com.android.alibaba.ip.runtime.AndroidInstantRuntime.support(r0, r1)
            r3 = 1
            r4 = 0
            if (r2 == 0) goto L1b
            r2 = 2
            java.lang.Object[] r2 = new java.lang.Object[r2]
            r2[r4] = r11
            java.lang.Boolean r12 = java.lang.Boolean.valueOf(r12)
            r2[r3] = r12
            r0.ipc$dispatch(r1, r2)
            return
        L1b:
            cn.damai.seat.view.RegionSeatView$OnSeatViewListener r0 = r11.mListener
            if (r0 == 0) goto L57
            cn.damai.seat.view.RegionSeatView$c r1 = r11.drawSeat
            if (r1 == 0) goto L57
            boolean r5 = r11.isSmallVenueStyle
            if (r5 == 0) goto L36
            float r1 = r1.a
            r2 = 1028443341(0x3d4ccccd, float:0.05)
            float r6 = r11.minRegionImageWidth
            float r2 = r2 * r6
            float r1 = r1 - r2
            int r1 = (r1 > r6 ? 1 : (r1 == r6 ? 0 : -1))
            if (r1 <= 0) goto L40
            goto L3e
        L36:
            float r1 = r1.a
            float r2 = r11.minRegionImageDrawSeatWidth
            int r1 = (r1 > r2 ? 1 : (r1 == r2 ? 0 : -1))
            if (r1 < 0) goto L40
        L3e:
            r1 = 1
            goto L41
        L40:
            r1 = 0
        L41:
            r6 = r1
            if (r12 == 0) goto L4a
            boolean r12 = r11.isShowOverview
            if (r12 == 0) goto L4a
            r7 = 1
            goto L4b
        L4a:
            r7 = 0
        L4b:
            android.graphics.Bitmap r8 = r11.overviewBitmap
            float r12 = r11.rectW
            int r9 = (int) r12
            float r12 = r11.rectH
            int r10 = (int) r12
            r4 = r0
            r4.onShowBack2Venue(r5, r6, r7, r8, r9, r10)
        L57:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: cn.damai.seat.view.RegionSeatView.notifyOverViewChanged(boolean):void");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void scrollView(float f2, float f3) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1864411492")) {
            ipChange.ipc$dispatch("1864411492", new Object[]{this, Float.valueOf(f2), Float.valueOf(f3)});
            return;
        }
        int i = this.viewWidth;
        if (f2 > i / 2) {
            this.drawSeat.c = i / 2;
        } else {
            c cVar = this.drawSeat;
            float f4 = cVar.a;
            if (f2 + f4 < i / 2) {
                cVar.c = (i / 2) - f4;
            } else {
                cVar.c = f2;
            }
        }
        int i2 = this.viewHeight;
        if (f3 > i2 / 2) {
            this.drawSeat.d = i2 / 2;
        } else {
            c cVar2 = this.drawSeat;
            float f5 = cVar2.b;
            if (f3 + f5 < i2 / 2) {
                cVar2.d = (i2 / 2) - f5;
            } else {
                cVar2.d = f3;
            }
        }
        invalidate();
    }

    private float spacing(float f2, float f3, float f4, float f5) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-746433503")) {
            return ((Float) ipChange.ipc$dispatch("-746433503", new Object[]{this, Float.valueOf(f2), Float.valueOf(f3), Float.valueOf(f4), Float.valueOf(f5)})).floatValue();
        }
        float f6 = f4 - f2;
        float f7 = f5 - f3;
        return (float) Math.sqrt((f6 * f6) + (f7 * f7));
    }

    private void testDrawSvgLocation(Canvas canvas) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1042080628")) {
            ipChange.ipc$dispatch("1042080628", new Object[]{this, canvas});
            return;
        }
        Rect rect = this.mBackgroundRect;
        c cVar = this.drawSeat;
        float f2 = cVar.c;
        float f3 = cVar.d;
        rect.set((int) f2, (int) f3, (int) (f2 + cVar.a), (int) (f3 + cVar.b));
        canvas.drawRect(this.mBackgroundRect, this.mPaintJust4Test);
        if (!cb2.d(this.mLocationPics4Test)) {
            for (Picture picture : this.mLocationPics4Test) {
                canvas.drawPicture(picture, this.mBackgroundRect);
            }
        } else if (!cb2.d(this.mSvgRegionLocations)) {
            for (List<PointLocation> list : this.mSvgRegionLocations) {
                Path path = new Path();
                int size = list.size();
                float f4 = 0.0f;
                String str = null;
                float f5 = 0.0f;
                int i = 0;
                while (i < size) {
                    PointLocation pointLocation = list.get(i);
                    String str2 = pointLocation.id;
                    float f6 = pointLocation.x;
                    float f7 = this.mSvgScale;
                    float f8 = f6 * f7;
                    float f9 = pointLocation.y * f7;
                    if (i == 0) {
                        path.moveTo(f8, f9);
                        f5 = f9;
                        f4 = f8;
                    } else {
                        path.lineTo(f8, f9);
                    }
                    i++;
                    str = str2;
                }
                path.lineTo(f4, f5);
                path.close();
                Picture picture2 = new Picture();
                Canvas beginRecording = picture2.beginRecording((int) this.regionImageWidth, (int) this.regionImageHeight);
                beginRecording.drawPath(path, this.mPaintJust4Test);
                if (!TextUtils.isEmpty(str)) {
                    beginRecording.drawTextOnPath(str, path, this.mPaintJust4Test.measureText(str), 16.0f, this.mTextPaintJust4Test);
                }
                this.mLocationPics4Test.add(picture2);
            }
        }
    }

    private void zoom(float f2, float f3, float f4) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-224831971")) {
            ipChange.ipc$dispatch("-224831971", new Object[]{this, Float.valueOf(f2), Float.valueOf(f3), Float.valueOf(f4)});
            return;
        }
        float f5 = (this.viewWidth / 2.0f) - f2;
        float f6 = (this.viewHeight / 2.0f) - f3;
        c cVar = this.drawSeat;
        float f7 = cVar.c;
        float f8 = f4 - 1.0f;
        float f9 = ((f7 - f2) * f8) + f7 + f5;
        float f10 = cVar.d;
        float f11 = cVar.a;
        zoomAnimate(new f(this, f7, f10, f11), new f(this, f9, ((f10 - f3) * f8) + f10 + f6, f4 * f11), new a());
    }

    private void zoomAnimate(f fVar, f fVar2) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1399996646")) {
            ipChange.ipc$dispatch("-1399996646", new Object[]{this, fVar, fVar2});
        } else {
            zoomAnimate(fVar, fVar2, null);
        }
    }

    public float computeScaleZoom2Region(RectF rectF) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "72116117")) {
            return ((Float) ipChange.ipc$dispatch("72116117", new Object[]{this, rectF})).floatValue();
        }
        boolean z = rectF.width() * ((float) this.viewHeight) > rectF.height() * ((float) this.viewWidth);
        return Math.min(Math.max((z ? this.viewWidth : this.viewHeight) / (z ? rectF.width() : rectF.height()), this.mScale50), this.mScale09);
    }

    void drawOverview(Canvas canvas) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "727875852")) {
            ipChange.ipc$dispatch("727875852", new Object[]{this, canvas});
            return;
        }
        c cVar = this.drawSeat;
        float f2 = cVar.a;
        float f3 = f2 / (this.rectW - (this.overviewSpacing * 2.0f));
        float f4 = this.redBorderLeftBoundary;
        float f5 = cVar.c;
        float f6 = f4 - (f5 / f3);
        if (f6 >= f4) {
            f4 = f6;
        }
        int i = (int) (f5 + f2);
        int i2 = this.viewWidth;
        float f7 = this.redBorderRightBoundary - ((i > i2 ? i - i2 : 0) / f3);
        float f8 = this.redBorderTopBoundary;
        float f9 = cVar.d;
        float f10 = f8 - (f9 / f3);
        if (f10 >= f8) {
            f8 = f10;
        }
        int i3 = (int) (f9 + cVar.b);
        float height = this.redBorderBottomBoundary - ((i3 > getHeight() ? i3 - getHeight() : 0) / f3);
        if (f4 >= f7) {
            f4 = f7 - this.redBorderPaint.getStrokeWidth();
        }
        canvas.drawRect(f4, height <= f8 ? height - this.redBorderPaint.getStrokeWidth() : f8, f7, height, this.redBorderPaint);
    }

    public List<String> getCurrentRegionIdsInScreen() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "519080741")) {
            return (List) ipChange.ipc$dispatch("519080741", new Object[]{this});
        }
        ArrayList arrayList = new ArrayList();
        ArrayMap<String, String> arrayMap = this.mRegionVid2IdMap;
        if (arrayMap == null || arrayMap.isEmpty() || this.mSvgRegionLocations == null) {
            return arrayList;
        }
        float f2 = ((this.drawSeat.a * 1.0f) / this.regionImageWidth) * this.mSvgScale;
        for (int i = 0; i < this.mSvgRegionLocations.size(); i++) {
            List<PointLocation> list = this.mSvgRegionLocations.get(i);
            if (list != null && !list.isEmpty() && !TextUtils.isEmpty(list.get(0).id) && list.size() >= 2) {
                RectF rectF = list.get(0).rectF;
                c cVar = this.drawSeat;
                float f3 = cVar.c;
                float f4 = (rectF.left * f2) + f3;
                float f5 = cVar.d;
                float f6 = (rectF.top * f2) + f5;
                float f7 = (rectF.right * f2) + f3;
                float f8 = (rectF.bottom * f2) + f5;
                int i2 = this.viewHeight + this.seatViewPaddingBottom;
                if ((f4 >= 0.0f || f7 >= 0.0f) && (f6 >= 0.0f || f8 >= 0.0f)) {
                    int i3 = this.viewWidth;
                    if (f4 <= i3 || f7 <= i3) {
                        float f9 = i2;
                        if (f6 <= f9 || f8 <= f9) {
                            arrayList.add(this.mRegionVid2IdMap.get(list.get(0).id));
                        }
                    }
                }
            }
        }
        return arrayList;
    }

    public RegionBound getPointRegionBound(MotionEvent motionEvent) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-236197648")) {
            return (RegionBound) ipChange.ipc$dispatch("-236197648", new Object[]{this, motionEvent});
        }
        float x = motionEvent.getX();
        float y = motionEvent.getY();
        c cVar = this.drawSeat;
        float f2 = x - cVar.c;
        float f3 = cVar.e;
        float f4 = this.mSvgScale;
        float f5 = f2 / (f3 * f4);
        float f6 = (y - cVar.d) / (f3 * f4);
        if (cb2.d(this.mRegionBounds)) {
            return null;
        }
        for (int i = 0; i < this.mRegionBounds.size(); i++) {
            RegionBound regionBound = this.mRegionBounds.get(i);
            if (regionBound.isPoint(f5, f6)) {
                return regionBound;
            }
        }
        return null;
    }

    public void initView(Context context) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-2120833049")) {
            ipChange.ipc$dispatch("-2120833049", new Object[]{this, context});
            return;
        }
        hs hsVar = new hs();
        this.isSmallVenueStyle = hsVar.f(this.mRegionData);
        this.seatPaint = new Paint();
        Paint paint = new Paint(1);
        this.mPaint = paint;
        paint.setStyle(Paint.Style.FILL);
        this.overviewPaint = new Paint();
        this.overviewBackgroundColor = Color.parseColor("#99000000");
        Paint paint2 = new Paint();
        this.redBorderPaint = paint2;
        paint2.setAntiAlias(true);
        this.redBorderPaint.setColor(Color.parseColor("#fa1155"));
        this.redBorderPaint.setStyle(Paint.Style.STROKE);
        this.redBorderPaint.setStrokeWidth(m62.a(this.mContext, 2.0f));
        this.mBackgroundRect = new Rect();
        this.mSeatRect = new RectF();
        this.mOverviewRect = new RectF();
        this.maxOverViewRectWidth = (int) (DisplayMetrics.getwidthPixels(m62.b(this.mContext)) * 0.4f);
        this.overviewSpacing = m62.a(this.mContext, 10.0f);
        this.isDrawOverview = false;
        Paint paint3 = new Paint();
        this.packageSeatBorderPaint = paint3;
        paint3.setStyle(Paint.Style.STROKE);
        this.packageSeatBorderPaint.setAntiAlias(true);
        this.packageSeatBorderPaint.setStrokeWidth(1.0f);
        this.packageSeatBorderPaint.setColor(Color.parseColor("#999999"));
        this.packageSeatBorderPaint.setPathEffect(new DashPathEffect(new float[]{6.0f, 4.0f}, 0.0f));
        this.unavailableSeatColor = Color.parseColor("#e9e9e9");
        this.mInScreenSeatData = new ArrayMap<>();
        this.mClickScaleOffset = m62.a(this.mContext, 25.0f);
        bb c2 = hsVar.c(this.mRegionData);
        if (c2 != null) {
            this.mRegionVid2IdMap = c2.c(this.mRegionData);
        }
        ViewConfiguration viewConfiguration = ViewConfiguration.get(this.mContext);
        int scaledTouchSlop = viewConfiguration.getScaledTouchSlop();
        this.mTouchSlop = scaledTouchSlop;
        this.mTouchSlopSquare = scaledTouchSlop * scaledTouchSlop;
        this.mMinimumFlingVelocity = viewConfiguration.getScaledMinimumFlingVelocity();
        this.mMaximumFlingVelocity = viewConfiguration.getScaledMaximumFlingVelocity();
        this.mOverViewOffset = ScreenUtil.dip2px(this.mContext, 9.0f);
        Paint paint4 = new Paint(1);
        this.mPaintJust4Test = paint4;
        paint4.setColor(-16776961);
        this.mPaintJust4Test.setStrokeWidth(4.0f);
        this.mPaintJust4Test.setStyle(Paint.Style.STROKE);
        TextPaint textPaint = new TextPaint(1);
        this.mTextPaintJust4Test = textPaint;
        textPaint.setTextAlign(Paint.Align.CENTER);
        this.mTextPaintJust4Test.setTextSize(16.0f);
        this.mTextPaintJust4Test.setColor(-16776961);
        this.seatViewPaddingBottom = m62.a(context, 48.0f);
    }

    public void isShowOverView(boolean z) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "433419614")) {
            ipChange.ipc$dispatch("433419614", new Object[]{this, Boolean.valueOf(z)});
        } else {
            this.isShowOverview = z;
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:110:0x02e4 A[Catch: Exception -> 0x04a2, TryCatch #1 {Exception -> 0x04a2, blocks: (B:9:0x0024, B:11:0x002e, B:13:0x0090, B:15:0x0096, B:17:0x009a, B:19:0x00a5, B:21:0x00b1, B:23:0x00b7, B:25:0x00d0, B:27:0x00d8, B:32:0x00e8, B:34:0x00f5, B:33:0x00f0, B:28:0x00dc, B:30:0x00e2, B:22:0x00b4, B:18:0x00a1, B:35:0x016f, B:37:0x0173, B:39:0x0177, B:40:0x017d, B:42:0x0196, B:44:0x019a, B:45:0x01a4, B:47:0x01ae, B:48:0x01b8, B:50:0x01bc, B:52:0x01c0, B:53:0x01c6, B:54:0x01cd, B:56:0x01d7, B:59:0x01dc, B:151:0x041f, B:153:0x0423, B:154:0x0426, B:156:0x042a, B:158:0x042e, B:160:0x0432, B:162:0x044a, B:163:0x0454, B:165:0x0458, B:167:0x045c, B:171:0x0469, B:173:0x046d, B:176:0x0474, B:175:0x0471, B:177:0x0476, B:179:0x047d, B:180:0x0480, B:61:0x01e2, B:63:0x01e8, B:65:0x01f5, B:67:0x0206, B:69:0x020a, B:71:0x021d, B:77:0x0227, B:80:0x023d, B:82:0x0247, B:84:0x0255, B:85:0x0259, B:87:0x025f, B:88:0x026c, B:90:0x0273, B:92:0x029d, B:108:0x02cf, B:110:0x02e4, B:112:0x02ea, B:96:0x02a5, B:99:0x02af, B:102:0x02b6, B:105:0x02c5, B:64:0x01ef), top: B:190:0x0024 }] */
    /* JADX WARN: Removed duplicated region for block: B:115:0x02f8  */
    /* JADX WARN: Removed duplicated region for block: B:128:0x036d A[Catch: Exception -> 0x0407, TryCatch #0 {Exception -> 0x0407, blocks: (B:113:0x02ef, B:119:0x02ff, B:121:0x0305, B:140:0x03ce, B:142:0x03d2, B:144:0x03d6, B:148:0x03ed, B:147:0x03ec, B:122:0x031a, B:123:0x032f, B:125:0x0335, B:126:0x0349, B:127:0x035c, B:128:0x036d, B:130:0x0371, B:132:0x0379, B:134:0x0390, B:139:0x03cc, B:133:0x0385, B:135:0x0399, B:137:0x03a3, B:138:0x03b8), top: B:188:0x02ef }] */
    /* JADX WARN: Removed duplicated region for block: B:146:0x03e9  */
    /* JADX WARN: Removed duplicated region for block: B:147:0x03ec A[Catch: Exception -> 0x0407, TryCatch #0 {Exception -> 0x0407, blocks: (B:113:0x02ef, B:119:0x02ff, B:121:0x0305, B:140:0x03ce, B:142:0x03d2, B:144:0x03d6, B:148:0x03ed, B:147:0x03ec, B:122:0x031a, B:123:0x032f, B:125:0x0335, B:126:0x0349, B:127:0x035c, B:128:0x036d, B:130:0x0371, B:132:0x0379, B:134:0x0390, B:139:0x03cc, B:133:0x0385, B:135:0x0399, B:137:0x03a3, B:138:0x03b8), top: B:188:0x02ef }] */
    /* JADX WARN: Removed duplicated region for block: B:153:0x0423 A[Catch: Exception -> 0x04a2, TryCatch #1 {Exception -> 0x04a2, blocks: (B:9:0x0024, B:11:0x002e, B:13:0x0090, B:15:0x0096, B:17:0x009a, B:19:0x00a5, B:21:0x00b1, B:23:0x00b7, B:25:0x00d0, B:27:0x00d8, B:32:0x00e8, B:34:0x00f5, B:33:0x00f0, B:28:0x00dc, B:30:0x00e2, B:22:0x00b4, B:18:0x00a1, B:35:0x016f, B:37:0x0173, B:39:0x0177, B:40:0x017d, B:42:0x0196, B:44:0x019a, B:45:0x01a4, B:47:0x01ae, B:48:0x01b8, B:50:0x01bc, B:52:0x01c0, B:53:0x01c6, B:54:0x01cd, B:56:0x01d7, B:59:0x01dc, B:151:0x041f, B:153:0x0423, B:154:0x0426, B:156:0x042a, B:158:0x042e, B:160:0x0432, B:162:0x044a, B:163:0x0454, B:165:0x0458, B:167:0x045c, B:171:0x0469, B:173:0x046d, B:176:0x0474, B:175:0x0471, B:177:0x0476, B:179:0x047d, B:180:0x0480, B:61:0x01e2, B:63:0x01e8, B:65:0x01f5, B:67:0x0206, B:69:0x020a, B:71:0x021d, B:77:0x0227, B:80:0x023d, B:82:0x0247, B:84:0x0255, B:85:0x0259, B:87:0x025f, B:88:0x026c, B:90:0x0273, B:92:0x029d, B:108:0x02cf, B:110:0x02e4, B:112:0x02ea, B:96:0x02a5, B:99:0x02af, B:102:0x02b6, B:105:0x02c5, B:64:0x01ef), top: B:190:0x0024 }] */
    /* JADX WARN: Removed duplicated region for block: B:162:0x044a A[Catch: Exception -> 0x04a2, TryCatch #1 {Exception -> 0x04a2, blocks: (B:9:0x0024, B:11:0x002e, B:13:0x0090, B:15:0x0096, B:17:0x009a, B:19:0x00a5, B:21:0x00b1, B:23:0x00b7, B:25:0x00d0, B:27:0x00d8, B:32:0x00e8, B:34:0x00f5, B:33:0x00f0, B:28:0x00dc, B:30:0x00e2, B:22:0x00b4, B:18:0x00a1, B:35:0x016f, B:37:0x0173, B:39:0x0177, B:40:0x017d, B:42:0x0196, B:44:0x019a, B:45:0x01a4, B:47:0x01ae, B:48:0x01b8, B:50:0x01bc, B:52:0x01c0, B:53:0x01c6, B:54:0x01cd, B:56:0x01d7, B:59:0x01dc, B:151:0x041f, B:153:0x0423, B:154:0x0426, B:156:0x042a, B:158:0x042e, B:160:0x0432, B:162:0x044a, B:163:0x0454, B:165:0x0458, B:167:0x045c, B:171:0x0469, B:173:0x046d, B:176:0x0474, B:175:0x0471, B:177:0x0476, B:179:0x047d, B:180:0x0480, B:61:0x01e2, B:63:0x01e8, B:65:0x01f5, B:67:0x0206, B:69:0x020a, B:71:0x021d, B:77:0x0227, B:80:0x023d, B:82:0x0247, B:84:0x0255, B:85:0x0259, B:87:0x025f, B:88:0x026c, B:90:0x0273, B:92:0x029d, B:108:0x02cf, B:110:0x02e4, B:112:0x02ea, B:96:0x02a5, B:99:0x02af, B:102:0x02b6, B:105:0x02c5, B:64:0x01ef), top: B:190:0x0024 }] */
    /* JADX WARN: Removed duplicated region for block: B:169:0x0466  */
    /* JADX WARN: Removed duplicated region for block: B:170:0x0468  */
    /* JADX WARN: Removed duplicated region for block: B:179:0x047d A[Catch: Exception -> 0x04a2, TryCatch #1 {Exception -> 0x04a2, blocks: (B:9:0x0024, B:11:0x002e, B:13:0x0090, B:15:0x0096, B:17:0x009a, B:19:0x00a5, B:21:0x00b1, B:23:0x00b7, B:25:0x00d0, B:27:0x00d8, B:32:0x00e8, B:34:0x00f5, B:33:0x00f0, B:28:0x00dc, B:30:0x00e2, B:22:0x00b4, B:18:0x00a1, B:35:0x016f, B:37:0x0173, B:39:0x0177, B:40:0x017d, B:42:0x0196, B:44:0x019a, B:45:0x01a4, B:47:0x01ae, B:48:0x01b8, B:50:0x01bc, B:52:0x01c0, B:53:0x01c6, B:54:0x01cd, B:56:0x01d7, B:59:0x01dc, B:151:0x041f, B:153:0x0423, B:154:0x0426, B:156:0x042a, B:158:0x042e, B:160:0x0432, B:162:0x044a, B:163:0x0454, B:165:0x0458, B:167:0x045c, B:171:0x0469, B:173:0x046d, B:176:0x0474, B:175:0x0471, B:177:0x0476, B:179:0x047d, B:180:0x0480, B:61:0x01e2, B:63:0x01e8, B:65:0x01f5, B:67:0x0206, B:69:0x020a, B:71:0x021d, B:77:0x0227, B:80:0x023d, B:82:0x0247, B:84:0x0255, B:85:0x0259, B:87:0x025f, B:88:0x026c, B:90:0x0273, B:92:0x029d, B:108:0x02cf, B:110:0x02e4, B:112:0x02ea, B:96:0x02a5, B:99:0x02af, B:102:0x02b6, B:105:0x02c5, B:64:0x01ef), top: B:190:0x0024 }] */
    @Override // android.view.View
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    protected void onDraw(android.graphics.Canvas r29) {
        /*
            Method dump skipped, instructions count: 1268
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: cn.damai.seat.view.RegionSeatView.onDraw(android.graphics.Canvas):void");
    }

    @Override // android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        RectF a2;
        VelocityTracker velocityTracker;
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1107014283")) {
            return ((Boolean) ipChange.ipc$dispatch("-1107014283", new Object[]{this, motionEvent})).booleanValue();
        }
        if (this.mVelocityTracker == null) {
            this.mVelocityTracker = VelocityTracker.obtain();
        }
        this.mVelocityTracker.addMovement(motionEvent);
        int action = motionEvent.getAction();
        if (action == 0) {
            if (motionEvent.getPointerCount() == 1) {
                float x = motionEvent.getX();
                this.mLastFocusX = x;
                this.mDownX = x;
                float y = motionEvent.getY();
                this.mLastFocusY = y;
                this.mDownY = y;
                c cVar = this.drawSeat;
                this.mDLeft = cVar.c;
                this.mDTop = cVar.d;
                this.mDWidth = cVar.a;
            }
            this.mAlwaysInTapRegion = true;
            this.mHandler.removeCallbacks(this.hideOverviewRunnable);
        } else if (action == 1) {
            if (this.mAlwaysInTapRegion && !this.mScaling) {
                if (this.isSmallVenueStyle) {
                    if (needAutoScale()) {
                        autoScale(motionEvent);
                    }
                    click(motionEvent.getX(), motionEvent.getY());
                } else if (this.drawSeat.a < this.minRegionImageDrawSeatWidth && !cb2.d(this.mRegionBounds) && this.regions != null) {
                    RegionBound pointRegionBound = getPointRegionBound(motionEvent);
                    if (pointRegionBound != null && f92.y(this.regions, pointRegionBound.regionVid) && (a2 = h12.a(pointRegionBound.pointBounds)) != null) {
                        translate2SVGScaledRegionRectF(a2);
                        float computeScaleZoom2Region = computeScaleZoom2Region(a2);
                        translate2ViewRegionRectF(a2);
                        zoom(a2.centerX(), a2.centerY(), (this.regionImageWidth * computeScaleZoom2Region) / this.drawSeat.a);
                    }
                } else {
                    if (needAutoScale()) {
                        autoScale(motionEvent);
                    }
                    click(motionEvent.getX(), motionEvent.getY());
                }
            } else if (!this.mScaling) {
                float[] fArr = new float[2];
                computeOffset2AdjustBounds(fArr);
                if (Math.abs(fArr[0]) < this.mTouchSlop && Math.abs(fArr[1]) < this.mTouchSlop) {
                    VelocityTracker velocityTracker2 = this.mVelocityTracker;
                    int pointerId = motionEvent.getPointerId(0);
                    velocityTracker2.computeCurrentVelocity(1000, this.mMaximumFlingVelocity);
                    float yVelocity = velocityTracker2.getYVelocity(pointerId);
                    float xVelocity = velocityTracker2.getXVelocity(pointerId);
                    if (Math.abs(yVelocity) > this.mMinimumFlingVelocity || Math.abs(xVelocity) > this.mMinimumFlingVelocity) {
                        flingAnimate(xVelocity, yVelocity);
                    }
                } else {
                    c cVar2 = this.drawSeat;
                    f fVar = new f(this, cVar2.c, cVar2.d, cVar2.a);
                    c cVar3 = this.drawSeat;
                    zoomAnimate(fVar, new f(this, cVar3.c + fArr[0], cVar3.d + fArr[1], cVar3.a));
                }
                this.mHandler.postDelayed(this.hideOverviewRunnable, 500L);
            }
            if (this.mScaling) {
                this.mHandler.postDelayed(this.hideOverviewRunnable, 500L);
            }
            VelocityTracker velocityTracker3 = this.mVelocityTracker;
            if (velocityTracker3 != null) {
                velocityTracker3.recycle();
                this.mVelocityTracker = null;
            }
            this.mScaling = false;
        } else if (action != 2) {
            if (action == 3 && (velocityTracker = this.mVelocityTracker) != null) {
                velocityTracker.recycle();
                this.mVelocityTracker = null;
            }
        } else if (motionEvent.getPointerCount() == 1 && !this.mScaling) {
            float x2 = motionEvent.getX();
            float y2 = motionEvent.getY();
            float f2 = x2 - this.mDownX;
            float f3 = y2 - this.mDownY;
            float f4 = this.mLastFocusX - x2;
            float f5 = this.mLastFocusY - y2;
            if (!this.isDrawOverview) {
                this.isDrawOverview = Math.abs(f2) >= ((float) this.mTouchSlop) || Math.abs(f3) >= ((float) this.mTouchSlop);
            }
            if (this.mAlwaysInTapRegion) {
                if (((int) ((f2 * f2) + (f3 * f3))) > this.mTouchSlopSquare) {
                    scrollView(f2 + this.mDLeft, f3 + this.mDTop);
                    this.mLastFocusX = x2;
                    this.mLastFocusY = y2;
                    this.mAlwaysInTapRegion = false;
                }
            } else if (Math.abs(f4) >= 1.0f || Math.abs(f5) >= 1.0f) {
                scrollView(f2 + this.mDLeft, f3 + this.mDTop);
                this.mLastFocusX = x2;
                this.mLastFocusY = y2;
            }
        } else if (motionEvent.getPointerCount() == 2) {
            this.isDrawOverview = true;
            if (!this.mScaling) {
                this.mDownX = motionEvent.getX(0);
                this.mDownY = motionEvent.getY(0);
                this.mScaleDistance = spacing(this.mDownX, this.mDownY, motionEvent.getX(1), motionEvent.getY(1));
                this.mScaling = true;
            }
            float x3 = motionEvent.getX();
            float y3 = motionEvent.getY();
            float x4 = motionEvent.getX(1);
            float y4 = motionEvent.getY(1);
            float spacing = spacing(x3, y3, x4, y4);
            float f6 = (x3 + x4) * 0.5f;
            float f7 = (y3 + y4) * 0.5f;
            c cVar4 = this.drawSeat;
            float f8 = cVar4.c;
            float f9 = cVar4.d;
            float f10 = cVar4.a;
            float f11 = cVar4.b;
            float f12 = this.mDWidth * (spacing / this.mScaleDistance);
            if (f12 > this.maxRegionImageWidth || f12 <= this.minRegionImageWidth) {
                return true;
            }
            cVar4.a(f12);
            c cVar5 = this.drawSeat;
            cVar5.c = f6 - (cVar5.a * ((f6 - f8) / f10));
            cVar5.d = f7 - (cVar5.b * ((f7 - f9) / f11));
            invalidate();
        }
        return true;
    }

    public void setListener(OnSeatViewListener onSeatViewListener) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-2095988411")) {
            ipChange.ipc$dispatch("-2095988411", new Object[]{this, onSeatViewListener});
        } else {
            this.mListener = onSeatViewListener;
        }
    }

    public void setRegionBounds(List<RegionBound> list) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "571729818")) {
            ipChange.ipc$dispatch("571729818", new Object[]{this, list});
        } else {
            this.mRegionBounds = list;
        }
    }

    public void setRegionInitialPictureData(PictureDrawable pictureDrawable) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "261085880")) {
            ipChange.ipc$dispatch("261085880", new Object[]{this, pictureDrawable});
        } else {
            this.regionPictureDataWithoutColor = pictureDrawable;
        }
    }

    public void setRegionPictureData(Picture picture) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1052390905")) {
            ipChange.ipc$dispatch("1052390905", new Object[]{this, picture});
        } else {
            this.mColorRegionPicture = picture;
        }
    }

    public void setRegions(List<Region> list) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1679562934")) {
            ipChange.ipc$dispatch("-1679562934", new Object[]{this, list});
        } else {
            this.regions = list;
        }
    }

    public void setSVGVenueLayerPicture(@Nullable Picture picture) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1453443121")) {
            ipChange.ipc$dispatch("-1453443121", new Object[]{this, picture});
        } else {
            this.mSVGVenueLayerPicture = picture;
        }
    }

    public void setSeatData(SeatBox seatBox) {
        Map<String, List<Path>> map;
        PictureDrawable pictureDrawable;
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1392984097")) {
            ipChange.ipc$dispatch("1392984097", new Object[]{this, seatBox});
            return;
        }
        this.mSeatBox = seatBox;
        this.isSeatStateChanged = true;
        this.mPackageSeatWrapLineMap.clear();
        SeatBox seatBox2 = this.mSeatBox;
        if (seatBox2 == null || (map = seatBox2.packagePathMap) == null || map.size() == 0 || (pictureDrawable = this.regionPictureDataWithoutColor) == null) {
            return;
        }
        int height = (int) (pictureDrawable.getPicture().getHeight() * this.mSvgScale);
        int width = (int) (this.regionPictureDataWithoutColor.getPicture().getWidth() * this.mSvgScale);
        for (String str : map.keySet()) {
            for (Path path : map.get(str)) {
                Picture picture = new Picture();
                picture.beginRecording(width, height).drawPath(path, this.packageSeatBorderPaint);
                if (this.mPackageSeatWrapLineMap.get(str) == null) {
                    this.mPackageSeatWrapLineMap.put(str, new ArrayList());
                }
                this.mPackageSeatWrapLineMap.get(str).add(picture);
            }
        }
    }

    public void setSeatRequestChecker(RegionSeatRequestChecker regionSeatRequestChecker) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "216416079")) {
            ipChange.ipc$dispatch("216416079", new Object[]{this, regionSeatRequestChecker});
        } else {
            this.mSeatRequestChecker = regionSeatRequestChecker;
        }
    }

    public void setSelectPrice(PriceLevel priceLevel) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1717186998")) {
            ipChange.ipc$dispatch("1717186998", new Object[]{this, priceLevel});
        } else {
            this.mSelectPrice = priceLevel;
        }
    }

    public void setSvgRegionLocations(List<List<PointLocation>> list) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1406446147")) {
            ipChange.ipc$dispatch("-1406446147", new Object[]{this, list});
        } else {
            this.mSvgRegionLocations = list;
        }
    }

    public void setSvgScale(float f2) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "886004148")) {
            ipChange.ipc$dispatch("886004148", new Object[]{this, Float.valueOf(f2)});
            return;
        }
        if (f2 <= 0.0f) {
            f2 = 1.0f;
        }
        this.mSvgScale = f2;
    }

    public void translate2SVGScaledRegionRectF(RectF rectF) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-906873741")) {
            ipChange.ipc$dispatch("-906873741", new Object[]{this, rectF});
            return;
        }
        float f2 = rectF.left;
        float f3 = this.mSvgScale;
        rectF.left = f2 * f3;
        rectF.right *= f3;
        rectF.top *= f3;
        rectF.bottom *= f3;
    }

    public void translate2ViewRegionRectF(RectF rectF) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "955220704")) {
            ipChange.ipc$dispatch("955220704", new Object[]{this, rectF});
            return;
        }
        float f2 = rectF.left;
        c cVar = this.drawSeat;
        float f3 = cVar.e;
        float f4 = cVar.c;
        rectF.left = (f2 * f3) + f4;
        rectF.right = (rectF.right * f3) + f4;
        float f5 = cVar.d;
        rectF.top = (rectF.top * f3) + f5;
        rectF.bottom = (rectF.bottom * f3) + f5;
    }

    public boolean zoom2AdaptSeatPrice() {
        c cVar;
        ArrayMap<String, List<SeatNew>> allRegion;
        HashSet<Long> hashSet;
        float f2;
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "855089111")) {
            return ((Boolean) ipChange.ipc$dispatch("855089111", new Object[]{this})).booleanValue();
        }
        if (!this.isSmallVenueStyle || (cVar = this.drawSeat) == null || cVar.a <= 0.0f || this.viewWidth <= 0 || this.viewHeight <= 0 || this.mSelectPrice == null || (allRegion = getAllRegion()) == null) {
            return false;
        }
        float f3 = Float.MIN_VALUE;
        float f4 = Float.MIN_VALUE;
        float f5 = Float.MAX_VALUE;
        float f6 = Float.MAX_VALUE;
        boolean z = false;
        int i = 0;
        for (int i2 = 0; i2 < allRegion.size(); i2++) {
            List<SeatNew> valueAt = allRegion.valueAt(i2);
            if (!cb2.d(valueAt)) {
                if (this.mSelectPrice.isFreeCombineTiaoPiao()) {
                    hashSet = this.mSelectPrice.getSubPriceIds();
                } else {
                    hashSet = new HashSet<>();
                    hashSet.add(Long.valueOf(this.mSelectPrice.getPriceId()));
                }
                if (hashSet == null) {
                    hashSet = new HashSet<>();
                }
                for (SeatNew seatNew : valueAt) {
                    float f7 = f4;
                    long j = seatNew.isPackaged ? seatNew.packagedPriceIndexId : seatNew.priceLevel;
                    if (seatNew.state == n92.SEAT_STATUS_AVAILABLE.shortValue() && hashSet.contains(Long.valueOf(j))) {
                        i++;
                        c cVar2 = this.drawSeat;
                        float f8 = cVar2.e;
                        float f9 = (seatNew.x * f8) + cVar2.c;
                        float f10 = (seatNew.y * f8) + cVar2.d;
                        if (z) {
                            float min = Math.min(f9, f5);
                            float max = Math.max(f9, f3);
                            float min2 = Math.min(f10, f6);
                            f3 = max;
                            f9 = min;
                            f2 = Math.max(f10, f7);
                            f10 = min2;
                        } else {
                            f3 = f9;
                            f2 = f10;
                        }
                        f5 = f9;
                        f6 = f10;
                        z = true;
                        f4 = f2;
                    } else {
                        f4 = f7;
                    }
                    if (i > 10) {
                        return false;
                    }
                }
            }
        }
        if (!z || i > 10) {
            return false;
        }
        c cVar3 = this.drawSeat;
        int i3 = cVar3.g;
        float f11 = (f3 - f5) + i3;
        float f12 = (f4 - f6) + i3;
        int i4 = this.viewWidth;
        float f13 = i4 / 2.0f;
        int i5 = this.viewHeight;
        float f14 = i5 / 2.0f;
        float f15 = f14 - ((f6 + f4) / 2.0f);
        float f16 = cVar3.c + (f13 - ((f3 + f5) / 2.0f));
        float f17 = cVar3.d + f15;
        float f18 = 1.0f;
        if (f11 > 0.0f && f12 > 0.0f) {
            f18 = f11 / f12 < ((float) i4) / ((float) i5) ? i5 / f12 : i4 / f11;
            if (f11 < i4 && f12 < i5) {
                f18 = Math.min(f18, this.maxRegionImageWidth / cVar3.a);
            }
        }
        float f19 = f14 - ((f14 - f17) * f18);
        c cVar4 = this.drawSeat;
        float f20 = cVar4.a;
        f fVar = new f(this, cVar4.c, cVar4.d, f20);
        f fVar2 = new f(this, f13 - ((f13 - f16) * f18), f19, f18 * f20);
        this.isDrawOverview = true;
        zoomAnimate(fVar, fVar2, new b());
        return true;
    }

    public void zoom2FullViewMode() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1389265758")) {
            ipChange.ipc$dispatch("1389265758", new Object[]{this});
            return;
        }
        c cVar = this.drawSeat;
        if (cVar != null) {
            float f2 = cVar.a;
            if (f2 <= 0.0f || this.regionImageWidth <= 0.0f || this.viewWidth <= 0 || this.viewHeight <= 0) {
                return;
            }
            if (this.isSmallVenueStyle) {
                f fVar = new f(this, cVar.c, cVar.d, f2);
                float f3 = this.minRegionImageWidth;
                float f4 = this.viewHeight;
                this.isDrawOverview = false;
                zoomAnimate(fVar, new f(this, (this.viewWidth - f3) / 2.0f, (f4 - ((this.regionImageHeight / this.regionImageWidth) * f3)) / 2.0f, f3));
                return;
            }
            f fVar2 = new f(this, cVar.c, cVar.d, f2);
            float f5 = this.bigVenueInitRegionImageWidth;
            f fVar3 = new f(this, (this.viewWidth - f5) / 2.0f, (this.viewHeight - ((this.regionImageHeight / this.regionImageWidth) * f5)) / 2.0f, f5);
            this.isDrawOverview = false;
            zoomAnimate(fVar2, fVar3);
        }
    }

    public void zoomWhenSeatPriceChanged(@Nullable PriceLevel priceLevel) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1328088708")) {
            ipChange.ipc$dispatch("1328088708", new Object[]{this, priceLevel});
            return;
        }
        this.mSelectPrice = priceLevel;
        if (priceLevel == null) {
            invalidate();
        } else if (!this.isSmallVenueStyle) {
            zoom2FullViewMode();
        } else if (zoom2AdaptSeatPrice()) {
        } else {
            zoom2FullViewMode();
        }
    }

    private void zoomAnimate(f fVar, f fVar2, Animator.AnimatorListener animatorListener) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1462066138")) {
            ipChange.ipc$dispatch("1462066138", new Object[]{this, fVar, fVar2, animatorListener});
            return;
        }
        ValueAnimator ofObject = ValueAnimator.ofObject(new e(), fVar, fVar2);
        ofObject.setInterpolator(new DecelerateInterpolator());
        ofObject.addUpdateListener(new g());
        if (animatorListener != null) {
            ofObject.addListener(animatorListener);
        }
        ofObject.setDuration(300L);
        ofObject.start();
    }
}
