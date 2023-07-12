package cn.damai.category.calendar.ui;

import android.content.res.Resources;
import android.graphics.Point;
import android.os.Build;
import android.text.TextUtils;
import android.view.Display;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.annotation.Nullable;
import androidx.lifecycle.Observer;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import cn.damai.category.calendar.bean.CalendarPerformEntity;
import cn.damai.category.calendar.bean.Day;
import cn.damai.category.calendar.bean.ProjectItem;
import cn.damai.category.calendar.model.CalendarModel;
import cn.damai.category.calendar.ui.adapter.HorizontalCategoryAdapter;
import cn.damai.category.calendar.ui.adapter.HorizontalHeadAdapter;
import cn.damai.category.common.bean.CalendarBean;
import cn.damai.category.common.bean.CategoryBean;
import cn.damai.category.common.bean.CategoryPerformBean;
import cn.damai.category.common.bean.CategoryProjectBean;
import cn.damai.category.common.request.CategoryRequest;
import cn.damai.category.common.ui.adapter.PerformListAdapter;
import cn.damai.category.common.utils.CalendarPopUtil;
import cn.damai.commonbusiness.base.ResponseErrorPage;
import cn.damai.commonbusiness.base.SimpleBaseActivity;
import cn.damai.commonbusiness.search.Daojishi;
import cn.damai.homepage.R$color;
import cn.damai.homepage.R$id;
import cn.damai.homepage.R$layout;
import cn.damai.uikit.iconfont.DMIconFontTextView;
import cn.damai.uikit.irecycler.HorizontalRecyclerView;
import cn.damai.uikit.irecycler.IRecyclerView;
import cn.damai.uikit.irecycler.OnLoadMoreListener;
import cn.damai.uikit.irecycler.OnRefreshListener;
import cn.damai.uikit.irecycler.widget.LoadMoreFooterView;
import cn.damai.uikit.irecycler.widget.PullToRefreshHeaderView;
import cn.damai.uikit.irecycler.widget.WrapLinearLayoutManager;
import cn.damai.user.view.SpaceItemDecoration;
import com.ali.user.mobile.utils.ScreenUtil;
import com.alibaba.wireless.security.aopsdk.replace.android.util.DisplayMetrics;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import java.util.ArrayList;
import java.util.List;
import tb.kg2;
import tb.mf;
import tb.rf;
import tb.t60;
import tb.wh2;
import tb.z20;

/* compiled from: Taobao */
/* loaded from: classes.dex */
public class PerformCalendarActivity extends SimpleBaseActivity implements OnLoadMoreListener, OnRefreshListener {
    private static transient /* synthetic */ IpChange $ipChange;
    private PerformListAdapter mAdapter;
    private ViewGroup mCalendarLayout;
    private CalendarModel mCalendarModel;
    private CalendarPopUtil mCalendarPopUtil;
    private HorizontalCategoryAdapter mCategoryAdapter;
    private HorizontalRecyclerView mCategoryRlv;
    private String mCityName;
    private String mCurrentCategoryName;
    private String mCurrentTopName;
    private List<CalendarPerformEntity> mDateList;
    private TextView mDateTv;
    private DMIconFontTextView mDateXiala;
    private View mEmptyFoot;
    private View mEmptyView;
    private String mEndDay;
    private HorizontalHeadAdapter mHeadAdapter;
    private HorizontalRecyclerView mHeadRlv;
    private View mLayoutDate;
    private View mLineView;
    private View mMengcengView;
    private ViewGroup mPopView;
    private IRecyclerView mRecyclerView;
    private String mStartDay;
    private List<String> mProjectIdList = new ArrayList();
    private int mCurrentTotal = 0;
    private int mTempTotal = 0;
    private boolean mHasNextPage = true;
    private boolean mFirstRequest = true;
    private int mScrollTotal = 0;
    private CategoryRequest mCategoryRequest = new CategoryRequest();
    private boolean mGoRequest = true;
    private Daojishi mDaojishi = new Daojishi();
    private View.OnClickListener mProjectItemListener = new f();

    /* compiled from: Taobao */
    /* loaded from: classes.dex */
    public class a implements ResponseErrorPage.ErrorRefreshListener {
        private static transient /* synthetic */ IpChange $ipChange;

        a() {
        }

