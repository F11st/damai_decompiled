package com.alimm.xadsdk.base.model;

import android.text.TextUtils;
import com.alibaba.fastjson.annotation.JSONField;
import com.alibaba.pictures.bricks.orderconfirm.CouponOrderConfirmFragment;
import com.alimm.xadsdk.base.ut.AdUtConstants;
import com.alimm.xadsdk.base.utils.Utils;
import com.taobao.weex.bridge.WXBridgeManager;
import com.taobao.weex.common.Constants;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/* compiled from: Taobao */
/* loaded from: classes10.dex */
public class InteractionCreativeInfo implements BaseInfo {
    @JSONField(name = "benefit_code")
    private String mActivityCode;
    @JSONField(name = "shop_creativeid")
    private String mBenefitCode;
    @JSONField(name = "benefit_name")
    private String mBenefitName;
    @JSONField(name = "blank")
    private String mBlank;
    @JSONField(name = "creative_type")
    private String mCreativeType;
    @JSONField(name = "end")
    private String mEndTime;
    @JSONField(name = "gesture_deeplink")
    private String mGestureDeepLink;
    @JSONField(name = "gesture_link")
    private String mGestureLink;
    @JSONField(name = "h5")
    private CreativeItem mH5CreativeInfo;
    @JSONField(name = "height")
    private String mHeight;
    @JSONField(name = "image")
    private CreativeItem mImageCreativeInfo;
    @JSONField(name = "itemid")
    private String mItemId;
    @JSONField(name = "logo")
    private CreativeItem mLogo;
    @JSONField(name = "lottie_zip")
    private CreativeItem mLottieZipCreativeInfo;
    @JSONField(serialize = false)
    private CreativeItem mMainCreativeInfo;
    @JSONField(name = WXBridgeManager.OPTIONS)
    private List<OptionInfo> mOptionInfoList;
    @JSONField(name = "shop_asac")
    private String mShopAsac;
    @JSONField(name = "shop_id")
    private String mShopId;
    @JSONField(name = "skuid")
    private String mSkuId;
    @JSONField(name = AdUtConstants.XAD_UT_ARG_STA)
    private String mStartTime;
    @JSONField(name = "title")
    private String mTitle;
    @JSONField(name = "type")
    private String mType;
    @JSONField(name = "js")
    private String mUseJs;
    @JSONField(name = "width")
    private String mWidth;
    @JSONField(name = Constants.Name.X)
    private String mXCoord;
    @JSONField(name = Constants.Name.Y)
    private String mYCoord;
    @JSONField(name = "zip")
    private CreativeItem mZipCreativeInfo;

    public String getActivityCode() {
        return this.mActivityCode;
    }

    public Map<String, String> getAttributeMap() {
        return new HashMap();
    }

    public String getBenefitCode() {
        return this.mBenefitCode;
    }

    public String getBenefitName() {
        return this.mBenefitName;
    }

