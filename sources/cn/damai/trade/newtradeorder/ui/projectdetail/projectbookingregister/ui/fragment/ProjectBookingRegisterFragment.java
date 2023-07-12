package cn.damai.trade.newtradeorder.ui.projectdetail.projectbookingregister.ui.fragment;

import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.Bitmap;
import android.net.Uri;
import android.os.Bundle;
import android.os.SystemClock;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.annotation.Nullable;
import androidx.recyclerview.widget.RecyclerView;
import cn.damai.common.app.widget.DMDialog;
import cn.damai.common.nav.DMNav;
import cn.damai.common.nav.NavUri;
import cn.damai.common.user.C0529c;
import cn.damai.common.util.ToastUtil;
import cn.damai.commonbusiness.base.DamaiBaseMvpFragment;
import cn.damai.commonbusiness.base.PermissionsHelper;
import cn.damai.commonbusiness.imagebrowse.bean.PicInfo;
import cn.damai.commonbusiness.search.bean.FollowDataBean;
import cn.damai.commonbusiness.share.ShareManager;
import cn.damai.commonbusiness.util.DMRGBUtil;
import cn.damai.h5container.CaptureActivity;
import cn.damai.im.AliMeUtil;
import cn.damai.login.LoginManager;
import cn.damai.trade.R$id;
import cn.damai.trade.R$layout;
import cn.damai.trade.R$string;
import cn.damai.trade.newtradeorder.ui.projectdetail.common.bean.VenueBean;
import cn.damai.trade.newtradeorder.ui.projectdetail.listeners.OnExtendInfoImageItemClickListener;
import cn.damai.trade.newtradeorder.ui.projectdetail.projectbookingregister.bean.DynamicExtData;
import cn.damai.trade.newtradeorder.ui.projectdetail.projectbookingregister.bean.ItemData;
import cn.damai.trade.newtradeorder.ui.projectdetail.projectbookingregister.bean.ProjectBookingRegisterData;
import cn.damai.trade.newtradeorder.ui.projectdetail.projectbookingregister.bean.StaticData;
import cn.damai.trade.newtradeorder.ui.projectdetail.projectbookingregister.contract.ProjectBookingRegisterContract;
import cn.damai.trade.newtradeorder.ui.projectdetail.projectbookingregister.model.ProjectBookingRegisterModel;
import cn.damai.trade.newtradeorder.ui.projectdetail.projectbookingregister.presenter.ProjectBookingRegisterPresenter;
import cn.damai.trade.newtradeorder.ui.projectdetail.projectbookingregister.ui.adapter.ProjectBookingRegisterAdapter;
import cn.damai.trade.newtradeorder.ui.projectdetail.projectbookingregister.ui.view.BuyButtonStatusHelper;
import cn.damai.trade.newtradeorder.ui.projectdetail.projectdetailitem.bean.ProjectRatingContentLabelBean;
import cn.damai.trade.newtradeorder.ui.projectdetail.projectdetailitem.dataholder.ProjectDataHolder;
import cn.damai.trade.newtradeorder.ui.projectdetail.projectdetailitem.ui.view.projectheader.OnHeadClickListener;
import cn.damai.trade.newtradeorder.ui.projectdetail.projectdetailitem.ui.view.projectheader.ProjectTitleBarPanel;
import cn.damai.trade.newtradeorder.ui.projectdetail.ui.activity.ProjectDetailActivity;
import cn.damai.trade.newtradeorder.ui.projectdetail.ui.view.PullToRefreshView;
import cn.damai.trade.newtradeorder.ui.projectdetail.util.ProjectIntentExtraParser;
import cn.damai.uikit.irecycler.DamaiRootRecyclerView;
import cn.damai.uikit.irecycler.widget.WrapLinearLayoutManager;
import cn.damai.uikit.view.SeeAnimateView;
import cn.damai.user.userprofile.FeedsViewModel;
import com.alibaba.aliweex.adapter.module.location.ILocatable;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import tb.cm2;
import tb.cs;
import tb.iv1;
import tb.jv1;
import tb.kv1;
import tb.m62;
import tb.mu0;
import tb.pp2;
import tb.wh2;
import tb.wv1;
import tb.yv1;
import tb.z20;

