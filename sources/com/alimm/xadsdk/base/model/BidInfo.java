package com.alimm.xadsdk.base.model;

import android.text.TextUtils;
import com.alibaba.fastjson.annotation.JSONField;
import com.alimm.xadsdk.base.ut.AdUtConstants;
import com.alimm.xadsdk.base.utils.LogUtils;
import com.youku.arch.v3.data.Constants;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import tb.jn1;

/* compiled from: Taobao */
/* loaded from: classes10.dex */
public class BidInfo implements BaseInfo {
    private static final String TAG = "BidInfo";
    @JSONField(serialize = false)
    private AdItem mAdItem;
    @JSONField(serialize = false)
    private String mCreativePath;
    @JSONField(serialize = false)
    private String mCreativeType;
    @JSONField(name = "ad0")
    private AdItem mDefaultAd;
    @JSONField(name = "interact0")
    private InteractionInfo mDefaultInteractionInfo;
    @JSONField(name = "extension")
    private Map<String, String> mExtension;
    @JSONField(name = "adgroup")
    private AdGroupInfo mGroupInfo;
    @JSONField(name = AdUtConstants.XAD_UT_ARG_IMP_ID)
    private String mImpressionId;
    @JSONField(serialize = false)
    private int mIndex;
    @JSONField(serialize = false)
    private Map<String, String> mInfoExtend;
    @JSONField(serialize = false)
    private InteractionInfo mInteractionInfo;
    @JSONField(name = "end")
    private long mReleaseEndTime;
    @JSONField(name = "start")
    private long mReleaseStartTime;
    @JSONField(name = "scene")
    private SceneInfo mSceneInfo;
    @JSONField(name = "ad1")
    private AdItem mSecondaryAd;
    @JSONField(name = "interact1")
    private InteractionInfo mSecondaryInteractionInfo;
    @JSONField(name = Constants.TEMPLATE)
    private TemplateInfo mTemplateInfo;
    @JSONField(serialize = false)
    private int mType;

    public AdItem getAdItem() {
        return this.mAdItem;
    }

    public Map<String, String> getAllExtend() {
        return this.mInfoExtend;
    }

    public Map<String, List<MonitorInfo>> getAllMonitorInfo() {
        AdItem adItem = this.mAdItem;
        if (adItem != null) {
            return adItem.getMonitorInfo();
        }
        return null;
    }

    public int getCreativeHeight() {
        AdItem adItem = this.mAdItem;
        if (adItem == null || adItem.getCreativeInfo() == null) {
            return 0;
        }
        return this.mAdItem.getCreativeInfo().getCreativeHeight();
    }

    public String getCreativeId() {
        AdGroupInfo adGroupInfo = this.mGroupInfo;
        return adGroupInfo != null ? adGroupInfo.getCreativeId() : "";
    }

    public AdCreativeInfo getCreativeInfo() {
        AdItem adItem = this.mAdItem;
        if (adItem != null) {
            return adItem.getCreativeInfo();
        }
        return null;
    }

    public String getCreativeMd5() {
        AdItem adItem = this.mAdItem;
        return (adItem == null || adItem.getCreativeInfo() == null) ? "" : this.mAdItem.getCreativeInfo().getCreativeMd5();
    }

    public String getCreativeName() {
        AdItem adItem = this.mAdItem;
        return (adItem == null || adItem.getCreativeInfo() == null) ? "" : this.mAdItem.getCreativeInfo().getName();
    }

    public String getCreativePath() {
        return this.mCreativePath;
    }

    public String getCreativeType() {
        if (TextUtils.isEmpty(this.mCreativeType)) {
            AdItem adItem = this.mAdItem;
            if (adItem == null || adItem.getCreativeInfo() == null) {
                return "";
            }
            String creativeType = this.mAdItem.getCreativeInfo().getCreativeType();
            this.mCreativeType = creativeType;
            return creativeType;
        }
        return this.mCreativeType;
    }

    public String getCreativeUrl() {
        AdItem adItem = this.mAdItem;
        return (adItem == null || adItem.getCreativeInfo() == null) ? "" : this.mAdItem.getCreativeInfo().getUrl();
    }

    public int getCreativeWidth() {
        AdItem adItem = this.mAdItem;
        if (adItem == null || adItem.getCreativeInfo() == null) {
            return 0;
        }
        return this.mAdItem.getCreativeInfo().getCreativeWidth();
    }

    public AdItem getDefaultAd() {
        return this.mDefaultAd;
    }

    public InteractionInfo getDefaultInteractionInfo() {
        return this.mDefaultInteractionInfo;
    }

