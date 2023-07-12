package com.alibaba.pictures.bricks.myorder.fragment;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.alibaba.fastjson.JSONObject;
import com.alibaba.pictures.R$id;
import com.alibaba.pictures.R$layout;
import com.alibaba.pictures.bricks.base.BricksBaseFragment;
import com.alibaba.pictures.bricks.myorder.bean.MyOrderListResp;
import com.alibaba.pictures.bricks.myorder.request.MyOrderListRequest;
import com.alibaba.pictures.bricks.util.toast.BricksToastUtil;
import com.alibaba.pictures.dolores.login.DoloresLoginHandler;
import com.alibaba.pictures.dolores.request.DoloresRequest;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import com.meizu.cloud.pushsdk.notification.model.AdvanceSetting;
import com.scwang.smartrefresh.layout.SmartRefreshLayout;
import com.scwang.smartrefresh.layout.api.RefreshLayout;
import com.scwang.smartrefresh.layout.listener.OnLoadMoreListener;
import com.scwang.smartrefresh.layout.listener.OnRefreshListener;
import com.youku.kubus.Event;
import com.youku.kubus.EventBus;
import com.youku.kubus.Subscribe;
import kotlin.C8177b;
import kotlin.Lazy;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import tb.b41;
import tb.cc0;
import tb.dc0;
import tb.k50;
import tb.wt2;
import tb.yb1;

/* compiled from: Taobao */
/* loaded from: classes7.dex */
public final class MyOrderListFragment extends BricksBaseFragment implements OnLoadMoreListener, OnRefreshListener {
    private static transient /* synthetic */ IpChange $ipChange = null;
    @NotNull
    public static final C3529a Companion = new C3529a(null);
    @NotNull
    public static final String KEY_PAGE_TYPE = "pageType";
    public static final int REQUEST_CODE_LOGIN = 10;
    public static final int VALUE_PAGE_TYPE_ALL = 0;
    public static final int VALUE_PAGE_TYPE_UNPAY = 2;
    public static final int VALUE_PAGE_TYPE_UNUSED = 1;
    @NotNull
    private final Lazy adapter$delegate;
    private ViewGroup errorContainer;
    private boolean isRefresh;
    private boolean needRefreshStateOnResume;
    private int pageNumber;
    private int pageType;
    private RecyclerView recyclerView;
    private SmartRefreshLayout refreshLayout;

    /* compiled from: Taobao */
    /* renamed from: com.alibaba.pictures.bricks.myorder.fragment.MyOrderListFragment$a */
    /* loaded from: classes7.dex */
    public static final class C3529a {
        private C3529a() {
        }

        public /* synthetic */ C3529a(k50 k50Var) {
            this();
        }
    }

    /* compiled from: Taobao */
    /* renamed from: com.alibaba.pictures.bricks.myorder.fragment.MyOrderListFragment$b */
    /* loaded from: classes7.dex */
    public static final class C3530b implements BricksBaseFragment.IClickListener {
        private static transient /* synthetic */ IpChange $ipChange;

        C3530b() {
        }

