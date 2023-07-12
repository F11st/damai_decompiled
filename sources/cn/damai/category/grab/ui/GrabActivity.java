package cn.damai.category.grab.ui;

import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import android.text.TextUtils;
import android.view.View;
import android.widget.LinearLayout;
import androidx.annotation.Nullable;
import androidx.lifecycle.Observer;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import cn.damai.category.common.listener.ShareImageCallback;
import cn.damai.category.grab.bean.GrabBean;
import cn.damai.category.grab.bean.ItemBean;
import cn.damai.category.grab.bean.ItemGroup;
import cn.damai.category.grab.model.GrabModel;
import cn.damai.category.grab.request.GrabRequest;
import cn.damai.category.grab.ui.adapter.GrabListAdapter;
import cn.damai.common.user.C0529c;
import cn.damai.commonbusiness.base.ResponseErrorPage;
import cn.damai.commonbusiness.base.SimpleBaseActivity;
import cn.damai.commonbusiness.share.ShareManager;
import cn.damai.commonbusiness.share.generateimage.GenerateImageUtil;
import cn.damai.homepage.R$color;
import cn.damai.homepage.R$id;
import cn.damai.homepage.R$layout;
import cn.damai.issue.tool.IssueConstants;
import cn.damai.uikit.irecycler.widget.WrapLinearLayoutManager;
import cn.damai.uikit.snake.HorScrollView;
import cn.damai.uikit.snake.ScrollTitleBean;
import cn.damai.uikit.view.LinearPullToRefreshView;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import com.google.android.material.appbar.AppBarLayout;
import java.util.ArrayList;
import java.util.List;
import tb.bp2;
import tb.kg2;
import tb.ou0;
import tb.qd2;
import tb.wh2;
import tb.z20;

