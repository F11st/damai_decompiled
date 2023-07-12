package com.alimm.xadsdk.base.utils;

import android.text.TextUtils;
import androidx.annotation.NonNull;
import com.alimm.xadsdk.AdSdkManager;
import com.alimm.xadsdk.base.model.AdInfo;
import com.alimm.xadsdk.base.model.BidInfo;
import com.alimm.xadsdk.base.ut.AdUtConstants;
import com.alimm.xadsdk.business.common.model.YouKuPlayerVideoInfo;
import com.alimm.xadsdk.business.common.utils.AdUtils;
import com.alimm.xadsdk.info.GlobalInfoManager;
import java.util.HashMap;
import java.util.Map;

/* compiled from: Taobao */
/* loaded from: classes12.dex */
public class AdUtUtils {
    public static void addCommonInfo(@NonNull Map<String, String> map, BidInfo bidInfo) {
        if (bidInfo != null) {
            map.put("ad_type", String.valueOf(bidInfo.getType()));
            map.put("rs", bidInfo.getCreativeUrl());
            map.put("rst", bidInfo.getCreativeType());
            if (!TextUtils.isEmpty(bidInfo.getVideoId())) {
                map.put("vid", bidInfo.getVideoId());
            }
            map.put(AdUtConstants.XAD_UT_ARG_IE, bidInfo.getCreativeId());
            map.put(AdUtConstants.XAD_UT_ARG_PST, String.valueOf(bidInfo.getSspId()));
            map.put(AdUtConstants.XAD_UT_ARG_IMP_ID, bidInfo.getImpressionId());
            map.put(AdUtConstants.XAD_UT_ARG_AD_INDEX, String.valueOf(bidInfo.getIndex()));
            map.put(AdUtConstants.XAD_UT_ARG_CA, bidInfo.getGroupId());
            if (bidInfo.getTemplateId() != 0) {
                map.put("template_id", String.valueOf(bidInfo.getTemplateId()));
            }
        }
    }

    private static void addCommonRequestInfo(@NonNull Map<String, String> map) {
        map.put("utdid", GlobalInfoManager.getInstance().getUtdid());
        map.put("aid", GlobalInfoManager.getInstance().getAndroidId());
        map.put("imei", GlobalInfoManager.getInstance().getImei());
        map.put("mac", GlobalInfoManager.getInstance().getMacAddress());
        map.put("aaid", GlobalInfoManager.getInstance().getAdvertisingId());
        map.put("dvw", String.valueOf(GlobalInfoManager.getInstance().getScreenWidth()));
        map.put("dvh", String.valueOf(GlobalInfoManager.getInstance().getScreenHeight()));
    }

    private static void addPasterCommonInfo(@NonNull Map<String, String> map, YouKuPlayerVideoInfo youKuPlayerVideoInfo, @NonNull BidInfo bidInfo) {
        if (youKuPlayerVideoInfo != null) {
            map.put("cache", youKuPlayerVideoInfo.isOffline() ? "1" : "0");
            map.put("is_live", youKuPlayerVideoInfo.getStreamType() != 1 ? "0" : "1");
            map.put("vid", youKuPlayerVideoInfo.getVideoId());
        }
        map.put(AdUtConstants.XAD_UT_ARG_STA, String.valueOf(bidInfo.getReleaseStartTime()));
        map.put("end", String.valueOf(bidInfo.getReleaseEndTime()));
    }

    private static Map<String, String> createAndFillExtras(@NonNull BidInfo bidInfo, Map<String, String> map) {
        HashMap hashMap = new HashMap(16);
        Utils.addCommonInfo(hashMap, bidInfo);
        if (map != null) {
            hashMap.putAll(map);
        }
        if (bidInfo.getAllExtend() != null) {
            hashMap.putAll(bidInfo.getAllExtend());
        }
        return hashMap;
    }

    public static void recordAdClick(BidInfo bidInfo, int i, Map<String, String> map) {
        if (bidInfo == null) {
            return;
        }
        AdSdkManager.getInstance().getUserTracker().track(19999, AdUtConstants.XAD_ARG1_CLICK, String.valueOf(i), "", createAndFillExtras(bidInfo, map));
    }

    public static void recordAdClosed(BidInfo bidInfo, int i, Map<String, String> map) {
        if (bidInfo == null) {
            return;
        }
        AdSdkManager.getInstance().getUserTracker().track(19999, AdUtConstants.XAD_ARG1_CLOSE, String.valueOf(i), "", createAndFillExtras(bidInfo, map));
    }

    public static void recordAdError(BidInfo bidInfo, int i, int i2, Map<String, String> map) {
        HashMap hashMap = new HashMap(16);
        hashMap.put("reason", String.valueOf(i2));
        if (bidInfo != null) {
            Utils.addCommonInfo(hashMap, bidInfo);
            if (bidInfo.getAllExtend() != null) {
                hashMap.putAll(bidInfo.getAllExtend());
            }
        }
        if (map != null) {
            hashMap.putAll(map);
        }
        AdSdkManager.getInstance().getUserTracker().track(19999, AdUtConstants.XAD_ARG1_ERROR, String.valueOf(i), "", hashMap);
    }

