package com.youku.alixplayer.opensdk.statistics.proxy;

import com.alibaba.mtl.appmonitor.AppMonitor;
import com.alimm.xadsdk.base.expose.MonitorType;
import com.youku.alixplayer.opensdk.utils.Logger;
import java.util.HashMap;
import java.util.LinkedHashSet;
import java.util.Map;

/* compiled from: Taobao */
/* loaded from: classes5.dex */
public class VpmProxy {
    private static Boolean isRegistBeforePlayError;
    private static Boolean isRegistHeartBeat;
    private static Boolean isRegistImpairmentError;
    private static Boolean isRegistOneChange;
    private static Boolean isRegistOneEvent;
    private static Boolean isRegistOnePlayError;
    private static Boolean isRegistPlayingError;
    private static Boolean isRegisterAbnormalDetect;
    private static Boolean isRegisterAdError;
    private static Boolean isRegisterAdImpairment;
    private static Boolean isRegisterAdPlay;
    private static Boolean isRegisterControlStartClarity;
    private static Boolean isRegisterDitherMonitor;
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
        isRegistImpairmentError = bool;
        isRegistOnePlayError = bool;
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
    }

    public static void alarmCommitFail(String str, String str2, String str3, String str4) {
        if (UtProxy.isIsUseAppMonitor()) {
            AppMonitor.Alarm.commitFail(str, str2, str3, str4);
            return;
        }
        HashMap hashMap = new HashMap();
        hashMap.put("error_code", str3);
        hashMap.put("error_msg", str4);
        UtProxy.getInstance().commit(str, str2, hashMap, new HashMap());
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
        if (map != null && map2 != null) {
            if (!isRegistHeartBeat.booleanValue()) {
                LinkedHashSet linkedHashSet = new LinkedHashSet();
                if (map.size() > 0) {
                    linkedHashSet.addAll(map.keySet());
                }
                LinkedHashSet linkedHashSet2 = new LinkedHashSet();
                if (map2.size() > 0) {
                    linkedHashSet2.addAll(map2.keySet());
                }
                UtProxy.getInstance().register("vpm", "playHeartbeat", linkedHashSet2, linkedHashSet);
                isRegistHeartBeat = Boolean.TRUE;
            }
            UtProxy.getInstance().commit("vpm", "playHeartbeat", map, map2);
            return;
        }
        Logger.d("VPM", "commitHeartBeatStatistics --> param is null.");
    }

    public static void commitImpairmentStatistic(Map<String, String> map, Map<String, Double> map2) {
        if (map != null && map2 != null) {
            if (!isRegistImpairmentError.booleanValue()) {
                LinkedHashSet linkedHashSet = new LinkedHashSet();
                if (map.size() > 0) {
                    linkedHashSet.addAll(map.keySet());
                }
                LinkedHashSet linkedHashSet2 = new LinkedHashSet();
                if (map2.size() > 0) {
                    linkedHashSet2.addAll(map2.keySet());
                }
                long currentTimeMillis = System.currentTimeMillis();
                UtProxy.getInstance().register("vpm", "impairment", linkedHashSet2, linkedHashSet);
                Logger.d("VPM", "register impairment cost:" + (System.currentTimeMillis() - currentTimeMillis));
                isRegistImpairmentError = Boolean.TRUE;
            }
            UtProxy.getInstance().commit("vpm", "impairment", map, map2);
            return;
        }
        Logger.d("VPM", "commitImpairmentStatistic --> param is null.");
    }

    public static void commitOneChangeStatistics(Map<String, String> map, Map<String, Double> map2) {
        if (map != null && map2 != null) {
            if (!isRegistOneChange.booleanValue()) {
                LinkedHashSet linkedHashSet = new LinkedHashSet();
                if (map.size() > 0) {
                    linkedHashSet.addAll(map.keySet());
                }
                LinkedHashSet linkedHashSet2 = new LinkedHashSet();
                if (map2.size() > 0) {
                    linkedHashSet2.addAll(map2.keySet());
                }
                UtProxy.getInstance().register("vpm", "oneChange", linkedHashSet2, linkedHashSet);
                isRegistOneChange = Boolean.TRUE;
            }
            UtProxy.getInstance().commit("vpm", "oneChange", map, map2);
            return;
        }
        Logger.d("VPM", "commitOneChangeStatistics --> param is null.");
    }

    public static void commitOneEventStatistics(Map<String, String> map, Map<String, Double> map2) {
        if (map != null && map2 != null) {
            if (!isRegistOneEvent.booleanValue()) {
                LinkedHashSet linkedHashSet = new LinkedHashSet();
                if (map.size() > 0) {
                    linkedHashSet.addAll(map.keySet());
                }
                LinkedHashSet linkedHashSet2 = new LinkedHashSet();
                if (map2.size() > 0) {
                    linkedHashSet2.addAll(map2.keySet());
                }
                UtProxy.getInstance().register("vpm", "oneEvent", linkedHashSet2, linkedHashSet);
                isRegistOneEvent = Boolean.TRUE;
            }
            UtProxy.getInstance().commit("vpm", "oneEvent", map, map2);
            return;
        }
        Logger.d("VPM", "commitOneEventStatistics --> param is null.");
    }

    public static void commitOnePlayStatistics(Map<String, String> map, Map<String, Double> map2) {
        if (map != null && map2 != null) {
            if (!isRegistOnePlayError.booleanValue()) {
                LinkedHashSet linkedHashSet = new LinkedHashSet();
                if (map.size() > 0) {
                    linkedHashSet.addAll(map.keySet());
                }
                LinkedHashSet linkedHashSet2 = new LinkedHashSet();
                if (map2.size() > 0) {
                    linkedHashSet2.addAll(map2.keySet());
                }
                long currentTimeMillis = System.currentTimeMillis();
                UtProxy.getInstance().register("vpm", "onePlay", linkedHashSet2, linkedHashSet);
                Logger.d("VPM", "register onePlay cost:" + (System.currentTimeMillis() - currentTimeMillis));
                isRegistOnePlayError = Boolean.TRUE;
            }
            UtProxy.getInstance().commit("vpm", "onePlay", map, map2);
            return;
        }
        Logger.d("VPM", "commitOnePlayStatistics --> param is null.");
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
        if (map != null && bool != null && map2 != null) {
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
                Logger.d("VPM", "register " + str + " cost:" + (System.currentTimeMillis() - currentTimeMillis));
                if (bool.booleanValue()) {
                    isRegistPlayingError = Boolean.TRUE;
                } else {
                    isRegistBeforePlayError = Boolean.TRUE;
                }
            }
            UtProxy.getInstance().commit("vpm", str, map, map2);
            return;
        }
        Logger.d("VPM", "VideoPlayErrInfo is null");
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

    public static boolean statCheckSampled(String str, String str2) {
        if (UtProxy.isIsUseAppMonitor()) {
            return AppMonitor.Stat.checkSampled(str, str2);
        }
        return true;
    }
}
