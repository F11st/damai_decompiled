package cn.damai.tetris.component.discover.mvp;

import android.view.ViewStub;
import android.widget.ImageView;
import android.widget.TextView;
import cn.damai.commonbusiness.discover.bean.ThemeBean;
import cn.damai.commonbusiness.discover.bean.ThemeShareBean;
import cn.damai.commonbusiness.search.bean.ProjectItemBean;
import cn.damai.commonbusiness.view.UserAvatarOverlayListLayout;
import cn.damai.discover.main.ui.adapter.CircleRankPanel;
import cn.damai.discover.main.ui.bean.RankUserBean;
import cn.damai.discover.main.ui.bean.ThemeRankBean;
import cn.damai.discover.main.ui.view.DMThemeProjectItemView;
import cn.damai.tetris.core.BaseNode;
import cn.damai.tetris.core.IModel;
import cn.damai.tetris.core.IPresenter;
import cn.damai.tetris.core.IView;
import cn.damai.uikit.banner.sub.RoundRadiusImageView;
import cn.damai.uikit.iconfont.DMIconFontTextView;
import cn.damai.uikit.view.NewSimpleTitleLayout;
import java.util.List;

/* compiled from: Taobao */
/* loaded from: classes16.dex */
public interface CircleHeadContract {

    /* compiled from: Taobao */
    /* loaded from: classes7.dex */
    public interface Model<D extends BaseNode> extends IModel {
        String getBackImage();

        String getBannerPic();

        String getBannerUrl();

        String getEndColor();

        List<ProjectItemBean> getProjectList();

        ThemeRankBean getRank();

        ThemeShareBean getShare();

        String getStartColor();

        ThemeBean getThemeBean();
    }

    /* compiled from: Taobao */
    /* loaded from: classes7.dex */
    public interface Presenter<M extends IModel, V extends View, N extends BaseNode> extends IPresenter<M, V, N> {
        void clickPoj(ProjectItemBean projectItemBean, int i);

        void clickPojMore(List<ProjectItemBean> list);

        void clickVote(RankUserBean rankUserBean, int i);

        void exposePoj(android.view.View view, ProjectItemBean projectItemBean, int i);

        void exposeVote(android.view.View view, int i);
    }

    /* compiled from: Taobao */
    /* loaded from: classes7.dex */
    public interface View<P extends Presenter> extends IView<P> {
        ImageView getBannerImg();

        android.view.View getBannerUi();

        ImageView getBgImage();

        RoundRadiusImageView getCircleHeadImage();

        DMIconFontTextView getJoinIcon();

        DMThemeProjectItemView getProjectUi();

        ViewStub getRankStub();

        CircleRankPanel getRankView();

        TextView getThemeDesc();

        TextView getThemeJoinBtn();

        TextView getThemeJoinNum();

        TextView getThemeName();

        NewSimpleTitleLayout getTitleLayout();

        UserAvatarOverlayListLayout getUserOverlay();
    }
}
