package cn.damai.homepage.bean;

import android.graphics.Color;
import android.text.TextUtils;
import cn.damai.commonbusiness.discover.bean.IFeedProjectBean;
import cn.damai.commonbusiness.discover.bean.TagBean;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import java.util.ArrayList;
import java.util.List;

/* compiled from: Taobao */
/* loaded from: classes5.dex */
public class WaterFlowRec2Project implements IFeedProjectBean<WaterFlowRecommendItem> {
    private static transient /* synthetic */ IpChange $ipChange;
    private WaterFlowRecommendItem mItem;
    private List<TagBean> tagList;

    public WaterFlowRec2Project(WaterFlowRecommendItem waterFlowRecommendItem) {
        this.mItem = waterFlowRecommendItem;
    }

    @Override // cn.damai.commonbusiness.discover.bean.IFeedProjectBean
    public String getAtmospheric() {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "932856415") ? (String) ipChange.ipc$dispatch("932856415", new Object[]{this}) : this.mItem.atmosphericPic;
    }

    @Override // cn.damai.commonbusiness.discover.bean.IFeedProjectBean
    public int getLiveStatus() {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "-1473718399") ? ((Integer) ipChange.ipc$dispatch("-1473718399", new Object[]{this})).intValue() : this.mItem.liveStatus;
    }

    @Override // cn.damai.commonbusiness.discover.bean.IFeedProjectBean
    public String getPostPic() {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "1112543788") ? (String) ipChange.ipc$dispatch("1112543788", new Object[]{this}) : this.mItem.projectPic;
    }

    @Override // cn.damai.commonbusiness.discover.bean.IFeedProjectBean
    public String getProjectDate() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "2108496841")) {
            return (String) ipChange.ipc$dispatch("2108496841", new Object[]{this});
        }
        if (!TextUtils.isEmpty(this.mItem.liveStartTime)) {
            return this.mItem.liveStartTime;
        }
        return this.mItem.projectDatetime;
    }

    @Override // cn.damai.commonbusiness.discover.bean.IFeedProjectBean
    public String getProjectName() {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "-1475045850") ? (String) ipChange.ipc$dispatch("-1475045850", new Object[]{this}) : this.mItem.projectName;
    }

    @Override // cn.damai.commonbusiness.discover.bean.IFeedProjectBean
    public String getRankText() {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "188174605") ? (String) ipChange.ipc$dispatch("188174605", new Object[]{this}) : this.mItem.title;
    }

    @Override // cn.damai.commonbusiness.discover.bean.IFeedProjectBean
    public double getScoreStar() {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "-1916820184") ? ((Double) ipChange.ipc$dispatch("-1916820184", new Object[]{this})).doubleValue() : this.mItem.itemScore;
    }

    @Override // cn.damai.commonbusiness.discover.bean.IFeedProjectBean
    public String getShowPrice() {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "1138316014") ? (String) ipChange.ipc$dispatch("1138316014", new Object[]{this}) : this.mItem.priceLow;
    }

    @Override // cn.damai.commonbusiness.discover.bean.IFeedProjectBean
    public List<TagBean> getTagList() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1214498273")) {
            return (List) ipChange.ipc$dispatch("1214498273", new Object[]{this});
        }
        if (this.tagList == null) {
            this.tagList = new ArrayList();
            WaterFlowRecommendItem waterFlowRecommendItem = this.mItem;
            String str = waterFlowRecommendItem.tagType;
            String str2 = waterFlowRecommendItem.tag;
            if (!TextUtils.isEmpty(str2) && !TextUtils.isEmpty(str)) {
                if (TextUtils.equals("1", str)) {
                    this.tagList.add(new TagBean(str2, Color.parseColor("#FF2869")));
                } else if (TextUtils.equals("2", str)) {
                    this.tagList.add(new TagBean(str2, Color.parseColor("#FF2869")));
                } else if (TextUtils.equals("4", str)) {
                    this.tagList.add(new TagBean(str2, Color.parseColor("#30AEFF")));
                } else if (TextUtils.equals("5", str)) {
                    this.tagList.add(new TagBean(str2, Color.parseColor("#FF993A")));
                }
            }
            if (!TextUtils.isEmpty(this.mItem.categoryName)) {
                this.tagList.add(new TagBean(this.mItem.categoryName, Color.parseColor("#9C9CA5")));
            }
        }
        return this.tagList;
    }

    @Override // cn.damai.commonbusiness.discover.bean.IFeedProjectBean
    public boolean isPendingPrice() {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "150400720") ? ((Boolean) ipChange.ipc$dispatch("150400720", new Object[]{this})).booleanValue() : TextUtils.isEmpty(this.mItem.priceLow) || this.mItem.priceLow.contains("待定");
    }

    @Override // cn.damai.commonbusiness.discover.bean.IFeedProjectBean
    public boolean isShowVideoIcon() {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "1545720217") ? ((Boolean) ipChange.ipc$dispatch("1545720217", new Object[]{this})).booleanValue() : this.mItem.hasVideo;
    }

    @Override // cn.damai.commonbusiness.discover.bean.IFeedProjectBean
    public boolean isShowWannaSeeTag() {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "-704575697") ? ((Boolean) ipChange.ipc$dispatch("-704575697", new Object[]{this})).booleanValue() : TextUtils.equals("3", this.mItem.tagType);
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // cn.damai.commonbusiness.discover.bean.IFeedProjectBean
    public WaterFlowRecommendItem getRaw() {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "1301042948") ? (WaterFlowRecommendItem) ipChange.ipc$dispatch("1301042948", new Object[]{this}) : this.mItem;
    }
}