    public String getDspName() {
        AdGroupInfo adGroupInfo = this.mGroupInfo;
        return adGroupInfo != null ? adGroupInfo.getDspName() : "";
    }

    public int getDuration() {
        AdItem adItem = this.mAdItem;
        if (adItem == null || adItem.getCreativeInfo() == null) {
            return 0;
        }
        return this.mAdItem.getCreativeInfo().getDuration();
    }

    public String getExtend(String str) {
        if (this.mInfoExtend == null || TextUtils.isEmpty(str)) {
            return null;
        }
        return this.mInfoExtend.get(str);
    }

    public Map<String, String> getExtension() {
        return this.mExtension;
    }

    public String getExtensionByKey(String str) {
        Map<String, String> map = this.mExtension;
        if (map == null || map.isEmpty() || TextUtils.isEmpty(str)) {
            return null;
        }
        return this.mExtension.get(str);
    }

    public String getGroupId() {
        AdGroupInfo adGroupInfo = this.mGroupInfo;
        return adGroupInfo != null ? adGroupInfo.getGroupId() : "";
    }

    public AdGroupInfo getGroupInfo() {
        return this.mGroupInfo;
    }

    public String getImpressionId() {
        return this.mImpressionId;
    }

    public int getIndex() {
        return this.mIndex;
    }

    public Map<String, String> getInfoExtend() {
        return this.mInfoExtend;
    }

    public InteractionInfo getInteractionInfo() {
        return this.mInteractionInfo;
    }

    public List<LandingInfo> getLandingInfo() {
        AdItem adItem = this.mAdItem;
        if (adItem != null) {
            return adItem.getDefaultLandingInfo();
        }
        return null;
    }

    public String getLandingInfoString() {
        List<LandingInfo> landingInfo = getLandingInfo();
        if (landingInfo == null || landingInfo.isEmpty()) {
            return "";
        }
        StringBuilder sb = new StringBuilder(jn1.ARRAY_START_STR);
        for (LandingInfo landingInfo2 : landingInfo) {
            sb.append("type:");
            sb.append(landingInfo2.getType());
            sb.append("&url:");
            sb.append(landingInfo2.getUrl());
            sb.append(" ");
        }
        sb.append(jn1.ARRAY_END_STR);
        return sb.toString();
    }

    public List<MonitorInfo> getMonitorList(String str) {
        if (this.mAdItem == null || TextUtils.isEmpty(str) || this.mAdItem.getMonitorInfo() == null) {
            return null;
        }
        return this.mAdItem.getMonitorInfo().get(str);
    }

    public long getReleaseEndTime() {
        return this.mReleaseEndTime;
    }

    public long getReleaseStartTime() {
        return this.mReleaseStartTime;
    }

    public SceneInfo getSceneInfo() {
        return this.mSceneInfo;
    }

    public AdItem getSecondaryAd() {
        return this.mSecondaryAd;
    }

    public BidInfo getSecondaryBidInfo() {
        if (this.mSecondaryAd != null) {
            BidInfo bidInfo = new BidInfo();
            bidInfo.setType(this.mType);
            bidInfo.setIndex(this.mIndex);
            bidInfo.setImpressionId(this.mImpressionId);
            bidInfo.setGroupInfo(this.mGroupInfo);
            bidInfo.setTemplateInfo(this.mTemplateInfo);
            bidInfo.setReleaseStartTime(this.mReleaseStartTime);
            bidInfo.setReleaseEndTime(this.mReleaseEndTime);
            bidInfo.setSceneInfo(this.mSceneInfo);
            bidInfo.setDefaultAd(this.mSecondaryAd);
            bidInfo.setDefaultInteractionInfo(this.mSecondaryInteractionInfo);
            Map<String, String> map = this.mInfoExtend;
            if (map != null) {
                bidInfo.putAllExtend(map);
            }
            if (LogUtils.DEBUG) {
                LogUtils.d(TAG, "getSecondaryBidInfo: bidInfo = " + bidInfo);
            }
            return bidInfo;
        }
        return null;
    }

    public InteractionInfo getSecondaryInteractionInfo() {
        return this.mSecondaryInteractionInfo;
    }

    public String getSspId() {
        AdGroupInfo adGroupInfo = this.mGroupInfo;
        return adGroupInfo != null ? adGroupInfo.getSspId() : "";
    }

    public int getTemplateId() {
        TemplateInfo templateInfo = this.mTemplateInfo;
        if (templateInfo != null) {
            return templateInfo.getTemplateId();
        }
        return 0;
    }

    public TemplateInfo getTemplateInfo() {
        return this.mTemplateInfo;
    }

    public int getType() {
        return this.mType;
    }

