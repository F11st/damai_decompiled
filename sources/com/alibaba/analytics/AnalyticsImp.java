package com.alibaba.analytics;

import android.app.Application;
import android.os.RemoteException;
import com.alibaba.analytics.IAnalytics;
import com.alibaba.analytics.core.Variables;
import com.alibaba.analytics.core.config.C3108a;
import com.alibaba.analytics.core.config.SystemConfigMgr;
import com.alibaba.analytics.core.sync.C3135g;
import com.alibaba.analytics.utils.Logger;
import com.alibaba.analytics.utils.UTServerAppStatusTrigger;
import com.alibaba.appmonitor.delegate.C3309a;
import com.alibaba.appmonitor.delegate.C3314b;
import com.alibaba.appmonitor.event.EventType;
import com.alibaba.mtl.appmonitor.Transaction;
import com.alibaba.mtl.appmonitor.model.DimensionSet;
import com.alibaba.mtl.appmonitor.model.DimensionValueSet;
import com.alibaba.mtl.appmonitor.model.MeasureSet;
import com.alibaba.mtl.appmonitor.model.MeasureValueSet;
import com.ut.mini.UTAnalyticsDelegate;
import java.util.HashMap;
import java.util.Map;
import tb.za2;

/* compiled from: Taobao */
/* loaded from: classes5.dex */
public class AnalyticsImp extends IAnalytics.Stub {
    private static Application mApplication;

    public AnalyticsImp(Application application) {
        mApplication = application;
    }

    public static Application getApplication() {
        return mApplication;
    }

    private EventType getEventType(int i) {
        return EventType.getEventType(i);
    }

    @Override // com.alibaba.analytics.IAnalytics
    public boolean alarm_checkSampled(String str, String str2) throws RemoteException {
        try {
            return C3309a.C3310a.a(str, str2);
        } catch (Throwable th) {
            Logger.h(null, th, new Object[0]);
            return false;
        }
    }

    @Override // com.alibaba.analytics.IAnalytics
    public void alarm_commitFail1(String str, String str2, String str3, String str4) throws RemoteException {
        try {
            C3309a.C3310a.b(str, str2, str3, str4);
        } catch (Throwable th) {
            Logger.h(null, th, new Object[0]);
        }
    }

    @Override // com.alibaba.analytics.IAnalytics
    public void alarm_commitFail2(String str, String str2, String str3, String str4, String str5) throws RemoteException {
        try {
            C3309a.C3310a.c(str, str2, str3, str4, str5);
        } catch (Throwable th) {
            Logger.h(null, th, new Object[0]);
        }
    }

    @Override // com.alibaba.analytics.IAnalytics
    public void alarm_commitSuccess1(String str, String str2) throws RemoteException {
        try {
            C3309a.C3310a.d(str, str2);
        } catch (Throwable th) {
            Logger.h(null, th, new Object[0]);
        }
    }

    @Override // com.alibaba.analytics.IAnalytics
    public void alarm_commitSuccess2(String str, String str2, String str3) throws RemoteException {
        try {
            C3309a.C3310a.e(str, str2, str3);
        } catch (Throwable th) {
            Logger.h(null, th, new Object[0]);
        }
    }

    @Override // com.alibaba.analytics.IAnalytics
    public void alarm_setSampling(int i) throws RemoteException {
        try {
            C3309a.C3310a.f(i);
        } catch (Throwable th) {
            Logger.h(null, th, new Object[0]);
        }
    }

    @Override // com.alibaba.analytics.IAnalytics
    public void alarm_setStatisticsInterval(int i) throws RemoteException {
        try {
            C3309a.C3310a.g(i);
        } catch (Throwable th) {
            Logger.h(null, th, new Object[0]);
        }
    }

    @Override // com.alibaba.analytics.IAnalytics
    public boolean counter_checkSampled(String str, String str2) throws RemoteException {
        try {
            return C3309a.C3311b.a(str, str2);
        } catch (Throwable th) {
            Logger.h(null, th, new Object[0]);
            return false;
        }
    }

