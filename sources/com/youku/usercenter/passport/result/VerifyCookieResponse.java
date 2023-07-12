package com.youku.usercenter.passport.result;

import java.io.Serializable;
import java.util.Map;

/* compiled from: Taobao */
/* loaded from: classes3.dex */
public class VerifyCookieResponse implements Serializable {
    public String avatarUrl;
    public String encryptYtId;
    public String loginAppId;
    public boolean needRefreshPtoken;
    public String nickName;
    public UserProfileDto profile;
    public Map<String, Object> sdkCookieInfo;
    public long t;
    public String tid;
    public String uid;
    public String yid;
    public String yktk;
    public String ytid;
}
