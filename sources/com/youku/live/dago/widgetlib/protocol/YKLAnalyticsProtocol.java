package com.youku.live.dago.widgetlib.protocol;

import android.content.Context;
import java.util.Map;

/* compiled from: Taobao */
/* loaded from: classes2.dex */
public interface YKLAnalyticsProtocol {
    void adEndForAntiStealingLink(String str, Map<String, String> map);

    void adStartForAntiStealingLink(String str, Map<String, String> map);

    void bannerClick(Map map);

    void bannerExpose(Map map);

    void click(String str, String str2, Map<String, String> map);

    void customEvent(String str, int i, String str2, String str3, String str4, Map<String, String> map);

    void dmMultiViewClick(String str, Map<String, String> map);

    void dmMultiViewExpose(String str, Map<String, String> map);

    void dolbyClick(Map map);

    void dolbyExpose(Map map);

    void fullAudioClick(Map map);

    void fullAudioExpose(Map map);

    void halfAudioClick(Map map);

    void halfAudioExpose(Map map);

    void liveTrialWatchClick(String str, Map<String, String> map);

    void liveTrialWatchExpose(String str, Map<String, String> map);

    void multiViewClick(String str, Map<String, String> map);

    void multiViewExpose(String str, Map<String, String> map);

    void onEnterLiveRoom(Map map);

    void pageAppear(Context context, Map<String, String> map);

    void pageDisAppear(Context context, Map<String, String> map);

    void pageExposure(String str, Map<String, String> map);

    void pageInit(Context context);

    void playBlock(String str, Map<String, String> map);

    void playEnd(String str, Map<String, String> map);

    void playError(String str, Map<String, String> map);

    void playHeartBeat(String str, Map<String, String> map);

    void playPerformance(String str, Map<String, String> map);

    void playStart(String str, Map<String, String> map);

    void playStartForAntiStealingLink(String str, Map<String, String> map);

    void playSuccessRate(Map map);

    void timeShiftClick(String str, Map<String, String> map);

    void timeShiftExpose(String str, Map<String, String> map);

    void updatePageName(String str);

    void updatePageProperties(Map<String, String> map);
}
