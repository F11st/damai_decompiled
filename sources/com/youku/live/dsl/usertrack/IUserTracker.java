package com.youku.live.dsl.usertrack;

import android.app.Activity;
import android.net.Uri;
import java.util.Map;

/* compiled from: Taobao */
/* loaded from: classes12.dex */
public interface IUserTracker {
    Map<String, String> getLastClickParams();

    void pageAppear(Object obj);

    void pageAppearDonotSkip(Object obj);

    void pageDisAppear(Object obj);

    void setLastClickParams(Map<String, String> map);

    void skipPage(Object obj);

    void startSessionForUt(Activity activity, String str, String str2, Map<String, String> map);

    void track4Click(String str, String str2, Map<String, String> map);

    void track4Click(String str, String str2, String... strArr);

    void track4Show(String str, String str2, Map<String, String> map);

    void trackCustom(String str, int i, String str2, String str3, String str4, Map<String, String> map);

    void trackCustom(String str, String str2, Map<String, String> map);

    void updateNextPageUtParam(String str);

    void updateNextPageUtParam(Map<String, String> map);

    void updatePageName(Object obj, String str);

    void updatePageProperties(Object obj, Map<String, String> map);

    void updatePageUrl(Object obj, Uri uri);
}
