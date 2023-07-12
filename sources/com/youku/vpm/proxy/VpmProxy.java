package com.youku.vpm.proxy;

import com.alimm.xadsdk.base.expose.MonitorType;
import com.youku.vpm.utils.LogUtil;
import com.youku.vpm.utils.Logger;
import java.util.LinkedHashSet;
import java.util.Map;

/* compiled from: Taobao */
/* loaded from: classes3.dex */
public class VpmProxy {
    private static Boolean isRegistBeforePlayError;
    private static Boolean isRegistHeartBeat;
    private static Boolean isRegistImpairment;
    private static Boolean isRegistOneChange;
    private static Boolean isRegistOneEvent;
    private static Boolean isRegistOnePlay;
    private static Boolean isRegistPlayingError;
    private static Boolean isRegistedOnePlayExtras;
    private static Boolean isRegisterAbnormalDetect;
    private static Boolean isRegisterAdError;
    private static Boolean isRegisterAdImpairment;
    private static Boolean isRegisterAdPlay;
    private static Boolean isRegisterControlStartClarity;
    private static Boolean isRegisterDitherMonitor;
    private static Boolean isRegisterNewSeek;
    private static Boolean isRegisterPlayAbnormalDetail;
    private static Boolean isRegisterPlayAbnormalSummary;
    private static Boolean isRegisterPlayAlarmError;
    private static Boolean isRegisterStartLoading;
    private static Boolean isRegisterSubtitleEvent;
    private static Boolean isRegisterViewMonitor;

    static {
        Boolean bool = Boolean.FALSE;
        isRegistBeforePlayError = bool;
        isRegistPlayingError = bool;
        isRegistImpairment = bool;
        isRegistOnePlay = bool;
        isRegistOneChange = bool;
        isRegistHeartBeat = bool;
        isRegistOneEvent = bool;
        isRegisterAbnormalDetect = bool;
        isRegisterAdPlay = bool;
        isRegisterAdError = bool;
        isRegisterAdImpairment = bool;
        isRegisterPlayAlarmError = bool;
        isRegisterDitherMonitor = bool;
        isRegisterViewMonitor = bool;
        isRegisterStartLoading = bool;
        isRegisterSubtitleEvent = bool;
        isRegisterControlStartClarity = bool;
        isRegisterPlayAbnormalDetail = bool;
        isRegisterPlayAbnormalSummary = bool;
        isRegisterNewSeek = bool;
        isRegistedOnePlayExtras = bool;
    }

    public static void commitAbnormalDetectStatistics(Map<String, String> map, Map<String, Double> map2) {
        if (VpmCommit.commitStatistics("abnormalDetect", isRegisterAbnormalDetect.booleanValue(), map, map2)) {
            isRegisterAbnormalDetect = Boolean.TRUE;
        }
    }

    public static void commitAdErrorStatistics(Map<String, String> map, Map<String, Double> map2) {
        if (VpmCommit.commitStatistics("adError", isRegisterAdError.booleanValue(), map, map2)) {
            isRegisterAdError = Boolean.TRUE;
        }
    }

    public static void commitAdImpairmentStatistics(Map<String, String> map, Map<String, Double> map2) {
        if (VpmCommit.commitStatistics("adImpairment", isRegisterAdImpairment.booleanValue(), map, map2)) {
            isRegisterAdImpairment = Boolean.TRUE;
        }
    }

    public static void commitAdPlayStatistics(Map<String, String> map, Map<String, Double> map2) {
        if (VpmCommit.commitStatistics("adPlay", isRegisterAdPlay.booleanValue(), map, map2)) {
            isRegisterAdPlay = Boolean.TRUE;
        }
    }

    public static void commitControlStartClarityStatistics(Map<String, String> map, Map<String, Double> map2) {
        if (VpmCommit.commitStatistics("controlStartClarity", isRegisterControlStartClarity.booleanValue(), map, map2)) {
            isRegisterSubtitleEvent = Boolean.TRUE;
        }
    }

    public static void commitDitherMonitorStatistics(Map<String, String> map, Map<String, Double> map2) {
        if (VpmCommit.commitStatistics("ditherMonitor", isRegisterDitherMonitor.booleanValue(), map, map2)) {
            isRegisterDitherMonitor = Boolean.TRUE;
        }
    }

    public static void commitHeartBeatStatistics(Map<String, String> map, Map<String, Double> map2) {
        if (VpmCommit.commitStatistics("playHeartbeat", isRegistHeartBeat.booleanValue(), map, map2)) {
            isRegistHeartBeat = Boolean.TRUE;
        }
    }

    public static void commitImpairmentStatistic(Map<String, String> map, Map<String, Double> map2) {
        if (VpmCommit.commitStatistics("impairment", isRegistImpairment.booleanValue(), map, map2)) {
            isRegistImpairment = Boolean.TRUE;
        }
    }

