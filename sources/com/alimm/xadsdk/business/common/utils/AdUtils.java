package com.alimm.xadsdk.business.common.utils;

import android.os.SystemClock;
import android.text.TextUtils;
import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONException;
import com.alimm.xadsdk.base.model.AdInfo;
import com.alimm.xadsdk.base.model.BidInfo;
import com.alimm.xadsdk.base.ut.AdUtConstants;
import com.alimm.xadsdk.base.utils.AdUtUtils;
import com.alimm.xadsdk.base.utils.LogUtils;
import com.alimm.xadsdk.request.AdRequestManager;
import com.alimm.xadsdk.request.builder.IRequestConst;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/* compiled from: Taobao */
/* loaded from: classes12.dex */
public class AdUtils {
    private static final String TAG = "AdUtils";
    private static int sAdPausedPosition;
    private static long sPreReqStartTime;

    public static int getAdPausedPosition() {
        return sAdPausedPosition;
    }

    public static Map<String, String> getAdRequestParams(int i, boolean z) {
        if (LogUtils.DEBUG) {
            LogUtils.d(TAG, "getAdRequestParameter: adType = " + i);
        }
        if (i == 7) {
            sPreReqStartTime = SystemClock.elapsedRealtime();
            HashMap hashMap = new HashMap(16);
            hashMap.put(AdUtConstants.XAD_UT_ARG_IS_OFFLINE, "0");
            AdUtUtils.sendReqUt(7, hashMap);
            HashMap hashMap2 = new HashMap(32);
            AdRequestManager.getInstance().getUpsAdQueryParams(hashMap2);
            if (z) {
                hashMap2.put(IRequestConst.NEED_BF, "0");
            }
            return hashMap2;
        }
        return null;
    }

    public static boolean hasAdInfo(AdInfo adInfo, int i) {
        return (adInfo == null || adInfo.getBidInfoListByType(i) == null || adInfo.getBidInfoListByType(i).isEmpty()) ? false : true;
    }

    public static boolean hasAdvInfo(AdInfo adInfo) {
        return (adInfo == null || adInfo.getBidInfoList() == null || adInfo.getBidInfoList().isEmpty()) ? false : true;
    }

    public static AdInfo parseAd(String str, boolean z, int i, Map<String, String> map) {
        if (LogUtils.DEBUG) {
            LogUtils.d(TAG, "parseAd: isLive = " + z);
        }
        AdInfo parsePasterAd = parsePasterAd(str, false, z);
        AdUtUtils.recordUpsRequestTime(z, parsePasterAd, SystemClock.elapsedRealtime() - sPreReqStartTime, map);
        if (parsePasterAd != null) {
            HashMap hashMap = new HashMap(16);
            hashMap.put("is_live", z ? "1" : "0");
            hashMap.put("cache", "0");
            AdUtUtils.sendNodeUt(parsePasterAd, null, 7, hashMap);
        }
        return parsePasterAd;
    }

    public static AdInfo parsePasterAd(String str, boolean z, boolean z2) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        try {
            AdInfo adInfo = (AdInfo) JSON.parseObject(str, AdInfo.class);
            if (hasAdInfo(adInfo, 7)) {
                List<BidInfo> bidInfoListByType = adInfo.getBidInfoListByType(7);
                for (int size = bidInfoListByType.size() - 1; size >= 0; size--) {
                    BidInfo bidInfo = bidInfoListByType.get(size);
                    bidInfo.setType(adInfo.getType());
                    bidInfo.setIndex(size);
                    bidInfo.putExtend("reqid", adInfo.getRequestId());
                    String str2 = "1";
                    bidInfo.putExtend("cache", z ? "1" : "0");
                    if (!z2) {
                        str2 = "0";
                    }
                    bidInfo.putExtend("is_live", str2);
                    if (TextUtils.isEmpty(bidInfo.getCreativeUrl())) {
                        bidInfoListByType.remove(size);
                        AdUtUtils.sendLossUt(bidInfo, bidInfo.getType(), "12", null, "");
                    }
                }
            }
            return adInfo;
        } catch (JSONException e) {
            LogUtils.e(TAG, "parseAd failed.", e);
            return null;
        }
    }
}
