package com.alimm.xadsdk.base.model;

import android.text.TextUtils;
import com.alibaba.fastjson.annotation.JSONField;
import com.alimm.xadsdk.base.utils.Utils;
import com.huawei.hms.push.constant.RemoteMessageConst;

/* compiled from: Taobao */
/* loaded from: classes10.dex */
public class AdCreativeInfo implements BaseInfo {
    @JSONField(name = "autoplay_no_wifi")
    private String mAutoPlayWhenNoWifi;
    @JSONField(name = "click_zone")
    private String mClickZone;
    @JSONField(name = "close_switch")
    private String mCloseSwitch;
    @JSONField(name = "close_txt")
    private String mCloseText;
    @JSONField(name = "creative_type")
    private String mCreativeType;
    @JSONField(serialize = false)
    private int mDuration = 0;
    @JSONField(name = "focus_time")
    private String mFocusTime;
    @JSONField(name = "master_h5")
    private CreativeItem mH5CreativeInfo;
    @JSONField(name = "image")
    private CreativeItem mImageCreativeInfo;
    @JSONField(name = "linkage")
    private String mLinkage;
    @JSONField(name = "linkage_id")
    private String mLinkageId;
    @JSONField(name = "location_position")
    private String mLocationPosition;
    @JSONField(serialize = false)
    private CreativeItem mMainCreativeInfo;
    @JSONField(serialize = false)
    private PositionInfo mPositionInfo;
    @JSONField(name = "show_apple_frame")
    private String mShowAppleFrame;
    @JSONField(name = "show_time")
    private String mShowTime;
    @JSONField(name = "show_no_wifi")
    private String mShowWhenNoWifi;
    @JSONField(name = "h5")
    private CreativeItem mSideH5CreativeInfo;
    @JSONField(name = "side_image")
    private CreativeItem mSideImageCreativeInfo;
    @JSONField(name = "skip_tx")
    private String mSkipText;
    @JSONField(name = "skip_tx1")
    private String mSkipText1;
    @JSONField(name = "skip_tx2")
    private String mSkipText2;
    @JSONField(name = RemoteMessageConst.Notification.SOUND)
    private String mSoundOn;
    @JSONField(name = "sub_title")
    private String mSubTitle;
    @JSONField(name = "title")
    private String mTitle;
    @JSONField(name = "video")
    private CreativeItem mVideoCreativeInfo;
    @JSONField(name = "zip")
    private CreativeItem mZipCreativeInfo;

    public String getAutoPlayWhenNoWifi() {
        return this.mAutoPlayWhenNoWifi;
    }

    public String getClickZone() {
        return this.mClickZone;
    }

    public String getCloseSwitch() {
        return this.mCloseSwitch;
    }

    public String getCloseText() {
        return this.mCloseText;
    }

    public int getCreativeHeight() {
        if (getMainCreativeInfo() != null) {
            return getMainCreativeInfo().getHeight();
        }
        return 0;
    }

    public String getCreativeMd5() {
        return getMainCreativeInfo() != null ? getMainCreativeInfo().getContentMd5() : "";
    }

    public String getCreativeType() {
        return this.mCreativeType;
    }

    public int getCreativeWidth() {
        if (getMainCreativeInfo() != null) {
            return getMainCreativeInfo().getWidth();
        }
        return 0;
    }

    public int getDuration() {
        if (this.mDuration == 0) {
            int i = Utils.toInt(this.mShowTime, 0);
            this.mDuration = i;
            if (i == 0 && getMainCreativeInfo() != null) {
                this.mDuration = getMainCreativeInfo().getDuration();
            }
        }
        return this.mDuration;
    }

    public int getFocusTime() {
        return Utils.toInt(this.mFocusTime, 0);
    }

    public CreativeItem getH5CreativeInfo() {
        return this.mH5CreativeInfo;
    }

    public CreativeItem getImageCreativeInfo() {
        return this.mImageCreativeInfo;
    }

    public String getLinkage() {
        return this.mLinkage;
    }

    public String getLinkageId() {
        return this.mLinkageId;
    }

    public CreativeItem getMainCreativeInfo() {
        CreativeItem creativeItem;
        if (this.mMainCreativeInfo == null) {
            if (TextUtils.equals(this.mCreativeType, "1")) {
                creativeItem = this.mImageCreativeInfo;
            } else if (TextUtils.equals(this.mCreativeType, "2")) {
                creativeItem = this.mVideoCreativeInfo;
            } else if (TextUtils.equals(this.mCreativeType, "3")) {
                creativeItem = this.mH5CreativeInfo;
            } else if (TextUtils.equals(this.mCreativeType, "4")) {
                creativeItem = this.mZipCreativeInfo;
            }
            this.mMainCreativeInfo = creativeItem;
        }
        return this.mMainCreativeInfo;
    }

