package cn.damai.category.inventory.ui;

import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.Color;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.GradientDrawable;
import android.os.Build;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.annotation.FloatRange;
import androidx.annotation.Nullable;
import androidx.coordinatorlayout.widget.CoordinatorLayout;
import androidx.core.content.ContextCompat;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import cn.damai.category.inventory.bean.DetailedBean;
import cn.damai.category.inventory.bean.DetailedBeanResponse;
import cn.damai.category.inventory.bean.DetailedDataHolder;
import cn.damai.category.inventory.bean.DetailedFollowResponse;
import cn.damai.category.inventory.model.DetailedModel;
import cn.damai.category.inventory.ui.adapter.DetailedAdapter;
import cn.damai.common.image.DMImageCreator;
import cn.damai.common.nav.DMNav;
import cn.damai.common.nav.NavUri;
import cn.damai.common.util.ToastUtil;
import cn.damai.commonbusiness.base.SimpleBaseActivity;
import cn.damai.commonbusiness.search.bean.FollowDataBean;
import cn.damai.commonbusiness.share.ShareManager;
import cn.damai.commonbusiness.util.DMRGBUtil;
import cn.damai.homepage.R$color;
import cn.damai.homepage.R$drawable;
import cn.damai.homepage.R$id;
import cn.damai.homepage.R$layout;
import cn.damai.login.LoginManager;
import cn.damai.uikit.iconfont.DMIconFontTextView;
import com.alibaba.wireless.security.SecExceptionCode;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import com.google.android.material.appbar.AppBarLayout;
import com.google.android.material.appbar.CollapsingToolbarLayout;
import java.util.ArrayList;
import java.util.List;
import tb.kg2;
import tb.m62;
import tb.mu0;
import tb.u70;
import tb.wh2;
import tb.z20;