    public static void commitNewSeek(Map<String, String> map, Map<String, Double> map2) {
        if (VpmCommit.commitStatistics("seek", isRegisterNewSeek.booleanValue(), map, map2)) {
            isRegisterNewSeek = Boolean.TRUE;
        }
    }

    public static void commitOneChangeStatistics(Map<String, String> map, Map<String, Double> map2) {
        if (VpmCommit.commitStatistics("oneChange", isRegistOneChange.booleanValue(), map, map2)) {
            isRegistOneChange = Boolean.TRUE;
        }
    }

    public static void commitOneEventStatistics(Map<String, String> map, Map<String, Double> map2) {
        if (VpmCommit.commitStatistics("oneEvent", isRegistOneEvent.booleanValue(), map, map2)) {
            isRegistOneEvent = Boolean.TRUE;
        }
    }

    public static void commitOnePlayExtras(Map<String, String> map, Map<String, Double> map2) {
        if (VpmCommit.commitStatistics("onePlayExtras", isRegistedOnePlayExtras.booleanValue(), map, map2)) {
            isRegistedOnePlayExtras = Boolean.TRUE;
        }
    }

    public static void commitOnePlayStatistics(Map<String, String> map, Map<String, Double> map2) {
        if (VpmCommit.commitStatistics("onePlay", isRegistOnePlay.booleanValue(), map, map2)) {
            isRegistOnePlay = Boolean.TRUE;
        }
    }

    public static void commitPlayAbnormalDetail(Map<String, String> map, Map<String, Double> map2) {
        if (VpmCommit.commitStatistics("playAbnormalDetail", isRegisterPlayAbnormalDetail.booleanValue(), map, map2)) {
            isRegisterPlayAbnormalDetail = Boolean.TRUE;
        }
    }

    public static void commitPlayAbnormalSummary(Map<String, String> map, Map<String, Double> map2) {
        if (VpmCommit.commitStatistics("playAbnormalSummary", isRegisterPlayAbnormalSummary.booleanValue(), map, map2)) {
            isRegisterPlayAbnormalSummary = Boolean.TRUE;
        }
    }

    public static void commitPlayAlarmErrorStatistics(Map<String, String> map, Map<String, Double> map2) {
        if (VpmCommit.commitStatistics("playAlarmError", isRegisterPlayAlarmError.booleanValue(), map, map2)) {
            isRegisterPlayAlarmError = Boolean.TRUE;
        }
    }

    public static void commitPlayErrInfoStatistics(Map<String, String> map, Map<String, Double> map2, Boolean bool) {
        if (map == null || bool == null || map2 == null) {
            Logger.d("VPM", "VideoPlayErrInfo is null");
            return;
        }
        String str = bool.booleanValue() ? MonitorType.PLAYING : "beforePlay";
        if ((bool.booleanValue() && !isRegistPlayingError.booleanValue()) || (!bool.booleanValue() && !isRegistBeforePlayError.booleanValue())) {
            LinkedHashSet linkedHashSet = new LinkedHashSet();
            if (map.size() > 0) {
                linkedHashSet.addAll(map.keySet());
            }
            LinkedHashSet linkedHashSet2 = new LinkedHashSet();
            if (map2.size() > 0) {
                linkedHashSet2.addAll(map2.keySet());
            }
            long currentTimeMillis = System.currentTimeMillis();
            UtProxy.getInstance().register("vpm", str, linkedHashSet2, linkedHashSet);
            LogUtil.d("VPM", "register " + str + " cost:" + (System.currentTimeMillis() - currentTimeMillis));
            if (bool.booleanValue()) {
                isRegistPlayingError = Boolean.TRUE;
            } else {
                isRegistBeforePlayError = Boolean.TRUE;
            }
        }
        UtProxy.getInstance().commit("vpm", str, map, map2);
    }

    public static void commitStartLoadingStatistics(Map<String, String> map, Map<String, Double> map2) {
        if (VpmCommit.commitStatistics("startLoading", isRegisterStartLoading.booleanValue(), map, map2)) {
            isRegisterStartLoading = Boolean.TRUE;
        }
    }

    public static void commitSubtitleEventStatistics(Map<String, String> map, Map<String, Double> map2) {
        if (VpmCommit.commitStatistics("subtitleEvent", isRegisterSubtitleEvent.booleanValue(), map, map2)) {
            isRegisterSubtitleEvent = Boolean.TRUE;
        }
    }

    public static void commitViewMonitorStatistics(Map<String, String> map, Map<String, Double> map2) {
        if (VpmCommit.commitStatistics("viewMonitor", isRegisterViewMonitor.booleanValue(), map, map2)) {
            isRegisterViewMonitor = Boolean.TRUE;
        }
    }
}
