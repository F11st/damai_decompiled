package com.youku.usercenter.passport;

import android.content.Context;
import android.content.Intent;
import android.text.TextUtils;
import android.util.Base64;
import androidx.localbroadcastmanager.content.LocalBroadcastManager;
import com.taobao.tlog.adapter.AdapterForTLog;
import com.youku.usercenter.passport.listener.IRefreshCookieListener;
import com.youku.usercenter.passport.listener.IRefreshTokenListener;
import com.youku.usercenter.passport.orange.RollBackSwitch;
import com.youku.usercenter.passport.result.UserInfo;
import com.youku.usercenter.passport.statistics.PassportAppMonitor;
import com.youku.usercenter.passport.task.HYTask;
import com.youku.usercenter.passport.util.CookieUtil;
import com.youku.usercenter.passport.util.EncryptUtil;
import com.youku.usercenter.passport.util.Logger;
import com.youku.usercenter.passport.util.MiscUtil;
import com.youku.usercenter.passport.util.SysUtil;
import java.net.URLEncoder;
import java.util.Iterator;
import mtopsdk.mtop.intf.Mtop;
import org.json.JSONObject;

/* compiled from: Taobao */
/* loaded from: classes3.dex */
public class Account {
    private static final boolean DEBUG = false;
    private static final String KEY_ACCOUNT = "account";
    private static final String KEY_AVATAR_URL = "avatarUrl";
    private static final String KEY_BOUND_MOBILE = "boundMobile";
    private static final String KEY_EMAIL = "email";
    private static final String KEY_EXPIRE_TIME = "expiretime";
    private static final String KEY_EXTRA_COOKIE = "extra_cookie";
    private static final String KEY_IS_LOGIN_MOBILE = "isLoginMobile";
    private static final String KEY_LAST_ACCOUNT = "last_account";
    private static final String KEY_MASK_MOBILE = "mask_mobile";
    private static final String KEY_MOBILE = "mobile";
    private static final String KEY_NICKNAME = "nickname";
    private static final String KEY_PTOKEN = "ptoken";
    private static final String KEY_REGION = "region";
    private static final String KEY_TID = "tid";
    private static final String KEY_USERNAME = "username";
    private static final String KEY_YID = "yid";
    private static final String KEY_YKTK = "yktk";
    private static final String KEY_YOUKU_UID = "youku_uid";
    private static final String KEY_YTID = "uid";
    private static final int PTOKEN_END = 24;
    private static final int PTOKEN_START = 8;
    public static String TAG = "Passport.Account";
    public String mAvatarUrl;
    public boolean mBoundMobile;
    private String mCookie;
    public String mEmail;
    public long mExpireTime;
    private JSONObject mExtraCookie;
    public boolean mIsLoginMobile;
    public String mMaskMobile;
    public String mMobile;
    public String mNickName;
    public String mPToken;
    public String mRegion;
    public String mSToken;
    private volatile long mSTokenGenTime;
    public String mTid;
    public String mUserName;
    public String mYid;
    public String mYktk;
    public String mYoukuUid;
    public String mYtid;

    private Account() {
    }

    private void checkSTokenTime() {
        long timestamp = PassportManager.getInstance().getTimestamp() - this.mSTokenGenTime;
        if (timestamp > RefreshTask.STOKEN_CHECK_INTERVAL) {
            AdapterForTLog.loge("YKLogin.Account", "sToken Refreshed from check! gap = " + timestamp + " mSTokenGenTime = " + this.mSTokenGenTime);
            refreshSToken();
            PassportAppMonitor.commitSTokenExpire("local");
        }
    }

    private static Account fromJSONObject(JSONObject jSONObject) {
        if (jSONObject == null) {
            return null;
        }
        Account account = new Account();
        account.mPToken = jSONObject.optString(KEY_PTOKEN);
        account.mUserName = jSONObject.optString("username");
        account.mYtid = jSONObject.optString("uid");
        account.mYid = jSONObject.optString(KEY_YID);
        account.mTid = jSONObject.optString("tid");
        account.mYoukuUid = jSONObject.optString(KEY_YOUKU_UID);
        account.mYktk = jSONObject.optString("yktk");
        account.mExtraCookie = jSONObject.optJSONObject(KEY_EXTRA_COOKIE);
        account.mNickName = jSONObject.optString(KEY_NICKNAME);
        account.mExpireTime = jSONObject.optLong(KEY_EXPIRE_TIME);
        account.mEmail = jSONObject.optString("email");
        account.mRegion = jSONObject.optString("region");
        account.mMobile = jSONObject.optString("mobile");
        account.mMaskMobile = jSONObject.optString(KEY_MASK_MOBILE);
        account.mAvatarUrl = jSONObject.optString("avatarUrl");
        account.mBoundMobile = jSONObject.optBoolean(KEY_BOUND_MOBILE);
        account.mIsLoginMobile = jSONObject.optBoolean(KEY_IS_LOGIN_MOBILE);
        return account;
    }

