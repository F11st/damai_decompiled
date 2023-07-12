package com.alibaba.mobsec.privacydoublelist.config;

import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.util.Log;
import com.alibaba.mobsec.privacydoublelist.PdlEnvUtils;
import com.alibaba.mobsec.privacydoublelist.b.b;
import com.alibaba.mobsec.privacydoublelist.b.c;
import com.alibaba.mobsec.privacydoublelist.e.e;
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
    /* loaded from: classes6.dex */
    public class a implements c.a {
        public a() {
        }

        public void a(String str, Map<String, String> map) {
            ConfigCenter.this.a(c.a(str));
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
                        e.b().a(Integer.parseInt(str2));
                    } else if (c == 4) {
                        com.alibaba.mobsec.privacydoublelist.c.a.a().a(str2);
                    } else if (c != 5) {
                        Log.e("DL-CONFIG", "Unknown key in config: " + str);
                    } else {
                        e.b().c = Integer.parseInt(str2);
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
        a aVar = new a();
        if (!c.b) {
            c.a();
        }
        if (c.c != null && c.e != null && c.d != null) {
            try {
                c.e.invoke(c.c, c.a, Proxy.newProxyInstance(c.d.getClassLoader(), new Class[]{c.d}, new b(aVar)), Boolean.TRUE);
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
            context.registerReceiver(new com.alibaba.mobsec.privacydoublelist.b.a(this), new IntentFilter("com.alibaba.mobsec.privacydoublelist.config.update"));
        }
        a(c.a("pdl_orange_namespace"));
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
