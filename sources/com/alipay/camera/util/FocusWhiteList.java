package com.alipay.camera.util;

import android.os.Build;
import android.text.TextUtils;
import com.alipay.mobile.bqcscanservice.BQCCameraParam;
import com.alipay.mobile.bqcscanservice.MPaasLogger;
import com.alipay.mobile.scan.util.BQCSystemUtil;
import com.taobao.alivfssdk.utils.AVFSCacheConstants;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import org.json.JSONObject;
import tb.jn1;

/* compiled from: Taobao */
/* loaded from: classes12.dex */
public class FocusWhiteList {
    public static final String TAG = "FocusWhiteList";
    private static HashSet<String> a;
    private static HashMap<String, String> b;
    public static boolean maxPictureSizeValid;
    public static boolean useNewFocusWhiteList;

    static {
        HashSet<String> hashSet = new HashSet<>();
        a = hashSet;
        hashSet.add("Xiaomi/Redmi Note 4");
        a.add("Xiaomi/Redmi Note 3");
        a.add("Xiaomi/Redmi Note 2");
        a.add("Xiaomi/Redmi 3S");
        a.add("Xiaomi/MI NOTE Pro");
        a.add("Xiaomi/MI 5");
        a.add("Xiaomi/MI 5s");
        a.add("Xiaomi/MI MAX");
        a.add("HUAWEI/HUAWEI P8max");
        a.add("HUAWEI/CUN-AL00");
        a.add("LeEco/Le X620");
        a.add("Meizu/M685C");
        a.add("Meizu/MX6");
        a.add("Meizu/m3");
        a.add("vivo/vivo Xplay6");
        a.add("vivo/vivo Y51A");
        a.add("vivo/vivo X6D");
        a.add("lge/LG-H990");
        a.add("GiONEE/GN5001S");
        a.add("GIONEE/GN5005");
        a.add("nubia/NX531J");
        b = new HashMap<>();
        b.put(BQCCameraParam.FOCUS_TYPE_WX, ";msm8996:4640*3480;msm8937:4160*3120;");
    }

    private static boolean a() {
        return (Build.VERSION.SDK_INT >= 23) && maxPictureSizeValid;
    }

    public static boolean inWhiteList() {
        if (a == null) {
            return false;
        }
        boolean z = useNewFocusWhiteList && a();
        String brand = com.alibaba.wireless.security.aopsdk.replace.android.os.Build.getBRAND();
        String model = com.alibaba.wireless.security.aopsdk.replace.android.os.Build.getMODEL();
        boolean contains = a.contains(brand + "/" + model);
        MPaasLogger.d(TAG, new Object[]{"Continue Focus Contained(", Boolean.valueOf(contains), jn1.BRACKET_END_STR});
        return contains || Build.VERSION.SDK_INT >= 25 || z;
    }

    public static String postValidFocusMode(String str) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        String reflectSystemProperties = BQCSystemUtil.reflectSystemProperties("ro.board.platform");
        if (TextUtils.isEmpty(reflectSystemProperties)) {
            return null;
        }
        for (String str2 : b.keySet()) {
            String str3 = b.get(str2);
            if (str3 != null) {
                if (str3.contains(";" + reflectSystemProperties + ":" + str)) {
                    return str2;
                }
            }
            if (str3.contains(";" + reflectSystemProperties + ":*")) {
                return str2;
            }
        }
        return null;
    }

    public static void updateDeviceFingerPrint(String str) {
        if (TextUtils.isEmpty(str)) {
            return;
        }
        try {
            JSONObject jSONObject = new JSONObject(str);
            Iterator<String> keys = jSONObject.keys();
            while (keys.hasNext()) {
                String next = keys.next();
                if (!TextUtils.isEmpty(next)) {
                    String string = jSONObject.getString(next);
                    if (TextUtils.isEmpty(string)) {
                        b.remove(next);
                    } else {
                        b.put(next, string);
                    }
                }
            }
        } catch (Exception e) {
            MPaasLogger.e(TAG, new Object[]{"updateDeviceFingerPrint: ", str, AVFSCacheConstants.COMMA_SEP}, e);
        }
    }
}
