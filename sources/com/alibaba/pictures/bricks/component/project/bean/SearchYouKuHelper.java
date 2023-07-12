package com.alibaba.pictures.bricks.component.project.bean;

import android.text.TextUtils;
import com.alibaba.pictures.bricks.component.project.bean.SearchYouKuProjectBean;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import java.util.ArrayList;

/* compiled from: Taobao */
/* loaded from: classes7.dex */
public class SearchYouKuHelper {
    private static transient /* synthetic */ IpChange $ipChange;

    public static ProjectItemBean parseOneProductInner(SearchYouKuProjectBean searchYouKuProjectBean) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "514646573")) {
            return (ProjectItemBean) ipChange.ipc$dispatch("514646573", new Object[]{searchYouKuProjectBean});
        }
        if (searchYouKuProjectBean == null) {
            return null;
        }
        ProjectItemBean projectItemBean = new ProjectItemBean();
        projectItemBean.id = searchYouKuProjectBean.itemId;
        projectItemBean.verticalPic = searchYouKuProjectBean.verticalPic;
        projectItemBean.isVideoSupport = searchYouKuProjectBean.getVideoSupport();
        projectItemBean.categoryName = searchYouKuProjectBean.summaryCategoryName;
        projectItemBean.guideSubCategoryName = searchYouKuProjectBean.guideSubCategoryName;
        projectItemBean.isHot = searchYouKuProjectBean.isHot;
        projectItemBean.name = searchYouKuProjectBean.summaryName;
        projectItemBean.venueCity = searchYouKuProjectBean.venueCity;
        projectItemBean.highlightWord = searchYouKuProjectBean.highlightWord;
        projectItemBean.showTime = searchYouKuProjectBean.showTime;
        projectItemBean.venueName = searchYouKuProjectBean.summaryVenueName;
        projectItemBean.cityName = searchYouKuProjectBean.summaryCityName;
        projectItemBean.isSelectSeat = searchYouKuProjectBean.isSelectSeat;
        projectItemBean.formattedPriceStr = searchYouKuProjectBean.priceStr;
        projectItemBean.priceLow = searchYouKuProjectBean.priceLow;
        projectItemBean.showStatus = searchYouKuProjectBean.showStatus;
        SearchYouKuProjectBean.AtmosphericPicArch atmosphericPicArch = searchYouKuProjectBean.atmosphericPic;
        if (atmosphericPicArch != null) {
            projectItemBean.atmosphericPic = atmosphericPicArch.atmospheric_pic_url;
        }
        projectItemBean.discountRate = searchYouKuProjectBean.discountRate;
        projectItemBean.showTag = searchYouKuProjectBean.showTag;
        SearchYouKuProjectBean.RankingListArch rankingListArch = searchYouKuProjectBean.rankingList;
        if (rankingListArch != null && !TextUtils.isEmpty(rankingListArch.title)) {
            RankingListBean rankingListBean = new RankingListBean();
            projectItemBean.rankingList = rankingListBean;
            SearchYouKuProjectBean.RankingListArch rankingListArch2 = searchYouKuProjectBean.rankingList;
            rankingListBean.title = rankingListArch2.title;
            rankingListBean.type = rankingListArch2.getType();
        }
        projectItemBean.actores = searchYouKuProjectBean.summaryArtistName;
        projectItemBean.promotionTags = searchYouKuProjectBean.promotionTags;
        projectItemBean.vipCouponTags = searchYouKuProjectBean.vipCouponTags;
        projectItemBean.couponTags = searchYouKuProjectBean.couponTags;
        projectItemBean.activityTags = searchYouKuProjectBean.activityTags;
        projectItemBean.privilegeTags = searchYouKuProjectBean.privilegeTags;
        projectItemBean.brandOptimizationTag = searchYouKuProjectBean.projectStatusTag;
        if (searchYouKuProjectBean.isRefundSupport != null) {
            ArrayList arrayList = new ArrayList();
            projectItemBean.commonTags = arrayList;
            arrayList.add(searchYouKuProjectBean.isRefundSupport);
        }
        projectItemBean.venueId = searchYouKuProjectBean.venueId;
        projectItemBean.isSnapUp = searchYouKuProjectBean.isSnapUp;
        projectItemBean.upTime = searchYouKuProjectBean.upTime;
        projectItemBean.onSaleTime = searchYouKuProjectBean.onSaleTime;
        if (!TextUtils.isEmpty(searchYouKuProjectBean.itemScore)) {
            try {
                projectItemBean.itemScore = Double.parseDouble(searchYouKuProjectBean.itemScore);
            } catch (Exception unused) {
            }
        }
        projectItemBean.alg = searchYouKuProjectBean.alg;
        projectItemBean.liveStatus = searchYouKuProjectBean.liveStatus;
        projectItemBean.liveStartTime = searchYouKuProjectBean.liveStartTime;
        projectItemBean.schema = searchYouKuProjectBean.liveItemUrl;
        projectItemBean.marketPromotionTags = searchYouKuProjectBean.marketPromotionTags;
        return projectItemBean;
    }

    public static long parseServerInfo(long j) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-191120893")) {
            return ((Long) ipChange.ipc$dispatch("-191120893", new Object[]{Long.valueOf(j)})).longValue();
        }
        if (j > 0) {
            return j;
        }
        return 0L;
    }
}
