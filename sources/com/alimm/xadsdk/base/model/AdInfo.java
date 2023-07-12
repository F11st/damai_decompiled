package com.alimm.xadsdk.base.model;

import com.alibaba.fastjson.annotation.JSONField;
import com.alimm.xadsdk.base.utils.LogUtils;
import com.alimm.xadsdk.request.builder.IRequestConst;
import com.taobao.weex.ui.component.richtext.node.RichTextNode;
import java.util.ArrayList;
import java.util.List;

/* compiled from: Taobao */
/* loaded from: classes10.dex */
public class AdInfo implements BaseInfo {
    private static final String TAG = "AdInfo";
    @JSONField(name = RichTextNode.ATTR)
    private long mAttributeMask;
    @JSONField(serialize = false)
    private SeatInfo mDefaultSeatInfo;
    @JSONField(name = "flowexp")
    private FlowExp mFlowExp;
    @JSONField(name = "reqid")
    private String mRequestId;
    @JSONField(name = "seats")
    private List<SeatInfo> mSeatList;
    @JSONField(name = IRequestConst.VIP_TIPS)
    private String mVipTips;

    public int getAdCount() {
        SeatInfo seatInfo = this.mDefaultSeatInfo;
        if (seatInfo == null || seatInfo.getBidList() == null) {
            return 0;
        }
        return this.mDefaultSeatInfo.getBidList().size();
    }

    public long getAttributeMask() {
        return this.mAttributeMask;
    }

    public List<BidInfo> getBidInfoList() {
        SeatInfo seatInfo = this.mDefaultSeatInfo;
        if (seatInfo != null) {
            return seatInfo.getBidList();
        }
        return null;
    }

    public List<BidInfo> getBidInfoListByType(int i) {
        SeatInfo seatInfoByType = getSeatInfoByType(i);
        if (seatInfoByType != null) {
            return seatInfoByType.getBidList();
        }
        return null;
    }

    public SeatInfo getDefaultSeatInfo() {
        return this.mDefaultSeatInfo;
    }

    public FlowExp getFlowExp() {
        return this.mFlowExp;
    }

    public String getRequestId() {
        return this.mRequestId;
    }

    public SeatInfo getSeatInfoByType(int i) {
        List<SeatInfo> list = this.mSeatList;
        if (list != null) {
            for (SeatInfo seatInfo : list) {
                if (seatInfo.getType() == i) {
                    return seatInfo;
                }
            }
            return null;
        }
        return null;
    }

    public List<SeatInfo> getSeatList() {
        return this.mSeatList;
    }

    public AdInfo getSplitAdInfo(int i) {
        AdInfo adInfo = new AdInfo();
        adInfo.setRequestId(this.mRequestId);
        adInfo.setFlowExp(this.mFlowExp);
        adInfo.setVipTips(this.mVipTips);
        adInfo.setAttributeMask(this.mAttributeMask);
        ArrayList arrayList = new ArrayList();
        List<SeatInfo> list = this.mSeatList;
        if (list != null && !list.isEmpty()) {
            for (SeatInfo seatInfo : this.mSeatList) {
                if (seatInfo.getType() == i) {
                    arrayList.add(seatInfo);
                }
            }
        }
        adInfo.setSeatList(arrayList);
        if (LogUtils.DEBUG) {
            LogUtils.d(TAG, "getSplitAdInfo: adType = " + i + ", adInfo = " + adInfo);
        }
        return adInfo;
    }

    public int getType() {
        SeatInfo seatInfo = this.mDefaultSeatInfo;
        if (seatInfo != null) {
            return seatInfo.getType();
        }
        return 0;
    }

    public String getVipTips() {
        return this.mVipTips;
    }

    public void setAttributeMask(long j) {
        this.mAttributeMask = j;
    }

    public AdInfo setFlowExp(FlowExp flowExp) {
        this.mFlowExp = flowExp;
        return this;
    }

    public AdInfo setRequestId(String str) {
        this.mRequestId = str;
        return this;
    }

    public AdInfo setSeatList(List<SeatInfo> list) {
        this.mSeatList = list;
        if (list != null && !list.isEmpty()) {
            this.mDefaultSeatInfo = list.get(0);
        }
        return this;
    }

    public AdInfo setVipTips(String str) {
        this.mVipTips = str;
        return this;
    }
}
