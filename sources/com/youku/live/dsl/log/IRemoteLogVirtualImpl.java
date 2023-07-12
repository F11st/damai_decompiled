package com.youku.live.dsl.log;

import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;

/* compiled from: Taobao */
/* loaded from: classes3.dex */
public class IRemoteLogVirtualImpl implements IRemoteLog {
    private static transient /* synthetic */ IpChange $ipChange;
    private static ILog gInstance;

    public static ILog getInstance() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1393358538")) {
            return (ILog) ipChange.ipc$dispatch("1393358538", new Object[0]);
        }
        if (gInstance == null) {
            synchronized (ILog.class) {
                if (gInstance == null) {
                    gInstance = new IRemoteLogVirtualImpl();
                }
            }
        }
        return gInstance;
    }

    @Override // com.youku.live.dsl.log.ILog
    public void d(String str, String str2) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-274846725")) {
            ipChange.ipc$dispatch("-274846725", new Object[]{this, str, str2});
        }
    }

    @Override // com.youku.live.dsl.log.ILog
    public void e(String str, String str2) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1186733274")) {
            ipChange.ipc$dispatch("1186733274", new Object[]{this, str, str2});
        }
    }

    @Override // com.youku.live.dsl.log.ILog
    public void e(String str, String str2, Throwable th) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-913947813")) {
            ipChange.ipc$dispatch("-913947813", new Object[]{this, str, str2, th});
        }
    }

    @Override // com.youku.live.dsl.log.ILog
    public void i(String str, String str2) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1556881322")) {
            ipChange.ipc$dispatch("-1556881322", new Object[]{this, str, str2});
        }
    }

    @Override // com.youku.live.dsl.log.ILog
    public void i(String str, String str2, Throwable th) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1285765793")) {
            ipChange.ipc$dispatch("-1285765793", new Object[]{this, str, str2, th});
        }
    }

    @Override // com.youku.live.dsl.log.ILog
    public void v(String str, String str2) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "263789481")) {
            ipChange.ipc$dispatch("263789481", new Object[]{this, str, str2});
        }
    }

    @Override // com.youku.live.dsl.log.ILog
    public void w(String str, String str2) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1725369480")) {
            ipChange.ipc$dispatch("1725369480", new Object[]{this, str, str2});
        }
    }

    @Override // com.youku.live.dsl.log.ILog
    public void w(String str, String str2, Throwable th) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-439645075")) {
            ipChange.ipc$dispatch("-439645075", new Object[]{this, str, str2, th});
        }
    }
}
