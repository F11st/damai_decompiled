package cn.damai.tetris.component.discover.mvp;

import android.content.Context;
import android.view.View;
import android.view.ViewStub;
import android.widget.ImageView;
import android.widget.TextView;
import cn.damai.commonbusiness.R$id;
import cn.damai.commonbusiness.dynamicx.customwidget.temp.DMUpMarqueeView;
import cn.damai.commonbusiness.search.bean.ProjectItemBean;
import cn.damai.commonbusiness.view.UserAvatarOverlayListLayout;
import cn.damai.discover.main.ui.adapter.CircleRankPanel;
import cn.damai.discover.main.ui.bean.RankUserBean;
import cn.damai.discover.main.ui.view.DMThemeProjectItemView;
import cn.damai.tetris.component.discover.mvp.CircleHeadContract;
import cn.damai.tetris.component.drama.viewholder.OnItemBindListener;
import cn.damai.tetris.core.AbsView;
import cn.damai.uikit.banner.sub.RoundRadiusImageView;
import cn.damai.uikit.iconfont.DMIconFontTextView;
import cn.damai.uikit.view.NewSimpleTitleLayout;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import java.util.ArrayList;
import java.util.List;

/* compiled from: Taobao */
/* loaded from: classes7.dex */
public class CircleHeadView extends AbsView<CircleHeadContract.Presenter> implements CircleHeadContract.View<CircleHeadContract.Presenter> {
    private static transient /* synthetic */ IpChange $ipChange;
    ImageView bgImage;
    RoundRadiusImageView circleHeadImage;
    DMIconFontTextView joinIcon;
    private ImageView mBannerImg;
    private View mBannerUi;
    private Context mContext;
    DMThemeProjectItemView mProjectRevUi;
    CircleRankPanel mRankPanel;
    ViewStub mRankStub;
    TextView themeDesc;
    TextView themeJoinBtn;
    TextView themeJoinNum;
    TextView themeName;
    NewSimpleTitleLayout titleLayout;
    UserAvatarOverlayListLayout userOverlay;

    /* compiled from: Taobao */
    /* renamed from: cn.damai.tetris.component.discover.mvp.CircleHeadView$a */
    /* loaded from: classes7.dex */
    public class C1812a implements DMUpMarqueeView.OnItemClickListener {
        private static transient /* synthetic */ IpChange $ipChange;

        C1812a() {
        }

