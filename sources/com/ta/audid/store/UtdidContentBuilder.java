package com.ta.audid.store;

import android.content.Context;
import com.alibaba.analytics.core.config.AudidConfigListener;
import com.ta.audid.Variables;
import com.ta.audid.upload.UtdidKeyFile;
import com.ta.utdid2.android.utils.StringUtils;
import java.util.HashMap;
import org.json.JSONObject;

/* compiled from: Taobao */
/* loaded from: classes7.dex */
public class UtdidContentBuilder {
    private static final String BODY = "{\"type\":\"%s\",\"timestamp\":%s,\"data\":%s}";
    private static final String MODULE_APPKEY = "appkey";
    private static final String MODULE_APPNAME = "appName";
    private static final String MODULE_AUDID = "audid";
    private static final String MODULE_UTDID = "utdid";
    private static final String TYPE_AUDID = "audid";

    private static String buildAudidDataJsonString(String str, String str2, String str3, String str4) {
        HashMap hashMap = new HashMap();
        hashMap.put(AudidConfigListener.KEY, str2);
        hashMap.put("utdid", str);
        hashMap.put("appkey", str3);
        hashMap.put("appName", str4);
        return new JSONObject(StringUtils.sortMapByKey(hashMap)).toString();
    }

    public static String buildUDID(String str) {
        Context context = Variables.getInstance().getContext();
        return context == null ? "" : StringUtils.getStringWithoutBlank(String.format(BODY, AudidConfigListener.KEY, Variables.getInstance().getCurrentTimeMillisString(), buildAudidDataJsonString(str, UtdidKeyFile.readAudidFile(), "", context.getPackageName())));
    }
}