    public String getVideoId() {
        AdItem adItem = this.mAdItem;
        return (adItem == null || adItem.getCreativeInfo() == null || this.mAdItem.getCreativeInfo().getVideoCreativeInfo() == null) ? "" : this.mAdItem.getCreativeInfo().getVideoCreativeInfo().getVideoId();
    }

    public boolean isCacheable() {
        AdGroupInfo adGroupInfo = this.mGroupInfo;
        if (adGroupInfo != null) {
            return adGroupInfo.isCacheable();
        }
        return false;
    }

    public boolean isMarketing() {
        AdGroupInfo adGroupInfo = this.mGroupInfo;
        if (adGroupInfo != null) {
            return adGroupInfo.isMarketing();
        }
        return false;
    }

    public boolean isSerialized() {
        AdGroupInfo adGroupInfo = this.mGroupInfo;
        if (adGroupInfo != null) {
            return adGroupInfo.isSerialized();
        }
        return false;
    }

    public boolean needShowCloseButton() {
        AdItem adItem = this.mAdItem;
        return (adItem == null || adItem.getCreativeInfo() == null || !TextUtils.equals(this.mAdItem.getCreativeInfo().getCloseSwitch(), "1")) ? false : true;
    }

    public void putAllExtend(Map<String, String> map) {
        if (map != null) {
            if (this.mInfoExtend == null) {
                this.mInfoExtend = new ConcurrentHashMap(16);
            }
            this.mInfoExtend.putAll(map);
        }
    }

    public void putExtend(String str, String str2) {
        if (this.mInfoExtend == null) {
            this.mInfoExtend = new ConcurrentHashMap(16);
        }
        if (TextUtils.isEmpty(str) || str2 == null) {
            return;
        }
        this.mInfoExtend.put(str, str2);
    }

    public BidInfo setAdItem(AdItem adItem) {
        this.mAdItem = adItem;
        return this;
    }

    public BidInfo setCreativePath(String str) {
        if (LogUtils.DEBUG) {
            LogUtils.d(TAG, "setCreativePath: creativePath = " + str);
        }
        this.mCreativePath = str;
        return this;
    }

    public BidInfo setCreativeType(String str) {
        if (LogUtils.DEBUG) {
            LogUtils.d(TAG, "setCreativeType: creativeType = " + str);
        }
        this.mCreativeType = str;
        return this;
    }

    public BidInfo setDefaultAd(AdItem adItem) {
        this.mDefaultAd = adItem;
        this.mAdItem = adItem;
        return this;
    }

    public BidInfo setDefaultInteractionInfo(InteractionInfo interactionInfo) {
        this.mDefaultInteractionInfo = interactionInfo;
        this.mInteractionInfo = interactionInfo;
        return this;
    }

    public BidInfo setExtension(Map<String, String> map) {
        this.mExtension = map;
        return this;
    }

    public BidInfo setGroupInfo(AdGroupInfo adGroupInfo) {
        this.mGroupInfo = adGroupInfo;
        return this;
    }

    public BidInfo setImpressionId(String str) {
        this.mImpressionId = str;
        return this;
    }

    public BidInfo setIndex(int i) {
        this.mIndex = i;
        return this;
    }

    public BidInfo setInfoExtend(Map<String, String> map) {
        this.mInfoExtend = map;
        return this;
    }

    public BidInfo setInteractionInfo(InteractionInfo interactionInfo) {
        this.mInteractionInfo = interactionInfo;
        return this;
    }

    public BidInfo setReleaseEndTime(long j) {
        this.mReleaseEndTime = j;
        return this;
    }

    public BidInfo setReleaseStartTime(long j) {
        this.mReleaseStartTime = j;
        return this;
    }

    public BidInfo setSceneInfo(SceneInfo sceneInfo) {
        this.mSceneInfo = sceneInfo;
        return this;
    }

    public BidInfo setSecondaryAd(AdItem adItem) {
        this.mSecondaryAd = adItem;
        return this;
    }

    public BidInfo setSecondaryInteractionInfo(InteractionInfo interactionInfo) {
        this.mSecondaryInteractionInfo = interactionInfo;
        return this;
    }

    public BidInfo setTemplateInfo(TemplateInfo templateInfo) {
        this.mTemplateInfo = templateInfo;
        return this;
    }

    public BidInfo setType(int i) {
        this.mType = i;
        return this;
    }

    public String toString() {
        return "BidInfo{mType=" + this.mType + ", mIndex=" + this.mIndex + ", mImpressionId=" + this.mImpressionId + ", mGroupInfo=" + this.mGroupInfo + ", mTemplateInfo=" + this.mTemplateInfo + '}';
    }
}
