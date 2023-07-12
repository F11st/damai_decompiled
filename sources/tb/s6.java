package tb;

import android.app.Application;
import android.content.Context;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.os.Build;
import com.alibaba.pictures.cornerstone.APPClient;
import com.alibaba.pictures.cornerstone.EnvMode;
import com.alibaba.pictures.cornerstone.protocol.IAppInfo;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: Taobao */
/* loaded from: classes7.dex */
public class s6 implements IAppInfo {
    private static transient /* synthetic */ IpChange $ipChange;
    @Nullable
    private Boolean a;

    @Override // com.alibaba.pictures.cornerstone.protocol.IAppInfo
    public boolean debugable() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-865519636")) {
            return ((Boolean) ipChange.ipc$dispatch("-865519636", new Object[]{this})).booleanValue();
        }
        if (this.a == null) {
            this.a = Boolean.valueOf((getApplication().getApplicationInfo().flags & 2) != 0);
        }
        Boolean bool = this.a;
        b41.f(bool);
        return bool.booleanValue();
    }

    @Override // com.alibaba.pictures.cornerstone.protocol.IAppInfo
    @NotNull
    public String getAppClientName() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1770194100")) {
            return (String) ipChange.ipc$dispatch("-1770194100", new Object[]{this});
        }
        String c = ko.INSTANCE.c();
        return c != null ? c : APPClient.TPP.getClientName();
    }

    @Override // com.alibaba.pictures.cornerstone.protocol.IAppInfo
    @NotNull
    public Context getAppContext() {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "2037194345") ? (Context) ipChange.ipc$dispatch("2037194345", new Object[]{this}) : ko.INSTANCE.a();
    }

    @Override // com.alibaba.pictures.cornerstone.protocol.IAppInfo
    @NotNull
    public String getAppKey() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1759044991")) {
            return (String) ipChange.ipc$dispatch("1759044991", new Object[]{this});
        }
        String appKey = ko.INSTANCE.b().getAppKey();
        return appKey != null ? appKey : "";
    }

    @Override // com.alibaba.pictures.cornerstone.protocol.IAppInfo
    @NotNull
    public Application getApplication() {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "-1841092054") ? (Application) ipChange.ipc$dispatch("-1841092054", new Object[]{this}) : ko.INSTANCE.a();
    }

    @Override // com.alibaba.pictures.cornerstone.protocol.IAppInfo
    @NotNull
    public String getChannelId() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "299004499")) {
            return (String) ipChange.ipc$dispatch("299004499", new Object[]{this});
        }
        String channelId = ko.INSTANCE.b().getChannelId();
        return channelId != null ? channelId : "";
    }

    @Override // com.alibaba.pictures.cornerstone.protocol.IAppInfo
    @NotNull
    public EnvMode getEnv() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-644187857")) {
            return (EnvMode) ipChange.ipc$dispatch("-644187857", new Object[]{this});
        }
        EnvMode env = ko.INSTANCE.b().getEnv();
        return env != null ? env : EnvMode.ONLINE;
    }

    @Override // com.alibaba.pictures.cornerstone.protocol.IAppInfo
    @NotNull
    public String getPackageName() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-205414714")) {
            return (String) ipChange.ipc$dispatch("-205414714", new Object[]{this});
        }
        String packageName = getApplication().getPackageName();
        return packageName != null ? packageName : "";
    }

    @Override // com.alibaba.pictures.cornerstone.protocol.IAppInfo
    @NotNull
    public String getTTID() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-2002571908")) {
            return (String) ipChange.ipc$dispatch("-2002571908", new Object[]{this});
        }
        String ttid = ko.INSTANCE.b().getTTID();
        return ttid != null ? ttid : "";
    }

    @Override // com.alibaba.pictures.cornerstone.protocol.IAppInfo
    @Nullable
    public Integer getVersionCode() {
        IpChange ipChange = $ipChange;
        int i = 0;
        if (AndroidInstantRuntime.support(ipChange, "-188098739")) {
            return (Integer) ipChange.ipc$dispatch("-188098739", new Object[]{this});
        }
        Context appContext = getAppContext();
        PackageManager packageManager = appContext.getPackageManager();
        if (Build.VERSION.SDK_INT < 28) {
            try {
                i = packageManager.getPackageInfo(appContext.getPackageName(), 16384).versionCode;
            } catch (PackageManager.NameNotFoundException e) {
                e.printStackTrace();
            }
        } else {
            try {
                PackageInfo packageInfo = packageManager.getPackageInfo(appContext.getPackageName(), 16384);
                b41.h(packageInfo, "info");
                i = (int) packageInfo.getLongVersionCode();
            } catch (PackageManager.NameNotFoundException e2) {
                e2.printStackTrace();
            }
        }
        return Integer.valueOf(i);
    }

    @Override // com.alibaba.pictures.cornerstone.protocol.IAppInfo
    @Nullable
    public String getVersionName() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-450530984")) {
            return (String) ipChange.ipc$dispatch("-450530984", new Object[]{this});
        }
        try {
            return getApplication().getPackageManager().getPackageInfo(getPackageName(), 16384).versionName;
        } catch (PackageManager.NameNotFoundException e) {
            e.printStackTrace();
            return null;
        }
    }

    @Override // com.alibaba.pictures.cornerstone.protocol.IAppInfo
    public boolean isFullApp() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1955772337")) {
            return ((Boolean) ipChange.ipc$dispatch("1955772337", new Object[]{this})).booleanValue();
        }
        return true;
    }

    @Override // com.alibaba.pictures.cornerstone.protocol.IAppInfo
    public boolean isPreInstall() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-5408713")) {
            return ((Boolean) ipChange.ipc$dispatch("-5408713", new Object[]{this})).booleanValue();
        }
        return false;
    }
}
