package com.youku.live.dsl.log;

import android.util.Log;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;

/* compiled from: Taobao */
/* loaded from: classes3.dex */
public class ILogVirtualImpl implements ILog {
    private static transient /* synthetic */ IpChange $ipChange;
    private static ILog gInstance;

    private ILogVirtualImpl() {
    }

    public static ILog getInstance() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-802924496")) {
            return (ILog) ipChange.ipc$dispatch("-802924496", new Object[0]);
        }
        if (gInstance == null) {
            synchronized (ILog.class) {
                if (gInstance == null) {
                    gInstance = new ILogVirtualImpl();
                }
            }
        }
        return gInstance;
    }

    @Override // com.youku.live.dsl.log.ILog
    public void d(String str, String str2) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1170910945")) {
            ipChange.ipc$dispatch("1170910945", new Object[]{this, str, str2});
        } else {
            Log.d(str, str2);
        }
    }

    @Override // com.youku.live.dsl.log.ILog
    public void e(String str, String str2) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1662476352")) {
            ipChange.ipc$dispatch("-1662476352", new Object[]{this, str, str2});
        } else {
            Log.e(str, str2);
        }
    }

    @Override // com.youku.live.dsl.log.ILog
    public void i(String str, String str2) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-111123652")) {
            ipChange.ipc$dispatch("-111123652", new Object[]{this, str, str2});
        } else {
            Log.i(str, str2);
        }
    }

    @Override // com.youku.live.dsl.log.ILog
    public void v(String str, String str2) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1709547151")) {
            ipChange.ipc$dispatch("1709547151", new Object[]{this, str, str2});
        } else {
            Log.v(str, str2);
        }
    }

    @Override // com.youku.live.dsl.log.ILog
    public void w(String str, String str2) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1123840146")) {
            ipChange.ipc$dispatch("-1123840146", new Object[]{this, str, str2});
        } else {
            Log.w(str, str2);
        }
    }

    @Override // com.youku.live.dsl.log.ILog
    public void e(String str, String str2, Throwable th) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "197438517")) {
            ipChange.ipc$dispatch("197438517", new Object[]{this, str, str2, th});
        } else {
            Log.e(str, str2, th);
        }
    }

    @Override // com.youku.live.dsl.log.ILog
    public void i(String str, String str2, Throwable th) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-174379463")) {
            ipChange.ipc$dispatch("-174379463", new Object[]{this, str, str2, th});
        } else {
            Log.i(str, str2, th);
        }
    }

    @Override // com.youku.live.dsl.log.ILog
    public void w(String str, String str2, Throwable th) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "671741255")) {
            ipChange.ipc$dispatch("671741255", new Object[]{this, str, str2, th});
        } else {
            Log.w(str, str2, th);
        }
    }
}