        @Override // cn.damai.commonbusiness.dynamicx.customwidget.temp.DMUpMarqueeView.OnItemClickListener
        public void onItemClick(int i, View view) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "-880786173")) {
                ipChange.ipc$dispatch("-880786173", new Object[]{this, Integer.valueOf(i), view});
            } else {
                CircleHeadView.this.getPresenter().clickPoj((ProjectItemBean) view.getTag(), i);
            }
        }
    }

    /* compiled from: Taobao */
    /* renamed from: cn.damai.tetris.component.discover.mvp.CircleHeadView$b */
    /* loaded from: classes7.dex */
    public class C1813b implements DMThemeProjectItemView.ProjectLabelClickListener {
        private static transient /* synthetic */ IpChange $ipChange;

        C1813b() {
        }

        @Override // cn.damai.discover.main.ui.view.DMThemeProjectItemView.ProjectLabelClickListener
        public void onClick(int i, ProjectItemBean projectItemBean, List<ProjectItemBean> list) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "1478085908")) {
                ipChange.ipc$dispatch("1478085908", new Object[]{this, Integer.valueOf(i), projectItemBean, list});
            } else if (1 == i) {
                CircleHeadView.this.getPresenter().clickPoj(projectItemBean, i);
            } else {
                CircleHeadView.this.getPresenter().clickPojMore((ArrayList) list);
            }
        }
    }

    /* compiled from: Taobao */
    /* renamed from: cn.damai.tetris.component.discover.mvp.CircleHeadView$c */
    /* loaded from: classes7.dex */
    public class C1814c implements DMThemeProjectItemView.ExposureCallBack {
        private static transient /* synthetic */ IpChange $ipChange;

        C1814c() {
        }

        @Override // cn.damai.discover.main.ui.view.DMThemeProjectItemView.ExposureCallBack
        public void exposure(View view, int i) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "-780703444")) {
                ipChange.ipc$dispatch("-780703444", new Object[]{this, view, Integer.valueOf(i)});
            } else {
                CircleHeadView.this.getPresenter().exposePoj(view, (ProjectItemBean) view.getTag(), i);
            }
        }
    }

    /* compiled from: Taobao */
    /* renamed from: cn.damai.tetris.component.discover.mvp.CircleHeadView$d */
    /* loaded from: classes7.dex */
    public class C1815d implements OnItemBindListener<RankUserBean> {
        private static transient /* synthetic */ IpChange $ipChange;

        C1815d() {
        }

        @Override // cn.damai.tetris.component.drama.viewholder.OnItemBindListener
        /* renamed from: a */
        public void exposeItem(View view, RankUserBean rankUserBean, int i) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "1396224574")) {
                ipChange.ipc$dispatch("1396224574", new Object[]{this, view, rankUserBean, Integer.valueOf(i)});
            } else {
                CircleHeadView.this.getPresenter().exposeVote(view, i);
            }
        }

        @Override // cn.damai.tetris.component.drama.viewholder.OnItemClickListener
        /* renamed from: b */
        public void onItemClick(RankUserBean rankUserBean, int i) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "1144802089")) {
                ipChange.ipc$dispatch("1144802089", new Object[]{this, rankUserBean, Integer.valueOf(i)});
            } else {
                CircleHeadView.this.getPresenter().clickVote(rankUserBean, i);
            }
        }
    }

    public CircleHeadView(View view) {
        super(view);
        this.mContext = view.getContext();
        this.titleLayout = (NewSimpleTitleLayout) view.findViewById(R$id.theme_circle_title_cms_bar);
        this.bgImage = (ImageView) view.findViewById(R$id.theme_circle_bg_image);
        this.circleHeadImage = (RoundRadiusImageView) view.findViewById(R$id.iv_circle_head);
        this.themeName = (TextView) view.findViewById(R$id.theme_circle_name);
        this.userOverlay = (UserAvatarOverlayListLayout) view.findViewById(R$id.circle_avatar_list_layout);
        this.themeJoinNum = (TextView) view.findViewById(R$id.theme_circle_person_info);
        this.themeDesc = (TextView) view.findViewById(R$id.theme_circle_desc_v2);
        this.themeJoinBtn = (TextView) view.findViewById(R$id.theme_circle_join);
        this.joinIcon = (DMIconFontTextView) view.findViewById(R$id.theme_circle_join_icon);
        DMThemeProjectItemView dMThemeProjectItemView = (DMThemeProjectItemView) view.findViewById(R$id.theme_project_ui);
        this.mProjectRevUi = dMThemeProjectItemView;
        dMThemeProjectItemView.setProjectOnClick(new C1812a());
        this.mProjectRevUi.setProjectLabelOnClick(new C1813b());
        this.mProjectRevUi.setExposureCallBack(new C1814c());
        ViewStub viewStub = (ViewStub) view.findViewById(R$id.theme_rank_view_stub);
        this.mRankStub = viewStub;
        this.mRankPanel = new CircleRankPanel(this.mContext, viewStub, new C1815d());
        this.mBannerUi = view.findViewById(R$id.theme_image_ui);
        this.mBannerImg = (ImageView) view.findViewById(R$id.theme_banner_img);
    }

    @Override // cn.damai.tetris.component.discover.mvp.CircleHeadContract.View
    public ImageView getBannerImg() {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "-370242082") ? (ImageView) ipChange.ipc$dispatch("-370242082", new Object[]{this}) : this.mBannerImg;
    }

    @Override // cn.damai.tetris.component.discover.mvp.CircleHeadContract.View
    public View getBannerUi() {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "1326431555") ? (View) ipChange.ipc$dispatch("1326431555", new Object[]{this}) : this.mBannerUi;
    }

    @Override // cn.damai.tetris.component.discover.mvp.CircleHeadContract.View
    public ImageView getBgImage() {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "1064960893") ? (ImageView) ipChange.ipc$dispatch("1064960893", new Object[]{this}) : this.bgImage;
    }

    @Override // cn.damai.tetris.component.discover.mvp.CircleHeadContract.View
    public RoundRadiusImageView getCircleHeadImage() {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "-114485699") ? (RoundRadiusImageView) ipChange.ipc$dispatch("-114485699", new Object[]{this}) : this.circleHeadImage;
    }

    @Override // cn.damai.tetris.component.discover.mvp.CircleHeadContract.View
    public DMIconFontTextView getJoinIcon() {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "960722629") ? (DMIconFontTextView) ipChange.ipc$dispatch("960722629", new Object[]{this}) : this.joinIcon;
    }

    @Override // cn.damai.tetris.component.discover.mvp.CircleHeadContract.View
    public DMThemeProjectItemView getProjectUi() {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "691629378") ? (DMThemeProjectItemView) ipChange.ipc$dispatch("691629378", new Object[]{this}) : this.mProjectRevUi;
    }

    @Override // cn.damai.tetris.component.discover.mvp.CircleHeadContract.View
    public ViewStub getRankStub() {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "-1899191461") ? (ViewStub) ipChange.ipc$dispatch("-1899191461", new Object[]{this}) : this.mRankStub;
    }

    @Override // cn.damai.tetris.component.discover.mvp.CircleHeadContract.View
    public CircleRankPanel getRankView() {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "-661569079") ? (CircleRankPanel) ipChange.ipc$dispatch("-661569079", new Object[]{this}) : this.mRankPanel;
    }

    @Override // cn.damai.tetris.component.discover.mvp.CircleHeadContract.View
    public TextView getThemeDesc() {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "-887737469") ? (TextView) ipChange.ipc$dispatch("-887737469", new Object[]{this}) : this.themeDesc;
    }

    @Override // cn.damai.tetris.component.discover.mvp.CircleHeadContract.View
    public TextView getThemeJoinBtn() {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "-459736788") ? (TextView) ipChange.ipc$dispatch("-459736788", new Object[]{this}) : this.themeJoinBtn;
    }

    @Override // cn.damai.tetris.component.discover.mvp.CircleHeadContract.View
    public TextView getThemeJoinNum() {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "623894978") ? (TextView) ipChange.ipc$dispatch("623894978", new Object[]{this}) : this.themeJoinNum;
    }

    @Override // cn.damai.tetris.component.discover.mvp.CircleHeadContract.View
    public TextView getThemeName() {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "-2093085879") ? (TextView) ipChange.ipc$dispatch("-2093085879", new Object[]{this}) : this.themeName;
    }

    @Override // cn.damai.tetris.component.discover.mvp.CircleHeadContract.View
    public NewSimpleTitleLayout getTitleLayout() {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "-524515412") ? (NewSimpleTitleLayout) ipChange.ipc$dispatch("-524515412", new Object[]{this}) : this.titleLayout;
    }

    @Override // cn.damai.tetris.component.discover.mvp.CircleHeadContract.View
    public UserAvatarOverlayListLayout getUserOverlay() {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "-689160658") ? (UserAvatarOverlayListLayout) ipChange.ipc$dispatch("-689160658", new Object[]{this}) : this.userOverlay;
    }
}
