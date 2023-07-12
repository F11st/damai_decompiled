package cn.damai.category.category.ui;

import android.os.Bundle;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.recyclerview.widget.RecyclerView;
import cn.damai.category.calendar.bean.ProjectItem;
import cn.damai.category.category.bean.CategoryItemBean;
import cn.damai.category.category.bean.CategoryNewProjectBean;
import cn.damai.category.category.bean.CategoryNewTitleBean;
import cn.damai.category.category.bean.ConditionEntity;
import cn.damai.category.category.repository.CategoryRepository;
import cn.damai.category.common.request.CategoryRequestNew;
import cn.damai.common.AppConfig;
import cn.damai.common.user.a;
import cn.damai.commonbusiness.base.DamaiBaseActivity;
import cn.damai.commonbusiness.base.ResponseErrorPage;
import cn.damai.commonbusiness.search.Daojishi;
import cn.damai.homepage.R$id;
import cn.damai.homepage.R$layout;
import cn.damai.tetris.DMMtopWarningListener;
import cn.damai.tetris.core.BaseLayer;
import cn.damai.tetris.core.BaseSection;
import cn.damai.tetris.core.msg.Message;
import cn.damai.tetris.core.mtop.BaseResponse;
import cn.damai.tetris.core.mtop.GlobalConfig;
import cn.damai.tetris.page.AbsFragmentV2;
import cn.damai.tetris.request.DrObj;
import cn.damai.tetris.request.TetrisRequest;
import cn.damai.tetris.v2.common.Node;
import cn.damai.uikit.irecycler.DamaiRootRecyclerView;
import cn.damai.uikit.irecycler.widget.LoadMoreFooterView;
import cn.damai.uikit.view.LinearPullToRefreshView;
import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import tb.bh;
import tb.db;
import tb.dh;
import tb.jn1;
import tb.wh2;
import tb.xl2;
import tb.z20;

/* compiled from: Taobao */
@Deprecated
/* loaded from: classes.dex */
public class ShowFragment extends AbsFragmentV2 {
    private static transient /* synthetic */ IpChange $ipChange = null;
    public static final String CATEGORYID_KEY = "categoryId";
    public static final String CATEGORYNAME_KEY = "categoryName";
    public static final String TITLEBEAN_KEY = "titlebean";
    Map<String, String> arg;
    private DrObj drObj;
    private View emptyView;
    private CategoryActivity mActivity;
    private FrameLayout mContainerLayout;
    private CategoryRepository mData;
    private ResponseErrorPage mErrorPage;
    private ViewGroup mRecycleViewLayout;
    public DamaiRootRecyclerView mRecyclerView;
    public LinearPullToRefreshView mRefreshView;
    private CategoryNewTitleBean mTitleBean;
    private View mTopView;
    ViewGroup rootView;
    String spmB = "";
    int visibleHint = 1;
    private boolean mHasNextPage = true;
    private String mCategoryId = "";
    private String mCategoryName = "";
    private boolean mIsFristProject = true;
    private CategoryRequestNew mCategoryRequest = new CategoryRequestNew();
    private boolean mIsRequesting = false;
    private int mScrollTotal = 0;

    /* compiled from: Taobao */
    /* loaded from: classes.dex */
    public class a implements View.OnClickListener {
        private static transient /* synthetic */ IpChange $ipChange;

