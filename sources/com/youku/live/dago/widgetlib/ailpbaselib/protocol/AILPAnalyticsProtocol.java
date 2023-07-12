package com.youku.live.dago.widgetlib.ailpbaselib.protocol;

import android.content.Context;
import java.util.Map;

/* compiled from: Taobao */
/* loaded from: classes2.dex */
public interface AILPAnalyticsProtocol {
    void click(String str, String str2, Map<String, String> map);

    void customEvent(String str, int i, String str2, String str3, String str4, Map<String, String> map);

    void pageAppear(Context context);

    void pageDisAppear(Context context);

    void updatePageName(Context context, String str);

    void updatePageProperties(Context context, Map<String, String> map);
}
