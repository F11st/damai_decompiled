package com.youku.playerservice.axp.modules.history;

import android.content.Context;
import android.text.TextUtils;
import android.util.Log;
import android.util.Pair;
import com.youku.middlewareservice.provider.info.AppInfoProviderProxy;
import com.youku.playerservice.axp.playparams.PlayIdParams;
import com.youku.playerservice.axp.playparams.PlayParams;
import com.youku.playerservice.axp.utils.Logger;
import com.youku.playerservice.axp.utils.PlayerUtil;
import com.youku.playerservice.axp.utils.TLogUtil;
import com.youku.playhistory.PlayHistory;
import com.youku.playhistory.data.PlayHistoryInfo;
import com.youku.vo.LanguageBean;

/* compiled from: Taobao */
/* loaded from: classes3.dex */
public class HistoryDataUtil {
    public static final String PLAYER_HISTORY_REFERENCE_SID = "player_history_reference_sid";
    private static final String TAG = "HistoryDataUtil";

    private static long getCurrentTime() {
        return System.currentTimeMillis();
    }

    public static String getLanguageCodeById(int i) {
        LanguageBean[] languageBeanArr;
        for (LanguageBean languageBean : LanguageBean.ALL_LANGAUGE) {
            if (i == languageBean.id) {
                return languageBean.code;
            }
        }
        return LanguageBean.ALL_LANGAUGE[0].code;
    }

    public static void readHistoryWithUpdate(Context context, PlayParams playParams) {
        if (AppInfoProviderProxy.isDebuggable()) {
            Logger.d(TAG, "onNewRequest readHistory()");
        }
        long currentTime = getCurrentTime();
        PlayIdParams playIdParams = playParams.getPlayIdParams();
        String playId = playParams.getPlayIdParams().getPlayId();
        String string = playParams.getString("player_history_reference_sid");
        if (AppInfoProviderProxy.isDebuggable()) {
            Log.e(TAG, "readHistory: playerHistoryReferenceSid = " + string);
        }
        Pair byVidAndSid = PlayHistory.getByVidAndSid(context, playId, string);
        PlayHistoryInfo playHistoryInfo = (PlayHistoryInfo) byVidAndSid.first;
        PlayHistoryInfo playHistoryInfo2 = (PlayHistoryInfo) byVidAndSid.second;
        if (AppInfoProviderProxy.isDebuggable()) {
            Log.e(TAG, "readHistory: historyInfo = " + playHistoryInfo + ",showIdHistoryInfo = " + playHistoryInfo2);
        }
        long currentTime2 = getCurrentTime() - currentTime;
        if (AppInfoProviderProxy.isDebuggable()) {
            Logger.d(TAG, "readHistory consume:" + currentTime2);
        }
        if (playHistoryInfo == null) {
            if (!TextUtils.isEmpty(playIdParams.getLanguageCode()) || playHistoryInfo2 == null) {
                return;
            }
            if (AppInfoProviderProxy.isDebuggable()) {
                Log.e(TAG, "readHistory: showIdHistoryInfo lang = " + playHistoryInfo2.lang);
            }
            playIdParams.setLanguageCode(getLanguageCodeById(playHistoryInfo2.lang));
            playParams.putString("langChange", "history");
        } else if (!PlayerUtil.isVid(playId) && playIdParams.getVideoStage() > 0 && playIdParams.getVideoStage() != playHistoryInfo.showVideoSeq) {
            if (AppInfoProviderProxy.isDebuggable()) {
                Logger.d(TAG, "电视剧传入与历史记录不同剧集编号，不读历史记录");
            }
        } else {
            if (!TextUtils.equals(playId, playHistoryInfo.videoId)) {
                playIdParams.setPlayId(playHistoryInfo.videoId);
                playParams.putString("vid_src", "playlog");
            }
            playParams.putString("showId", playHistoryInfo.showId);
            if (TextUtils.isEmpty(playIdParams.getLanguageCode())) {
                if (AppInfoProviderProxy.isDebuggable()) {
                    Log.e(TAG, "readHistory: history lang = " + playHistoryInfo.lang);
                }
                String languageCodeById = getLanguageCodeById(playHistoryInfo.lang);
                if (!TextUtils.equals(languageCodeById, playIdParams.getLanguageCode())) {
                    playIdParams.setLanguageCode(languageCodeById);
                    playParams.putString("langChange", "history");
                    String sessionId = playParams.getSessionId();
                    TLogUtil.flowLog(sessionId, "读取历史记录 langCode=" + languageCodeById);
                }
            }
            int i = (int) (playHistoryInfo.point * 1000);
            if (playParams.getStartTime() >= 0 || i <= 10000) {
                return;
            }
            if (AppInfoProviderProxy.isDebuggable()) {
                Logger.d(TAG, playHistoryInfo.title + " playlog is end+ " + playHistoryInfo.isPlayEnd());
            }
            if (playHistoryInfo.isPlayEnd()) {
                return;
            }
            String sessionId2 = playParams.getSessionId();
            TLogUtil.flowLog(sessionId2, "读取历史记录 point=" + i);
            playParams.setStartTime((long) i);
            playParams.getString("startPointHistory", String.valueOf(i));
        }
    }
}
