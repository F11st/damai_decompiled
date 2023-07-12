package cn.damai.mine.wantpraise.fragment;

import android.graphics.Rect;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.annotation.Nullable;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import cn.damai.common.net.mtop.netfit.DMMtopRequestListener;
import cn.damai.commonbusiness.base.DamaiBaseMvpFragment;
import cn.damai.homepage.R$id;
import cn.damai.homepage.R$layout;
import cn.damai.login.havana.ILoginListener;
import cn.damai.mine.wantpraise.WantListAdapter;
import cn.damai.mine.wantpraise.WantPriseCallback;
import cn.damai.mine.wantpraise.net.WantPriseListRequest;
import cn.damai.mine.wantpraise.net.WantPriseListResponse;
import cn.damai.uikit.irecycler.IRecyclerView;
import cn.damai.uikit.irecycler.OnLoadMoreListener;
import cn.damai.uikit.irecycler.OnRefreshListener;
import cn.damai.uikit.irecycler.widget.PullToRefreshHeaderView;
import com.alibaba.fastjson.JSONObject;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import java.util.ArrayList;
import java.util.List;
import tb.t60;

/* compiled from: Taobao */
/* loaded from: classes6.dex */
public class WantPraiseBaseFragment extends DamaiBaseMvpFragment implements ILoginListener, OnLoadMoreListener, OnRefreshListener {
    private static transient /* synthetic */ IpChange $ipChange = null;
    public static final String WANT_PRISE_TYPE_PRISE = "0";
    public static final String WANT_PRISE_TYPE_WANT = "1";
    private WantPriseCallback callback;
    private WantListAdapter mAdapter;
    private LinearLayout mContainerLayout;
    private IRecyclerView mRecyclerView;
    private RelativeLayout rlPraise;
    private TextView tvFooter;
    private TextView tvPriseNum;
    private String wantEmptyStr = "还没有人点了想看哦";
    private String praiseEmptyStr = "还没有人点赞哦";
    private String wantSeeType = "1";
    private String targetIdStr = "";
    private boolean self = false;

