package cn.damai.h5container;

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
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import com.youku.arch.v3.data.Constants;
import tb.gn1;

/* compiled from: Taobao */
/* loaded from: classes14.dex */
public class AndroidBug5497Workaround {
    private static transient /* synthetic */ IpChange $ipChange;
    private final Activity activity;
    private FrameLayout.LayoutParams frameLayoutParams;
    private View mChildOfContent;
    private int statusBarHeight;
    private int usableHeightPrevious;

    private AndroidBug5497Workaround(final Activity activity) {
        this.activity = activity;
        if (checkDeviceHasNavigationBar(activity)) {
            this.statusBarHeight = activity.getResources().getDimensionPixelSize(activity.getResources().getIdentifier("status_bar_height", Constants.DIMEN, "android"));
        }
        View childAt = ((FrameLayout) activity.findViewById(16908290)).getChildAt(0);
        this.mChildOfContent = childAt;
        childAt.getViewTreeObserver().addOnGlobalLayoutListener(new ViewTreeObserver.OnGlobalLayoutListener() { // from class: cn.damai.h5container.AndroidBug5497Workaround.1
            private static transient /* synthetic */ IpChange $ipChange;

            @Override // android.view.ViewTreeObserver.OnGlobalLayoutListener
            public void onGlobalLayout() {
                IpChange ipChange = $ipChange;
                if (AndroidInstantRuntime.support(ipChange, "759213108")) {
                    ipChange.ipc$dispatch("759213108", new Object[]{this});
                } else {
                    AndroidBug5497Workaround.this.possiblyResizeChildOfContent(AndroidBug5497Workaround.checkDeviceHasNavigationBar(activity));
                }
            }
        });
        this.frameLayoutParams = (FrameLayout.LayoutParams) this.mChildOfContent.getLayoutParams();
    }

    public static void assistActivity(Activity activity) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "818805709")) {
            ipChange.ipc$dispatch("818805709", new Object[]{activity});
        } else {
            new AndroidBug5497Workaround(activity);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static boolean checkDeviceHasNavigationBar(Activity activity) {
        IpChange ipChange = $ipChange;
        boolean z = false;
        if (AndroidInstantRuntime.support(ipChange, "-1500348342")) {
            return ((Boolean) ipChange.ipc$dispatch("-1500348342", new Object[]{activity})).booleanValue();
        }
        try {
            Resources resources = activity.getResources();
            int identifier = resources.getIdentifier("config_showNavigationBar", "bool", "android");
            boolean z2 = identifier > 0 ? resources.getBoolean(identifier) : false;
            try {
                Class<?> cls = Class.forName("android.os.SystemProperties");
                String str = (String) cls.getMethod(gn1.TYPE_OPEN_URL_METHOD_GET, String.class).invoke(cls, "qemu.hw.mainkeys");
                if ("1".equals(str)) {
                    return false;
                }
                if ("0".equals(str)) {
                    return true;
                }
                return hasNavBar(activity);
            } catch (Exception e) {
                e = e;
                z = z2;
                Log.e("exception", e.getMessage());
                return z;
            }
        } catch (Exception e2) {
            e = e2;
        }
    }

    private int computeUsableHeight(boolean z) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-23038618")) {
            return ((Integer) ipChange.ipc$dispatch("-23038618", new Object[]{this, Boolean.valueOf(z)})).intValue();
        }
        if (z) {
            Rect rect = new Rect();
            this.mChildOfContent.getWindowVisibleDisplayFrame(rect);
            int i = rect.top;
            int i2 = this.statusBarHeight;
            if (i < i2) {
                return rect.bottom - i2;
            }
            return rect.bottom - i;
        }
        Rect rect2 = new Rect();
        this.activity.getWindow().getDecorView().getWindowVisibleDisplayFrame(rect2);
        int i3 = rect2.top;
        Rect rect3 = new Rect();
        this.mChildOfContent.getWindowVisibleDisplayFrame(rect3);
        if (Build.VERSION.SDK_INT >= 19) {
            return (rect3.bottom - rect3.top) + i3;
        }
        return rect3.bottom - rect3.top;
    }

    private static boolean hasNavBar(Activity activity) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "2030383619")) {
            return ((Boolean) ipChange.ipc$dispatch("2030383619", new Object[]{activity})).booleanValue();
        }
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
    public void possiblyResizeChildOfContent(boolean z) {
        int height;
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-138074176")) {
            ipChange.ipc$dispatch("-138074176", new Object[]{this, Boolean.valueOf(z)});
            return;
        }
        int computeUsableHeight = computeUsableHeight(z);
        if (computeUsableHeight != this.usableHeightPrevious) {
            if (z) {
                height = this.mChildOfContent.getHeight();
            } else {
                height = this.mChildOfContent.getRootView().getHeight();
                if (Build.VERSION.SDK_INT < 19) {
                    Rect rect = new Rect();
                    this.activity.getWindow().getDecorView().getWindowVisibleDisplayFrame(rect);
                    height -= rect.top;
                }
            }
            int i = height - computeUsableHeight;
            if (i > height / 4) {
                if (Build.VERSION.SDK_INT >= 19 && z) {
                    this.frameLayoutParams.height = (height - i) + this.statusBarHeight;
                } else {
                    this.frameLayoutParams.height = height - i;
                }
            } else if (z) {
                this.frameLayoutParams.height = this.statusBarHeight + computeUsableHeight;
            } else {
                this.frameLayoutParams.height = height;
            }
            this.mChildOfContent.requestLayout();
            this.usableHeightPrevious = computeUsableHeight;
        }
    }
}
