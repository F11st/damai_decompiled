package cn.damai.trade.newtradeorder.ui.projectdetail.projectdetailitem.ui.fragment;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.Color;
import android.os.Build;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.os.Handler;
import android.os.Message;
import android.os.SystemClock;
import android.text.TextUtils;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewStub;
import android.view.animation.TranslateAnimation;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.PopupWindow;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.fragment.app.FragmentTransaction;
import androidx.recyclerview.widget.RecyclerView;
import cn.damai.comment.bean.CommentPraiseInfoBean;
import cn.damai.comment.bean.CommentsItemBean;
import cn.damai.common.OrangeConfigCenter;
import cn.damai.common.app.widget.DMDialog;
import cn.damai.common.nav.DMNav;
import cn.damai.common.nav.NavUri;
import cn.damai.common.user.C0525a;
import cn.damai.common.user.C0529c;
import cn.damai.common.util.ToastUtil;
import cn.damai.commonbusiness.base.DamaiBaseMvpFragment;
import cn.damai.commonbusiness.bean.FocusEvent;
import cn.damai.commonbusiness.calendar.remind.CalendarsResolver;
import cn.damai.commonbusiness.coupondialog.CouponDialogHelper;
import cn.damai.commonbusiness.imagebrowse.bean.PicInfo;
import cn.damai.commonbusiness.notice.NoticeDetailFragment;
import cn.damai.commonbusiness.notice.bean.ItemContent;
import cn.damai.commonbusiness.notice.bean.NoticeListBean;
import cn.damai.commonbusiness.rank.RankInfo;
import cn.damai.commonbusiness.screenshot.ScreenShotDetector;
import cn.damai.commonbusiness.search.bean.FollowDataBean;
import cn.damai.commonbusiness.search.bean.ProjectItemBean;
import cn.damai.commonbusiness.seatbiz.promotion.NcovPromotionFragment;
import cn.damai.commonbusiness.seatbiz.promotion.bean.PromotionDataBean;
import cn.damai.commonbusiness.seatbiz.promotion.bean.PromotionGroupBean;
import cn.damai.commonbusiness.seatbiz.seat.qilin.bean.SeatPreloadExtra;
import cn.damai.commonbusiness.seatbiz.sku.qilin.bean.ItemBuyBtnBean;
import cn.damai.commonbusiness.seatbiz.sku.qilin.bean.PromotionBean;
import cn.damai.commonbusiness.seatbiz.sku.qilin.bean.SkuBean;
import cn.damai.commonbusiness.seatbiz.sku.qilin.elapsed.bean.SkuPerform;
import cn.damai.commonbusiness.seatbiz.sku.qilin.ui.NcovSkuActivity;
import cn.damai.commonbusiness.servicenotice.OnCompleteListener;
import cn.damai.commonbusiness.servicenotice.ProjectSupportServiceFragment;
import cn.damai.commonbusiness.servicenotice.ServiceNote;
import cn.damai.commonbusiness.share.ShareManager;
import cn.damai.commonbusiness.skeleton.SkeletonScreen;
import cn.damai.commonbusiness.util.DMRGBUtil;
import cn.damai.h5container.CaptureActivity;
import cn.damai.im.AliMeUtil;
import cn.damai.login.LoginManager;
import cn.damai.message.observer.Action;
import cn.damai.rank.view.WantSeeGuideTips;
import cn.damai.rank.view.WantSeePosterTips;
import cn.damai.rank.view.WantSeeTips;
import cn.damai.trade.R$anim;
import cn.damai.trade.R$color;
import cn.damai.trade.R$id;
import cn.damai.trade.R$layout;
import cn.damai.trade.R$string;
import cn.damai.trade.newtradeorder.ui.projectdetail.bean.ProjectDetailCommentBean;
import cn.damai.trade.newtradeorder.ui.projectdetail.common.bean.VenueBean;
import cn.damai.trade.newtradeorder.ui.projectdetail.listeners.OnEvaluateMineListener;
import cn.damai.trade.newtradeorder.ui.projectdetail.listeners.OnRecommendItemClickListener;
import cn.damai.trade.newtradeorder.ui.projectdetail.projectdetailitem.anchor.AnchorManager;
import cn.damai.trade.newtradeorder.ui.projectdetail.projectdetailitem.bean.InFieldCommentsBean;
import cn.damai.trade.newtradeorder.ui.projectdetail.projectdetailitem.bean.MarketingStallBean;
import cn.damai.trade.newtradeorder.ui.projectdetail.projectdetailitem.bean.ProjectDetailDataBean;
import cn.damai.trade.newtradeorder.ui.projectdetail.projectdetailitem.bean.ProjectDynamicExtDataBean;
import cn.damai.trade.newtradeorder.ui.projectdetail.projectdetailitem.bean.ProjectFreeTicketBean;
import cn.damai.trade.newtradeorder.ui.projectdetail.projectdetailitem.bean.ProjectInformationBean;
import cn.damai.trade.newtradeorder.ui.projectdetail.projectdetailitem.bean.ProjectItemDataBean;
import cn.damai.trade.newtradeorder.ui.projectdetail.projectdetailitem.bean.ProjectMemberPrompt;
import cn.damai.trade.newtradeorder.ui.projectdetail.projectdetailitem.bean.ProjectNotice;
import cn.damai.trade.newtradeorder.ui.projectdetail.projectdetailitem.bean.ProjectRatingContentLabelBean;
import cn.damai.trade.newtradeorder.ui.projectdetail.projectdetailitem.bean.ProjectRecommendBean;
import cn.damai.trade.newtradeorder.ui.projectdetail.projectdetailitem.bean.ProjectRecommendListBean;
import cn.damai.trade.newtradeorder.ui.projectdetail.projectdetailitem.bean.ProjectStaticDataBean;
import cn.damai.trade.newtradeorder.ui.projectdetail.projectdetailitem.bean.ProjectStaticExtendInfoBean;
import cn.damai.trade.newtradeorder.ui.projectdetail.projectdetailitem.bean.ProjectStaticItemBaseBean;
import cn.damai.trade.newtradeorder.ui.projectdetail.projectdetailitem.bean.ProjectTicketGuideBean;
import cn.damai.trade.newtradeorder.ui.projectdetail.projectdetailitem.bean.ProjectTour;
import cn.damai.trade.newtradeorder.ui.projectdetail.projectdetailitem.bean.ProjectWantSeeBean;
import cn.damai.trade.newtradeorder.ui.projectdetail.projectdetailitem.bean.PromotionItemBean;
import cn.damai.trade.newtradeorder.ui.projectdetail.projectdetailitem.bean.StatusNotice;
import cn.damai.trade.newtradeorder.ui.projectdetail.projectdetailitem.contract.ProjectItemContract;
import cn.damai.trade.newtradeorder.ui.projectdetail.projectdetailitem.dataholder.ProjectDataHolder;
import cn.damai.trade.newtradeorder.ui.projectdetail.projectdetailitem.helper.IRichTextManager;
import cn.damai.trade.newtradeorder.ui.projectdetail.projectdetailitem.helper.ITimeCountDownManager;
import cn.damai.trade.newtradeorder.ui.projectdetail.projectdetailitem.helper.OnTimeCountDownListener;
import cn.damai.trade.newtradeorder.ui.projectdetail.projectdetailitem.helper.ShareManagerImpl;
import cn.damai.trade.newtradeorder.ui.projectdetail.projectdetailitem.helper.TimeCountDownManagerImpl;
import cn.damai.trade.newtradeorder.ui.projectdetail.projectdetailitem.listeners.OnCommonProblemsListener;
import cn.damai.trade.newtradeorder.ui.projectdetail.projectdetailitem.listeners.OnDiscussionClickListener;
import cn.damai.trade.newtradeorder.ui.projectdetail.projectdetailitem.listeners.OnItemExtendInfoItemClickListener;
import cn.damai.trade.newtradeorder.ui.projectdetail.projectdetailitem.listeners.OnSectionMoreClickListener;
import cn.damai.trade.newtradeorder.ui.projectdetail.projectdetailitem.listeners.ProjectDialogShowListener;
import cn.damai.trade.newtradeorder.ui.projectdetail.projectdetailitem.presenter.ProjectItemPresenter;
import cn.damai.trade.newtradeorder.ui.projectdetail.projectdetailitem.ui.adapter.ProjectItemDetailAdapter;
import cn.damai.trade.newtradeorder.ui.projectdetail.projectdetailitem.ui.fragment.ProjectDetailItemMainFragment;
import cn.damai.trade.newtradeorder.ui.projectdetail.projectdetailitem.ui.view.AnchorIndicatorView;
import cn.damai.trade.newtradeorder.ui.projectdetail.projectdetailitem.ui.view.ProjectDialogHelper;
import cn.damai.trade.newtradeorder.ui.projectdetail.projectdetailitem.ui.view.ProjectItemStatusHelper;
import cn.damai.trade.newtradeorder.ui.projectdetail.projectdetailitem.ui.view.ProjectSpecialBuyPromptView;
import cn.damai.trade.newtradeorder.ui.projectdetail.projectdetailitem.ui.view.ProjectTimerAndStagoryView;
import cn.damai.trade.newtradeorder.ui.projectdetail.projectdetailitem.ui.view.ProjectTimerAndStrategyTmPromptView;
import cn.damai.trade.newtradeorder.ui.projectdetail.projectdetailitem.ui.view.projectheader.OnHeadClickListener;
import cn.damai.trade.newtradeorder.ui.projectdetail.projectdetailitem.ui.view.projectheader.ProjectHeaderPanel;
import cn.damai.trade.newtradeorder.ui.projectdetail.projectdetailitem.ui.view.projectheader.ProjectTitleBarPanel;
import cn.damai.trade.newtradeorder.ui.projectdetail.projectdetailitem.ui.viewholder.SplitImageSizeCache;
import cn.damai.trade.newtradeorder.ui.projectdetail.ui.activity.ProjectDetailActivity;
import cn.damai.trade.newtradeorder.ui.projectdetail.ui.fragment.PrivilegeCodeVerifyFragment;
import cn.damai.trade.newtradeorder.ui.projectdetail.ui.fragment.VIPCreditExchangePopFragment;
import cn.damai.trade.newtradeorder.ui.projectdetail.ui.view.PullToRefreshView;
import cn.damai.trade.newtradeorder.ui.projectdetail.util.ProjectIntentExtraParser;
import cn.damai.trade.newtradeorder.ui.projectdetail.wantsee.WantSeeHelper;
import cn.damai.trade.newtradeorder.ui.projectdetail.xflush.ProjectDetailXFlushUtil;
import cn.damai.uikit.irecycler.DamaiRootRecyclerView;
import cn.damai.uikit.irecycler.widget.WrapLinearLayoutManager;
import cn.damai.uikit.nav.INavUri;
import cn.damai.uikit.nav.NavProxy;
import cn.damai.uikit.view.SeeAnimateView;
import cn.damai.wantsee.GuideUtProvider;
import cn.damai.wantsee.StartConfig;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import com.google.android.material.badge.BadgeDrawable;
import com.heytap.mcssdk.constant.MessageConstant$MessageType;
import com.real.android.nativehtml.android.HtmlView;
import com.taobao.android.purchase.core.utils.PurchaseConstants;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import tb.c5;
import tb.cb2;
import tb.cs;
import tb.e11;
import tb.e80;
import tb.fr1;
import tb.fw1;
import tb.g03;
import tb.gb;
import tb.gn2;
import tb.gv0;
import tb.gw1;
import tb.hw1;
import tb.i12;
import tb.ir1;
import tb.jn1;
import tb.kg2;
import tb.lk1;
import tb.m62;
import tb.m91;
import tb.m92;
import tb.mk1;
import tb.mr1;
import tb.mu0;
import tb.n03;
import tb.o62;
import tb.od2;
import tb.pp2;
import tb.pv1;
import tb.qv1;
import tb.r92;
import tb.tv1;
import tb.vl1;
import tb.wh2;
import tb.wv1;
import tb.x8;
import tb.xr;
import tb.yb;
import tb.yr;
import tb.z20;
import tb.zn2;
import tb.zx2;