    public static WantPraiseBaseFragment getInstance(String str, String str2, boolean z) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1053708517")) {
            return (WantPraiseBaseFragment) ipChange.ipc$dispatch("-1053708517", new Object[]{str, str2, Boolean.valueOf(z)});
        }
        WantPraiseBaseFragment wantPraiseBaseFragment = new WantPraiseBaseFragment();
        Bundle bundle = new Bundle();
        bundle.putString("wantSeeType", str);
        bundle.putString("targetIdStr", str2);
        bundle.putBoolean("self", z);
        wantPraiseBaseFragment.setArguments(bundle);
        return wantPraiseBaseFragment;
    }

    private void initRecyclerView() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1487585813")) {
            ipChange.ipc$dispatch("-1487585813", new Object[]{this});
            return;
        }
        this.mRecyclerView = (IRecyclerView) this.rootView.findViewById(R$id.irc);
        this.mRecyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));
        WantListAdapter wantListAdapter = new WantListAdapter(getContext(), this.self);
        this.mAdapter = wantListAdapter;
        this.mRecyclerView.setAdapter(wantListAdapter);
        this.mRecyclerView.addItemDecoration(new RecyclerView.ItemDecoration() { // from class: cn.damai.mine.wantpraise.fragment.WantPraiseBaseFragment.2
            private static transient /* synthetic */ IpChange $ipChange;

            @Override // androidx.recyclerview.widget.RecyclerView.ItemDecoration
            public void getItemOffsets(Rect rect, View view, RecyclerView recyclerView, RecyclerView.State state) {
                IpChange ipChange2 = $ipChange;
                if (AndroidInstantRuntime.support(ipChange2, "1365106978")) {
                    ipChange2.ipc$dispatch("1365106978", new Object[]{this, rect, view, recyclerView, state});
                    return;
                }
                ViewGroup.LayoutParams layoutParams = view.getLayoutParams();
                if (layoutParams instanceof RecyclerView.LayoutParams) {
                    if (((RecyclerView.LayoutParams) layoutParams).getViewAdapterPosition() > 1) {
                        rect.set(0, 0, 0, t60.a(WantPraiseBaseFragment.this.getContext(), 9.0f));
                    } else {
                        rect.set(0, 0, 0, 0);
                    }
                }
            }
        });
        this.mRecyclerView.setRefreshEnabled(true);
        this.mRecyclerView.setLoadMoreEnabled(false);
        this.mRecyclerView.setIsAutoToDefault(false);
        this.mRecyclerView.setOnLoadMoreListener(this);
        this.mRecyclerView.setOnRefreshListener(this);
        this.mRecyclerView.getLoadMoreFooterView().setVisibility(8);
        this.mRecyclerView.setRefreshHeaderView(PullToRefreshHeaderView.getInstance(getActivity()));
        View inflate = LayoutInflater.from(getActivity()).inflate(R$layout.mine_loadmore_footer, (ViewGroup) this.mRecyclerView.getHeaderContainer(), false);
        this.tvFooter = (TextView) inflate.findViewById(R$id.mine_loadmore_footer);
        this.mRecyclerView.addFooterView(inflate);
        this.mRecyclerView.getFooterContainer().setVisibility(8);
    }

    private void loadEmptyPage(String str) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1999162465")) {
            ipChange.ipc$dispatch("-1999162465", new Object[]{this, str});
            return;
        }
        if (this.rlPraise.getVisibility() == 0) {
            this.rlPraise.setVisibility(8);
        }
        this.mContainerLayout.setVisibility(0);
        onResponseError(3, str, "0", "", this.mContainerLayout, true);
    }

    private void loadRequest(boolean z) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1906787086")) {
            ipChange.ipc$dispatch("-1906787086", new Object[]{this, Boolean.valueOf(z)});
            return;
        }
        if (z) {
            startProgressDialog();
        }
        requestInfoList(this.targetIdStr, this.wantSeeType);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void netFail(String str, String str2) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1909832036")) {
            ipChange.ipc$dispatch("1909832036", new Object[]{this, str, str2});
            return;
        }
        stopProgressDialog();
        if (this.rlPraise.getVisibility() == 0) {
            this.rlPraise.setVisibility(8);
        }
        this.mContainerLayout.setVisibility(0);
        onResponseError(str2, "", "", this.mContainerLayout, true);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void netSuccess(WantPriseListResponse wantPriseListResponse) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1616024980")) {
            ipChange.ipc$dispatch("1616024980", new Object[]{this, wantPriseListResponse});
            return;
        }
        stopProgressDialog();
        List<JSONObject> arrayList = new ArrayList<>();
        if (wantPriseListResponse != null) {
            arrayList = wantPriseListResponse.getDataList();
            WantPriseCallback wantPriseCallback = this.callback;
            if (wantPriseCallback != null) {
                wantPriseCallback.titleRefresh(wantPriseListResponse.getWantCount(), wantPriseListResponse.getPraiseCount());
            }
        }
        if ("0".equals(this.wantSeeType)) {
            try {
                if ((!TextUtils.isEmpty(wantPriseListResponse.getPraiseCount()) ? Integer.parseInt(wantPriseListResponse.getPraiseCount()) : 0) > 0) {
                    this.mRecyclerView.setVisibility(8);
                    this.mContainerLayout.setVisibility(8);
                    onResponseSuccess(this.mContainerLayout);
                    this.rlPraise.setVisibility(0);
                    this.tvPriseNum.setText(wantPriseListResponse.getPraiseCount());
                    return;
                }
                loadEmptyPage(this.praiseEmptyStr);
                return;
            } catch (Exception unused) {
                loadEmptyPage(this.praiseEmptyStr);
                return;
            }
        }
        this.mContainerLayout.setVisibility(8);
        onResponseSuccess(this.mContainerLayout);
        if (this.rlPraise.getVisibility() == 0) {
            this.rlPraise.setVisibility(8);
        }
        stopProgressDialog();
        if (arrayList != null) {
            if (arrayList.size() > 0) {
                if (this.mRecyclerView.getVisibility() == 8) {
                    this.mRecyclerView.setVisibility(0);
                }
                this.mAdapter.e(arrayList);
            } else {
                loadEmptyPage(this.wantEmptyStr);
            }
        } else {
            loadEmptyPage(this.wantEmptyStr);
        }
        this.mRecyclerView.getFooterContainer().setVisibility(0);
        this.tvFooter.setText("只有这些哦");
    }

    @Override // cn.damai.common.app.base.BaseFragment
    protected int getLayoutResource() {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "-693872656") ? ((Integer) ipChange.ipc$dispatch("-693872656", new Object[]{this})).intValue() : R$layout.layout_want_prasie_layout;
    }

    @Override // cn.damai.commonbusiness.base.ResponseErrorPage.ErrorRefreshListener
    public void handleError(int i) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-33153128")) {
            ipChange.ipc$dispatch("-33153128", new Object[]{this, Integer.valueOf(i)});
            return;
        }
        this.mContainerLayout.setVisibility(8);
        loadRequest(true);
    }

    @Override // cn.damai.common.app.base.BaseFragment
    public void initPresenter() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "343114131")) {
            ipChange.ipc$dispatch("343114131", new Object[]{this});
        }
    }

    @Override // cn.damai.common.app.base.BaseFragment
    protected void initView() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1904645418")) {
            ipChange.ipc$dispatch("1904645418", new Object[]{this});
            return;
        }
        initRecyclerView();
        this.mContainerLayout = (LinearLayout) this.rootView.findViewById(R$id.ll_container);
        this.rlPraise = (RelativeLayout) this.rootView.findViewById(R$id.rl_praise_layout);
        this.tvPriseNum = (TextView) this.rootView.findViewById(R$id.tv_prise_num);
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1676314768")) {
            ipChange.ipc$dispatch("1676314768", new Object[]{this, view});
        }
    }

    @Override // androidx.fragment.app.Fragment
    public void onCreate(@Nullable Bundle bundle) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1348908752")) {
            ipChange.ipc$dispatch("1348908752", new Object[]{this, bundle});
            return;
        }
        super.onCreate(bundle);
        Bundle arguments = getArguments();
        if (arguments != null) {
            this.targetIdStr = arguments.getString("targetIdStr");
            this.wantSeeType = arguments.getString("wantSeeType");
            this.self = arguments.getBoolean("self");
        }
        loadRequest(true);
    }

    @Override // cn.damai.uikit.irecycler.OnLoadMoreListener
    public void onLoadMore(View view) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-805877587")) {
            ipChange.ipc$dispatch("-805877587", new Object[]{this, view});
        }
    }

    @Override // cn.damai.login.havana.ILoginListener
    public void onLoginCancel() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1588483673")) {
            ipChange.ipc$dispatch("-1588483673", new Object[]{this});
        }
    }

    @Override // cn.damai.login.havana.ILoginListener
    public void onLoginFail() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-994944637")) {
            ipChange.ipc$dispatch("-994944637", new Object[]{this});
        }
    }

    @Override // cn.damai.login.havana.ILoginListener
    public void onLoginSuccess() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-324333786")) {
            ipChange.ipc$dispatch("-324333786", new Object[]{this});
        } else {
            onRefresh();
        }
    }

    @Override // cn.damai.login.havana.ILoginListener
    public void onLogout() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1440518090")) {
            ipChange.ipc$dispatch("-1440518090", new Object[]{this});
        }
    }

    @Override // cn.damai.uikit.irecycler.OnRefreshListener
    public void onRefresh() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1528178289")) {
            ipChange.ipc$dispatch("-1528178289", new Object[]{this});
            return;
        }
        this.mRecyclerView.getFooterContainer().setVisibility(8);
        loadRequest(false);
    }

    public void requestInfoList(String str, String str2) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-84176988")) {
            ipChange.ipc$dispatch("-84176988", new Object[]{this, str, str2});
            return;
        }
        WantPriseListRequest wantPriseListRequest = new WantPriseListRequest();
        wantPriseListRequest.wantSeeType = str2;
        wantPriseListRequest.targetIdStr = str;
        wantPriseListRequest.request(new DMMtopRequestListener<WantPriseListResponse>(WantPriseListResponse.class) { // from class: cn.damai.mine.wantpraise.fragment.WantPraiseBaseFragment.1
            private static transient /* synthetic */ IpChange $ipChange;

            @Override // cn.damai.common.net.mtop.netfit.DMMtopRequestListener
            public void onFail(String str3, String str4) {
                IpChange ipChange2 = $ipChange;
                if (AndroidInstantRuntime.support(ipChange2, "490332675")) {
                    ipChange2.ipc$dispatch("490332675", new Object[]{this, str3, str4});
                } else {
                    WantPraiseBaseFragment.this.netFail(str3, str4);
                }
            }

            @Override // cn.damai.common.net.mtop.netfit.DMMtopRequestListener
            public void onSuccess(WantPriseListResponse wantPriseListResponse) {
                IpChange ipChange2 = $ipChange;
                if (AndroidInstantRuntime.support(ipChange2, "-1183739243")) {
                    ipChange2.ipc$dispatch("-1183739243", new Object[]{this, wantPriseListResponse});
                } else {
                    WantPraiseBaseFragment.this.netSuccess(wantPriseListResponse);
                }
            }
        });
    }

    public void setCallback(WantPriseCallback wantPriseCallback) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "729082759")) {
            ipChange.ipc$dispatch("729082759", new Object[]{this, wantPriseCallback});
        } else {
            this.callback = wantPriseCallback;
        }
    }

    @Override // cn.damai.common.app.base.BaseFragment
    public void stopProgressDialog() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-2018428216")) {
            ipChange.ipc$dispatch("-2018428216", new Object[]{this});
            return;
        }
        super.stopProgressDialog();
        this.mRecyclerView.setRefreshing(false);
    }
}
