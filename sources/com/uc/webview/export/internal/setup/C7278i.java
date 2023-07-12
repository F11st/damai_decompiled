package com.uc.webview.export.internal.setup;

import android.util.Pair;
import com.huawei.hms.api.ConnectionResult;
import com.uc.webview.export.extension.UCCore;
import com.uc.webview.export.internal.setup.af;
import com.uc.webview.export.internal.uc.startup.C7301a;
import com.uc.webview.export.internal.utility.C7329e;
import com.uc.webview.export.internal.utility.C7349p;
import java.util.HashMap;

/* compiled from: Taobao */
/* renamed from: com.uc.webview.export.internal.setup.i */
/* loaded from: classes11.dex */
public final class C7278i extends AbstractRunnableC7254a {
    public C7278i() {
        this.a = "InitCoreEngineJob";
        this.b = new Pair<>(261, 262);
    }

    @Override // com.uc.webview.export.internal.setup.AbstractRunnableC7254a
    protected final void a() {
        HashMap hashMap = new HashMap();
        bt btVar = af.c;
        if (btVar != null) {
            hashMap.put("ucm_corelib_path", btVar.soDirPath);
            hashMap.put("ucm_paks_resource_dir", btVar.resDirPath);
            Pair<String, String> pair = btVar.coreImplModule;
            if (pair != null) {
                hashMap.put("ucm_dex_path", pair.first);
                hashMap.put("ucm_odex_path", btVar.coreImplModule.second);
            }
            String str = (String) af.a(UCCore.OPTION_PRIVATE_DATA_DIRECTORY_SUFFIX);
            if (str != null) {
                hashMap.put("ucm_private_data_dir_suffix", str);
            }
            hashMap.put(UCCore.OPTION_DISABLE_CRITICAL_MEMORY_PRESSURE, C7349p.b(af.a(UCCore.OPTION_DISABLE_CRITICAL_MEMORY_PRESSURE)) ? "1" : "0");
            Integer num = (Integer) af.a(UCCore.OPTION_WEBVIEW_MULTI_PROCESS);
            if (num == null) {
                num = r4;
            }
            Integer num2 = (Integer) af.a(UCCore.OPTION_WEBVIEW_MULTI_PROCESS_FALLBACK_TIMEOUT);
            if (num2 == null) {
                num2 = r4;
            }
            Boolean bool = (Boolean) af.a(UCCore.OPTION_WEBVIEW_MULTI_PROCESS_ENABLE_SERVICE_SPEEDUP);
            if (bool == null) {
                bool = Boolean.FALSE;
            }
            hashMap.put("ucm_multi_process", String.valueOf(num));
            hashMap.put("ucm_multi_process_fallback_timeout", String.valueOf(num2));
            hashMap.put("ucm_multi_process_enable_service_speedup", String.valueOf(bool));
            hashMap.put(UCCore.OPTION_WEBVIEW_MULTI_PROCESS_ENABLE_SECCOMP, C7349p.b(af.a(UCCore.OPTION_WEBVIEW_MULTI_PROCESS_ENABLE_SECCOMP)) ? "1" : "0");
            Integer num3 = (Integer) af.a(UCCore.OPTION_MULTI_PROCESS_STARTUP_TIMEOUT);
            if (num3 == null) {
                num3 = r4;
            }
            hashMap.put(UCCore.OPTION_MULTI_PROCESS_STARTUP_TIMEOUT, String.valueOf(num3));
            hashMap.put(UCCore.OPTION_MULTI_PROCESS_DISABLE_FALLBACK_TO_SINGLE_PROCESS, C7349p.b(af.a(UCCore.OPTION_MULTI_PROCESS_DISABLE_FALLBACK_TO_SINGLE_PROCESS)) ? "1" : "0");
            Integer num4 = (Integer) af.a(UCCore.OPTION_GPU_PROCESS_MODE);
            hashMap.put("ucm_gpu_process_mode", String.valueOf(num4 != null ? num4 : 0));
            String str2 = (String) af.a("GpuProcBL");
            if (str2 != null) {
                hashMap.put("GpuProcBL", str2);
            }
            Integer num5 = (Integer) af.a(UCCore.OPTION_GPU_WARM_UP_TIME);
            if (num5 != null) {
                hashMap.put(UCCore.OPTION_GPU_WARM_UP_TIME, String.valueOf(num5));
            } else {
                hashMap.put(UCCore.OPTION_GPU_WARM_UP_TIME, "-1");
            }
            Integer num6 = (Integer) af.a(UCCore.OPTION_GPU_PROC_INIT_TIMEOUT);
            if (num6 != null) {
                hashMap.put(UCCore.OPTION_GPU_PROC_INIT_TIMEOUT, String.valueOf(num6));
            }
            Boolean bool2 = (Boolean) af.a("AloneLauncherThread");
            if (bool2 != null) {
                hashMap.put("AloneLauncherThread", bool2.booleanValue() ? "1" : "0");
            }
            Boolean bool3 = (Boolean) af.a("GPUInfoCache");
            if (bool3 != null) {
                hashMap.put("GPUInfoCache", bool3.booleanValue() ? "1" : "0");
            }
            String str3 = (String) af.a("GpuImageViewWL");
            if (str3 != null) {
                hashMap.put("GpuImageViewWL", str3);
            }
            hashMap.put("ucm_skip_init_setting", String.valueOf(!af.b));
            hashMap.put("ucm_is_hardware_ac", String.valueOf(af.e));
            hashMap.put("ucm_sup", String.valueOf(af.a()));
            Object c = C7329e.c(UCCore.OPTION_THREAD_WATCHDOG_WATCH_LIST);
            if (c == null) {
                c = af.a(UCCore.OPTION_THREAD_WATCHDOG_WATCH_LIST);
            }
            if (c != null) {
                hashMap.put("ucm_twd_watch_list", String.valueOf(c));
            }
            Object c2 = C7329e.c(UCCore.OPTION_TRHEAD_WATCHDOG_ALARM_DURATION);
            if (c2 == null) {
                c2 = af.a(UCCore.OPTION_TRHEAD_WATCHDOG_ALARM_DURATION);
            }
            if (c2 != null) {
                hashMap.put("ucm_twd_alarm_duration", String.valueOf(c2));
            }
            Object c3 = C7329e.c(UCCore.OPTION_TRHEAD_WATCHDOG_DUMP_JS_RATE);
            if (c3 == null) {
                c3 = af.a(UCCore.OPTION_TRHEAD_WATCHDOG_DUMP_JS_RATE);
            }
            if (c3 != null) {
                hashMap.put("ucm_twd_dump_js_rate", String.valueOf(c3));
            }
            Object c4 = C7329e.c(UCCore.OPTION_TRHEAD_WATCHDOG_DUMP_NATIVE_RATE);
            if (c4 == null) {
                c4 = af.a(UCCore.OPTION_TRHEAD_WATCHDOG_DUMP_NATIVE_RATE);
            }
            if (c4 != null) {
                hashMap.put("ucm_twd_dump_native_rate", String.valueOf(c4));
            }
        }
        try {
            C7301a.a(ConnectionResult.DRIVE_EXTERNAL_STORAGE_REQUIRED, new Object[]{af.a, hashMap});
            af.a(af.EnumC7264a.CORE_LIBRARY_LOADED, new Object[0]);
        } catch (Throwable th) {
            throw new UCSetupException(3007, th);
        }
    }
}
