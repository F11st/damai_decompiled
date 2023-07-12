package com.ut.mini.behavior.config;

import android.content.Context;
import com.alibaba.analytics.core.Variables;
import com.alibaba.analytics.utils.Logger;
import com.alibaba.fastjson.JSON;
import com.uc.webview.export.extension.UCCore;
import com.ut.mini.behavior.module.ModulesConfig;
import com.ut.mini.behavior.module.ModulesMgr;
import com.ut.mini.behavior.trigger.TriggerConfig;
import com.ut.mini.behavior.trigger.TriggerMgr;
import java.io.File;
import java.util.Random;
import tb.hl2;
import tb.hn;
import tb.s01;
import tb.si0;
import tb.sj;
import tb.yh2;

/* compiled from: Taobao */
/* loaded from: classes11.dex */
public class UTBehaviorConfigMgr {
    private static final int MAX_SAMPLING_SEED = 10000;
    private static final String TAG = "UTBehaviorConfigMgr";
    private static final String UT_BEHAVIOR_CONFIG_FILE = "3c080a1447baf9ff";
    private static final int VERSION = 1;
    private static boolean bInit;
    private static int mSampleSeed;
    private static long mTimestamp;
    private static boolean mUpdatingConfig;

    static /* synthetic */ String access$000() {
        return getUTBehaviorConfigFilePath();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void downloadConfig(String str) {
        byte[] bArr;
        if (yh2.f(str)) {
            return;
        }
        String str2 = str + "/v1.json";
        s01.a a = new s01().a(str2);
        Logger.f(TAG, "downloadConfig url", str2, "response", a);
        if (a == null || (bArr = a.a) == null) {
            return;
        }
        try {
            String str3 = new String(bArr, 0, bArr.length);
            if (init(str3)) {
                si0.d(getUTBehaviorConfigFilePath(), str3);
            }
        } catch (Throwable th) {
            Logger.h(TAG, th, new Object[0]);
        }
    }

    public static boolean enableSample(long j) {
        return ((long) mSampleSeed) < j;
    }

    private static String getUTBehaviorConfigFilePath() {
        Context j = Variables.n().j();
        if (j == null) {
            j = sj.c().b();
        }
        if (j == null) {
            return null;
        }
        StringBuilder sb = new StringBuilder();
        sb.append(j.getFilesDir().getAbsolutePath());
        String str = File.separator;
        sb.append(str);
        sb.append(hn.UT_FILE_DIR);
        String sb2 = sb.toString();
        si0.b(sb2);
        return sb2 + str + UT_BEHAVIOR_CONFIG_FILE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static boolean init(String str) {
        if (yh2.f(str)) {
            initNull();
            return false;
        }
        try {
            UTBehaviorConfig uTBehaviorConfig = (UTBehaviorConfig) JSON.parseObject(str, UTBehaviorConfig.class);
            if (uTBehaviorConfig != null && uTBehaviorConfig.v == 1) {
                mTimestamp = uTBehaviorConfig.timestamp;
                ModulesMgr.getInstance().init(uTBehaviorConfig.modulesConfig);
                TriggerMgr.getInstance().init(uTBehaviorConfig.triggerConfig);
                Logger.f(TAG, "init config timestamp", Long.valueOf(mTimestamp));
                return true;
            }
        } catch (Exception e) {
            Logger.h(TAG, e, new Object[0]);
        }
        initNull();
        return false;
    }

    public static synchronized void initConfig() {
        synchronized (UTBehaviorConfigMgr.class) {
            if (bInit) {
                return;
            }
            bInit = true;
            Logger.f(TAG, UCCore.LEGACY_EVENT_INIT);
            mSampleSeed = new Random().nextInt(10000);
            hl2.c().f(new Runnable() { // from class: com.ut.mini.behavior.config.UTBehaviorConfigMgr.1
                @Override // java.lang.Runnable
                public void run() {
                    String access$000 = UTBehaviorConfigMgr.access$000();
                    if (access$000 != null) {
                        UTBehaviorConfigMgr.init(si0.c(access$000));
                    }
                    UTBehaviorConfigListener.init();
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void initNull() {
        mTimestamp = 0L;
        ModulesMgr.getInstance().init((ModulesConfig) null);
        TriggerMgr.getInstance().init((TriggerConfig) null);
        Logger.f(TAG, "init null config");
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static void updateConfig(final String str, final long j) {
        hl2.c().f(new Runnable() { // from class: com.ut.mini.behavior.config.UTBehaviorConfigMgr.2
            @Override // java.lang.Runnable
            public void run() {
                if (!UTBehaviorConfigMgr.mUpdatingConfig) {
                    boolean unused = UTBehaviorConfigMgr.mUpdatingConfig = true;
                    Logger.f(UTBehaviorConfigMgr.TAG, "updateConfig host", str, "timestamp", Long.valueOf(j));
                    if (yh2.f(str)) {
                        UTBehaviorConfigMgr.initNull();
                        String access$000 = UTBehaviorConfigMgr.access$000();
                        if (access$000 != null) {
                            si0.a(access$000);
                            return;
                        }
                        return;
                    }
                    Logger.f(UTBehaviorConfigMgr.TAG, "File Timestamp", Long.valueOf(UTBehaviorConfigMgr.mTimestamp));
                    if (j > UTBehaviorConfigMgr.mTimestamp) {
                        UTBehaviorConfigMgr.downloadConfig(str);
                    } else {
                        Logger.f(UTBehaviorConfigMgr.TAG, "Do not need update Config");
                    }
                    boolean unused2 = UTBehaviorConfigMgr.mUpdatingConfig = false;
                    return;
                }
                Logger.f(UTBehaviorConfigMgr.TAG, "Config is updating...");
            }
        });
    }
}
