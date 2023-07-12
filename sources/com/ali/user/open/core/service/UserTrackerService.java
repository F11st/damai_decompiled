package com.ali.user.open.core.service;

import android.app.Activity;
import java.util.Map;

/* compiled from: Taobao */
/* loaded from: classes9.dex */
public interface UserTrackerService {
    void pageDisAppear(Activity activity);

    void send(String str, String str2, Map<String, String> map);

    void send(String str, Map<String, String> map);

    void sendControl(String str, String str2, String str3, Map<String, String> map);

    void skipPage(Activity activity);

    void updatePageName(Activity activity, String str, Map<String, String> map);
}
