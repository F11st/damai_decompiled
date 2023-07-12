package com.youku.arch.solid.log;

import android.util.Log;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;

/* compiled from: Taobao */
/* loaded from: classes2.dex */
public class DefaultLoggerImpl implements ILogger {
    private static transient /* synthetic */ IpChange $ipChange = null;
    private static final String TAG = "Solid.";
    private final boolean openLog;

    public DefaultLoggerImpl(boolean z) {
        this.openLog = z;
    }

    private String buildTag(String str) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "928530896")) {
            return (String) ipChange.ipc$dispatch("928530896", new Object[]{this, str});
        }
        return TAG + str;
    }

    @Override // com.youku.arch.solid.log.ILogger
    public void d(String str, String str2) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-227604632")) {
            ipChange.ipc$dispatch("-227604632", new Object[]{this, str, str2});
        } else if (this.openLog) {
            Log.d(buildTag(str), str2);
        }
    }

    @Override // com.youku.arch.solid.log.ILogger
    public void e(String str, String str2) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1233975367")) {
            ipChange.ipc$dispatch("1233975367", new Object[]{this, str, str2});
        } else {
            Log.e(buildTag(str), str2);
        }
    }

    @Override // com.youku.arch.solid.log.ILogger
    public boolean isLog() {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "476886466") ? ((Boolean) ipChange.ipc$dispatch("476886466", new Object[]{this})).booleanValue() : this.openLog;
    }

    @Override // com.youku.arch.solid.log.ILogger
    public void v(String str, String str2) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "311031574")) {
            ipChange.ipc$dispatch("311031574", new Object[]{this, str, str2});
        } else if (this.openLog) {
            Log.v(buildTag(str), str2);
        }
    }

    @Override // com.youku.arch.solid.log.ILogger
    public void w(String str, String str2) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1772611573")) {
            ipChange.ipc$dispatch("1772611573", new Object[]{this, str, str2});
        } else if (this.openLog) {
            Log.w(buildTag(str), str2);
        }
    }
}
