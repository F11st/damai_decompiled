package cn.damai.uikit.wheel;

import android.content.Context;
import android.os.Handler;
import android.os.Message;
import android.view.GestureDetector;
import android.view.MotionEvent;
import android.view.animation.Interpolator;
import android.widget.Scroller;
import com.alibaba.poplayerconsole.lib.StandOutWindow;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;

/* compiled from: Taobao */
/* loaded from: classes8.dex */
public class WheelScroller {
    private static transient /* synthetic */ IpChange $ipChange = null;
    public static final int MIN_DELTA_FOR_SCROLLING = 1;
    private ScrollingListener a;
    private Context b;
    private GestureDetector c;
    private Scroller d;
    private int e;
    private float f;
    private boolean g;
    private GestureDetector.SimpleOnGestureListener h = new a();
    private Handler i = new b();

    /* compiled from: Taobao */
    /* loaded from: classes8.dex */
    public interface ScrollingListener {
        void onFinished();

        void onJustify();

        void onScroll(int i);

        void onStarted();
    }

    /* compiled from: Taobao */
    /* loaded from: classes8.dex */
    public class a extends GestureDetector.SimpleOnGestureListener {
        private static transient /* synthetic */ IpChange $ipChange;

        a() {
        }

        @Override // android.view.GestureDetector.SimpleOnGestureListener, android.view.GestureDetector.OnGestureListener
        public boolean onFling(MotionEvent motionEvent, MotionEvent motionEvent2, float f, float f2) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "-947988864")) {
                return ((Boolean) ipChange.ipc$dispatch("-947988864", new Object[]{this, motionEvent, motionEvent2, Float.valueOf(f), Float.valueOf(f2)})).booleanValue();
            }
            WheelScroller.this.e = 0;
            WheelScroller.this.d.fling(0, WheelScroller.this.e, 0, (int) (-f2), 0, 0, StandOutWindow.StandOutLayoutParams.AUTO_POSITION, Integer.MAX_VALUE);
            WheelScroller.this.n(0);
            return true;
        }

        @Override // android.view.GestureDetector.SimpleOnGestureListener, android.view.GestureDetector.OnGestureListener
        public boolean onScroll(MotionEvent motionEvent, MotionEvent motionEvent2, float f, float f2) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "310847197")) {
                return ((Boolean) ipChange.ipc$dispatch("310847197", new Object[]{this, motionEvent, motionEvent2, Float.valueOf(f), Float.valueOf(f2)})).booleanValue();
            }
            return true;
        }
    }

    /* compiled from: Taobao */
    /* loaded from: classes8.dex */
    public class b extends Handler {
        private static transient /* synthetic */ IpChange $ipChange;

        b() {
        }

        @Override // android.os.Handler
        public void handleMessage(Message message) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "1978356738")) {
                ipChange.ipc$dispatch("1978356738", new Object[]{this, message});
                return;
            }
            WheelScroller.this.d.computeScrollOffset();
            int currY = WheelScroller.this.d.getCurrY();
            int i = WheelScroller.this.e - currY;
            WheelScroller.this.e = currY;
            if (i != 0) {
                WheelScroller.this.a.onScroll(i);
            }
            if (Math.abs(currY - WheelScroller.this.d.getFinalY()) < 1) {
                WheelScroller.this.d.getFinalY();
                WheelScroller.this.d.forceFinished(true);
            }
            if (!WheelScroller.this.d.isFinished()) {
                WheelScroller.this.i.sendEmptyMessage(message.what);
            } else if (message.what == 0) {
                WheelScroller.this.j();
            } else {
                WheelScroller.this.i();
            }
        }
    }

    public WheelScroller(Context context, ScrollingListener scrollingListener) {
        GestureDetector gestureDetector = new GestureDetector(context, this.h);
        this.c = gestureDetector;
        gestureDetector.setIsLongpressEnabled(false);
        this.d = new Scroller(context);
        this.a = scrollingListener;
        this.b = context;
    }

    private void h() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1517117955")) {
            ipChange.ipc$dispatch("1517117955", new Object[]{this});
            return;
        }
        this.i.removeMessages(0);
        this.i.removeMessages(1);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void j() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "2033060876")) {
            ipChange.ipc$dispatch("2033060876", new Object[]{this});
            return;
        }
        this.a.onJustify();
        n(1);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void n(int i) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "288340775")) {
            ipChange.ipc$dispatch("288340775", new Object[]{this, Integer.valueOf(i)});
            return;
        }
        h();
        this.i.sendEmptyMessage(i);
    }

    private void o() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-996581413")) {
            ipChange.ipc$dispatch("-996581413", new Object[]{this});
        } else if (this.g) {
        } else {
            this.g = true;
            this.a.onStarted();
        }
    }

    void i() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1380148154")) {
            ipChange.ipc$dispatch("1380148154", new Object[]{this});
        } else if (this.g) {
            this.a.onFinished();
            this.g = false;
        }
    }

    public boolean k(MotionEvent motionEvent) {
        int y;
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1070299219")) {
            return ((Boolean) ipChange.ipc$dispatch("-1070299219", new Object[]{this, motionEvent})).booleanValue();
        }
        int action = motionEvent.getAction();
        if (action == 0) {
            this.f = motionEvent.getY();
            this.d.forceFinished(true);
            h();
        } else if (action == 2 && (y = (int) (motionEvent.getY() - this.f)) != 0) {
            o();
            this.a.onScroll(y);
            this.f = motionEvent.getY();
        }
        if (!this.c.onTouchEvent(motionEvent) && motionEvent.getAction() == 1) {
            j();
        }
        return true;
    }

    public void l(int i, int i2) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1001176159")) {
            ipChange.ipc$dispatch("-1001176159", new Object[]{this, Integer.valueOf(i), Integer.valueOf(i2)});
            return;
        }
        this.d.forceFinished(true);
        this.e = 0;
        this.d.startScroll(0, 0, 0, i, i2 != 0 ? i2 : 400);
        n(0);
        o();
    }

    public void m(Interpolator interpolator) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-213151150")) {
            ipChange.ipc$dispatch("-213151150", new Object[]{this, interpolator});
            return;
        }
        this.d.forceFinished(true);
        this.d = new Scroller(this.b, interpolator);
    }

    public void p() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1965723241")) {
            ipChange.ipc$dispatch("1965723241", new Object[]{this});
        } else {
            this.d.forceFinished(true);
        }
    }
}
