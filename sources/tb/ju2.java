package tb;

import com.taobao.update.adapter.UpdateMonitor;

/* compiled from: Taobao */
/* loaded from: classes11.dex */
public class ju2 {
    public boolean apkUpdateEnabled;
    public boolean bundleUpdateEnabled;
    public boolean checkUpdateOnStartUp;
    public mm config;
    public boolean enableNativeLibUpdate;
    public boolean hasTest;
    public boolean lightApkEnabled;

    public ju2(mm mmVar) {
        this.config = mmVar;
    }

    private Class a(String str) {
        try {
            return Class.forName(str);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
            return null;
        }
    }

    public ju2 enableApkUpdate() {
        this.apkUpdateEnabled = true;
        return this;
    }

    public ju2 enableCheckUpdateOnStartup() {
        this.checkUpdateOnStartUp = true;
        return this;
    }

    public ju2 enableMonitor(UpdateMonitor updateMonitor) {
        Class a;
        if (updateMonitor == null && (a = a("com.taobao.update.monitor.UpdateMonitorImpl")) != null) {
            wb.registerClass(a);
        } else if (updateMonitor != null) {
            wb.registerInstance(updateMonitor);
        } else {
            wb.registerInstance(new UpdateMonitor.a());
        }
        return this;
    }
}
