package com.youku.arch.beast.apas;

import android.content.Context;
import android.content.Intent;
import android.os.Build;
import android.text.TextUtils;
import android.util.Log;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import com.taobao.orange.OConfigListener;
import com.taobao.orange.OrangeConfig;
import com.youku.arch.beast.apas.remote.ApasServiceManager;
import com.youku.arch.beast.hostschedule.HostScheduler;
import com.youku.core.context.YoukuContext;
import com.youku.sopalladium.SoLoaderGui;
import com.youku.util.Logger;
import java.io.File;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/* compiled from: Taobao */
/* loaded from: classes2.dex */
public class Apas {
    private static transient /* synthetic */ IpChange $ipChange = null;
    public static final String APAS_PATH = "apas_configs";
    private static final String PREF_APS_EXTRA_INFO = "pref_aps_extra_info";
    private static Apas sInstance;
    private boolean mApsEnabled;
    private volatile boolean mSendInitialRequest;
    private boolean mUseExtraInfo;
    private ConcurrentHashMap<String, String> mRequestExtraInfo = new ConcurrentHashMap<>();
    private volatile String mClientIp = "";
    private volatile boolean mLocalMode = false;
    private HashMap<ConfigUpdateListener, Long> mListeners = new HashMap<>();
    private long mNativeId = getDefaultNativeManager();

    /* compiled from: Taobao */
    /* loaded from: classes2.dex */
    public interface ConfigUpdateListener {
        void onUpdateConfig(String str, String str2, String str3);
    }

    static {
        try {
            System.loadLibrary("beast");
        } catch (Throwable unused) {
            SoLoaderGui.loadSoWithRelinker("beast");
        }
    }

    private Apas() {
        this.mApsEnabled = true;
        this.mUseExtraInfo = false;
        final Context applicationContext = YoukuContext.getApplicationContext();
        ApasServiceManager.getInstance().init(applicationContext);
        File file = new File(applicationContext.getFilesDir().getAbsolutePath(), APAS_PATH);
        if (file.exists() && !file.isDirectory() && !file.delete()) {
            Log.e("beast", "apas file error!");
        }
        this.mApsEnabled = applicationContext.getSharedPreferences("APAS", 0).getBoolean("apas_enable", true);
        this.mUseExtraInfo = applicationContext.getSharedPreferences("APAS", 0).getBoolean("aps_use_extra_info", false);
        setApsSyncEnable(applicationContext.getSharedPreferences("APAS", 0).getBoolean("apas_sync_load_enable", false));
        configLocalMode(applicationContext);
        loadLocalRequestExtraInfo();
        OrangeConfig.getInstance().registerListener(new String[]{"aps_config"}, new OConfigListener() { // from class: com.youku.arch.beast.apas.Apas.1
            private static transient /* synthetic */ IpChange $ipChange;

            @Override // com.taobao.orange.OConfigListener
            public void onConfigUpdate(String str, Map<String, String> map) {
                IpChange ipChange = $ipChange;
                if (AndroidInstantRuntime.support(ipChange, "-1680056407")) {
                    ipChange.ipc$dispatch("-1680056407", new Object[]{this, str, map});
                    return;
                }
                Apas.this.mApsEnabled = "1".equals(OrangeConfig.getInstance().getConfig("aps_config", "aps_enable", "1"));
                Logger.d("apas", "aps_enable:" + Apas.this.mApsEnabled);
                Apas.this.mUseExtraInfo = "1".equals(OrangeConfig.getInstance().getConfig("aps_config", "aps_use_extra_info", "0"));
                applicationContext.getSharedPreferences("APAS", 0).edit().putBoolean("apas_enable", Apas.this.mApsEnabled).putBoolean("aps_use_extra_info", Apas.this.mUseExtraInfo).putBoolean("apas_sync_load_enable", "1".equals(OrangeConfig.getInstance().getConfig("aps_config", "apas_sync_load_enable", "0"))).apply();
            }
        }, false);
        if (!file.exists()) {
            file.mkdirs();
        }
        updateFolderPath(file.getAbsolutePath());
        String version = HostScheduler.getInstance().getVersion();
        Logger.d("apas", "hostSchedulerVersion:" + version);
    }

    private native long addConfigUpdateListenerNative(String str, ConfigUpdateListener configUpdateListener);

