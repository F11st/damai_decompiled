package tb;

import android.app.Application;
import android.content.Context;
import cn.damai.common.AppConfig;
import cn.damai.common.R$drawable;
import com.alibaba.pictures.accs.ACCSEnvMode;
import com.alibaba.pictures.accs.IACCSConfigProvider;
import com.alibaba.pictures.accs.MoiveAccsService;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import java.util.HashMap;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: Taobao */
/* loaded from: classes6.dex */
public final class s2 implements IACCSConfigProvider {
    private static transient /* synthetic */ IpChange $ipChange;
    @NotNull
    private final String a = "openacs.m.taobao.com";
    @NotNull
    private final String b = "openjmacs.m.taobao.com";
    @NotNull
    private final String c = "msgacs.waptest.taobao.com";
    @NotNull
    private final String d = "acs.waptest.taobao.com";
    @NotNull
    private final String e = "msgacs.wapa.taobao.com";
    @NotNull
    private final String f = "acs.wapa.taobao.com";
    @NotNull
    private final HashMap<String, String> g;

    /* compiled from: Taobao */
    /* renamed from: tb.s2$a */
    /* loaded from: classes6.dex */
    public /* synthetic */ class C9672a {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;

        static {
            int[] iArr = new int[AppConfig.EnvMode.values().length];
            iArr[AppConfig.EnvMode.test.ordinal()] = 1;
            iArr[AppConfig.EnvMode.prepare.ordinal()] = 2;
            $EnumSwitchMapping$0 = iArr;
        }
    }

    public s2() {
        HashMap<String, String> hashMap = new HashMap<>();
        hashMap.put(t2.ACCS_CHANNEL, MoiveAccsService.class.getName());
        hashMap.put("orange", "com.taobao.orange.accssupport.OrangeAccsService");
        hashMap.put("login", "cn.damai.login.loginaccs.LoginAccsService");
        this.g = hashMap;
    }

    @Override // com.alibaba.pictures.accs.IACCSConfigProvider
    @Nullable
    public HashMap<String, String> getAccsServiceMap() {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "2068162041") ? (HashMap) ipChange.ipc$dispatch("2068162041", new Object[]{this}) : this.g;
    }

    @Override // com.alibaba.pictures.accs.IACCSConfigProvider
    @Nullable
    public String getAgooMsgReceiveServiceName() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1029756771")) {
            return (String) ipChange.ipc$dispatch("-1029756771", new Object[]{this});
        }
        return null;
    }

    @Override // com.alibaba.pictures.accs.IACCSConfigProvider
    @Nullable
    public Integer getAppIconRes() {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "959675120") ? (Integer) ipChange.ipc$dispatch("959675120", new Object[]{this}) : Integer.valueOf(R$drawable.logo);
    }

    @Override // com.alibaba.pictures.accs.IACCSConfigProvider
    @NotNull
    public String getAppKey() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "2035331887")) {
            return (String) ipChange.ipc$dispatch("2035331887", new Object[]{this});
        }
        AppConfig.EnvMode g = AppConfig.g();
        if ((g == null ? -1 : C9672a.$EnumSwitchMapping$0[g.ordinal()]) == 1) {
            String f = AppConfig.f();
            b41.h(f, "{\n                AppCon…tDebugKey()\n            }");
            return f;
        }
        String k = AppConfig.k();
        b41.h(k, "{\n                AppCon…OnlineKey()\n            }");
        return k;
    }

    @Override // com.alibaba.pictures.accs.IACCSConfigProvider
    @Nullable
    public Integer getAppTinyIconRes() {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "1850055824") ? (Integer) ipChange.ipc$dispatch("1850055824", new Object[]{this}) : Integer.valueOf(R$drawable.logo);
    }

    @Override // com.alibaba.pictures.accs.IACCSConfigProvider
    @NotNull
    public String getChannelHost() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1783379088")) {
            return (String) ipChange.ipc$dispatch("-1783379088", new Object[]{this});
        }
        AppConfig.EnvMode g = AppConfig.g();
        int i = g == null ? -1 : C9672a.$EnumSwitchMapping$0[g.ordinal()];
        if (i != 1) {
            if (i != 2) {
                return this.b;
            }
            return this.f;
        }
        return this.d;
    }

    @Override // com.alibaba.pictures.accs.IACCSConfigProvider
    @NotNull
    public Context getContext() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1400767932")) {
            return (Context) ipChange.ipc$dispatch("-1400767932", new Object[]{this});
        }
        Application a = mu0.a();
        b41.h(a, "getApplication()");
        return a;
    }

    @Override // com.alibaba.pictures.accs.IACCSConfigProvider
    @NotNull
    public ACCSEnvMode getEnvMode() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1453437186")) {
            return (ACCSEnvMode) ipChange.ipc$dispatch("1453437186", new Object[]{this});
        }
        AppConfig.EnvMode g = AppConfig.g();
        int i = g == null ? -1 : C9672a.$EnumSwitchMapping$0[g.ordinal()];
        if (i != 1) {
            if (i != 2) {
                return ACCSEnvMode.RELEASE;
            }
            return ACCSEnvMode.PRE;
        }
        return ACCSEnvMode.TEST;
    }

    @Override // com.alibaba.pictures.accs.IACCSConfigProvider
    @NotNull
    public String getInAppHost() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "605669545")) {
            return (String) ipChange.ipc$dispatch("605669545", new Object[]{this});
        }
        AppConfig.EnvMode g = AppConfig.g();
        int i = g == null ? -1 : C9672a.$EnumSwitchMapping$0[g.ordinal()];
        if (i != 1) {
            if (i != 2) {
                return this.a;
            }
            return this.e;
        }
        return this.c;
    }

    @Override // com.alibaba.pictures.accs.IACCSConfigProvider
    @NotNull
    public String getTTid() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-622286036")) {
            return (String) ipChange.ipc$dispatch("-622286036", new Object[]{this});
        }
        String b = AppConfig.b();
        b41.h(b, "getAppId()");
        return b;
    }

    @Override // com.alibaba.pictures.accs.IACCSConfigProvider
    @Nullable
    public String getUserId() {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "-450051849") ? (String) ipChange.ipc$dispatch("-450051849", new Object[]{this}) : x20.c();
    }

    @Override // com.alibaba.pictures.accs.IACCSConfigProvider
    public boolean isDebuggable() {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "1069006801") ? ((Boolean) ipChange.ipc$dispatch("1069006801", new Object[]{this})).booleanValue() : AppConfig.v();
    }
}
