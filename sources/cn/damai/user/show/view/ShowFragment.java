package cn.damai.user.show.view;

import android.os.Bundle;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.recyclerview.widget.LinearLayoutManager;
import cn.damai.common.app.base.BaseFragment;
import cn.damai.common.net.mtop.netfit.DMMtopRequestListener;
import cn.damai.common.user.b;
import cn.damai.common.user.c;
import cn.damai.commonbusiness.search.bean.ProjectItemBean;
import cn.damai.commonbusiness.search.bean.SearchResultBean;
import cn.damai.homepage.R$id;
import cn.damai.homepage.R$layout;
import cn.damai.issue.tool.IssueConstants;
import cn.damai.uikit.irecycler.IRecyclerView;
import cn.damai.uikit.irecycler.OnLoadMoreListener;
import cn.damai.uikit.irecycler.widget.LoadMoreFooterView;
import cn.damai.user.show.adapter.ShowAdapter;
import cn.damai.user.show.bean.ShowDataHolder;
import cn.damai.user.show.bean.ShowRequest;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import tb.ja1;
import tb.qd2;
import tb.t60;
import tb.wh2;
import tb.z20;

/* compiled from: Taobao */
/* loaded from: classes9.dex */
public class ShowFragment extends BaseFragment implements OnLoadMoreListener {
    private static transient /* synthetic */ IpChange $ipChange = null;
    public static final String ID = "id";
    public static final String TYPE = "type";
    private ShowAdapter mAdapter;
    private View mEmptyFoot;
    private View mEmptyView;
    private LinearLayoutManager mLinearLayoutManager;
    private IRecyclerView mRecyclerView;
    private List<ShowDataHolder> mDataHolderList = new ArrayList();
    private int mType = -1;
    private String mId = "";
    private int mPageIndex = 1;
    private int mPageSize = 15;
    private int mProjectSize = 0;
    private int mProjectAllSize = 0;
    private View.OnClickListener mItemClick = new a();

    /* compiled from: Taobao */
    /* loaded from: classes17.dex */
    public class a implements View.OnClickListener {
        private static transient /* synthetic */ IpChange $ipChange;

