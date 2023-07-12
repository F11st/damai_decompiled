package com.youku.live.dago.widgetlib.ailpbaselib.util;

import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import java.lang.reflect.Field;

/* compiled from: Taobao */
/* loaded from: classes2.dex */
public class DebugHelp {
    private static transient /* synthetic */ IpChange $ipChange;
    public static Boolean sDebug;

    public static boolean isDebugBuild() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "409291275")) {
            return ((Boolean) ipChange.ipc$dispatch("409291275", new Object[0])).booleanValue();
        }
        if (sDebug == null) {
            try {
                Field field = Class.forName(((String) Class.forName("android.app.ActivityThread").getMethod("currentPackageName", new Class[0]).invoke(null, null)) + ".BuildConfig").getField("DEBUG");
                field.setAccessible(true);
                sDebug = Boolean.valueOf(field.getBoolean("true"));
            } catch (Throwable th) {
                String message = th.getMessage();
                if (message != null) {
                    message.contains("BuildConfig");
                }
                sDebug = Boolean.FALSE;
            }
        }
        return sDebug.booleanValue();
    }
}
