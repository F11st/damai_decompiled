package com.ali.user.open.session;

/* compiled from: Taobao */
/* loaded from: classes9.dex */
public class Session {
    public String avatarUrl;
    public String bindToken;
    public long expireIn;
    public String hid;
    public long loginTime;
    public String nick;
    public String openId;
    public String openSid;
    public String sid;
    public String topAccessToken;
    public String topAuthCode;
    public String topExpireTime;

    public String toString() {
        return "nick = " + this.nick + ", ava = " + this.avatarUrl + " , hid=" + this.hid + ", Sid=" + this.sid + ", topAccessToken=" + this.topAccessToken + ", topAuthCode=" + this.topAuthCode + ",topExpireTime=" + this.topExpireTime;
    }
}
