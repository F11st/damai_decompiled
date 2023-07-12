package com.ali.user.mobile.rpc;

import android.text.TextUtils;
import com.ali.user.mobile.app.init.Debuggable;
import com.ali.user.mobile.login.model.LoginConstant;
import com.alimm.xadsdk.base.expose.RetryMonitorDbHelper;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Comparator;

/* compiled from: Taobao */
/* loaded from: classes17.dex */
public class HistoryAccount implements Comparator {
    private static final boolean DEBUG = Debuggable.isDebug();
    public String accountId;
    public String alipayCrossed;
    public long alipayHid;
    public String autologinToken;
    public String biometricId;
    public String email;
    public int hasPwd = -1;
    public String headImg;
    public boolean isVip;
    public String loginAccount;
    public String loginPhone;
    public int loginSite;
    public long loginTime;
    public String loginType;
    public String mobile;
    public String nick;
    public String nickName;
    public String srcLoginType;
    public String tokenKey;
    public long userId;
    public String userInputName;
    public String vipExpireTime;

    public HistoryAccount() {
    }

    @Override // java.util.Comparator
    public int compare(Object obj, Object obj2) {
        long j = ((HistoryAccount) obj).loginTime;
        long j2 = ((HistoryAccount) obj2).loginTime;
        if (j > j2) {
            return -1;
        }
        return j == j2 ? 0 : 1;
    }

    @Override // java.util.Comparator
    public boolean equals(Object obj) {
        return super.equals(obj);
    }

    public String getAccount() {
        if (TextUtils.isEmpty(this.loginAccount)) {
            return TextUtils.isEmpty(this.mobile) ? this.email : this.mobile;
        }
        return this.loginAccount;
    }

    public String getAccountId() {
        return this.accountId;
    }

    public String getFormatVipExpireTime() {
        try {
            if (this.vipExpireTime == null) {
                return "";
            }
            return new SimpleDateFormat(RetryMonitorDbHelper.DATE_FORMAT).format(new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").parse(this.vipExpireTime));
        } catch (ParseException unused) {
            return "";
        }
    }

    public String getLoginPhone() {
        return this.loginPhone;
    }

    public int getLoginSite() {
        return this.loginSite;
    }

    public int isHasPwd() {
        return this.hasPwd;
    }

    public void setAccountId(String str) {
        this.accountId = str;
    }

    public void setHasPwd(int i) {
        this.hasPwd = i;
    }

    public void setLoginPhone(String str) {
        this.loginPhone = str;
    }

    public void setLoginSite(int i) {
        this.loginSite = i;
    }

    public void setSrcLoginType(String str) {
        if (TextUtils.isEmpty(str) || TextUtils.equals(str, LoginConstant.LOGIN_TYPE_FINGERPRINT)) {
            return;
        }
        this.srcLoginType = str;
    }

    public String toString() {
        if (DEBUG) {
            return "HistoryAccount{, userId=" + this.userId + ", nick=" + this.nick + ", nickName=" + this.nickName + ", email=" + this.email + ", mobile=" + this.mobile + ", loginPhone=" + this.loginPhone + ", loginAccount=" + this.loginAccount + ", loginTime=" + this.loginTime + ", loginType=" + this.loginType + ", srcLoginType=" + this.srcLoginType + ", headImg=" + this.headImg + ", tokenKey=" + this.tokenKey;
        }
        return super.toString();
    }

    public void update(HistoryAccount historyAccount) {
        if (this.userId != historyAccount.userId) {
            return;
        }
        this.biometricId = historyAccount.biometricId;
        this.autologinToken = historyAccount.autologinToken;
        if (!TextUtils.isEmpty(historyAccount.userInputName)) {
            this.userInputName = historyAccount.userInputName;
        }
        if (!TextUtils.isEmpty(historyAccount.tokenKey)) {
            this.tokenKey = historyAccount.tokenKey;
        }
        this.email = historyAccount.email;
        if (!TextUtils.isEmpty(historyAccount.headImg)) {
            this.headImg = historyAccount.headImg;
        }
        if (!TextUtils.isEmpty(historyAccount.loginType)) {
            this.loginType = historyAccount.loginType;
        }
        this.nick = historyAccount.nick;
        this.mobile = historyAccount.mobile;
        if (!TextUtils.isEmpty(historyAccount.loginAccount)) {
            this.loginAccount = historyAccount.loginAccount;
        }
        long j = historyAccount.loginTime;
        if (j > 0) {
            this.loginTime = j;
        }
        this.loginPhone = historyAccount.loginPhone;
        this.loginSite = historyAccount.loginSite;
        this.alipayCrossed = historyAccount.alipayCrossed;
        this.hasPwd = historyAccount.hasPwd;
        this.isVip = historyAccount.isVip;
        this.vipExpireTime = historyAccount.vipExpireTime;
        setSrcLoginType(historyAccount.srcLoginType);
        this.biometricId = historyAccount.biometricId;
    }

    public void updateVipState(boolean z, String str) {
        this.isVip = z;
        this.vipExpireTime = str;
    }

    public HistoryAccount(String str, String str2, String str3, long j, long j2, String str4, long j3, String str5, String str6, String str7, String str8, String str9, int i) {
        this.userInputName = str;
        this.mobile = str2;
        this.headImg = str3;
        this.userId = j;
        this.alipayHid = j2;
        this.autologinToken = str4;
        this.loginTime = j3;
        this.tokenKey = str5;
        this.loginType = str6;
        this.nick = str7;
        this.email = str8;
        this.alipayCrossed = str9;
        this.loginSite = i;
    }

    public HistoryAccount(String str, String str2, String str3, long j, long j2, String str4, String str5, String str6) {
        this.mobile = str;
        this.email = str2;
        this.headImg = str3;
        this.userId = j;
        this.loginTime = j2;
        this.loginType = str4;
        this.nickName = str5;
        this.loginAccount = str6;
    }
}
