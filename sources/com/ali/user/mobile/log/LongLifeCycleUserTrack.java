package com.ali.user.mobile.log;

import android.text.TextUtils;
import java.util.Properties;

/* compiled from: Taobao */
/* loaded from: classes17.dex */
public class LongLifeCycleUserTrack {
    private static String ResultScene;
    private static String sScene;

    public static String getResultScene() {
        return ResultScene;
    }

    public static String getScene() {
        return sScene;
    }

    public static void sendUT(String str, Properties properties) {
        String str2;
        if (properties == null) {
            properties = new Properties();
        }
        if (!TextUtils.isEmpty(getResultScene())) {
            properties.put("UTScene", getResultScene());
        }
        String str3 = "";
        if (!TextUtils.isEmpty(sScene)) {
            if (TextUtils.equals(sScene, "login_bar")) {
                properties.put("source", "Page_Login5-AlipaySuc");
                str2 = "Page_Login5";
            } else if (TextUtils.equals(ResultScene, "Alipay_AuthCode_Login")) {
                str2 = sScene;
            } else {
                properties.put("source", sScene);
                str2 = "";
            }
            sScene = "";
            str3 = str2;
        }
        if (TextUtils.isEmpty(str3)) {
            UserTrackAdapter.sendUT(str, properties);
        } else {
            UserTrackAdapter.sendUT(str3, str, properties);
        }
        setResultScene(null);
    }

    public static void setResultScene(String str) {
        ResultScene = str;
    }

    public static void setScene(String str) {
        sScene = str;
    }

    public static void sendUT(String str) {
        sendUT(str, null);
    }
}
