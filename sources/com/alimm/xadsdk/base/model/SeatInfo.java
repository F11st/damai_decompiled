package com.alimm.xadsdk.base.model;

import com.alibaba.fastjson.annotation.JSONField;
import com.alimm.xadsdk.base.utils.Utils;
import java.util.List;

/* compiled from: Taobao */
/* loaded from: classes10.dex */
public class SeatInfo implements BaseInfo {
    @JSONField(name = "bids")
    private List<BidInfo> mBidList;
    @JSONField(name = "m3u8_all")
    private String mRsAll;
    @JSONField(name = "ad_point")
    private String mType;

    public List<BidInfo> getBidList() {
        return this.mBidList;
    }

    public String getRsAll() {
        return this.mRsAll;
    }

    public int getType() {
        return Utils.toInt(this.mType, 0);
    }

    public SeatInfo setBidList(List<BidInfo> list) {
        this.mBidList = list;
        return this;
    }

    public SeatInfo setRsAll(String str) {
        this.mRsAll = str;
        return this;
    }

    public SeatInfo setType(String str) {
        this.mType = str;
        return this;
    }
}
