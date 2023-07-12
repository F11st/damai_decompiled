package cn.damai.category.category.ui;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.graphics.Point;
import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import android.text.TextUtils;
import android.util.DisplayMetrics;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.viewpager.widget.ViewPager;
import cn.damai.category.calendar.bean.Day;
import cn.damai.category.category.bean.CategoryNewTitleBean;
import cn.damai.category.category.bean.CategoryNewTitleListBean;
import cn.damai.category.category.bean.ConditionEntity;
import cn.damai.category.category.model.CategoryModel;
import cn.damai.category.category.repository.CategoryRepository;
import cn.damai.category.category.ui.adapter.CategoryPagerAdapter;
import cn.damai.category.category.ui.view.CityView;
import cn.damai.category.categorygirl.ui.GirlFragment;
import cn.damai.category.common.bean.CalendarBean;
import cn.damai.category.common.ui.adapter.HorizontalTitleAdapter;
import cn.damai.category.common.utils.CalendarPopUtil;
import cn.damai.category.discountticket.bean.biz.DtParams;
import cn.damai.category.discountticket.ui.DiscountTicketFragment;
import cn.damai.common.user.C0529c;
import cn.damai.commonbusiness.base.DamaiBaseMvpFragment;
import cn.damai.commonbusiness.city.net.CityListResponse;
import cn.damai.homepage.R$id;
import cn.damai.homepage.R$layout;
import cn.damai.uikit.iconfont.DMIconFontTextView;
import cn.damai.uikit.irecycler.HorizontalRecyclerView;
import cn.damai.uikit.view.Option;
import cn.damai.user.view.SpaceItemDecoration;
import com.ali.user.mobile.utils.ScreenUtil;
import com.alibaba.wireless.security.aopsdk.replace.android.view.Display;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.List;
import tb.C9796v;
import tb.bh;
import tb.ja1;
import tb.o91;
import tb.q62;
import tb.rf;
import tb.xr;
import tb.zi;

/* compiled from: Taobao */
@Deprecated
/* loaded from: classes.dex */
public class CategoryFragment extends DamaiBaseMvpFragment {
    private static transient /* synthetic */ IpChange $ipChange = null;
    public static final int REQUEST_CODE = 1005;
    private CategoryActivity mActivity;
    private CalendarPopUtil mCalendarPopUtil;
    private CityView mCityView;
    private int mCurIndex;
    private CategoryRepository mData;
    private HorizontalTitleAdapter mHeadAdapter;
    private HorizontalRecyclerView mHeadRlv;
    private boolean mIsInitData;
    private LinearLayoutManager mLayoutManager;
    private View mMengcengView;
    private CategoryModel mModel;
    private CategoryPagerAdapter mPagerAdapter;
    private q62 mScreenView;
    public CategoryNewTitleBean mSelectTitle;
    private List<CategoryNewTitleBean> mTitleList;
    private View mView;
    private ViewPager mViewPager;
    private List<Fragment> mListFragment = new ArrayList();
    private boolean mHasTitleData = false;
    private boolean mHasCityData = false;
    private boolean mHasCanledarData = false;

    /* compiled from: Taobao */
    /* renamed from: cn.damai.category.category.ui.CategoryFragment$a */
    /* loaded from: classes.dex */
    public class View$OnClickListenerC0330a implements View.OnClickListener {
        private static transient /* synthetic */ IpChange $ipChange;