    public String getName() {
        return getMainCreativeInfo() != null ? getMainCreativeInfo().getName() : "";
    }

    public PositionInfo getPositionInfo() {
        return this.mPositionInfo;
    }

    public String getShowAppleFrame() {
        return this.mShowAppleFrame;
    }

    public String getShowTime() {
        return this.mShowTime;
    }

    public String getShowWhenNoWifi() {
        return this.mShowWhenNoWifi;
    }

    public CreativeItem getSideH5CreativeInfo() {
        return this.mSideH5CreativeInfo;
    }

    public CreativeItem getSideImageCreativeInfo() {
        return this.mSideImageCreativeInfo;
    }

    public String getSkipText() {
        return this.mSkipText;
    }

    public String getSkipText1() {
        return this.mSkipText1;
    }

    public String getSkipText2() {
        return this.mSkipText2;
    }

    public String getSoundOn() {
        return this.mSoundOn;
    }

    public String getSubTitle() {
        return this.mSubTitle;
    }

    public String getTitle() {
        return this.mTitle;
    }

    public String getUrl() {
        return getMainCreativeInfo() != null ? getMainCreativeInfo().getUrl() : "";
    }

    public CreativeItem getVideoCreativeInfo() {
        return this.mVideoCreativeInfo;
    }

    public CreativeItem getZipCreativeInfo() {
        return this.mZipCreativeInfo;
    }

    public AdCreativeInfo setAutoPlayWhenNoWifi(String str) {
        this.mAutoPlayWhenNoWifi = str;
        return this;
    }

    public AdCreativeInfo setClickZone(String str) {
        this.mClickZone = str;
        return this;
    }

    public AdCreativeInfo setCloseSwitch(String str) {
        this.mCloseSwitch = str;
        return this;
    }

    public AdCreativeInfo setCloseText(String str) {
        this.mCloseText = str;
        return this;
    }

    public AdCreativeInfo setCreativeType(String str) {
        this.mCreativeType = str;
        return this;
    }

    public AdCreativeInfo setFocusTime(String str) {
        this.mFocusTime = str;
        return this;
    }

    public AdCreativeInfo setH5CreativeInfo(CreativeItem creativeItem) {
        this.mH5CreativeInfo = creativeItem;
        return this;
    }

    public AdCreativeInfo setImageCreativeInfo(CreativeItem creativeItem) {
        this.mImageCreativeInfo = creativeItem;
        return this;
    }

    public AdCreativeInfo setLinkage(String str) {
        this.mLinkage = str;
        return this;
    }

    public AdCreativeInfo setLinkageId(String str) {
        this.mLinkageId = str;
        return this;
    }

    public AdCreativeInfo setLocationPosition(String str) {
        this.mLocationPosition = str;
        this.mPositionInfo = new PositionInfo(str);
        return this;
    }

    public AdCreativeInfo setPositionInfo(PositionInfo positionInfo) {
        this.mPositionInfo = positionInfo;
        return this;
    }

    public AdCreativeInfo setShowAppleFrame(String str) {
        this.mShowAppleFrame = str;
        return this;
    }

    public AdCreativeInfo setShowTime(String str) {
        this.mShowTime = str;
        return this;
    }

    public AdCreativeInfo setShowWhenNoWifi(String str) {
        this.mShowWhenNoWifi = str;
        return this;
    }

    public AdCreativeInfo setSideH5CreativeInfo(CreativeItem creativeItem) {
        this.mSideH5CreativeInfo = creativeItem;
        return this;
    }

    public AdCreativeInfo setSideImageCreativeInfo(CreativeItem creativeItem) {
        this.mSideImageCreativeInfo = creativeItem;
        return this;
    }

    public AdCreativeInfo setSkipText(String str) {
        this.mSkipText = str;
        return this;
    }

    public AdCreativeInfo setSkipText1(String str) {
        this.mSkipText1 = str;
        return this;
    }

    public AdCreativeInfo setSkipText2(String str) {
        this.mSkipText2 = str;
        return this;
    }

    public AdCreativeInfo setSoundOn(String str) {
        this.mSoundOn = str;
        return this;
    }

    public AdCreativeInfo setSubTitle(String str) {
        this.mSubTitle = str;
        return this;
    }

    public AdCreativeInfo setTitle(String str) {
        this.mTitle = str;
        return this;
    }

    public AdCreativeInfo setVideoCreativeInfo(CreativeItem creativeItem) {
        this.mVideoCreativeInfo = creativeItem;
        return this;
    }

    public AdCreativeInfo setZipCreativeInfo(CreativeItem creativeItem) {
        this.mZipCreativeInfo = creativeItem;
        return this;
    }
}
