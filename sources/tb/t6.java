package tb;

import android.app.Application;
import android.content.Context;
import com.alibaba.pictures.cornerstone.EnvMode;
import com.alibaba.pictures.cornerstone.protocol.IAppInfo;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: Taobao */
/* loaded from: classes7.dex */
public final class t6 extends hb<IAppInfo> implements IAppInfo {
    private static transient /* synthetic */ IpChange $ipChange;
    @NotNull
    public static final t6 INSTANCE;

    static {
        t6 t6Var = new t6();
        INSTANCE = t6Var;
        hb.f(t6Var, new s6(), null, 2, null);
    }

    private t6() {
    }

    @Override // com.alibaba.pictures.cornerstone.protocol.IAppInfo
    public boolean debugable() {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "1338003244") ? ((Boolean) ipChange.ipc$dispatch("1338003244", new Object[]{this})).booleanValue() : a().debugable();
    }

    @Override // com.alibaba.pictures.cornerstone.protocol.IAppInfo
    @NotNull
    public String getAppClientName() {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "-1479388532") ? (String) ipChange.ipc$dispatch("-1479388532", new Object[]{this}) : a().getAppClientName();
    }

    @Override // com.alibaba.pictures.cornerstone.protocol.IAppInfo
    @NotNull
    public Context getAppContext() {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "-1513826903") ? (Context) ipChange.ipc$dispatch("-1513826903", new Object[]{this}) : a().getAppContext();
    }

    @Override // com.alibaba.pictures.cornerstone.protocol.IAppInfo
    @Nullable
    public String getAppKey() {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "1579890239") ? (String) ipChange.ipc$dispatch("1579890239", new Object[]{this}) : a().getAppKey();
    }

    @Override // com.alibaba.pictures.cornerstone.protocol.IAppInfo
    @NotNull
    public Application getApplication() {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "-253601046") ? (Application) ipChange.ipc$dispatch("-253601046", new Object[]{this}) : a().getApplication();
    }

    @Override // com.alibaba.pictures.cornerstone.protocol.IAppInfo
    @Nullable
    public String getChannelId() {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "1744136595") ? (String) ipChange.ipc$dispatch("1744136595", new Object[]{this}) : a().getChannelId();
    }

    @Override // com.alibaba.pictures.cornerstone.protocol.IAppInfo
    @NotNull
    public EnvMode getEnv() {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "2049319023") ? (EnvMode) ipChange.ipc$dispatch("2049319023", new Object[]{this}) : a().getEnv();
    }

    @Override // com.alibaba.pictures.cornerstone.protocol.IAppInfo
    @Nullable
    public String getPackageName() {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "1292092934") ? (String) ipChange.ipc$dispatch("1292092934", new Object[]{this}) : a().getPackageName();
    }

    @Override // com.alibaba.pictures.cornerstone.protocol.IAppInfo
    @Nullable
    public String getTTID() {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "-1949127108") ? (String) ipChange.ipc$dispatch("-1949127108", new Object[]{this}) : a().getTTID();
    }

    @Override // com.alibaba.pictures.cornerstone.protocol.IAppInfo
    @Nullable
    public Integer getVersionCode() {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "-1010001907") ? (Integer) ipChange.ipc$dispatch("-1010001907", new Object[]{this}) : a().getVersionCode();
    }

    @Override // com.alibaba.pictures.cornerstone.protocol.IAppInfo
    @Nullable
    public String getVersionName() {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "1046976664") ? (String) ipChange.ipc$dispatch("1046976664", new Object[]{this}) : a().getVersionName();
    }

    @Override // com.alibaba.pictures.cornerstone.protocol.IAppInfo
    public boolean isFullApp() {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "-135672079") ? ((Boolean) ipChange.ipc$dispatch("-135672079", new Object[]{this})).booleanValue() : a().isFullApp();
    }

    @Override // com.alibaba.pictures.cornerstone.protocol.IAppInfo
    public boolean isPreInstall() {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "864557303") ? ((Boolean) ipChange.ipc$dispatch("864557303", new Object[]{this})).booleanValue() : a().isPreInstall();
    }
}
