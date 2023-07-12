package cn.damai.solid.bean;

import cn.damai.solid.util.Constant;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import java.io.Serializable;

/* compiled from: Taobao */
/* loaded from: classes16.dex */
public class SoInstallResult implements Serializable {
    private static transient /* synthetic */ IpChange $ipChange;
    public String alarmMsg;
    public String errCode;
    public boolean isSoInstallSuccess;

    public SoInstallResult() {
        this.isSoInstallSuccess = false;
    }

    public static SoInstallResult noSoGroupResult() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1041753031")) {
            return (SoInstallResult) ipChange.ipc$dispatch("1041753031", new Object[0]);
        }
        SoInstallResult soInstallResult = new SoInstallResult();
        soInstallResult.isSoInstallSuccess = false;
        soInstallResult.errCode = Constant.CODE_SOLID_NONE_SO_GROUP;
        soInstallResult.alarmMsg = Constant.MSG_SOLID_NONE_SO_GROUP;
        return soInstallResult;
    }

    public static SoInstallResult success() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-2078046589")) {
            return (SoInstallResult) ipChange.ipc$dispatch("-2078046589", new Object[0]);
        }
        SoInstallResult soInstallResult = new SoInstallResult();
        soInstallResult.isSoInstallSuccess = true;
        return soInstallResult;
    }

    public SoInstallResult(boolean z, String str, String str2) {
        this.isSoInstallSuccess = false;
        this.isSoInstallSuccess = z;
        this.errCode = str;
        this.alarmMsg = str2;
    }
}
