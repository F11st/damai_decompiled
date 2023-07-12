package cn.damai.mine.mycollect.ui.fragment;

import android.content.DialogInterface;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import androidx.annotation.Nullable;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;
import androidx.recyclerview.widget.LinearLayoutManager;
import cn.damai.common.app.base.BaseFragment;
import cn.damai.common.app.widget.DMDialog;
import cn.damai.common.bean.RankBean;
import cn.damai.common.user.C0529c;
import cn.damai.common.util.ToastUtil;
import cn.damai.commonbusiness.base.DamaiBaseMvpFragment;
import cn.damai.homepage.R$id;
import cn.damai.homepage.R$layout;
import cn.damai.homepage.R$string;
import cn.damai.mine.mycollect.bean.MyCollectDataHolder;
import cn.damai.mine.mycollect.bean.MyCollectFollowResponse;
import cn.damai.mine.mycollect.bean.MyCollectResponse;
import cn.damai.mine.mycollect.net.MyCollectApi;
import cn.damai.mine.mycollect.net.MyCollectViewModel;
import cn.damai.mine.mycollect.ui.adapter.MyJoinAdapter;
import cn.damai.uikit.irecycler.IRecyclerView;
import cn.damai.uikit.irecycler.OnLoadMoreListener;
import cn.damai.uikit.irecycler.OnRefreshListener;
import cn.damai.uikit.irecycler.widget.PullToRefreshHeaderView;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import java.util.ArrayList;
import java.util.List;
import tb.hi1;
import tb.wh2;

