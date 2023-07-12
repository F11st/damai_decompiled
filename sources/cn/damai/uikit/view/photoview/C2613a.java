package cn.damai.uikit.view.photoview;

import android.content.Context;
import android.view.MotionEvent;
import android.view.ScaleGestureDetector;
import android.view.VelocityTracker;
import android.view.ViewConfiguration;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;

/* compiled from: Taobao */
/* renamed from: cn.damai.uikit.view.photoview.a */
/* loaded from: classes8.dex */
public class C2613a {
    private static transient /* synthetic */ IpChange $ipChange;
    private int a = -1;
    private int b = 0;
    private final ScaleGestureDetector c;
    private VelocityTracker d;
    private boolean e;
    private float f;
    private float g;
    private final float h;
    private final float i;
    private OnGestureListener j;

    /* compiled from: Taobao */
    /* renamed from: cn.damai.uikit.view.photoview.a$a */
    /* loaded from: classes8.dex */
    public class ScaleGestureDetector$OnScaleGestureListenerC2614a implements ScaleGestureDetector.OnScaleGestureListener {
        private static transient /* synthetic */ IpChange $ipChange;

        ScaleGestureDetector$OnScaleGestureListenerC2614a() {
        }

        @Override // android.view.ScaleGestureDetector.OnScaleGestureListener
        public boolean onScale(ScaleGestureDetector scaleGestureDetector) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "1294740133")) {
                return ((Boolean) ipChange.ipc$dispatch("1294740133", new Object[]{this, scaleGestureDetector})).booleanValue();
            }
            float scaleFactor = scaleGestureDetector.getScaleFactor();
            if (Float.isNaN(scaleFactor) || Float.isInfinite(scaleFactor)) {
                return false;
            }
            C2613a.this.j.onScale(scaleFactor, scaleGestureDetector.getFocusX(), scaleGestureDetector.getFocusY());
            return true;
        }

        @Override // android.view.ScaleGestureDetector.OnScaleGestureListener
        public boolean onScaleBegin(ScaleGestureDetector scaleGestureDetector) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "-401950106")) {
                return ((Boolean) ipChange.ipc$dispatch("-401950106", new Object[]{this, scaleGestureDetector})).booleanValue();
            }
            return true;
        }

        @Override // android.view.ScaleGestureDetector.OnScaleGestureListener
        public void onScaleEnd(ScaleGestureDetector scaleGestureDetector) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "-1601213420")) {
                ipChange.ipc$dispatch("-1601213420", new Object[]{this, scaleGestureDetector});
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public C2613a(Context context, OnGestureListener onGestureListener) {
        ViewConfiguration viewConfiguration = ViewConfiguration.get(context);
        this.i = viewConfiguration.getScaledMinimumFlingVelocity();
        this.h = viewConfiguration.getScaledTouchSlop();
        this.j = onGestureListener;
        this.c = new ScaleGestureDetector(context, new ScaleGestureDetector$OnScaleGestureListenerC2614a());
    }

    private float b(MotionEvent motionEvent) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-80056022")) {
            return ((Float) ipChange.ipc$dispatch("-80056022", new Object[]{this, motionEvent})).floatValue();
        }
        try {
            return motionEvent.getX(this.b);
        } catch (Exception unused) {
            return motionEvent.getX();
        }
    }

    private float c(MotionEvent motionEvent) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-68739895")) {
            return ((Float) ipChange.ipc$dispatch("-68739895", new Object[]{this, motionEvent})).floatValue();
        }
        try {
            return motionEvent.getY(this.b);
        } catch (Exception unused) {
            return motionEvent.getY();
        }
    }

    private boolean g(MotionEvent motionEvent) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-2028806824")) {
            return ((Boolean) ipChange.ipc$dispatch("-2028806824", new Object[]{this, motionEvent})).booleanValue();
        }
        int action = motionEvent.getAction() & 255;
        if (action == 0) {
            this.a = motionEvent.getPointerId(0);
            VelocityTracker obtain = VelocityTracker.obtain();
            this.d = obtain;
            if (obtain != null) {
                obtain.addMovement(motionEvent);
            }
            this.f = b(motionEvent);
            this.g = c(motionEvent);
            this.e = false;
        } else if (action == 1) {
            this.a = -1;
            if (this.e && this.d != null) {
                this.f = b(motionEvent);
                this.g = c(motionEvent);
                this.d.addMovement(motionEvent);
                this.d.computeCurrentVelocity(1000);
                float xVelocity = this.d.getXVelocity();
                float yVelocity = this.d.getYVelocity();
                if (Math.max(Math.abs(xVelocity), Math.abs(yVelocity)) >= this.i) {
                    this.j.onFling(this.f, this.g, -xVelocity, -yVelocity);
                }
            }
            VelocityTracker velocityTracker = this.d;
            if (velocityTracker != null) {
                velocityTracker.recycle();
                this.d = null;
            }
        } else if (action == 2) {
            float b = b(motionEvent);
            float c = c(motionEvent);
            float f = b - this.f;
            float f2 = c - this.g;
            if (!this.e) {
                this.e = Math.sqrt((double) ((f * f) + (f2 * f2))) >= ((double) this.h);
            }
            if (this.e) {
                this.j.onDrag(f, f2);
                this.f = b;
                this.g = c;
                VelocityTracker velocityTracker2 = this.d;
                if (velocityTracker2 != null) {
                    velocityTracker2.addMovement(motionEvent);
                }
            }
        } else if (action == 3) {
            this.a = -1;
            VelocityTracker velocityTracker3 = this.d;
            if (velocityTracker3 != null) {
                velocityTracker3.recycle();
                this.d = null;
            }
        } else if (action == 6) {
            int b2 = C2615b.b(motionEvent.getAction());
            if (motionEvent.getPointerId(b2) == this.a) {
                int i = b2 == 0 ? 1 : 0;
                this.a = motionEvent.getPointerId(i);
                this.f = motionEvent.getX(i);
                this.g = motionEvent.getY(i);
            }
        }
        int i2 = this.a;
        this.b = motionEvent.findPointerIndex(i2 != -1 ? i2 : 0);
        return true;
    }

    public boolean d() {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "-219455604") ? ((Boolean) ipChange.ipc$dispatch("-219455604", new Object[]{this})).booleanValue() : this.e;
    }

    public boolean e() {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "669599376") ? ((Boolean) ipChange.ipc$dispatch("669599376", new Object[]{this})).booleanValue() : this.c.isInProgress();
    }

    public boolean f(MotionEvent motionEvent) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "321692416")) {
            return ((Boolean) ipChange.ipc$dispatch("321692416", new Object[]{this, motionEvent})).booleanValue();
        }
        try {
            this.c.onTouchEvent(motionEvent);
            return g(motionEvent);
        } catch (IllegalArgumentException unused) {
            return true;
        }
    }
}