    private void configLocalMode(Context context) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1136963961")) {
            ipChange.ipc$dispatch("1136963961", new Object[]{this, context});
        } else if (context != null) {
            setLocalMode(context.getSharedPreferences("player_egg", Build.VERSION.SDK_INT >= 9 ? 4 : 0).getBoolean("apas_local_mode", false));
        }
    }

    private native long getDefaultNativeManager();

    public static Apas getInstance() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-353794661")) {
            return (Apas) ipChange.ipc$dispatch("-353794661", new Object[0]);
        }
        if (sInstance == null) {
            synchronized (Apas.class) {
                if (sInstance == null) {
                    sInstance = new Apas();
                }
            }
        }
        return sInstance;
    }

    private void loadLocalRequestExtraInfo() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1286731801")) {
            ipChange.ipc$dispatch("-1286731801", new Object[]{this});
        } else if (this.mUseExtraInfo) {
            this.mRequestExtraInfo.putAll(YoukuContext.getApplicationContext().getSharedPreferences(PREF_APS_EXTRA_INFO, 0).getAll());
        }
    }

    private native void removeConfigUpdateListenerNative(String str, long j);

    private native void updateFolderPath(String str);

    public void addConfigUpdateListener(String str, ConfigUpdateListener configUpdateListener) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1414628371")) {
            ipChange.ipc$dispatch("1414628371", new Object[]{this, str, configUpdateListener});
        } else {
            this.mListeners.put(configUpdateListener, Long.valueOf(addConfigUpdateListenerNative(str, configUpdateListener)));
        }
    }

    public boolean apsEnabled() {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "-604721578") ? ((Boolean) ipChange.ipc$dispatch("-604721578", new Object[]{this})).booleanValue() : this.mApsEnabled;
    }

    public native String[] getAllNamespaces();

    public String getClientIp() {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "-874160243") ? (String) ipChange.ipc$dispatch("-874160243", new Object[]{this}) : this.mClientIp;
    }

    public native String getCurrentVersion();

    public native Namespace getNamespace(String str);

    public Map<String, String> getRequestExtraInfo() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "292809547")) {
            return (Map) ipChange.ipc$dispatch("292809547", new Object[]{this});
        }
        if (this.mUseExtraInfo) {
            HashMap hashMap = new HashMap(this.mRequestExtraInfo);
            hashMap.putAll(this.mRequestExtraInfo);
            return hashMap;
        }
        return null;
    }

    public boolean hasSentInitialRequest() {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "1753285890") ? ((Boolean) ipChange.ipc$dispatch("1753285890", new Object[]{this})).booleanValue() : this.mSendInitialRequest;
    }

    public void initRemoteService(Context context) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1189075532")) {
            ipChange.ipc$dispatch("1189075532", new Object[]{this, context});
            return;
        }
        Intent intent = new Intent();
        intent.setAction("com.youku.arch.beast.action.APAS");
        context.startService(intent);
    }

    public boolean isLocalMode() {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "-142836197") ? ((Boolean) ipChange.ipc$dispatch("-142836197", new Object[]{this})).booleanValue() : this.mLocalMode;
    }

    public void removeConfigUpdateListener(String str, ConfigUpdateListener configUpdateListener) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1675854722")) {
            ipChange.ipc$dispatch("1675854722", new Object[]{this, str, configUpdateListener});
        } else if (this.mListeners.containsKey(configUpdateListener)) {
            removeConfigUpdateListenerNative(str, this.mListeners.get(configUpdateListener).longValue());
            this.mListeners.remove(configUpdateListener);
        }
    }

    public native void setApsSyncEnable(boolean z);

    public void setClientIp(String str) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1211491599")) {
            ipChange.ipc$dispatch("-1211491599", new Object[]{this, str});
        } else if (TextUtils.isEmpty(str)) {
        } else {
            this.mClientIp = str;
        }
    }

    public void setInitialRequest(boolean z) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "693844390")) {
            ipChange.ipc$dispatch("693844390", new Object[]{this, Boolean.valueOf(z)});
        } else {
            this.mSendInitialRequest = z;
        }
    }

    public void setLocalMode(boolean z) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "363298481")) {
            ipChange.ipc$dispatch("363298481", new Object[]{this, Boolean.valueOf(z)});
            return;
        }
        Logger.d("apas", "setLocalMode:" + z);
        this.mLocalMode = z;
    }

    public void setRequestExtraInfo(String str, String str2) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1001164574")) {
            ipChange.ipc$dispatch("1001164574", new Object[]{this, str, str2});
        } else if (!this.mUseExtraInfo || TextUtils.isEmpty(str) || TextUtils.isEmpty(str2) || str2.equals(this.mRequestExtraInfo.get(str))) {
        } else {
            this.mRequestExtraInfo.put(str, str2);
            YoukuContext.getApplicationContext().getSharedPreferences(PREF_APS_EXTRA_INFO, 0).edit().putString(str, str2).apply();
        }
    }

    public native void updateConfigData(String str);
}