    @Override // com.alibaba.analytics.IAnalytics
    public void counter_commit1(String str, String str2, double d) throws RemoteException {
        try {
            C3309a.C3311b.b(str, str2, d);
        } catch (VerifyError e) {
            Logger.h(null, e, new Object[0]);
        } catch (Throwable th) {
            Logger.h(null, th, new Object[0]);
        }
    }

    @Override // com.alibaba.analytics.IAnalytics
    public void counter_commit2(String str, String str2, String str3, double d) throws RemoteException {
        try {
            C3309a.C3311b.c(str, str2, str3, d);
        } catch (VerifyError e) {
            Logger.h(null, e, new Object[0]);
        } catch (Throwable th) {
            Logger.h(null, th, new Object[0]);
        }
    }

    @Override // com.alibaba.analytics.IAnalytics
    public void counter_setSampling(int i) throws RemoteException {
        try {
            C3309a.C3311b.d(i);
        } catch (Throwable th) {
            Logger.h(null, th, new Object[0]);
        }
    }

    @Override // com.alibaba.analytics.IAnalytics
    public void counter_setStatisticsInterval(int i) throws RemoteException {
        try {
            C3309a.C3311b.e(i);
        } catch (VerifyError e) {
            Logger.h(null, e, new Object[0]);
        } catch (Throwable th) {
            Logger.h(null, th, new Object[0]);
        }
    }

    @Override // com.alibaba.analytics.IAnalytics
    public void destroy() throws RemoteException {
        try {
            C3309a.a();
        } catch (Throwable th) {
            Logger.h(null, th, new Object[0]);
        }
    }

    @Override // com.alibaba.analytics.IAnalytics
    public void dispatchLocalHits() throws RemoteException {
        try {
            C3135g.p().l();
        } catch (Throwable th) {
            Logger.h(null, th, new Object[0]);
        }
    }

    @Override // com.alibaba.analytics.IAnalytics
    public void enableLog(boolean z) throws RemoteException {
        try {
            C3309a.b(z);
        } catch (Throwable th) {
            Logger.h(null, th, new Object[0]);
        }
    }

    @Override // com.alibaba.analytics.IAnalytics
    public String getValue(String str) throws RemoteException {
        try {
        } catch (Throwable th) {
            Logger.h(null, th, new Object[0]);
        }
        if (C3108a.KEY.equals(str)) {
            return SystemConfigMgr.i().h(str);
        }
        if ("tpk_md5".equals(str)) {
            return Variables.n().z();
        }
        if ("tpk_string".equals(str)) {
            return Variables.n().y();
        }
        if ("session_timestamp".equals(str)) {
            return "" + za2.a().b();
        }
        if ("autoExposure".equalsIgnoreCase(str)) {
            return SystemConfigMgr.i().h(str);
        }
        return null;
    }

    @Override // com.alibaba.analytics.IAnalytics
    public void init() throws RemoteException {
        try {
            initUT();
        } catch (Throwable th) {
            Logger.h(null, th, new Object[0]);
        }
    }

    @Override // com.alibaba.analytics.IAnalytics
    public void initUT() throws RemoteException {
        Logger.f("AnalyticsImp", "initUT start..");
        Variables.n().D(mApplication);
        Logger.f("AnalyticsImp", "initUT end..");
    }

    @Override // com.alibaba.analytics.IAnalytics
    public boolean offlinecounter_checkSampled(String str, String str2) throws RemoteException {
        return C3309a.C3312c.a(str, str2);
    }

    @Override // com.alibaba.analytics.IAnalytics
    public void offlinecounter_commit(String str, String str2, double d) throws RemoteException {
        C3309a.C3312c.b(str, str2, d);
    }

    @Override // com.alibaba.analytics.IAnalytics
    public void offlinecounter_setSampling(int i) throws RemoteException {
        C3309a.C3312c.c(i);
    }