    private String genAuthInfo() {
        String str;
        if (TextUtils.isEmpty(this.mYtid)) {
            return null;
        }
        try {
            JSONObject jSONObject = new JSONObject();
            if (!TextUtils.isEmpty(this.mNickName)) {
                str = this.mNickName;
            } else if (!TextUtils.isEmpty(this.mMobile)) {
                str = this.mMobile;
            } else {
                str = !TextUtils.isEmpty(this.mEmail) ? this.mEmail : null;
            }
            jSONObject.put("displayName", str);
            jSONObject.put("portraitUrl", this.mAvatarUrl);
            return jSONObject.toString();
        } catch (Throwable th) {
            Logger.printStackTrace(th);
            return null;
        }
    }

    private synchronized String genSToken() {
        if (TextUtils.isEmpty(this.mPToken)) {
            this.mSToken = null;
            this.mSTokenGenTime = 0L;
            Logger.d("refreshSToken, ptoken is empty!");
            return null;
        }
        String str = this.mPToken;
        String str2 = this.mYtid;
        PassportConfig config = PassportManager.getInstance().getConfig();
        StringBuilder sb = new StringBuilder();
        StringBuilder sb2 = new StringBuilder();
        sb.append("1.0.0");
        sb.append("|");
        sb.append(config.mAppId);
        sb.append("|");
        sb.append(str.substring(8, 24));
        sb.append("|");
        String loginUtdid = PassportPreference.getInstance(config.mContext).getLoginUtdid();
        if (TextUtils.isEmpty(loginUtdid)) {
            loginUtdid = SysUtil.getDeviceId(config.mContext);
        }
        sb.append(loginUtdid);
        sb.append("|");
        long timestamp = PassportManager.getInstance().getTimestamp();
        sb.append(String.valueOf(timestamp));
        sb.append("|");
        sb.append(str2);
        sb.append("|");
        sb.append("Android");
        sb.append("|");
        sb.append(SysUtil.getOSVersion());
        sb.append("|");
        sb2.append("1.0.0");
        sb2.append(config.mAppId);
        sb2.append(str2);
        sb2.append(loginUtdid);
        sb2.append(String.valueOf(timestamp));
        sb2.append("Android");
        sb2.append(SysUtil.getOSVersion());
        sb2.append(str);
        sb.append(EncryptUtil.encryptMD5(sb2.toString(), true));
        this.mSToken = URLEncoder.encode(Base64.encodeToString(sb.toString().getBytes(), 2), "UTF-8");
        this.mSTokenGenTime = timestamp;
        return this.mSToken;
    }