        View$OnClickListenerC0330a() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "-1229405470")) {
                ipChange.ipc$dispatch("-1229405470", new Object[]{this, view});
                return;
            }
            CategoryNewTitleBean categoryNewTitleBean = (CategoryNewTitleBean) view.getTag();
            if (categoryNewTitleBean != null) {
                if (categoryNewTitleBean.type == 3 && categoryNewTitleBean.categoryId != null && categoryNewTitleBean.index == CategoryFragment.this.mCurIndex) {
                    return;
                }
                CategoryFragment categoryFragment = CategoryFragment.this;
                categoryFragment.mSelectTitle = categoryNewTitleBean;
                categoryFragment.mCurIndex = categoryNewTitleBean.index;
                CategoryRepository categoryRepository = CategoryFragment.this.mData;
                CategoryFragment categoryFragment2 = CategoryFragment.this;
                categoryRepository.categoryId = categoryFragment2.mSelectTitle.categoryId;
                CategoryRepository categoryRepository2 = categoryFragment2.mData;
                CategoryFragment categoryFragment3 = CategoryFragment.this;
                categoryRepository2.type = categoryFragment3.mSelectTitle.type;
                CategoryRepository categoryRepository3 = categoryFragment3.mData;
                CategoryFragment categoryFragment4 = CategoryFragment.this;
                categoryRepository3.categoryName = categoryFragment4.mSelectTitle.name;
                categoryFragment4.mViewPager.setCurrentItem(categoryNewTitleBean.index);
                CategoryFragment.this.moveToCenter(view);
            }
        }
    }

    /* compiled from: Taobao */
    /* renamed from: cn.damai.category.category.ui.CategoryFragment$b */
    /* loaded from: classes.dex */
    public class C0331b extends q62 {
        private static transient /* synthetic */ IpChange $ipChange;

        C0331b(View view) {
            super(view);
        }

        @Override // tb.q62
        public void a(int i) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "620148353")) {
                ipChange.ipc$dispatch("620148353", new Object[]{this, Integer.valueOf(i)});
                return;
            }
            super.a(i);
            if (CategoryFragment.this.getCurrentShowFragment() != null && CategoryFragment.this.getCurrentShowFragment().mRecyclerView != null) {
                CategoryFragment.this.getCurrentShowFragment().mRecyclerView.scrollToPosition(0);
            }
            CategoryFragment.this.hidePop(i);
        }

        @Override // tb.q62
        public void b(Option option) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "-1381702789")) {
                ipChange.ipc$dispatch("-1381702789", new Object[]{this, option});
            } else if (option == null) {
            } else {
                if (option.index == 1) {
                    CategoryFragment.this.mData.isShowJuli = true;
                    ja1.c();
                } else {
                    CategoryFragment.this.mData.isShowJuli = false;
                }
                CategoryFragment.this.hidePop(0);
                CategoryFragment.this.mData.conditionEntity.sortType = option.id;
                CategoryFragment.this.getDoubleReuqest(false, true);
                if (CategoryFragment.this.mSelectTitle != null) {
                    C0529c e = C0529c.e();
                    bh m = bh.m();
                    int i = option.index;
                    String str = CategoryFragment.this.mSelectTitle.name;
                    String str2 = option.title;
                    e.x(m.o(i, str, str2, option.id + ""));
                }
            }
        }
    }

    /* compiled from: Taobao */
    /* renamed from: cn.damai.category.category.ui.CategoryFragment$c */
    /* loaded from: classes.dex */
    public class C0332c extends CityView {
        private static transient /* synthetic */ IpChange $ipChange;

        C0332c(Activity activity, int i, View view, View view2, View view3) {
            super(activity, i, view, view2, view3);
        }

        @Override // cn.damai.category.category.ui.view.CityView
        public void x(int i, int i2, String str, String str2) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "-1822954603")) {
                ipChange.ipc$dispatch("-1822954603", new Object[]{this, Integer.valueOf(i), Integer.valueOf(i2), str, str2});
                return;
            }
            super.x(i, i2, str, str2);
            CategoryFragment.this.hidePop(0);
            if (TextUtils.isEmpty(str)) {
                return;
            }
            xr.c(zi.CATEGORY_CITY_CHANGED_EVENT, str);
            CategoryFragment.this.mData.conditionEntity.currentCityId = str;
            CategoryFragment.this.getDoubleReuqest(true, true);
            CategoryFragment.this.mModel.calendarRequest(CategoryFragment.this.mData.conditionEntity.currentCityId, rf.o(), rf.a());
            CategoryFragment.this.mScreenView.g();
            if (CategoryFragment.this.mSelectTitle != null) {
                C0529c.e().x(bh.m().j(i, i2, CategoryFragment.this.mSelectTitle.name, str2));
            }
        }
    }

    /* compiled from: Taobao */
    /* renamed from: cn.damai.category.category.ui.CategoryFragment$d */
    /* loaded from: classes.dex */
    public class View$OnClickListenerC0333d implements View.OnClickListener {
        private static transient /* synthetic */ IpChange $ipChange;

        View$OnClickListenerC0333d() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "809498341")) {
                ipChange.ipc$dispatch("809498341", new Object[]{this, view});
            } else if (CategoryFragment.this.getCurrentShowFragment() == null || CategoryFragment.this.getCurrentShowFragment().mRefreshView == null) {
            } else {
                CategoryFragment.this.getCurrentShowFragment().mRefreshView.setPullToRefreshEnabled(true);
            }
        }
    }

    /* compiled from: Taobao */
    /* renamed from: cn.damai.category.category.ui.CategoryFragment$e */
    /* loaded from: classes.dex */
    public class View$OnClickListenerC0334e implements View.OnClickListener {
        private static transient /* synthetic */ IpChange $ipChange;

        View$OnClickListenerC0334e() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "-1374178586")) {
                ipChange.ipc$dispatch("-1374178586", new Object[]{this, view});
            } else if (view.getTag() != null) {
                CategoryFragment.this.mScreenView.g();
                CategoryFragment.this.hidePop(0);
                Day day = (Day) view.getTag();
                if (day == null || day.showType == 0) {
                    return;
                }
                if (!TextUtils.isEmpty(day.project)) {
                    CategoryFragment.this.mData.conditionEntity.projectIdList.clear();
                    CategoryFragment.this.mData.conditionEntity.projectIdList.add(day.project);
                } else {
                    CategoryFragment.this.mData.conditionEntity.projectIdList.clear();
                }
                String c = rf.c(day);
                ArrayList arrayList = new ArrayList();
                arrayList.add(day);
                CategoryFragment.this.mCalendarPopUtil.o(arrayList);
                CategoryFragment.this.mData.conditionEntity.dateType = 5;
                CategoryFragment.this.mData.conditionEntity.startDate = c;
                CategoryFragment.this.mData.conditionEntity.endDate = c;
                CategoryFragment.this.getDoubleReuqest(true, false);
                if (CategoryFragment.this.mSelectTitle != null) {
                    C0529c.e().x(bh.m().l(4, CategoryFragment.this.mSelectTitle.name, "calendar", rf.c(day)));
                }
                CategoryFragment.this.mData.conditionEntity.projectIdList.clear();
            }
        }
    }

    /* compiled from: Taobao */
    /* renamed from: cn.damai.category.category.ui.CategoryFragment$f */
    /* loaded from: classes.dex */
    public class C0335f extends CalendarPopUtil {
        private static transient /* synthetic */ IpChange $ipChange;

        C0335f(Context context, View view, View view2, ViewGroup viewGroup, boolean z, boolean z2, boolean z3, int i, View.OnClickListener onClickListener) {
            super(context, view, view2, viewGroup, z, z2, z3, i, onClickListener);
        }

        @Override // cn.damai.category.common.utils.CalendarPopUtil
        public void k(int i, int i2, String str) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "490144872")) {
                ipChange.ipc$dispatch("490144872", new Object[]{this, Integer.valueOf(i), Integer.valueOf(i2), str});
                return;
            }
            super.k(i, i2, str);
            CategoryFragment.this.mScreenView.g();
            CategoryFragment.this.hidePop(0);
            if (i != -1) {
                if (i == 6) {
                    CategoryFragment.this.mData.conditionEntity.dateType = 5;
                    CategoryFragment.this.mData.conditionEntity.startDate = rf.o();
                    CategoryFragment.this.mData.conditionEntity.endDate = rf.j();
                } else {
                    CategoryFragment.this.mData.conditionEntity.dateType = i;
                }
                CategoryFragment.this.getDoubleReuqest(true, true);
                if (CategoryFragment.this.mSelectTitle == null) {
                    return;
                }
                C0529c.e().x(bh.m().l(i2, CategoryFragment.this.mSelectTitle.name, "timerange", str));
            }
        }
    }

    /* compiled from: Taobao */
    /* renamed from: cn.damai.category.category.ui.CategoryFragment$g */
    /* loaded from: classes.dex */
    public class View$OnClickListenerC0336g implements View.OnClickListener {
        private static transient /* synthetic */ IpChange $ipChange;

        View$OnClickListenerC0336g() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "-1446565144")) {
                ipChange.ipc$dispatch("-1446565144", new Object[]{this, view});
            } else {
                CategoryFragment.this.hidePop(0);
            }
        }
    }

    private Fragment getCurrentFragment() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "998388926")) {
            return (Fragment) ipChange.ipc$dispatch("998388926", new Object[]{this});
        }
        CategoryPagerAdapter categoryPagerAdapter = this.mPagerAdapter;
        if (categoryPagerAdapter != null) {
            return categoryPagerAdapter.b();
        }
        return null;
    }

    private GirlFragment getCurrentGirlFragment() {
        CategoryPagerAdapter categoryPagerAdapter;
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "161626729")) {
            return (GirlFragment) ipChange.ipc$dispatch("161626729", new Object[]{this});
        }
        if (this.mSelectTitle == null || (categoryPagerAdapter = this.mPagerAdapter) == null) {
            return null;
        }
        Fragment b = categoryPagerAdapter.b();
        if (b instanceof GirlFragment) {
            return (GirlFragment) b;
        }
        return null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public ShowFragment getCurrentShowFragment() {
        CategoryPagerAdapter categoryPagerAdapter;
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1483238171")) {
            return (ShowFragment) ipChange.ipc$dispatch("-1483238171", new Object[]{this});
        }
        if (this.mSelectTitle == null || (categoryPagerAdapter = this.mPagerAdapter) == null) {
            return null;
        }
        Fragment b = categoryPagerAdapter.b();
        if (b instanceof ShowFragment) {
            return (ShowFragment) b;
        }
        return null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void getDoubleReuqest(boolean z, boolean z2) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "955685331")) {
            ipChange.ipc$dispatch("955685331", new Object[]{this, Boolean.valueOf(z), Boolean.valueOf(z2)});
            return;
        }
        this.mData.isChangeCondition = true;
        if (!this.mHasTitleData) {
            this.mModel.categoryNewTitleRequest();
        }
        if (!this.mHasCityData) {
            this.mModel.getCityRequest();
        }
        if (!this.mHasCanledarData) {
            this.mModel.calendarRequest(this.mData.conditionEntity.currentCityId, rf.o(), rf.a());
        }
        if (getCurrentShowFragment() != null) {
            getCurrentShowFragment().request(true, z2);
        }
    }

    private boolean getIsAizhe(int i, int i2) {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "-806727336") ? ((Boolean) ipChange.ipc$dispatch("-806727336", new Object[]{this, Integer.valueOf(i), Integer.valueOf(i2)})).booleanValue() : Math.abs(i - i2) <= 1;
    }

    private DamaiBaseMvpFragment getMVPFragment() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1135995152")) {
            return (DamaiBaseMvpFragment) ipChange.ipc$dispatch("-1135995152", new Object[]{this});
        }
        CategoryPagerAdapter categoryPagerAdapter = this.mPagerAdapter;
        if (categoryPagerAdapter != null) {
            Fragment b = categoryPagerAdapter.b();
            if (b instanceof DamaiBaseMvpFragment) {
                return (DamaiBaseMvpFragment) b;
            }
            return null;
        }
        return null;
    }

    private void getRequest() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "15844842")) {
            ipChange.ipc$dispatch("15844842", new Object[]{this});
            return;
        }
        this.mActivity.startProgressDialog();
        this.mModel.categoryNewTitleRequest();
        this.mModel.getCityRequest();
        this.mModel.calendarRequest(this.mData.conditionEntity.currentCityId, rf.o(), rf.a());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void hidePop(int i) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-578962613")) {
            ipChange.ipc$dispatch("-578962613", new Object[]{this, Integer.valueOf(i)});
        } else if (i == 0) {
            this.mCityView.q();
            this.mCalendarPopUtil.i();
            if (getCurrentShowFragment() == null || getCurrentShowFragment().mRefreshView == null) {
                return;
            }
            getCurrentShowFragment().mRefreshView.setPullToRefreshEnabled(true);
        } else if (i == 1) {
            this.mCalendarPopUtil.i();
            if (!this.mCityView.p() && this.mSelectTitle != null) {
                C0529c e = C0529c.e();
                bh m = bh.m();
                String str = this.mSelectTitle.name;
                e.x(m.i(str, ((Object) ((TextView) this.rootView.findViewById(R$id.tv_tab1)).getText()) + ""));
            }
            this.mCityView.z((DMIconFontTextView) this.rootView.findViewById(R$id.icon_tab1));
            if (getCurrentShowFragment() == null || getCurrentShowFragment().mRefreshView == null) {
                return;
            }
            getCurrentShowFragment().mRefreshView.setPullToRefreshEnabled(false);
        } else if (i != 2) {
        } else {
            this.mCityView.q();
            if (!this.mCalendarPopUtil.h() && this.mSelectTitle != null) {
                C0529c e2 = C0529c.e();
                bh m2 = bh.m();
                String str2 = this.mSelectTitle.name;
                e2.x(m2.k(str2, ((Object) ((TextView) this.rootView.findViewById(R$id.tv_tab2)).getText()) + ""));
            }
            this.mCalendarPopUtil.q((DMIconFontTextView) this.rootView.findViewById(R$id.icon_tab2), true);
            if (getCurrentShowFragment() == null || getCurrentShowFragment().mRefreshView == null) {
                return;
            }
            getCurrentShowFragment().mRefreshView.setPullToRefreshEnabled(false);
        }
    }

    private void initCalendar() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1809192907")) {
            ipChange.ipc$dispatch("-1809192907", new Object[]{this});
            return;
        }
        C0335f c0335f = new C0335f(this.mActivity, this.rootView.findViewById(R$id.tv_tab2), this.mMengcengView, (ViewGroup) this.rootView.findViewById(R$id.layout_calendar), false, true, true, getRealHeight(), new View$OnClickListenerC0334e());
        this.mCalendarPopUtil = c0335f;
        c0335f.n(new View$OnClickListenerC0336g());
    }

    private void initCity() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "2043153896")) {
            ipChange.ipc$dispatch("2043153896", new Object[]{this});
            return;
        }
        C0332c c0332c = new C0332c(this.mActivity, getRealHeight(), this.rootView.findViewById(R$id.tv_tab1), this.rootView.findViewById(R$id.layout_city), this.mMengcengView);
        this.mCityView = c0332c;
        c0332c.y(new View$OnClickListenerC0333d());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void initData() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1594057911")) {
            ipChange.ipc$dispatch("-1594057911", new Object[]{this});
            return;
        }
        this.mModel = new CategoryModel(getContext());
        ConditionEntity conditionEntity = this.mData.conditionEntity;
        conditionEntity.dateType = 0;
        conditionEntity.startDate = null;
        conditionEntity.endDate = null;
        getRequest();
        this.mModel.getCategoryTitleBean().observe(this, new Observer<CategoryNewTitleListBean>() { // from class: cn.damai.category.category.ui.CategoryFragment.9
            private static transient /* synthetic */ IpChange $ipChange;

            @Override // androidx.lifecycle.Observer
            public void onChanged(@Nullable CategoryNewTitleListBean categoryNewTitleListBean) {
                IpChange ipChange2 = $ipChange;
                if (AndroidInstantRuntime.support(ipChange2, "-1872679548")) {
                    ipChange2.ipc$dispatch("-1872679548", new Object[]{this, categoryNewTitleListBean});
                } else {
                    CategoryFragment.this.updateTitle(categoryNewTitleListBean);
                }
            }
        });
        this.mModel.getCalendarBean().observe(this, new Observer<CalendarBean>() { // from class: cn.damai.category.category.ui.CategoryFragment.10
            private static transient /* synthetic */ IpChange $ipChange;

            @Override // androidx.lifecycle.Observer
            public void onChanged(@Nullable CalendarBean calendarBean) {
                IpChange ipChange2 = $ipChange;
                if (AndroidInstantRuntime.support(ipChange2, "-2096391629")) {
                    ipChange2.ipc$dispatch("-2096391629", new Object[]{this, calendarBean});
                } else if (calendarBean == null) {
                } else {
                    CategoryFragment.this.mHasCanledarData = true;
                    CategoryFragment.this.mCalendarPopUtil.l(calendarBean);
                }
            }
        });
        this.mModel.getCityBeanBean().observe(this, new Observer<CityListResponse>() { // from class: cn.damai.category.category.ui.CategoryFragment.11
            private static transient /* synthetic */ IpChange $ipChange;

            @Override // androidx.lifecycle.Observer
            public void onChanged(@Nullable CityListResponse cityListResponse) {
                IpChange ipChange2 = $ipChange;
                if (AndroidInstantRuntime.support(ipChange2, "-93982552")) {
                    ipChange2.ipc$dispatch("-93982552", new Object[]{this, cityListResponse});
                } else if (cityListResponse == null) {
                } else {
                    CategoryFragment.this.mHasCityData = true;
                    CategoryFragment.this.mScreenView.f(0);
                    CategoryFragment.this.mScreenView.c(0);
                    CategoryFragment.this.mCityView.r(cityListResponse);
                }
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void moveToCenter(View view) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-599112848")) {
            ipChange.ipc$dispatch("-599112848", new Object[]{this, view});
            return;
        }
        int[] iArr = new int[2];
        view.getLocationOnScreen(iArr);
        int width = view.getWidth();
        DisplayMetrics displayMetrics = new DisplayMetrics();
        Display.getMetrics(((WindowManager) this.mActivity.getSystemService(C9796v.ATTACH_MODE_WINDOW)).getDefaultDisplay(), displayMetrics);
        this.mHeadRlv.smoothScrollBy((iArr[0] - (com.alibaba.wireless.security.aopsdk.replace.android.util.DisplayMetrics.getwidthPixels(displayMetrics) / 2)) + (width / 2), 0);
    }

    private void setHidden123() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "234494877")) {
            ipChange.ipc$dispatch("234494877", new Object[]{this});
        } else {
            this.mScreenView.f(8);
        }
    }

    private void setHidden23() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "978338490")) {
            ipChange.ipc$dispatch("978338490", new Object[]{this});
            return;
        }
        this.mScreenView.e(8);
        this.mScreenView.d(8);
    }

    private void setViewPaperItem(int i) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "499460952")) {
            ipChange.ipc$dispatch("499460952", new Object[]{this, Integer.valueOf(i)});
            return;
        }
        try {
            Field declaredField = Class.forName("androidx.viewpager.widget.ViewPager").getDeclaredField("mCurItem");
            declaredField.setAccessible(true);
            declaredField.setInt(this.mViewPager, i);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void show123() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1502116718")) {
            ipChange.ipc$dispatch("-1502116718", new Object[]{this});
            return;
        }
        this.mScreenView.f(0);
        this.mScreenView.e(0);
        this.mScreenView.d(0);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Removed duplicated region for block: B:18:0x004c A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:19:0x004d  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public void updateTitle(cn.damai.category.category.bean.CategoryNewTitleListBean r7) {
        /*
            r6 = this;
            com.android.alibaba.ip.runtime.IpChange r0 = cn.damai.category.category.ui.CategoryFragment.$ipChange
            java.lang.String r1 = "-1168353665"
            boolean r2 = com.android.alibaba.ip.runtime.AndroidInstantRuntime.support(r0, r1)
            r3 = 0
            r4 = 1
            r5 = 2
            if (r2 == 0) goto L17
            java.lang.Object[] r2 = new java.lang.Object[r5]
            r2[r3] = r6
            r2[r4] = r7
            r0.ipc$dispatch(r1, r2)
            return
        L17:
            java.lang.String r0 = "categoryTitleList"
            if (r7 == 0) goto L2f
            java.util.List<cn.damai.category.category.bean.CategoryNewTitleBean> r1 = r7.data     // Catch: java.lang.Exception -> L2d
            boolean r1 = tb.o91.a(r1)     // Catch: java.lang.Exception -> L2d
            if (r1 != 0) goto L2f
            r6.mHasTitleData = r4     // Catch: java.lang.Exception -> L2d
            java.lang.String r1 = com.alibaba.fastjson.JSON.toJSONString(r7)     // Catch: java.lang.Exception -> L2d
            tb.z20.T(r0, r1)     // Catch: java.lang.Exception -> L2d
            goto L42
        L2d:
            goto L42
        L2f:
            java.lang.String r0 = tb.z20.B(r0)     // Catch: java.lang.Exception -> L2d
            boolean r1 = android.text.TextUtils.isEmpty(r0)     // Catch: java.lang.Exception -> L2d
            if (r1 != 0) goto L42
            java.lang.Class<cn.damai.category.category.bean.CategoryNewTitleListBean> r1 = cn.damai.category.category.bean.CategoryNewTitleListBean.class
            java.lang.Object r0 = com.alibaba.fastjson.JSON.parseObject(r0, r1)     // Catch: java.lang.Exception -> L2d
            cn.damai.category.category.bean.CategoryNewTitleListBean r0 = (cn.damai.category.category.bean.CategoryNewTitleListBean) r0     // Catch: java.lang.Exception -> L2d
            r7 = r0
        L42:
            java.util.List r7 = tb.ch.b(r7)
            boolean r0 = tb.o91.a(r7)
            if (r0 == 0) goto L4d
            return
        L4d:
            cn.damai.category.category.repository.CategoryRepository r0 = r6.mData
            java.lang.String r1 = r0.categoryId
            int r0 = r0.type
            int r0 = tb.ch.a(r1, r0)
            r6.mCurIndex = r0
            cn.damai.category.common.ui.adapter.HorizontalTitleAdapter r1 = r6.mHeadAdapter
            r1.h(r7, r0)
            int r0 = r6.mCurIndex
            if (r0 == 0) goto L6e
            if (r0 == r4) goto L6e
            if (r0 != r5) goto L67
            goto L6e
        L67:
            cn.damai.uikit.irecycler.HorizontalRecyclerView r1 = r6.mHeadRlv
            int r0 = r0 - r5
            r1.scrollToPosition(r0)
            goto L73
        L6e:
            cn.damai.uikit.irecycler.HorizontalRecyclerView r0 = r6.mHeadRlv
            r0.scrollToPosition(r3)
        L73:
            r6.mTitleList = r7
            cn.damai.category.common.ui.adapter.HorizontalTitleAdapter r0 = r6.mHeadAdapter
            int r1 = r6.mCurIndex
            r0.i(r1)
            java.util.List<cn.damai.category.category.bean.CategoryNewTitleBean> r0 = r6.mTitleList
            int r1 = r6.mCurIndex
            java.lang.Object r0 = r0.get(r1)
            cn.damai.category.category.bean.CategoryNewTitleBean r0 = (cn.damai.category.category.bean.CategoryNewTitleBean) r0
            r6.mSelectTitle = r0
            int r0 = r6.mCurIndex
            r6.updateViewPager(r7, r0)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: cn.damai.category.category.ui.CategoryFragment.updateTitle(cn.damai.category.category.bean.CategoryNewTitleListBean):void");
    }

    private void updateViewPager(List<CategoryNewTitleBean> list, int i) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1194508512")) {
            ipChange.ipc$dispatch("-1194508512", new Object[]{this, list, Integer.valueOf(i)});
        } else if (!o91.a(list)) {
            this.mListFragment.clear();
            for (int i2 = 0; i2 < list.size(); i2++) {
                CategoryNewTitleBean categoryNewTitleBean = list.get(i2);
                if (categoryNewTitleBean != null) {
                    Fragment fragment = null;
                    int i3 = categoryNewTitleBean.type;
                    if (i3 == 1) {
                        fragment = GirlFragment.newInstance(categoryNewTitleBean.name);
                    } else if (i3 == 2) {
                        fragment = DiscountTicketFragment.instance(new DtParams(8, "discount"));
                    } else if (i3 == 3) {
                        fragment = new ShowFragment();
                        Bundle bundle = new Bundle();
                        bundle.putSerializable("titlebean", categoryNewTitleBean);
                        fragment.setArguments(bundle);
                    }
                    this.mListFragment.add(fragment);
                }
            }
            setViewPaperItem(i);
            CategoryPagerAdapter categoryPagerAdapter = new CategoryPagerAdapter(getChildFragmentManager(), this.mListFragment);
            this.mPagerAdapter = categoryPagerAdapter;
            this.mViewPager.setAdapter(categoryPagerAdapter);
            this.mViewPager.addOnPageChangeListener(new ViewPager.OnPageChangeListener() { // from class: cn.damai.category.category.ui.CategoryFragment.12
                private static transient /* synthetic */ IpChange $ipChange;

                @Override // androidx.viewpager.widget.ViewPager.OnPageChangeListener
                public void onPageScrollStateChanged(int i4) {
                    IpChange ipChange2 = $ipChange;
                    if (AndroidInstantRuntime.support(ipChange2, "-1669777139")) {
                        ipChange2.ipc$dispatch("-1669777139", new Object[]{this, Integer.valueOf(i4)});
                    }
                }

                @Override // androidx.viewpager.widget.ViewPager.OnPageChangeListener
                public void onPageScrolled(int i4, float f, int i5) {
                    IpChange ipChange2 = $ipChange;
                    if (AndroidInstantRuntime.support(ipChange2, "1819026092")) {
                        ipChange2.ipc$dispatch("1819026092", new Object[]{this, Integer.valueOf(i4), Float.valueOf(f), Integer.valueOf(i5)});
                    }
                }

                @Override // androidx.viewpager.widget.ViewPager.OnPageChangeListener
                public void onPageSelected(int i4) {
                    IpChange ipChange2 = $ipChange;
                    if (AndroidInstantRuntime.support(ipChange2, "1525519512")) {
                        ipChange2.ipc$dispatch("1525519512", new Object[]{this, Integer.valueOf(i4)});
                    } else {
                        CategoryFragment.this.changePage(i4, true);
                    }
                }
            });
            this.mCurIndex = i;
            this.mViewPager.setCurrentItem(i);
            String str = this.mSelectTitle.patternName;
            bh.c = str;
            bh.d = str;
            changePage(i, true);
        }
    }

    public void changePage(int i, boolean z) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "34784085")) {
            ipChange.ipc$dispatch("34784085", new Object[]{this, Integer.valueOf(i), Boolean.valueOf(z)});
            return;
        }
        this.mData.isAizhe = getIsAizhe(this.mCurIndex, i);
        hidePop(0);
        CategoryNewTitleBean categoryNewTitleBean = this.mTitleList.get(i);
        this.mSelectTitle = categoryNewTitleBean;
        if (categoryNewTitleBean == null) {
            return;
        }
        this.mData.showTitleBean = categoryNewTitleBean;
        int i2 = categoryNewTitleBean.type;
        if (i2 == 1) {
            setHidden123();
        } else if (i2 == 2) {
            setHidden123();
        } else if (i2 == 3) {
            if (categoryNewTitleBean.isShowFilter == 1) {
                show123();
            } else {
                setHidden123();
            }
        }
        CategoryRepository categoryRepository = this.mData;
        CategoryNewTitleBean categoryNewTitleBean2 = this.mSelectTitle;
        categoryRepository.categoryId = categoryNewTitleBean2.categoryId;
        categoryRepository.type = categoryNewTitleBean2.type;
        categoryRepository.categoryName = categoryNewTitleBean2.name;
        View findViewByPosition = this.mLayoutManager.findViewByPosition(i);
        if (findViewByPosition != null) {
            moveToCenter(findViewByPosition);
        } else {
            this.mHeadRlv.scrollToPosition(i);
        }
        this.mHeadAdapter.i(i);
        CategoryRepository categoryRepository2 = this.mData;
        categoryRepository2.isNeedShowClickUt = true;
        int i3 = this.mSelectTitle.type;
        if (i3 == 1) {
            String str = categoryRepository2.mXiannvBdian;
            bh.c = str;
            bh.d = str;
        } else if (i3 == 2) {
            bh.c = "zhekou";
            bh.d = "zhekou";
        } else if (i3 == 3) {
            String str2 = categoryRepository2.showTitleBean.patternName;
            bh.c = str2;
            bh.d = str2;
        }
        if (getMVPFragment() != null) {
            getMVPFragment().pageUtBuild();
        }
        if (getCurrentGirlFragment() != null) {
            getCurrentGirlFragment().pageUtBuild();
        }
    }

    @Override // cn.damai.common.app.base.BaseFragment
    protected int getLayoutResource() {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "-405115092") ? ((Integer) ipChange.ipc$dispatch("-405115092", new Object[]{this})).intValue() : R$layout.category_fragment;
    }

    public int getRealHeight() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1315432705")) {
            return ((Integer) ipChange.ipc$dispatch("-1315432705", new Object[]{this})).intValue();
        }
        int i = com.alibaba.wireless.security.aopsdk.replace.android.util.DisplayMetrics.getheightPixels(getResources().getDisplayMetrics());
        if (Build.VERSION.SDK_INT >= 17) {
            android.view.Display defaultDisplay = this.mActivity.getWindowManager().getDefaultDisplay();
            Point point = new Point();
            Point point2 = new Point();
            Display.getSize(defaultDisplay, point);
            Display.getRealSize(defaultDisplay, point2);
            return com.alibaba.wireless.security.aopsdk.replace.android.graphics.Point.gety(point2);
        }
        return i;
    }

    @Override // cn.damai.commonbusiness.base.ResponseErrorPage.ErrorRefreshListener
    public void handleError(int i) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "813003484")) {
            ipChange.ipc$dispatch("813003484", new Object[]{this, Integer.valueOf(i)});
        }
    }

    @Override // cn.damai.common.app.base.BaseFragment
    public void initPresenter() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "804165327")) {
            ipChange.ipc$dispatch("804165327", new Object[]{this});
        }
    }

    @Override // cn.damai.common.app.base.BaseFragment
    public void initView() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1711942254")) {
            ipChange.ipc$dispatch("1711942254", new Object[]{this});
            return;
        }
        this.mMengcengView = this.rootView.findViewById(R$id.view_mengceng);
        this.mHeadRlv = (HorizontalRecyclerView) this.rootView.findViewById(R$id.rlv_head);
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this.mActivity);
        this.mLayoutManager = linearLayoutManager;
        linearLayoutManager.setOrientation(0);
        this.mHeadRlv.setLayoutManager(this.mLayoutManager);
        this.mHeadRlv.addItemDecoration(new SpaceItemDecoration(ScreenUtil.dip2px(this.mActivity, 9.0f)));
        HorizontalTitleAdapter horizontalTitleAdapter = new HorizontalTitleAdapter(this.mActivity, new View$OnClickListenerC0330a());
        this.mHeadAdapter = horizontalTitleAdapter;
        this.mHeadRlv.setAdapter(horizontalTitleAdapter);
        this.mScreenView = new C0331b(this.rootView.findViewById(R$id.layout_screen));
        this.mViewPager = (ViewPager) this.rootView.findViewById(R$id.category_pager);
        initCity();
        initCalendar();
    }

    @Override // androidx.fragment.app.Fragment
    public void onActivityResult(int i, int i2, Intent intent) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-165632299")) {
            ipChange.ipc$dispatch("-165632299", new Object[]{this, Integer.valueOf(i), Integer.valueOf(i2), intent});
        } else {
            super.onActivityResult(i, i2, intent);
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "701813972")) {
            ipChange.ipc$dispatch("701813972", new Object[]{this, view});
        }
    }

    @Override // cn.damai.common.app.base.BaseFragment, androidx.fragment.app.Fragment
    @Nullable
    public View onCreateView(@NonNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, @Nullable Bundle bundle) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-406160136")) {
            return (View) ipChange.ipc$dispatch("-406160136", new Object[]{this, layoutInflater, viewGroup, bundle});
        }
        CategoryActivity categoryActivity = (CategoryActivity) getActivity();
        this.mActivity = categoryActivity;
        this.mData = categoryActivity.getData();
        View onCreateView = super.onCreateView(layoutInflater, viewGroup, bundle);
        this.mView = onCreateView;
        return onCreateView;
    }

    @Override // androidx.fragment.app.Fragment
    public void onDestroy() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1425090740")) {
            ipChange.ipc$dispatch("-1425090740", new Object[]{this});
            return;
        }
        super.onDestroy();
        this.mListFragment.clear();
        this.mListFragment = null;
    }

    public boolean onInterceptLocationActivityResult(int i, int i2, Intent intent) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-164932732")) {
            return ((Boolean) ipChange.ipc$dispatch("-164932732", new Object[]{this, Integer.valueOf(i), Integer.valueOf(i2), intent})).booleanValue();
        }
        CityView cityView = this.mCityView;
        if (cityView != null) {
            return cityView.w(i, i2, intent);
        }
        return false;
    }

    @Override // cn.damai.commonbusiness.base.DamaiBaseMvpFragment, cn.damai.common.app.base.BaseFragment, androidx.fragment.app.Fragment
    public void setUserVisibleHint(boolean z) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1758733091")) {
            ipChange.ipc$dispatch("-1758733091", new Object[]{this, Boolean.valueOf(z)});
            return;
        }
        super.setUserVisibleHint(z);
        if (!z || this.mIsInitData) {
            return;
        }
        new Handler().postDelayed(new Runnable() { // from class: cn.damai.category.category.ui.CategoryFragment.1
            private static transient /* synthetic */ IpChange $ipChange;

            @Override // java.lang.Runnable
            public void run() {
                IpChange ipChange2 = $ipChange;
                if (AndroidInstantRuntime.support(ipChange2, "1106961903")) {
                    ipChange2.ipc$dispatch("1106961903", new Object[]{this});
                } else if (CategoryFragment.this.isVisible()) {
                    CategoryFragment.this.initData();
                    CategoryFragment.this.mIsInitData = true;
                }
            }
        }, 200L);
    }

    public void startTimer() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1672881152")) {
            ipChange.ipc$dispatch("-1672881152", new Object[]{this});
        } else if (getCurrentShowFragment() != null) {
            getCurrentShowFragment().startTimer();
        }
    }
}
