package tb;

import android.text.TextUtils;
import cn.damai.commonbusiness.search.bean.ProjectItemBean;
import cn.damai.commonbusiness.search.bean.RankingListBean;
import cn.damai.search.bean.youku.SearchResultBeanYouKu;
import cn.damai.tetris.component.discover.bean.NoteBean;
import cn.damai.tetris.component.discover.bean.VideoInfo;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;

/* compiled from: Taobao */
/* loaded from: classes6.dex */
public class g82 {
    private static transient /* synthetic */ IpChange $ipChange;

    public static NoteBean a(SearchResultBeanYouKu.ListBean listBean, int i) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-232553206")) {
            return (NoteBean) ipChange.ipc$dispatch("-232553206", new Object[]{listBean, Integer.valueOf(i)});
        }
        NoteBean noteBean = new NoteBean();
        noteBean.highLight = false;
        if (listBean.isVideoImageText()) {
            VideoInfo videoInfo = new VideoInfo();
            noteBean.videoInfo = videoInfo;
            videoInfo.coverUrl = listBean.thumb_url;
        }
        noteBean.id = listBean.object_id;
        noteBean.pic = listBean.thumb_url;
        noteBean.isFeature = listBean.is_feature;
        noteBean.content = listBean.SUMMARY_object_name;
        noteBean.headImg = listBean.user_pic;
        noteBean.nickname = listBean.user_nick;
        if (i % 5 == 0) {
            noteBean.hwRatio = 1.3333334f;
        } else {
            noteBean.hwRatio = 1.0f;
        }
        return noteBean;
    }

    public static ProjectItemBean b(SearchResultBeanYouKu.ListBean listBean) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1111150069")) {
            return (ProjectItemBean) ipChange.ipc$dispatch("-1111150069", new Object[]{listBean});
        }
        if (listBean == null) {
            return null;
        }
        ProjectItemBean projectItemBean = new ProjectItemBean();
        projectItemBean.id = listBean.item_id;
        projectItemBean.verticalPic = listBean.verticalPic;
        projectItemBean.isVideoSupport = listBean.getVideoSupport();
        projectItemBean.categoryName = listBean.SUMMARY_category_name;
        projectItemBean.isHot = listBean.isHot;
        projectItemBean.name = listBean.SUMMARY_name;
        projectItemBean.venueCity = listBean.venue_city;
        projectItemBean.highlightWord = listBean.highlightWord;
        projectItemBean.showTime = listBean.showtime;
        projectItemBean.venueName = listBean.SUMMARY_venue_name;
        projectItemBean.cityName = listBean.SUMMARY_city_name;
        projectItemBean.isSelectSeat = listBean.is_select_seat;
        projectItemBean.formattedPriceStr = listBean.price_str;
        projectItemBean.priceLow = listBean.price_low;
        projectItemBean.showStatus = listBean.showStatus;
        SearchResultBeanYouKu.AtmosphericPic atmosphericPic = listBean.atmosphericPic;
        if (atmosphericPic != null) {
            projectItemBean.atmosphericPic = atmosphericPic.atmospheric_pic_url;
        }
        projectItemBean.discountRate = listBean.discountRate;
        projectItemBean.showTag = listBean.showtag;
        SearchResultBeanYouKu.RankingList rankingList = listBean.rankingList;
        if (rankingList != null && !TextUtils.isEmpty(rankingList.title)) {
            RankingListBean rankingListBean = new RankingListBean();
            projectItemBean.rankingList = rankingListBean;
            SearchResultBeanYouKu.RankingList rankingList2 = listBean.rankingList;
            rankingListBean.title = rankingList2.title;
            rankingListBean.type = rankingList2.getType();
        }
        projectItemBean.actores = listBean.SUMMARY_artist_name;
        projectItemBean.promotionTags = listBean.promotionTags;
        projectItemBean.couponTags = listBean.couponTags;
        projectItemBean.activityTags = listBean.activityTags;
        projectItemBean.privilegeTags = listBean.privilegeTags;
        projectItemBean.commonTags = listBean.isRefundSupport;
        projectItemBean.venueId = listBean.venue_id;
        projectItemBean.isSnapUp = listBean.isSnapUp;
        projectItemBean.upTime = listBean.up_time * 1000;
        projectItemBean.onSaleTime = listBean.onSaleTime;
        if (!TextUtils.isEmpty(listBean.itemScore)) {
            try {
                projectItemBean.itemScore = Double.parseDouble(listBean.itemScore);
            } catch (Exception unused) {
            }
        }
        projectItemBean.alg = listBean.alg;
        projectItemBean.liveStatus = listBean.liveStatus;
        projectItemBean.liveStartTime = listBean.liveStartTime;
        projectItemBean.schema = listBean.liveItemUrl;
        return projectItemBean;
    }
}
