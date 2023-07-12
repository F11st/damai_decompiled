package com.alibaba.pictures.bricks.orderresult;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.recyclerview.widget.LinearLayoutManager;
import com.alibaba.fastjson.JSONObject;
import com.alibaba.pictures.R$id;
import com.alibaba.pictures.R$layout;
import com.alibaba.pictures.bricks.base.BricksBaseFragment;
import com.alibaba.pictures.bricks.orderresult.CouponPayResultFragment;
import com.alibaba.pictures.bricks.orderresult.couponpayresult.PayResultUtListener;
import com.alibaba.pictures.bricks.orderresult.couponpayresult.bean.DmCouponPaySuccessBean;
import com.alibaba.pictures.bricks.orderresult.couponpayresult.bean.PayResultDataHolder;
import com.alibaba.pictures.bricks.orderresult.couponpayresult.bean.RecommendListMo;
import com.alibaba.pictures.bricks.orderresult.couponpayresult.request.PaySuccessRequest;
import com.alibaba.pictures.bricks.orderresult.couponpayresult.request.RecommendRequest;
import com.alibaba.pictures.bricks.view.PullToRefreshHeaderView;
import com.alibaba.pictures.bricks.view.irecycler.IRecyclerView;
import com.alibaba.pictures.bricks.view.irecycler.OnRefreshListener;
import com.alibaba.pictures.dolores.login.DoloresLoginHandler;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import com.meizu.cloud.pushsdk.notification.model.AdvanceSetting;
import java.util.ArrayList;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.text.o;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import tb.b41;
import tb.cc0;
import tb.cr1;
import tb.dc0;
import tb.k50;
import tb.rb0;
import tb.tr2;
import tb.wt2;
import tb.yb1;

/* compiled from: Taobao */
/* loaded from: classes7.dex */
public final class CouponPayResultFragment extends BricksBaseFragment {
    private static transient /* synthetic */ IpChange $ipChange = null;
    @NotNull
    public static final String CITYID = "cityId";
    @NotNull
    public static final a Companion = new a(null);
    @NotNull
    public static final String HOME_CLICK = "home_action";
    @NotNull
    public static final String ORDERID = "orderId";
    @NotNull
    public static final String ORDER_CLICK = "order_action";
    public static final int PAYRESULT_LOGIN_RESULT = 2008;
    @Nullable
    private String cityID;
    @Nullable
    private CouponPayResultAdapter mGaiaXAdapter;
    public IRecyclerView mGaiaXRecyclerView;
    @Nullable
    private String orderId;
    @Nullable
    private PayResultUtListener payResultUtListener;
    public View rootView;
    @NotNull
    private ArrayList<PayResultDataHolder> mGaiaXList = new ArrayList<>();
    @NotNull
    private OnRefreshListener onFreshListener = new OnRefreshListener() { // from class: tb.fp
        @Override // com.alibaba.pictures.bricks.view.irecycler.OnRefreshListener
        public final void onRefresh() {
            CouponPayResultFragment.m187onFreshListener$lambda0(CouponPayResultFragment.this);
        }
    };

    /* compiled from: Taobao */
    /* loaded from: classes7.dex */
    public static final class a {
        private a() {
        }

        public /* synthetic */ a(k50 k50Var) {
            this();
        }
    }