    public String getBlank() {
        return this.mBlank;
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

    public String getCreativeName() {
        return getMainCreativeInfo() != null ? getMainCreativeInfo().getName() : "";
    }

    public String getCreativeType() {
        return this.mCreativeType;
    }

    public String getCreativeUrl() {
        return getMainCreativeInfo() != null ? getMainCreativeInfo().getUrl() : "";
    }

    public int getCreativeWidth() {
        if (getMainCreativeInfo() != null) {
            return getMainCreativeInfo().getWidth();
        }
        return 0;
    }

    public long getEndTime() {
        return Utils.toLong(this.mEndTime, 0L);
    }

    public String getGestureDeepLink() {
        return this.mGestureDeepLink;
    }

    public String getGestureLink() {
        return this.mGestureLink;
    }

    public Map<String, String> getGoodsInfo() {
        HashMap hashMap = new HashMap(8);
        if (!TextUtils.isEmpty(getShopId())) {
            hashMap.put("sellerId", getShopId());
        }
        if (!TextUtils.isEmpty(getShopAsac())) {
            hashMap.put("asac", getShopAsac());
        }
        if (!TextUtils.isEmpty(getItemId())) {
            hashMap.put("itemId", getItemId());
        }
        if (!TextUtils.isEmpty(getSkuId())) {
            hashMap.put(CouponOrderConfirmFragment.SKU_ID, getSkuId());
        }
        if (!TextUtils.isEmpty(getActivityCode())) {
            hashMap.put("activityCode", getActivityCode());
        }
        if (!TextUtils.isEmpty(getBenefitCode())) {
            hashMap.put("benefitCode", getBenefitCode());
        }
        return hashMap;
    }

    public CreativeItem getH5CreativeInfo() {
        return this.mH5CreativeInfo;
    }

    public int getHeight() {
        return Utils.toInt(this.mHeight, 0);
    }

    public CreativeItem getImageCreativeInfo() {
        return this.mImageCreativeInfo;
    }

    public String getItemId() {
        return this.mItemId;
    }

    public CreativeItem getLogo() {
        return this.mLogo;
    }

    public CreativeItem getLottieZipCreativeInfo() {
        return this.mLottieZipCreativeInfo;
    }

    public String getLottieZipUrl() {
        CreativeItem creativeItem = this.mLottieZipCreativeInfo;
        return (creativeItem == null || TextUtils.isEmpty(creativeItem.getUrl())) ? "" : this.mLottieZipCreativeInfo.getUrl();
    }

    public CreativeItem getMainCreativeInfo() {
        CreativeItem creativeItem;
        if (this.mMainCreativeInfo == null) {
            if (TextUtils.equals(this.mCreativeType, "1")) {
                creativeItem = this.mImageCreativeInfo;
            } else if (TextUtils.equals(this.mCreativeType, "3")) {
                creativeItem = this.mH5CreativeInfo;
            } else if (TextUtils.equals(this.mCreativeType, "4")) {
                creativeItem = this.mZipCreativeInfo;
            }
            this.mMainCreativeInfo = creativeItem;
        }
        return this.mMainCreativeInfo;
    }

    public List<OptionInfo> getOptionInfoList() {
        return this.mOptionInfoList;
    }

    public int getOptionNumber() {
        List<OptionInfo> list = this.mOptionInfoList;
        if (list != null) {
            return list.size();
        }
        return 0;
    }

    public String getShopAsac() {
        return this.mShopAsac;
    }

    public String getShopId() {
        return this.mShopId;
    }

    public String getSkuId() {
        return this.mSkuId;
    }

    public long getStartTime() {
        return Utils.toLong(this.mStartTime, 0L);
    }

    public String getTitle() {
        return this.mTitle;
    }

    public int getType() {
        return Utils.toInt(this.mType, -1);
    }

    public String getUseJs() {
        return this.mUseJs;
    }

    public int getWidth() {
        return Utils.toInt(this.mWidth, 0);
    }

    public int getXCoord() {
        return Utils.toInt(this.mXCoord, 0);
    }

    public int getYCoord() {
        return Utils.toInt(this.mYCoord, 0);
    }

    public CreativeItem getZipCreativeInfo() {
        return this.mZipCreativeInfo;
    }

    public InteractionCreativeInfo setActivityCode(String str) {
        this.mActivityCode = str;
        return this;
    }

    public InteractionCreativeInfo setBenefitCode(String str) {
        this.mBenefitCode = str;
        return this;
    }

    public InteractionCreativeInfo setBenefitName(String str) {
        this.mBenefitName = str;
        return this;
    }

    public InteractionCreativeInfo setBlank(String str) {
        this.mBlank = str;
        return this;
    }

    public InteractionCreativeInfo setCreativeType(String str) {
        this.mCreativeType = str;
        return this;
    }

    public InteractionCreativeInfo setEndTime(String str) {
        this.mEndTime = str;
        return this;
    }

    public InteractionCreativeInfo setGestureDeepLink(String str) {
        this.mGestureDeepLink = str;
        return this;
    }

    public InteractionCreativeInfo setGestureLink(String str) {
        this.mGestureLink = str;
        return this;
    }

    public InteractionCreativeInfo setH5CreativeInfo(CreativeItem creativeItem) {
        this.mH5CreativeInfo = creativeItem;
        return this;
    }

    public InteractionCreativeInfo setHeight(String str) {
        this.mHeight = str;
        return this;
    }

    public InteractionCreativeInfo setImageCreativeInfo(CreativeItem creativeItem) {
        this.mImageCreativeInfo = creativeItem;
        return this;
    }

    public InteractionCreativeInfo setItemId(String str) {
        this.mItemId = str;
        return this;
    }

    public InteractionCreativeInfo setLogo(CreativeItem creativeItem) {
        this.mLogo = creativeItem;
        return this;
    }

    public InteractionCreativeInfo setLottieZipCreativeInfo(CreativeItem creativeItem) {
        this.mLottieZipCreativeInfo = creativeItem;
        return this;
    }

    public InteractionCreativeInfo setOptionInfoList(List<OptionInfo> list) {
        this.mOptionInfoList = list;
        return this;
    }

    public InteractionCreativeInfo setShopAsac(String str) {
        this.mShopAsac = str;
        return this;
    }

    public InteractionCreativeInfo setShopId(String str) {
        this.mShopId = str;
        return this;
    }

    public InteractionCreativeInfo setSkuId(String str) {
        this.mSkuId = str;
        return this;
    }

    public InteractionCreativeInfo setStartTime(String str) {
        this.mStartTime = str;
        return this;
    }

    public InteractionCreativeInfo setTitle(String str) {
        this.mTitle = str;
        return this;
    }

    public InteractionCreativeInfo setType(String str) {
        this.mType = str;
        return this;
    }

    public InteractionCreativeInfo setUseJs(String str) {
        this.mUseJs = str;
        return this;
    }

    public InteractionCreativeInfo setWidth(String str) {
        this.mWidth = str;
        return this;
    }

    public InteractionCreativeInfo setXCoord(String str) {
        this.mXCoord = str;
        return this;
    }

    public InteractionCreativeInfo setYCoord(String str) {
        this.mYCoord = str;
        return this;
    }

    public InteractionCreativeInfo setZipCreativeInfo(CreativeItem creativeItem) {
        this.mZipCreativeInfo = creativeItem;
        return this;
    }
}
