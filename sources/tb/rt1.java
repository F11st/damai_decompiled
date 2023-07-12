package tb;

import android.app.Activity;
import android.content.res.Resources;
import android.graphics.Point;
import android.graphics.drawable.BitmapDrawable;
import android.os.Build;
import android.view.View;
import android.view.WindowManager;
import android.widget.PopupWindow;
import cn.damai.commonbusiness.R$style;
import com.alibaba.wireless.security.aopsdk.replace.android.util.DisplayMetrics;
import com.alibaba.wireless.security.aopsdk.replace.android.view.Display;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import com.youku.arch.v3.data.Constants;

/* compiled from: Taobao */
/* loaded from: classes7.dex */
public class rt1 {
    private static transient /* synthetic */ IpChange $ipChange;
    private View a;
    private int b;
    private PopupWindow c;

    public rt1(View view, int i) {
        this.a = view;
        this.b = i;
    }

    public static int b(Activity activity) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-301321258")) {
            return ((Integer) ipChange.ipc$dispatch("-301321258", new Object[]{activity})).intValue();
        }
        try {
            Resources resources = activity.getResources();
            return resources.getDimensionPixelSize(resources.getIdentifier("navigation_bar_height", Constants.DIMEN, "android"));
        } catch (Exception e) {
            e.printStackTrace();
            return 0;
        }
    }

    public int a() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1793172465")) {
            return ((Integer) ipChange.ipc$dispatch("-1793172465", new Object[]{this})).intValue();
        }
        Resources system = Resources.getSystem();
        int identifier = system.getIdentifier("navigation_bar_height", Constants.DIMEN, "android");
        if (identifier != 0) {
            return system.getDimensionPixelSize(identifier);
        }
        return 0;
    }

    public PopupWindow c() {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "776960665") ? (PopupWindow) ipChange.ipc$dispatch("776960665", new Object[]{this}) : this.c;
    }

    public int d(Activity activity) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "2134393459")) {
            return ((Integer) ipChange.ipc$dispatch("2134393459", new Object[]{this, activity})).intValue();
        }
        WindowManager windowManager = (WindowManager) activity.getSystemService(C9796v.ATTACH_MODE_WINDOW);
        Point point = new Point();
        if (Build.VERSION.SDK_INT >= 17) {
            Display.getRealSize(windowManager.getDefaultDisplay(), point);
        }
        return com.alibaba.wireless.security.aopsdk.replace.android.graphics.Point.gety(point);
    }

    public int e() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1656866526")) {
            return ((Integer) ipChange.ipc$dispatch("-1656866526", new Object[]{this})).intValue();
        }
        Resources system = Resources.getSystem();
        return system.getDimensionPixelSize(system.getIdentifier("status_bar_height", Constants.DIMEN, "android"));
    }

    public int f() {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "-1443593438") ? ((Integer) ipChange.ipc$dispatch("-1443593438", new Object[]{this})).intValue() : this.b;
    }

    public rt1 g(Activity activity) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-2067241378")) {
            return (rt1) ipChange.ipc$dispatch("-2067241378", new Object[]{this, activity});
        }
        int i = DisplayMetrics.getheightPixels(activity.getResources().getDisplayMetrics());
        double d = i * 0.8d;
        if (this.b > d) {
            this.b = (int) d;
        }
        PopupWindow popupWindow = new PopupWindow(this.a, -1, -1);
        this.c = popupWindow;
        if (Build.VERSION.SDK_INT > 21) {
            popupWindow.setClippingEnabled(false);
        } else {
            popupWindow.setHeight(i);
        }
        this.c.setFocusable(true);
        this.c.setBackgroundDrawable(new BitmapDrawable());
        this.c.setOutsideTouchable(true);
        this.c.setTouchable(true);
        if (activity.isFinishing()) {
            return this;
        }
        if (h(activity)) {
            this.c.showAtLocation(this.a, 80, 0, b(activity));
        } else {
            this.c.showAtLocation(this.a, 80, 0, 0);
        }
        this.c.setAnimationStyle(R$style.pop_animation);
        return this;
    }

    /* JADX WARN: Removed duplicated region for block: B:20:0x004f A[ORIG_RETURN, RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:31:? A[RETURN, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public boolean h(android.app.Activity r6) {
        /*
            r5 = this;
            com.android.alibaba.ip.runtime.IpChange r0 = tb.rt1.$ipChange
            java.lang.String r1 = "2095709901"
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
            int r6 = r5.d(r6)     // Catch: java.lang.Exception -> L44
            int r1 = r5.e()     // Catch: java.lang.Exception -> L44
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
        throw new UnsupportedOperationException("Method not decompiled: tb.rt1.h(android.app.Activity):boolean");
    }
}
