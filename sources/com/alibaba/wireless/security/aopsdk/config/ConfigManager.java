package com.alibaba.wireless.security.aopsdk.config;

import android.annotation.SuppressLint;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.SharedPreferences;
import android.text.TextUtils;
import android.util.Base64;
import android.util.Log;
import com.alibaba.wireless.security.aopsdk.AopManager;
import com.alibaba.wireless.security.aopsdk.e.a;
import com.alibaba.wireless.security.aopsdk.e.c;
import com.alibaba.wireless.security.aopsdk.report.ReportManager;
import com.taobao.weex.annotation.JSMethod;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;
import java.util.Observable;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.TimeUnit;
import javax.crypto.Cipher;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.SecretKeySpec;
import org.json.JSONObject;

/* loaded from: classes.dex */
public class ConfigManager extends Observable {
    public static final String APP_INFO_KEY = "strategy_control_use_running_app_info";
    public static final String CALLBACK_KEY = "strategy_control_callback_android";
    public static final String CONFIG_KEY = "strategy_control_config_android";
    public static volatile boolean DEBUG = false;
    public static final String LOG_KEY = "strategy_control_log_android";
    public static final String PERSIST_KEY = "strategy_control_persist";
    public static final String STACK_FILTER_KEY = "strategy_control_stack_filter";
    public static final String STACK_LIMIT_KEY = "strategy_control_stack_limit";
    public static final String SWITCH_KEY = "strategy_control_switch_android";
    @SuppressLint({"StaticFieldLeak"})
    private static ConfigManager k = null;
    private static final String l = "AOP-CONFIG";
    public static final String m = "secAspect";
    public static final String n = "cfg";
    public static final String o = "secaop";
    public static final String p = "mobsec_secaop";
    public static final String q = "enabled";
    public static final String r = "cfg";
    public static final String s = "AOPENCRYPTKEY123";
    private static final String t = "com.alibaba.wireless.security.aopsdk.config.update";
    private static final int u = 1;
    private static final Object v = new Object();
    private static final Object w = new Object();
    private Context a;
    private j b;
    private Boolean c;
    private final Map<String, String> d = new HashMap();
    private ScheduledExecutorService e = null;
    private boolean f = false;
    private boolean g = false;
    private boolean h = true;
    private boolean i = false;
    private boolean j = false;

    /* loaded from: classes.dex */
    public class a extends Thread {
        public final /* synthetic */ Map a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public a(String str, Map map) {
            super(str);
            this.a = map;
        }

