package cn.damai.wxapi;

import cn.damai.common.AppConfig;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import com.tencent.mm.opensdk.modelmsg.SendAuth;
import com.tencent.mm.opensdk.openapi.IWXAPI;
import com.tencent.mm.opensdk.openapi.WXAPIFactory;
import tb.mu0;
import tb.v20;

/* compiled from: Taobao */
/* loaded from: classes17.dex */
public class WXAgent {
    private static transient /* synthetic */ IpChange $ipChange = null;
    public static final String APP_ID_CRYPT = "cwSb3qNTcPlk0UICwnDMOf7PMG0LyEaF";
    public static final String APP_ID_DEBUG_CRYPT = "NnFsgwa8buxrSx6cR4X9RFw6U9UhpTo8";
    public static final String BASE_WX_OATUTH = "https://api.weixin.qq.com/sns/oauth2/";
    public static final String MINI_ID = "gh_8f607e128043";
    public static final int TIMELINE_SUPPORTED_VERSION = 553779201;
    public static final String WX_GET_REFRESH_TOKEN_URL = "https://api.weixin.qq.com/sns/oauth2/refresh_token";
    public static final String WX_GET_TOKEN_URL = "https://api.weixin.qq.com/sns/oauth2/access_token";
    public static final int WX_TO_LOGIN = 1;
    public static final int WX_TO_SHARE = 0;
    public static final String APP_SECRET_CRYPT = "qn6Uf9ZeG0dk3Mg8FMHwVUw7esGeGMg4CVx++Qv/dBkbFvb5GO6qKA==";
    public static final String APP_SECRET = v20.a(APP_SECRET_CRYPT);

    public static IWXAPI createWxApi() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "952733937")) {
            return (IWXAPI) ipChange.ipc$dispatch("952733937", new Object[0]);
        }
        if (AppConfig.v()) {
            return WXAPIFactory.createWXAPI(mu0.a(), v20.a(APP_ID_DEBUG_CRYPT), false);
        }
        return WXAPIFactory.createWXAPI(mu0.a(), v20.a(APP_ID_CRYPT), false);
    }

    public static boolean loginToWX() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-651889343")) {
            return ((Boolean) ipChange.ipc$dispatch("-651889343", new Object[0])).booleanValue();
        }
        WXEntryActivity.setWXType(1);
        SendAuth.Req req = new SendAuth.Req();
        req.scope = "snsapi_userinfo";
        req.state = "none";
        return createWxApi().sendReq(req);
    }
}
