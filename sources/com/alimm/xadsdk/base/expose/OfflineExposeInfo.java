package com.alimm.xadsdk.base.expose;

import androidx.annotation.NonNull;
import com.alibaba.fastjson.annotation.JSONField;
import com.alimm.xadsdk.base.model.BidInfo;
import com.alimm.xadsdk.base.model.MonitorInfo;
import com.alimm.xadsdk.base.ut.AdUtConstants;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/* compiled from: Taobao */
/* loaded from: classes12.dex */
public class OfflineExposeInfo implements Serializable {
    @JSONField(name = "ad_type")
    public int mAdType;
    @JSONField(name = "data")
    public List<MonitorInfo> mExposureInfoList;
    @JSONField(name = "type")
    public String mExposureType;
    @JSONField(name = "extend")
    public HashMap<String, String> mExtend;

    private OfflineExposeInfo() {
    }

    public static OfflineExposeInfo create(@NonNull BidInfo bidInfo, List<MonitorInfo> list, String str) {
        OfflineExposeInfo offlineExposeInfo = new OfflineExposeInfo();
        offlineExposeInfo.mExposureInfoList = new ArrayList(list);
        offlineExposeInfo.mAdType = bidInfo.getType();
        offlineExposeInfo.mExposureType = str;
        HashMap<String, String> hashMap = new HashMap<>(16);
        offlineExposeInfo.mExtend = hashMap;
        hashMap.put("ad_type", String.valueOf(bidInfo.getType()));
        offlineExposeInfo.mExtend.put(AdUtConstants.XAD_UT_ARG_AD_INDEX, String.valueOf(bidInfo.getIndex()));
        offlineExposeInfo.mExtend.put(AdUtConstants.XAD_UT_ARG_IMP_ID, bidInfo.getImpressionId());
        offlineExposeInfo.mExtend.put(AdUtConstants.XAD_UT_ARG_IE, bidInfo.getCreativeId());
        offlineExposeInfo.mExtend.put("rs", bidInfo.getCreativeUrl());
        offlineExposeInfo.mExtend.put("rst", bidInfo.getCreativeType());
        offlineExposeInfo.mExtend.put(AdUtConstants.XAD_UT_ARG_CA, bidInfo.getGroupId());
        offlineExposeInfo.mExtend.put(AdUtConstants.XAD_UT_ARG_PST, String.valueOf(bidInfo.getSspId()));
        if (bidInfo.getAllExtend() != null) {
            offlineExposeInfo.mExtend.putAll(bidInfo.getAllExtend());
        }
        return offlineExposeInfo;
    }

    public BidInfo convertToAdvItem() {
        BidInfo bidInfo = new BidInfo();
        bidInfo.setType(this.mAdType);
        bidInfo.putExtend(AdUtConstants.XAD_UT_ARG_IS_OFFLINE, "1");
        HashMap<String, String> hashMap = this.mExtend;
        if (hashMap != null) {
            bidInfo.putAllExtend(hashMap);
        }
        return bidInfo;
    }
}