        /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:27:0x00a2 -> B:62:0x005c). Please submit an issue!!! */
        @Override // java.lang.Thread, java.lang.Runnable
        public void run() {
            FileOutputStream fileOutputStream;
            ObjectOutputStream objectOutputStream;
            boolean z = false;
            for (String str : this.a.keySet()) {
                String str2 = (String) this.a.get(str);
                String str3 = (String) ConfigManager.this.d.get(str);
                if (str2 != null && !str2.equals(str3)) {
                    ConfigManager.this.d.put(str, str2);
                    if (ConfigManager.DEBUG) {
                        Log.i("AOP-CONFIG", String.format("Key %s updated %s -> %s", str, str3, str2));
                    }
                    z = true;
                }
            }
            if (z) {
                File a = ConfigManager.this.a();
                try {
                } catch (IOException e) {
                    Log.e("AOP-CONFIG", "stream close failed", e);
                }
                if (a != null) {
                    try {
                        fileOutputStream = new FileOutputStream(a);
                        try {
                            objectOutputStream = new ObjectOutputStream(fileOutputStream);
                            try {
                                objectOutputStream.writeObject(ConfigManager.this.d);
                                if (ConfigManager.DEBUG) {
                                    Log.i("AOP-CONFIG", "Successfully write config to file: " + ConfigManager.this.d);
                                }
                                try {
                                    fileOutputStream.close();
                                } catch (IOException e2) {
                                    Log.e("AOP-CONFIG", "stream close failed", e2);
                                }
                                objectOutputStream.close();
                            } catch (Throwable th) {
                                th = th;
                                try {
                                    Log.e("AOP-CONFIG", "Write config failed", th);
                                    if (fileOutputStream != null) {
                                        try {
                                            fileOutputStream.close();
                                        } catch (IOException e3) {
                                            Log.e("AOP-CONFIG", "stream close failed", e3);
                                        }
                                    }
                                    if (objectOutputStream != null) {
                                        objectOutputStream.close();
                                    }
                                } catch (Throwable th2) {
                                    if (fileOutputStream != null) {
                                        try {
                                            fileOutputStream.close();
                                        } catch (IOException e4) {
                                            Log.e("AOP-CONFIG", "stream close failed", e4);
                                        }
                                    }
                                    if (objectOutputStream != null) {
                                        try {
                                            objectOutputStream.close();
                                        } catch (IOException e5) {
                                            Log.e("AOP-CONFIG", "stream close failed", e5);
                                        }
                                    }
                                    throw th2;
                                }
                            }
                        } catch (Throwable th3) {
                            th = th3;
                            objectOutputStream = null;
                        }
                    } catch (Throwable th4) {
                        th = th4;
                        fileOutputStream = null;
                        objectOutputStream = null;
                    }
                }
            }
        }
    }

    /* loaded from: classes.dex */
    public class b extends Thread {
        public final /* synthetic */ String a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public b(String str, String str2) {
            super(str);
            this.a = str2;
        }

        @Override // java.lang.Thread, java.lang.Runnable
        public void run() {
            try {
                Cipher cipher = Cipher.getInstance("AES/CBC/PKCS5PADDING");
                cipher.init(1, new SecretKeySpec(ConfigManager.s.getBytes(), "AES"), new IvParameterSpec(ConfigManager.s.getBytes()));
                String encodeToString = Base64.encodeToString(cipher.doFinal(this.a.getBytes()), 0);
                SharedPreferences.Editor edit = ConfigManager.this.a.getSharedPreferences(ConfigManager.p, 0).edit();
                edit.putString("cfg", encodeToString);
                edit.apply();
            } catch (Throwable th) {
                if (ConfigManager.DEBUG) {
                    Log.e("AOP", "write failed", th);
                }
            }
            if (ConfigManager.DEBUG) {
                Log.d("AOP", "Wrote " + this.a + " into sp");
            }
        }
    }

    /* loaded from: classes.dex */
    public class c implements Runnable {
        public c() {
        }

        @Override // java.lang.Runnable
        public void run() {
            try {
                ConfigManager.this.c();
            } catch (Throwable th) {
                Log.e("AOP", "", th);
            }
        }
    }

    /* loaded from: classes.dex */
    public class d extends BroadcastReceiver {
        public d() {
        }

        @Override // android.content.BroadcastReceiver
        public void onReceive(Context context, Intent intent) {
            Serializable serializableExtra = intent.getSerializableExtra("cfg");
            Map<String, String> map = serializableExtra instanceof Map ? (Map) serializableExtra : null;
            String stringExtra = intent.getStringExtra("pkg");
            if (ConfigManager.DEBUG) {
                Log.d("AOP-CONFIG", "Get cfg from main process: " + map + ", pkg=" + stringExtra);
            }
            if (map != null && stringExtra != null && stringExtra.equals(ConfigManager.this.getContext().getPackageName())) {
                try {
                    ConfigManager.this.onConfigChanged(map);
                } catch (Throwable th) {
                    Log.e("AOP-CONFIG", "输入无效配置: " + map.toString(), th);
                }
            }
        }
    }

    /* loaded from: classes.dex */
    public class e implements a.b {
        public e() {
        }

        @Override // com.alibaba.wireless.security.aopsdk.e.a.b
        public void a(String str, String str2, String str3) {
            String a = com.alibaba.wireless.security.aopsdk.e.a.a().a(ConfigManager.m, ConfigManager.CONFIG_KEY, "");
            if (ConfigManager.DEBUG) {
                Log.d("AOP", "Listener on changed, new value=" + a);
            }
            HashMap hashMap = new HashMap();
            hashMap.put(ConfigManager.CONFIG_KEY, a);
            ConfigManager.this.onConfigChanged(hashMap);
        }
    }

    /* loaded from: classes.dex */
    public class f implements a.b {
        public f() {
        }

        @Override // com.alibaba.wireless.security.aopsdk.e.a.b
        public void a(String str, String str2, String str3) {
            boolean a = com.alibaba.wireless.security.aopsdk.e.a.a().a(ConfigManager.m, ConfigManager.SWITCH_KEY, true);
            HashMap hashMap = new HashMap();
            hashMap.put(ConfigManager.SWITCH_KEY, a ? "1" : "0");
            ConfigManager.this.onConfigChanged(hashMap);
        }
    }

    /* loaded from: classes.dex */
    public class g implements c.b {
        public g() {
        }

        @Override // com.alibaba.wireless.security.aopsdk.e.c.b
        public void a(String str, Map<String, String> map) {
            Map<String, String> a = com.alibaba.wireless.security.aopsdk.e.c.a(str);
            com.alibaba.wireless.security.aopsdk.i.a.b("AOP-CONFIG", "Receive config from orange");
            if (a != null) {
                ConfigManager.this.a(a);
            }
        }
    }

    /* loaded from: classes.dex */
    public class h implements ThreadFactory {
        public h() {
        }

        @Override // java.util.concurrent.ThreadFactory
        public Thread newThread(Runnable runnable) {
            return new Thread(runnable, "SecAopConfigUpdate");
        }
    }

    /* loaded from: classes.dex */
    public class i extends Thread {
        public i(String str) {
            super(str);
        }

        @Override // java.lang.Thread, java.lang.Runnable
        public void run() {
            SharedPreferences.Editor edit = ConfigManager.this.a.getSharedPreferences(ConfigManager.p, 0).edit();
            edit.putBoolean(ConfigManager.q, ConfigManager.this.f);
            edit.apply();
        }
    }

    /* loaded from: classes.dex */
    public static class j {
        private final String a;
        private final com.alibaba.wireless.security.aopsdk.e.f.g b;

        public j(String str, com.alibaba.wireless.security.aopsdk.e.f.g gVar) {
            this.a = str;
            this.b = gVar;
        }

        public String a() {
            return this.a;
        }

        public com.alibaba.wireless.security.aopsdk.e.f.g b() {
            return this.b;
        }
    }

    private ConfigManager() {
    }

    private Map<String, String> f() {
        Map<String, String> e2;
        synchronized (w) {
            e2 = e();
        }
        return e2;
    }

    private String g() {
        if (this.h) {
            String string = this.a.getSharedPreferences(p, 0).getString("cfg", "");
            if (!TextUtils.isEmpty(string)) {
                try {
                    byte[] decode = Base64.decode(string, 0);
                    Cipher cipher = Cipher.getInstance("AES/CBC/PKCS5PADDING");
                    cipher.init(2, new SecretKeySpec(s.getBytes(), "AES"), new IvParameterSpec(s.getBytes()));
                    return new String(cipher.doFinal(decode));
                } catch (Throwable th) {
                    if (DEBUG) {
                        Log.e("AOP", "read failed", th);
                    }
                }
            }
        }
        return "";
    }

    public static synchronized ConfigManager getInstance() {
        ConfigManager configManager;
        synchronized (ConfigManager.class) {
            if (k == null) {
                k = new ConfigManager();
            }
            configManager = k;
        }
        return configManager;
    }

    public void forceDisable() {
        this.g = true;
    }

    public void forceEnable() {
        this.g = false;
        this.f = true;
    }

    public j getConfig() {
        j jVar;
        synchronized (v) {
            jVar = this.b;
        }
        return jVar;
    }

    public int getConfigId() {
        return getTopLevelConfig().e;
    }

    public Context getContext() {
        return this.a;
    }

    public com.alibaba.wireless.security.aopsdk.e.f.g getTopLevelConfig() {
        return getConfig().b();
    }

    public void init(Context context, boolean z) {
        if (context.getApplicationContext() != null) {
            context = context.getApplicationContext();
        }
        this.a = context;
        b();
        Map<String, String> f2 = f();
        if (!d()) {
            a(this.a);
        }
        if (f2 != null && !f2.isEmpty()) {
            a(f2, false);
        } else {
            com.alibaba.wireless.security.aopsdk.e.f.g gVar = new com.alibaba.wireless.security.aopsdk.e.f.g();
            com.alibaba.wireless.security.aopsdk.e.f.c cVar = new com.alibaba.wireless.security.aopsdk.e.f.c();
            gVar.f = cVar;
            cVar.f = DEBUG ? 1 : 0;
            gVar.f.k = 1;
            setConfig("", gVar);
            setChanged();
            notifyObservers(gVar);
        }
        this.e = Executors.newSingleThreadScheduledExecutor(new h());
        if (z) {
            a(0);
        }
    }

    public boolean isEnabled() {
        return !this.g && this.f;
    }

    public boolean isTaobao() {
        if (this.c == null) {
            this.c = Boolean.valueOf(TextUtils.equals(this.a.getPackageName(), "com.taobao.taobao"));
        }
        return this.c.booleanValue();
    }

    public void onConfigChanged(Map<String, String> map) {
        a(map, true);
    }

    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:18:0x007a -> B:19:0x0059). Please submit an issue!!! */
    public void parseConfig(String str) {
        if (str != null) {
            if (getConfig() == null || !TextUtils.equals(str, getConfig().a())) {
                if (DEBUG) {
                    Log.d("AOP-CONFIG", "Update config string to " + str);
                }
                try {
                    JSONObject jSONObject = new JSONObject(str);
                    int i2 = jSONObject.getInt("v");
                    if (i2 <= 1) {
                        com.alibaba.wireless.security.aopsdk.e.f.g gVar = new com.alibaba.wireless.security.aopsdk.e.f.g();
                        gVar.b(jSONObject);
                        setConfig(str, gVar);
                        setChanged();
                        notifyObservers(gVar);
                        com.alibaba.wireless.security.aopsdk.i.a.b("AOP-CONFIG", "Config update complete");
                    } else {
                        com.alibaba.wireless.security.aopsdk.i.a.a("AOP-CONFIG", "Config version " + i2 + " not supported");
                    }
                } catch (Throwable th) {
                    Log.e("AOP-CONFIG", "", th);
                }
            }
        }
    }

    public void resetSamplingCount() {
        getTopLevelConfig().f.d = 0;
    }

    public void setConfig(String str, com.alibaba.wireless.security.aopsdk.e.f.g gVar) {
        synchronized (v) {
            this.b = new j(str, gVar);
        }
    }

    public void updateEnableStatus(boolean z) {
        if (DEBUG) {
            Log.d("AOP", "Update enable status in main process to " + z);
        }
        this.f = z;
        if (this.h) {
            new i("AopCfgPersist").start();
        }
    }

    private void b() {
        addObserver(com.alibaba.wireless.security.aopsdk.e.d.a());
        addObserver(new ReportManager.a());
    }

    private void c(Map<String, String> map) {
        synchronized (w) {
            b(map);
        }
    }

    private boolean d() {
        if (!this.j) {
            this.i = this.a.getPackageName().equals(com.alibaba.wireless.security.aopsdk.d.e(this.a));
            this.j = true;
        }
        return this.i;
    }

    private Map<String, String> e() {
        FileInputStream fileInputStream;
        ObjectInputStream objectInputStream;
        if (this.h) {
            long currentTimeMillis = DEBUG ? System.currentTimeMillis() : 0L;
            try {
                File a2 = a();
                if (a2 == null || !a2.isFile()) {
                    fileInputStream = null;
                    objectInputStream = null;
                } else {
                    fileInputStream = new FileInputStream(a2);
                    try {
                        objectInputStream = new ObjectInputStream(fileInputStream);
                        try {
                            Object readObject = objectInputStream.readObject();
                            if (readObject instanceof Map) {
                                if (DEBUG) {
                                    Log.i("AOP-CONFIG", "Load config from file " + readObject);
                                }
                                Map<String, String> map = (Map) readObject;
                                this.d.putAll(map);
                                try {
                                    fileInputStream.close();
                                } catch (IOException e2) {
                                    Log.e("AOP-CONFIG", "stream close failed", e2);
                                }
                                try {
                                    objectInputStream.close();
                                } catch (IOException e3) {
                                    Log.e("AOP-CONFIG", "stream close failed", e3);
                                }
                                if (DEBUG) {
                                    Log.i("AOP-CONFIG", "LoadPersistentConfig cost " + (System.currentTimeMillis() - currentTimeMillis) + " ms");
                                    return map;
                                }
                                return map;
                            }
                        } catch (Throwable th) {
                            th = th;
                            try {
                                Log.e("AOP-CONFIG", "load config failed", th);
                                return null;
                            } finally {
                                if (fileInputStream != null) {
                                    try {
                                        fileInputStream.close();
                                    } catch (IOException e4) {
                                        Log.e("AOP-CONFIG", "stream close failed", e4);
                                    }
                                }
                                if (objectInputStream != null) {
                                    try {
                                        objectInputStream.close();
                                    } catch (IOException e5) {
                                        Log.e("AOP-CONFIG", "stream close failed", e5);
                                    }
                                }
                                if (DEBUG) {
                                    Log.i("AOP-CONFIG", "LoadPersistentConfig cost " + (System.currentTimeMillis() - currentTimeMillis) + " ms");
                                }
                            }
                        }
                    } catch (Throwable th2) {
                        th = th2;
                        objectInputStream = null;
                    }
                }
                if (fileInputStream != null) {
                    try {
                        fileInputStream.close();
                    } catch (IOException e6) {
                        Log.e("AOP-CONFIG", "stream close failed", e6);
                    }
                }
                if (objectInputStream != null) {
                    try {
                        objectInputStream.close();
                    } catch (IOException e7) {
                        Log.e("AOP-CONFIG", "stream close failed", e7);
                    }
                }
                if (DEBUG) {
                    Log.i("AOP-CONFIG", "LoadPersistentConfig cost " + (System.currentTimeMillis() - currentTimeMillis) + " ms");
                }
            } catch (Throwable th3) {
                th = th3;
                fileInputStream = null;
                objectInputStream = null;
            }
        }
        return null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public File a() {
        String e2 = com.alibaba.wireless.security.aopsdk.d.e(this.a);
        if (e2 == null) {
            e2 = JSMethod.NOT_SET;
        }
        File file = new File(this.a.getFilesDir(), o + File.separator + e2);
        if (!file.isDirectory()) {
            file.mkdirs();
        }
        if (file.exists()) {
            return new File(file, "cfg");
        }
        return null;
    }

    private void b(Map<String, String> map) {
        if (this.h) {
            new a("AopCfgPersist", map).start();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void c() {
        if (com.alibaba.wireless.security.aopsdk.e.a.a().c()) {
            if (d()) {
                updateEnableStatus(com.alibaba.wireless.security.aopsdk.e.a.a().a(m, SWITCH_KEY, true));
                String str = null;
                try {
                    str = com.alibaba.wireless.security.aopsdk.e.a.a().a(m, CONFIG_KEY, "");
                    if (DEBUG) {
                        Log.d("AOP", "Config get in main process=" + str);
                    }
                } catch (Throwable th) {
                }
                if (!TextUtils.equals(getConfig().a(), str)) {
                    a(str);
                }
                if (!TextUtils.isEmpty(str)) {
                    parseConfig(str);
                    if (DEBUG) {
                        Log.d("AOP", "parseConfig finished");
                    }
                    com.alibaba.wireless.security.aopsdk.e.a.a().a(m, CONFIG_KEY, new e());
                    com.alibaba.wireless.security.aopsdk.e.a.a().a(m, SWITCH_KEY, new f());
                    if (DEBUG) {
                        Log.d("AOP", "addConfigChangeListener finished");
                        return;
                    }
                    return;
                }
                a(5);
                return;
            }
            boolean z = this.a.getSharedPreferences(p, 0).getBoolean(q, true);
            if (z != this.f) {
                this.f = z;
                if (DEBUG) {
                    Log.d("AOP", "Update enable status in child process to " + this.f);
                }
            }
        } else if (com.alibaba.wireless.security.aopsdk.e.c.a()) {
            com.alibaba.wireless.security.aopsdk.e.c.a(new g());
        }
    }

    private void a(String str) {
        if (this.h) {
            new b("AopCfgPersist", str).start();
        }
    }

    private void a(int i2) {
        ScheduledExecutorService scheduledExecutorService = this.e;
        if (scheduledExecutorService != null) {
            scheduledExecutorService.schedule(new c(), i2, TimeUnit.SECONDS);
        }
    }

    private void a(Map<String, String> map, boolean z) {
        if ((map instanceof Serializable) && z) {
            c(map);
            if (d()) {
                Intent intent = new Intent(t);
                if (DEBUG) {
                    Log.d("AOP-CONFIG", "Sync to child process: " + map.toString());
                }
                intent.putExtra("cfg", (Serializable) map);
                intent.putExtra("pkg", getContext().getPackageName());
                this.a.sendBroadcast(intent);
            }
        }
        a(map);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(Map<String, String> map) {
        int parseInt;
        if (DEBUG) {
            Log.d("AOP-CONFIG", "Orange change listener triggered " + new JSONObject(map).toString());
        }
        if (map != null) {
            for (String str : map.keySet()) {
                str.hashCode();
                char c2 = 65535;
                switch (str.hashCode()) {
                    case -1326904352:
                        if (str.equals(CONFIG_KEY)) {
                            c2 = 0;
                            break;
                        }
                        break;
                    case -500158979:
                        if (str.equals(STACK_FILTER_KEY)) {
                            c2 = 1;
                            break;
                        }
                        break;
                    case 460533202:
                        if (str.equals(SWITCH_KEY)) {
                            c2 = 2;
                            break;
                        }
                        break;
                    case 813191779:
                        if (str.equals(CALLBACK_KEY)) {
                            c2 = 3;
                            break;
                        }
                        break;
                    case 1183330610:
                        if (str.equals(APP_INFO_KEY)) {
                            c2 = 4;
                            break;
                        }
                        break;
                    case 1374880918:
                        if (str.equals(STACK_LIMIT_KEY)) {
                            c2 = 5;
                            break;
                        }
                        break;
                    case 1490537510:
                        if (str.equals(PERSIST_KEY)) {
                            c2 = 6;
                            break;
                        }
                        break;
                    case 1552324038:
                        if (str.equals(LOG_KEY)) {
                            c2 = 7;
                            break;
                        }
                        break;
                }
                switch (c2) {
                    case 0:
                        String str2 = map.get(CONFIG_KEY);
                        if (DEBUG) {
                            Log.d("AOP-CONFIG", "New config get=" + str2);
                        }
                        if (TextUtils.isEmpty(str2)) {
                            break;
                        } else {
                            parseConfig(str2);
                            break;
                        }
                    case 1:
                        com.alibaba.wireless.security.aopsdk.d.a("1".equals(map.get(STACK_FILTER_KEY)));
                        break;
                    case 2:
                        this.f = "1".equals(map.get(SWITCH_KEY));
                        break;
                    case 3:
                        String str3 = map.get(CALLBACK_KEY);
                        if (TextUtils.isEmpty(str3)) {
                            break;
                        } else {
                            AopManager.getInstance().setDelegateEnabled("1".equals(str3));
                            break;
                        }
                    case 4:
                        com.alibaba.wireless.security.aopsdk.d.c("1".equals(map.get(APP_INFO_KEY)));
                        break;
                    case 5:
                        String str4 = map.get(STACK_LIMIT_KEY);
                        if (str4 != null && (parseInt = Integer.parseInt(str4)) > 0) {
                            com.alibaba.wireless.security.aopsdk.d.a(parseInt);
                            break;
                        }
                        break;
                    case 6:
                        if ("1".equals(map.get(PERSIST_KEY))) {
                            this.h = true;
                            break;
                        } else {
                            break;
                        }
                    case 7:
                        DEBUG = "1".equals(map.get(LOG_KEY));
                        com.alibaba.wireless.security.aopsdk.i.a.b("AOP-CONFIG", "Debug log enabled status=" + DEBUG);
                        break;
                    default:
                        com.alibaba.wireless.security.aopsdk.i.a.a("AOP-CONFIG", "Key " + str + " not valid");
                        break;
                }
            }
            com.alibaba.wireless.security.aopsdk.i.a.a("Hornet", "" + (getTopLevelConfig().f.f * 1000) + 2123);
        }
    }

    private void a(Context context) {
        if (context != null) {
            if (DEBUG) {
                Log.d("AOP-CONFIG", "register config broadcast listener in child process");
            }
            context.registerReceiver(new d(), new IntentFilter(t));
        }
    }
}
