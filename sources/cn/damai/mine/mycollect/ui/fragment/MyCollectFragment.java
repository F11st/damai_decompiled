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
import cn.damai.common.nav.DMNav;
import cn.damai.common.nav.NavUri;
import cn.damai.common.user.c;
import cn.damai.common.util.ToastUtil;
import cn.damai.commonbusiness.base.DamaiBaseMvpFragment;
import cn.damai.commonbusiness.search.bean.ProjectItemBean;
import cn.damai.homepage.R$id;
import cn.damai.homepage.R$layout;
import cn.damai.homepage.R$string;
import cn.damai.mine.mycollect.bean.MyCollectDataHolder;
import cn.damai.mine.mycollect.bean.MyCollectFollowResponse;
import cn.damai.mine.mycollect.bean.MyCollectResponse;
import cn.damai.mine.mycollect.net.MyCollectApi;
import cn.damai.mine.mycollect.net.MyCollectViewModel;
import cn.damai.mine.mycollect.ui.adapter.MyCollectAdapter;
import cn.damai.uikit.irecycler.IRecyclerView;
import cn.damai.uikit.irecycler.OnLoadMoreListener;
import cn.damai.uikit.irecycler.OnRefreshListener;
import cn.damai.uikit.irecycler.widget.PullToRefreshHeaderView;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import java.util.ArrayList;
import java.util.List;
import tb.cs;
import tb.hi1;
import tb.wh2;

