package tb;

import android.content.pm.PackageInfo;
import cn.damai.common.AppConfig;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import com.taobao.wireless.security.sdk.SecurityGuardManager;
import com.taobao.wireless.security.sdk.staticdatastore.IStaticDataStoreComponent;
import java.io.PrintStream;

/* compiled from: Taobao */
/* loaded from: classes7.dex */
public class mm2 {
    private static transient /* synthetic */ IpChange $ipChange = null;
    public static final String ALIPAY_APP_ID = "2015092200310865";
    public static final String QQ_PACKAGENAME = "com.tencent.mobileqq";
    public static final String WECHAT_PACKAGENAME = "com.tencent.mm";
    public static String b = "dingoabomemo9ad1hqjwwo";
    public static String c = "dingoaesuqtseep9fabz7p";
    public static String d = "http://www.damai.cn";
    public static String e = "";
    private static final mm2 f = new mm2();
    SecurityGuardManager a;

    private mm2() {
    }

    public static mm2 c() {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "11167579") ? (mm2) ipChange.ipc$dispatch("11167579", new Object[0]) : f;
    }

    private static boolean e() {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "-187490632") ? ((Boolean) ipChange.ipc$dispatch("-187490632", new Object[0])).booleanValue() : AppConfig.v();
    }

    public static String j() {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "-1720652176") ? (String) ipChange.ipc$dispatch("-1720652176", new Object[0]) : "http://www.damai.cn";
    }

    public String a() {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "-942056449") ? (String) ipChange.ipc$dispatch("-942056449", new Object[]{this}) : e() ? c : b;
    }

    public String b(String str) {
        IStaticDataStoreComponent staticDataStoreComp;
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1973859789")) {
            return (String) ipChange.ipc$dispatch("1973859789", new Object[]{this, str});
        }
        String str2 = null;
        if (this.a == null) {
            this.a = SecurityGuardManager.getInstance(mu0.a());
        }
        SecurityGuardManager securityGuardManager = this.a;
        if (securityGuardManager != null && (staticDataStoreComp = securityGuardManager.getStaticDataStoreComp()) != null && (str2 = staticDataStoreComp.getExtraData(str)) != null) {
            PrintStream printStream = System.out;
            printStream.println("Get extra data: " + str2);
        }
        return str2;
    }

    public boolean d(String str) {
        PackageInfo packageInfo;
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1507837720")) {
            return ((Boolean) ipChange.ipc$dispatch("1507837720", new Object[]{this, str})).booleanValue();
        }
        try {
            packageInfo = mu0.a().getPackageManager().getPackageInfo(str, 0);
        } catch (Exception e2) {
            e2.printStackTrace();
            packageInfo = null;
        }
        return packageInfo != null;
    }

    public String f() {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "-922718625") ? (String) ipChange.ipc$dispatch("-922718625", new Object[]{this}) : b("QQ_APP_ID");
    }

    public String g() {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "1150390036") ? (String) ipChange.ipc$dispatch("1150390036", new Object[]{this}) : b("QQ_APP_SECRET");
    }

    public String h() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1492800999")) {
            return (String) ipChange.ipc$dispatch("1492800999", new Object[]{this});
        }
        return b(e() ? "WEIBO_DEBUG_APP_ID" : "WEIBO_RELEASE_APP_ID");
    }

    public String i() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-289639780")) {
            return (String) ipChange.ipc$dispatch("-289639780", new Object[]{this});
        }
        return b(e() ? "WEIBO_DEBUG_APP_SECRET" : "WEIBO_RELEASE_APP_SECRET");
    }

    public String k() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "769136830")) {
            return (String) ipChange.ipc$dispatch("769136830", new Object[]{this});
        }
        return b(e() ? "WX_DEBUG_APP_ID" : "WX_RELEASE_APP_ID");
    }

    public String l() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-960564749")) {
            return (String) ipChange.ipc$dispatch("-960564749", new Object[]{this});
        }
        return b(e() ? "WX_DEBUG_APP_SECRET" : "WX_RELEASE_APP_SECRET");
    }
}