/* compiled from: Taobao */
/* loaded from: classes6.dex */
public class MyJoinFragment extends DamaiBaseMvpFragment implements OnLoadMoreListener, OnRefreshListener {
    private static transient /* synthetic */ IpChange $ipChange;
    private boolean isVisibleToUser;
    private MyJoinAdapter mAdapter;
    private boolean mHasNext;
    private boolean mIsLoadFinish;
    private IRecyclerView mRecyclerView;
    private MyCollectViewModel mViewModel;
    private boolean showLoading;
    private final String NET_MSG = "网络不稳定 辛苦稍后重试";
    private List<MyCollectDataHolder> mDataHolderList = new ArrayList();
    private MyCollectDataHolder bottomDataHolder = new MyCollectDataHolder(1);
    private int mIndex = 0;
    private Observer<Integer> pageChangeObserver = new Observer<Integer>() { // from class: cn.damai.mine.mycollect.ui.fragment.MyJoinFragment.1
        private static transient /* synthetic */ IpChange $ipChange;

        @Override // androidx.lifecycle.Observer
        public void onChanged(@Nullable Integer num) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "-1100567232")) {
                ipChange.ipc$dispatch("-1100567232", new Object[]{this, num});
            } else {
                MyJoinFragment.this.pageChangeListener();
            }
        }
    };
    private Observer<MyCollectResponse> joinDataChangeObserver = new Observer<MyCollectResponse>() { // from class: cn.damai.mine.mycollect.ui.fragment.MyJoinFragment.2
        private static transient /* synthetic */ IpChange $ipChange;

        @Override // androidx.lifecycle.Observer
        public void onChanged(@Nullable MyCollectResponse myCollectResponse) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "-390898445")) {
                ipChange.ipc$dispatch("-390898445", new Object[]{this, myCollectResponse});
            } else if (MyJoinFragment.this.isPageFinish()) {
            } else {
                MyJoinFragment.this.stopLoading();
                if (myCollectResponse == null) {
                    return;
                }
                if (!myCollectResponse.requestSuccess) {
                    if (MyJoinFragment.this.mViewModel.getPageIndex().getValue().intValue() == 1) {
                        MyJoinFragment myJoinFragment = MyJoinFragment.this;
                        String str = myCollectResponse.errorMsg;
                        myJoinFragment.onResponseError(str, str, MyCollectApi.MY_COLLECT_API, ((BaseFragment) myJoinFragment).rootView, true);
                        return;
                    }
                    if (TextUtils.isEmpty(myCollectResponse.errorMsg)) {
                        myCollectResponse.errorMsg = "网络不稳定 辛苦稍后重试";
                    }
                    ToastUtil.i(myCollectResponse.errorMsg);
                    return;
                }
                MyJoinFragment myJoinFragment2 = MyJoinFragment.this;
                myJoinFragment2.onResponseSuccess(((BaseFragment) myJoinFragment2).rootView);
                MyJoinFragment.this.loadJoinData(myCollectResponse);
            }
        }
    };
    Observer<MyCollectFollowResponse> cancelFollowObserver = new Observer<MyCollectFollowResponse>() { // from class: cn.damai.mine.mycollect.ui.fragment.MyJoinFragment.3
        private static transient /* synthetic */ IpChange $ipChange;

        @Override // androidx.lifecycle.Observer
        public void onChanged(@Nullable MyCollectFollowResponse myCollectFollowResponse) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "-850270175")) {
                ipChange.ipc$dispatch("-850270175", new Object[]{this, myCollectFollowResponse});
                return;
            }
            MyJoinFragment.this.stopProgressDialog();
            if (MyJoinFragment.this.isPageFinish() || myCollectFollowResponse == null) {
                return;
            }
            if (myCollectFollowResponse.requestSuccess) {
                ToastUtil.f(MyJoinFragment.this.getString(R$string.damai_mycollect_delete_success));
                if (MyJoinFragment.this.mDeletePos <= -1 || MyJoinFragment.this.mDeletePos >= MyJoinFragment.this.mDataHolderList.size()) {
                    return;
                }
                MyJoinFragment.this.mDataHolderList.remove(MyJoinFragment.this.mDeletePos);
                if (MyJoinFragment.this.mAdapter != null) {
                    MyJoinFragment.this.mAdapter.notifyDataSetChanged();
                    return;
                }
                return;
            }
            if (TextUtils.isEmpty(myCollectFollowResponse.errorMsg)) {
                myCollectFollowResponse.errorMsg = "网络不稳定 辛苦稍后重试";
            }
            ToastUtil.i(myCollectFollowResponse.errorMsg);
        }
    };
    private int mDeletePos = -1;
    View.OnLongClickListener mItemLongListener = new View$OnLongClickListenerC1446a();

    /* compiled from: Taobao */
    /* renamed from: cn.damai.mine.mycollect.ui.fragment.MyJoinFragment$a */
    /* loaded from: classes15.dex */
    public class View$OnLongClickListenerC1446a implements View.OnLongClickListener {
        private static transient /* synthetic */ IpChange $ipChange;

        /* compiled from: Taobao */
        /* renamed from: cn.damai.mine.mycollect.ui.fragment.MyJoinFragment$a$a */
        /* loaded from: classes15.dex */
        public class DialogInterface$OnClickListenerC1447a implements DialogInterface.OnClickListener {
            private static transient /* synthetic */ IpChange $ipChange;
            final /* synthetic */ RankBean a;
            final /* synthetic */ int b;

            DialogInterface$OnClickListenerC1447a(RankBean rankBean, int i) {
                this.a = rankBean;
                this.b = i;
            }

            @Override // android.content.DialogInterface.OnClickListener
            public void onClick(DialogInterface dialogInterface, int i) {
                IpChange ipChange = $ipChange;
                if (AndroidInstantRuntime.support(ipChange, "-1922833904")) {
                    ipChange.ipc$dispatch("-1922833904", new Object[]{this, dialogInterface, Integer.valueOf(i)});
                    return;
                }
                dialogInterface.dismiss();
                MyJoinFragment myJoinFragment = MyJoinFragment.this;
                RankBean rankBean = this.a;
                myJoinFragment.requestCancelFollow(rankBean.id, rankBean.type, this.b);
            }
        }

        View$OnLongClickListenerC1446a() {
        }

        @Override // android.view.View.OnLongClickListener
        public boolean onLongClick(View view) {
            RankBean rankBean;
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "-809598118")) {
                return ((Boolean) ipChange.ipc$dispatch("-809598118", new Object[]{this, view})).booleanValue();
            }
            int intValue = ((Integer) view.getTag()).intValue();
            MyCollectDataHolder myCollectDataHolder = intValue < MyJoinFragment.this.mDataHolderList.size() ? (MyCollectDataHolder) MyJoinFragment.this.mDataHolderList.get(intValue) : null;
            if (myCollectDataHolder == null || (rankBean = myCollectDataHolder.mJoinBean) == null) {
                return false;
            }
            DMDialog dMDialog = new DMDialog(MyJoinFragment.this.getActivity());
            dMDialog.v("是否取消想看?");
            dMDialog.i("否", null);
            dMDialog.n("是", new DialogInterface$OnClickListenerC1447a(rankBean, intValue));
            dMDialog.show();
            return true;
        }
    }

    private void emptyDataPage() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1835409523")) {
            ipChange.ipc$dispatch("1835409523", new Object[]{this});
        } else {
            onResponseError(3, "你还未收藏过合辑哦(-.-)", "0", MyCollectApi.MY_COLLECT_API, this.rootView, true);
        }
    }

    private void initRecyclerView() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "422815549")) {
            ipChange.ipc$dispatch("422815549", new Object[]{this});
            return;
        }
        this.mDataHolderList.clear();
        this.mRecyclerView = (IRecyclerView) this.rootView.findViewById(R$id.irc);
        this.mRecyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));
        MyJoinAdapter myJoinAdapter = new MyJoinAdapter(getActivity(), this.mDataHolderList);
        this.mAdapter = myJoinAdapter;
        myJoinAdapter.b(this.mItemLongListener);
        this.mRecyclerView.setAdapter(this.mAdapter);
        this.mRecyclerView.setRefreshEnabled(true);
        this.mRecyclerView.setLoadMoreEnabled(true);
        this.mRecyclerView.setIsAutoToDefault(false);
        this.mRecyclerView.setOnRefreshListener(this);
        this.mRecyclerView.setOnLoadMoreListener(this);
        this.mRecyclerView.getLoadMoreFooterView().setVisibility(8);
        this.mRecyclerView.setRefreshHeaderView(PullToRefreshHeaderView.getInstance(getActivity()));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean isPageFinish() {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "-664996311") ? ((Boolean) ipChange.ipc$dispatch("-664996311", new Object[]{this})).booleanValue() : getActivity() == null || getActivity().isFinishing() || isDetached();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void loadJoinData(MyCollectResponse myCollectResponse) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-201747852")) {
            ipChange.ipc$dispatch("-201747852", new Object[]{this, myCollectResponse});
        } else if (myCollectResponse == null) {
            emptyDataPage();
        } else {
            int e = wh2.e(myCollectResponse.rankings);
            this.mHasNext = myCollectResponse.hasNext;
            int i = this.mIndex + 1;
            this.mIndex = i;
            if (i == 1) {
                this.mDataHolderList.clear();
            }
            if (e != 0) {
                for (int i2 = 0; i2 < e; i2++) {
                    RankBean rankBean = myCollectResponse.rankings.get(i2);
                    if (rankBean != null) {
                        MyCollectDataHolder myCollectDataHolder = new MyCollectDataHolder(0);
                        myCollectDataHolder.mJoinBean = rankBean;
                        this.mDataHolderList.add(myCollectDataHolder);
                    }
                }
                if (!this.mHasNext) {
                    this.mDataHolderList.add(this.bottomDataHolder);
                }
            } else if (this.mIndex != 1) {
                this.mHasNext = false;
                this.mDataHolderList.add(this.bottomDataHolder);
            }
            MyJoinAdapter myJoinAdapter = this.mAdapter;
            if (myJoinAdapter != null) {
                myJoinAdapter.notifyDataSetChanged();
            }
            if (wh2.e(this.mDataHolderList) == 0) {
                emptyDataPage();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void pageChangeListener() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "743694238")) {
            ipChange.ipc$dispatch("743694238", new Object[]{this});
        } else if (isAdded()) {
            if (this.showLoading && this.isVisibleToUser) {
                startProgressDialog();
            }
            this.mIsLoadFinish = false;
            this.mViewModel.getJoinData().observe(this, this.joinDataChangeObserver);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void requestCancelFollow(String str, int i, int i2) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1822601751")) {
            ipChange.ipc$dispatch("-1822601751", new Object[]{this, str, Integer.valueOf(i), Integer.valueOf(i2)});
        } else if (this.mViewModel != null) {
            startProgressDialog();
            this.mDeletePos = i2;
            this.mViewModel.cancelFollowData(str, String.valueOf(i)).observe(this, this.cancelFollowObserver);
            C0529c e = C0529c.e();
            hi1 m = hi1.m();
            e.x(m.k(str + "&" + i, i2));
        }
    }

    @Override // cn.damai.common.app.base.BaseFragment
    protected int getLayoutResource() {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "-1600972578") ? ((Integer) ipChange.ipc$dispatch("-1600972578", new Object[]{this})).intValue() : R$layout.layout_collect;
    }

    @Override // cn.damai.commonbusiness.base.ResponseErrorPage.ErrorRefreshListener
    public void handleError(int i) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-2145254934")) {
            ipChange.ipc$dispatch("-2145254934", new Object[]{this, Integer.valueOf(i)});
        } else if (isAdded()) {
            this.showLoading = true;
            this.mViewModel.getPageIndex().setValue(1);
        }
    }

    @Override // cn.damai.common.app.base.BaseFragment
    public void initPresenter() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-707532415")) {
            ipChange.ipc$dispatch("-707532415", new Object[]{this});
        }
    }

    @Override // cn.damai.common.app.base.BaseFragment
    protected void initView() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "662990972")) {
            ipChange.ipc$dispatch("662990972", new Object[]{this});
        } else {
            initRecyclerView();
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "383447906")) {
            ipChange.ipc$dispatch("383447906", new Object[]{this, view});
        }
    }

    @Override // androidx.fragment.app.Fragment
    public void onCreate(@Nullable Bundle bundle) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-75258306")) {
            ipChange.ipc$dispatch("-75258306", new Object[]{this, bundle});
            return;
        }
        super.onCreate(bundle);
        MyCollectViewModel myCollectViewModel = (MyCollectViewModel) ViewModelProviders.of(this).get(MyCollectViewModel.class);
        this.mViewModel = myCollectViewModel;
        myCollectViewModel.getPageIndex().observe(this, this.pageChangeObserver);
        refreshData();
    }

    @Override // cn.damai.uikit.irecycler.OnLoadMoreListener
    public void onLoadMore(View view) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "664147099")) {
            ipChange.ipc$dispatch("664147099", new Object[]{this, view});
        } else if (this.mIsLoadFinish && this.mHasNext) {
            this.showLoading = false;
            this.mViewModel.getPageIndex().setValue(Integer.valueOf(this.mIndex + 1));
        }
    }

    @Override // cn.damai.uikit.irecycler.OnRefreshListener
    public void onRefresh() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1364760451")) {
            ipChange.ipc$dispatch("-1364760451", new Object[]{this});
        } else if (isAdded()) {
            this.mIndex = 0;
            this.showLoading = false;
            this.mViewModel.getPageIndex().setValue(1);
        }
    }

    public void refreshData() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "681237940")) {
            ipChange.ipc$dispatch("681237940", new Object[]{this});
            return;
        }
        this.mIndex = 0;
        if (this.isVisibleToUser) {
            this.showLoading = true;
        }
        MyCollectViewModel myCollectViewModel = this.mViewModel;
        if (myCollectViewModel == null || myCollectViewModel.getPageIndex() == null) {
            return;
        }
        this.mViewModel.getPageIndex().setValue(1);
    }

    @Override // cn.damai.commonbusiness.base.DamaiBaseMvpFragment, cn.damai.common.app.base.BaseFragment, androidx.fragment.app.Fragment
    public void setUserVisibleHint(boolean z) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "73458191")) {
            ipChange.ipc$dispatch("73458191", new Object[]{this, Boolean.valueOf(z)});
            return;
        }
        super.setUserVisibleHint(z);
        this.isVisibleToUser = z;
    }

    public void stopLoading() {
        IRecyclerView iRecyclerView;
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-967717921")) {
            ipChange.ipc$dispatch("-967717921", new Object[]{this});
        } else if (isPageFinish()) {
        } else {
            stopProgressDialog();
            if (this.mViewModel.getPageIndex().getValue().intValue() == 1 && (iRecyclerView = this.mRecyclerView) != null) {
                iRecyclerView.setRefreshing(false);
            }
            this.mIsLoadFinish = true;
        }
    }
}
