package cn.damai.common;

import android.content.Context;
import android.text.TextUtils;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import cn.damai.common.AppConfig;
import com.alibaba.fastjson.JSON;
import com.alibaba.pictures.cornerstone.protocol.ICloudConfig;
import com.alibaba.pictures.cornerstone.protocol.IInitProxy;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import com.taobao.orange.OConfig;
import com.taobao.orange.OConstant;
import com.taobao.orange.OrangeConfig;
import com.youku.danmaku.engine.danmaku.model.android.DanmakuFactory;
import java.util.Map;
import tb.cb1;
import tb.ck;
import tb.hb;
import tb.ko;

/* compiled from: Taobao */
/* loaded from: classes13.dex */
public class OrangeConfigCenter {
    private static transient /* synthetic */ IpChange $ipChange;
    private static OrangeConfigCenter a;

    /* compiled from: Taobao */
    /* loaded from: classes13.dex */
    public interface DMOrangeConfigListener {
        void onConfigUpdate(String str, boolean z);
    }

    /* compiled from: Taobao */
    /* renamed from: cn.damai.common.OrangeConfigCenter$a */
    /* loaded from: classes4.dex */
    public class C0465a implements IInitProxy<ICloudConfig> {
        private static transient /* synthetic */ IpChange $ipChange;
        final /* synthetic */ Context a;

        C0465a(Context context) {
            this.a = context;
        }

        @Override // com.alibaba.pictures.cornerstone.protocol.IInitProxy
        public void afterInit() {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "2028075214")) {
                ipChange.ipc$dispatch("2028075214", new Object[]{this});
            }
        }

        @Override // com.alibaba.pictures.cornerstone.protocol.IInitProxy
        public boolean init(@Nullable Context context, @Nullable hb<ICloudConfig> hbVar) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "-1731668070")) {
                return ((Boolean) ipChange.ipc$dispatch("-1731668070", new Object[]{this, context, hbVar})).booleanValue();
            }
            String c = AppConfig.c();
            if (AppConfig.g() == AppConfig.EnvMode.test) {
                c = AppConfig.f();
            } else if (AppConfig.g() == AppConfig.EnvMode.prepare) {
                c = AppConfig.k();
            } else if (AppConfig.g() == AppConfig.EnvMode.online) {
                c = AppConfig.k();
            }
            OrangeConfig.getInstance().init(this.a, new OConfig.Builder().setAppKey(c).setAppVersion(AppConfig.q()).setEnv(AppConfig.g().ordinal()).setServerType(OConstant.SERVER.TAOBAO.ordinal()).setIndexUpdateMode(OConstant.UPDMODE.O_XMD.ordinal()).setTime(DanmakuFactory.MIN_DANMAKU_DURATION_V).build());
            return true;
        }

        @Override // com.alibaba.pictures.cornerstone.protocol.IInitProxy
        public void preInit(@Nullable Context context, @Nullable hb<ICloudConfig> hbVar) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "1013565405")) {
                ipChange.ipc$dispatch("1013565405", new Object[]{this, context, hbVar});
            }
        }
    }

    /* compiled from: Taobao */
    /* renamed from: cn.damai.common.OrangeConfigCenter$b */
    /* loaded from: classes4.dex */
    public class C0466b implements ICloudConfig.OnGroupUpdateListener {
        private static transient /* synthetic */ IpChange $ipChange;

        C0466b(OrangeConfigCenter orangeConfigCenter) {
        }

        @Override // com.alibaba.pictures.cornerstone.protocol.ICloudConfig.OnGroupUpdateListener
        public void onUpdate(@NonNull String str, @NonNull Map<String, String> map) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "1498251473")) {
                ipChange.ipc$dispatch("1498251473", new Object[]{this, str, map});
                return;
            }
            OrangeConfig.getInstance().getConfigs(str);
            if (AppConfig.v()) {
                cb1.c("damai_OrangeConfig", "namespace = " + str + " , configValue = " + JSON.toJSONString(map));
            }
        }
    }

    /* compiled from: Taobao */
    /* renamed from: cn.damai.common.OrangeConfigCenter$c */
    /* loaded from: classes4.dex */
    public class C0467c implements ICloudConfig.OnGroupUpdateListener {
        private static transient /* synthetic */ IpChange $ipChange;
        final /* synthetic */ DMOrangeConfigListener a;

        C0467c(OrangeConfigCenter orangeConfigCenter, DMOrangeConfigListener dMOrangeConfigListener) {
            this.a = dMOrangeConfigListener;
        }

        @Override // com.alibaba.pictures.cornerstone.protocol.ICloudConfig.OnGroupUpdateListener
        public void onUpdate(@NonNull String str, @NonNull Map<String, String> map) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "-1827134800")) {
                ipChange.ipc$dispatch("-1827134800", new Object[]{this, str, map});
                return;
            }
            OrangeConfig.getInstance().getConfigs(str);
            this.a.onConfigUpdate(str, "true".equals(map.get("fromCache")));
            if (AppConfig.v()) {
                cb1.c("damai_OrangeConfig", "namespace = " + str + " , configValue = " + JSON.toJSONString(map));
            }
        }
    }

    private OrangeConfigCenter() {
    }

    public static synchronized OrangeConfigCenter c() {
        synchronized (OrangeConfigCenter.class) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "-46430437")) {
                return (OrangeConfigCenter) ipChange.ipc$dispatch("-46430437", new Object[0]);
            }
            if (a == null) {
                a = new OrangeConfigCenter();
            }
            return a;
        }
    }

    public static void d(Context context) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1374459499")) {
            ipChange.ipc$dispatch("-1374459499", new Object[]{context});
            return;
        }
        ko.d().e(new ck(), new C0465a(context));
        ko.d().c(context);
        ko.d().i(DamaiConstants.APP_STARTUP_CACHEABLE_ORANGE_KEY_SETS);
    }

    @Deprecated
    public int a(String str, String str2, int i) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "4231155")) {
            return ((Integer) ipChange.ipc$dispatch("4231155", new Object[]{this, str, str2, Integer.valueOf(i)})).intValue();
        }
        if (TextUtils.isEmpty(str)) {
            return i;
        }
        try {
            return ko.d().getInt(str, str2, i);
        } catch (Throwable unused) {
            return i;
        }
    }

    @Deprecated
    public String b(String str, String str2, String str3) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-891882029")) {
            return (String) ipChange.ipc$dispatch("-891882029", new Object[]{this, str, str2, str3});
        }
        try {
            return ko.d().getString(str, str2, str3);
        } catch (Throwable unused) {
            return str3;
        }
    }

    public void e(String str) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "573374954")) {
            ipChange.ipc$dispatch("573374954", new Object[]{this, str});
        } else {
            ko.d().registerGroupConfigUpdateListener(str, new C0466b(this), false);
        }
    }

    public void f(String str, DMOrangeConfigListener dMOrangeConfigListener) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1570651884")) {
            ipChange.ipc$dispatch("-1570651884", new Object[]{this, str, dMOrangeConfigListener});
        } else {
            ko.d().registerGroupConfigUpdateListener(str, new C0467c(this, dMOrangeConfigListener), false);
        }
    }

    public void g(String str) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1790296657")) {
            ipChange.ipc$dispatch("1790296657", new Object[]{this, str});
        } else {
            ko.d().unRegisterGroupConfigUpdateListener(str);
        }
    }
}
