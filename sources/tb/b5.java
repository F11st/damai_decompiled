package tb;

import android.app.Application;
import android.content.Context;
import android.content.res.Resources;
import android.text.TextUtils;
import android.util.Pair;
import cn.damai.common.AppConfig;
import cn.damai.common.R$string;
import com.alibaba.motu.tbrest.SendService;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import com.taobao.android.tlog.protocol.Constants;
import com.taobao.application.common.Apm;
import com.taobao.monitor.adapter.OtherAppApmInitiator;
import com.taobao.monitor.impl.common.PageVisibleAlgorithm;
import com.ut.mini.IUTApplication;
import com.ut.mini.UTAnalytics;
import com.ut.mini.core.sign.IUTRequestAuthentication;
import com.ut.mini.core.sign.UTSecuritySDKRequestAuthentication;
import com.ut.mini.crashhandler.IUTCrashCaughtListner;
import com.ut.mini.internal.UTTeamWork;
import java.util.HashMap;
import me.ele.altriax.launcher.real.time.data.monitor.PolymerizationMonitor;

/* compiled from: Taobao */
/* loaded from: classes4.dex */
public class b5 {
    private static transient /* synthetic */ IpChange $ipChange;
    private static Pair<String, Long> a;

    /* compiled from: Taobao */
    /* loaded from: classes4.dex */
    public class a implements IUTApplication {
        private static transient /* synthetic */ IpChange $ipChange;

        a() {
        }

        @Override // com.ut.mini.IUTApplication
        public String getUTAppVersion() {
            IpChange ipChange = $ipChange;
            return AndroidInstantRuntime.support(ipChange, "-1503638106") ? (String) ipChange.ipc$dispatch("-1503638106", new Object[]{this}) : AppConfig.q();
        }

        @Override // com.ut.mini.IUTApplication
        public String getUTChannel() {
            IpChange ipChange = $ipChange;
            return AndroidInstantRuntime.support(ipChange, "-2054094870") ? (String) ipChange.ipc$dispatch("-2054094870", new Object[]{this}) : AppConfig.p();
        }

