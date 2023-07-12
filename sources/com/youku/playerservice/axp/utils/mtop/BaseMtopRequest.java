package com.youku.playerservice.axp.utils.mtop;

import com.alibaba.fastjson.JSON;
import com.youku.playerservice.axp.utils.Logger;
import java.util.HashMap;
import java.util.Map;
import mtopsdk.mtop.domain.IMTOPDataObject;
import mtopsdk.mtop.domain.MtopResponse;
import tb.jn1;

/* compiled from: Taobao */
/* loaded from: classes3.dex */
public abstract class BaseMtopRequest implements IMTOPDataObject {
    private static final String DEVICE = "ANDROID";
    protected static final String TAG = "BaseMtopRequest";
    public String API_NAME;
    public String VERSION;
    public boolean NEED_ECODE = false;
    public boolean NEED_SESSION = false;
    public String filter = null;
    public String system_info = null;
    public long channel_id = 0;
    public String layout_ver = "100000";
    public String root = "MAIN";
    public HashMap<String, Object> mParamsMap = new HashMap<>();

    public static String convertMapToDataStr(Map<String, Object> map) {
        StringBuilder sb = new StringBuilder(64);
        sb.append(jn1.BLOCK_START_STR);
        if (map != null && !map.isEmpty()) {
            for (Map.Entry<String, Object> entry : map.entrySet()) {
                String key = entry.getKey();
                String str = (String) entry.getValue();
                if (key != null && str != null) {
                    try {
                        sb.append(JSON.toJSONString(key));
                        sb.append(":");
                        sb.append(JSON.toJSONString(str));
                        sb.append(",");
                    } catch (Throwable th) {
                        StringBuilder sb2 = new StringBuilder(64);
                        sb2.append("[converMapToDataStr] convert key=");
                        sb2.append(key);
                        sb2.append(",value=");
                        sb2.append(str);
                        sb2.append(" to dataStr error.");
                        Logger.e("mtopsdk.ups ReflectUtil", sb2.toString(), th);
                    }
                }
            }
            int length = sb.length();
            if (length > 1) {
                sb.deleteCharAt(length - 1);
            }
        }
        sb.append("}");
        return sb.toString();
    }

    public abstract MtopResponse doMtopRequest(HashMap<String, Object> hashMap);
}
