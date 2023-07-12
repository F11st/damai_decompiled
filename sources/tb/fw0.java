package tb;

import cn.damai.login.LoginManager;
import cn.damai.login.havana.HavanaProxy;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;

/* compiled from: Taobao */
/* loaded from: classes5.dex */
public class fw0 {
    private static transient /* synthetic */ IpChange $ipChange = null;
    public static final String LOGIN_ALIPAY_FAILED_CODE = "-2001";
    public static final String LOGIN_ALIPAY_FAILED_MSG = "支付宝登录失败";
    public static final String LOGIN_NORMAL_FAILED_CODE = "-2000";
    public static final String LOGIN_NORMAL_FAILED_MSG = "普通登录失败(havana)";
    public static final String LOGIN_QQ_FAILED_CODE = "-2004";
    public static final String LOGIN_QQ_FAILED_MSG = "QQ登录失败";
    public static final String LOGIN_TAOBAO_FAILED_CODE = "-2002";
    public static final String LOGIN_TAOBAO_FAILED_MSG = "手淘登录失败";
    public static final String LOGIN_WECHAT_FAILED_CODE = "-2005";
    public static final String LOGIN_WECHAT_FAILED_MSG = "微信登录失败";
    public static final String LOGIN_WEIBO_FAILED_CODE = "-2003";
    public static final String LOGIN_WEIBO_FAILED_MSG = "微博登录失败";
    public static final String LOGIN_YOUKU_BRIDGE_FAILED_CODE = "-2006";
    public static final String LOGIN_YOUKU_BRIDGE_FAILED_MSG = "优酷h5桥自动登录失败";
    public static final String LOGIN_YOUKU_FAILED_CODE = "-2007";
    public static final String LOGIN_YOUKU_FAILED_MSG = "优酷sdk自动登录失败";

    public static void a() {
        String str;
        String str2;
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1302444236")) {
            ipChange.ipc$dispatch("-1302444236", new Object[0]);
            return;
        }
        switch (LoginManager.k().l()) {
            case 100:
                str = LOGIN_NORMAL_FAILED_CODE;
                str2 = LOGIN_NORMAL_FAILED_MSG;
                break;
            case 101:
                str = LOGIN_ALIPAY_FAILED_CODE;
                str2 = LOGIN_ALIPAY_FAILED_MSG;
                break;
            case 102:
                str = LOGIN_TAOBAO_FAILED_CODE;
                str2 = LOGIN_TAOBAO_FAILED_MSG;
                break;
            case 103:
                str = LOGIN_WEIBO_FAILED_CODE;
                str2 = LOGIN_WEIBO_FAILED_MSG;
                break;
            case 104:
                str = LOGIN_QQ_FAILED_CODE;
                str2 = LOGIN_QQ_FAILED_MSG;
                break;
            case 105:
                str = LOGIN_WECHAT_FAILED_CODE;
                str2 = LOGIN_WECHAT_FAILED_MSG;
                break;
            default:
                str = "";
                str2 = str;
                break;
        }
        b23.a("", str, str2 + "  原因：" + HavanaProxy.v().u());
    }
}
