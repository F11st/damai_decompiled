package com.youku.playerservice.axp.player;

import com.youku.alixplayer.IAlixPlayer;
import java.util.Map;

/* compiled from: Taobao */
/* loaded from: classes3.dex */
public class OtherFunc {
    private static final int UPLAYER_INFO_KEY_EXTRA_CHANNEL_INFO = 16;

    private static boolean getExtraChannelInfoByKey(IAlixPlayer iAlixPlayer, String str, boolean z) {
        return iAlixPlayer == null ? z : "1".equals(getValueByKeyInStr(iAlixPlayer.getPlayerInfoByKey(16), str));
    }

    private static String getValueByKeyInStr(String str, String str2) {
        String[] split;
        if (str != null) {
            try {
                String[] split2 = str.split(";");
                if (split2 == null || split2.length <= 0) {
                    return "";
                }
                for (String str3 : split2) {
                    if (str3 != null && str3.contains(str2) && (split = str3.split("=")) != null && split.length > 1 && split[0].equals(str2)) {
                        return split[1];
                    }
                }
                return "";
            } catch (Exception unused) {
                return "";
            }
        }
        return "";
    }

    public Object doAction(IAlixPlayer iAlixPlayer, String str, Map<String, Object> map) {
        String str2;
        if ("setColorBlindType".equals(str)) {
            iAlixPlayer.setColorBlindType(((Integer) map.get("type")).intValue(), ((Integer) map.get("level")).intValue());
            return null;
        } else if ("setVideoRendMove".equals(str)) {
            iAlixPlayer.setVideoRendMove(((Float) map.get("xmove")).floatValue(), ((Float) map.get("ymove")).floatValue());
            return null;
        } else if ("setNightMode".equals(str)) {
            iAlixPlayer.setNightMode(((Integer) map.get("level")).intValue());
            return null;
        } else {
            if ("getExtraChannelTipsEnable".equals(str)) {
                str2 = "extra_channel_enable_tips";
            } else if ("getExtraChannelEnable".equals(str)) {
                str2 = "extra_channel_enable";
            } else if (!"getUserSettingExtraChannel".equals(str)) {
                if ("setRotationMatrix".equals(str)) {
                    iAlixPlayer.setRotationMatrix(((Integer) map.get("length")).intValue(), (float[]) map.get("rotationMatrix"));
                    return null;
                } else if ("setGyroscopeActive".equals(str)) {
                    iAlixPlayer.setGyroscopeActive(((Boolean) map.get("isOpen")).booleanValue());
                    return null;
                } else if ("updateLocalConfig".equals(str)) {
                    try {
                        iAlixPlayer.getLocalConfigCenter().updateLocalConfig((String) map.get("namespace"), (String) map.get("key"), (String) map.get("value"));
                        return null;
                    } catch (Exception e) {
                        e.printStackTrace();
                        return null;
                    }
                } else {
                    return null;
                }
            } else {
                str2 = "user_extra_channel_enable";
            }
            return Boolean.valueOf(getExtraChannelInfoByKey(iAlixPlayer, str2, false));
        }
    }
}
