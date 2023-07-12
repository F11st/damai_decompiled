package com.youku.live.arch.utils;

import android.app.Activity;
import android.content.Context;
import android.content.ContextWrapper;
import android.content.res.Resources;
import android.graphics.Point;
import android.os.Build;
import android.util.DisplayMetrics;
import android.view.Display;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.view.WindowManager;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import tb.C9796v;

/* compiled from: Taobao */
/* loaded from: classes2.dex */
public class ViewUtils {
    private static transient /* synthetic */ IpChange $ipChange = null;
    private static boolean mHasCheckAllScreen = false;
    private static boolean mIsAllScreenDevice = false;
    private static int sScreenHeight = -1;
    private static int sScreenWidth = -1;

    public static void addView(ViewGroup viewGroup, View view) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1341575632")) {
            ipChange.ipc$dispatch("1341575632", new Object[]{viewGroup, view});
        } else if (view == null || viewGroup == null) {
        } else {
            try {
                ViewParent parent = view.getParent();
                if (parent != null) {
                    if (parent.equals(viewGroup)) {
                        return;
                    }
                    if (parent instanceof ViewGroup) {
                        ((ViewGroup) parent).removeView(view);
                    }
                }
                viewGroup.addView(view);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:27:0x0092, code lost:
        if ("0".equals(r1) != false) goto L17;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static boolean checkNavigationBarShow(@androidx.annotation.NonNull android.content.Context r7) {
        /*
            com.android.alibaba.ip.runtime.IpChange r0 = com.youku.live.arch.utils.ViewUtils.$ipChange
            java.lang.String r1 = "-1116596609"
            boolean r2 = com.android.alibaba.ip.runtime.AndroidInstantRuntime.support(r0, r1)
            r3 = 1
            r4 = 0
            if (r2 == 0) goto L1b
            java.lang.Object[] r2 = new java.lang.Object[r3]
            r2[r4] = r7
            java.lang.Object r7 = r0.ipc$dispatch(r1, r2)
            java.lang.Boolean r7 = (java.lang.Boolean) r7
            boolean r7 = r7.booleanValue()
            return r7
        L1b:
            android.content.res.Resources r0 = r7.getResources()
            java.lang.String r1 = "config_showNavigationBar"
            java.lang.String r2 = "bool"
            java.lang.String r5 = "android"
            int r1 = r0.getIdentifier(r1, r2, r5)
            if (r1 <= 0) goto L30
            boolean r0 = r0.getBoolean(r1)
            goto L31
        L30:
            r0 = 0
        L31:
            boolean r1 = isMIUI()     // Catch: java.lang.Exception -> L99
            if (r1 == 0) goto L4a
            int r1 = android.os.Build.VERSION.SDK_INT     // Catch: java.lang.Exception -> L99
            r2 = 17
            if (r1 < r2) goto L95
            android.content.ContentResolver r7 = r7.getContentResolver()     // Catch: java.lang.Exception -> L99
            java.lang.String r1 = "force_fsg_nav_bar"
            int r7 = android.provider.Settings.Global.getInt(r7, r1, r4)     // Catch: java.lang.Exception -> L99
            if (r7 != 0) goto L97
            goto L98
        L4a:
            java.lang.String r1 = "android.os.SystemProperties"
            java.lang.Class r1 = java.lang.Class.forName(r1)     // Catch: java.lang.Exception -> L99
            java.lang.String r2 = "get"
            java.lang.Class[] r5 = new java.lang.Class[r3]     // Catch: java.lang.Exception -> L99
            java.lang.Class<java.lang.String> r6 = java.lang.String.class
            r5[r4] = r6     // Catch: java.lang.Exception -> L99
            java.lang.reflect.Method r2 = r1.getMethod(r2, r5)     // Catch: java.lang.Exception -> L99
            java.lang.Object[] r5 = new java.lang.Object[r3]     // Catch: java.lang.Exception -> L99
            java.lang.String r6 = "qemu.hw.mainkeys"
            r5[r4] = r6     // Catch: java.lang.Exception -> L99
            java.lang.Object r1 = r2.invoke(r1, r5)     // Catch: java.lang.Exception -> L99
            java.lang.String r1 = (java.lang.String) r1     // Catch: java.lang.Exception -> L99
            int r2 = android.os.Build.VERSION.SDK_INT     // Catch: java.lang.Exception -> L99
            r5 = 21
            java.lang.String r6 = "navigationbar_is_min"
            if (r2 >= r5) goto L79
            android.content.ContentResolver r7 = r7.getContentResolver()     // Catch: java.lang.Exception -> L99
            int r7 = android.provider.Settings.System.getInt(r7, r6, r4)     // Catch: java.lang.Exception -> L99
            goto L81
        L79:
            android.content.ContentResolver r7 = r7.getContentResolver()     // Catch: java.lang.Exception -> L99
            int r7 = android.provider.Settings.Global.getInt(r7, r6, r4)     // Catch: java.lang.Exception -> L99
        L81:
            java.lang.String r2 = "1"
            boolean r2 = r2.equals(r1)     // Catch: java.lang.Exception -> L99
            if (r2 != 0) goto L97
            if (r3 != r7) goto L8c
            goto L97
        L8c:
            java.lang.String r7 = "0"
            boolean r7 = r7.equals(r1)     // Catch: java.lang.Exception -> L99
            if (r7 == 0) goto L95
            goto L98
        L95:
            r3 = r0
            goto L98
        L97:
            r3 = 0
        L98:
            r0 = r3
        L99:
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.youku.live.arch.utils.ViewUtils.checkNavigationBarShow(android.content.Context):boolean");
    }

    public static void forceActivityOrientationLandscape(Activity activity) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-561004202")) {
            ipChange.ipc$dispatch("-561004202", new Object[]{activity});
        } else if (activity != null) {
            activity.setRequestedOrientation(0);
        }
    }

    public static void forceActivityOrientationPortrait(Activity activity) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "661944802")) {
            ipChange.ipc$dispatch("661944802", new Object[]{activity});
        } else if (activity != null) {
            activity.setRequestedOrientation(1);
        }
    }

    public static void forceActivityOrientationSensor(Activity activity) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "830341155")) {
            ipChange.ipc$dispatch("830341155", new Object[]{activity});
        } else if (activity != null) {
            activity.setRequestedOrientation(4);
        }
    }

    public static void forceActivityOrientationSensorLandscape(Activity activity) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1941767376")) {
            ipChange.ipc$dispatch("-1941767376", new Object[]{activity});
        } else if (activity != null) {
            activity.setRequestedOrientation(6);
        }
    }

    public static Activity getActivity(Context context) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-2014803612")) {
            return (Activity) ipChange.ipc$dispatch("-2014803612", new Object[]{context});
        }
        if (context != null && (context instanceof ContextWrapper)) {
            if (context instanceof Activity) {
                return (Activity) context;
            }
            return getActivity(((ContextWrapper) context).getBaseContext());
        }
        return null;
    }

    public static int getDpi(Context context) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-133667519")) {
            return ((Integer) ipChange.ipc$dispatch("-133667519", new Object[]{context})).intValue();
        }
        Display defaultDisplay = ((WindowManager) context.getSystemService(C9796v.ATTACH_MODE_WINDOW)).getDefaultDisplay();
        DisplayMetrics displayMetrics = new DisplayMetrics();
        try {
            Class.forName("android.view.Display").getMethod("getRealMetrics", DisplayMetrics.class).invoke(defaultDisplay, displayMetrics);
            return com.alibaba.wireless.security.aopsdk.replace.android.util.DisplayMetrics.getheightPixels(displayMetrics);
        } catch (Exception e) {
            e.printStackTrace();
            return 0;
        }
    }

    public static int getNavigationBarHeight(Context context) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "592099274")) {
            return ((Integer) ipChange.ipc$dispatch("592099274", new Object[]{context})).intValue();
        }
        if (checkNavigationBarShow(context)) {
            return getDpi(context) - getScreenHeight(context);
        }
        return 0;
    }

    /* JADX WARN: Removed duplicated region for block: B:18:0x0063  */
    /* JADX WARN: Removed duplicated region for block: B:19:0x0065  */
    /* JADX WARN: Removed duplicated region for block: B:23:0x006b  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static int[] getScreenConfig(android.content.Context r7) {
        /*
            com.android.alibaba.ip.runtime.IpChange r0 = com.youku.live.arch.utils.ViewUtils.$ipChange
            java.lang.String r1 = "1843423041"
            boolean r2 = com.android.alibaba.ip.runtime.AndroidInstantRuntime.support(r0, r1)
            r3 = 1
            r4 = 0
            if (r2 == 0) goto L17
            java.lang.Object[] r2 = new java.lang.Object[r3]
            r2[r4] = r7
            java.lang.Object r7 = r0.ipc$dispatch(r1, r2)
            int[] r7 = (int[]) r7
            return r7
        L17:
            android.util.DisplayMetrics r0 = new android.util.DisplayMetrics
            r0.<init>()
            java.lang.String r1 = "window"
            java.lang.Object r7 = r7.getSystemService(r1)
            android.view.WindowManager r7 = (android.view.WindowManager) r7
            android.view.Display r7 = r7.getDefaultDisplay()
            com.alibaba.wireless.security.aopsdk.replace.android.view.Display.getMetrics(r7, r0)
            int r1 = com.alibaba.wireless.security.aopsdk.replace.android.util.DisplayMetrics.getwidthPixels(r0)
            int r0 = com.alibaba.wireless.security.aopsdk.replace.android.util.DisplayMetrics.getheightPixels(r0)
            int r2 = android.os.Build.VERSION.SDK_INT
            r5 = 21
            if (r2 >= r5) goto L3b
        L39:
            r7 = 0
            goto L5e
        L3b:
            android.graphics.Point r2 = new android.graphics.Point
            r2.<init>()
            com.alibaba.wireless.security.aopsdk.replace.android.view.Display.getRealSize(r7, r2)
            int r7 = com.alibaba.wireless.security.aopsdk.replace.android.graphics.Point.getx(r2)
            int r2 = com.alibaba.wireless.security.aopsdk.replace.android.graphics.Point.gety(r2)
            if (r7 >= r2) goto L50
            float r7 = (float) r7
            float r2 = (float) r2
            goto L55
        L50:
            float r2 = (float) r2
            float r7 = (float) r7
            r6 = r2
            r2 = r7
            r7 = r6
        L55:
            float r2 = r2 / r7
            r7 = 1073490166(0x3ffc28f6, float:1.97)
            int r7 = (r2 > r7 ? 1 : (r2 == r7 ? 0 : -1))
            if (r7 < 0) goto L39
            r7 = 1
        L5e:
            r2 = 3
            int[] r2 = new int[r2]
            if (r1 < r0) goto L65
            r5 = r1
            goto L66
        L65:
            r5 = r0
        L66:
            r2[r4] = r5
            if (r1 >= r0) goto L6b
            goto L6c
        L6b:
            r1 = r0
        L6c:
            r2[r3] = r1
            r0 = 2
            r2[r0] = r7
            return r2
        */
        throw new UnsupportedOperationException("Method not decompiled: com.youku.live.arch.utils.ViewUtils.getScreenConfig(android.content.Context):int[]");
    }

    public static int getScreenHeight(Context context) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1928999333")) {
            return ((Integer) ipChange.ipc$dispatch("-1928999333", new Object[]{context})).intValue();
        }
        if (sScreenHeight < 0) {
            Resources resources = context.getResources();
            sScreenWidth = com.alibaba.wireless.security.aopsdk.replace.android.util.DisplayMetrics.getwidthPixels(resources.getDisplayMetrics());
            int i = com.alibaba.wireless.security.aopsdk.replace.android.util.DisplayMetrics.getheightPixels(resources.getDisplayMetrics());
            sScreenHeight = i;
            int i2 = sScreenWidth;
            if (i > i2) {
                i = i2;
            }
            sScreenWidth = i;
        }
        return sScreenHeight;
    }

    public static int getScreenWidth(Context context) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1947278050")) {
            return ((Integer) ipChange.ipc$dispatch("-1947278050", new Object[]{context})).intValue();
        }
        if (sScreenWidth < 0) {
            Resources resources = context.getResources();
            sScreenWidth = com.alibaba.wireless.security.aopsdk.replace.android.util.DisplayMetrics.getwidthPixels(resources.getDisplayMetrics());
            int i = com.alibaba.wireless.security.aopsdk.replace.android.util.DisplayMetrics.getheightPixels(resources.getDisplayMetrics());
            sScreenHeight = i;
            int i2 = sScreenWidth;
            if (i > i2) {
                i = i2;
            }
            sScreenWidth = i;
        }
        return sScreenWidth;
    }

    public static boolean isAllScreenDevice(Activity activity) {
        float f;
        float f2;
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1598035642")) {
            return ((Boolean) ipChange.ipc$dispatch("-1598035642", new Object[]{activity})).booleanValue();
        }
        if (mHasCheckAllScreen) {
            return mIsAllScreenDevice;
        }
        mHasCheckAllScreen = true;
        mIsAllScreenDevice = false;
        if (Build.VERSION.SDK_INT < 21) {
            return false;
        }
        WindowManager windowManager = (WindowManager) activity.getSystemService(C9796v.ATTACH_MODE_WINDOW);
        if (windowManager != null) {
            Display defaultDisplay = windowManager.getDefaultDisplay();
            Point point = new Point();
            com.alibaba.wireless.security.aopsdk.replace.android.view.Display.getRealSize(defaultDisplay, point);
            int xVar = com.alibaba.wireless.security.aopsdk.replace.android.graphics.Point.getx(point);
            int yVar = com.alibaba.wireless.security.aopsdk.replace.android.graphics.Point.gety(point);
            if (xVar < yVar) {
                f2 = xVar;
                f = yVar;
            } else {
                float f3 = yVar;
                f = xVar;
                f2 = f3;
            }
            if (f / f2 >= 1.97f) {
                mIsAllScreenDevice = true;
            }
        }
        return mIsAllScreenDevice;
    }

    public static boolean isMIUI() {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "31353771") ? ((Boolean) ipChange.ipc$dispatch("31353771", new Object[0])).booleanValue() : "xiaomi".equalsIgnoreCase(com.alibaba.wireless.security.aopsdk.replace.android.os.Build.getMANUFACTURER());
    }

    public static void removeFromParent(View view) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "170815881")) {
            ipChange.ipc$dispatch("170815881", new Object[]{view});
        } else if (view != null) {
            try {
                ViewParent parent = view.getParent();
                if (parent instanceof ViewGroup) {
                    ((ViewGroup) parent).removeView(view);
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    public static void setFullScreen(Activity activity) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1865291394")) {
            ipChange.ipc$dispatch("-1865291394", new Object[]{activity});
        } else if (activity == null) {
        } else {
            View decorView = activity.getWindow().getDecorView();
            int i = Build.VERSION.SDK_INT;
            if (i >= 16 && i < 19) {
                if (decorView != null) {
                    decorView.setSystemUiVisibility(6);
                }
            } else if (i < 19 || decorView == null) {
            } else {
                decorView.setSystemUiVisibility(5894);
            }
        }
    }

    public static void setNotFullScreen(Activity activity) {
        View decorView;
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1600204935")) {
            ipChange.ipc$dispatch("1600204935", new Object[]{activity});
        } else if (activity == null || (decorView = activity.getWindow().getDecorView()) == null) {
        } else {
            decorView.setSystemUiVisibility(0);
        }
    }
}
