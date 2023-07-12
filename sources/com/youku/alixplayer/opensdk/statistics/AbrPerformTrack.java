package com.youku.alixplayer.opensdk.statistics;

import android.text.TextUtils;
import com.youku.alixplayer.opensdk.statistics.OnPlayerTrackListener;
import com.youku.alixplayer.opensdk.statistics.proxy.VpmCommit;
import com.youku.alixplayer.opensdk.utils.TLogUtil;
import com.youku.vpm.constants.TableField;
import com.youku.vpm.data.ExtrasInfo;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;

/* compiled from: Taobao */
/* loaded from: classes5.dex */
public class AbrPerformTrack {
    public static final String TAG = "AbrPerformTrack";
    private static Boolean isRegister = Boolean.FALSE;

    public AbrPerformTrack(Track track) {
    }

    private void commit(Map<String, String> map, Map<String, Double> map2) {
        if (VpmCommit.commitStatistics("abr_perform", isRegister.booleanValue(), map, map2)) {
            isRegister = Boolean.TRUE;
        }
    }

    private String getKeyString(String str, String str2, String str3, String str4) {
        if (str != null) {
            for (String str5 : str.split(str3)) {
                String[] split = str5.split(str2, 2);
                if (split.length == 2) {
                    String str6 = split[0];
                    String str7 = split[1];
                    if (str4.equals(str6) && !TextUtils.isEmpty(str7)) {
                        return str7;
                    }
                }
            }
            return null;
        }
        return null;
    }

    private void putAbrPerformInfo(String str, Map<String, String> map, StringBuilder sb) {
        for (String str2 : str.split(";")) {
            String[] split = str2.split("=", 2);
            if (split.length == 2) {
                String str3 = split[0];
                String str4 = split[1];
                if (map.containsKey(str3) && !TextUtils.isEmpty(str4)) {
                    map.put(str3, str4);
                }
                if ("HLSInfo".equals(str3) && !TextUtils.isEmpty(str4)) {
                    HashMap hashMap = new HashMap();
                    hashMap.put("playlistSourcerSwitch", "newSourcer=");
                    hashMap.put("abrScheme", "abrScheme=");
                    setExtra(str4, ":", "&", hashMap, sb);
                }
            }
        }
    }

    private boolean setExtra(String str, String str2, String str3, Map<String, String> map, StringBuilder sb) {
        if (str != null) {
            for (String str4 : str.split(str3)) {
                String[] split = str4.split(str2, 2);
                if (split.length == 2) {
                    String str5 = split[0];
                    String str6 = split[1];
                    for (Map.Entry<String, String> entry : map.entrySet()) {
                        String value = entry.getValue();
                        if (entry.getKey().equals(str5) && !TextUtils.isEmpty(str6)) {
                            sb.append(value);
                            sb.append(str6);
                            sb.append(";");
                        }
                    }
                }
            }
        }
        return true;
    }

    public void onMonitorPoint(Track track, String str, OnPlayerTrackListener.Result result) {
        if ("onePlay".equals(str) && "end".equals(result.getDimension("playType"))) {
            String paramsFromCore = track.getParamsFromCore("-1", null);
            if (TextUtils.isEmpty(paramsFromCore)) {
                return;
            }
            String dimension = result.getDimension(TableField.MEDIA_TYPE);
            String dimension2 = result.getDimension("vid");
            String dimension3 = result.getDimension("vvId");
            String dimension4 = result.getDimension(TableField.PS_ID);
            String dimension5 = result.getDimension(TableField.VIDEO_FORMAT);
            String dimension6 = result.getDimension(TableField.STREAM_TYPE);
            String dimension7 = result.getDimension(TableField.FILE_FORMAT);
            String dimension8 = result.getDimension(TableField.IS_VIP);
            String dimension9 = result.getDimension("isCDN");
            StringBuilder sb = new StringBuilder();
            String dimension10 = result.getDimension("extras_player_info");
            HashMap hashMap = new HashMap();
            hashMap.put("player_version", "newArch=");
            setExtra(dimension10, "=", ";", hashMap, sb);
            String keyString = getKeyString(result.getDimension(ExtrasInfo.EXTRAS), "=", ";", "wifiInfo");
            HashMap hashMap2 = new HashMap();
            hashMap2.put("netscore", "netScore=");
            setExtra(keyString, ":", ",", hashMap2, sb);
            LinkedHashMap linkedHashMap = new LinkedHashMap();
            linkedHashMap.put(TableField.MEDIA_TYPE, dimension);
            linkedHashMap.put("vid", dimension2);
            linkedHashMap.put("vvId", dimension3);
            linkedHashMap.put(TableField.PS_ID, dimension4);
            linkedHashMap.put(TableField.VIDEO_FORMAT, dimension5);
            linkedHashMap.put(TableField.STREAM_TYPE, dimension6);
            linkedHashMap.put(TableField.FILE_FORMAT, dimension7);
            linkedHashMap.put(TableField.IS_VIP, dimension8);
            linkedHashMap.put("isCdn", dimension9);
            linkedHashMap.put("performCount", "0");
            linkedHashMap.put("perform1", null);
            linkedHashMap.put("perform2", null);
            linkedHashMap.put("perform3", null);
            linkedHashMap.put("perform4", null);
            linkedHashMap.put("perform5", null);
            linkedHashMap.put("perform6", null);
            putAbrPerformInfo(paramsFromCore, linkedHashMap, sb);
            linkedHashMap.put("extra", sb.toString());
            if (track.getPlayerConfig().isExternal() || "0".equals(linkedHashMap.get("performCount"))) {
                return;
            }
            commit(linkedHashMap, new HashMap());
            TrackUtil.printlog("AbrPerformTrack", "abrPerform", linkedHashMap, new HashMap());
            TLogUtil.vpmLog("AbrPerformTrack:baseInfo:" + linkedHashMap.toString());
        }
    }
}
