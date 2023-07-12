package com.youku.playerservice.axp.postprocessing;

import android.content.Context;
import android.text.TextUtils;
import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.youku.media.arch.instruments.ConfigFetcher;
import com.youku.playerservice.axp.utils.Logger;
import java.util.Arrays;

/* compiled from: Taobao */
/* loaded from: classes3.dex */
public class PostProcessingSwitch {
    static final String SWITCH_KEY = "switch_key";
    static final String SWITCH_NAMESPACE = "switch_namespace";
    static final String SWITCH_ON = "switch_on";
    static final String SWITCH_TYPE = "switch_type";
    private static String TAG = "PostProcessing-Switch";
    static final String TYPE_APS = "type_aps";
    static final String TYPE_SETTINGS = "type_setting";

    private static boolean isApsOn(JSONObject jSONObject) {
        String string = jSONObject.getString(SWITCH_NAMESPACE);
        String string2 = jSONObject.getString(SWITCH_KEY);
        if (TextUtils.isEmpty(string) || TextUtils.isEmpty(string2)) {
            return false;
        }
        String config = ConfigFetcher.getInstance().getConfig(string, string2, null);
        String string3 = jSONObject.getString(SWITCH_ON);
        if (TextUtils.isEmpty(string3)) {
            return false;
        }
        if (Logger.DEBUG) {
            String str = TAG;
            Logger.d(str, "isApsOn namespace=" + string + " key=" + string2 + " switchOn=" + string3 + " value=" + config);
        }
        return Arrays.asList(string3.split(",")).contains(config);
    }

    public static boolean isOn(Context context, String str) {
        if (TextUtils.isEmpty(str)) {
            return true;
        }
        JSONObject jSONObject = null;
        try {
            jSONObject = JSON.parseObject(str);
        } catch (Exception unused) {
        }
        if (jSONObject == null) {
            return false;
        }
        if (Logger.DEBUG) {
            String str2 = TAG;
            Logger.d(str2, "isOn? " + jSONObject);
        }
        String string = jSONObject.getString(SWITCH_TYPE);
        if (TextUtils.isEmpty(string)) {
            return false;
        }
        string.hashCode();
        if (string.equals(TYPE_APS)) {
            return isApsOn(jSONObject);
        }
        if (string.equals(TYPE_SETTINGS) && context != null) {
            return isSettingOn(context, jSONObject);
        }
        return false;
    }

    /* JADX WARN: Removed duplicated region for block: B:22:0x0080 A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:23:0x0081  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private static boolean isSettingOn(android.content.Context r5, @androidx.annotation.NonNull com.alibaba.fastjson.JSONObject r6) {
        /*
            java.lang.String r0 = "switch_key"
            java.lang.String r0 = r6.getString(r0)
            r1 = 0
            r2 = 0
            boolean r3 = android.text.TextUtils.isEmpty(r0)     // Catch: java.lang.Exception -> L73
            if (r3 == 0) goto Lf
            return r1
        Lf:
            android.net.Uri r3 = android.provider.Settings.System.CONTENT_URI     // Catch: java.lang.Exception -> L73
            java.lang.String r3 = r3.toString()     // Catch: java.lang.Exception -> L73
            boolean r4 = r0.startsWith(r3)     // Catch: java.lang.Exception -> L73
            if (r4 == 0) goto L2f
            android.content.ContentResolver r5 = r5.getContentResolver()     // Catch: java.lang.Exception -> L73
            int r3 = r3.length()     // Catch: java.lang.Exception -> L73
            int r3 = r3 + 1
            java.lang.String r3 = r0.substring(r3)     // Catch: java.lang.Exception -> L73
            java.lang.String r5 = android.provider.Settings.System.getString(r5, r3)     // Catch: java.lang.Exception -> L73
        L2d:
            r2 = r5
            goto L74
        L2f:
            android.net.Uri r3 = android.provider.Settings.Secure.CONTENT_URI     // Catch: java.lang.Exception -> L73
            java.lang.String r3 = r3.toString()     // Catch: java.lang.Exception -> L73
            boolean r4 = r0.startsWith(r3)     // Catch: java.lang.Exception -> L73
            if (r4 == 0) goto L4e
            android.content.ContentResolver r5 = r5.getContentResolver()     // Catch: java.lang.Exception -> L73
            int r3 = r3.length()     // Catch: java.lang.Exception -> L73
            int r3 = r3 + 1
            java.lang.String r3 = r0.substring(r3)     // Catch: java.lang.Exception -> L73
            java.lang.String r5 = com.alibaba.wireless.security.aopsdk.replace.android.provider.Settings.Secure.getString(r5, r3)     // Catch: java.lang.Exception -> L73
            goto L2d
        L4e:
            int r3 = android.os.Build.VERSION.SDK_INT     // Catch: java.lang.Exception -> L73
            r4 = 17
            if (r3 < r4) goto L74
            android.net.Uri r3 = android.provider.Settings.Global.CONTENT_URI     // Catch: java.lang.Exception -> L73
            java.lang.String r3 = r3.toString()     // Catch: java.lang.Exception -> L73
            boolean r4 = r0.startsWith(r3)     // Catch: java.lang.Exception -> L73
            if (r4 == 0) goto L74
            android.content.ContentResolver r5 = r5.getContentResolver()     // Catch: java.lang.Exception -> L73
            int r3 = r3.length()     // Catch: java.lang.Exception -> L73
            int r3 = r3 + 1
            java.lang.String r3 = r0.substring(r3)     // Catch: java.lang.Exception -> L73
            java.lang.String r5 = android.provider.Settings.Global.getString(r5, r3)     // Catch: java.lang.Exception -> L73
            goto L2d
        L73:
        L74:
            java.lang.String r5 = "switch_on"
            java.lang.String r5 = r6.getString(r5)
            boolean r6 = android.text.TextUtils.isEmpty(r5)
            if (r6 == 0) goto L81
            return r1
        L81:
            boolean r6 = com.youku.playerservice.axp.utils.Logger.DEBUG
            if (r6 == 0) goto Lab
            java.lang.String r6 = com.youku.playerservice.axp.postprocessing.PostProcessingSwitch.TAG
            java.lang.StringBuilder r1 = new java.lang.StringBuilder
            r1.<init>()
            java.lang.String r3 = "isSettingOn key="
            r1.append(r3)
            r1.append(r0)
            java.lang.String r0 = " switchOn="
            r1.append(r0)
            r1.append(r5)
            java.lang.String r0 = " value="
            r1.append(r0)
            r1.append(r2)
            java.lang.String r0 = r1.toString()
            com.youku.playerservice.axp.utils.Logger.d(r6, r0)
        Lab:
            java.lang.String r6 = ","
            java.lang.String[] r5 = r5.split(r6)
            java.util.List r5 = java.util.Arrays.asList(r5)
            boolean r5 = r5.contains(r2)
            return r5
        */
        throw new UnsupportedOperationException("Method not decompiled: com.youku.playerservice.axp.postprocessing.PostProcessingSwitch.isSettingOn(android.content.Context, com.alibaba.fastjson.JSONObject):boolean");
    }
}
