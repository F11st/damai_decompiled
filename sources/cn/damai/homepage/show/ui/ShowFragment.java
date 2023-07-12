package cn.damai.homepage.show.ui;

import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.recyclerview.widget.RecyclerView;
import cn.damai.common.AppConfig;
import cn.damai.common.user.C0525a;
import cn.damai.common.user.C0529c;
import cn.damai.commonbusiness.base.ResponseErrorPage;
import cn.damai.commonbusiness.calendar.CalendarPopView;
import cn.damai.commonbusiness.home.OnCityChangedListener;
import cn.damai.commonbusiness.home.bean.HomeTabBean;
import cn.damai.commonbusiness.search.Daojishi;
import cn.damai.homepage.MainActivity;
import cn.damai.homepage.R$id;
import cn.damai.homepage.R$layout;
import cn.damai.homepage.show.bean.ShowBean;
import cn.damai.homepage.show.bean.ShowItemBean;
import cn.damai.homepage.show.bean.ShowShowItem;
import cn.damai.homepage.show.request.ShowRequest;
import cn.damai.homepage.show.view.ScreenView;
import cn.damai.tetris.DMMtopWarningListener;
import cn.damai.tetris.component.home.HomeData;
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
import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import tb.C9039db;
import tb.jn1;
import tb.oc2;
import tb.pc2;
import tb.wh2;
import tb.xl2;
import tb.z20;

/* compiled from: Taobao */
/* loaded from: classes5.dex */
public class ShowFragment extends AbsFragmentV2 implements OnCityChangedListener {
    private static transient /* synthetic */ IpChange $ipChange = null;
    public static final String TITLEBEAN_KEY = "titlebean";
    Map<String, String> arg;
    private DrObj drObj;
    private View emptyView;
    private MainActivity mActivity;
    private CalendarPopView mCalendarView;
    private HomeData mData;
    private ResponseErrorPage mErrorPage;
    private boolean mIsChangeCity;
    private boolean mIsCreateView;
    private boolean mIsGetData;
    private boolean mIsShowJuli;
    private boolean mIsUserVisible;
    private FrameLayout mListLayout;
    private ViewGroup mRecycleViewLayout;
    public DamaiRootRecyclerView mRecyclerView;
    private ScreenView mScreenView;
    private HomeTabBean mTitleBean;
    private View mTitleLineView;
    private View mTopView;
    C0525a.C0527b mUTBuilder;
    ViewGroup rootView;
    String spmB = "";
    private boolean mHasNextPage = true;
    private String mCategoryId = "";
    private String mCategoryName = "";
    private boolean mIsFristProject = true;
    private ShowRequest mShowRequest = new ShowRequest();
    private boolean mIsRequesting = false;
    private Daojishi mDaojishi = new Daojishi();
    private int mSortType = 3;

    /* compiled from: Taobao */
    /* renamed from: cn.damai.homepage.show.ui.ShowFragment$a */
    /* loaded from: classes5.dex */
    public class C1150a implements CalendarPopView.OnDateClickListener {
        private static transient /* synthetic */ IpChange $ipChange;

        C1150a() {
        }