    @Override // com.alibaba.analytics.IAnalytics
    public void offlinecounter_setStatisticsInterval(int i) throws RemoteException {
        try {
            C3309a.C3312c.d(i);
        } catch (Throwable th) {
            Logger.h(null, th, new Object[0]);
        }
    }

    @Override // com.alibaba.analytics.IAnalytics
    public void onBackground() throws RemoteException {
        try {
            saveCacheDataToLocal();
            UTServerAppStatusTrigger.a();
        } catch (VerifyError e) {
            Logger.h(null, e, new Object[0]);
        } catch (Throwable th) {
            Logger.h(null, th, new Object[0]);
        }
    }

    @Override // com.alibaba.analytics.IAnalytics
    public void onForeground() throws RemoteException {
        try {
            UTServerAppStatusTrigger.b();
        } catch (VerifyError e) {
            Logger.h(null, e, new Object[0]);
        } catch (Throwable th) {
            Logger.h(null, th, new Object[0]);
        }
    }

    @Override // com.alibaba.analytics.IAnalytics
    public void register1(String str, String str2, MeasureSet measureSet) throws RemoteException {
        try {
            C3309a.f(str, str2, measureSet);
        } catch (Throwable th) {
            Logger.h(null, th, new Object[0]);
        }
    }

    @Override // com.alibaba.analytics.IAnalytics
    public void register2(String str, String str2, MeasureSet measureSet, boolean z) throws RemoteException {
        try {
            C3309a.i(str, str2, measureSet, z);
        } catch (Throwable th) {
            Logger.h(null, th, new Object[0]);
        }
    }

    @Override // com.alibaba.analytics.IAnalytics
    public void register3(String str, String str2, MeasureSet measureSet, DimensionSet dimensionSet) throws RemoteException {
        try {
            C3309a.g(str, str2, measureSet, dimensionSet);
        } catch (Throwable th) {
            Logger.h(null, th, new Object[0]);
        }
    }

    @Override // com.alibaba.analytics.IAnalytics
    public void register4(String str, String str2, MeasureSet measureSet, DimensionSet dimensionSet, boolean z) throws RemoteException {
        try {
            C3309a.h(str, str2, measureSet, dimensionSet, z);
        } catch (Throwable th) {
            Logger.h(null, th, new Object[0]);
        }
    }

    @Override // com.alibaba.analytics.IAnalytics
    public void removeGlobalProperty(String str) throws RemoteException {
        try {
            C3309a.j(str);
        } catch (Throwable th) {
            Logger.h(null, th, new Object[0]);
        }
    }

    @Override // com.alibaba.analytics.IAnalytics
    public void saveCacheDataToLocal() throws RemoteException {
        try {
            UTAnalyticsDelegate.getInstance().saveCacheDataToLocal();
        } catch (Throwable th) {
            Logger.h(null, th, new Object[0]);
        }
    }

    @Override // com.alibaba.analytics.IAnalytics
    public String selfCheck(String str) throws RemoteException {
        return null;
    }

    @Override // com.alibaba.analytics.IAnalytics
    public void sessionTimeout() throws RemoteException {
        try {
            UTAnalyticsDelegate.getInstance().sessionTimeout();
        } catch (VerifyError e) {
            Logger.h(null, e, new Object[0]);
        } catch (Throwable th) {
            Logger.h(null, th, new Object[0]);
        }
    }

    @Override // com.alibaba.analytics.IAnalytics
    public void setAppVersion(String str) throws RemoteException {
        try {
            UTAnalyticsDelegate.getInstance().setAppVersion(str);
        } catch (VerifyError e) {
            Logger.h(null, e, new Object[0]);
        } catch (Throwable th) {
            Logger.h(null, th, new Object[0]);
        }
    }

    @Override // com.alibaba.analytics.IAnalytics
    public void setChannel(String str) throws RemoteException {
        try {
            UTAnalyticsDelegate.getInstance().setChannel(str);
        } catch (VerifyError e) {
            Logger.h(null, e, new Object[0]);
        } catch (Throwable th) {
            Logger.h(null, th, new Object[0]);
        }
    }