        @Override // com.alibaba.pictures.bricks.base.BricksBaseFragment.IClickListener
        public void handleClick(int i) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "1976779913")) {
                ipChange.ipc$dispatch("1976779913", new Object[]{this, Integer.valueOf(i)});
            } else {
                MyOrderListFragment.this.requestOrderList(true);
            }
        }
    }

    public MyOrderListFragment() {
        this(0, 1, null);
    }

    public MyOrderListFragment(int i) {
        Lazy b;
        this.pageType = i;
        this.pageNumber = 1;
        this.isRefresh = true;
        b = C8177b.b(new Function0<MyOrderListAdapter>() { // from class: com.alibaba.pictures.bricks.myorder.fragment.MyOrderListFragment$adapter$2
            private static transient /* synthetic */ IpChange $ipChange;

            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            @NotNull
            public final MyOrderListAdapter invoke() {
                IpChange ipChange = $ipChange;
                if (AndroidInstantRuntime.support(ipChange, "-479425140")) {
                    return (MyOrderListAdapter) ipChange.ipc$dispatch("-479425140", new Object[]{this});
                }
                Context context = MyOrderListFragment.this.getContext();
                b41.f(context);
                return new MyOrderListAdapter(context);
            }
        });
        this.adapter$delegate = b;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final MyOrderListAdapter getAdapter() {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "-523431726") ? (MyOrderListAdapter) ipChange.ipc$dispatch("-523431726", new Object[]{this}) : (MyOrderListAdapter) this.adapter$delegate.getValue();
    }

    private final void initView(View view) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1005666320")) {
            ipChange.ipc$dispatch("-1005666320", new Object[]{this, view});
            return;
        }
        View findViewById = view.findViewById(R$id.error_container);
        b41.h(findViewById, "root.findViewById(R.id.error_container)");
        this.errorContainer = (ViewGroup) findViewById;
        View findViewById2 = view.findViewById(R$id.recyclerView);
        b41.h(findViewById2, "root.findViewById(R.id.recyclerView)");
        RecyclerView recyclerView = (RecyclerView) findViewById2;
        this.recyclerView = recyclerView;
        RecyclerView recyclerView2 = null;
        if (recyclerView == null) {
            b41.A("recyclerView");
            recyclerView = null;
        }
        recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));
        View findViewById3 = view.findViewById(R$id.refresh_layout);
        b41.h(findViewById3, "root.findViewById(R.id.refresh_layout)");
        SmartRefreshLayout smartRefreshLayout = (SmartRefreshLayout) findViewById3;
        this.refreshLayout = smartRefreshLayout;
        if (smartRefreshLayout == null) {
            b41.A("refreshLayout");
            smartRefreshLayout = null;
        }
        smartRefreshLayout.setEnableLoadMore(true);
        SmartRefreshLayout smartRefreshLayout2 = this.refreshLayout;
        if (smartRefreshLayout2 == null) {
            b41.A("refreshLayout");
            smartRefreshLayout2 = null;
        }
        smartRefreshLayout2.setEnableAutoLoadMore(true);
        SmartRefreshLayout smartRefreshLayout3 = this.refreshLayout;
        if (smartRefreshLayout3 == null) {
            b41.A("refreshLayout");
            smartRefreshLayout3 = null;
        }
        smartRefreshLayout3.setOnRefreshListener(this);
        SmartRefreshLayout smartRefreshLayout4 = this.refreshLayout;
        if (smartRefreshLayout4 == null) {
            b41.A("refreshLayout");
            smartRefreshLayout4 = null;
        }
        smartRefreshLayout4.setOnLoadMoreListener(this);
        RecyclerView recyclerView3 = this.recyclerView;
        if (recyclerView3 == null) {
            b41.A("recyclerView");
        } else {
            recyclerView2 = recyclerView3;
        }
        recyclerView2.setAdapter(getAdapter());
        JSONObject jSONObject = new JSONObject();
        jSONObject.put((JSONObject) "pageType", (String) Integer.valueOf(this.pageType));
        getAdapter().b(jSONObject);
    }

    private final void parseArguments() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-2045546156")) {
            ipChange.ipc$dispatch("-2045546156", new Object[]{this});
        } else if (getArguments() == null) {
        } else {
            Bundle arguments = getArguments();
            b41.f(arguments);
            if (arguments.containsKey("pageType")) {
                Bundle arguments2 = getArguments();
                b41.f(arguments2);
                this.pageType = arguments2.getInt("pageType");
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void requestOrderList(final boolean z) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1654924582")) {
            ipChange.ipc$dispatch("-1654924582", new Object[]{this, Boolean.valueOf(z)});
            return;
        }
        if (z) {
            this.pageNumber = 1;
        } else {
            this.pageNumber++;
        }
        this.isRefresh = z;
        if (DoloresLoginHandler.Companion.a().c()) {
            MyOrderListRequest myOrderListRequest = new MyOrderListRequest();
            myOrderListRequest.setPageSize(20);
            myOrderListRequest.setPageNum(this.pageNumber);
            myOrderListRequest.setQueryType(this.pageType);
            cc0.a(myOrderListRequest).doOnKTStart(new Function1<DoloresRequest<MyOrderListResp>, wt2>() { // from class: com.alibaba.pictures.bricks.myorder.fragment.MyOrderListFragment$requestOrderList$2
                private static transient /* synthetic */ IpChange $ipChange;

                @Override // kotlin.jvm.functions.Function1
                public /* bridge */ /* synthetic */ wt2 invoke(DoloresRequest<MyOrderListResp> doloresRequest) {
                    invoke2(doloresRequest);
                    return wt2.INSTANCE;
                }

                /* renamed from: invoke  reason: avoid collision after fix types in other method */
                public final void invoke2(@Nullable DoloresRequest<MyOrderListResp> doloresRequest) {
                    IpChange ipChange2 = $ipChange;
                    if (AndroidInstantRuntime.support(ipChange2, "-1741692420")) {
                        ipChange2.ipc$dispatch("-1741692420", new Object[]{this, doloresRequest});
                    }
                }
            }).doOnKTSuccess(new Function1<MyOrderListResp, wt2>() { // from class: com.alibaba.pictures.bricks.myorder.fragment.MyOrderListFragment$requestOrderList$3
                private static transient /* synthetic */ IpChange $ipChange;

                /* JADX INFO: Access modifiers changed from: package-private */
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(1);
                }

                @Override // kotlin.jvm.functions.Function1
                public /* bridge */ /* synthetic */ wt2 invoke(MyOrderListResp myOrderListResp) {
                    invoke2(myOrderListResp);
                    return wt2.INSTANCE;
                }

                /* JADX WARN: Code restructure failed: missing block: B:37:0x00be, code lost:
                    if (r0 < r8.intValue()) goto L31;
                 */
                /* renamed from: invoke  reason: avoid collision after fix types in other method */
                /*
                    Code decompiled incorrectly, please refer to instructions dump.
                    To view partially-correct code enable 'Show inconsistent code' option in preferences
                */
                public final void invoke2(@org.jetbrains.annotations.NotNull com.alibaba.pictures.bricks.myorder.bean.MyOrderListResp r8) {
                    /*
                        r7 = this;
                        com.android.alibaba.ip.runtime.IpChange r0 = com.alibaba.pictures.bricks.myorder.fragment.MyOrderListFragment$requestOrderList$3.$ipChange
                        java.lang.String r1 = "-1955345280"
                        boolean r2 = com.android.alibaba.ip.runtime.AndroidInstantRuntime.support(r0, r1)
                        r3 = 1
                        r4 = 0
                        if (r2 == 0) goto L17
                        r2 = 2
                        java.lang.Object[] r2 = new java.lang.Object[r2]
                        r2[r4] = r7
                        r2[r3] = r8
                        r0.ipc$dispatch(r1, r2)
                        return
                    L17:
                        java.lang.String r0 = "it"
                        tb.b41.i(r8, r0)
                        boolean r0 = r1
                        java.lang.String r1 = "refreshLayout"
                        r2 = 0
                        if (r0 == 0) goto L7e
                        com.alibaba.pictures.bricks.myorder.fragment.MyOrderListFragment r0 = r2
                        android.view.ViewGroup r0 = com.alibaba.pictures.bricks.myorder.fragment.MyOrderListFragment.access$getErrorContainer$p(r0)
                        java.lang.String r5 = "errorContainer"
                        if (r0 != 0) goto L31
                        tb.b41.A(r5)
                        r0 = r2
                    L31:
                        r6 = 8
                        r0.setVisibility(r6)
                        com.alibaba.pictures.bricks.myorder.fragment.MyOrderListFragment r0 = r2
                        android.view.ViewGroup r6 = com.alibaba.pictures.bricks.myorder.fragment.MyOrderListFragment.access$getErrorContainer$p(r0)
                        if (r6 != 0) goto L42
                        tb.b41.A(r5)
                        r6 = r2
                    L42:
                        r0.removeErrorView(r6)
                        com.alibaba.pictures.bricks.myorder.fragment.MyOrderListFragment r0 = r2
                        r0.hideLoading()
                        com.alibaba.pictures.bricks.myorder.fragment.MyOrderListFragment r0 = r2
                        com.alibaba.pictures.bricks.myorder.fragment.MyOrderListAdapter r0 = com.alibaba.pictures.bricks.myorder.fragment.MyOrderListFragment.access$getAdapter(r0)
                        java.util.ArrayList r5 = r8.getOrderList()
                        r0.setData(r5)
                        com.alibaba.pictures.bricks.myorder.fragment.MyOrderListFragment r0 = r2
                        com.scwang.smartrefresh.layout.SmartRefreshLayout r0 = com.alibaba.pictures.bricks.myorder.fragment.MyOrderListFragment.access$getRefreshLayout$p(r0)
                        if (r0 != 0) goto L63
                        tb.b41.A(r1)
                        r0 = r2
                    L63:
                        r0.finishRefresh()
                        java.util.ArrayList r0 = r8.getOrderList()
                        if (r0 == 0) goto L75
                        boolean r0 = r0.isEmpty()
                        if (r0 == 0) goto L73
                        goto L75
                    L73:
                        r0 = 0
                        goto L76
                    L75:
                        r0 = 1
                    L76:
                        if (r0 == 0) goto L9a
                        com.alibaba.pictures.bricks.myorder.fragment.MyOrderListFragment r0 = r2
                        com.alibaba.pictures.bricks.myorder.fragment.MyOrderListFragment.access$showEmpty(r0)
                        goto L9a
                    L7e:
                        com.alibaba.pictures.bricks.myorder.fragment.MyOrderListFragment r0 = r2
                        com.alibaba.pictures.bricks.myorder.fragment.MyOrderListAdapter r0 = com.alibaba.pictures.bricks.myorder.fragment.MyOrderListFragment.access$getAdapter(r0)
                        java.util.ArrayList r5 = r8.getOrderList()
                        r0.a(r5)
                        com.alibaba.pictures.bricks.myorder.fragment.MyOrderListFragment r0 = r2
                        com.scwang.smartrefresh.layout.SmartRefreshLayout r0 = com.alibaba.pictures.bricks.myorder.fragment.MyOrderListFragment.access$getRefreshLayout$p(r0)
                        if (r0 != 0) goto L97
                        tb.b41.A(r1)
                        r0 = r2
                    L97:
                        r0.finishLoadMore()
                    L9a:
                        com.alibaba.pictures.bricks.myorder.fragment.MyOrderListFragment r0 = r2
                        com.scwang.smartrefresh.layout.SmartRefreshLayout r0 = com.alibaba.pictures.bricks.myorder.fragment.MyOrderListFragment.access$getRefreshLayout$p(r0)
                        if (r0 != 0) goto La6
                        tb.b41.A(r1)
                        goto La7
                    La6:
                        r2 = r0
                    La7:
                        java.lang.Integer r0 = r8.getTotalPageNum()
                        if (r0 == 0) goto Lc1
                        com.alibaba.pictures.bricks.myorder.fragment.MyOrderListFragment r0 = r2
                        int r0 = com.alibaba.pictures.bricks.myorder.fragment.MyOrderListFragment.access$getPageNumber$p(r0)
                        java.lang.Integer r8 = r8.getTotalPageNum()
                        tb.b41.f(r8)
                        int r8 = r8.intValue()
                        if (r0 >= r8) goto Lc1
                        goto Lc2
                    Lc1:
                        r3 = 0
                    Lc2:
                        r2.setEnableLoadMore(r3)
                        return
                    */
                    throw new UnsupportedOperationException("Method not decompiled: com.alibaba.pictures.bricks.myorder.fragment.MyOrderListFragment$requestOrderList$3.invoke2(com.alibaba.pictures.bricks.myorder.bean.MyOrderListResp):void");
                }
            }).doOnKTFail(new Function1<dc0<MyOrderListResp>, wt2>() { // from class: com.alibaba.pictures.bricks.myorder.fragment.MyOrderListFragment$requestOrderList$4
                private static transient /* synthetic */ IpChange $ipChange;

                /* compiled from: Taobao */
                /* renamed from: com.alibaba.pictures.bricks.myorder.fragment.MyOrderListFragment$requestOrderList$4$a */
                /* loaded from: classes7.dex */
                public static final class C3531a implements BricksBaseFragment.IClickListener {
                    private static transient /* synthetic */ IpChange $ipChange;
                    final /* synthetic */ MyOrderListFragment a;

                    C3531a(MyOrderListFragment myOrderListFragment) {
                        this.a = myOrderListFragment;
                    }

                    @Override // com.alibaba.pictures.bricks.base.BricksBaseFragment.IClickListener
                    public void handleClick(int i) {
                        IpChange ipChange = $ipChange;
                        if (AndroidInstantRuntime.support(ipChange, "1444710706")) {
                            ipChange.ipc$dispatch("1444710706", new Object[]{this, Integer.valueOf(i)});
                        } else {
                            this.a.requestOrderList(true);
                        }
                    }
                }

                /* JADX INFO: Access modifiers changed from: package-private */
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(1);
                }

                @Override // kotlin.jvm.functions.Function1
                public /* bridge */ /* synthetic */ wt2 invoke(dc0<MyOrderListResp> dc0Var) {
                    invoke2(dc0Var);
                    return wt2.INSTANCE;
                }

                /* renamed from: invoke  reason: avoid collision after fix types in other method */
                public final void invoke2(@NotNull dc0<MyOrderListResp> dc0Var) {
                    SmartRefreshLayout smartRefreshLayout;
                    SmartRefreshLayout smartRefreshLayout2;
                    ViewGroup viewGroup;
                    ViewGroup viewGroup2;
                    ViewGroup viewGroup3;
                    IpChange ipChange2 = $ipChange;
                    if (AndroidInstantRuntime.support(ipChange2, "1881092530")) {
                        ipChange2.ipc$dispatch("1881092530", new Object[]{this, dc0Var});
                        return;
                    }
                    b41.i(dc0Var, AdvanceSetting.NETWORK_TYPE);
                    SmartRefreshLayout smartRefreshLayout3 = null;
                    if (z) {
                        smartRefreshLayout2 = this.refreshLayout;
                        if (smartRefreshLayout2 == null) {
                            b41.A("refreshLayout");
                            smartRefreshLayout2 = null;
                        }
                        smartRefreshLayout2.finishRefresh();
                        viewGroup = this.errorContainer;
                        if (viewGroup == null) {
                            b41.A("errorContainer");
                            viewGroup = null;
                        }
                        viewGroup.setVisibility(0);
                        MyOrderListFragment myOrderListFragment = this;
                        String f = dc0Var.f();
                        String str = f == null ? "加载异常，请稍候重试" : f;
                        String e = dc0Var.e();
                        if (e == null) {
                            e = "";
                        }
                        String str2 = e;
                        viewGroup2 = this.errorContainer;
                        if (viewGroup2 == null) {
                            b41.A("errorContainer");
                            viewGroup3 = null;
                        } else {
                            viewGroup3 = viewGroup2;
                        }
                        myOrderListFragment.showErrorView(1, str, str2, viewGroup3, true, false, true, new C3531a(this));
                        return;
                    }
                    smartRefreshLayout = this.refreshLayout;
                    if (smartRefreshLayout == null) {
                        b41.A("refreshLayout");
                    } else {
                        smartRefreshLayout3 = smartRefreshLayout;
                    }
                    smartRefreshLayout3.finishLoadMore();
                    BricksToastUtil.INSTANCE.b("加载异常，请稍候重试");
                }
            });
            return;
        }
        yb1.Companion.d(this, 10);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void showEmpty() {
        ViewGroup viewGroup;
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-829477053")) {
            ipChange.ipc$dispatch("-829477053", new Object[]{this});
            return;
        }
        ViewGroup viewGroup2 = this.errorContainer;
        if (viewGroup2 == null) {
            b41.A("errorContainer");
            viewGroup2 = null;
        }
        viewGroup2.setVisibility(0);
        ViewGroup viewGroup3 = this.errorContainer;
        if (viewGroup3 == null) {
            b41.A("errorContainer");
            viewGroup = null;
        } else {
            viewGroup = viewGroup3;
        }
        showErrorView(3, "暂无相关内容", "", viewGroup, false, false, true, new C3530b());
    }

    @Override // androidx.fragment.app.Fragment
    public void onActivityResult(int i, int i2, @Nullable Intent intent) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "2044178697")) {
            ipChange.ipc$dispatch("2044178697", new Object[]{this, Integer.valueOf(i), Integer.valueOf(i2), intent});
            return;
        }
        super.onActivityResult(i, i2, intent);
        if (i2 == -1 && i == 10) {
            requestOrderList(this.isRefresh);
        }
    }

    @Override // androidx.fragment.app.Fragment
    public void onCreate(@Nullable Bundle bundle) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-743815336")) {
            ipChange.ipc$dispatch("-743815336", new Object[]{this, bundle});
            return;
        }
        super.onCreate(bundle);
        parseArguments();
        EventBus.getDefault().register(this);
    }

    @Override // androidx.fragment.app.Fragment
    @Nullable
    public View onCreateView(@NotNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, @Nullable Bundle bundle) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "522920236")) {
            return (View) ipChange.ipc$dispatch("522920236", new Object[]{this, layoutInflater, viewGroup, bundle});
        }
        b41.i(layoutInflater, "inflater");
        super.onCreateView(layoutInflater, viewGroup, bundle);
        View inflate = LayoutInflater.from(getContext()).inflate(R$layout.bricks_fragment_order_script_murder_list_layout, viewGroup, false);
        b41.h(inflate, "root");
        initView(inflate);
        return inflate;
    }

    @Override // androidx.fragment.app.Fragment
    public void onDestroy() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-672930152")) {
            ipChange.ipc$dispatch("-672930152", new Object[]{this});
            return;
        }
        super.onDestroy();
        EventBus.getDefault().unregister(this);
    }

    @Subscribe(eventType = {"scriptOrderRefresh"})
    public void onEventMainThread(@Nullable Event event) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1563396415")) {
            ipChange.ipc$dispatch("1563396415", new Object[]{this, event});
        } else {
            this.needRefreshStateOnResume = getUserVisibleHint();
        }
    }

    @Override // com.scwang.smartrefresh.layout.listener.OnLoadMoreListener
    public void onLoadMore(@NotNull RefreshLayout refreshLayout) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "930605938")) {
            ipChange.ipc$dispatch("930605938", new Object[]{this, refreshLayout});
            return;
        }
        b41.i(refreshLayout, "refreshLayout");
        requestOrderList(false);
    }

    @Override // com.scwang.smartrefresh.layout.listener.OnRefreshListener
    public void onRefresh(@NotNull RefreshLayout refreshLayout) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "849591948")) {
            ipChange.ipc$dispatch("849591948", new Object[]{this, refreshLayout});
            return;
        }
        b41.i(refreshLayout, "refreshLayout");
        requestOrderList(true);
    }

    @Override // androidx.fragment.app.Fragment
    public void onResume() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1575748395")) {
            ipChange.ipc$dispatch("1575748395", new Object[]{this});
            return;
        }
        super.onResume();
        if (this.needRefreshStateOnResume) {
            requestOrderList(true);
            this.needRefreshStateOnResume = false;
        }
    }

    @Override // androidx.fragment.app.Fragment
    public void setUserVisibleHint(boolean z) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "404700457")) {
            ipChange.ipc$dispatch("404700457", new Object[]{this, Boolean.valueOf(z)});
            return;
        }
        super.setUserVisibleHint(z);
        if (z) {
            showLoading("");
            requestOrderList(true);
        }
    }

    public /* synthetic */ MyOrderListFragment(int i, int i2, k50 k50Var) {
        this((i2 & 1) != 0 ? 0 : i);
    }
}
