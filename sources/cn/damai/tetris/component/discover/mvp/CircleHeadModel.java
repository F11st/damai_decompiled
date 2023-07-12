package cn.damai.tetris.component.discover.mvp;

import cn.damai.commonbusiness.discover.bean.CircleStyle;
import cn.damai.commonbusiness.discover.bean.ThemeBean;
import cn.damai.commonbusiness.discover.bean.ThemeHeadResult;
import cn.damai.commonbusiness.discover.bean.ThemeShareBean;
import cn.damai.commonbusiness.search.bean.ProjectItemBean;
import cn.damai.discover.main.ui.bean.ThemeRankBean;
import cn.damai.tetris.component.discover.mvp.CircleHeadContract;
import cn.damai.tetris.core.AbsModel;
import cn.damai.tetris.core.BaseNode;
import com.alibaba.fastjson.JSON;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import java.util.List;

/* compiled from: Taobao */
/* loaded from: classes7.dex */
public class CircleHeadModel extends AbsModel implements CircleHeadContract.Model {
    private static transient /* synthetic */ IpChange $ipChange;
    public ThemeRankBean activity;
    public List<ProjectItemBean> projectDOS;
    public ThemeShareBean share;
    public ThemeBean theme;

    @Override // cn.damai.tetris.component.discover.mvp.CircleHeadContract.Model
    public String getBackImage() {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "-561005935") ? (String) ipChange.ipc$dispatch("-561005935", new Object[]{this}) : this.theme.backgroundImg;
    }

    @Override // cn.damai.tetris.component.discover.mvp.CircleHeadContract.Model
    public String getBannerPic() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1032454245")) {
            return (String) ipChange.ipc$dispatch("-1032454245", new Object[]{this});
        }
        ThemeRankBean themeRankBean = this.activity;
        return themeRankBean != null ? themeRankBean.bannerPic : "";
    }

    @Override // cn.damai.tetris.component.discover.mvp.CircleHeadContract.Model
    public String getBannerUrl() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1635921664")) {
            return (String) ipChange.ipc$dispatch("1635921664", new Object[]{this});
        }
        ThemeRankBean themeRankBean = this.activity;
        return themeRankBean != null ? themeRankBean.bannerUrl : "";
    }

    @Override // cn.damai.tetris.component.discover.mvp.CircleHeadContract.Model
    public String getEndColor() {
        CircleStyle circleStyle;
        List<String> list;
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "2021932225")) {
            return (String) ipChange.ipc$dispatch("2021932225", new Object[]{this});
        }
        ThemeBean themeBean = this.theme;
        return (themeBean == null || (circleStyle = themeBean.colorGroup) == null || (list = circleStyle.colors) == null || list.size() <= 1) ? "#AAC4FF" : this.theme.colorGroup.colors.get(1);
    }

    @Override // cn.damai.tetris.component.discover.mvp.CircleHeadContract.Model
    public List<ProjectItemBean> getProjectList() {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "1653755867") ? (List) ipChange.ipc$dispatch("1653755867", new Object[]{this}) : this.projectDOS;
    }

    @Override // cn.damai.tetris.component.discover.mvp.CircleHeadContract.Model
    public ThemeRankBean getRank() {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "1564285620") ? (ThemeRankBean) ipChange.ipc$dispatch("1564285620", new Object[]{this}) : this.activity;
    }

    @Override // cn.damai.tetris.component.discover.mvp.CircleHeadContract.Model
    public ThemeShareBean getShare() {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "-1318320743") ? (ThemeShareBean) ipChange.ipc$dispatch("-1318320743", new Object[]{this}) : this.share;
    }

    @Override // cn.damai.tetris.component.discover.mvp.CircleHeadContract.Model
    public String getStartColor() {
        CircleStyle circleStyle;
        List<String> list;
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-451476582")) {
            return (String) ipChange.ipc$dispatch("-451476582", new Object[]{this});
        }
        ThemeBean themeBean = this.theme;
        return (themeBean == null || (circleStyle = themeBean.colorGroup) == null || (list = circleStyle.colors) == null || list.size() <= 0) ? "#8F8FFF" : this.theme.colorGroup.colors.get(0);
    }

    @Override // cn.damai.tetris.component.discover.mvp.CircleHeadContract.Model
    public ThemeBean getThemeBean() {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "-2118947772") ? (ThemeBean) ipChange.ipc$dispatch("-2118947772", new Object[]{this}) : this.theme;
    }

    @Override // cn.damai.tetris.core.AbsModel
    public void parseModel(BaseNode baseNode) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "2089590210")) {
            ipChange.ipc$dispatch("2089590210", new Object[]{this, baseNode});
            return;
        }
        try {
            ThemeHeadResult themeHeadResult = (ThemeHeadResult) JSON.parseObject(baseNode.getItem().toJSONString(), ThemeHeadResult.class);
            this.share = themeHeadResult.share;
            this.theme = themeHeadResult.theme;
            this.projectDOS = themeHeadResult.projectDOS;
            this.activity = themeHeadResult.activity;
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
