package com.ali.user.mobile.security;

import com.ali.user.mobile.log.UserTrackAdapter;
import java.util.Properties;

/* compiled from: Taobao */
/* loaded from: classes17.dex */
public class SecurityUTHitUtils {
    public static void utHit(String str, String str2, String str3) {
        try {
            Properties properties = new Properties();
            properties.setProperty("errorCode", str + "");
            properties.setProperty("cause", str2 + "");
            UserTrackAdapter.sendUT(str3, properties);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
