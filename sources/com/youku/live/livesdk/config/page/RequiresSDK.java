package com.youku.live.livesdk.config.page;

import android.text.TextUtils;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;

/* compiled from: Taobao */
/* loaded from: classes12.dex */
public class RequiresSDK {
    private static transient /* synthetic */ IpChange $ipChange = null;
    public static final String KEY = "pageRequireSDK";
    public static final String VALUE_AILP_SDK = "ailp";
    public static final String VALUE_DAGO_SDK = "dago";
    public static final String VALUE_DEFAULT = "ailp,dago,laifengsdk";
    public static final String VALUE_LAIFENG_SDK = "laifengsdk";
    public static final String VALUE_SPLIT_CHAR = ",";
    private boolean requireAilpSDK = true;
    private boolean requireDagoSDK = true;
    private boolean requireLaifengSDK = true;

    public boolean requireAilpSDK() {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "-3268903") ? ((Boolean) ipChange.ipc$dispatch("-3268903", new Object[]{this})).booleanValue() : this.requireAilpSDK;
    }

    public boolean requireDagoSDK() {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "-29696366") ? ((Boolean) ipChange.ipc$dispatch("-29696366", new Object[]{this})).booleanValue() : this.requireDagoSDK;
    }

    public boolean requireLaifengSDK() {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "-1748652899") ? ((Boolean) ipChange.ipc$dispatch("-1748652899", new Object[]{this})).booleanValue() : this.requireLaifengSDK;
    }

    public RequiresSDK setAilpSDK(boolean z) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "58087610")) {
            return (RequiresSDK) ipChange.ipc$dispatch("58087610", new Object[]{this, Boolean.valueOf(z)});
        }
        this.requireAilpSDK = z;
        return this;
    }

    public RequiresSDK setDagoSDK(boolean z) {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "1312383603") ? (RequiresSDK) ipChange.ipc$dispatch("1312383603", new Object[]{this, Boolean.valueOf(z)}) : this;
    }

    public RequiresSDK setLaifengSDK(boolean z) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1480710428")) {
            return (RequiresSDK) ipChange.ipc$dispatch("-1480710428", new Object[]{this, Boolean.valueOf(z)});
        }
        this.requireLaifengSDK = z;
        return this;
    }

    public RequiresSDK setRemoteConfig(String str) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "568784208")) {
            return (RequiresSDK) ipChange.ipc$dispatch("568784208", new Object[]{this, str});
        }
        if (TextUtils.isEmpty(str)) {
            str = VALUE_DEFAULT;
        }
        setAilpSDK(str.contains(VALUE_AILP_SDK));
        setDagoSDK(true);
        setLaifengSDK(str.contains(VALUE_LAIFENG_SDK));
        return this;
    }
}
