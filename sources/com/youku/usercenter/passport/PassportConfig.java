package com.youku.usercenter.passport;

import android.content.Context;
import android.text.TextUtils;
import com.youku.usercenter.passport.listener.IAuthorizeListener;
import com.youku.usercenter.passport.listener.IRefreshCookieListener;
import com.youku.usercenter.passport.listener.IRefreshTokenListener;
import com.youku.usercenter.passport.util.Logger;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import mtopsdk.mtop.intf.Mtop;
import org.json.JSONArray;

/* compiled from: Taobao */
/* loaded from: classes3.dex */
public final class PassportConfig {
    public static final String STATISTIC_APPSTORE = "appStore";
    public static final String STATISTIC_GUID = "guid";
    public static final String STATISTIC_OUID = "ouId";
    public static final String STATISTIC_RGUID = "rguId";
    public static final String STATISTIC_UTDID = "utdId";
    public static final String STOKEN_GEN_VERSION = "1.0.0";
    public String mAppId;
    public String mAppSecret;
    public Context mContext;
    public boolean mDebug;
    public Domain mDomain;
    public IAuthorizeListener mListener;
    public List<String> mLoginUrls;
    public boolean mNeedBind;
    public IRefreshCookieListener mRefreshCookieListener;
    public IRefreshTokenListener mRefreshTokenListener;
    public List<String> mRegisterUrls;
    public boolean mServerFpAuth;
    public Mtop mSessionMtop;
    public String mSessionSite;
    public Map<String, String> mStatistics;
    public boolean mSuccessToast;
    private boolean mUseMtop;
    private boolean mUseMtopServer;
    private boolean mUseOrange;
    public int orientation;

    /* compiled from: Taobao */
    /* loaded from: classes3.dex */
    public static class Builder {
        private String mAppId;
        private String mAppSecret;
        private Context mContext;
        private IAuthorizeListener mListener;
        private IRefreshCookieListener mRefreshCookieListener;
        private IRefreshTokenListener mRefreshTokenListener;
        private Mtop mSessionMtop;
        private Map<String, String> mStatistics;
        private boolean mUseOrange;
        private Domain mDomain = Domain.DOMAIN_ONLINE;
        private boolean mDebug = false;
        private boolean mSuccessToast = true;
        private boolean mUseMtop = false;
        private int orientation = 1;
        private String mSessionSite = "youku";
        private boolean mNeedBind = true;

        public Builder(Context context) {
            this.mContext = context.getApplicationContext();
        }

        public PassportConfig build() {
            if (!TextUtils.isEmpty(this.mAppId) && !TextUtils.isEmpty(this.mAppSecret)) {
                return new PassportConfig(this);
            }
            throw new IllegalArgumentException("appId and appSecret can't be null!");
        }

        public Mtop getSessionMtop() {
            return this.mSessionMtop;
        }

        public Builder setAuthorizeListener(IAuthorizeListener iAuthorizeListener) {
            this.mListener = iAuthorizeListener;
            return this;
        }

        public Builder setDebug(boolean z) {
            this.mDebug = z;
            return this;
        }

        public Builder setDomain(Domain domain) {
            this.mDomain = domain;
            return this;
        }

        public void setNeedBind(boolean z) {
            this.mNeedBind = z;
        }

        public Builder setProductLineInfo(String str, String str2) {
            this.mAppId = str;
            this.mAppSecret = str2;
            return this;
        }

        @Deprecated
        public Builder setRefreshCookieListener(IRefreshCookieListener iRefreshCookieListener) {
            this.mRefreshCookieListener = iRefreshCookieListener;
            return this;
        }

        public Builder setRefreshTokenListener(IRefreshTokenListener iRefreshTokenListener) {
            this.mRefreshTokenListener = iRefreshTokenListener;
            return this;
        }

        public Builder setSessionMtop(Mtop mtop) {
            this.mSessionMtop = mtop;
            return this;
        }

        public void setSessionSite(String str) {
            this.mSessionSite = str;
        }

        public Builder setStatistics(Map<String, String> map) {
            this.mStatistics = map;
            return this;
        }

        public Builder setUseMtop(boolean z) {
            this.mUseMtop = z;
            return this;
        }

        public Builder setUseOrange(boolean z) {
            this.mUseOrange = z;
            return this;
        }
    }

    public boolean getMtopServer() {
        return this.mUseMtopServer;
    }

    public boolean isUseOrange() {
        return this.mUseOrange;
    }

    public void setUseMtopServer(boolean z) {
        this.mUseMtopServer = z;
    }

    public boolean userMtop() {
        return true;
    }

    private PassportConfig(Builder builder) {
        this.mDebug = false;
        this.mUseMtopServer = true;
        this.orientation = 1;
        this.mNeedBind = true;
        this.mContext = builder.mContext;
        this.mAppId = builder.mAppId;
        this.mAppSecret = builder.mAppSecret;
        this.mDomain = builder.mDomain;
        this.mListener = builder.mListener;
        this.mRefreshTokenListener = builder.mRefreshTokenListener;
        this.mRefreshCookieListener = builder.mRefreshCookieListener;
        this.mDebug = builder.mDebug;
        this.mStatistics = builder.mStatistics;
        this.mSuccessToast = builder.mSuccessToast;
        this.mUseMtop = builder.mUseMtop;
        this.mUseOrange = builder.mUseOrange;
        this.mLoginUrls = new ArrayList();
        this.mRegisterUrls = new ArrayList();
        this.orientation = builder.orientation;
        this.mSessionMtop = builder.mSessionMtop;
        this.mSessionSite = builder.mSessionSite;
        this.mNeedBind = builder.mNeedBind;
        this.mServerFpAuth = PassportPreference.getInstance(this.mContext).isServerFpAuthEnabled();
        String loginUrls = PassportPreference.getInstance(this.mContext).getLoginUrls();
        String registerUrls = PassportPreference.getInstance(this.mContext).getRegisterUrls();
        PassportPreference.getInstance(this.mContext).getThirdPartyLogin();
        try {
            if (!TextUtils.isEmpty(loginUrls)) {
                JSONArray jSONArray = new JSONArray(loginUrls);
                for (int i = 0; i < jSONArray.length(); i++) {
                    this.mLoginUrls.add(jSONArray.getString(i));
                }
            }
            if (TextUtils.isEmpty(registerUrls)) {
                return;
            }
            JSONArray jSONArray2 = new JSONArray(registerUrls);
            for (int i2 = 0; i2 < jSONArray2.length(); i2++) {
                this.mRegisterUrls.add(jSONArray2.getString(i2));
            }
        } catch (Exception e) {
            Logger.printStackTrace(e);
        }
    }
}
