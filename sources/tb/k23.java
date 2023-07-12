package tb;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.text.TextUtils;
import cn.damai.common.AppConfig;
import cn.damai.common.OrangeConfigCenter;
import cn.damai.common.nav.DMNav;
import cn.damai.commonbusiness.yymember.view.MemberAuthPopWindow;
import cn.damai.login.LoginManager;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;

/* compiled from: Taobao */
/* loaded from: classes.dex */
public class k23 {
    private static transient /* synthetic */ IpChange $ipChange = null;
    public static final String SWITCH_ORANGE_VIP_KEY = "taomai_vip_h5_url";
    public static final String SWITCH_ORANGE_VIP_SECOND_KEY = "taomai_vip_h5_url_second_page";
    public static final String SWITCH_ORANGE_VIP_URL = "damai_taomai_vip_h5_url";
    public static final String TAG = "YYMemberUtil";
    private static String a = "https://m.taopiaopiao.com/tickets/vip/pages/center/index.html?refreshable=true&hidenavbar=1&disableNav=YES&hidestatusbar=1&pullRefresh=YES&hideBackBtn=1&__webview_options__=transparentTitle%3Dalways%26pullRefresh%3DYES%26titlePenetrate%3DYES";
    private static String b = "https://m.wapa.taopiaopiao.com/tickets/vip/pages/center/index.html?refreshable=true&hidenavbar=1&disableNav=YES&hidestatusbar=1&pullRefresh=YES&hideBackBtn=1&__webview_options__=transparentTitle%3Dalways%26pullRefresh%3DYES%26titlePenetrate%3DYES";
    private static String c = "https://m.wapa.taopiaopiao.com/tickets/vip/pages/center/index.html?refreshable=true&hidenavbar=1&disableNav=YES&hidestatusbar=1&pullRefresh=YES&hideBackBtn=1&__webview_options__=transparentTitle%3Dalways%26pullRefresh%3DYES%26titlePenetrate%3DYES";
    private static String d = "https://m.taopiaopiao.com/tickets/vip/pages/center/index.html?refreshable=false&loading=false&hidenavbar=1&disableNav=YES&hidestatusbar=1&pullRefresh=YES&toAuth=1&__webview_options__=transparentTitle%3Dalways%26pullRefresh%3DYES%26titlePenetrate%3DYES";
    private static String e = "https://m.wapa.taopiaopiao.com/tickets/vip/pages/center/index.html?refreshable=false&loading=false&hidenavbar=1&disableNav=YES&hidestatusbar=1&pullRefresh=YES&toAuth=1&__webview_options__=transparentTitle%3Dalways%26pullRefresh%3DYES%26titlePenetrate%3DYES";
    private static String f = "https://m.wapa.taopiaopiao.com/tickets/vip/pages/center/index.html?refreshable=false&loading=false&hidenavbar=1&disableNav=YES&hidestatusbar=1&pullRefresh=YES&toAuth=1&__webview_options__=transparentTitle%3Dalways%26pullRefresh%3DYES%26titlePenetrate%3DYES";
    private static String g = "https://m.taopiaopiao.com/tickets/vip/pages/damai-member-service/index.html?loading=false";
    private static String h = "https://m.wapa.taopiaopiao.com/tickets/vip/pages/damai-member-service/index.html?loading=false";
    private static String i = "https://m.wapa.taopiaopiao.com/tickets/vip/pages/damai-member-service/index.html?loading=false";

    private static String a() {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "244382864") ? (String) ipChange.ipc$dispatch("244382864", new Object[0]) : OrangeConfigCenter.c().b(SWITCH_ORANGE_VIP_URL, SWITCH_ORANGE_VIP_KEY, "");
    }

    private static String b() {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "1348688996") ? (String) ipChange.ipc$dispatch("1348688996", new Object[0]) : OrangeConfigCenter.c().b(SWITCH_ORANGE_VIP_URL, SWITCH_ORANGE_VIP_SECOND_KEY, "");
    }

    public static String c() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1095287528")) {
            return (String) ipChange.ipc$dispatch("-1095287528", new Object[0]);
        }
        String str = g;
        if (AppConfig.v()) {
            if (AppConfig.g() == AppConfig.EnvMode.test) {
                return i;
            }
            return AppConfig.g() == AppConfig.EnvMode.prepare ? h : str;
        }
        return str;
    }

    public static boolean d(String str) {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "-152834927") ? ((Boolean) ipChange.ipc$dispatch("-152834927", new Object[]{str})).booleanValue() : (TextUtils.isEmpty(str) || "0".equals(str)) ? false : true;
    }

    public static void e(Activity activity) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "652491671")) {
            ipChange.ipc$dispatch("652491671", new Object[]{activity});
        } else {
            DMNav.from(activity).setTransition(0, 0).toHost(cs.q);
        }
    }

    public static void f(boolean z) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1622508804")) {
            ipChange.ipc$dispatch("-1622508804", new Object[]{Boolean.valueOf(z)});
            return;
        }
        try {
            if (z) {
                OrangeConfigCenter.c().e(SWITCH_ORANGE_VIP_URL);
            } else {
                OrangeConfigCenter.c().g(SWITCH_ORANGE_VIP_URL);
            }
        } catch (Exception e2) {
            e2.printStackTrace();
        }
    }

    public static void g(Context context, Activity activity, String str, MemberAuthPopWindow.ICustomDialogEventListener iCustomDialogEventListener) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-417888479")) {
            ipChange.ipc$dispatch("-417888479", new Object[]{context, activity, str, iCustomDialogEventListener});
        } else if (LoginManager.k().q()) {
            MemberAuthPopWindow memberAuthPopWindow = new MemberAuthPopWindow(context, activity.findViewById(16908290), activity);
            memberAuthPopWindow.setEventListener(iCustomDialogEventListener);
            memberAuthPopWindow.setPageSource(str);
            memberAuthPopWindow.show();
        } else {
            DMNav.from(activity).withExtras(new Bundle()).toUri(cs.f());
        }
    }

    public static String h() {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "624642964") ? (String) ipChange.ipc$dispatch("624642964", new Object[0]) : "0";
    }

    public static String i() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "515127267")) {
            return (String) ipChange.ipc$dispatch("515127267", new Object[0]);
        }
        String str = a;
        String a2 = a();
        cb1.c(TAG, "memberUrl form orange [" + a2 + jn1.ARRAY_END_STR);
        if (TextUtils.isEmpty(a2)) {
            if (AppConfig.v()) {
                if (AppConfig.g() == AppConfig.EnvMode.test) {
                    return c;
                }
                return AppConfig.g() == AppConfig.EnvMode.prepare ? b : str;
            }
            return str;
        }
        return a2;
    }

    public static String j() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "645936991")) {
            return (String) ipChange.ipc$dispatch("645936991", new Object[0]);
        }
        String str = d;
        String b2 = b();
        cb1.c(TAG, "memberUrl form orange [" + b2 + jn1.ARRAY_END_STR);
        if (TextUtils.isEmpty(b2)) {
            if (AppConfig.v()) {
                if (AppConfig.g() == AppConfig.EnvMode.test) {
                    return f;
                }
                return AppConfig.g() == AppConfig.EnvMode.prepare ? e : str;
            }
            return str;
        }
        return b2;
    }
}
