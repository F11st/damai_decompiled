package com.youku.live.livesdk.dago;

import android.app.Application;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import com.youku.live.dago.widgetlib.DagoWidgetLib;
import com.youku.live.dsl.Dsl;
import com.youku.live.dsl.pages.IDagoLivePlaybackManangerInterface;
import com.youku.live.dsl.pages.IDagoManangerInterface;
import com.youku.live.dsl.pages.IDagoPGCPlaybackManangerInterface;
import java.lang.reflect.InvocationTargetException;

/* compiled from: Taobao */
/* loaded from: classes12.dex */
public class DagoSDK {
    private static transient /* synthetic */ IpChange $ipChange;
    private static boolean isInitialized;

    public static void registerAll(Application application) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-314963157")) {
            ipChange.ipc$dispatch("-314963157", new Object[]{application});
        } else if (isInitialized) {
        } else {
            isInitialized = true;
            try {
                ((IDagoManangerInterface) Dsl.getService(IDagoManangerInterface.class)).registerAll(application);
            } catch (Throwable unused) {
                registerAllOld(application);
            }
            try {
                ((IDagoLivePlaybackManangerInterface) Dsl.getService(IDagoLivePlaybackManangerInterface.class)).registerAll(application);
            } catch (Throwable unused2) {
            }
            try {
                ((IDagoPGCPlaybackManangerInterface) Dsl.getService(IDagoPGCPlaybackManangerInterface.class)).registerAll(application);
            } catch (Throwable unused3) {
            }
        }
    }

    private static void registerAllByReflect(Application application) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "966605135")) {
            ipChange.ipc$dispatch("966605135", new Object[]{application});
            return;
        }
        try {
            DagoWidgetLib.class.getMethod("registerAll", Application.class).invoke(null, application);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e2) {
            e2.printStackTrace();
        } catch (NoSuchMethodException e3) {
            e3.printStackTrace();
        } catch (InvocationTargetException e4) {
            e4.printStackTrace();
        }
    }

    @Deprecated
    public static void registerAllOld(Application application) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-98706224")) {
            ipChange.ipc$dispatch("-98706224", new Object[]{application});
        } else if (isInitialized) {
        } else {
            isInitialized = true;
            registerAllByReflect(application);
        }
    }
}