        @Override // cn.damai.commonbusiness.calendar.CalendarPopView.OnDateClickListener
        public void onClose() {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "1396113683")) {
                ipChange.ipc$dispatch("1396113683", new Object[]{this});
            } else {
                ShowFragment.this.mScreenView.f(true);
            }
        }

        @Override // cn.damai.commonbusiness.calendar.CalendarPopView.OnDateClickListener
        public void onDateClick(int i, String str, String str2, int i2, String str3) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "1819747687")) {
                ipChange.ipc$dispatch("1819747687", new Object[]{this, Integer.valueOf(i), str, str2, Integer.valueOf(i2), str3});
                return;
            }
            ShowFragment.this.mShowRequest.dateType = i;
            ShowFragment.this.mShowRequest.startDate = str;
            ShowFragment.this.mShowRequest.endDate = str2;
            if (i == 0) {
                ShowFragment.this.mScreenView.e(false, str3);
            } else {
                ShowFragment.this.mScreenView.e(true, str3);
            }
            ShowFragment.this.request(true);
        }
    }

    /* compiled from: Taobao */
    /* renamed from: cn.damai.homepage.show.ui.ShowFragment$b */
    /* loaded from: classes5.dex */
    public class C1151b implements ScreenView.OnScreenClickListener {
        private static transient /* synthetic */ IpChange $ipChange;

        C1151b() {
        }

        @Override // cn.damai.homepage.show.view.ScreenView.OnScreenClickListener
        public void onScreenClick(int i) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "-891749675")) {
                ipChange.ipc$dispatch("-891749675", new Object[]{this, Integer.valueOf(i)});
                return;
            }
            if (i == 4) {
                ShowFragment.this.mIsShowJuli = true;
            } else {
                ShowFragment.this.mIsShowJuli = false;
            }
            ShowFragment.this.mSortType = i;
            ShowFragment.this.mShowRequest.sortType = ShowFragment.this.mSortType;
            if (ShowFragment.this.mCalendarView != null) {
                ShowFragment.this.mCalendarView.t();
            }
            ShowFragment.this.request(true);
        }

        @Override // cn.damai.homepage.show.view.ScreenView.OnScreenClickListener
        public void onTimeClick(boolean z) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "811029541")) {
                ipChange.ipc$dispatch("811029541", new Object[]{this, Boolean.valueOf(z)});
            } else if (z) {
                ShowFragment.this.mCalendarView.E();
            } else {
                ShowFragment.this.mCalendarView.t();
            }
        }
    }

    /* compiled from: Taobao */
    /* renamed from: cn.damai.homepage.show.ui.ShowFragment$c */
    /* loaded from: classes14.dex */
    public class View$OnClickListenerC1152c implements View.OnClickListener {
        private static transient /* synthetic */ IpChange $ipChange;

        View$OnClickListenerC1152c() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "2006930545")) {
                ipChange.ipc$dispatch("2006930545", new Object[]{this, view});
                return;
            }
            ShowFragment.this.mRecyclerView.scrollToPosition(0);
            HashMap hashMap = new HashMap();
            hashMap.put("titlelabel", ShowFragment.this.spmB);
            C0529c.e().x(new C0525a.C0527b().i(ShowFragment.this.spmB).f("bottom").l("anchor").g(false).j(hashMap));
        }
    }

    /* compiled from: Taobao */
    /* renamed from: cn.damai.homepage.show.ui.ShowFragment$d */
    /* loaded from: classes5.dex */
    public class C1153d implements ResponseErrorPage.ErrorRefreshListener {
        private static transient /* synthetic */ IpChange $ipChange;

        C1153d() {
        }

        @Override // cn.damai.commonbusiness.base.ResponseErrorPage.ErrorRefreshListener
        public void handleError(int i) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "-2139881860")) {
                ipChange.ipc$dispatch("-2139881860", new Object[]{this, Integer.valueOf(i)});
            } else {
                ShowFragment.this.request(true, false);
            }
        }
    }

    /* compiled from: Taobao */
    /* renamed from: cn.damai.homepage.show.ui.ShowFragment$e */
    /* loaded from: classes14.dex */
    public class C1154e {
        private static transient /* synthetic */ IpChange $ipChange;
        private BaseResponse a;

        public C1154e(BaseResponse baseResponse) {
            this.a = baseResponse;
        }

        private List<ShowShowItem> a(ShowBean showBean) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "1710595898")) {
                return (List) ipChange.ipc$dispatch("1710595898", new Object[]{this, showBean});
            }
            ArrayList arrayList = new ArrayList();
            if (showBean == null) {
                return arrayList;
            }
            if (ShowFragment.this.mShowRequest.cityOption == 0) {
                int i = showBean.total;
                if (i == 0) {
                    if (ShowFragment.this.mIsFristProject) {
                        ShowFragment.this.mShowRequest.cityOption = 1;
                        ShowFragment.this.mShowRequest.sortType = 4;
                        if (wh2.e(showBean.nearByCity) <= 0) {
                            ShowFragment.this.mHasNextPage = false;
                        } else {
                            ShowShowItem showShowItem = new ShowShowItem();
                            showShowItem.type = 1;
                            showShowItem.hasCurrentCity = false;
                            arrayList.add(showShowItem);
                            for (int i2 = 0; i2 < showBean.nearByCity.size(); i2++) {
                                ShowShowItem showShowItem2 = new ShowShowItem();
                                showShowItem2.projectItemBean = showBean.nearByCity.get(i2);
                                showShowItem2.isCurrentCity = false;
                                arrayList.add(showShowItem2);
                            }
                            if (wh2.e(showBean.nearByCity) < Integer.parseInt(ShowFragment.this.mShowRequest.pageSize)) {
                                ShowFragment.this.mHasNextPage = false;
                            }
                        }
                    }
                } else if (i <= 3 && i > 0) {
                    if (showBean.currentCity != null) {
                        for (int i3 = 0; i3 < showBean.currentCity.size(); i3++) {
                            ShowItemBean showItemBean = showBean.currentCity.get(i3);
                            if (showItemBean != null) {
                                ShowShowItem showShowItem3 = new ShowShowItem();
                                int i4 = showItemBean.type;
                                if (i4 == 4) {
                                    showShowItem3.type = 4;
                                    showShowItem3.projectItemBean = showItemBean.wirelessProjectDO;
                                    showShowItem3.isCurrentCity = true;
                                } else if (i4 == 5) {
                                    showShowItem3.type = 5;
                                    showShowItem3.rankBean = showItemBean.rankingListVO;
                                }
                                arrayList.add(showShowItem3);
                            }
                        }
                    }
                    ShowFragment.this.mShowRequest.cityOption = 1;
                    ShowFragment.this.mShowRequest.sortType = 4;
                    if (wh2.e(showBean.nearByCity) <= 0) {
                        ShowFragment.this.mHasNextPage = false;
                    } else {
                        ShowShowItem showShowItem4 = new ShowShowItem();
                        showShowItem4.type = 1;
                        showShowItem4.hasCurrentCity = true;
                        arrayList.add(showShowItem4);
                        for (int i5 = 0; i5 < showBean.nearByCity.size(); i5++) {
                            ShowShowItem showShowItem5 = new ShowShowItem();
                            showShowItem5.projectItemBean = showBean.nearByCity.get(i5);
                            showShowItem5.isCurrentCity = false;
                            arrayList.add(showShowItem5);
                        }
                        if (wh2.e(showBean.nearByCity) < Integer.parseInt(ShowFragment.this.mShowRequest.pageSize)) {
                            ShowFragment.this.mHasNextPage = false;
                        }
                    }
                } else if (wh2.e(showBean.currentCity) <= 0) {
                    ShowFragment.this.mShowRequest.cityOption = 1;
                    ShowFragment.this.mShowRequest.sortType = 4;
                    ShowFragment.this.mShowRequest.pageIndex = 1;
                    ShowFragment.this.request(false, false);
                } else {
                    for (int i6 = 0; i6 < showBean.currentCity.size(); i6++) {
                        ShowItemBean showItemBean2 = showBean.currentCity.get(i6);
                        if (showItemBean2 != null) {
                            ShowShowItem showShowItem6 = new ShowShowItem();
                            int i7 = showItemBean2.type;
                            if (i7 == 4) {
                                showShowItem6.type = 4;
                                showShowItem6.projectItemBean = showItemBean2.wirelessProjectDO;
                                showShowItem6.isCurrentCity = true;
                            } else if (i7 == 5) {
                                showShowItem6.type = 5;
                                showShowItem6.rankBean = showItemBean2.rankingListVO;
                            }
                            arrayList.add(showShowItem6);
                        }
                    }
                }
            } else if (wh2.e(showBean.nearByCity) > 0) {
                if (ShowFragment.this.mShowRequest.pageIndex == 1) {
                    ShowShowItem showShowItem7 = new ShowShowItem();
                    showShowItem7.type = 1;
                    showShowItem7.hasCurrentCity = true;
                    arrayList.add(showShowItem7);
                }
                for (int i8 = 0; i8 < showBean.nearByCity.size(); i8++) {
                    ShowShowItem showShowItem8 = new ShowShowItem();
                    showShowItem8.projectItemBean = showBean.nearByCity.get(i8);
                    showShowItem8.isCurrentCity = false;
                    arrayList.add(showShowItem8);
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
            if (AndroidInstantRuntime.support(ipChange, "1174804723")) {
                ipChange.ipc$dispatch("1174804723", new Object[]{this});
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
                        List<ShowShowItem> a = a((ShowBean) JSON.parseObject(baseSection.getItem().toJSONString(), ShowBean.class));
                        JSONObject jSONObject = new JSONObject();
                        jSONObject.put("result", (Object) a);
                        jSONObject.put(C9039db.KEY_DAOJISHI, (Object) ShowFragment.this.mDaojishi);
                        jSONObject.put(C9039db.KEY_SHOW_DIS, (Object) Boolean.valueOf(ShowFragment.this.mIsShowJuli));
                        jSONObject.put(C9039db.TRACKKEY_CATEGORY_NAME, (Object) ShowFragment.this.mCategoryName);
                        jSONObject.put("trackB", (Object) oc2.f(ShowFragment.this.mCategoryId));
                        jSONObject.put(C9039db.TRACKKEY_CITY, (Object) z20.d());
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
        ShowBean showBean;
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1263785957")) {
            return ((Boolean) ipChange.ipc$dispatch("-1263785957", new Object[]{this, baseResponse})).booleanValue();
        }
        if (baseResponse != null && (arrayList = baseResponse.layers) != null) {
            Iterator<BaseLayer> it = arrayList.iterator();
            while (it.hasNext() && (next = it.next()) != null && next.getSections() != null) {
                for (BaseSection baseSection : next.getSections()) {
                    if (baseSection != null && TextUtils.equals(xl2.CATEGORY_LIST_COMPONENT_ID, baseSection.getComponentId()) && baseSection.getItem() != null && (showBean = (ShowBean) JSON.parseObject(baseSection.getItem().toJSONString(), ShowBean.class)) != null) {
                        return wh2.e(showBean.currentCity) + wh2.e(showBean.nearByCity) == 0;
                    }
                }
            }
        }
        return true;
    }

    public static ShowFragment getInstance(HomeTabBean homeTabBean) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1686410628")) {
            return (ShowFragment) ipChange.ipc$dispatch("1686410628", new Object[]{homeTabBean});
        }
        ShowFragment showFragment = new ShowFragment();
        Bundle bundle = new Bundle();
        if (homeTabBean != null) {
            bundle.putSerializable("titlebean", homeTabBean);
        }
        showFragment.setArguments(bundle);
        return showFragment;
    }

    private ShowRequest getRequest() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-674479769")) {
            return (ShowRequest) ipChange.ipc$dispatch("-674479769", new Object[]{this});
        }
        if (this.mShowRequest == null) {
            this.mShowRequest = new ShowRequest();
        }
        this.mShowRequest.dmChannel = AppConfig.p();
        this.mShowRequest.currentCityId = z20.c();
        this.mShowRequest.cityId = z20.c();
        this.mShowRequest.comboDamaiCityId = z20.c();
        ShowRequest showRequest = this.mShowRequest;
        showRequest.longitude = z20.o() + "";
        ShowRequest showRequest2 = this.mShowRequest;
        showRequest2.latitude = z20.n() + "";
        ShowRequest showRequest3 = this.mShowRequest;
        showRequest3.categoryId = this.mCategoryId;
        return showRequest3;
    }

    private void initData() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1760082985")) {
            ipChange.ipc$dispatch("-1760082985", new Object[]{this});
        } else if (isVisible()) {
            request(true, true);
        } else {
            request(true, false);
        }
    }

    public DrObj getTetrisDr(BaseResponse baseResponse) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1327320426")) {
            return (DrObj) ipChange.ipc$dispatch("1327320426", new Object[]{this, baseResponse});
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
        if (AndroidInstantRuntime.support(ipChange, "1545917180")) {
            ipChange.ipc$dispatch("1545917180", new Object[]{this});
            return;
        }
        this.mScreenView = new ScreenView(this.rootView.findViewById(R$id.layout_screen), new C1151b());
        this.mTitleLineView = this.rootView.findViewById(R$id.title_line);
        DamaiRootRecyclerView damaiRootRecyclerView = (DamaiRootRecyclerView) this.rootView.findViewById(R$id.teris_page_irecyclerview);
        this.mRecyclerView = damaiRootRecyclerView;
        this.mRecycleViewLayout = (ViewGroup) damaiRootRecyclerView.getParent();
        View findViewById = this.rootView.findViewById(R$id.category_image_gotop);
        this.mTopView = findViewById;
        findViewById.setOnClickListener(new View$OnClickListenerC1152c());
        View findViewById2 = this.rootView.findViewById(R$id.ll_empty);
        this.emptyView = findViewById2;
        findViewById2.setVisibility(8);
        this.mRecyclerView.addOnScrollListener(new RecyclerView.OnScrollListener() { // from class: cn.damai.homepage.show.ui.ShowFragment.4
            private static transient /* synthetic */ IpChange $ipChange;

            @Override // androidx.recyclerview.widget.RecyclerView.OnScrollListener
            public void onScrolled(RecyclerView recyclerView, int i, int i2) {
                IpChange ipChange2 = $ipChange;
                if (AndroidInstantRuntime.support(ipChange2, "-664404127")) {
                    ipChange2.ipc$dispatch("-664404127", new Object[]{this, recyclerView, Integer.valueOf(i), Integer.valueOf(i2)});
                } else if (ShowFragment.this.isRecyclerViewOverPage(recyclerView)) {
                    ShowFragment.this.mTopView.setVisibility(0);
                } else {
                    ShowFragment.this.mTopView.setVisibility(8);
                }
            }
        });
    }

    @Override // cn.damai.tetris.page.AbsFragment
    public void lazyLoad() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1945686473")) {
            ipChange.ipc$dispatch("-1945686473", new Object[]{this});
        } else {
            initData();
        }
    }

    @Override // cn.damai.commonbusiness.home.OnCityChangedListener
    public void onCityIdChanged() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1386329546")) {
            ipChange.ipc$dispatch("1386329546", new Object[]{this});
            return;
        }
        this.mIsChangeCity = true;
        CalendarPopView calendarPopView = this.mCalendarView;
        if (calendarPopView != null) {
            calendarPopView.t();
        }
        if (isVisible()) {
            initData();
        }
    }

    @Override // cn.damai.tetris.page.AbsFragment, androidx.fragment.app.Fragment
    @Nullable
    public View onCreateView(@NonNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, @Nullable Bundle bundle) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1434896646")) {
            return (View) ipChange.ipc$dispatch("1434896646", new Object[]{this, layoutInflater, viewGroup, bundle});
        }
        MainActivity mainActivity = (MainActivity) getActivity();
        this.mActivity = mainActivity;
        this.mData = mainActivity.getData();
        this.mIsRequesting = false;
        this.mIsCreateView = true;
        if (getArguments() != null) {
            try {
                this.mTitleBean = (HomeTabBean) getArguments().getSerializable("titlebean");
            } catch (Exception unused) {
            }
            HomeTabBean homeTabBean = this.mTitleBean;
            if (homeTabBean != null) {
                this.mCategoryId = homeTabBean.categoryId;
                this.mCategoryName = homeTabBean.name;
                this.spmB = homeTabBean.spmb;
            }
        }
        ViewGroup viewGroup2 = (ViewGroup) layoutInflater.inflate(R$layout.show_fragment, viewGroup, false);
        this.rootView = viewGroup2;
        FrameLayout frameLayout = (FrameLayout) viewGroup2.findViewById(R$id.layout_list);
        this.mListLayout = frameLayout;
        this.mListLayout.addView(super.onCreateView(layoutInflater, frameLayout, bundle), 0);
        CalendarPopView calendarPopView = new CalendarPopView(this.mActivity, true, true, 60, new C1150a());
        this.mCalendarView = calendarPopView;
        this.mListLayout.addView(calendarPopView.s(), -1, -1);
        this.mUTBuilder = oc2.h().g(this.mCategoryId);
        initView();
        return this.rootView;
    }

    @Override // cn.damai.tetris.page.AbsFragment, androidx.fragment.app.Fragment
    public void onDestroy() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "2018066558")) {
            ipChange.ipc$dispatch("2018066558", new Object[]{this});
            return;
        }
        this.mIsCreateView = false;
        this.mIsGetData = false;
        super.onDestroy();
    }

    @Override // androidx.fragment.app.Fragment
    public void onDestroyView() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1472744679")) {
            ipChange.ipc$dispatch("-1472744679", new Object[]{this});
        } else {
            super.onDestroyView();
        }
    }

    @Override // androidx.fragment.app.Fragment
    public void onHiddenChanged(boolean z) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-750515706")) {
            ipChange.ipc$dispatch("-750515706", new Object[]{this, Boolean.valueOf(z)});
        } else {
            super.onHiddenChanged(z);
        }
    }

    @Override // cn.damai.tetris.page.AbsFragment, cn.damai.uikit.irecycler.OnLoadMoreListener
    public void onLoadMore(View view) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1958460901")) {
            ipChange.ipc$dispatch("-1958460901", new Object[]{this, view});
            return;
        }
        showLoadMoreV2();
        showBottomLoadMore();
        if (this.mHasNextPage) {
            loadMoreResetV2(true);
            this.mShowRequest.pageIndex++;
            request(false, true);
            return;
        }
        showNoMoreV2();
        showBottonEmpty();
    }

    @Override // cn.damai.tetris.page.AbsFragment, cn.damai.tetris.core.msg.IMessage
    public void onMessage(int i, Object obj) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1196897070")) {
            ipChange.ipc$dispatch("1196897070", new Object[]{this, Integer.valueOf(i), obj});
        }
    }

    @Override // cn.damai.tetris.page.AbsFragment, androidx.fragment.app.Fragment
    public void onPause() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "156900802")) {
            ipChange.ipc$dispatch("156900802", new Object[]{this});
            return;
        }
        super.onPause();
        Log.e("abtest", "showfragment onPause  :" + this.mCategoryName);
    }

    @Override // cn.damai.tetris.page.AbsFragment, cn.damai.uikit.irecycler.OnRefreshListener
    public void onRefresh() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "236148221")) {
            ipChange.ipc$dispatch("236148221", new Object[]{this});
        } else {
            request(true, false);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // cn.damai.tetris.page.AbsFragment
    public void onResponseError(String str, String str2, String str3) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-745246737")) {
            ipChange.ipc$dispatch("-745246737", new Object[]{this, str, str2, str3});
            return;
        }
        this.mRecycleViewLayout.setVisibility(8);
        ResponseErrorPage responseErrorPage = this.mErrorPage;
        if (responseErrorPage == null || (!responseErrorPage.isShown() && this.mErrorPage.getParent() == null)) {
            ResponseErrorPage responseErrorPage2 = new ResponseErrorPage(this.mActivity, str, str2, str3);
            this.mErrorPage = responseErrorPage2;
            responseErrorPage2.setVisibility(0);
            this.mErrorPage.hideTitle();
            this.mErrorPage.setRefreshListener(new C1153d());
            this.mListLayout.addView(this.mErrorPage);
        }
    }

    @Override // cn.damai.tetris.page.AbsFragment
    public void onResponseSuccess() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1580001290")) {
            ipChange.ipc$dispatch("-1580001290", new Object[]{this});
            return;
        }
        this.mRecycleViewLayout.setVisibility(0);
        try {
            ResponseErrorPage responseErrorPage = this.mErrorPage;
            if (responseErrorPage != null) {
                responseErrorPage.setVisibility(8);
                this.mListLayout.removeView(this.mErrorPage);
                this.mErrorPage = null;
            }
        } catch (Exception unused) {
        }
    }

    @Override // cn.damai.tetris.page.AbsFragment, androidx.fragment.app.Fragment
    public void onResume() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-2078223227")) {
            ipChange.ipc$dispatch("-2078223227", new Object[]{this});
            return;
        }
        super.onResume();
        Log.e("abtest", "showfragment onResume  :" + this.mCategoryName);
    }

    @Override // cn.damai.tetris.page.AbsFragmentV2, cn.damai.tetris.page.AbsFragment, androidx.fragment.app.Fragment
    public void onViewCreated(@NonNull View view, @Nullable Bundle bundle) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1771816151")) {
            ipChange.ipc$dispatch("1771816151", new Object[]{this, view, bundle});
            return;
        }
        super.onViewCreated(view, bundle);
        enableDividerLine(false);
    }

    public void overWriteArgs(TetrisRequest tetrisRequest) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "217656885")) {
            ipChange.ipc$dispatch("217656885", new Object[]{this, tetrisRequest});
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

    public void reSetPage() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "2108041819")) {
            ipChange.ipc$dispatch("2108041819", new Object[]{this});
            return;
        }
        ShowRequest showRequest = this.mShowRequest;
        showRequest.cityOption = 0;
        showRequest.sortType = 3;
        showRequest.pageIndex = 1;
        showRequest.sortType = this.mSortType;
        this.drObj = null;
        this.mIsFristProject = true;
        this.mRecyclerView.scrollToPosition(0);
        this.mHasNextPage = true;
        loadMoreResetV2(true);
        this.mRecyclerView.setLoadMoreStatus(LoadMoreFooterView.Status.GONE);
        this.mRecyclerView.getLoadMoreFooterView().setVisibility(8);
    }

    public void request(boolean z) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "920447114")) {
            ipChange.ipc$dispatch("920447114", new Object[]{this, Boolean.valueOf(z)});
        } else {
            request(z, true);
        }
    }

    @Override // cn.damai.tetris.page.AbsFragmentV2, cn.damai.tetris.page.AbsFragment, androidx.fragment.app.Fragment
    public void setUserVisibleHint(boolean z) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-2048790641")) {
            ipChange.ipc$dispatch("-2048790641", new Object[]{this, Boolean.valueOf(z)});
            return;
        }
        boolean isLazyLoaded = isLazyLoaded();
        super.setUserVisibleHint(z);
        CalendarPopView calendarPopView = this.mCalendarView;
        if (calendarPopView != null) {
            calendarPopView.t();
        }
        this.mIsUserVisible = z;
        if (isLazyLoaded && z && this.mIsCreateView) {
            if (!this.mIsGetData || this.mIsChangeCity) {
                initData();
            }
        }
    }

    public void showBottomLoadMore() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "815964174")) {
            ipChange.ipc$dispatch("815964174", new Object[]{this});
            return;
        }
        this.mRecyclerView.getLoadMoreFooterView().setVisibility(0);
        this.mRecyclerView.setLoadMoreStatus(LoadMoreFooterView.Status.LOADING);
    }

    public void showBottonEmpty() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1335738037")) {
            ipChange.ipc$dispatch("1335738037", new Object[]{this});
            return;
        }
        this.mRecyclerView.setLoadMoreStatus(LoadMoreFooterView.Status.THE_END);
        this.mRecyclerView.getLoadMoreFooterView().setVisibility(8);
        this.mHasNextPage = false;
    }

    public void startTimer() {
        Daojishi daojishi;
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1985779982")) {
            ipChange.ipc$dispatch("1985779982", new Object[]{this});
        } else if (this.mData == null || (daojishi = this.mDaojishi) == null) {
        } else {
            daojishi.startTimer();
            sendMsg(new Message(1001, null));
        }
    }

    public void stopBottomProgress() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1000946793")) {
            ipChange.ipc$dispatch("-1000946793", new Object[]{this});
            return;
        }
        this.mRecyclerView.setLoadMoreStatus(LoadMoreFooterView.Status.GONE);
        this.mRecyclerView.getLoadMoreFooterView().setVisibility(8);
    }

    public void request(final boolean z, boolean z2) {
        DrObj drObj;
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1530864758")) {
            ipChange.ipc$dispatch("-1530864758", new Object[]{this, Boolean.valueOf(z), Boolean.valueOf(z2)});
        } else if (this.mIsRequesting) {
        } else {
            if (z) {
                reSetPage();
            }
            this.mIsRequesting = true;
            final TetrisRequest tetrisRequest = new TetrisRequest(getRequest());
            HomeTabBean homeTabBean = this.mTitleBean;
            tetrisRequest.patternVersion = homeTabBean.patternVersion;
            tetrisRequest.patternName = homeTabBean.patternName;
            overWriteArgs(tetrisRequest);
            if (this.mShowRequest.cityOption == 1 && (drObj = this.drObj) != null) {
                drObj.targetArgs = tetrisRequest.args;
                tetrisRequest.dr = jn1.ARRAY_START_STR + JSON.toJSONString(this.drObj) + jn1.ARRAY_END_STR;
            }
            tetrisRequest.request(new DMMtopWarningListener<BaseResponse>(BaseResponse.class, tetrisRequest.toJsonString()) { // from class: cn.damai.homepage.show.ui.ShowFragment.5
                private static transient /* synthetic */ IpChange $ipChange;

                @Override // cn.damai.tetris.DMMtopWarningListener
                public void onFailWithWarning(String str, String str2) {
                    IpChange ipChange2 = $ipChange;
                    if (AndroidInstantRuntime.support(ipChange2, "456938147")) {
                        ipChange2.ipc$dispatch("456938147", new Object[]{this, str, str2});
                        return;
                    }
                    ShowFragment.this.mIsRequesting = false;
                    ShowFragment.this.refreshFinish();
                    ShowFragment.this.stopProgressDialog();
                    ShowFragment.this.onResponseError("", "", "");
                }

                @Override // cn.damai.tetris.DMMtopWarningListener
                public void onSuccessWithWarning(BaseResponse baseResponse) {
                    Node node;
                    List<Node> list;
                    Node node2;
                    List<Node> list2;
                    IpChange ipChange2 = $ipChange;
                    if (AndroidInstantRuntime.support(ipChange2, "-739169733")) {
                        ipChange2.ipc$dispatch("-739169733", new Object[]{this, baseResponse});
                        return;
                    }
                    ShowFragment.this.emptyView.setVisibility(8);
                    ShowFragment.this.mIsChangeCity = false;
                    ShowFragment.this.mIsGetData = true;
                    ShowFragment.this.mIsRequesting = false;
                    ShowFragment.this.stopBottomProgress();
                    ShowFragment.this.refreshFinish();
                    ShowFragment.this.onResponseSuccess();
                    ShowFragment.this.stopProgressDialog();
                    if (tetrisRequest != null && baseResponse.layers != null) {
                        ShowFragment showFragment = ShowFragment.this;
                        showFragment.drObj = showFragment.getTetrisDr(baseResponse);
                        if (ShowFragment.this.mIsFristProject) {
                            if (baseResponse.layers != null) {
                                if (ShowFragment.this.checkEmpty(baseResponse)) {
                                    ShowFragment.this.emptyView.setVisibility(0);
                                } else {
                                    ShowFragment.this.emptyView.setVisibility(8);
                                }
                                if (ShowFragment.this.mDaojishi != null && ShowFragment.this.mDaojishi.serverTime == 0) {
                                    ShowFragment.this.mDaojishi.setServiceTimeAndDiff(baseResponse.serverTime);
                                }
                            } else {
                                onFail("", "");
                                if (ShowFragment.this.mShowRequest != null) {
                                    pc2.a(JSON.toJSONString(ShowFragment.this.mShowRequest));
                                    return;
                                }
                                return;
                            }
                        }
                        new C1154e(baseResponse).b();
                        Node e = new C9039db().e(baseResponse);
                        if (z) {
                            ShowFragment.this.setData(e);
                            GlobalConfig globalConfig = baseResponse.globalConfig;
                            if (globalConfig != null) {
                                ShowFragment.this.updateAB(globalConfig);
                            }
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
        }
    }
}
