package com.youku.middlewareservice.provider.config;

import android.os.IBinder;
import java.util.Map;

/* compiled from: Taobao */
/* loaded from: classes13.dex */
public interface OneConfigProvider {

    /* compiled from: Taobao */
    /* loaded from: classes13.dex */
    public interface IUpdateListenerInterface {
        IBinder asBinder();

        void onConfigUpdate(String str, String str2, String str3);
    }

    boolean containsNamespace(String str);

    String[] getAllNamespaces();

    int getConfig(String str, String str2, int i);

    Object getConfig(String str, String str2, Object obj);

    String getConfig(String str, String str2, String str3);

    boolean getConfig(String str, String str2, boolean z);

    Map getConfigs(String str);

    String getCurrentOccVersion();

    boolean registerListener(String str, IUpdateListenerInterface iUpdateListenerInterface);

    boolean unregisterListener(String str, IUpdateListenerInterface iUpdateListenerInterface);
}
