package com.youku.playerservice.axp.utils;

import android.text.TextUtils;
import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONException;
import com.alibaba.fastjson.JSONObject;
import com.alimm.xadsdk.request.builder.IRequestConst;
import com.taobao.weex.common.Constants;
import com.youku.media.arch.instruments.ConfigFetcher;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

/* compiled from: Taobao */
/* loaded from: classes3.dex */
public class StreamTypeUtils {
    private static final String NAMESPACE_STREAMTYPE_MEDIAINFOS_CONTROL = "axp_player_streamtype_mediainfos";
    private static final String TAG = "StreamTypeUtils";
    private static boolean hasExecStreamTypeAPS;

    public static void getStreamTypeAttributeFromAPS() {
        String str;
        if (hasExecStreamTypeAPS) {
            Map<String, String> configs = ConfigFetcher.getInstance().getConfigs(NAMESPACE_STREAMTYPE_MEDIAINFOS_CONTROL);
            if (configs != null && configs.size() != 0) {
                for (Map.Entry<String, String> entry : configs.entrySet()) {
                    String key = entry.getKey();
                    String value = entry.getValue();
                    if (TextUtils.isEmpty(key) || TextUtils.isEmpty(value)) {
                        str = "key or value is null";
                    } else {
                        try {
                            JSONObject parseObject = JSON.parseObject(value);
                            if (parseObject == null) {
                                str = "StreamTypeObj is null";
                            } else if (updateLocalMap(key, parseObject)) {
                                hasExecStreamTypeAPS = true;
                            }
                        } catch (Exception unused) {
                            str = "parse StreamTypeAttributeValue error";
                        }
                    }
                }
                return;
            }
            str = "config is null";
        } else {
            str = "has exec!";
        }
        Logger.d(TAG, str);
    }

    public static void parseAndCacheStreamExt(String str) {
        if (TextUtils.isEmpty(str)) {
            Logger.d(TAG, "StreamExt is null");
            return;
        }
        try {
            JSONObject parseObject = JSON.parseObject(str);
            if (parseObject == null) {
                Logger.d(TAG, "jsonObject is null");
                return;
            }
            Set<String> keySet = parseObject.keySet();
            if (keySet != null && keySet.size() != 0) {
                Iterator<String> it = keySet.iterator();
                while (it != null && it.hasNext()) {
                    new ArrayList();
                    JSONObject jSONObject = parseObject.getJSONObject(it.next());
                    if (jSONObject != null) {
                        Iterator<String> it2 = jSONObject.keySet().iterator();
                        while (it2 != null && it2.hasNext()) {
                            String next = it2.next();
                            JSONObject jSONObject2 = jSONObject.getJSONObject(next);
                            Logger.d(TAG, "parseAndCacheStreamExt success,cache~");
                            updateLocalMap(next, jSONObject2);
                        }
                    }
                }
                return;
            }
            Logger.d(TAG, "langCodes is empty");
        } catch (JSONException e) {
            e.printStackTrace();
            Logger.d(TAG, "parseAndCacheStreamExt 异常");
        }
    }

    private static boolean updateLocalMap(String str, JSONObject jSONObject) {
        if (TextUtils.isEmpty(str) || jSONObject == null) {
            Logger.d(TAG, "StreamType or StreamTypeObj is null");
            return false;
        }
        String string = jSONObject.getString("mediatype");
        String string2 = jSONObject.getString("codec");
        String string3 = jSONObject.getString(Constants.Name.QUALITY);
        String string4 = jSONObject.getString("colorspace");
        String string5 = jSONObject.getString("bitdepth");
        String string6 = jSONObject.getString(IRequestConst.VR);
        String string7 = jSONObject.getString("audioeffect");
        String string8 = jSONObject.getString("vip");
        StringBuilder sb = new StringBuilder();
        sb.append("get istreamType info streamType = ");
        sb.append(str);
        sb.append(", mediatype = ");
        if (TextUtils.isEmpty(string)) {
            string = "";
        }
        sb.append(string);
        sb.append(", codec = ");
        if (TextUtils.isEmpty(string2)) {
            string2 = "";
        }
        sb.append(string2);
        sb.append(", quality = ");
        if (TextUtils.isEmpty(string3)) {
            string3 = "";
        }
        sb.append(string3);
        sb.append(", colorspace = ");
        if (TextUtils.isEmpty(string4)) {
            string4 = "";
        }
        sb.append(string4);
        sb.append(", bitdepth = ");
        if (TextUtils.isEmpty(string5)) {
            string5 = "";
        }
        sb.append(string5);
        sb.append(", vr = ");
        if (TextUtils.isEmpty(string6)) {
            string6 = "";
        }
        sb.append(string6);
        sb.append(", audioeffect = ");
        if (TextUtils.isEmpty(string7)) {
            string7 = "";
        }
        sb.append(string7);
        sb.append(", vip = ");
        if (TextUtils.isEmpty(string8)) {
            string8 = "";
        }
        sb.append(string8);
        Logger.d(TAG, sb.toString());
        return true;
    }
}
