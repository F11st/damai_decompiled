package com.uc.webview.export.internal.utility;

import android.text.TextUtils;
import com.uc.webview.export.extension.SettingKeys;
import com.uc.webview.export.extension.UCCore;
import java.util.HashMap;
import java.util.Map;

/* compiled from: Taobao */
/* loaded from: classes11.dex */
public final class e {
    private static final HashMap<String, a> a = new HashMap<>();
    private static boolean b = false;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: Taobao */
    /* loaded from: classes11.dex */
    public static final class a {
        String a;
        Object b;
        int c;
        boolean d;

        public a(String str, int i, boolean z) {
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
        HashMap<String, a> hashMap = a;
        synchronized (hashMap) {
            a aVar = hashMap.get(str);
            if (aVar == null) {
                com.uc.webview.export.cyclone.Log.rInfo("DynamicSettings", "unsupport update key:" + str + ", value:" + str2);
                return;
            }
            int i = aVar.c;
            if (i == 0) {
                aVar.b = Boolean.valueOf(str2);
            } else if (i == 1) {
                try {
                    aVar.b = Integer.valueOf(str2);
                } catch (Exception unused) {
                    com.uc.webview.export.cyclone.Log.rInfo("DynamicSettings", "invalid int setting value: " + str2);
                }
            } else if (i != 2) {
                com.uc.webview.export.cyclone.Log.rInfo("DynamicSettings", "unsupport value type: " + aVar.c);
            } else {
                aVar.b = str2;
            }
            if (UCCore.OPTION_LOG_CONFIG.equals(str) && (a2 = a(str)) != null) {
                UCCore.setPrintLog(a2.booleanValue());
            }
            com.uc.webview.export.cyclone.Log.rInfo("DynamicSettings", "update " + str + "=" + aVar.b);
            if (b) {
                a(aVar);
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
        HashMap<String, a> hashMap = a;
        synchronized (hashMap) {
            a aVar = hashMap.get(str);
            if (aVar == null) {
                com.uc.webview.export.cyclone.Log.rInfo("DynamicSettings", "unsupport key: " + str);
                return null;
            }
            return aVar.b;
        }
    }

    public static void a() {
        HashMap<String, a> hashMap = a;
        synchronized (hashMap) {
            for (Map.Entry<String, a> entry : hashMap.entrySet()) {
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
        a.put(str, new a(str, i, z));
    }

    private static void a(a aVar) {
        Object obj;
        if (!aVar.d || (obj = aVar.b) == null) {
            return;
        }
        com.uc.webview.export.internal.uc.startup.a.a(9012, new Object[]{aVar.a, obj});
    }
}
