package cn.damai.uikit.view.photoview;

import android.content.Context;
import android.graphics.Matrix;
import android.graphics.RectF;
import android.graphics.drawable.Drawable;
import android.view.GestureDetector;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewParent;
import android.view.animation.AccelerateDecelerateInterpolator;
import android.view.animation.Interpolator;
import android.widget.ImageView;
import android.widget.OverScroller;
import androidx.core.view.MotionEventCompat;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import tb.xl;

/* compiled from: Taobao */
/* loaded from: classes8.dex */
public class PhotoViewAttacher implements View.OnLayoutChangeListener, View.OnTouchListener {
    private static transient /* synthetic */ IpChange $ipChange = null;
    private static float E = 3.0f;
    private static float F = 1.75f;
    private static float G = 1.0f;
    private static int H = 200;
    private static int I = 1;
    private float A;
    private ImageView h;
    private GestureDetector i;
    private cn.damai.uikit.view.photoview.a j;
    private OnMatrixChangedListener p;
    private OnPhotoTapListener q;
    private OnOutsidePhotoTapListener r;
    private OnViewTapListener s;
    private View.OnClickListener t;
    private View.OnLongClickListener u;
    private OnScaleChangedListener v;
    private OnSingleFlingListener w;
    private OnViewDragListener x;
    private FlingRunnable y;
    private Interpolator a = new AccelerateDecelerateInterpolator();
    private int b = H;
    private float c = G;
    private float d = F;
    private float e = E;
    private boolean f = true;
    private boolean g = false;
    private final Matrix k = new Matrix();
    private final Matrix l = new Matrix();
    private final Matrix m = new Matrix();
    private final RectF n = new RectF();
    private final float[] o = new float[9];
    private int z = 2;
    private boolean B = true;
    private ImageView.ScaleType C = ImageView.ScaleType.FIT_CENTER;
    private OnGestureListener D = new a();

    /* compiled from: Taobao */
    /* loaded from: classes8.dex */
    public class AnimatedZoomRunnable implements Runnable {
        private static transient /* synthetic */ IpChange $ipChange;
        private final float mFocalX;
        private final float mFocalY;
        private final long mStartTime = System.currentTimeMillis();
        private final float mZoomEnd;
        private final float mZoomStart;

        public AnimatedZoomRunnable(float f, float f2, float f3, float f4) {
            this.mFocalX = f3;
            this.mFocalY = f4;
            this.mZoomStart = f;
            this.mZoomEnd = f2;
        }

        private float interpolate() {
            IpChange ipChange = $ipChange;
            return AndroidInstantRuntime.support(ipChange, "1961481788") ? ((Float) ipChange.ipc$dispatch("1961481788", new Object[]{this})).floatValue() : PhotoViewAttacher.this.a.getInterpolation(Math.min(1.0f, (((float) (System.currentTimeMillis() - this.mStartTime)) * 1.0f) / PhotoViewAttacher.this.b));
        }

