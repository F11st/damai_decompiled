package com.ut.mini;

import android.app.Application;
import android.os.RemoteException;
import com.alibaba.analytics.core.Variables;
import com.alibaba.analytics.core.store.LogStoreMgr;
import com.alibaba.analytics.utils.Logger;
import com.ut.mini.core.UTLogTransferMain;
import com.ut.mini.internal.UTTeamWork;
import java.util.HashMap;
import java.util.Map;
import tb.za2;

/* compiled from: Taobao */
/* loaded from: classes11.dex */
public final class UTAnalyticsDelegate {
    private static UTAnalyticsDelegate s_instance;
    private Application mApplication;
    private UTTracker mDefaultTracker;
    private Map<String, UTTracker> mTrackerMap = new HashMap();

    private UTAnalyticsDelegate() {
    }

    public static synchronized UTAnalyticsDelegate getInstance() {
        UTAnalyticsDelegate uTAnalyticsDelegate;
        synchronized (UTAnalyticsDelegate.class) {
            if (s_instance == null) {
                s_instance = new UTAnalyticsDelegate();
            }
            uTAnalyticsDelegate = s_instance;
        }
        return uTAnalyticsDelegate;
    }

    public void initUT(Application application) {
        this.mApplication = application;
        UTTeamWork.getInstance().initialized();
    }

    public void saveCacheDataToLocal() throws RemoteException {
        LogStoreMgr.l().n();
    }

    public void sessionTimeout() {
        za2.a().e();
    }

    public void setAppVersion(String str) {
        Variables.n().R(str);
    }

    public void setChannel(String str) {
        Logger.f(null, "channel", str);
        Variables.n().S(str);
    }

    public void setSessionProperties(Map map) {
        Variables.n().d0(map);
    }

    public void transferLog(Map<String, String> map) {
        UTLogTransferMain.getInstance().transferLog(map);
    }

    public void turnOffRealTimeDebug() throws RemoteException {
        Variables.n().p0();
    }

    public void turnOnDebug() {
        Variables.n().r0();
    }

    public void turnOnRealTimeDebug(Map map) throws RemoteException {
        Variables.n().s0(map);
    }

    public void updateSessionProperties(Map map) {
        Map<String, String> x = Variables.n().x();
        HashMap hashMap = new HashMap();
        if (x != null) {
            hashMap.putAll(x);
        }
        if (map != null) {
            hashMap.putAll(map);
        }
        Variables.n().d0(hashMap);
    }

    @Deprecated
    public void updateUserAccount(String str, String str2, String str3) {
        Variables.n().u0(str, str2, str3);
    }

    public void updateUserAccount(String str, String str2, String str3, String str4) {
        Variables.n().v0(str, str2, str3, str4);
    }
}
