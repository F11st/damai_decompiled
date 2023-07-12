package com.alibaba.pictures.bricks.component.project.bean;

import android.text.TextUtils;
import cn.damai.commonbusiness.search.bean.MarketTagBean;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import java.io.Serializable;
import java.util.List;
import org.apache.commons.lang3.StringUtils;

/* compiled from: Taobao */
/* loaded from: classes7.dex */
public class SearchYouKuProjectBean implements Serializable {
    private static transient /* synthetic */ IpChange $ipChange = null;
    private static final long serialVersionUID = 1;
    public List<HnProjectTag> activityTags;
    public String address;
    public String alg;
    public String artistId;
    public String artistName;
    public AtmosphericPicArch atmosphericPic;
    public String auctionLabel;
    public String backgroundPic;
    public String brandId;
    public String brandName;
    public String categoryId;
    public String categoryName;
    public String cityId;
    public String cityName;
    public List<HnProjectTag> couponTags;
    public String createTime;
    public String damaiEntityMatch;
    public String damaiEntityPrefixMatch;
    public String discountRate;
    public String distance;
    public String distanceScore;
    public String extraInfo;
    public String fansCount;
    public String favourable;
    public String favourableId;
    public String featureScore;
    public String filterLatestTime;
    public String followStatus;
    public String formattedPriceStr;
    public String gifUrl;
    public String globalRelevanceScore;
    public String guideSubCategoryName;
    public String headPic;
    public List<String> highlightWord;
    public String humanTag;
    public String humanTagD;
    public String id;
    public String ipId;
    public String ipName;
    public String ipvuv;
    public String isFeature;
    public String isFullMatch;
    public String isGeneralAgent;
    public String isHot;
    public CommonTagBean isRefundSupport;
    public String isSelectSeat;
    public String isSnapUp;
    public String isTitleExactlyMatch;
    public String isVideoSupport;
    public String itemId;
    public String itemScore;
    public String labelName;
    public String latitude;
    public String liveItemUrl;
    public String liveStartTime;
    public String liveStatus;
    public String longitude;
    public List<MarketTagBean> marketPromotionTags;
    public String marketTag;
    public String marketTagD;
    public String matchLevel;
    public String name;
    public String nearestPerformTime;
    public String newRelevanceLevel;
    public String newUserId;
    public String nid;
    public String objectAlias;
    public String objectDesc;
    public String objectEnglishName;
    public String objectId;
    public String objectName;
    public String objectNameRaw;
    public String onSaleTime;
    public String performanceCount;
    public String personMatchIndex;
    public String praiseTotal;
    public String priceHigh;
    public String priceLow;
    public String priceStr;
    public List<HnProjectTag> privilegeTags;
    public String projectId;
    public String projectStatusTag;
    public String projectTag;
    public String projectTagD;
    public String promotionPrice;
    public List<String> promotionTags;
    public RankingListArch rankingList;
    public String recommendReason;
    public String relevanceMatchDegree;
    public String replyTotal;
    public String saleEndTime;
    public String sceneTag;
    public String sceneTagD;
    public ProjectBuyStatus showStatus;
    public String showTag;
    public String showTime;
    public String siteStatus;
    public String sortExprValues;
    public String spScore;
    public String srcEngine;
    public String status;
    public String subCategoryId;
    public String subCategoryName;
    public String subHead;
    public String subTitle;
    public String subType;
    public String summaryAddress;
    public String summaryArtistName;
    public String summaryBrandName;
    public String summaryCategoryName;
    public String summaryCityName;
    public String summaryLabelName;
    public String summaryName;
    public String summaryObjectAlias;
    public String summaryObjectEnglishName;
    public String summaryObjectName;
    public String summaryTagName;
    public String summaryVenueName;
    public String tagName;
    public String thumbUrl;
    public String tourId;
    public String type;
    public long upTime;
    public String userId;
    public String venueCity;
    public String venueId;
    public String venueName;
    public String verticalPic;
    public String videoCoverUrl;
    public String videoTime;
    public List<ProjectVipTagBean> vipCouponTags;
    public String weight;

    /* compiled from: Taobao */
    /* loaded from: classes7.dex */
    public static class AtmosphericPicArch implements Serializable {
        public String atmospheric_pic_url;
    }

    /* compiled from: Taobao */
    /* loaded from: classes7.dex */
    public static class RankingListArch implements Serializable {
        private static transient /* synthetic */ IpChange $ipChange;
        public String title;
        public String type;

        public int getType() {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "-12724945")) {
                return ((Integer) ipChange.ipc$dispatch("-12724945", new Object[]{this})).intValue();
            }
            if (TextUtils.isEmpty(this.type)) {
                return 0;
            }
            try {
                if (StringUtils.isNumeric(this.type)) {
                    return Integer.parseInt(this.type);
                }
            } catch (Exception unused) {
            }
            return 0;
        }
    }

    public String getVideoSupport() {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "-1813655208") ? (String) ipChange.ipc$dispatch("-1813655208", new Object[]{this}) : (TextUtils.isEmpty(this.isVideoSupport) || !this.isVideoSupport.equals("1")) ? "false" : "true";
    }
}
