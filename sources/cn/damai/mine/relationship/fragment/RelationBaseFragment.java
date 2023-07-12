package cn.damai.mine.relationship.fragment;

import android.graphics.Rect;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.annotation.Nullable;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import cn.damai.common.net.mtop.netfit.DMMtopRequestListener;
import cn.damai.common.util.ToastUtil;
import cn.damai.commonbusiness.base.DamaiBaseMvpFragment;
import cn.damai.homepage.R$id;
import cn.damai.homepage.R$layout;
import cn.damai.login.havana.ILoginListener;
import cn.damai.mine.adapter.RelationListAdapter;
import cn.damai.mine.relationship.net.RelationInfoListRequest;
import cn.damai.mine.relationship.net.RelationInfoListResponse;
import cn.damai.mine.relationship.net.RelationSelfRequest;
import cn.damai.uikit.irecycler.IRecyclerView;
import cn.damai.uikit.irecycler.OnLoadMoreListener;
import cn.damai.uikit.irecycler.OnRefreshListener;
import cn.damai.uikit.irecycler.widget.PullToRefreshHeaderView;
import com.alibaba.fastjson.JSONObject;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import java.util.ArrayList;
import java.util.List;
import tb.cb1;
import tb.t60;

/* compiled from: Taobao */
/* loaded from: classes6.dex */
public class RelationBaseFragment extends DamaiBaseMvpFragment implements ILoginListener, OnLoadMoreListener, OnRefreshListener {
    private static transient /* synthetic */ IpChange $ipChange = null;
    public static final String RELATION_TYPE_KIND_BRAND = "brand";
    public static final String RELATION_TYPE_KIND_COSTOMER = "customer";
    public static final String RELATION_TYPE_KIND_STAR = "star";
    private boolean loadingMore;
    private RelationListAdapter mAdapter;
    private LinearLayout mContainerLayout;
    private int mPageNo;
    private IRecyclerView mRecyclerView;
    private String mTargetId;
    private String mTargetType;
    private int requestPageNo;
    private TextView tvFooter;
    private boolean mIsMore = false;
    private String userId = "";
    private boolean self = false;
    private String relationType = "1";
    private String relationKind = "brand";

