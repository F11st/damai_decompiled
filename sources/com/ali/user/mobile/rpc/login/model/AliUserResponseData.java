package com.ali.user.mobile.rpc.login.model;

import com.taobao.login4android.session.SuccessTip;
import java.io.Serializable;
import java.util.Map;

/* compiled from: Taobao */
/* loaded from: classes17.dex */
public class AliUserResponseData implements Serializable {
    public long alipayHid;
    public String autoLoginToken;
    public String[] cookies;
    public String ecode;
    public String email;
    public long expires;
    public Map<String, Object> extendAttribute;
    public String[] externalCookies;
    public long havanaId;
    public String havanaSsoToken;
    public long havanaSsoTokenExpiredTime;
    public String headPicLink;
    public String loginPhone;
    public Map<String, String> loginServiceExt;
    public long loginTime;
    public String nick;
    public String sid;
    public String ssoToken;
    public String subSid;
    public SuccessTip successTips;
    public String uidDigest;
    public String userId;
}