/* compiled from: Taobao */
/* loaded from: classes.dex */
public class DetailedActivity extends SimpleBaseActivity {
    private static transient /* synthetic */ IpChange $ipChange;
    private int imageShapeHeight;
    private boolean loginIsFollow;
    private DetailedAdapter mAdapter;
    private ImageView mCollectTipIcon;
    private String mDetailId;
    private String mDetailTitle;
    private LinearLayout mErrorLayout;
    private DMIconFontTextView mFansIcon;
    private LinearLayout mFansLayout;
    private View mIvImageShape;
    private ImageView mIvProjectImage;
    private LinearLayout mParHeadBar;
    private RecyclerView mRecyclerView;
    private CoordinatorLayout mRootLayout;
    private ImageView mShareImage;
    private LinearLayout mShareLayout;
    private CountDownTimer mTimeCountDown;
    private LinearLayout mTitleLayout;
    private int mTitleMinHeight;
    private CollapsingToolbarLayout mToolbarLayout;
    private TextView mTvDetailedTitle;
    private TextView mTvFans;
    private TextView mTvSubHeaderTitle;
    private TextView mTvTitle;
    private DetailedModel mViewModel;
    private int topShapeHeight;
    private List<DetailedDataHolder> mDataHolderList = new ArrayList();
    private int mDetailBgColor = -1;
    private int mStatusBarHeight = 0;
    Observer<DetailedFollowResponse> followChangeObserver = new Observer<DetailedFollowResponse>() { // from class: cn.damai.category.inventory.ui.DetailedActivity.3
        private static transient /* synthetic */ IpChange $ipChange;

        @Override // androidx.lifecycle.Observer
        public void onChanged(@Nullable DetailedFollowResponse detailedFollowResponse) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "-2089333775")) {
                ipChange.ipc$dispatch("-2089333775", new Object[]{this, detailedFollowResponse});
            } else if (detailedFollowResponse != null) {
                if (detailedFollowResponse.requestSuccess) {
                    FollowDataBean followDataBean = detailedFollowResponse.data;
                    if (followDataBean == null) {
                        return;
                    }
                    int status = followDataBean.getStatus();
                    if (status == 1 || status == 2) {
                        DetailedActivity.this.updateFansData(true);
                        ToastUtil.i("已添加到想看的演出列表");
                        return;
                    }
                    DetailedActivity.this.updateFansData(false);
                    ToastUtil.i("已取消想看");
                } else if (TextUtils.isEmpty(detailedFollowResponse.errorMsg)) {
                } else {
                    ToastUtil.i(detailedFollowResponse.errorMsg);
                }
            }
        }
    };
    final int defaultRed = 89;
    final int defaultGreen = SecExceptionCode.SEC_ERROR_INIT_CLAZZ_NULL_ERROR;
    final int defaultBlue = 202;
    private final int requestFollowLogin = 1010;
    View.OnClickListener mTitleClickListener = new h();

    /* compiled from: Taobao */
    /* loaded from: classes.dex */
    public class a extends CountDownTimer {
        private static transient /* synthetic */ IpChange $ipChange;

        a(long j, long j2) {
            super(j, j2);
        }

        @Override // android.os.CountDownTimer
        public void onFinish() {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "-1516813387")) {
                ipChange.ipc$dispatch("-1516813387", new Object[]{this});
            } else {
                DetailedActivity.this.mCollectTipIcon.setVisibility(8);
            }
        }

        @Override // android.os.CountDownTimer
        public void onTick(long j) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "-1873272583")) {
                ipChange.ipc$dispatch("-1873272583", new Object[]{this, Long.valueOf(j)});
            }
        }
    }

    /* compiled from: Taobao */
    /* loaded from: classes.dex */
    public class b implements AppBarLayout.OnOffsetChangedListener {
        private static transient /* synthetic */ IpChange $ipChange;

        b() {
        }

        @Override // com.google.android.material.appbar.AppBarLayout.OnOffsetChangedListener, com.google.android.material.appbar.AppBarLayout.BaseOnOffsetChangedListener
        public void onOffsetChanged(AppBarLayout appBarLayout, int i) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "-1642517560")) {
                ipChange.ipc$dispatch("-1642517560", new Object[]{this, appBarLayout, Integer.valueOf(i)});
                return;
            }
            int abs = (Math.abs(i) * 255) / DetailedActivity.this.topShapeHeight;
            DetailedActivity.this.mTitleLayout.setBackgroundColor(DetailedActivity.this.getTitleBgColor(abs));
            if (abs > 255) {
                DetailedActivity.this.mTvTitle.setText(DetailedActivity.this.mDetailTitle);
            } else {
                DetailedActivity.this.mTvTitle.setText("");
            }
        }
    }

    /* compiled from: Taobao */
    /* loaded from: classes.dex */
    public class c implements DMImageCreator.DMImageFailListener {
        private static transient /* synthetic */ IpChange $ipChange;

        c() {
        }

        @Override // cn.damai.common.image.DMImageCreator.DMImageFailListener
        public void onFail(DMImageCreator.d dVar) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "926491873")) {
                ipChange.ipc$dispatch("926491873", new Object[]{this, dVar});
                return;
            }
            DetailedActivity.this.mIvProjectImage.setImageResource(R$drawable.category_999999_bg);
            DetailedActivity.this.defaultTopBackground();
        }
    }

    /* compiled from: Taobao */
    /* loaded from: classes.dex */
    public class d implements DMImageCreator.DMImageSuccListener {
        private static transient /* synthetic */ IpChange $ipChange;
        final /* synthetic */ String a;

        d(String str) {
            this.a = str;
        }

        @Override // cn.damai.common.image.DMImageCreator.DMImageSuccListener
        public void onSuccess(DMImageCreator.e eVar) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "390867382")) {
                ipChange.ipc$dispatch("390867382", new Object[]{this, eVar});
            } else if (eVar != null) {
                DetailedActivity.this.mIvProjectImage.setImageBitmap(eVar.b);
                DetailedActivity.this.updateDetailedBg(this.a, eVar.b);
            }
        }
    }

    /* compiled from: Taobao */
    /* loaded from: classes.dex */
    public class e implements DMRGBUtil.OnFetchColorListener {
        private static transient /* synthetic */ IpChange $ipChange;

        e() {
        }

        @Override // cn.damai.commonbusiness.util.DMRGBUtil.OnFetchColorListener
        public void onFetchColor(int i) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "-1454067317")) {
                ipChange.ipc$dispatch("-1454067317", new Object[]{this, Integer.valueOf(i)});
                return;
            }
            DetailedActivity.this.mDetailBgColor = i;
            int[] iArr = {DetailedActivity.setAlphaColor(0.0f, i), DetailedActivity.setAlphaColor(1.0f, i)};
            DetailedActivity.this.setTopImageBackground(iArr);
            if (DetailedActivity.this.mAdapter != null) {
                DetailedActivity.this.mAdapter.a(iArr);
                DetailedActivity.this.mAdapter.notifyDataSetChanged();
            }
        }
    }

    /* compiled from: Taobao */
    /* loaded from: classes.dex */
    public class f implements DMImageCreator.DMImageFailListener {
        private static transient /* synthetic */ IpChange $ipChange;
        final /* synthetic */ String a;
        final /* synthetic */ DetailedBean b;

        f(String str, DetailedBean detailedBean) {
            this.a = str;
            this.b = detailedBean;
        }

        @Override // cn.damai.common.image.DMImageCreator.DMImageFailListener
        public void onFail(DMImageCreator.d dVar) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "1721370212")) {
                ipChange.ipc$dispatch("1721370212", new Object[]{this, dVar});
            } else {
                DetailedActivity.this.updateShareLayout(this.a, this.b);
            }
        }
    }

    /* compiled from: Taobao */
    /* loaded from: classes.dex */
    public class g implements DMImageCreator.DMImageSuccListener {
        private static transient /* synthetic */ IpChange $ipChange;
        final /* synthetic */ DetailedBean a;
        final /* synthetic */ String b;

        g(DetailedBean detailedBean, String str) {
            this.a = detailedBean;
            this.b = str;
        }

        @Override // cn.damai.common.image.DMImageCreator.DMImageSuccListener
        public void onSuccess(DMImageCreator.e eVar) {
            Drawable drawable;
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "-1433363207")) {
                ipChange.ipc$dispatch("-1433363207", new Object[]{this, eVar});
            } else if (eVar == null || (drawable = eVar.a) == null) {
                DetailedActivity.this.updateShareLayout(this.b, this.a);
            } else {
                int intrinsicWidth = drawable.getIntrinsicWidth();
                int intrinsicHeight = drawable.getIntrinsicHeight();
                int a = m62.a(mu0.a(), 25.0f);
                int i = intrinsicHeight > 0 ? (int) ((intrinsicWidth * a) / intrinsicHeight) : 0;
                ViewGroup.LayoutParams layoutParams = DetailedActivity.this.mShareImage.getLayoutParams();
                if (layoutParams != null) {
                    layoutParams.height = a;
                    layoutParams.width = i;
                }
                DetailedActivity.this.mShareLayout.setVisibility(8);
                DetailedActivity.this.mShareImage.setTag(this.a);
                DetailedActivity.this.mShareImage.setVisibility(0);
                DetailedActivity.this.mShareImage.setImageDrawable(eVar.a);
            }
        }
    }

    /* compiled from: Taobao */
    /* loaded from: classes.dex */
    public class h implements View.OnClickListener {
        private static transient /* synthetic */ IpChange $ipChange;

        h() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "-1638997964")) {
                ipChange.ipc$dispatch("-1638997964", new Object[]{this, view});
                return;
            }
            int id = view.getId();
            if (id != R$id.btn_left && id != R$id.error_btn_left) {
                if (id == R$id.ll_fans) {
                    if (view.getTag() != null) {
                        boolean booleanValue = ((Boolean) view.getTag()).booleanValue();
                        cn.damai.common.user.c.e().x(u70.g().h(DetailedActivity.this.mDetailTitle, DetailedActivity.this.mDetailId, booleanValue));
                        if (!LoginManager.k().q()) {
                            DetailedActivity.this.loginIsFollow = booleanValue;
                            LoginManager.k().x(DetailedActivity.this, new Intent(), 1010);
                            return;
                        } else if (DetailedActivity.this.mViewModel != null) {
                            DetailedActivity.this.mViewModel.getAttentionState(booleanValue);
                            return;
                        } else {
                            return;
                        }
                    }
                    return;
                } else if (id == R$id.ll_share) {
                    cn.damai.common.user.c.e().x(u70.g().j(DetailedActivity.this.mDetailTitle, DetailedActivity.this.mDetailId));
                    DetailedActivity.this.openShare((DetailedBean) view.getTag());
                    return;
                } else if (id == R$id.iv_share) {
                    cn.damai.common.user.c.e().x(u70.g().j(DetailedActivity.this.mDetailTitle, DetailedActivity.this.mDetailId));
                    DetailedActivity.this.openShare((DetailedBean) view.getTag());
                    return;
                } else {
                    return;
                }
            }
            DetailedActivity.this.onBackPressed();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void defaultTopBackground() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1330008372")) {
            ipChange.ipc$dispatch("-1330008372", new Object[]{this});
            return;
        }
        int[] iArr = {Color.argb(0, 89, (int) SecExceptionCode.SEC_ERROR_INIT_CLAZZ_NULL_ERROR, 202), Color.argb(255, 89, (int) SecExceptionCode.SEC_ERROR_INIT_CLAZZ_NULL_ERROR, 202)};
        setTopImageBackground(iArr);
        DetailedAdapter detailedAdapter = this.mAdapter;
        if (detailedAdapter != null) {
            detailedAdapter.a(iArr);
            this.mAdapter.notifyDataSetChanged();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public int getTitleBgColor(int i) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1898131978")) {
            return ((Integer) ipChange.ipc$dispatch("-1898131978", new Object[]{this, Integer.valueOf(i)})).intValue();
        }
        if (i > 255) {
            i = 255;
        }
        int i2 = this.mDetailBgColor;
        if (i2 == -1) {
            return Color.argb(i, 89, (int) SecExceptionCode.SEC_ERROR_INIT_CLAZZ_NULL_ERROR, 202);
        }
        return i >= 255 ? i2 : setAlphaColor(i / 255.0f, i2);
    }

    private void initErrorView() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1801443169")) {
            ipChange.ipc$dispatch("-1801443169", new Object[]{this});
            return;
        }
        LinearLayout linearLayout = (LinearLayout) findViewById(R$id.ll_error_container);
        this.mErrorLayout = linearLayout;
        linearLayout.setVisibility(8);
        findViewById(R$id.error_btn_left).setOnClickListener(this.mTitleClickListener);
        initStateBar(findViewById(R$id.error_status_bar), false);
    }

    private void initHeadView() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1254914233")) {
            ipChange.ipc$dispatch("1254914233", new Object[]{this});
            return;
        }
        this.mTvDetailedTitle = (TextView) this.mParHeadBar.findViewById(R$id.tv_detail_title);
        this.mTvSubHeaderTitle = (TextView) this.mParHeadBar.findViewById(R$id.tv_sub_title);
        ((AppBarLayout) findViewById(R$id.appbar_layout)).addOnOffsetChangedListener((AppBarLayout.OnOffsetChangedListener) new b());
    }

    private void initIRecycleView() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1140058351")) {
            ipChange.ipc$dispatch("1140058351", new Object[]{this});
            return;
        }
        RecyclerView recyclerView = (RecyclerView) findViewById(R$id.irc);
        this.mRecyclerView = recyclerView;
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        DetailedAdapter detailedAdapter = new DetailedAdapter(this.mContext, this.mDataHolderList);
        this.mAdapter = detailedAdapter;
        this.mRecyclerView.setAdapter(detailedAdapter);
    }

    private void initStateBar(View view, boolean z) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "479029438")) {
            ipChange.ipc$dispatch("479029438", new Object[]{this, view, Boolean.valueOf(z)});
            return;
        }
        this.mStatusBarHeight = 0;
        if (Build.VERSION.SDK_INT >= 23) {
            if (view != null) {
                this.mStatusBarHeight = kg2.a(this);
                view.getLayoutParams().height = this.mStatusBarHeight;
                view.setVisibility(0);
            }
            kg2.f(this, true, R$color.black);
            kg2.d(true, this);
            kg2.e(this);
        } else {
            kg2.f(this, false, R$color.black);
            if (view != null) {
                view.setVisibility(8);
            }
        }
        this.topShapeHeight = m62.a(this, 81.0f);
        this.imageShapeHeight = this.mStatusBarHeight + m62.a(this, 126.0f);
        if (z) {
            int a2 = this.mStatusBarHeight + m62.a(this.mContext, 44.0f);
            this.mTitleMinHeight = a2;
            this.mToolbarLayout.setMinimumHeight(a2);
            FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) this.mParHeadBar.getLayoutParams();
            layoutParams.topMargin = this.mTitleMinHeight;
            this.mParHeadBar.setLayoutParams(layoutParams);
            updateImageShapeHeight();
        }
    }

    private void initTitleBar() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "763238147")) {
            ipChange.ipc$dispatch("763238147", new Object[]{this});
            return;
        }
        this.mFansLayout = (LinearLayout) findViewById(R$id.ll_fans);
        this.mFansIcon = (DMIconFontTextView) findViewById(R$id.icon_fans);
        this.mTvFans = (TextView) findViewById(R$id.tv_fans);
        this.mFansLayout.setVisibility(8);
        this.mFansLayout.setOnClickListener(this.mTitleClickListener);
        LinearLayout linearLayout = (LinearLayout) findViewById(R$id.ll_share);
        this.mShareLayout = linearLayout;
        linearLayout.setVisibility(8);
        this.mShareLayout.setOnClickListener(this.mTitleClickListener);
        ImageView imageView = (ImageView) findViewById(R$id.iv_share);
        this.mShareImage = imageView;
        imageView.setVisibility(8);
        this.mShareImage.setOnClickListener(this.mTitleClickListener);
        this.mTvTitle = (TextView) findViewById(R$id.tv_title);
        ImageView imageView2 = (ImageView) findViewById(R$id.tv_collect_tip);
        this.mCollectTipIcon = imageView2;
        imageView2.setVisibility(8);
        findViewById(R$id.btn_left).setOnClickListener(this.mTitleClickListener);
    }

    private void loadShareData(String str, String str2, DetailedBean detailedBean) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1588561982")) {
            ipChange.ipc$dispatch("1588561982", new Object[]{this, str, str2, detailedBean});
        } else if (TextUtils.isEmpty(str2)) {
            updateShareLayout(str, detailedBean);
        } else {
            cn.damai.common.image.a.b().c(str2).n(new g(detailedBean, str)).e(new f(str, detailedBean)).f();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void openShare(DetailedBean detailedBean) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-990238428")) {
            ipChange.ipc$dispatch("-990238428", new Object[]{this, detailedBean});
        } else if (detailedBean == null) {
        } else {
            Bundle bundle = new Bundle();
            bundle.putString("imageUrl", detailedBean.bgPic);
            bundle.putString("uniqueIdent", this.mDetailId);
            bundle.putString("projectName", detailedBean.subTitle);
            bundle.putString("mainMessage", detailedBean.subTitle);
            bundle.putString("channel", "2");
            bundle.putString("subMessage", detailedBean.title);
            bundle.putString("producturl", detailedBean.shareUrl);
            bundle.putString("fromWhere", "");
            bundle.putString("sceneType", "1");
            DMNav.from(this).withExtras(bundle).toUri(NavUri.b("fissionshare"));
        }
    }

    private void requestData(boolean z) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1783998575")) {
            ipChange.ipc$dispatch("-1783998575", new Object[]{this, Boolean.valueOf(z)});
            return;
        }
        if (z) {
            startProgressDialog();
        }
        cancelCountDown();
        this.mViewModel.getDetailedListData().observe(this, new Observer<DetailedBeanResponse>() { // from class: cn.damai.category.inventory.ui.DetailedActivity.2
            private static transient /* synthetic */ IpChange $ipChange;

            @Override // androidx.lifecycle.Observer
            public void onChanged(@Nullable DetailedBeanResponse detailedBeanResponse) {
                IpChange ipChange2 = $ipChange;
                if (AndroidInstantRuntime.support(ipChange2, "-1388495343")) {
                    ipChange2.ipc$dispatch("-1388495343", new Object[]{this, detailedBeanResponse});
                    return;
                }
                DetailedActivity.this.stopProgressDialog();
                if (detailedBeanResponse == null) {
                    return;
                }
                if (detailedBeanResponse.requestSuccess) {
                    DetailedActivity.this.returnDetailedSuccess();
                    DetailedActivity.this.returnDetailedData(detailedBeanResponse.detailedBean);
                    return;
                }
                DetailedActivity.this.returnDetailedFail(detailedBeanResponse.errorMsg, detailedBeanResponse.errorCode);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void returnDetailedData(DetailedBean detailedBean) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-495808345")) {
            ipChange.ipc$dispatch("-495808345", new Object[]{this, detailedBean});
        } else if (detailedBean != null) {
            int e2 = wh2.e(detailedBean.topItems);
            int e3 = wh2.e(detailedBean.items);
            if (e2 <= 0 && e3 <= 0) {
                returnDetailedEmpty();
                return;
            }
            this.mDetailTitle = detailedBean.title;
            this.mTitleLayout.setBackgroundColor(ContextCompat.getColor(this, R$color.transparent));
            loadShareData(detailedBean.shareUrl, detailedBean.shareIcon, detailedBean);
            this.mFansLayout.setVisibility(0);
            updateFansData(detailedBean.isFollow());
            visCollectTip();
            this.mDataHolderList.clear();
            if (e2 > 0) {
                DetailedDataHolder detailedDataHolder = new DetailedDataHolder();
                detailedDataHolder.mType = 2;
                detailedDataHolder.topItems = detailedBean.topItems;
                this.mDataHolderList.add(detailedDataHolder);
            }
            for (int i = 0; i < e3; i++) {
                DetailedDataHolder detailedDataHolder2 = new DetailedDataHolder();
                detailedDataHolder2.mType = 0;
                detailedDataHolder2.itemsBean = detailedBean.items.get(i);
                this.mDataHolderList.add(detailedDataHolder2);
            }
            DetailedDataHolder detailedDataHolder3 = new DetailedDataHolder();
            detailedDataHolder3.mType = 1;
            this.mDataHolderList.add(detailedDataHolder3);
            DetailedAdapter detailedAdapter = this.mAdapter;
            if (detailedAdapter != null) {
                detailedAdapter.b(this.mDetailTitle, this.mDetailId, e2);
                this.mAdapter.notifyDataSetChanged();
            }
            updateDetailedHeaderData(detailedBean.subTitle, detailedBean.title, detailedBean.bgPic);
        }
    }

    public static int setAlphaColor(@FloatRange(from = 0.0d, to = 1.0d) float f2, int i) {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "-1960050357") ? ((Integer) ipChange.ipc$dispatch("-1960050357", new Object[]{Float.valueOf(f2), Integer.valueOf(i)})).intValue() : Color.argb(Math.round(f2 * 255.0f), (16711680 & i) >> 16, (65280 & i) >> 8, i & 255);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setTopImageBackground(int[] iArr) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1570050220")) {
            ipChange.ipc$dispatch("-1570050220", new Object[]{this, iArr});
        } else if (iArr.length != 2) {
        } else {
            this.mIvImageShape.setBackgroundDrawable(new GradientDrawable(GradientDrawable.Orientation.TOP_BOTTOM, iArr));
        }
    }

    private void startTime() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "117194285")) {
            ipChange.ipc$dispatch("117194285", new Object[]{this});
            return;
        }
        cancelCountDown();
        if (this.mTimeCountDown == null) {
            this.mTimeCountDown = new a(3000L, 3000L);
        }
        this.mTimeCountDown.start();
    }

    private void updateDetailedHeaderData(String str, String str2, String str3) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-109663940")) {
            ipChange.ipc$dispatch("-109663940", new Object[]{this, str, str2, str3});
            return;
        }
        this.mTvDetailedTitle.setText(str2);
        this.mTvSubHeaderTitle.setText(str);
        cn.damai.common.image.a.b().e(str3).n(new d(str3)).e(new c()).f();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void updateFansData(boolean z) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1212035559")) {
            ipChange.ipc$dispatch("-1212035559", new Object[]{this, Boolean.valueOf(z)});
            return;
        }
        this.mFansLayout.setTag(Boolean.valueOf(z));
        if (z) {
            this.mFansIcon.setVisibility(8);
            this.mTvFans.setText("已想看");
            this.mTvFans.setTextColor(getResources().getColor(R$color.mask_white_60));
            this.mFansLayout.setBackgroundResource(R$drawable.attention_btn_followed_normal);
            return;
        }
        this.mFansIcon.setVisibility(0);
        this.mTvFans.setText("想看");
        this.mTvFans.setTextColor(getResources().getColor(R$color.white));
        this.mFansLayout.setBackgroundResource(R$drawable.attention_btn_followed_normal);
    }

    private void updateImageShapeHeight() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1739575544")) {
            ipChange.ipc$dispatch("1739575544", new Object[]{this});
            return;
        }
        FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) this.mIvProjectImage.getLayoutParams();
        layoutParams.height = this.imageShapeHeight;
        this.mIvProjectImage.setLayoutParams(layoutParams);
        FrameLayout.LayoutParams layoutParams2 = (FrameLayout.LayoutParams) this.mIvImageShape.getLayoutParams();
        layoutParams2.height = this.imageShapeHeight;
        this.mIvImageShape.setLayoutParams(layoutParams2);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void updateShareLayout(String str, DetailedBean detailedBean) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1600210171")) {
            ipChange.ipc$dispatch("-1600210171", new Object[]{this, str, detailedBean});
            return;
        }
        this.mShareImage.setVisibility(8);
        if (TextUtils.isEmpty(str)) {
            this.mShareLayout.setVisibility(8);
            return;
        }
        this.mShareLayout.setVisibility(0);
        this.mShareLayout.setTag(detailedBean);
    }

    private void visCollectTip() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1377719701")) {
            ipChange.ipc$dispatch("-1377719701", new Object[]{this});
        } else if (z20.L()) {
        } else {
            z20.u0();
            FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) this.mCollectTipIcon.getLayoutParams();
            layoutParams.topMargin = this.mTitleMinHeight - m62.a(this.mContext, 8.0f);
            this.mCollectTipIcon.setLayoutParams(layoutParams);
            this.mCollectTipIcon.setVisibility(0);
            startTime();
        }
    }

    public void cancelCountDown() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1133844805")) {
            ipChange.ipc$dispatch("1133844805", new Object[]{this});
            return;
        }
        CountDownTimer countDownTimer = this.mTimeCountDown;
        if (countDownTimer != null) {
            countDownTimer.cancel();
            this.mTimeCountDown = null;
        }
    }

    @Override // cn.damai.common.app.base.BaseActivity
    public int getLayoutId() {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "-1619214380") ? ((Integer) ipChange.ipc$dispatch("-1619214380", new Object[]{this})).intValue() : R$layout.inventory_activity;
    }

    @Override // cn.damai.commonbusiness.base.SimpleBaseActivity, cn.damai.commonbusiness.base.ResponseErrorPage.ErrorRefreshListener
    public void handleError(int i) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-518036953")) {
            ipChange.ipc$dispatch("-518036953", new Object[]{this, Integer.valueOf(i)});
        } else {
            requestData(true);
        }
    }

    @Override // cn.damai.commonbusiness.base.SimpleBaseActivity, cn.damai.common.app.base.BaseActivity
    public void initView() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1777502407")) {
            ipChange.ipc$dispatch("-1777502407", new Object[]{this});
            return;
        }
        hideBaseLayout();
        this.mRootLayout = (CoordinatorLayout) findViewById(R$id.ll_container);
        this.mIvProjectImage = (ImageView) findViewById(R$id.iv_image);
        this.mIvImageShape = findViewById(R$id.iv_image_shape);
        this.mToolbarLayout = (CollapsingToolbarLayout) findViewById(R$id.toolbar);
        this.mParHeadBar = (LinearLayout) findViewById(R$id.head_bar);
        this.mTitleLayout = (LinearLayout) findViewById(R$id.nav_bar);
        initTitleBar();
        initStateBar(findViewById(R$id.status_bar), true);
        initIRecycleView();
        initHeadView();
        initErrorView();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // cn.damai.commonbusiness.base.DamaiBaseActivity, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, android.app.Activity
    public void onActivityResult(int i, int i2, Intent intent) {
        DetailedModel detailedModel;
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1278279904")) {
            ipChange.ipc$dispatch("1278279904", new Object[]{this, Integer.valueOf(i), Integer.valueOf(i2), intent});
            return;
        }
        super.onActivityResult(i, i2, intent);
        ShareManager.E().r0(i, i2, intent);
        if (i == 1010 && LoginManager.k().q() && (detailedModel = this.mViewModel) != null) {
            detailedModel.getAttentionState(this.loginIsFollow);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // cn.damai.commonbusiness.base.DamaiBaseActivity, cn.damai.common.app.base.BaseActivity, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    public void onCreate(@Nullable Bundle bundle) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1406936161")) {
            ipChange.ipc$dispatch("1406936161", new Object[]{this, bundle});
            return;
        }
        super.onCreate(bundle);
        DetailedModel detailedModel = (DetailedModel) ViewModelProviders.of(this).get(DetailedModel.class);
        this.mViewModel = detailedModel;
        detailedModel.initParam(getIntent());
        this.mDetailId = this.mViewModel.getDetailedId();
        this.mViewModel.getFollowLiveData().observe(this, this.followChangeObserver);
        setDamaiUTKeyBuilder(u70.g().f(this.mDetailId));
        requestData(true);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // cn.damai.commonbusiness.base.DamaiBaseActivity, cn.damai.common.app.base.BaseActivity, androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onDestroy() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "2071274465")) {
            ipChange.ipc$dispatch("2071274465", new Object[]{this});
            return;
        }
        super.onDestroy();
        cancelCountDown();
    }

    public void returnDetailedEmpty() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1200541647")) {
            ipChange.ipc$dispatch("1200541647", new Object[]{this});
            return;
        }
        this.mRootLayout.setVisibility(8);
        this.mErrorLayout.setVisibility(0);
        onResponseError(3, "暂时没有演出，一会再来吧", "0", "mtop.damai.wireless.search.detailedlist.get", findViewById(R$id.ll_error_page), true);
    }

    public void returnDetailedFail(String str, String str2) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "910325508")) {
            ipChange.ipc$dispatch("910325508", new Object[]{this, str, str2});
            return;
        }
        this.mRootLayout.setVisibility(8);
        this.mErrorLayout.setVisibility(0);
        onResponseError(str2, str, "mtop.damai.wireless.search.detailedlist.get", findViewById(R$id.ll_error_page), true);
    }

    public void returnDetailedSuccess() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1247183975")) {
            ipChange.ipc$dispatch("-1247183975", new Object[]{this});
            return;
        }
        this.mRootLayout.setVisibility(0);
        this.mErrorLayout.setVisibility(8);
        onResponseSuccess(findViewById(R$id.ll_error_page));
    }

    @Override // cn.damai.common.app.base.BaseActivity
    protected String setTitle() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "623403848")) {
            return (String) ipChange.ipc$dispatch("623403848", new Object[]{this});
        }
        return null;
    }

    public void updateDetailedBg(String str, Bitmap bitmap) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-230141196")) {
            ipChange.ipc$dispatch("-230141196", new Object[]{this, str, bitmap});
        } else if (bitmap != null) {
            DMRGBUtil.h(bitmap, str, new e());
        } else {
            defaultTopBackground();
        }
    }
}
