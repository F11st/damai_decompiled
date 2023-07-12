package com.youku.live.dago.liveplayback.widget.plugins.postprocessing;

import android.content.Context;
import android.text.TextUtils;
import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.alibaba.fastjson.TypeReference;
import com.alibaba.fastjson.parser.Feature;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import com.youku.alixplayer.opensdk.IPlayer;
import com.youku.alixplayer.opensdk.utils.Logger;
import com.youku.alixplayer.opensdk.utils.TLogUtil;
import com.youku.android.liveservice.bean.BypassPlayInfo;
import com.youku.android.liveservice.bean.LivePlayControl;
import com.youku.android.liveservice.bean.PlayerWidget;
import com.youku.android.liveservice.bean.Quality;
import com.youku.media.arch.instruments.ConfigFetcher;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import tb.jn1;

/* compiled from: Taobao */
/* loaded from: classes2.dex */
public class PostProcessingConfigManager2 {
    private static transient /* synthetic */ IpChange $ipChange = null;
    private static String TAG = "PostProcessing-PPM2";

    public static String convertMasterClientQualityToStreamType(LivePlayControl livePlayControl, int i) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-665252122")) {
            return (String) ipChange.ipc$dispatch("-665252122", new Object[]{livePlayControl, Integer.valueOf(i)});
        }
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

    public static int doManualPostProcess(IPlayer iPlayer, String str, PlayerWidget playerWidget, String str2, boolean z) {
        JSONObject parseObject;
        List<JSONObject> parseArray;
        int pPFilterType;
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-187549766")) {
            return ((Integer) ipChange.ipc$dispatch("-187549766", new Object[]{iPlayer, str, playerWidget, str2, Boolean.valueOf(z)})).intValue();
        }
        if (iPlayer == null) {
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
                    int filter = iPlayer.setFilter(pPFilterType, hashMap);
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
                    int filter2 = iPlayer.setFilter(Integer.parseInt(str2), hashMap2);
                    String str5 = TAG;
                    TLogUtil.loge(str5, "manual by pc  filter = " + str2 + "  with params = " + hashMap2 + " , result = " + filter2);
                    return filter2;
                }
            }
        }
        return -1;
    }

    public static String getCurrentPPTypeId(String str) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1447124392")) {
            return (String) ipChange.ipc$dispatch("1447124392", new Object[]{str});
        }
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        return ConfigFetcher.getInstance().getConfig("pp_type_map_live", str, null);
    }

    private static String getPPConfigId(String str, String str2) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1135263291")) {
            return (String) ipChange.ipc$dispatch("1135263291", new Object[]{str, str2});
        }
        Map<String, Object> map = null;
        try {
            map = JSON.parseObject(ConfigFetcher.getInstance().getConfig(str, "app_post_processing_default_config", "")).getInnerMap();
        } catch (Exception unused) {
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
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1104138278")) {
            return (PPConfigItem) ipChange.ipc$dispatch("1104138278", new Object[]{str, str2});
        }
        if (TextUtils.isEmpty(str2)) {
            return null;
        }
        try {
            hashMap = (HashMap) JSON.parseObject(ConfigFetcher.getInstance().getConfig(str, "app_post_processing_config_list", ""), new TypeReference<HashMap<String, PPConfigItem>>() { // from class: com.youku.live.dago.liveplayback.widget.plugins.postprocessing.PostProcessingConfigManager2.1
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
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1281597784")) {
            return (PPConfigItem) ipChange.ipc$dispatch("-1281597784", new Object[]{str, bypassPlayInfo, str2});
        }
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

    public static PPConfigItem getPPConfigItemByTypeId(String str, String str2) {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "-710459794") ? (PPConfigItem) ipChange.ipc$dispatch("-710459794", new Object[]{str, str2}) : getPPConfigItemByConfigId(str, getPPConfigId(str, str2));
    }

    public static int getPPFilterType(String str) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-2146507271")) {
            return ((Integer) ipChange.ipc$dispatch("-2146507271", new Object[]{str})).intValue();
        }
        String config = ConfigFetcher.getInstance().getConfig(str, "app_post_processing_type", "0");
        if (TextUtils.isEmpty(config) || !TextUtils.isDigitsOnly(config)) {
            return 0;
        }
        return Integer.valueOf(config).intValue();
    }

    public static String getPPMode(PPConfigItem pPConfigItem, PPConfigItem pPConfigItem2) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1715437803")) {
            return (String) ipChange.ipc$dispatch("-1715437803", new Object[]{pPConfigItem, pPConfigItem2});
        }
        return pPConfigItem2 != null ? pPConfigItem2.mode : pPConfigItem != null ? pPConfigItem.mode : "0";
    }

    public static int getPlayControlPostProcessMode(BypassPlayInfo bypassPlayInfo) {
        LivePlayControl livePlayControl;
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-182163840")) {
            return ((Integer) ipChange.ipc$dispatch("-182163840", new Object[]{bypassPlayInfo})).intValue();
        }
        if (bypassPlayInfo == null || (livePlayControl = bypassPlayInfo.livePlayControl) == null) {
            return 0;
        }
        return getPlayControlPostProcessMode(livePlayControl.playerWidget);
    }

    public static boolean isModeEnable(PPConfigItem pPConfigItem, PPConfigItem pPConfigItem2) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1115350630")) {
            return ((Boolean) ipChange.ipc$dispatch("-1115350630", new Object[]{pPConfigItem, pPConfigItem2})).booleanValue();
        }
        String str = pPConfigItem != null ? pPConfigItem.mode : "0";
        if (pPConfigItem2 != null) {
            str = pPConfigItem2.mode;
        }
        return "1".equals(str);
    }

    public static boolean isPPMasterEnable(String str) {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "479707301") ? ((Boolean) ipChange.ipc$dispatch("479707301", new Object[]{str})).booleanValue() : "1".equals(ConfigFetcher.getInstance().getConfig(str, "app_post_processing_in_auto", "0"));
    }

    public static boolean isPostProcessingEnable(Context context, String str) {
        IpChange ipChange = $ipChange;
        boolean z = true;
        if (AndroidInstantRuntime.support(ipChange, "-1356579120")) {
            return ((Boolean) ipChange.ipc$dispatch("-1356579120", new Object[]{context, str})).booleanValue();
        }
        z = ("1".equals(ConfigFetcher.getInstance().getConfig(str, "app_post_processing_enable", "0")) && PostProcessingSwitch.isOn(context, ConfigFetcher.getInstance().getConfig(str, "app_post_processing_switch", null))) ? false : false;
        if (Logger.DEBUG) {
            String str2 = TAG;
            Logger.d(str2, "isPostProcessingEnable namespace = " + str + " enable = " + z);
        }
        return z;
    }

    public static boolean isSupportAudioHbr(String str, String str2, PlayerWidget playerWidget) {
        JSONObject parseObject;
        List<JSONObject> parseArray;
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-23218006")) {
            return ((Boolean) ipChange.ipc$dispatch("-23218006", new Object[]{str, str2, playerWidget})).booleanValue();
        }
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
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1476551299")) {
            return (Map) ipChange.ipc$dispatch("1476551299", new Object[]{map});
        }
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

    public static String getPPMode(String str, String str2, String str3) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-624297321")) {
            return (String) ipChange.ipc$dispatch("-624297321", new Object[]{str, str2, str3});
        }
        String str4 = ConfigConstants.CONFIG_TYPE_NAMESPACE_MAP.get(str3);
        if (TextUtils.isEmpty(str4)) {
            return "0";
        }
        String currentPPTypeId = getCurrentPPTypeId(str);
        return (!TextUtils.isEmpty(currentPPTypeId) && isPostProcessingEnable(null, str4)) ? getPPMode(getPPConfigItemByTypeId(str4, currentPPTypeId), getPPConfigItemByLiveControl(str4, str2, currentPPTypeId)) : "0";
    }

    public static PPConfigItem getPPConfigItemByLiveControl(String str, String str2, String str3) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-122709214")) {
            return (PPConfigItem) ipChange.ipc$dispatch("-122709214", new Object[]{str, str2, str3});
        }
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

    private static int getPlayControlPostProcessMode(PlayerWidget playerWidget) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1996831003")) {
            return ((Integer) ipChange.ipc$dispatch("-1996831003", new Object[]{playerWidget})).intValue();
        }
        if (playerWidget == null) {
            return 0;
        }
        return playerWidget.postProcess;
    }
}