/* compiled from: Taobao */
/* loaded from: classes8.dex */
public class ProjectDetailItemMainFragment extends DamaiBaseMvpFragment<ProjectItemPresenter, ProjectItemContract.Model> implements ProjectItemContract.View, PullToRefreshView.OnRefreshListener, AnchorIndicatorView.OnAnchorItemClickListener, PrivilegeCodeVerifyFragment.OnPrivilegeCodeVerifyResultListener, OnCompleteListener {
    private static transient /* synthetic */ IpChange $ipChange = null;
    public static final String BRAND_STATE_CHANGED = "brand_state_changed";
    private static final int MAX_NUM_RECOMMEND = 10;
    private static final int MSG_REMOVE_BUY_RIGHT_NOW_FRAGMENT = 103;
    private static final int MSG_REMOVE_PERFORM_LIST_FRAGMENT = 102;
    public static final int TIME_INTERVAL_ADD_CALENDAR = 10;
    private static final int TYPE_BUY_AFTER_COUNT_DOWN = 4;
    private static final int TYPE_BUY_CHOOSE_SEAT = 2;
    private static final int TYPE_BUY_RIGHT_NOW = 1;
    private static final int TYPE_BUY_SALE_REMIND = 3;
    private static final int TYPE_BUY_UN_CLICKABLE = -1;
    private static final HashMap<Long, Integer> projectEnterCountMap = new HashMap<>();
    private Action action;
    private String atomSplit;
    NoticeDetailFragment detailFragment;
    private View footer;
    private ViewGroup.LayoutParams footerParam;
    View header;
    private boolean isFixedAnchorVisible;
    private boolean isFlowByBottomBar;
    private boolean isShowAnchor;
    private boolean isShowFixAnchorIndicator;
    private AnchorIndicatorView mAnchorIndicator;
    private AnchorIndicatorView mAnchorIndicatorFixed;
    private AnchorManager mAnchorManager;
    private int mBackType;
    private View mBottomLineView;
    private String mClickedProblem;
    private FrameLayout mContentRootLayout;
    private int mCurAnchorPosition;
    private int mDefaultRVMarginBottom;
    private ProjectDialogHelper mDialogPanel;
    private FrameLayout mFlMoreRecommendFloatLayer;
    private FrameLayout mFlNotExistPageContainer;
    private FrameLayout mFlProjectContentContainer;
    private FrameLayout mFlPurchaseStatusBarContainer;
    private FrameLayout mFlvPopupLayer;
    private Handler mHandler;
    private boolean mHasClosedMoreRecommend;
    private boolean mHasCountDownFinished;
    private boolean mHasDisplayedLimitedDialog;
    private boolean mHasRegisterRedPacketMsg;
    private View mHeadDividerLine;
    private ProjectHeaderPanel mHeadPanel;
    private boolean mIsFirstEnter;
    private boolean mIsFromPush;
    private boolean mIsLoading;
    private boolean mIsScrolled;
    private ImageView mIvCloseMoreRecommend;
    private ImageView mIvProjectPosterMask;
    private WrapLinearLayoutManager mLinearLayoutManager;
    private PullToRefreshView mLinearPullToRefreshView;
    private View mLvBottomBar;
    private FrameLayout mLvCustomerService;
    private LinearLayout mLvProjectDetailHeader;
    private int mMaskColor;
    private OnTimeCountDownListener mMemberPromptOnTimeCountDownListener;
    private ITimeCountDownManager mMemberPromptTimeCountDownManager;
    private OnTimeCountDownListener mMemberSpecilBuyTimeCountDownListener;
    private lk1 mNewSkuData;
    private mk1 mNewSkuDataManager;
    private View.OnClickListener mOnCloseMoreRecommendClickListener;
    private OnDiscussionClickListener mOnDiscussionClickListener;
    private OnEvaluateMineListener mOnEvaluateMineListener;
    private OnItemExtendInfoItemClickListener mOnExtendInfoImageItemClickListener;
    private View.OnClickListener mOnMoreRecommendClickListener;
    private View.OnClickListener mOnPerformInfoClickListener;
    private View.OnClickListener mOnPerformSeatImgIconClickListener;
    private OnCommonProblemsListener mOnProjectCommonProblemListener;
    private View.OnClickListener mOnProjectFollowClickListener;
    private View.OnClickListener mOnProjectPosterClickListener;
    private View.OnClickListener mOnPromotionDetailClickListener;
    private OnRecommendItemClickListener mOnRecommendItemClickListener;
    private OnSectionMoreClickListener mOnSectionMoreClickListener;
    private OnTimeCountDownListener mOnTimeCountDownListener;
    private gv0 mPerformDataConfigure;
    private fr1 mPerformDataManager;
    private Fragment mPopLayerFragment;
    private PrivilegeCodeVerifyFragment mPrivilegeCodeVerifyFragment;
    private String mPrivilegeId;
    private pv1 mProjectDataHolderManager;
    public ProjectDetailActivity mProjectDetailActivity;
    private ProjectDetailDataBean mProjectDetailDataBean;
    private ProjectDetailCommentBean mProjectDetailDiscussionBean;
    private ProjectDetailCommentBean mProjectDetailEvaluateBean;
    private ProjectDynamicExtDataBean mProjectDynamicExtDataBean;
    private ProjectIntentExtraParser.ProjectDetailExtrasData mProjectExtraData;
    public long mProjectId;
    private ProjectItemDataBean mProjectItemDataBean;
    private ProjectItemDetailAdapter mProjectItemDetailAdapter;
    private ProjectItemStatusHelper mProjectItemStatusHelper;
    private ProjectStaticDataBean mProjectStaticDataBean;
    private int mPurchaseType;
    private RankInfo mRankInfo;
    private List<ProjectRecommendBean> mRecommendItems;
    private DamaiRootRecyclerView mRecyclerView;
    private i12 mRegionManager;
    private RelativeLayout mRvProjectDetailContent;
    private View mRvPromptFloatingLayerView;
    private SeatPreloadExtra mSeatPreloadExtra;
    private int mSingleStagoryMargin;
    SkuBean mSkuBean;
    private ITimeCountDownManager mTimeCountDownManager;
    private int mTimerRVMarginBottom;
    private ProjectTitleBarPanel mTitleBarPanel;
    private TextView mTvProjectFollowText;
    private TextView mTvPromptContent;
    private SeeAnimateView mViewProjectFollow;
    private FrameLayout mWantTipsContainer;
    PopupWindow popupWindow;
    private SkeletonScreen skeletonScreen;
    private ProjectSpecialBuyPromptView specialBuyPromptView;
    private ProjectTimerAndStagoryView timerAndStagoryView;
    private ProjectTimerAndStrategyTmPromptView timerAndStrategyTmPromptView;
    private zx2 viewCreater;
    private WantSeeGuideTips wantSeeGuideTips;
    private CountDownTimer wantSeeGuideTipsTimer;
    private WantSeePosterTips wantSeePosterTips;
    private WantSeeTips wantSeeTips;
    private int titleBar2DarkHeight = m62.a(mu0.a(), 18.0f);
    private String mSinaSharePath = "";
    private String mAliMeFrom = "";
    private long mWantSeeNum = 0;
    private RecyclerView.OnScrollListener mOnScrollListener = new RecyclerView.OnScrollListener() { // from class: cn.damai.trade.newtradeorder.ui.projectdetail.projectdetailitem.ui.fragment.ProjectDetailItemMainFragment.1
        private static transient /* synthetic */ IpChange $ipChange;

        @Override // androidx.recyclerview.widget.RecyclerView.OnScrollListener
        public void onScrollStateChanged(RecyclerView recyclerView, int i) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "1067239650")) {
                ipChange.ipc$dispatch("1067239650", new Object[]{this, recyclerView, Integer.valueOf(i)});
                return;
            }
            super.onScrollStateChanged(recyclerView, i);
            ProjectDetailItemMainFragment.this.mIsScrolled = i != 0;
        }

        @Override // androidx.recyclerview.widget.RecyclerView.OnScrollListener
        public void onScrolled(RecyclerView recyclerView, int i, int i2) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "-298432259")) {
                ipChange.ipc$dispatch("-298432259", new Object[]{this, recyclerView, Integer.valueOf(i), Integer.valueOf(i2)});
                return;
            }
            super.onScrolled(recyclerView, i, i2);
            ProjectDetailItemMainFragment.this.updateTitleBarStyle();
            if (ProjectDetailItemMainFragment.this.mIsScrolled) {
                boolean z = i2 > 0;
                ProjectDetailItemMainFragment.this.updateTitleBgAndAnchorIndicator();
                ProjectDetailItemMainFragment.this.fixAnchorSelection(z);
            }
        }
    };
    public String mButtomText = "";
    private List<View> exposureViewList = new ArrayList();
    private CalendarsResolver.RemindMeListener calendRemindMeListener = new C2300h0();
    private GuideUtProvider mGuideUtProvider = new C2304j0();
    ShareManagerImpl mShareManagerImpl = new C2318q0();
    ProjectDialogShowListener dialogShowListener = new u0();
    ScreenShotDetector.IScreenShotExtraListener extraListener = new v0();

    /* compiled from: Taobao */
    /* renamed from: cn.damai.trade.newtradeorder.ui.projectdetail.projectdetailitem.ui.fragment.ProjectDetailItemMainFragment$a */
    /* loaded from: classes16.dex */
    public class View$OnClickListenerC2285a implements View.OnClickListener {
        private static transient /* synthetic */ IpChange $ipChange;

        View$OnClickListenerC2285a() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "-360766002")) {
                ipChange.ipc$dispatch("-360766002", new Object[]{this, view});
                return;
            }
            ArrayList posterPicInfoList = ProjectDetailItemMainFragment.this.getPosterPicInfoList();
            if (posterPicInfoList == null || posterPicInfoList.isEmpty()) {
                return;
            }
            C0529c.e().x(pp2.u().G0(ProjectDetailItemMainFragment.this.mProjectId));
            ProjectDetailItemMainFragment projectDetailItemMainFragment = ProjectDetailItemMainFragment.this;
            tv1.l(projectDetailItemMainFragment.mProjectDetailActivity, projectDetailItemMainFragment.mProjectId, posterPicInfoList, 0);
        }
    }

    /* compiled from: Taobao */
    /* renamed from: cn.damai.trade.newtradeorder.ui.projectdetail.projectdetailitem.ui.fragment.ProjectDetailItemMainFragment$a0 */
    /* loaded from: classes8.dex */
    public class C2286a0 implements NcovPromotionFragment.OnConfirmClickListener {
        private static transient /* synthetic */ IpChange $ipChange;

        C2286a0() {
        }

        @Override // cn.damai.commonbusiness.seatbiz.promotion.NcovPromotionFragment.OnConfirmClickListener
        public void onCloseClick() {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "-202474671")) {
                ipChange.ipc$dispatch("-202474671", new Object[]{this});
                return;
            }
            ProjectDetailItemMainFragment projectDetailItemMainFragment = ProjectDetailItemMainFragment.this;
            projectDetailItemMainFragment.dismissPopLayerFragment(projectDetailItemMainFragment.mPopLayerFragment);
        }
    }

    /* compiled from: Taobao */
    /* loaded from: classes16.dex */
    public class a1 implements View.OnClickListener {
        private static transient /* synthetic */ IpChange $ipChange;

        a1() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "-98581155")) {
                ipChange.ipc$dispatch("-98581155", new Object[]{this, view});
                return;
            }
            ProjectDetailItemMainFragment.this.mHasClosedMoreRecommend = true;
            ProjectDetailItemMainFragment.this.mFlMoreRecommendFloatLayer.setVisibility(8);
        }
    }

    /* compiled from: Taobao */
    /* renamed from: cn.damai.trade.newtradeorder.ui.projectdetail.projectdetailitem.ui.fragment.ProjectDetailItemMainFragment$b */
    /* loaded from: classes16.dex */
    public class View$OnClickListenerC2287b implements View.OnClickListener {
        private static transient /* synthetic */ IpChange $ipChange;

        View$OnClickListenerC2287b() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            IpChange ipChange = $ipChange;
            boolean z = true;
            if (AndroidInstantRuntime.support(ipChange, "1750524367")) {
                ipChange.ipc$dispatch("1750524367", new Object[]{this, view});
            } else if (ProjectDetailItemMainFragment.this.mProjectItemDataBean != null) {
                C0529c.e().x(pp2.u().E0(ProjectDetailItemMainFragment.this.mProjectId));
                List<String> itemPromotionTag = ProjectDetailItemMainFragment.this.mProjectItemDataBean.getItemPromotionTag();
                if (ProjectDetailItemMainFragment.this.mProjectItemDataBean.promotionList != null && !cb2.d(ProjectDetailItemMainFragment.this.mProjectItemDataBean.promotionList)) {
                    Iterator<PromotionItemBean> it = ProjectDetailItemMainFragment.this.mProjectItemDataBean.promotionList.iterator();
                    while (true) {
                        if (!it.hasNext()) {
                            z = false;
                            break;
                        } else if (it.next().hasCoupon()) {
                            break;
                        }
                    }
                    if (ProjectDetailItemMainFragment.this.isLogin() || !z) {
                        ProjectDetailItemMainFragment.this.showCouponPromotionFragment();
                    } else {
                        ProjectDetailItemMainFragment.this.startLoginActivityForResult(4098);
                    }
                } else if (itemPromotionTag == null || itemPromotionTag.isEmpty()) {
                } else {
                    ProjectDetailItemMainFragment.this.showCouponPromotionFragment();
                }
            }
        }
    }

    /* compiled from: Taobao */
    /* renamed from: cn.damai.trade.newtradeorder.ui.projectdetail.projectdetailitem.ui.fragment.ProjectDetailItemMainFragment$b0 */
    /* loaded from: classes16.dex */
    public class View$OnClickListenerC2288b0 implements View.OnClickListener {
        private static transient /* synthetic */ IpChange $ipChange;

        View$OnClickListenerC2288b0() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "1473058322")) {
                ipChange.ipc$dispatch("1473058322", new Object[]{this, view});
                return;
            }
            ProjectDetailItemMainFragment projectDetailItemMainFragment = ProjectDetailItemMainFragment.this;
            projectDetailItemMainFragment.dismissPopLayerFragment(projectDetailItemMainFragment.mPopLayerFragment);
        }
    }

    /* compiled from: Taobao */
    /* loaded from: classes16.dex */
    public class b1 implements View.OnClickListener {
        private static transient /* synthetic */ IpChange $ipChange;

        b1() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "2012709214")) {
                ipChange.ipc$dispatch("2012709214", new Object[]{this, view});
            } else if (ProjectDetailItemMainFragment.this.hasRecommendProject()) {
                C0529c.e().x(pp2.u().B0(ProjectDetailItemMainFragment.this.mProjectId));
                ProjectDetailItemMainFragment.this.mHasClosedMoreRecommend = true;
                ProjectDetailItemMainFragment.this.mFlMoreRecommendFloatLayer.setVisibility(8);
                ProjectDetailItemMainFragment.this.scrollToRecommend();
            }
        }
    }

    /* compiled from: Taobao */
    /* renamed from: cn.damai.trade.newtradeorder.ui.projectdetail.projectdetailitem.ui.fragment.ProjectDetailItemMainFragment$c */
    /* loaded from: classes8.dex */
    public class C2289c implements ProjectTimerAndStrategyTmPromptView.ProjectPromptListener {
        private static transient /* synthetic */ IpChange $ipChange;

        C2289c() {
        }

        @Override // cn.damai.trade.newtradeorder.ui.projectdetail.projectdetailitem.ui.view.ProjectTimerAndStrategyTmPromptView.ProjectPromptListener
        public void onVipRefresh() {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "-621244158")) {
                ipChange.ipc$dispatch("-621244158", new Object[]{this});
            } else {
                ProjectDetailItemMainFragment.this.onRefresh();
            }
        }

        @Override // cn.damai.trade.newtradeorder.ui.projectdetail.projectdetailitem.ui.view.ProjectTimerAndStrategyTmPromptView.ProjectPromptListener
        public void showVIPCreditExchange() {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "-1474614513")) {
                ipChange.ipc$dispatch("-1474614513", new Object[]{this});
            } else {
                ProjectDetailItemMainFragment.this.showVIPCreditExchangeFragment();
            }
        }
    }

    /* compiled from: Taobao */
    /* renamed from: cn.damai.trade.newtradeorder.ui.projectdetail.projectdetailitem.ui.fragment.ProjectDetailItemMainFragment$c0 */
    /* loaded from: classes8.dex */
    public class C2290c0 implements DMRGBUtil.OnFetchColorListener {
        private static transient /* synthetic */ IpChange $ipChange;

        C2290c0() {
        }

        @Override // cn.damai.commonbusiness.util.DMRGBUtil.OnFetchColorListener
        public void onFetchColor(int i) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "426091625")) {
                ipChange.ipc$dispatch("426091625", new Object[]{this, Integer.valueOf(i)});
                return;
            }
            if (ProjectDetailItemMainFragment.this.mNewSkuData != null) {
                ProjectDetailItemMainFragment.this.mNewSkuData.a = i;
            }
            ProjectDetailItemMainFragment.this.mIvProjectPosterMask.setBackgroundColor(i);
        }
    }

    /* compiled from: Taobao */
    /* renamed from: cn.damai.trade.newtradeorder.ui.projectdetail.projectdetailitem.ui.fragment.ProjectDetailItemMainFragment$d */
    /* loaded from: classes16.dex */
    public class View$OnClickListenerC2291d implements View.OnClickListener {
        private static transient /* synthetic */ IpChange $ipChange;

        View$OnClickListenerC2291d() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "1678137809")) {
                ipChange.ipc$dispatch("1678137809", new Object[]{this, view});
            } else {
                ProjectDetailItemMainFragment.this.processCalendarRemind();
            }
        }
    }

    /* compiled from: Taobao */
    /* renamed from: cn.damai.trade.newtradeorder.ui.projectdetail.projectdetailitem.ui.fragment.ProjectDetailItemMainFragment$d0 */
    /* loaded from: classes8.dex */
    public class C2292d0 implements AliMeUtil.OnAliMeTokenListener {
        private static transient /* synthetic */ IpChange $ipChange;

        C2292d0() {
        }

        @Override // cn.damai.im.AliMeUtil.OnAliMeTokenListener
        public void onFailed(String str, String str2) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "-175530821")) {
                ipChange.ipc$dispatch("-175530821", new Object[]{this, str, str2});
                return;
            }
            ProjectDetailItemMainFragment.this.stopProgressDialog();
            AliMeUtil.p(str, str2);
            ProjectDetailItemMainFragment.this.resetAliMeClickData();
            ProjectDetailXFlushUtil.i(String.valueOf(ProjectDetailItemMainFragment.this.mProjectId), str, str);
        }

        @Override // cn.damai.im.AliMeUtil.OnAliMeTokenListener
        public void onSuccess(String str) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "-93936531")) {
                ipChange.ipc$dispatch("-93936531", new Object[]{this, str});
                return;
            }
            ProjectDetailItemMainFragment.this.stopProgressDialog();
            if (!wh2.j(str)) {
                ProjectDetailItemMainFragment.this.launchAliMe(str);
                return;
            }
            AliMeUtil.o();
            ProjectDetailItemMainFragment.this.resetAliMeClickData();
        }
    }

    /* compiled from: Taobao */
    /* renamed from: cn.damai.trade.newtradeorder.ui.projectdetail.projectdetailitem.ui.fragment.ProjectDetailItemMainFragment$e */
    /* loaded from: classes16.dex */
    public class View$OnClickListenerC2293e implements View.OnClickListener {
        private static transient /* synthetic */ IpChange $ipChange;

        View$OnClickListenerC2293e() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "-505539118")) {
                ipChange.ipc$dispatch("-505539118", new Object[]{this, view});
                return;
            }
            ProjectDetailItemMainFragment.this.timerAndStagoryView.hideResetAttendees();
            ProjectDetailItemMainFragment.this.strategyClick();
        }
    }

    /* compiled from: Taobao */
    /* renamed from: cn.damai.trade.newtradeorder.ui.projectdetail.projectdetailitem.ui.fragment.ProjectDetailItemMainFragment$e0 */
    /* loaded from: classes8.dex */
    public class C2294e0 implements ProjectItemStatusHelper.OnBottomViewClickListener {
        private static transient /* synthetic */ IpChange $ipChange;

        C2294e0() {
        }

        @Override // cn.damai.trade.newtradeorder.ui.projectdetail.projectdetailitem.ui.view.ProjectItemStatusHelper.OnBottomViewClickListener
        public void onBuyRightNow(int i) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "1452566846")) {
                ipChange.ipc$dispatch("1452566846", new Object[]{this, Integer.valueOf(i)});
            } else {
                ProjectDetailItemMainFragment.this.showPerformListFragment(false);
            }
        }

        @Override // cn.damai.trade.newtradeorder.ui.projectdetail.projectdetailitem.ui.view.ProjectItemStatusHelper.OnBottomViewClickListener
        public void onNeedPrivilege(int i) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "908644025")) {
                ipChange.ipc$dispatch("908644025", new Object[]{this, Integer.valueOf(i)});
                return;
            }
            ProjectDetailItemMainFragment projectDetailItemMainFragment = ProjectDetailItemMainFragment.this;
            projectDetailItemMainFragment.mSkuBean = null;
            projectDetailItemMainFragment.showPrivilegeCodeVerifyFragment(i);
        }

        @Override // cn.damai.trade.newtradeorder.ui.projectdetail.projectdetailitem.ui.view.ProjectItemStatusHelper.OnBottomViewClickListener
        public void onRegister(int i) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "-93089279")) {
                ipChange.ipc$dispatch("-93089279", new Object[]{this, Integer.valueOf(i)});
            } else {
                ProjectDetailItemMainFragment.this.showPerformListFragment(false);
            }
        }

        @Override // cn.damai.trade.newtradeorder.ui.projectdetail.projectdetailitem.ui.view.ProjectItemStatusHelper.OnBottomViewClickListener
        public void onSelectSeat() {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "1248072196")) {
                ipChange.ipc$dispatch("1248072196", new Object[]{this});
            } else {
                ProjectDetailItemMainFragment.this.handleChooseSeatPage();
            }
        }

        @Override // cn.damai.trade.newtradeorder.ui.projectdetail.projectdetailitem.ui.view.ProjectItemStatusHelper.OnBottomViewClickListener
        public void onSoldOut() {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "68748811")) {
                ipChange.ipc$dispatch("68748811", new Object[]{this});
            } else {
                ProjectDetailItemMainFragment.this.showPerformListFragment(false);
            }
        }

        @Override // cn.damai.trade.newtradeorder.ui.projectdetail.projectdetailitem.ui.view.ProjectItemStatusHelper.OnBottomViewClickListener
        public void onTimingCountDown() {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "-926618722")) {
                ipChange.ipc$dispatch("-926618722", new Object[]{this});
            } else {
                ProjectDetailItemMainFragment.this.processTimeCountDownClick();
            }
        }
    }

    /* compiled from: Taobao */
    /* renamed from: cn.damai.trade.newtradeorder.ui.projectdetail.projectdetailitem.ui.fragment.ProjectDetailItemMainFragment$f */
    /* loaded from: classes16.dex */
    public class View$OnClickListenerC2295f implements View.OnClickListener {
        private static transient /* synthetic */ IpChange $ipChange;

        View$OnClickListenerC2295f() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "1605751251")) {
                ipChange.ipc$dispatch("1605751251", new Object[]{this, view});
                return;
            }
            ProjectDetailItemMainFragment.this.timerAndStrategyTmPromptView.hideResetAttendees();
            ProjectDetailItemMainFragment.this.strategyClick();
        }
    }

    /* compiled from: Taobao */
    /* renamed from: cn.damai.trade.newtradeorder.ui.projectdetail.projectdetailitem.ui.fragment.ProjectDetailItemMainFragment$f0 */
    /* loaded from: classes8.dex */
    public class C2296f0 implements ProjectTitleBarPanel.OnUiClickListener {
        private static transient /* synthetic */ IpChange $ipChange;

        C2296f0() {
        }

        @Override // cn.damai.trade.newtradeorder.ui.projectdetail.projectdetailitem.ui.view.projectheader.ProjectTitleBarPanel.OnUiClickListener
        public void onActivityShareClick() {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "-415926288")) {
                ipChange.ipc$dispatch("-415926288", new Object[]{this});
                return;
            }
            ProjectDetailActivity projectDetailActivity = ProjectDetailItemMainFragment.this.mProjectDetailActivity;
            gw1.c(projectDetailActivity, ProjectDetailItemMainFragment.this.mProjectId + "", ProjectDetailItemMainFragment.this.mProjectStaticDataBean);
        }

        @Override // cn.damai.trade.newtradeorder.ui.projectdetail.projectdetailitem.ui.view.projectheader.ProjectTitleBarPanel.OnUiClickListener
        public void onBackClick() {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "1575630017")) {
                ipChange.ipc$dispatch("1575630017", new Object[]{this});
                return;
            }
            C0529c.e().x(pp2.u().f1(ProjectDetailItemMainFragment.this.mProjectId, true));
            if (ProjectDetailItemMainFragment.this.mIsFromPush && ProjectDetailItemMainFragment.this.mBackType != 1) {
                DMNav.from(ProjectDetailItemMainFragment.this.mProjectDetailActivity).toUri(NavUri.b(cs.n));
            }
            ProjectDetailItemMainFragment.this.mProjectDetailActivity.onBackPressed();
        }

        @Override // cn.damai.trade.newtradeorder.ui.projectdetail.projectdetailitem.ui.view.projectheader.ProjectTitleBarPanel.OnUiClickListener
        public void onCertInfoClick() {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "-699599028")) {
                ipChange.ipc$dispatch("-699599028", new Object[]{this});
                return;
            }
            C0529c.e().x(pp2.u().g1(ProjectDetailItemMainFragment.this.mProjectId, true));
            ProjectDetailItemMainFragment projectDetailItemMainFragment = ProjectDetailItemMainFragment.this;
            tv1.b(projectDetailItemMainFragment.mProjectDetailActivity, projectDetailItemMainFragment.mProjectId, projectDetailItemMainFragment.mProjectStaticDataBean);
        }

        @Override // cn.damai.trade.newtradeorder.ui.projectdetail.projectdetailitem.ui.view.projectheader.ProjectTitleBarPanel.OnUiClickListener
        public void onTitleBarClick() {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "-1081397259")) {
                ipChange.ipc$dispatch("-1081397259", new Object[]{this});
            } else if (ProjectDetailItemMainFragment.this.mAnchorManager != null) {
                ProjectDetailItemMainFragment.this.mTitleBarPanel.d(false);
                ProjectDetailItemMainFragment.this.isFixedAnchorVisible = false;
                ProjectDetailItemMainFragment projectDetailItemMainFragment = ProjectDetailItemMainFragment.this;
                projectDetailItemMainFragment.scrollToPosition(1, projectDetailItemMainFragment.getOffset());
                ProjectDetailItemMainFragment.this.hideFixedAnchorIndicator();
                ProjectDetailItemMainFragment.this.setCurAnchorPosition(0);
                ProjectDetailItemMainFragment.this.mLinearPullToRefreshView.setPullToRefreshEnabled(true);
            }
        }
    }

    /* compiled from: Taobao */
    /* renamed from: cn.damai.trade.newtradeorder.ui.projectdetail.projectdetailitem.ui.fragment.ProjectDetailItemMainFragment$g */
    /* loaded from: classes8.dex */
    public class C2297g implements ProjectSpecialBuyPromptView.SpecialBuyPromptListener {
        private static transient /* synthetic */ IpChange $ipChange;

        C2297g() {
        }

        @Override // cn.damai.trade.newtradeorder.ui.projectdetail.projectdetailitem.ui.view.ProjectSpecialBuyPromptView.SpecialBuyPromptListener
        public void onVipRefresh() {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "295835654")) {
                ipChange.ipc$dispatch("295835654", new Object[]{this});
            } else {
                ProjectDetailItemMainFragment.this.onRefresh();
            }
        }

        @Override // cn.damai.trade.newtradeorder.ui.projectdetail.projectdetailitem.ui.view.ProjectSpecialBuyPromptView.SpecialBuyPromptListener
        public void showVIPCreditExchange() {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "1801406603")) {
                ipChange.ipc$dispatch("1801406603", new Object[]{this});
            } else {
                ProjectDetailItemMainFragment.this.showVIPCreditExchangeFragment();
            }
        }
    }

    /* compiled from: Taobao */
    /* renamed from: cn.damai.trade.newtradeorder.ui.projectdetail.projectdetailitem.ui.fragment.ProjectDetailItemMainFragment$g0 */
    /* loaded from: classes8.dex */
    public class C2298g0 implements ProjectItemStatusHelper.OnProjectNotExistsListener {
        private static transient /* synthetic */ IpChange $ipChange;

        C2298g0() {
        }

        @Override // cn.damai.trade.newtradeorder.ui.projectdetail.projectdetailitem.ui.view.ProjectItemStatusHelper.OnProjectNotExistsListener
        public void onProjectNotExists() {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "-1272758491")) {
                ipChange.ipc$dispatch("-1272758491", new Object[]{this});
            } else {
                ProjectDetailItemMainFragment.this.reportProjectNotExitsFromHome();
            }
        }
    }

    /* compiled from: Taobao */
    /* renamed from: cn.damai.trade.newtradeorder.ui.projectdetail.projectdetailitem.ui.fragment.ProjectDetailItemMainFragment$h */
    /* loaded from: classes8.dex */
    public class C2299h implements OnTimeCountDownListener {
        private static transient /* synthetic */ IpChange $ipChange;

        C2299h() {
        }

        @Override // cn.damai.trade.newtradeorder.ui.projectdetail.projectdetailitem.helper.OnTimeCountDownListener
        public void onCountDownFinished(long j) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "-625943198")) {
                ipChange.ipc$dispatch("-625943198", new Object[]{this, Long.valueOf(j)});
                return;
            }
            ProjectDetailItemMainFragment.this.mHasCountDownFinished = true;
            ProjectDetailItemMainFragment.this.timeCountDownFinished();
        }

        @Override // cn.damai.trade.newtradeorder.ui.projectdetail.projectdetailitem.helper.OnTimeCountDownListener
        public void onCountDownStart(String str, String str2, String str3, String str4) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "1678681212")) {
                ipChange.ipc$dispatch("1678681212", new Object[]{this, str, str2, str3, str4});
            } else {
                ProjectDetailItemMainFragment.this.mHasCountDownFinished = false;
            }
        }

        @Override // cn.damai.trade.newtradeorder.ui.projectdetail.projectdetailitem.helper.OnTimeCountDownListener
        public void onCountDownTip(long j, String str, String str2, String str3, String str4) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "321248145")) {
                ipChange.ipc$dispatch("321248145", new Object[]{this, Long.valueOf(j), str, str2, str3, str4});
            } else if (ProjectDetailItemMainFragment.this.mProjectItemDataBean != null) {
                ProjectDetailItemMainFragment.this.mProjectItemDataBean.setCountDown(j);
            }
        }
    }

    /* compiled from: Taobao */
    /* renamed from: cn.damai.trade.newtradeorder.ui.projectdetail.projectdetailitem.ui.fragment.ProjectDetailItemMainFragment$h0 */
    /* loaded from: classes8.dex */
    public class C2300h0 implements CalendarsResolver.RemindMeListener {
        private static transient /* synthetic */ IpChange $ipChange;

        C2300h0() {
        }

        @Override // cn.damai.commonbusiness.calendar.remind.CalendarsResolver.RemindMeListener
        public void addRemindmeSuccess() {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "1051736854")) {
                ipChange.ipc$dispatch("1051736854", new Object[]{this});
                return;
            }
            C0529c.e().x(pp2.u().n(ProjectDetailItemMainFragment.this.mProjectId));
            ProjectDetailItemMainFragment.this.timerAndStagoryView.updateRemindMeBtnText(true);
            qv1.f(ProjectDetailItemMainFragment.this.mProjectDetailActivity, "添加日历提醒成功", "开抢前10分钟将收到手机日历提醒，可在系统日历中更改提醒时间");
        }

        @Override // cn.damai.commonbusiness.calendar.remind.CalendarsResolver.RemindMeListener
        public void candelRemindmeSuccess() {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "-390678812")) {
                ipChange.ipc$dispatch("-390678812", new Object[]{this});
                return;
            }
            C0529c.e().x(pp2.u().p(ProjectDetailItemMainFragment.this.mProjectId));
            ProjectDetailItemMainFragment.this.timerAndStagoryView.updateRemindMeBtnText(false);
            ToastUtil.i("取消提醒成功");
        }
    }

    /* compiled from: Taobao */
    /* renamed from: cn.damai.trade.newtradeorder.ui.projectdetail.projectdetailitem.ui.fragment.ProjectDetailItemMainFragment$i */
    /* loaded from: classes16.dex */
    public class View$OnClickListenerC2301i implements View.OnClickListener {
        private static transient /* synthetic */ IpChange $ipChange;

        View$OnClickListenerC2301i() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "-650312234")) {
                ipChange.ipc$dispatch("-650312234", new Object[]{this, view});
                return;
            }
            ProjectDetailItemMainFragment.this.specialBuyPromptView.hideResetAttendees();
            ProjectDetailItemMainFragment.this.strategyClick();
        }
    }

    /* compiled from: Taobao */
    /* renamed from: cn.damai.trade.newtradeorder.ui.projectdetail.projectdetailitem.ui.fragment.ProjectDetailItemMainFragment$i0 */
    /* loaded from: classes16.dex */
    public class View$OnClickListenerC2302i0 implements View.OnClickListener {
        private static transient /* synthetic */ IpChange $ipChange;

        View$OnClickListenerC2302i0() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "-1651643859")) {
                ipChange.ipc$dispatch("-1651643859", new Object[]{this, view});
                return;
            }
            e80.f(ProjectDetailItemMainFragment.this.mProjectDetailActivity);
            ProjectDetailItemMainFragment projectDetailItemMainFragment = ProjectDetailItemMainFragment.this;
            projectDetailItemMainFragment.dismissPopLayerFragment(projectDetailItemMainFragment.mPrivilegeCodeVerifyFragment);
        }
    }

    /* compiled from: Taobao */
    /* renamed from: cn.damai.trade.newtradeorder.ui.projectdetail.projectdetailitem.ui.fragment.ProjectDetailItemMainFragment$j */
    /* loaded from: classes16.dex */
    public class View$OnClickListenerC2303j implements View.OnClickListener {
        private static transient /* synthetic */ IpChange $ipChange;

        View$OnClickListenerC2303j() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "1460978135")) {
                ipChange.ipc$dispatch("1460978135", new Object[]{this, view});
            } else if (ProjectDetailItemMainFragment.this.mProjectStaticDataBean == null || ProjectDetailItemMainFragment.this.mProjectStaticDataBean.getItemBase() == null || !"true".equals(ProjectDetailItemMainFragment.this.mProjectStaticDataBean.getItemBase().getHasSkuPopup())) {
            } else {
                C0529c.e().x(pp2.u().F0(ProjectDetailItemMainFragment.this.mProjectId));
                if (ProjectDetailItemMainFragment.this.isLogin()) {
                    ProjectDetailItemMainFragment.this.popupSkuByPerformInfo();
                    hw1.f(false);
                    return;
                }
                ProjectDetailItemMainFragment.this.startLoginActivityForResult(4117);
            }
        }
    }

    /* compiled from: Taobao */
    /* renamed from: cn.damai.trade.newtradeorder.ui.projectdetail.projectdetailitem.ui.fragment.ProjectDetailItemMainFragment$j0 */
    /* loaded from: classes8.dex */
    public class C2304j0 implements GuideUtProvider {
        private static transient /* synthetic */ IpChange $ipChange;

        C2304j0() {
        }

        @Override // cn.damai.wantsee.GuideUtProvider
        @NonNull
        public Map<String, String> getGuideCloseBtnArgMap() {
            IpChange ipChange = $ipChange;
            return AndroidInstantRuntime.support(ipChange, "-268061374") ? (Map) ipChange.ipc$dispatch("-268061374", new Object[]{this}) : getGuideExposeArgMap();
        }

        @Override // cn.damai.wantsee.GuideUtProvider
        @NonNull
        public Map<String, String> getGuideExposeArgMap() {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "-1677338814")) {
                return (Map) ipChange.ipc$dispatch("-1677338814", new Object[]{this});
            }
            HashMap hashMap = new HashMap();
            hashMap.put("item_id", ProjectDetailItemMainFragment.this.mProjectId + "");
            return hashMap;
        }

        @Override // cn.damai.wantsee.GuideUtProvider
        @NonNull
        public Map<String, String> getGuideGoMineBtnArgMap() {
            IpChange ipChange = $ipChange;
            return AndroidInstantRuntime.support(ipChange, "2134719969") ? (Map) ipChange.ipc$dispatch("2134719969", new Object[]{this}) : getGuideExposeArgMap();
        }

        @Override // cn.damai.wantsee.GuideUtProvider
        @NonNull
        public String getSpmB() {
            IpChange ipChange = $ipChange;
            return AndroidInstantRuntime.support(ipChange, "691341723") ? (String) ipChange.ipc$dispatch("691341723", new Object[]{this}) : gb.PROJECT_PAGE;
        }
    }

    /* compiled from: Taobao */
    /* renamed from: cn.damai.trade.newtradeorder.ui.projectdetail.projectdetailitem.ui.fragment.ProjectDetailItemMainFragment$k */
    /* loaded from: classes16.dex */
    public class View$OnClickListenerC2305k implements View.OnClickListener {
        private static transient /* synthetic */ IpChange $ipChange;

        View$OnClickListenerC2305k() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            ProjectStaticItemBaseBean itemBase;
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "664725997")) {
                ipChange.ipc$dispatch("664725997", new Object[]{this, view});
            } else if (ProjectDetailItemMainFragment.this.mProjectStaticDataBean == null || (itemBase = ProjectDetailItemMainFragment.this.mProjectStaticDataBean.getItemBase()) == null) {
            } else {
                ProjectDetailItemMainFragment projectDetailItemMainFragment = ProjectDetailItemMainFragment.this;
                tv1.p(projectDetailItemMainFragment.mProjectDetailActivity, projectDetailItemMainFragment.mProjectId, itemBase.getListSeatImg(), itemBase.getListPerformSeatImg(), itemBase.isHasNoneSeatImg());
            }
        }
    }

    /* compiled from: Taobao */
    /* renamed from: cn.damai.trade.newtradeorder.ui.projectdetail.projectdetailitem.ui.fragment.ProjectDetailItemMainFragment$k0 */
    /* loaded from: classes16.dex */
    public class DialogInterface$OnClickListenerC2306k0 implements DialogInterface.OnClickListener {
        private static transient /* synthetic */ IpChange $ipChange;

        DialogInterface$OnClickListenerC2306k0() {
        }

        @Override // android.content.DialogInterface.OnClickListener
        public void onClick(DialogInterface dialogInterface, int i) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "1488337504")) {
                ipChange.ipc$dispatch("1488337504", new Object[]{this, dialogInterface, Integer.valueOf(i)});
            } else if (ProjectDetailItemMainFragment.this.getContext() != null) {
                ProjectDetailItemMainFragment.this.getContext().startActivity(vl1.a(ProjectDetailItemMainFragment.this.getContext()));
                C0529c.e().x(pp2.u().w(ProjectDetailItemMainFragment.this.mProjectId));
            }
        }
    }

    /* compiled from: Taobao */
    /* renamed from: cn.damai.trade.newtradeorder.ui.projectdetail.projectdetailitem.ui.fragment.ProjectDetailItemMainFragment$l */
    /* loaded from: classes8.dex */
    public class C2307l implements OnRecommendItemClickListener {
        private static transient /* synthetic */ IpChange $ipChange;

        C2307l() {
        }

        @Override // cn.damai.trade.newtradeorder.ui.projectdetail.listeners.OnRecommendItemClickListener
        public void onRecommendItemClick(int i) {
            ProjectRecommendBean projectRecommendBean;
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "93982142")) {
                ipChange.ipc$dispatch("93982142", new Object[]{this, Integer.valueOf(i)});
                return;
            }
            int e = wh2.e(ProjectDetailItemMainFragment.this.mRecommendItems);
            if (e <= 0 || i < 0 || i >= e || (projectRecommendBean = (ProjectRecommendBean) ProjectDetailItemMainFragment.this.mRecommendItems.get(i)) == null) {
                return;
            }
            ProjectItemBean projectItemBean = projectRecommendBean.project;
            if (projectItemBean != null) {
                ProjectDetailItemMainFragment projectDetailItemMainFragment = ProjectDetailItemMainFragment.this;
                tv1.i(projectDetailItemMainFragment.mProjectDetailActivity, projectDetailItemMainFragment.mProjectId, i, projectItemBean);
                return;
            }
            ProjectFreeTicketBean projectFreeTicketBean = projectRecommendBean.freeTicket;
            if (projectFreeTicketBean != null) {
                tv1.h(ProjectDetailItemMainFragment.this.mProjectDetailActivity, projectFreeTicketBean.url);
            }
        }
    }

    /* compiled from: Taobao */
    /* renamed from: cn.damai.trade.newtradeorder.ui.projectdetail.projectdetailitem.ui.fragment.ProjectDetailItemMainFragment$l0 */
    /* loaded from: classes16.dex */
    public class DialogInterface$OnDismissListenerC2308l0 implements DialogInterface.OnDismissListener {
        private static transient /* synthetic */ IpChange $ipChange;
        final /* synthetic */ long a;

        DialogInterface$OnDismissListenerC2308l0(long j) {
            this.a = j;
        }

        @Override // android.content.DialogInterface.OnDismissListener
        public void onDismiss(DialogInterface dialogInterface) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "61027462")) {
                ipChange.ipc$dispatch("61027462", new Object[]{this, dialogInterface});
            } else {
                pp2.u().V1(String.valueOf(ProjectDetailItemMainFragment.this.mProjectId), this.a);
            }
        }
    }

    /* compiled from: Taobao */
    /* renamed from: cn.damai.trade.newtradeorder.ui.projectdetail.projectdetailitem.ui.fragment.ProjectDetailItemMainFragment$m */
    /* loaded from: classes8.dex */
    public class C2309m implements OnItemExtendInfoItemClickListener {
        private static transient /* synthetic */ IpChange $ipChange;

        C2309m() {
        }

        @Override // cn.damai.trade.newtradeorder.ui.projectdetail.projectdetailitem.listeners.OnItemExtendInfoItemClickListener
        public IRichTextManager getRichTextManager(int i) {
            IpChange ipChange = $ipChange;
            return AndroidInstantRuntime.support(ipChange, "866863311") ? (IRichTextManager) ipChange.ipc$dispatch("866863311", new Object[]{this, Integer.valueOf(i)}) : ProjectDetailItemMainFragment.this.mProjectDataHolderManager.r(i);
        }

        @Override // cn.damai.trade.newtradeorder.ui.projectdetail.projectdetailitem.listeners.OnItemExtendInfoItemClickListener
        public void onExtendInfoImageItemClick(View view, int i, String str, String str2) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "667593026")) {
                ipChange.ipc$dispatch("667593026", new Object[]{this, view, Integer.valueOf(i), str, str2});
            } else {
                ProjectDetailItemMainFragment.this.onExtendInfoItemClick(view, i, str, str2);
            }
        }

        @Override // cn.damai.trade.newtradeorder.ui.projectdetail.projectdetailitem.listeners.OnItemExtendInfoItemClickListener
        public void onExtendInfoMoreBtnClick(int i) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "234516301")) {
                ipChange.ipc$dispatch("234516301", new Object[]{this, Integer.valueOf(i)});
                return;
            }
            ProjectDetailItemMainFragment.this.onMoreExtendInfoBtnClickListener(i, -1);
            ProjectDetailItemMainFragment.this.startWantSeeGuideTimer(WantSeeGuideTips.AbstractC1546b.C1549c.INSTANCE);
        }
    }

    /* compiled from: Taobao */
    /* renamed from: cn.damai.trade.newtradeorder.ui.projectdetail.projectdetailitem.ui.fragment.ProjectDetailItemMainFragment$m0 */
    /* loaded from: classes16.dex */
    public class View$OnClickListenerC2310m0 implements View.OnClickListener {
        private static transient /* synthetic */ IpChange $ipChange;

        View$OnClickListenerC2310m0(ProjectDetailItemMainFragment projectDetailItemMainFragment) {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "-1796416975")) {
                ipChange.ipc$dispatch("-1796416975", new Object[]{this, view});
            }
        }
    }

    /* compiled from: Taobao */
    /* renamed from: cn.damai.trade.newtradeorder.ui.projectdetail.projectdetailitem.ui.fragment.ProjectDetailItemMainFragment$n */
    /* loaded from: classes8.dex */
    public class C2311n implements OnCommonProblemsListener {
        private static transient /* synthetic */ IpChange $ipChange;

        C2311n() {
        }

        @Override // cn.damai.trade.newtradeorder.ui.projectdetail.projectdetailitem.listeners.OnSectionMoreClickListener
        public void onMoreClick(int i, int i2, int i3) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "-24221780")) {
                ipChange.ipc$dispatch("-24221780", new Object[]{this, Integer.valueOf(i), Integer.valueOf(i2), Integer.valueOf(i3)});
                return;
            }
            C0529c.e().x(pp2.u().m0(ProjectDetailItemMainFragment.this.mProjectId));
            ProjectDetailItemMainFragment.this.setAliMeParams(AliMeUtil.FROM_PROJECT_DETAIL, "");
            ProjectDetailItemMainFragment.this.getAliMeTokenAndEnter();
        }

        @Override // cn.damai.trade.newtradeorder.ui.projectdetail.projectdetailitem.listeners.OnCommonProblemsListener
        public void onProblemItemClick(int i, String str) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "1775344195")) {
                ipChange.ipc$dispatch("1775344195", new Object[]{this, Integer.valueOf(i), str});
                return;
            }
            C0529c.e().x(pp2.u().l0(ProjectDetailItemMainFragment.this.mProjectId, i));
            ProjectDetailItemMainFragment.this.setAliMeParams(AliMeUtil.FROM_PROJECT_COMMON_PROBLEM, str);
            ProjectDetailItemMainFragment.this.getAliMeTokenAndEnter();
        }
    }

    /* compiled from: Taobao */
    /* renamed from: cn.damai.trade.newtradeorder.ui.projectdetail.projectdetailitem.ui.fragment.ProjectDetailItemMainFragment$n0 */
    /* loaded from: classes16.dex */
    public class View$OnClickListenerC2312n0 implements View.OnClickListener {
        private static transient /* synthetic */ IpChange $ipChange;

        View$OnClickListenerC2312n0() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "314873394")) {
                ipChange.ipc$dispatch("314873394", new Object[]{this, view});
                return;
            }
            ProjectDetailItemMainFragment.this.mWantTipsContainer.removeAllViews();
            ProjectDetailItemMainFragment.this.mWantTipsContainer.setVisibility(8);
        }
    }

    /* compiled from: Taobao */
    /* renamed from: cn.damai.trade.newtradeorder.ui.projectdetail.projectdetailitem.ui.fragment.ProjectDetailItemMainFragment$o */
    /* loaded from: classes8.dex */
    public class C2313o implements OnEvaluateMineListener {
        private static transient /* synthetic */ IpChange $ipChange;

        C2313o() {
        }

        @Override // cn.damai.trade.newtradeorder.ui.projectdetail.listeners.OnEvaluateMineListener
        public void onClick(View view, String str, String str2) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "942058117")) {
                ipChange.ipc$dispatch("942058117", new Object[]{this, view, str, str2});
                return;
            }
            ProjectDetailItemMainFragment projectDetailItemMainFragment = ProjectDetailItemMainFragment.this;
            tv1.m(projectDetailItemMainFragment.mProjectDetailActivity, str, projectDetailItemMainFragment.mProjectId);
        }
    }

    /* compiled from: Taobao */
    /* renamed from: cn.damai.trade.newtradeorder.ui.projectdetail.projectdetailitem.ui.fragment.ProjectDetailItemMainFragment$o0 */
    /* loaded from: classes16.dex */
    public class View$OnClickListenerC2314o0 implements View.OnClickListener {
        private static transient /* synthetic */ IpChange $ipChange;

        View$OnClickListenerC2314o0() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "242486836")) {
                ipChange.ipc$dispatch("242486836", new Object[]{this, view});
                return;
            }
            ProjectDetailItemMainFragment projectDetailItemMainFragment = ProjectDetailItemMainFragment.this;
            projectDetailItemMainFragment.dismissPopLayerFragment(projectDetailItemMainFragment.mPopLayerFragment);
        }
    }

    /* compiled from: Taobao */
    /* renamed from: cn.damai.trade.newtradeorder.ui.projectdetail.projectdetailitem.ui.fragment.ProjectDetailItemMainFragment$p */
    /* loaded from: classes8.dex */
    public class C2315p implements OnDiscussionClickListener {
        private static transient /* synthetic */ IpChange $ipChange;

        C2315p(ProjectDetailItemMainFragment projectDetailItemMainFragment) {
        }

        @Override // cn.damai.trade.newtradeorder.ui.projectdetail.projectdetailitem.listeners.OnDiscussionClickListener
        public void onDiscussionClick(View view) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "-1668605846")) {
                ipChange.ipc$dispatch("-1668605846", new Object[]{this, view});
            }
        }
    }

    /* compiled from: Taobao */
    /* renamed from: cn.damai.trade.newtradeorder.ui.projectdetail.projectdetailitem.ui.fragment.ProjectDetailItemMainFragment$p0 */
    /* loaded from: classes8.dex */
    public class C2316p0 implements ProjectDialogHelper.ProjectDialogListener {
        private static transient /* synthetic */ IpChange $ipChange;

        C2316p0() {
        }

        @Override // cn.damai.trade.newtradeorder.ui.projectdetail.projectdetailitem.ui.view.ProjectDialogHelper.ProjectDialogListener
        public void excuteNATRequest(String str) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "-84585202")) {
                ipChange.ipc$dispatch("-84585202", new Object[]{this, str});
            } else {
                ((ProjectItemPresenter) ProjectDetailItemMainFragment.this.mPresenter).getProjectNATData(str);
            }
        }
    }

    /* compiled from: Taobao */
    /* renamed from: cn.damai.trade.newtradeorder.ui.projectdetail.projectdetailitem.ui.fragment.ProjectDetailItemMainFragment$q */
    /* loaded from: classes8.dex */
    public class C2317q implements OnSectionMoreClickListener {
        private static transient /* synthetic */ IpChange $ipChange;

        C2317q() {
        }

        @Override // cn.damai.trade.newtradeorder.ui.projectdetail.projectdetailitem.listeners.OnSectionMoreClickListener
        public void onMoreClick(int i, int i2, int i3) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "609830959")) {
                ipChange.ipc$dispatch("609830959", new Object[]{this, Integer.valueOf(i), Integer.valueOf(i2), Integer.valueOf(i3)});
            } else if (i == 2) {
                C0529c.e().x(pp2.u().n0(ProjectDetailItemMainFragment.this.mProjectId));
                ProjectDetailItemMainFragment projectDetailItemMainFragment = ProjectDetailItemMainFragment.this;
                tv1.n(projectDetailItemMainFragment.mProjectDetailActivity, projectDetailItemMainFragment.mProjectId, projectDetailItemMainFragment.getIpId(), ProjectDetailItemMainFragment.this.getTourId(), "");
            } else if (i == 3) {
                C0529c.e().x(pp2.u().D0(ProjectDetailItemMainFragment.this.mProjectId));
                ProjectDetailItemMainFragment.this.showNoticeFragment(0);
            } else if (i == 4) {
                C0529c.e().x(pp2.u().U0(ProjectDetailItemMainFragment.this.mProjectId));
                ProjectDetailItemMainFragment.this.showNoticeFragment(1);
            } else if (i == 0) {
                ProjectDetailItemMainFragment.this.onMoreExtendInfoBtnClickListener(i2, i3);
            }
        }
    }

    /* compiled from: Taobao */
    /* renamed from: cn.damai.trade.newtradeorder.ui.projectdetail.projectdetailitem.ui.fragment.ProjectDetailItemMainFragment$q0 */
    /* loaded from: classes8.dex */
    public class C2318q0 implements ShareManagerImpl {
        private static transient /* synthetic */ IpChange $ipChange;

        C2318q0() {
        }

        @Override // cn.damai.trade.newtradeorder.ui.projectdetail.projectdetailitem.helper.ShareManagerImpl
        public void createPic() {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "887785571")) {
                ipChange.ipc$dispatch("887785571", new Object[]{this});
                return;
            }
            ProjectDetailItemMainFragment projectDetailItemMainFragment = ProjectDetailItemMainFragment.this;
            gw1.a(projectDetailItemMainFragment.mProjectDetailActivity, projectDetailItemMainFragment.mProjectStaticDataBean, ProjectDetailItemMainFragment.this.mProjectId);
        }

        @Override // cn.damai.trade.newtradeorder.ui.projectdetail.projectdetailitem.helper.ShareManagerImpl
        public void shareFriend() {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "-1002386796")) {
                ipChange.ipc$dispatch("-1002386796", new Object[]{this});
                return;
            }
            ProjectDetailItemMainFragment projectDetailItemMainFragment = ProjectDetailItemMainFragment.this;
            ProjectDetailActivity projectDetailActivity = projectDetailItemMainFragment.mProjectDetailActivity;
            ProjectStaticDataBean projectStaticDataBean = projectDetailItemMainFragment.mProjectStaticDataBean;
            ProjectDetailItemMainFragment projectDetailItemMainFragment2 = ProjectDetailItemMainFragment.this;
            gw1.e(1, projectDetailActivity, projectStaticDataBean, projectDetailItemMainFragment2.mProjectId, projectDetailItemMainFragment2.mSinaSharePath);
        }

        @Override // cn.damai.trade.newtradeorder.ui.projectdetail.projectdetailitem.helper.ShareManagerImpl
        public void shareWX() {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "907081233")) {
                ipChange.ipc$dispatch("907081233", new Object[]{this});
                return;
            }
            ProjectDetailItemMainFragment projectDetailItemMainFragment = ProjectDetailItemMainFragment.this;
            ProjectDetailActivity projectDetailActivity = projectDetailItemMainFragment.mProjectDetailActivity;
            ProjectStaticDataBean projectStaticDataBean = projectDetailItemMainFragment.mProjectStaticDataBean;
            ProjectDetailItemMainFragment projectDetailItemMainFragment2 = ProjectDetailItemMainFragment.this;
            gw1.e(0, projectDetailActivity, projectStaticDataBean, projectDetailItemMainFragment2.mProjectId, projectDetailItemMainFragment2.mSinaSharePath);
        }
    }

    /* compiled from: Taobao */
    /* renamed from: cn.damai.trade.newtradeorder.ui.projectdetail.projectdetailitem.ui.fragment.ProjectDetailItemMainFragment$r */
    /* loaded from: classes16.dex */
    public class View$OnClickListenerC2319r implements View.OnClickListener {
        private static transient /* synthetic */ IpChange $ipChange;

        View$OnClickListenerC2319r() {
        }

        @Override // android.view.View.OnClickListener
        @SuppressLint({"NewApi"})
        public void onClick(View view) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "-1736110604")) {
                ipChange.ipc$dispatch("-1736110604", new Object[]{this, view});
            } else {
                ProjectDetailItemMainFragment.this.requestFavorite(true);
            }
        }
    }

    /* compiled from: Taobao */
    /* renamed from: cn.damai.trade.newtradeorder.ui.projectdetail.projectdetailitem.ui.fragment.ProjectDetailItemMainFragment$r0 */
    /* loaded from: classes16.dex */
    public class DialogInterface$OnClickListenerC2320r0 implements DialogInterface.OnClickListener {
        private static transient /* synthetic */ IpChange $ipChange;

        DialogInterface$OnClickListenerC2320r0() {
        }

        @Override // android.content.DialogInterface.OnClickListener
        public void onClick(DialogInterface dialogInterface, int i) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "-1428164924")) {
                ipChange.ipc$dispatch("-1428164924", new Object[]{this, dialogInterface, Integer.valueOf(i)});
            } else {
                ProjectDetailItemMainFragment.this.getProjectDetailData(1);
            }
        }
    }

    /* compiled from: Taobao */
    /* renamed from: cn.damai.trade.newtradeorder.ui.projectdetail.projectdetailitem.ui.fragment.ProjectDetailItemMainFragment$s */
    /* loaded from: classes16.dex */
    public class View$OnClickListenerC2321s implements View.OnClickListener {
        private static transient /* synthetic */ IpChange $ipChange;

        View$OnClickListenerC2321s() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "375179765")) {
                ipChange.ipc$dispatch("375179765", new Object[]{this, view});
                return;
            }
            InFieldCommentsBean inFieldCommentsBean = null;
            try {
                inFieldCommentsBean = (InFieldCommentsBean) view.getTag();
            } catch (Exception e) {
                e.printStackTrace();
            }
            if (inFieldCommentsBean == null) {
                return;
            }
            if (!inFieldCommentsBean.isTypeStrategy() && !inFieldCommentsBean.isCanDowngradeToStrategy()) {
                if (!inFieldCommentsBean.isTypeGROUP() || TextUtils.isEmpty(inFieldCommentsBean.groupJumpUrl)) {
                    return;
                }
                C0529c e2 = C0529c.e();
                pp2 u = pp2.u();
                e2.x(u.x2(ProjectDetailItemMainFragment.this.mProjectId + "", inFieldCommentsBean, inFieldCommentsBean.index));
                NavProxy.from(ProjectDetailItemMainFragment.this.mActivity).toUri(inFieldCommentsBean.groupJumpUrl);
                return;
            }
            Bundle bundle = new Bundle();
            bundle.putString("contentId", inFieldCommentsBean.id);
            NavProxy.from(ProjectDetailItemMainFragment.this.mActivity).withExtras(bundle).toUri(INavUri.page(cs.DISCOVER_CONTENT_DETAIL));
            C0529c e3 = C0529c.e();
            pp2 u2 = pp2.u();
            e3.x(u2.x2(ProjectDetailItemMainFragment.this.mProjectId + "", inFieldCommentsBean, inFieldCommentsBean.index));
        }
    }

    /* compiled from: Taobao */
    /* loaded from: classes16.dex */
    public class s0 implements DialogInterface.OnClickListener {
        private static transient /* synthetic */ IpChange $ipChange;

        s0() {
        }

        @Override // android.content.DialogInterface.OnClickListener
        public void onClick(DialogInterface dialogInterface, int i) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "-458583901")) {
                ipChange.ipc$dispatch("-458583901", new Object[]{this, dialogInterface, Integer.valueOf(i)});
            } else {
                ProjectDetailItemMainFragment.this.scrollToRecommend();
            }
        }
    }

    /* compiled from: Taobao */
    /* renamed from: cn.damai.trade.newtradeorder.ui.projectdetail.projectdetailitem.ui.fragment.ProjectDetailItemMainFragment$t */
    /* loaded from: classes16.dex */
    public class View$OnClickListenerC2322t implements View.OnClickListener {
        private static transient /* synthetic */ IpChange $ipChange;

        View$OnClickListenerC2322t() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "-1808497162")) {
                ipChange.ipc$dispatch("-1808497162", new Object[]{this, view});
                return;
            }
            ProjectDetailItemMainFragment projectDetailItemMainFragment = ProjectDetailItemMainFragment.this;
            projectDetailItemMainFragment.dismissPopLayerFragment(projectDetailItemMainFragment.detailFragment);
        }
    }

    /* compiled from: Taobao */
    /* loaded from: classes8.dex */
    public class t0 implements Action<Object> {
        private static transient /* synthetic */ IpChange $ipChange;

        t0() {
        }

        @Override // cn.damai.message.observer.Action
        public void call(Object obj) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "-48567078")) {
                ipChange.ipc$dispatch("-48567078", new Object[]{this, obj});
            } else {
                ProjectDetailItemMainFragment.this.onPraiseViewOnClick((CommentsItemBean) obj);
            }
        }
    }

    /* compiled from: Taobao */
    /* renamed from: cn.damai.trade.newtradeorder.ui.projectdetail.projectdetailitem.ui.fragment.ProjectDetailItemMainFragment$u */
    /* loaded from: classes16.dex */
    public class HandlerC2323u extends Handler {
        private static transient /* synthetic */ IpChange $ipChange;

        HandlerC2323u() {
        }

        @Override // android.os.Handler
        public void handleMessage(Message message) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "-969311336")) {
                ipChange.ipc$dispatch("-969311336", new Object[]{this, message});
                return;
            }
            super.handleMessage(message);
            int i = message.what;
            if ((i == 102 || i == 103) && ProjectDetailItemMainFragment.this.mFlvPopupLayer != null && ProjectDetailItemMainFragment.this.mFlvPopupLayer.getVisibility() == 0) {
                ProjectDetailItemMainFragment.this.mFlvPopupLayer.setVisibility(8);
            }
        }
    }

    /* compiled from: Taobao */
    /* loaded from: classes8.dex */
    public class u0 implements ProjectDialogShowListener {
        private static transient /* synthetic */ IpChange $ipChange;

        u0() {
        }

        @Override // cn.damai.trade.newtradeorder.ui.projectdetail.projectdetailitem.listeners.ProjectDialogShowListener
        public void dialogShowBack() {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "1630630385")) {
                ipChange.ipc$dispatch("1630630385", new Object[]{this});
            } else {
                ProjectDetailItemMainFragment.this.dismissScreenShotShare();
            }
        }
    }

    /* compiled from: Taobao */
    /* renamed from: cn.damai.trade.newtradeorder.ui.projectdetail.projectdetailitem.ui.fragment.ProjectDetailItemMainFragment$v */
    /* loaded from: classes16.dex */
    public class View$OnClickListenerC2324v implements View.OnClickListener {
        private static transient /* synthetic */ IpChange $ipChange;

        View$OnClickListenerC2324v() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "1690217996")) {
                ipChange.ipc$dispatch("1690217996", new Object[]{this, view});
                return;
            }
            ProjectDetailItemMainFragment projectDetailItemMainFragment = ProjectDetailItemMainFragment.this;
            projectDetailItemMainFragment.dismissPopLayerFragment(projectDetailItemMainFragment.detailFragment);
        }
    }

    /* compiled from: Taobao */
    /* loaded from: classes8.dex */
    public class v0 implements ScreenShotDetector.IScreenShotExtraListener {
        private static transient /* synthetic */ IpChange $ipChange;

        v0() {
        }

        @Override // cn.damai.commonbusiness.screenshot.ScreenShotDetector.IScreenShotExtraListener
        public void onDetected(String str, Activity activity) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "1196456409")) {
                ipChange.ipc$dispatch("1196456409", new Object[]{this, str, activity});
            } else if (ProjectDetailItemMainFragment.this.mIsLoading) {
                ProjectDetailItemMainFragment.this.startSreenShotPage();
            } else if (ProjectDetailItemMainFragment.this.mProjectDetailDataBean == null) {
                ProjectDetailItemMainFragment.this.startSreenShotPage();
            } else if (ProjectDetailItemMainFragment.this.isHotProject()) {
                ProjectDetailItemMainFragment.this.startSreenShotPage();
            } else {
                if (ProjectDetailItemMainFragment.this.mDialogPanel != null) {
                    if (ProjectDetailItemMainFragment.this.mDialogPanel.t()) {
                        ProjectDetailItemMainFragment.this.startSreenShotPage();
                        return;
                    } else if (ProjectDetailItemMainFragment.this.mDialogPanel.r()) {
                        ProjectDetailItemMainFragment.this.startSreenShotPage();
                        return;
                    }
                }
                ProjectDetailItemMainFragment.this.showSreenSharePage();
            }
        }
    }

    /* compiled from: Taobao */
    /* renamed from: cn.damai.trade.newtradeorder.ui.projectdetail.projectdetailitem.ui.fragment.ProjectDetailItemMainFragment$w */
    /* loaded from: classes16.dex */
    public class View$OnClickListenerC2325w implements View.OnClickListener {
        private static transient /* synthetic */ IpChange $ipChange;

        View$OnClickListenerC2325w() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "-493458931")) {
                ipChange.ipc$dispatch("-493458931", new Object[]{this, view});
                return;
            }
            ProjectDetailItemMainFragment projectDetailItemMainFragment = ProjectDetailItemMainFragment.this;
            projectDetailItemMainFragment.dismissPopLayerFragment(projectDetailItemMainFragment.mPopLayerFragment);
        }
    }

    /* compiled from: Taobao */
    /* loaded from: classes16.dex */
    public class w0 extends CountDownTimer {
        private static transient /* synthetic */ IpChange $ipChange;
        final /* synthetic */ WantSeeGuideTips.AbstractC1546b a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        w0(long j, long j2, WantSeeGuideTips.AbstractC1546b abstractC1546b) {
            super(j, j2);
            this.a = abstractC1546b;
        }

        @Override // android.os.CountDownTimer
        public void onFinish() {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "-1080117683")) {
                ipChange.ipc$dispatch("-1080117683", new Object[]{this});
                return;
            }
            if (ProjectDetailItemMainFragment.this.wantSeeTips != null) {
                ProjectDetailItemMainFragment.this.wantSeeTips.cancel();
            }
            if (ProjectDetailItemMainFragment.this.isBottomTimerAndStrategyShowing()) {
                return;
            }
            ((FrameLayout.LayoutParams) ProjectDetailItemMainFragment.this.wantSeeGuideTips.getLayoutParams()).gravity = BadgeDrawable.BOTTOM_START;
            ProjectDetailItemMainFragment.this.wantSeeGuideTips.setScenesSource(this.a);
            ProjectDetailItemMainFragment.this.wantSeeGuideTips.setProjectId(Long.valueOf(ProjectDetailItemMainFragment.this.mProjectId));
            ProjectDetailItemMainFragment.this.wantSeeGuideTips.showAnim();
            WantSeeGuideTips.Companion.b(true);
        }

        @Override // android.os.CountDownTimer
        public void onTick(long j) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "80477025")) {
                ipChange.ipc$dispatch("80477025", new Object[]{this, Long.valueOf(j)});
            }
        }
    }

    /* compiled from: Taobao */
    /* renamed from: cn.damai.trade.newtradeorder.ui.projectdetail.projectdetailitem.ui.fragment.ProjectDetailItemMainFragment$x */
    /* loaded from: classes8.dex */
    public class C2326x implements OnTimeCountDownListener {
        private static transient /* synthetic */ IpChange $ipChange;

        C2326x() {
        }

        @Override // cn.damai.trade.newtradeorder.ui.projectdetail.projectdetailitem.helper.OnTimeCountDownListener
        public void onCountDownFinished(long j) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "-1648519077")) {
                ipChange.ipc$dispatch("-1648519077", new Object[]{this, Long.valueOf(j)});
                return;
            }
            ProjectDetailItemMainFragment.this.mHasCountDownFinished = true;
            ProjectDetailItemMainFragment.this.timeCountDownFinished();
        }

        @Override // cn.damai.trade.newtradeorder.ui.projectdetail.projectdetailitem.helper.OnTimeCountDownListener
        public void onCountDownStart(String str, String str2, String str3, String str4) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "1538454261")) {
                ipChange.ipc$dispatch("1538454261", new Object[]{this, str, str2, str3, str4});
                return;
            }
            ProjectDetailItemMainFragment.this.mHasCountDownFinished = false;
            ProjectDetailItemMainFragment.this.timerAndStrategyTmPromptView.setCountDownTime(str, str2, str3, str4);
        }

        @Override // cn.damai.trade.newtradeorder.ui.projectdetail.projectdetailitem.helper.OnTimeCountDownListener
        public void onCountDownTip(long j, String str, String str2, String str3, String str4) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "1425103352")) {
                ipChange.ipc$dispatch("1425103352", new Object[]{this, Long.valueOf(j), str, str2, str3, str4});
                return;
            }
            if (ProjectDetailItemMainFragment.this.mProjectItemDataBean != null) {
                ProjectDetailItemMainFragment.this.mProjectItemDataBean.setCountDown(j);
            }
            ProjectDetailItemMainFragment.this.timerAndStrategyTmPromptView.setCountDownTime(str, str2, str3, str4);
        }
    }

    /* compiled from: Taobao */
    /* loaded from: classes8.dex */
    public class x0 implements OnHeadClickListener {
        private static transient /* synthetic */ IpChange $ipChange;

        x0() {
        }

        @Override // cn.damai.trade.newtradeorder.ui.projectdetail.projectdetailitem.ui.view.projectheader.OnHeadClickListener
        public void onLoadedPosterPic(String str, Bitmap bitmap, boolean z) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "-754777224")) {
                ipChange.ipc$dispatch("-754777224", new Object[]{this, str, bitmap, Boolean.valueOf(z)});
            } else {
                ProjectDetailItemMainFragment.this.setProjectDetailMaskLayerImage(str, bitmap, z);
            }
        }

        @Override // cn.damai.trade.newtradeorder.ui.projectdetail.projectdetailitem.ui.view.projectheader.OnHeadClickListener
        public void onMarketStallClick() {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "-474956442")) {
                ipChange.ipc$dispatch("-474956442", new Object[]{this});
            } else {
                ProjectDetailItemMainFragment.this.toMarketStall();
            }
        }

        @Override // cn.damai.trade.newtradeorder.ui.projectdetail.projectdetailitem.ui.view.projectheader.OnHeadClickListener
        public void onNoticeClick() {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "1106490160")) {
                ipChange.ipc$dispatch("1106490160", new Object[]{this});
                return;
            }
            C0529c.e().x(pp2.u().C0(ProjectDetailItemMainFragment.this.mProjectId));
            ProjectDetailItemMainFragment.this.showProjectNoticeFragment();
        }

        @Override // cn.damai.trade.newtradeorder.ui.projectdetail.projectdetailitem.ui.view.projectheader.OnHeadClickListener
        public void onPosterClick() {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "-740436827")) {
                ipChange.ipc$dispatch("-740436827", new Object[]{this});
            } else {
                ProjectDetailItemMainFragment.this.mOnProjectPosterClickListener.onClick(null);
            }
        }

        @Override // cn.damai.trade.newtradeorder.ui.projectdetail.projectdetailitem.ui.view.projectheader.OnHeadClickListener
        public void onPromotionTagsClick() {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "-1353962818")) {
                ipChange.ipc$dispatch("-1353962818", new Object[]{this});
            } else {
                ProjectDetailItemMainFragment.this.mOnPromotionDetailClickListener.onClick(null);
            }
        }

        @Override // cn.damai.trade.newtradeorder.ui.projectdetail.projectdetailitem.ui.view.projectheader.OnHeadClickListener
        public void onRankListClick() {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "1158856322")) {
                ipChange.ipc$dispatch("1158856322", new Object[]{this});
            } else {
                ProjectDetailItemMainFragment.this.toRankListPage();
            }
        }

        @Override // cn.damai.trade.newtradeorder.ui.projectdetail.projectdetailitem.ui.view.projectheader.OnHeadClickListener
        public void onScoreBottomTagClick(ProjectRatingContentLabelBean projectRatingContentLabelBean) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "-479409253")) {
                ipChange.ipc$dispatch("-479409253", new Object[]{this, projectRatingContentLabelBean});
            } else if (projectRatingContentLabelBean == null) {
            } else {
                ProjectDetailItemMainFragment projectDetailItemMainFragment = ProjectDetailItemMainFragment.this;
                tv1.o(projectDetailItemMainFragment.mActivity, projectDetailItemMainFragment.mProjectId, projectDetailItemMainFragment.getIpId(), ProjectDetailItemMainFragment.this.getTourId(), projectRatingContentLabelBean.labelName, projectRatingContentLabelBean.labelType, projectRatingContentLabelBean.labelId);
            }
        }

        @Override // cn.damai.trade.newtradeorder.ui.projectdetail.projectdetailitem.ui.view.projectheader.OnHeadClickListener
        public void onScoreCommentClick(String str, String str2, String str3) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "-141853021")) {
                ipChange.ipc$dispatch("-141853021", new Object[]{this, str, str2, str3});
                return;
            }
            ProjectDetailItemMainFragment projectDetailItemMainFragment = ProjectDetailItemMainFragment.this;
            tv1.n(projectDetailItemMainFragment.mActivity, projectDetailItemMainFragment.mProjectId, projectDetailItemMainFragment.getIpId(), ProjectDetailItemMainFragment.this.getTourId(), str3);
        }

        @Override // cn.damai.trade.newtradeorder.ui.projectdetail.projectdetailitem.ui.view.projectheader.OnHeadClickListener
        public void onScoreHeadTipClick(String str, String str2) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "-2147360939")) {
                ipChange.ipc$dispatch("-2147360939", new Object[]{this, str, str2});
                return;
            }
            C0529c e = C0529c.e();
            pp2 u = pp2.u();
            e.x(u.D1(ProjectDetailItemMainFragment.this.mProjectId + "", ProjectDetailItemMainFragment.this.getIpId(), str2));
            DMNav.from(ProjectDetailItemMainFragment.this.mActivity).toUri(str);
        }

        @Override // cn.damai.trade.newtradeorder.ui.projectdetail.projectdetailitem.ui.view.projectheader.OnHeadClickListener
        public void onSeatIconClick() {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "-1724333130")) {
                ipChange.ipc$dispatch("-1724333130", new Object[]{this});
            } else {
                ProjectDetailItemMainFragment.this.mOnPerformSeatImgIconClickListener.onClick(null);
            }
        }

        @Override // cn.damai.trade.newtradeorder.ui.projectdetail.projectdetailitem.ui.view.projectheader.OnHeadClickListener
        public void onServiceEtcClick() {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "-286614921")) {
                ipChange.ipc$dispatch("-286614921", new Object[]{this});
                return;
            }
            C0529c.e().x(pp2.u().P0(ProjectDetailItemMainFragment.this.mProjectId));
            ProjectDetailItemMainFragment.this.showSupportServicePopLayer();
        }

        @Override // cn.damai.trade.newtradeorder.ui.projectdetail.projectdetailitem.ui.view.projectheader.OnHeadClickListener
        public void onShowTimeClick() {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "2138611458")) {
                ipChange.ipc$dispatch("2138611458", new Object[]{this});
            } else {
                ProjectDetailItemMainFragment.this.mOnPerformInfoClickListener.onClick(null);
            }
        }

        @Override // cn.damai.trade.newtradeorder.ui.projectdetail.projectdetailitem.ui.view.projectheader.OnHeadClickListener
        public void onVenueMapIconClick() {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "-956672866")) {
                ipChange.ipc$dispatch("-956672866", new Object[]{this});
                return;
            }
            ProjectStaticDataBean projectStaticDataBean = ProjectDetailItemMainFragment.this.mProjectStaticDataBean;
            ProjectDetailItemMainFragment projectDetailItemMainFragment = ProjectDetailItemMainFragment.this;
            tv1.f(projectStaticDataBean, projectDetailItemMainFragment.mProjectId, projectDetailItemMainFragment.mProjectDetailActivity);
        }

        @Override // cn.damai.trade.newtradeorder.ui.projectdetail.projectdetailitem.ui.view.projectheader.OnHeadClickListener
        public void onVenueNameClick() {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "75132284")) {
                ipChange.ipc$dispatch("75132284", new Object[]{this});
                return;
            }
            ProjectStaticDataBean projectStaticDataBean = ProjectDetailItemMainFragment.this.mProjectStaticDataBean;
            ProjectDetailItemMainFragment projectDetailItemMainFragment = ProjectDetailItemMainFragment.this;
            tv1.e(projectStaticDataBean, projectDetailItemMainFragment.mProjectId, projectDetailItemMainFragment.mProjectDetailActivity);
        }

        @Override // cn.damai.trade.newtradeorder.ui.projectdetail.projectdetailitem.ui.view.projectheader.OnHeadClickListener
        public void onVideoClick(int i) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "-1477413690")) {
                ipChange.ipc$dispatch("-1477413690", new Object[]{this, Integer.valueOf(i)});
                return;
            }
            ProjectDetailItemMainFragment projectDetailItemMainFragment = ProjectDetailItemMainFragment.this;
            tv1.g(projectDetailItemMainFragment.mProjectDetailActivity, projectDetailItemMainFragment.mProjectDynamicExtDataBean, ProjectDetailItemMainFragment.this.mProjectId, i);
        }

        @Override // cn.damai.trade.newtradeorder.ui.projectdetail.projectdetailitem.ui.view.projectheader.OnHeadClickListener
        public void onWannaSeeActionClick() {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "-426267158")) {
                ipChange.ipc$dispatch("-426267158", new Object[]{this});
            } else {
                ProjectDetailItemMainFragment.this.requestFavorite(false);
            }
        }
    }

    /* compiled from: Taobao */
    /* renamed from: cn.damai.trade.newtradeorder.ui.projectdetail.projectdetailitem.ui.fragment.ProjectDetailItemMainFragment$y */
    /* loaded from: classes8.dex */
    public class C2327y implements OnTimeCountDownListener {
        private static transient /* synthetic */ IpChange $ipChange;

        C2327y() {
        }

        @Override // cn.damai.trade.newtradeorder.ui.projectdetail.projectdetailitem.helper.OnTimeCountDownListener
        public void onCountDownFinished(long j) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "-686905060")) {
                ipChange.ipc$dispatch("-686905060", new Object[]{this, Long.valueOf(j)});
                return;
            }
            ProjectDetailItemMainFragment.this.mHasCountDownFinished = true;
            ProjectDetailItemMainFragment.this.timeCountDownFinished();
        }

        @Override // cn.damai.trade.newtradeorder.ui.projectdetail.projectdetailitem.helper.OnTimeCountDownListener
        public void onCountDownStart(String str, String str2, String str3, String str4) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "-2080820426")) {
                ipChange.ipc$dispatch("-2080820426", new Object[]{this, str, str2, str3, str4});
                return;
            }
            ProjectDetailItemMainFragment.this.mHasCountDownFinished = false;
            ProjectDetailItemMainFragment.this.timerAndStagoryView.setCountDownTime(str, str2, str3, str4);
        }

        @Override // cn.damai.trade.newtradeorder.ui.projectdetail.projectdetailitem.helper.OnTimeCountDownListener
        public void onCountDownTip(long j, String str, String str2, String str3, String str4) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "615615895")) {
                ipChange.ipc$dispatch("615615895", new Object[]{this, Long.valueOf(j), str, str2, str3, str4});
                return;
            }
            if (ProjectDetailItemMainFragment.this.mProjectItemDataBean != null) {
                ProjectDetailItemMainFragment.this.mProjectItemDataBean.setCountDown(j);
            }
            ProjectDetailItemMainFragment.this.timerAndStagoryView.setCountDownTime(str, str2, str3, str4);
        }
    }

    /* compiled from: Taobao */
    /* loaded from: classes16.dex */
    public class y0 implements View.OnClickListener {
        private static transient /* synthetic */ IpChange $ipChange;

        y0() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "-26194597")) {
                ipChange.ipc$dispatch("-26194597", new Object[]{this, view});
                return;
            }
            C0529c.e().x(pp2.u().O0(ProjectDetailItemMainFragment.this.mProjectId));
            ProjectDetailItemMainFragment.this.setAliMeParams(AliMeUtil.FROM_PROJECT_DETAIL, "");
            ProjectDetailItemMainFragment.this.getAliMeTokenAndEnter();
        }
    }

    /* compiled from: Taobao */
    /* renamed from: cn.damai.trade.newtradeorder.ui.projectdetail.projectdetailitem.ui.fragment.ProjectDetailItemMainFragment$z */
    /* loaded from: classes8.dex */
    public class C2328z implements VIPCreditExchangePopFragment.IExchangeResult {
        private static transient /* synthetic */ IpChange $ipChange;

        C2328z() {
        }

        @Override // cn.damai.trade.newtradeorder.ui.projectdetail.ui.fragment.VIPCreditExchangePopFragment.IExchangeResult
        public void exchangeResult(boolean z) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "206325685")) {
                ipChange.ipc$dispatch("206325685", new Object[]{this, Boolean.valueOf(z)});
            } else {
                ProjectDetailItemMainFragment.this.onRefresh();
            }
        }
    }

    /* compiled from: Taobao */
    /* loaded from: classes8.dex */
    public class z0 implements Action<Bundle> {
        private static transient /* synthetic */ IpChange $ipChange;

        z0() {
        }

        @Override // cn.damai.message.observer.Action
        /* renamed from: a */
        public void call(Bundle bundle) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "1479105255")) {
                ipChange.ipc$dispatch("1479105255", new Object[]{this, bundle});
            } else if (ProjectDetailItemMainFragment.this.viewCreater != null) {
                xr.c(ProjectDetailItemMainFragment.this.viewCreater.a().a(), new cn.damai.tetris.core.msg.Message(10241, bundle));
            }
        }
    }

    private void autoCancelCalendarRemind() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "215223436")) {
            ipChange.ipc$dispatch("215223436", new Object[]{this});
        } else if (this.mProjectStaticDataBean.getItemBase() == null || !this.mProjectStaticDataBean.getItemBase().isProjectCancel()) {
        } else {
            qv1.b(this.mProjectDetailActivity, getCalendarRemindTitle(), getCalendSellTime(), this.mProjectId);
        }
    }

    private void autoShowSkuLayer() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "363252408")) {
            ipChange.ipc$dispatch("363252408", new Object[]{this});
            return;
        }
        int i = this.mPurchaseType;
        if (i == 1) {
            this.mPurchaseType = -1;
            showPerformListFragment(false);
        } else if (i == 2) {
            this.mPurchaseType = -1;
            handleChooseSeatPage();
        } else if (i != 3) {
        } else {
            this.mPurchaseType = -1;
            processClickSaleRemindStatus();
        }
    }

    private void cancelCountDown() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-529802277")) {
            ipChange.ipc$dispatch("-529802277", new Object[]{this});
            return;
        }
        ITimeCountDownManager iTimeCountDownManager = this.mTimeCountDownManager;
        if (iTimeCountDownManager != null) {
            iTimeCountDownManager.cancelCountDown();
        }
        ITimeCountDownManager iTimeCountDownManager2 = this.mMemberPromptTimeCountDownManager;
        if (iTimeCountDownManager2 != null) {
            iTimeCountDownManager2.cancelCountDown();
        }
        ProjectTimerAndStrategyTmPromptView projectTimerAndStrategyTmPromptView = this.timerAndStrategyTmPromptView;
        if (projectTimerAndStrategyTmPromptView != null) {
            projectTimerAndStrategyTmPromptView.cancelDownAnim();
        }
        ProjectSpecialBuyPromptView projectSpecialBuyPromptView = this.specialBuyPromptView;
        if (projectSpecialBuyPromptView != null) {
            projectSpecialBuyPromptView.cancelDownAnim();
            if (this.specialBuyPromptView.getTimerCountDownManager() != null) {
                this.specialBuyPromptView.getTimerCountDownManager().cancelCountDown();
            }
        }
    }

    private void checkDisplayFixedAnchorIndicator(int i) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "608064555")) {
            ipChange.ipc$dispatch("608064555", new Object[]{this, Integer.valueOf(i)});
        } else if (i >= (this.mLvProjectDetailHeader.getHeight() - this.mTitleBarPanel.e()) - this.mAnchorIndicator.getHeight()) {
            this.isFixedAnchorVisible = true;
            showFixedAnchorIndicator();
        } else {
            this.isFixedAnchorVisible = false;
            hideFixedAnchorIndicator();
        }
    }

    private void clickedAnchorItem(int i, c5 c5Var) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "922975081")) {
            ipChange.ipc$dispatch("922975081", new Object[]{this, Integer.valueOf(i), c5Var});
            return;
        }
        this.mLinearPullToRefreshView.setPullToRefreshEnabled(false);
        setCurAnchorPosition(i);
        scrollToPosition(c5Var.c().b().intValue(), getOffset());
        this.isFixedAnchorVisible = true;
        updateTitleAndFixAnchorVisibility(false);
    }

    private void closeSkuActivity() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "233223076")) {
            ipChange.ipc$dispatch("233223076", new Object[]{this});
        } else {
            xr.c(NcovSkuActivity.MESSAGE_CLOSE, "");
        }
    }

    private void confirmPromptContentPriority() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-2118485281")) {
            ipChange.ipc$dispatch("-2118485281", new Object[]{this});
            return;
        }
        String unpaidNotice = getUnpaidNotice();
        if (!TextUtils.isEmpty(unpaidNotice)) {
            this.mTvPromptContent.setText(unpaidNotice);
            this.mTvPromptContent.setMaxLines(2);
            this.mRvPromptFloatingLayerView.setVisibility(0);
            return;
        }
        this.mRvPromptFloatingLayerView.setVisibility(8);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void dismissPopLayerFragment(Fragment fragment) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-2099375280")) {
            ipChange.ipc$dispatch("-2099375280", new Object[]{this, fragment});
        } else if (fragment == null || fragment.getActivity() == null) {
        } else {
            if (!fragment.getActivity().isFinishing()) {
                FragmentTransaction fragmentTransaction = getFragmentTransaction();
                fragmentTransaction.remove(fragment);
                fragmentTransaction.commitAllowingStateLoss();
            }
            sendHandlerMessage(102, 400L);
            if (fragment instanceof NcovPromotionFragment) {
                novBackUtHandle();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void dismissScreenShotShare() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1710696361")) {
            ipChange.ipc$dispatch("1710696361", new Object[]{this});
            return;
        }
        PopupWindow popupWindow = this.popupWindow;
        if (popupWindow != null) {
            popupWindow.dismiss();
        }
    }

    private void displayErrorPage(String str, String str2, String str3) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1199217215")) {
            ipChange.ipc$dispatch("-1199217215", new Object[]{this, str, str2, str3});
            return;
        }
        this.mFlPurchaseStatusBarContainer.setVisibility(8);
        this.mLvBottomBar.setVisibility(8);
        this.mRvPromptFloatingLayerView.setVisibility(8);
        updateTitleAndFixAnchorVisibility(true);
        this.mFlProjectContentContainer.setVisibility(0);
        if (isFlowLimitedErrorCode(str)) {
            onResponseError(2, "抱歉，当前排队的人数太多啦，请稍后再试哦", str, str3, this.mFlProjectContentContainer, true);
            this.mErrorPage.updateRefreshBtn(true, "努力刷新");
            this.mErrorPage.updateReportBtn(false, "");
            return;
        }
        onResponseError(str2, str, str3, this.mFlProjectContentContainer, true);
    }

    private void displayProjectNotExistPage() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "529262638")) {
            ipChange.ipc$dispatch("529262638", new Object[]{this});
            return;
        }
        if (this.mFlNotExistPageContainer == null) {
            this.mFlNotExistPageContainer = (FrameLayout) ((ViewStub) this.mContentRootLayout.findViewById(R$id.project_item_not_exist_view_stub)).inflate().findViewById(R$id.trade_project_detail_not_exist_page_fl);
        }
        updateTitleAndFixAnchorVisibility(true);
        this.mRvProjectDetailContent.setVisibility(8);
        this.mRvPromptFloatingLayerView.setVisibility(8);
        this.mFlNotExistPageContainer.setVisibility(0);
    }

    private boolean enableCalenderRemind() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "154146778")) {
            return ((Boolean) ipChange.ipc$dispatch("154146778", new Object[]{this})).booleanValue();
        }
        ProjectItemDataBean projectItemDataBean = this.mProjectItemDataBean;
        return projectItemDataBean != null && projectItemDataBean.getSellStartTime() > 0 && this.mProjectItemDataBean.getCountDown() > 600;
    }

    private void enterShowWantSeeGuideTips(long j) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1081558632")) {
            ipChange.ipc$dispatch("-1081558632", new Object[]{this, Long.valueOf(j)});
            return;
        }
        HashMap<Long, Integer> hashMap = projectEnterCountMap;
        if (hashMap.containsKey(Long.valueOf(j))) {
            for (Map.Entry<Long, Integer> entry : hashMap.entrySet()) {
                if (entry.getKey().longValue() == j && entry.getValue().intValue() >= 3) {
                    startWantSeeGuideTimer(WantSeeGuideTips.AbstractC1546b.C1547a.INSTANCE);
                }
            }
        }
    }

    private void executeEvaluatesAndDiscussionRequest() {
        ProjectStaticItemBaseBean itemBase;
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "934532067")) {
            ipChange.ipc$dispatch("934532067", new Object[]{this});
            return;
        }
        ProjectStaticDataBean projectStaticDataBean = this.mProjectStaticDataBean;
        if (projectStaticDataBean == null || (itemBase = projectStaticDataBean.getItemBase()) == null) {
            return;
        }
        long categoryId = itemBase.getCategoryId();
        ProjectDynamicExtDataBean projectDynamicExtDataBean = this.mProjectDynamicExtDataBean;
        String ipId = (projectDynamicExtDataBean == null || projectDynamicExtDataBean.getIpCard() == null) ? "" : this.mProjectDynamicExtDataBean.getIpCard().getIpId();
        ((ProjectItemPresenter) this.mPresenter).getProjectDetailEvaluates(this.mProjectId, categoryId, ipId, 9, 32, 1, 3, true, getTourId());
        ((ProjectItemPresenter) this.mPresenter).getProjectDetailDiscussion(this.mProjectId, categoryId, ipId);
    }

    private void executeProjectDetailDataRequest(int i) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-461896703")) {
            ipChange.ipc$dispatch("-461896703", new Object[]{this, Integer.valueOf(i)});
        } else {
            ((ProjectItemPresenter) this.mPresenter).getProjectDetailData(i, String.valueOf(this.mProjectId));
        }
    }

    private void executeRecommendedProjectRequest() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "2047629404")) {
            ipChange.ipc$dispatch("2047629404", new Object[]{this});
        } else if (z20.K()) {
            ((ProjectItemPresenter) this.mPresenter).getRecommendProjectList(z20.E(), z20.c(), z20.o(), z20.n(), 1, 10, jn1.ARRAY_START_STR + this.mProjectId + jn1.ARRAY_END_STR, true, 1);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void fixAnchorSelection(boolean z) {
        AnchorManager anchorManager;
        c5 e;
        View findViewByPosition;
        c5 h;
        View findViewByPosition2;
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1738675390")) {
            ipChange.ipc$dispatch("1738675390", new Object[]{this, Boolean.valueOf(z)});
        } else if (this.isShowAnchor && (anchorManager = this.mAnchorManager) != null) {
            if (z) {
                if (!anchorManager.j() || (h = this.mAnchorManager.h()) == null || (findViewByPosition2 = this.mLinearLayoutManager.findViewByPosition(h.c().b().intValue())) == null || Math.abs(findViewByPosition2.getTop()) > getOffset() || this.mAnchorManager.f() == h.b()) {
                    return;
                }
                int b = h.b();
                this.mCurAnchorPosition = b;
                setCurAnchorPosition(b);
            } else if (!anchorManager.k() || (e = this.mAnchorManager.e()) == null || (findViewByPosition = this.mLinearLayoutManager.findViewByPosition(e.c().b().intValue())) == null || Math.abs(findViewByPosition.getTop()) <= getOffset()) {
            } else {
                int b2 = this.mAnchorManager.i().b();
                this.mCurAnchorPosition = b2;
                setCurAnchorPosition(b2);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void getAliMeTokenAndEnter() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1662590488")) {
            ipChange.ipc$dispatch("1662590488", new Object[]{this});
            return;
        }
        String E = z20.E();
        if (isLogin() && !TextUtils.isEmpty(E)) {
            int k = wh2.k(E);
            startProgressDialog();
            AliMeUtil.d(k, this.mAliMeFrom, new C2292d0());
            return;
        }
        startLoginActivityForResult(CaptureActivity.LOCK_SUCCESS);
    }

    private long getCalendSellTime() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-2035744252")) {
            return ((Long) ipChange.ipc$dispatch("-2035744252", new Object[]{this})).longValue();
        }
        ProjectItemDataBean projectItemDataBean = this.mProjectItemDataBean;
        if (projectItemDataBean != null) {
            return projectItemDataBean.getSellStartTime();
        }
        return 0L;
    }

    private String getCalendarRemindTitle() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1217383161")) {
            return (String) ipChange.ipc$dispatch("-1217383161", new Object[]{this});
        }
        ProjectStaticDataBean projectStaticDataBean = this.mProjectStaticDataBean;
        return (projectStaticDataBean == null || projectStaticDataBean.getItemBase() == null) ? "" : this.mProjectStaticDataBean.getItemBase().getItemName();
    }

    private FragmentTransaction getFragmentTransaction() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-955636886")) {
            return (FragmentTransaction) ipChange.ipc$dispatch("-955636886", new Object[]{this});
        }
        FragmentTransaction beginTransaction = getChildFragmentManager().beginTransaction();
        int i = R$anim.pop_layer_slide_in_from_bottom;
        int i2 = R$anim.pop_layer_slide_out_to_bottom;
        beginTransaction.setCustomAnimations(i, i2, i, i2);
        return beginTransaction;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public String getIpId() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1719103802")) {
            return (String) ipChange.ipc$dispatch("-1719103802", new Object[]{this});
        }
        ProjectDynamicExtDataBean projectDynamicExtDataBean = this.mProjectDynamicExtDataBean;
        return (projectDynamicExtDataBean == null || projectDynamicExtDataBean.getIpCard() == null) ? "" : this.mProjectDynamicExtDataBean.getIpCard().getIpId();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public int getOffset() {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "-1823839812") ? ((Integer) ipChange.ipc$dispatch("-1823839812", new Object[]{this})).intValue() : this.mTitleBarPanel.e() + this.mAnchorIndicator.getHeight();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public ArrayList<PicInfo> getPosterPicInfoList() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1907353217")) {
            return (ArrayList) ipChange.ipc$dispatch("-1907353217", new Object[]{this});
        }
        ProjectStaticDataBean projectStaticDataBean = this.mProjectStaticDataBean;
        if (projectStaticDataBean == null || projectStaticDataBean.getItemBase() == null || this.mProjectStaticDataBean.getItemBase().getItemPics() == null) {
            return null;
        }
        return this.mProjectStaticDataBean.getItemBase().getItemPics().getItemPicList();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void getProjectDetailData(int i) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1007447799")) {
            ipChange.ipc$dispatch("-1007447799", new Object[]{this, Integer.valueOf(i)});
        } else if (this.mIsLoading) {
        } else {
            this.mIsLoading = true;
            this.mSkuBean = null;
            this.mPerformDataConfigure.a();
            this.mNewSkuData.a();
            this.mProjectDataHolderManager.T();
            executeProjectDetailDataRequest(i);
            if (i == 0 || i == 1) {
                executeRecommendedProjectRequest();
            }
        }
    }

    private String getProjectName() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1066824298")) {
            return (String) ipChange.ipc$dispatch("-1066824298", new Object[]{this});
        }
        ProjectStaticDataBean projectStaticDataBean = this.mProjectStaticDataBean;
        return (projectStaticDataBean == null || projectStaticDataBean.getItemBase() == null) ? "" : this.mProjectStaticDataBean.getItemBase().getItemName();
    }

    private String getProjectPosterUrl() {
        PicInfo picInfo;
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1643004141")) {
            return (String) ipChange.ipc$dispatch("1643004141", new Object[]{this});
        }
        ProjectStaticDataBean projectStaticDataBean = this.mProjectStaticDataBean;
        return (projectStaticDataBean == null || projectStaticDataBean.getItemBase() == null || this.mProjectStaticDataBean.getItemBase().getItemPics() == null || this.mProjectStaticDataBean.getItemBase().getItemPics().getItemPicList() == null || this.mProjectStaticDataBean.getItemBase().getItemPics().getItemPicList().isEmpty() || (picInfo = this.mProjectStaticDataBean.getItemBase().getItemPics().getItemPicList().get(0)) == null) ? "" : picInfo.getPicUrl();
    }

    private void getResetAttendeesOrangeSwitch() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1884548016")) {
            ipChange.ipc$dispatch("1884548016", new Object[]{this});
        } else if (StartConfig.isResetAttendeesOpen()) {
        } else {
            this.mProjectItemDataBean.setPurchaseLimitation(0);
        }
    }

    private FragmentTransaction getRightFragmentTransaction() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1184366444")) {
            return (FragmentTransaction) ipChange.ipc$dispatch("-1184366444", new Object[]{this});
        }
        FragmentTransaction beginTransaction = getChildFragmentManager().beginTransaction();
        int i = R$anim.pop_layer_slide_left_from_right;
        int i2 = R$anim.pop_layer_slide_right_to_left;
        beginTransaction.setCustomAnimations(i, i2, i, i2);
        return beginTransaction;
    }

    private void getSubProjectDectailCheckData() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1804752221")) {
            ipChange.ipc$dispatch("-1804752221", new Object[]{this});
        } else if (this.mIsLoading) {
        } else {
            this.mIsLoading = true;
            ((ProjectItemPresenter) this.mPresenter).getSubProjectDetailCheckData(String.valueOf(this.mProjectId), this.mPrivilegeId);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public String getTourId() {
        String str;
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1210093303")) {
            return (String) ipChange.ipc$dispatch("1210093303", new Object[]{this});
        }
        String str2 = null;
        ProjectStaticDataBean projectStaticDataBean = this.mProjectStaticDataBean;
        if (projectStaticDataBean != null && !m91.a(projectStaticDataBean.tourProjects)) {
            for (int i = 0; i < this.mProjectStaticDataBean.tourProjects.size(); i++) {
                ProjectTour projectTour = this.mProjectStaticDataBean.tourProjects.get(i);
                if (projectTour != null && (str = projectTour.itemId) != null) {
                    if (str.equals(this.mProjectId + "")) {
                        str2 = projectTour.tourId;
                    }
                }
            }
        }
        return str2;
    }

    private String getUnpaidNotice() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-740216383")) {
            return (String) ipChange.ipc$dispatch("-740216383", new Object[]{this});
        }
        ProjectItemDataBean projectItemDataBean = this.mProjectItemDataBean;
        return projectItemDataBean != null ? projectItemDataBean.getUnpaidNotice() : "";
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void handleChooseSeatPage() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "465807941")) {
            ipChange.ipc$dispatch("465807941", new Object[]{this});
        } else if (!isLogin()) {
            startLoginActivityForResult(MessageConstant$MessageType.MESSAGE_DATA);
        } else {
            showPerformListFragment(false);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean hasRecommendProject() {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "2082480351") ? ((Boolean) ipChange.ipc$dispatch("2082480351", new Object[]{this})).booleanValue() : wh2.e(this.mRecommendItems) > 0;
    }

    private boolean hasShowStrategy() {
        ProjectStaticItemBaseBean itemBase;
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1175677268")) {
            return ((Boolean) ipChange.ipc$dispatch("-1175677268", new Object[]{this})).booleanValue();
        }
        ProjectStaticDataBean projectStaticDataBean = this.mProjectStaticDataBean;
        return (projectStaticDataBean == null || (itemBase = projectStaticDataBean.getItemBase()) == null || !"true".equalsIgnoreCase(itemBase.getIsShowHotProjectModel())) ? false : true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void hideFixedAnchorIndicator() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-304143056")) {
            ipChange.ipc$dispatch("-304143056", new Object[]{this});
            return;
        }
        this.isShowFixAnchorIndicator = false;
        this.mAnchorIndicatorFixed.setVisibility(8);
        this.mHeadDividerLine.setVisibility(8);
    }

    private void hideSkeleton() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-487877175")) {
            ipChange.ipc$dispatch("-487877175", new Object[]{this});
            return;
        }
        SkeletonScreen skeletonScreen = this.skeletonScreen;
        if (skeletonScreen != null) {
            skeletonScreen.hide();
        }
    }

    private void initAnchorIndicator() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1022808520")) {
            ipChange.ipc$dispatch("1022808520", new Object[]{this});
            return;
        }
        AnchorIndicatorView anchorIndicatorView = (AnchorIndicatorView) this.mLvProjectDetailHeader.findViewById(R$id.project_item_anchor_indicator);
        this.mAnchorIndicator = anchorIndicatorView;
        Resources resources = getResources();
        int i = R$color.color_000000;
        int color = resources.getColor(i);
        Resources resources2 = getResources();
        int i2 = R$color.color_9C9CA5;
        anchorIndicatorView.setAnchorFontColor(color, resources2.getColor(i2));
        this.mAnchorIndicator.setOnAnchorItemClickListener(this);
        AnchorIndicatorView anchorIndicatorView2 = (AnchorIndicatorView) this.rootView.findViewById(R$id.project_item_anchor_indicator_fixed);
        this.mAnchorIndicatorFixed = anchorIndicatorView2;
        anchorIndicatorView2.setAnchorFontColor(getResources().getColor(i), getResources().getColor(i2));
        this.mAnchorIndicatorFixed.setOnAnchorItemClickListener(this);
        this.mAnchorIndicatorFixed.setVisibility(8);
        View findViewById = this.rootView.findViewById(R$id.header_line_divider);
        this.mHeadDividerLine = findViewById;
        findViewById.setVisibility(8);
    }

    private void initBottomButtonView() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-226794266")) {
            ipChange.ipc$dispatch("-226794266", new Object[]{this});
            return;
        }
        this.mBottomLineView = this.rootView.findViewById(R$id.line);
        this.mLvBottomBar = this.rootView.findViewById(R$id.project_item_bottom_bar_lv);
        this.mLvCustomerService = (FrameLayout) this.rootView.findViewById(R$id.project_item_bottom_customer_service_lv);
        SeeAnimateView seeAnimateView = (SeeAnimateView) this.rootView.findViewById(R$id.project_bottom_want_to_see_view);
        this.mViewProjectFollow = seeAnimateView;
        seeAnimateView.setCancelImage();
        this.mTvProjectFollowText = (TextView) this.rootView.findViewById(R$id.project_item_bottom_follow_text_tv);
        this.mFlPurchaseStatusBarContainer = (FrameLayout) this.rootView.findViewById(R$id.trade_project_detail_purchase_status_bar_container_fl);
        this.mLvCustomerService.setOnClickListener(new y0());
        this.wantSeeGuideTips = (WantSeeGuideTips) this.rootView.findViewById(R$id.want_see_guide_tips);
        this.wantSeePosterTips = (WantSeePosterTips) this.rootView.findViewById(R$id.want_see_poster_tips);
    }

    private void initBottomProjectStatusBarView(ProjectItemDataBean projectItemDataBean) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "411872049")) {
            ipChange.ipc$dispatch("411872049", new Object[]{this, projectItemDataBean});
            return;
        }
        if (this.mProjectItemStatusHelper == null) {
            ProjectItemStatusHelper projectItemStatusHelper = new ProjectItemStatusHelper(this.mProjectDetailActivity, this.mProjectItemDataBean, this.mProjectId, this.mFlPurchaseStatusBarContainer);
            this.mProjectItemStatusHelper = projectItemStatusHelper;
            if (projectItemStatusHelper.l()) {
                this.mFlPurchaseStatusBarContainer.addView(this.mProjectItemStatusHelper.h());
                initStatusBarViewListeners();
                this.mFlPurchaseStatusBarContainer.setVisibility(0);
            }
        } else {
            this.mFlPurchaseStatusBarContainer.setVisibility(0);
            this.mProjectItemStatusHelper.u(this.mProjectItemDataBean);
        }
        updatePageUT();
    }

    private void initExtraData() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-871534968")) {
            ipChange.ipc$dispatch("-871534968", new Object[]{this});
            return;
        }
        updateProjectName();
        this.mProjectItemDetailAdapter.a(this.mProjectDataHolderManager.n());
    }

    private void initExtraParams() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1950221332")) {
            ipChange.ipc$dispatch("-1950221332", new Object[]{this});
            return;
        }
        Bundle arguments = getArguments();
        if (arguments != null) {
            ProjectIntentExtraParser.ProjectDetailExtrasData projectDetailExtrasData = (ProjectIntentExtraParser.ProjectDetailExtrasData) arguments.getParcelable("projectExtraData");
            this.mProjectExtraData = projectDetailExtrasData;
            if (projectDetailExtrasData != null) {
                long j = projectDetailExtrasData.projectId;
                if (j > 0) {
                    this.mProjectId = j;
                    this.mIsFromPush = projectDetailExtrasData.isFromPush;
                    this.mBackType = projectDetailExtrasData.backType;
                    this.mRankInfo = projectDetailExtrasData.rankInfo;
                    this.mMaskColor = Color.parseColor("#9D9D9D");
                    this.mProjectDetailActivity = (ProjectDetailActivity) getActivity();
                    this.mPerformDataConfigure = this.mPerformDataManager.c(this.mProjectId);
                    this.mNewSkuData = this.mNewSkuDataManager.b(this.mProjectId);
                    recordProjectEnterCount(this.mProjectId);
                    return;
                }
            }
            getActivity().finish();
            return;
        }
        getActivity().finish();
    }

    private void initListeners() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-791955965")) {
            ipChange.ipc$dispatch("-791955965", new Object[]{this});
            return;
        }
        this.action = new z0();
        yr.c().e("brand_state_changed", this.action);
        this.mOnCloseMoreRecommendClickListener = new a1();
        this.mOnMoreRecommendClickListener = new b1();
        this.mOnProjectPosterClickListener = new View$OnClickListenerC2285a();
        this.mOnPromotionDetailClickListener = new View$OnClickListenerC2287b();
        this.timerAndStagoryView = (ProjectTimerAndStagoryView) this.rootView.findViewById(R$id.project_item_bottom_time_stagory);
        ProjectTimerAndStrategyTmPromptView projectTimerAndStrategyTmPromptView = (ProjectTimerAndStrategyTmPromptView) this.rootView.findViewById(R$id.rl_member_timer_strategy);
        this.timerAndStrategyTmPromptView = projectTimerAndStrategyTmPromptView;
        projectTimerAndStrategyTmPromptView.setPromptParam(this.mProjectDetailActivity, new C2289c());
        this.timerAndStagoryView.setOnRemindMeClickListener(new View$OnClickListenerC2291d());
        this.timerAndStagoryView.setStrategoryClickListener(new View$OnClickListenerC2293e());
        this.timerAndStrategyTmPromptView.setOnStrategyClickListener(new View$OnClickListenerC2295f());
        this.timerAndStagoryView.setProjectId(String.valueOf(this.mProjectId));
        this.timerAndStrategyTmPromptView.setProjectId(String.valueOf(this.mProjectId));
        ProjectSpecialBuyPromptView projectSpecialBuyPromptView = (ProjectSpecialBuyPromptView) this.rootView.findViewById(R$id.member_special_buy_layout);
        this.specialBuyPromptView = projectSpecialBuyPromptView;
        projectSpecialBuyPromptView.setProjectId(this.mPrivilegeId);
        this.specialBuyPromptView.setPromptListener(new C2297g());
        this.specialBuyPromptView.setCountDownListener(new C2299h());
        this.specialBuyPromptView.setOnStrategyClickListener(new View$OnClickListenerC2301i());
        this.mOnPerformInfoClickListener = new View$OnClickListenerC2303j();
        this.mOnPerformSeatImgIconClickListener = new View$OnClickListenerC2305k();
        this.mOnRecommendItemClickListener = new C2307l();
        this.mOnExtendInfoImageItemClickListener = new C2309m();
        this.mOnProjectCommonProblemListener = new C2311n();
        this.mOnEvaluateMineListener = new C2313o();
        this.mOnDiscussionClickListener = new C2315p(this);
        this.mOnSectionMoreClickListener = new C2317q();
        this.mOnProjectFollowClickListener = new View$OnClickListenerC2319r();
    }

    private void initPopFragmentHandler() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1434646527")) {
            ipChange.ipc$dispatch("1434646527", new Object[]{this});
        } else {
            this.mHandler = new HandlerC2323u();
        }
    }

    private void initProjectDataHolderManager() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-581024982")) {
            ipChange.ipc$dispatch("-581024982", new Object[]{this});
            return;
        }
        pv1 pv1Var = new pv1(this.mProjectDetailActivity);
        this.mProjectDataHolderManager = pv1Var;
        this.mAnchorManager = pv1Var.i();
    }

    private void initProjectDetailHeaderInfoView() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-649839208")) {
            ipChange.ipc$dispatch("-649839208", new Object[]{this});
            return;
        }
        LinearLayout linearLayout = (LinearLayout) LayoutInflater.from(this.mProjectDetailActivity).inflate(R$layout.project_detail_header_wrap, (ViewGroup) this.mRecyclerView.getHeaderContainer(), false);
        this.mLvProjectDetailHeader = linearLayout;
        View findViewById = linearLayout.findViewById(R$id.project_header);
        this.header = findViewById;
        ProjectDialogHelper projectDialogHelper = new ProjectDialogHelper(this.mProjectDetailActivity, findViewById.findViewById(R$id.header_service_etc_ui), new C2316p0());
        this.mDialogPanel = projectDialogHelper;
        projectDialogHelper.u(this.dialogShowListener);
        this.mHeadPanel = new ProjectHeaderPanel(this.mProjectDetailActivity, this.mProjectId, this.header, new x0());
        this.mRecyclerView.addHeaderView(this.mLvProjectDetailHeader);
    }

    private void initProjectDetailView() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-390048077")) {
            ipChange.ipc$dispatch("-390048077", new Object[]{this});
            return;
        }
        initProjectDetailHeaderInfoView();
        FrameLayout frameLayout = (FrameLayout) this.rootView.findViewById(R$id.project_item_detail_error_page_container);
        this.mFlProjectContentContainer = frameLayout;
        frameLayout.setVisibility(8);
        ViewGroup.LayoutParams layoutParams = this.mFlProjectContentContainer.getLayoutParams();
        if (layoutParams instanceof ViewGroup.MarginLayoutParams) {
            ((ViewGroup.MarginLayoutParams) layoutParams).topMargin = m62.a(this.mProjectDetailActivity, 44.0f) + (supportImmersionStyle() ? kg2.a(this.mProjectDetailActivity) : 0);
        }
        this.mIvProjectPosterMask = (ImageView) this.rootView.findViewById(R$id.project_poster_mask_iv);
        this.mRvPromptFloatingLayerView = this.rootView.findViewById(R$id.project_item_bottom_prompt_rv);
        this.mTvPromptContent = (TextView) this.rootView.findViewById(R$id.project_bottom_prompt_content_tv);
        this.mRvPromptFloatingLayerView.setVisibility(8);
        FrameLayout frameLayout2 = (FrameLayout) this.rootView.findViewById(R$id.project_item_bottom_want_tips_fl);
        this.mWantTipsContainer = frameLayout2;
        frameLayout2.setVisibility(8);
        this.wantSeeTips = (WantSeeTips) this.rootView.findViewById(R$id.want_see_tips_project_detail);
        this.mFlMoreRecommendFloatLayer = (FrameLayout) this.rootView.findViewById(R$id.project_more_recommend_flv);
        this.mIvCloseMoreRecommend = (ImageView) this.rootView.findViewById(R$id.close_more_recommend);
        this.mFlMoreRecommendFloatLayer.setVisibility(8);
        this.mFlvPopupLayer = (FrameLayout) this.rootView.findViewById(R$id.trade_project_detail_popup_layer_container_flv);
    }

    private void initRecyclerView() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-35770076")) {
            ipChange.ipc$dispatch("-35770076", new Object[]{this});
            return;
        }
        PullToRefreshView pullToRefreshView = (PullToRefreshView) this.rootView.findViewById(R$id.project_item_pull_to_refresh_view);
        this.mLinearPullToRefreshView = pullToRefreshView;
        pullToRefreshView.setPullToRefreshEnabled(true);
        this.mLinearPullToRefreshView.setOnRefreshListener(this);
        this.viewCreater = new zx2(getActivity());
        this.mRecyclerView = (DamaiRootRecyclerView) this.rootView.findViewById(R$id.project_item_detail_recycler_view);
        ProjectItemDetailAdapter projectItemDetailAdapter = new ProjectItemDetailAdapter(this.mProjectDetailActivity, this.mProjectId);
        this.mProjectItemDetailAdapter = projectItemDetailAdapter;
        projectItemDetailAdapter.m(this.viewCreater);
        WrapLinearLayoutManager wrapLinearLayoutManager = new WrapLinearLayoutManager(this.mProjectDetailActivity);
        this.mLinearLayoutManager = wrapLinearLayoutManager;
        this.mRecyclerView.setLayoutManager(wrapLinearLayoutManager);
        this.mRecyclerView.setAdapter(this.mProjectItemDetailAdapter);
        this.mRecyclerView.setRefreshEnabled(false);
        this.mRecyclerView.setIsAutoToDefault(false);
        this.mRecyclerView.setLoadMoreEnabled(false);
        this.mRecyclerView.getLoadMoreFooterView().setVisibility(8);
        this.mRecyclerView.addOnScrollListener(this.mOnScrollListener);
        View inflate = LayoutInflater.from(this.mProjectDetailActivity).inflate(R$layout.project_irc_load_footer, (ViewGroup) this.mRecyclerView.getFooterContainer(), false);
        this.footer = inflate;
        this.mRecyclerView.addFooterView(inflate);
        ViewGroup.LayoutParams layoutParams = this.footer.getLayoutParams();
        this.footerParam = layoutParams;
        layoutParams.height = 0;
    }

    private void initStatusBarViewListeners() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "991554799")) {
            ipChange.ipc$dispatch("991554799", new Object[]{this});
            return;
        }
        this.mProjectItemStatusHelper.r(new C2294e0());
        this.mProjectItemStatusHelper.s(ProjectItemStatusHelper.C2352a.a(this.mProjectId));
        this.mProjectItemStatusHelper.t(new C2298g0());
    }

    private void initTitleView() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1896304229")) {
            ipChange.ipc$dispatch("1896304229", new Object[]{this});
            return;
        }
        this.mTitleBarPanel = new ProjectTitleBarPanel(this.mProjectDetailActivity, this.rootView.findViewById(R$id.project_new_title), new C2296f0());
        this.mContentRootLayout = (FrameLayout) this.rootView.findViewById(R$id.project_details_root_layout);
        this.mRvProjectDetailContent = (RelativeLayout) this.rootView.findViewById(R$id.project_item_bottom_content_rv);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean isBottomTimerAndStrategyShowing() {
        ProjectTimerAndStrategyTmPromptView projectTimerAndStrategyTmPromptView;
        ProjectSpecialBuyPromptView projectSpecialBuyPromptView;
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-15102997")) {
            return ((Boolean) ipChange.ipc$dispatch("-15102997", new Object[]{this})).booleanValue();
        }
        ProjectTimerAndStagoryView projectTimerAndStagoryView = this.timerAndStagoryView;
        return (projectTimerAndStagoryView != null && projectTimerAndStagoryView.isShowing()) || ((projectTimerAndStrategyTmPromptView = this.timerAndStrategyTmPromptView) != null && projectTimerAndStrategyTmPromptView.getVisibility() == 0) || ((projectSpecialBuyPromptView = this.specialBuyPromptView) != null && projectSpecialBuyPromptView.getVisibility() == 0);
    }

    private boolean isChangeAttendees(int i, boolean z) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "437208424")) {
            return ((Boolean) ipChange.ipc$dispatch("437208424", new Object[]{this, Integer.valueOf(i), Boolean.valueOf(z)})).booleanValue();
        }
        if (StartConfig.isResetAttendeesOpen() && i != 0) {
            x8.C9911a c9911a = x8.Companion;
            if (c9911a.b(String.valueOf(this.mProjectId), this.mActivity).length > i) {
                if (z) {
                    c9911a.a(String.valueOf(this.mProjectId), this.mActivity);
                }
                return true;
            }
            return false;
        }
        return false;
    }

    private boolean isFlowLimitedErrorCode(String str) {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "782575763") ? ((Boolean) ipChange.ipc$dispatch("782575763", new Object[]{this, str})).booleanValue() : e11.FAIL_SYS_TRAFFIC_LIMIT.equalsIgnoreCase(str) || "ANDROID_SYS_API_FLOW_LIMIT_LOCKED".equalsIgnoreCase(str);
    }

    private boolean isFromHomePage() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "493273018")) {
            return ((Boolean) ipChange.ipc$dispatch("493273018", new Object[]{this})).booleanValue();
        }
        ProjectIntentExtraParser.ProjectDetailExtrasData projectDetailExtrasData = this.mProjectExtraData;
        if (projectDetailExtrasData != null) {
            return "homepage".equals(projectDetailExtrasData.fromWhere);
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean isHotProject() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1629879622")) {
            return ((Boolean) ipChange.ipc$dispatch("1629879622", new Object[]{this})).booleanValue();
        }
        ProjectStaticDataBean projectStaticDataBean = this.mProjectStaticDataBean;
        if (projectStaticDataBean == null || projectStaticDataBean.getItemBase() == null) {
            return false;
        }
        return "true".equalsIgnoreCase(this.mProjectStaticDataBean.getItemBase().getIsHotProject());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean isLogin() {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "1242994807") ? ((Boolean) ipChange.ipc$dispatch("1242994807", new Object[]{this})).booleanValue() : LoginManager.k().q();
    }

    private boolean isSoldOutAndNoUnpaid() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1257725999")) {
            return ((Boolean) ipChange.ipc$dispatch("1257725999", new Object[]{this})).booleanValue();
        }
        ProjectItemDataBean projectItemDataBean = this.mProjectItemDataBean;
        if (projectItemDataBean != null) {
            return "true".equalsIgnoreCase(projectItemDataBean.getIsSoldOutAndNoUnpaid());
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$showVIPCreditExchangeFragment$0(VIPCreditExchangePopFragment vIPCreditExchangePopFragment, View view) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "965561863")) {
            ipChange.ipc$dispatch("965561863", new Object[]{this, vIPCreditExchangePopFragment, view});
        } else {
            dismissPopLayerFragment(vIPCreditExchangePopFragment);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$showVIPCreditExchangeFragment$1(VIPCreditExchangePopFragment vIPCreditExchangePopFragment, View view) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "141880392")) {
            ipChange.ipc$dispatch("141880392", new Object[]{this, vIPCreditExchangePopFragment, view});
        } else {
            dismissPopLayerFragment(vIPCreditExchangePopFragment);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void launchAliMe(String str) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1095891975")) {
            ipChange.ipc$dispatch("-1095891975", new Object[]{this, str});
            return;
        }
        String f = AliMeUtil.f(this.mAliMeFrom, str, String.valueOf(this.mProjectId), this.mClickedProblem);
        if (!wh2.j(f)) {
            AliMeUtil.b(this.mActivity, f);
        }
        resetAliMeClickData();
    }

    public static ProjectDetailItemMainFragment newInstance(ProjectIntentExtraParser.ProjectDetailExtrasData projectDetailExtrasData) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1119627317")) {
            return (ProjectDetailItemMainFragment) ipChange.ipc$dispatch("1119627317", new Object[]{projectDetailExtrasData});
        }
        ProjectDetailItemMainFragment projectDetailItemMainFragment = new ProjectDetailItemMainFragment();
        if (projectDetailExtrasData != null) {
            Bundle bundle = new Bundle();
            bundle.putParcelable("projectExtraData", projectDetailExtrasData);
            projectDetailItemMainFragment.setArguments(bundle);
        }
        return projectDetailItemMainFragment;
    }

    private void novBackUtHandle() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1273975343")) {
            ipChange.ipc$dispatch("1273975343", new Object[]{this});
            return;
        }
        viewIgnoreTagForExposure(this.mPopLayerFragment.getView());
        C0529c.e().q(getActivity());
        C0529c.e().p(this, getDamaiUTKeyBuilder());
        C0529c.e().b(this.exposureViewList);
        this.exposureViewList.clear();
    }

    private void openSkuActivity() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-816110000")) {
            ipChange.ipc$dispatch("-816110000", new Object[]{this});
            return;
        }
        Bundle bundle = new Bundle();
        bundle.putSerializable(NcovSkuActivity.KEY_SKUBEAN, this.mSkuBean);
        bundle.putString("itemId", this.mProjectId + "");
        bundle.putSerializable(NcovSkuActivity.KEY_PRIVILEGEID, this.mPrivilegeId);
        bundle.putString(NcovSkuActivity.KEY_ATOMSPLIT, this.atomSplit);
        bundle.putString(NcovSkuActivity.KEY_REMIND_TITLE, getCalendarRemindTitle());
        bundle.putLong(NcovSkuActivity.KEY_REMIND_SALE_TIME, getCalendSellTime());
        bundle.putLong(NcovSkuActivity.KEY_REMIND_COUNTDOWN, this.mProjectItemDataBean.getCountDown());
        SeatPreloadExtra.putPreloadExtraIfNeed(this.mSeatPreloadExtra, bundle);
        DMNav.from(this.mActivity).forResult(4129).withExtras(bundle).toUri(NavUri.b("sku"));
    }

    private void pauseRedPacket() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1482527467")) {
            ipChange.ipc$dispatch("-1482527467", new Object[]{this});
        } else if (!this.mHasRegisterRedPacketMsg || isHotProject() || this.mProjectDetailActivity.isActivityFinsihed()) {
        } else {
            CouponDialogHelper.l(this.mProjectDetailActivity).n();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void popupSkuByPerformInfo() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1288980597")) {
            ipChange.ipc$dispatch("-1288980597", new Object[]{this});
            return;
        }
        ProjectItemStatusHelper projectItemStatusHelper = this.mProjectItemStatusHelper;
        if (projectItemStatusHelper == null || projectItemStatusHelper.h() == null) {
            return;
        }
        this.mProjectItemStatusHelper.o(true);
        this.mProjectItemStatusHelper.h().performClick();
        this.mProjectItemStatusHelper.o(false);
    }

    private void preloadRegionData() {
        ProjectItemDataBean projectItemDataBean;
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1331805205")) {
            ipChange.ipc$dispatch("-1331805205", new Object[]{this});
            return;
        }
        if (!(OrangeConfigCenter.c().a("damai_seat_data_preload_switch", "damai_seat_data_preload", 1) == 1)) {
            this.mSeatPreloadExtra = null;
            return;
        }
        this.mSeatPreloadExtra = m92.a(this.mProjectId, this.mProjectStaticDataBean, this.mProjectItemDataBean);
        ProjectStaticDataBean projectStaticDataBean = this.mProjectStaticDataBean;
        if (projectStaticDataBean == null || projectStaticDataBean.getItemBase() == null || (projectItemDataBean = this.mProjectItemDataBean) == null || projectItemDataBean.getPerformBases() == null || this.mProjectItemDataBean.getPerformBases().size() == 0 || this.mProjectItemDataBean.getPerformBases().get(0).getPerforms() == null || this.mProjectItemDataBean.getPerformBases().get(0).getPerforms().size() == 0 || this.mProjectItemDataBean.getPerformBases().get(0).getPerforms().get(0).chooseSeatType != 1) {
            return;
        }
        this.mProjectStaticDataBean.getItemBase().getNationalStandardCityId();
    }

    private void processAutoShowSku(int i, int i2) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1919691510")) {
            ipChange.ipc$dispatch("1919691510", new Object[]{this, Integer.valueOf(i), Integer.valueOf(i2)});
        } else if (i != i2 && this.mPurchaseType == 4) {
            this.mPurchaseType = -1;
            popupSkuByPerformInfo();
        } else if (i == i2) {
            autoShowSkuLayer();
        } else {
            this.mPurchaseType = -1;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void processCalendarRemind() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "551539456")) {
            ipChange.ipc$dispatch("551539456", new Object[]{this});
        } else if (enableCalenderRemind()) {
            qv1.e(this.mProjectDetailActivity, getCalendarRemindTitle(), getCalendSellTime(), this.calendRemindMeListener);
        } else {
            qv1.f(this.mProjectDetailActivity, "抱歉，不能添加日历提醒", "距开抢前10分钟不能添加日历提醒，请实时关注商品动态");
        }
    }

    private void processClickNotRefreshAfterCountDown() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1474726110")) {
            ipChange.ipc$dispatch("-1474726110", new Object[]{this});
        } else if (isLogin()) {
            getSubProjectDectailCheckData();
        } else {
            startLoginActivityForResult(4119);
        }
    }

    private void processClickSaleRemindStatus() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-818844479")) {
            ipChange.ipc$dispatch("-818844479", new Object[]{this});
        } else if (isLogin()) {
            showPerformListFragment(true);
        } else {
            startLoginActivityForResult(4120);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void processTimeCountDownClick() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "110544991")) {
            ipChange.ipc$dispatch("110544991", new Object[]{this});
        } else if (this.mHasCountDownFinished) {
            processClickNotRefreshAfterCountDown();
        } else {
            processClickSaleRemindStatus();
        }
    }

    private void recordProjectEnterCount(long j) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1419077871")) {
            ipChange.ipc$dispatch("-1419077871", new Object[]{this, Long.valueOf(j)});
            return;
        }
        HashMap<Long, Integer> hashMap = projectEnterCountMap;
        if (hashMap.containsKey(Long.valueOf(j))) {
            for (Map.Entry<Long, Integer> entry : hashMap.entrySet()) {
                if (entry.getKey().longValue() == j) {
                    projectEnterCountMap.put(Long.valueOf(j), Integer.valueOf(entry.getValue().intValue() + 1));
                }
            }
            return;
        }
        hashMap.put(Long.valueOf(j), 1);
    }

    private void registerMessageObserver() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1525544472")) {
            ipChange.ipc$dispatch("1525544472", new Object[]{this});
        } else {
            this.mDMMessage.b("evaluate_praise", new t0());
        }
    }

    private void registerRedPacketMessage() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "640164775")) {
            ipChange.ipc$dispatch("640164775", new Object[]{this});
            return;
        }
        if (!this.mHasRegisterRedPacketMsg && !isHotProject() && !this.mProjectDetailActivity.isActivityFinsihed()) {
            this.mHasRegisterRedPacketMsg = true;
            CouponDialogHelper.l(this.mProjectDetailActivity).r(this.mDMMessage);
        }
        resumeRedPacket();
    }

    private void removeShotListener() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-413275162")) {
            ipChange.ipc$dispatch("-413275162", new Object[]{this});
        } else {
            ScreenShotDetector.k().x(null);
        }
    }

    private void reportProjectCouponPromotionUT() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-714485759")) {
            ipChange.ipc$dispatch("-714485759", new Object[]{this});
            return;
        }
        ProjectStaticDataBean projectStaticDataBean = this.mProjectStaticDataBean;
        if (projectStaticDataBean == null || projectStaticDataBean.getItemBase() == null || this.mProjectItemDataBean == null) {
            return;
        }
        long itemId = this.mProjectStaticDataBean.getItemBase().getItemId();
        String itemCouponIds = this.mProjectItemDataBean.getItemCouponIds();
        String itemPromotionIds = this.mProjectItemDataBean.getItemPromotionIds();
        String privilegeActivityIds = this.mProjectItemDataBean.getPrivilegeActivityIds();
        if (TextUtils.isEmpty(itemCouponIds) && TextUtils.isEmpty(itemPromotionIds) && TextUtils.isEmpty(privilegeActivityIds)) {
            return;
        }
        pp2.u().W1(itemId, itemPromotionIds, itemCouponIds, privilegeActivityIds);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void reportProjectNotExitsFromHome() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "355580994")) {
            ipChange.ipc$dispatch("355580994", new Object[]{this});
        } else if (isFromHomePage()) {
            ProjectStaticDataBean projectStaticDataBean = this.mProjectStaticDataBean;
            ProjectDetailXFlushUtil.o(String.valueOf(this.mProjectId), (projectStaticDataBean == null || projectStaticDataBean.getItemBase() == null) ? "" : this.mProjectStaticDataBean.getItemBase().getItemName(), "mtop.alibaba.damai.detail.getdetail", "", "");
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    @RequiresApi(api = 11)
    public void requestFavorite(boolean z) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "902743213")) {
            ipChange.ipc$dispatch("902743213", new Object[]{this, Boolean.valueOf(z)});
            return;
        }
        this.isFlowByBottomBar = z;
        if (isLogin()) {
            ProjectDynamicExtDataBean projectDynamicExtDataBean = this.mProjectDynamicExtDataBean;
            if (projectDynamicExtDataBean != null ? projectDynamicExtDataBean.isSubFlag() : false) {
                this.mViewProjectFollow.cancelAnimate();
                C0529c.e().x(pp2.u().k0(this.mProjectId, false));
                updateProjectFollowRelation(0);
                return;
            }
            this.mViewProjectFollow.clickAnimate();
            C0529c.e().x(pp2.u().k0(this.mProjectId, true));
            updateProjectFollowRelation(1);
            return;
        }
        C0529c.e().x(pp2.u().k0(this.mProjectId, false));
        startLoginActivityForResult(4097);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void resetAliMeClickData() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1050856313")) {
            ipChange.ipc$dispatch("-1050856313", new Object[]{this});
            return;
        }
        this.mClickedProblem = "";
        this.mAliMeFrom = "";
    }

    private void resetProjectPerformData() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-123578863")) {
            ipChange.ipc$dispatch("-123578863", new Object[]{this});
            return;
        }
        this.mPerformDataConfigure.d(this.mProjectId);
        ProjectItemDataBean projectItemDataBean = this.mProjectItemDataBean;
        if (projectItemDataBean != null) {
            this.mPerformDataConfigure.g(projectItemDataBean.getPerformBases());
        }
        this.mPerformDataConfigure.e(null);
        this.mPerformDataConfigure.f(null);
    }

    private void resumeRedPacket() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1641006618")) {
            ipChange.ipc$dispatch("-1641006618", new Object[]{this});
        } else if (!this.mHasRegisterRedPacketMsg || isHotProject() || this.mProjectDetailActivity.isActivityFinsihed()) {
        } else {
            CouponDialogHelper.l(this.mProjectDetailActivity).B(gb.PROJECT_PAGE, String.valueOf(this.mProjectId));
            CouponDialogHelper.l(this.mProjectDetailActivity).o();
        }
    }

    private void saveHotSellStartTime() {
        ProjectItemDataBean projectItemDataBean;
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "734967371")) {
            ipChange.ipc$dispatch("734967371", new Object[]{this});
        } else if (!isHotProject() || (projectItemDataBean = this.mProjectItemDataBean) == null) {
        } else {
            z20.V(projectItemDataBean.getSellStartTime());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void scrollToPosition(int i, int i2) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-2047428633")) {
            ipChange.ipc$dispatch("-2047428633", new Object[]{this, Integer.valueOf(i), Integer.valueOf(i2)});
            return;
        }
        this.mRecyclerView.dispatchTouchEvent(MotionEvent.obtain(SystemClock.uptimeMillis(), SystemClock.uptimeMillis(), 3, 0.0f, 0.0f, 0));
        this.mLinearLayoutManager.scrollToPositionWithOffset(i, i2);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void scrollToRecommend() {
        AnchorManager anchorManager;
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "141454590")) {
            ipChange.ipc$dispatch("141454590", new Object[]{this});
        } else if (!hasRecommendProject() || (anchorManager = this.mAnchorManager) == null) {
        } else {
            AnchorManager.AnchorType anchorType = AnchorManager.AnchorType.RECOMMEND;
            if (anchorManager.c(anchorType) != null) {
                c5 c = this.mAnchorManager.c(anchorType);
                clickedAnchorItem(c.b(), c);
            }
        }
    }

    private void sendHandlerMessage(int i, long j) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "902429652")) {
            ipChange.ipc$dispatch("902429652", new Object[]{this, Integer.valueOf(i), Long.valueOf(j)});
            return;
        }
        Message obtainMessage = this.mHandler.obtainMessage();
        obtainMessage.what = i;
        this.mHandler.sendMessageDelayed(obtainMessage, j);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setAliMeParams(String str, String str2) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1610412978")) {
            ipChange.ipc$dispatch("1610412978", new Object[]{this, str, str2});
            return;
        }
        this.mAliMeFrom = str;
        this.mClickedProblem = str2;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setCurAnchorPosition(int i) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "949100615")) {
            ipChange.ipc$dispatch("949100615", new Object[]{this, Integer.valueOf(i)});
            return;
        }
        this.mAnchorManager.n(i);
        this.mAnchorIndicator.setSelectAnchor(i);
        this.mAnchorIndicatorFixed.setSelectAnchor(i);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setProjectDetailMaskLayerImage(String str, Bitmap bitmap, boolean z) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1240320202")) {
            ipChange.ipc$dispatch("1240320202", new Object[]{this, str, bitmap, Boolean.valueOf(z)});
            return;
        }
        try {
            if (z) {
                this.mIvProjectPosterMask.setBackgroundColor(Color.parseColor("#000000"));
            } else if (str == null) {
                return;
            } else {
                DMRGBUtil.g(1.0f, bitmap, str, new C2290c0());
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        if (TextUtils.isEmpty(str)) {
            return;
        }
        this.mSinaSharePath = wv1.b(str, bitmap, this.mProjectDetailActivity);
    }

    private void setProjectFollowStatus(boolean z) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1000319562")) {
            ipChange.ipc$dispatch("-1000319562", new Object[]{this, Boolean.valueOf(z)});
            return;
        }
        ProjectDynamicExtDataBean projectDynamicExtDataBean = this.mProjectDynamicExtDataBean;
        if (projectDynamicExtDataBean != null) {
            projectDynamicExtDataBean.setSubFlag(z);
        }
    }

    private void setRemindTime() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-845235330")) {
            ipChange.ipc$dispatch("-845235330", new Object[]{this});
        } else if (enableCalenderRemind()) {
            gn2.b().k(this.mProjectItemDataBean.getCountDown());
        } else {
            gn2.b().a();
        }
    }

    private void setSeatImageAndAtomSplit() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-2091471054")) {
            ipChange.ipc$dispatch("-2091471054", new Object[]{this});
            return;
        }
        ProjectStaticItemBaseBean itemBase = this.mProjectStaticDataBean.getItemBase();
        if (itemBase != null) {
            this.atomSplit = itemBase.getAtomSplit() + "";
        }
    }

    private void setupListeners() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-190709866")) {
            ipChange.ipc$dispatch("-190709866", new Object[]{this});
            return;
        }
        this.mFlMoreRecommendFloatLayer.setOnClickListener(this.mOnMoreRecommendClickListener);
        this.mIvCloseMoreRecommend.setOnClickListener(this.mOnCloseMoreRecommendClickListener);
        this.mViewProjectFollow.setOnClickListener(this.mOnProjectFollowClickListener);
        this.mProjectItemDetailAdapter.h(this.mOnExtendInfoImageItemClickListener);
        this.mProjectItemDetailAdapter.j(this.mOnRecommendItemClickListener);
        this.mProjectItemDetailAdapter.i(this.mOnProjectCommonProblemListener);
        this.mProjectItemDetailAdapter.f(this.mOnEvaluateMineListener);
        this.mProjectItemDetailAdapter.e(this.mOnDiscussionClickListener);
        this.mProjectItemDetailAdapter.g(this.mOnSectionMoreClickListener);
        this.mProjectItemDetailAdapter.k(this.mShareManagerImpl);
        this.mProjectItemDetailAdapter.d(new View$OnClickListenerC2321s());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void showCouponPromotionFragment() {
        List<PromotionGroupBean> list;
        String str;
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-2069038622")) {
            ipChange.ipc$dispatch("-2069038622", new Object[]{this});
            return;
        }
        ProjectItemDataBean projectItemDataBean = this.mProjectItemDataBean;
        if (projectItemDataBean != null) {
            PromotionBean promotionBean = projectItemDataBean.promotionDetail;
            if (promotionBean != null) {
                List<PromotionGroupBean> list2 = promotionBean.promotionGroupList;
                str = promotionBean.promotionRemark;
                list = list2;
            } else {
                list = null;
                str = null;
            }
            this.mPopLayerFragment = NcovPromotionFragment.instance(new PromotionDataBean("preferentialexplain", this.mProjectId, list, str, null, null), new C2286a0());
            FragmentTransaction fragmentTransaction = getFragmentTransaction();
            fragmentTransaction.replace(R$id.trade_project_detail_popup_layer_container_flv, this.mPopLayerFragment);
            fragmentTransaction.commitAllowingStateLoss();
            this.mFlvPopupLayer.setVisibility(0);
            Log.e("xxxxx_fragment_ut", "detail pageDisAppear before");
            C0529c.e().q(getActivity());
            this.exposureViewList = viewIgnoreTagForExposure(getActivity().getWindow().getDecorView());
            Log.e("xxxxx_fragment_ut", "detail pageDisAppear after");
        }
    }

    private void showFixedAnchorIndicator() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-927931115")) {
            ipChange.ipc$dispatch("-927931115", new Object[]{this});
            return;
        }
        this.isShowFixAnchorIndicator = true;
        this.mAnchorIndicatorFixed.setVisibility(0);
        this.mHeadDividerLine.setVisibility(0);
    }

    private void showFlowLimitedDialog() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "663233435")) {
            ipChange.ipc$dispatch("663233435", new Object[]{this});
            return;
        }
        DMDialog dMDialog = new DMDialog(getActivity());
        dMDialog.setCanceledOnTouchOutside(false);
        dMDialog.setCancelable(true);
        dMDialog.v("排队的人数太多啦").q("抱歉，当前排队人数太多啦，实在挤不进去了，请稍后再进行尝试").i(hasRecommendProject() ? "看看别的" : "", new s0()).n("努力刷新", new DialogInterface$OnClickListenerC2320r0()).j(true).show();
    }

    private void showNewScreenShotShare() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "2028661314")) {
            ipChange.ipc$dispatch("2028661314", new Object[]{this});
        } else {
            this.popupWindow = new ScreenShotImgShare().j(this.mProjectId, this.mProjectDetailDataBean, this.mRankInfo, this.mContentRootLayout, this.mProjectItemDetailAdapter, this.viewCreater, getActivity());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void showNoticeFragment(int i) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "106614672")) {
            ipChange.ipc$dispatch("106614672", new Object[]{this, Integer.valueOf(i)});
            return;
        }
        ProjectStaticDataBean projectStaticDataBean = this.mProjectStaticDataBean;
        if (projectStaticDataBean == null || projectStaticDataBean.getNoticeMatter() == null || this.mProjectStaticDataBean.getNoticeMatter().getNoticeList() == null) {
            return;
        }
        this.mPopLayerFragment = ProjectNoticeMatterFragment.newInstance(this.mProjectId, i, this.mProjectStaticDataBean.getNoticeMatter());
        FragmentTransaction fragmentTransaction = getFragmentTransaction();
        fragmentTransaction.replace(R$id.trade_project_detail_popup_layer_container_flv, this.mPopLayerFragment);
        fragmentTransaction.commitAllowingStateLoss();
        this.mFlvPopupLayer.setVisibility(0);
        this.mFlvPopupLayer.setOnClickListener(new View$OnClickListenerC2314o0());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void showPerformListFragment(boolean z) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-540137036")) {
            ipChange.ipc$dispatch("-540137036", new Object[]{this, Boolean.valueOf(z)});
        } else if (isLogin()) {
            openSkuActivity();
        } else {
            startLoginActivityForResult(4101);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void showPrivilegeCodeVerifyFragment(int i) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-2115321189")) {
            ipChange.ipc$dispatch("-2115321189", new Object[]{this, Integer.valueOf(i)});
        } else if (isLogin()) {
            ProjectItemDataBean projectItemDataBean = this.mProjectItemDataBean;
            if (projectItemDataBean == null) {
                return;
            }
            this.mPrivilegeCodeVerifyFragment = PrivilegeCodeVerifyFragment.newInstance(this.mProjectId, projectItemDataBean.getPrivilegeId(), i);
            FragmentTransaction fragmentTransaction = getFragmentTransaction();
            fragmentTransaction.replace(R$id.trade_project_detail_popup_layer_container_flv, this.mPrivilegeCodeVerifyFragment);
            fragmentTransaction.commitAllowingStateLoss();
            this.mFlvPopupLayer.setOnClickListener(new View$OnClickListenerC2302i0());
            this.mFlvPopupLayer.setVisibility(0);
        } else {
            startLoginActivityForResult(4102);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void showProjectNoticeFragment() {
        ProjectNotice projectNotice;
        NoticeListBean noticeListBean;
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1373636526")) {
            ipChange.ipc$dispatch("1373636526", new Object[]{this});
            return;
        }
        ProjectStaticDataBean projectStaticDataBean = this.mProjectStaticDataBean;
        if (projectStaticDataBean != null && (noticeListBean = projectStaticDataBean.announcementVO) != null) {
            ArrayList<ItemContent> subItemContentList = noticeListBean.subItemContentList();
            NoticeDetailFragment instance = NoticeDetailFragment.instance(subItemContentList, this.mProjectId + "");
            this.detailFragment = instance;
            instance.setClose(new View$OnClickListenerC2322t());
            FragmentTransaction fragmentTransaction = getFragmentTransaction();
            fragmentTransaction.replace(R$id.trade_project_detail_popup_layer_container_flv, this.detailFragment);
            fragmentTransaction.commitAllowingStateLoss();
            this.mFlvPopupLayer.setOnClickListener(new View$OnClickListenerC2324v());
            this.mFlvPopupLayer.setVisibility(0);
        } else if (projectStaticDataBean == null || (projectNotice = projectStaticDataBean.announcementMsg) == null) {
        } else {
            StatusNotice statusNotice = new StatusNotice();
            statusNotice.setPopupTitle(projectNotice.name);
            statusNotice.setPopupContent(projectNotice.content);
            statusNotice.imageUrl = projectNotice.imageUrl;
            this.mPopLayerFragment = ProjectNotificationFragment.newInstance(statusNotice);
            FragmentTransaction fragmentTransaction2 = getFragmentTransaction();
            fragmentTransaction2.replace(R$id.trade_project_detail_popup_layer_container_flv, this.mPopLayerFragment);
            fragmentTransaction2.commitAllowingStateLoss();
            this.mFlvPopupLayer.setOnClickListener(new View$OnClickListenerC2325w());
            this.mFlvPopupLayer.setVisibility(0);
        }
    }

    private void showSkeleton() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1483061970")) {
            ipChange.ipc$dispatch("-1483061970", new Object[]{this});
        } else {
            this.skeletonScreen = od2.a(this.rootView).j(R$layout.activity_project_skeleton).i(1500).h(R$color.color_mater_66).g(10).k();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void showSreenSharePage() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "648037628")) {
            ipChange.ipc$dispatch("648037628", new Object[]{this});
        } else if (getActivity() == null || getActivity().isFinishing()) {
        } else {
            PopupWindow popupWindow = this.popupWindow;
            if (popupWindow == null || !popupWindow.isShowing()) {
                o62.f().j();
                showNewScreenShotShare();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void showSupportServicePopLayer() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1827072213")) {
            ipChange.ipc$dispatch("1827072213", new Object[]{this});
            return;
        }
        ArrayList arrayList = new ArrayList();
        StatusNotice j = yb.j(this.mProjectItemDataBean);
        if (j != null && j.isHasPopup()) {
            ServiceNote serviceNote = new ServiceNote();
            serviceNote.isSupport = "false";
            String prefixText = j.getPrefixText();
            if (TextUtils.isEmpty(prefixText)) {
                prefixText = PurchaseConstants.NORMAL_WARNING_TITLE;
            }
            serviceNote.tagName = prefixText;
            serviceNote.tagDesc = j.getPopupContent();
            serviceNote.tagDescWithStyle = j.getPopupContent();
            arrayList.add(serviceNote);
        }
        List<ServiceNote> i = yb.i(this.mProjectStaticDataBean);
        if (!cb2.d(i)) {
            arrayList.addAll(i);
        }
        if (cb2.d(arrayList)) {
            return;
        }
        this.mPopLayerFragment = ProjectSupportServiceFragment.newInstance(arrayList, yb.b(this.mProjectStaticDataBean));
        FragmentTransaction fragmentTransaction = getFragmentTransaction();
        fragmentTransaction.replace(R$id.trade_project_detail_popup_layer_container_flv, this.mPopLayerFragment);
        fragmentTransaction.commitAllowingStateLoss();
        this.mFlvPopupLayer.setOnClickListener(new View$OnClickListenerC2288b0());
        this.mFlvPopupLayer.setVisibility(0);
    }

    /* JADX WARN: Removed duplicated region for block: B:17:0x0032  */
    /* JADX WARN: Removed duplicated region for block: B:19:0x0036  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private void showTipsOnWantSeeClick() {
        /*
            r6 = this;
            com.android.alibaba.ip.runtime.IpChange r0 = cn.damai.trade.newtradeorder.ui.projectdetail.projectdetailitem.ui.fragment.ProjectDetailItemMainFragment.$ipChange
            java.lang.String r1 = "-13185121"
            boolean r2 = com.android.alibaba.ip.runtime.AndroidInstantRuntime.support(r0, r1)
            r3 = 1
            if (r2 == 0) goto L14
            java.lang.Object[] r2 = new java.lang.Object[r3]
            r3 = 0
            r2[r3] = r6
            r0.ipc$dispatch(r1, r2)
            return
        L14:
            r0 = 0
            cn.damai.trade.newtradeorder.ui.projectdetail.projectdetailitem.bean.ProjectDynamicExtDataBean r1 = r6.mProjectDynamicExtDataBean     // Catch: java.lang.NullPointerException -> L26
            cn.damai.trade.newtradeorder.ui.projectdetail.projectdetailitem.bean.ProjectWantSeeBean r1 = r1.wantVO     // Catch: java.lang.NullPointerException -> L26
            java.lang.String r1 = r1.getTips()     // Catch: java.lang.NullPointerException -> L26
            cn.damai.trade.newtradeorder.ui.projectdetail.projectdetailitem.bean.ProjectDynamicExtDataBean r2 = r6.mProjectDynamicExtDataBean     // Catch: java.lang.NullPointerException -> L24
            cn.damai.trade.newtradeorder.ui.projectdetail.projectdetailitem.bean.ProjectWantSeeBean r2 = r2.wantVO     // Catch: java.lang.NullPointerException -> L24
            java.lang.String r2 = r2.tipsTitle     // Catch: java.lang.NullPointerException -> L24
            goto L2c
        L24:
            r2 = move-exception
            goto L28
        L26:
            r2 = move-exception
            r1 = r0
        L28:
            r2.printStackTrace()
            r2 = r0
        L2c:
            boolean r2 = android.text.TextUtils.isEmpty(r2)
            if (r2 != 0) goto L36
            r6.showWantTips()
            return
        L36:
            boolean r2 = tb.wh2.j(r1)
            java.lang.String r4 = "想看成功"
            if (r2 == 0) goto La3
            cn.damai.trade.newtradeorder.ui.projectdetail.projectdetailitem.ui.view.ProjectItemStatusHelper r1 = r6.mProjectItemStatusHelper
            if (r1 == 0) goto L8b
            cn.damai.trade.newtradeorder.ui.projectdetail.projectdetailitem.bean.ProjectItemDataBean r2 = r6.mProjectItemDataBean
            boolean r1 = r1.j(r2)
            if (r1 == 0) goto L8b
            android.content.Context r1 = r6.getContext()
            boolean r1 = tb.vl1.b(r1)
            if (r1 != 0) goto L8b
            android.app.Activity r1 = r6.mActivity
            if (r1 == 0) goto L8b
            cn.damai.uikit.view.DMThemeDialog r1 = new cn.damai.uikit.view.DMThemeDialog
            android.app.Activity r2 = r6.mActivity
            r1.<init>(r2)
            long r4 = java.lang.System.currentTimeMillis()
            cn.damai.uikit.view.DMThemeDialog$DMDialogTheme r2 = cn.damai.uikit.view.DMThemeDialog.DMDialogTheme.THEME_NOTIFICATION
            r1.r(r2)
            java.lang.String r2 = "我们将第一时间为您送上独家消息提醒～"
            r1.k(r2)
            int r2 = cn.damai.trade.R$string.damai_detail_wantsee_click_message
            r1.n(r2)
            r1.g(r3, r0)
            cn.damai.trade.newtradeorder.ui.projectdetail.projectdetailitem.ui.fragment.ProjectDetailItemMainFragment$k0 r0 = new cn.damai.trade.newtradeorder.ui.projectdetail.projectdetailitem.ui.fragment.ProjectDetailItemMainFragment$k0
            r0.<init>()
            java.lang.String r2 = "开启提醒"
            r1.i(r2, r0)
            cn.damai.trade.newtradeorder.ui.projectdetail.projectdetailitem.ui.fragment.ProjectDetailItemMainFragment$l0 r0 = new cn.damai.trade.newtradeorder.ui.projectdetail.projectdetailitem.ui.fragment.ProjectDetailItemMainFragment$l0
            r0.<init>(r4)
            r1.setOnDismissListener(r0)
            r1.show()
            goto Lc2
        L8b:
            tb.g03 r0 = tb.g03.INSTANCE
            android.app.Activity r1 = r6.mActivity
            cn.damai.wantsee.GuideUtProvider r2 = r6.mGuideUtProvider
            boolean r0 = r0.e(r1, r2)
            if (r0 != 0) goto Lc2
            int r0 = cn.damai.trade.R$string.damai_detail_wantsee_click_message
            java.lang.String r0 = r6.getString(r0)
            int r1 = cn.damai.trade.R$raw.toast_lottie_peach_heart
            cn.damai.common.util.ToastUtil.k(r4, r0, r1)
            goto Lc2
        La3:
            boolean r0 = r6.isFlowByBottomBar
            if (r0 == 0) goto Lab
            r6.showWantTips(r1)
            goto Lc2
        Lab:
            tb.g03 r0 = tb.g03.INSTANCE
            android.app.Activity r1 = r6.mActivity
            cn.damai.wantsee.GuideUtProvider r2 = r6.mGuideUtProvider
            boolean r0 = r0.e(r1, r2)
            if (r0 != 0) goto Lc2
            int r0 = cn.damai.trade.R$string.damai_detail_wantsee_click_message
            java.lang.String r0 = r6.getString(r0)
            int r1 = cn.damai.trade.R$raw.toast_lottie_peach_heart
            cn.damai.common.util.ToastUtil.k(r4, r0, r1)
        Lc2:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: cn.damai.trade.newtradeorder.ui.projectdetail.projectdetailitem.ui.fragment.ProjectDetailItemMainFragment.showTipsOnWantSeeClick():void");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void showVIPCreditExchangeFragment() {
        ProjectDynamicExtDataBean projectDynamicExtDataBean;
        ProjectMemberPrompt projectMemberPrompt;
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "822461254")) {
            ipChange.ipc$dispatch("822461254", new Object[]{this});
            return;
        }
        ProjectDetailDataBean projectDetailDataBean = this.mProjectDetailDataBean;
        if (projectDetailDataBean == null || (projectDynamicExtDataBean = projectDetailDataBean.dynamicExtData) == null || (projectMemberPrompt = projectDynamicExtDataBean.memberPrompt) == null) {
            return;
        }
        final VIPCreditExchangePopFragment a = VIPCreditExchangePopFragment.Companion.a(projectMemberPrompt, new C2328z());
        a.setCloseListener(new View.OnClickListener() { // from class: tb.rv1
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                ProjectDetailItemMainFragment.this.lambda$showVIPCreditExchangeFragment$0(a, view);
            }
        });
        FragmentTransaction fragmentTransaction = getFragmentTransaction();
        fragmentTransaction.replace(R$id.trade_project_detail_popup_layer_container_flv, a);
        fragmentTransaction.commitAllowingStateLoss();
        this.mFlvPopupLayer.setVisibility(0);
        this.mFlvPopupLayer.setOnClickListener(new View.OnClickListener() { // from class: tb.sv1
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                ProjectDetailItemMainFragment.this.lambda$showVIPCreditExchangeFragment$1(a, view);
            }
        });
    }

    private void showWantTips(String str) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1206438595")) {
            ipChange.ipc$dispatch("-1206438595", new Object[]{this, str});
        } else if (g03.INSTANCE.e(this.mActivity, this.mGuideUtProvider)) {
        } else {
            WantSeeGuideTips wantSeeGuideTips = this.wantSeeGuideTips;
            if (wantSeeGuideTips != null && wantSeeGuideTips.getVisibility() == 0) {
                this.wantSeeGuideTips.cancel();
            }
            View inflate = LayoutInflater.from(this.mActivity).inflate(R$layout.layout_want_see_bottombar_tip, (ViewGroup) null);
            HtmlView htmlView = (HtmlView) inflate.findViewById(R$id.want_see_bottom_bar_tips_html_view_below);
            htmlView.init();
            HtmlView.setTextOneLine(true);
            htmlView.loadHtml(str);
            if (this.mProjectItemStatusHelper.j(this.mProjectItemDataBean)) {
                inflate.findViewById(R$id.ic_wantsee_tips_arrow).setVisibility(4);
            }
            this.mWantTipsContainer.addView(inflate);
            this.mWantTipsContainer.setVisibility(0);
            TranslateAnimation translateAnimation = new TranslateAnimation(2, 0.0f, 2, 0.0f, 2, 1.0f, 2, 0.0f);
            translateAnimation.setDuration(300L);
            inflate.startAnimation(translateAnimation);
            View findViewById = inflate.findViewById(R$id.want_see_bottombar_tip_close);
            inflate.findViewById(R$id.want_see_bottombar_tip_bg).setOnClickListener(new View$OnClickListenerC2310m0(this));
            findViewById.setOnClickListener(new View$OnClickListenerC2312n0());
            inflate.postDelayed(new Runnable() { // from class: cn.damai.trade.newtradeorder.ui.projectdetail.projectdetailitem.ui.fragment.ProjectDetailItemMainFragment.48
                private static transient /* synthetic */ IpChange $ipChange;

                @Override // java.lang.Runnable
                public void run() {
                    IpChange ipChange2 = $ipChange;
                    if (AndroidInstantRuntime.support(ipChange2, "-1915130147")) {
                        ipChange2.ipc$dispatch("-1915130147", new Object[]{this});
                        return;
                    }
                    ProjectDetailItemMainFragment.this.mWantTipsContainer.removeAllViews();
                    ProjectDetailItemMainFragment.this.mWantTipsContainer.setVisibility(8);
                }
            }, 10000L);
            pp2.u().Y1(inflate, String.valueOf(this.mProjectId), this.mButtomText);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void startLoginActivityForResult(int i) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "897776417")) {
            ipChange.ipc$dispatch("897776417", new Object[]{this, Integer.valueOf(i)});
        } else {
            LoginManager.k().y(this, new Intent(), i);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void startSreenShotPage() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-818893758")) {
            ipChange.ipc$dispatch("-818893758", new Object[]{this});
        } else if (getActivity() == null || getActivity().isFinishing()) {
        } else {
            o62.f().i();
            Bundle bundle = new Bundle();
            bundle.putSerializable("screen_shot_info", ScreenShotDetector.k().l());
            DMNav.from(getActivity()).withExtras(bundle).toUri(NavUri.b("screen_float"));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void startWantSeeGuideTimer(WantSeeGuideTips.AbstractC1546b abstractC1546b) {
        ProjectDynamicExtDataBean projectDynamicExtDataBean;
        ProjectWantSeeBean projectWantSeeBean;
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1052910826")) {
            ipChange.ipc$dispatch("1052910826", new Object[]{this, abstractC1546b});
        } else if (!n03.INSTANCE.c() || (projectDynamicExtDataBean = this.mProjectDynamicExtDataBean) == null || (projectWantSeeBean = projectDynamicExtDataBean.wantVO) == null || projectWantSeeBean.isSubFlag() || WantSeeGuideTips.Companion.a()) {
        } else {
            CountDownTimer countDownTimer = this.wantSeeGuideTipsTimer;
            if (countDownTimer != null) {
                countDownTimer.cancel();
            }
            w0 w0Var = new w0(3000L, 1000L, abstractC1546b);
            this.wantSeeGuideTipsTimer = w0Var;
            w0Var.start();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void strategyClick() {
        ProjectTicketGuideBean projectTicketGuideBean;
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "454120829")) {
            ipChange.ipc$dispatch("454120829", new Object[]{this});
            return;
        }
        ProjectStaticDataBean projectStaticDataBean = this.mProjectStaticDataBean;
        if (projectStaticDataBean == null || (projectTicketGuideBean = projectStaticDataBean.ticketPurchasesGuidePage) == null || TextUtils.isEmpty(projectTicketGuideBean.purchaseGuideUrl)) {
            return;
        }
        VenueBean venue = this.mProjectStaticDataBean.getVenue();
        if (venue != null) {
            venue.notMainLandProject();
        }
        setRemindTime();
        DMNav.from(this.mProjectDetailActivity).toUri(this.mProjectStaticDataBean.ticketPurchasesGuidePage.purchaseGuideUrl);
    }

    private boolean supportImmersionStyle() {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "1619843617") ? ((Boolean) ipChange.ipc$dispatch("1619843617", new Object[]{this})).booleanValue() : Build.VERSION.SDK_INT >= 23;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void timeCountDownFinished() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1710139364")) {
            ipChange.ipc$dispatch("-1710139364", new Object[]{this});
        } else if (this.mProjectDynamicExtDataBean.memberPrompt != null) {
            startProgressDialog();
            onRefresh();
        } else {
            if (this.mProjectItemDataBean != null && this.mProjectItemStatusHelper != null) {
                updateCountDownVisibility(false, true);
                String buyBtnTextAfterCountDown = this.mProjectItemDataBean.getBuyBtnTextAfterCountDown();
                if (!TextUtils.isEmpty(buyBtnTextAfterCountDown)) {
                    this.mProjectItemDataBean.setBuyBtnText(buyBtnTextAfterCountDown);
                } else {
                    this.mProjectItemDataBean.setBuyBtnText("立即购买");
                }
                ProjectItemDataBean projectItemDataBean = this.mProjectItemDataBean;
                projectItemDataBean.setBuyBtnTip(projectItemDataBean.getBuyBtnTipAfterCountDown());
                try {
                    int parseInt = Integer.parseInt(this.mProjectItemDataBean.getBuyBtnStatusAfterCountDown());
                    if (parseInt == 224 || parseInt == 223 || parseInt == 88 || parseInt == 87) {
                        this.mProjectItemDataBean.setBuyBtnStatus(parseInt);
                    }
                } catch (Exception unused) {
                }
                this.mProjectItemStatusHelper.u(this.mProjectItemDataBean);
                updatePageUT();
            }
            closeSkuActivity();
        }
    }

    private boolean toDisplayErrorPage() {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "-469120788") ? ((Boolean) ipChange.ipc$dispatch("-469120788", new Object[]{this})).booleanValue() : this.mProjectStaticDataBean == null && this.mProjectDynamicExtDataBean == null && this.mProjectItemDataBean == null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void toMarketStall() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1316552585")) {
            ipChange.ipc$dispatch("1316552585", new Object[]{this});
            return;
        }
        MarketingStallBean d = yb.d(this.mProjectItemDataBean);
        if (d != null) {
            int i = d.interactiveMode;
            if (i == 2) {
                if (isLogin()) {
                    return;
                }
                C0529c.e().x(pp2.u().X0(this.mProjectId, d.utd));
                startLoginActivityForResult(4118);
            } else if (i == 3) {
                C0529c.e().x(pp2.u().X0(this.mProjectId, d.utd));
                tv1.d(this.mProjectDetailActivity, d.forwardUrl);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void toRankListPage() {
        String id;
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1891268580")) {
            ipChange.ipc$dispatch("1891268580", new Object[]{this});
            return;
        }
        RankInfo rankInfo = this.mRankInfo;
        if (rankInfo != null) {
            id = rankInfo.getId();
        } else {
            ProjectStaticDataBean projectStaticDataBean = this.mProjectStaticDataBean;
            id = (projectStaticDataBean == null || projectStaticDataBean.getRankListVO() == null) ? "" : this.mProjectStaticDataBean.getRankListVO().getId();
        }
        tv1.c(this.mProjectDetailActivity, this.mProjectId, wh2.m(id, 0L));
    }

    private void updateAnchorData() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-76684368")) {
            ipChange.ipc$dispatch("-76684368", new Object[]{this});
            return;
        }
        AnchorManager anchorManager = this.mAnchorManager;
        if (anchorManager != null && wh2.e(anchorManager.d()) > 1) {
            this.isShowAnchor = true;
            this.mAnchorIndicator.setVisibility(0);
            this.mAnchorIndicatorFixed.setVisibility(this.isShowFixAnchorIndicator ? 0 : 8);
            this.mHeadDividerLine.setVisibility(this.isShowFixAnchorIndicator ? 0 : 8);
            List<c5> d = this.mAnchorManager.d();
            this.mAnchorIndicator.setAnchorList(d);
            this.mAnchorIndicatorFixed.setAnchorList(d);
            setCurAnchorPosition(this.mAnchorManager.f());
            this.mAnchorManager.m(d, this.mAnchorIndicator, String.valueOf(this.mProjectId));
            return;
        }
        this.isShowAnchor = false;
        this.mAnchorIndicator.setVisibility(8);
        hideFixedAnchorIndicator();
    }

    private void updateCalendRemindText(boolean z) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1101370716")) {
            ipChange.ipc$dispatch("-1101370716", new Object[]{this, Boolean.valueOf(z)});
        } else if (z) {
            if (!ir1.i(mr1.CALENDAR)) {
                this.timerAndStagoryView.updateRemindMeBtnText(false);
            } else {
                this.timerAndStagoryView.updateRemindMeBtnText(qv1.d(this.mProjectDetailActivity, getCalendarRemindTitle(), getCalendSellTime()));
            }
        }
    }

    private void updateCountDownVisibility(boolean z, boolean z2) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1062796936")) {
            ipChange.ipc$dispatch("-1062796936", new Object[]{this, Boolean.valueOf(z), Boolean.valueOf(z2)});
        } else if (this.timerAndStagoryView == null) {
        } else {
            updateCalendRemindText(z);
            updateRecyclerMargin(this.timerAndStagoryView.setCountDownVisibility(z, z2, this.mDialogPanel.o(), isChangeAttendees(this.mProjectItemDataBean.getPurchaseLimitation(), z)));
        }
    }

    private void updateDetailDataHoldersAndTab() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1160125265")) {
            ipChange.ipc$dispatch("1160125265", new Object[]{this});
            return;
        }
        List<ProjectDataHolder> p = this.mProjectDataHolderManager.p(this.mProjectStaticDataBean, this.mProjectDynamicExtDataBean, this.mProjectDetailEvaluateBean, this.mProjectDetailDiscussionBean, this.mRecommendItems, this.mProjectItemDataBean, String.valueOf(this.mProjectId));
        if (wh2.e(p) > 0) {
            this.mProjectItemDetailAdapter.c(p);
        }
        updateAnchorData();
    }

    private void updateMemberPromptCountDownVisibility(boolean z, boolean z2) {
        ProjectMemberPrompt projectMemberPrompt;
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-286517450")) {
            ipChange.ipc$dispatch("-286517450", new Object[]{this, Boolean.valueOf(z), Boolean.valueOf(z2)});
            return;
        }
        ProjectDynamicExtDataBean projectDynamicExtDataBean = this.mProjectDynamicExtDataBean;
        if (projectDynamicExtDataBean != null && (projectMemberPrompt = projectDynamicExtDataBean.memberPrompt) != null && projectMemberPrompt.isSpecialBuy()) {
            ProjectSpecialBuyPromptView projectSpecialBuyPromptView = this.specialBuyPromptView;
            if (projectSpecialBuyPromptView != null) {
                updateRecyclerMargin(projectSpecialBuyPromptView.setCountDownVisibility(z, z2, this.mProjectDynamicExtDataBean.memberPrompt, isChangeAttendees(this.mProjectItemDataBean.getPurchaseLimitation(), false)));
                return;
            }
            return;
        }
        ProjectTimerAndStrategyTmPromptView projectTimerAndStrategyTmPromptView = this.timerAndStrategyTmPromptView;
        if (projectTimerAndStrategyTmPromptView == null) {
            return;
        }
        updateRecyclerMargin(projectTimerAndStrategyTmPromptView.setCountDownVisibility(z, z2, this.mProjectDynamicExtDataBean.memberPrompt, isChangeAttendees(this.mProjectItemDataBean.getPurchaseLimitation(), z)));
    }

    private void updateMemberPromptTimeCountDownStatus() {
        ProjectDynamicExtDataBean projectDynamicExtDataBean;
        long launchScd;
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1128784253")) {
            ipChange.ipc$dispatch("-1128784253", new Object[]{this});
        } else if (this.mProjectItemDataBean != null && (projectDynamicExtDataBean = this.mProjectDynamicExtDataBean) != null && projectDynamicExtDataBean.memberPrompt != null) {
            long a = zn2.a();
            if (this.mProjectDynamicExtDataBean.memberPrompt.isSpecialBuy()) {
                this.specialBuyPromptView.setItemName(getCalendarRemindTitle());
                long scd = this.mProjectDynamicExtDataBean.memberPrompt.getScd();
                if (scd <= 0) {
                    updateMemberPromptCountDownVisibility(true, false);
                    return;
                } else if (scd > a) {
                    updateMemberPromptCountDownVisibility(true, false);
                    return;
                } else {
                    this.mHasCountDownFinished = true;
                    timeCountDownFinished();
                    return;
                }
            }
            this.timerAndStrategyTmPromptView.setItemName(getCalendarRemindTitle());
            if (this.mProjectDynamicExtDataBean.memberPrompt.isPromptBeforeSale()) {
                launchScd = this.mProjectDynamicExtDataBean.memberPrompt.getScd();
            } else {
                launchScd = this.mProjectDynamicExtDataBean.memberPrompt.getLaunchScd();
            }
            if (launchScd <= 0) {
                updateMemberPromptCountDownVisibility(false, false);
            } else if (launchScd > a) {
                long j = launchScd - a;
                if (this.mMemberPromptOnTimeCountDownListener == null) {
                    this.mMemberPromptOnTimeCountDownListener = new C2326x();
                }
                if (this.mMemberPromptTimeCountDownManager == null) {
                    this.mMemberPromptTimeCountDownManager = TimeCountDownManagerImpl.c(this.mMemberPromptOnTimeCountDownListener);
                }
                updateMemberPromptCountDownVisibility(true, false);
                this.mMemberPromptTimeCountDownManager.setCountDown(j);
                this.mMemberPromptTimeCountDownManager.startCountDown();
            } else {
                this.mHasCountDownFinished = true;
                timeCountDownFinished();
            }
        } else {
            updateMemberPromptCountDownVisibility(false, false);
        }
    }

    private void updateMoreRecommendVisibility() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "436898594")) {
            ipChange.ipc$dispatch("436898594", new Object[]{this});
        } else if (isSoldOutAndNoUnpaid() && hasRecommendProject() && !this.mHasClosedMoreRecommend) {
            this.mFlMoreRecommendFloatLayer.setVisibility(0);
        } else {
            this.mFlMoreRecommendFloatLayer.setVisibility(8);
        }
    }

    private void updatePageUT() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1484008223")) {
            ipChange.ipc$dispatch("-1484008223", new Object[]{this});
            return;
        }
        ProjectItemDataBean projectItemDataBean = this.mProjectItemDataBean;
        if (projectItemDataBean != null) {
            String buyBtnText = projectItemDataBean.getBuyBtnText();
            if (TextUtils.isEmpty(this.mButtomText)) {
                this.mButtomText = buyBtnText;
            }
            HashMap hashMap = new HashMap();
            hashMap.put("project_post_status", buyBtnText);
            hashMap.put("project_pre_status", this.mButtomText);
            C0525a.C0527b c0527b = new C0525a.C0527b();
            c0527b.d(String.valueOf(this.mProjectId)).i(gb.PROJECT_PAGE).j(hashMap);
            C0529c.e().l(getActivity(), c0527b);
        }
    }

    private void updateProjectBasicInfo() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1866167604")) {
            ipChange.ipc$dispatch("-1866167604", new Object[]{this});
            return;
        }
        ProjectStaticDataBean projectStaticDataBean = this.mProjectStaticDataBean;
        if (projectStaticDataBean == null) {
            return;
        }
        ProjectStaticItemBaseBean itemBase = projectStaticDataBean.getItemBase();
        if (itemBase != null) {
            String projectPosterUrl = getProjectPosterUrl();
            String itemName = itemBase.getItemName();
            String subTitle = itemBase.getSubTitle();
            ProjectItemDetailAdapter projectItemDetailAdapter = this.mProjectItemDetailAdapter;
            if (!TextUtils.isEmpty(subTitle)) {
                itemName = subTitle;
            }
            projectItemDetailAdapter.l(itemName, projectPosterUrl);
            updateProjectName();
        }
        if (this.mTitleBarPanel != null) {
            this.mTitleBarPanel.g(wh2.e(yb.l(this.mProjectDynamicExtDataBean)) > 0);
        }
    }

    private void updateProjectFollowRelation(int i) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-622121714")) {
            ipChange.ipc$dispatch("-622121714", new Object[]{this, Integer.valueOf(i)});
        } else {
            ((ProjectItemPresenter) this.mPresenter).updateProjectFollowRelation(i, this.mProjectId, 7);
        }
    }

    private void updateProjectFollowStatus(FollowDataBean followDataBean) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1895987038")) {
            ipChange.ipc$dispatch("-1895987038", new Object[]{this, followDataBean});
        } else if (followDataBean.getStatus() >= 1) {
            showTipsOnWantSeeClick();
            setProjectFollowStatus(true);
            updateWantSeeByFollow(true);
        } else {
            setProjectFollowStatus(false);
            updateWantSeeByFollow(false);
        }
    }

    private void updateProjectName() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "554725975")) {
            ipChange.ipc$dispatch("554725975", new Object[]{this});
        } else {
            this.mTitleBarPanel.k("商品详情");
        }
    }

    private void updateProjectPurchaseBtnStatus() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-662553925")) {
            ipChange.ipc$dispatch("-662553925", new Object[]{this});
            return;
        }
        ProjectItemDataBean projectItemDataBean = this.mProjectItemDataBean;
        if (projectItemDataBean != null) {
            this.mPerformDataConfigure.g(projectItemDataBean.getPerformBases());
            this.mPerformDataConfigure.d(this.mProjectId);
        }
        initBottomProjectStatusBarView(this.mProjectItemDataBean);
        this.mLvBottomBar.setVisibility(0);
    }

    private void updateProjectStaticData() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1213094090")) {
            ipChange.ipc$dispatch("1213094090", new Object[]{this});
        } else if (this.mProjectStaticDataBean == null) {
        } else {
            updateProjectBasicInfo();
            setSeatImageAndAtomSplit();
            updateStrategyVisibility();
        }
    }

    private void updateRecyclerMargin(ProjectTimerAndStagoryView.StateEnum stateEnum) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-992210588")) {
            ipChange.ipc$dispatch("-992210588", new Object[]{this, stateEnum});
            return;
        }
        DamaiRootRecyclerView damaiRootRecyclerView = this.mRecyclerView;
        if (damaiRootRecyclerView == null) {
            return;
        }
        FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) damaiRootRecyclerView.getLayoutParams();
        ViewGroup.LayoutParams layoutParams2 = this.footerParam;
        layoutParams2.height = 0;
        if (stateEnum == ProjectTimerAndStagoryView.StateEnum.TIMER) {
            if (this.mProjectDynamicExtDataBean.memberPrompt != null) {
                layoutParams.bottomMargin = this.mDefaultRVMarginBottom;
                layoutParams2.height = m62.a(getContext(), 68.0f);
                this.mBottomLineView.setVisibility(0);
            } else {
                layoutParams.bottomMargin = this.mTimerRVMarginBottom;
                this.mBottomLineView.setVisibility(8);
            }
        } else if (stateEnum == ProjectTimerAndStagoryView.StateEnum.STAGORY) {
            layoutParams.bottomMargin = this.mSingleStagoryMargin;
            this.mBottomLineView.setVisibility(8);
        } else {
            layoutParams.bottomMargin = this.mDefaultRVMarginBottom;
            this.mBottomLineView.setVisibility(0);
        }
        this.mRecyclerView.setLayoutParams(layoutParams);
    }

    private void updateRefreshable() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "2122412870")) {
            ipChange.ipc$dispatch("2122412870", new Object[]{this});
            return;
        }
        int findFirstVisibleItemPosition = this.mLinearLayoutManager.findFirstVisibleItemPosition();
        if (findFirstVisibleItemPosition <= 1) {
            View findViewByPosition = this.mLinearLayoutManager.findViewByPosition(findFirstVisibleItemPosition);
            if ((findViewByPosition == null ? 0 : Math.abs(findViewByPosition.getTop())) == 0) {
                this.mLinearPullToRefreshView.setPullToRefreshEnabled(true);
                return;
            } else {
                this.mLinearPullToRefreshView.setPullToRefreshEnabled(false);
                return;
            }
        }
        this.mLinearPullToRefreshView.setPullToRefreshEnabled(false);
    }

    private void updateScreenShot() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "59567305")) {
            ipChange.ipc$dispatch("59567305", new Object[]{this});
            return;
        }
        ScreenShotDetector.k().x(null);
        ScreenShotDetector.k().x(this.extraListener);
    }

    private void updateStrategyVisibility() {
        ProjectTimerAndStagoryView.StateEnum strategyVisibility;
        ProjectMemberPrompt projectMemberPrompt;
        IpChange ipChange = $ipChange;
        boolean z = false;
        if (AndroidInstantRuntime.support(ipChange, "53300490")) {
            ipChange.ipc$dispatch("53300490", new Object[]{this});
            return;
        }
        boolean hasShowStrategy = hasShowStrategy();
        ProjectDynamicExtDataBean projectDynamicExtDataBean = this.mProjectDynamicExtDataBean;
        if (projectDynamicExtDataBean != null && (projectMemberPrompt = projectDynamicExtDataBean.memberPrompt) != null) {
            if (projectMemberPrompt.isSpecialBuy()) {
                if (hasShowStrategy && this.mProjectDynamicExtDataBean.memberPrompt.isPromptBeforeSale()) {
                    z = true;
                }
                strategyVisibility = this.specialBuyPromptView.setTmLottieStrategy(z, isChangeAttendees(this.mProjectItemDataBean.getPurchaseLimitation(), z));
            } else {
                strategyVisibility = this.timerAndStrategyTmPromptView.setTmLottieStrategy(hasShowStrategy, isChangeAttendees(this.mProjectItemDataBean.getPurchaseLimitation(), hasShowStrategy));
            }
        } else {
            strategyVisibility = this.timerAndStagoryView.setStrategyVisibility(hasShowStrategy, this.mDialogPanel.o(), isChangeAttendees(this.mProjectItemDataBean.getPurchaseLimitation(), hasShowStrategy));
        }
        updateRecyclerMargin(strategyVisibility);
    }

    private void updateTimeCountDownFunction() {
        ProjectMemberPrompt projectMemberPrompt;
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "86508319")) {
            ipChange.ipc$dispatch("86508319", new Object[]{this});
            return;
        }
        ProjectDynamicExtDataBean projectDynamicExtDataBean = this.mProjectDynamicExtDataBean;
        if (projectDynamicExtDataBean != null && (projectMemberPrompt = projectDynamicExtDataBean.memberPrompt) != null) {
            ProjectStaticDataBean projectStaticDataBean = this.mProjectStaticDataBean;
            if (projectStaticDataBean != null) {
                projectMemberPrompt.setAlipayDetailUrl(projectStaticDataBean.alipayDetailUrl);
            }
            if (this.mProjectDynamicExtDataBean.memberPrompt.isSpecialBuy()) {
                this.specialBuyPromptView.setVisibility(0);
                this.timerAndStrategyTmPromptView.setVisibility(8);
            } else {
                this.timerAndStrategyTmPromptView.setVisibility(0);
                this.specialBuyPromptView.setVisibility(8);
            }
            this.timerAndStagoryView.setVisibility(8);
            updateMemberPromptTimeCountDownStatus();
            return;
        }
        this.timerAndStrategyTmPromptView.setVisibility(8);
        this.specialBuyPromptView.setVisibility(8);
        this.timerAndStagoryView.setVisibility(0);
        updateTimeCountDownStatus();
    }

    private void updateTimeCountDownStatus() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1632416069")) {
            ipChange.ipc$dispatch("1632416069", new Object[]{this});
            return;
        }
        ProjectItemDataBean projectItemDataBean = this.mProjectItemDataBean;
        if (projectItemDataBean != null) {
            int buyBtnStatus = projectItemDataBean.getBuyBtnStatus();
            String sellStartTimeStr = this.mProjectItemDataBean.getSellStartTimeStr();
            long countDown = this.mProjectItemDataBean.getCountDown();
            long a = zn2.a();
            if ((buyBtnStatus != 105 && buyBtnStatus != 106) || TextUtils.isEmpty(sellStartTimeStr) || countDown <= 0) {
                updateCountDownVisibility(false, false);
                return;
            } else if (countDown > a) {
                long j = countDown - a;
                this.timerAndStagoryView.updateCountDownRemindText(sellStartTimeStr + "开抢");
                if (this.mOnTimeCountDownListener == null) {
                    this.mOnTimeCountDownListener = new C2327y();
                }
                if (this.mTimeCountDownManager == null) {
                    this.mTimeCountDownManager = TimeCountDownManagerImpl.c(this.mOnTimeCountDownListener);
                }
                this.mTimeCountDownManager.setCountDown(j);
                this.mTimeCountDownManager.startCountDown();
                updateCountDownVisibility(true, false);
                return;
            } else {
                this.mHasCountDownFinished = true;
                timeCountDownFinished();
                return;
            }
        }
        updateCountDownVisibility(false, false);
    }

    private void updateTitleAndFixAnchorVisibility(boolean z) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1235080042")) {
            ipChange.ipc$dispatch("-1235080042", new Object[]{this, Boolean.valueOf(z)});
        } else if (z) {
            hideFixedAnchorIndicator();
            this.mTitleBarPanel.l(false);
        } else {
            if (this.isFixedAnchorVisible) {
                showFixedAnchorIndicator();
            } else {
                hideFixedAnchorIndicator();
            }
            this.mTitleBarPanel.l(true);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void updateTitleBarStyle() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "860819717")) {
            ipChange.ipc$dispatch("860819717", new Object[]{this});
            return;
        }
        int findFirstVisibleItemPosition = this.mLinearLayoutManager.findFirstVisibleItemPosition();
        if (findFirstVisibleItemPosition <= 1) {
            View findViewByPosition = this.mLinearLayoutManager.findViewByPosition(findFirstVisibleItemPosition);
            if ((findViewByPosition == null ? 0 : Math.abs(findViewByPosition.getTop())) >= this.titleBar2DarkHeight) {
                this.mTitleBarPanel.d(true);
                return;
            } else {
                this.mTitleBarPanel.d(false);
                return;
            }
        }
        this.mTitleBarPanel.d(true);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void updateTitleBgAndAnchorIndicator() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-59717637")) {
            ipChange.ipc$dispatch("-59717637", new Object[]{this});
            return;
        }
        updateRefreshable();
        int findFirstVisibleItemPosition = this.mLinearLayoutManager.findFirstVisibleItemPosition();
        if (findFirstVisibleItemPosition <= 1) {
            View findViewByPosition = this.mLinearLayoutManager.findViewByPosition(findFirstVisibleItemPosition);
            checkDisplayFixedAnchorIndicator(findViewByPosition != null ? Math.abs(findViewByPosition.getTop()) : 0);
        } else if (this.isShowAnchor) {
            showFixedAnchorIndicator();
        } else {
            hideFixedAnchorIndicator();
        }
    }

    private void updateWantSeeButtonStatus(boolean z) {
        ProjectWantSeeBean projectWantSeeBean;
        String string;
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1921247200")) {
            ipChange.ipc$dispatch("-1921247200", new Object[]{this, Boolean.valueOf(z)});
            return;
        }
        ProjectDynamicExtDataBean projectDynamicExtDataBean = this.mProjectDynamicExtDataBean;
        if (projectDynamicExtDataBean == null || (projectWantSeeBean = projectDynamicExtDataBean.wantVO) == null) {
            return;
        }
        boolean isSubFlag = projectWantSeeBean.isSubFlag();
        this.mWantSeeNum = projectWantSeeBean.getWantNum();
        if (isSubFlag) {
            string = mu0.a().getResources().getString(R$string.i_want_to_see);
        } else {
            string = mu0.a().getResources().getString(R$string.want_to_see);
        }
        this.mTvProjectFollowText.setText(string);
        if (isSubFlag) {
            this.mViewProjectFollow.setFollowImage();
            if (z) {
                this.mViewProjectFollow.clickAnimate();
            }
        } else {
            this.mViewProjectFollow.setCancelImage();
            if (z) {
                this.mViewProjectFollow.cancelAnimate();
            } else if (fw1.a()) {
                this.mViewProjectFollow.guideAnimate();
                fw1.b();
            }
        }
        pp2.u().q2(this.mViewProjectFollow, String.valueOf(this.mProjectId), isSubFlag);
    }

    private void updateWantSeeByFollow(boolean z) {
        ProjectWantSeeBean projectWantSeeBean;
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "2104671684")) {
            ipChange.ipc$dispatch("2104671684", new Object[]{this, Boolean.valueOf(z)});
            return;
        }
        ProjectDynamicExtDataBean projectDynamicExtDataBean = this.mProjectDynamicExtDataBean;
        if (projectDynamicExtDataBean == null || (projectWantSeeBean = projectDynamicExtDataBean.wantVO) == null) {
            return;
        }
        if (z) {
            this.mWantSeeNum = projectWantSeeBean.getWantNum() + 1;
        } else {
            this.mWantSeeNum = Math.max(projectWantSeeBean.getWantNum() - 1, 0L);
        }
        this.mProjectDynamicExtDataBean.wantVO.setWantNum(this.mWantSeeNum);
        String a = WantSeeHelper.b().a(this.mWantSeeNum);
        this.mProjectDynamicExtDataBean.wantVO.setSubFlag(z);
        if (!TextUtils.isEmpty(this.mProjectDynamicExtDataBean.wantVO.getWantNumStr())) {
            this.mProjectDynamicExtDataBean.wantVO.setWantNumStr(a);
        }
        ProjectWantSeeBean projectWantSeeBean2 = this.mProjectDynamicExtDataBean.wantVO;
        updateWantSeeButtonStatus(true);
        ProjectHeaderPanel projectHeaderPanel = this.mHeadPanel;
        if (projectHeaderPanel != null) {
            projectHeaderPanel.A(z, projectWantSeeBean2);
        }
    }

    private List<View> viewIgnoreTagForExposure(View view) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1340967680")) {
            return (List) ipChange.ipc$dispatch("1340967680", new Object[]{this, view});
        }
        new ArrayList();
        return C0529c.e().I(C0529c.e().d(view));
    }

    @Override // cn.damai.common.app.base.BaseFragment
    protected int getLayoutResource() {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "1362742231") ? ((Integer) ipChange.ipc$dispatch("1362742231", new Object[]{this})).intValue() : R$layout.project_item_detail_main_layout;
    }

    public pv1 getProjectDataHolderManager() {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "-2046609609") ? (pv1) ipChange.ipc$dispatch("-2046609609", new Object[]{this}) : this.mProjectDataHolderManager;
    }

    @Override // cn.damai.commonbusiness.base.ResponseErrorPage.ErrorRefreshListener
    public void handleError(int i) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "2079561553")) {
            ipChange.ipc$dispatch("2079561553", new Object[]{this, Integer.valueOf(i)});
            return;
        }
        hideSkeleton();
        getProjectDetailData(0);
    }

    public boolean handlerBack() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "2144024005")) {
            return ((Boolean) ipChange.ipc$dispatch("2144024005", new Object[]{this})).booleanValue();
        }
        PrivilegeCodeVerifyFragment privilegeCodeVerifyFragment = this.mPrivilegeCodeVerifyFragment;
        if (privilegeCodeVerifyFragment != null && privilegeCodeVerifyFragment.isVisible() && this.mFlvPopupLayer.getVisibility() == 0) {
            dismissPopLayerFragment(this.mPrivilegeCodeVerifyFragment);
            return true;
        }
        Fragment fragment = this.mPopLayerFragment;
        if (fragment != null && fragment.isVisible() && this.mFlvPopupLayer.getVisibility() == 0) {
            dismissPopLayerFragment(this.mPopLayerFragment);
            return true;
        }
        NoticeDetailFragment noticeDetailFragment = this.detailFragment;
        if (noticeDetailFragment != null && noticeDetailFragment.isVisible() && this.mFlvPopupLayer.getVisibility() == 0) {
            dismissPopLayerFragment(this.detailFragment);
            return true;
        }
        C0529c.e().x(pp2.u().f1(this.mProjectId, true));
        return false;
    }

    @Override // cn.damai.common.app.base.BaseFragment
    public void initPresenter() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1412759802")) {
            ipChange.ipc$dispatch("1412759802", new Object[]{this});
        } else {
            ((ProjectItemPresenter) this.mPresenter).setVM(this, (ProjectItemContract.Model) this.mModel);
        }
    }

    @Override // cn.damai.common.app.base.BaseFragment
    protected void initView() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-2100375197")) {
            ipChange.ipc$dispatch("-2100375197", new Object[]{this});
            return;
        }
        this.mDefaultRVMarginBottom = m62.a(getContext(), 60.0f);
        this.mTimerRVMarginBottom = m62.a(getContext(), 121.0f);
        this.mSingleStagoryMargin = m62.a(getContext(), 104.0f);
        registerMessageObserver();
        initExtraParams();
        initPopFragmentHandler();
        initProjectDataHolderManager();
        initTitleView();
        initRecyclerView();
        initProjectDetailView();
        initBottomButtonView();
        initAnchorIndicator();
        initListeners();
        setupListeners();
        initExtraData();
    }

    @Override // androidx.fragment.app.Fragment
    public void onActivityCreated(@Nullable Bundle bundle) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "641969180")) {
            ipChange.ipc$dispatch("641969180", new Object[]{this, bundle});
            return;
        }
        super.onActivityCreated(bundle);
        setDamaiUTKeyBuilder(pp2.u().i0(this.mProjectId));
    }

    @Override // androidx.fragment.app.Fragment
    public void onActivityResult(int i, int i2, Intent intent) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-609529718")) {
            ipChange.ipc$dispatch("-609529718", new Object[]{this, Integer.valueOf(i), Integer.valueOf(i2), intent});
            return;
        }
        super.onActivityResult(i, i2, intent);
        ShareManager.E().r0(i, i2, intent);
        if (i == 2000 && i2 == 1000) {
            this.mProjectDetailActivity.finish();
        } else if (i == 4097 && i2 == -1) {
            updateProjectFollowRelation(1);
        } else if (i == 4101 && i2 == -1) {
            this.mPurchaseType = 1;
        } else if (i == 4103 && i2 == -1) {
            this.mPurchaseType = 2;
        } else if (i == 4119 && i2 == -1) {
            this.mPurchaseType = 4;
        } else if (i == 4120 && i2 == -1) {
            this.mPurchaseType = 3;
        } else if (i == 4115 && i2 == -1) {
            getAliMeTokenAndEnter();
        } else if (i == 4117 && i2 == -1) {
            popupSkuByPerformInfo();
        } else if (i != 4118 || i2 != -1) {
            if (i == 4130) {
                onRefresh();
            }
        } else {
            this.mHeadPanel.s();
            if (this.mProjectDetailActivity.isActivityFinsihed()) {
                return;
            }
            CouponDialogHelper.l(this.mProjectDetailActivity).y(true);
            CouponDialogHelper.l(this.mProjectDetailActivity).p();
        }
    }

    @Override // cn.damai.trade.newtradeorder.ui.projectdetail.projectdetailitem.ui.view.AnchorIndicatorView.OnAnchorItemClickListener
    public void onAnchorItemClick(int i, c5 c5Var) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1119833353")) {
            ipChange.ipc$dispatch("-1119833353", new Object[]{this, Integer.valueOf(i), c5Var});
            return;
        }
        clickedAnchorItem(i, c5Var);
        pp2.u().b0(c5Var.d(), this.mProjectId);
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1829472393")) {
            ipChange.ipc$dispatch("1829472393", new Object[]{this, view});
        }
    }

    @Override // cn.damai.commonbusiness.servicenotice.OnCompleteListener
    public void onComplete(int i) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "609714595")) {
            ipChange.ipc$dispatch("609714595", new Object[]{this, Integer.valueOf(i)});
        } else if (i == 1) {
            dismissPopLayerFragment(this.mPopLayerFragment);
        } else if (i == 2) {
            dismissPopLayerFragment(this.mPopLayerFragment);
        } else if (i == 3) {
            dismissPopLayerFragment(this.mPopLayerFragment);
        } else if (i == 4) {
            dismissPopLayerFragment(this.mPrivilegeCodeVerifyFragment);
        } else {
            dismissPopLayerFragment(this.mPopLayerFragment);
        }
    }

    @Override // androidx.fragment.app.Fragment
    public void onCreate(@Nullable Bundle bundle) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1801827831")) {
            ipChange.ipc$dispatch("1801827831", new Object[]{this, bundle});
            return;
        }
        super.onCreate(bundle);
        this.mIsFirstEnter = true;
        this.mPurchaseType = -1;
        r92.e(true);
        OrangeConfigCenter.c().e("damai_seat_data_preload_switch");
        this.mRegionManager = new i12();
        this.mPerformDataManager = fr1.d();
        this.mNewSkuDataManager = mk1.a();
        updateScreenShot();
    }

    @Override // androidx.fragment.app.Fragment
    public void onDestroy() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "652152567")) {
            ipChange.ipc$dispatch("652152567", new Object[]{this});
            return;
        }
        SplitImageSizeCache.b();
        yr.c().a("brand_state_changed", this.action);
        super.onDestroy();
        removeShotListener();
        cancelCountDown();
        SkuPerform c = this.mPerformDataConfigure.c();
        if (c != null) {
            this.mRegionManager.d(fr1.b(c));
        }
        fr1 fr1Var = this.mPerformDataManager;
        if (fr1Var != null) {
            fr1Var.e(this.mProjectId);
        }
        mk1 mk1Var = this.mNewSkuDataManager;
        if (mk1Var != null) {
            mk1Var.c(this.mProjectId);
        }
        ProjectHeaderPanel projectHeaderPanel = this.mHeadPanel;
        if (projectHeaderPanel != null) {
            projectHeaderPanel.u();
        }
    }

    @Override // androidx.fragment.app.Fragment
    public void onDetach() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1589214778")) {
            ipChange.ipc$dispatch("-1589214778", new Object[]{this});
            return;
        }
        super.onDetach();
        r92.e(false);
        OrangeConfigCenter.c().g("damai_seat_data_preload_switch");
    }

    public void onExtendInfoItemClick(View view, int i, String str, String str2) {
        LinkedHashMap<String, Integer> q;
        IpChange ipChange = $ipChange;
        int i2 = 0;
        if (AndroidInstantRuntime.support(ipChange, "83481833")) {
            ipChange.ipc$dispatch("83481833", new Object[]{this, view, Integer.valueOf(i), str, str2});
        } else if (!TextUtils.isEmpty(str2) && (q = this.mProjectDataHolderManager.q(i)) != null) {
            try {
                Integer num = q.get(str2);
                if (num != null) {
                    i2 = num.intValue();
                }
            } catch (Exception unused) {
            }
            if (!TextUtils.isEmpty(str)) {
                C0529c.e().x(pp2.u().x0(this.mProjectId, i2));
                DMNav.from(this.mActivity).toUri(str);
                return;
            }
            ArrayList arrayList = new ArrayList();
            for (Map.Entry<String, Integer> entry : q.entrySet()) {
                String key = entry.getKey();
                if (!TextUtils.isEmpty(key)) {
                    PicInfo picInfo = new PicInfo();
                    picInfo.setPicUrl(key);
                    arrayList.add(picInfo);
                }
            }
            C0529c.e().x(pp2.u().x0(this.mProjectId, i2));
            tv1.l(this.mProjectDetailActivity, this.mProjectId, arrayList, i2);
        }
    }

    public void onMoreExtendInfoBtnClickListener(int i, int i2) {
        IRichTextManager r;
        AnchorManager anchorManager;
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1758583076")) {
            ipChange.ipc$dispatch("-1758583076", new Object[]{this, Integer.valueOf(i), Integer.valueOf(i2)});
        } else if (isRemoving() || isDetached() || this.mProjectItemDetailAdapter == null || (r = this.mProjectDataHolderManager.r(i)) == null) {
        } else {
            boolean hasExpanded = r.hasExpanded();
            r.expandShrinkRichText();
            this.mProjectItemDetailAdapter.c(this.mProjectDataHolderManager.o());
            this.mProjectItemDetailAdapter.notifyDataSetChanged();
            if (hasExpanded && (anchorManager = this.mAnchorManager) != null && anchorManager.e() != null && this.mAnchorManager.e().c() != null) {
                setCurAnchorPosition(0);
                scrollToPosition(r.getStartIndex(), getOffset());
                this.isFixedAnchorVisible = true;
                updateTitleAndFixAnchorVisibility(false);
            }
            C0529c.e().x(pp2.u().y0(this.mProjectId));
        }
    }

    @Override // cn.damai.commonbusiness.base.BaseDamaiView
    public void onNetError(String str, String str2, String str3) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-647382452")) {
            ipChange.ipc$dispatch("-647382452", new Object[]{this, str, str2, str3});
            return;
        }
        hideSkeleton();
        stopProgressDialog();
        this.mLinearPullToRefreshView.onRefreshComplete();
        this.mIsLoading = false;
        ProjectDetailXFlushUtil.m("mtop.alibaba.damai.detail.getdetail", String.valueOf(this.mProjectId), str, str2, getProjectName());
        if (toDisplayErrorPage()) {
            displayErrorPage(str, str2, str3);
            this.mTitleBarPanel.l(false);
            ProjectDetailXFlushUtil.h("mtop.alibaba.damai.detail.getdetail", String.valueOf(this.mProjectId), str, str2, getProjectName(), false);
        } else if (isFlowLimitedErrorCode(str) && !this.mHasDisplayedLimitedDialog) {
            showFlowLimitedDialog();
            this.mHasDisplayedLimitedDialog = true;
        } else {
            ToastUtil.a().j(this.mProjectDetailActivity, str2);
        }
    }

    @Override // cn.damai.commonbusiness.base.BaseDamaiView
    public void onNetSuccess() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1496832301")) {
            ipChange.ipc$dispatch("-1496832301", new Object[]{this});
            return;
        }
        hideSkeleton();
        stopProgressDialog();
        onResponseSuccess(this.mContentRootLayout);
    }

    @Override // androidx.fragment.app.Fragment
    public void onPause() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-237816197")) {
            ipChange.ipc$dispatch("-237816197", new Object[]{this});
            return;
        }
        super.onPause();
        pauseRedPacket();
    }

    @Override // cn.damai.trade.newtradeorder.ui.projectdetail.projectdetailitem.contract.ProjectItemContract.View
    public void onPraiseViewOnClick(CommentsItemBean commentsItemBean) {
        ProjectDetailCommentBean projectDetailCommentBean;
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "99704301")) {
            ipChange.ipc$dispatch("99704301", new Object[]{this, commentsItemBean});
        } else if (commentsItemBean != null && (projectDetailCommentBean = this.mProjectDetailEvaluateBean) != null) {
            List<CommentsItemBean> moduleComments = projectDetailCommentBean.getModuleComments();
            int e = wh2.e(moduleComments);
            for (int i = 0; i < e; i++) {
                CommentsItemBean commentsItemBean2 = moduleComments.get(i);
                if (commentsItemBean2 != null && commentsItemBean.getCommentId().equals(commentsItemBean2.getCommentId())) {
                    CommentPraiseInfoBean praiseInfo = commentsItemBean.getPraiseInfo();
                    CommentPraiseInfoBean praiseInfo2 = commentsItemBean2.getPraiseInfo();
                    if (praiseInfo.isHasPraised() != praiseInfo2.isHasPraised()) {
                        praiseInfo2.setHasPraised(praiseInfo.isHasPraised());
                        praiseInfo2.setPraiseCount(praiseInfo.getPraiseCount());
                        return;
                    }
                    return;
                }
            }
        }
    }

    @Override // cn.damai.trade.newtradeorder.ui.projectdetail.ui.fragment.PrivilegeCodeVerifyFragment.OnPrivilegeCodeVerifyResultListener
    public void onPrivilegeCodeVerifySuccess(int i, String str) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-286357024")) {
            ipChange.ipc$dispatch("-286357024", new Object[]{this, Integer.valueOf(i), str});
            return;
        }
        if (this.mProjectItemDataBean != null) {
            if (TextUtils.isEmpty(str)) {
                str = this.mProjectItemDataBean.getPrivilegeId();
            }
            this.mPrivilegeId = str;
        }
        if (i == 300) {
            showPerformListFragment(false);
        } else if (i == 200) {
            handleChooseSeatPage();
        }
    }

    @Override // cn.damai.trade.newtradeorder.ui.projectdetail.ui.view.PullToRefreshView.OnRefreshListener
    public void onRefresh() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1129765770")) {
            ipChange.ipc$dispatch("-1129765770", new Object[]{this});
        } else if (!this.mIsLoading) {
            this.mProjectDataHolderManager.T();
            getProjectDetailData(1);
        } else {
            stopProgressDialog();
            this.mLinearPullToRefreshView.onRefreshComplete();
        }
    }

    @Override // cn.damai.commonbusiness.base.DamaiBaseMvpFragment, androidx.fragment.app.Fragment
    public void onResume() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1429548308")) {
            ipChange.ipc$dispatch("-1429548308", new Object[]{this});
            return;
        }
        super.onResume();
        ScreenShotDetector.k().y(false);
        resumeRedPacket();
        if (!this.mIsFirstEnter) {
            resetProjectPerformData();
            getProjectDetailData(2);
        } else {
            this.mIsFirstEnter = false;
            showSkeleton();
            getProjectDetailData(0);
        }
        dismissScreenShotShare();
        Log.e("xxxxx_fragment_ut", "detail onresume");
    }

    @Override // cn.damai.trade.newtradeorder.ui.projectdetail.projectdetailitem.contract.ProjectItemContract.View
    public void onRetrieveDiscussionError(String str, String str2) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1940450913")) {
            ipChange.ipc$dispatch("1940450913", new Object[]{this, str, str2});
        } else {
            ProjectDetailXFlushUtil.j(String.valueOf(this.mProjectId), str, str2);
        }
    }

    @Override // cn.damai.trade.newtradeorder.ui.projectdetail.projectdetailitem.contract.ProjectItemContract.View
    public void onRetrieveDiscussionSuccess(ProjectDetailCommentBean projectDetailCommentBean) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "135475040")) {
            ipChange.ipc$dispatch("135475040", new Object[]{this, projectDetailCommentBean});
            return;
        }
        this.mProjectDetailDiscussionBean = projectDetailCommentBean;
        updateDetailDataHoldersAndTab();
    }

    @Override // cn.damai.trade.newtradeorder.ui.projectdetail.projectdetailitem.contract.ProjectItemContract.View
    public void onReturnProjectDetailCommentError(String str, String str2) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1975126754")) {
            ipChange.ipc$dispatch("1975126754", new Object[]{this, str, str2});
        } else {
            ProjectDetailXFlushUtil.k(String.valueOf(this.mProjectId), str, str2);
        }
    }

    @Override // cn.damai.trade.newtradeorder.ui.projectdetail.projectdetailitem.contract.ProjectItemContract.View
    public void onReturnProjectDetailCommentSuccess(ProjectDetailCommentBean projectDetailCommentBean) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-636900289")) {
            ipChange.ipc$dispatch("-636900289", new Object[]{this, projectDetailCommentBean});
            return;
        }
        this.mProjectDetailEvaluateBean = projectDetailCommentBean;
        updateDetailDataHoldersAndTab();
    }

    @Override // cn.damai.trade.newtradeorder.ui.projectdetail.projectdetailitem.contract.ProjectItemContract.View
    public void onReturnProjectDetailDataSuccess(int i, ProjectDetailDataBean projectDetailDataBean) {
        ProjectWantSeeBean.GuideVO guideVO;
        ProjectStaticDataBean projectStaticDataBean;
        ProjectStaticExtendInfoBean projectStaticExtendInfoBean;
        ProjectTicketGuideBean projectTicketGuideBean;
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1072918516")) {
            ipChange.ipc$dispatch("-1072918516", new Object[]{this, Integer.valueOf(i), projectDetailDataBean});
            return;
        }
        this.mLinearPullToRefreshView.onRefreshComplete();
        this.mIsLoading = false;
        if (projectDetailDataBean == null) {
            return;
        }
        ProjectStaticDataBean staticData = projectDetailDataBean.getStaticData();
        if (staticData != null) {
            String str = staticData.track;
            if (!TextUtils.isEmpty(str)) {
                pp2.u().G2(this.mProjectId, this.mActivity, str);
            }
        }
        this.mHeadPanel.o(projectDetailDataBean, this.mRankInfo);
        ProjectDialogHelper projectDialogHelper = this.mDialogPanel;
        if (projectDialogHelper != null) {
            projectDialogHelper.j(staticData, this.mProjectId);
        }
        if (toDisplayErrorPage()) {
            ProjectDetailXFlushUtil.h("mtop.alibaba.damai.detail.getdetail", String.valueOf(this.mProjectId), "2000", "", getProjectName(), true);
        }
        this.mProjectDetailDataBean = projectDetailDataBean;
        this.mProjectStaticDataBean = projectDetailDataBean.getStaticData();
        this.mProjectDynamicExtDataBean = projectDetailDataBean.getDynamicExtData();
        ProjectItemDataBean item = projectDetailDataBean.getItem();
        this.mProjectItemDataBean = item;
        this.mPrivilegeId = item == null ? "" : item.getPrivilegeId();
        ProjectStaticDataBean projectStaticDataBean2 = this.mProjectStaticDataBean;
        if (projectStaticDataBean2 != null && (projectTicketGuideBean = projectStaticDataBean2.ticketPurchasesGuidePage) != null && !TextUtils.isEmpty(projectTicketGuideBean.purchaseGuideUrl)) {
            StringBuilder sb = new StringBuilder(this.mProjectStaticDataBean.ticketPurchasesGuidePage.purchaseGuideUrl);
            getResetAttendeesOrangeSwitch();
            if (this.mProjectItemDataBean.getPurchaseLimitation() != 0) {
                sb.append("&isSupportMultiple=YES");
            }
            if (isChangeAttendees(this.mProjectItemDataBean.getPurchaseLimitation(), false)) {
                sb.append("&highLightSection=needRealName");
            }
            this.mProjectStaticDataBean.ticketPurchasesGuidePage.purchaseGuideUrl = sb.toString();
        }
        updateRefreshable();
        updateTitleAndFixAnchorVisibility(false);
        updateProjectStaticData();
        updateWantSeeButtonStatus(false);
        ProjectItemDataBean projectItemDataBean = this.mProjectItemDataBean;
        int buyBtnStatus = projectItemDataBean == null ? -1 : projectItemDataBean.getBuyBtnStatus();
        autoCancelCalendarRemind();
        updateTimeCountDownFunction();
        registerRedPacketMessage();
        preloadRegionData();
        updateProjectPurchaseBtnStatus();
        ProjectItemStatusHelper projectItemStatusHelper = this.mProjectItemStatusHelper;
        if (projectItemStatusHelper != null && !projectItemStatusHelper.l()) {
            cancelCountDown();
            displayProjectNotExistPage();
            return;
        }
        ProjectItemDataBean projectItemDataBean2 = this.mProjectItemDataBean;
        processAutoShowSku(buyBtnStatus, projectItemDataBean2 != null ? projectItemDataBean2.getBuyBtnStatus() : -1);
        confirmPromptContentPriority();
        reportProjectCouponPromotionUT();
        executeEvaluatesAndDiscussionRequest();
        updateDetailDataHoldersAndTab();
        updateMoreRecommendVisibility();
        saveHotSellStartTime();
        if (this.mProjectStaticDataBean != null) {
            this.mTitleBarPanel.j(this.mProjectId);
            this.mTitleBarPanel.m(this.mProjectStaticDataBean.getShareIconPicUrl());
        }
        ProjectDetailDataBean projectDetailDataBean2 = this.mProjectDetailDataBean;
        if (projectDetailDataBean2 != null && (projectStaticDataBean = projectDetailDataBean2.staticData) != null && (projectStaticExtendInfoBean = projectStaticDataBean.itemExtendInfo) != null) {
            this.mTitleBarPanel.i(projectStaticExtendInfoBean.approvalVO != null);
        }
        WantSeePosterTips.C1554a c1554a = WantSeePosterTips.Companion;
        if (c1554a.a()) {
            return;
        }
        ProjectDynamicExtDataBean projectDynamicExtDataBean = this.mProjectDynamicExtDataBean;
        if (projectDynamicExtDataBean != null && projectDynamicExtDataBean.wantVO != null && !isBottomTimerAndStrategyShowing() && (guideVO = this.mProjectDynamicExtDataBean.wantVO.guideVO) != null) {
            WantSeePosterTips.AbstractC1555b.C1559d c1559d = WantSeePosterTips.AbstractC1555b.C1559d.INSTANCE;
            c1559d.u(guideVO.title);
            c1559d.v(guideVO.titleSuffix);
            c1559d.t(guideVO.subTitle);
            c1559d.r(guideVO.posterUrl);
            c1559d.q(Integer.valueOf(guideVO.titleType));
            this.wantSeePosterTips.setProjectId(Long.valueOf(this.mProjectId));
            this.wantSeePosterTips.setPageSource(c1559d);
            this.wantSeePosterTips.showAnim();
            this.wantSeePosterTips.mark(Long.valueOf(this.mProjectId));
            c1554a.b(true);
        }
        enterShowWantSeeGuideTips(this.mProjectId);
    }

    @Override // cn.damai.trade.newtradeorder.ui.projectdetail.projectdetailitem.contract.ProjectItemContract.View
    public void onReturnProjectNATDataFail(String str, String str2) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1920813267")) {
            ipChange.ipc$dispatch("-1920813267", new Object[]{this, str, str2});
            return;
        }
        ProjectDialogHelper projectDialogHelper = this.mDialogPanel;
        if (projectDialogHelper != null) {
            projectDialogHelper.s();
        }
    }

    @Override // cn.damai.trade.newtradeorder.ui.projectdetail.projectdetailitem.contract.ProjectItemContract.View
    public void onReturnProjectNATDataSuccess(ProjectInformationBean projectInformationBean) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1156807754")) {
            ipChange.ipc$dispatch("-1156807754", new Object[]{this, projectInformationBean});
            return;
        }
        ProjectDialogHelper projectDialogHelper = this.mDialogPanel;
        if (projectDialogHelper != null) {
            projectDialogHelper.q(projectInformationBean);
        }
    }

    @Override // cn.damai.trade.newtradeorder.ui.projectdetail.projectdetailitem.contract.ProjectItemContract.View
    public void onReturnProjectRecommendError(String str, String str2) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "768589648")) {
            ipChange.ipc$dispatch("768589648", new Object[]{this, str, str2});
        } else {
            ProjectDetailXFlushUtil.p(String.valueOf(this.mProjectId), str, str2);
        }
    }

    @Override // cn.damai.trade.newtradeorder.ui.projectdetail.projectdetailitem.contract.ProjectItemContract.View
    public void onReturnProjectRecommendSuccess(ProjectRecommendListBean projectRecommendListBean) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1551394121")) {
            ipChange.ipc$dispatch("-1551394121", new Object[]{this, projectRecommendListBean});
        } else if (projectRecommendListBean != null) {
            this.mRecommendItems = projectRecommendListBean.recommends;
            updateDetailDataHoldersAndTab();
            updateMoreRecommendVisibility();
        }
    }

    @Override // cn.damai.trade.newtradeorder.ui.projectdetail.projectdetailitem.contract.ProjectItemContract.View
    public void onReturnSkuBeanDataFail(String str, String str2) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-585674496")) {
            ipChange.ipc$dispatch("-585674496", new Object[]{this, str, str2});
            return;
        }
        this.mIsLoading = false;
        if (toDisplayErrorPage()) {
            displayErrorPage(str, str2, "mtop.alibaba.detail.subpage.getdetail");
            this.mTitleBarPanel.l(false);
        } else if (isFlowLimitedErrorCode(str) && !this.mHasDisplayedLimitedDialog) {
            showFlowLimitedDialog();
            this.mHasDisplayedLimitedDialog = true;
        } else {
            if (!TextUtils.isEmpty(str2) && str2.contains("result")) {
                str2 = "项目太火爆了，请稍后再试";
            }
            ToastUtil.a().j(this.mProjectDetailActivity, str2);
        }
    }

    @Override // cn.damai.trade.newtradeorder.ui.projectdetail.projectdetailitem.contract.ProjectItemContract.View
    public void onReturnSkuBeanDataSuccess(SkuBean skuBean) {
        long j;
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1223338604")) {
            ipChange.ipc$dispatch("1223338604", new Object[]{this, skuBean});
            return;
        }
        this.mIsLoading = false;
        if (skuBean == null) {
            return;
        }
        ItemBuyBtnBean itemBuyBtnBean = skuBean.itemBuyBtn;
        if (itemBuyBtnBean == null) {
            ToastUtil.i("麦麦开小差了，请稍后重试");
            return;
        }
        int i = itemBuyBtnBean.btnStatus;
        if (i != 230 && i != 231) {
            this.mSkuBean = skuBean;
        } else {
            this.mSkuBean = null;
        }
        ProjectItemDataBean projectItemDataBean = this.mProjectItemDataBean;
        if (projectItemDataBean != null) {
            projectItemDataBean.setBuyBtnText(itemBuyBtnBean.btnText);
            this.mProjectItemDataBean.setBuyBtnTip(itemBuyBtnBean.btnTips);
            this.mProjectItemDataBean.setBuyBtnStatus(itemBuyBtnBean.btnStatus);
        }
        if (itemBuyBtnBean.btnStatus == 106) {
            try {
                j = Long.parseLong(itemBuyBtnBean.scd);
            } catch (Exception unused) {
                j = 0;
            }
            if (j > 60) {
                this.mPurchaseType = 4;
                getProjectDetailData(1);
                return;
            } else if (j > 0) {
                this.mProjectItemDataBean.setCountDown(j);
                updateTimeCountDownFunction();
                ProjectItemStatusHelper projectItemStatusHelper = this.mProjectItemStatusHelper;
                if (projectItemStatusHelper != null) {
                    projectItemStatusHelper.u(this.mProjectItemDataBean);
                    updatePageUT();
                    if (!this.mProjectItemStatusHelper.l()) {
                        cancelCountDown();
                        displayProjectNotExistPage();
                        return;
                    }
                }
                autoShowSkuLayer();
                return;
            } else {
                return;
            }
        }
        updateCountDownVisibility(false, false);
        updateMemberPromptCountDownVisibility(false, false);
        ProjectItemStatusHelper projectItemStatusHelper2 = this.mProjectItemStatusHelper;
        if (projectItemStatusHelper2 != null) {
            projectItemStatusHelper2.u(this.mProjectItemDataBean);
            updatePageUT();
            if (!this.mProjectItemStatusHelper.l()) {
                cancelCountDown();
                displayProjectNotExistPage();
                return;
            }
            this.mPurchaseType = -1;
            popupSkuByPerformInfo();
        }
    }

    public void onSelfActivityResult(int i, int i2, Intent intent) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-2076110946")) {
            ipChange.ipc$dispatch("-2076110946", new Object[]{this, Integer.valueOf(i), Integer.valueOf(i2), intent});
        } else if (i == 4128) {
            startWantSeeGuideTimer(WantSeeGuideTips.AbstractC1546b.C1548b.INSTANCE);
        } else if (i != 4129) {
        } else {
            startWantSeeGuideTimer(WantSeeGuideTips.AbstractC1546b.C1550d.INSTANCE);
        }
    }

    @Override // cn.damai.trade.newtradeorder.ui.projectdetail.projectdetailitem.contract.ProjectItemContract.View
    public void onUpdateProjectFollowStatusError(String str, String str2) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1860681576")) {
            ipChange.ipc$dispatch("-1860681576", new Object[]{this, str, str2});
            return;
        }
        ToastUtil.a().j(this.mActivity, str2);
        ProjectDetailXFlushUtil.l(String.valueOf(this.mProjectId), str, str2);
    }

    @Override // cn.damai.trade.newtradeorder.ui.projectdetail.projectdetailitem.contract.ProjectItemContract.View
    public void onUpdateProjectFollowStatusSuccess(FollowDataBean followDataBean) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "431810988")) {
            ipChange.ipc$dispatch("431810988", new Object[]{this, followDataBean});
        } else if (followDataBean != null) {
            xr.c(FocusEvent.EVENT_NAME_PROJECT_FOCUS_CHANGED, FocusEvent.projectFocusChanged());
            updateProjectFollowStatus(followDataBean);
        }
    }

    @Override // cn.damai.common.app.base.BaseView
    public void showEmptyView() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "185636925")) {
            ipChange.ipc$dispatch("185636925", new Object[]{this});
        }
    }

    @Override // cn.damai.common.app.base.BaseView
    public void showErrorTips(String str) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1479669319")) {
            ipChange.ipc$dispatch("-1479669319", new Object[]{this, str});
            return;
        }
        FragmentActivity activity = getActivity();
        if (TextUtils.isEmpty(str) || activity == null || activity.isFinishing()) {
            return;
        }
        ToastUtil.a().e(activity, str);
    }

    @Override // cn.damai.common.app.base.BaseView
    public void showLoading(String str) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "531119581")) {
            ipChange.ipc$dispatch("531119581", new Object[]{this, str});
        }
    }

    @Override // cn.damai.common.app.base.BaseView
    public void stopLoading() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1523871128")) {
            ipChange.ipc$dispatch("1523871128", new Object[]{this});
        }
    }

    private void showWantTips() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1338053171")) {
            ipChange.ipc$dispatch("1338053171", new Object[]{this});
            return;
        }
        ProjectDynamicExtDataBean projectDynamicExtDataBean = this.mProjectDynamicExtDataBean;
        if (projectDynamicExtDataBean == null || projectDynamicExtDataBean.wantVO == null || this.mProjectItemDataBean == null || isBottomTimerAndStrategyShowing() || g03.INSTANCE.e(this.mActivity, this.mGuideUtProvider)) {
            return;
        }
        ProjectWantSeeBean projectWantSeeBean = this.mProjectDynamicExtDataBean.wantVO;
        if (this.mProjectItemDataBean.showWantSeeGuideTips()) {
            CountDownTimer countDownTimer = this.wantSeeGuideTipsTimer;
            if (countDownTimer != null) {
                countDownTimer.cancel();
            }
            WantSeeGuideTips.AbstractC1546b.C1551e c1551e = WantSeeGuideTips.AbstractC1546b.C1551e.INSTANCE;
            c1551e.j(projectWantSeeBean.tipsTitle);
            c1551e.i(projectWantSeeBean.tipsSubTitle);
            this.wantSeeGuideTips.setScenesSource(c1551e);
            ((FrameLayout.LayoutParams) this.wantSeeGuideTips.getLayoutParams()).gravity = BadgeDrawable.BOTTOM_END;
            this.wantSeeGuideTips.showAnim();
        } else {
            CountDownTimer countDownTimer2 = this.wantSeeGuideTipsTimer;
            if (countDownTimer2 != null) {
                countDownTimer2.cancel();
            }
            WantSeeGuideTips wantSeeGuideTips = this.wantSeeGuideTips;
            if (wantSeeGuideTips != null) {
                wantSeeGuideTips.cancel();
            }
            WantSeeTips.AbstractC1562a.C1567e c1567e = WantSeeTips.AbstractC1562a.C1567e.INSTANCE;
            c1567e.p(projectWantSeeBean.tipsTitle);
            c1567e.o(projectWantSeeBean.tipsSubTitle);
            this.wantSeeTips.setPageSource(c1567e);
            this.wantSeeTips.showAnim();
        }
        pp2.u().Y1(this.wantSeeTips, String.valueOf(this.mProjectId), this.mButtomText);
    }
}
