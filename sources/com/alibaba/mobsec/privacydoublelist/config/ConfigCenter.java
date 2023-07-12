package com.alibaba.mobsec.privacydoublelist.config;

import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.util.Log;
import com.alibaba.mobsec.privacydoublelist.PdlEnvUtils;
import com.alibaba.mobsec.privacydoublelist.b.C3422a;
import com.alibaba.mobsec.privacydoublelist.b.C3423b;
import com.alibaba.mobsec.privacydoublelist.b.C3424c;
import com.alibaba.mobsec.privacydoublelist.c.C3426a;
import com.alibaba.mobsec.privacydoublelist.e.C3438e;
import com.alibaba.mobsec.privacydoublelist.report.PrivacyDoubleListReporter;
import java.lang.reflect.Proxy;
import java.util.Map;
import org.json.JSONObject;

/* compiled from: Taobao */
/* loaded from: classes6.dex */
public class ConfigCenter {
    public static final String KEY_DEBUG = "open_log";
    public static final String KEY_DETAIL = "detail_list";
    public static final String KEY_ENABLED = "master_switch";
    public static final String KEY_REPORT_DELAY = "cache_cycle";
    public static final String KEY_RETVAL_CACHE = "cache_retval_cycle";
    public static final String KEY_RETVAL_COUNT = "retval_limit";
    public static ConfigCenter a;

    /* compiled from: Taobao */
    /* renamed from: com.alibaba.mobsec.privacydoublelist.config.ConfigCenter$a */
    /* loaded from: classes6.dex */
    public class C3429a implements C3424c.InterfaceC3425a {
        public C3429a() {
        }

        public void a(String str, Map<String, String> map) {
            ConfigCenter.this.a(C3424c.a(str));
        }
    }

    public static synchronized ConfigCenter getInstance() {
        ConfigCenter configCenter;
        synchronized (ConfigCenter.class) {
            if (a == null) {
                a = new ConfigCenter();
            }
            configCenter = a;
        }
        return configCenter;
    }

    public final void a(Map<String, String> map) {
        if (map == null) {
            return;
        }
        for (String str : map.keySet()) {
            String str2 = map.get(str);
            if (str2 != null) {
                char c = 65535;
                try {
                    switch (str.hashCode()) {
                        case -2050303028:
                            if (str.equals(KEY_DETAIL)) {
                                c = 4;
                                break;
                            }
                            break;
                        case -1982118500:
                            if (str.equals(KEY_RETVAL_COUNT)) {
                                c = 5;
                                break;
                            }
                            break;
                        case -504314929:
                            if (str.equals(KEY_DEBUG)) {
                                c = 1;
                                break;
                            }
                            break;
                        case 886276585:
                            if (str.equals(KEY_REPORT_DELAY)) {
                                c = 0;
                                break;
                            }
                            break;
                        case 969832369:
                            if (str.equals(KEY_ENABLED)) {
                                c = 2;
                                break;
                            }
                            break;
                        case 2044137572:
                            if (str.equals(KEY_RETVAL_CACHE)) {
                                c = 3;
                                break;
                            }
                            break;
                    }
                    if (c == 0) {
                        PrivacyDoubleListReporter.getInstance().setReportInitDelay(Integer.parseInt(str2));
                        PrivacyDoubleListReporter.getInstance().setReportDelay(Integer.parseInt(str2));
                    } else if (c == 1) {
                        PdlEnvUtils.a = str2.equals("1");
                    } else if (c == 2) {
                        PdlEnvUtils.setEnabled(str2.equals("1"));
                    } else if (c == 3) {
                        C3438e.b().a(Integer.parseInt(str2));
                    } else if (c == 4) {
                        C3426a.a().a(str2);
                    } else if (c != 5) {
                        Log.e("DL-CONFIG", "Unknown key in config: " + str);
                    } else {
                        C3438e.b().c = Integer.parseInt(str2);
                    }
                } catch (Throwable th) {
                    if (PdlEnvUtils.a) {
                        Log.e("DL-CONFIG", "Error while parsing config", th);
                    }
                }
            }
        }
    }

    public void initConfig(Context context) {
        C3429a c3429a = new C3429a();
        if (!C3424c.b) {
            C3424c.a();
        }
        if (C3424c.c != null && C3424c.e != null && C3424c.d != null) {
            try {
                C3424c.e.invoke(C3424c.c, C3424c.a, Proxy.newProxyInstance(C3424c.d.getClassLoader(), new Class[]{C3424c.d}, new C3423b(c3429a)), Boolean.TRUE);
                if (PdlEnvUtils.a) {
                    Log.d("AOP-OrangeConfigHelper", "Orange listener register success");
                }
            } catch (Throwable th) {
                Log.e("AOP-OrangeConfigHelper", "Register Method failed", th);
            }
        } else {
            Log.e("AOP-OrangeConfigHelper", "Orange reflect failed");
        }
        if (PdlEnvUtils.a) {
            Log.e("AOP-OrangeConfigHelper", "Finish registerOrangeListener!");
        }
        if (!PdlEnvUtils.a(context) && context != null) {
            context.registerReceiver(new C3422a(this), new IntentFilter("com.alibaba.mobsec.privacydoublelist.config.update"));
        }
        a(C3424c.a("pdl_orange_namespace"));
    }

    public void updateConfig(Map<String, String> map) {
        a(map);
        Context context = PdlEnvUtils.e;
        if (PdlEnvUtils.a(context)) {
            Intent intent = new Intent("com.alibaba.mobsec.privacydoublelist.config.update");
            String jSONObject = new JSONObject(map).toString();
            if (PdlEnvUtils.a) {
                Log.d("DL-CONFIG", "Sync to child process: " + jSONObject);
            }
            intent.putExtra("cfg", jSONObject);
            intent.putExtra("pkg", context.getPackageName());
            context.sendBroadcast(intent);
        }
    }
}