/* compiled from: Taobao */
/* loaded from: classes8.dex */
public class ProjectBookingRegisterFragment extends DamaiBaseMvpFragment<ProjectBookingRegisterPresenter, ProjectBookingRegisterModel> implements ProjectBookingRegisterContract.View {
    private static transient /* synthetic */ IpChange $ipChange;
    private BuyButtonStatusHelper mBuyButtonStatusHelper;
    private DynamicExtData mDynamicExtData;
    private FrameLayout mFlProjectContentContainer;
    private FrameLayout mFlPurchaseStatusBarContainer;
    private iv1 mHeadPanel;
    private boolean mIsFirstEnter;
    private boolean mIsLoading;
    private boolean mIsScrolled;
    private ItemData mItemData;
    private ImageView mIvProjectPosterMask;
    private WrapLinearLayoutManager mLinearLayoutManager;
    private View mLvBottomBar;
    private FrameLayout mLvCustomerService;
    private LinearLayout mLvProjectDetailHeader;
    private View.OnClickListener mOnCustomerServiceClickListener;
    private OnExtendInfoImageItemClickListener mOnExtendInfoImageItemClickListener;
    private View.OnClickListener mOnProjectFollowClickListener;
    private PullToRefreshView.OnRefreshListener mOnRefreshListener;
    private ProjectBookingRegisterAdapter mProjectBookingRegisterAdapter;
    private jv1 mProjectBookingRegisterDataManager;
    private ProjectDetailActivity mProjectDetailActivity;
    private ProjectIntentExtraParser.ProjectDetailExtrasData mProjectExtraData;
    private long mProjectId;
    private PullToRefreshView mPullToRefreshView;
    private DamaiRootRecyclerView mRecyclerView;
    private StaticData mStaticData;
    private ProjectTitleBarPanel mTitleBarPanel;
    private TextView mTvProjectFollowText;
    private SeeAnimateView mViewProjectFollow;
    private View mViewPurchaseStatusContent;
    RecyclerView.OnScrollListener mOnScrollListener = new RecyclerView.OnScrollListener() { // from class: cn.damai.trade.newtradeorder.ui.projectdetail.projectbookingregister.ui.fragment.ProjectBookingRegisterFragment.1
        private static transient /* synthetic */ IpChange $ipChange;

        @Override // androidx.recyclerview.widget.RecyclerView.OnScrollListener
        public void onScrollStateChanged(RecyclerView recyclerView, int i) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "-1177269067")) {
                ipChange.ipc$dispatch("-1177269067", new Object[]{this, recyclerView, Integer.valueOf(i)});
                return;
            }
            ProjectBookingRegisterFragment.this.mIsScrolled = i != 0;
        }

        @Override // androidx.recyclerview.widget.RecyclerView.OnScrollListener
        public void onScrolled(RecyclerView recyclerView, int i, int i2) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "-678782006")) {
                ipChange.ipc$dispatch("-678782006", new Object[]{this, recyclerView, Integer.valueOf(i), Integer.valueOf(i2)});
                return;
            }
            ProjectBookingRegisterFragment.this.updateTitleStyle();
            if (ProjectBookingRegisterFragment.this.mIsScrolled) {
                ProjectBookingRegisterFragment.this.updateRefreshable();
            }
        }
    };
    OnHeadClickListener headClickListener = new C2259d();
    private int titleBar2DarkHeight = m62.a(mu0.a(), 18.0f);

    /* compiled from: Taobao */
    /* renamed from: cn.damai.trade.newtradeorder.ui.projectdetail.projectbookingregister.ui.fragment.ProjectBookingRegisterFragment$a */
    /* loaded from: classes16.dex */
    public class DialogInterface$OnClickListenerC2256a implements DialogInterface.OnClickListener {
        private static transient /* synthetic */ IpChange $ipChange;

        DialogInterface$OnClickListenerC2256a() {
        }

        @Override // android.content.DialogInterface.OnClickListener
        public void onClick(DialogInterface dialogInterface, int i) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "-689239820")) {
                ipChange.ipc$dispatch("-689239820", new Object[]{this, dialogInterface, Integer.valueOf(i)});
                return;
            }
            C0529c.e().A(pp2.u().i("pdt_dtl", "1"), "selectsuggestmessage", "message");
            Intent intent = new Intent("android.settings.APPLICATION_DETAILS_SETTINGS");
            intent.setData(Uri.parse("package:" + ProjectBookingRegisterFragment.this.mActivity.getPackageName()));
            ProjectBookingRegisterFragment.this.startActivity(intent);
        }
    }

    /* compiled from: Taobao */
    /* renamed from: cn.damai.trade.newtradeorder.ui.projectdetail.projectbookingregister.ui.fragment.ProjectBookingRegisterFragment$b */
    /* loaded from: classes16.dex */
    public class DialogInterface$OnClickListenerC2257b implements DialogInterface.OnClickListener {
        private static transient /* synthetic */ IpChange $ipChange;

        DialogInterface$OnClickListenerC2257b(ProjectBookingRegisterFragment projectBookingRegisterFragment) {
        }

        @Override // android.content.DialogInterface.OnClickListener
        public void onClick(DialogInterface dialogInterface, int i) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "280341203")) {
                ipChange.ipc$dispatch("280341203", new Object[]{this, dialogInterface, Integer.valueOf(i)});
            } else {
                C0529c.e().A(pp2.u().i("pdt_dtl", "0"), "selectsuggestmessage", "message");
            }
        }
    }

    /* compiled from: Taobao */
    /* renamed from: cn.damai.trade.newtradeorder.ui.projectdetail.projectbookingregister.ui.fragment.ProjectBookingRegisterFragment$c */
    /* loaded from: classes8.dex */
    public class C2258c implements AliMeUtil.OnAliMeTokenListener {
        private static transient /* synthetic */ IpChange $ipChange;

        C2258c() {
        }

        @Override // cn.damai.im.AliMeUtil.OnAliMeTokenListener
        public void onFailed(String str, String str2) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "1602204804")) {
                ipChange.ipc$dispatch("1602204804", new Object[]{this, str, str2});
                return;
            }
            ProjectBookingRegisterFragment.this.stopProgressDialog();
            AliMeUtil.p(str, str2);
        }

        @Override // cn.damai.im.AliMeUtil.OnAliMeTokenListener
        public void onSuccess(String str) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "359202180")) {
                ipChange.ipc$dispatch("359202180", new Object[]{this, str});
                return;
            }
            ProjectBookingRegisterFragment.this.stopProgressDialog();
            if (!wh2.j(str)) {
                String f = AliMeUtil.f(AliMeUtil.FROM_PROJECT_DETAIL, str, String.valueOf(ProjectBookingRegisterFragment.this.mProjectId), "");
                if (wh2.j(f)) {
                    return;
                }
                AliMeUtil.b(ProjectBookingRegisterFragment.this.mActivity, f);
                return;
            }
            AliMeUtil.o();
        }
    }

    /* compiled from: Taobao */
    /* renamed from: cn.damai.trade.newtradeorder.ui.projectdetail.projectbookingregister.ui.fragment.ProjectBookingRegisterFragment$d */
    /* loaded from: classes8.dex */
    public class C2259d implements OnHeadClickListener {
        private static transient /* synthetic */ IpChange $ipChange;

        C2259d() {
        }

        @Override // cn.damai.trade.newtradeorder.ui.projectdetail.projectdetailitem.ui.view.projectheader.OnHeadClickListener
        public void onLoadedPosterPic(String str, Bitmap bitmap, boolean z) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "-1285205144")) {
                ipChange.ipc$dispatch("-1285205144", new Object[]{this, str, bitmap, Boolean.valueOf(z)});
            } else {
                ProjectBookingRegisterFragment.this.setProjectDetailMaskLayerImage(str, bitmap);
            }
        }

        @Override // cn.damai.trade.newtradeorder.ui.projectdetail.projectdetailitem.ui.view.projectheader.OnHeadClickListener
        public void onMarketStallClick() {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "566051702")) {
                ipChange.ipc$dispatch("566051702", new Object[]{this});
            }
        }

        @Override // cn.damai.trade.newtradeorder.ui.projectdetail.projectdetailitem.ui.view.projectheader.OnHeadClickListener
        public void onNoticeClick() {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "-594566368")) {
                ipChange.ipc$dispatch("-594566368", new Object[]{this});
            }
        }

        @Override // cn.damai.trade.newtradeorder.ui.projectdetail.projectdetailitem.ui.view.projectheader.OnHeadClickListener
        public void onPosterClick() {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "1853473941")) {
                ipChange.ipc$dispatch("1853473941", new Object[]{this});
                return;
            }
            C0529c.e().x(kv1.h().i(String.valueOf(ProjectBookingRegisterFragment.this.mProjectId), "top", "poster", false));
            ArrayList<PicInfo> arrayList = null;
            if (ProjectBookingRegisterFragment.this.mStaticData == null || ProjectBookingRegisterFragment.this.mStaticData.getItemBase() == null || ProjectBookingRegisterFragment.this.mStaticData.getItemBase().getItemPics() == null || ProjectBookingRegisterFragment.this.mStaticData.getItemBase().getItemPics().getItemPicList() == null || ProjectBookingRegisterFragment.this.mStaticData.getItemBase().getItemPics().getItemPicList().isEmpty()) {
                if (ProjectBookingRegisterFragment.this.mProjectExtraData != null && TextUtils.isEmpty(ProjectBookingRegisterFragment.this.mProjectExtraData.projectImage)) {
                    arrayList = new ArrayList<>();
                    PicInfo picInfo = new PicInfo();
                    picInfo.setPicUrl(ProjectBookingRegisterFragment.this.mProjectExtraData.projectImage);
                    arrayList.add(picInfo);
                }
            } else {
                arrayList = ProjectBookingRegisterFragment.this.mStaticData.getItemBase().getItemPics().getItemPicList();
            }
            if (arrayList == null || arrayList.isEmpty()) {
                return;
            }
            ProjectBookingRegisterFragment.this.startBrowseImageWithTextActivity(arrayList, 0);
        }

        @Override // cn.damai.trade.newtradeorder.ui.projectdetail.projectdetailitem.ui.view.projectheader.OnHeadClickListener
        public void onPromotionTagsClick() {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "-1672516402")) {
                ipChange.ipc$dispatch("-1672516402", new Object[]{this});
            }
        }

        @Override // cn.damai.trade.newtradeorder.ui.projectdetail.projectdetailitem.ui.view.projectheader.OnHeadClickListener
        public void onRankListClick() {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "-1468894606")) {
                ipChange.ipc$dispatch("-1468894606", new Object[]{this});
            }
        }

        @Override // cn.damai.trade.newtradeorder.ui.projectdetail.projectdetailitem.ui.view.projectheader.OnHeadClickListener
        public void onScoreBottomTagClick(ProjectRatingContentLabelBean projectRatingContentLabelBean) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "1335694219")) {
                ipChange.ipc$dispatch("1335694219", new Object[]{this, projectRatingContentLabelBean});
            }
        }

        @Override // cn.damai.trade.newtradeorder.ui.projectdetail.projectdetailitem.ui.view.projectheader.OnHeadClickListener
        public void onScoreCommentClick(String str, String str2, String str3) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "1589995155")) {
                ipChange.ipc$dispatch("1589995155", new Object[]{this, str, str2, str3});
            }
        }

        @Override // cn.damai.trade.newtradeorder.ui.projectdetail.projectdetailitem.ui.view.projectheader.OnHeadClickListener
        public void onScoreHeadTipClick(String str, String str2) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "-1399135419")) {
                ipChange.ipc$dispatch("-1399135419", new Object[]{this, str, str2});
            }
        }

        @Override // cn.damai.trade.newtradeorder.ui.projectdetail.projectdetailitem.ui.view.projectheader.OnHeadClickListener
        public void onSeatIconClick() {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "-57116762")) {
                ipChange.ipc$dispatch("-57116762", new Object[]{this});
            }
        }

        @Override // cn.damai.trade.newtradeorder.ui.projectdetail.projectdetailitem.ui.view.projectheader.OnHeadClickListener
        public void onServiceEtcClick() {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "-114486681")) {
                ipChange.ipc$dispatch("-114486681", new Object[]{this});
            }
        }

        @Override // cn.damai.trade.newtradeorder.ui.projectdetail.projectdetailitem.ui.view.projectheader.OnHeadClickListener
        public void onShowTimeClick() {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "-489139470")) {
                ipChange.ipc$dispatch("-489139470", new Object[]{this});
            }
        }

        @Override // cn.damai.trade.newtradeorder.ui.projectdetail.projectdetailitem.ui.view.projectheader.OnHeadClickListener
        public void onVenueMapIconClick() {
            VenueBean venue;
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "1249808526")) {
                ipChange.ipc$dispatch("1249808526", new Object[]{this});
                return;
            }
            C0529c.e().x(kv1.h().i(String.valueOf(ProjectBookingRegisterFragment.this.mProjectId), ILocatable.ADDRESS, "item", true));
            if (ProjectBookingRegisterFragment.this.mStaticData == null || (venue = ProjectBookingRegisterFragment.this.mStaticData.getVenue()) == null || TextUtils.isEmpty(venue.getVenueName()) || venue.getVenueName().contains(cm2.b(ProjectBookingRegisterFragment.this.mProjectDetailActivity, R$string.damai_projectdetail_tbd))) {
                return;
            }
            Bundle bundle = new Bundle();
            bundle.putString("name", venue.getVenueName());
            bundle.putLong("venueid", wh2.m(venue.getVenueId(), 0L));
            bundle.putLong("projectId", ProjectBookingRegisterFragment.this.mProjectId);
            DMNav.from(ProjectBookingRegisterFragment.this.mProjectDetailActivity).withExtras(bundle).toUri(NavUri.b("venuemap"));
        }

        @Override // cn.damai.trade.newtradeorder.ui.projectdetail.projectdetailitem.ui.view.projectheader.OnHeadClickListener
        public void onVenueNameClick() {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "219232140")) {
                ipChange.ipc$dispatch("219232140", new Object[]{this});
            } else if (ProjectBookingRegisterFragment.this.mStaticData != null) {
                C0529c.e().x(kv1.h().i(String.valueOf(ProjectBookingRegisterFragment.this.mProjectId), "center", "venuenamebtn", true));
                VenueBean venue = ProjectBookingRegisterFragment.this.mStaticData.getVenue();
                if (venue == null || TextUtils.isEmpty(venue.getVenueName()) || venue.getVenueName().contains(cm2.b(ProjectBookingRegisterFragment.this.mProjectDetailActivity, R$string.damai_projectdetail_tbd))) {
                    return;
                }
                Bundle bundle = new Bundle();
                bundle.putString(ILocatable.ADDRESS, venue.getVenueAddr());
                bundle.putString(FeedsViewModel.ARG_USERID, venue.getVenueId());
                bundle.putString("usertype", "3");
                DMNav.from(ProjectBookingRegisterFragment.this.mProjectDetailActivity).withExtras(bundle).toUri(NavUri.b(cs.ARTISTID_THEME));
            }
        }

        @Override // cn.damai.trade.newtradeorder.ui.projectdetail.projectdetailitem.ui.view.projectheader.OnHeadClickListener
        public void onVideoClick(int i) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "1116497078")) {
                ipChange.ipc$dispatch("1116497078", new Object[]{this, Integer.valueOf(i)});
            }
        }

        @Override // cn.damai.trade.newtradeorder.ui.projectdetail.projectdetailitem.ui.view.projectheader.OnHeadClickListener
        public void onWannaSeeActionClick() {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "-1711493670")) {
                ipChange.ipc$dispatch("-1711493670", new Object[]{this});
            }
        }
    }

    /* compiled from: Taobao */
    /* renamed from: cn.damai.trade.newtradeorder.ui.projectdetail.projectbookingregister.ui.fragment.ProjectBookingRegisterFragment$e */
    /* loaded from: classes8.dex */
    public class C2260e implements ProjectTitleBarPanel.OnUiClickListener {
        private static transient /* synthetic */ IpChange $ipChange;

        C2260e() {
        }

        @Override // cn.damai.trade.newtradeorder.ui.projectdetail.projectdetailitem.ui.view.projectheader.ProjectTitleBarPanel.OnUiClickListener
        public void onActivityShareClick() {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "-2144605117")) {
                ipChange.ipc$dispatch("-2144605117", new Object[]{this});
            } else {
                ProjectBookingRegisterFragment.this.shareProjectInfo();
            }
        }

        @Override // cn.damai.trade.newtradeorder.ui.projectdetail.projectdetailitem.ui.view.projectheader.ProjectTitleBarPanel.OnUiClickListener
        public void onBackClick() {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "1465321230")) {
                ipChange.ipc$dispatch("1465321230", new Object[]{this});
            } else if (ProjectBookingRegisterFragment.this.getActivity() == null || ProjectBookingRegisterFragment.this.getActivity().isFinishing()) {
            } else {
                ProjectBookingRegisterFragment.this.getActivity().finish();
            }
        }

        @Override // cn.damai.trade.newtradeorder.ui.projectdetail.projectdetailitem.ui.view.projectheader.ProjectTitleBarPanel.OnUiClickListener
        public void onCertInfoClick() {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "-851584231")) {
                ipChange.ipc$dispatch("-851584231", new Object[]{this});
            }
        }

        @Override // cn.damai.trade.newtradeorder.ui.projectdetail.projectdetailitem.ui.view.projectheader.ProjectTitleBarPanel.OnUiClickListener
        public void onTitleBarClick() {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "-1233382462")) {
                ipChange.ipc$dispatch("-1233382462", new Object[]{this});
                return;
            }
            ProjectBookingRegisterFragment.this.mTitleBarPanel.d(false);
            ProjectBookingRegisterFragment projectBookingRegisterFragment = ProjectBookingRegisterFragment.this;
            projectBookingRegisterFragment.scrollToPosition(1, projectBookingRegisterFragment.getOffset());
            ProjectBookingRegisterFragment.this.updateRefreshable();
        }
    }

    /* compiled from: Taobao */
    /* renamed from: cn.damai.trade.newtradeorder.ui.projectdetail.projectbookingregister.ui.fragment.ProjectBookingRegisterFragment$f */
    /* loaded from: classes8.dex */
    public class C2261f implements PullToRefreshView.OnRefreshListener {
        private static transient /* synthetic */ IpChange $ipChange;

        C2261f() {
        }

        @Override // cn.damai.trade.newtradeorder.ui.projectdetail.ui.view.PullToRefreshView.OnRefreshListener
        public void onRefresh() {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "-124887245")) {
                ipChange.ipc$dispatch("-124887245", new Object[]{this});
            } else if (!ProjectBookingRegisterFragment.this.mIsLoading) {
                ProjectBookingRegisterFragment.this.mProjectBookingRegisterDataManager.i();
                ProjectBookingRegisterFragment.this.getProjectBookingRegisterData(1);
            } else {
                ProjectBookingRegisterFragment.this.mPullToRefreshView.onRefreshComplete();
            }
        }
    }

    /* compiled from: Taobao */
    /* renamed from: cn.damai.trade.newtradeorder.ui.projectdetail.projectbookingregister.ui.fragment.ProjectBookingRegisterFragment$g */
    /* loaded from: classes16.dex */
    public class View$OnClickListenerC2262g implements View.OnClickListener {
        private static transient /* synthetic */ IpChange $ipChange;

        View$OnClickListenerC2262g() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "-2104673427")) {
                ipChange.ipc$dispatch("-2104673427", new Object[]{this, view});
                return;
            }
            C0529c.e().x(kv1.h().i(String.valueOf(ProjectBookingRegisterFragment.this.mProjectId), "bottom", "service", true));
            ProjectBookingRegisterFragment.this.getAliMeTokenAndEnter();
        }
    }

    /* compiled from: Taobao */
    /* renamed from: cn.damai.trade.newtradeorder.ui.projectdetail.projectbookingregister.ui.fragment.ProjectBookingRegisterFragment$h */
    /* loaded from: classes16.dex */
    public class View$OnClickListenerC2263h implements View.OnClickListener {
        private static transient /* synthetic */ IpChange $ipChange;

        View$OnClickListenerC2263h() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "6616942")) {
                ipChange.ipc$dispatch("6616942", new Object[]{this, view});
            } else {
                ProjectBookingRegisterFragment.this.updateProjectFollowRelation();
            }
        }
    }

    /* compiled from: Taobao */
    /* renamed from: cn.damai.trade.newtradeorder.ui.projectdetail.projectbookingregister.ui.fragment.ProjectBookingRegisterFragment$i */
    /* loaded from: classes8.dex */
    public class C2264i implements OnExtendInfoImageItemClickListener {
        private static transient /* synthetic */ IpChange $ipChange;

        C2264i() {
        }

        @Override // cn.damai.trade.newtradeorder.ui.projectdetail.listeners.OnExtendInfoImageItemClickListener
        public yv1 getProjectExtendInfoManager() {
            IpChange ipChange = $ipChange;
            return AndroidInstantRuntime.support(ipChange, "-60840945") ? (yv1) ipChange.ipc$dispatch("-60840945", new Object[]{this}) : ProjectBookingRegisterFragment.this.mProjectBookingRegisterDataManager.e();
        }

        @Override // cn.damai.trade.newtradeorder.ui.projectdetail.listeners.OnExtendInfoImageItemClickListener
        public void onExtendInfoImageItemClick(View view, String str, String str2) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "-1897321591")) {
                ipChange.ipc$dispatch("-1897321591", new Object[]{this, view, str, str2});
            } else {
                ProjectBookingRegisterFragment.this.onExtendInfoItemClick(view, str, str2);
            }
        }

        @Override // cn.damai.trade.newtradeorder.ui.projectdetail.listeners.OnExtendInfoImageItemClickListener
        public void onExtendInfoMoreBtnClick() {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "-781909002")) {
                ipChange.ipc$dispatch("-781909002", new Object[]{this});
            }
        }
    }

    /* compiled from: Taobao */
    /* renamed from: cn.damai.trade.newtradeorder.ui.projectdetail.projectbookingregister.ui.fragment.ProjectBookingRegisterFragment$j */
    /* loaded from: classes8.dex */
    public class C2265j implements DMRGBUtil.OnFetchColorListener {
        private static transient /* synthetic */ IpChange $ipChange;

        C2265j() {
        }

        @Override // cn.damai.commonbusiness.util.DMRGBUtil.OnFetchColorListener
        public void onFetchColor(int i) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "1727042540")) {
                ipChange.ipc$dispatch("1727042540", new Object[]{this, Integer.valueOf(i)});
            } else {
                ProjectBookingRegisterFragment.this.mIvProjectPosterMask.setBackgroundColor(i);
            }
        }
    }

    /* compiled from: Taobao */
    /* renamed from: cn.damai.trade.newtradeorder.ui.projectdetail.projectbookingregister.ui.fragment.ProjectBookingRegisterFragment$k */
    /* loaded from: classes8.dex */
    public class C2266k implements BuyButtonStatusHelper.OnBuyBtnClickListener {
        private static transient /* synthetic */ IpChange $ipChange;

        C2266k() {
        }

        @Override // cn.damai.trade.newtradeorder.ui.projectdetail.projectbookingregister.ui.view.BuyButtonStatusHelper.OnBuyBtnClickListener
        public void onRemindBookingRegister() {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "-303774574")) {
                ipChange.ipc$dispatch("-303774574", new Object[]{this});
                return;
            }
            C0529c.e().x(kv1.h().i(String.valueOf(ProjectBookingRegisterFragment.this.mProjectId), "bottom", "book_checkin", false));
            ProjectBookingRegisterFragment.this.executeBookingRegisterReq();
        }
    }

    private void displayErrorPage(String str, String str2, String str3) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-2132752364")) {
            ipChange.ipc$dispatch("-2132752364", new Object[]{this, str, str2, str3});
            return;
        }
        this.mFlPurchaseStatusBarContainer.setVisibility(8);
        this.mLvBottomBar.setVisibility(8);
        this.mFlProjectContentContainer.setVisibility(0);
        this.mTitleBarPanel.l(false);
        onResponseError(str2, str, str3, this.mFlProjectContentContainer, true);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void executeBookingRegisterReq() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1849191976")) {
            ipChange.ipc$dispatch("1849191976", new Object[]{this});
        } else if (isLogin()) {
            startProgressDialog();
            ((ProjectBookingRegisterPresenter) this.mPresenter).bookingRegisterProject(1, this.mProjectId, 11);
        } else {
            startLoginActivityForResult(4116);
        }
    }

    private void executeProjectFollowRequest(int i) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1812536254")) {
            ipChange.ipc$dispatch("1812536254", new Object[]{this, Integer.valueOf(i)});
        } else {
            ((ProjectBookingRegisterPresenter) this.mPresenter).updateProjectFollowRelation(i, this.mProjectId, 12);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void getAliMeTokenAndEnter() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-332835995")) {
            ipChange.ipc$dispatch("-332835995", new Object[]{this});
            return;
        }
        String E = z20.E();
        if (isLogin() && !TextUtils.isEmpty(E)) {
            int k = wh2.k(E);
            startProgressDialog();
            AliMeUtil.d(k, AliMeUtil.FROM_PROJECT_DETAIL, new C2258c());
            return;
        }
        startLoginActivityForResult(CaptureActivity.LOCK_SUCCESS);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public int getOffset() {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "862874249") ? ((Integer) ipChange.ipc$dispatch("862874249", new Object[]{this})).intValue() : this.mTitleBarPanel.e();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void getProjectBookingRegisterData(int i) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1787482201")) {
            ipChange.ipc$dispatch("-1787482201", new Object[]{this, Integer.valueOf(i)});
        } else if (this.mIsLoading) {
        } else {
            this.mIsLoading = true;
            this.mProjectBookingRegisterDataManager.i();
            ((ProjectBookingRegisterPresenter) this.mPresenter).retrieveProjectBookingRegisterData(i, String.valueOf(this.mProjectId));
        }
    }

    private boolean getProjectFollowStatus() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1413632297")) {
            return ((Boolean) ipChange.ipc$dispatch("1413632297", new Object[]{this})).booleanValue();
        }
        DynamicExtData dynamicExtData = this.mDynamicExtData;
        if (dynamicExtData != null) {
            return "true".equals(dynamicExtData.getSubFlag());
        }
        return false;
    }

    private String getProjectPosterUrl() {
        PicInfo picInfo;
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1565710336")) {
            return (String) ipChange.ipc$dispatch("-1565710336", new Object[]{this});
        }
        StaticData staticData = this.mStaticData;
        return (staticData == null || staticData.getItemBase() == null || this.mStaticData.getItemBase().getItemPics() == null || this.mStaticData.getItemBase().getItemPics().getItemPicList() == null || this.mStaticData.getItemBase().getItemPics().getItemPicList().isEmpty() || (picInfo = this.mStaticData.getItemBase().getItemPics().getItemPicList().get(0)) == null) ? "" : picInfo.getPicUrl();
    }

    private void initBottomViews() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-617067892")) {
            ipChange.ipc$dispatch("-617067892", new Object[]{this});
            return;
        }
        this.mLvBottomBar = this.rootView.findViewById(R$id.project_booking_register_bottom_bar_lv);
        this.mLvCustomerService = (FrameLayout) this.rootView.findViewById(R$id.project_item_bottom_customer_service_lv);
        SeeAnimateView seeAnimateView = (SeeAnimateView) this.rootView.findViewById(R$id.project_bottom_want_to_see_view);
        this.mViewProjectFollow = seeAnimateView;
        seeAnimateView.setCancelImage();
        this.mTvProjectFollowText = (TextView) this.rootView.findViewById(R$id.project_item_bottom_follow_text_tv);
        this.mFlPurchaseStatusBarContainer = (FrameLayout) this.rootView.findViewById(R$id.trade_project_detail_purchase_status_bar_container_fl);
    }

    private void initBuyBtnListeners() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "865487334")) {
            ipChange.ipc$dispatch("865487334", new Object[]{this});
        } else {
            this.mBuyButtonStatusHelper.h(new C2266k());
        }
    }

    private void initExtraData() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-981843755")) {
            ipChange.ipc$dispatch("-981843755", new Object[]{this});
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
                    this.mProjectDetailActivity = (ProjectDetailActivity) getActivity();
                    return;
                }
            }
            getActivity().finish();
            return;
        }
        getActivity().finish();
    }

    private void initHeadBarView() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-2045359593")) {
            ipChange.ipc$dispatch("-2045359593", new Object[]{this});
            return;
        }
        ProjectTitleBarPanel projectTitleBarPanel = new ProjectTitleBarPanel(getActivity(), this.rootView.findViewById(R$id.project_book_title), new C2260e());
        this.mTitleBarPanel = projectTitleBarPanel;
        projectTitleBarPanel.k("商品详情");
    }

    private void initHeadViews() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-939266111")) {
            ipChange.ipc$dispatch("-939266111", new Object[]{this});
            return;
        }
        this.mIvProjectPosterMask = (ImageView) this.rootView.findViewById(R$id.project_poster_mask_iv);
        initHeadBarView();
        initProjectInfoView();
    }

    private void initListeners() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-902264752")) {
            ipChange.ipc$dispatch("-902264752", new Object[]{this});
            return;
        }
        this.mOnRefreshListener = new C2261f();
        this.mOnCustomerServiceClickListener = new View$OnClickListenerC2262g();
        this.mOnProjectFollowClickListener = new View$OnClickListenerC2263h();
        this.mOnExtendInfoImageItemClickListener = new C2264i();
    }

    private void initProjectDataHolderManager() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-548213443")) {
            ipChange.ipc$dispatch("-548213443", new Object[]{this});
        } else {
            this.mProjectBookingRegisterDataManager = new jv1(this.mProjectDetailActivity);
        }
    }

    private void initProjectInfoView() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1780788925")) {
            ipChange.ipc$dispatch("-1780788925", new Object[]{this});
            return;
        }
        LinearLayout linearLayout = (LinearLayout) LayoutInflater.from(this.mProjectDetailActivity).inflate(R$layout.project_book_header_wrap, (ViewGroup) this.mRecyclerView.getHeaderContainer(), false);
        this.mLvProjectDetailHeader = linearLayout;
        this.mHeadPanel = new iv1(this.mProjectDetailActivity, this.mProjectId, linearLayout.findViewById(R$id.project_book_header), this.headClickListener);
        this.mRecyclerView.addHeaderView(this.mLvProjectDetailHeader);
    }

    private void initViews() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "2001824449")) {
            ipChange.ipc$dispatch("2001824449", new Object[]{this});
            return;
        }
        this.mPullToRefreshView = (PullToRefreshView) this.rootView.findViewById(R$id.project_booking_register_pull_to_refresh_view);
        this.mRecyclerView = (DamaiRootRecyclerView) this.rootView.findViewById(R$id.project_booking_register_recycler_view);
        this.mProjectBookingRegisterAdapter = new ProjectBookingRegisterAdapter(this.mProjectDetailActivity, this.mProjectId);
        WrapLinearLayoutManager wrapLinearLayoutManager = new WrapLinearLayoutManager(this.mProjectDetailActivity);
        this.mLinearLayoutManager = wrapLinearLayoutManager;
        this.mRecyclerView.setLayoutManager(wrapLinearLayoutManager);
        this.mRecyclerView.setAdapter(this.mProjectBookingRegisterAdapter);
        this.mRecyclerView.setRefreshEnabled(false);
        this.mRecyclerView.setIsAutoToDefault(false);
        this.mRecyclerView.setLoadMoreEnabled(false);
        this.mRecyclerView.getLoadMoreFooterView().setVisibility(8);
        this.mRecyclerView.addOnScrollListener(this.mOnScrollListener);
        initHeadViews();
        initBottomViews();
        FrameLayout frameLayout = (FrameLayout) this.rootView.findViewById(R$id.project_booking_register_error_page_container);
        this.mFlProjectContentContainer = frameLayout;
        frameLayout.setVisibility(8);
    }

    private boolean isLogin() {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "1089366148") ? ((Boolean) ipChange.ipc$dispatch("1089366148", new Object[]{this})).booleanValue() : LoginManager.k().q();
    }

    private boolean isShowErrorPage() {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "-1707831277") ? ((Boolean) ipChange.ipc$dispatch("-1707831277", new Object[]{this})).booleanValue() : this.mStaticData == null && this.mDynamicExtData == null && this.mItemData == null;
    }

    public static ProjectBookingRegisterFragment newInstance(ProjectIntentExtraParser.ProjectDetailExtrasData projectDetailExtrasData) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1627451797")) {
            return (ProjectBookingRegisterFragment) ipChange.ipc$dispatch("1627451797", new Object[]{projectDetailExtrasData});
        }
        ProjectBookingRegisterFragment projectBookingRegisterFragment = new ProjectBookingRegisterFragment();
        if (projectDetailExtrasData != null) {
            Bundle bundle = new Bundle();
            bundle.putParcelable("projectExtraData", projectDetailExtrasData);
            projectBookingRegisterFragment.setArguments(bundle);
        }
        return projectBookingRegisterFragment;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void scrollToPosition(int i, int i2) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1830964666")) {
            ipChange.ipc$dispatch("1830964666", new Object[]{this, Integer.valueOf(i), Integer.valueOf(i2)});
            return;
        }
        this.mRecyclerView.dispatchTouchEvent(MotionEvent.obtain(SystemClock.uptimeMillis(), SystemClock.uptimeMillis(), 3, 0.0f, 0.0f, 0));
        this.mLinearLayoutManager.scrollToPositionWithOffset(i, i2);
    }

    private void setExtraData() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "573392723")) {
            ipChange.ipc$dispatch("573392723", new Object[]{this});
            return;
        }
        ProjectIntentExtraParser.ProjectDetailExtrasData projectDetailExtrasData = this.mProjectExtraData;
        if (projectDetailExtrasData != null) {
            String str = projectDetailExtrasData.projectImage;
            String str2 = projectDetailExtrasData.projectName;
            iv1 iv1Var = this.mHeadPanel;
            if (iv1Var != null) {
                iv1Var.e(str, str2);
            }
        }
        this.mProjectBookingRegisterAdapter.a(this.mProjectBookingRegisterDataManager.c());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setProjectDetailMaskLayerImage(String str, Bitmap bitmap) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "808741911")) {
            ipChange.ipc$dispatch("808741911", new Object[]{this, str, bitmap});
            return;
        }
        try {
            DMRGBUtil.g(1.0f, bitmap, str, new C2265j());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void setProjectFollowStatus(boolean z) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1245211587")) {
            ipChange.ipc$dispatch("1245211587", new Object[]{this, Boolean.valueOf(z)});
            return;
        }
        DynamicExtData dynamicExtData = this.mDynamicExtData;
        if (dynamicExtData != null) {
            dynamicExtData.setSubFlag(z ? "true" : "false");
        }
    }

    private void setupListeners() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "684685033")) {
            ipChange.ipc$dispatch("684685033", new Object[]{this});
            return;
        }
        this.mPullToRefreshView.setOnRefreshListener(this.mOnRefreshListener);
        this.mLvCustomerService.setOnClickListener(this.mOnCustomerServiceClickListener);
        this.mViewProjectFollow.setOnClickListener(this.mOnProjectFollowClickListener);
        this.mProjectBookingRegisterAdapter.c(this.mOnExtendInfoImageItemClickListener);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void shareProjectInfo() {
        String str;
        String str2;
        StaticData.ItemBase itemBase;
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "914567651")) {
            ipChange.ipc$dispatch("914567651", new Object[]{this});
        } else if (this.mStaticData == null) {
        } else {
            C0529c.e().x(kv1.h().i(String.valueOf(this.mProjectId), "top", "share", false));
            String projectPosterUrl = getProjectPosterUrl();
            StaticData staticData = this.mStaticData;
            if (staticData == null || (itemBase = staticData.getItemBase()) == null) {
                str = "";
                str2 = str;
            } else {
                String itemName = itemBase.getItemName();
                str2 = itemBase.getCityName();
                str = itemName;
            }
            Bundle a = wv1.a(this.mProjectId, "https://m.damai.cn/damai/project/item.html?id=", str, "", str2, "", projectPosterUrl, "", "", "projectBooking", "chat_h5", false);
            if (a != null) {
                ShareManager.E().T(this.mProjectDetailActivity, a, LayoutInflater.from(getContext()).inflate(R$layout.project_booking_register_fragment_layout, (ViewGroup) null));
                ShareManager E = ShareManager.E();
                ShareManager E2 = ShareManager.E();
                Context context = getContext();
                E.e0(E2.F(context, 1, this.mProjectId + "", 1));
                ShareManager.E().l0();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void startBrowseImageWithTextActivity(ArrayList<PicInfo> arrayList, int i) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-818123309")) {
            ipChange.ipc$dispatch("-818123309", new Object[]{this, arrayList, Integer.valueOf(i)});
            return;
        }
        Bundle bundle = new Bundle();
        bundle.putParcelableArrayList("pic_info", arrayList);
        bundle.putInt("position", i);
        DMNav.from(this.mProjectDetailActivity).withExtras(bundle).toUri(cs.e());
    }

    private void startLoginActivityForResult(int i) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "930587956")) {
            ipChange.ipc$dispatch("930587956", new Object[]{this, Integer.valueOf(i)});
        } else {
            DMNav.from(this.mProjectDetailActivity).forResult(i).toUri(cs.f());
        }
    }

    private void updateItemData() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-453543067")) {
            ipChange.ipc$dispatch("-453543067", new Object[]{this});
            return;
        }
        ItemData itemData = this.mItemData;
        if (itemData != null) {
            if (this.mBuyButtonStatusHelper == null) {
                BuyButtonStatusHelper buyButtonStatusHelper = new BuyButtonStatusHelper(this.mProjectDetailActivity, itemData, this.mProjectId, this.mFlPurchaseStatusBarContainer);
                this.mBuyButtonStatusHelper = buyButtonStatusHelper;
                View d = buyButtonStatusHelper.d();
                this.mViewPurchaseStatusContent = d;
                this.mFlPurchaseStatusBarContainer.addView(d);
                initBuyBtnListeners();
                this.mFlPurchaseStatusBarContainer.setVisibility(0);
                return;
            }
            this.mFlPurchaseStatusBarContainer.setVisibility(0);
            this.mBuyButtonStatusHelper.i(this.mItemData);
        }
    }

    private void updateProjectDataHolders() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1019387202")) {
            ipChange.ipc$dispatch("-1019387202", new Object[]{this});
            return;
        }
        List<ProjectDataHolder> d = this.mProjectBookingRegisterDataManager.d(this.mStaticData);
        if (wh2.e(d) > 0) {
            this.mProjectBookingRegisterAdapter.b(d);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void updateProjectFollowRelation() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1505009698")) {
            ipChange.ipc$dispatch("1505009698", new Object[]{this});
        } else if (isLogin()) {
            if (getProjectFollowStatus()) {
                C0529c.e().x(kv1.h().g(String.valueOf(this.mProjectId), "top", "favorite", "0"));
                executeProjectFollowRequest(0);
                return;
            }
            executeProjectFollowRequest(1);
            C0529c.e().x(kv1.h().g(String.valueOf(this.mProjectId), "top", "favorite", "1"));
        } else {
            startLoginActivityForResult(4097);
            C0529c.e().x(kv1.h().g(String.valueOf(this.mProjectId), "top", "favorite", "0"));
        }
    }

    private void updateProjectFollowStatus(FollowDataBean followDataBean) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1687063825")) {
            ipChange.ipc$dispatch("-1687063825", new Object[]{this, followDataBean});
        } else if (followDataBean.getStatus() >= 1) {
            ToastUtil.a().j(this.mProjectDetailActivity, "已添加想看");
            setProjectFollowStatus(true);
            this.mViewProjectFollow.clickAnimate();
            this.mTvProjectFollowText.setText(R$string.i_want_to_see);
        } else {
            setProjectFollowStatus(false);
            this.mViewProjectFollow.cancelAnimate();
            this.mTvProjectFollowText.setText(R$string.want_to_see);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void updateRefreshable() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1970427667")) {
            ipChange.ipc$dispatch("1970427667", new Object[]{this});
            return;
        }
        int findFirstVisibleItemPosition = this.mLinearLayoutManager.findFirstVisibleItemPosition();
        if (findFirstVisibleItemPosition <= 1) {
            View findViewByPosition = this.mLinearLayoutManager.findViewByPosition(findFirstVisibleItemPosition);
            if ((findViewByPosition == null ? 0 : Math.abs(findViewByPosition.getTop())) == 0) {
                this.mPullToRefreshView.setPullToRefreshEnabled(true);
                return;
            } else {
                this.mPullToRefreshView.setPullToRefreshEnabled(false);
                return;
            }
        }
        this.mPullToRefreshView.setPullToRefreshEnabled(false);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void updateTitleStyle() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-797871671")) {
            ipChange.ipc$dispatch("-797871671", new Object[]{this});
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

    private void updateWantToSeeStatus() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1169393774")) {
            ipChange.ipc$dispatch("1169393774", new Object[]{this});
            return;
        }
        DynamicExtData dynamicExtData = this.mDynamicExtData;
        if (dynamicExtData != null) {
            if ("true".equals(dynamicExtData.getSubFlag())) {
                this.mViewProjectFollow.setFollowImage();
                this.mTvProjectFollowText.setText(R$string.i_want_to_see);
                return;
            }
            this.mViewProjectFollow.setCancelImage();
            this.mTvProjectFollowText.setText(R$string.want_to_see);
        }
    }

    @Override // cn.damai.common.app.base.BaseFragment
    protected int getLayoutResource() {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "1210757028") ? ((Integer) ipChange.ipc$dispatch("1210757028", new Object[]{this})).intValue() : R$layout.project_booking_register_fragment_layout;
    }

    @Override // cn.damai.commonbusiness.base.ResponseErrorPage.ErrorRefreshListener
    public void handleError(int i) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "967624548")) {
            ipChange.ipc$dispatch("967624548", new Object[]{this, Integer.valueOf(i)});
        } else {
            getProjectBookingRegisterData(1);
        }
    }

    @Override // cn.damai.common.app.base.BaseFragment
    public void initPresenter() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1302451015")) {
            ipChange.ipc$dispatch("1302451015", new Object[]{this});
        } else {
            ((ProjectBookingRegisterPresenter) this.mPresenter).setVM(this, (ProjectBookingRegisterContract.Model) this.mModel);
        }
    }

    @Override // cn.damai.common.app.base.BaseFragment
    protected void initView() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1727070966")) {
            ipChange.ipc$dispatch("1727070966", new Object[]{this});
            return;
        }
        initExtraData();
        initProjectDataHolderManager();
        initViews();
        initListeners();
        setupListeners();
        setExtraData();
        getProjectBookingRegisterData(0);
    }

    @Override // androidx.fragment.app.Fragment
    public void onActivityCreated(@Nullable Bundle bundle) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1728221999")) {
            ipChange.ipc$dispatch("1728221999", new Object[]{this, bundle});
            return;
        }
        super.onActivityCreated(bundle);
        setDamaiUTKeyBuilder(pp2.u().i0(this.mProjectId));
    }

    @Override // androidx.fragment.app.Fragment
    public void onActivityResult(int i, int i2, Intent intent) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1032364707")) {
            ipChange.ipc$dispatch("-1032364707", new Object[]{this, Integer.valueOf(i), Integer.valueOf(i2), intent});
            return;
        }
        super.onActivityResult(i, i2, intent);
        ShareManager.E().r0(i, i2, intent);
        if (i == 2000 && i2 == 1000) {
            this.mProjectDetailActivity.finish();
        } else if (i == 4097 && i2 == -1) {
            updateProjectFollowRelation();
        } else if (i == 4115 && i2 == -1) {
            getAliMeTokenAndEnter();
        } else if (i == 4116 && i2 == -1) {
            executeBookingRegisterReq();
        }
    }

    @Override // cn.damai.trade.newtradeorder.ui.projectdetail.projectbookingregister.contract.ProjectBookingRegisterContract.View
    public void onBookingRegisterError(String str, String str2) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1295815636")) {
            ipChange.ipc$dispatch("1295815636", new Object[]{this, str, str2});
            return;
        }
        stopProgressDialog();
        ToastUtil.a().j(this.mProjectDetailActivity, str2);
    }

    @Override // cn.damai.trade.newtradeorder.ui.projectdetail.projectbookingregister.contract.ProjectBookingRegisterContract.View
    public void onBookingRegisterSuccess(FollowDataBean followDataBean) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "109143528")) {
            ipChange.ipc$dispatch("109143528", new Object[]{this, followDataBean});
            return;
        }
        stopProgressDialog();
        if (followDataBean.getStatus() != 1) {
            ToastUtil.a().e(this.mProjectDetailActivity, getString(R$string.booking_register_failure));
        } else if (PermissionsHelper.a(this.mProjectDetailActivity)) {
            DMDialog dMDialog = new DMDialog(getActivity());
            dMDialog.v("提交成功");
            dMDialog.q("开售前，将通过APP通知");
            dMDialog.n("知道了", null);
            dMDialog.show();
        } else {
            ProjectDetailActivity projectDetailActivity = this.mProjectDetailActivity;
            if (projectDetailActivity == null || projectDetailActivity.isFinishing()) {
                return;
            }
            PermissionsHelper.c(this.mProjectDetailActivity, "未开启推送通知", false, "「设置」-「状态栏与通知」-「通知管理」", "立即开启", new DialogInterface$OnClickListenerC2256a(), "取消", new DialogInterface$OnClickListenerC2257b(this));
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "37329756")) {
            ipChange.ipc$dispatch("37329756", new Object[]{this, view});
        }
    }

    @Override // androidx.fragment.app.Fragment
    public void onCreate(@Nullable Bundle bundle) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "2079980932")) {
            ipChange.ipc$dispatch("2079980932", new Object[]{this, bundle});
            return;
        }
        super.onCreate(bundle);
        this.mIsFirstEnter = true;
    }

    public void onExtendInfoItemClick(View view, String str, String str2) {
        LinkedHashMap<String, Integer> g;
        IpChange ipChange = $ipChange;
        int i = 0;
        if (AndroidInstantRuntime.support(ipChange, "-711096171")) {
            ipChange.ipc$dispatch("-711096171", new Object[]{this, view, str, str2});
        } else if (!TextUtils.isEmpty(str2) && (g = this.mProjectBookingRegisterDataManager.e().g()) != null) {
            try {
                Integer num = g.get(str2);
                if (num != null) {
                    i = num.intValue();
                }
            } catch (Exception unused) {
            }
            if (!TextUtils.isEmpty(str)) {
                DMNav.from(this.mActivity).toUri(str);
                C0529c.e().x(pp2.u().x0(this.mProjectId, i));
                return;
            }
            ArrayList<PicInfo> arrayList = new ArrayList<>();
            for (Map.Entry<String, Integer> entry : g.entrySet()) {
                String key = entry.getKey();
                if (!TextUtils.isEmpty(key)) {
                    PicInfo picInfo = new PicInfo();
                    picInfo.setPicUrl(key);
                    arrayList.add(picInfo);
                }
            }
            C0529c.e().x(pp2.u().x0(this.mProjectId, i));
            startBrowseImageWithTextActivity(arrayList, i);
        }
    }

    @Override // cn.damai.commonbusiness.base.BaseDamaiView
    public void onNetError(String str, String str2, String str3) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-649718049")) {
            ipChange.ipc$dispatch("-649718049", new Object[]{this, str, str2, str3});
        }
    }

    @Override // cn.damai.commonbusiness.base.BaseDamaiView
    public void onNetSuccess() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1686197990")) {
            ipChange.ipc$dispatch("1686197990", new Object[]{this});
        }
    }

    @Override // cn.damai.trade.newtradeorder.ui.projectdetail.projectbookingregister.contract.ProjectBookingRegisterContract.View
    public void onProjectFollowError(String str, String str2) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "2140224162")) {
            ipChange.ipc$dispatch("2140224162", new Object[]{this, str, str2});
            return;
        }
        stopProgressDialog();
        ToastUtil.a().j(this.mProjectDetailActivity, str2);
    }

    @Override // cn.damai.trade.newtradeorder.ui.projectdetail.projectbookingregister.contract.ProjectBookingRegisterContract.View
    public void onProjectFollowSuccess(FollowDataBean followDataBean) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-967625418")) {
            ipChange.ipc$dispatch("-967625418", new Object[]{this, followDataBean});
            return;
        }
        stopProgressDialog();
        if (followDataBean != null) {
            updateProjectFollowStatus(followDataBean);
        }
    }

    @Override // cn.damai.commonbusiness.base.DamaiBaseMvpFragment, androidx.fragment.app.Fragment
    public void onResume() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1897069441")) {
            ipChange.ipc$dispatch("-1897069441", new Object[]{this});
            return;
        }
        super.onResume();
        if (!this.mIsFirstEnter) {
            getProjectBookingRegisterData(2);
        } else {
            this.mIsFirstEnter = true;
        }
    }

    @Override // cn.damai.trade.newtradeorder.ui.projectdetail.projectbookingregister.contract.ProjectBookingRegisterContract.View
    public void onReturnBookingRegisterDataError(String str, String str2, String str3) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1607739608")) {
            ipChange.ipc$dispatch("1607739608", new Object[]{this, str, str2, str3});
            return;
        }
        this.mPullToRefreshView.onRefreshComplete();
        this.mIsLoading = false;
        if (isShowErrorPage()) {
            displayErrorPage(str, str2, str3);
        } else {
            ToastUtil.a().j(this.mProjectDetailActivity, str2);
        }
    }

    @Override // cn.damai.trade.newtradeorder.ui.projectdetail.projectbookingregister.contract.ProjectBookingRegisterContract.View
    public void onReturnBookingRegisterDataSuccess(int i, ProjectBookingRegisterData projectBookingRegisterData) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1950976386")) {
            ipChange.ipc$dispatch("-1950976386", new Object[]{this, Integer.valueOf(i), projectBookingRegisterData});
            return;
        }
        this.mPullToRefreshView.onRefreshComplete();
        this.mIsLoading = false;
        if (projectBookingRegisterData == null) {
            return;
        }
        updateRefreshable();
        if (i == 1 || i == 0) {
            this.mTitleBarPanel.l(true);
        }
        this.mFlProjectContentContainer.setVisibility(8);
        this.mLvBottomBar.setVisibility(0);
        StaticData staticData = projectBookingRegisterData.getStaticData();
        this.mStaticData = staticData;
        this.mHeadPanel.d(staticData);
        updateProjectDataHolders();
        if (this.mStaticData != null) {
            this.mTitleBarPanel.m("");
        }
        this.mDynamicExtData = projectBookingRegisterData.getDynamicExtData();
        updateWantToSeeStatus();
        this.mItemData = projectBookingRegisterData.getItem();
        updateItemData();
    }

    @Override // cn.damai.commonbusiness.base.DamaiBaseMvpFragment, androidx.fragment.app.Fragment
    public void onStop() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1248485962")) {
            ipChange.ipc$dispatch("1248485962", new Object[]{this});
        } else {
            super.onStop();
        }
    }

    @Override // cn.damai.common.app.base.BaseView
    public void showEmptyView() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "75328138")) {
            ipChange.ipc$dispatch("75328138", new Object[]{this});
        }
    }

    @Override // cn.damai.common.app.base.BaseView
    public void showErrorTips(String str) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1051312838")) {
            ipChange.ipc$dispatch("1051312838", new Object[]{this, str});
        }
    }

    @Override // cn.damai.common.app.base.BaseView
    public void showLoading(String str) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1548277290")) {
            ipChange.ipc$dispatch("1548277290", new Object[]{this, str});
        }
    }

    @Override // cn.damai.common.app.base.BaseView
    public void stopLoading() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-2114228443")) {
            ipChange.ipc$dispatch("-2114228443", new Object[]{this});
        }
    }
}
