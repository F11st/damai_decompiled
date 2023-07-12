package tb;

import android.app.Application;
import com.taobao.update.adapter.Log;
import com.taobao.update.adapter.NativeLibUpdateListener;
import com.taobao.update.adapter.ThreadExecutor;
import java.util.ArrayList;
import java.util.List;

/* compiled from: Taobao */
/* loaded from: classes11.dex */
public class mm {
    public static List<String> blackDialogActivity = new ArrayList();
    public String appName;
    public Application application;
    public String city;
    public boolean clickBackViewExitDialog;
    public int delayedStartTime;
    public String group;
    public Log logImpl;
    public int logoResourceId;
    public NativeLibUpdateListener nativeLibUpdateListener;
    public boolean popDialogBeforeInstall;
    public boolean push;
    public ThreadExecutor threadExecutorImpl;
    public String ttid;
    public boolean autoStart = true;
    public boolean foregroundRequest = true;
    public int delayedKillAppTime = 5000;
    public boolean forceInstallAfaterDownload = false;
    public boolean installBundleAfterDownload = false;
    public boolean enableNavProcessor = false;
    public boolean isOutApk = false;
    public boolean enabledSoLoader = true;
    public Class uiToastClass = vr2.class;
    public Class uiNotifyClass = sr2.class;
    public Class uiSysNotifyClass = ur2.class;
    public Class uiConfirmClass = qr2.class;
    public int bundleUpdateMinDisk = 200;

    public mm(Application application) {
        this.application = application;
    }
}
