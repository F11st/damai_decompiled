package com.youku.playerservice.axp.postprocessing;

import android.content.Context;
import android.text.TextUtils;
import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.alibaba.fastjson.TypeReference;
import com.alibaba.fastjson.parser.Feature;
import com.youku.android.liveservice.bean.BypassPlayInfo;
import com.youku.android.liveservice.bean.LivePlayControl;
import com.youku.android.liveservice.bean.PlayerWidget;
import com.youku.android.liveservice.bean.Quality;
import com.youku.media.arch.instruments.ConfigFetcher;
import com.youku.playerservice.axp.axpinterface.IPlayerImplProtocol;
import com.youku.playerservice.axp.utils.Logger;
import com.youku.playerservice.axp.utils.TLogUtil;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import tb.jn1;

/* compiled from: Taobao */
/* loaded from: classes3.dex */
public class PostProcessingConfigManager {
    private static String TAG = "PostProcessing-PPM2";

    public static String convertMasterClientQualityToStreamType(LivePlayControl livePlayControl, int i) {
        if (livePlayControl != null) {
            for (Quality quality : livePlayControl.qualities) {
                if (quality.quality == i) {
                    return quality.bitStream;
                }
            }
            return "";
        }
        return "";
    }

    public static int doManualPostProcess(IPlayerImplProtocol iPlayerImplProtocol, String str, PlayerWidget playerWidget, String str2, boolean z) {
        JSONObject parseObject;
        List<JSONObject> parseArray;
        int pPFilterType;
        if (iPlayerImplProtocol == null) {
            return -1;
        }
        int playControlPostProcessMode = getPlayControlPostProcessMode(playerWidget);
        if (playControlPostProcessMode == 1) {
            String str3 = ConfigConstants.CONFIG_TYPE_NAMESPACE_MAP.get(str2);
            if (TextUtils.isEmpty(str3)) {
                return -1;
            }
            String currentPPTypeId = getCurrentPPTypeId(str);
            if (!TextUtils.isEmpty(currentPPTypeId) && (pPFilterType = getPPFilterType(str3)) != 0 && isPostProcessingEnable(null, str3)) {
                PPConfigItem pPConfigItemByTypeId = getPPConfigItemByTypeId(str3, currentPPTypeId);
                PPConfigItem pPConfigItemByLiveControl = getPPConfigItemByLiveControl(str3, playerWidget.clientConfig, currentPPTypeId);
                if ("2".equals(getPPMode(pPConfigItemByTypeId, pPConfigItemByLiveControl))) {
                    HashMap hashMap = new HashMap();
                    if (z) {
                        hashMap.put("type", pPConfigItemByLiveControl != null ? pPConfigItemByLiveControl.algorithm : pPConfigItemByTypeId.algorithm);
                        if (pPConfigItemByTypeId != null && !TextUtils.isEmpty(pPConfigItemByTypeId.extend)) {
                            hashMap.put("extend", pPConfigItemByTypeId.extend);
                        }
                        if (pPConfigItemByLiveControl != null && !TextUtils.isEmpty(pPConfigItemByLiveControl.extend)) {
                            hashMap.put("ups_extend", pPConfigItemByLiveControl.extend);
                        }
                    } else {
                        hashMap.put("type", "0");
                    }
                    int filter = iPlayerImplProtocol.setFilter(pPFilterType, hashMap);
                    String str4 = TAG;
                    TLogUtil.loge(str4, " manual  filter = " + pPFilterType + "  with params = " + hashMap + " , result = " + filter);
                    return filter;
                }
            }
        } else if (playControlPostProcessMode == 2 && (parseObject = JSON.parseObject(playerWidget.postProcessConfig)) != null && (parseArray = JSON.parseArray(parseObject.getString(str), JSONObject.class)) != null && !parseArray.isEmpty()) {
            for (JSONObject jSONObject : parseArray) {
                if (TextUtils.equals(str2, jSONObject.getString("appPostProcessingType")) && TextUtils.equals("2", jSONObject.getString("appPostProcessingMode"))) {
                    HashMap hashMap2 = new HashMap();
                    if (z) {
                        if (!TextUtils.isEmpty(jSONObject.getString("appPostProcessingAlgorithm"))) {
                            hashMap2.put("type", jSONObject.getString("appPostProcessingAlgorithm"));
                        }
                        if (!TextUtils.isEmpty(jSONObject.getString("appPostProcessingDefaultExtend"))) {
                            hashMap2.put("extend", jSONObject.getString("appPostProcessingDefaultExtend"));
                        }
                        if (!TextUtils.isEmpty(jSONObject.getString("appPostProcessingExtend"))) {
                            hashMap2.put("ups_extend", jSONObject.getString("appPostProcessingExtend"));
                        }
                    } else {
                        hashMap2.put("type", "0");
                    }
                    int filter2 = iPlayerImplProtocol.setFilter(Integer.parseInt(str2), hashMap2);
                    String str5 = TAG;
                    TLogUtil.loge(str5, "manual by pc  filter = " + str2 + "  with params = " + hashMap2 + " , result = " + filter2);
                    return filter2;
                }
            }
        }
        return -1;
    }

