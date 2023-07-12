package com.ali.user.mobile.utils;

import android.content.Context;
import android.content.pm.PackageInfo;
import android.os.Bundle;
import android.text.TextUtils;
import com.alibaba.fastjson.JSONException;
import com.alibaba.fastjson.JSONObject;
import java.util.List;

/* compiled from: Taobao */
/* loaded from: classes17.dex */
public class BundleUtil {
    public static final String TAG = "login.BundleUitl";
    private static List<PackageInfo> sPackages;

    public static JSONObject bundleToJSON(String str) {
        String[] split;
        JSONObject jSONObject = new JSONObject();
        if (str != null && str.length() > 0) {
            for (String str2 : str.split("&")) {
                int indexOf = str2.indexOf("=");
                if (indexOf > 0 && indexOf < str2.length() - 1) {
                    try {
                        jSONObject.put(str2.substring(0, indexOf), (Object) str2.substring(indexOf + 1));
                    } catch (JSONException e) {
                        e.printStackTrace();
                    }
                }
            }
        }
        return jSONObject;
    }

    public static boolean isAppInstalled(Context context, String str) {
        if (TextUtils.isEmpty(str)) {
            return false;
        }
        try {
            context.getPackageManager().getPackageInfo(str, 0);
            return true;
        } catch (Throwable th) {
            th.printStackTrace();
            return false;
        }
    }

    public static Bundle serialBundle(String str) {
        if (str == null || str.length() <= 0) {
            return null;
        }
        String[] split = str.split("&");
        Bundle bundle = new Bundle();
        for (String str2 : split) {
            int indexOf = str2.indexOf("=");
            if (indexOf > 0 && indexOf < str2.length() - 1) {
                bundle.putString(str2.substring(0, indexOf), str2.substring(indexOf + 1));
            }
        }
        return bundle;
    }
}
