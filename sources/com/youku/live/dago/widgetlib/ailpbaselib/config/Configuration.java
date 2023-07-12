package com.youku.live.dago.widgetlib.ailpbaselib.config;

import androidx.annotation.NonNull;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import com.youku.live.dago.widgetlib.ailpbaselib.net.mtop.LicenceResolveCallback;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;

/* compiled from: Taobao */
/* loaded from: classes2.dex */
public class Configuration {
    private static transient /* synthetic */ IpChange $ipChange;
    private static ConcurrentMap<String, Configuration> configurations = new ConcurrentHashMap();
    private String mAppId;
    private String mLicence;
    private String mRoomId;
    private int mTestEnv = -1;
    private LicenceResolveCallback licenceCallback = null;

    private Configuration(String str, String str2, String str3) {
        this.mRoomId = null;
        this.mAppId = null;
        this.mLicence = null;
        this.mRoomId = str;
        this.mAppId = str2;
        this.mLicence = str3;
    }

    public static Configuration getConfig(@NonNull String str) {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "249135262") ? (Configuration) ipChange.ipc$dispatch("249135262", new Object[]{str}) : configurations.get(str);
    }

    public static Configuration init(@NonNull String str, @NonNull String str2, @NonNull String str3) {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "738688784") ? (Configuration) ipChange.ipc$dispatch("738688784", new Object[]{str, str2, str3}) : configurations.putIfAbsent(str, new Configuration(str, str2, str3));
    }

    public static void removeConfig(@NonNull String str) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-24674574")) {
            ipChange.ipc$dispatch("-24674574", new Object[]{str});
        } else {
            configurations.remove(str);
        }
    }

    public String getAppId() {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "407553656") ? (String) ipChange.ipc$dispatch("407553656", new Object[]{this}) : this.mAppId;
    }

    public String getLicence() {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "259161325") ? (String) ipChange.ipc$dispatch("259161325", new Object[]{this}) : this.mLicence;
    }

    public LicenceResolveCallback getLicenceCallback() {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "-2075746054") ? (LicenceResolveCallback) ipChange.ipc$dispatch("-2075746054", new Object[]{this}) : this.licenceCallback;
    }

    public int getTestEnv() {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "-2097586404") ? ((Integer) ipChange.ipc$dispatch("-2097586404", new Object[]{this})).intValue() : this.mTestEnv;
    }

    public void setLicenceCallback(@NonNull LicenceResolveCallback licenceResolveCallback) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1506378206")) {
            ipChange.ipc$dispatch("-1506378206", new Object[]{this, licenceResolveCallback});
        } else {
            this.licenceCallback = licenceResolveCallback;
        }
    }

    public void setTestEnv(int i) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1922591854")) {
            ipChange.ipc$dispatch("1922591854", new Object[]{this, Integer.valueOf(i)});
        } else {
            this.mTestEnv = i;
        }
    }
}