        @Override // cn.damai.commonbusiness.base.ResponseErrorPage.ErrorRefreshListener
        public void handleError(int i) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "-1104327868")) {
                ipChange.ipc$dispatch("-1104327868", new Object[]{this, Integer.valueOf(i)});
            } else {
                PerformCalendarActivity.this.getDoubleReuqest();
            }
        }
    }

    /* compiled from: Taobao */
    /* loaded from: classes.dex */
    public class b implements View.OnClickListener {
        private static transient /* synthetic */ IpChange $ipChange;

        b() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "-1002452407")) {
                ipChange.ipc$dispatch("-1002452407", new Object[]{this, view});
            } else {
                PerformCalendarActivity.this.finish();
            }
        }
    }

    /* compiled from: Taobao */
    /* loaded from: classes.dex */
    public class c implements View.OnClickListener {
        private static transient /* synthetic */ IpChange $ipChange;

        c() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "1108837962")) {
                ipChange.ipc$dispatch("1108837962", new Object[]{this, view});
                return;
            }
            try {
                CalendarPerformEntity calendarPerformEntity = (CalendarPerformEntity) view.getTag();
                if (calendarPerformEntity == null) {
                    return;
                }
                PerformCalendarActivity.this.updateDateTv(false, "选择日期");
                PerformCalendarActivity.this.setListDateSelected(calendarPerformEntity);
                PerformCalendarActivity.this.mHeadAdapter.setData(PerformCalendarActivity.this.mDateList);
                PerformCalendarActivity.this.mCalendarPopUtil.o(rf.i(calendarPerformEntity));
                PerformCalendarActivity.this.mCalendarPopUtil.i();
                PerformCalendarActivity.this.getDoubleReuqest("0", calendarPerformEntity.dateType, calendarPerformEntity.startDate, calendarPerformEntity.endDate);
                cn.damai.common.user.c.e().x(mf.i().k(calendarPerformEntity.index, PerformCalendarActivity.this.mCityName, calendarPerformEntity.name));
            } catch (Exception unused) {
            }
        }
    }

    /* compiled from: Taobao */
    /* loaded from: classes.dex */
    public class d implements View.OnClickListener {
        private static transient /* synthetic */ IpChange $ipChange;

        d() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "-1074838965")) {
                ipChange.ipc$dispatch("-1074838965", new Object[]{this, view});
            } else {
                PerformCalendarActivity.this.mCalendarPopUtil.q(PerformCalendarActivity.this.mDateXiala, true);
            }
        }
    }

    /* compiled from: Taobao */
    /* loaded from: classes.dex */
    public class e implements View.OnClickListener {
        private static transient /* synthetic */ IpChange $ipChange;

        e() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            CategoryBean categoryBean;
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "1036451404")) {
                ipChange.ipc$dispatch("1036451404", new Object[]{this, view});
            } else if (view.getTag() == null || (categoryBean = (CategoryBean) view.getTag()) == null) {
            } else {
                PerformCalendarActivity.this.startProgressDialog();
                PerformCalendarActivity.this.reSetPage();
                CategoryRequest categoryRequest = PerformCalendarActivity.this.mCategoryRequest;
                categoryRequest.categoryId = categoryBean.id + "";
                PerformCalendarActivity.this.mCalendarModel.getProjectListRequest(PerformCalendarActivity.this.mCategoryRequest);
                PerformCalendarActivity.this.mCurrentCategoryName = categoryBean.name;
                cn.damai.common.user.c.e().x(mf.i().h(categoryBean.id, PerformCalendarActivity.this.mCityName, PerformCalendarActivity.this.mCurrentTopName, PerformCalendarActivity.this.mCurrentCategoryName));
            }
        }
    }

    /* compiled from: Taobao */
    /* loaded from: classes.dex */
    public class f implements View.OnClickListener {
        private static transient /* synthetic */ IpChange $ipChange;

        f() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "964064846")) {
                ipChange.ipc$dispatch("964064846", new Object[]{this, view});
                return;
            }
            try {
                ProjectItem projectItem = (ProjectItem) view.getTag();
                if (projectItem == null || projectItem.projectItemBean == null) {
                    return;
                }
                PerformCalendarActivity.this.mGoRequest = false;
                cn.damai.common.user.c.e().x(mf.i().j(projectItem.index, PerformCalendarActivity.this.mCityName, PerformCalendarActivity.this.mCurrentTopName, PerformCalendarActivity.this.mCurrentCategoryName, projectItem.projectItemBean.id));
            } catch (Exception unused) {
            }
        }
    }

    /* compiled from: Taobao */
    /* loaded from: classes.dex */
    public class g implements View.OnClickListener {
        private static transient /* synthetic */ IpChange $ipChange;

        g() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Day day;
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "-1219612081")) {
                ipChange.ipc$dispatch("-1219612081", new Object[]{this, view});
            } else if (view.getTag() == null || (day = (Day) view.getTag()) == null || day.showType == 0) {
            } else {
                if (!TextUtils.isEmpty(day.project)) {
                    PerformCalendarActivity.this.mProjectIdList.clear();
                    PerformCalendarActivity.this.mProjectIdList.add(day.project);
                    PerformCalendarActivity.this.mCategoryRequest.projectIdList = PerformCalendarActivity.this.mProjectIdList;
                }
                PerformCalendarActivity.this.startProgressDialog();
                PerformCalendarActivity performCalendarActivity = PerformCalendarActivity.this;
                performCalendarActivity.updateDateTv(true, day.month + "月" + day.day + "日");
                PerformCalendarActivity.this.setListDateSelected(null);
                PerformCalendarActivity.this.mHeadAdapter.setData(PerformCalendarActivity.this.mDateList);
                PerformCalendarActivity.this.mStartDay = rf.c(day);
                PerformCalendarActivity.this.mEndDay = rf.c(day);
                ArrayList arrayList = new ArrayList();
                arrayList.add(day);
                PerformCalendarActivity.this.mCalendarPopUtil.o(arrayList);
                PerformCalendarActivity performCalendarActivity2 = PerformCalendarActivity.this;
                performCalendarActivity2.getDoubleReuqest("0", 5, performCalendarActivity2.mStartDay, PerformCalendarActivity.this.mEndDay);
                cn.damai.common.user.c e = cn.damai.common.user.c.e();
                mf i = mf.i();
                int i2 = day.day;
                String str = PerformCalendarActivity.this.mCityName;
                e.x(i.g(i2, str, day.year + "年" + day.month + "月" + day.day + "日"));
                PerformCalendarActivity.this.mProjectIdList.clear();
                PerformCalendarActivity performCalendarActivity3 = PerformCalendarActivity.this;
                performCalendarActivity3.mCurrentTopName = performCalendarActivity3.mDateTv.getText().toString();
            }
        }
    }

    static /* synthetic */ int access$1312(PerformCalendarActivity performCalendarActivity, int i) {
        int i2 = performCalendarActivity.mScrollTotal + i;
        performCalendarActivity.mScrollTotal = i2;
        return i2;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void getDoubleReuqest(String str, int i, String str2, String str3) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1839134414")) {
            ipChange.ipc$dispatch("-1839134414", new Object[]{this, str, Integer.valueOf(i), str2, str3});
            return;
        }
        reSetPage();
        startProgressDialog();
        CategoryRequest categoryRequest = this.mCategoryRequest;
        categoryRequest.categoryId = str;
        categoryRequest.startDate = str2;
        categoryRequest.endDate = str3;
        categoryRequest.dateType = i;
        this.mCalendarModel.getProjectListRequest(categoryRequest);
        this.mCalendarModel.getCategoryPerformRequest(this.mCategoryRequest);
    }

    private List<CalendarPerformEntity> getHeadDates() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-129006549")) {
            return (List) ipChange.ipc$dispatch("-129006549", new Object[]{this});
        }
        ArrayList arrayList = new ArrayList();
        CalendarPerformEntity calendarPerformEntity = new CalendarPerformEntity();
        calendarPerformEntity.name = "七日精选";
        calendarPerformEntity.dateType = 5;
        calendarPerformEntity.startDate = rf.o();
        calendarPerformEntity.endDate = rf.j();
        calendarPerformEntity.index = 0;
        calendarPerformEntity.isSelected = true;
        CalendarPerformEntity calendarPerformEntity2 = new CalendarPerformEntity();
        calendarPerformEntity2.name = "月度看点";
        calendarPerformEntity2.dateType = 5;
        calendarPerformEntity2.startDate = rf.o();
        calendarPerformEntity2.endDate = rf.l();
        calendarPerformEntity2.index = 1;
        CalendarPerformEntity calendarPerformEntity3 = new CalendarPerformEntity();
        calendarPerformEntity3.name = "全部时间";
        calendarPerformEntity3.dateType = 5;
        calendarPerformEntity3.startDate = rf.o();
        calendarPerformEntity3.endDate = rf.a();
        calendarPerformEntity3.index = 2;
        arrayList.add(calendarPerformEntity);
        arrayList.add(calendarPerformEntity2);
        arrayList.add(calendarPerformEntity3);
        return arrayList;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public List<ProjectItem> getProjectData(CategoryProjectBean categoryProjectBean) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1943259554")) {
            return (List) ipChange.ipc$dispatch("-1943259554", new Object[]{this, categoryProjectBean});
        }
        ArrayList arrayList = new ArrayList();
        if (categoryProjectBean == null) {
            return arrayList;
        }
        int i = categoryProjectBean.total;
        if (i == 0) {
            if (this.mFirstRequest) {
                ProjectItem projectItem = new ProjectItem();
                projectItem.type = 1;
                projectItem.hasCurrentCity = false;
                arrayList.add(projectItem);
                CategoryRequest categoryRequest = this.mCategoryRequest;
                categoryRequest.cityOption = 1;
                categoryRequest.sortType = 4;
            }
        } else if (i <= 3 && i > 0) {
            for (int i2 = 0; i2 < categoryProjectBean.currentCity.size(); i2++) {
                ProjectItem projectItem2 = new ProjectItem();
                projectItem2.projectItemBean = categoryProjectBean.currentCity.get(i2);
                arrayList.add(projectItem2);
            }
            if (wh2.e(categoryProjectBean.nearByCity) == 0) {
                this.mHasNextPage = false;
            } else {
                ProjectItem projectItem3 = new ProjectItem();
                projectItem3.type = 1;
                projectItem3.hasCurrentCity = true;
                arrayList.add(projectItem3);
                CategoryRequest categoryRequest2 = this.mCategoryRequest;
                categoryRequest2.cityOption = 1;
                categoryRequest2.sortType = 4;
            }
        } else if (wh2.e(categoryProjectBean.currentCity) > 0) {
            for (int i3 = 0; i3 < categoryProjectBean.currentCity.size(); i3++) {
                ProjectItem projectItem4 = new ProjectItem();
                projectItem4.projectItemBean = categoryProjectBean.currentCity.get(i3);
                arrayList.add(projectItem4);
            }
            this.mCurrentTotal = categoryProjectBean.total;
            int size = this.mTempTotal + categoryProjectBean.currentCity.size();
            this.mTempTotal = size;
            if (size >= this.mCurrentTotal || categoryProjectBean.currentCity.size() == 0) {
                this.mHasNextPage = false;
            }
        }
        if (categoryProjectBean.total <= 3) {
            if (wh2.e(categoryProjectBean.nearByCity) > 0) {
                for (int i4 = 0; i4 < categoryProjectBean.nearByCity.size(); i4++) {
                    ProjectItem projectItem5 = new ProjectItem();
                    projectItem5.projectItemBean = categoryProjectBean.nearByCity.get(i4);
                    arrayList.add(projectItem5);
                }
            } else {
                this.mHasNextPage = false;
            }
        }
        return arrayList;
    }

    private void initCategory(View view) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1569900501")) {
            ipChange.ipc$dispatch("1569900501", new Object[]{this, view});
            return;
        }
        this.mCategoryRlv = (HorizontalRecyclerView) view.findViewById(R$id.rlv_category);
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this);
        linearLayoutManager.setOrientation(0);
        this.mCategoryRlv.setLayoutManager(linearLayoutManager);
        HorizontalCategoryAdapter horizontalCategoryAdapter = new HorizontalCategoryAdapter(this, new e());
        this.mCategoryAdapter = horizontalCategoryAdapter;
        this.mCategoryRlv.setAdapter(horizontalCategoryAdapter);
        this.mCategoryRlv.addItemDecoration(new SpaceItemDecoration(ScreenUtil.dip2px(this, 5.0f)));
    }

    private void initData() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-289332559")) {
            ipChange.ipc$dispatch("-289332559", new Object[]{this});
            return;
        }
        if (wh2.e(this.mDateList) > 0) {
            this.mCalendarPopUtil.o(rf.i(this.mDateList.get(0)));
        }
        this.mCityName = z20.d();
        CalendarModel calendarModel = new CalendarModel(this);
        this.mCalendarModel = calendarModel;
        calendarModel.calendarRequest(rf.o(), rf.a());
        this.mCalendarModel.getCalendarBean().observe(this, new Observer<CalendarBean>() { // from class: cn.damai.category.calendar.ui.PerformCalendarActivity.8
            private static transient /* synthetic */ IpChange $ipChange;

            @Override // androidx.lifecycle.Observer
            public void onChanged(@Nullable CalendarBean calendarBean) {
                IpChange ipChange2 = $ipChange;
                if (AndroidInstantRuntime.support(ipChange2, "635345254")) {
                    ipChange2.ipc$dispatch("635345254", new Object[]{this, calendarBean});
                } else if (calendarBean != null) {
                    PerformCalendarActivity.this.mCalendarPopUtil.l(calendarBean);
                    PerformCalendarActivity.this.mStartDay = rf.o();
                    PerformCalendarActivity.this.mEndDay = rf.a();
                    PerformCalendarActivity.this.getDoubleReuqest("0", 5, rf.o(), rf.j());
                } else {
                    PerformCalendarActivity.this.onResponseError("", "", "");
                }
            }
        });
        this.mCalendarModel.getCalendarProjectBean().observe(this, new Observer<CategoryProjectBean>() { // from class: cn.damai.category.calendar.ui.PerformCalendarActivity.9
            private static transient /* synthetic */ IpChange $ipChange;

            @Override // androidx.lifecycle.Observer
            public void onChanged(@Nullable CategoryProjectBean categoryProjectBean) {
                IpChange ipChange2 = $ipChange;
                if (AndroidInstantRuntime.support(ipChange2, "2010542386")) {
                    ipChange2.ipc$dispatch("2010542386", new Object[]{this, categoryProjectBean});
                    return;
                }
                PerformCalendarActivity.this.stopProgressDialog();
                PerformCalendarActivity.this.mRecyclerView.setRefreshing(false);
                if (PerformCalendarActivity.this.mFirstRequest) {
                    if (categoryProjectBean != null) {
                        PerformCalendarActivity.this.mDaojishi.setServiceTimeAndDiff(categoryProjectBean.currentTime);
                        PerformCalendarActivity.this.onResponseSuccess();
                        if (wh2.e(categoryProjectBean.currentCity) + wh2.e(categoryProjectBean.nearByCity) == 0) {
                            PerformCalendarActivity.this.setEmptyView();
                            return;
                        }
                    } else {
                        PerformCalendarActivity.this.onResponseError("", "", "");
                        return;
                    }
                }
                PerformCalendarActivity.this.setProjectView();
                if (PerformCalendarActivity.this.mFirstRequest) {
                    PerformCalendarActivity.this.mDaojishi.startTimer();
                    PerformCalendarActivity.this.mAdapter.b(PerformCalendarActivity.this.getProjectData(categoryProjectBean), false, PerformCalendarActivity.this.mDaojishi);
                } else {
                    PerformCalendarActivity.this.mAdapter.a(PerformCalendarActivity.this.getProjectData(categoryProjectBean), false);
                }
                PerformCalendarActivity.this.mFirstRequest = false;
            }
        });
        this.mCalendarModel.getCategoryPerformBean().observe(this, new Observer<CategoryPerformBean>() { // from class: cn.damai.category.calendar.ui.PerformCalendarActivity.10
            private static transient /* synthetic */ IpChange $ipChange;

            @Override // androidx.lifecycle.Observer
            public void onChanged(@Nullable CategoryPerformBean categoryPerformBean) {
                IpChange ipChange2 = $ipChange;
                if (AndroidInstantRuntime.support(ipChange2, "1705880148")) {
                    ipChange2.ipc$dispatch("1705880148", new Object[]{this, categoryPerformBean});
                    return;
                }
                PerformCalendarActivity.this.stopProgressDialog();
                PerformCalendarActivity.this.mRecyclerView.setRefreshing(false);
                if (categoryPerformBean == null || wh2.e(categoryPerformBean.statistics) == 0) {
                    PerformCalendarActivity.this.mCategoryRlv.setVisibility(8);
                    return;
                }
                CategoryBean categoryBean = categoryPerformBean.statistics.get(0);
                if (categoryBean == null || categoryBean.count != 0) {
                    PerformCalendarActivity.this.mCategoryRlv.setVisibility(0);
                    PerformCalendarActivity.this.mCategoryAdapter.g(categoryPerformBean);
                    return;
                }
                PerformCalendarActivity.this.mCategoryRlv.setVisibility(8);
            }
        });
    }

    private void initPop() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "485519262")) {
            ipChange.ipc$dispatch("485519262", new Object[]{this});
            return;
        }
        this.mMengcengView = findViewById(R$id.view_mengceng);
        ViewGroup viewGroup = (ViewGroup) findViewById(R$id.layout_calendar);
        this.mPopView = viewGroup;
        this.mCalendarPopUtil = new CalendarPopUtil(this, this.mDateTv, this.mMengcengView, viewGroup, true, false, false, getRealHeight(), new g());
    }

    private void initRecyclerView() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1002172055")) {
            ipChange.ipc$dispatch("1002172055", new Object[]{this});
            return;
        }
        this.mRecyclerView = (IRecyclerView) findViewById(R$id.irc);
        this.mLineView = findViewById(R$id.view_line);
        this.mEmptyView = findViewById(R$id.ll_empty);
        this.mRecyclerView.setLayoutManager(new WrapLinearLayoutManager(this));
        PerformListAdapter performListAdapter = new PerformListAdapter(this, false, this.mProjectItemListener);
        this.mAdapter = performListAdapter;
        this.mRecyclerView.setAdapter(performListAdapter);
        this.mRecyclerView.setRefreshEnabled(true);
        this.mRecyclerView.setLoadMoreEnabled(true);
        this.mRecyclerView.setIsAutoToDefault(false);
        this.mRecyclerView.setOnRefreshListener(this);
        this.mRecyclerView.setOnLoadMoreListener(this);
        this.mRecyclerView.getLoadMoreFooterView().setVisibility(8);
        this.mRecyclerView.addOnScrollListener(new RecyclerView.OnScrollListener() { // from class: cn.damai.category.calendar.ui.PerformCalendarActivity.5
            private static transient /* synthetic */ IpChange $ipChange;

            @Override // androidx.recyclerview.widget.RecyclerView.OnScrollListener
            public void onScrolled(RecyclerView recyclerView, int i, int i2) {
                IpChange ipChange2 = $ipChange;
                if (AndroidInstantRuntime.support(ipChange2, "-2002663578")) {
                    ipChange2.ipc$dispatch("-2002663578", new Object[]{this, recyclerView, Integer.valueOf(i), Integer.valueOf(i2)});
                    return;
                }
                PerformCalendarActivity.access$1312(PerformCalendarActivity.this, i2);
                if (PerformCalendarActivity.this.mScrollTotal < 0) {
                    PerformCalendarActivity.this.mScrollTotal = 0;
                }
                if (PerformCalendarActivity.this.mScrollTotal < 5) {
                    PerformCalendarActivity.this.mLineView.setVisibility(8);
                } else {
                    PerformCalendarActivity.this.mLineView.setVisibility(0);
                }
            }
        });
        this.mRecyclerView.setRefreshHeaderView(PullToRefreshHeaderView.getInstance(this, 100, false, R$color.color_ffffff));
        View inflate = LayoutInflater.from(this).inflate(R$layout.canlendar_sub, (ViewGroup) null);
        initCategory(inflate);
        this.mRecyclerView.addHeaderView(inflate);
        this.mEmptyFoot = LayoutInflater.from(this).inflate(R$layout.common_footer_empty_new, (ViewGroup) null);
        this.mEmptyFoot.setLayoutParams(new ViewGroup.LayoutParams(-1, t60.a(this, 110.0f)));
        this.mRecyclerView.addFooterView(this.mEmptyFoot);
        this.mEmptyFoot.setVisibility(8);
    }

    private void initTitle() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "257855415")) {
            ipChange.ipc$dispatch("257855415", new Object[]{this});
            return;
        }
        removeHeadTitleView();
        findViewById(R$id.btn_left).setOnClickListener(new b());
        View findViewById = findViewById(R$id.status_bar_space);
        if (Build.VERSION.SDK_INT >= 23) {
            findViewById.getLayoutParams().height = kg2.a(this);
            findViewById.setVisibility(0);
            kg2.f(this, true, R$color.black);
            kg2.d(true, this);
        } else {
            kg2.f(this, false, R$color.black);
            findViewById.setVisibility(8);
        }
        this.mCalendarLayout = (ViewGroup) findViewById(R$id.layout_main);
    }

    private void initTop() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "600035866")) {
            ipChange.ipc$dispatch("600035866", new Object[]{this});
            return;
        }
        this.mLayoutDate = findViewById(R$id.layout_date);
        this.mHeadRlv = (HorizontalRecyclerView) findViewById(R$id.rlv_head);
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this);
        linearLayoutManager.setOrientation(0);
        this.mHeadRlv.setLayoutManager(linearLayoutManager);
        this.mHeadAdapter = new HorizontalHeadAdapter(this, new c());
        this.mDateTv = (TextView) findViewById(R$id.tv_date);
        this.mDateXiala = (DMIconFontTextView) findViewById(R$id.tv_date_xiala);
        this.mLayoutDate.setOnClickListener(new d());
        this.mHeadRlv.setAdapter(this.mHeadAdapter);
        this.mHeadRlv.addItemDecoration(new SpaceItemDecoration(ScreenUtil.dip2px(this, 5.0f)));
        List<CalendarPerformEntity> headDates = getHeadDates();
        this.mDateList = headDates;
        this.mHeadAdapter.setData(headDates);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void reSetPage() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "456664769")) {
            ipChange.ipc$dispatch("456664769", new Object[]{this});
            return;
        }
        this.mScrollTotal = 0;
        this.mRecyclerView.smoothScrollToPosition(0);
        this.mLineView.setVisibility(8);
        CategoryRequest categoryRequest = this.mCategoryRequest;
        categoryRequest.sortType = 3;
        categoryRequest.pageIndex = 1;
        categoryRequest.cityOption = 0;
        this.mCurrentTotal = 0;
        this.mTempTotal = 0;
        this.mHasNextPage = true;
        this.mFirstRequest = true;
        this.mRecyclerView.setLoadMoreStatus(LoadMoreFooterView.Status.GONE);
        this.mRecyclerView.getLoadMoreFooterView().setVisibility(8);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setEmptyView() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-862866053")) {
            ipChange.ipc$dispatch("-862866053", new Object[]{this});
            return;
        }
        this.mRecyclerView.setVisibility(8);
        this.mCategoryRlv.setVisibility(8);
        this.mEmptyView.setVisibility(0);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setListDateSelected(CalendarPerformEntity calendarPerformEntity) {
        String str;
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-229271511")) {
            ipChange.ipc$dispatch("-229271511", new Object[]{this, calendarPerformEntity});
        } else if (this.mDateList != null) {
            for (int i = 0; i < this.mDateList.size(); i++) {
                CalendarPerformEntity calendarPerformEntity2 = this.mDateList.get(i);
                if (calendarPerformEntity2 != null) {
                    if (calendarPerformEntity == null) {
                        calendarPerformEntity2.isSelected = false;
                    } else {
                        String str2 = calendarPerformEntity2.name;
                        if (str2 != null && (str = calendarPerformEntity.name) != null && str2.equals(str)) {
                            calendarPerformEntity2.isSelected = true;
                        } else {
                            calendarPerformEntity2.isSelected = false;
                        }
                    }
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setProjectView() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "771177519")) {
            ipChange.ipc$dispatch("771177519", new Object[]{this});
            return;
        }
        this.mRecyclerView.setVisibility(0);
        this.mEmptyView.setVisibility(8);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void updateDateTv(boolean z, String str) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1546100948")) {
            ipChange.ipc$dispatch("-1546100948", new Object[]{this, Boolean.valueOf(z), str});
            return;
        }
        this.mDateTv.setText(str);
        if (z) {
            TextView textView = this.mDateTv;
            Resources resources = getResources();
            int i = R$color.color_ff2d79;
            textView.setTextColor(resources.getColor(i));
            this.mDateXiala.setTextColor(getResources().getColor(i));
            return;
        }
        TextView textView2 = this.mDateTv;
        Resources resources2 = getResources();
        int i2 = R$color.color_000000;
        textView2.setTextColor(resources2.getColor(i2));
        this.mDateXiala.setTextColor(getResources().getColor(i2));
    }

    @Override // cn.damai.common.app.base.BaseActivity
    public int getLayoutId() {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "952149015") ? ((Integer) ipChange.ipc$dispatch("952149015", new Object[]{this})).intValue() : R$layout.calendar_activty;
    }

    public int getRealHeight() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1846014103")) {
            return ((Integer) ipChange.ipc$dispatch("1846014103", new Object[]{this})).intValue();
        }
        int i = DisplayMetrics.getheightPixels(getResources().getDisplayMetrics());
        if (Build.VERSION.SDK_INT >= 17) {
            Display defaultDisplay = getWindowManager().getDefaultDisplay();
            Point point = new Point();
            Point point2 = new Point();
            com.alibaba.wireless.security.aopsdk.replace.android.view.Display.getSize(defaultDisplay, point);
            com.alibaba.wireless.security.aopsdk.replace.android.view.Display.getRealSize(defaultDisplay, point2);
            return com.alibaba.wireless.security.aopsdk.replace.android.graphics.Point.gety(point2);
        }
        return i;
    }

    @Override // cn.damai.commonbusiness.base.SimpleBaseActivity, cn.damai.common.app.base.BaseActivity
    public void initView() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1278299690")) {
            ipChange.ipc$dispatch("-1278299690", new Object[]{this});
            return;
        }
        super.initView();
        initTitle();
        initTop();
        initRecyclerView();
        initPop();
        setDamaiUTKeyBuilder(mf.i().f());
        this.mGoRequest = true;
    }

    @Override // cn.damai.uikit.irecycler.OnLoadMoreListener
    public void onLoadMore(View view) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1290932097")) {
            ipChange.ipc$dispatch("1290932097", new Object[]{this, view});
        } else if (this.mHasNextPage) {
            showBottonLoadMore();
            startProgressDialog();
            CategoryRequest categoryRequest = this.mCategoryRequest;
            categoryRequest.pageIndex++;
            this.mCalendarModel.getProjectListRequest(categoryRequest);
        } else {
            showBottonEmpty();
        }
    }

    @Override // cn.damai.uikit.irecycler.OnRefreshListener
    public void onRefresh() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1415228829")) {
            ipChange.ipc$dispatch("-1415228829", new Object[]{this});
            return;
        }
        startProgressDialog();
        reSetPage();
        this.mCalendarModel.getProjectListRequest(this.mCategoryRequest);
    }

    protected void onResponseError(String str, String str2, String str3) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-293445803")) {
            ipChange.ipc$dispatch("-293445803", new Object[]{this, str, str2, str3});
            return;
        }
        ResponseErrorPage responseErrorPage = this.mErrorPage;
        if (responseErrorPage == null || (!responseErrorPage.isShown() && this.mErrorPage.getParent() == null)) {
            ResponseErrorPage responseErrorPage2 = new ResponseErrorPage(this, str, str2, str3);
            this.mErrorPage = responseErrorPage2;
            responseErrorPage2.hideTitle();
            this.mErrorPage.setVisibility(0);
            this.mErrorPage.setRefreshListener(new a());
            this.mCalendarLayout.addView(this.mErrorPage);
        }
    }

    public void onResponseSuccess() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1897050532")) {
            ipChange.ipc$dispatch("-1897050532", new Object[]{this});
            return;
        }
        try {
            ResponseErrorPage responseErrorPage = this.mErrorPage;
            if (responseErrorPage != null) {
                responseErrorPage.setVisibility(8);
                this.mCalendarLayout.removeView(this.mErrorPage);
                this.mErrorPage = null;
            }
        } catch (Exception e2) {
            e2.printStackTrace();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // cn.damai.commonbusiness.base.DamaiBaseActivity, cn.damai.common.app.base.BaseActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onResume() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-607472801")) {
            ipChange.ipc$dispatch("-607472801", new Object[]{this});
            return;
        }
        super.onResume();
        if (this.mGoRequest) {
            initData();
        } else {
            this.mDaojishi.startTimer();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // cn.damai.commonbusiness.base.DamaiBaseActivity, androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onStop() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1230616278")) {
            ipChange.ipc$dispatch("-1230616278", new Object[]{this});
            return;
        }
        super.onStop();
        this.mGoRequest = false;
        this.mDaojishi.stopTimer();
    }

    @Override // cn.damai.common.app.base.BaseActivity
    protected String setTitle() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1137043893")) {
            return (String) ipChange.ipc$dispatch("-1137043893", new Object[]{this});
        }
        return null;
    }

    public void showBottonEmpty() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1920882331")) {
            ipChange.ipc$dispatch("1920882331", new Object[]{this});
            return;
        }
        this.mRecyclerView.setLoadMoreStatus(LoadMoreFooterView.Status.THE_END);
        this.mRecyclerView.getLoadMoreFooterView().setVisibility(8);
        this.mEmptyFoot.setVisibility(0);
    }

    public void showBottonLoadMore() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-293545017")) {
            ipChange.ipc$dispatch("-293545017", new Object[]{this});
            return;
        }
        this.mEmptyFoot.setVisibility(8);
        this.mRecyclerView.getLoadMoreFooterView().setVisibility(0);
        this.mRecyclerView.setLoadMoreStatus(LoadMoreFooterView.Status.LOADING);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void getDoubleReuqest() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-57108613")) {
            ipChange.ipc$dispatch("-57108613", new Object[]{this});
            return;
        }
        reSetPage();
        this.mCalendarModel.getProjectListRequest(this.mCategoryRequest);
        this.mCalendarModel.getCategoryPerformRequest(this.mCategoryRequest);
    }
}