    @Override // com.alibaba.analytics.IAnalytics
    public void setGlobalProperty(String str, String str2) throws RemoteException {
        try {
            C3309a.k(str, str2);
        } catch (Throwable th) {
            Logger.h(null, th, new Object[0]);
        }
    }

    @Override // com.alibaba.analytics.IAnalytics
    public void setRequestAuthInfo(boolean z, boolean z2, String str, String str2) throws RemoteException {
        try {
            C3309a.l(z, z2, str, str2);
        } catch (Throwable th) {
            Logger.h(null, th, new Object[0]);
        }
    }

    @Override // com.alibaba.analytics.IAnalytics
    public void setSampling(int i) throws RemoteException {
        try {
            C3309a.m(i);
        } catch (Throwable th) {
            Logger.h(null, th, new Object[0]);
        }
    }

    @Override // com.alibaba.analytics.IAnalytics
    public void setSessionProperties(Map map) throws RemoteException {
        try {
            UTAnalyticsDelegate.getInstance().setSessionProperties(map);
        } catch (VerifyError e) {
            Logger.h(null, e, new Object[0]);
        } catch (Throwable th) {
            Logger.h(null, th, new Object[0]);
        }
    }

    @Override // com.alibaba.analytics.IAnalytics
    public void setStatisticsInterval1(int i) throws RemoteException {
        try {
            C3309a.n(i);
        } catch (Throwable th) {
            Logger.h(null, th, new Object[0]);
        }
    }

    @Override // com.alibaba.analytics.IAnalytics
    public void setStatisticsInterval2(int i, int i2) throws RemoteException {
        try {
            C3309a.o(getEventType(i), i2);
        } catch (Throwable th) {
            Logger.h(null, th, new Object[0]);
        }
    }

    @Override // com.alibaba.analytics.IAnalytics
    public void startMainProcess(long j) throws RemoteException {
        try {
            Logger.f("AnalyticsImp", "startMainProcess", Long.valueOf(j));
            if (j == 0) {
                return;
            }
            long s = Variables.n().s();
            if (s == 0) {
                Variables.n().Y(j);
            } else if (s != j) {
                sessionTimeout();
                if (j - s > 600000) {
                    Variables.n().Y(j);
                    setSessionProperties(new HashMap());
                }
            }
        } catch (VerifyError e) {
            Logger.h(null, e, new Object[0]);
        } catch (Throwable th) {
            Logger.h(null, th, new Object[0]);
        }
    }

    @Override // com.alibaba.analytics.IAnalytics
    public void stat_begin(String str, String str2, String str3) throws RemoteException {
        try {
            C3309a.C3313d.a(str, str2, str3);
        } catch (Throwable th) {
            Logger.h(null, th, new Object[0]);
        }
    }

    @Override // com.alibaba.analytics.IAnalytics
    public boolean stat_checkSampled(String str, String str2) throws RemoteException {
        return C3309a.C3313d.b(str, str2);
    }

    @Override // com.alibaba.analytics.IAnalytics
    public void stat_commit1(String str, String str2, double d) throws RemoteException {
        try {
            C3309a.C3313d.c(str, str2, d);
        } catch (Throwable th) {
            Logger.h(null, th, new Object[0]);
        }
    }

    @Override // com.alibaba.analytics.IAnalytics
    public void stat_commit2(String str, String str2, DimensionValueSet dimensionValueSet, double d) throws RemoteException {
        try {
            C3309a.C3313d.d(str, str2, dimensionValueSet, d);
        } catch (Throwable th) {
            Logger.h(null, th, new Object[0]);
        }
    }

    @Override // com.alibaba.analytics.IAnalytics
    public void stat_commit3(String str, String str2, DimensionValueSet dimensionValueSet, MeasureValueSet measureValueSet) throws RemoteException {
        try {
            C3309a.C3313d.e(str, str2, dimensionValueSet, measureValueSet);
        } catch (Throwable th) {
            Logger.h(null, th, new Object[0]);
        }
    }

