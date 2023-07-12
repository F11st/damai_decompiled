package cn.damai.category.ranking.ui;

import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.Color;
import android.os.Build;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.text.TextUtils;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.annotation.IdRes;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import cn.damai.category.category.request.FollowRequest;
import cn.damai.category.discountticket.ui.OnErrorClickListener;
import cn.damai.category.ranking.bean.RankListHeader;
import cn.damai.common.image.C0504a;
import cn.damai.common.image.DMImageCreator;
import cn.damai.common.nav.DMNav;
import cn.damai.common.nav.NavUri;
import cn.damai.common.net.mtop.netfit.DMMtopRequestListener;
import cn.damai.common.user.C0525a;
import cn.damai.common.user.C0528b;
import cn.damai.common.user.C0529c;
import cn.damai.commonbusiness.base.DamaiBaseActivity;
import cn.damai.commonbusiness.search.bean.FollowDataBean;
import cn.damai.commonbusiness.share.ShareManager;
import cn.damai.commonbusiness.share.generateimage.GenerateImageUtil;
import cn.damai.homepage.R$color;
import cn.damai.homepage.R$drawable;
import cn.damai.homepage.R$id;
import cn.damai.homepage.R$layout;
import cn.damai.rank.view.WantSeeTips;
import cn.damai.tetris.DMMtopWarningListener;
import cn.damai.tetris.component.rank.RankListItemHolder;
import cn.damai.tetris.component.rank.bean.RankItemBean;
import cn.damai.tetris.core.BaseLayer;
import cn.damai.tetris.core.BaseSection;
import cn.damai.tetris.core.mtop.BaseResponse;
import cn.damai.tetris.core.mtop.GlobalConfig;
import cn.damai.tetris.page.AbsFragment;
import cn.damai.tetris.page.AbsFragmentV2;
import cn.damai.tetris.request.TetrisRequest;
import cn.damai.uikit.pulltorefresh.ptrheader.PtrUiHeader;
import cn.damai.wantsee.GuideUtProvider;
import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import com.google.android.material.appbar.AppBarLayout;
import in.srain.cube.views.ptr.PtrClassicDefaultHeader;
import in.srain.cube.views.ptr.PtrFrameLayout;
import in.srain.cube.views.ptr.PtrHandler;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import tb.C9548pb;
import tb.g03;
import tb.j11;
import tb.kg2;
import tb.m62;
import tb.rx1;
import tb.xj0;
import tb.z20;

/* compiled from: Taobao */
/* loaded from: classes.dex */
public class RankListFragment extends AbsFragmentV2 {
    private static transient /* synthetic */ IpChange $ipChange = null;
    public static final String KEY_RANK_ID = "rankId";
    private RankListActivity baseActivity;
    DMMtopRequestListener<BaseResponse> dmlistener;
    private int followStatus;
    private long lastClickTime;
    private AppBarLayout mAppBar;
    private TextView mBackBtn;
    private ImageView mBgImg;
    private String mCityId;
    private View mCollectTipIcon;
    private TextView mDescTv;
    private View mEmptyFoot;
    private View mHeader;
    private String mId;
    private ViewGroup mMainView;
    private TextView mMoreRank;
    private PtrFrameLayout mPtr;
    private String mShareBitmapUrl;
    private TextView mShareBtn;
    private String mShareImageUrl;
    private String mShareUrl;
    private View mStatusBarSpace;
    private CountDownTimer mTimeCountDown;
    private View mTitleBgLayout;
    private TextView mTitleTv;
    private TextView mTopTitleTv;
    private TextView mWannaSee;
    ViewGroup rootView;
    private WantSeeTips wantSeeTips;
    String spmB = "ranklist";
    RankListHeader headerBean = null;

    /* compiled from: Taobao */
    /* renamed from: cn.damai.category.ranking.ui.RankListFragment$a */
    /* loaded from: classes.dex */
    public class C0422a implements DMImageCreator.DMImageSuccListener {
        private static transient /* synthetic */ IpChange $ipChange;

        C0422a() {
        }

