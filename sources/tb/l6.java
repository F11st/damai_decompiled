package tb;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.taobao.update.adapter.UpdateMonitor;
import com.taobao.update.apk.MainUpdateData;
import com.taobao.update.apk.history.ApkUpdateHistory;
import com.taobao.update.datasource.UpdateDataSource;
import com.taobao.update.datasource.UpdateListener;
import com.taobao.update.datasource.logger.Log;
import com.taobao.update.framework.UpdateRuntime;
import com.taobao.update.main.R$string;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;

/* compiled from: Taobao */
/* loaded from: classes11.dex */
public class l6 extends mu2 implements UpdateListener {
    private UpdateListener.PatchListener a;
    private UpdateMonitor b;
    private Log c = ub1.getLog(l6.class, (Log) null);

    public l6() {
        UpdateDataSource.getInstance().registerListener(lu2.MAIN, this);
        this.b = (UpdateMonitor) wb.getInstance(UpdateMonitor.class);
        try {
            b();
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    private void a() {
        File[] listFiles;
        File file = new File(pu2.getStorePath(UpdateRuntime.getContext()) + "/apkupdate");
        if (!file.exists() || file.listFiles() == null) {
            return;
        }
        String versionName = pu2.getVersionName();
        for (File file2 : file.listFiles()) {
            if (pu2.greaterThen(versionName, file2.getName())) {
                we.deleteDir(file2);
            }
        }
    }

    private void b() {
        String str;
        String str2;
        ApkUpdateHistory.Data data = ApkUpdateHistory.getData();
        if (data != null) {
            boolean equals = pu2.getVersionName().equals(data.toVersion);
            if (equals) {
                try {
                    new File(data.ext).delete();
                } catch (Throwable th) {
                    th.printStackTrace();
                }
            }
            if (equals) {
                str = "";
                str2 = str;
            } else {
                str = String.valueOf(pu2.getVersionName().equals(data.fromVersion) ? -71 : -72);
                str2 = "fromVersion=" + data.fromVersion + ",toVersion=" + data.toVersion;
            }
            UpdateMonitor updateMonitor = this.b;
            if (updateMonitor != null) {
                updateMonitor.add("apefficiency", equals, "install", str, str2, data.fromVersion, data.toVersion, "");
                this.b.commit("apefficiency");
            }
            ApkUpdateHistory.reset();
        }
        a();
    }

    @Override // tb.mu2
    public boolean doUpdate(JSONObject jSONObject, boolean z, String str) {
        if (jSONObject == null || !pu2.greaterThen(jSONObject.getString("version"), pu2.getVersionName())) {
            if (z) {
                return false;
            }
            UpdateRuntime.toast(pu2.getAppNameString(R$string.notice_noupdate, UpdateRuntime.sAppName));
            return false;
        }
        UpdateListener.PatchListener patchListener = this.a;
        if (patchListener != null) {
            patchListener.patchStart();
        }
        try {
            MainUpdateData mainUpdateData = (MainUpdateData) pu2.toJavaObject(jSONObject, MainUpdateData.class);
            File file = new File("/sdcard/test_pri.txt");
            if (file.exists()) {
                try {
                    BufferedReader bufferedReader = new BufferedReader(new FileReader(file));
                    String trim = bufferedReader.readLine().trim();
                    android.util.Log.e("update", " FIXME delete before release ... " + trim);
                    if (trim != null) {
                        mainUpdateData.remindStrategy = Integer.valueOf(trim).intValue();
                        String trim2 = bufferedReader.readLine().trim();
                        if (trim2 != null) {
                            mainUpdateData.remindCount = Integer.valueOf(trim2).intValue();
                        }
                    }
                } catch (Throwable unused) {
                }
            }
            android.util.Log.e("main_update", JSON.toJSONString(mainUpdateData));
            el2 execute = new com.taobao.update.apk.a().execute(z, mainUpdateData);
            if (execute != null && execute.success) {
                UpdateDataSource.getInstance().clearCache();
                UpdateListener.PatchListener patchListener2 = this.a;
                if (patchListener2 != null) {
                    patchListener2.patchSuccess();
                    return true;
                }
                return true;
            }
            UpdateListener.PatchListener patchListener3 = this.a;
            if (patchListener3 != null) {
                patchListener3.patchFailed(execute.errorMsg);
                return true;
            }
            return true;
        } catch (Throwable th) {
            th.printStackTrace();
            return true;
        }
    }

    @Override // com.taobao.update.datasource.UpdateListener
    public void onUpdate(boolean z, JSONObject jSONObject, String str) {
        doUpdate(jSONObject, z, str);
    }

    @Override // com.taobao.update.datasource.UpdateListener
    public void patchProcessListener(UpdateListener.PatchListener patchListener) {
        this.a = patchListener;
    }
}
