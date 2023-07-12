package cn.damai.trade.newtradeorder.ui.orderlist.ui.activity;

import android.content.Intent;
import android.os.Bundle;
import android.os.SystemClock;
import android.text.TextUtils;
import android.view.View;
import android.widget.LinearLayout;
import androidx.annotation.Nullable;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import cn.damai.common.nav.DMNav;
import cn.damai.common.util.ToastUtil;
import cn.damai.commonbusiness.base.DamaiBaseMvpFragment;
import cn.damai.commonbusiness.seatbiz.orderlist.bean.OrderFirstPayChooseSeat;
import cn.damai.commonbusiness.seatbiz.seat.qilin.loader.prepare.SeatPrepare4Order;
import cn.damai.trade.R$id;
import cn.damai.trade.R$layout;
import cn.damai.trade.R$string;
import cn.damai.trade.RefundActivity;
import cn.damai.trade.newtradeorder.ui.orderlist.bean.OrderListBean;
import cn.damai.trade.newtradeorder.ui.orderlist.bean.OrderListResultBean;
import cn.damai.trade.newtradeorder.ui.orderlist.contract.OrderListContract;
import cn.damai.trade.newtradeorder.ui.orderlist.helper.OrderPayChooseImpl;
import cn.damai.trade.newtradeorder.ui.orderlist.presenter.OrderListPresenter;
import cn.damai.trade.newtradeorder.ui.orderlist.ui.adapter.OrderListAdapter;
import cn.damai.uikit.irecycler.IRecyclerView;
import cn.damai.uikit.irecycler.OnLoadMoreListener;
import cn.damai.uikit.irecycler.OnRefreshListener;
import cn.damai.uikit.irecycler.widget.PullToRefreshHeaderView;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import java.util.ArrayList;
import java.util.List;
import org.apache.commons.lang3.time.DateUtils;
import tb.ap1;
import tb.b23;
import tb.mo1;
import tb.mu0;
import tb.pp2;
import tb.uo;
import tb.uo1;
import tb.wh2;

/* compiled from: Taobao */
/* loaded from: classes8.dex */
public class OrderListFragment extends DamaiBaseMvpFragment<OrderListPresenter, OrderListContract.Model> implements OrderListContract.View, OnRefreshListener, OnLoadMoreListener {
    private static transient /* synthetic */ IpChange $ipChange = null;
    public static final int REQUEST_CHOOSE_SEAT_CODE = 1201;
    public OrderListAdapter mAdapter;
    private SeatPrepare4Order mChooseSeat;
    private View mChooseSeatBtn;
    private uo mCountDownHandler;
    private LinearLayout mEmptyPageLayout;
    private boolean mIsLoadFinish;
    public int mQueryType;
    private IRecyclerView mRecyclerView;
    private long mTotalPageNum;
    public String mUserCode;
    private View mYinyingView;
    private int mPageIndex = 1;
    private final int mPageSize = 20;
    private List<OrderListBean> mOrderListBeanList = new ArrayList();
    private int mScrollTotal = 0;
    private View.OnClickListener jumpOrderDetailListener = new a();
    private OrderPayChooseImpl firstPayChooseListener = new b();
    private View.OnClickListener jumpRefundListener = new c();

    /* compiled from: Taobao */
    /* loaded from: classes16.dex */
    public class a implements View.OnClickListener {
        private static transient /* synthetic */ IpChange $ipChange;

