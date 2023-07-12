package com.taobao.android.sns4android.util;

import android.text.TextUtils;
import com.ali.user.mobile.login.LoginFrom;
import com.ali.user.mobile.model.LoginType;
import com.ali.user.mobile.model.TokenType;
import com.ali.user.open.core.Site;
import com.taobao.android.sns4android.alipay3.Alipay3SignInHelper;
import com.taobao.android.sns4android.netease.NeteaseSignInHelper;
import com.taobao.android.sns4android.qq.QQSignInHelper;
import com.taobao.android.sns4android.taobao3.TaobaoSignInHelper;
import com.taobao.android.sns4android.weibo.WeiboSignInHelper;
import com.taobao.android.sns4android.weixin.WeixinSignInHelper;

/* compiled from: Taobao */
/* loaded from: classes12.dex */
public class UTConstans {

    /* compiled from: Taobao */
    /* loaded from: classes12.dex */
    public static class Args {
        public static final String UT_RESULT = "result";
    }

    /* compiled from: Taobao */
    /* loaded from: classes12.dex */
    public static class CustomEvent {
        public static final String UT_SNS_AUTHCODE_CANCEL = "snsAuthCode_cancel";
        public static final String UT_SNS_AUTHCODE_COMMIT = "snsAuthCode_commit";
        public static final String UT_SNS_AUTHCODE_FAILURE = "snsAuthCode_failure";
        public static final String UT_SNS_AUTHCODE_SUCCESS = "snsAuthCode_success";
        public static final String UT_SNS_LOGIN_RESULT = "SNS_LoginResult";
    }

    /* compiled from: Taobao */
    /* loaded from: classes12.dex */
    public static class PageName {
        public static final String UT_PAGE_EXTENT_ALIPAY3 = "Page_Extent_Alipay";
        public static final String UT_PAGE_EXTENT_LINE = "Page_Extent_Line";
        public static final String UT_PAGE_EXTENT_QQ = "Page_Extent_QQ";
        public static final String UT_PAGE_EXTENT_TAOBAO3 = "Page_Extent_Taobao";
        public static final String UT_PAGE_EXTENT_UC = "Page_Extent_UC";
        public static final String UT_PAGE_EXTENT_WEIBO = "Page_Extent_Weibo";
        public static final String UT_PAGE_EXTENT_WEIXIN = "Page_Extent_Weixin";
    }

    public static String convertSnsPlatformToLoginType(String str) {
        if (TextUtils.isEmpty(str)) {
            return "";
        }
        return TextUtils.equals("weixin", str) ? LoginType.LocalLoginType.LOGIN_TYPE_WEIXIN : TextUtils.equals(Site.QQ, str) ? LoginType.LocalLoginType.LOGIN_TYPE_QQ : TextUtils.equals("alipay3", str) ? LoginType.LocalLoginType.LOGIN_TYPE_ALIPAY : str.toLowerCase() + TokenType.LOGIN;
    }

    public static String convertSnsTypeToLoginType(String str) {
        if (TextUtils.isEmpty(str)) {
            return "";
        }
        return TextUtils.equals("weixin", str) ? LoginType.LocalLoginType.LOGIN_TYPE_WEIXIN : TextUtils.equals(Site.QQ, str) ? LoginType.LocalLoginType.LOGIN_TYPE_QQ : TextUtils.equals(NeteaseSignInHelper.SNS_TYPE, str) ? LoginType.LocalLoginType.LOGIN_TYPE_NETEASE : str.toLowerCase() + TokenType.LOGIN;
    }

    public static void setLoginFrom(String str) {
        if (QQSignInHelper.SNS_TYPE.equals(str)) {
            LoginFrom.setCurrentLoginFrom("3");
        } else if (WeiboSignInHelper.SNS_TYPE.equals(str)) {
            LoginFrom.setCurrentLoginFrom("2");
        } else if (WeixinSignInHelper.SNS_TYPE.equals(str)) {
            LoginFrom.setCurrentLoginFrom("1");
        } else if (Alipay3SignInHelper.SNS_TYPE.equals(str)) {
            LoginFrom.setCurrentLoginFrom("7");
        } else if (TaobaoSignInHelper.SNS_TYPE.equals(str)) {
            LoginFrom.setCurrentLoginFrom("6");
        }
    }
}
