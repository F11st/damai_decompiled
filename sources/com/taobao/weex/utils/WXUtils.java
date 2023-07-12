package com.taobao.weex.utils;

import android.app.ActivityManager;
import android.content.Context;
import android.os.Looper;
import android.os.SystemClock;
import android.text.TextUtils;
import androidx.annotation.Nullable;
import androidx.collection.LruCache;
import com.alipay.mobile.bqcscanservice.BQCCameraParam;
import com.taobao.uikit.feature.features.FeatureFactory;
import com.taobao.weex.WXEnvironment;
import com.taobao.weex.WXSDKManager;
import com.taobao.weex.adapter.IWXConfigAdapter;
import com.taobao.weex.common.Constants;
import org.apache.commons.lang3.StringUtils;
import org.apache.commons.net.SocketClient;

/* compiled from: Taobao */
/* loaded from: classes11.dex */
public class WXUtils {
    public static final char PERCENT = '%';
    static final LruCache<String, Integer> a = new LruCache<>(64);
    private static final long b = System.currentTimeMillis() - SystemClock.uptimeMillis();

    private static int a(String str, int i) {
        int indexOf = str.indexOf(StringUtils.CR, i);
        if (indexOf == -1) {
            indexOf = str.indexOf(StringUtils.LF, i);
        }
        return indexOf == -1 ? str.indexOf(SocketClient.NETASCII_EOL, i) : indexOf;
    }

    private static int b(String str, int i) {
        return (int) ((Float.parseFloat(str) / 100.0f) * i);
    }

    private static String[] c(String str) {
        String[] split = str.split(StringUtils.CR);
        if (split.length == 1) {
            split = str.split(StringUtils.LF);
        }
        return split.length == 1 ? str.split(SocketClient.NETASCII_EOL) : split;
    }

    public static boolean checkGreyConfig(String str, String str2, String str3) {
        IWXConfigAdapter J = WXSDKManager.v().J();
        if (J == null) {
            return false;
        }
        double d = 100.0d;
        double random = Math.random() * 100.0d;
        try {
            d = Double.valueOf(J.getConfig(str, str2, str3)).doubleValue();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return random < d;
    }

    private static float d(String str, int i) {
        if (str == null) {
            return 0.0f;
        }
        if (str.endsWith(BQCCameraParam.FOCUS_TYPE_WX)) {
            str = str.substring(0, str.indexOf(BQCCameraParam.FOCUS_TYPE_WX));
        }
        return ((WXEnvironment.sApplication.getResources().getDisplayMetrics().density * Float.valueOf(Float.parseFloat(str)).floatValue()) * i) / WXViewUtils.getScreenWidth();
    }

    /* JADX WARN: Code restructure failed: missing block: B:32:0x0074, code lost:
        return r1 * (-1.0f);
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static float fastGetFloat(java.lang.String r10, int r11) {
        /*
            boolean r0 = android.text.TextUtils.isEmpty(r10)
            r1 = 0
            if (r0 != 0) goto L74
            r0 = 0
            char r2 = r10.charAt(r0)
            r3 = 45
            r4 = 1
            if (r2 != r3) goto L14
            r2 = 1
            r3 = 0
            goto L20
        L14:
            char r2 = r10.charAt(r0)
            r3 = 43
            if (r2 != r3) goto L1e
            r2 = 1
            goto L1f
        L1e:
            r2 = 0
        L1f:
            r3 = 1
        L20:
            int r5 = r10.length()
            r6 = 57
            r7 = 48
            if (r2 >= r5) goto L3e
            char r5 = r10.charAt(r2)
            if (r5 < r7) goto L3e
            if (r5 > r6) goto L3e
            r6 = 1092616192(0x41200000, float:10.0)
            float r1 = r1 * r6
            float r5 = (float) r5
            float r1 = r1 + r5
            r5 = 1111490560(0x42400000, float:48.0)
            float r1 = r1 - r5
            int r2 = r2 + 1
            goto L20
        L3e:
            int r5 = r10.length()
            if (r2 >= r5) goto L6e
            char r5 = r10.charAt(r2)
            r8 = 46
            if (r5 != r8) goto L6e
            int r2 = r2 + r4
            r4 = 10
            r5 = 10
        L51:
            int r8 = r10.length()
            if (r2 >= r8) goto L6e
            if (r0 >= r11) goto L6e
            char r8 = r10.charAt(r2)
            if (r8 < r7) goto L6e
            if (r8 > r6) goto L6e
            int r8 = r8 + (-48)
            float r8 = (float) r8
            float r9 = (float) r5
            float r8 = r8 / r9
            float r1 = r1 + r8
            int r5 = r5 * 10
            int r2 = r2 + 1
            int r0 = r0 + 1
            goto L51
        L6e:
            if (r3 != 0) goto L74
            r10 = -1082130432(0xffffffffbf800000, float:-1.0)
            float r1 = r1 * r10
        L74:
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.taobao.weex.utils.WXUtils.fastGetFloat(java.lang.String, int):float");
    }

    public static long getAvailMemory(Context context) {
        ActivityManager.MemoryInfo memoryInfo = new ActivityManager.MemoryInfo();
        ((ActivityManager) context.getSystemService("activity")).getMemoryInfo(memoryInfo);
        WXLogUtils.w("app AvailMemory ---->>>" + (memoryInfo.availMem / 1048576));
        return memoryInfo.availMem / 1048576;
    }

    public static Boolean getBoolean(@Nullable Object obj, @Nullable Boolean bool) {
        if (obj == null) {
            return bool;
        }
        if (TextUtils.equals("false", obj.toString())) {
            return Boolean.FALSE;
        }
        return TextUtils.equals("true", obj.toString()) ? Boolean.TRUE : bool;
    }

    public static String getBundleBanner(String str) {
        int i;
        int a2;
        int indexOf = str.indexOf("/*!");
        if (indexOf == -1 || (a2 = a(str, (i = indexOf + 3))) == -1) {
            return null;
        }
        int i2 = a2 + 1;
        String substring = str.substring(i2, Integer.parseInt(str.substring(i, a2)) + i2);
        int lastIndexOf = substring.lastIndexOf("!*/");
        if (lastIndexOf == -1) {
            return null;
        }
        String substring2 = substring.substring(0, lastIndexOf);
        StringBuilder sb = new StringBuilder();
        for (String str2 : c(substring2)) {
            sb.append(str2.replaceFirst("\\*", ""));
        }
        return sb.toString();
    }

