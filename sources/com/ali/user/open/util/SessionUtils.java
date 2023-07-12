package com.ali.user.open.util;

import com.ali.user.open.core.util.JSONUtils;
import com.ali.user.open.session.InternalSession;
import com.taobao.login4android.session.constants.SessionConstants;
import java.util.Map;
import org.json.JSONException;
import org.json.JSONObject;

/* compiled from: Taobao */
/* loaded from: classes9.dex */
public class SessionUtils {
    public static String toInternalSessionJSON(InternalSession internalSession) {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put(SessionConstants.LOGIN_TIME, internalSession.loginTime);
            jSONObject.put("expireIn", internalSession.expireIn);
            jSONObject.put("sid", internalSession.sid);
            jSONObject.put("site", internalSession.site);
            jSONObject.put("mobile", internalSession.mobile);
            jSONObject.put("loginId", internalSession.loginId);
            jSONObject.put("autoLoginToken", internalSession.autoLoginToken);
            jSONObject.put("topAccessToken", internalSession.topAccessToken);
            jSONObject.put("topAuthCode", internalSession.topAuthCode);
            jSONObject.put("topExpireTime", internalSession.topExpireTime);
            jSONObject.put("avatarUrl", internalSession.avatarUrl);
            jSONObject.put("userId", internalSession.userId);
            jSONObject.put("openId", internalSession.openId);
            jSONObject.put("openSid", internalSession.openSid);
            jSONObject.put("nick", internalSession.nick);
            jSONObject.put("deviceTokenKey", internalSession.deviceTokenKey);
            jSONObject.put("deviceTokenSalt", internalSession.deviceTokenSalt);
            Map<String, Object> map = internalSession.otherInfo;
            if (map != null) {
                jSONObject.put("otherInfo", JSONUtils.toJsonObject(map));
            }
            return jSONObject.toString();
        } catch (JSONException e) {
            throw new RuntimeException(e);
        }
    }
}
