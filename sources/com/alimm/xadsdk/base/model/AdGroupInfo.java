package com.alimm.xadsdk.base.model;

import com.alibaba.fastjson.annotation.JSONField;
import com.alimm.xadsdk.base.expose.RetryMonitorDbHelper;

/* compiled from: Taobao */
/* loaded from: classes10.dex */
public class AdGroupInfo implements BaseInfo {
    @JSONField(name = "is_cacheable")
    private boolean mCacheable;
    @JSONField(name = RetryMonitorDbHelper.COLUMN_CREATIVE_ID)
    private String mCreativeId;
    @JSONField(name = "dsp_name")
    private String mDspName;
    @JSONField(name = "adgroup_id")
    private String mGroupId;
    @JSONField(name = "is_marketing")
    private boolean mIsMarketing;
    @JSONField(name = "is_serialized")
    private boolean mIsSerialized;
    @JSONField(name = "ssp_pid")
    private String mSspId;

    public String getCreativeId() {
        return this.mCreativeId;
    }

    public String getDspName() {
        return this.mDspName;
    }

    public String getGroupId() {
        return this.mGroupId;
    }

    public String getSspId() {
        return this.mSspId;
    }

    public boolean isCacheable() {
        return this.mCacheable;
    }

    public boolean isMarketing() {
        return this.mIsMarketing;
    }

    public boolean isSerialized() {
        return this.mIsSerialized;
    }

    public AdGroupInfo setCacheable(boolean z) {
        this.mCacheable = z;
        return this;
    }

    public AdGroupInfo setCreativeId(String str) {
        this.mCreativeId = str;
        return this;
    }

    public AdGroupInfo setDspName(String str) {
        this.mDspName = str;
        return this;
    }

    public AdGroupInfo setGroupId(String str) {
        this.mGroupId = str;
        return this;
    }

    public AdGroupInfo setMarketing(boolean z) {
        this.mIsMarketing = z;
        return this;
    }

    public AdGroupInfo setSerialized(boolean z) {
        this.mIsSerialized = z;
        return this;
    }

    public AdGroupInfo setSspId(String str) {
        this.mSspId = str;
        return this;
    }

    public String toString() {
        return "AdGroup{creative_id =" + this.mCreativeId + ", adgroup_id = " + this.mGroupId + ", isMarketing = " + this.mIsMarketing + ", dspName = " + this.mDspName + "}";
    }
}
