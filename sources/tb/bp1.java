package tb;

import android.app.Activity;
import android.content.Context;
import android.database.ContentObserver;
import android.os.Handler;
import android.provider.Settings;
import com.alibaba.pictures.responsive.page.orientation.OrientationListener;
import com.alibaba.pictures.responsive.state.ResponsivePageStateCache;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: Taobao */
/* loaded from: classes7.dex */
public final class bp1 {
    private static transient /* synthetic */ IpChange $ipChange;
    @NotNull
    private final Activity a;
    @Nullable
    private OrientationListener b;
    @NotNull
    private final Handler c;
    @NotNull
    private final ContentObserver d;
    @NotNull
    private OrientationListener.OrientationChangeCallback e;

    /* compiled from: Taobao */
    /* renamed from: tb.bp1$a */
    /* loaded from: classes7.dex */
    public static final class C8970a implements OrientationListener.OrientationChangeCallback {
        private static transient /* synthetic */ IpChange $ipChange;

        C8970a() {
        }

        @Override // com.alibaba.pictures.responsive.page.orientation.OrientationListener.OrientationChangeCallback
        public void land() {
            int requestedOrientation;
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "1867383514")) {
                ipChange.ipc$dispatch("1867383514", new Object[]{this});
            } else if (bp1.this.f() || (requestedOrientation = bp1.this.a.getRequestedOrientation()) == 0) {
            } else {
                if (requestedOrientation != 6 && requestedOrientation != 8) {
                    bp1 bp1Var = bp1.this;
                    if (bp1Var.e(bp1Var.a)) {
                        dp1.INSTANCE.b(bp1.this.a, 0);
                        return;
                    }
                    return;
                }
                dp1.INSTANCE.b(bp1.this.a, 0);
            }
        }

        @Override // com.alibaba.pictures.responsive.page.orientation.OrientationListener.OrientationChangeCallback
        public void port() {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "1527409796")) {
                ipChange.ipc$dispatch("1527409796", new Object[]{this});
                return;
            }
            try {
                if (bp1.this.f()) {
                    return;
                }
                int requestedOrientation = bp1.this.a.getRequestedOrientation();
                if (requestedOrientation != 1) {
                    if (requestedOrientation == 9) {
                        dp1.INSTANCE.b(bp1.this.a, 1);
                    } else {
                        bp1 bp1Var = bp1.this;
                        if (bp1Var.e(bp1Var.a)) {
                            dp1.INSTANCE.b(bp1.this.a, 1);
                        }
                    }
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }

        @Override // com.alibaba.pictures.responsive.page.orientation.OrientationListener.OrientationChangeCallback
        public void reverseLand() {
            int requestedOrientation;
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "1544348984")) {
                ipChange.ipc$dispatch("1544348984", new Object[]{this});
            } else if (bp1.this.f() || (requestedOrientation = bp1.this.a.getRequestedOrientation()) == 8) {
            } else {
                if (requestedOrientation != 0 && requestedOrientation != 6) {
                    bp1 bp1Var = bp1.this;
                    if (bp1Var.e(bp1Var.a)) {
                        dp1.INSTANCE.b(bp1.this.a, 8);
                        return;
                    }
                    return;
                }
                dp1.INSTANCE.b(bp1.this.a, 8);
            }
        }

        @Override // com.alibaba.pictures.responsive.page.orientation.OrientationListener.OrientationChangeCallback
        public void reversePort() {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "1204375266")) {
                ipChange.ipc$dispatch("1204375266", new Object[]{this});
            }
        }
    }

    /* compiled from: Taobao */
    /* renamed from: tb.bp1$b */
    /* loaded from: classes7.dex */
    public static final class C8971b extends ContentObserver {
        private static transient /* synthetic */ IpChange $ipChange;

        C8971b(Handler handler) {
            super(handler);
        }

        @Override // android.database.ContentObserver
        public boolean deliverSelfNotifications() {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "-1620134387")) {
                return ((Boolean) ipChange.ipc$dispatch("-1620134387", new Object[]{this})).booleanValue();
            }
            return true;
        }

        /* JADX WARN: Removed duplicated region for block: B:19:0x004f  */
        /* JADX WARN: Removed duplicated region for block: B:22:? A[RETURN, SYNTHETIC] */
        @Override // android.database.ContentObserver
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct code enable 'Show inconsistent code' option in preferences
        */
        public void onChange(boolean r6) {
            /*
                r5 = this;
                com.android.alibaba.ip.runtime.IpChange r0 = tb.bp1.C8971b.$ipChange
                java.lang.String r1 = "-478515197"
                boolean r2 = com.android.alibaba.ip.runtime.AndroidInstantRuntime.support(r0, r1)
                r3 = 1
                if (r2 == 0) goto L1b
                r2 = 2
                java.lang.Object[] r2 = new java.lang.Object[r2]
                r4 = 0
                r2[r4] = r5
                java.lang.Boolean r6 = java.lang.Boolean.valueOf(r6)
                r2[r3] = r6
                r0.ipc$dispatch(r1, r2)
                return
            L1b:
                super.onChange(r6)
                tb.bp1 r6 = tb.bp1.this
                android.app.Activity r6 = tb.bp1.a(r6)
                boolean r6 = r6.isFinishing()
                if (r6 != 0) goto L52
                tb.bp1 r6 = tb.bp1.this
                android.app.Activity r6 = tb.bp1.a(r6)
                int r6 = r6.getRequestedOrientation()
                r0 = 1001(0x3e9, float:1.403E-42)
                if (r6 == 0) goto L44
                if (r6 == r3) goto L46
                switch(r6) {
                    case 6: goto L44;
                    case 7: goto L46;
                    case 8: goto L41;
                    case 9: goto L3e;
                    default: goto L3d;
                }
            L3d:
                goto L46
            L3e:
                r0 = 1004(0x3ec, float:1.407E-42)
                goto L46
            L41:
                r0 = 1003(0x3eb, float:1.406E-42)
                goto L46
            L44:
                r0 = 1002(0x3ea, float:1.404E-42)
            L46:
                tb.bp1 r6 = tb.bp1.this
                com.alibaba.pictures.responsive.page.orientation.OrientationListener r6 = tb.bp1.b(r6)
                if (r6 != 0) goto L4f
                goto L52
            L4f:
                r6.c(r0)
            L52:
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: tb.bp1.C8971b.onChange(boolean):void");
        }
    }

    public bp1(@NotNull Activity activity) {
        b41.i(activity, "activity");
        this.a = activity;
        Handler handler = new Handler();
        this.c = handler;
        C8971b c8971b = new C8971b(handler);
        this.d = c8971b;
        this.e = new C8970a();
        OrientationListener orientationListener = new OrientationListener(activity, this.e);
        orientationListener.b();
        wt2 wt2Var = wt2.INSTANCE;
        this.b = orientationListener;
        activity.getContentResolver().registerContentObserver(Settings.System.getUriFor("accelerometer_rotation"), false, c8971b);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final boolean e(Context context) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1876527605")) {
            return ((Boolean) ipChange.ipc$dispatch("-1876527605", new Object[]{this, context})).booleanValue();
        }
        try {
            return Settings.System.getInt(context.getContentResolver(), "accelerometer_rotation", 0) == 1;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final boolean f() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "139469807")) {
            return ((Boolean) ipChange.ipc$dispatch("139469807", new Object[]{this})).booleanValue();
        }
        return c80.g(this.a) && ResponsivePageStateCache.Companion.a().d(this.a) <= ye2.b();
    }

    public final void g() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1055250616")) {
            ipChange.ipc$dispatch("1055250616", new Object[]{this});
            return;
        }
        OrientationListener orientationListener = this.b;
        if (orientationListener != null) {
            orientationListener.a();
        }
        this.c.removeCallbacksAndMessages(null);
        this.a.getContentResolver().unregisterContentObserver(this.d);
    }
}
