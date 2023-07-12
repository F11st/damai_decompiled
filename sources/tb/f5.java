package tb;

import android.app.Activity;
import android.content.res.Resources;
import android.graphics.Rect;
import android.os.Build;
import android.util.DisplayMetrics;
import android.util.Log;
import android.view.Display;
import android.view.View;
import android.view.ViewTreeObserver;
import android.widget.FrameLayout;
import com.youku.arch.v3.data.Constants;

/* compiled from: Taobao */
/* loaded from: classes11.dex */
public class f5 {
    private final Activity a;
    private View b;
    private int c;
    private FrameLayout.LayoutParams d;
    private int e;

    /* compiled from: Taobao */
    /* renamed from: tb.f5$a */
    /* loaded from: classes11.dex */
    class ViewTreeObserver$OnGlobalLayoutListenerC9126a implements ViewTreeObserver.OnGlobalLayoutListener {
        final /* synthetic */ Activity a;

        ViewTreeObserver$OnGlobalLayoutListenerC9126a(Activity activity) {
            this.a = activity;
        }

        @Override // android.view.ViewTreeObserver.OnGlobalLayoutListener
        public void onGlobalLayout() {
            f5.this.g(f5.d(this.a));
        }
    }

    private f5(Activity activity) {
        this.a = activity;
        if (d(activity)) {
            this.e = activity.getResources().getDimensionPixelSize(activity.getResources().getIdentifier("status_bar_height", Constants.DIMEN, "android"));
        }
        View childAt = ((FrameLayout) activity.findViewById(16908290)).getChildAt(0);
        this.b = childAt;
        childAt.getViewTreeObserver().addOnGlobalLayoutListener(new ViewTreeObserver$OnGlobalLayoutListenerC9126a(activity));
        this.d = (FrameLayout.LayoutParams) this.b.getLayoutParams();
    }

    public static void c(Activity activity) {
        new f5(activity);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static boolean d(Activity activity) {
        boolean z;
        boolean z2 = false;
        try {
            Resources resources = activity.getResources();
            int identifier = resources.getIdentifier("config_showNavigationBar", "bool", "android");
            z = identifier > 0 ? resources.getBoolean(identifier) : false;
        } catch (Exception e) {
            e = e;
        }
        try {
            Class<?> cls = Class.forName("android.os.SystemProperties");
            String str = (String) cls.getMethod(gn1.TYPE_OPEN_URL_METHOD_GET, String.class).invoke(cls, "qemu.hw.mainkeys");
            if ("1".equals(str)) {
                return false;
            }
            if ("0".equals(str)) {
                return true;
            }
            return f(activity);
        } catch (Exception e2) {
            e = e2;
            z2 = z;
            Log.e("exception", e.getMessage());
            return z2;
        }
    }

    private int e(boolean z) {
        if (z) {
            Rect rect = new Rect();
            this.b.getWindowVisibleDisplayFrame(rect);
            int i = rect.top;
            int i2 = this.e;
            if (i < i2) {
                return rect.bottom - i2;
            }
            return rect.bottom - i;
        }
        Rect rect2 = new Rect();
        this.a.getWindow().getDecorView().getWindowVisibleDisplayFrame(rect2);
        int i3 = rect2.top;
        Rect rect3 = new Rect();
        this.b.getWindowVisibleDisplayFrame(rect3);
        if (Build.VERSION.SDK_INT >= 19) {
            return (rect3.bottom - rect3.top) + i3;
        }
        return rect3.bottom - rect3.top;
    }

    private static boolean f(Activity activity) {
        Display defaultDisplay = activity.getWindowManager().getDefaultDisplay();
        DisplayMetrics displayMetrics = new DisplayMetrics();
        if (Build.VERSION.SDK_INT >= 19) {
            com.alibaba.wireless.security.aopsdk.replace.android.view.Display.getRealMetrics(defaultDisplay, displayMetrics);
        }
        int i = com.alibaba.wireless.security.aopsdk.replace.android.util.DisplayMetrics.getheightPixels(displayMetrics);
        int i2 = com.alibaba.wireless.security.aopsdk.replace.android.util.DisplayMetrics.getwidthPixels(displayMetrics);
        DisplayMetrics displayMetrics2 = new DisplayMetrics();
        com.alibaba.wireless.security.aopsdk.replace.android.view.Display.getMetrics(defaultDisplay, displayMetrics2);
        return i2 - com.alibaba.wireless.security.aopsdk.replace.android.util.DisplayMetrics.getwidthPixels(displayMetrics2) > 0 || i - com.alibaba.wireless.security.aopsdk.replace.android.util.DisplayMetrics.getheightPixels(displayMetrics2) > 0;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void g(boolean z) {
        int height;
        int e = e(z);
        if (e != this.c) {
            if (z) {
                height = this.b.getHeight();
            } else {
                height = this.b.getRootView().getHeight();
                if (Build.VERSION.SDK_INT < 19) {
                    Rect rect = new Rect();
                    this.a.getWindow().getDecorView().getWindowVisibleDisplayFrame(rect);
                    height -= rect.top;
                }
            }
            int i = height - e;
            if (i > height / 4) {
                if (Build.VERSION.SDK_INT >= 19 && z) {
                    this.d.height = (height - i) + this.e;
                } else {
                    this.d.height = height - i;
                }
            } else if (z) {
                this.d.height = this.e + e;
            } else {
                this.d.height = height;
            }
            this.b.requestLayout();
            this.c = e;
        }
    }
}
