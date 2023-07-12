package tb;

import android.app.Activity;
import android.os.Bundle;
import cn.damai.category.ranking.ui.RankListFragment;
import cn.damai.common.bean.RankBean;
import cn.damai.common.nav.DMNav;
import cn.damai.common.nav.NavUri;
import cn.damai.commonbusiness.search.bean.ProjectItemBean;
import cn.damai.commonbusiness.wannasee.bean.RecommendProjects;
import cn.damai.commonbusiness.wannasee.listener.MultiClickUt;
import cn.damai.commonbusiness.wannasee.listener.OnMultiListClickListener;
import cn.damai.issue.tool.IssueConstants;
import cn.damai.tetris.component.discover.bean.NoteBean;
import cn.damai.tetris.component.discover.bean.ThemeBean;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;

/* compiled from: Taobao */
/* loaded from: classes.dex */
public class v3 implements MultiClickUt, OnMultiListClickListener {
    private static transient /* synthetic */ IpChange $ipChange;
    private Activity a;
    private MultiClickUt b;

    public v3(Activity activity, MultiClickUt multiClickUt) {
        this.a = activity;
        this.b = multiClickUt;
    }

    private boolean a() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1224145619")) {
            return ((Boolean) ipChange.ipc$dispatch("-1224145619", new Object[]{this})).booleanValue();
        }
        Activity activity = this.a;
        return (activity == null || activity.isFinishing()) ? false : true;
    }

    public static void b(Activity activity, ProjectItemBean projectItemBean) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "410694118")) {
            ipChange.ipc$dispatch("410694118", new Object[]{activity, projectItemBean});
        } else if (activity == null || activity.isFinishing() || projectItemBean == null) {
        } else {
            Bundle bundle = new Bundle();
            bundle.putString(IssueConstants.ProjectID, projectItemBean.id);
            bundle.putString("projectName", projectItemBean.name);
            bundle.putString("projectImage", projectItemBean.verticalPic);
            qd2.a(activity, projectItemBean.schema, bundle);
        }
    }

    @Override // cn.damai.commonbusiness.wannasee.listener.OnMultiListClickListener
    public void onNoteClick(NoteBean noteBean, int i) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "865338791")) {
            ipChange.ipc$dispatch("865338791", new Object[]{this, noteBean, Integer.valueOf(i)});
        } else if (!a() || noteBean == null) {
        } else {
            utNoteClick(noteBean, i);
            Bundle bundle = new Bundle();
            bundle.putString("contentId", noteBean.id);
            bundle.putFloat("picWhRatio", noteBean.localPicWhRatio);
            DMNav.from(this.a).withExtras(bundle).toUri(NavUri.b(cs.DISCOVER_CONTENT_DETAIL));
        }
    }

    @Override // cn.damai.commonbusiness.wannasee.listener.OnMultiListClickListener
    public void onNoteShareClick(NoteBean noteBean, int i) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-281156520")) {
            ipChange.ipc$dispatch("-281156520", new Object[]{this, noteBean, Integer.valueOf(i)});
        } else if (!a() || noteBean == null) {
        } else {
            utNoteEditClick(noteBean, i);
            Bundle bundle = new Bundle();
            if (noteBean.relatedInfo != null) {
                bundle.putString("themeId", "0");
                bundle.putString(g41.ISSUE_PARAM_LIVE_THEME_NAME, noteBean.relatedInfo.value);
            }
            if (noteBean.extraRelatedInfo != null) {
                bundle.putString("circleId", "0");
                bundle.putString("circleName", noteBean.extraRelatedInfo.value);
            }
            bundle.putString(g41.ISSUE_TYPE, g41.ISSUE_TYPE_EDIT);
            bundle.putString(g41.ISSUE_PARAM_COMMENT_ID, noteBean.sourceId);
            DMNav.from(this.a).withExtras(bundle).forResult(2020).toUri(NavUri.b("issue"));
        }
    }

    @Override // cn.damai.commonbusiness.wannasee.listener.OnMultiListClickListener
    public void onProjectClick(ProjectItemBean projectItemBean, int i) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "584009965")) {
            ipChange.ipc$dispatch("584009965", new Object[]{this, projectItemBean, Integer.valueOf(i)});
        } else if (!a() || projectItemBean == null) {
        } else {
            utProjectClick(projectItemBean, i);
            b(this.a, projectItemBean);
        }
    }

    @Override // cn.damai.commonbusiness.wannasee.listener.OnMultiListClickListener
    public void onRankClick(RankBean rankBean, int i) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1215424925")) {
            ipChange.ipc$dispatch("-1215424925", new Object[]{this, rankBean, Integer.valueOf(i)});
        } else if (!a() || rankBean == null) {
        } else {
            utRankClick(rankBean, i);
            if (rankBean.isRankListType()) {
                Bundle bundle = new Bundle();
                bundle.putString(RankListFragment.KEY_RANK_ID, rankBean.id);
                DMNav.from(this.a).withExtras(bundle).toUri(NavUri.b("ranking"));
            } else if (rankBean.isMaiListType()) {
                Bundle bundle2 = new Bundle();
                bundle2.putString("id", rankBean.id);
                DMNav.from(this.a).withExtras(bundle2).toUri(NavUri.b("detailed_list"));
            }
        }
    }

    @Override // cn.damai.commonbusiness.wannasee.listener.OnMultiListClickListener
    public void onRecommendClick(RecommendProjects recommendProjects, int i) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-878414122")) {
            ipChange.ipc$dispatch("-878414122", new Object[]{this, recommendProjects, Integer.valueOf(i)});
        } else if (!a() || recommendProjects == null) {
        } else {
            utRecommendClick(recommendProjects, i);
        }
    }

    @Override // cn.damai.commonbusiness.wannasee.listener.OnMultiListClickListener
    public void onRecommendFollowClick(RecommendProjects recommendProjects, int i) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1728178663")) {
            ipChange.ipc$dispatch("1728178663", new Object[]{this, recommendProjects, Integer.valueOf(i)});
        } else if (!a() || recommendProjects == null) {
        } else {
            utRecommendFollowClick(recommendProjects, i);
        }
    }

    public void onRecommendFollowSuccessClick(RecommendProjects recommendProjects, int i) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "445820412")) {
            ipChange.ipc$dispatch("445820412", new Object[]{this, recommendProjects, Integer.valueOf(i)});
        }
    }

    @Override // cn.damai.commonbusiness.wannasee.listener.OnMultiListClickListener
    public void onRecommendRefreshClick(RecommendProjects recommendProjects, int i) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1561641733")) {
            ipChange.ipc$dispatch("1561641733", new Object[]{this, recommendProjects, Integer.valueOf(i)});
        } else if (!a() || recommendProjects == null) {
        } else {
            utRecommendRefreshClick(recommendProjects, i);
        }
    }

    @Override // cn.damai.commonbusiness.wannasee.listener.OnMultiListClickListener
    public void onThemeClick(ThemeBean themeBean, int i) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-386841195")) {
            ipChange.ipc$dispatch("-386841195", new Object[]{this, themeBean, Integer.valueOf(i)});
        } else if (!a() || themeBean == null) {
        } else {
            utThemeClick(themeBean, i);
            new Bundle().putString("themeId", themeBean.id);
            DMNav.from(this.a).toUri(NavUri.b(cs.DISCOVER_THEME));
        }
    }

    @Override // cn.damai.commonbusiness.wannasee.listener.MultiClickUt
    public void utNoteClick(NoteBean noteBean, int i) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-61412121")) {
            ipChange.ipc$dispatch("-61412121", new Object[]{this, noteBean, Integer.valueOf(i)});
            return;
        }
        MultiClickUt multiClickUt = this.b;
        if (multiClickUt != null) {
            multiClickUt.utNoteClick(noteBean, i);
        }
    }

    @Override // cn.damai.commonbusiness.wannasee.listener.MultiClickUt
    public void utNoteEditClick(NoteBean noteBean, int i) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "472480893")) {
            ipChange.ipc$dispatch("472480893", new Object[]{this, noteBean, Integer.valueOf(i)});
            return;
        }
        MultiClickUt multiClickUt = this.b;
        if (multiClickUt != null) {
            multiClickUt.utNoteEditClick(noteBean, i);
        }
    }

    @Override // cn.damai.commonbusiness.wannasee.listener.MultiClickUt
    public void utProjectClick(ProjectItemBean projectItemBean, int i) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-887635923")) {
            ipChange.ipc$dispatch("-887635923", new Object[]{this, projectItemBean, Integer.valueOf(i)});
            return;
        }
        MultiClickUt multiClickUt = this.b;
        if (multiClickUt != null) {
            multiClickUt.utProjectClick(projectItemBean, i);
        }
    }

    @Override // cn.damai.commonbusiness.wannasee.listener.MultiClickUt
    public void utRankClick(RankBean rankBean, int i) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1340082397")) {
            ipChange.ipc$dispatch("-1340082397", new Object[]{this, rankBean, Integer.valueOf(i)});
            return;
        }
        MultiClickUt multiClickUt = this.b;
        if (multiClickUt != null) {
            multiClickUt.utRankClick(rankBean, i);
        }
    }

    @Override // cn.damai.commonbusiness.wannasee.listener.MultiClickUt
    public void utRecommendClick(RecommendProjects recommendProjects, int i) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1560706582")) {
            ipChange.ipc$dispatch("1560706582", new Object[]{this, recommendProjects, Integer.valueOf(i)});
            return;
        }
        MultiClickUt multiClickUt = this.b;
        if (multiClickUt != null) {
            multiClickUt.utRecommendClick(recommendProjects, i);
        }
    }

    @Override // cn.damai.commonbusiness.wannasee.listener.MultiClickUt
    public void utRecommendFollowClick(RecommendProjects recommendProjects, int i) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1813086503")) {
            ipChange.ipc$dispatch("1813086503", new Object[]{this, recommendProjects, Integer.valueOf(i)});
            return;
        }
        MultiClickUt multiClickUt = this.b;
        if (multiClickUt != null) {
            multiClickUt.utRecommendFollowClick(recommendProjects, i);
        }
    }

    @Override // cn.damai.commonbusiness.wannasee.listener.MultiClickUt
    public void utRecommendRefreshClick(RecommendProjects recommendProjects, int i) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-101182523")) {
            ipChange.ipc$dispatch("-101182523", new Object[]{this, recommendProjects, Integer.valueOf(i)});
            return;
        }
        MultiClickUt multiClickUt = this.b;
        if (multiClickUt != null) {
            multiClickUt.utRecommendRefreshClick(recommendProjects, i);
        }
    }

    @Override // cn.damai.commonbusiness.wannasee.listener.MultiClickUt
    public void utThemeClick(ThemeBean themeBean, int i) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1936237355")) {
            ipChange.ipc$dispatch("-1936237355", new Object[]{this, themeBean, Integer.valueOf(i)});
            return;
        }
        MultiClickUt multiClickUt = this.b;
        if (multiClickUt != null) {
            multiClickUt.utThemeClick(themeBean, i);
        }
    }
}
