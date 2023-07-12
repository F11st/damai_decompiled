package com.tencent.stat.common;

import android.content.Context;
import android.os.Build;
import android.util.DisplayMetrics;
import com.alimm.xadsdk.base.ut.AdUtConstants;
import com.alipay.sdk.m.s.a;
import com.meizu.cloud.pushsdk.notification.model.AdvanceSetting;
import com.tencent.stat.StatConfig;
import java.util.Locale;
import java.util.Map;
import java.util.TimeZone;
import org.json.JSONException;
import org.json.JSONObject;
import tb.jn1;

/* compiled from: Taobao */
/* loaded from: classes11.dex */
public class Env {
    private static JSONObject attr_json;
    static BasicEnv basicEnv;
    String conn;
    Integer tel_network;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: Taobao */
    /* loaded from: classes11.dex */
    public static class BasicEnv {
        String appVersion;
        String channel;
        DisplayMetrics display;
        int jb;
        String language;
        String manufacture;
        String model;
        String operator;
        int osVersion;
        String sd;
        String sdkVersion;
        String timezone;

        private BasicEnv(Context context) {
            this.sdkVersion = "1.0.0";
            this.osVersion = Build.VERSION.SDK_INT;
            this.model = com.alibaba.wireless.security.aopsdk.replace.android.os.Build.getMODEL();
            this.manufacture = com.alibaba.wireless.security.aopsdk.replace.android.os.Build.getMANUFACTURER();
            this.language = Locale.getDefault().getLanguage();
            this.jb = 0;
            this.display = StatCommonHelper.getDisplayMetrics(context);
            this.appVersion = StatCommonHelper.getCurAppVersion(context);
            this.channel = StatConfig.getInstallChannel(context);
            this.operator = StatCommonHelper.getSimOperator(context);
            this.timezone = TimeZone.getDefault().getID();
            this.jb = StatCommonHelper.hasRootAccess(context);
            this.sd = StatCommonHelper.getExternalStorageInfo(context);
        }

        void encode(JSONObject jSONObject) throws JSONException {
            jSONObject.put("sr", com.alibaba.wireless.security.aopsdk.replace.android.util.DisplayMetrics.getwidthPixels(this.display) + jn1.MUL + com.alibaba.wireless.security.aopsdk.replace.android.util.DisplayMetrics.getheightPixels(this.display));
            StatCommonHelper.jsonPut(jSONObject, a.w, this.appVersion);
            StatCommonHelper.jsonPut(jSONObject, "ch", this.channel);
            StatCommonHelper.jsonPut(jSONObject, "mf", this.manufacture);
            StatCommonHelper.jsonPut(jSONObject, a.t, this.sdkVersion);
            StatCommonHelper.jsonPut(jSONObject, "ov", Integer.toString(this.osVersion));
            jSONObject.put("os", 1);
            StatCommonHelper.jsonPut(jSONObject, "op", this.operator);
            StatCommonHelper.jsonPut(jSONObject, "lg", this.language);
            StatCommonHelper.jsonPut(jSONObject, AdUtConstants.XAD_UT_ARG_MD, this.model);
            StatCommonHelper.jsonPut(jSONObject, "tz", this.timezone);
            int i = this.jb;
            if (i != 0) {
                jSONObject.put("jb", i);
            }
            StatCommonHelper.jsonPut(jSONObject, "sd", this.sd);
        }
    }

    public Env(Context context) {
        this.tel_network = null;
        this.conn = null;
        getBasicEnv(context);
        this.tel_network = StatCommonHelper.getTelephonyNetworkType(context.getApplicationContext());
        this.conn = StatCommonHelper.getLinkedWay(context);
    }

    public static void appendEnvAttr(Context context, Map<String, String> map) throws JSONException {
        if (map == null) {
            return;
        }
        if (attr_json == null) {
            attr_json = new JSONObject();
        }
        for (Map.Entry<String, String> entry : map.entrySet()) {
            attr_json.put(entry.getKey(), entry.getValue());
        }
    }

    static BasicEnv getBasicEnv(Context context) {
        if (basicEnv == null) {
            basicEnv = new BasicEnv(context.getApplicationContext());
        }
        return basicEnv;
    }

    public void encode(JSONObject jSONObject) throws JSONException {
        JSONObject jSONObject2 = new JSONObject();
        BasicEnv basicEnv2 = basicEnv;
        if (basicEnv2 != null) {
            basicEnv2.encode(jSONObject2);
        }
        StatCommonHelper.jsonPut(jSONObject2, AdvanceSetting.CLEAR_NOTIFICATION, this.conn);
        Integer num = this.tel_network;
        if (num != null) {
            jSONObject2.put("tn", num);
        }
        jSONObject.put("ev", jSONObject2);
        JSONObject jSONObject3 = attr_json;
        if (jSONObject3 == null || jSONObject3.length() <= 0) {
            return;
        }
        jSONObject.put("eva", attr_json);
    }
}
