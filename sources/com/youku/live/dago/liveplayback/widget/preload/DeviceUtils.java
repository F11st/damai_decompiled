package com.youku.live.dago.liveplayback.widget.preload;

import android.os.Build;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;

/* compiled from: Taobao */
/* loaded from: classes2.dex */
public class DeviceUtils {
    private static transient /* synthetic */ IpChange $ipChange;

    public static String getDeviceBoard() {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "1945319174") ? (String) ipChange.ipc$dispatch("1945319174", new Object[0]) : Build.BOARD;
    }

    public static String getDeviceBrand() {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "1306589479") ? (String) ipChange.ipc$dispatch("1306589479", new Object[0]) : com.alibaba.wireless.security.aopsdk.replace.android.os.Build.getBRAND();
    }

    public static String getDeviceManufacturer() {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "-1785936857") ? (String) ipChange.ipc$dispatch("-1785936857", new Object[0]) : com.alibaba.wireless.security.aopsdk.replace.android.os.Build.getMANUFACTURER();
    }

    public static String getDeviceModel() {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "-1869052983") ? (String) ipChange.ipc$dispatch("-1869052983", new Object[0]) : com.alibaba.wireless.security.aopsdk.replace.android.os.Build.getMODEL();
    }

    public static String getDeviceProduct() {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "1046066511") ? (String) ipChange.ipc$dispatch("1046066511", new Object[0]) : com.alibaba.wireless.security.aopsdk.replace.android.os.Build.getPRODUCT();
    }
}
