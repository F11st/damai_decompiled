package com.ali.user.mobile.model;

import cn.damai.login.authlogin.req.GetAuthorizationTokenRequest;
import com.ali.user.open.core.Site;
import com.taobao.weex.common.Constants;

/* compiled from: Taobao */
/* loaded from: classes17.dex */
public class LoginType {

    /* compiled from: Taobao */
    /* loaded from: classes17.dex */
    public static class LocalLoginType {
        public static final String ALIPAY_TRUST_LOGIN = "alipayTrustLogin";
        public static final String ASO_LOGIN = "asoLogin";
        public static final String AUTO_LOGIN = "autologin";
        public static final String BIO_LOGIN = "bioLogin";
        public static final String LOGIN2REGISTER_LOGIN = "login2Register";
        public static final String LOGIN_TYPE_ALIPAY = "alipayLogin";
        public static final String LOGIN_TYPE_NETEASE = "neteaseLogin";
        public static final String LOGIN_TYPE_QQ = "tencentLogin";
        public static final String LOGIN_TYPE_WEIXIN = "wechatLogin";
        public static final String MOBILE_VERIFY_LOGIN = "mobileVerifyLogin";
        public static final String NICK_SMS_LOGIN = "nickSmsLogin";
        public static final String PONE_KEY_REGISTER_LOGIN = "oneKeyRegister";
        public static final String PWD_LOGIN = "pwdLogin";
        public static final String RETRIVE_PWD_LOGIN = "retrivePwd";
        public static final String SCAN_FACE_LOGIN = "scanfaceLogin";
        public static final String SIM_LOGIN = "simLogin";
        public static final String SMS_LOGIN = "smsLogin";
        public static final String SSO_LOGIN = "tbssoLogin";
        public static final String SSO_SILENT = "ssoSilent";
    }

    /* compiled from: Taobao */
    /* loaded from: classes17.dex */
    public enum ServerLoginType {
        BIOLOGIN(LocalLoginType.BIO_LOGIN),
        SMSLogin(LocalLoginType.SMS_LOGIN),
        SimLogin(LocalLoginType.SIM_LOGIN),
        MobileVerifyLogin(LocalLoginType.MOBILE_VERIFY_LOGIN),
        AutoLogin(GetAuthorizationTokenRequest.ACTION_AUTO_LOGIN),
        TokenLogin("tokenlogin"),
        UnifySsoLogin("unifysso"),
        QrLogin("qrLogin"),
        TaobaoSSOLogin("taobao"),
        AlipaySSOLogin("alipayAso"),
        FaceLogin(TokenType.FACE_LOGIN),
        LoginTypeQQ(Site.QQ),
        LoginTypeWeixin("weixin"),
        LoginTypeWeibo(Site.WEIBO),
        LoginTypeRegister("register"),
        CheckSession("checksession"),
        MergeAccount(TokenType.MERGE_ACCOUNT),
        TouristLogin("touristLogin"),
        PasswordLogin(Constants.Value.PASSWORD);
        
        private String type;

        ServerLoginType(String str) {
            this.type = str;
        }

        public String getType() {
            return this.type;
        }
    }
}
