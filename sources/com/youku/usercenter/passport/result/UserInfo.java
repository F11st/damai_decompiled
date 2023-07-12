package com.youku.usercenter.passport.result;

import com.ali.user.mobile.register.RegistConstants;
import com.youku.usercenter.passport.util.Logger;
import org.json.JSONObject;

/* compiled from: Taobao */
/* loaded from: classes3.dex */
public class UserInfo extends Result {
    public String mAvatarUrl;
    public String mEmail;
    public boolean mIsLoginMobile;
    public String mMobile;
    public String mNickName;
    public String mRegion;
    public String mTid;
    public String mUid;
    public String mUserName;
    public String mYid;
    @Deprecated
    public String mYoukuUid;

    public JSONObject toJSONObject() {
        JSONObject jSONObject;
        Throwable th;
        try {
            jSONObject = new JSONObject();
        } catch (Throwable th2) {
            jSONObject = null;
            th = th2;
        }
        try {
            jSONObject.putOpt("username", this.mUserName);
            jSONObject.putOpt("uid", this.mUid);
            jSONObject.putOpt("nickname", this.mNickName);
            jSONObject.putOpt("email", this.mEmail);
            jSONObject.putOpt(RegistConstants.REGION_INFO, this.mRegion);
            jSONObject.putOpt("mobile", this.mMobile);
            jSONObject.putOpt("avatar", this.mAvatarUrl);
            jSONObject.putOpt("isLoginMobile", Boolean.valueOf(this.mIsLoginMobile));
        } catch (Throwable th3) {
            th = th3;
            Logger.printStackTrace(th);
            return jSONObject;
        }
        return jSONObject;
    }
}
