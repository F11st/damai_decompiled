package com.ali.user.mobile.service;

import android.app.Activity;
import java.util.Map;
import java.util.Properties;

/* compiled from: Taobao */
/* loaded from: classes17.dex */
public interface UserTrackService {
    void UIShown(String str, String str2, String str3);

    void pageDisAppear(Activity activity);

    void sendControlUT(String str, String str2);

    void sendControlUT(String str, String str2, String str3);

    void sendControlUT(String str, String str2, String str3, String str4, String str5, Map<String, String> map);

    void sendControlUT(String str, String str2, String str3, Map<String, String> map);

    void sendUT(String str);

    void sendUT(String str, String str2);

    void sendUT(String str, String str2, String str3, String str4, Properties properties);

    void sendUT(String str, String str2, String str3, Properties properties);

    void sendUT(String str, String str2, Properties properties);

    void sendUT(String str, Properties properties);

    void sendUserTrack(String str, String str2, Map<String, String> map);

    void skipPage(Activity activity);

    void updatePageName(Activity activity, String str, String str2);
}
