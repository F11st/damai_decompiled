package tb;

import android.app.Activity;
import android.content.res.Resources;
import android.graphics.Point;
import android.graphics.drawable.BitmapDrawable;
import android.os.Build;
import android.view.View;
import android.view.WindowManager;
import android.widget.PopupWindow;
import com.alibaba.pictures.R$style;
import com.alibaba.wireless.security.aopsdk.replace.android.util.DisplayMetrics;
import com.alibaba.wireless.security.aopsdk.replace.android.view.Display;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import com.youku.arch.v3.data.Constants;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: Taobao */
/* loaded from: classes7.dex */
public final class qt1 {
    private static transient /* synthetic */ IpChange $ipChange;
    @NotNull
    public static final C9628a Companion = new C9628a(null);
    @NotNull
    private final View a;
    private int b;
    @Nullable
    private PopupWindow c;

    /* compiled from: Taobao */
    /* renamed from: tb.qt1$a */
    /* loaded from: classes7.dex */
    public static final class C9628a {
        private static transient /* synthetic */ IpChange $ipChange;

        private C9628a() {
        }

        public /* synthetic */ C9628a(k50 k50Var) {
            this();
        }

        public final int a(@NotNull Activity activity) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "-1743925177")) {
                return ((Integer) ipChange.ipc$dispatch("-1743925177", new Object[]{this, activity})).intValue();
            }
            b41.i(activity, "activity");
            try {
                Resources resources = activity.getResources();
                return resources.getDimensionPixelSize(resources.getIdentifier("navigation_bar_height", Constants.DIMEN, "android"));
            } catch (Exception e) {
                e.printStackTrace();
                return 0;
            }
        }
    }

    public qt1(@NotNull View view, int i) {
        b41.i(view, "contentView");
        this.a = view;
        this.b = i;
    }

    public final int a() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "663169798")) {
            return ((Integer) ipChange.ipc$dispatch("663169798", new Object[]{this})).intValue();
        }
        Resources system = Resources.getSystem();
        int identifier = system.getIdentifier("navigation_bar_height", Constants.DIMEN, "android");
        if (identifier != 0) {
            return system.getDimensionPixelSize(identifier);
        }
        return 0;
    }

    @Nullable
    public final PopupWindow b() {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "-1754664240") ? (PopupWindow) ipChange.ipc$dispatch("-1754664240", new Object[]{this}) : this.c;
    }

    public final int c(@NotNull Activity activity) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "180547562")) {
            return ((Integer) ipChange.ipc$dispatch("180547562", new Object[]{this, activity})).intValue();
        }
        b41.i(activity, "activity");
        Object systemService = activity.getSystemService(C9796v.ATTACH_MODE_WINDOW);
        b41.g(systemService, "null cannot be cast to non-null type android.view.WindowManager");
        WindowManager windowManager = (WindowManager) systemService;
        Point point = new Point();
        if (Build.VERSION.SDK_INT >= 17) {
            Display.getRealSize(windowManager.getDefaultDisplay(), point);
        }
        return com.alibaba.wireless.security.aopsdk.replace.android.graphics.Point.gety(point);
    }

    public final int d() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1877668555")) {
            return ((Integer) ipChange.ipc$dispatch("1877668555", new Object[]{this})).intValue();
        }
        Resources system = Resources.getSystem();
        return system.getDimensionPixelSize(system.getIdentifier("status_bar_height", Constants.DIMEN, "android"));
    }

    public final int e() {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "-1291479207") ? ((Integer) ipChange.ipc$dispatch("-1291479207", new Object[]{this})).intValue() : this.b;
    }

    /* JADX WARN: Removed duplicated region for block: B:20:0x004f A[ORIG_RETURN, RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:31:? A[RETURN, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final boolean f(@org.jetbrains.annotations.Nullable android.app.Activity r6) {
        /*
            r5 = this;
            com.android.alibaba.ip.runtime.IpChange r0 = tb.qt1.$ipChange
            java.lang.String r1 = "-435915004"
            boolean r2 = com.android.alibaba.ip.runtime.AndroidInstantRuntime.support(r0, r1)
            r3 = 1
            r4 = 0
            if (r2 == 0) goto L1e
            r2 = 2
            java.lang.Object[] r2 = new java.lang.Object[r2]
            r2[r4] = r5
            r2[r3] = r6
            java.lang.Object r6 = r0.ipc$dispatch(r1, r2)
            java.lang.Boolean r6 = (java.lang.Boolean) r6
            boolean r6 = r6.booleanValue()
            return r6
        L1e:
            if (r6 != 0) goto L21
            return r4
        L21:
            android.graphics.Rect r0 = new android.graphics.Rect
            r0.<init>()
            android.view.Window r1 = r6.getWindow()     // Catch: java.lang.Exception -> L51
            android.view.View r1 = r1.getDecorView()     // Catch: java.lang.Exception -> L51
            r1.getWindowVisibleDisplayFrame(r0)     // Catch: java.lang.Exception -> L51
            int r0 = com.alibaba.wireless.security.aopsdk.replace.android.graphics.Rect.height(r0)     // Catch: java.lang.Exception -> L46
            int r6 = r5.c(r6)     // Catch: java.lang.Exception -> L44
            int r1 = r5.d()     // Catch: java.lang.Exception -> L44
            int r6 = r6 - r1
            int r1 = r5.a()     // Catch: java.lang.Exception -> L44
            int r6 = r6 - r1
            goto L4c
        L44:
            r6 = move-exception
            goto L48
        L46:
            r6 = move-exception
            r0 = 0
        L48:
            r6.printStackTrace()
            r6 = 0
        L4c:
            if (r0 != r6) goto L4f
            goto L50
        L4f:
            r3 = 0
        L50:
            return r3
        L51:
            r6 = move-exception
            r6.printStackTrace()
            return r4
        */
        throw new UnsupportedOperationException("Method not decompiled: tb.qt1.f(android.app.Activity):boolean");
    }

    @NotNull
    public final qt1 g(@NotNull Activity activity) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1416951434")) {
            return (qt1) ipChange.ipc$dispatch("1416951434", new Object[]{this, activity});
        }
        b41.i(activity, "activity");
        int i = DisplayMetrics.getheightPixels(activity.getResources().getDisplayMetrics());
        int i2 = this.b;
        double d = i * 0.8d;
        if (i2 > d || i2 < 0) {
            this.b = (int) d;
        }
        PopupWindow popupWindow = new PopupWindow(this.a, -1, -1);
        this.c = popupWindow;
        if (Build.VERSION.SDK_INT > 21) {
            b41.f(popupWindow);
            popupWindow.setClippingEnabled(false);
        } else {
            b41.f(popupWindow);
            popupWindow.setHeight(i);
        }
        PopupWindow popupWindow2 = this.c;
        b41.f(popupWindow2);
        popupWindow2.setFocusable(true);
        PopupWindow popupWindow3 = this.c;
        b41.f(popupWindow3);
        popupWindow3.setBackgroundDrawable(new BitmapDrawable());
        PopupWindow popupWindow4 = this.c;
        b41.f(popupWindow4);
        popupWindow4.setOutsideTouchable(true);
        PopupWindow popupWindow5 = this.c;
        b41.f(popupWindow5);
        popupWindow5.setTouchable(true);
        if (activity.isFinishing()) {
            return this;
        }
        if (f(activity)) {
            PopupWindow popupWindow6 = this.c;
            b41.f(popupWindow6);
            popupWindow6.showAtLocation(this.a, 80, 0, Companion.a(activity));
        } else {
            PopupWindow popupWindow7 = this.c;
            b41.f(popupWindow7);
            popupWindow7.showAtLocation(this.a, 80, 0, 0);
        }
        PopupWindow popupWindow8 = this.c;
        b41.f(popupWindow8);
        popupWindow8.setAnimationStyle(R$style.bricks_pop_animation);
        return this;
    }
}