/* compiled from: Taobao */
/* loaded from: classes.dex */
public class GrabActivity extends SimpleBaseActivity {
    private static transient /* synthetic */ IpChange $ipChange = null;
    private static final String KEY_TOPPROJECTID = "topProjectId";
    public static final int TYPE_SELLING = 3;
    public static final int TYPE_TODAY = 1;
    public static final int TYPE_TOSELL = 2;
    public static int second;
    private GrabListAdapter mAdapter;
    private AppBarLayout mAppBarLayout;
    private String mFirstProjectId;
    private Handler mHandler;
    private HorScrollView mHorScrollView;
    private View mItemTopView;
    private View mLineView;
    private GrabModel mModel;
    private LinearLayoutManager mRecyclerManager;
    private RecyclerView mRecyclerView;
    private LinearPullToRefreshView mRefreshView;
    private View mShareBtn;
    private String mShareImageUrl;
    private String mShareLocalImageUrl;
    private String mShareUrl;
    private LinearLayout mTop;
    private ItemBean mTopItemBean;
    private String mTopProjectId;
    private bp2 mTopView;
    private LinearLayout mView;
    private GrabRequest mGrabRequest = new GrabRequest();
    private int mFenjiexianIndex = 0;
    private boolean mHasTop = false;
    private int mTitleIndex = 0;
    private View.OnClickListener mProjectItemListener = new View$OnClickListenerC0406j();
    private Runnable mRunnable = new Runnable() { // from class: cn.damai.category.grab.ui.GrabActivity.13
        private static transient /* synthetic */ IpChange $ipChange;

        @Override // java.lang.Runnable
        public void run() {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "711866533")) {
                ipChange.ipc$dispatch("711866533", new Object[]{this});
            } else if (GrabActivity.this.mHandler != null) {
                GrabActivity.this.mHandler.postDelayed(this, 1000L);
                GrabActivity.second++;
                if (GrabActivity.this.mHasTop) {
                    GrabActivity.this.mTopView.g(GrabActivity.this.mTopItemBean);
                }
                GrabActivity.this.mAdapter.notifyDataSetChanged();
            }
        }
    };

    /* compiled from: Taobao */
    /* renamed from: cn.damai.category.grab.ui.GrabActivity$a */
    /* loaded from: classes.dex */
    public class C0397a implements AppBarLayout.OnOffsetChangedListener {
        private static transient /* synthetic */ IpChange $ipChange;

        C0397a() {
        }

        @Override // com.google.android.material.appbar.AppBarLayout.OnOffsetChangedListener, com.google.android.material.appbar.AppBarLayout.BaseOnOffsetChangedListener
        public void onOffsetChanged(AppBarLayout appBarLayout, int i) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "1901161740")) {
                ipChange.ipc$dispatch("1901161740", new Object[]{this, appBarLayout, Integer.valueOf(i)});
            } else if (i < 0) {
                GrabActivity.this.mRefreshView.setPullToRefreshEnabled(false);
            } else {
                GrabActivity.this.mRefreshView.setPullToRefreshEnabled(true);
            }
        }
    }

    /* compiled from: Taobao */
    /* renamed from: cn.damai.category.grab.ui.GrabActivity$b */
    /* loaded from: classes.dex */
    public class View$OnClickListenerC0398b implements View.OnClickListener {
        private static transient /* synthetic */ IpChange $ipChange;

        View$OnClickListenerC0398b() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "742231913")) {
                ipChange.ipc$dispatch("742231913", new Object[]{this, view});
                return;
            }
            GrabActivity.this.mAppBarLayout.setExpanded(false, true);
            ScrollTitleBean scrollTitleBean = (ScrollTitleBean) view.getTag();
            if (scrollTitleBean != null) {
                if (scrollTitleBean.index == 0) {
                    GrabActivity.this.mTitleIndex = 0;
                    GrabActivity.this.mRecyclerManager.scrollToPositionWithOffset(0, 0);
                    return;
                }
                GrabActivity.this.mTitleIndex = 1;
                GrabActivity.this.mRecyclerManager.scrollToPositionWithOffset(GrabActivity.this.mFenjiexianIndex, 0);
            }
        }
    }

    /* compiled from: Taobao */
    /* renamed from: cn.damai.category.grab.ui.GrabActivity$c */
    /* loaded from: classes.dex */
    public class C0399c implements ResponseErrorPage.ErrorRefreshListener {
        private static transient /* synthetic */ IpChange $ipChange;

        C0399c() {
        }

        @Override // cn.damai.commonbusiness.base.ResponseErrorPage.ErrorRefreshListener
        public void handleError(int i) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "2079869812")) {
                ipChange.ipc$dispatch("2079869812", new Object[]{this, Integer.valueOf(i)});
            } else {
                GrabActivity.this.mModel.grabRequest(GrabActivity.this.mGrabRequest);
            }
        }
    }

    /* compiled from: Taobao */
    /* renamed from: cn.damai.category.grab.ui.GrabActivity$d */
    /* loaded from: classes.dex */
    public class View$OnClickListenerC0400d implements View.OnClickListener {
        private static transient /* synthetic */ IpChange $ipChange;

        View$OnClickListenerC0400d() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "-916858756")) {
                ipChange.ipc$dispatch("-916858756", new Object[]{this, view});
            } else {
                GrabActivity.this.finish();
            }
        }
    }

    /* compiled from: Taobao */
    /* renamed from: cn.damai.category.grab.ui.GrabActivity$e */
    /* loaded from: classes.dex */
    public class View$OnClickListenerC0401e implements View.OnClickListener {
        private static transient /* synthetic */ IpChange $ipChange;

        View$OnClickListenerC0401e() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "1194431613")) {
                ipChange.ipc$dispatch("1194431613", new Object[]{this, view});
                return;
            }
            C0529c.e().x(ou0.g().i(z20.E(), z20.d()));
            Bundle bundle = new Bundle();
            bundle.putString("title", "来抢票播报站，发现火热演出");
            bundle.putString("projectName", "来抢票播报站，发现火热演出");
            bundle.putString("message", "精彩演出都在这儿");
            if (!TextUtils.isEmpty(GrabActivity.this.mShareImageUrl)) {
                bundle.putString("imageurl", GrabActivity.this.mShareImageUrl);
                bundle.putString("projectImage", GrabActivity.this.mShareImageUrl);
            }
            if (!TextUtils.isEmpty(GrabActivity.this.mShareLocalImageUrl)) {
                bundle.putString("sinaSharePath", GrabActivity.this.mShareLocalImageUrl);
            }
            bundle.putString("producturl", GrabActivity.this.mShareUrl);
            bundle.putBoolean("showGenerateImage", true);
            bundle.putString("shareType", "chat_h5");
            bundle.putString("shareImageStyle", GenerateImageUtil.STYLE_GENERATE_RANKING_IMAGE);
            ShareManager.E().O(GrabActivity.this, bundle, R$layout.ranking_activity);
        }
    }

    /* compiled from: Taobao */
    /* renamed from: cn.damai.category.grab.ui.GrabActivity$f */
    /* loaded from: classes.dex */
    public class C0402f implements ShareImageCallback {
        private static transient /* synthetic */ IpChange $ipChange;

        C0402f() {
        }

        @Override // cn.damai.category.common.listener.ShareImageCallback
        public void callback(String str, String str2) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "-60968132")) {
                ipChange.ipc$dispatch("-60968132", new Object[]{this, str, str2});
                return;
            }
            GrabActivity.this.mShareImageUrl = str;
            GrabActivity.this.mShareLocalImageUrl = str2;
        }
    }

    /* compiled from: Taobao */
    /* renamed from: cn.damai.category.grab.ui.GrabActivity$g */
    /* loaded from: classes.dex */
    public class View$OnClickListenerC0403g implements View.OnClickListener {
        private static transient /* synthetic */ IpChange $ipChange;

        View$OnClickListenerC0403g() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "1122045055")) {
                ipChange.ipc$dispatch("1122045055", new Object[]{this, view});
                return;
            }
            ItemBean itemBean = GrabActivity.this.mTopView.E;
            if (itemBean != null) {
                GrabActivity.this.goProject(itemBean);
                C0529c.e().x(ou0.g().h(itemBean.groupIndex, itemBean.index, z20.d(), itemBean.groupTitle, itemBean.itemId));
            }
        }
    }

    /* compiled from: Taobao */
    /* renamed from: cn.damai.category.grab.ui.GrabActivity$h */
    /* loaded from: classes.dex */
    public class C0404h implements LinearPullToRefreshView.OnRefreshListener {
        private static transient /* synthetic */ IpChange $ipChange;

        C0404h() {
        }

        @Override // cn.damai.uikit.view.LinearPullToRefreshView.OnRefreshListener
        public void onRefresh() {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "-1941832801")) {
                ipChange.ipc$dispatch("-1941832801", new Object[]{this});
            } else {
                GrabActivity.this.mModel.grabRequest(GrabActivity.this.mGrabRequest);
            }
        }
    }

    /* compiled from: Taobao */
    /* renamed from: cn.damai.category.grab.ui.GrabActivity$i */
    /* loaded from: classes.dex */
    public class C0405i implements ShareImageCallback {
        private static transient /* synthetic */ IpChange $ipChange;

        C0405i() {
        }

        @Override // cn.damai.category.common.listener.ShareImageCallback
        public void callback(String str, String str2) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "-956363649")) {
                ipChange.ipc$dispatch("-956363649", new Object[]{this, str, str2});
            } else if (GrabActivity.this.mHasTop) {
            } else {
                GrabActivity.this.mShareImageUrl = str;
                GrabActivity.this.mShareLocalImageUrl = str2;
            }
        }
    }

    /* compiled from: Taobao */
    /* renamed from: cn.damai.category.grab.ui.GrabActivity$j */
    /* loaded from: classes.dex */
    public class View$OnClickListenerC0406j implements View.OnClickListener {
        private static transient /* synthetic */ IpChange $ipChange;

        View$OnClickListenerC0406j() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "977271939")) {
                ipChange.ipc$dispatch("977271939", new Object[]{this, view});
                return;
            }
            try {
                ItemBean itemBean = (ItemBean) view.getTag();
                if (itemBean == null || TextUtils.isEmpty(itemBean.itemId)) {
                    return;
                }
                C0529c.e().x(ou0.g().h(itemBean.groupIndex, itemBean.index, z20.d(), itemBean.groupTitle, itemBean.itemId));
                GrabActivity.this.goProject(itemBean);
            } catch (Exception unused) {
            }
        }
    }

    private List<ItemBean> getItemList(List<ItemGroup> list) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "2070419185")) {
            return (List) ipChange.ipc$dispatch("2070419185", new Object[]{this, list});
        }
        ArrayList arrayList = new ArrayList();
        for (int i = 0; i < list.size(); i++) {
            ItemGroup itemGroup = list.get(i);
            if (wh2.e(itemGroup.items) > 0) {
                if (i == 0) {
                    this.mFenjiexianIndex = itemGroup.items.size() + 1;
                }
                ItemBean itemBean = new ItemBean();
                itemBean.groupType = 1;
                itemBean.groupTitle = itemGroup.title;
                itemBean.groupTip = itemGroup.tip;
                arrayList.add(itemBean);
                for (int i2 = 0; i2 < itemGroup.items.size(); i2++) {
                    ItemBean itemBean2 = itemGroup.items.get(i2);
                    if (itemBean2 != null) {
                        itemBean2.index = i2;
                        itemBean2.group = itemGroup.type;
                        itemBean2.groupTitle = itemGroup.title;
                        if (this.mHasTop) {
                            itemBean2.groupIndex = i + 1;
                        } else {
                            itemBean2.groupIndex = i;
                        }
                        arrayList.add(itemBean2);
                    }
                }
            }
        }
        ItemBean itemBean3 = new ItemBean();
        itemBean3.groupType = 2;
        arrayList.add(itemBean3);
        return arrayList;
    }

    private List<ScrollTitleBean> getTitleList(ItemGroup itemGroup, ItemGroup itemGroup2) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1574998455")) {
            return (List) ipChange.ipc$dispatch("-1574998455", new Object[]{this, itemGroup, itemGroup2});
        }
        if (itemGroup == null || itemGroup2 == null) {
            return null;
        }
        ArrayList arrayList = new ArrayList();
        ScrollTitleBean scrollTitleBean = new ScrollTitleBean();
        scrollTitleBean.id = "0";
        scrollTitleBean.index = 0;
        scrollTitleBean.name = itemGroup.title;
        ScrollTitleBean scrollTitleBean2 = new ScrollTitleBean();
        scrollTitleBean2.id = "1";
        scrollTitleBean2.index = 1;
        scrollTitleBean2.name = itemGroup2.title;
        arrayList.add(scrollTitleBean);
        arrayList.add(scrollTitleBean2);
        return arrayList;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void goProject(ItemBean itemBean) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-724328907")) {
            ipChange.ipc$dispatch("-724328907", new Object[]{this, itemBean});
        } else if (itemBean == null) {
        } else {
            Bundle bundle = new Bundle();
            bundle.putString(IssueConstants.ProjectID, itemBean.itemId);
            bundle.putString("projectName", itemBean.name);
            bundle.putString("projectImage", itemBean.verticalPic);
            qd2.a(this, itemBean.schema, bundle);
        }
    }

    private void initBundle() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-670292404")) {
            ipChange.ipc$dispatch("-670292404", new Object[]{this});
            return;
        }
        Intent intent = getIntent();
        Bundle bundle = null;
        if (intent != null) {
            try {
                bundle = intent.getExtras();
            } catch (Exception unused) {
            }
        }
        if (bundle != null) {
            this.mTopProjectId = bundle.getString(KEY_TOPPROJECTID, "0");
        }
    }

    private void initData() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "2051803236")) {
            ipChange.ipc$dispatch("2051803236", new Object[]{this});
            return;
        }
        this.mModel = new GrabModel(this);
        if (this.mGrabRequest == null) {
            this.mGrabRequest = new GrabRequest();
        }
        this.mGrabRequest.topProjectId = this.mTopProjectId;
        startProgressDialog();
        this.mModel.grabRequest(this.mGrabRequest);
        this.mModel.getGrabBean().observe(this, new Observer<GrabBean>() { // from class: cn.damai.category.grab.ui.GrabActivity.9
            private static transient /* synthetic */ IpChange $ipChange;

            @Override // androidx.lifecycle.Observer
            public void onChanged(@Nullable GrabBean grabBean) {
                IpChange ipChange2 = $ipChange;
                if (AndroidInstantRuntime.support(ipChange2, "911156835")) {
                    ipChange2.ipc$dispatch("911156835", new Object[]{this, grabBean});
                    return;
                }
                GrabActivity.this.stopProgressDialog();
                if (GrabActivity.this.mRefreshView != null) {
                    GrabActivity.this.mRefreshView.onRefreshComplete();
                }
                if (grabBean != null && wh2.e(grabBean.modules) != 0) {
                    GrabActivity.this.onResponseSuccess();
                    if (!TextUtils.isEmpty(grabBean.shareUrl)) {
                        GrabActivity.this.mShareBtn.setVisibility(0);
                        GrabActivity.this.mShareUrl = grabBean.shareUrl;
                    }
                    GrabActivity.this.updateView(grabBean);
                    GrabActivity.this.startTimer();
                    return;
                }
                GrabActivity.this.onResponseError("", "", "");
            }
        });
    }

    private void initGrab() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "888525442")) {
            ipChange.ipc$dispatch("888525442", new Object[]{this});
            return;
        }
        LinearPullToRefreshView linearPullToRefreshView = (LinearPullToRefreshView) findViewById(R$id.layout_pulltorefresh);
        this.mRefreshView = linearPullToRefreshView;
        linearPullToRefreshView.setPullToRefreshEnabled(true);
        this.mAppBarLayout = (AppBarLayout) findViewById(R$id.appbar_layout);
        this.mRefreshView.setOnRefreshListener(new C0404h());
        this.mHorScrollView = (HorScrollView) findViewById(R$id.view_group);
        this.mLineView = findViewById(R$id.view_divider);
        RecyclerView recyclerView = (RecyclerView) findViewById(R$id.irc);
        this.mRecyclerView = recyclerView;
        recyclerView.setLayoutManager(new WrapLinearLayoutManager(this));
        this.mRecyclerManager = (LinearLayoutManager) this.mRecyclerView.getLayoutManager();
        GrabListAdapter grabListAdapter = new GrabListAdapter(this, this.mProjectItemListener);
        this.mAdapter = grabListAdapter;
        grabListAdapter.b(new C0405i());
        this.mRecyclerView.setAdapter(this.mAdapter);
        this.mRecyclerView.addOnScrollListener(new RecyclerView.OnScrollListener() { // from class: cn.damai.category.grab.ui.GrabActivity.7
            private static transient /* synthetic */ IpChange $ipChange;

            @Override // androidx.recyclerview.widget.RecyclerView.OnScrollListener
            public void onScrolled(RecyclerView recyclerView2, int i, int i2) {
                IpChange ipChange2 = $ipChange;
                if (AndroidInstantRuntime.support(ipChange2, "-837973679")) {
                    ipChange2.ipc$dispatch("-837973679", new Object[]{this, recyclerView2, Integer.valueOf(i), Integer.valueOf(i2)});
                    return;
                }
                int findFirstVisibleItemPosition = ((LinearLayoutManager) recyclerView2.getLayoutManager()).findFirstVisibleItemPosition();
                if (i2 >= 0) {
                    if (findFirstVisibleItemPosition == GrabActivity.this.mFenjiexianIndex) {
                        GrabActivity.this.mHorScrollView.selectTitle(1);
                        GrabActivity.this.mTitleIndex = 1;
                    }
                } else if (findFirstVisibleItemPosition <= GrabActivity.this.mFenjiexianIndex - 1 && GrabActivity.this.mTitleIndex == 1) {
                    GrabActivity.this.mHorScrollView.selectTitle(0);
                    GrabActivity.this.mTitleIndex = 0;
                }
                if (GrabActivity.this.mHasTop) {
                    return;
                }
                if (GrabActivity.this.mRecyclerManager.findFirstCompletelyVisibleItemPosition() == 0) {
                    GrabActivity.this.mRefreshView.setPullToRefreshEnabled(true);
                } else {
                    GrabActivity.this.mRefreshView.setPullToRefreshEnabled(false);
                }
            }
        });
    }

    private void initTitle() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-181378972")) {
            ipChange.ipc$dispatch("-181378972", new Object[]{this});
            return;
        }
        this.mView = (LinearLayout) findViewById(R$id.layout_grab);
        removeHeadTitleView();
        findViewById(R$id.btn_left).setOnClickListener(new View$OnClickListenerC0400d());
        View findViewById = findViewById(R$id.btn_right);
        this.mShareBtn = findViewById;
        findViewById.setOnClickListener(new View$OnClickListenerC0401e());
        View findViewById2 = findViewById(R$id.status_bar_space);
        if (Build.VERSION.SDK_INT >= 23) {
            findViewById2.getLayoutParams().height = kg2.a(this);
            findViewById2.setVisibility(0);
            kg2.f(this, true, R$color.black);
            kg2.d(true, this);
            return;
        }
        kg2.f(this, false, R$color.black);
        findViewById2.setVisibility(8);
    }

    private void initTop() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "121367047")) {
            ipChange.ipc$dispatch("121367047", new Object[]{this});
            return;
        }
        LinearLayout linearLayout = (LinearLayout) findViewById(R$id.grab_top);
        this.mTop = linearLayout;
        this.mTopView = new bp2(this, linearLayout, new C0402f());
        View findViewById = findViewById(R$id.item_top);
        this.mItemTopView = findViewById;
        findViewById.setOnClickListener(new View$OnClickListenerC0403g());
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Removed duplicated region for block: B:41:0x00c6  */
    /* JADX WARN: Removed duplicated region for block: B:42:0x00fb  */
    /* JADX WARN: Removed duplicated region for block: B:50:0x014c  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public void updateView(cn.damai.category.grab.bean.GrabBean r8) {
        /*
            Method dump skipped, instructions count: 364
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: cn.damai.category.grab.ui.GrabActivity.updateView(cn.damai.category.grab.bean.GrabBean):void");
    }

    @Override // cn.damai.common.app.base.BaseActivity
    public int getLayoutId() {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "-245301884") ? ((Integer) ipChange.ipc$dispatch("-245301884", new Object[]{this})).intValue() : R$layout.grab_activity;
    }

    @Override // cn.damai.commonbusiness.base.SimpleBaseActivity, cn.damai.common.app.base.BaseActivity
    public void initView() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1062836105")) {
            ipChange.ipc$dispatch("1062836105", new Object[]{this});
            return;
        }
        super.initView();
        initBundle();
        setDamaiUTKeyBuilder(ou0.g().f(this.mTopProjectId));
        C0529c.e().K(this);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // cn.damai.commonbusiness.base.DamaiBaseActivity, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, android.app.Activity
    public void onActivityResult(int i, int i2, Intent intent) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-567210704")) {
            ipChange.ipc$dispatch("-567210704", new Object[]{this, Integer.valueOf(i), Integer.valueOf(i2), intent});
            return;
        }
        super.onActivityResult(i, i2, intent);
        ShareManager.E().r0(i, i2, intent);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // cn.damai.commonbusiness.base.DamaiBaseActivity, cn.damai.common.app.base.BaseActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onPause() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-412871787")) {
            ipChange.ipc$dispatch("-412871787", new Object[]{this});
            return;
        }
        super.onPause();
        stopTimer();
    }

    protected void onResponseError(String str, String str2, String str3) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-256268670")) {
            ipChange.ipc$dispatch("-256268670", new Object[]{this, str, str2, str3});
            return;
        }
        ResponseErrorPage responseErrorPage = this.mErrorPage;
        if (responseErrorPage == null || (!responseErrorPage.isShown() && this.mErrorPage.getParent() == null)) {
            ResponseErrorPage responseErrorPage2 = new ResponseErrorPage(this, str, str2, str3);
            this.mErrorPage = responseErrorPage2;
            responseErrorPage2.hideTitle();
            this.mErrorPage.setRefreshListener(new C0399c());
            this.mView.addView(this.mErrorPage, new LinearLayout.LayoutParams(-1, -1));
            this.mRefreshView.setVisibility(8);
        }
    }

    public void onResponseSuccess() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-533847543")) {
            ipChange.ipc$dispatch("-533847543", new Object[]{this});
            return;
        }
        try {
            ResponseErrorPage responseErrorPage = this.mErrorPage;
            if (responseErrorPage != null) {
                responseErrorPage.setVisibility(8);
                this.mView.removeView(this.mErrorPage);
                this.mErrorPage = null;
            }
            this.mRefreshView.setVisibility(0);
        } catch (Exception unused) {
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // cn.damai.commonbusiness.base.DamaiBaseActivity, cn.damai.common.app.base.BaseActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onResume() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1733662994")) {
            ipChange.ipc$dispatch("1733662994", new Object[]{this});
            return;
        }
        super.onResume();
        initTitle();
        initTop();
        initGrab();
        initData();
    }

    @Override // cn.damai.common.app.base.BaseActivity
    protected String setTitle() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1731652856")) {
            return (String) ipChange.ipc$dispatch("1731652856", new Object[]{this});
        }
        return null;
    }

    public void startTimer() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1601334875")) {
            ipChange.ipc$dispatch("1601334875", new Object[]{this});
            return;
        }
        stopTimer();
        Handler handler = new Handler();
        this.mHandler = handler;
        handler.postDelayed(this.mRunnable, 0L);
    }

    public void stopTimer() {
        Runnable runnable;
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "466962761")) {
            ipChange.ipc$dispatch("466962761", new Object[]{this});
            return;
        }
        Handler handler = this.mHandler;
        if (handler == null || (runnable = this.mRunnable) == null) {
            return;
        }
        handler.removeCallbacks(runnable);
        this.mHandler = null;
        second = 0;
    }
}