    public static String getCurrentPPTypeId(String str) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        return ConfigFetcher.getInstance().getConfig("pp_type_map_live", str, null);
    }

    private static String getPPConfigId(String str, String str2) {
        Map<String, Object> map;
        try {
            map = JSON.parseObject(ConfigFetcher.getInstance().getConfig(str, "app_post_processing_default_config", "")).getInnerMap();
        } catch (Exception unused) {
            map = null;
        }
        Map<String, String> parseTypeMap = parseTypeMap(map);
        String str3 = parseTypeMap.get(str2);
        if (str3 == null) {
            str3 = parseTypeMap.get("0");
        }
        if (Logger.DEBUG) {
            String str4 = TAG;
            Logger.d(str4, "getPPConfigId namespace = " + str + " ppTypeId = " + str2 + " ConfigId = " + str3);
        }
        return str3;
    }

    public static PPConfigItem getPPConfigItemByConfigId(String str, String str2) {
        HashMap hashMap;
        if (TextUtils.isEmpty(str2)) {
            return null;
        }
        try {
            hashMap = (HashMap) JSON.parseObject(ConfigFetcher.getInstance().getConfig(str, "app_post_processing_config_list", ""), new TypeReference<HashMap<String, PPConfigItem>>() { // from class: com.youku.playerservice.axp.postprocessing.PostProcessingConfigManager.1
            }, new Feature[0]);
        } catch (Exception unused) {
            hashMap = null;
        }
        if (hashMap != null) {
            return (PPConfigItem) hashMap.get(str2);
        }
        return null;
    }

    public static PPConfigItem getPPConfigItemByLiveControl(String str, BypassPlayInfo bypassPlayInfo, String str2) {
        if (bypassPlayInfo != null) {
            try {
                String str3 = bypassPlayInfo.livePlayControl.playerWidget.clientConfig;
                if (TextUtils.isEmpty(str3)) {
                    return null;
                }
                return getPPConfigItemByLiveControl(str, str3, str2);
            } catch (Exception e) {
                Logger.d(TAG, e);
                return null;
            }
        }
        return null;
    }

    public static PPConfigItem getPPConfigItemByLiveControl(String str, String str2, String str3) {
        try {
            if (TextUtils.isEmpty(str2)) {
                return null;
            }
            int pPFilterType = getPPFilterType(str);
            JSONObject parseObject = JSON.parseObject(str2);
            if (parseObject != null) {
                parseObject = parseObject.getJSONObject("post_process_config");
            }
            if (parseObject != null) {
                parseObject = parseObject.getJSONObject(String.valueOf(pPFilterType));
            }
            if (parseObject != null) {
                if (Logger.DEBUG) {
                    String str4 = TAG;
                    Logger.d(str4, "get ups config " + parseObject + " namespace = " + str + jn1.BRACKET_START_STR + pPFilterType + jn1.BRACKET_END_STR);
                }
                Map<String, String> parseTypeMap = parseTypeMap(parseObject.getInnerMap());
                String str5 = parseTypeMap.get(str3);
                if (TextUtils.isEmpty(str5)) {
                    str5 = parseTypeMap.get("0");
                }
                if (TextUtils.isEmpty(str5)) {
                    return null;
                }
                return getPPConfigItemByConfigId(str, str5);
            }
            return null;
        } catch (Exception e) {
            Logger.d(TAG, e);
            return null;
        }
    }

    public static PPConfigItem getPPConfigItemByTypeId(String str, String str2) {
        return getPPConfigItemByConfigId(str, getPPConfigId(str, str2));
    }

    public static int getPPFilterType(String str) {
        String config = ConfigFetcher.getInstance().getConfig(str, "app_post_processing_type", "0");
        if (TextUtils.isEmpty(config) || !TextUtils.isDigitsOnly(config)) {
            return 0;
        }
        return Integer.valueOf(config).intValue();
    }

    public static String getPPMode(PPConfigItem pPConfigItem, PPConfigItem pPConfigItem2) {
        return pPConfigItem2 != null ? pPConfigItem2.mode : pPConfigItem != null ? pPConfigItem.mode : "0";
    }

    public static String getPPMode(String str, String str2, String str3) {
        String str4 = ConfigConstants.CONFIG_TYPE_NAMESPACE_MAP.get(str3);
        if (TextUtils.isEmpty(str4)) {
            return "0";
        }
        String currentPPTypeId = getCurrentPPTypeId(str);
        return (!TextUtils.isEmpty(currentPPTypeId) && isPostProcessingEnable(null, str4)) ? getPPMode(getPPConfigItemByTypeId(str4, currentPPTypeId), getPPConfigItemByLiveControl(str4, str2, currentPPTypeId)) : "0";
    }

    public static int getPlayControlPostProcessMode(BypassPlayInfo bypassPlayInfo) {
        LivePlayControl livePlayControl;
        if (bypassPlayInfo == null || (livePlayControl = bypassPlayInfo.livePlayControl) == null) {
            return 0;
        }
        return getPlayControlPostProcessMode(livePlayControl.playerWidget);
    }

    private static int getPlayControlPostProcessMode(PlayerWidget playerWidget) {
        if (playerWidget == null) {
            return 0;
        }
        return playerWidget.postProcess;
    }

    public static boolean isModeEnable(PPConfigItem pPConfigItem, PPConfigItem pPConfigItem2) {
        String str = pPConfigItem != null ? pPConfigItem.mode : "0";
        if (pPConfigItem2 != null) {
            str = pPConfigItem2.mode;
        }
        return "1".equals(str);
    }

    public static boolean isPPMasterEnable(String str) {
        return "1".equals(ConfigFetcher.getInstance().getConfig(str, "app_post_processing_in_auto", "0"));
    }

    public static boolean isPostProcessingEnable(Context context, String str) {
        boolean z = "1".equals(ConfigFetcher.getInstance().getConfig(str, "app_post_processing_enable", "0")) && PostProcessingSwitch.isOn(context, ConfigFetcher.getInstance().getConfig(str, "app_post_processing_switch", null));
        if (Logger.DEBUG) {
            String str2 = TAG;
            Logger.d(str2, "isPostProcessingEnable namespace = " + str + " enable = " + z);
        }
        return z;
    }

    public static boolean isSupportAudioHbr(String str, String str2, PlayerWidget playerWidget) {
        JSONObject parseObject;
        List<JSONObject> parseArray;
        int playControlPostProcessMode = getPlayControlPostProcessMode(playerWidget);
        if (playControlPostProcessMode == 1) {
            String str3 = ConfigConstants.CONFIG_TYPE_NAMESPACE_MAP.get(str2);
            return (TextUtils.isEmpty(str3) || TextUtils.isEmpty(getCurrentPPTypeId(str)) || getPPFilterType(str3) == 0) ? false : true;
        }
        if (playControlPostProcessMode == 2 && (parseObject = JSON.parseObject(playerWidget.postProcessConfig)) != null && (parseArray = JSON.parseArray(parseObject.getString(str), JSONObject.class)) != null && !parseArray.isEmpty()) {
            for (JSONObject jSONObject : parseArray) {
                if (TextUtils.equals(str2, jSONObject.getString("appPostProcessingType")) && TextUtils.equals("2", jSONObject.getString("appPostProcessingMode"))) {
                    return true;
                }
            }
        }
        return false;
    }

    public static Map<String, String> parseTypeMap(Map<String, Object> map) {
        HashMap hashMap = new HashMap();
        if (map != null) {
            for (Map.Entry<String, Object> entry : map.entrySet()) {
                String key = entry.getKey();
                if (!TextUtils.isEmpty(key)) {
                    for (String str : key.split(",")) {
                        hashMap.put(str, entry.getValue().toString());
                    }
                }
            }
        }
        return hashMap;
    }
}
