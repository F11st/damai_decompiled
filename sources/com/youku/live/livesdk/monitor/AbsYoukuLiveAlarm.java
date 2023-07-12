package com.youku.live.livesdk.monitor;

import android.text.TextUtils;
import android.util.Log;
import com.alibaba.mtl.appmonitor.AppMonitor;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import java.util.HashMap;
import java.util.Map;

/* compiled from: Taobao */
/* loaded from: classes12.dex */
public class AbsYoukuLiveAlarm {
    private static transient /* synthetic */ IpChange $ipChange = null;
    private static final String MODULE_NAME = "YoukuLiveAlarm";
    private final String CHAR_EQUAL;
    private final String CHAR_QUOT;
    private final String NIL_STRING;
    private String args;
    private Map<String, String> argsMap;
    private String errorCode;
    private String errorMessage;
    private boolean hasNewArg;
    private final String moduleName;
    private final String pointName;

    public AbsYoukuLiveAlarm(String str, String str2) {
        this.NIL_STRING = "";
        this.CHAR_EQUAL = "=";
        this.CHAR_QUOT = ",";
        this.moduleName = str;
        this.pointName = str2;
    }

    private void buildArgs() {
        IpChange ipChange = $ipChange;
        boolean z = true;
        if (AndroidInstantRuntime.support(ipChange, "1844579713")) {
            ipChange.ipc$dispatch("1844579713", new Object[]{this});
            return;
        }
        StringBuilder sb = new StringBuilder();
        Map<String, String> argsMap = getArgsMap();
        if (argsMap != null) {
            for (Map.Entry<String, String> entry : argsMap.entrySet()) {
                if (z) {
                    z = false;
                } else {
                    sb.append(",");
                }
                sb.append(entry.getKey());
                sb.append("=");
                sb.append(entry.getValue());
            }
        }
        this.args = sb.toString();
    }

    private String getArgs() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1514923929")) {
            return (String) ipChange.ipc$dispatch("-1514923929", new Object[]{this});
        }
        if (this.hasNewArg) {
            this.hasNewArg = false;
            buildArgs();
        }
        return stringEmptyChecker(this.args, "");
    }

    private Map<String, String> getArgsMap() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "725841354")) {
            return (Map) ipChange.ipc$dispatch("725841354", new Object[]{this});
        }
        if (this.argsMap == null) {
            synchronized (this) {
                if (this.argsMap == null) {
                    this.argsMap = new HashMap();
                }
            }
        }
        return this.argsMap;
    }

    private String getErrorCode() {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "-2035700095") ? (String) ipChange.ipc$dispatch("-2035700095", new Object[]{this}) : stringEmptyChecker(this.errorCode, "");
    }

    private String getErrorMessage() {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "1752920169") ? (String) ipChange.ipc$dispatch("1752920169", new Object[]{this}) : stringEmptyChecker(this.errorMessage, "");
    }

    private String getModuleName() {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "-951682463") ? (String) ipChange.ipc$dispatch("-951682463", new Object[]{this}) : this.moduleName;
    }

    private String getPointName() {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "-43947097") ? (String) ipChange.ipc$dispatch("-43947097", new Object[]{this}) : this.pointName;
    }

    private static String stringEmptyChecker(String str, String str2) {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "-1922361561") ? (String) ipChange.ipc$dispatch("-1922361561", new Object[]{str, str2}) : TextUtils.isEmpty(str) ? str2 : str;
    }

    public AbsYoukuLiveAlarm addArg(String str, String str2) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1715539167")) {
            return (AbsYoukuLiveAlarm) ipChange.ipc$dispatch("1715539167", new Object[]{this, str, str2});
        }
        if (!TextUtils.isEmpty(str)) {
            getArgsMap().put(str, stringEmptyChecker(str2, ""));
            this.hasNewArg = true;
        }
        return this;
    }

    public AbsYoukuLiveAlarm addArgs(Map<String, String> map) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1959252741")) {
            return (AbsYoukuLiveAlarm) ipChange.ipc$dispatch("1959252741", new Object[]{this, map});
        }
        if (map != null) {
            getArgsMap().putAll(map);
        }
        return this;
    }

    public AbsYoukuLiveAlarm commitFailure() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1139667523")) {
            return (AbsYoukuLiveAlarm) ipChange.ipc$dispatch("1139667523", new Object[]{this});
        }
        try {
            AppMonitor.Alarm.commitFail(getModuleName(), getPointName(), getArgs(), getErrorCode(), getErrorMessage());
            String moduleName = getModuleName();
            Log.e(moduleName, "Failure: " + getPointName() + "; " + getErrorCode() + "; " + getErrorMessage() + "; " + getArgs());
        } catch (Throwable th) {
            th.printStackTrace();
        }
        return this;
    }

    public AbsYoukuLiveAlarm commitSuccess() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1901717052")) {
            return (AbsYoukuLiveAlarm) ipChange.ipc$dispatch("1901717052", new Object[]{this});
        }
        try {
            AppMonitor.Alarm.commitSuccess(getModuleName(), getPointName(), getArgs());
            String moduleName = getModuleName();
            Log.e(moduleName, "Success: " + getPointName() + "; " + getArgs());
        } catch (Throwable th) {
            th.printStackTrace();
        }
        return this;
    }

    public AbsYoukuLiveAlarm setErrorCode(String str) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "2034458311")) {
            return (AbsYoukuLiveAlarm) ipChange.ipc$dispatch("2034458311", new Object[]{this, str});
        }
        this.errorCode = str;
        return this;
    }

    public AbsYoukuLiveAlarm setErrorMessage(String str) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-350617785")) {
            return (AbsYoukuLiveAlarm) ipChange.ipc$dispatch("-350617785", new Object[]{this, str});
        }
        this.errorMessage = str;
        return this;
    }

    public AbsYoukuLiveAlarm(String str) {
        this(MODULE_NAME, str);
    }
}
