package com.alimm.xadsdk.business.common.model;

import android.text.TextUtils;
import androidx.annotation.NonNull;
import com.alimm.xadsdk.base.model.AdCreativeInfo;
import com.alimm.xadsdk.base.model.BidInfo;
import com.alimm.xadsdk.base.model.InteractionInfo;
import com.alimm.xadsdk.base.model.LandingInfo;
import com.alimm.xadsdk.base.utils.Utils;
import java.io.Serializable;
import java.util.List;

/* compiled from: Taobao */
/* loaded from: classes12.dex */
public class AdInfo implements Serializable {
    private boolean mAllowFullscreenClick;
    private String mAssetPath;
    private String mAssetType;
    private int mDuration;
    private int mHeight;
    private boolean mHideAdMark;
    private String mIdentifier;
    private InteractionInfo mInteractionInfo;
    private List<LandingInfo> mLandingInfoList;
    private String mMainTitle;
    private long mPosition;
    private String mSkipText;
    private String mSubTitle;
    private int mTemplateId;
    private String mVendorName;
    private int mWidth;

    public AdInfo(@NonNull BidInfo bidInfo) {
        this.mIdentifier = bidInfo.getImpressionId();
        AdCreativeInfo creativeInfo = bidInfo.getCreativeInfo();
        if (creativeInfo != null) {
            this.mAssetType = creativeInfo.getCreativeType();
            this.mAssetPath = bidInfo.getCreativePath();
            this.mAllowFullscreenClick = TextUtils.equals("1", creativeInfo.getClickZone());
            this.mMainTitle = creativeInfo.getTitle();
            this.mSubTitle = creativeInfo.getSubTitle();
            this.mDuration = creativeInfo.getDuration();
            this.mWidth = creativeInfo.getCreativeWidth();
            this.mHeight = creativeInfo.getCreativeHeight();
        }
        this.mLandingInfoList = bidInfo.getLandingInfo();
        this.mHideAdMark = bidInfo.isMarketing();
        this.mVendorName = bidInfo.getDspName();
        this.mPosition = Utils.toLong(bidInfo.getSspId(), 0L);
        this.mTemplateId = bidInfo.getTemplateId();
        this.mInteractionInfo = bidInfo.getInteractionInfo();
    }

    public String getAssetType() {
        return this.mAssetType;
    }

    public String getAssetUrl() {
        return this.mAssetPath;
    }

    public int getDuration() {
        return this.mDuration;
    }

    public int getHeight() {
        return this.mHeight;
    }

    public String getIdentifier() {
        return this.mIdentifier;
    }

    public InteractionInfo getInteractionInfo() {
        return this.mInteractionInfo;
    }

    public List<LandingInfo> getLandingInfoList() {
        return this.mLandingInfoList;
    }

    public String getMainTitle() {
        return this.mMainTitle;
    }

    public long getPosition() {
        return this.mPosition;
    }

    public String getSkipText() {
        return this.mSkipText;
    }

    public String getSubTitle() {
        return this.mSubTitle;
    }

    public int getTemplateId() {
        return this.mTemplateId;
    }

    public String getVendorName() {
        return this.mVendorName;
    }

    public int getWidth() {
        return this.mWidth;
    }

    public boolean isAllowFullscreenClick() {
        return this.mAllowFullscreenClick || isImmersiveTemplate() || isTopViewTemplate() || isTradeInteractionTemplate() || isGestureInteractionTemplate() || isSlideInteractionTemplate() || isVoteInteractionTemplate();
    }

    public boolean isGestureInteractionTemplate() {
        int i = this.mTemplateId;
        return i == 169 || i == 168;
    }

    public boolean isHideAdMark() {
        return this.mHideAdMark;
    }

    public boolean isImmersiveTemplate() {
        int i = this.mTemplateId;
        return i == 161 || i == 163;
    }

    public boolean isSlideInteractionTemplate() {
        int i = this.mTemplateId;
        return i == 361 || i == 360;
    }

    public boolean isTopViewTemplate() {
        int i = this.mTemplateId;
        return i == 362 || i == 363;
    }

    public boolean isTradeInteractionTemplate() {
        int i = this.mTemplateId;
        return i == 167 || i == 166;
    }

    public boolean isVoteInteractionTemplate() {
        int i = this.mTemplateId;
        return i == 364 || i == 365;
    }

    public String toString() {
        return "AdInfo{id = " + this.mIdentifier + ",tmpId=" + this.mTemplateId + ",type=" + this.mAssetType + ",assetPath=" + this.mAssetPath + "}";
    }
}