        @Override // cn.damai.common.image.DMImageCreator.DMImageSuccListener
        public void onSuccess(DMImageCreator.C0502e c0502e) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "1124723081")) {
                ipChange.ipc$dispatch("1124723081", new Object[]{this, c0502e});
            } else if (c0502e == null || c0502e.b == null) {
            } else {
                try {
                    RankListFragment rankListFragment = RankListFragment.this;
                    rankListFragment.mShareBitmapUrl = j11.d(rankListFragment.mShareImageUrl, c0502e.b, RankListFragment.this.baseActivity);
                } catch (Exception unused) {
                }
            }
        }
    }

    /* compiled from: Taobao */
    /* renamed from: cn.damai.category.ranking.ui.RankListFragment$b */
    /* loaded from: classes.dex */
    public class C0423b implements GuideUtProvider {
        private static transient /* synthetic */ IpChange $ipChange;
        final /* synthetic */ RankItemBean a;

        C0423b(RankItemBean rankItemBean) {
            this.a = rankItemBean;
        }

        @Override // cn.damai.wantsee.GuideUtProvider
        @NonNull
        public Map<String, String> getGuideCloseBtnArgMap() {
            IpChange ipChange = $ipChange;
            return AndroidInstantRuntime.support(ipChange, "-703816616") ? (Map) ipChange.ipc$dispatch("-703816616", new Object[]{this}) : getGuideExposeArgMap();
        }

        @Override // cn.damai.wantsee.GuideUtProvider
        @NonNull
        public Map<String, String> getGuideExposeArgMap() {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "-475558952")) {
                return (Map) ipChange.ipc$dispatch("-475558952", new Object[]{this});
            }
            HashMap hashMap = new HashMap();
            if (this.a != null) {
                hashMap.put("item_id", this.a.id + "");
                hashMap.put("titlelabel", this.a.rankName);
                hashMap.put(C9548pb.CNT_CONTENT_ID, this.a.rankId);
            }
            return hashMap;
        }

        @Override // cn.damai.wantsee.GuideUtProvider
        @NonNull
        public Map<String, String> getGuideGoMineBtnArgMap() {
            IpChange ipChange = $ipChange;
            return AndroidInstantRuntime.support(ipChange, "1511209355") ? (Map) ipChange.ipc$dispatch("1511209355", new Object[]{this}) : getGuideExposeArgMap();
        }

        @Override // cn.damai.wantsee.GuideUtProvider
        @NonNull
        public String getSpmB() {
            IpChange ipChange = $ipChange;
            return AndroidInstantRuntime.support(ipChange, "297623985") ? (String) ipChange.ipc$dispatch("297623985", new Object[]{this}) : RankListFragment.this.spmB;
        }
    }

    /* compiled from: Taobao */
    /* renamed from: cn.damai.category.ranking.ui.RankListFragment$c */
    /* loaded from: classes.dex */
    public class CountDownTimerC0424c extends CountDownTimer {
        private static transient /* synthetic */ IpChange $ipChange;

        CountDownTimerC0424c(long j, long j2) {
            super(j, j2);
        }

        @Override // android.os.CountDownTimer
        public void onFinish() {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "757641795")) {
                ipChange.ipc$dispatch("757641795", new Object[]{this});
            } else {
                RankListFragment.this.mCollectTipIcon.setVisibility(8);
            }
        }

        @Override // android.os.CountDownTimer
        public void onTick(long j) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "-1799903061")) {
                ipChange.ipc$dispatch("-1799903061", new Object[]{this, Long.valueOf(j)});
            }
        }
    }

    /* compiled from: Taobao */
    /* renamed from: cn.damai.category.ranking.ui.RankListFragment$d */
    /* loaded from: classes.dex */
    public class View$OnClickListenerC0425d implements View.OnClickListener {
        private static transient /* synthetic */ IpChange $ipChange;

        View$OnClickListenerC0425d() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "1000603585")) {
                ipChange.ipc$dispatch("1000603585", new Object[]{this, view});
            } else if (RankListFragment.this.isFastDoubleClick()) {
            } else {
                RankListFragment.this.jumpRankSquare();
            }
        }
    }

    /* compiled from: Taobao */
    /* renamed from: cn.damai.category.ranking.ui.RankListFragment$e */
    /* loaded from: classes.dex */
    public class View$OnClickListenerC0426e implements View.OnClickListener {
        private static transient /* synthetic */ IpChange $ipChange;

        View$OnClickListenerC0426e() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "-1183073342")) {
                ipChange.ipc$dispatch("-1183073342", new Object[]{this, view});
            } else {
                RankListFragment.this.requestFollow(view);
            }
        }
    }

    /* compiled from: Taobao */
    /* renamed from: cn.damai.category.ranking.ui.RankListFragment$f */
    /* loaded from: classes.dex */
    public class View$OnClickListenerC0427f implements View.OnClickListener {
        private static transient /* synthetic */ IpChange $ipChange;

        View$OnClickListenerC0427f() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "928217027")) {
                ipChange.ipc$dispatch("928217027", new Object[]{this, view});
            } else if (RankListFragment.this.baseActivity != null) {
                RankListFragment.this.baseActivity.finish();
            }
        }
    }

    /* compiled from: Taobao */
    /* renamed from: cn.damai.category.ranking.ui.RankListFragment$g */
    /* loaded from: classes.dex */
    public class View$OnClickListenerC0428g implements View.OnClickListener {
        private static transient /* synthetic */ IpChange $ipChange;

        View$OnClickListenerC0428g() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "-1255459900")) {
                ipChange.ipc$dispatch("-1255459900", new Object[]{this, view});
                return;
            }
            C0528b c0528b = C0528b.getInstance();
            RankListFragment rankListFragment = RankListFragment.this;
            C0529c.e().x(c0528b.e(rankListFragment.spmB, "top", "share", rankListFragment.getUtMap(), Boolean.FALSE));
            Bundle bundle = new Bundle();
            bundle.putString("title", ((Object) RankListFragment.this.mTopTitleTv.getText()) + "");
            bundle.putString("projectName", ((Object) RankListFragment.this.mTopTitleTv.getText()) + "");
            bundle.putString("message", ((Object) RankListFragment.this.mDescTv.getText()) + "");
            if (!TextUtils.isEmpty(RankListFragment.this.mShareImageUrl)) {
                bundle.putString("imageurl", RankListFragment.this.mShareImageUrl);
                bundle.putString("projectImage", RankListFragment.this.mShareImageUrl);
            }
            if (!TextUtils.isEmpty(RankListFragment.this.mShareBitmapUrl)) {
                bundle.putString("sinaSharePath", RankListFragment.this.mShareBitmapUrl);
            }
            if (!TextUtils.isEmpty(RankListFragment.this.mShareUrl)) {
                bundle.putString("producturl", RankListFragment.this.mShareUrl);
            }
            bundle.putBoolean("showGenerateImage", true);
            bundle.putString("shareType", "chat_h5");
            bundle.putString("shareImageStyle", GenerateImageUtil.STYLE_GENERATE_RANKING_IMAGE);
            ShareManager.E().O(RankListFragment.this.baseActivity, bundle, R$layout.rank_activity);
        }
    }

    /* compiled from: Taobao */
    /* renamed from: cn.damai.category.ranking.ui.RankListFragment$h */
    /* loaded from: classes.dex */
    public class C0429h implements PtrHandler {
        private static transient /* synthetic */ IpChange $ipChange;

        C0429h() {
        }

        @Override // in.srain.cube.views.ptr.PtrHandler
        public boolean checkCanDoRefresh(PtrFrameLayout ptrFrameLayout, View view, View view2) {
            IpChange ipChange = $ipChange;
            return AndroidInstantRuntime.support(ipChange, "1327366478") ? ((Boolean) ipChange.ipc$dispatch("1327366478", new Object[]{this, ptrFrameLayout, view, view2})).booleanValue() : RankListFragment.this.mAppBar.getTop() >= 0;
        }

        @Override // in.srain.cube.views.ptr.PtrHandler
        public void onRefreshBegin(PtrFrameLayout ptrFrameLayout) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "14715395")) {
                ipChange.ipc$dispatch("14715395", new Object[]{this, ptrFrameLayout});
            } else {
                RankListFragment.this.loadData();
            }
        }
    }

    /* compiled from: Taobao */
    /* renamed from: cn.damai.category.ranking.ui.RankListFragment$i */
    /* loaded from: classes.dex */
    public class C0430i implements AppBarLayout.OnOffsetChangedListener {
        private static transient /* synthetic */ IpChange $ipChange;

        C0430i() {
        }

        @Override // com.google.android.material.appbar.AppBarLayout.OnOffsetChangedListener, com.google.android.material.appbar.AppBarLayout.BaseOnOffsetChangedListener
        public void onOffsetChanged(AppBarLayout appBarLayout, int i) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "383957965")) {
                ipChange.ipc$dispatch("383957965", new Object[]{this, appBarLayout, Integer.valueOf(i)});
                return;
            }
            float abs = Math.abs(i) / appBarLayout.getHeight();
            if (abs > 0.5f) {
                kg2.f(RankListFragment.this.baseActivity, true, R$color.black);
                kg2.d(true, RankListFragment.this.baseActivity);
                RankListFragment.this.mBackBtn.setTextColor(-16777216);
                RankListFragment.this.mShareBtn.setTextColor(Color.parseColor("#5F6672"));
                TextView textView = RankListFragment.this.mMoreRank;
                int i2 = R$drawable.bg_share_pink;
                textView.setBackgroundResource(i2);
                RankListFragment.this.mWannaSee.setBackgroundResource(i2);
                RankListFragment.this.mMoreRank.setTextColor(Color.parseColor("#FF79BD"));
                RankListFragment.this.mWannaSee.setTextColor(Color.parseColor("#FF79BD"));
            } else {
                kg2.e(RankListFragment.this.baseActivity);
                RankListFragment.this.mBackBtn.setTextColor(-1);
                RankListFragment.this.mShareBtn.setTextColor(-1);
                TextView textView2 = RankListFragment.this.mMoreRank;
                int i3 = R$drawable.bg_btn_33white;
                textView2.setBackgroundResource(i3);
                RankListFragment.this.mMoreRank.setTextColor(-1);
                RankListFragment.this.mWannaSee.setBackgroundResource(i3);
                RankListFragment.this.mWannaSee.setTextColor(-1);
            }
            if (abs > 1.0f) {
                abs = 1.0f;
            }
            RankListFragment.this.mTitleBgLayout.setAlpha(abs);
            RankListFragment.this.mStatusBarSpace.setAlpha(abs);
            RankListFragment.this.mTitleTv.setAlpha(abs);
            RankListFragment.this.mHeader.scrollTo(0, -i);
            boolean z = appBarLayout.getHeight() == Math.abs(i);
            if (((AbsFragment) RankListFragment.this).mRecyclerView != null) {
                ((AbsFragment) RankListFragment.this).mRecyclerView.setBackgroundResource(z ? R$drawable.bg_white : R$drawable.discount_lv_bg);
            }
        }
    }

    /* compiled from: Taobao */
    /* renamed from: cn.damai.category.ranking.ui.RankListFragment$j */
    /* loaded from: classes.dex */
    public class C0431j implements DMImageCreator.DMImageFailListener {
        private static transient /* synthetic */ IpChange $ipChange;

        C0431j(RankListFragment rankListFragment) {
        }

        @Override // cn.damai.common.image.DMImageCreator.DMImageFailListener
        public void onFail(DMImageCreator.C0501d c0501d) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "414434683")) {
                ipChange.ipc$dispatch("414434683", new Object[]{this, c0501d});
            }
        }
    }

    private void getShareData(RankListHeader rankListHeader) {
        RankItemBean rankItemBean;
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1959745802")) {
            ipChange.ipc$dispatch("1959745802", new Object[]{this, rankListHeader});
            return;
        }
        if (TextUtils.isEmpty(rankListHeader.shareUrl)) {
            this.mShareBtn.setVisibility(8);
        } else {
            this.mShareBtn.setVisibility(0);
            C0529c.e().G(this.mShareBtn, "share", "top", this.spmB, getUtMap());
        }
        this.mShareUrl = rankListHeader.shareUrl;
        List<RankItemBean> list = rankListHeader.list;
        if (list == null || (rankItemBean = list.get(0)) == null) {
            return;
        }
        C0504a.b().f(rankItemBean.headPic, m62.a(this.baseActivity, 111.0f), m62.a(this.baseActivity, 148.0f)).n(new C0422a()).e(new C0431j(this)).f();
    }

    /* JADX INFO: Access modifiers changed from: private */
    @NonNull
    public Map<String, String> getUtMap() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-668107119")) {
            return (Map) ipChange.ipc$dispatch("-668107119", new Object[]{this});
        }
        HashMap hashMap = new HashMap();
        hashMap.put("usercode", z20.E());
        hashMap.put(C9548pb.CNT_CONTENT_ID, this.mId);
        String str = this.mCityId;
        if (str != null) {
            hashMap.put("city", str);
        } else {
            hashMap.put("city", z20.c());
        }
        RankListHeader rankListHeader = this.headerBean;
        if (rankListHeader != null) {
            hashMap.put("titlelabel", rankListHeader.name);
        }
        hashMap.put(C9548pb.CNT_CONTENT_TYPE, "ranklist");
        return hashMap;
    }

    private void initList() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1415573173")) {
            ipChange.ipc$dispatch("1415573173", new Object[]{this});
            return;
        }
        View inflate = LayoutInflater.from(this.baseActivity).inflate(R$layout.common_footer_empty_new, (ViewGroup) null);
        this.mEmptyFoot = inflate;
        this.mRecyclerView.setLoadMoreFooterView(inflate);
        this.mRecyclerView.setRefreshEnabled(false);
    }

    private void initTop() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1388454306")) {
            ipChange.ipc$dispatch("1388454306", new Object[]{this});
            return;
        }
        this.mStatusBarSpace = findViewById(R$id.title_bar_space);
        this.mMainView = (ViewGroup) findViewById(R$id.main_view);
        this.mAppBar = (AppBarLayout) findViewById(R$id.appbar);
        this.mHeader = findViewById(R$id.header);
        this.mTitleBgLayout = findViewById(R$id.title_bg_layout);
        this.mPtr = (PtrFrameLayout) findViewById(R$id.discount_ticket_ptr);
        this.mBgImg = (ImageView) findViewById(R$id.header_image);
        this.mTitleTv = (TextView) findViewById(R$id.title_tv);
        this.mTopTitleTv = (TextView) findViewById(R$id.tv_title);
        this.mDescTv = (TextView) findViewById(R$id.tv_desc);
        this.mBackBtn = (TextView) findViewById(R$id.title_back_btn);
        this.mShareBtn = (TextView) findViewById(R$id.title_share_btn);
        this.mWannaSee = (TextView) findViewById(R$id.title_wannasee_btn);
        this.mMoreRank = (TextView) findViewById(R$id.title_more_rank_btn);
        View findViewById = findViewById(R$id.tv_collect_tip);
        this.mCollectTipIcon = findViewById;
        findViewById.setVisibility(8);
        this.mMoreRank.setOnClickListener(new View$OnClickListenerC0425d());
        this.mWannaSee.setOnClickListener(new View$OnClickListenerC0426e());
        this.mBackBtn.setOnClickListener(new View$OnClickListenerC0427f());
        this.mShareBtn.setOnClickListener(new View$OnClickListenerC0428g());
        PtrUiHeader ptrUiHeader = new PtrUiHeader(this.baseActivity);
        this.mPtr.setHeaderView(ptrUiHeader);
        this.mPtr.addPtrUIHandler(ptrUiHeader);
        this.mPtr.setPtrIndicator(new xj0(100, this.baseActivity));
        this.mPtr.setResistance(1.7f);
        this.mPtr.setPtrHandler(new C0429h());
        this.mPtr.addPtrUIHandler(new PtrClassicDefaultHeader(this.baseActivity) { // from class: cn.damai.category.ranking.ui.RankListFragment.6
            private static transient /* synthetic */ IpChange $ipChange;

            @Override // in.srain.cube.views.ptr.PtrClassicDefaultHeader, in.srain.cube.views.ptr.PtrUIHandler
            public void onUIPositionChange(PtrFrameLayout ptrFrameLayout, boolean z, byte b, rx1 rx1Var) {
                IpChange ipChange2 = $ipChange;
                if (AndroidInstantRuntime.support(ipChange2, "-1665701679")) {
                    ipChange2.ipc$dispatch("-1665701679", new Object[]{this, ptrFrameLayout, Boolean.valueOf(z), Byte.valueOf(b), rx1Var});
                    return;
                }
                super.onUIPositionChange(ptrFrameLayout, z, b, rx1Var);
                int d = rx1Var.d();
                ViewGroup.LayoutParams layoutParams = RankListFragment.this.mBgImg.getLayoutParams();
                int a = m62.a(getContext(), 215.0f);
                int abs = Math.abs(d) + a;
                layoutParams.height = abs;
                RankListFragment.this.mBgImg.setPivotX(RankListFragment.this.mBgImg.getWidth() / 2.0f);
                RankListFragment.this.mBgImg.setScaleX(abs / a);
                RankListFragment.this.mBgImg.setLayoutParams(layoutParams);
            }
        });
        this.mAppBar.addOnOffsetChangedListener((AppBarLayout.OnOffsetChangedListener) new C0430i());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean isFastDoubleClick() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1790343654")) {
            return ((Boolean) ipChange.ipc$dispatch("-1790343654", new Object[]{this})).booleanValue();
        }
        long currentTimeMillis = System.currentTimeMillis();
        Log.e("lastClickTime", "long = " + (currentTimeMillis - this.lastClickTime));
        if (currentTimeMillis - this.lastClickTime < 500) {
            this.lastClickTime = currentTimeMillis;
            return true;
        }
        this.lastClickTime = currentTimeMillis;
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void jumpRankSquare() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "734186028")) {
            ipChange.ipc$dispatch("734186028", new Object[]{this});
            return;
        }
        C0529c.e().x(C0528b.getInstance().e(this.spmB, "top", "more", getUtMap(), Boolean.FALSE));
        RankListHeader rankListHeader = this.headerBean;
        if (rankListHeader != null && !TextUtils.isEmpty(rankListHeader.categoryId)) {
            DMNav from = DMNav.from(getActivity());
            from.toUri("damai://V1/RankSquareCmsPage?categoryId=" + this.headerBean.categoryId);
            return;
        }
        DMNav.from(getActivity()).toUri("damai://V1/RankSquareCmsPage");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void loadData() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "843974547")) {
            ipChange.ipc$dispatch("843974547", new Object[]{this});
            return;
        }
        startProgressDialog();
        final TetrisRequest tetrisRequest = new TetrisRequest(new RankListRequest(this.mId));
        DMMtopWarningListener<BaseResponse> dMMtopWarningListener = new DMMtopWarningListener<BaseResponse>(BaseResponse.class, tetrisRequest.toJsonString()) { // from class: cn.damai.category.ranking.ui.RankListFragment.8
            private static transient /* synthetic */ IpChange $ipChange;

            /* compiled from: Taobao */
            /* renamed from: cn.damai.category.ranking.ui.RankListFragment$8$a */
            /* loaded from: classes.dex */
            public class C0420a implements OnErrorClickListener {
                private static transient /* synthetic */ IpChange $ipChange;

                C0420a() {
                }

                @Override // cn.damai.commonbusiness.base.ResponseErrorPage.ErrorRefreshListener
                public void handleError(int i) {
                    IpChange ipChange = $ipChange;
                    if (AndroidInstantRuntime.support(ipChange, "1871424669")) {
                        ipChange.ipc$dispatch("1871424669", new Object[]{this, Integer.valueOf(i)});
                        return;
                    }
                    AnonymousClass8 anonymousClass8 = AnonymousClass8.this;
                    tetrisRequest.request(RankListFragment.this.dmlistener);
                }
            }

            /* compiled from: Taobao */
            /* renamed from: cn.damai.category.ranking.ui.RankListFragment$8$b */
            /* loaded from: classes.dex */
            public class C0421b implements OnErrorClickListener {
                private static transient /* synthetic */ IpChange $ipChange;

                C0421b() {
                }

                @Override // cn.damai.commonbusiness.base.ResponseErrorPage.ErrorRefreshListener
                public void handleError(int i) {
                    IpChange ipChange = $ipChange;
                    if (AndroidInstantRuntime.support(ipChange, "1026952798")) {
                        ipChange.ipc$dispatch("1026952798", new Object[]{this, Integer.valueOf(i)});
                        return;
                    }
                    AnonymousClass8 anonymousClass8 = AnonymousClass8.this;
                    tetrisRequest.request(RankListFragment.this.dmlistener);
                }
            }

            @Override // cn.damai.tetris.DMMtopWarningListener
            public void onFailWithWarning(String str, String str2) {
                IpChange ipChange2 = $ipChange;
                if (AndroidInstantRuntime.support(ipChange2, "-200667602")) {
                    ipChange2.ipc$dispatch("-200667602", new Object[]{this, str, str2});
                    return;
                }
                RankListFragment.this.stopProgressDialog();
                RankListFragment.this.mPtr.refreshComplete();
                ((AbsFragment) RankListFragment.this).mRecyclerView.setRefreshing(false);
                RankListFragment.this.showErrorView(str, str2, null, new C0421b());
            }

            @Override // cn.damai.tetris.DMMtopWarningListener
            public void onSuccessWithWarning(BaseResponse baseResponse) {
                ArrayList<BaseLayer> arrayList;
                IpChange ipChange2 = $ipChange;
                if (AndroidInstantRuntime.support(ipChange2, "-846304176")) {
                    ipChange2.ipc$dispatch("-846304176", new Object[]{this, baseResponse});
                    return;
                }
                RankListFragment.this.stopProgressDialog();
                RankListFragment.this.mPtr.refreshComplete();
                ((AbsFragment) RankListFragment.this).mRecyclerView.setRefreshing(false);
                if (baseResponse != null && (arrayList = baseResponse.layers) != null && arrayList.size() != 0) {
                    RankListFragment.this.updateTop(baseResponse);
                    GlobalConfig globalConfig = baseResponse.globalConfig;
                    if (globalConfig != null) {
                        RankListFragment rankListFragment = RankListFragment.this;
                        String str = globalConfig.pageName;
                        rankListFragment.spmB = str;
                        rankListFragment.updateSpmB(str, globalConfig.abBuckets);
                        baseResponse.globalConfig.putBuzUTMap(RankListFragment.this.getUtMap());
                    }
                    RankListItemHolder.Companion.b(new HashMap<>());
                    RankListFragment.this.setData(baseResponse);
                    return;
                }
                RankListFragment.this.showErrorView(null, null, null, new C0420a());
            }
        };
        this.dmlistener = dMMtopWarningListener;
        tetrisRequest.request(dMMtopWarningListener);
    }

    public static RankListFragment newInstance(String str) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "647199847")) {
            return (RankListFragment) ipChange.ipc$dispatch("647199847", new Object[]{str});
        }
        RankListFragment rankListFragment = new RankListFragment();
        Bundle bundle = new Bundle();
        bundle.putString(KEY_RANK_ID, str);
        rankListFragment.setArguments(bundle);
        return rankListFragment;
    }

    private void parseJson(BaseLayer baseLayer) {
        JSONArray jSONArray;
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-551956048")) {
            ipChange.ipc$dispatch("-551956048", new Object[]{this, baseLayer});
            return;
        }
        for (BaseSection baseSection : baseLayer.getSections()) {
            if (baseSection != null && "dm_list_header_ranking".equals(baseSection.getComponentId())) {
                try {
                    this.headerBean = (RankListHeader) JSON.parseObject(baseSection.getItem().toJSONString(), RankListHeader.class);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            } else if (baseSection != null && "dm_list_card_ranking".equals(baseSection.getComponentId())) {
                try {
                    JSONObject parseObject = JSON.parseObject(baseSection.getItem().toJSONString());
                    if (parseObject.getJSONArray("result") != null && (jSONArray = parseObject.getJSONArray("result")) != null && jSONArray.get(0) != null) {
                        JSONObject jSONObject = (JSONObject) jSONArray.get(0);
                        if (jSONObject != null) {
                            this.mShareImageUrl = jSONObject.getString("headPic");
                        }
                        for (int i = 0; i < jSONArray.size(); i++) {
                            JSONObject jSONObject2 = (JSONObject) jSONArray.get(i);
                            if (jSONObject2 != null) {
                                jSONObject2.put(KEY_RANK_ID, (Object) this.mId);
                                jSONObject2.put("rankName", (Object) this.headerBean.name);
                            }
                        }
                        baseSection.setItem(parseObject);
                    }
                } catch (Exception e2) {
                    e2.printStackTrace();
                }
            }
        }
    }

    private void startTime() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "168486072")) {
            ipChange.ipc$dispatch("168486072", new Object[]{this});
            return;
        }
        cancelCountDown();
        if (this.mTimeCountDown == null) {
            this.mTimeCountDown = new CountDownTimerC0424c(3000L, 3000L);
        }
        this.mTimeCountDown.start();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void updateSpmB(String str, JSONArray jSONArray) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1644495322")) {
            ipChange.ipc$dispatch("1644495322", new Object[]{this, str, jSONArray});
        } else if (getActivity() == null || !(getActivity() instanceof DamaiBaseActivity)) {
        } else {
            HashMap hashMap = new HashMap();
            if (jSONArray != null) {
                hashMap.put("current_ab", jSONArray.toJSONString());
            }
            if (getUserVisibleHint()) {
                C0529c.e().L(getActivity(), str);
                C0529c.e().l(getActivity(), new C0525a.C0527b().i(str).j(hashMap));
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void updateTop(BaseResponse baseResponse) {
        String str;
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "880895622")) {
            ipChange.ipc$dispatch("880895622", new Object[]{this, baseResponse});
            return;
        }
        if (baseResponse.layers.size() > 0) {
            Iterator<BaseLayer> it = baseResponse.layers.iterator();
            while (it.hasNext()) {
                BaseLayer next = it.next();
                if (next.getSections() != null && next.getSections().size() > 0) {
                    parseJson(next);
                }
            }
        }
        RankListHeader rankListHeader = this.headerBean;
        if (rankListHeader == null) {
            return;
        }
        int i = rankListHeader.type;
        if (i == 99) {
            this.mBgImg.setImageResource(R$drawable.ranklist_header_bg_repro);
        } else if (i == 2) {
            this.mBgImg.setImageResource(R$drawable.ranklist_header_bg_new);
        } else if (i == 3) {
            this.mBgImg.setImageResource(R$drawable.ranklist_header_bg_hiscore);
        } else {
            this.mBgImg.setImageResource(R$drawable.ranklist_header_bg_top);
        }
        this.mTitleTv.setText(this.headerBean.name);
        this.mTopTitleTv.setText(this.headerBean.name);
        if (!TextUtils.isEmpty(this.headerBean.desc) && !TextUtils.isEmpty(this.headerBean.updateDesc)) {
            str = this.headerBean.desc + " | " + this.headerBean.updateDesc;
        } else if (!TextUtils.isEmpty(this.headerBean.desc)) {
            str = this.headerBean.desc;
        } else {
            str = !TextUtils.isEmpty(this.headerBean.updateDesc) ? this.headerBean.updateDesc : "";
        }
        this.mDescTv.setText(str);
        int i2 = this.headerBean.followStatus;
        this.followStatus = i2;
        if (i2 == 1) {
            this.mWannaSee.setText("已想看");
        } else {
            this.mWannaSee.setText("想看");
            visCollectTip(TextUtils.isEmpty(this.headerBean.shareUrl));
        }
        C0529c.e().G(this.mWannaSee, "favorite", "top", this.spmB, getUtMap());
        C0529c.e().G(this.mMainView, "more", "top", this.spmB, getUtMap());
        getShareData(this.headerBean);
    }

    private void visCollectTip(boolean z) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-173076962")) {
            ipChange.ipc$dispatch("-173076962", new Object[]{this, Boolean.valueOf(z)});
            return;
        }
        SharedPreferences sharedPreferences = getContext().getSharedPreferences("rankListFragment_sp", 0);
        if (sharedPreferences.getBoolean("rankListFragment_sp_favorite", false)) {
            return;
        }
        sharedPreferences.edit().putBoolean("rankListFragment_sp_favorite", true).commit();
        FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) this.mCollectTipIcon.getLayoutParams();
        layoutParams.rightMargin = m62.a(getActivity(), z ? 10.0f : 50.0f);
        this.mCollectTipIcon.setLayoutParams(layoutParams);
        this.mCollectTipIcon.setVisibility(0);
        startTime();
    }

    protected void adjustStatusBar() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-513680715")) {
            ipChange.ipc$dispatch("-513680715", new Object[]{this});
            return;
        }
        View findViewById = findViewById(R$id.title_bar_space);
        int i = Build.VERSION.SDK_INT;
        if (i >= 23) {
            kg2.f(this.baseActivity, true, R$color.black);
        } else {
            kg2.f(this.baseActivity, false, R$color.black);
        }
        if (findViewById != null) {
            if (i >= 23) {
                findViewById.getLayoutParams().height = kg2.a(this.baseActivity);
                this.mAppBar.getLayoutParams().height = (m62.a(this.baseActivity, 180.0f) - m62.a(this.baseActivity, 44.0f)) - kg2.a(this.baseActivity);
                findViewById.setVisibility(0);
                return;
            }
            findViewById.setVisibility(8);
        }
    }

    public void cancelCountDown() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1200712592")) {
            ipChange.ipc$dispatch("1200712592", new Object[]{this});
            return;
        }
        CountDownTimer countDownTimer = this.mTimeCountDown;
        if (countDownTimer != null) {
            countDownTimer.cancel();
            this.mTimeCountDown = null;
        }
    }

    public <T extends View> T findViewById(@IdRes int i) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1453284270")) {
            return (T) ipChange.ipc$dispatch("-1453284270", new Object[]{this, Integer.valueOf(i)});
        }
        ViewGroup viewGroup = this.rootView;
        if (viewGroup == null) {
            return null;
        }
        return (T) viewGroup.findViewById(i);
    }

    @Override // cn.damai.tetris.page.AbsFragment
    public int getRecycleViewId() {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "-1655253831") ? ((Integer) ipChange.ipc$dispatch("-1655253831", new Object[]{this})).intValue() : R$id.discount_ticket_recycler;
    }

    @Override // cn.damai.tetris.page.AbsFragment
    public void hideErrorView() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-2051715364")) {
            ipChange.ipc$dispatch("-2051715364", new Object[]{this});
            return;
        }
        RankListActivity rankListActivity = this.baseActivity;
        if (rankListActivity != null) {
            rankListActivity.hideErrorView(this.mMainView);
        }
    }

    public void initView() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1687835470")) {
            ipChange.ipc$dispatch("1687835470", new Object[]{this});
            return;
        }
        initTop();
        adjustStatusBar();
        this.wantSeeTips = (WantSeeTips) findViewById(R$id.want_see_tips_rank_list);
        initList();
        loadData();
        HashMap hashMap = new HashMap();
        hashMap.put("usercode", z20.E());
        hashMap.put(C9548pb.CNT_CONTENT_ID, this.mId);
        String str = this.mCityId;
        if (str != null) {
            hashMap.put("city", str);
        } else {
            hashMap.put("city", z20.c());
        }
        hashMap.put(C9548pb.CNT_CONTENT_TYPE, "ranklist");
        this.baseActivity.setDamaiUTKeyBuilder(new C0525a.C0527b().j(hashMap).i("ranklist"));
    }

    @Override // cn.damai.tetris.page.AbsFragment, androidx.fragment.app.Fragment
    public void onActivityResult(int i, int i2, Intent intent) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "743348149")) {
            ipChange.ipc$dispatch("743348149", new Object[]{this, Integer.valueOf(i), Integer.valueOf(i2), intent});
            return;
        }
        super.onActivityResult(i, i2, intent);
        ShareManager.E().r0(i, i2, intent);
        if (i == 4097 && i2 == -1 && getActivity() != null) {
            Bundle bundle = new Bundle();
            bundle.putString(KEY_RANK_ID, this.mId);
            bundle.putString("cityId", this.mCityId);
            DMNav.from(getActivity()).withExtras(bundle).toUri(NavUri.b("ranking"));
            getActivity().finish();
        }
    }

    @Override // cn.damai.tetris.page.AbsFragment, androidx.fragment.app.Fragment
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1042489896")) {
            return (View) ipChange.ipc$dispatch("-1042489896", new Object[]{this, layoutInflater, viewGroup, bundle});
        }
        if (getArguments() == null) {
            return null;
        }
        try {
            this.mId = getArguments().getString(KEY_RANK_ID);
            this.mCityId = getArguments().getString("cityId");
        } catch (NumberFormatException e) {
            e.printStackTrace();
        }
        return layoutInflater.inflate(R$layout.rank_activity, viewGroup, false);
    }

    @Override // cn.damai.tetris.page.AbsFragment, androidx.fragment.app.Fragment
    public void onDestroy() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "2122566252")) {
            ipChange.ipc$dispatch("2122566252", new Object[]{this});
            return;
        }
        super.onDestroy();
        cancelCountDown();
    }

    @Override // cn.damai.tetris.page.AbsFragment, cn.damai.uikit.irecycler.OnLoadMoreListener
    public void onLoadMore(View view) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1038841591")) {
            ipChange.ipc$dispatch("-1038841591", new Object[]{this, view});
        }
    }

    @Override // cn.damai.tetris.page.AbsFragment, cn.damai.tetris.core.msg.IMessage
    public void onMessage(int i, Object obj) {
        WantSeeTips wantSeeTips;
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "118183552")) {
            ipChange.ipc$dispatch("118183552", new Object[]{this, Integer.valueOf(i), obj});
        } else if (i == 24 && (obj instanceof FollowDataBean)) {
            this.wantSeeTips.setPageSource(WantSeeTips.AbstractC1562a.C1568f.INSTANCE);
            if (g03.INSTANCE.e(this.baseActivity, new C0423b(((FollowDataBean) obj).tempRank)) || (wantSeeTips = this.wantSeeTips) == null) {
                return;
            }
            wantSeeTips.showAnim();
        }
    }

    @Override // cn.damai.tetris.page.AbsFragment, cn.damai.uikit.irecycler.OnRefreshListener
    public void onRefresh() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "340647915")) {
            ipChange.ipc$dispatch("340647915", new Object[]{this});
        }
    }

    @Override // cn.damai.tetris.page.AbsFragmentV2, cn.damai.tetris.page.AbsFragment, androidx.fragment.app.Fragment
    public void onViewCreated(@NonNull View view, @Nullable Bundle bundle) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "779093317")) {
            ipChange.ipc$dispatch("779093317", new Object[]{this, view, bundle});
            return;
        }
        super.onViewCreated(view, bundle);
        this.rootView = (ViewGroup) view;
        this.baseActivity = (RankListActivity) getActivity();
        initView();
    }

    public void requestFollow(final View view) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1803917355")) {
            ipChange.ipc$dispatch("1803917355", new Object[]{this, view});
            return;
        }
        C0529c.e().x(C0528b.getInstance().e(this.spmB, "top", "favorite", getUtMap(), Boolean.FALSE));
        view.setClickable(false);
        FollowRequest followRequest = new FollowRequest();
        followRequest.operateType = this.followStatus == 1 ? "0" : "1";
        followRequest.targetId = this.mId;
        followRequest.targetType = "13";
        followRequest.request(new DMMtopRequestListener<FollowDataBean>(FollowDataBean.class) { // from class: cn.damai.category.ranking.ui.RankListFragment.12
            private static transient /* synthetic */ IpChange $ipChange;

            /* compiled from: Taobao */
            /* renamed from: cn.damai.category.ranking.ui.RankListFragment$12$a */
            /* loaded from: classes.dex */
            public class C0419a implements GuideUtProvider {
                private static transient /* synthetic */ IpChange $ipChange;

                C0419a() {
                }

                @Override // cn.damai.wantsee.GuideUtProvider
                @NonNull
                public Map<String, String> getGuideCloseBtnArgMap() {
                    IpChange ipChange = $ipChange;
                    return AndroidInstantRuntime.support(ipChange, "-1792284506") ? (Map) ipChange.ipc$dispatch("-1792284506", new Object[]{this}) : getGuideExposeArgMap();
                }

                @Override // cn.damai.wantsee.GuideUtProvider
                @NonNull
                public Map<String, String> getGuideExposeArgMap() {
                    IpChange ipChange = $ipChange;
                    if (AndroidInstantRuntime.support(ipChange, "2066322342")) {
                        return (Map) ipChange.ipc$dispatch("2066322342", new Object[]{this});
                    }
                    HashMap hashMap = new HashMap();
                    RankListHeader rankListHeader = RankListFragment.this.headerBean;
                    if (rankListHeader != null && !TextUtils.isEmpty(rankListHeader.name)) {
                        hashMap.put("titlelabel", RankListFragment.this.headerBean.name);
                    }
                    if (!TextUtils.isEmpty(RankListFragment.this.mId)) {
                        hashMap.put(C9548pb.CNT_CONTENT_ID, RankListFragment.this.mId);
                    }
                    return hashMap;
                }

                @Override // cn.damai.wantsee.GuideUtProvider
                @NonNull
                public Map<String, String> getGuideGoMineBtnArgMap() {
                    IpChange ipChange = $ipChange;
                    return AndroidInstantRuntime.support(ipChange, "2128443133") ? (Map) ipChange.ipc$dispatch("2128443133", new Object[]{this}) : getGuideExposeArgMap();
                }

                @Override // cn.damai.wantsee.GuideUtProvider
                @NonNull
                public String getSpmB() {
                    IpChange ipChange = $ipChange;
                    return AndroidInstantRuntime.support(ipChange, "1654797055") ? (String) ipChange.ipc$dispatch("1654797055", new Object[]{this}) : RankListFragment.this.spmB;
                }
            }

            @Override // cn.damai.common.net.mtop.netfit.DMMtopRequestListener
            public void onFail(String str, String str2) {
                IpChange ipChange2 = $ipChange;
                if (AndroidInstantRuntime.support(ipChange2, "1706681131")) {
                    ipChange2.ipc$dispatch("1706681131", new Object[]{this, str, str2});
                } else {
                    view.setClickable(true);
                }
            }

            @Override // cn.damai.common.net.mtop.netfit.DMMtopRequestListener
            public void onSuccess(FollowDataBean followDataBean) {
                IpChange ipChange2 = $ipChange;
                if (AndroidInstantRuntime.support(ipChange2, "1962183125")) {
                    ipChange2.ipc$dispatch("1962183125", new Object[]{this, followDataBean});
                    return;
                }
                view.setClickable(true);
                if (followDataBean != null) {
                    RankListFragment.this.followStatus = followDataBean.getStatus();
                    if (followDataBean.getStatus() == 1) {
                        ((TextView) view).setText("已想看");
                        RankListFragment.this.wantSeeTips.setPageSource(WantSeeTips.AbstractC1562a.C1569g.INSTANCE);
                        if (g03.INSTANCE.e(RankListFragment.this.baseActivity, new C0419a()) || RankListFragment.this.wantSeeTips == null) {
                            return;
                        }
                        RankListFragment.this.wantSeeTips.showAnim();
                        return;
                    }
                    ((TextView) view).setText("想看");
                }
            }
        });
    }

    public void showErrorView(String str, String str2, String str3, OnErrorClickListener onErrorClickListener) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-2022258110")) {
            ipChange.ipc$dispatch("-2022258110", new Object[]{this, str, str2, str3, onErrorClickListener});
            return;
        }
        RankListActivity rankListActivity = this.baseActivity;
        if (rankListActivity != null) {
            rankListActivity.showErrorView(this.mMainView, str, str2, str3, onErrorClickListener);
        }
    }
}
