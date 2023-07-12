package com.taobao.update;

import android.preference.PreferenceManager;
import android.text.TextUtils;
import android.util.Log;
import com.alibaba.mtl.appmonitor.AppMonitor;
import com.taobao.orange.OrangeConfig;
import com.taobao.orange.OrangeConfigListener;
import com.taobao.update.datasource.UpdateDataSource;
import com.taobao.update.framework.UpdateRuntime;
import com.taobao.update.instantpatch.InstantPatchUpdater;
import java.util.ArrayList;
import java.util.List;
import tb.C9444mm;
import tb.fk;
import tb.hu2;
import tb.i30;
import tb.ju2;
import tb.l6;
import tb.lu2;
import tb.mu2;
import tb.ne2;
import tb.pu2;
import tb.qp;

/* compiled from: Taobao */
/* loaded from: classes11.dex */
public class UpdateSDK {
    private List<mu2> a = new ArrayList();

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: Taobao */
    /* renamed from: com.taobao.update.UpdateSDK$a */
    /* loaded from: classes11.dex */
    public class C6913a implements OrangeConfigListener {
        final /* synthetic */ ju2 a;

        C6913a(UpdateSDK updateSDK, ju2 ju2Var) {
            this.a = ju2Var;
        }

        @Override // com.taobao.orange.OrangeConfigListener
        public void onConfigUpdate(String str) {
            String config = OrangeConfig.getInstance().getConfig(lu2.UPDATE_CONFIG_GROUP, lu2.AUTO_START_BUNDLES, "");
            if (TextUtils.isEmpty(config)) {
                return;
            }
            PreferenceManager.getDefaultSharedPreferences(this.a.config.application).edit().putString(lu2.AUTO_START_BUNDLES, config).apply();
        }
    }

    public UpdateSDK(ju2 ju2Var) {
        C9444mm c9444mm = ju2Var.config;
        if (c9444mm == null) {
            return;
        }
        if (!UpdateDataSource.inited) {
            UpdateDataSource.getInstance().init(c9444mm.application, c9444mm.group, c9444mm.ttid, c9444mm.isOutApk, new hu2());
            this.a.add(new i30(c9444mm));
        }
        b(c9444mm);
        if (ju2Var.apkUpdateEnabled) {
            this.a.add(new l6());
        }
        this.a.add(new fk());
        InstantPatchUpdater.instance().init(c9444mm.application);
        UpdateDataSource.getInstance().registerListener(lu2.HOTPATCH, InstantPatchUpdater.instance());
        this.a.add(InstantPatchUpdater.instance());
        if (c9444mm.enabledSoLoader) {
            ne2 instance = ne2.instance();
            instance.init(c9444mm.application);
            UpdateDataSource.getInstance().registerListener(instance.registerName(), instance);
            this.a.add(instance);
        }
    }

    private void b(C9444mm c9444mm) {
        int currentRuntimeCpuArchValue = qp.getCurrentRuntimeCpuArchValue(c9444mm.application);
        String versionName = pu2.getVersionName();
        if (PreferenceManager.getDefaultSharedPreferences(c9444mm.application).getInt(versionName.concat("_bit_runtime"), 0) == 0) {
            AppMonitor.Counter.commit("update-sdk", "bit-runtime", currentRuntimeCpuArchValue);
            PreferenceManager.getDefaultSharedPreferences(c9444mm.application).edit().putInt(versionName.concat("_bit_runtime"), currentRuntimeCpuArchValue).apply();
        }
    }

    public void init(ju2 ju2Var) {
        for (mu2 mu2Var : this.a) {
            try {
                mu2Var.init(ju2Var.config.application);
            } catch (Throwable th) {
                Log.e("UpdateSDK", " updateLifeCycle:" + mu2Var.getClass().getName(), th);
            }
        }
        if (ju2Var.checkUpdateOnStartUp) {
            UpdateDataSource.getInstance().startUpdate(true, false);
        }
        OrangeConfig.getInstance().registerListener(new String[]{lu2.UPDATE_CONFIG_GROUP}, new C6913a(this, ju2Var));
    }

    public void onBackground() {
        for (mu2 mu2Var : this.a) {
            mu2Var.onBackground();
        }
    }

    public void onExit() {
        for (mu2 mu2Var : this.a) {
            mu2Var.onExit();
        }
    }

    public void onForeground() {
        UpdateRuntime.execute(new Runnable() { // from class: com.taobao.update.UpdateSDK.2
            @Override // java.lang.Runnable
            public void run() {
                for (mu2 mu2Var : UpdateSDK.this.a) {
                    mu2Var.onForeground();
                }
            }
        });
    }
}
