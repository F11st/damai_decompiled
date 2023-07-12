package cn.damai.search.bean.youku;

import android.text.TextUtils;
import cn.damai.commonbusiness.search.bean.ProjectBuyStatus;
import cn.damai.commonbusiness.search.bean.SearchTourItem;
import com.alibaba.pictures.bricks.component.project.bean.CommonTagBean;
import com.alibaba.pictures.bricks.component.project.bean.HnProjectTag;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import java.io.Serializable;
import java.util.List;
import org.apache.commons.lang3.StringUtils;
import tb.cb2;

/* compiled from: Taobao */
/* loaded from: classes15.dex */
public class SearchResultBeanYouKu implements Serializable {
    private static transient /* synthetic */ IpChange $ipChange = null;
    public static final String FLAG_ARTIFICIAL_IMAGE_TEXT = "artificialImageText";
    public static final String FLAG_ARTIFICIAL_INFO = "artificialInfo";
    public static final String FLAG_BACCOUNT = "baccountInfo";
    public static final String FLAG_BRAND_OPTIMIZATION = "brandOptimization";
    public static final String FLAG_IMAGE_TEXT = "imageText";
    public static final String FLAG_SERVER_INFO = "serverInfo";
    public static final String FLAG_SUGGEST_PROJECT = "suggestProjectInfo";
    public static final String FLAG_TOUR = "tour";
    public static final String FlAG_PROJECT = "projectInfo";
    public static final int TYPE_BRAND = 11;
    public static final int TYPE_IMAGE_TEXT = 21;
    public static final int TYPE_PROJECT = 12;
    public static final int TYPE_SHOW = 13;
    public static final int TYPE_VENUE = 10;
    public DataBean data;

    /* compiled from: Taobao */
    /* loaded from: classes15.dex */
    public static class AtmosphericPic implements Serializable {
        public String atmospheric_pic_url;
    }

    /* compiled from: Taobao */
    /* loaded from: classes15.dex */
    public static class DataBean {
        public boolean isEnded;
        public List<ListBean> resultList;
        public int total;
    }

    /* compiled from: Taobao */
    /* loaded from: classes15.dex */
    public static class ListBean {
        private static transient /* synthetic */ IpChange $ipChange;
        public String SUMMARY_artist_name;
        public String SUMMARY_category_name;
        public String SUMMARY_city_name;
        public String SUMMARY_name;
        public String SUMMARY_object_name;
        public String SUMMARY_venue_name;
        public List<HnProjectTag> activityTags;
        public String alg;
        public AtmosphericPic atmosphericPic;
        public String backgroundPic;
        public String city;
        public String content;
        public String content_image;
        public List<HnProjectTag> couponTags;
        public String cover;
        public long currentTime;
        public String damaiId;
        public String discountRate;
        public String extra_info;
        public String fansCount;
        public String flag;
        public String followStatus;
        public String headPic;
        public List<String> highlightWord;
        public String id;
        public String idx;
        public String ipvuv;
        public String isHot;
        public boolean isImageTextEnd = true;
        public List<CommonTagBean> isRefundSupport;
        public String isSnapUp;
        public String isVideoSupport;
        public String is_feature;
        public String is_select_seat;
        public String itemName;
        public String itemScore;
        public String item_id;
        public List<SearchTourItem> items;
        public String label;
        public String liveItemUrl;
        public String liveStartTime;
        public String liveStatus;
        public List<String> moreInfo;
        public String name;
        public String object_id;
        public String onSaleTime;
        public String performanceCount;
        public String price_low;
        public String price_str;
        public List<HnProjectTag> privilegeTags;
        public List<String> promotionTags;
        public String query;
        public RankingList rankingList;
        public String recommend;
        public ProjectBuyStatus showStatus;
        public String showtag;
        public String showtime;
        public String subtype;
        public List<ListBean> tabArray;
        public String tagUrl;
        public String theme_image;
        public String thumb_url;
        public String title;
        public ListBean topItem;
        public String type;
        public long up_time;
        public String url;
        public String user_nick;
        public String user_pic;
        public String vaccount;
        public String venue_city;
        public String venue_id;
        public String verticalPic;

        public String getVideoSupport() {
            IpChange ipChange = $ipChange;
            return AndroidInstantRuntime.support(ipChange, "834658036") ? (String) ipChange.ipc$dispatch("834658036", new Object[]{this}) : (TextUtils.isEmpty(this.isVideoSupport) || !this.isVideoSupport.equals("1")) ? "false" : "true";
        }

        public boolean isVideoImageText() {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "503853121")) {
                return ((Boolean) ipChange.ipc$dispatch("503853121", new Object[]{this})).booleanValue();
            }
            if (TextUtils.isEmpty(this.isVideoSupport)) {
                return false;
            }
            return this.isVideoSupport.equals("1") || this.isVideoSupport.equals("true");
        }
    }

    /* compiled from: Taobao */
    /* loaded from: classes15.dex */
    public static class RankingList implements Serializable {
        private static transient /* synthetic */ IpChange $ipChange;
        public String title;
        public String type;

        public int getType() {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "-811374387")) {
                return ((Integer) ipChange.ipc$dispatch("-811374387", new Object[]{this})).intValue();
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

    public static boolean isResImageTextEnded(SearchResultBeanYouKu searchResultBeanYouKu) {
        DataBean dataBean;
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-758595414")) {
            return ((Boolean) ipChange.ipc$dispatch("-758595414", new Object[]{searchResultBeanYouKu})).booleanValue();
        }
        if (searchResultBeanYouKu != null && (dataBean = searchResultBeanYouKu.data) != null && !cb2.d(dataBean.resultList)) {
            for (ListBean listBean : searchResultBeanYouKu.data.resultList) {
                if (listBean != null && TextUtils.equals(FLAG_IMAGE_TEXT, listBean.flag)) {
                    return listBean.isImageTextEnd;
                }
            }
        }
        return true;
    }
}