    public static RelationBaseFragment getInstance(String str, String str2, String str3, String str4, String str5, boolean z) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "989781889")) {
            return (RelationBaseFragment) ipChange.ipc$dispatch("989781889", new Object[]{str, str2, str3, str4, str5, Boolean.valueOf(z)});
        }
        RelationBaseFragment relationBaseFragment = new RelationBaseFragment();
        Bundle bundle = new Bundle();
        bundle.putString("relationType", str);
        bundle.putString("userId", str2);
        bundle.putString("targetType", str3);
        bundle.putString("targetId", str4);
        bundle.putString("relationKind", str5);
        bundle.putBoolean("self", z);
        relationBaseFragment.setArguments(bundle);
        return relationBaseFragment;
    }

    private void initRecyclerView() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "948742119")) {
            ipChange.ipc$dispatch("948742119", new Object[]{this});
            return;
        }
        this.mRecyclerView = (IRecyclerView) this.rootView.findViewById(R$id.irc);
        this.mRecyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));
        if (isFollowType()) {
            this.mAdapter = new RelationListAdapter(getContext(), true, this.self, this.relationKind);
        } else {
            this.mAdapter = new RelationListAdapter(getContext(), false, this.self);
        }
        this.mRecyclerView.addItemDecoration(new RecyclerView.ItemDecoration() { // from class: cn.damai.mine.relationship.fragment.RelationBaseFragment.3
            private static transient /* synthetic */ IpChange $ipChange;

            @Override // androidx.recyclerview.widget.RecyclerView.ItemDecoration
            public void getItemOffsets(Rect rect, View view, RecyclerView recyclerView, RecyclerView.State state) {
                IpChange ipChange2 = $ipChange;
                if (AndroidInstantRuntime.support(ipChange2, "-306372897")) {
                    ipChange2.ipc$dispatch("-306372897", new Object[]{this, rect, view, recyclerView, state});
                    return;
                }
                ViewGroup.LayoutParams layoutParams = view.getLayoutParams();
                if (layoutParams instanceof RecyclerView.LayoutParams) {
                    if (((RecyclerView.LayoutParams) layoutParams).getViewAdapterPosition() > 1) {
                        rect.set(0, 0, 0, t60.a(RelationBaseFragment.this.getContext(), 9.0f));
                    } else {
                        rect.set(0, 0, 0, 0);
                    }
                }
            }
        });
        LinearLayout headerContainer = this.mRecyclerView.getHeaderContainer();
        this.mRecyclerView.setAdapter(this.mAdapter);
        this.mRecyclerView.setRefreshEnabled(true);
        this.mRecyclerView.setLoadMoreEnabled(true);
        this.mRecyclerView.setIsAutoToDefault(false);
        this.mRecyclerView.setOnLoadMoreListener(this);
        this.mRecyclerView.setOnRefreshListener(this);
        this.mRecyclerView.setItemAnimator(null);
        this.mRecyclerView.setRefreshHeaderView(PullToRefreshHeaderView.getInstance(getActivity()));
        View inflate = LayoutInflater.from(getActivity()).inflate(R$layout.mine_loadmore_footer, (ViewGroup) headerContainer, false);
        this.tvFooter = (TextView) inflate.findViewById(R$id.mine_loadmore_footer);
        this.mRecyclerView.addFooterView(inflate);
        this.mRecyclerView.getFooterContainer().setVisibility(8);
    }

    private boolean isFirstPage() {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "1922575006") ? ((Boolean) ipChange.ipc$dispatch("1922575006", new Object[]{this})).booleanValue() : this.requestPageNo == 1;
    }

    private boolean isFollowType() {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "1089296554") ? ((Boolean) ipChange.ipc$dispatch("1089296554", new Object[]{this})).booleanValue() : "1".equals(this.relationType);
    }

    private void loadEmptyPage() {
        String str;
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1100710759")) {
            ipChange.ipc$dispatch("-1100710759", new Object[]{this});
            return;
        }
        if (!isFollowType()) {
            str = "暂时没有粉丝哦";
        } else if (this.self) {
            if ("brand".equals(this.relationKind)) {
                str = "你还没有关注的厂牌哦，\n去发现一些吧";
            } else if ("star".equals(this.relationKind)) {
                str = "你还没有关注艺人哦，\n去发现一些吧";
            } else {
                if (RELATION_TYPE_KIND_COSTOMER.equals(this.relationKind)) {
                    str = "你还没有关注任何人哦";
                }
                str = "暂时没有任何关注哦";
            }
        } else if ("brand".equals(this.relationKind)) {
            str = "TA没有关注任何品牌";
        } else if ("star".equals(this.relationKind)) {
            str = "TA没有关注任何艺人";
        } else {
            if (RELATION_TYPE_KIND_COSTOMER.equals(this.relationKind)) {
                str = "TA没有关注任何人";
            }
            str = "暂时没有任何关注哦";
        }
        this.mContainerLayout.setVisibility(0);
        onResponseError(3, str, "0", "", this.mContainerLayout, true);
    }

    private void loadRequest(boolean z) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1628666642")) {
            ipChange.ipc$dispatch("-1628666642", new Object[]{this, Boolean.valueOf(z)});
            return;
        }
        if (z) {
            startProgressDialog();
        }
        this.mPageNo = 1;
        if (isFollowType()) {
            requestRelationInfoList(this.mPageNo, this.userId, this.relationKind);
        } else {
            requestRelationSelfList(this.mPageNo, this.mTargetId, this.mTargetType);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void netFail(String str, String str2) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1610092056")) {
            ipChange.ipc$dispatch("-1610092056", new Object[]{this, str, str2});
            return;
        }
        stopProgressDialog();
        if (isFirstPage()) {
            this.mContainerLayout.setVisibility(0);
            onResponseError(str2, "", "", this.mContainerLayout, true);
            return;
        }
        ToastUtil.i(str2);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void netSuccess(RelationInfoListResponse relationInfoListResponse) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "798730043")) {
            ipChange.ipc$dispatch("798730043", new Object[]{this, relationInfoListResponse});
            return;
        }
        stopProgressDialog();
        List<JSONObject> arrayList = new ArrayList<>();
        if (relationInfoListResponse != null) {
            arrayList = relationInfoListResponse.getDataList();
            this.mIsMore = relationInfoListResponse.isHasNext();
        }
        onResponseSuccess(this.mContainerLayout);
        this.mContainerLayout.setVisibility(8);
        stopProgressDialog();
        cb1.c("RelationBaseFragment", "addObserver" + this.relationKind);
        if (arrayList != null) {
            if (arrayList.size() > 0) {
                if (isFirstPage()) {
                    this.mAdapter.j(arrayList);
                } else {
                    this.mAdapter.e(arrayList);
                }
            } else {
                this.loadingMore = false;
                if (isFirstPage()) {
                    loadEmptyPage();
                }
            }
            this.loadingMore = this.mIsMore;
        } else {
            this.loadingMore = false;
            if (isFirstPage()) {
                loadEmptyPage();
            }
        }
        this.mRecyclerView.getFooterContainer().setVisibility(0);
        if (this.loadingMore) {
            this.tvFooter.setText("上滑加载更多");
        } else {
            this.tvFooter.setText("只有这些哦");
        }
    }

    @Override // cn.damai.common.app.base.BaseFragment
    protected int getLayoutResource() {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "1817849204") ? ((Integer) ipChange.ipc$dispatch("1817849204", new Object[]{this})).intValue() : R$layout.layout_relation_layout;
    }

    @Override // cn.damai.commonbusiness.base.ResponseErrorPage.ErrorRefreshListener
    public void handleError(int i) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "244967316")) {
            ipChange.ipc$dispatch("244967316", new Object[]{this, Integer.valueOf(i)});
            return;
        }
        this.mContainerLayout.setVisibility(8);
        onRefresh();
    }

    @Override // cn.damai.common.app.base.BaseFragment
    public void initPresenter() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "374913303")) {
            ipChange.ipc$dispatch("374913303", new Object[]{this});
        }
    }

    @Override // cn.damai.common.app.base.BaseFragment
    protected void initView() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1784003366")) {
            ipChange.ipc$dispatch("1784003366", new Object[]{this});
            return;
        }
        initRecyclerView();
        this.mContainerLayout = (LinearLayout) this.rootView.findViewById(R$id.ll_container);
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "2060625804")) {
            ipChange.ipc$dispatch("2060625804", new Object[]{this, view});
        }
    }

    @Override // androidx.fragment.app.Fragment
    public void onCreate(@Nullable Bundle bundle) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "377648980")) {
            ipChange.ipc$dispatch("377648980", new Object[]{this, bundle});
            return;
        }
        super.onCreate(bundle);
        Bundle arguments = getArguments();
        if (arguments != null) {
            this.relationType = arguments.getString("relationType");
            this.userId = arguments.getString("userId");
            this.mTargetType = arguments.getString("targetType");
            this.mTargetId = arguments.getString("targetId");
            this.relationKind = arguments.getString("relationKind");
            this.self = arguments.getBoolean("self");
        }
        loadRequest(true);
    }

    @Override // cn.damai.uikit.irecycler.OnLoadMoreListener
    public void onLoadMore(View view) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "2116352049")) {
            ipChange.ipc$dispatch("2116352049", new Object[]{this, view});
        } else if (this.loadingMore) {
            this.mPageNo++;
            if (isFollowType()) {
                requestRelationInfoList(this.mPageNo, this.userId, this.relationKind);
            } else {
                requestRelationSelfList(this.mPageNo, this.mTargetId, this.mTargetType);
            }
        }
    }

    @Override // cn.damai.login.havana.ILoginListener
    public void onLoginCancel() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1556684501")) {
            ipChange.ipc$dispatch("-1556684501", new Object[]{this});
        }
    }

    @Override // cn.damai.login.havana.ILoginListener
    public void onLoginFail() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-154689017")) {
            ipChange.ipc$dispatch("-154689017", new Object[]{this});
        }
    }

    @Override // cn.damai.login.havana.ILoginListener
    public void onLoginSuccess() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "661440546")) {
            ipChange.ipc$dispatch("661440546", new Object[]{this});
        } else {
            onRefresh();
        }
    }

    @Override // cn.damai.login.havana.ILoginListener
    public void onLogout() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1561160142")) {
            ipChange.ipc$dispatch("-1561160142", new Object[]{this});
        }
    }

    @Override // cn.damai.uikit.irecycler.OnRefreshListener
    public void onRefresh() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-973114605")) {
            ipChange.ipc$dispatch("-973114605", new Object[]{this});
            return;
        }
        this.mRecyclerView.getFooterContainer().setVisibility(8);
        loadRequest(false);
    }

    public void requestRelationInfoList(int i, String str, String str2) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-53549281")) {
            ipChange.ipc$dispatch("-53549281", new Object[]{this, Integer.valueOf(i), str, str2});
            return;
        }
        this.requestPageNo = i;
        RelationInfoListRequest relationInfoListRequest = new RelationInfoListRequest();
        relationInfoListRequest.pageNo = i;
        relationInfoListRequest.pageSize = 20;
        if ("brand".equals(str2)) {
            relationInfoListRequest.targetTypeList = "[3,4,5,9]";
        } else if ("star".equals(str2)) {
            relationInfoListRequest.targetTypeList = "[2]";
        } else if (RELATION_TYPE_KIND_COSTOMER.equals(str2)) {
            relationInfoListRequest.targetTypeList = "[1]";
        }
        relationInfoListRequest.needQueryFansNum = true;
        relationInfoListRequest.needQueryDynamicNum = true;
        relationInfoListRequest.needQueryRecentShowInfo = true;
        if (!TextUtils.isEmpty(str)) {
            relationInfoListRequest.sourceId = str;
        }
        relationInfoListRequest.request(new DMMtopRequestListener<RelationInfoListResponse>(RelationInfoListResponse.class) { // from class: cn.damai.mine.relationship.fragment.RelationBaseFragment.2
            private static transient /* synthetic */ IpChange $ipChange;

            @Override // cn.damai.common.net.mtop.netfit.DMMtopRequestListener
            public void onFail(String str3, String str4) {
                IpChange ipChange2 = $ipChange;
                if (AndroidInstantRuntime.support(ipChange2, "-1260891136")) {
                    ipChange2.ipc$dispatch("-1260891136", new Object[]{this, str3, str4});
                } else {
                    RelationBaseFragment.this.netFail(str3, str4);
                }
            }

            @Override // cn.damai.common.net.mtop.netfit.DMMtopRequestListener
            public void onSuccess(RelationInfoListResponse relationInfoListResponse) {
                IpChange ipChange2 = $ipChange;
                if (AndroidInstantRuntime.support(ipChange2, "-1234353837")) {
                    ipChange2.ipc$dispatch("-1234353837", new Object[]{this, relationInfoListResponse});
                } else {
                    RelationBaseFragment.this.netSuccess(relationInfoListResponse);
                }
            }
        });
    }

    public void requestRelationSelfList(int i, String str, String str2) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "110386365")) {
            ipChange.ipc$dispatch("110386365", new Object[]{this, Integer.valueOf(i), str, str2});
            return;
        }
        this.requestPageNo = i;
        RelationSelfRequest relationSelfRequest = new RelationSelfRequest();
        relationSelfRequest.pageNo = i;
        relationSelfRequest.pageSize = 20;
        relationSelfRequest.targetId = str;
        relationSelfRequest.targetType = Integer.parseInt(str2);
        relationSelfRequest.request(new DMMtopRequestListener<RelationInfoListResponse>(RelationInfoListResponse.class) { // from class: cn.damai.mine.relationship.fragment.RelationBaseFragment.1
            private static transient /* synthetic */ IpChange $ipChange;

            @Override // cn.damai.common.net.mtop.netfit.DMMtopRequestListener
            public void onFail(String str3, String str4) {
                IpChange ipChange2 = $ipChange;
                if (AndroidInstantRuntime.support(ipChange2, "-1253131777")) {
                    ipChange2.ipc$dispatch("-1253131777", new Object[]{this, str3, str4});
                } else {
                    RelationBaseFragment.this.netFail(str3, str4);
                }
            }

            @Override // cn.damai.common.net.mtop.netfit.DMMtopRequestListener
            public void onSuccess(RelationInfoListResponse relationInfoListResponse) {
                IpChange ipChange2 = $ipChange;
                if (AndroidInstantRuntime.support(ipChange2, "-278832558")) {
                    ipChange2.ipc$dispatch("-278832558", new Object[]{this, relationInfoListResponse});
                } else {
                    RelationBaseFragment.this.netSuccess(relationInfoListResponse);
                }
            }
        });
    }

    @Override // cn.damai.common.app.base.BaseFragment
    public void stopProgressDialog() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1464461884")) {
            ipChange.ipc$dispatch("-1464461884", new Object[]{this});
            return;
        }
        super.stopProgressDialog();
        if (this.mPageNo == 1) {
            this.mRecyclerView.setRefreshing(false);
        }
    }
}