    @Deprecated
    public static double getDouble(Object obj) {
        if (obj == null) {
            return 0.0d;
        }
        String trim = obj.toString().trim();
        if (trim.endsWith(BQCCameraParam.FOCUS_TYPE_WX)) {
            if (WXEnvironment.isApkDebugable()) {
                WXLogUtils.w("the value of " + obj + " use wx unit, which will be not supported soon after.");
            }
            try {
                return d(trim, FeatureFactory.PRIORITY_ABOVE_NORMAL);
            } catch (NumberFormatException e) {
                WXLogUtils.e("Argument format error! value is " + obj, e);
            } catch (Exception e2) {
                WXLogUtils.e("Argument error! value is " + obj, e2);
            }
        } else if (trim.endsWith("px")) {
            try {
                return Double.parseDouble(trim.substring(0, trim.indexOf("px")));
            } catch (NumberFormatException e3) {
                WXLogUtils.e("Argument format error! value is " + obj, e3);
            } catch (Exception e4) {
                WXLogUtils.e("Argument error! value is " + obj, e4);
            }
        } else {
            try {
                return Double.parseDouble(trim);
            } catch (NumberFormatException e5) {
                WXLogUtils.e("Argument format error! value is " + obj, e5);
            } catch (Exception e6) {
                WXLogUtils.e("Argument error! value is " + obj, e6);
            }
        }
        return 0.0d;
    }

    public static long getFixUnixTime() {
        return b + SystemClock.uptimeMillis();
    }

    public static float getFloat(Object obj) {
        return getFloat(obj, Float.valueOf(Float.NaN)).floatValue();
    }

    public static float getFloatByViewport(Object obj, int i) {
        if (obj == null) {
            return Float.NaN;
        }
        String trim = obj.toString().trim();
        if (!"auto".equals(trim) && !Constants.Name.UNDEFINED.equals(trim) && !TextUtils.isEmpty(trim)) {
            if (trim.endsWith(BQCCameraParam.FOCUS_TYPE_WX)) {
                try {
                    return d(trim, i);
                } catch (NumberFormatException e) {
                    WXLogUtils.e("Argument format error! value is " + obj, e);
                } catch (Exception e2) {
                    WXLogUtils.e("Argument error! value is " + obj, e2);
                }
            } else if (trim.endsWith("px")) {
                try {
                    return Float.parseFloat(trim.substring(0, trim.indexOf("px")));
                } catch (NumberFormatException e3) {
                    WXLogUtils.e("Argument format error! value is " + obj, e3);
                } catch (Exception e4) {
                    WXLogUtils.e("Argument error! value is " + obj, e4);
                }
            } else {
                try {
                    return Float.parseFloat(trim);
                } catch (NumberFormatException e5) {
                    WXLogUtils.e("Argument format error! value is " + obj, e5);
                } catch (Exception e6) {
                    WXLogUtils.e("Argument error! value is " + obj, e6);
                }
            }
            return Float.NaN;
        }
        WXLogUtils.e("Argument Warning ! value is " + trim + "And default Value:NaN");
        return Float.NaN;
    }