        a() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "1767992352")) {
                ipChange.ipc$dispatch("1767992352", new Object[]{this, view});
                return;
            }
            ShowFragment.this.mRecyclerView.scrollToPosition(0);
            HashMap hashMap = new HashMap();
            hashMap.put("titlelabel", ShowFragment.this.spmB);
            cn.damai.common.user.c.e().x(new a.b().i(ShowFragment.this.spmB).f("bottom").l("anchor").g(false).j(hashMap));
        }
    }

    /* compiled from: Taobao */
    /* loaded from: classes.dex */
    public class b implements ResponseErrorPage.ErrorRefreshListener {
        private static transient /* synthetic */ IpChange $ipChange;

        b() {
        }

        @Override // cn.damai.commonbusiness.base.ResponseErrorPage.ErrorRefreshListener
        public void handleError(int i) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "-614292373")) {
                ipChange.ipc$dispatch("-614292373", new Object[]{this, Integer.valueOf(i)});
            } else {
                ShowFragment.this.request(true, false);
            }
        }
    }

    /* compiled from: Taobao */
    /* loaded from: classes.dex */
    public class c {
        private static transient /* synthetic */ IpChange $ipChange;
        private BaseResponse a;

        public c(BaseResponse baseResponse) {
            this.a = baseResponse;
        }

        private List<ProjectItem> a(CategoryNewProjectBean categoryNewProjectBean) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "-1177489900")) {
                return (List) ipChange.ipc$dispatch("-1177489900", new Object[]{this, categoryNewProjectBean});
            }
            ArrayList arrayList = new ArrayList();
            if (categoryNewProjectBean == null) {
                return arrayList;
            }
            if (ShowFragment.this.mCategoryRequest.cityOption == 0) {
                int i = categoryNewProjectBean.total;
                if (i == 0) {
                    if (ShowFragment.this.mIsFristProject) {
                        ShowFragment.this.mCategoryRequest.cityOption = 1;
                        ShowFragment.this.mCategoryRequest.sortType = 4;
                        if (wh2.e(categoryNewProjectBean.nearByCity) <= 0) {
                            ShowFragment.this.mHasNextPage = false;
                        } else {
                            ProjectItem projectItem = new ProjectItem();
                            projectItem.type = 1;
                            projectItem.hasCurrentCity = false;
                            arrayList.add(projectItem);
                            for (int i2 = 0; i2 < categoryNewProjectBean.nearByCity.size(); i2++) {
                                ProjectItem projectItem2 = new ProjectItem();
                                projectItem2.projectItemBean = categoryNewProjectBean.nearByCity.get(i2);
                                projectItem2.isCurrentCity = false;
                                arrayList.add(projectItem2);
                            }
                            if (wh2.e(categoryNewProjectBean.nearByCity) < Integer.parseInt(ShowFragment.this.mCategoryRequest.pageSize)) {
                                ShowFragment.this.mHasNextPage = false;
                            }
                        }
                    }
                } else if (i <= 3 && i > 0) {
                    for (int i3 = 0; i3 < categoryNewProjectBean.currentCity.size(); i3++) {
                        CategoryItemBean categoryItemBean = categoryNewProjectBean.currentCity.get(i3);
                        if (categoryItemBean != null) {
                            ProjectItem projectItem3 = new ProjectItem();
                            int i4 = categoryItemBean.type;
                            if (i4 == 4) {
                                projectItem3.type = 4;
                                projectItem3.projectItemBean = categoryItemBean.wirelessProjectDO;
                                projectItem3.isCurrentCity = true;
                            } else if (i4 == 5) {
                                projectItem3.type = 5;
                                projectItem3.rankBean = categoryItemBean.rankingListVO;
                            }
                            arrayList.add(projectItem3);
                        }
                    }
                    ShowFragment.this.mCategoryRequest.cityOption = 1;
                    ShowFragment.this.mCategoryRequest.sortType = 4;
                    if (wh2.e(categoryNewProjectBean.nearByCity) <= 0) {
                        ShowFragment.this.mHasNextPage = false;
                    } else {
                        ProjectItem projectItem4 = new ProjectItem();
                        projectItem4.type = 1;
                        projectItem4.hasCurrentCity = true;
                        arrayList.add(projectItem4);
                        for (int i5 = 0; i5 < categoryNewProjectBean.nearByCity.size(); i5++) {
                            ProjectItem projectItem5 = new ProjectItem();
                            projectItem5.projectItemBean = categoryNewProjectBean.nearByCity.get(i5);
                            projectItem5.isCurrentCity = false;
                            arrayList.add(projectItem5);
                        }
                        if (wh2.e(categoryNewProjectBean.nearByCity) < Integer.parseInt(ShowFragment.this.mCategoryRequest.pageSize)) {
                            ShowFragment.this.mHasNextPage = false;
                        }
                    }
                } else if (wh2.e(categoryNewProjectBean.currentCity) <= 0) {
                    ShowFragment.this.mCategoryRequest.cityOption = 1;
                    ShowFragment.this.mCategoryRequest.sortType = 4;
                    ShowFragment.this.mCategoryRequest.pageIndex = 1;
                    ShowFragment.this.request(false, false);
                } else {
                    for (int i6 = 0; i6 < categoryNewProjectBean.currentCity.size(); i6++) {
                        CategoryItemBean categoryItemBean2 = categoryNewProjectBean.currentCity.get(i6);
                        if (categoryItemBean2 != null) {
                            ProjectItem projectItem6 = new ProjectItem();
                            int i7 = categoryItemBean2.type;
                            if (i7 == 4) {
                                projectItem6.type = 4;
                                projectItem6.projectItemBean = categoryItemBean2.wirelessProjectDO;
                                projectItem6.isCurrentCity = true;
                            } else if (i7 == 5) {
                                projectItem6.type = 5;
                                projectItem6.rankBean = categoryItemBean2.rankingListVO;
                            }
                            arrayList.add(projectItem6);
                        }
                    }
                }
            } else if (wh2.e(categoryNewProjectBean.nearByCity) > 0) {
                if (ShowFragment.this.mCategoryRequest.pageIndex == 1) {
                    ProjectItem projectItem7 = new ProjectItem();
                    projectItem7.type = 1;
                    projectItem7.hasCurrentCity = true;
                    arrayList.add(projectItem7);
                }
                for (int i8 = 0; i8 < categoryNewProjectBean.nearByCity.size(); i8++) {
                    ProjectItem projectItem8 = new ProjectItem();
                    projectItem8.projectItemBean = categoryNewProjectBean.nearByCity.get(i8);
                    projectItem8.isCurrentCity = false;
                    arrayList.add(projectItem8);
                }
            } else {
                ShowFragment.this.mHasNextPage = false;
            }
            return arrayList;
        }

        public void b() {
            ArrayList<BaseLayer> arrayList;
            BaseLayer next;
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "863479972")) {
                ipChange.ipc$dispatch("863479972", new Object[]{this});
                return;
            }
            BaseResponse baseResponse = this.a;
            if (baseResponse == null || (arrayList = baseResponse.layers) == null) {
                return;
            }
            Iterator<BaseLayer> it = arrayList.iterator();
            while (it.hasNext() && (next = it.next()) != null && next.getSections() != null) {
                for (BaseSection baseSection : next.getSections()) {
                    if (baseSection != null && TextUtils.equals(xl2.CATEGORY_LIST_COMPONENT_ID, baseSection.getComponentId()) && baseSection.getItem() != null) {
                        List<ProjectItem> a = a((CategoryNewProjectBean) JSON.parseObject(baseSection.getItem().toJSONString(), CategoryNewProjectBean.class));
                        JSONObject jSONObject = new JSONObject();
                        jSONObject.put("result", (Object) a);
                        jSONObject.put(db.KEY_DAOJISHI, (Object) ShowFragment.this.mData.daojishi);
                        jSONObject.put(db.KEY_SHOW_DIS, (Object) Boolean.valueOf(ShowFragment.this.mData.isShowJuli));
                        jSONObject.put(db.TRACKKEY_CATEGORY_NAME, (Object) ShowFragment.this.mCategoryName);
                        jSONObject.put("trackB", (Object) bh.g(ShowFragment.this.mCategoryId));
                        jSONObject.put(db.TRACKKEY_CITY, (Object) z20.d());
                        baseSection.setItem(jSONObject);
                    }
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean checkEmpty(BaseResponse baseResponse) {
        ArrayList<BaseLayer> arrayList;
        BaseLayer next;
        CategoryNewProjectBean categoryNewProjectBean;
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-2008847092")) {
            return ((Boolean) ipChange.ipc$dispatch("-2008847092", new Object[]{this, baseResponse})).booleanValue();
        }
        if (baseResponse != null && (arrayList = baseResponse.layers) != null) {
            Iterator<BaseLayer> it = arrayList.iterator();
            while (it.hasNext() && (next = it.next()) != null && next.getSections() != null) {
                for (BaseSection baseSection : next.getSections()) {
                    if (baseSection != null && TextUtils.equals(xl2.CATEGORY_LIST_COMPONENT_ID, baseSection.getComponentId()) && baseSection.getItem() != null && (categoryNewProjectBean = (CategoryNewProjectBean) JSON.parseObject(baseSection.getItem().toJSONString(), CategoryNewProjectBean.class)) != null) {
                        return wh2.e(categoryNewProjectBean.currentCity) + wh2.e(categoryNewProjectBean.nearByCity) == 0;
                    }
                }
            }
        }
        return true;
    }

    private CategoryRequestNew getRequest() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-937759299")) {
            return (CategoryRequestNew) ipChange.ipc$dispatch("-937759299", new Object[]{this});
        }
        if (this.mCategoryRequest == null) {
            this.mCategoryRequest = new CategoryRequestNew();
        }
        this.mCategoryRequest.dmChannel = AppConfig.p();
        CategoryRequestNew categoryRequestNew = this.mCategoryRequest;
        ConditionEntity conditionEntity = this.mData.conditionEntity;
        String str = conditionEntity.currentCityId;
        categoryRequestNew.currentCityId = str;
        categoryRequestNew.cityId = str;
        categoryRequestNew.dateType = conditionEntity.dateType;
        categoryRequestNew.startDate = conditionEntity.startDate;
        categoryRequestNew.endDate = conditionEntity.endDate;
        categoryRequestNew.longitude = conditionEntity.longitude;
        categoryRequestNew.latitude = conditionEntity.latitude;
        categoryRequestNew.projectIdList = conditionEntity.projectIdList;
        categoryRequestNew.categoryId = this.mCategoryId;
        categoryRequestNew.comboDamaiCityId = str;
        return categoryRequestNew;
    }

    private void initData() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "952030728")) {
            ipChange.ipc$dispatch("952030728", new Object[]{this});
        } else if (!TextUtils.isEmpty(this.mData.categoryId) && this.mData.categoryId.equals(this.mCategoryId)) {
            request(true, false, true);
        } else {
            request(true, false, false);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void updateSpmB(String str, JSONArray jSONArray) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "304165433")) {
            ipChange.ipc$dispatch("304165433", new Object[]{this, str, jSONArray});
        } else if (getActivity() == null || !(getActivity() instanceof DamaiBaseActivity)) {
        } else {
            HashMap hashMap = new HashMap();
            this.arg = hashMap;
            if (jSONArray != null) {
                hashMap.put("current_ab", jSONArray.toJSONString());
            }
            if (getUserVisibleHint()) {
                cn.damai.common.user.c.e().L(getActivity(), str);
                cn.damai.common.user.c.e().l(getActivity(), new a.b().i(str).j(this.arg));
            }
        }
    }

    public DrObj getTetrisDr(BaseResponse baseResponse) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-821450151")) {
            return (DrObj) ipChange.ipc$dispatch("-821450151", new Object[]{this, baseResponse});
        }
        DrObj drObj = new DrObj();
        if (baseResponse != null) {
            for (BaseLayer baseLayer : baseResponse.layers) {
                List<BaseSection> sections = baseLayer.getSections();
                if (sections != null) {
                    for (BaseSection baseSection : sections) {
                        if (baseSection != null && xl2.CATEGORY_LIST_COMPONENT_ID.equals(baseSection.getComponentId())) {
                            drObj.targetLayerId = baseLayer.getLayerId();
                            drObj.targetSectionId = baseSection.getSectionId();
                        }
                    }
                }
            }
        }
        return drObj;
    }

    public void initView() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-36936403")) {
            ipChange.ipc$dispatch("-36936403", new Object[]{this});
            return;
        }
        ViewGroup viewGroup = this.rootView;
        this.mContainerLayout = (FrameLayout) viewGroup;
        DamaiRootRecyclerView damaiRootRecyclerView = (DamaiRootRecyclerView) viewGroup.findViewById(R$id.teris_page_irecyclerview);
        this.mRecyclerView = damaiRootRecyclerView;
        this.mRecycleViewLayout = (ViewGroup) damaiRootRecyclerView.getParent();
        View findViewById = this.rootView.findViewById(R$id.category_image_gotop);
        this.mTopView = findViewById;
        findViewById.setOnClickListener(new a());
        View findViewById2 = this.rootView.findViewById(R$id.ll_empty);
        this.emptyView = findViewById2;
        findViewById2.setVisibility(8);
        this.mRecyclerView.addOnScrollListener(new RecyclerView.OnScrollListener() { // from class: cn.damai.category.category.ui.ShowFragment.2
            private static transient /* synthetic */ IpChange $ipChange;

            @Override // androidx.recyclerview.widget.RecyclerView.OnScrollListener
            public void onScrolled(RecyclerView recyclerView, int i, int i2) {
                IpChange ipChange2 = $ipChange;
                if (AndroidInstantRuntime.support(ipChange2, "-1890018798")) {
                    ipChange2.ipc$dispatch("-1890018798", new Object[]{this, recyclerView, Integer.valueOf(i), Integer.valueOf(i2)});
                } else if (ShowFragment.this.isRecyclerViewOverPage(recyclerView)) {
                    ShowFragment.this.mTopView.setVisibility(0);
                } else {
                    ShowFragment.this.mTopView.setVisibility(8);
                }
            }
        });
    }

    @Override // cn.damai.tetris.page.AbsFragment
    public boolean isRecyclerViewOverPage(RecyclerView recyclerView) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "897186954")) {
            return ((Boolean) ipChange.ipc$dispatch("897186954", new Object[]{this, recyclerView})).booleanValue();
        }
        if (recyclerView != null) {
            try {
                View childAt = recyclerView.getChildAt(0);
                RecyclerView.LayoutManager layoutManager = recyclerView.getLayoutManager();
                if (childAt != null && layoutManager != null) {
                    return layoutManager.getPosition(childAt) > 10;
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return false;
    }

    @Override // cn.damai.tetris.page.AbsFragment, androidx.fragment.app.Fragment
    @Nullable
    public View onCreateView(@NonNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, @Nullable Bundle bundle) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-419092617")) {
            return (View) ipChange.ipc$dispatch("-419092617", new Object[]{this, layoutInflater, viewGroup, bundle});
        }
        CategoryActivity categoryActivity = (CategoryActivity) getActivity();
        this.mActivity = categoryActivity;
        this.mData = categoryActivity.getData();
        this.mIsRequesting = false;
        this.mScrollTotal = 0;
        if (getArguments() != null) {
            try {
                this.mTitleBean = (CategoryNewTitleBean) getArguments().getSerializable("titlebean");
            } catch (Exception e) {
                e.printStackTrace();
            }
            CategoryNewTitleBean categoryNewTitleBean = this.mTitleBean;
            if (categoryNewTitleBean != null) {
                this.mCategoryId = categoryNewTitleBean.categoryId;
                this.mCategoryName = categoryNewTitleBean.name;
                this.spmB = categoryNewTitleBean.patternName;
            }
        }
        ViewGroup viewGroup2 = (ViewGroup) layoutInflater.inflate(R$layout.category_show_fragment, viewGroup, false);
        this.rootView = viewGroup2;
        this.rootView.addView(super.onCreateView(layoutInflater, viewGroup2, bundle), 0);
        initView();
        if (this.visibleHint == 1) {
            initData();
        } else {
            this.visibleHint = 1;
        }
        return this.rootView;
    }

    @Override // androidx.fragment.app.Fragment
    public void onDestroyView() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1847121800")) {
            ipChange.ipc$dispatch("1847121800", new Object[]{this});
        } else {
            super.onDestroyView();
        }
    }

    @Override // cn.damai.tetris.page.AbsFragment, cn.damai.uikit.irecycler.OnLoadMoreListener
    public void onLoadMore(View view) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1275373706")) {
            ipChange.ipc$dispatch("1275373706", new Object[]{this, view});
            return;
        }
        showLoadMoreV2();
        showBottomLoadMore();
        if (this.mHasNextPage) {
            loadMoreResetV2(true);
            this.mCategoryRequest.pageIndex++;
            request(false, false, true);
            return;
        }
        showNoMoreV2();
        showBottonEmpty();
    }

    @Override // cn.damai.tetris.page.AbsFragment, cn.damai.tetris.core.msg.IMessage
    public void onMessage(int i, Object obj) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "885572319")) {
            ipChange.ipc$dispatch("885572319", new Object[]{this, Integer.valueOf(i), obj});
        }
    }

    @Override // cn.damai.tetris.page.AbsFragment, cn.damai.uikit.irecycler.OnRefreshListener
    public void onRefresh() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1587672596")) {
            ipChange.ipc$dispatch("-1587672596", new Object[]{this});
        } else {
            request(true, false);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // cn.damai.tetris.page.AbsFragment
    public void onResponseError(String str, String str2, String str3) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1628865698")) {
            ipChange.ipc$dispatch("-1628865698", new Object[]{this, str, str2, str3});
            return;
        }
        this.mRecycleViewLayout.setVisibility(8);
        ResponseErrorPage responseErrorPage = this.mErrorPage;
        if (responseErrorPage == null || (!responseErrorPage.isShown() && this.mErrorPage.getParent() == null)) {
            ResponseErrorPage responseErrorPage2 = new ResponseErrorPage(this.mActivity, str, str2, str3);
            this.mErrorPage = responseErrorPage2;
            responseErrorPage2.setVisibility(0);
            this.mErrorPage.hideTitle();
            this.mErrorPage.setRefreshListener(new b());
            this.mContainerLayout.addView(this.mErrorPage);
        }
    }

    @Override // cn.damai.tetris.page.AbsFragment
    public void onResponseSuccess() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1868665627")) {
            ipChange.ipc$dispatch("-1868665627", new Object[]{this});
            return;
        }
        this.mRecycleViewLayout.setVisibility(0);
        try {
            ResponseErrorPage responseErrorPage = this.mErrorPage;
            if (responseErrorPage != null) {
                responseErrorPage.setVisibility(8);
                this.mContainerLayout.removeView(this.mErrorPage);
                this.mErrorPage = null;
            }
        } catch (Exception unused) {
        }
    }

    @Override // cn.damai.tetris.page.AbsFragmentV2, cn.damai.tetris.page.AbsFragment, androidx.fragment.app.Fragment
    public void onViewCreated(@NonNull View view, @Nullable Bundle bundle) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "149757446")) {
            ipChange.ipc$dispatch("149757446", new Object[]{this, view, bundle});
            return;
        }
        super.onViewCreated(view, bundle);
        enableDividerLine(false);
    }

    public void overWriteArgs(TetrisRequest tetrisRequest) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1473444582")) {
            ipChange.ipc$dispatch("1473444582", new Object[]{this, tetrisRequest});
        } else if (TextUtils.isEmpty(tetrisRequest.args)) {
        } else {
            JSONObject parseObject = JSON.parseObject(tetrisRequest.args);
            if (parseObject == null) {
                parseObject = new JSONObject();
            }
            JSONObject objArgs = this.mTitleBean.getObjArgs();
            if (objArgs.getInnerMap() != null) {
                if (parseObject.getInnerMap() != null) {
                    parseObject.getInnerMap().putAll(objArgs.getInnerMap());
                } else {
                    parseObject = objArgs;
                }
            }
            tetrisRequest.args = parseObject.toJSONString();
        }
    }

    public void reSetPage(boolean z) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "220962250")) {
            ipChange.ipc$dispatch("220962250", new Object[]{this, Boolean.valueOf(z)});
            return;
        }
        this.mCategoryRequest.cityOption = 0;
        if (z) {
            this.mData.conditionEntity.projectIdList.clear();
        }
        CategoryRequestNew categoryRequestNew = this.mCategoryRequest;
        categoryRequestNew.pageIndex = 1;
        this.drObj = null;
        categoryRequestNew.sortType = this.mData.conditionEntity.sortType;
        this.mIsFristProject = true;
        this.mRecyclerView.scrollToPosition(0);
        this.mHasNextPage = true;
        loadMoreResetV2(true);
        this.mRecyclerView.setLoadMoreStatus(LoadMoreFooterView.Status.GONE);
        this.mRecyclerView.getLoadMoreFooterView().setVisibility(8);
    }

    public void request(boolean z, boolean z2) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "940281721")) {
            ipChange.ipc$dispatch("940281721", new Object[]{this, Boolean.valueOf(z), Boolean.valueOf(z2)});
        } else {
            request(z, z2, true);
        }
    }

    @Override // cn.damai.tetris.page.AbsFragmentV2, cn.damai.tetris.page.AbsFragment, androidx.fragment.app.Fragment
    public void setUserVisibleHint(boolean z) {
        CategoryRepository categoryRepository;
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-282344258")) {
            ipChange.ipc$dispatch("-282344258", new Object[]{this, Boolean.valueOf(z)});
            return;
        }
        super.setUserVisibleHint(z);
        if (z) {
            DamaiRootRecyclerView damaiRootRecyclerView = this.mRecyclerView;
            if (damaiRootRecyclerView != null && this.mScrollTotal != 0) {
                damaiRootRecyclerView.scrollBy(0, 1);
            }
            if (this.mActivity == null || (categoryRepository = this.mData) == null || !categoryRepository.isChangeCondition) {
                return;
            }
            if (categoryRepository.isAizhe) {
                request(true, true);
                this.visibleHint = 2;
                this.mData.isAizhe = false;
            }
            this.mData.isChangeCondition = false;
        }
    }

    public void showBottomLoadMore() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "457304319")) {
            ipChange.ipc$dispatch("457304319", new Object[]{this});
            return;
        }
        this.mRecyclerView.getLoadMoreFooterView().setVisibility(0);
        this.mRecyclerView.setLoadMoreStatus(LoadMoreFooterView.Status.LOADING);
    }

    public void showBottonEmpty() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "566723428")) {
            ipChange.ipc$dispatch("566723428", new Object[]{this});
            return;
        }
        this.mRecyclerView.setLoadMoreStatus(LoadMoreFooterView.Status.THE_END);
        this.mRecyclerView.getLoadMoreFooterView().setVisibility(8);
        this.mHasNextPage = false;
    }

    public void startTimer() {
        Daojishi daojishi;
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1281909503")) {
            ipChange.ipc$dispatch("1281909503", new Object[]{this});
            return;
        }
        CategoryRepository categoryRepository = this.mData;
        if (categoryRepository == null || categoryRepository.tab != 0 || (daojishi = categoryRepository.daojishi) == null) {
            return;
        }
        daojishi.startTimer();
        sendMsg(new Message(1001, null));
    }

    public void stopBottomProgress() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1359606648")) {
            ipChange.ipc$dispatch("-1359606648", new Object[]{this});
            return;
        }
        this.mRecyclerView.setLoadMoreStatus(LoadMoreFooterView.Status.GONE);
        this.mRecyclerView.getLoadMoreFooterView().setVisibility(8);
    }

    public void request(final boolean z, boolean z2, boolean z3) {
        DrObj drObj;
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-915991941")) {
            ipChange.ipc$dispatch("-915991941", new Object[]{this, Boolean.valueOf(z), Boolean.valueOf(z2), Boolean.valueOf(z3)});
        } else if (this.mIsRequesting) {
        } else {
            if (z) {
                reSetPage(z2);
            }
            if (z3) {
                this.mActivity.startProgressDialog();
            }
            this.mIsRequesting = true;
            final TetrisRequest tetrisRequest = new TetrisRequest(getRequest());
            CategoryNewTitleBean categoryNewTitleBean = this.mTitleBean;
            tetrisRequest.patternVersion = categoryNewTitleBean.patternVersion;
            tetrisRequest.patternName = categoryNewTitleBean.patternName;
            overWriteArgs(tetrisRequest);
            if (this.mCategoryRequest.cityOption == 1 && (drObj = this.drObj) != null) {
                drObj.targetArgs = tetrisRequest.args;
                tetrisRequest.dr = jn1.ARRAY_START_STR + JSON.toJSONString(this.drObj) + jn1.ARRAY_END_STR;
            }
            tetrisRequest.request(new DMMtopWarningListener<BaseResponse>(BaseResponse.class, tetrisRequest.toJsonString()) { // from class: cn.damai.category.category.ui.ShowFragment.3
                private static transient /* synthetic */ IpChange $ipChange;

                @Override // cn.damai.tetris.DMMtopWarningListener
                public void onFailWithWarning(String str, String str2) {
                    IpChange ipChange2 = $ipChange;
                    if (AndroidInstantRuntime.support(ipChange2, "-2033719916")) {
                        ipChange2.ipc$dispatch("-2033719916", new Object[]{this, str, str2});
                        return;
                    }
                    ShowFragment.this.mIsRequesting = false;
                    ShowFragment.this.refreshFinish();
                    if (ShowFragment.this.mActivity != null) {
                        ShowFragment.this.mActivity.stopProgressDialog();
                    }
                    ShowFragment.this.onResponseError("", "", "");
                }

                @Override // cn.damai.tetris.DMMtopWarningListener
                public void onSuccessWithWarning(BaseResponse baseResponse) {
                    Node node;
                    List<Node> list;
                    Node node2;
                    List<Node> list2;
                    IpChange ipChange2 = $ipChange;
                    if (AndroidInstantRuntime.support(ipChange2, "-1667721686")) {
                        ipChange2.ipc$dispatch("-1667721686", new Object[]{this, baseResponse});
                        return;
                    }
                    ShowFragment.this.mIsRequesting = false;
                    ShowFragment.this.stopBottomProgress();
                    ShowFragment.this.refreshFinish();
                    ShowFragment.this.onResponseSuccess();
                    if (ShowFragment.this.mActivity != null) {
                        ShowFragment.this.mActivity.stopProgressDialog();
                    }
                    if (tetrisRequest != null && baseResponse.layers != null) {
                        ShowFragment showFragment = ShowFragment.this;
                        showFragment.drObj = showFragment.getTetrisDr(baseResponse);
                        GlobalConfig globalConfig = baseResponse.globalConfig;
                        if (globalConfig != null) {
                            ShowFragment showFragment2 = ShowFragment.this;
                            String str = globalConfig.pageName;
                            showFragment2.spmB = str;
                            showFragment2.updateSpmB(str, globalConfig.abBuckets);
                        }
                        if (ShowFragment.this.mIsFristProject) {
                            if (baseResponse.layers != null) {
                                if (ShowFragment.this.checkEmpty(baseResponse)) {
                                    ShowFragment.this.emptyView.setVisibility(0);
                                } else {
                                    ShowFragment.this.emptyView.setVisibility(8);
                                }
                                if (ShowFragment.this.mData.daojishi != null && ShowFragment.this.mData.daojishi.serverTime == 0) {
                                    ShowFragment.this.mData.daojishi.setServiceTimeAndDiff(baseResponse.serverTime);
                                }
                            } else {
                                onFail("", "");
                                if (ShowFragment.this.mCategoryRequest != null) {
                                    dh.b(JSON.toJSONString(ShowFragment.this.mCategoryRequest));
                                    return;
                                }
                                return;
                            }
                        }
                        new c(baseResponse).b();
                        Node e = new db().e(baseResponse);
                        if (z) {
                            ShowFragment.this.setData(e);
                        } else {
                            List<Node> list3 = e.children;
                            if (list3 != null && list3.size() == 1 && (node = e.children.get(0)) != null && (list = node.children) != null && list.size() == 1 && (node2 = node.children.get(0)) != null && (list2 = node2.children) != null) {
                                ShowFragment.this.addSectionList(list2, true, false);
                            }
                        }
                        ShowFragment.this.startTimer();
                        ShowFragment.this.mIsFristProject = false;
                        if (ShowFragment.this.mHasNextPage) {
                            return;
                        }
                        ShowFragment.this.showNoMoreV2();
                        return;
                    }
                    ShowFragment.this.onResponseError("", "", "");
                }
            });
            stopBottomProgress();
            this.emptyView.setVisibility(8);
        }
    }
}
