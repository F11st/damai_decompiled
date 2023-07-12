package com.youku.gaiax.impl.utils;

import android.content.Context;
import android.content.SharedPreferences;
import com.uc.webview.export.extension.UCCore;
import io.flutter.wpkbridge.WPKFactory;
import kotlin.Metadata;
import org.android.agoo.common.AgooConstants;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import tb.b41;
import tb.ms0;

/* compiled from: Taobao */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0014\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u001f\u0010 J&\u0010\u0006\u001a\u00020\u00022\b\u0010\u0003\u001a\u0004\u0018\u00010\u00022\b\u0010\u0004\u001a\u0004\u0018\u00010\u00022\b\u0010\u0005\u001a\u0004\u0018\u00010\u0002H\u0002J&\u0010\t\u001a\u00020\b2\b\u0010\u0003\u001a\u0004\u0018\u00010\u00022\b\u0010\u0004\u001a\u0004\u0018\u00010\u00022\b\u0010\u0007\u001a\u0004\u0018\u00010\u0002H\u0002J\u000e\u0010\f\u001a\u00020\b2\u0006\u0010\u000b\u001a\u00020\nJ\u0006\u0010\u000e\u001a\u00020\rJ\u0006\u0010\u000f\u001a\u00020\rJ\u0006\u0010\u0010\u001a\u00020\rJ\u0006\u0010\u0011\u001a\u00020\rJ\u000e\u0010\u0013\u001a\u00020\b2\u0006\u0010\u0012\u001a\u00020\u0002J\u0006\u0010\u0014\u001a\u00020\rJ\u0006\u0010\u0015\u001a\u00020\rJ\u0006\u0010\u0016\u001a\u00020\rJ\u0006\u0010\u0017\u001a\u00020\rR\u0018\u0010\u0018\u001a\u0004\u0018\u00010\n8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u0018\u0010\u0019R\u0018\u0010\u000e\u001a\u0004\u0018\u00010\r8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u000e\u0010\u001aR\u0018\u0010\u000f\u001a\u0004\u0018\u00010\r8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u000f\u0010\u001aR\u0018\u0010\u0010\u001a\u0004\u0018\u00010\r8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u0010\u0010\u001aR\u0018\u0010\u0011\u001a\u0004\u0018\u00010\r8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u0011\u0010\u001aR\u0018\u0010\u0014\u001a\u0004\u0018\u00010\r8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u0014\u0010\u001aR$\u0010\u0015\u001a\u0004\u0018\u00010\r8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u0015\u0010\u001a\u001a\u0004\b\u0015\u0010\u001b\"\u0004\b\u001c\u0010\u001dR\u0018\u0010\u001e\u001a\u0004\u0018\u00010\r8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u001e\u0010\u001aR\u0018\u0010\u0017\u001a\u0004\u0018\u00010\r8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u0017\u0010\u001a¨\u0006!"}, d2 = {"Lcom/youku/gaiax/impl/utils/PropUtils;", "", "", "name", "key", "defValue", "getStringPreference", "value", "Ltb/wt2;", "setStringPreference", "Landroid/content/Context;", WPKFactory.INIT_KEY_CONTEXT, UCCore.LEGACY_EVENT_INIT, "", "isProfile", "isLog", "isLaunchLog", "isMonitorLog", AgooConstants.MESSAGE_FLAG, "setLog", "isJSLog", "isRemote", "isTimeLog", "isTrace", "appContext", "Landroid/content/Context;", "Ljava/lang/Boolean;", "()Ljava/lang/Boolean;", "setRemote", "(Ljava/lang/Boolean;)V", "isTestLog", "<init>", "()V", "GaiaX-Android"}, k = 1, mv = {1, 5, 1})
/* loaded from: classes2.dex */
public final class PropUtils {
    @NotNull
    public static final PropUtils INSTANCE = new PropUtils();
    @Nullable
    private static Context appContext;
    @Nullable
    private static Boolean isJSLog;
    @Nullable
    private static Boolean isLaunchLog;
    @Nullable
    private static Boolean isLog;
    @Nullable
    private static Boolean isMonitorLog;
    @Nullable
    private static Boolean isProfile;
    @Nullable
    private static Boolean isRemote;
    @Nullable
    private static Boolean isTestLog;
    @Nullable
    private static Boolean isTrace;

    private PropUtils() {
    }

    private final String getStringPreference(String str, String str2, String str3) {
        SharedPreferences sharedPreferences;
        try {
            Context context = appContext;
            if (context != null && (sharedPreferences = context.getSharedPreferences(str, 0)) != null) {
                String string = sharedPreferences.getString(str2, str3);
                return string == null ? "" : string;
            }
            return "";
        } catch (Exception unused) {
            return "";
        }
    }