    private final void gotoLogin() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "2128477920")) {
            ipChange.ipc$dispatch("2128477920", new Object[]{this});
        } else {
            yb1.Companion.d(this, 2008);
        }
    }

    private final void initRecyclerView() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1215557584")) {
            ipChange.ipc$dispatch("-1215557584", new Object[]{this});
            return;
        }
        Context context = getContext();
        if (context != null) {
            CouponPayResultAdapter couponPayResultAdapter = new CouponPayResultAdapter(context, this.orderId);
            this.mGaiaXAdapter = couponPayResultAdapter;
            couponPayResultAdapter.a(this.mGaiaXList);
            IRecyclerView mGaiaXRecyclerView = getMGaiaXRecyclerView();
            if (mGaiaXRecyclerView != null) {
                LinearLayoutManager linearLayoutManager = new LinearLayoutManager(context);
                linearLayoutManager.setOrientation(1);
                mGaiaXRecyclerView.setLayoutManager(linearLayoutManager);
                mGaiaXRecyclerView.setRefreshEnabled(true);
                mGaiaXRecyclerView.setAdapter(this.mGaiaXAdapter);
                mGaiaXRecyclerView.setIsAutoToDefault(false);
                mGaiaXRecyclerView.getLoadMoreFooterView().setVisibility(8);
                mGaiaXRecyclerView.setLoadMoreEnabled(true);
                mGaiaXRecyclerView.setRefreshHeaderView(PullToRefreshHeaderView.getInstance(context));
                mGaiaXRecyclerView.setOnRefreshListener(this.onFreshListener);
                mGaiaXRecyclerView.setItemAnimator(null);
            }
        }
    }

    private final void initView() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1776124817")) {
            ipChange.ipc$dispatch("-1776124817", new Object[]{this});
            return;
        }
        View findViewById = getRootView().findViewById(R$id.rc);
        b41.h(findViewById, "rootView.findViewById(R.id.rc)");
        setMGaiaXRecyclerView((IRecyclerView) findViewById);
        initRecyclerView();
        requestPayResultData();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: onFreshListener$lambda-0  reason: not valid java name */
    public static final void m187onFreshListener$lambda0(CouponPayResultFragment couponPayResultFragment) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1478607137")) {
            ipChange.ipc$dispatch("1478607137", new Object[]{couponPayResultFragment});
            return;
        }
        b41.i(couponPayResultFragment, "this$0");
        couponPayResultFragment.requestPayResultData();
    }

    private final void requestPayResultData() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1620806660")) {
            ipChange.ipc$dispatch("1620806660", new Object[]{this});
        } else if (DoloresLoginHandler.Companion.a().c()) {
            IRecyclerView mGaiaXRecyclerView = getMGaiaXRecyclerView();
            if (mGaiaXRecyclerView != null) {
                mGaiaXRecyclerView.setRefreshing(true);
            }
            rb0.a aVar = rb0.Companion;
            PaySuccessRequest paySuccessRequest = new PaySuccessRequest();
            paySuccessRequest.setOrderId(this.orderId);
            aVar.b(paySuccessRequest).c(getContext()).a().doOnKTSuccess(new Function1<DmCouponPaySuccessBean, wt2>() { // from class: com.alibaba.pictures.bricks.orderresult.CouponPayResultFragment$requestPayResultData$2
                private static transient /* synthetic */ IpChange $ipChange;

                /* JADX INFO: Access modifiers changed from: package-private */
                {
                    super(1);
                }

                @Override // kotlin.jvm.functions.Function1
                public /* bridge */ /* synthetic */ wt2 invoke(DmCouponPaySuccessBean dmCouponPaySuccessBean) {
                    invoke2(dmCouponPaySuccessBean);
                    return wt2.INSTANCE;
                }

                /* renamed from: invoke  reason: avoid collision after fix types in other method */
                public final void invoke2(@NotNull DmCouponPaySuccessBean dmCouponPaySuccessBean) {
                    ArrayList arrayList;
                    ArrayList arrayList2;
                    CouponPayResultAdapter couponPayResultAdapter;
                    ArrayList<PayResultDataHolder> arrayList3;
                    IpChange ipChange2 = $ipChange;
                    if (AndroidInstantRuntime.support(ipChange2, "-1198860456")) {
                        ipChange2.ipc$dispatch("-1198860456", new Object[]{this, dmCouponPaySuccessBean});
                        return;
                    }
                    b41.i(dmCouponPaySuccessBean, AdvanceSetting.NETWORK_TYPE);
                    arrayList = CouponPayResultFragment.this.mGaiaXList;
                    arrayList.clear();
                    PayResultDataHolder payResultDataHolder = new PayResultDataHolder();
                    payResultDataHolder.setMPayResponse(dmCouponPaySuccessBean);
                    payResultDataHolder.setType(0);
                    arrayList2 = CouponPayResultFragment.this.mGaiaXList;
                    arrayList2.add(payResultDataHolder);
                    couponPayResultAdapter = CouponPayResultFragment.this.mGaiaXAdapter;
                    if (couponPayResultAdapter != null) {
                        arrayList3 = CouponPayResultFragment.this.mGaiaXList;
                        couponPayResultAdapter.a(arrayList3);
                    }
                    cr1.INSTANCE.h(CouponPayResultFragment.this.getOrderId(), dmCouponPaySuccessBean.getPayState(), dmCouponPaySuccessBean.resultDesc);
                    PayResultUtListener payResultUtListener = CouponPayResultFragment.this.getPayResultUtListener();
                    if (payResultUtListener != null) {
                        String payState = dmCouponPaySuccessBean.getPayState();
                        b41.h(payState, "it.payState");
                        String str = dmCouponPaySuccessBean.resultDesc;
                        b41.h(str, "it.resultDesc");
                        payResultUtListener.updateUTParam(payState, str);
                    }
                    CouponPayResultFragment.this.queryAnotherShow();
                }
            }).doOnKTFail(new Function1<dc0<DmCouponPaySuccessBean>, wt2>() { // from class: com.alibaba.pictures.bricks.orderresult.CouponPayResultFragment$requestPayResultData$3
                private static transient /* synthetic */ IpChange $ipChange;

                /* JADX INFO: Access modifiers changed from: package-private */
                {
                    super(1);
                }

                @Override // kotlin.jvm.functions.Function1
                public /* bridge */ /* synthetic */ wt2 invoke(dc0<DmCouponPaySuccessBean> dc0Var) {
                    invoke2(dc0Var);
                    return wt2.INSTANCE;
                }

                /* renamed from: invoke  reason: avoid collision after fix types in other method */
                public final void invoke2(@NotNull dc0<DmCouponPaySuccessBean> dc0Var) {
                    ArrayList arrayList;
                    ArrayList arrayList2;
                    CouponPayResultAdapter couponPayResultAdapter;
                    ArrayList<PayResultDataHolder> arrayList3;
                    IpChange ipChange2 = $ipChange;
                    if (AndroidInstantRuntime.support(ipChange2, "-1223867683")) {
                        ipChange2.ipc$dispatch("-1223867683", new Object[]{this, dc0Var});
                        return;
                    }
                    b41.i(dc0Var, AdvanceSetting.NETWORK_TYPE);
                    arrayList = CouponPayResultFragment.this.mGaiaXList;
                    arrayList.clear();
                    PayResultDataHolder payResultDataHolder = new PayResultDataHolder();
                    payResultDataHolder.setMPayResponse(CouponPayResultFragment.this.createPayResultErrorMsg());
                    payResultDataHolder.setType(0);
                    arrayList2 = CouponPayResultFragment.this.mGaiaXList;
                    arrayList2.add(payResultDataHolder);
                    couponPayResultAdapter = CouponPayResultFragment.this.mGaiaXAdapter;
                    if (couponPayResultAdapter != null) {
                        arrayList3 = CouponPayResultFragment.this.mGaiaXList;
                        couponPayResultAdapter.a(arrayList3);
                    }
                    DmCouponPaySuccessBean createPayResultErrorMsg = CouponPayResultFragment.this.createPayResultErrorMsg();
                    if (createPayResultErrorMsg != null) {
                        CouponPayResultFragment couponPayResultFragment = CouponPayResultFragment.this;
                        cr1.INSTANCE.h(createPayResultErrorMsg.orderId, createPayResultErrorMsg.getPayState(), createPayResultErrorMsg.resultDesc);
                        PayResultUtListener payResultUtListener = couponPayResultFragment.getPayResultUtListener();
                        if (payResultUtListener != null) {
                            String payState = createPayResultErrorMsg.getPayState();
                            b41.h(payState, "this.payState");
                            String str = createPayResultErrorMsg.resultDesc;
                            b41.h(str, "this.resultDesc");
                            payResultUtListener.updateUTParam(payState, str);
                        }
                    }
                }
            }).doOnKTFinish(new Function0<wt2>() { // from class: com.alibaba.pictures.bricks.orderresult.CouponPayResultFragment$requestPayResultData$4
                private static transient /* synthetic */ IpChange $ipChange;

                /* JADX INFO: Access modifiers changed from: package-private */
                {
                    super(0);
                }

                @Override // kotlin.jvm.functions.Function0
                public /* bridge */ /* synthetic */ wt2 invoke() {
                    invoke2();
                    return wt2.INSTANCE;
                }

                /* renamed from: invoke  reason: avoid collision after fix types in other method */
                public final void invoke2() {
                    IpChange ipChange2 = $ipChange;
                    if (AndroidInstantRuntime.support(ipChange2, "1439501098")) {
                        ipChange2.ipc$dispatch("1439501098", new Object[]{this});
                        return;
                    }
                    IRecyclerView mGaiaXRecyclerView2 = CouponPayResultFragment.this.getMGaiaXRecyclerView();
                    if (mGaiaXRecyclerView2 != null) {
                        mGaiaXRecyclerView2.setRefreshing(false);
                    }
                }
            });
        } else {
            gotoLogin();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void returnAnotherShow(RecommendListMo recommendListMo) {
        ArrayList<JSONObject> result;
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-105454608")) {
            ipChange.ipc$dispatch("-105454608", new Object[]{this, recommendListMo});
        } else if (recommendListMo != null && (result = recommendListMo.getResult()) != null) {
            if (result.size() > 0) {
                PayResultDataHolder payResultDataHolder = new PayResultDataHolder();
                payResultDataHolder.setType(1);
                this.mGaiaXList.add(payResultDataHolder);
            }
            int size = result.size();
            for (int i = 0; i < size; i++) {
                PayResultDataHolder payResultDataHolder2 = new PayResultDataHolder();
                payResultDataHolder2.setMRecommendResponse(result.get(i));
                payResultDataHolder2.setType(2);
                this.mGaiaXList.add(payResultDataHolder2);
            }
            CouponPayResultAdapter couponPayResultAdapter = this.mGaiaXAdapter;
            if (couponPayResultAdapter != null) {
                couponPayResultAdapter.a(this.mGaiaXList);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void returnAnotherShowError(String str, String str2) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1845513312")) {
            ipChange.ipc$dispatch("-1845513312", new Object[]{this, str, str2});
        }
    }

    @NotNull
    public final DmCouponPaySuccessBean createPayResultErrorMsg() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1073347796")) {
            return (DmCouponPaySuccessBean) ipChange.ipc$dispatch("1073347796", new Object[]{this});
        }
        DmCouponPaySuccessBean dmCouponPaySuccessBean = new DmCouponPaySuccessBean();
        dmCouponPaySuccessBean.isPaid = "false";
        dmCouponPaySuccessBean.orderId = this.orderId;
        dmCouponPaySuccessBean.resultDesc = "支付结果处理中";
        dmCouponPaySuccessBean.render = new ArrayList();
        DmCouponPaySuccessBean.GaiaxRender gaiaxRender = new DmCouponPaySuccessBean.GaiaxRender();
        gaiaxRender.type = "gaiax";
        gaiaxRender.url = "damai://gaiax?templateId=damai_script_play_pay_result_item&templateVersion=99&bizId=damai";
        dmCouponPaySuccessBean.render.add(gaiaxRender);
        dmCouponPaySuccessBean.buttons = new ArrayList();
        DmCouponPaySuccessBean.DmPayButtonBean dmPayButtonBean = new DmCouponPaySuccessBean.DmPayButtonBean();
        dmPayButtonBean.buttonText = "返回首页";
        dmPayButtonBean.buttonType = "1";
        dmPayButtonBean.nativeUrl = tr2.SCHEME_HOMEPAGE;
        DmCouponPaySuccessBean.DmPayButtonBean dmPayButtonBean2 = new DmCouponPaySuccessBean.DmPayButtonBean();
        dmPayButtonBean2.buttonText = "查看订单详情";
        dmPayButtonBean2.buttonType = "2";
        dmPayButtonBean2.nativeUrl = "damai://V1/CouponOrderDetail?orderId=" + this.orderId + "&payResult=false";
        dmCouponPaySuccessBean.buttons.add(dmPayButtonBean);
        dmCouponPaySuccessBean.buttons.add(dmPayButtonBean2);
        return dmCouponPaySuccessBean;
    }

    @Nullable
    public final String getCityID() {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "-5853770") ? (String) ipChange.ipc$dispatch("-5853770", new Object[]{this}) : this.cityID;
    }

    @NotNull
    public final IRecyclerView getMGaiaXRecyclerView() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1232546802")) {
            return (IRecyclerView) ipChange.ipc$dispatch("1232546802", new Object[]{this});
        }
        IRecyclerView iRecyclerView = this.mGaiaXRecyclerView;
        if (iRecyclerView != null) {
            return iRecyclerView;
        }
        b41.A("mGaiaXRecyclerView");
        return null;
    }

    @Nullable
    public final String getOrderId() {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "-1635400241") ? (String) ipChange.ipc$dispatch("-1635400241", new Object[]{this}) : this.orderId;
    }

    @Nullable
    public final PayResultUtListener getPayResultUtListener() {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "2067465395") ? (PayResultUtListener) ipChange.ipc$dispatch("2067465395", new Object[]{this}) : this.payResultUtListener;
    }

    @NotNull
    public final View getRootView() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1096801003")) {
            return (View) ipChange.ipc$dispatch("1096801003", new Object[]{this});
        }
        View view = this.rootView;
        if (view != null) {
            return view;
        }
        b41.A("rootView");
        return null;
    }

    @Override // androidx.fragment.app.Fragment
    public void onActivityResult(int i, int i2, @Nullable Intent intent) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-193120106")) {
            ipChange.ipc$dispatch("-193120106", new Object[]{this, Integer.valueOf(i), Integer.valueOf(i2), intent});
        } else if (i2 == -1 && i == 2008) {
            requestPayResultData();
        }
    }

    @Override // androidx.fragment.app.Fragment
    public void onCreate(@Nullable Bundle bundle) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-285591701")) {
            ipChange.ipc$dispatch("-285591701", new Object[]{this, bundle});
            return;
        }
        super.onCreate(bundle);
        Bundle arguments = getArguments();
        this.orderId = arguments != null ? arguments.getString("orderId") : null;
        Bundle arguments2 = getArguments();
        this.cityID = arguments2 != null ? arguments2.getString("cityId") : null;
        String str = this.orderId;
        if (str != null) {
            o.s(str);
        }
    }

    @Override // androidx.fragment.app.Fragment
    @Nullable
    public View onCreateView(@NotNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, @Nullable Bundle bundle) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-960655559")) {
            return (View) ipChange.ipc$dispatch("-960655559", new Object[]{this, layoutInflater, viewGroup, bundle});
        }
        b41.i(layoutInflater, "inflater");
        View inflate = layoutInflater.inflate(R$layout.bricks_coupon_pay_result_fragment, viewGroup, false);
        b41.h(inflate, "inflater.inflate(R.layou…agment, container, false)");
        setRootView(inflate);
        initView();
        return getRootView();
    }

    public final void queryAnotherShow() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-785499220")) {
            ipChange.ipc$dispatch("-785499220", new Object[]{this});
            return;
        }
        RecommendRequest recommendRequest = new RecommendRequest();
        recommendRequest.setCityId(this.cityID);
        cc0.a(recommendRequest).doOnKTSuccess(new Function1<RecommendListMo, wt2>() { // from class: com.alibaba.pictures.bricks.orderresult.CouponPayResultFragment$queryAnotherShow$2
            private static transient /* synthetic */ IpChange $ipChange;

            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ wt2 invoke(RecommendListMo recommendListMo) {
                invoke2(recommendListMo);
                return wt2.INSTANCE;
            }

            /* renamed from: invoke  reason: avoid collision after fix types in other method */
            public final void invoke2(@NotNull RecommendListMo recommendListMo) {
                IpChange ipChange2 = $ipChange;
                if (AndroidInstantRuntime.support(ipChange2, "-768569382")) {
                    ipChange2.ipc$dispatch("-768569382", new Object[]{this, recommendListMo});
                    return;
                }
                b41.i(recommendListMo, AdvanceSetting.NETWORK_TYPE);
                CouponPayResultFragment.this.returnAnotherShow(recommendListMo);
            }
        }).doOnKTFail(new Function1<dc0<RecommendListMo>, wt2>() { // from class: com.alibaba.pictures.bricks.orderresult.CouponPayResultFragment$queryAnotherShow$3
            private static transient /* synthetic */ IpChange $ipChange;

            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ wt2 invoke(dc0<RecommendListMo> dc0Var) {
                invoke2(dc0Var);
                return wt2.INSTANCE;
            }

            /* renamed from: invoke  reason: avoid collision after fix types in other method */
            public final void invoke2(@NotNull dc0<RecommendListMo> dc0Var) {
                IpChange ipChange2 = $ipChange;
                if (AndroidInstantRuntime.support(ipChange2, "12782725")) {
                    ipChange2.ipc$dispatch("12782725", new Object[]{this, dc0Var});
                    return;
                }
                b41.i(dc0Var, AdvanceSetting.NETWORK_TYPE);
                CouponPayResultFragment.this.returnAnotherShowError(dc0Var.e(), dc0Var.f());
            }
        });
    }

    public final void setCityID(@Nullable String str) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1576558872")) {
            ipChange.ipc$dispatch("-1576558872", new Object[]{this, str});
        } else {
            this.cityID = str;
        }
    }

    public final void setMGaiaXRecyclerView(@NotNull IRecyclerView iRecyclerView) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "2080639382")) {
            ipChange.ipc$dispatch("2080639382", new Object[]{this, iRecyclerView});
            return;
        }
        b41.i(iRecyclerView, "<set-?>");
        this.mGaiaXRecyclerView = iRecyclerView;
    }

    public final void setOrderId(@Nullable String str) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-774053497")) {
            ipChange.ipc$dispatch("-774053497", new Object[]{this, str});
        } else {
            this.orderId = str;
        }
    }

    public final void setPayResultUtListener(@Nullable PayResultUtListener payResultUtListener) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1756607565")) {
            ipChange.ipc$dispatch("-1756607565", new Object[]{this, payResultUtListener});
        } else {
            this.payResultUtListener = payResultUtListener;
        }
    }

    public final void setRootView(@NotNull View view) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1394776917")) {
            ipChange.ipc$dispatch("1394776917", new Object[]{this, view});
            return;
        }
        b41.i(view, "<set-?>");
        this.rootView = view;
    }

    public final void setUtListener(@NotNull PayResultUtListener payResultUtListener) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "467482672")) {
            ipChange.ipc$dispatch("467482672", new Object[]{this, payResultUtListener});
            return;
        }
        b41.i(payResultUtListener, "utListener");
        this.payResultUtListener = payResultUtListener;
    }
}