    public static String getLastLoginYtid(Context context) {
        String str = PassportManager.getInstance().getUserInfo().mUid;
        return TextUtils.isEmpty(str) ? loadLast(context).mYtid : str;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static Account load(Context context) {
        Account account = null;
        try {
            String securityRead = MiscUtil.securityRead(context, "account");
            if (!TextUtils.isEmpty(securityRead)) {
                account = fromJSONObject(new JSONObject(securityRead));
            }
        } catch (Throwable th) {
            AdapterForTLog.loge(PassportManager.TAG, "getAccountInfo Exception! " + th.getMessage());
            Logger.printStackTrace(th);
        }
        return account == null ? new Account() : account;
    }

    static Account loadLast(Context context) {
        Account account = null;
        try {
            String securityRead = MiscUtil.securityRead(context, KEY_LAST_ACCOUNT);
            if (!TextUtils.isEmpty(securityRead)) {
                account = fromJSONObject(new JSONObject(securityRead));
            }
        } catch (Throwable th) {
            Logger.printStackTrace(th);
        }
        return account == null ? new Account() : account;
    }

    private void notifySTokenUpdated() {
        new HYTask(null) { // from class: com.youku.usercenter.passport.Account.1
            /* JADX INFO: Access modifiers changed from: protected */
            @Override // android.os.AsyncTask
            public String doInBackground(String... strArr) {
                PassportConfig config = PassportManager.getInstance().getConfig();
                Context context = config.mContext;
                Account account = Account.this;
                CookieUtil.syncCookie(context, account.mSToken, account.mYktk);
                IRefreshTokenListener iRefreshTokenListener = config.mRefreshTokenListener;
                if (iRefreshTokenListener != null) {
                    iRefreshTokenListener.onTokenRefreshed(Account.this.mSToken);
                }
                LocalBroadcastManager.getInstance(context).sendBroadcast(new Intent(IPassport.ACTION_TOKEN_REFRESHED).putExtra(IPassport.EXTRA_STOKEN, Account.this.mSToken).putExtra(IPassport.EXTRA_YTID, Account.this.mYtid));
                if (!RollBackSwitch.willRollBack(RollBackSwitch.ROLLBACK_REGISTER_MTOP)) {
                    try {
                        Mtop mtop = config.mSessionMtop;
                        if (mtop != null) {
                            Account account2 = Account.this;
                            mtop.registerSessionInfo(account2.mSToken, account2.mYtid);
                        } else {
                            Logger.e(Account.TAG, "did not set mtop in PassportConfig");
                        }
                        return null;
                    } catch (Throwable th) {
                        th.printStackTrace();
                        return null;
                    }
                }
                Logger.e(Account.TAG, "rollback register mtop");
                return null;
            }
        }.start(new String[0]);
    }

    private void refreshSTokenInner(boolean z) {
        Logger.d("refreshSToken");
        String genSToken = genSToken();
        this.mSToken = genSToken;
        if (TextUtils.isEmpty(genSToken)) {
            return;
        }
        notifySTokenUpdated();
        if (z) {
            refreshCookie();
        }
        AdapterForTLog.loge("YKLogin.Account", "sToken Refreshed! sToken = " + this.mSToken);
    }

    private JSONObject toJSONObject() {
        try {
            JSONObject jSONObject = new JSONObject();
            jSONObject.put(KEY_PTOKEN, this.mPToken);
            jSONObject.put("username", this.mUserName);
            jSONObject.put("uid", this.mYtid);
            jSONObject.put(KEY_YID, this.mYid);
            jSONObject.put("tid", this.mTid);
            jSONObject.put(KEY_YOUKU_UID, this.mYoukuUid);
            jSONObject.put("yktk", this.mYktk);
            jSONObject.put(KEY_EXTRA_COOKIE, this.mExtraCookie);
            jSONObject.put(KEY_NICKNAME, this.mNickName);
            jSONObject.put(KEY_EXPIRE_TIME, this.mExpireTime);
            jSONObject.put("email", this.mEmail);
            jSONObject.put("region", this.mRegion);
            jSONObject.put("mobile", this.mMobile);
            jSONObject.put(KEY_MASK_MOBILE, this.mMaskMobile);
            jSONObject.put("avatarUrl", this.mAvatarUrl);
            jSONObject.put(KEY_BOUND_MOBILE, this.mBoundMobile);
            return jSONObject;
        } catch (Exception e) {
            Logger.printStackTrace(e);
            return null;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void clearAccount(boolean z) {
        saveOrClearLastAccount(z);
        PassportConfig config = PassportManager.getInstance().getConfig();
        this.mPToken = null;
        this.mSToken = null;
        this.mSTokenGenTime = 0L;
        this.mYktk = null;
        this.mYtid = null;
        this.mYid = null;
        this.mTid = null;
        this.mYoukuUid = null;
        CookieUtil.clearExtraCookie(config.mContext, this.mExtraCookie);
        this.mExtraCookie = null;
        this.mCookie = null;
        this.mBoundMobile = false;
        save();
        CookieUtil.clearCookie(config.mContext);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Deprecated
    public synchronized String getCookie() {
        if (isLogin()) {
            if (TextUtils.isEmpty(this.mCookie)) {
                refreshCookie();
            } else {
                checkSTokenTime();
            }
            return this.mCookie;
        }
        return null;
    }

    public JSONObject getExtraCookie() {
        return this.mExtraCookie;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public synchronized String getSToken() {
        if (TextUtils.isEmpty(this.mPToken)) {
            return null;
        }
        if (this.mSToken == null) {
            refreshSToken();
        } else {
            checkSTokenTime();
        }
        return this.mSToken;
    }

    String getSTokenSilent() {
        if (TextUtils.isEmpty(this.mPToken)) {
            return null;
        }
        return genSToken();
    }

    boolean isLastAccountValid() {
        try {
            Account loadLast = loadLast(PassportManager.getInstance().getConfig().mContext);
            long timestamp = PassportManager.getInstance().getTimestamp();
            if (loadLast != null) {
                return timestamp < loadLast.mExpireTime;
            }
            return false;
        } catch (Throwable th) {
            Logger.printStackTrace(th);
            return false;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public boolean isLogin() {
        return (TextUtils.isEmpty(this.mPToken) && TextUtils.isEmpty(this.mYktk)) ? false : true;
    }

    public synchronized void refreshCookie() {
        StringBuilder sb = new StringBuilder();
        JSONObject jSONObject = this.mExtraCookie;
        if (jSONObject != null) {
            try {
                Iterator<String> keys = jSONObject.keys();
                while (keys.hasNext()) {
                    String next = keys.next();
                    sb.append(next);
                    sb.append("=");
                    sb.append(this.mExtraCookie.optString(next));
                    sb.append(";");
                }
            } catch (Exception e) {
                Logger.printStackTrace(e);
            }
        }
        if (!TextUtils.isEmpty(this.mPToken) && TextUtils.isEmpty(this.mSToken)) {
            refreshSTokenInner(false);
        }
        if (!TextUtils.isEmpty(this.mSToken)) {
            sb.append("P_sck");
            sb.append("=");
            sb.append(this.mSToken);
            sb.append(";");
        }
        if (!TextUtils.isEmpty(this.mYktk)) {
            sb.append("yktk");
            sb.append("=");
            sb.append(this.mYktk);
        }
        String sb2 = sb.toString();
        this.mCookie = sb2;
        if (sb2.endsWith(";")) {
            String str = this.mCookie;
            this.mCookie = str.substring(0, str.length() - 1);
        }
        try {
            PassportConfig config = PassportManager.getInstance().getConfig();
            IRefreshCookieListener iRefreshCookieListener = config.mRefreshCookieListener;
            if (iRefreshCookieListener != null) {
                iRefreshCookieListener.onCookieRefreshed(this.mCookie);
            }
            LocalBroadcastManager.getInstance(config.mContext).sendBroadcast(new Intent(IPassport.ACTION_COOKIE_REFRESHED).putExtra(IPassport.EXTRA_COOKIE, this.mCookie));
        } catch (Exception e2) {
            Logger.printStackTrace(e2);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void refreshSToken() {
        refreshSTokenInner(true);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void save() {
        try {
            JSONObject jSONObject = toJSONObject();
            if (jSONObject == null) {
                return;
            }
            MiscUtil.securitySave(PassportManager.getInstance().getConfig().mContext, "account", jSONObject.toString());
        } catch (Throwable th) {
            Logger.printStackTrace(th);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void saveOrClearLastAccount(boolean z) {
        try {
            Context context = PassportManager.getInstance().getConfig().mContext;
            if (PassportManager.getInstance().isFingerprintAuthEnabled() && z) {
                JSONObject jSONObject = toJSONObject();
                if (jSONObject == null) {
                    return;
                }
                MiscUtil.securitySave(context, KEY_LAST_ACCOUNT, jSONObject.toString());
            } else {
                MiscUtil.securityDelete(context, KEY_LAST_ACCOUNT);
            }
        } catch (Throwable th) {
            Logger.printStackTrace(th);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public UserInfo toUserInfo() {
        UserInfo userInfo = new UserInfo();
        userInfo.mUserName = this.mUserName;
        userInfo.mUid = this.mYtid;
        userInfo.mYid = this.mYid;
        userInfo.mTid = this.mTid;
        userInfo.mYoukuUid = this.mYoukuUid;
        userInfo.mNickName = this.mNickName;
        userInfo.mMobile = this.mMobile;
        userInfo.mEmail = this.mEmail;
        userInfo.mRegion = this.mRegion;
        userInfo.mAvatarUrl = this.mAvatarUrl;
        userInfo.mIsLoginMobile = this.mIsLoginMobile;
        return userInfo;
    }

    public void updateExtraCookie(JSONObject jSONObject) {
        JSONObject jSONObject2 = this.mExtraCookie;
        if (TextUtils.equals(jSONObject2 == null ? null : jSONObject2.toString(), jSONObject != null ? jSONObject.toString() : null)) {
            return;
        }
        this.mExtraCookie = jSONObject;
        CookieUtil.syncExtraCookie(PassportManager.getInstance().getConfig().mContext, this.mExtraCookie);
        save();
    }

    public void updateYktk(String str) {
        if (TextUtils.isEmpty(str) || TextUtils.equals(this.mYktk, str)) {
            return;
        }
        this.mYktk = str;
        CookieUtil.syncCookie(PassportManager.getInstance().getConfig().mContext, null, this.mYktk);
        save();
    }
}