        a() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            ShowDataHolder showDataHolder;
            ProjectItemBean projectItemBean;
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "-1101654142")) {
                ipChange.ipc$dispatch("-1101654142", new Object[]{this, view});
            } else if (view.getTag() == null) {
            } else {
                try {
                    int intValue = ((Integer) view.getTag()).intValue();
                    if (intValue < 0 || intValue >= ShowFragment.this.mAdapter.getItemCount() || (showDataHolder = ShowFragment.this.mAdapter.getData().get(intValue)) == null || showDataHolder.mType != 0 || (projectItemBean = showDataHolder.mProjectItem) == null) {
                        return;
                    }
                    Bundle bundle = new Bundle();
                    bundle.putString(IssueConstants.ProjectID, projectItemBean.id);
                    bundle.putString("projectName", projectItemBean.name);
                    bundle.putString("projectImage", projectItemBean.verticalPic);
                    bundle.putString("projectPrice", ShowFragment.this.getProjectPrice(projectItemBean.formattedPriceStr, projectItemBean.promotionPrice, projectItemBean.displayStatus));
                    qd2.a(ShowFragment.this.getActivity(), projectItemBean.schema, bundle);
                    HashMap hashMap = new HashMap();
                    hashMap.put("usercode", z20.E());
                    hashMap.put("biz_id", ShowFragment.this.mId);
                    hashMap.put("biz_type", ShowFragment.this.mType + "");
                    b bVar = new b();
                    c.e().x(bVar.e("business_homepage", "detials", "project_list_" + intValue, hashMap, Boolean.TRUE));
                } catch (Exception unused) {
                }
            }
        }
    }

    static /* synthetic */ int access$010(ShowFragment showFragment) {
        int i = showFragment.mPageIndex;
        showFragment.mPageIndex = i - 1;
        return i;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public String getProjectPrice(String str, String str2, String str3) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-490975967")) {
            return (String) ipChange.ipc$dispatch("-490975967", new Object[]{this, str, str2, str3});
        }
        if (TextUtils.isEmpty(str3)) {
            if (!TextUtils.isEmpty(str2)) {
                return String.format("%1$s%2$s", "¥", str2);
            }
            return String.format("%1$s%2$s", "¥", str);
        }
        return "";
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setEmptyView() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1774827187")) {
            ipChange.ipc$dispatch("1774827187", new Object[]{this});
            return;
        }
        this.mRecyclerView.setVisibility(8);
        this.mEmptyView.setVisibility(0);
    }

    public void getData() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "467900935")) {
            ipChange.ipc$dispatch("467900935", new Object[]{this});
            return;
        }
        ShowRequest showRequest = new ShowRequest();
        int i = this.mType;
        if (i == 2) {
            showRequest.artistId = this.mId;
        } else if (i == 3) {
            showRequest.venueId = this.mId;
        } else if (i == 4) {
            showRequest.brandId = this.mId;
        } else if (i == 5) {
            showRequest.repertoireId = this.mId;
        } else if (i == 9) {
            showRequest.categoryId = this.mId;
        }
        showRequest.distanceCityId = z20.c();
        showRequest.pageIndex = String.valueOf(this.mPageIndex);
        showRequest.pageSize = String.valueOf(this.mPageSize);
        double[] b = ja1.b();
        if (b != null) {
            showRequest.longitude = String.valueOf(b[0]);
            showRequest.latitude = String.valueOf(b[1]);
        }
        showRequest.request(new DMMtopRequestListener<SearchResultBean>(SearchResultBean.class) { // from class: cn.damai.user.show.view.ShowFragment.1
            private static transient /* synthetic */ IpChange $ipChange;

            @Override // cn.damai.common.net.mtop.netfit.DMMtopRequestListener
            public void onFail(String str, String str2) {
                IpChange ipChange2 = $ipChange;
                if (AndroidInstantRuntime.support(ipChange2, "-2020918809")) {
                    ipChange2.ipc$dispatch("-2020918809", new Object[]{this, str, str2});
                } else if (ShowFragment.this.mPageIndex <= 1) {
                    ShowFragment.this.setEmptyView();
                } else {
                    ShowFragment.access$010(ShowFragment.this);
                }
            }

            @Override // cn.damai.common.net.mtop.netfit.DMMtopRequestListener
            public void onSuccess(SearchResultBean searchResultBean) {
                IpChange ipChange2 = $ipChange;
                if (AndroidInstantRuntime.support(ipChange2, "1588099695")) {
                    ipChange2.ipc$dispatch("1588099695", new Object[]{this, searchResultBean});
                } else if (searchResultBean == null) {
                    if (ShowFragment.this.mPageIndex == 1) {
                        ShowFragment.this.setEmptyView();
                    }
                } else {
                    int e = wh2.e(searchResultBean.projectInfo);
                    ShowFragment.this.mProjectSize += e;
                    if (ShowFragment.this.mPageIndex != 1 || ShowFragment.this.mProjectSize != 0) {
                        ShowFragment.this.mProjectAllSize = searchResultBean.total;
                        for (int i2 = 0; i2 < e; i2++) {
                            ShowDataHolder showDataHolder = new ShowDataHolder(0);
                            showDataHolder.mProjectItem = searchResultBean.projectInfo.get(i2);
                            showDataHolder.isRecommendProject = false;
                            ShowFragment.this.mDataHolderList.add(showDataHolder);
                        }
                        ShowFragment.this.mAdapter.notifyDataSetChanged();
                        return;
                    }
                    ShowFragment.this.setEmptyView();
                }
            }
        });
    }

    @Override // cn.damai.common.app.base.BaseFragment
    protected int getLayoutResource() {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "-918307188") ? ((Integer) ipChange.ipc$dispatch("-918307188", new Object[]{this})).intValue() : R$layout.fragment_show;
    }

    @Override // cn.damai.common.app.base.BaseFragment
    public void initPresenter() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-165243345")) {
            ipChange.ipc$dispatch("-165243345", new Object[]{this});
        }
    }

    @Override // cn.damai.common.app.base.BaseFragment
    protected void initView() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-471331058")) {
            ipChange.ipc$dispatch("-471331058", new Object[]{this});
            return;
        }
        if (getArguments() != null) {
            this.mType = getArguments().getInt("type", 0);
            this.mId = getArguments().getString("id", "");
        }
        this.mRecyclerView = (IRecyclerView) this.rootView.findViewById(R$id.irc);
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getContext());
        this.mLinearLayoutManager = linearLayoutManager;
        this.mRecyclerView.setLayoutManager(linearLayoutManager);
        ShowAdapter showAdapter = new ShowAdapter(getContext(), this.mDataHolderList, this.mItemClick);
        this.mAdapter = showAdapter;
        this.mRecyclerView.setAdapter(showAdapter);
        this.mRecyclerView.setRefreshEnabled(false);
        this.mRecyclerView.setLoadMoreEnabled(true);
        this.mRecyclerView.setIsAutoToDefault(false);
        this.mRecyclerView.setOnLoadMoreListener(this);
        this.mEmptyFoot = LayoutInflater.from(getContext()).inflate(R$layout.feeds_footer_empty, (ViewGroup) null);
        this.mEmptyFoot.setLayoutParams(new ViewGroup.LayoutParams(-1, t60.a(getActivity(), 110.0f)));
        this.mRecyclerView.addFooterView(this.mEmptyFoot);
        this.mEmptyFoot.setVisibility(8);
        this.mEmptyView = this.rootView.findViewById(R$id.user_empty_view);
        this.mPageIndex = 1;
        getData();
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "335466868")) {
            ipChange.ipc$dispatch("335466868", new Object[]{this, view});
        }
    }

    @Override // cn.damai.uikit.irecycler.OnLoadMoreListener
    public void onLoadMore(View view) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1485153609")) {
            ipChange.ipc$dispatch("1485153609", new Object[]{this, view});
        } else if (this.mProjectAllSize > this.mProjectSize) {
            this.mEmptyFoot.setVisibility(8);
            this.mRecyclerView.getLoadMoreFooterView().setVisibility(0);
            this.mRecyclerView.setLoadMoreStatus(LoadMoreFooterView.Status.LOADING);
            this.mPageIndex++;
            getData();
        } else {
            this.mRecyclerView.setLoadMoreStatus(LoadMoreFooterView.Status.THE_END);
            this.mRecyclerView.getLoadMoreFooterView().setVisibility(8);
            this.mEmptyFoot.setVisibility(0);
        }
    }
}
