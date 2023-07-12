package cn.damai.commonbusiness.wannasee.listener;

import cn.damai.common.bean.RankBean;
import cn.damai.commonbusiness.search.bean.ProjectItemBean;
import cn.damai.commonbusiness.wannasee.bean.RecommendProjects;
import cn.damai.tetris.component.discover.bean.NoteBean;
import cn.damai.tetris.component.discover.bean.ThemeBean;

/* compiled from: Taobao */
/* loaded from: classes.dex */
public interface OnMultiListClickListener {
    void onNoteClick(NoteBean noteBean, int i);

    void onNoteShareClick(NoteBean noteBean, int i);

    void onProjectClick(ProjectItemBean projectItemBean, int i);

    void onRankClick(RankBean rankBean, int i);

    void onRecommendClick(RecommendProjects recommendProjects, int i);

    void onRecommendFollowClick(RecommendProjects recommendProjects, int i);

    void onRecommendFollowSuccessClick(RecommendProjects recommendProjects, int i);

    void onRecommendRefreshClick(RecommendProjects recommendProjects, int i);

    void onThemeClick(ThemeBean themeBean, int i);
}
