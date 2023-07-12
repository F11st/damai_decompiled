package com.youku.youkuplayer.util;

import android.content.Context;
import android.text.TextUtils;
import android.util.Log;
import com.youku.playerservice.axp.axpinterface.PlayDefinition;
import com.youku.playerservice.axp.item.Quality;
import com.youku.playerservice.axp.playparams.PlayIdParams;
import com.youku.playerservice.axp.playparams.PlayParams;
import com.youku.playerservice.axp.playparams.PlayUrlParams;
import com.youku.youkuplayer.data.PlayParam;
import com.youku.youkuplayer.data.YKPlayerConfig;
import java.util.Map;

/* compiled from: Taobao */
/* loaded from: classes3.dex */
public class PlayerSDKUtils {
    public static PlayParams convert(PlayParam playParam, YKPlayerConfig yKPlayerConfig) {
        PlayParams playParams = null;
        if (playParam == null) {
            return null;
        }
        PlayDefinition.PlayScene playScene = PlayDefinition.PlayScene.UNKNOWN;
        yKPlayerConfig.putString("hardwareDecode", "");
        String cCode = yKPlayerConfig.getCCode();
        boolean isDisableAd = playParam.isDisableAd();
        long startTime = playParam.getStartTime();
        if (!TextUtils.isEmpty(playParam.getVid()) || !TextUtils.isEmpty(playParam.getShowId())) {
            String vid = playParam.getVid();
            if (TextUtils.isEmpty(vid)) {
                vid = playParam.getShowId();
            }
            PlayIdParams playIdParams = new PlayIdParams(vid, cCode);
            playIdParams.setDisableAd(isDisableAd);
            playIdParams.setLocalPlay(playParam.isLocalPlay());
            playIdParams.setClientId(yKPlayerConfig.getClient_id());
            playParams = PlayParams.createPlayParams(PlayDefinition.PlayType.VOD, playScene, playIdParams);
            Map<String, String> extMap = playParam.getExtMap();
            if (extMap != null && !extMap.isEmpty()) {
                playParams.getPlayIdParams().getExtraParams().putAll(extMap);
            }
            playParams.getPlayIdParams().setRequestQuality(Quality.getQualityByAbrCode(playParam.getQualityType()));
        } else if (!TextUtils.isEmpty(playParam.getLiveUrl())) {
            playParams = PlayParams.createPlayParams(PlayDefinition.PlayType.LIVE, playScene, PlayUrlParams.createPlayUrlParams(playParam.getLiveUrl(), PlayDefinition.PlayFormat.UNKNOWN));
        } else if (!TextUtils.isEmpty(playParam.getUrl()) || !TextUtils.isEmpty(playParam.getPath())) {
            String url = playParam.getUrl();
            if (TextUtils.isEmpty(url)) {
                url = playParam.getPath();
            }
            if (TextUtils.isEmpty(url)) {
                return null;
            }
            String token = playParam.getToken();
            if (!TextUtils.isEmpty(token)) {
                yKPlayerConfig.putString("player_url_token", token);
                if (url.startsWith("/")) {
                    url = "file:/" + url;
                }
            }
            playParams = PlayParams.createPlayParams(PlayDefinition.PlayType.URL, playScene, PlayUrlParams.createPlayUrlParams(url, PlayDefinition.PlayFormat.UNKNOWN));
        }
        if (playParams != null) {
            playParams.setStartTime(startTime);
            playParams.setReusedPlayer(yKPlayerConfig.isReusedPlayer());
            playParams.setUseSystemPlayer(playParam.isUseSystemPlayer());
            Map<String, String> extConfig = yKPlayerConfig.getExtConfig();
            if (extConfig != null && extConfig.size() > 0) {
                playParams.getExtConfigMap().putAll(extConfig);
            }
        }
        return playParams;
    }

    public static String getAppName(Context context) {
        try {
            return context.getPackageManager().getPackageInfo(context.getPackageName(), 0).applicationInfo.name;
        } catch (Exception e) {
            Log.e("VersionInfo", "Exception", e);
            return "";
        }
    }

    public static String getAppVersionCode(Context context) {
        int i = 0;
        try {
            i = context.getPackageManager().getPackageInfo(context.getPackageName(), 0).versionCode;
        } catch (Exception e) {
            Log.e("VersionInfo", "Exception", e);
        }
        return i + "";
    }

    public static String getAppVersionName(Context context) {
        try {
            return context.getPackageManager().getPackageInfo(context.getPackageName(), 0).versionName;
        } catch (Exception e) {
            Log.e("VersionInfo", "Exception", e);
            return null;
        }
    }
}
