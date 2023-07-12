package com.ali.user.open.tbauth.util;

import android.text.TextUtils;
import com.ali.user.open.core.model.LoginDataModel;
import com.ali.user.open.core.model.LoginReturnData;
import com.ali.user.open.core.util.JSONUtils;
import com.ali.user.open.session.Session;
import java.util.Map;
import org.json.JSONObject;

/* compiled from: Taobao */
/* loaded from: classes9.dex */
public class SessionConvert {
    public static Session convertLoginDataToSeesion(LoginReturnData loginReturnData) {
        Session session = new Session();
        if (loginReturnData != null && !TextUtils.isEmpty(loginReturnData.data)) {
            try {
                LoginDataModel loginDataModel = (LoginDataModel) JSONUtils.toPOJO(new JSONObject(loginReturnData.data), LoginDataModel.class);
                session.openId = loginDataModel.openId;
                session.topAccessToken = loginDataModel.topAccessToken;
                session.topAuthCode = loginDataModel.topAuthCode;
                session.openSid = loginDataModel.openSid;
                session.nick = loginDataModel.nick;
                session.avatarUrl = loginDataModel.headPicLink;
                Map<String, String> map = loginReturnData.extMap;
                if (map != null) {
                    session.bindToken = map.get("bind_token");
                }
            } catch (Throwable unused) {
            }
        }
        return session;
    }
}
