package com.uc.webview.export.internal.utility;

import android.text.TextUtils;
import com.uc.webview.export.extension.SettingKeys;
import com.uc.webview.export.extension.UCCore;
import com.uc.webview.export.internal.uc.startup.C7301a;
import java.util.HashMap;
import java.util.Map;

/* compiled from: Taobao */
/* renamed from: com.uc.webview.export.internal.utility.e */
/* loaded from: classes11.dex */
public final class C7329e {
    private static final HashMap<String, C7330a> a = new HashMap<>();
    private static boolean b = false;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: Taobao */
    /* renamed from: com.uc.webview.export.internal.utility.e$a */
    /* loaded from: classes11.dex */
    public static final class C7330a {
        String a;
        Object b;
        int c;
        boolean d;

        public C7330a(String str, int i, boolean z) {
            this.a = str;
            this.c = i;
            this.d = z;
        }

        public final String toString() {
            return this.a + "=" + this.b + ", type=" + this.c + ", toCore=" + this.d;
        }
    }

    static {
        a(UCCore.OPTION_STARTUP_POLICY, 1, false);
        a(UCCore.OPTION_LOG_CONFIG, 0, false);
        a("wa_uspl_dabl", 0, false);
        a("wa_uspl_rate", 1, false);
        a(UCCore.OPTION_THREAD_WATCHDOG_WATCH_LIST, 2, false);
        a(UCCore.OPTION_TRHEAD_WATCHDOG_ALARM_DURATION, 2, false);
        a(UCCore.OPTION_TRHEAD_WATCHDOG_DUMP_JS_RATE, 2, false);
        a(UCCore.OPTION_TRHEAD_WATCHDOG_DUMP_NATIVE_RATE, 2, false);
        a(SettingKeys.ExtImgDecoderOn, 0, true);
        a(SettingKeys.DisableHiddenApiReflect, 0, true);
        a(SettingKeys.RemoveImageFromCache, 0, true);
        a(SettingKeys.DecodeFailIsOn, 0, true);
        a(SettingKeys.SendDecodeFailWebviewEvent, 0, true);
        a(SettingKeys.RenderingOptimization, 0, true);
        a(SettingKeys.EnableMediaPlayerService, 0, true);
        a(SettingKeys.EnableWebAudioStats, 0, true);
        a(SettingKeys.GLErrorDetail, 0, true);
        a(SettingKeys.EnableFDSanitizer, 1, true);
        a(SettingKeys.DisableAndroid12Adaptation, 0, true);
        a("AloneLauncherThread", 1, true);
        a("GPUInfoCache", 1, true);
        a(SettingKeys.GpuProcInitTimeout, 1, true);
        a("GpuProcBL", 2, true);
        a("GpuImageViewWL", 2, true);
    }

    public static void a(String str, String str2) {
        Boolean a2;
        if (TextUtils.isEmpty(str) || str2 == null) {
            return;
        }
        HashMap<String, C7330a> hashMap = a;
        synchronized (hashMap) {
            C7330a c7330a = hashMap.get(str);
            if (c7330a == null) {
                com.uc.webview.export.cyclone.Log.rInfo("DynamicSettings", "unsupport update key:" + str + ", value:" + str2);
                return;
            }
            int i = c7330a.c;
            if (i == 0) {
                c7330a.b = Boolean.valueOf(str2);
            } else if (i == 1) {
                try {
                    c7330a.b = Integer.valueOf(str2);
                } catch (Exception unused) {
                    com.uc.webview.export.cyclone.Log.rInfo("DynamicSettings", "invalid int setting value: " + str2);
                }
            } else if (i != 2) {
                com.uc.webview.export.cyclone.Log.rInfo("DynamicSettings", "unsupport value type: " + c7330a.c);
            } else {
                c7330a.b = str2;
            }
            if (UCCore.OPTION_LOG_CONFIG.equals(str) && (a2 = a(str)) != null) {
                UCCore.setPrintLog(a2.booleanValue());
            }
            com.uc.webview.export.cyclone.Log.rInfo("DynamicSettings", "update " + str + "=" + c7330a.b);
            if (b) {
                a(c7330a);
            }
        }
    }

    public static Integer b(String str) {
        try {
            return (Integer) d(str);
        } catch (Throwable unused) {
            return null;
        }
    }

    public static String c(String str) {
        try {
            return (String) d(str);
        } catch (Throwable unused) {
            return null;
        }
    }

    private static Object d(String str) {
        HashMap<String, C7330a> hashMap = a;
        synchronized (hashMap) {
            C7330a c7330a = hashMap.get(str);
            if (c7330a == null) {
                com.uc.webview.export.cyclone.Log.rInfo("DynamicSettings", "unsupport key: " + str);
                return null;
            }
            return c7330a.b;
        }
    }

    public static void a() {
        HashMap<String, C7330a> hashMap = a;
        synchronized (hashMap) {
            for (Map.Entry<String, C7330a> entry : hashMap.entrySet()) {
                a(entry.getValue());
            }
            b = true;
        }
    }

    public static Boolean a(String str) {
        try {
            return (Boolean) d(str);
        } catch (Throwable unused) {
            return null;
        }
    }

    private static void a(String str, int i, boolean z) {
        a.put(str, new C7330a(str, i, z));
    }

    private static void a(C7330a c7330a) {
        Object obj;
        if (!c7330a.d || (obj = c7330a.b) == null) {
            return;
        }
        C7301a.a(9012, new Object[]{c7330a.a, obj});
    }
}
