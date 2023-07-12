package cn.damai.discover.main.ui;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.DisplayMetrics;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewStub;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewpager.widget.ViewPager;
import cn.damai.baseview.RCRelativeLayoutView;
import cn.damai.comment.view.DMHotDiscussView;
import cn.damai.common.app.base.BaseActivity;
import cn.damai.common.image.DMImageCreator;
import cn.damai.common.nav.DMNav;
import cn.damai.common.nav.NavUri;
import cn.damai.common.user.a;
import cn.damai.common.util.ToastUtil;
import cn.damai.commonbusiness.base.DamaiBaseActivity;
import cn.damai.commonbusiness.base.ResponseErrorPage;
import cn.damai.commonbusiness.discover.bean.VoteBean;
import cn.damai.commonbusiness.discover.bean.VoteInfoBean;
import cn.damai.commonbusiness.discover.viewholder.VotePanel;
import cn.damai.commonbusiness.dynamicx.customwidget.temp.DMUpMarqueeView;
import cn.damai.commonbusiness.search.bean.ProjectItemBean;
import cn.damai.commonbusiness.share.ShareManager;
import cn.damai.commonbusiness.wannasee.listener.OnBizListener;
import cn.damai.commonbusiness.wannasee.listener.OnErrClickListener;
import cn.damai.discover.main.bean.PublishStateBean;
import cn.damai.discover.main.bean.ThemeInfo;
import cn.damai.discover.main.bean.ThemePageBean;
import cn.damai.discover.main.ui.adapter.LivePagerAdapter;
import cn.damai.discover.main.ui.adapter.ThemeRankPanel;
import cn.damai.discover.main.ui.bean.RankUserBean;
import cn.damai.discover.main.ui.listener.OnShareListener;
import cn.damai.discover.main.ui.model.ThemeModel;
import cn.damai.discover.main.ui.view.DMThemeProjectItemView;
import cn.damai.homepage.R$color;
import cn.damai.homepage.R$drawable;
import cn.damai.homepage.R$id;
import cn.damai.homepage.R$layout;
import cn.damai.login.LoginManager;
import cn.damai.tetris.component.drama.viewholder.OnItemBindListener;
import cn.damai.ticklet.ui.activity.TickletAttendanceActivity;
import cn.damai.uikit.image.IImageLoader;
import cn.damai.uikit.irecycler.helper.UpLoadMorePanel;
import cn.damai.uikit.number.DMDigitTextView;
import cn.damai.uikit.pulltorefresh.ptrheader.PtrUiHeader;
import cn.damai.uikit.snake.HorScrollView;
import cn.damai.uikit.snake.ScrollTitleBean;
import cn.damai.uikit.view.NewSimpleTitleLayout;
import cn.damai.uikit.view.RoundImageView;
import cn.damai.user.userprofile.FeedsViewModel;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import com.google.android.material.appbar.AppBarLayout;
import in.srain.cube.views.ptr.PtrFrameLayout;
import in.srain.cube.views.ptr.PtrHandler;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import tb.cb2;
import tb.cs;
import tb.lm2;
import tb.m62;
import tb.mu0;
import tb.pb;
import tb.r92;
import tb.rx1;
import tb.s90;
import tb.t3;
import tb.t60;
import tb.vu0;
import tb.wh2;
import tb.xj0;

/* compiled from: Taobao */
/* loaded from: classes5.dex */
public class ThemeActivity extends DamaiBaseActivity implements UpLoadMorePanel.LoadMoreEventListener {
    private static transient /* synthetic */ IpChange $ipChange = null;
    private static final int REQUEST_CODE_LOGIN = 27;
    public static final String THEME_ID = "themeId";
    TextView activityTag;
    FrameLayout frVoteLayout;
    private DMHotDiscussView hotDiscussView;
    private AppBarLayout mAppBar;
    private ImageView mBannerImg;
    private View mBannerUi;
    private ImageView mBgImg;
    private TextView mDescV2Tv;
    private ViewGroup mHeadUi;
    private ViewGroup mHeader;
    private HorScrollView mHorScrollView;
    private int mItemViewPadding;
    private t3 mLoginListener;
    private ViewGroup mMainView;
    private ThemeModel mModel;
    VotePanel mPanel;
    private DMDigitTextView mPersonContentCountTv;
    private DMDigitTextView mPersonIpvuvTv;
    private DMThemeProjectItemView mProjectRevUi;
    private PtrFrameLayout mPtr;
    private View mPublishContainer;
    private View mPublishPlusIcon;
    private View mPublishUi;
    private RoundImageView mPublishUserImg;
    private ThemeRankPanel mRankPanel;
    private ViewStub mRankStub;
    private ViewGroup mRootView;
    private ScrollTitleBean mSelectTitle;
    private String mThemeId;
    private String mThemeName;
    private TextView mThemeNameTv;
    private NewSimpleTitleLayout mTitleBar;
    private List<ScrollTitleBean> mTitleList;
    private ViewPager mViewPager;
    private ThemeFeedFragment newFragment;
    private int random;
    private ThemeFeedFragment recommendFragment;
    ImageView voteImage;
    RCRelativeLayoutView voteLayout;
    FrameLayout voteLayoutBg;
    ViewGroup voteWidget;
    private final List<Fragment> mPageList = new ArrayList();
    private vu0 mGradientHelper = new vu0();
    private boolean isShouldRefreshAfterOnResume = false;
    private int mDynamicBgImgHeight = -1;
    private int mIndicatorCurrentPosY = 0;
    private boolean isCanShowPublishUi = false;
    private String title = "";
    private final lm2 mUt = new lm2();
    private boolean isViewCreated = false;
    private RecyclerView.OnScrollListener feedListener = new RecyclerView.OnScrollListener() { // from class: cn.damai.discover.main.ui.ThemeActivity.13
        private static transient /* synthetic */ IpChange $ipChange;

        @Override // androidx.recyclerview.widget.RecyclerView.OnScrollListener
        public void onScrolled(@NonNull RecyclerView recyclerView, int i2, int i3) {
            IpChange ipChange = $ipChange;
            boolean z = true;
            if (AndroidInstantRuntime.support(ipChange, "-1128241745")) {
                ipChange.ipc$dispatch("-1128241745", new Object[]{this, recyclerView, Integer.valueOf(i2), Integer.valueOf(i3)});
                return;
            }
            super.onScrolled(recyclerView, i2, i3);
            boolean z2 = i3 < 0;
            boolean h2 = s90.h(recyclerView);
            if (ThemeActivity.this.isCanShowPublishUi) {
                if (h2 && !z2) {
                    z = false;
                }
                s90.c(ThemeActivity.this.mPublishContainer, z);
            }
        }
    };

