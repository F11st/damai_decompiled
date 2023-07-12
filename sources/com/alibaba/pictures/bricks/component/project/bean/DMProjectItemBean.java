package com.alibaba.pictures.bricks.component.project.bean;

import android.text.TextUtils;
import cn.damai.commonbusiness.search.bean.MarketTagBean;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import java.io.Serializable;
import java.util.List;
import tb.n91;

/* compiled from: Taobao */
/* loaded from: classes7.dex */
public class DMProjectItemBean implements Serializable {
    private static transient /* synthetic */ IpChange $ipChange = null;
    private static final long serialVersionUID = -8470055033790130775L;
    public PosterTag bottomLeft;
    public PosterTag bottomRight;
    public String cityName;
    public String comboDispatchId;
    public String formattedDistance;
    public List<String> highlightWord;
    public String id;
    public double itemScore = -1.0d;
    public String name;
    public int pos;
    public String priceLow;
    public String priceShowText;
    public String schema;
    public ProjectBuyStatus showStatus;
    public String showTag;
    public String showTime;
    public SnapUpInfo snapUpInfo;
    public ProjectTagModel tagModel;
    public PosterTag topRight;
    public String venueName;
    public String verticalPic;
    public String wantSee;

    /* compiled from: Taobao */
    /* loaded from: classes7.dex */
    public static class PosterTag implements Serializable {
        public String tag;
        public String type;
    }

    /* compiled from: Taobao */
    /* loaded from: classes7.dex */
    public static class ProjectTagModel implements Serializable {
        public List<CommonTagBean> commonTags;
        public List<MarketTagBean> marketPromotionTags;
    }

    /* compiled from: Taobao */
    /* loaded from: classes7.dex */
    public static class SnapUpInfo implements Serializable {
        public String onSaleTime;
        public Long upTime;
    }

    public Long calSnapUpCountDownTime(Long l) {
        Long l2;
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-42120468")) {
            return (Long) ipChange.ipc$dispatch("-42120468", new Object[]{this, l});
        }
        if (judgeIsSnapUp() && (l2 = this.snapUpInfo.upTime) != null && l2.longValue() > 0 && l != null) {
            return Long.valueOf(this.snapUpInfo.upTime.longValue() - l.longValue());
        }
        return 0L;
    }

    public String gotMarketUTValue() {
        IpChange ipChange = $ipChange;
        int i = 0;
        if (AndroidInstantRuntime.support(ipChange, "-541388619")) {
            return (String) ipChange.ipc$dispatch("-541388619", new Object[]{this});
        }
        StringBuffer stringBuffer = new StringBuffer();
        ProjectTagModel projectTagModel = this.tagModel;
        if (projectTagModel != null && !n91.b(projectTagModel.marketPromotionTags)) {
            for (MarketTagBean marketTagBean : this.tagModel.marketPromotionTags) {
                if (marketTagBean != null) {
                    stringBuffer.append(marketTagBean.type);
                    if (i < this.tagModel.marketPromotionTags.size() - 1) {
                        stringBuffer.append(",");
                    }
                }
                i++;
            }
        }
        return stringBuffer.toString();
    }

    public boolean hasWantSee() {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "-1655056400") ? ((Boolean) ipChange.ipc$dispatch("-1655056400", new Object[]{this})).booleanValue() : TextUtils.equals(this.wantSee, "true");
    }

    public boolean judgeIdXiaJiaProject() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1227224924")) {
            return ((Boolean) ipChange.ipc$dispatch("-1227224924", new Object[]{this})).booleanValue();
        }
        ProjectBuyStatus projectBuyStatus = this.showStatus;
        return projectBuyStatus != null && TextUtils.equals(projectBuyStatus.id, "2");
    }

    public boolean judgeIsLiveProject() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1237015027")) {
            return ((Boolean) ipChange.ipc$dispatch("-1237015027", new Object[]{this})).booleanValue();
        }
        PosterTag posterTag = this.topRight;
        return posterTag != null && (TextUtils.equals(posterTag.type, "202") || TextUtils.equals(this.topRight.type, "203"));
    }

    public boolean judgeIsSnapUp() {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "-2067920269") ? ((Boolean) ipChange.ipc$dispatch("-2067920269", new Object[]{this})).booleanValue() : this.snapUpInfo != null;
    }

    public boolean needShowPosterVideoTag() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1449276218")) {
            return ((Boolean) ipChange.ipc$dispatch("1449276218", new Object[]{this})).booleanValue();
        }
        PosterTag posterTag = this.bottomRight;
        return posterTag != null && TextUtils.equals(posterTag.type, "401");
    }
}
