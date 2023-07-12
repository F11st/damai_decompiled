package com.youku.playerservice.axp.utils;

import android.content.Context;
import android.content.SharedPreferences;
import android.preference.PreferenceManager;
import com.youku.playerservice.axp.item.HdrType;
import com.youku.playerservice.axp.item.MediaMap;
import com.youku.playerservice.axp.item.Quality;
import java.util.HashMap;
import java.util.Map;

/* compiled from: Taobao */
/* loaded from: classes3.dex */
public class QualityUtil {
    private static final String ABR_PREF_FILE = "ABR_FILE";
    private static final String ABR_PREF_KEY_LAST_QUALITY = "lastQualityBeforeSwitch";
    private static final String ABR_PREF_KEY_LAST_QUALITY_CHANGED = "lastTimeQualityChanged";
    private static final String ABR_PREF_KEY_LAST_QUALITY_CHANGED_ABR = "lastTimeQualityChangedFromAuto";
    private static Quality sLastQuality;
    private static Long sLastQualityChangeTs;

    public static Quality getLastQuality(Context context) {
        if (sLastQuality == null) {
            sLastQuality = Quality.getQualityByUpsCode(context.getSharedPreferences(ABR_PREF_FILE, 0).getInt(ABR_PREF_KEY_LAST_QUALITY, 0));
        }
        return sLastQuality;
    }

    public static long getLastQualityChangeTs(Context context) {
        if (sLastQualityChangeTs == null) {
            sLastQualityChangeTs = Long.valueOf(context.getSharedPreferences(ABR_PREF_FILE, 0).getLong(ABR_PREF_KEY_LAST_QUALITY_CHANGED, -1L));
        }
        return sLastQualityChangeTs.longValue();
    }

    public static Quality getQualityFromSetting(Context context) {
        return Quality.getQualityByAbrCode(PreferenceManager.getDefaultSharedPreferences(context).getInt("video_quality", -1));
    }

    public static Map<String, Object> saveQualityChange(Context context, Quality quality, Quality quality2) {
        HashMap hashMap = new HashMap();
        hashMap.put("from", quality);
        hashMap.put("to", quality2);
        sLastQualityChangeTs = Long.valueOf(System.currentTimeMillis());
        sLastQuality = quality;
        int upsCode = quality.getUpsCode();
        SharedPreferences sharedPreferences = context.getSharedPreferences(ABR_PREF_FILE, 0);
        sharedPreferences.edit().putLong(ABR_PREF_KEY_LAST_QUALITY_CHANGED, sLastQualityChangeTs.longValue()).apply();
        sharedPreferences.edit().putInt(ABR_PREF_KEY_LAST_QUALITY, upsCode).apply();
        if (quality == Quality.AUTO) {
            sharedPreferences.edit().putLong(ABR_PREF_KEY_LAST_QUALITY_CHANGED_ABR, sLastQualityChangeTs.longValue()).apply();
        }
        return hashMap;
    }

    public static boolean smooth(String str, String str2) {
        String str3;
        MediaMap.MediaFormat media = MediaMap.getMedia(str);
        MediaMap.MediaFormat media2 = MediaMap.getMedia(str2);
        if (media == null || media2 == null) {
            return true;
        }
        HdrType hdrType = media.getHdrType();
        HdrType hdrType2 = HdrType.HDR_10;
        if (hdrType == hdrType2 || media2.getHdrType() == hdrType2) {
            str3 = "源流为HDR10不支持平滑切";
        } else if (media.getStreamType().contains("bit10") || media2.getStreamType().contains("bit10")) {
            str3 = "10bit从平滑切转化为硬切";
        } else if (media.getStreamType().startsWith("cmfv") || media2.getStreamType().startsWith("cmfv")) {
            str3 = "CMAF从平滑切转化成硬切";
        } else {
            Quality quality = media.getQuality();
            Quality quality2 = Quality.DOLBY;
            if (quality == quality2 || media2.getQuality() == quality2) {
                str3 = "杜比不支持平滑切";
            } else {
                Quality quality3 = media.getQuality();
                Quality quality4 = Quality.SOUND;
                if (quality3 == quality4 || media2.getQuality() == quality4) {
                    str3 = "音频不支持平滑切";
                } else if (media.getCodec() == media2.getCodec()) {
                    return true;
                } else {
                    str3 = "新老流codec不一致，不支持平滑切";
                }
            }
        }
        TLogUtil.playLog(str3);
        return false;
    }
}
