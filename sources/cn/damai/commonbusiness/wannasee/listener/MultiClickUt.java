package cn.damai.commonbusiness.wannasee.listener;

import cn.damai.common.bean.RankBean;
import cn.damai.commonbusiness.search.bean.ProjectItemBean;
import cn.damai.commonbusiness.wannasee.bean.RecommendProjects;
import cn.damai.tetris.component.discover.bean.NoteBean;
import cn.damai.tetris.component.discover.bean.ThemeBean;

/* compiled from: Taobao */
/* loaded from: classes.dex */
public interface MultiClickUt {
    void utNoteClick(NoteBean noteBean, int i);

    void utNoteEditClick(NoteBean noteBean, int i);

    void utProjectClick(ProjectItemBean projectItemBean, int i);

    void utRankClick(RankBean rankBean, int i);

    void utRecommendClick(RecommendProjects recommendProjects, int i);

    void utRecommendFollowClick(RecommendProjects recommendProjects, int i);

    void utRecommendRefreshClick(RecommendProjects recommendProjects, int i);

    void utThemeClick(ThemeBean themeBean, int i);
}
