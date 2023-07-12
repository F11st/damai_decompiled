package tb;

import cn.damai.common.bean.RankBean;
import cn.damai.commonbusiness.search.bean.ProjectItemBean;
import cn.damai.commonbusiness.wannasee.bean.RecommendProjects;
import cn.damai.commonbusiness.wannasee.listener.MultiClickUt;
import cn.damai.tetris.component.discover.bean.NoteBean;
import cn.damai.tetris.component.discover.bean.ThemeBean;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;

/* compiled from: Taobao */
/* loaded from: classes.dex */
public class x3 implements MultiClickUt {
    private static transient /* synthetic */ IpChange $ipChange;

    @Override // cn.damai.commonbusiness.wannasee.listener.MultiClickUt
    public void utNoteEditClick(NoteBean noteBean, int i) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1546347118")) {
            ipChange.ipc$dispatch("1546347118", new Object[]{this, noteBean, Integer.valueOf(i)});
        }
    }

    @Override // cn.damai.commonbusiness.wannasee.listener.MultiClickUt
    public void utProjectClick(ProjectItemBean projectItemBean, int i) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "305655262")) {
            ipChange.ipc$dispatch("305655262", new Object[]{this, projectItemBean, Integer.valueOf(i)});
        }
    }

    @Override // cn.damai.commonbusiness.wannasee.listener.MultiClickUt
    public void utRankClick(RankBean rankBean, int i) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1443605586")) {
            ipChange.ipc$dispatch("1443605586", new Object[]{this, rankBean, Integer.valueOf(i)});
        }
    }

    @Override // cn.damai.commonbusiness.wannasee.listener.MultiClickUt
    public void utRecommendClick(RecommendProjects recommendProjects, int i) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-675290361")) {
            ipChange.ipc$dispatch("-675290361", new Object[]{this, recommendProjects, Integer.valueOf(i)});
        }
    }

    @Override // cn.damai.commonbusiness.wannasee.listener.MultiClickUt
    public void utRecommendFollowClick(RecommendProjects recommendProjects, int i) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-202527400")) {
            ipChange.ipc$dispatch("-202527400", new Object[]{this, recommendProjects, Integer.valueOf(i)});
        }
    }

    @Override // cn.damai.commonbusiness.wannasee.listener.MultiClickUt
    public void utRecommendRefreshClick(RecommendProjects recommendProjects, int i) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1839295924")) {
            ipChange.ipc$dispatch("1839295924", new Object[]{this, recommendProjects, Integer.valueOf(i)});
        }
    }

    @Override // cn.damai.commonbusiness.wannasee.listener.MultiClickUt
    public void utThemeClick(ThemeBean themeBean, int i) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1760818426")) {
            ipChange.ipc$dispatch("-1760818426", new Object[]{this, themeBean, Integer.valueOf(i)});
        }
    }
}
