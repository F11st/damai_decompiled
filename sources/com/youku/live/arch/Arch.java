package com.youku.live.arch;

import android.annotation.SuppressLint;
import android.app.Application;
import android.content.Context;
import androidx.annotation.NonNull;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import java.util.Objects;

/* compiled from: Taobao */
/* loaded from: classes2.dex */
public class Arch {
    private static transient /* synthetic */ IpChange $ipChange;
    @SuppressLint({"StaticFieldLeak"})
    private static Application sApplication;

    private Arch() {
        throw new UnsupportedOperationException("u can't instantiate me...");
    }

    public static Application getApp() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1205139175")) {
            return (Application) ipChange.ipc$dispatch("-1205139175", new Object[0]);
        }
        Application application = sApplication;
        Objects.requireNonNull(application, "com.youku.live.arch.Arch should init first");
        return application;
    }

    public static void init(@NonNull Application application) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1172738938")) {
            ipChange.ipc$dispatch("1172738938", new Object[]{application});
        } else {
            sApplication = application;
        }
    }

    public static void initWithApplication(Application application) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "2088352292")) {
            ipChange.ipc$dispatch("2088352292", new Object[]{application});
        }
    }

    public static void initWithContext(Context context) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1291329516")) {
            ipChange.ipc$dispatch("1291329516", new Object[]{context});
        }
    }
}