    @Override // com.alibaba.analytics.IAnalytics
    public void stat_end(String str, String str2, String str3) throws RemoteException {
        try {
            C3309a.C3313d.f(str, str2, str3);
        } catch (Throwable th) {
            Logger.h(null, th, new Object[0]);
        }
    }

    @Override // com.alibaba.analytics.IAnalytics
    public void stat_setSampling(int i) throws RemoteException {
        try {
            C3309a.C3313d.g(i);
        } catch (Throwable th) {
            Logger.h(null, th, new Object[0]);
        }
    }

    @Override // com.alibaba.analytics.IAnalytics
    public void stat_setStatisticsInterval(int i) throws RemoteException {
        try {
            C3309a.C3313d.h(i);
        } catch (Throwable th) {
            Logger.h(null, th, new Object[0]);
        }
    }

    @Override // com.alibaba.analytics.IAnalytics
    public void transaction_begin(Transaction transaction, String str) throws RemoteException {
        try {
            C3314b.b(transaction, str);
        } catch (Throwable th) {
            Logger.h(null, th, new Object[0]);
        }
    }

    @Override // com.alibaba.analytics.IAnalytics
    public void transaction_end(Transaction transaction, String str) throws RemoteException {
        try {
            C3314b.c(transaction, str);
        } catch (Throwable th) {
            Logger.h(null, th, new Object[0]);
        }
    }

    @Override // com.alibaba.analytics.IAnalytics
    public void transferLog(Map map) throws RemoteException {
        Logger.q();
        try {
            if (!Variables.n().K()) {
                Variables.n().D(mApplication);
            }
            UTAnalyticsDelegate.getInstance().transferLog(map);
        } catch (VerifyError e) {
            Logger.h(null, e, new Object[0]);
        } catch (Throwable th) {
            Logger.h(null, th, new Object[0]);
        }
    }

    @Override // com.alibaba.analytics.IAnalytics
    public void triggerUpload() throws RemoteException {
        try {
            C3309a.p();
        } catch (Throwable th) {
            Logger.h(null, th, new Object[0]);
        }
    }

    @Override // com.alibaba.analytics.IAnalytics
    public void turnOffRealTimeDebug() throws RemoteException {
        try {
            Variables.n().p0();
        } catch (Throwable th) {
            Logger.h(null, th, new Object[0]);
        }
    }

    @Override // com.alibaba.analytics.IAnalytics
    public void turnOnDebug() throws RemoteException {
        try {
            UTAnalyticsDelegate.getInstance().turnOnDebug();
        } catch (Throwable th) {
            Logger.h(null, th, new Object[0]);
        }
    }

    @Override // com.alibaba.analytics.IAnalytics
    public void turnOnRealTimeDebug(Map map) throws RemoteException {
        try {
            Variables.n().s0(map);
        } catch (Throwable th) {
            Logger.h(null, th, new Object[0]);
        }
    }

    @Override // com.alibaba.analytics.IAnalytics
    public void updateMeasure(String str, String str2, String str3, double d, double d2, double d3) throws RemoteException {
        C3309a.q(str, str2, str3, d, d2, d3);
    }

    @Override // com.alibaba.analytics.IAnalytics
    public void updateSessionProperties(Map map) throws RemoteException {
        try {
            UTAnalyticsDelegate.getInstance().updateSessionProperties(map);
        } catch (VerifyError e) {
            Logger.h(null, e, new Object[0]);
        } catch (Throwable th) {
            Logger.h(null, th, new Object[0]);
        }
    }

    @Override // com.alibaba.analytics.IAnalytics
    public void updateUserAccount(String str, String str2, String str3, String str4) throws RemoteException {
        try {
            UTAnalyticsDelegate.getInstance().updateUserAccount(str, str2, str3, str4);
        } catch (VerifyError e) {
            Logger.h(null, e, new Object[0]);
        } catch (Throwable th) {
            Logger.h(null, th, new Object[0]);
        }
    }
}
