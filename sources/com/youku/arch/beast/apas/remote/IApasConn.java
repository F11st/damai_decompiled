package com.youku.arch.beast.apas.remote;

import android.content.Context;
import java.util.Map;

/* compiled from: Taobao */
/* loaded from: classes2.dex */
public interface IApasConn {
    boolean containsNamespace(String str);

    String getConfig(String str, String str2, String str3);

    Map getConfigs(String str);

    void init(Context context);

    boolean registerListener(String str, IApasUpdateListenerInterface iApasUpdateListenerInterface);

    void setRequestExtraInfo(String str, String str2);

    boolean unregisterListener(String str, IApasUpdateListenerInterface iApasUpdateListenerInterface);
}