/* compiled from: Taobao */
/* loaded from: classes6.dex */
public class MyCollectFragment extends DamaiBaseMvpFragment implements OnLoadMoreListener, OnRefreshListener {
    private static transient /* synthetic */ IpChange $ipChange;
    private boolean isVisibleToUser;
    private MyCollectAdapter mAdapter;
    private boolean mHasNext;
    private boolean mIsLoadFinish;
    private IRecyclerView mRecyclerView;
    private MyCollectViewModel mViewModel;
    private boolean showLoading;
    private final String NET_MSG = "网络不稳定 辛苦稍后重试";
    private List<MyCollectDataHolder> mDataHolderList = new ArrayList();
    private MyCollectDataHolder bottomDataHolder = new MyCollectDataHolder(1);
    private int mIndex = 0;
    private Observer<Integer> pageChangeObserver = new Observer<Integer>() { // from class: cn.damai.mine.mycollect.ui.fragment.MyCollectFragment.1
        private static transient /* synthetic */ IpChange $ipChange;

        @Override // androidx.lifecycle.Observer
        public void onChanged(@Nullable Integer num) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "-1395528604")) {
                ipChange.ipc$dispatch("-1395528604", new Object[]{this, num});
            } else {
                MyCollectFragment.this.pageChangeListener();
            }
        }
    };
    private Observer<MyCollectResponse> collectDataChangeObserver = new Observer<MyCollectResponse>() { // from class: cn.damai.mine.mycollect.ui.fragment.MyCollectFragment.2
        private static transient /* synthetic */ IpChange $ipChange;

        @Override // androidx.lifecycle.Observer
        public void onChanged(@Nullable MyCollectResponse myCollectResponse) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "212639823")) {
                ipChange.ipc$dispatch("212639823", new Object[]{this, myCollectResponse});
                return;
            }
            MyCollectFragment.this.stopLoading();
            if (MyCollectFragment.this.isPageFinish() || myCollectResponse == null) {
                return;
            }
            if (!myCollectResponse.requestSuccess) {
                if (MyCollectFragment.this.mViewModel.getPageIndex().getValue().intValue() == 1) {
                    MyCollectFragment myCollectFragment = MyCollectFragment.this;
                    String str = myCollectResponse.errorMsg;
                    myCollectFragment.onResponseError(str, str, MyCollectApi.MY_COLLECT_API, ((BaseFragment) myCollectFragment).rootView, true);
                    return;
                }
                if (TextUtils.isEmpty(myCollectResponse.errorMsg)) {
                    myCollectResponse.errorMsg = "网络不稳定 辛苦稍后重试";
                }
                ToastUtil.i(myCollectResponse.errorMsg);
                return;
            }
            MyCollectFragment myCollectFragment2 = MyCollectFragment.this;
            myCollectFragment2.onResponseSuccess(((BaseFragment) myCollectFragment2).rootView);
            MyCollectFragment.this.loadCollectData(myCollectResponse);
        }
    };
    Observer<MyCollectFollowResponse> cancelFollowObserver = new Observer<MyCollectFollowResponse>() { // from class: cn.damai.mine.mycollect.ui.fragment.MyCollectFragment.3
        private static transient /* synthetic */ IpChange $ipChange;

        @Override // androidx.lifecycle.Observer
        public void onChanged(@Nullable MyCollectFollowResponse myCollectFollowResponse) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "-1765132675")) {
                ipChange.ipc$dispatch("-1765132675", new Object[]{this, myCollectFollowResponse});
                return;
            }
            MyCollectFragment.this.stopProgressDialog();
            if (MyCollectFragment.this.isPageFinish() || myCollectFollowResponse == null) {
                return;
            }
            if (myCollectFollowResponse.requestSuccess) {
                ToastUtil.f(MyCollectFragment.this.getString(R$string.damai_mycollect_delete_success));
                if (MyCollectFragment.this.mDeletePos <= -1 || MyCollectFragment.this.mDeletePos >= MyCollectFragment.this.mDataHolderList.size()) {
                    return;
                }
                MyCollectFragment.this.mDataHolderList.remove(MyCollectFragment.this.mDeletePos);
                if (MyCollectFragment.this.mAdapter != null) {
                    MyCollectFragment.this.mAdapter.notifyDataSetChanged();
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
    View.OnLongClickListener mItemLongListener = new a();
    View.OnClickListener mItemClickListener = new b();

    /* compiled from: Taobao */
    /* loaded from: classes15.dex */
    public class a implements View.OnLongClickListener {
        private static transient /* synthetic */ IpChange $ipChange;

        /* compiled from: Taobao */
        /* renamed from: cn.damai.mine.mycollect.ui.fragment.MyCollectFragment$a$a  reason: collision with other inner class name */
        /* loaded from: classes15.dex */
        public class DialogInterface$OnClickListenerC0056a implements DialogInterface.OnClickListener {
            private static transient /* synthetic */ IpChange $ipChange;
            final /* synthetic */ ProjectItemBean a;
            final /* synthetic */ int b;

            DialogInterface$OnClickListenerC0056a(ProjectItemBean projectItemBean, int i) {
                this.a = projectItemBean;
                this.b = i;
            }

            @Override // android.content.DialogInterface.OnClickListener
            public void onClick(DialogInterface dialogInterface, int i) {
                IpChange ipChange = $ipChange;
                if (AndroidInstantRuntime.support(ipChange, "968226412")) {
                    ipChange.ipc$dispatch("968226412", new Object[]{this, dialogInterface, Integer.valueOf(i)});
                    return;
                }
                dialogInterface.dismiss();
                MyCollectFragment myCollectFragment = MyCollectFragment.this;
                ProjectItemBean projectItemBean = this.a;
                myCollectFragment.requestCancelFollow(projectItemBean.id, projectItemBean.isNewItem == 1 ? 7 : 6, this.b);
            }
        }

        a() {
        }

        @Override // android.view.View.OnLongClickListener
        public boolean onLongClick(View view) {
            ProjectItemBean projectItemBean;
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "-799635074")) {
                return ((Boolean) ipChange.ipc$dispatch("-799635074", new Object[]{this, view})).booleanValue();
            }
            int intValue = ((Integer) view.getTag()).intValue();
            MyCollectDataHolder myCollectDataHolder = intValue < MyCollectFragment.this.mDataHolderList.size() ? (MyCollectDataHolder) MyCollectFragment.this.mDataHolderList.get(intValue) : null;
            if (myCollectDataHolder == null || (projectItemBean = myCollectDataHolder.mProjectItemBean) == null) {
                return false;
            }
            DMDialog dMDialog = new DMDialog(MyCollectFragment.this.getActivity());
            dMDialog.v("是否取消想看?");
            dMDialog.i("否", null);
            dMDialog.n("是", new DialogInterface$OnClickListenerC0056a(projectItemBean, intValue));
            dMDialog.show();
            return true;
        }
    }

    /* compiled from: Taobao */
    /* loaded from: classes15.dex */
    public class b implements View.OnClickListener {
        private static transient /* synthetic */ IpChange $ipChange;

        b() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            ProjectItemBean projectItemBean;
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "1844535831")) {
                ipChange.ipc$dispatch("1844535831", new Object[]{this, view});
                return;
            }
            int intValue = ((Integer) view.getTag()).intValue();
            MyCollectDataHolder myCollectDataHolder = intValue < MyCollectFragment.this.mDataHolderList.size() ? (MyCollectDataHolder) MyCollectFragment.this.mDataHolderList.get(intValue) : null;
            if (myCollectDataHolder == null || (projectItemBean = myCollectDataHolder.mProjectItemBean) == null) {
                return;
            }
            c e = c.e();
            hi1 m = hi1.m();
            e.x(m.l(projectItemBean.id + "&6", intValue));
            if (TextUtils.isEmpty(projectItemBean.schema)) {
                DMNav.from(MyCollectFragment.this.getActivity()).withExtras(MyCollectFragment.this.getProjectPrice(projectItemBean)).forResult(1001).toUri(NavUri.b(cs.b));
            } else {
                DMNav.from(MyCollectFragment.this.getActivity()).forResult(1001).toUri(projectItemBean.schema);
            }
        }
    }

    private void emptyDataPage() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1958697777")) {
            ipChange.ipc$dispatch("-1958697777", new Object[]{this});
        } else {
            onResponseError(3, "你还未收藏过演出哦(-.-)", "0", MyCollectApi.MY_COLLECT_API, this.rootView, true);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public Bundle getProjectPrice(ProjectItemBean projectItemBean) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "317922747")) {
            return (Bundle) ipChange.ipc$dispatch("317922747", new Object[]{this, projectItemBean});
        }
        Bundle bundle = new Bundle();
        if (projectItemBean != null) {
            bundle.putString("projectId", projectItemBean.id);
            bundle.putString("projectName", projectItemBean.name);
            bundle.putString("projectImage", projectItemBean.verticalPic);
        }
        return bundle;
    }

    private void initRecyclerView() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "826570081")) {
            ipChange.ipc$dispatch("826570081", new Object[]{this});
            return;
        }
        this.mDataHolderList.clear();
        this.mRecyclerView = (IRecyclerView) this.rootView.findViewById(R$id.irc);
        this.mRecyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));
        MyCollectAdapter myCollectAdapter = new MyCollectAdapter(getActivity(), this.mDataHolderList);
        this.mAdapter = myCollectAdapter;
        myCollectAdapter.a(this.mItemClickListener, this.mItemLongListener);
        this.mRecyclerView.setAdapter(this.mAdapter);
        this.mRecyclerView.setRefreshEnabled(true);
        this.mRecyclerView.setLoadMoreEnabled(true);
        this.mRecyclerView.setIsAutoToDefault(false);
        this.mRecyclerView.setOnLoadMoreListener(this);
        this.mRecyclerView.setOnRefreshListener(this);
        this.mRecyclerView.getLoadMoreFooterView().setVisibility(8);
        this.mRecyclerView.setRefreshHeaderView(PullToRefreshHeaderView.getInstance(getActivity()));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean isPageFinish() {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "1429370445") ? ((Boolean) ipChange.ipc$dispatch("1429370445", new Object[]{this})).booleanValue() : getActivity() == null || getActivity().isFinishing() || isDetached();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void loadCollectData(MyCollectResponse myCollectResponse) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "714345380")) {
            ipChange.ipc$dispatch("714345380", new Object[]{this, myCollectResponse});
        } else if (myCollectResponse == null) {
            emptyDataPage();
        } else {
            int e = wh2.e(myCollectResponse.items);
            this.mHasNext = myCollectResponse.hasNext;
            int i = this.mIndex + 1;
            this.mIndex = i;
            if (i == 1) {
                this.mDataHolderList.clear();
            }
            if (e != 0) {
                for (int i2 = 0; i2 < e; i2++) {
                    ProjectItemBean projectItemBean = myCollectResponse.items.get(i2);
                    if (projectItemBean != null) {
                        MyCollectDataHolder myCollectDataHolder = new MyCollectDataHolder(0);
                        myCollectDataHolder.mProjectItemBean = projectItemBean;
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
            MyCollectAdapter myCollectAdapter = this.mAdapter;
            if (myCollectAdapter != null) {
                myCollectAdapter.notifyDataSetChanged();
            }
            if (wh2.e(this.mDataHolderList) == 0) {
                emptyDataPage();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void pageChangeListener() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-2090224446")) {
            ipChange.ipc$dispatch("-2090224446", new Object[]{this});
        } else if (isAdded()) {
            if (this.showLoading && this.isVisibleToUser) {
                startProgressDialog();
            }
            this.mIsLoadFinish = false;
            this.mViewModel.getCollectData().observe(this, this.collectDataChangeObserver);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void requestCancelFollow(String str, int i, int i2) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "444389189")) {
            ipChange.ipc$dispatch("444389189", new Object[]{this, str, Integer.valueOf(i), Integer.valueOf(i2)});
        } else if (this.mViewModel != null) {
            startProgressDialog();
            this.mDeletePos = i2;
            this.mViewModel.cancelFollowData(str, String.valueOf(i)).observe(this, this.cancelFollowObserver);
            c e = c.e();
            hi1 m = hi1.m();
            e.x(m.k(str + "&" + i, i2));
        }
    }

    @Override // cn.damai.common.app.base.BaseFragment
    protected int getLayoutResource() {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "-1969483974") ? ((Integer) ipChange.ipc$dispatch("-1969483974", new Object[]{this})).intValue() : R$layout.layout_collect;
    }

    @Override // cn.damai.commonbusiness.base.ResponseErrorPage.ErrorRefreshListener
    public void handleError(int i) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-50888178")) {
            ipChange.ipc$dispatch("-50888178", new Object[]{this, Integer.valueOf(i)});
        } else if (isAdded()) {
            this.showLoading = true;
            this.mViewModel.getPageIndex().setValue(1);
        }
    }

    @Override // cn.damai.common.app.base.BaseFragment
    public void initPresenter() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-206672419")) {
            ipChange.ipc$dispatch("-206672419", new Object[]{this});
        }
    }

    @Override // cn.damai.common.app.base.BaseFragment
    protected void initView() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "2068292256")) {
            ipChange.ipc$dispatch("2068292256", new Object[]{this});
        } else {
            initRecyclerView();
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1391158406")) {
            ipChange.ipc$dispatch("1391158406", new Object[]{this, view});
        }
    }

    @Override // androidx.fragment.app.Fragment
    public void onCreate(@Nullable Bundle bundle) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1098996122")) {
            ipChange.ipc$dispatch("1098996122", new Object[]{this, bundle});
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
        if (AndroidInstantRuntime.support(ipChange, "-453746441")) {
            ipChange.ipc$dispatch("-453746441", new Object[]{this, view});
        } else if (this.mIsLoadFinish && this.mHasNext) {
            this.showLoading = false;
            this.mViewModel.getPageIndex().setValue(Integer.valueOf(this.mIndex + 1));
        }
    }

    @Override // cn.damai.uikit.irecycler.OnRefreshListener
    public void onRefresh() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-750093607")) {
            ipChange.ipc$dispatch("-750093607", new Object[]{this});
        } else if (isAdded()) {
            this.showLoading = false;
            this.mIndex = 0;
            this.mViewModel.getPageIndex().setValue(1);
        }
    }

    public void refreshData() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1329411824")) {
            ipChange.ipc$dispatch("-1329411824", new Object[]{this});
            return;
        }
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
        if (AndroidInstantRuntime.support(ipChange, "-1878675093")) {
            ipChange.ipc$dispatch("-1878675093", new Object[]{this, Boolean.valueOf(z)});
            return;
        }
        super.setUserVisibleHint(z);
        this.isVisibleToUser = z;
    }

    public void stopLoading() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1316599611")) {
            ipChange.ipc$dispatch("1316599611", new Object[]{this});
        } else if (isPageFinish()) {
        } else {
            stopProgressDialog();
            if (this.mViewModel.getPageIndex().getValue().intValue() == 1) {
                this.mRecyclerView.setRefreshing(false);
            }
            this.mIsLoadFinish = true;
        }
    }
}