    /* compiled from: Taobao */
    /* loaded from: classes5.dex */
    public class a implements DMUpMarqueeView.OnItemClickListener {
        private static transient /* synthetic */ IpChange $ipChange;

        a() {
        }

        @Override // cn.damai.commonbusiness.dynamicx.customwidget.temp.DMUpMarqueeView.OnItemClickListener
        public void onItemClick(int i, View view) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "889811699")) {
                ipChange.ipc$dispatch("889811699", new Object[]{this, Integer.valueOf(i), view});
                return;
            }
            ProjectItemBean projectItemBean = (ProjectItemBean) view.getTag();
            s90.j(ThemeActivity.this, projectItemBean);
            pb.j(ThemeActivity.this.mUt.A(i, projectItemBean.id, false));
        }
    }

    /* compiled from: Taobao */
    /* loaded from: classes5.dex */
    public class b implements DMThemeProjectItemView.ProjectLabelClickListener {
        private static transient /* synthetic */ IpChange $ipChange;

        b() {
        }

        @Override // cn.damai.discover.main.ui.view.DMThemeProjectItemView.ProjectLabelClickListener
        public void onClick(int i, ProjectItemBean projectItemBean, List<ProjectItemBean> list) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "354424580")) {
                ipChange.ipc$dispatch("354424580", new Object[]{this, Integer.valueOf(i), projectItemBean, list});
            } else if (1 == i) {
                s90.j(ThemeActivity.this, projectItemBean);
                pb.j(ThemeActivity.this.mUt.A(i, projectItemBean.id, false));
            } else {
                Bundle bundle = new Bundle();
                bundle.putSerializable(ProjectListActivity.DATA_LIST_KEY, (ArrayList) list);
                DMNav.from(ThemeActivity.this).withExtras(bundle).toUri(NavUri.b("theme_project_list"));
                pb.j(ThemeActivity.this.mUt.B());
            }
        }
    }

    /* compiled from: Taobao */
    /* loaded from: classes5.dex */
    public class c implements DMThemeProjectItemView.ExposureCallBack {
        private static transient /* synthetic */ IpChange $ipChange;

        c() {
        }

        @Override // cn.damai.discover.main.ui.view.DMThemeProjectItemView.ExposureCallBack
        public void exposure(View view, int i) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "-1585544900")) {
                ipChange.ipc$dispatch("-1585544900", new Object[]{this, view, Integer.valueOf(i)});
            } else {
                ThemeActivity.this.mUt.u(view, ((ProjectItemBean) view.getTag()).id, i, false);
            }
        }
    }

    /* compiled from: Taobao */
    /* loaded from: classes14.dex */
    public class d implements View.OnClickListener {
        private static transient /* synthetic */ IpChange $ipChange;

        d() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "-987864219")) {
                ipChange.ipc$dispatch("-987864219", new Object[]{this, view});
                return;
            }
            ScrollTitleBean scrollTitleBean = (ScrollTitleBean) view.getTag();
            if (scrollTitleBean != null) {
                pb.j(ThemeActivity.this.mUt.J(scrollTitleBean.index));
                ThemeActivity.this.mSelectTitle = scrollTitleBean;
                if (ThemeActivity.this.mViewPager != null && scrollTitleBean.index < wh2.e(ThemeActivity.this.mPageList)) {
                    ThemeActivity.this.mViewPager.setCurrentItem(scrollTitleBean.index);
                }
                if (ThemeActivity.this.mSelectTitle.index == 1 && ThemeActivity.this.mModel.newPageNo == 1) {
                    ThemeActivity.this.load(true);
                }
            }
        }
    }

    /* compiled from: Taobao */
    /* loaded from: classes5.dex */
    public class e implements OnBizListener<ThemePageBean> {
        private static transient /* synthetic */ IpChange $ipChange;
        final /* synthetic */ boolean a;

        /* compiled from: Taobao */
        /* loaded from: classes5.dex */
        public class a implements OnErrClickListener {
            private static transient /* synthetic */ IpChange $ipChange;

            a() {
            }

            @Override // cn.damai.commonbusiness.wannasee.listener.OnErrClickListener
            public void onClick() {
                IpChange ipChange = $ipChange;
                if (AndroidInstantRuntime.support(ipChange, "-1101210786")) {
                    ipChange.ipc$dispatch("-1101210786", new Object[]{this});
                    return;
                }
                ThemeActivity.this.hideErrorView();
                ThemeActivity.this.load(true);
            }
        }

        e(boolean z) {
            this.a = z;
        }

        @Override // cn.damai.commonbusiness.wannasee.listener.OnBizListener
        /* renamed from: a */
        public void onBizSuccess(ThemePageBean themePageBean) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "2026968678")) {
                ipChange.ipc$dispatch("2026968678", new Object[]{this, themePageBean});
                return;
            }
            ThemeActivity.this.stopProgressDialog();
            if (this.a) {
                ThemeActivity.this.mPtr.refreshComplete();
                ThemeActivity.this.hideErrorView();
                ThemeActivity.this.showHeadView(themePageBean);
                ThemeActivity.this.updateVote(themePageBean);
                ThemeActivity.this.upDataFeedFragment(themePageBean, false);
                return;
            }
            ThemeActivity.this.upDataFeedFragment(themePageBean, true);
        }

        @Override // cn.damai.commonbusiness.wannasee.listener.OnBizListener
        public void onBizFail(String str, String str2) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "-1299526090")) {
                ipChange.ipc$dispatch("-1299526090", new Object[]{this, str, str2});
                return;
            }
            ThemeActivity.this.stopProgressDialog();
            if (this.a) {
                ThemeActivity.this.showErrorView(str, str2, new a());
                return;
            }
            ToastUtil.i(str2);
            ThemeActivity.this.loadFailFragment();
        }
    }

    /* compiled from: Taobao */
    /* loaded from: classes5.dex */
    public class f implements DMImageCreator.DMImageFailListener {
        private static transient /* synthetic */ IpChange $ipChange;

        f() {
        }

        @Override // cn.damai.common.image.DMImageCreator.DMImageFailListener
        public void onFail(DMImageCreator.d dVar) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "-1083316070")) {
                ipChange.ipc$dispatch("-1083316070", new Object[]{this, dVar});
            } else {
                ThemeActivity.this.mBgImg.setImageResource(R$drawable.bg_color_theme_head_fail);
            }
        }
    }

    /* compiled from: Taobao */
    /* loaded from: classes5.dex */
    public class g implements DMImageCreator.DMImageSuccListener {
        private static transient /* synthetic */ IpChange $ipChange;

        g() {
        }

        @Override // cn.damai.common.image.DMImageCreator.DMImageSuccListener
        public void onSuccess(DMImageCreator.e eVar) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "1107525295")) {
                ipChange.ipc$dispatch("1107525295", new Object[]{this, eVar});
            } else if (eVar == null || eVar.b == null) {
            } else {
                ThemeActivity.this.mBgImg.setImageBitmap(eVar.b);
            }
        }
    }

    /* compiled from: Taobao */
    /* loaded from: classes5.dex */
    public class h extends t3 {
        private static transient /* synthetic */ IpChange $ipChange;

        h() {
        }

        @Override // tb.t3, cn.damai.login.havana.ILoginListener
        public void onLoginSuccess() {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "604422265")) {
                ipChange.ipc$dispatch("604422265", new Object[]{this});
            } else {
                ThemeActivity.this.isShouldRefreshAfterOnResume = true;
            }
        }
    }

    /* compiled from: Taobao */
    /* loaded from: classes5.dex */
    public class i implements OnShareListener {
        private static transient /* synthetic */ IpChange $ipChange;

        i() {
        }

        @Override // cn.damai.discover.main.ui.listener.OnShareListener
        public void openShareView(Bundle bundle) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "-1860592045")) {
                ipChange.ipc$dispatch("-1860592045", new Object[]{this, bundle});
            } else if (ThemeActivity.this.isFinishing()) {
            } else {
                ShareManager E = ShareManager.E();
                ThemeActivity themeActivity = ThemeActivity.this;
                E.P(themeActivity, bundle, themeActivity.mRootView);
            }
        }

        @Override // cn.damai.discover.main.ui.listener.OnShareListener
        public void showLoading(boolean z) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "-1377098344")) {
                ipChange.ipc$dispatch("-1377098344", new Object[]{this, Boolean.valueOf(z)});
            } else if (z) {
                ThemeActivity.this.startProgressDialog();
            } else {
                ThemeActivity.this.stopProgressDialog();
            }
        }

        @Override // cn.damai.discover.main.ui.listener.OnShareListener
        public void toast(String str) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "-956520866")) {
                ipChange.ipc$dispatch("-956520866", new Object[]{this, str});
            } else {
                ToastUtil.i(str);
            }
        }
    }

    /* compiled from: Taobao */
    /* loaded from: classes5.dex */
    public class j implements ResponseErrorPage.ErrorRefreshListener {
        private static transient /* synthetic */ IpChange $ipChange;
        final /* synthetic */ OnErrClickListener a;

        j(ThemeActivity themeActivity, OnErrClickListener onErrClickListener) {
            this.a = onErrClickListener;
        }

        @Override // cn.damai.commonbusiness.base.ResponseErrorPage.ErrorRefreshListener
        public void handleError(int i) {
            OnErrClickListener onErrClickListener;
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "1482232905")) {
                ipChange.ipc$dispatch("1482232905", new Object[]{this, Integer.valueOf(i)});
            } else if (r92.c() || (onErrClickListener = this.a) == null) {
            } else {
                onErrClickListener.onClick();
            }
        }
    }

    /* compiled from: Taobao */
    /* loaded from: classes5.dex */
    public class k implements OnBizListener<PublishStateBean> {
        private static transient /* synthetic */ IpChange $ipChange;

        k() {
        }

        @Override // cn.damai.commonbusiness.wannasee.listener.OnBizListener
        /* renamed from: a */
        public void onBizSuccess(PublishStateBean publishStateBean) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "-1113598997")) {
                ipChange.ipc$dispatch("-1113598997", new Object[]{this, publishStateBean});
            } else {
                ThemeActivity.this.showPublishView(publishStateBean.isNeedShowPublishBtn());
            }
        }

        @Override // cn.damai.commonbusiness.wannasee.listener.OnBizListener
        public void onBizFail(String str, String str2) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "-2006772165")) {
                ipChange.ipc$dispatch("-2006772165", new Object[]{this, str, str2});
            } else {
                ThemeActivity.this.showPublishView(false);
            }
        }
    }

    /* compiled from: Taobao */
    /* loaded from: classes5.dex */
    public class l implements AppBarLayout.OnOffsetChangedListener {
        private static transient /* synthetic */ IpChange $ipChange;

        l() {
        }

        @Override // com.google.android.material.appbar.AppBarLayout.OnOffsetChangedListener, com.google.android.material.appbar.AppBarLayout.BaseOnOffsetChangedListener
        public void onOffsetChanged(AppBarLayout appBarLayout, int i) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "-2108806256")) {
                ipChange.ipc$dispatch("-2108806256", new Object[]{this, appBarLayout, Integer.valueOf(i)});
                return;
            }
            float abs = Math.abs(i) / m62.a(ThemeActivity.this, 18.0f);
            ThemeActivity.this.mTitleBar.setAlpha(abs);
            ThemeActivity.this.mTitleBar.setTitle(abs >= 1.0f ? ThemeActivity.this.title : "");
            ThemeActivity.this.mHeader.scrollTo(0, -i);
        }
    }

    /* compiled from: Taobao */
    /* loaded from: classes5.dex */
    public class m implements NewSimpleTitleLayout.OnBtnClickListener {
        private static transient /* synthetic */ IpChange $ipChange;

        m() {
        }

        @Override // cn.damai.uikit.view.NewSimpleTitleLayout.OnBtnClickListener
        public void onBackClick() {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "-1012529068")) {
                ipChange.ipc$dispatch("-1012529068", new Object[]{this});
            } else {
                ThemeActivity.this.finish();
            }
        }

        @Override // cn.damai.uikit.view.NewSimpleTitleLayout.OnBtnClickListener
        public void onShareClick() {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "-125391732")) {
                ipChange.ipc$dispatch("-125391732", new Object[]{this});
            } else {
                ThemeActivity.this.showShareView();
            }
        }
    }

    /* compiled from: Taobao */
    /* loaded from: classes5.dex */
    public class n implements PtrHandler {
        private static transient /* synthetic */ IpChange $ipChange;

        n() {
        }

        @Override // in.srain.cube.views.ptr.PtrHandler
        public boolean checkCanDoRefresh(PtrFrameLayout ptrFrameLayout, View view, View view2) {
            IpChange ipChange = $ipChange;
            return AndroidInstantRuntime.support(ipChange, "-213618452") ? ((Boolean) ipChange.ipc$dispatch("-213618452", new Object[]{this, ptrFrameLayout, view, view2})).booleanValue() : ThemeActivity.this.mAppBar.getTop() >= 0 && ThemeActivity.this.isViewCreated;
        }

        @Override // in.srain.cube.views.ptr.PtrHandler
        public void onRefreshBegin(PtrFrameLayout ptrFrameLayout) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "1395226789")) {
                ipChange.ipc$dispatch("1395226789", new Object[]{this, ptrFrameLayout});
            } else {
                ThemeActivity.this.load(true);
            }
        }
    }

    /* compiled from: Taobao */
    /* loaded from: classes5.dex */
    public class o implements OnItemBindListener<RankUserBean> {
        private static transient /* synthetic */ IpChange $ipChange;

        o() {
        }

        @Override // cn.damai.tetris.component.drama.viewholder.OnItemBindListener
        /* renamed from: a */
        public void exposeItem(View view, RankUserBean rankUserBean, int i) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "1433843370")) {
                ipChange.ipc$dispatch("1433843370", new Object[]{this, view, rankUserBean, Integer.valueOf(i)});
            } else {
                ThemeActivity.this.mUt.v(view, i);
            }
        }

        @Override // cn.damai.tetris.component.drama.viewholder.OnItemClickListener
        /* renamed from: b */
        public void onItemClick(RankUserBean rankUserBean, int i) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "1024250517")) {
                ipChange.ipc$dispatch("1024250517", new Object[]{this, rankUserBean, Integer.valueOf(i)});
            } else if (rankUserBean.isValidUser()) {
                ThemeActivity.this.mUt.D(i);
                Bundle bundle = new Bundle();
                bundle.putString(FeedsViewModel.ARG_USERID, rankUserBean.havanaIdStr);
                DMNav.from(ThemeActivity.this.mContext).withExtras(bundle).toUri(NavUri.b(cs.ARTISTID_THEME));
            }
        }
    }

    /* compiled from: Taobao */
    /* loaded from: classes5.dex */
    public class p implements VotePanel.VoteActionListener {
        private static transient /* synthetic */ IpChange $ipChange;

        p() {
        }

        @Override // cn.damai.commonbusiness.discover.viewholder.VotePanel.VoteActionListener
        public Activity getActivity() {
            IpChange ipChange = $ipChange;
            return AndroidInstantRuntime.support(ipChange, "-344605285") ? (Activity) ipChange.ipc$dispatch("-344605285", new Object[]{this}) : ThemeActivity.this;
        }

        @Override // cn.damai.commonbusiness.discover.viewholder.VotePanel.VoteActionListener
        public void onVoteInfoUpdate(@NonNull VoteInfoBean voteInfoBean) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "1295706653")) {
                ipChange.ipc$dispatch("1295706653", new Object[]{this, voteInfoBean});
            }
        }

        @Override // cn.damai.commonbusiness.discover.viewholder.VotePanel.VoteActionListener
        public void showActivityLoading(boolean z) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "-529799502")) {
                ipChange.ipc$dispatch("-529799502", new Object[]{this, Boolean.valueOf(z)});
                return;
            }
            Activity activity = getActivity();
            if (activity instanceof BaseActivity) {
                if (z) {
                    ((BaseActivity) activity).startProgressDialog();
                } else {
                    ((BaseActivity) activity).stopProgressDialog();
                }
            }
        }

        @Override // cn.damai.commonbusiness.discover.viewholder.VotePanel.VoteUtListener
        public void ut4CancelVoteClick(VoteInfoBean voteInfoBean) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "-1370523474")) {
                ipChange.ipc$dispatch("-1370523474", new Object[]{this, voteInfoBean});
            } else {
                pb.j(ThemeActivity.this.mUt.n(voteInfoBean.id, 0));
            }
        }

        @Override // cn.damai.commonbusiness.discover.viewholder.VotePanel.VoteUtListener
        public void ut4VoteCardExposure(View view, VoteInfoBean voteInfoBean, int i) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "-1643177208")) {
                ipChange.ipc$dispatch("-1643177208", new Object[]{this, view, voteInfoBean, Integer.valueOf(i)});
            } else {
                ThemeActivity.this.mUt.w(view, voteInfoBean.id);
            }
        }

        @Override // cn.damai.commonbusiness.discover.viewholder.VotePanel.VoteUtListener
        public void ut4VoteClick(VoteInfoBean voteInfoBean, VoteBean voteBean, int i) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "-700459652")) {
                ipChange.ipc$dispatch("-700459652", new Object[]{this, voteInfoBean, voteBean, Integer.valueOf(i)});
            } else {
                pb.j(ThemeActivity.this.mUt.k(voteInfoBean.id, i));
            }
        }
    }

    /* compiled from: Taobao */
    /* loaded from: classes5.dex */
    public class q implements IImageLoader.IImageSuccListener {
        private static transient /* synthetic */ IpChange $ipChange;
        final /* synthetic */ int a;
        final /* synthetic */ int b;
        final /* synthetic */ ViewGroup.LayoutParams c;

        q(int i, int i2, ViewGroup.LayoutParams layoutParams) {
            this.a = i;
            this.b = i2;
            this.c = layoutParams;
        }

        @Override // cn.damai.uikit.image.IImageLoader.IImageSuccListener
        public void onSuccess(IImageLoader.b bVar) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "-739314430")) {
                ipChange.ipc$dispatch("-739314430", new Object[]{this, bVar});
            } else if (bVar.b != null) {
                ThemeActivity.this.voteImage.setVisibility(0);
                ThemeActivity.this.voteImage.setImageDrawable(bVar.a);
                int height = (this.a * bVar.b.getHeight()) / bVar.b.getWidth();
                int i = this.a;
                int i2 = this.b;
                if (i2 < height) {
                    i = (bVar.b.getWidth() * i2) / bVar.b.getHeight();
                    height = i2;
                }
                ViewGroup.LayoutParams layoutParams = this.c;
                layoutParams.width = i;
                layoutParams.height = height;
            }
        }
    }

    /* compiled from: Taobao */
    /* loaded from: classes5.dex */
    public class r implements IImageLoader.IImageFailListener {
        private static transient /* synthetic */ IpChange $ipChange;

        r() {
        }

        @Override // cn.damai.uikit.image.IImageLoader.IImageFailListener
        public void onFail(IImageLoader.a aVar) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "753934059")) {
                ipChange.ipc$dispatch("753934059", new Object[]{this, aVar});
            } else {
                ThemeActivity.this.voteImage.setVisibility(4);
            }
        }
    }

    private void findViews() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1523308208")) {
            ipChange.ipc$dispatch("1523308208", new Object[]{this});
            return;
        }
        this.mRootView = (ViewGroup) findViewById(R$id.root_view);
        this.mTitleBar = (NewSimpleTitleLayout) findViewById(R$id.theme_title_bar);
        this.mMainView = (ViewGroup) findViewById(R$id.main_view);
        this.mThemeNameTv = (TextView) findViewById(R$id.theme_name);
        this.mPersonContentCountTv = (DMDigitTextView) findViewById(R$id.theme_person_contentCount);
        this.mPersonIpvuvTv = (DMDigitTextView) findViewById(R$id.theme_person_ipvuv);
        this.mBannerUi = findViewById(R$id.theme_image_ui);
        this.mBannerImg = (ImageView) findViewById(R$id.theme_banner_img);
        this.mProjectRevUi = (DMThemeProjectItemView) findViewById(R$id.theme_project_ui);
        this.mAppBar = (AppBarLayout) findViewById(R$id.theme_app_bar);
        this.mHorScrollView = (HorScrollView) findViewById(R$id.layout_horscroll);
        this.mViewPager = (ViewPager) findViewById(R$id.view_pager);
        this.mPublishContainer = findViewById(R$id.theme_new_publish_container);
        this.mPublishUi = findViewById(R$id.theme_new_publish_ui);
        this.mPublishUserImg = (RoundImageView) findViewById(R$id.theme_new_publish_user_icon);
        this.mPublishPlusIcon = findViewById(R$id.theme_new_publish_icon_plus);
        this.mHeadUi = (ViewGroup) findViewById(R$id.theme_header_bg);
        this.mBgImg = (ImageView) findViewById(R$id.theme_bg_image);
        this.mPtr = (PtrFrameLayout) findViewById(R$id.theme_ptr);
        this.mHeader = (ViewGroup) findViewById(R$id.theme_bg_layout);
        this.mDescV2Tv = (TextView) findViewById(R$id.theme_desc_v2);
        this.mRankStub = (ViewStub) findViewById(R$id.theme_rank_view_stub);
        this.hotDiscussView = (DMHotDiscussView) findViewById(R$id.theme_discuss_view);
    }

    private Drawable getRandomBg() {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "-1183442957") ? (Drawable) ipChange.ipc$dispatch("-1183442957", new Object[]{this}) : new Drawable[]{getResources().getDrawable(R$drawable.theme_defult_bg_01), getResources().getDrawable(R$drawable.theme_defult_bg_02), getResources().getDrawable(R$drawable.theme_defult_bg_03), getResources().getDrawable(R$drawable.theme_defult_bg_04), getResources().getDrawable(R$drawable.theme_defult_bg_05), getResources().getDrawable(R$drawable.theme_defult_bg_06)}[this.random];
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void load(boolean z) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1994109813")) {
            ipChange.ipc$dispatch("1994109813", new Object[]{this, Boolean.valueOf(z)});
        } else {
            this.mModel.load(z, this.mSelectTitle.index, new e(z));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void loadFailFragment() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1387508271")) {
            ipChange.ipc$dispatch("-1387508271", new Object[]{this});
        } else if (this.mSelectTitle.index == 0) {
            this.recommendFragment.loadFail();
        } else {
            this.newFragment.loadFail();
        }
    }

    private void loadPublish() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "76630300")) {
            ipChange.ipc$dispatch("76630300", new Object[]{this});
        } else if (isFinishing() || this.mModel == null) {
        } else {
            showPublishView(false);
            this.mModel.loadPublish(new k());
        }
    }

    private void setUpHorizontalProjectView() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1878449352")) {
            ipChange.ipc$dispatch("1878449352", new Object[]{this});
            return;
        }
        this.mProjectRevUi.setProjectOnClick(new a());
        this.mProjectRevUi.setProjectLabelOnClick(new b());
        this.mProjectRevUi.setExposureCallBack(new c());
    }

    private void setUpVoteView() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-141425383")) {
            ipChange.ipc$dispatch("-141425383", new Object[]{this});
            return;
        }
        this.voteLayout = (RCRelativeLayoutView) findViewById(R$id.theme_circle_vote_layout);
        this.voteLayoutBg = (FrameLayout) findViewById(R$id.theme_circle_vote_bg);
        this.frVoteLayout = (FrameLayout) findViewById(R$id.item_vote_fr_layout);
        this.voteImage = (ImageView) findViewById(R$id.theme_circle_vote_img);
        this.voteWidget = (ViewGroup) findViewById(R$id.item_vote_layout_id);
        this.activityTag = (TextView) findViewById(R$id.theme_circle_vote_tag);
        this.mPanel = new VotePanel(this.voteWidget, new p());
        this.voteLayout.setVisibility(8);
    }

    private void setUpWaterFallView() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-189673397")) {
            ipChange.ipc$dispatch("-189673397", new Object[]{this});
            return;
        }
        ArrayList arrayList = new ArrayList();
        this.mTitleList = arrayList;
        arrayList.clear();
        ScrollTitleBean scrollTitleBean = new ScrollTitleBean("0", "推荐", 0);
        ScrollTitleBean scrollTitleBean2 = new ScrollTitleBean("1", "最新", 1);
        this.mTitleList.add(scrollTitleBean);
        this.mTitleList.add(scrollTitleBean2);
        this.mHorScrollView.setTitle(this.mTitleList).setLineType(2).setFontColor(R$color.color_000000, R$color.color_333333).setHeight(35).setSpace(10).setFontSize(16, 18).commit();
        this.mHorScrollView.setOnTitleClickListener(new d());
        this.mHorScrollView.selectTitle(0);
        this.mSelectTitle = this.mTitleList.get(0);
        this.mPageList.clear();
        ThemeFeedFragment themeFeedFragment = new ThemeFeedFragment();
        this.recommendFragment = themeFeedFragment;
        themeFeedFragment.setIndex(0);
        this.recommendFragment.setUt(this.mUt);
        this.recommendFragment.setWaterfallScrollListener(this.feedListener);
        ThemeFeedFragment themeFeedFragment2 = new ThemeFeedFragment();
        this.newFragment = themeFeedFragment2;
        themeFeedFragment2.setIndex(1);
        this.newFragment.setUt(this.mUt);
        this.newFragment.setWaterfallScrollListener(this.feedListener);
        this.mPageList.add(this.recommendFragment);
        this.mPageList.add(this.newFragment);
        this.mViewPager.setAdapter(new LivePagerAdapter(getSupportFragmentManager(), this.mPageList));
        this.mViewPager.addOnPageChangeListener(new ViewPager.OnPageChangeListener() { // from class: cn.damai.discover.main.ui.ThemeActivity.15
            private static transient /* synthetic */ IpChange $ipChange;

            @Override // androidx.viewpager.widget.ViewPager.OnPageChangeListener
            public void onPageScrollStateChanged(int i2) {
                IpChange ipChange2 = $ipChange;
                if (AndroidInstantRuntime.support(ipChange2, "1390987052")) {
                    ipChange2.ipc$dispatch("1390987052", new Object[]{this, Integer.valueOf(i2)});
                }
            }

            @Override // androidx.viewpager.widget.ViewPager.OnPageChangeListener
            public void onPageScrolled(int i2, float f2, int i3) {
                IpChange ipChange2 = $ipChange;
                if (AndroidInstantRuntime.support(ipChange2, "-1325449269")) {
                    ipChange2.ipc$dispatch("-1325449269", new Object[]{this, Integer.valueOf(i2), Float.valueOf(f2), Integer.valueOf(i3)});
                }
            }

            @Override // androidx.viewpager.widget.ViewPager.OnPageChangeListener
            public void onPageSelected(int i2) {
                IpChange ipChange2 = $ipChange;
                if (AndroidInstantRuntime.support(ipChange2, "-1315738249")) {
                    ipChange2.ipc$dispatch("-1315738249", new Object[]{this, Integer.valueOf(i2)});
                    return;
                }
                ThemeActivity themeActivity = ThemeActivity.this;
                themeActivity.mSelectTitle = (ScrollTitleBean) themeActivity.mTitleList.get(i2);
                ThemeActivity.this.mHorScrollView.selectTitle(i2);
            }
        });
        this.mViewPager.setCurrentItem(0);
        this.mViewPager.setOffscreenPageLimit(wh2.e(this.mPageList));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void showHeadView(ThemePageBean themePageBean) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1268180778")) {
            ipChange.ipc$dispatch("1268180778", new Object[]{this, themePageBean});
        } else if (themePageBean == null || themePageBean.themeInfo == null) {
        } else {
            if (themePageBean.rankInfo != null) {
                updatePageB();
            }
            ThemeInfo themeInfo = themePageBean.themeInfo;
            String str = themePageBean.bannerUrl;
            if (TextUtils.isEmpty(str)) {
                this.mBgImg.setImageDrawable(getRandomBg());
            } else {
                DisplayMetrics b2 = m62.b(this);
                cn.damai.common.image.a.b().f(str, com.alibaba.wireless.security.aopsdk.replace.android.util.DisplayMetrics.getwidthPixels(b2), com.alibaba.wireless.security.aopsdk.replace.android.util.DisplayMetrics.getheightPixels(b2) / 2).i(R$drawable.bg_holder_30grey).n(new g()).e(new f()).f();
            }
            this.mHeadUi.post(new Runnable() { // from class: cn.damai.discover.main.ui.ThemeActivity.19
                private static transient /* synthetic */ IpChange $ipChange;

                @Override // java.lang.Runnable
                public void run() {
                    IpChange ipChange2 = $ipChange;
                    if (AndroidInstantRuntime.support(ipChange2, "-112098426")) {
                        ipChange2.ipc$dispatch("-112098426", new Object[]{this});
                        return;
                    }
                    int i2 = ThemeActivity.this.mDynamicBgImgHeight;
                    int measuredHeight = ThemeActivity.this.mHeadUi.getMeasuredHeight() + ThemeActivity.this.mTitleBar.getMeasuredHeight() + m62.a(mu0.a(), 44.0f);
                    if (measuredHeight == i2) {
                        return;
                    }
                    ThemeActivity.this.mDynamicBgImgHeight = measuredHeight;
                    ViewGroup.LayoutParams layoutParams = ThemeActivity.this.mBgImg.getLayoutParams();
                    layoutParams.height = ThemeActivity.this.mDynamicBgImgHeight + ThemeActivity.this.mIndicatorCurrentPosY;
                    ThemeActivity.this.mBgImg.setLayoutParams(layoutParams);
                }
            });
            String str2 = themeInfo.themeName;
            this.mThemeName = str2;
            if (TextUtils.isEmpty(str2)) {
                str2 = "";
            }
            this.mThemeNameTv.setText(str2);
            this.mPersonIpvuvTv.setText(themeInfo.ipvuv);
            this.mPersonContentCountTv.setText(themeInfo.contentCount);
            findViewById(R$id.view_line).setVisibility((TextUtils.isEmpty(themeInfo.ipvuv) || TextUtils.isEmpty(themeInfo.contentCount)) ? 8 : 0);
            s90.p(this.mDescV2Tv, themeInfo.themeDesc);
            String str3 = themeInfo.bannerPic;
            String str4 = themeInfo.bannerUrl;
            if (!TextUtils.isEmpty(str3) && !TextUtils.isEmpty(str4)) {
                this.mBannerUi.setVisibility(0);
                this.mBannerImg.setTag(themeInfo);
                this.mBannerImg.setOnClickListener(this);
                cn.damai.common.image.a.b().f(str3, com.alibaba.wireless.security.aopsdk.replace.android.util.DisplayMetrics.getwidthPixels(m62.b(this)) - (m62.a(this, 12.0f) * 2), m62.a(this, 88.0f)).g(this.mBannerImg);
                this.mUt.r(this.mBannerImg, 0, str4);
            } else {
                this.mBannerUi.setVisibility(8);
            }
            this.mRankPanel.j(themePageBean.rankInfo);
            this.mRankPanel.e();
            this.title = themeInfo.themeName;
            List<ProjectItemBean> list = themeInfo.projectInfo;
            if (cb2.d(list)) {
                this.mProjectRevUi.setVisibility(8);
            } else {
                this.mProjectRevUi.setVisibility(0);
                this.mProjectRevUi.create(list);
            }
            this.hotDiscussView.bindData(themeInfo.topComment);
            if (themeInfo.topComment != null) {
                this.hotDiscussView.setVisibility(0);
                this.hotDiscussView.showInnerTitle(true);
                this.hotDiscussView.setItemId(themeInfo.topComment.contentDetail.contentId);
                this.hotDiscussView.updateSpmBC("theme", "hot_discussion");
                this.hotDiscussView.setCntContentId(this.mThemeId);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void showPublishView(boolean z) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1520641542")) {
            ipChange.ipc$dispatch("1520641542", new Object[]{this, Boolean.valueOf(z)});
            return;
        }
        this.isCanShowPublishUi = z;
        if (z) {
            this.mPublishUi.setVisibility(0);
            boolean q2 = LoginManager.k().q();
            this.mPublishPlusIcon.setVisibility(q2 ? 8 : 0);
            this.mPublishUserImg.setVisibility(q2 ? 0 : 8);
            if (q2) {
                this.mPublishUserImg.setBackgroundResource(cn.damai.commonbusiness.R$drawable.uikit_user_default_icon);
                String userHeadUrl = this.mModel.getUserHeadUrl();
                if (TextUtils.isEmpty(userHeadUrl)) {
                    userHeadUrl = s90.d();
                }
                if (!TextUtils.isEmpty(userHeadUrl)) {
                    int a2 = m62.a(this, 20.0f);
                    cn.damai.common.image.a.b().f(userHeadUrl, a2, a2).g(this.mPublishUserImg);
                }
            }
            this.mPublishUi.setOnClickListener(this);
            return;
        }
        this.mPublishUi.setVisibility(8);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void showShareView() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1570633982")) {
            ipChange.ipc$dispatch("1570633982", new Object[]{this});
        } else if (this.mModel == null || isFinishing()) {
        } else {
            pb.j(this.mUt.H());
            this.mModel.share(new i());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void upDataFeedFragment(ThemePageBean themePageBean, boolean z) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "291128313")) {
            ipChange.ipc$dispatch("291128313", new Object[]{this, themePageBean, Boolean.valueOf(z)});
        } else if (this.mSelectTitle.index == 0) {
            this.recommendFragment.putData(themePageBean, z);
        } else {
            this.newFragment.putData(themePageBean, z);
        }
    }

    private void updatePageB() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1168489861")) {
            ipChange.ipc$dispatch("-1168489861", new Object[]{this});
        } else if (this.mBuilder != null) {
            this.mUt.E(true);
            a.b K = this.mUt.K();
            setDamaiUTKeyBuilder(K);
            cn.damai.common.user.c.e().l(this, K);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void updateVote(ThemePageBean themePageBean) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-567399941")) {
            ipChange.ipc$dispatch("-567399941", new Object[]{this, themePageBean});
        } else if (themePageBean.themeInfo.vote != null) {
            this.voteLayout.setVisibility(0);
            if (!TextUtils.isEmpty(themePageBean.themeInfo.vote.activityTag)) {
                this.activityTag.setText(themePageBean.themeInfo.vote.activityTag);
                this.activityTag.setVisibility(0);
            } else {
                this.activityTag.setVisibility(8);
            }
            this.mPanel.d(themePageBean.themeInfo.vote, 0);
            int a2 = com.alibaba.wireless.security.aopsdk.replace.android.util.DisplayMetrics.getwidthPixels(t60.b(this)) - (t60.a(this, 21.0f) * 2);
            this.frVoteLayout.getLayoutParams().width = (a2 * 196) / 320;
            int i2 = (a2 * 124) / 320;
            int h2 = this.mPanel.h() + t60.a(this, 12.0f);
            int i3 = (i2 * TickletAttendanceActivity.ORDER_ADD_CONTACTS) / 372;
            ViewGroup.LayoutParams layoutParams = this.voteImage.getLayoutParams();
            if (h2 < i3) {
                layoutParams.width = (h2 * 372) / TickletAttendanceActivity.ORDER_ADD_CONTACTS;
                layoutParams.height = h2;
            } else {
                layoutParams.width = i2;
                layoutParams.height = i3;
            }
            if (!TextUtils.isEmpty(themePageBean.themeInfo.vote.backColor) && !TextUtils.isEmpty(themePageBean.themeInfo.vote.circleBackground)) {
                this.voteLayoutBg.setBackgroundColor(Color.parseColor(themePageBean.themeInfo.vote.backColor));
                cn.damai.uikit.image.a.a().load(themePageBean.themeInfo.vote.circleBackground, 0, 0, 0, new q(i2, h2, layoutParams), new r());
                return;
            }
            this.voteLayoutBg.setBackground(getResources().getDrawable(cn.damai.commonbusiness.R$drawable.bg_vote));
            this.voteImage.setVisibility(0);
            this.voteImage.setImageResource(cn.damai.commonbusiness.R$drawable.discover_vote_default);
        }
    }

    @Override // cn.damai.common.app.base.BaseActivity
    public void dealHeaderClick(int i2) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "2196493")) {
            ipChange.ipc$dispatch("2196493", new Object[]{this, Integer.valueOf(i2)});
        }
    }

    @Override // cn.damai.common.app.base.BaseActivity
    public int getLayoutId() {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "-1547052611") ? ((Integer) ipChange.ipc$dispatch("-1547052611", new Object[]{this})).intValue() : R$layout.activity_theme;
    }

    @Override // cn.damai.commonbusiness.base.ResponseErrorPage.ErrorRefreshListener
    public void handleError(int i2) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1718977886")) {
            ipChange.ipc$dispatch("1718977886", new Object[]{this, Integer.valueOf(i2)});
        }
    }

    public void hideErrorView() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1271846534")) {
            ipChange.ipc$dispatch("-1271846534", new Object[]{this});
            return;
        }
        this.mMainView.setVisibility(8);
        onResponseSuccess(this.mMainView);
    }

    @Override // cn.damai.common.app.base.BaseActivity
    public void initPresenter() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1175399283")) {
            ipChange.ipc$dispatch("-1175399283", new Object[]{this});
        }
    }

    @Override // cn.damai.common.app.base.BaseActivity
    public void initView() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1268003344")) {
            ipChange.ipc$dispatch("-1268003344", new Object[]{this});
            return;
        }
        removeHeadTitleView();
        this.mModel = new ThemeModel(this.mThemeId);
        findViews();
        this.mAppBar.addOnOffsetChangedListener((AppBarLayout.OnOffsetChangedListener) new l());
        this.mTitleBar.enableImmersiveMode(this);
        this.mTitleBar.setAlpha(0.0f);
        this.mTitleBar.setListener(new m());
        PtrUiHeader ptrUiHeader = new PtrUiHeader(this) { // from class: cn.damai.discover.main.ui.ThemeActivity.4
            private static transient /* synthetic */ IpChange $ipChange;

            @Override // cn.damai.uikit.pulltorefresh.ptrheader.PtrUiHeader, in.srain.cube.views.ptr.PtrUIHandler
            @SuppressLint({"NewApi"})
            public void onUIPositionChange(PtrFrameLayout ptrFrameLayout, boolean z, byte b2, rx1 rx1Var) {
                int a2;
                int abs;
                IpChange ipChange2 = $ipChange;
                if (AndroidInstantRuntime.support(ipChange2, "-2069455247")) {
                    ipChange2.ipc$dispatch("-2069455247", new Object[]{this, ptrFrameLayout, Boolean.valueOf(z), Byte.valueOf(b2), rx1Var});
                    return;
                }
                super.onUIPositionChange(ptrFrameLayout, z, b2, rx1Var);
                ThemeActivity.this.mIndicatorCurrentPosY = rx1Var.d();
                ViewGroup.LayoutParams layoutParams = ThemeActivity.this.mBgImg.getLayoutParams();
                if (ThemeActivity.this.mDynamicBgImgHeight > 0) {
                    a2 = ThemeActivity.this.mDynamicBgImgHeight;
                    abs = Math.abs(ThemeActivity.this.mIndicatorCurrentPosY);
                } else {
                    a2 = m62.a(getContext(), 300.0f);
                    abs = Math.abs(ThemeActivity.this.mIndicatorCurrentPosY);
                }
                layoutParams.height = a2 + abs;
                float f2 = 1.0f;
                if (ThemeActivity.this.mIndicatorCurrentPosY > 0 && ThemeActivity.this.mDynamicBgImgHeight > 0) {
                    f2 = 1.0f + (ThemeActivity.this.mIndicatorCurrentPosY / ThemeActivity.this.mDynamicBgImgHeight);
                }
                ThemeActivity.this.mBgImg.setScaleX(f2);
                ThemeActivity.this.mBgImg.setScaleY(f2);
                ThemeActivity.this.mBgImg.setLayoutParams(layoutParams);
            }
        };
        this.mPtr.setHeaderView(ptrUiHeader);
        this.mPtr.addPtrUIHandler(ptrUiHeader);
        this.mPtr.setPtrIndicator(new xj0(100, this));
        this.mPtr.setResistance(1.7f);
        this.mPtr.setPtrHandler(new n());
        this.mPtr.disableWhenHorizontalMove(true);
        setUpHorizontalProjectView();
        this.mRankPanel = new ThemeRankPanel(this, this.mRankStub, new o());
        setUpWaterFallView();
        setUpVoteView();
        startProgressDialog();
        load(true);
        loadPublish();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // cn.damai.commonbusiness.base.DamaiBaseActivity, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, android.app.Activity
    public void onActivityResult(int i2, int i3, Intent intent) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1469388329")) {
            ipChange.ipc$dispatch("-1469388329", new Object[]{this, Integer.valueOf(i2), Integer.valueOf(i3), intent});
            return;
        }
        super.onActivityResult(i2, i3, intent);
        ShareManager.E().r0(i2, i3, intent);
        if (i2 == 27 && i3 == -1) {
            loadPublish();
        }
    }

    @Override // cn.damai.common.app.base.BaseActivity, android.view.View.OnClickListener
    public void onClick(View view) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-289842218")) {
            ipChange.ipc$dispatch("-289842218", new Object[]{this, view});
        } else if (r92.c()) {
        } else {
            int id = view.getId();
            if (id == this.mBannerImg.getId()) {
                Object tag = this.mBannerImg.getTag();
                if (tag instanceof ThemeInfo) {
                    ThemeInfo themeInfo = (ThemeInfo) tag;
                    pb.j(this.mUt.m(0, themeInfo.bannerUrl));
                    DMNav.from(this).toUri(themeInfo.bannerUrl);
                }
            } else if (id == R$id.theme_new_publish_ui) {
                pb.j(this.mUt.I());
                if (LoginManager.k().q()) {
                    PublishStateBean stateBean = this.mModel.getStateBean();
                    stateBean.themeId = this.mThemeId;
                    stateBean.themeName = this.mThemeName;
                    if (stateBean.isNeedShowPublishBtn()) {
                        s90.k(this, stateBean, 100);
                        return;
                    }
                    return;
                }
                LoginManager.k().x(this, new Intent(), 27);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // cn.damai.commonbusiness.base.DamaiBaseActivity, cn.damai.common.app.base.BaseActivity, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    public void onCreate(@Nullable Bundle bundle) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "527584330")) {
            ipChange.ipc$dispatch("527584330", new Object[]{this, bundle});
            return;
        }
        String stringExtra = getIntent().getStringExtra("themeId");
        this.mThemeId = stringExtra;
        this.isViewCreated = true;
        this.mUt.F(stringExtra);
        this.mUt.G("主题");
        this.random = new Random().nextInt(5);
        super.onCreate(bundle);
        setDamaiUTKeyBuilder(this.mUt.K());
        cn.damai.common.user.c.e().K(this);
        this.mLoginListener = new h();
        LoginManager.k().c(this.mLoginListener);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // cn.damai.commonbusiness.base.DamaiBaseActivity, cn.damai.common.app.base.BaseActivity, androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onDestroy() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "685876234")) {
            ipChange.ipc$dispatch("685876234", new Object[]{this});
            return;
        }
        super.onDestroy();
        this.isViewCreated = false;
        if (this.mLoginListener != null) {
            LoginManager.k().C(this.mLoginListener);
        }
        ThemeModel themeModel = this.mModel;
        if (themeModel != null) {
            themeModel.destroy();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // cn.damai.commonbusiness.base.DamaiBaseActivity, cn.damai.common.app.base.BaseActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onResume() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-597176455")) {
            ipChange.ipc$dispatch("-597176455", new Object[]{this});
            return;
        }
        super.onResume();
        if (this.isShouldRefreshAfterOnResume) {
            this.isShouldRefreshAfterOnResume = false;
            load(true);
        }
    }

    @Override // cn.damai.common.app.base.BaseActivity
    protected String setTitle() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1422487921")) {
            return (String) ipChange.ipc$dispatch("1422487921", new Object[]{this});
        }
        return null;
    }

    public void showErrorView(String str, String str2, OnErrClickListener onErrClickListener) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "200974097")) {
            ipChange.ipc$dispatch("200974097", new Object[]{this, str, str2, onErrClickListener});
            return;
        }
        this.mMainView.setVisibility(0);
        onResponseError(str2, str, null, this.mMainView, true);
        ResponseErrorPage responseErrorPage = this.mErrorPage;
        if (responseErrorPage != null) {
            responseErrorPage.setRefreshListener(new j(this, onErrClickListener));
        }
    }

    @Override // cn.damai.uikit.irecycler.helper.UpLoadMorePanel.LoadMoreEventListener
    public void startLoadMore() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1870318072")) {
            ipChange.ipc$dispatch("-1870318072", new Object[]{this});
        } else {
            load(false);
        }
    }
}
