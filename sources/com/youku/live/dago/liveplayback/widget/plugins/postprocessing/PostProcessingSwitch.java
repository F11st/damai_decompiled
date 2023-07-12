package com.youku.live.dago.liveplayback.widget.plugins.postprocessing;

import android.content.Context;
import android.text.TextUtils;
import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import com.youku.alixplayer.opensdk.utils.Logger;
import com.youku.media.arch.instruments.ConfigFetcher;
import java.util.Arrays;

/* compiled from: Taobao */
/* loaded from: classes2.dex */
public class PostProcessingSwitch {
    private static transient /* synthetic */ IpChange $ipChange = null;
    static final String SWITCH_KEY = "switch_key";
    static final String SWITCH_NAMESPACE = "switch_namespace";
    static final String SWITCH_ON = "switch_on";
    static final String SWITCH_TYPE = "switch_type";
    private static String TAG = "PostProcessing-Switch";
    static final String TYPE_APS = "type_aps";
    static final String TYPE_SETTINGS = "type_setting";

    private static boolean isApsOn(JSONObject jSONObject) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-348272778")) {
            return ((Boolean) ipChange.ipc$dispatch("-348272778", new Object[]{jSONObject})).booleanValue();
        }
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
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1905451412")) {
            return ((Boolean) ipChange.ipc$dispatch("-1905451412", new Object[]{context, str})).booleanValue();
        }
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

    /* JADX WARN: Removed duplicated region for block: B:26:0x009a A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:27:0x009b  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private static boolean isSettingOn(android.content.Context r6, @androidx.annotation.NonNull com.alibaba.fastjson.JSONObject r7) {
        /*
            com.android.alibaba.ip.runtime.IpChange r0 = com.youku.live.dago.liveplayback.widget.plugins.postprocessing.PostProcessingSwitch.$ipChange
            java.lang.String r1 = "-1393114562"
            boolean r2 = com.android.alibaba.ip.runtime.AndroidInstantRuntime.support(r0, r1)
            r3 = 0
            r4 = 1
            if (r2 == 0) goto L1e
            r2 = 2
            java.lang.Object[] r2 = new java.lang.Object[r2]
            r2[r3] = r6
            r2[r4] = r7
            java.lang.Object r6 = r0.ipc$dispatch(r1, r2)
            java.lang.Boolean r6 = (java.lang.Boolean) r6
            boolean r6 = r6.booleanValue()
            return r6
        L1e:
            java.lang.String r0 = "switch_key"
            java.lang.String r0 = r7.getString(r0)
            r1 = 0
            boolean r2 = android.text.TextUtils.isEmpty(r0)     // Catch: java.lang.Exception -> L8d
            if (r2 == 0) goto L2c
            return r3
        L2c:
            android.net.Uri r2 = android.provider.Settings.System.CONTENT_URI     // Catch: java.lang.Exception -> L8d
            java.lang.String r2 = r2.toString()     // Catch: java.lang.Exception -> L8d
            boolean r5 = r0.startsWith(r2)     // Catch: java.lang.Exception -> L8d
            if (r5 == 0) goto L4b
            android.content.ContentResolver r6 = r6.getContentResolver()     // Catch: java.lang.Exception -> L8d
            int r2 = r2.length()     // Catch: java.lang.Exception -> L8d
            int r2 = r2 + r4
            java.lang.String r2 = r0.substring(r2)     // Catch: java.lang.Exception -> L8d
            java.lang.String r6 = android.provider.Settings.System.getString(r6, r2)     // Catch: java.lang.Exception -> L8d
        L49:
            r1 = r6
            goto L8e
        L4b:
            android.net.Uri r2 = android.provider.Settings.Secure.CONTENT_URI     // Catch: java.lang.Exception -> L8d
            java.lang.String r2 = r2.toString()     // Catch: java.lang.Exception -> L8d
            boolean r5 = r0.startsWith(r2)     // Catch: java.lang.Exception -> L8d
            if (r5 == 0) goto L69
            android.content.ContentResolver r6 = r6.getContentResolver()     // Catch: java.lang.Exception -> L8d
            int r2 = r2.length()     // Catch: java.lang.Exception -> L8d
            int r2 = r2 + r4
            java.lang.String r2 = r0.substring(r2)     // Catch: java.lang.Exception -> L8d
            java.lang.String r6 = com.alibaba.wireless.security.aopsdk.replace.android.provider.Settings.Secure.getString(r6, r2)     // Catch: java.lang.Exception -> L8d
            goto L49
        L69:
            int r2 = android.os.Build.VERSION.SDK_INT     // Catch: java.lang.Exception -> L8d
            r5 = 17
            if (r2 < r5) goto L8e
            android.net.Uri r2 = android.provider.Settings.Global.CONTENT_URI     // Catch: java.lang.Exception -> L8d
            java.lang.String r2 = r2.toString()     // Catch: java.lang.Exception -> L8d
            boolean r5 = r0.startsWith(r2)     // Catch: java.lang.Exception -> L8d
            if (r5 == 0) goto L8e
            android.content.ContentResolver r6 = r6.getContentResolver()     // Catch: java.lang.Exception -> L8d
            int r2 = r2.length()     // Catch: java.lang.Exception -> L8d
            int r2 = r2 + r4
            java.lang.String r2 = r0.substring(r2)     // Catch: java.lang.Exception -> L8d
            java.lang.String r6 = android.provider.Settings.Global.getString(r6, r2)     // Catch: java.lang.Exception -> L8d
            goto L49
        L8d:
        L8e:
            java.lang.String r6 = "switch_on"
            java.lang.String r6 = r7.getString(r6)
            boolean r7 = android.text.TextUtils.isEmpty(r6)
            if (r7 == 0) goto L9b
            return r3
        L9b:
            boolean r7 = com.youku.alixplayer.opensdk.utils.Logger.DEBUG
            if (r7 == 0) goto Lc5
            java.lang.String r7 = com.youku.live.dago.liveplayback.widget.plugins.postprocessing.PostProcessingSwitch.TAG
            java.lang.StringBuilder r2 = new java.lang.StringBuilder
            r2.<init>()
            java.lang.String r3 = "isSettingOn key="
            r2.append(r3)
            r2.append(r0)
            java.lang.String r0 = " switchOn="
            r2.append(r0)
            r2.append(r6)
            java.lang.String r0 = " value="
            r2.append(r0)
            r2.append(r1)
            java.lang.String r0 = r2.toString()
            com.youku.alixplayer.opensdk.utils.Logger.d(r7, r0)
        Lc5:
            java.lang.String r7 = ","
            java.lang.String[] r6 = r6.split(r7)
            java.util.List r6 = java.util.Arrays.asList(r6)
            boolean r6 = r6.contains(r1)
            return r6
        */
        throw new UnsupportedOperationException("Method not decompiled: com.youku.live.dago.liveplayback.widget.plugins.postprocessing.PostProcessingSwitch.isSettingOn(android.content.Context, com.alibaba.fastjson.JSONObject):boolean");
    }
}