        @Override // java.lang.Runnable
        public void run() {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "-274003838")) {
                ipChange.ipc$dispatch("-274003838", new Object[]{this});
                return;
            }
            float interpolate = interpolate();
            float f = this.mZoomStart;
            PhotoViewAttacher.this.D.onScale((f + ((this.mZoomEnd - f) * interpolate)) / PhotoViewAttacher.this.N(), this.mFocalX, this.mFocalY);
            if (interpolate < 1.0f) {
                xl.a(PhotoViewAttacher.this.h, this);
            }
        }
    }

    /* compiled from: Taobao */
    /* loaded from: classes8.dex */
    public class FlingRunnable implements Runnable {
        private static transient /* synthetic */ IpChange $ipChange;
        private int mCurrentX;
        private int mCurrentY;
        private final OverScroller mScroller;

        public FlingRunnable(Context context) {
            this.mScroller = new OverScroller(context);
        }

        public void cancelFling() {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "-1109970297")) {
                ipChange.ipc$dispatch("-1109970297", new Object[]{this});
            } else {
                this.mScroller.forceFinished(true);
            }
        }

        public void fling(int i, int i2, int i3, int i4) {
            int i5;
            int i6;
            int i7;
            int i8;
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "-629394643")) {
                ipChange.ipc$dispatch("-629394643", new Object[]{this, Integer.valueOf(i), Integer.valueOf(i2), Integer.valueOf(i3), Integer.valueOf(i4)});
                return;
            }
            RectF E = PhotoViewAttacher.this.E();
            if (E == null) {
                return;
            }
            int round = Math.round(-E.left);
            float f = i;
            if (f < E.width()) {
                i6 = Math.round(E.width() - f);
                i5 = 0;
            } else {
                i5 = round;
                i6 = i5;
            }
            int round2 = Math.round(-E.top);
            float f2 = i2;
            if (f2 < E.height()) {
                i8 = Math.round(E.height() - f2);
                i7 = 0;
            } else {
                i7 = round2;
                i8 = i7;
            }
            this.mCurrentX = round;
            this.mCurrentY = round2;
            if (round == i6 && round2 == i8) {
                return;
            }
            this.mScroller.fling(round, round2, i3, i4, i5, i6, i7, i8, 0, 0);
        }

        @Override // java.lang.Runnable
        public void run() {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "348446302")) {
                ipChange.ipc$dispatch("348446302", new Object[]{this});
            } else if (!this.mScroller.isFinished() && this.mScroller.computeScrollOffset()) {
                int currX = this.mScroller.getCurrX();
                int currY = this.mScroller.getCurrY();
                PhotoViewAttacher.this.m.postTranslate(this.mCurrentX - currX, this.mCurrentY - currY);
                PhotoViewAttacher.this.B();
                this.mCurrentX = currX;
                this.mCurrentY = currY;
                xl.a(PhotoViewAttacher.this.h, this);
            }
        }
    }

    /* compiled from: Taobao */
    /* loaded from: classes8.dex */
    public class a implements OnGestureListener {
        private static transient /* synthetic */ IpChange $ipChange;

        a() {
        }

        @Override // cn.damai.uikit.view.photoview.OnGestureListener
        public void onDrag(float f, float f2) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "1288248774")) {
                ipChange.ipc$dispatch("1288248774", new Object[]{this, Float.valueOf(f), Float.valueOf(f2)});
            } else if (PhotoViewAttacher.this.j.e()) {
            } else {
                if (PhotoViewAttacher.this.x != null) {
                    PhotoViewAttacher.this.x.onDrag(f, f2);
                }
                PhotoViewAttacher.this.m.postTranslate(f, f2);
                PhotoViewAttacher.this.B();
                ViewParent parent = PhotoViewAttacher.this.h.getParent();
                if (!PhotoViewAttacher.this.f || PhotoViewAttacher.this.j.e() || PhotoViewAttacher.this.g) {
                    if (parent != null) {
                        parent.requestDisallowInterceptTouchEvent(true);
                    }
                } else if ((PhotoViewAttacher.this.z == 2 || ((PhotoViewAttacher.this.z == 0 && f >= 1.0f) || (PhotoViewAttacher.this.z == 1 && f <= -1.0f))) && parent != null) {
                    parent.requestDisallowInterceptTouchEvent(false);
                }
            }
        }

        @Override // cn.damai.uikit.view.photoview.OnGestureListener
        public void onFling(float f, float f2, float f3, float f4) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "1095956916")) {
                ipChange.ipc$dispatch("1095956916", new Object[]{this, Float.valueOf(f), Float.valueOf(f2), Float.valueOf(f3), Float.valueOf(f4)});
                return;
            }
            PhotoViewAttacher photoViewAttacher = PhotoViewAttacher.this;
            photoViewAttacher.y = new FlingRunnable(photoViewAttacher.h.getContext());
            FlingRunnable flingRunnable = PhotoViewAttacher.this.y;
            PhotoViewAttacher photoViewAttacher2 = PhotoViewAttacher.this;
            int J = photoViewAttacher2.J(photoViewAttacher2.h);
            PhotoViewAttacher photoViewAttacher3 = PhotoViewAttacher.this;
            flingRunnable.fling(J, photoViewAttacher3.I(photoViewAttacher3.h), (int) f3, (int) f4);
            PhotoViewAttacher.this.h.post(PhotoViewAttacher.this.y);
        }

        @Override // cn.damai.uikit.view.photoview.OnGestureListener
        public void onScale(float f, float f2, float f3) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "388968698")) {
                ipChange.ipc$dispatch("388968698", new Object[]{this, Float.valueOf(f), Float.valueOf(f2), Float.valueOf(f3)});
            } else if (PhotoViewAttacher.this.N() < PhotoViewAttacher.this.e || f < 1.0f) {
                if (PhotoViewAttacher.this.N() > PhotoViewAttacher.this.c || f > 1.0f) {
                    if (PhotoViewAttacher.this.v != null) {
                        PhotoViewAttacher.this.v.onScaleChange(f, f2, f3);
                    }
                    PhotoViewAttacher.this.m.postScale(f, f, f2, f3);
                    PhotoViewAttacher.this.B();
                }
            }
        }
    }

    /* compiled from: Taobao */
    /* loaded from: classes8.dex */
    public class b extends GestureDetector.SimpleOnGestureListener {
        private static transient /* synthetic */ IpChange $ipChange;

        b() {
        }

        @Override // android.view.GestureDetector.SimpleOnGestureListener, android.view.GestureDetector.OnGestureListener
        public boolean onFling(MotionEvent motionEvent, MotionEvent motionEvent2, float f, float f2) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "1472342657")) {
                return ((Boolean) ipChange.ipc$dispatch("1472342657", new Object[]{this, motionEvent, motionEvent2, Float.valueOf(f), Float.valueOf(f2)})).booleanValue();
            }
            if (PhotoViewAttacher.this.w == null || PhotoViewAttacher.this.N() > PhotoViewAttacher.G || MotionEventCompat.getPointerCount(motionEvent) > PhotoViewAttacher.I || MotionEventCompat.getPointerCount(motionEvent2) > PhotoViewAttacher.I) {
                return false;
            }
            return PhotoViewAttacher.this.w.onFling(motionEvent, motionEvent2, f, f2);
        }

        @Override // android.view.GestureDetector.SimpleOnGestureListener, android.view.GestureDetector.OnGestureListener
        public void onLongPress(MotionEvent motionEvent) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "-1588759875")) {
                ipChange.ipc$dispatch("-1588759875", new Object[]{this, motionEvent});
            } else if (PhotoViewAttacher.this.u != null) {
                PhotoViewAttacher.this.u.onLongClick(PhotoViewAttacher.this.h);
            }
        }
    }

    /* compiled from: Taobao */
    /* loaded from: classes8.dex */
    public class c implements GestureDetector.OnDoubleTapListener {
        private static transient /* synthetic */ IpChange $ipChange;

        c() {
        }

        @Override // android.view.GestureDetector.OnDoubleTapListener
        public boolean onDoubleTap(MotionEvent motionEvent) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "1259361557")) {
                return ((Boolean) ipChange.ipc$dispatch("1259361557", new Object[]{this, motionEvent})).booleanValue();
            }
            try {
                float N = PhotoViewAttacher.this.N();
                float x = motionEvent.getX();
                float y = motionEvent.getY();
                if (N < PhotoViewAttacher.this.L()) {
                    PhotoViewAttacher photoViewAttacher = PhotoViewAttacher.this;
                    photoViewAttacher.n0(photoViewAttacher.L(), x, y, true);
                } else if (N >= PhotoViewAttacher.this.L() && N < PhotoViewAttacher.this.K()) {
                    PhotoViewAttacher photoViewAttacher2 = PhotoViewAttacher.this;
                    photoViewAttacher2.n0(photoViewAttacher2.K(), x, y, true);
                } else {
                    PhotoViewAttacher photoViewAttacher3 = PhotoViewAttacher.this;
                    photoViewAttacher3.n0(photoViewAttacher3.M(), x, y, true);
                }
            } catch (ArrayIndexOutOfBoundsException unused) {
            }
            return true;
        }

        @Override // android.view.GestureDetector.OnDoubleTapListener
        public boolean onDoubleTapEvent(MotionEvent motionEvent) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "441053613")) {
                return ((Boolean) ipChange.ipc$dispatch("441053613", new Object[]{this, motionEvent})).booleanValue();
            }
            return false;
        }

        @Override // android.view.GestureDetector.OnDoubleTapListener
        public boolean onSingleTapConfirmed(MotionEvent motionEvent) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "574543857")) {
                return ((Boolean) ipChange.ipc$dispatch("574543857", new Object[]{this, motionEvent})).booleanValue();
            }
            if (PhotoViewAttacher.this.t != null) {
                PhotoViewAttacher.this.t.onClick(PhotoViewAttacher.this.h);
            }
            RectF E = PhotoViewAttacher.this.E();
            float x = motionEvent.getX();
            float y = motionEvent.getY();
            if (PhotoViewAttacher.this.s != null) {
                PhotoViewAttacher.this.s.onViewTap(PhotoViewAttacher.this.h, x, y);
            }
            if (E != null) {
                if (!E.contains(x, y)) {
                    if (PhotoViewAttacher.this.r != null) {
                        PhotoViewAttacher.this.r.onOutsidePhotoTap(PhotoViewAttacher.this.h);
                    }
                } else {
                    float width = (x - E.left) / E.width();
                    float height = (y - E.top) / E.height();
                    if (PhotoViewAttacher.this.q != null) {
                        PhotoViewAttacher.this.q.onPhotoTap(PhotoViewAttacher.this.h, width, height);
                    }
                    return true;
                }
            }
            return false;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: Taobao */
    /* loaded from: classes8.dex */
    public static /* synthetic */ class d {
        static final /* synthetic */ int[] a;

        static {
            int[] iArr = new int[ImageView.ScaleType.values().length];
            a = iArr;
            try {
                iArr[ImageView.ScaleType.FIT_CENTER.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                a[ImageView.ScaleType.FIT_START.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                a[ImageView.ScaleType.FIT_END.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                a[ImageView.ScaleType.FIT_XY.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
        }
    }

    public PhotoViewAttacher(ImageView imageView) {
        this.h = imageView;
        imageView.setOnTouchListener(this);
        imageView.addOnLayoutChangeListener(this);
        if (imageView.isInEditMode()) {
            return;
        }
        this.A = 0.0f;
        this.j = new cn.damai.uikit.view.photoview.a(imageView.getContext(), this.D);
        GestureDetector gestureDetector = new GestureDetector(imageView.getContext(), new b());
        this.i = gestureDetector;
        gestureDetector.setOnDoubleTapListener(new c());
    }

    private void A() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1860138876")) {
            ipChange.ipc$dispatch("1860138876", new Object[]{this});
            return;
        }
        FlingRunnable flingRunnable = this.y;
        if (flingRunnable != null) {
            flingRunnable.cancelFling();
            this.y = null;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void B() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1475935818")) {
            ipChange.ipc$dispatch("1475935818", new Object[]{this});
        } else if (C()) {
            W(G());
        }
    }

    private boolean C() {
        float f;
        float f2;
        float f3;
        float f4;
        float f5;
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-888790204")) {
            return ((Boolean) ipChange.ipc$dispatch("-888790204", new Object[]{this})).booleanValue();
        }
        RectF F2 = F(G());
        if (F2 == null) {
            return false;
        }
        float height = F2.height();
        float width = F2.width();
        float I2 = I(this.h);
        float f6 = 0.0f;
        if (height <= I2) {
            int i = d.a[this.C.ordinal()];
            if (i != 2) {
                if (i != 3) {
                    I2 = (I2 - height) / 2.0f;
                    f2 = F2.top;
                } else {
                    I2 -= height;
                    f2 = F2.top;
                }
                f3 = I2 - f2;
            } else {
                f = F2.top;
                f3 = -f;
            }
        } else {
            f = F2.top;
            if (f <= 0.0f) {
                f2 = F2.bottom;
                if (f2 >= I2) {
                    f3 = 0.0f;
                }
                f3 = I2 - f2;
            }
            f3 = -f;
        }
        float J = J(this.h);
        if (width <= J) {
            int i2 = d.a[this.C.ordinal()];
            if (i2 != 2) {
                if (i2 != 3) {
                    f4 = (J - width) / 2.0f;
                    f5 = F2.left;
                } else {
                    f4 = J - width;
                    f5 = F2.left;
                }
                f6 = f4 - f5;
            } else {
                f6 = -F2.left;
            }
            this.z = 2;
        } else {
            float f7 = F2.left;
            if (f7 > 0.0f) {
                this.z = 0;
                f6 = -f7;
            } else {
                float f8 = F2.right;
                if (f8 < J) {
                    f6 = J - f8;
                    this.z = 1;
                } else {
                    this.z = -1;
                }
            }
        }
        this.m.postTranslate(f6, f3);
        return true;
    }

    private RectF F(Matrix matrix) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1160396167")) {
            return (RectF) ipChange.ipc$dispatch("1160396167", new Object[]{this, matrix});
        }
        Drawable drawable = this.h.getDrawable();
        if (drawable != null) {
            this.n.set(0.0f, 0.0f, drawable.getIntrinsicWidth(), drawable.getIntrinsicHeight());
            matrix.mapRect(this.n);
            return this.n;
        }
        return null;
    }

    private Matrix G() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "686550287")) {
            return (Matrix) ipChange.ipc$dispatch("686550287", new Object[]{this});
        }
        this.l.set(this.k);
        this.l.postConcat(this.m);
        return this.l;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public int I(ImageView imageView) {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "1303264680") ? ((Integer) ipChange.ipc$dispatch("1303264680", new Object[]{this, imageView})).intValue() : (imageView.getHeight() - imageView.getPaddingTop()) - imageView.getPaddingBottom();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public int J(ImageView imageView) {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "-334446929") ? ((Integer) ipChange.ipc$dispatch("-334446929", new Object[]{this, imageView})).intValue() : (imageView.getWidth() - imageView.getPaddingLeft()) - imageView.getPaddingRight();
    }

    private float Q(Matrix matrix, int i) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1820855032")) {
            return ((Float) ipChange.ipc$dispatch("-1820855032", new Object[]{this, matrix, Integer.valueOf(i)})).floatValue();
        }
        matrix.getValues(this.o);
        return this.o[i];
    }

    private void T() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1136743986")) {
            ipChange.ipc$dispatch("-1136743986", new Object[]{this});
            return;
        }
        this.m.reset();
        k0(this.A);
        W(G());
        C();
    }

    private void W(Matrix matrix) {
        RectF F2;
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1306405873")) {
            ipChange.ipc$dispatch("-1306405873", new Object[]{this, matrix});
            return;
        }
        this.h.setImageMatrix(matrix);
        if (this.p == null || (F2 = F(matrix)) == null) {
            return;
        }
        this.p.onMatrixChanged(F2);
    }

    private void u0(Drawable drawable) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-709283851")) {
            ipChange.ipc$dispatch("-709283851", new Object[]{this, drawable});
        } else if (drawable == null) {
        } else {
            float J = J(this.h);
            float I2 = I(this.h);
            int intrinsicWidth = drawable.getIntrinsicWidth();
            int intrinsicHeight = drawable.getIntrinsicHeight();
            this.k.reset();
            float f = intrinsicWidth;
            float f2 = J / f;
            float f3 = intrinsicHeight;
            float f4 = I2 / f3;
            ImageView.ScaleType scaleType = this.C;
            if (scaleType == ImageView.ScaleType.CENTER) {
                this.k.postTranslate((J - f) / 2.0f, (I2 - f3) / 2.0f);
            } else if (scaleType == ImageView.ScaleType.CENTER_CROP) {
                float max = Math.max(f2, f4);
                this.k.postScale(max, max);
                this.k.postTranslate((J - (f * max)) / 2.0f, (I2 - (f3 * max)) / 2.0f);
            } else if (scaleType == ImageView.ScaleType.CENTER_INSIDE) {
                float min = Math.min(1.0f, Math.min(f2, f4));
                this.k.postScale(min, min);
                this.k.postTranslate((J - (f * min)) / 2.0f, (I2 - (f3 * min)) / 2.0f);
            } else {
                RectF rectF = new RectF(0.0f, 0.0f, f, f3);
                RectF rectF2 = new RectF(0.0f, 0.0f, J, I2);
                if (((int) this.A) % 180 != 0) {
                    rectF = new RectF(0.0f, 0.0f, f3, f);
                }
                int i = d.a[this.C.ordinal()];
                if (i == 1) {
                    this.k.setRectToRect(rectF, rectF2, Matrix.ScaleToFit.CENTER);
                } else if (i == 2) {
                    this.k.setRectToRect(rectF, rectF2, Matrix.ScaleToFit.START);
                } else if (i == 3) {
                    this.k.setRectToRect(rectF, rectF2, Matrix.ScaleToFit.END);
                } else if (i == 4) {
                    this.k.setRectToRect(rectF, rectF2, Matrix.ScaleToFit.FILL);
                }
            }
            T();
        }
    }

    public void D(Matrix matrix) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-501991683")) {
            ipChange.ipc$dispatch("-501991683", new Object[]{this, matrix});
        } else {
            matrix.set(G());
        }
    }

    public RectF E() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "682760171")) {
            return (RectF) ipChange.ipc$dispatch("682760171", new Object[]{this});
        }
        C();
        return F(G());
    }

    public Matrix H() {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "-1880296558") ? (Matrix) ipChange.ipc$dispatch("-1880296558", new Object[]{this}) : this.l;
    }

    public float K() {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "-49097810") ? ((Float) ipChange.ipc$dispatch("-49097810", new Object[]{this})).floatValue() : this.e;
    }

    public float L() {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "-2078883203") ? ((Float) ipChange.ipc$dispatch("-2078883203", new Object[]{this})).floatValue() : this.d;
    }

    public float M() {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "-1159536740") ? ((Float) ipChange.ipc$dispatch("-1159536740", new Object[]{this})).floatValue() : this.c;
    }

    public float N() {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "100458920") ? ((Float) ipChange.ipc$dispatch("100458920", new Object[]{this})).floatValue() : (float) Math.sqrt(((float) Math.pow(Q(this.m, 0), 2.0d)) + ((float) Math.pow(Q(this.m, 3), 2.0d)));
    }

    public ImageView.ScaleType O() {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "981316114") ? (ImageView.ScaleType) ipChange.ipc$dispatch("981316114", new Object[]{this}) : this.C;
    }

    public void P(Matrix matrix) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "385525591")) {
            ipChange.ipc$dispatch("385525591", new Object[]{this, matrix});
        } else {
            matrix.set(this.m);
        }
    }

    @Deprecated
    public boolean R() {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "-1060689762") ? ((Boolean) ipChange.ipc$dispatch("-1060689762", new Object[]{this})).booleanValue() : this.B;
    }

    public boolean S() {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "-428885575") ? ((Boolean) ipChange.ipc$dispatch("-428885575", new Object[]{this})).booleanValue() : this.B;
    }

    public void U(boolean z) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1104863843")) {
            ipChange.ipc$dispatch("1104863843", new Object[]{this, Boolean.valueOf(z)});
        } else {
            this.f = z;
        }
    }

    public boolean V(Matrix matrix) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "86583157")) {
            return ((Boolean) ipChange.ipc$dispatch("86583157", new Object[]{this, matrix})).booleanValue();
        }
        if (matrix != null) {
            if (this.h.getDrawable() == null) {
                return false;
            }
            this.m.set(matrix);
            B();
            return true;
        }
        throw new IllegalArgumentException("Matrix cannot be null");
    }

    public void X(float f) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1229234382")) {
            ipChange.ipc$dispatch("1229234382", new Object[]{this, Float.valueOf(f)});
            return;
        }
        cn.damai.uikit.view.photoview.b.a(this.c, this.d, f);
        this.e = f;
    }

    public void Y(float f) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "899190855")) {
            ipChange.ipc$dispatch("899190855", new Object[]{this, Float.valueOf(f)});
            return;
        }
        cn.damai.uikit.view.photoview.b.a(this.c, f, this.e);
        this.d = f;
    }

    public void Z(float f) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1165365920")) {
            ipChange.ipc$dispatch("1165365920", new Object[]{this, Float.valueOf(f)});
            return;
        }
        cn.damai.uikit.view.photoview.b.a(f, this.d, this.e);
        this.c = f;
    }

    public void a0(View.OnClickListener onClickListener) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1766998680")) {
            ipChange.ipc$dispatch("-1766998680", new Object[]{this, onClickListener});
        } else {
            this.t = onClickListener;
        }
    }

    public void b0(GestureDetector.OnDoubleTapListener onDoubleTapListener) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1765422386")) {
            ipChange.ipc$dispatch("-1765422386", new Object[]{this, onDoubleTapListener});
        } else {
            this.i.setOnDoubleTapListener(onDoubleTapListener);
        }
    }

    public void c0(View.OnLongClickListener onLongClickListener) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1916449768")) {
            ipChange.ipc$dispatch("1916449768", new Object[]{this, onLongClickListener});
        } else {
            this.u = onLongClickListener;
        }
    }

    public void d0(OnMatrixChangedListener onMatrixChangedListener) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1591147141")) {
            ipChange.ipc$dispatch("-1591147141", new Object[]{this, onMatrixChangedListener});
        } else {
            this.p = onMatrixChangedListener;
        }
    }

    public void e0(OnOutsidePhotoTapListener onOutsidePhotoTapListener) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1130353485")) {
            ipChange.ipc$dispatch("1130353485", new Object[]{this, onOutsidePhotoTapListener});
        } else {
            this.r = onOutsidePhotoTapListener;
        }
    }

    public void f0(OnPhotoTapListener onPhotoTapListener) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1679880617")) {
            ipChange.ipc$dispatch("1679880617", new Object[]{this, onPhotoTapListener});
        } else {
            this.q = onPhotoTapListener;
        }
    }

    public void g0(OnScaleChangedListener onScaleChangedListener) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1216982313")) {
            ipChange.ipc$dispatch("-1216982313", new Object[]{this, onScaleChangedListener});
        } else {
            this.v = onScaleChangedListener;
        }
    }

    public void h0(OnSingleFlingListener onSingleFlingListener) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-698177523")) {
            ipChange.ipc$dispatch("-698177523", new Object[]{this, onSingleFlingListener});
        } else {
            this.w = onSingleFlingListener;
        }
    }

    public void i0(OnViewDragListener onViewDragListener) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "184712921")) {
            ipChange.ipc$dispatch("184712921", new Object[]{this, onViewDragListener});
        } else {
            this.x = onViewDragListener;
        }
    }

    public void j0(OnViewTapListener onViewTapListener) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-926069427")) {
            ipChange.ipc$dispatch("-926069427", new Object[]{this, onViewTapListener});
        } else {
            this.s = onViewTapListener;
        }
    }

    public void k0(float f) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "55906041")) {
            ipChange.ipc$dispatch("55906041", new Object[]{this, Float.valueOf(f)});
            return;
        }
        this.m.postRotate(f % 360.0f);
        B();
    }

    public void l0(float f) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "561995549")) {
            ipChange.ipc$dispatch("561995549", new Object[]{this, Float.valueOf(f)});
            return;
        }
        this.m.setRotate(f % 360.0f);
        B();
    }

    public void m0(float f) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "368278908")) {
            ipChange.ipc$dispatch("368278908", new Object[]{this, Float.valueOf(f)});
        } else {
            o0(f, false);
        }
    }

    public void n0(float f, float f2, float f3, boolean z) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "2076867544")) {
            ipChange.ipc$dispatch("2076867544", new Object[]{this, Float.valueOf(f), Float.valueOf(f2), Float.valueOf(f3), Boolean.valueOf(z)});
        } else if (f < this.c || f > this.e) {
            throw new IllegalArgumentException("Scale must be within the range of minScale and maxScale");
        } else {
            if (z) {
                this.h.post(new AnimatedZoomRunnable(N(), f, f2, f3));
                return;
            }
            this.m.setScale(f, f, f2, f3);
            B();
        }
    }

    public void o0(float f, boolean z) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1468209960")) {
            ipChange.ipc$dispatch("-1468209960", new Object[]{this, Float.valueOf(f), Boolean.valueOf(z)});
        } else {
            n0(f, this.h.getRight() / 2, this.h.getBottom() / 2, z);
        }
    }

    @Override // android.view.View.OnLayoutChangeListener
    public void onLayoutChange(View view, int i, int i2, int i3, int i4, int i5, int i6, int i7, int i8) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-2097333889")) {
            ipChange.ipc$dispatch("-2097333889", new Object[]{this, view, Integer.valueOf(i), Integer.valueOf(i2), Integer.valueOf(i3), Integer.valueOf(i4), Integer.valueOf(i5), Integer.valueOf(i6), Integer.valueOf(i7), Integer.valueOf(i8)});
        } else if (i == i5 && i2 == i6 && i3 == i7 && i4 == i8) {
        } else {
            u0(this.h.getDrawable());
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:33:0x009d  */
    /* JADX WARN: Removed duplicated region for block: B:48:0x00d0  */
    @Override // android.view.View.OnTouchListener
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public boolean onTouch(android.view.View r13, android.view.MotionEvent r14) {
        /*
            r12 = this;
            com.android.alibaba.ip.runtime.IpChange r0 = cn.damai.uikit.view.photoview.PhotoViewAttacher.$ipChange
            java.lang.String r1 = "1731005325"
            boolean r2 = com.android.alibaba.ip.runtime.AndroidInstantRuntime.support(r0, r1)
            r3 = 3
            r4 = 0
            r5 = 1
            if (r2 == 0) goto L21
            java.lang.Object[] r2 = new java.lang.Object[r3]
            r2[r4] = r12
            r2[r5] = r13
            r13 = 2
            r2[r13] = r14
            java.lang.Object r13 = r0.ipc$dispatch(r1, r2)
            java.lang.Boolean r13 = (java.lang.Boolean) r13
            boolean r13 = r13.booleanValue()
            return r13
        L21:
            boolean r0 = r12.B
            if (r0 == 0) goto Ldc
            r0 = r13
            android.widget.ImageView r0 = (android.widget.ImageView) r0
            boolean r0 = cn.damai.uikit.view.photoview.b.c(r0)
            if (r0 == 0) goto Ldc
            int r0 = r14.getAction()
            if (r0 == 0) goto L8c
            if (r0 == r5) goto L39
            if (r0 == r3) goto L39
            goto L98
        L39:
            float r0 = r12.N()
            float r1 = r12.c
            int r0 = (r0 > r1 ? 1 : (r0 == r1 ? 0 : -1))
            if (r0 >= 0) goto L62
            android.graphics.RectF r0 = r12.E()
            if (r0 == 0) goto L98
            cn.damai.uikit.view.photoview.PhotoViewAttacher$AnimatedZoomRunnable r1 = new cn.damai.uikit.view.photoview.PhotoViewAttacher$AnimatedZoomRunnable
            float r8 = r12.N()
            float r9 = r12.c
            float r10 = r0.centerX()
            float r11 = r0.centerY()
            r6 = r1
            r7 = r12
            r6.<init>(r8, r9, r10, r11)
            r13.post(r1)
            goto L8a
        L62:
            float r0 = r12.N()
            float r1 = r12.e
            int r0 = (r0 > r1 ? 1 : (r0 == r1 ? 0 : -1))
            if (r0 <= 0) goto L98
            android.graphics.RectF r0 = r12.E()
            if (r0 == 0) goto L98
            cn.damai.uikit.view.photoview.PhotoViewAttacher$AnimatedZoomRunnable r1 = new cn.damai.uikit.view.photoview.PhotoViewAttacher$AnimatedZoomRunnable
            float r8 = r12.N()
            float r9 = r12.e
            float r10 = r0.centerX()
            float r11 = r0.centerY()
            r6 = r1
            r7 = r12
            r6.<init>(r8, r9, r10, r11)
            r13.post(r1)
        L8a:
            r13 = 1
            goto L99
        L8c:
            android.view.ViewParent r13 = r13.getParent()
            if (r13 == 0) goto L95
            r13.requestDisallowInterceptTouchEvent(r5)
        L95:
            r12.A()
        L98:
            r13 = 0
        L99:
            cn.damai.uikit.view.photoview.a r0 = r12.j
            if (r0 == 0) goto Ld0
            boolean r13 = r0.e()
            cn.damai.uikit.view.photoview.a r0 = r12.j
            boolean r0 = r0.d()
            cn.damai.uikit.view.photoview.a r1 = r12.j
            boolean r1 = r1.f(r14)
            if (r13 != 0) goto Lb9
            cn.damai.uikit.view.photoview.a r13 = r12.j
            boolean r13 = r13.e()
            if (r13 != 0) goto Lb9
            r13 = 1
            goto Lba
        Lb9:
            r13 = 0
        Lba:
            if (r0 != 0) goto Lc6
            cn.damai.uikit.view.photoview.a r0 = r12.j
            boolean r0 = r0.d()
            if (r0 != 0) goto Lc6
            r0 = 1
            goto Lc7
        Lc6:
            r0 = 0
        Lc7:
            if (r13 == 0) goto Lcc
            if (r0 == 0) goto Lcc
            r4 = 1
        Lcc:
            r12.g = r4
            r4 = r1
            goto Ld1
        Ld0:
            r4 = r13
        Ld1:
            android.view.GestureDetector r13 = r12.i
            if (r13 == 0) goto Ldc
            boolean r13 = r13.onTouchEvent(r14)
            if (r13 == 0) goto Ldc
            r4 = 1
        Ldc:
            return r4
        */
        throw new UnsupportedOperationException("Method not decompiled: cn.damai.uikit.view.photoview.PhotoViewAttacher.onTouch(android.view.View, android.view.MotionEvent):boolean");
    }

    public void p0(float f, float f2, float f3) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-742694901")) {
            ipChange.ipc$dispatch("-742694901", new Object[]{this, Float.valueOf(f), Float.valueOf(f2), Float.valueOf(f3)});
            return;
        }
        cn.damai.uikit.view.photoview.b.a(f, f2, f3);
        this.c = f;
        this.d = f2;
        this.e = f3;
    }

    public void q0(ImageView.ScaleType scaleType) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1561040388")) {
            ipChange.ipc$dispatch("1561040388", new Object[]{this, scaleType});
        } else if (!cn.damai.uikit.view.photoview.b.d(scaleType) || scaleType == this.C) {
        } else {
            this.C = scaleType;
            t0();
        }
    }

    public void r0(int i) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-244679677")) {
            ipChange.ipc$dispatch("-244679677", new Object[]{this, Integer.valueOf(i)});
        } else {
            this.b = i;
        }
    }

    public void s0(boolean z) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1003165573")) {
            ipChange.ipc$dispatch("1003165573", new Object[]{this, Boolean.valueOf(z)});
            return;
        }
        this.B = z;
        t0();
    }

    public void t0() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1700103645")) {
            ipChange.ipc$dispatch("-1700103645", new Object[]{this});
        } else if (this.B) {
            u0(this.h.getDrawable());
        } else {
            T();
        }
    }
}