    private final void setStringPreference(String str, String str2, String str3) {
        SharedPreferences sharedPreferences;
        SharedPreferences.Editor edit;
        SharedPreferences.Editor putString;
        try {
            Context context = appContext;
            if (context != null && (sharedPreferences = context.getSharedPreferences(str, 0)) != null && (edit = sharedPreferences.edit()) != null && (putString = edit.putString(str2, str3)) != null) {
                putString.apply();
            }
        } catch (Exception unused) {
        }
    }

    public final void init(@NotNull Context context) {
        b41.i(context, WPKFactory.INIT_KEY_CONTEXT);
        appContext = context;
    }

    public final boolean isJSLog() {
        if (isJSLog == null) {
            isJSLog = Boolean.valueOf(b41.d("1", SystemProp.INSTANCE.get("debug.gaiax.js.log", "0")));
        }
        Boolean bool = isJSLog;
        if (bool == null) {
            return false;
        }
        return bool.booleanValue();
    }

    public final boolean isLaunchLog() {
        if (isLaunchLog == null) {
            isLaunchLog = Boolean.valueOf(b41.d("1", getStringPreference(ConfigUtils.GAIAX_CONFIG_SP_NAME_SPACE, "debug.gaiax.log.launch", "0")) || b41.d("1", SystemProp.INSTANCE.get("debug.gaiax.log.launch", "0")));
        }
        Boolean bool = isLaunchLog;
        if (bool == null) {
            return false;
        }
        return bool.booleanValue();
    }

    public final boolean isLog() {
        if (isLog == null) {
            isLog = Boolean.valueOf(b41.d("1", getStringPreference(ConfigUtils.GAIAX_CONFIG_SP_NAME_SPACE, "debug.gaiax.log", "0")) || b41.d("1", SystemProp.INSTANCE.get("debug.gaiax.log", "0")));
        }
        Boolean bool = isLog;
        if (bool == null) {
            return false;
        }
        return bool.booleanValue();
    }

    public final boolean isMonitorLog() {
        if (isMonitorLog == null) {
            isMonitorLog = Boolean.valueOf(b41.d("1", getStringPreference(ConfigUtils.GAIAX_CONFIG_SP_NAME_SPACE, "debug.gaiax.log.monitor", "0")) || b41.d("1", SystemProp.INSTANCE.get("debug.gaiax.log.monitor", "0")));
        }
        Boolean bool = isMonitorLog;
        if (bool == null) {
            return false;
        }
        return bool.booleanValue();
    }

    public final boolean isProfile() {
        if (isProfile == null) {
            isProfile = Boolean.valueOf(b41.d(SystemProp.INSTANCE.get("debug.gaiax.profile", "0"), "1"));
        }
        Boolean bool = isProfile;
        if (bool == null) {
            return false;
        }
        return bool.booleanValue();
    }

    @Nullable
    public final Boolean isRemote() {
        return isRemote;
    }

    public final boolean isTimeLog() {
        if (isTestLog == null) {
            isTestLog = Boolean.valueOf(b41.d("1", SystemProp.INSTANCE.get("debug.gaiax.log.time", "0")));
        }
        Boolean bool = isTestLog;
        if (bool == null) {
            return false;
        }
        return bool.booleanValue();
    }

    public final boolean isTrace() {
        if (isTrace == null) {
            isTrace = Boolean.valueOf(b41.d("1", ms0.INSTANCE.a("debug.gaiax.trace", "0")));
        }
        Boolean bool = isTrace;
        if (bool == null) {
            return false;
        }
        return bool.booleanValue();
    }

    public final void setLog(@NotNull String str) {
        b41.i(str, AgooConstants.MESSAGE_FLAG);
        isLog = Boolean.valueOf(b41.d(str, "1"));
        setStringPreference(ConfigUtils.GAIAX_CONFIG_SP_NAME_SPACE, "debug.gaiax.log", str);
    }

    public final void setRemote(@Nullable Boolean bool) {
        isRemote = bool;
    }

    /* renamed from: isRemote  reason: collision with other method in class */
    public final boolean m1260isRemote() {
        if (isRemote == null) {
            isRemote = Boolean.valueOf(b41.d("1", SystemProp.INSTANCE.get("debug.gaiax.remote", "1")));
        }
        Boolean bool = isRemote;
        if (bool == null) {
            return false;
        }
        return bool.booleanValue();
    }
}
