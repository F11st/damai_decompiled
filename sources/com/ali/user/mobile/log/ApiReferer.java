package com.ali.user.mobile.log;

import android.text.TextUtils;
import com.ali.user.mobile.app.dataprovider.DataProviderFactory;
import com.ali.user.mobile.info.AppInfo;
import com.alibaba.fastjson.JSON;
import com.taobao.login4android.constants.LoginConstants;
import com.taobao.login4android.session.SessionManager;
import com.taobao.login4android.session.constants.SessionConstants;
import com.taobao.weex.annotation.JSMethod;
import java.io.Serializable;

/* compiled from: Taobao */
/* loaded from: classes17.dex */
public class ApiReferer {
    public static final String TAG = "loginsdk.ApiReferer";

    /* compiled from: Taobao */
    /* loaded from: classes17.dex */
    public static class Refer implements Serializable {
        public String errorCode;
        public String errorMessage;
        public String eventName;
        public String site;
        public String userId;

        public Refer() {
        }

        public Refer(String str) {
            this.eventName = str;
        }
    }

    public static String generateApiReferer() {
        try {
            String eventTrace = SessionManager.getInstance(DataProviderFactory.getApplicationContext()).getEventTrace();
            return TextUtils.isEmpty(eventTrace) ? JSON.toJSONString(new Refer(LoginConstants.EVENT_SESSION_INVALID)) : eventTrace;
        } catch (Exception e) {
            e.printStackTrace();
            return "";
        }
    }

    public static String generateTraceId(String str, String str2) {
        return generateTraceId(str, str2, "");
    }

    public static String getApiRefer() {
        return DataProviderFactory.getApplicationContext() != null ? DataProviderFactory.getApplicationContext().getSharedPreferences(SessionManager.USERINFO, 4).getString(SessionConstants.EVENT_TRACE, "") : "";
    }

    public static String generateTraceId(String str, String str2, String str3) {
        if (TextUtils.isEmpty(str)) {
            return "";
        }
        String str4 = str + JSMethod.NOT_SET + AppInfo.getInstance().getUtdid() + JSMethod.NOT_SET + (System.currentTimeMillis() / 1000);
        if (!TextUtils.isEmpty(str2)) {
            str4 = str4 + JSMethod.NOT_SET + str2.replaceAll(JSMethod.NOT_SET, "");
        }
        if (TextUtils.isEmpty(str3)) {
            return str4;
        }
        return str4 + JSMethod.NOT_SET + str3;
    }
}