        a() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "-2145391456")) {
                ipChange.ipc$dispatch("-2145391456", new Object[]{this, view});
            } else {
                OrderListFragment.this.jumpOrderDetailPage((OrderListBean) view.getTag());
            }
        }
    }

    /* compiled from: Taobao */
    /* loaded from: classes8.dex */
    public class b implements OrderPayChooseImpl {
        private static transient /* synthetic */ IpChange $ipChange;

        /* compiled from: Taobao */
        /* loaded from: classes8.dex */
        public class a implements SeatPrepare4Order.OnLoadListener {
            private static transient /* synthetic */ IpChange $ipChange;
            final /* synthetic */ OrderListBean a;

            a(OrderListBean orderListBean) {
                this.a = orderListBean;
            }

            @Override // cn.damai.commonbusiness.seatbiz.seat.qilin.loader.prepare.SeatPrepare4Order.OnLoadListener
            public void onLoadStateChanged(boolean z) {
                IpChange ipChange = $ipChange;
                if (AndroidInstantRuntime.support(ipChange, "-1516994081")) {
                    ipChange.ipc$dispatch("-1516994081", new Object[]{this, Boolean.valueOf(z)});
                } else if (z) {
                    OrderListFragment.this.startProgressDialog();
                } else {
                    OrderListFragment.this.enableChooseSeatBtn();
                    OrderListFragment.this.stopProgressDialog();
                }
            }

            @Override // cn.damai.commonbusiness.seatbiz.seat.qilin.loader.prepare.SeatPrepare4Order.OnLoadListener
            public void onSeatActivityOpen(long j) {
                IpChange ipChange = $ipChange;
                if (AndroidInstantRuntime.support(ipChange, "-336395516")) {
                    ipChange.ipc$dispatch("-336395516", new Object[]{this, Long.valueOf(j)});
                } else {
                    cn.damai.common.user.c.e().x(pp2.u().U(OrderListFragment.this.mUserCode, String.valueOf(j), this.a.index));
                }
            }
        }

        b() {
        }

        @Override // cn.damai.trade.newtradeorder.ui.orderlist.helper.OrderPayChooseImpl
        public void onChooseSeatClick(View view) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "1722876741")) {
                ipChange.ipc$dispatch("1722876741", new Object[]{this, view});
                return;
            }
            OrderListFragment.this.mChooseSeatBtn = view;
            OrderListFragment.this.unenableChooseSeatBtn();
            OrderListBean orderListBean = (OrderListBean) view.getTag();
            if (orderListBean == null) {
                OrderListFragment.this.enableChooseSeatBtn();
                return;
            }
            OrderFirstPayChooseSeat orderFirstPayChooseSeat = orderListBean.firstPayChooseSeat;
            if (orderFirstPayChooseSeat == null) {
                OrderListFragment.this.enableChooseSeatBtn();
            } else {
                OrderListFragment.this.mChooseSeat.g(orderListBean.projectName, orderFirstPayChooseSeat.performName, String.valueOf(orderListBean.orderId), String.valueOf(orderListBean.projectId), String.valueOf(orderFirstPayChooseSeat.performId), String.valueOf(orderFirstPayChooseSeat.showCityId), new a(orderListBean));
            }
        }

        @Override // cn.damai.trade.newtradeorder.ui.orderlist.helper.OrderPayChooseImpl
        public void onRemindClick(View view) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "439443292")) {
                ipChange.ipc$dispatch("439443292", new Object[]{this, view});
                return;
            }
            OrderListBean orderListBean = (OrderListBean) view.getTag();
            if (orderListBean != null) {
                cn.damai.common.user.c.e().x(pp2.u().V(OrderListFragment.this.mUserCode, String.valueOf(orderListBean.orderId), orderListBean.index));
            }
            mo1.l(OrderListFragment.this.getContext());
            view.setClickable(true);
        }
    }

    /* compiled from: Taobao */
    /* loaded from: classes16.dex */
    public class c implements View.OnClickListener {
        private static transient /* synthetic */ IpChange $ipChange;

        c() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "2077189282")) {
                ipChange.ipc$dispatch("2077189282", new Object[]{this, view});
                return;
            }
            OrderListBean orderListBean = (OrderListBean) view.getTag();
            if (orderListBean != null) {
                cn.damai.common.user.c.e().x(pp2.u().i1(OrderListFragment.this.mUserCode, String.valueOf(orderListBean.orderId), orderListBean.index));
                Intent intent = new Intent(OrderListFragment.this.getActivity(), RefundActivity.class);
                intent.putExtra("order", orderListBean);
                OrderListFragment.this.startActivity(intent);
            }
        }
    }

    static /* synthetic */ int access$012(OrderListFragment orderListFragment, int i) {
        int i2 = orderListFragment.mScrollTotal + i;
        orderListFragment.mScrollTotal = i2;
        return i2;
    }

    private void cancelTimer() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "288735102")) {
            ipChange.ipc$dispatch("288735102", new Object[]{this});
            return;
        }
        uo uoVar = this.mCountDownHandler;
        if (uoVar != null) {
            uoVar.removeMessages(0);
            this.mCountDownHandler.a();
            this.mCountDownHandler = null;
        }
    }

    private void initData() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1948282873")) {
            ipChange.ipc$dispatch("-1948282873", new Object[]{this});
            return;
        }
        this.mQueryType = getArguments().getInt("type", 0);
        this.mUserCode = getArguments().getString("userCode", "");
    }

    private void initIRecycleView() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "288484834")) {
            ipChange.ipc$dispatch("288484834", new Object[]{this});
            return;
        }
        LinearLayout linearLayout = (LinearLayout) this.rootView.findViewById(R$id.ll_empty_page);
        this.mEmptyPageLayout = linearLayout;
        linearLayout.setVisibility(8);
        View findViewById = this.rootView.findViewById(R$id.view_yinying);
        this.mYinyingView = findViewById;
        findViewById.setVisibility(8);
        this.mRecyclerView = (IRecyclerView) this.rootView.findViewById(R$id.irc);
        this.mRecyclerView.setLayoutManager(new LinearLayoutManager(getContext()));
        OrderListAdapter orderListAdapter = new OrderListAdapter(getContext(), this.mOrderListBeanList, this.mQueryType);
        this.mAdapter = orderListAdapter;
        this.mRecyclerView.setAdapter(orderListAdapter);
        this.mAdapter.j(this.jumpRefundListener);
        this.mAdapter.h(this.jumpOrderDetailListener);
        this.mAdapter.i(this.firstPayChooseListener);
        this.mRecyclerView.setRefreshEnabled(true);
        this.mRecyclerView.setLoadMoreEnabled(true);
        this.mRecyclerView.setIsAutoToDefault(false);
        this.mRecyclerView.setOnRefreshListener(this);
        this.mRecyclerView.setOnLoadMoreListener(this);
        this.mRecyclerView.getLoadMoreFooterView().setVisibility(8);
        this.mRecyclerView.setRefreshHeaderView(PullToRefreshHeaderView.getInstance(getActivity()));
        this.mRecyclerView.addOnScrollListener(new RecyclerView.OnScrollListener() { // from class: cn.damai.trade.newtradeorder.ui.orderlist.ui.activity.OrderListFragment.1
            private static transient /* synthetic */ IpChange $ipChange;

            @Override // androidx.recyclerview.widget.RecyclerView.OnScrollListener
            public void onScrolled(RecyclerView recyclerView, int i, int i2) {
                IpChange ipChange2 = $ipChange;
                if (AndroidInstantRuntime.support(ipChange2, "486738516")) {
                    ipChange2.ipc$dispatch("486738516", new Object[]{this, recyclerView, Integer.valueOf(i), Integer.valueOf(i2)});
                    return;
                }
                OrderListFragment.access$012(OrderListFragment.this, i2);
                if (OrderListFragment.this.mScrollTotal < 5) {
                    OrderListFragment.this.mYinyingView.setVisibility(8);
                } else {
                    OrderListFragment.this.mYinyingView.setVisibility(0);
                }
            }
        });
    }

    private boolean isPageFinish() {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "-1418801959") ? ((Boolean) ipChange.ipc$dispatch("-1418801959", new Object[]{this})).booleanValue() : getActivity() == null || getActivity().isFinishing() || isDetached();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void jumpOrderDetailPage(OrderListBean orderListBean) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-2037079224")) {
            ipChange.ipc$dispatch("-2037079224", new Object[]{this, orderListBean});
        } else if (orderListBean == null) {
        } else {
            long j = mu0.f;
            long j2 = orderListBean.orderId;
            if (j != j2 && mu0.e) {
                mu0.e = false;
            }
            if (mu0.f == 0) {
                mu0.d = DateUtils.MILLIS_PER_MINUTE;
                mu0.e = false;
                mu0.f = j2;
            }
            cn.damai.common.user.c.e().x(pp2.u().h1(this.mUserCode, String.valueOf(orderListBean.orderId), orderListBean.index));
            DMNav.from(getContext()).forResult(1101).toUri(orderListBean.detailUrl);
        }
    }

    public static OrderListFragment newInstance(int i, String str) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "604678982")) {
            return (OrderListFragment) ipChange.ipc$dispatch("604678982", new Object[]{Integer.valueOf(i), str});
        }
        OrderListFragment orderListFragment = new OrderListFragment();
        Bundle bundle = new Bundle();
        bundle.putInt("type", i);
        bundle.putString("userCode", str);
        orderListFragment.setArguments(bundle);
        return orderListFragment;
    }

    private void updateEmptyView(boolean z) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1706448908")) {
            ipChange.ipc$dispatch("-1706448908", new Object[]{this, Boolean.valueOf(z)});
        } else if (z) {
            this.mEmptyPageLayout.setVisibility(0);
            this.mRecyclerView.setVisibility(8);
        } else {
            this.mEmptyPageLayout.setVisibility(8);
            this.mRecyclerView.setVisibility(0);
        }
    }

    public void enableChooseSeatBtn() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "845354988")) {
            ipChange.ipc$dispatch("845354988", new Object[]{this});
            return;
        }
        View view = this.mChooseSeatBtn;
        if (view != null) {
            view.setEnabled(true);
        }
    }

    @Override // cn.damai.common.app.base.BaseFragment
    protected int getLayoutResource() {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "1770778670") ? ((Integer) ipChange.ipc$dispatch("1770778670", new Object[]{this})).intValue() : R$layout.order_list_fragment;
    }

    @Override // cn.damai.commonbusiness.base.ResponseErrorPage.ErrorRefreshListener
    public void handleError(int i) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1395906714")) {
            ipChange.ipc$dispatch("1395906714", new Object[]{this, Integer.valueOf(i)});
        } else {
            requestOrderList();
        }
    }

    @Override // cn.damai.common.app.base.BaseFragment
    public void initPresenter() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1694296273")) {
            ipChange.ipc$dispatch("1694296273", new Object[]{this});
        } else {
            ((OrderListPresenter) this.mPresenter).setVM(this, (OrderListContract.Model) this.mModel);
        }
    }

    @Override // cn.damai.common.app.base.BaseFragment
    protected void initView() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1357717292")) {
            ipChange.ipc$dispatch("1357717292", new Object[]{this});
            return;
        }
        initData();
        initIRecycleView();
        requestOrderList();
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-371763694")) {
            ipChange.ipc$dispatch("-371763694", new Object[]{this, view});
        }
    }

    @Override // androidx.fragment.app.Fragment
    public void onCreate(@Nullable Bundle bundle) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-2011981426")) {
            ipChange.ipc$dispatch("-2011981426", new Object[]{this, bundle});
            return;
        }
        super.onCreate(bundle);
        this.mChooseSeat = new SeatPrepare4Order(getActivity(), 1201);
    }

    @Override // androidx.fragment.app.Fragment
    public void onDestroy() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "478837326")) {
            ipChange.ipc$dispatch("478837326", new Object[]{this});
            return;
        }
        cancelTimer();
        SeatPrepare4Order seatPrepare4Order = this.mChooseSeat;
        if (seatPrepare4Order != null) {
            seatPrepare4Order.c();
        }
        super.onDestroy();
    }

    @Override // cn.damai.uikit.irecycler.OnLoadMoreListener
    public void onLoadMore(View view) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-805932053")) {
            ipChange.ipc$dispatch("-805932053", new Object[]{this, view});
        } else if (this.mIsLoadFinish) {
            int i = this.mPageIndex;
            if (i < this.mTotalPageNum) {
                this.mIsLoadFinish = false;
                int i2 = i + 1;
                this.mPageIndex = i2;
                ((OrderListPresenter) this.mPresenter).getOrderListData(i2, 20, this.mQueryType);
            }
        }
    }

    @Override // cn.damai.commonbusiness.base.BaseDamaiView
    public void onNetError(String str, String str2, String str3) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1116202731")) {
            ipChange.ipc$dispatch("-1116202731", new Object[]{this, str, str2, str3});
        } else if (isPageFinish()) {
        } else {
            ap1.e(str3, str, str2);
            if (this.mPageIndex == 1) {
                onResponseError(str2, str, str3, this.rootView, true);
                return;
            }
            if (TextUtils.isEmpty(str2)) {
                str2 = getResources().getString(R$string.message_network_error_tips);
            }
            ToastUtil.f(str2);
        }
    }

    @Override // cn.damai.commonbusiness.base.BaseDamaiView
    public void onNetSuccess() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "2114480156")) {
            ipChange.ipc$dispatch("2114480156", new Object[]{this});
        } else if (isPageFinish()) {
        } else {
            onResponseSuccess(this.rootView);
            b23.d("order_list");
        }
    }

    @Override // cn.damai.uikit.irecycler.OnRefreshListener
    public void onRefresh() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1303081011")) {
            ipChange.ipc$dispatch("-1303081011", new Object[]{this});
        } else if (isAdded()) {
            cancelTimer();
            long[] jArr = uo1.a;
            int i = this.mQueryType;
            jArr[i] = 0;
            this.mIsLoadFinish = false;
            this.mPageIndex = 1;
            ((OrderListPresenter) this.mPresenter).getOrderListData(1, 20, i);
        }
    }

    @Override // cn.damai.trade.newtradeorder.ui.orderlist.contract.OrderListContract.View
    public void orderListRefreshNotify() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1270425289")) {
            ipChange.ipc$dispatch("1270425289", new Object[]{this});
        } else {
            requestOrderList();
        }
    }

    public void requestOrderList() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "632337092")) {
            ipChange.ipc$dispatch("632337092", new Object[]{this});
        } else if (isAdded()) {
            startProgressDialog();
            cancelTimer();
            long[] jArr = uo1.a;
            int i = this.mQueryType;
            jArr[i] = 0;
            this.mIsLoadFinish = false;
            this.mPageIndex = 1;
            ((OrderListPresenter) this.mPresenter).getOrderListData(1, 20, i);
        }
    }

    @Override // cn.damai.trade.newtradeorder.ui.orderlist.contract.OrderListContract.View
    public void returnOrderListData(OrderListResultBean orderListResultBean) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-2060499835")) {
            ipChange.ipc$dispatch("-2060499835", new Object[]{this, orderListResultBean});
        } else if (isPageFinish() || orderListResultBean == null) {
        } else {
            this.mTotalPageNum = orderListResultBean.totalPageNum;
            if (this.mPageIndex == 1) {
                if (wh2.e(orderListResultBean.orderList) == 0) {
                    showEmptyView();
                    return;
                }
                updateEmptyView(false);
                this.mOrderListBeanList.clear();
                uo1.a[this.mQueryType] = orderListResultBean.currentTime - SystemClock.elapsedRealtime();
            }
            this.mOrderListBeanList.addAll(orderListResultBean.orderList);
            OrderListAdapter orderListAdapter = this.mAdapter;
            if (orderListAdapter != null) {
                orderListAdapter.notifyDataSetChanged();
            }
        }
    }

    @Override // cn.damai.common.app.base.BaseView
    public void showEmptyView() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "467173396")) {
            ipChange.ipc$dispatch("467173396", new Object[]{this});
        } else if (isPageFinish()) {
        } else {
            updateEmptyView(true);
        }
    }

    @Override // cn.damai.common.app.base.BaseView
    public void showErrorTips(String str) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "757221840")) {
            ipChange.ipc$dispatch("757221840", new Object[]{this, str});
        }
    }

    @Override // cn.damai.common.app.base.BaseView
    public void showLoading(String str) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-932472908")) {
            ipChange.ipc$dispatch("-932472908", new Object[]{this, str});
        }
    }

    @Override // cn.damai.trade.newtradeorder.ui.orderlist.contract.OrderListContract.View
    public void startTimerNotify() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-542787979")) {
            ipChange.ipc$dispatch("-542787979", new Object[]{this});
        } else if (this.mCountDownHandler == null) {
            uo uoVar = new uo(this);
            this.mCountDownHandler = uoVar;
            if (uoVar.b()) {
                return;
            }
            this.mCountDownHandler.c();
        }
    }

    @Override // cn.damai.common.app.base.BaseView
    public void stopLoading() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1823318225")) {
            ipChange.ipc$dispatch("-1823318225", new Object[]{this});
        } else if (isPageFinish()) {
        } else {
            stopProgressDialog();
            this.mIsLoadFinish = true;
            if (this.mPageIndex == 1) {
                this.mRecyclerView.setRefreshing(false);
            }
        }
    }

    public void unenableChooseSeatBtn() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1962649403")) {
            ipChange.ipc$dispatch("-1962649403", new Object[]{this});
            return;
        }
        View view = this.mChooseSeatBtn;
        if (view != null) {
            view.setEnabled(false);
        }
    }
}