    public static void recordAdFail(int i, String str, BidInfo bidInfo, Map<String, String> map) {
        HashMap hashMap = new HashMap(16);
        if (bidInfo != null) {
            Utils.addCommonInfo(hashMap, bidInfo);
            if (bidInfo.getAllExtend() != null) {
                hashMap.putAll(bidInfo.getAllExtend());
            }
        }
        if (map != null) {
            hashMap.putAll(map);
        }
        AdSdkManager.getInstance().getUserTracker().track(19999, AdUtConstants.XAD_ARG1_FAIL, String.valueOf(i), str, hashMap);
    }

    public static void recordAdFinish(BidInfo bidInfo, int i, Map<String, String> map) {
        if (bidInfo == null) {
            return;
        }
        AdSdkManager.getInstance().getUserTracker().track(19999, AdUtConstants.XAD_ARG1_FINISH, String.valueOf(i), "", createAndFillExtras(bidInfo, map));
    }

    public static void recordAdLoss(BidInfo bidInfo, int i, String str, Map<String, String> map) {
        if (bidInfo == null) {
            return;
        }
        AdSdkManager.getInstance().getUserTracker().track(19999, "xad_loss", String.valueOf(i), str, createAndFillExtras(bidInfo, map));
    }

    public static void recordAdNode(AdInfo adInfo, int i, Map<String, String> map) {
        if (adInfo == null || adInfo.getDefaultSeatInfo() == null || adInfo.getDefaultSeatInfo().getBidList() == null) {
            return;
        }
        for (BidInfo bidInfo : adInfo.getDefaultSeatInfo().getBidList()) {
            AdSdkManager.getInstance().getUserTracker().track(19999, "xad_node", String.valueOf(i), "", createAndFillExtras(bidInfo, map));
        }
    }

    public static void recordAdRequestEnd(int i, int i2, long j, int i3, Map<String, String> map) {
        HashMap hashMap = new HashMap(16);
        hashMap.put("time", String.valueOf(j));
        hashMap.put(AdUtConstants.XAD_UT_ARG_COUNT, String.valueOf(i3));
        if (map != null) {
            hashMap.putAll(map);
        }
        AdSdkManager.getInstance().getUserTracker().track(19999, AdUtConstants.XAD_ARG1_REQ_END, String.valueOf(i), String.valueOf(i2), hashMap);
    }

    public static void recordAdRequestStart(int i, Map<String, String> map) {
        AdSdkManager.getInstance().getUserTracker().track(19999, AdUtConstants.XAD_ARG1_REQ_START, String.valueOf(i), "", map);
    }

    public static void recordAdStart(BidInfo bidInfo, int i, Map<String, String> map) {
        if (bidInfo == null) {
            return;
        }
        AdSdkManager.getInstance().getUserTracker().track(19999, AdUtConstants.XAD_ARG1_SHOW, String.valueOf(i), "", createAndFillExtras(bidInfo, map));
    }

    public static void recordUpsRequestTime(boolean z, AdInfo adInfo, long j, Map<String, String> map) {
        String str;
        HashMap hashMap = new HashMap(16);
        hashMap.put("is_live", z ? "1" : "0");
        int i = 0;
        if (adInfo != null) {
            i = adInfo.getAdCount();
            str = adInfo.getRequestId();
        } else {
            str = "";
        }
        hashMap.put("cache", "0");
        hashMap.put("reqid", str);
        hashMap.put("time", String.valueOf(j));
        hashMap.put(AdUtConstants.XAD_UT_ARG_COUNT, String.valueOf(i));
        if (map != null) {
            hashMap.putAll(map);
        }
        AdSdkManager.getInstance().getUserTracker().track(19999, AdUtConstants.XAD_ARG1_REQ_END, String.valueOf(7), "200", hashMap);
    }

    public static void sendLossUt(BidInfo bidInfo, int i, String str, Map<String, String> map, String str2) {
        if (bidInfo != null) {
            HashMap hashMap = new HashMap();
            addCommonInfo(hashMap, bidInfo);
            hashMap.put(AdUtConstants.XAD_UT_ARG_LOSS_TYPE, str);
            hashMap.put(AdUtConstants.XAD_UT_ARG_STA, String.valueOf(bidInfo.getReleaseStartTime()));
            hashMap.put("end", String.valueOf(bidInfo.getReleaseEndTime()));
            if (map != null) {
                hashMap.putAll(map);
            }
            if (bidInfo.getAllExtend() != null) {
                hashMap.putAll(bidInfo.getAllExtend());
            }
            AdSdkManager.getInstance().getUserTracker().track(19999, "xad_loss", String.valueOf(i), "", hashMap);
        }
    }

    public static void sendNodeUt(AdInfo adInfo, YouKuPlayerVideoInfo youKuPlayerVideoInfo, int i, Map<String, String> map) {
        if (AdUtils.hasAdInfo(adInfo, i)) {
            for (BidInfo bidInfo : adInfo.getBidInfoList()) {
                HashMap hashMap = new HashMap();
                addCommonInfo(hashMap, bidInfo);
                addPasterCommonInfo(hashMap, youKuPlayerVideoInfo, bidInfo);
                if (map != null) {
                    hashMap.putAll(map);
                }
                if (bidInfo.getAllExtend() != null) {
                    hashMap.putAll(bidInfo.getAllExtend());
                }
                hashMap.put("al", String.valueOf(bidInfo.getDuration()));
                AdSdkManager.getInstance().getUserTracker().track(19999, "xad_node", String.valueOf(i), (String) null, hashMap);
            }
        }
    }

    public static void sendReqUt(int i, Map<String, String> map) {
        addCommonRequestInfo(map);
        recordAdRequestStart(i, map);
    }
}
