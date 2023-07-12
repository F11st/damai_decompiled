package cn.damai.common.app.widget;

import android.app.Activity;
import android.app.Dialog;
import android.content.Context;
import android.graphics.Rect;
import android.os.Build;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewTreeObserver;
import android.view.Window;
import android.view.WindowManager;
import cn.damai.common.app.widget.BubbleLayout;
import cn.damai.uikit.R$style;
import com.alibaba.wireless.security.aopsdk.replace.android.util.DisplayMetrics;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import tb.q60;

/* compiled from: Taobao */
/* loaded from: classes13.dex */
public class BubbleDialog extends Dialog {
    private static transient /* synthetic */ IpChange $ipChange;
    private BubbleLayout a;
    private int b;
    private int c;
    private int d;
    private View e;
    private Rect f;
    private int g;
    private int h;
    private int i;
    private int j;
    private int k;
    private boolean l;
    private Position m;
    private Position[] n;
    private Auto o;
    private boolean p;
    private boolean q;
    private int[] r;
    private Activity s;
    private ViewTreeObserver.OnGlobalLayoutListener t;

    /* compiled from: Taobao */
    /* loaded from: classes13.dex */
    public enum Auto {
        AROUND,
        UP_AND_DOWN,
        LEFT_AND_RIGHT
    }

    /* compiled from: Taobao */
    /* loaded from: classes13.dex */
    public enum Position {
        LEFT,
        TOP,
        RIGHT,
        BOTTOM
    }

    /* compiled from: Taobao */
    /* loaded from: classes13.dex */
    public class a implements View.OnTouchListener {
        private static transient /* synthetic */ IpChange $ipChange;
        final /* synthetic */ WindowManager.LayoutParams a;
        final /* synthetic */ int b;

        a(WindowManager.LayoutParams layoutParams, int i) {
            this.a = layoutParams;
            this.b = i;
        }

