package tb;

import android.text.TextUtils;
import cn.damai.commonbusiness.search.bean.ProjectItemBean;
import cn.damai.commonbusiness.search.bean.RankingListBean;
import cn.damai.search.component.bean.SearchYouKuArchProjectBean;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import java.util.ArrayList;

/* compiled from: Taobao */
/* loaded from: classes6.dex */
public class f82 {
    private static transient /* synthetic */ IpChange $ipChange;

    public static ProjectItemBean a(SearchYouKuArchProjectBean searchYouKuArchProjectBean) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "2125785799")) {
            return (ProjectItemBean) ipChange.ipc$dispatch("2125785799", new Object[]{searchYouKuArchProjectBean});
        }
        if (searchYouKuArchProjectBean == null) {
            return null;
        }
        ProjectItemBean projectItemBean = new ProjectItemBean();
        projectItemBean.id = searchYouKuArchProjectBean.itemId;
        projectItemBean.verticalPic = searchYouKuArchProjectBean.verticalPic;
        projectItemBean.isVideoSupport = searchYouKuArchProjectBean.getVideoSupport();
        projectItemBean.categoryName = searchYouKuArchProjectBean.summaryCategoryName;
        projectItemBean.guideSubCategoryName = searchYouKuArchProjectBean.guideSubCategoryName;
        projectItemBean.isHot = searchYouKuArchProjectBean.isHot;
        projectItemBean.name = searchYouKuArchProjectBean.summaryName;
        projectItemBean.venueCity = searchYouKuArchProjectBean.venueCity;
        projectItemBean.highlightWord = searchYouKuArchProjectBean.highlightWord;
        projectItemBean.showTime = searchYouKuArchProjectBean.showTime;
        projectItemBean.venueName = searchYouKuArchProjectBean.summaryVenueName;
        projectItemBean.cityName = searchYouKuArchProjectBean.summaryCityName;
        projectItemBean.isSelectSeat = searchYouKuArchProjectBean.isSelectSeat;
        projectItemBean.formattedPriceStr = searchYouKuArchProjectBean.priceStr;
        projectItemBean.priceLow = searchYouKuArchProjectBean.priceLow;
        projectItemBean.showStatus = searchYouKuArchProjectBean.showStatus;
        SearchYouKuArchProjectBean.AtmosphericPicArch atmosphericPicArch = searchYouKuArchProjectBean.atmosphericPic;
        if (atmosphericPicArch != null) {
            projectItemBean.atmosphericPic = atmosphericPicArch.atmospheric_pic_url;
        }
        projectItemBean.discountRate = searchYouKuArchProjectBean.discountRate;
        projectItemBean.showTag = searchYouKuArchProjectBean.showTag;
        SearchYouKuArchProjectBean.RankingListArch rankingListArch = searchYouKuArchProjectBean.rankingList;
        if (rankingListArch != null && !TextUtils.isEmpty(rankingListArch.title)) {
            RankingListBean rankingListBean = new RankingListBean();
            projectItemBean.rankingList = rankingListBean;
            SearchYouKuArchProjectBean.RankingListArch rankingListArch2 = searchYouKuArchProjectBean.rankingList;
            rankingListBean.title = rankingListArch2.title;
            rankingListBean.type = rankingListArch2.getType();
        }
        projectItemBean.actores = searchYouKuArchProjectBean.summaryArtistName;
        projectItemBean.promotionTags = searchYouKuArchProjectBean.promotionTags;
        projectItemBean.vipCouponTags = searchYouKuArchProjectBean.vipCouponTags;
        projectItemBean.couponTags = searchYouKuArchProjectBean.couponTags;
        projectItemBean.activityTags = searchYouKuArchProjectBean.activityTags;
        projectItemBean.privilegeTags = searchYouKuArchProjectBean.privilegeTags;
        projectItemBean.brandOptimizationTag = searchYouKuArchProjectBean.projectStatusTag;
        if (searchYouKuArchProjectBean.isRefundSupport != null) {
            ArrayList arrayList = new ArrayList();
            projectItemBean.commonTags = arrayList;
            arrayList.add(searchYouKuArchProjectBean.isRefundSupport);
        }
        projectItemBean.venueId = searchYouKuArchProjectBean.venueId;
        projectItemBean.isSnapUp = searchYouKuArchProjectBean.isSnapUp;
        projectItemBean.upTime = searchYouKuArchProjectBean.upTime;
        projectItemBean.onSaleTime = searchYouKuArchProjectBean.onSaleTime;
        if (!TextUtils.isEmpty(searchYouKuArchProjectBean.itemScore)) {
            try {
                projectItemBean.itemScore = Double.parseDouble(searchYouKuArchProjectBean.itemScore);
            } catch (Exception unused) {
            }
        }
        projectItemBean.alg = searchYouKuArchProjectBean.alg;
        projectItemBean.liveStatus = searchYouKuArchProjectBean.liveStatus;
        projectItemBean.liveStartTime = searchYouKuArchProjectBean.liveStartTime;
        projectItemBean.schema = searchYouKuArchProjectBean.liveItemUrl;
        projectItemBean.marketPromotionTags = searchYouKuArchProjectBean.marketPromotionTags;
        return projectItemBean;
    }
}