        @Override // com.ut.mini.IUTApplication
        public IUTCrashCaughtListner getUTCrashCraughtListener() {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "-1459725339")) {
                return (IUTCrashCaughtListner) ipChange.ipc$dispatch("-1459725339", new Object[]{this});
            }
            return null;
        }

        @Override // com.ut.mini.IUTApplication
        public IUTRequestAuthentication getUTRequestAuthInstance() {
            IpChange ipChange = $ipChange;
            return AndroidInstantRuntime.support(ipChange, "2014069281") ? (IUTRequestAuthentication) ipChange.ipc$dispatch("2014069281", new Object[]{this}) : new UTSecuritySDKRequestAuthentication(AppConfig.c());
        }

        @Override // com.ut.mini.IUTApplication
        public boolean isAliyunOsSystem() {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "-2109761449")) {
                return ((Boolean) ipChange.ipc$dispatch("-2109761449", new Object[]{this})).booleanValue();
            }
            return false;
        }

        @Override // com.ut.mini.IUTApplication
        public boolean isUTCrashHandlerDisable() {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "-1635231410")) {
                return ((Boolean) ipChange.ipc$dispatch("-1635231410", new Object[]{this})).booleanValue();
            }
            return true;
        }

        @Override // com.ut.mini.IUTApplication
        public boolean isUTLogEnable() {
            IpChange ipChange = $ipChange;
            return AndroidInstantRuntime.support(ipChange, "-991422356") ? ((Boolean) ipChange.ipc$dispatch("-991422356", new Object[]{this})).booleanValue() : AppConfig.v();
        }
    }

    /* compiled from: Taobao */
    /* loaded from: classes4.dex */
    public class b implements Apm.OnAppLaunchListener {
        private static transient /* synthetic */ IpChange $ipChange;

        b() {
        }

        @Override // com.taobao.application.common.IAppLaunchListener
        public void onLaunchChanged(int i, int i2) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "-1588495709")) {
                ipChange.ipc$dispatch("-1588495709", new Object[]{this, Integer.valueOf(i), Integer.valueOf(i2)});
                return;
            }
            String str = i == 0 ? PolymerizationMonitor.COLD : "hot";
            String str2 = i2 != 0 ? i2 != 1 ? i2 != 2 ? i2 != 3 ? i2 != 4 ? "" : "completed" : "ski_interactive" : "interactive" : "visible" : "draw_start";
            if (TextUtils.equals(str2, "completed")) {
                long j = com.taobao.application.common.b.d().getLong("startProcessSystemTime", -1L);
                cb1.c("ApmLog", "Apm LaunchChanged type:" + str + " status:" + str2 + " cost:" + (System.currentTimeMillis() - j) + "ms");
                return;
            }
            cb1.c("ApmLog", "Apm LaunchChanged type:" + str + " status:" + str2);
        }
    }

    /* compiled from: Taobao */
    /* loaded from: classes4.dex */
    public class c implements Apm.OnApmEventListener {
        private static transient /* synthetic */ IpChange $ipChange;

        c() {
        }

        @Override // com.taobao.application.common.IApmEventListener
        public void onEvent(int i) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "-491579846")) {
                ipChange.ipc$dispatch("-491579846", new Object[]{this, Integer.valueOf(i)});
            } else if (i == 1) {
                cb1.c("ApmLog", "Apm Event NOTIFY_FOREGROUND_2_BACKGROUND");
            } else if (i == 2) {
                cb1.c("ApmLog", "Apm Event NOTIFY_BACKGROUND_2_FOREGROUND");
            } else if (i != 50) {
            } else {
                cb1.c("ApmLog", "Apm Event NOTIFY_FOR_IN_BACKGROUND");
            }
        }
    }

    /* compiled from: Taobao */
    /* loaded from: classes4.dex */
    public class d implements Apm.OnPageListener {
        private static transient /* synthetic */ IpChange $ipChange;

        d() {
        }

        @Override // com.taobao.application.common.IPageListener
        public void onPageChanged(String str, int i, long j) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "-1019368888")) {
                ipChange.ipc$dispatch("-1019368888", new Object[]{this, str, Integer.valueOf(i), Long.valueOf(j)});
            } else if (i == 0) {
                if (str.endsWith("Activity")) {
                    Pair unused = b5.a = new Pair(str, Long.valueOf(j));
                }
            } else if (i == 3 && b5.a != null && TextUtils.equals(str, (CharSequence) b5.a.first)) {
                cb1.c("ApmLog", "Apm Page " + str + "页面加载时长： " + (j - ((Long) b5.a.second).longValue()) + "ms");
            }
        }
    }

    private static void c() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "544506450")) {
            ipChange.ipc$dispatch("544506450", new Object[0]);
            return;
        }
        try {
            l23 l23Var = l23.INSTANCE;
            l23Var.c("4", "tppMovie", "tppMoviePoint");
            l23Var.d(z20.i());
            l23Var.b(AppConfig.v());
        } catch (Exception unused) {
        }
    }

    public static void d(Application application, boolean z) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1479470063")) {
            ipChange.ipc$dispatch("-1479470063", new Object[]{application, Boolean.valueOf(z)});
        } else if (z) {
            SendService sendService = SendService.getInstance();
            Context applicationContext = application.getApplicationContext();
            String b2 = AppConfig.b();
            String c2 = AppConfig.c();
            String q = AppConfig.q();
            Resources resources = application.getApplicationContext().getResources();
            int i = R$string.ttid;
            sendService.init(applicationContext, b2, c2, q, resources.getString(i), z20.E());
            jd0.j = true;
            rj2.f = false;
            jd0.p = true;
            rj2.i = PageVisibleAlgorithm.SHADOW;
            lu0.c = true;
            if (AppConfig.v()) {
                pb1.e(true);
            }
            HashMap hashMap = new HashMap();
            hashMap.put("deviceId", anet.channel.util.c.c(application.getApplicationContext()));
            hashMap.put("onlineAppKey", AppConfig.c());
            hashMap.put("appVersion", AppConfig.q());
            hashMap.put(Constants.KEY_APP_BUILD, "");
            hashMap.put("process", "cn.damai");
            hashMap.put("ttid", AppConfig.p());
            hashMap.put("channel", application.getApplicationContext().getResources().getString(i));
            hashMap.put("appPatch", "");
            jd0.j = true;
            jd0.k = true;
            new OtherAppApmInitiator().init(application, hashMap);
            g();
        }
    }

    public static void e() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-784441535")) {
            ipChange.ipc$dispatch("-784441535", new Object[0]);
            return;
        }
        try {
            ks2.a(mu0.a());
        } catch (Exception unused) {
        }
    }

    public static void f(Context context) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1013438668")) {
            ipChange.ipc$dispatch("1013438668", new Object[]{context});
            return;
        }
        ys2.INSTANCE.b(AppConfig.c(), "a2o4t", "page_");
        if (AppConfig.i().booleanValue()) {
            UTTeamWork.getInstance().setHostPort4TnetIpv6(context, "v6-adashx.ut.hzshudian.com", 443);
            UTTeamWork.getInstance().setHostPort4Tnet(context, "adashx.ut.hzshudian.com", 443);
            UTTeamWork.getInstance().setHost4Https(context, "h-adashx.ut.hzshudian.com");
            UTAnalytics.getInstance().setAppApplicationInstance(mu0.a(), new a());
            UTAnalytics.getInstance().turnOffAutoPageTrack();
            if (!TextUtils.isEmpty(z20.i())) {
                cn.damai.common.user.c.e().H("havanaid", z20.i());
            }
            if (!TextUtils.isEmpty(z20.E())) {
                cn.damai.common.user.c.e().H("usercode", z20.E());
            }
            c();
            e();
            vs.b();
        }
    }

    private static void g() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1298730162")) {
            ipChange.ipc$dispatch("-1298730162", new Object[0]);
        } else if (AppConfig.v()) {
            com.taobao.application.common.b.b(new b());
            com.taobao.application.common.b.a(new c());
            com.taobao.application.common.b.c(new d());
        }
    }
}
