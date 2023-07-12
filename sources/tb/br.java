package tb;

import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import com.taobao.android.dinamicx.log.IDXRemoteDebugLog;
import com.taobao.tao.log.TLog;

/* compiled from: Taobao */
/* loaded from: classes4.dex */
public class br implements IDXRemoteDebugLog {
    private static transient /* synthetic */ IpChange $ipChange;

    @Override // com.taobao.android.dinamicx.log.IDXRemoteDebugLog
    public void logd(String str, String... strArr) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1853848666")) {
            ipChange.ipc$dispatch("1853848666", new Object[]{this, str, strArr});
        } else {
            TLog.logd(str, strArr);
        }
    }

    @Override // com.taobao.android.dinamicx.log.IDXRemoteDebugLog
    public void loge(String str, String... strArr) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-81811621")) {
            ipChange.ipc$dispatch("-81811621", new Object[]{this, str, strArr});
        } else {
            TLog.loge(str, strArr);
        }
    }

    @Override // com.taobao.android.dinamicx.log.IDXRemoteDebugLog
    public void logi(String str, String... strArr) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "765481823")) {
            ipChange.ipc$dispatch("765481823", new Object[]{this, str, strArr});
        } else {
            TLog.logi(str, strArr);
        }
    }

    @Override // com.taobao.android.dinamicx.log.IDXRemoteDebugLog
    public void logv(String str, String... strArr) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1371701868")) {
            ipChange.ipc$dispatch("1371701868", new Object[]{this, str, strArr});
        } else {
            TLog.logv(str, strArr);
        }
    }

    @Override // com.taobao.android.dinamicx.log.IDXRemoteDebugLog
    public void logw(String str, String... strArr) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-563958419")) {
            ipChange.ipc$dispatch("-563958419", new Object[]{this, str, strArr});
        } else {
            TLog.logw(str, strArr);
        }
    }

    @Override // com.taobao.android.dinamicx.log.IDXRemoteDebugLog
    public void logd(String str, String str2) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1534877905")) {
            ipChange.ipc$dispatch("-1534877905", new Object[]{this, str, str2});
        } else {
            TLog.logd(str, str2);
        }
    }

    @Override // com.taobao.android.dinamicx.log.IDXRemoteDebugLog
    public void loge(String str, String str2) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-73297906")) {
            ipChange.ipc$dispatch("-73297906", new Object[]{this, str, str2});
        } else {
            TLog.loge(str, str2);
        }
    }

    @Override // com.taobao.android.dinamicx.log.IDXRemoteDebugLog
    public void logi(String str, String str2) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1478054794")) {
            ipChange.ipc$dispatch("1478054794", new Object[]{this, str, str2});
        } else {
            TLog.logi(str, str2);
        }
    }

    @Override // com.taobao.android.dinamicx.log.IDXRemoteDebugLog
    public void logv(String str, String str2) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-996241699")) {
            ipChange.ipc$dispatch("-996241699", new Object[]{this, str, str2});
        } else {
            TLog.logv(str, str2);
        }
    }

    @Override // com.taobao.android.dinamicx.log.IDXRemoteDebugLog
    public void logw(String str, String str2) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "465338300")) {
            ipChange.ipc$dispatch("465338300", new Object[]{this, str, str2});
        } else {
            TLog.logw(str, str2);
        }
    }

    @Override // com.taobao.android.dinamicx.log.IDXRemoteDebugLog
    public void logd(String str, String str2, String str3) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1048118471")) {
            ipChange.ipc$dispatch("-1048118471", new Object[]{this, str, str2, str3});
        } else {
            TLog.logd(str, str2, str3);
        }
    }

    @Override // com.taobao.android.dinamicx.log.IDXRemoteDebugLog
    public void loge(String str, String str2, String str3) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1316229720")) {
            ipChange.ipc$dispatch("1316229720", new Object[]{this, str, str2, str3});
        } else {
            TLog.loge(str, str2, str3);
        }
    }

    @Override // com.taobao.android.dinamicx.log.IDXRemoteDebugLog
    public void logi(String str, String str2, String str3) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-2111279404")) {
            ipChange.ipc$dispatch("-2111279404", new Object[]{this, str, str2, str3});
        } else {
            TLog.logi(str, str2, str3);
        }
    }

    @Override // com.taobao.android.dinamicx.log.IDXRemoteDebugLog
    public void logv(String str, String str2, String str3) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1439523993")) {
            ipChange.ipc$dispatch("-1439523993", new Object[]{this, str, str2, str3});
        } else {
            TLog.logv(str, str2, str3);
        }
    }

    @Override // com.taobao.android.dinamicx.log.IDXRemoteDebugLog
    public void logw(String str, String str2, String str3) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "924824198")) {
            ipChange.ipc$dispatch("924824198", new Object[]{this, str, str2, str3});
        } else {
            TLog.logw(str, str2, str3);
        }
    }

    @Override // com.taobao.android.dinamicx.log.IDXRemoteDebugLog
    public void loge(String str, String str2, Throwable th) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-339699545")) {
            ipChange.ipc$dispatch("-339699545", new Object[]{this, str, str2, th});
        } else {
            TLog.loge(str, str2, th);
        }
    }

    @Override // com.taobao.android.dinamicx.log.IDXRemoteDebugLog
    public void logw(String str, String str2, Throwable th) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "134603193")) {
            ipChange.ipc$dispatch("134603193", new Object[]{this, str, str2, th});
        } else {
            TLog.logw(str, str2, th);
        }
    }
}
