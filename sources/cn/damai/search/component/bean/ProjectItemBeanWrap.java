package cn.damai.search.component.bean;

import android.graphics.Color;
import android.text.TextUtils;
import cn.damai.commonbusiness.discover.bean.IFeedProjectBean;
import cn.damai.commonbusiness.discover.bean.TagBean;
import cn.damai.commonbusiness.search.bean.ProjectItemBean;
import cn.damai.login.LoginManager;
import com.alibaba.pictures.bricks.component.project.bean.RankingListBean;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import tb.jm1;

/* compiled from: Taobao */
/* loaded from: classes6.dex */
public class ProjectItemBeanWrap implements IFeedProjectBean<ProjectItemBean>, Serializable {
    private static transient /* synthetic */ IpChange $ipChange;
    public final ProjectItemBean mBean;
    private List<TagBean> tags;

    public ProjectItemBeanWrap(ProjectItemBean projectItemBean) {
        this.mBean = projectItemBean;
    }

    @Override // cn.damai.commonbusiness.discover.bean.IFeedProjectBean
    public String getAtmospheric() {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "1235797037") ? (String) ipChange.ipc$dispatch("1235797037", new Object[]{this}) : this.mBean.atmosphericPic;
    }

    @Override // cn.damai.commonbusiness.discover.bean.IFeedProjectBean
    public int getLiveStatus() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-80097073")) {
            return ((Integer) ipChange.ipc$dispatch("-80097073", new Object[]{this})).intValue();
        }
        if (TextUtils.isEmpty(this.mBean.liveStatus)) {
            return 0;
        }
        return jm1.j(this.mBean.liveStatus, 0);
    }

    @Override // cn.damai.commonbusiness.discover.bean.IFeedProjectBean
    public String getPostPic() {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "-996955398") ? (String) ipChange.ipc$dispatch("-996955398", new Object[]{this}) : this.mBean.verticalPic;
    }

    @Override // cn.damai.commonbusiness.discover.bean.IFeedProjectBean
    public String getProjectDate() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1883529833")) {
            return (String) ipChange.ipc$dispatch("-1883529833", new Object[]{this});
        }
        if (TextUtils.isEmpty(this.mBean.liveStartTime)) {
            return TextUtils.isEmpty(this.mBean.showTime) ? "时间待定" : this.mBean.showTime;
        }
        return this.mBean.liveStartTime;
    }

    @Override // cn.damai.commonbusiness.discover.bean.IFeedProjectBean
    public String getProjectName() {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "-1172105228") ? (String) ipChange.ipc$dispatch("-1172105228", new Object[]{this}) : this.mBean.name;
    }

    @Override // cn.damai.commonbusiness.discover.bean.IFeedProjectBean
    public String getRankText() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-781790721")) {
            return (String) ipChange.ipc$dispatch("-781790721", new Object[]{this});
        }
        if (!TextUtils.isEmpty(this.mBean.showTag)) {
            return this.mBean.showTag;
        }
        ProjectItemBean projectItemBean = this.mBean;
        RankingListBean rankingListBean = projectItemBean.rankingList;
        if (rankingListBean != null) {
            return rankingListBean.title;
        }
        if (TextUtils.isEmpty(projectItemBean.actores)) {
            return null;
        }
        return this.mBean.actores;
    }

    @Override // cn.damai.commonbusiness.discover.bean.IFeedProjectBean
    public double getScoreStar() {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "1730365978") ? ((Double) ipChange.ipc$dispatch("1730365978", new Object[]{this})).doubleValue() : this.mBean.itemScore;
    }

    @Override // cn.damai.commonbusiness.discover.bean.IFeedProjectBean
    public String getShowPrice() {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "1134161980") ? (String) ipChange.ipc$dispatch("1134161980", new Object[]{this}) : this.mBean.priceLow;
    }

    @Override // cn.damai.commonbusiness.discover.bean.IFeedProjectBean
    public List<TagBean> getTagList() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1598866897")) {
            return (List) ipChange.ipc$dispatch("-1598866897", new Object[]{this});
        }
        List<TagBean> list = this.tags;
        if (list != null) {
            return list;
        }
        if (!TextUtils.isEmpty(this.mBean.getCategoryNameCompat())) {
            ArrayList arrayList = new ArrayList();
            this.tags = arrayList;
            arrayList.add(new TagBean(this.mBean.getCategoryNameCompat(), Color.parseColor("#9C9CA5")));
        }
        return this.tags;
    }

    @Override // cn.damai.commonbusiness.discover.bean.IFeedProjectBean
    public boolean isPendingPrice() {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "402988866") ? ((Boolean) ipChange.ipc$dispatch("402988866", new Object[]{this})).booleanValue() : TextUtils.isEmpty(this.mBean.priceLow) || this.mBean.priceLow.contains("待定");
    }

    @Override // cn.damai.commonbusiness.discover.bean.IFeedProjectBean
    public boolean isShowVideoIcon() {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "786018151") ? ((Boolean) ipChange.ipc$dispatch("786018151", new Object[]{this})).booleanValue() : this.mBean.hasVideo();
    }

    @Override // cn.damai.commonbusiness.discover.bean.IFeedProjectBean
    public boolean isShowWannaSeeTag() {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "-633820803") ? ((Boolean) ipChange.ipc$dispatch("-633820803", new Object[]{this})).booleanValue() : this.mBean.isFollowStatus() && LoginManager.k().q();
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // cn.damai.commonbusiness.discover.bean.IFeedProjectBean
    public ProjectItemBean getRaw() {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "860887230") ? (ProjectItemBean) ipChange.ipc$dispatch("860887230", new Object[]{this}) : this.mBean;
    }
}