        @Override // android.view.View.OnTouchListener
        public boolean onTouch(View view, MotionEvent motionEvent) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "-1806723117")) {
                return ((Boolean) ipChange.ipc$dispatch("-1806723117", new Object[]{this, view, motionEvent})).booleanValue();
            }
            if (BubbleDialog.this.p) {
                int i = this.a.x;
                float f = i < 0 ? 0.0f : i;
                int i2 = this.b;
                if (view.getWidth() + f > i2) {
                    f = i2 - view.getWidth();
                }
                motionEvent.setLocation(f + motionEvent.getX(), this.a.y + motionEvent.getY());
                BubbleDialog.this.s.getWindow().getDecorView().dispatchTouchEvent(motionEvent);
                return true;
            }
            return false;
        }
    }

    /* compiled from: Taobao */
    /* loaded from: classes13.dex */
    public class b implements ViewTreeObserver.OnGlobalLayoutListener {
        private static transient /* synthetic */ IpChange $ipChange;
        int a;
        int b;

        b() {
        }

        @Override // android.view.ViewTreeObserver.OnGlobalLayoutListener
        public void onGlobalLayout() {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "1954128679")) {
                ipChange.ipc$dispatch("1954128679", new Object[]{this});
            } else if (this.a == BubbleDialog.this.a.getMeasuredWidth() && this.b == BubbleDialog.this.a.getMeasuredHeight()) {
            } else {
                BubbleDialog.this.f();
                this.a = BubbleDialog.this.a.getMeasuredWidth();
                this.b = BubbleDialog.this.a.getMeasuredHeight();
            }
        }
    }

    /* compiled from: Taobao */
    /* loaded from: classes4.dex */
    public class c implements BubbleLayout.OnClickEdgeListener {
        private static transient /* synthetic */ IpChange $ipChange;

        c() {
        }

        @Override // cn.damai.common.app.widget.BubbleLayout.OnClickEdgeListener
        public void edge() {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "-1534681033")) {
                ipChange.ipc$dispatch("-1534681033", new Object[]{this});
            } else if (BubbleDialog.this.q) {
                BubbleDialog.this.dismiss();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: Taobao */
    /* loaded from: classes13.dex */
    public static /* synthetic */ class d {
        static final /* synthetic */ int[] a;
        static final /* synthetic */ int[] b;

        static {
            int[] iArr = new int[Auto.values().length];
            b = iArr;
            try {
                iArr[Auto.AROUND.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                b[Auto.UP_AND_DOWN.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                b[Auto.LEFT_AND_RIGHT.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            int[] iArr2 = new int[Position.values().length];
            a = iArr2;
            try {
                iArr2[Position.LEFT.ordinal()] = 1;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                a[Position.TOP.ordinal()] = 2;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                a[Position.RIGHT.ordinal()] = 3;
            } catch (NoSuchFieldError unused6) {
            }
            try {
                a[Position.BOTTOM.ordinal()] = 4;
            } catch (NoSuchFieldError unused7) {
            }
        }
    }

    public BubbleDialog(Context context) {
        super(context, R$style.bubble_dialog);
        this.m = Position.TOP;
        this.n = new Position[4];
        this.p = false;
        this.r = new int[2];
        setCancelable(true);
        this.s = (Activity) context;
        Window window = getWindow();
        if (window == null) {
            return;
        }
        WindowManager.LayoutParams attributes = window.getAttributes();
        int i = DisplayMetrics.getwidthPixels(q60.b(getContext()));
        this.i = q60.c(getContext());
        getWindow().getDecorView().setOnTouchListener(new a(attributes, i));
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Code restructure failed: missing block: B:34:0x0072, code lost:
        if (r2 != 4) goto L34;
     */
    /* JADX WARN: Removed duplicated region for block: B:80:0x0267  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public void f() {
        /*
            Method dump skipped, instructions count: 629
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: cn.damai.common.app.widget.BubbleDialog.f():void");
    }

    private void g() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "915368156")) {
            ipChange.ipc$dispatch("915368156", new Object[]{this});
            return;
        }
        i();
        if (this.t != null) {
            m();
            f();
        }
    }

    private boolean h() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-805721721")) {
            return ((Boolean) ipChange.ipc$dispatch("-805721721", new Object[]{this})).booleanValue();
        }
        int i = 0;
        for (Position position : this.n) {
            if (position != null) {
                i++;
            }
        }
        return i > 0;
    }

    private void i() {
        Position[] positionArr;
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1338801810")) {
            ipChange.ipc$dispatch("-1338801810", new Object[]{this});
        } else if (this.f != null) {
            if (this.o != null || h()) {
                int[] iArr = this.r;
                int[] iArr2 = {iArr[0], iArr[1], (DisplayMetrics.getwidthPixels(q60.b(getContext())) - this.r[0]) - com.alibaba.wireless.security.aopsdk.replace.android.graphics.Rect.width(this.f), (DisplayMetrics.getheightPixels(q60.b(getContext())) - this.r[1]) - com.alibaba.wireless.security.aopsdk.replace.android.graphics.Rect.height(this.f)};
                if (h()) {
                    this.e.measure(0, 0);
                    for (Position position : this.n) {
                        if (position == null) {
                            return;
                        }
                        int i = d.a[position.ordinal()];
                        if (i != 1) {
                            if (i != 2) {
                                if (i != 3) {
                                    if (iArr2[3] > this.e.getMeasuredHeight()) {
                                        this.m = Position.BOTTOM;
                                        return;
                                    }
                                } else if (iArr2[2] > this.e.getMeasuredWidth()) {
                                    this.m = Position.RIGHT;
                                    return;
                                }
                            } else if (iArr2[1] > this.e.getMeasuredHeight()) {
                                this.m = Position.TOP;
                                return;
                            }
                        } else if (iArr2[0] > this.e.getMeasuredWidth()) {
                            this.m = Position.LEFT;
                            return;
                        }
                    }
                    this.m = this.n[0];
                    return;
                }
                Auto auto = this.o;
                if (auto != null) {
                    int i2 = d.b[auto.ordinal()];
                    if (i2 == 2) {
                        this.m = iArr2[1] > iArr2[3] ? Position.TOP : Position.BOTTOM;
                        return;
                    } else if (i2 == 3) {
                        this.m = iArr2[0] > iArr2[2] ? Position.LEFT : Position.RIGHT;
                        return;
                    }
                }
                int i3 = 0;
                for (int i4 = 0; i4 < 4; i4++) {
                    int i5 = iArr2[i4];
                    if (i5 > i3) {
                        i3 = i5;
                    }
                }
                if (i3 == iArr2[0]) {
                    this.m = Position.LEFT;
                } else if (i3 == iArr2[1]) {
                    this.m = Position.TOP;
                } else if (i3 == iArr2[2]) {
                    this.m = Position.RIGHT;
                } else if (i3 == iArr2[3]) {
                    this.m = Position.BOTTOM;
                }
            }
        }
    }

    private void m() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "2080848612")) {
            ipChange.ipc$dispatch("2080848612", new Object[]{this});
            return;
        }
        int i = d.a[this.m.ordinal()];
        if (i == 1) {
            this.a.setLook(BubbleLayout.Look.RIGHT);
        } else if (i == 2) {
            this.a.setLook(BubbleLayout.Look.BOTTOM);
        } else if (i == 3) {
            this.a.setLook(BubbleLayout.Look.LEFT);
        } else if (i == 4) {
            this.a.setLook(BubbleLayout.Look.TOP);
        }
        this.a.initPadding();
    }

    @Override // android.app.Dialog, android.content.DialogInterface
    public void dismiss() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-594101797")) {
            ipChange.ipc$dispatch("-594101797", new Object[]{this});
            return;
        }
        BubbleLayout bubbleLayout = this.a;
        if (bubbleLayout != null && Build.VERSION.SDK_INT >= 16) {
            bubbleLayout.getViewTreeObserver().removeOnGlobalLayoutListener(this.t);
        }
        super.dismiss();
    }

    public <T extends BubbleDialog> T j(View view) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1156174502")) {
            return (T) ipChange.ipc$dispatch("1156174502", new Object[]{this, view});
        }
        this.e = view;
        return this;
    }

    public <T extends BubbleDialog> T k(View view, int[] iArr) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1958138930")) {
            return (T) ipChange.ipc$dispatch("-1958138930", new Object[]{this, view, iArr});
        }
        this.f = new Rect(iArr[0], iArr[1], iArr[2], iArr[3]);
        view.getLocationOnScreen(this.r);
        g();
        return this;
    }

    public <T extends BubbleDialog> T l(int i, int i2, int i3) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1625249779")) {
            return (T) ipChange.ipc$dispatch("1625249779", new Object[]{this, Integer.valueOf(i), Integer.valueOf(i2), Integer.valueOf(i3)});
        }
        this.b = i;
        this.c = i2;
        this.d = i3;
        return this;
    }

    public <T extends BubbleDialog> T n(int i) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-257593861")) {
            return (T) ipChange.ipc$dispatch("-257593861", new Object[]{this, Integer.valueOf(i)});
        }
        this.k = q60.a(getContext(), i);
        return this;
    }

    public <T extends BubbleDialog> T o(Position... positionArr) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-2016341874")) {
            return (T) ipChange.ipc$dispatch("-2016341874", new Object[]{this, positionArr});
        }
        if (positionArr.length == 1 && positionArr[0] != null) {
            this.m = positionArr[0];
            return this;
        }
        this.n = positionArr;
        return this;
    }

    @Override // android.app.Dialog
    protected void onCreate(Bundle bundle) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-581309974")) {
            ipChange.ipc$dispatch("-581309974", new Object[]{this, bundle});
            return;
        }
        super.onCreate(bundle);
        if (this.a == null) {
            this.a = new BubbleLayout(getContext());
        }
        View view = this.e;
        if (view != null) {
            this.a.addView(view);
        }
        setContentView(this.a);
        Window window = getWindow();
        if (window == null) {
            return;
        }
        if (this.l) {
            window.setSoftInputMode(18);
        }
        window.setLayout(-2, -2);
        i();
        m();
        this.a.measure(0, 0);
        f();
        this.t = new b();
        this.a.getViewTreeObserver().addOnGlobalLayoutListener(this.t);
        this.a.setOnClickEdgeListener(new c());
    }

    @Override // android.app.Dialog, android.view.KeyEvent.Callback
    public boolean onKeyDown(int i, KeyEvent keyEvent) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-459851264")) {
            return ((Boolean) ipChange.ipc$dispatch("-459851264", new Object[]{this, Integer.valueOf(i), keyEvent})).booleanValue();
        }
        if (this.p && i == 4 && keyEvent.getRepeatCount() == 0) {
            dismiss();
            this.s.onBackPressed();
            this.s = null;
            return true;
        }
        return super.onKeyDown(i, keyEvent);
    }

    @Override // android.app.Dialog
    public boolean onTouchEvent(MotionEvent motionEvent) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "910366340")) {
            return ((Boolean) ipChange.ipc$dispatch("910366340", new Object[]{this, motionEvent})).booleanValue();
        }
        Window window = getWindow();
        if (window == null) {
            return false;
        }
        View decorView = window.getDecorView();
        if (this.q && isShowing() && s(motionEvent, decorView)) {
            cancel();
            return true;
        }
        return false;
    }

    public <T extends BubbleDialog> T p(int i) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "19244008")) {
            return (T) ipChange.ipc$dispatch("19244008", new Object[]{this, Integer.valueOf(i)});
        }
        this.j = q60.a(getContext(), i);
        return this;
    }

    public <T extends BubbleDialog> T q(boolean z, boolean z2) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-755166505")) {
            return (T) ipChange.ipc$dispatch("-755166505", new Object[]{this, Boolean.valueOf(z), Boolean.valueOf(z2)});
        }
        this.p = z;
        if (z) {
            setCancelable(false);
        } else {
            setCancelable(z2);
        }
        return this;
    }

    public <T extends BubbleDialog> T r() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1918534768")) {
            return (T) ipChange.ipc$dispatch("1918534768", new Object[]{this});
        }
        if (getWindow() == null) {
            return this;
        }
        getWindow().clearFlags(2);
        return this;
    }

    public boolean s(MotionEvent motionEvent, View view) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "724636503")) {
            return ((Boolean) ipChange.ipc$dispatch("724636503", new Object[]{this, motionEvent, view})).booleanValue();
        }
        int x = (int) motionEvent.getX();
        int y = (int) motionEvent.getY();
        return x <= 0 || y <= 0 || x > view.getWidth() || y > view.getHeight();
    }

    @Override // android.app.Dialog
    public void setCancelable(boolean z) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1809277787")) {
            ipChange.ipc$dispatch("-1809277787", new Object[]{this, Boolean.valueOf(z)});
            return;
        }
        super.setCancelable(z);
        this.q = z;
    }
}