    public static int getInt(Object obj) {
        return getInteger(obj, 0).intValue();
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r7v10 */
    /* JADX WARN: Type inference failed for: r7v12 */
    /* JADX WARN: Type inference failed for: r7v18, types: [java.lang.Integer] */
    /* JADX WARN: Type inference failed for: r7v19 */
    /* JADX WARN: Type inference failed for: r7v20 */
    @Nullable
    public static Integer getInteger(@Nullable Object obj, @Nullable Integer num) {
        if (obj == null) {
            return num;
        }
        String trim = obj.toString().trim();
        Integer num2 = a.get(trim);
        if (num2 != null) {
            return num2;
        }
        String substring = trim.length() >= 2 ? trim.substring(trim.length() - 2, trim.length()) : "";
        if (TextUtils.equals(BQCCameraParam.FOCUS_TYPE_WX, substring)) {
            if (WXEnvironment.isApkDebugable()) {
                WXLogUtils.w("the value of " + obj + " use wx unit, which will be not supported soon after.");
            }
            try {
                obj = Integer.valueOf((int) d(trim, FeatureFactory.PRIORITY_ABOVE_NORMAL));
            } catch (NumberFormatException e) {
                WXLogUtils.e("Argument format error! value is " + obj, e);
            } catch (Exception e2) {
                WXLogUtils.e("Argument error! value is " + obj, e2);
            }
        } else if (TextUtils.equals("px", substring)) {
            try {
                String substring2 = trim.substring(0, trim.length() - 2);
                if (!TextUtils.isEmpty(substring2) && substring2.contains(".")) {
                    obj = Integer.valueOf((int) parseFloat(substring2));
                } else {
                    obj = Integer.valueOf(Integer.parseInt(substring2));
                }
            } catch (NumberFormatException e3) {
                WXLogUtils.e("Argument format error! value is " + obj, e3);
            } catch (Exception e4) {
                WXLogUtils.e("Argument error! value is " + obj, e4);
            }
        } else {
            try {
            } catch (NumberFormatException e5) {
                if (WXEnvironment.isApkDebugable()) {
                    WXLogUtils.w("The parameter format is not supported", e5);
                }
            } catch (Exception e6) {
                WXLogUtils.e("Argument error! value is " + obj, e6);
            }
            if (!TextUtils.isEmpty(trim)) {
                if (trim.contains(".")) {
                    obj = Integer.valueOf((int) parseFloat(trim));
                } else {
                    obj = Integer.valueOf(Integer.parseInt(trim));
                }
            } else {
                if (WXEnvironment.isApkDebugable()) {
                    WXLogUtils.e("Argument value is null, df is" + num);
                }
                obj = num;
            }
        }
        if (obj != null && !obj.equals(num)) {
            a.put(trim, obj);
        }
        return obj;
    }

    @Deprecated
    public static long getLong(Object obj) {
        if (obj == null) {
            return 0L;
        }
        String trim = obj.toString().trim();
        if (trim.endsWith(BQCCameraParam.FOCUS_TYPE_WX)) {
            if (WXEnvironment.isApkDebugable()) {
                WXLogUtils.w("the value of " + obj + " use wx unit, which will be not supported soon after.");
            }
            try {
                return d(trim, FeatureFactory.PRIORITY_ABOVE_NORMAL);
            } catch (NumberFormatException e) {
                WXLogUtils.e("Argument format error! value is " + obj, e);
            } catch (Exception e2) {
                WXLogUtils.e("Argument error! value is " + obj, e2);
            }
        } else if (trim.endsWith("px")) {
            try {
                return Long.parseLong(trim.substring(0, trim.indexOf("px")));
            } catch (NumberFormatException e3) {
                WXLogUtils.e("Argument format error! value is " + obj, e3);
            } catch (Exception e4) {
                WXLogUtils.e("Argument error! value is " + obj, e4);
            }
        } else {
            try {
                return Long.parseLong(trim);
            } catch (NumberFormatException e5) {
                WXLogUtils.e("Argument format error! value is " + obj, e5);
            } catch (Exception e6) {
                WXLogUtils.e("Argument error! value is " + obj, e6);
            }
        }
        return 0L;
    }

    public static int getNumberInt(Object obj, int i) {
        if (obj == null) {
            return i;
        }
        if (obj instanceof Number) {
            return ((Number) obj).intValue();
        }
        try {
            String obj2 = obj.toString();
            if (obj2.indexOf(46) >= 0) {
                return (int) Float.parseFloat(obj.toString());
            }
            return Integer.parseInt(obj2);
        } catch (Exception unused) {
            return i;
        }
    }

    public static String getString(@Nullable Object obj, @Nullable String str) {
        if (obj == null) {
            return str;
        }
        if (obj instanceof String) {
            return (String) obj;
        }
        return obj.toString();
    }

    @Deprecated
    public static boolean isTabletDevice() {
        try {
            return (WXEnvironment.getApplication().getResources().getConfiguration().screenLayout & 15) >= 3;
        } catch (Exception unused) {
            return false;
        }
    }

    public static boolean isUiThread() {
        return Thread.currentThread().getId() == Looper.getMainLooper().getThread().getId();
    }

    public static boolean isUndefined(float f) {
        return Float.isNaN(f);
    }

    public static float parseFloat(Object obj) {
        return parseFloat(String.valueOf(obj));
    }

    public static int parseInt(String str) {
        try {
            if (TextUtils.isEmpty(str) || str.contains(".")) {
                return 0;
            }
            return Integer.parseInt(str);
        } catch (NumberFormatException e) {
            if (WXEnvironment.isApkDebugable()) {
                WXLogUtils.e(WXLogUtils.getStackTrace(e));
                return 0;
            }
            return 0;
        }
    }

    public static int parseUnitOrPercent(String str, int i) {
        int lastIndexOf = str.lastIndexOf(37);
        if (lastIndexOf != -1) {
            return b(str.substring(0, lastIndexOf), i);
        }
        return parseInt(str);
    }

    public static Float getFloat(Object obj, @Nullable Float f) {
        if (obj == null) {
            return f;
        }
        String trim = obj.toString().trim();
        if (!"auto".equals(trim) && !Constants.Name.UNDEFINED.equals(trim) && !TextUtils.isEmpty(trim)) {
            if (trim.endsWith(BQCCameraParam.FOCUS_TYPE_WX)) {
                try {
                    return Float.valueOf(d(trim, FeatureFactory.PRIORITY_ABOVE_NORMAL));
                } catch (NumberFormatException e) {
                    WXLogUtils.e("Argument format error! value is " + obj, e);
                } catch (Exception e2) {
                    WXLogUtils.e("Argument error! value is " + obj, e2);
                }
            } else if (trim.endsWith("px")) {
                try {
                    return Float.valueOf(Float.parseFloat(trim.substring(0, trim.indexOf("px"))));
                } catch (NumberFormatException e3) {
                    WXLogUtils.e("Argument format error! value is " + obj, e3);
                } catch (Exception e4) {
                    WXLogUtils.e("Argument error! value is " + obj, e4);
                }
            } else {
                try {
                    return Float.valueOf(Float.parseFloat(trim));
                } catch (NumberFormatException e5) {
                    WXLogUtils.e("Argument format error! value is " + obj, e5);
                } catch (Exception e6) {
                    WXLogUtils.e("Argument error! value is " + obj, e6);
                }
            }
            return f;
        }
        WXLogUtils.e("Argument Warning ! value is " + trim + "And default Value:NaN");
        return f;
    }

    public static float parseFloat(String str) {
        try {
            if (!TextUtils.isEmpty(str) && !TextUtils.equals(str, "null")) {
                return Float.parseFloat(str);
            }
            if (WXEnvironment.isApkDebugable()) {
                WXLogUtils.e("WXUtils parseFloat illegal value is " + str);
                return 0.0f;
            }
            return 0.0f;
        } catch (NumberFormatException e) {
            if (WXEnvironment.isApkDebugable()) {
                WXLogUtils.e(WXLogUtils.getStackTrace(e));
                return 0.0f;
            }
            return 0.0f;
        }
    }

    public static int parseInt(Object obj) {
        return parseInt(String.valueOf(obj));
    }

    public static float fastGetFloat(String str) {
        return fastGetFloat(str, Integer.MAX_VALUE);
    }
}
