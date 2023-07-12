package com.alipay.camera2.util;

import android.os.Build;
import android.text.TextUtils;
import com.alipay.mobile.bqcscanservice.MPaasLogger;
import com.alipay.mobile.scan.util.BQCSystemUtil;
import java.util.HashSet;

/* compiled from: Taobao */
/* loaded from: classes12.dex */
public class Camera2WhiteList {
    private static String a;
    private static String b;
    private static HashSet<String> c;
    private static HashSet<String> d;
    private static HashSet<String> e;

    static {
        HashSet<String> hashSet = new HashSet<>();
        c = hashSet;
        hashSet.add("Xiaomi/sdm710".toLowerCase());
        c.add("Xiaomi/sdm845".toLowerCase());
        c.add("OPPO/sdm710".toLowerCase());
        c.add("OPPO/sdm845".toLowerCase());
        c.add("VIVO/mt6771".toLowerCase());
        HashSet<String> hashSet2 = new HashSet<>();
        e = hashSet2;
        hashSet2.add("HUAWEI/hi3650".toLowerCase());
        HashSet<String> hashSet3 = new HashSet<>();
        d = hashSet3;
        hashSet3.add("kirin990");
        d.add("kirin980");
        d.add("kirin970");
        d.add("kirin810");
        d.add("kirin710");
        d.add("hi6250");
        d.add("hi3660");
        d.add("hi3650");
        d.add("msmnile");
        d.add("sdm845");
        d.add("sdm710");
        d.add("trinket");
        d.add("sm6150");
        d.add("sdm660");
        d.add("msm8998");
        d.add("msm8996");
        d.add("msm8953");
        d.add("msm8937");
        d.add("lito");
        d.add("mt6785");
        d.add("mt6779");
        d.add("mt6771");
        d.add("mt6768");
        d.add("mt6765");
        d.add("mt6885");
        d.add("exynos5");
    }

    private static boolean a(String str, String str2) {
        if (e == null) {
            return false;
        }
        boolean contains = e.contains((str + "/" + str2).toLowerCase());
        MPaasLogger.d("Camera2WhiteList", new Object[]{"inFocusAreaWhiteList:", Boolean.valueOf(contains)});
        return contains;
    }

    private static boolean b(String str, String str2) {
        if (c == null) {
            return false;
        }
        boolean contains = c.contains((str + "/" + str2).toLowerCase());
        MPaasLogger.d("Camera2WhiteList", new Object[]{"inJpegStreamWhiteList:", Boolean.valueOf(contains)});
        return contains;
    }

    public static boolean forceDisableFocusAreas() {
        String manufacturer = getManufacturer();
        String cpuModel = getCpuModel();
        if (!TextUtils.isEmpty(cpuModel) && !TextUtils.isEmpty(manufacturer)) {
            return a(manufacturer, cpuModel);
        }
        MPaasLogger.w("Camera2WhiteList", new Object[]{"forceEnableJpegStream argument error, return false."});
        return false;
    }

    public static boolean forceEnableJpegStream() {
        String manufacturer = getManufacturer();
        String cpuModel = getCpuModel();
        if (!TextUtils.isEmpty(cpuModel) && !TextUtils.isEmpty(manufacturer)) {
            return b(manufacturer, cpuModel);
        }
        MPaasLogger.w("Camera2WhiteList", new Object[]{"forceEnableJpegStream argument error, return false."});
        return false;
    }

    public static String getCpuModel() {
        if (TextUtils.isEmpty(b)) {
            String reflectSystemProperties = BQCSystemUtil.reflectSystemProperties("ro.board.platform");
            b = reflectSystemProperties;
            if (reflectSystemProperties == null) {
                reflectSystemProperties = Build.HARDWARE;
            }
            b = reflectSystemProperties;
        }
        return b;
    }

    public static String getManufacturer() {
        if (TextUtils.isEmpty(a)) {
            a = com.alibaba.wireless.security.aopsdk.replace.android.os.Build.getMANUFACTURER();
        }
        return a;
    }

    public static void init() {
        getManufacturer();
        getCpuModel();
    }

    public static boolean suggestUseCamera2() {
        String cpuModel = getCpuModel();
        if (TextUtils.isEmpty(cpuModel)) {
            return false;
        }
        boolean contains = d.contains(cpuModel.toLowerCase());
        MPaasLogger.d("Camera2WhiteList", new Object[]{"suggestUseCamera2:", Boolean.valueOf(contains)});
        return contains;
    }
}
