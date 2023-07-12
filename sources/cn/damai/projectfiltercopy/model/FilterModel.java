package cn.damai.projectfiltercopy.model;

import android.text.TextUtils;
import androidx.annotation.NonNull;
import cn.damai.commonbusiness.calendarcopy.bean.CalendarBean;
import cn.damai.commonbusiness.calendarcopy.bean.CalendarEntity;
import cn.damai.commonbusiness.calendarcopy.bean.CalendarYearBean;
import cn.damai.commonbusiness.calendarcopy.bean.Day;
import cn.damai.projectfiltercopy.FloatListener;
import cn.damai.projectfiltercopy.bean.CalendarInitBean;
import cn.damai.projectfiltercopy.bean.CalendarStyle;
import cn.damai.projectfiltercopy.bean.CategoryLevelOne;
import cn.damai.projectfiltercopy.bean.CategoryLevelTwo;
import cn.damai.projectfiltercopy.bean.CityBean;
import cn.damai.projectfiltercopy.bean.FilterBean;
import cn.damai.projectfiltercopy.bean.FilterData;
import cn.damai.projectfiltercopy.bean.FilterGroupBean;
import cn.damai.projectfiltercopy.bean.FilterItemBean;
import cn.damai.projectfiltercopy.bean.FilterPrimaryBean;
import cn.damai.projectfiltercopy.bean.FilterReqParamBean;
import cn.damai.projectfiltercopy.bean.FilterResponse;
import cn.damai.projectfiltercopy.bean.PresetBean;
import cn.damai.projectfiltercopy.bean.SortBean;
import cn.damai.projectfiltercopy.bean.Type;
import cn.damai.projectfiltercopy.filterbtn.BtnInfoProvider;
import cn.damai.projectfiltercopy.listener.FilterParamChangeListener;
import cn.damai.projectfiltercopy.listener.HorDateClickResultListener;
import cn.damai.projectfiltercopy.listener.RequestParamProvider;
import cn.damai.projectfiltercopy.listener.UiBizListener;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import tb.bb2;
import tb.jh0;
import tb.of;
import tb.qd;

/* compiled from: Taobao */
/* loaded from: classes6.dex */
public class FilterModel implements FloatListener, BtnInfoProvider, RequestParamProvider {
    private static transient /* synthetic */ IpChange $ipChange;
    private List<SortBean> mBeanList;
    public CalendarBean mCalendarBean;
    public CityBean mCityBean;
    public List<FilterBean> mFastFilterList;
    public FilterBean mFastGroupIdSelected;
    private FilterItemBean mFilterBean;
    private UiBizListener mListener;
    public List<CategoryLevelOne> mNewCategoryList;
    private FilterParamChangeListener mParamChangeListener;
    private PresetBean mPresetBean;
    private FilterReqParamBean mReqParams;
    public List<Day> mSelectDayList;
    public List<CategoryLevelOne> mSelectedNewCategoryList;
    public SortBean mSortBean;
    public List<Day> mTotalDayList;
    private List<CalendarYearBean> mYearBeanList;
    private final List<CalendarEntity> mCalendarEntityList = of.b(12);
    public final List<String> mGroupKeyInFilterBtn = new ArrayList();
    public final HashMap<String, FilterGroupBean> mGroupKeyGroupMap = new HashMap<>();
    public final List<Type> supportBtnType = new ArrayList();
    private CalendarStyle mCalendarStyle = CalendarStyle.BTN;
    public final HashMap<String, List<FilterBean>> mFilterMap = new HashMap<>();
    public final CategoryDataAssembler mCatAssembler = new CategoryDataAssembler();

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: Taobao */
    /* renamed from: cn.damai.projectfiltercopy.model.FilterModel$a */
    /* loaded from: classes15.dex */
    public static /* synthetic */ class C1537a {
        static final /* synthetic */ int[] a;

        static {
            int[] iArr = new int[Type.values().length];
            a = iArr;
            try {
                iArr[Type.SORT.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                a[Type.DATE.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                a[Type.CITY.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                a[Type.FILTER.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                a[Type.NEW_CATEGORY.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                a[Type.DATE_HOR_CALENDAR.ordinal()] = 6;
            } catch (NoSuchFieldError unused6) {
            }
        }
    }

    public FilterModel(UiBizListener uiBizListener) {
        this.mListener = uiBizListener;
    }

    private List<FilterBean> cloneFastListByCurSelection(List<FilterBean> list) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1565991394")) {
            return (List) ipChange.ipc$dispatch("1565991394", new Object[]{this, list});
        }
        if (bb2.d(list)) {
            return null;
        }
        List<FilterBean> a = jh0.a(list);
        jh0.b(a, this.mCalendarBean);
        jh0.c(a, this.mFilterMap, this.mGroupKeyInFilterBtn);
        jh0.d(a, this.mFastGroupIdSelected);
        return a;
    }

    private void createRequestParams() {
        String str;
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1086485685")) {
            ipChange.ipc$dispatch("1086485685", new Object[]{this});
            return;
        }
        this.mReqParams = new FilterReqParamBean();
        CalendarBean calendarBean = this.mCalendarBean;
        if (calendarBean == null) {
            calendarBean = this.mPresetBean.obtainPresetDate();
        }
        if (calendarBean == null) {
            calendarBean = CalendarBean.defaultAllTime();
        }
        FilterReqParamBean filterReqParamBean = this.mReqParams;
        filterReqParamBean.dateType = calendarBean.dateType;
        filterReqParamBean.startDate = calendarBean.startDate;
        filterReqParamBean.endDate = calendarBean.endDate;
        if (this.supportBtnType.contains(Type.NEW_CATEGORY)) {
            if (bb2.f(this.mSelectedNewCategoryList)) {
                StringBuilder sb = new StringBuilder();
                StringBuilder sb2 = new StringBuilder();
                for (CategoryLevelOne categoryLevelOne : this.mSelectedNewCategoryList) {
                    List<CategoryLevelTwo> list = categoryLevelOne.lineItemList;
                    if (bb2.f(list)) {
                        if (bb2.a(list) == 1 && list.get(0).isAll()) {
                            sb.append(categoryLevelOne.value);
                            sb.append("|");
                        } else {
                            for (CategoryLevelTwo categoryLevelTwo : list) {
                                sb2.append(categoryLevelTwo.value);
                                sb2.append("|");
                            }
                        }
                    }
                }
                int length = sb.length();
                if (length > 0) {
                    this.mReqParams.firstLevelSelection = sb.deleteCharAt(length - 1).toString();
                }
                int length2 = sb2.length();
                if (length2 > 0) {
                    this.mReqParams.secondLevelSelection = sb2.deleteCharAt(length2 - 1).toString();
                }
            }
        } else {
            FilterReqParamBean filterReqParamBean2 = this.mReqParams;
            PresetBean presetBean = this.mPresetBean;
            filterReqParamBean2.firstLevelSelection = presetBean.firstLevelSelection;
            filterReqParamBean2.secondLevelSelection = presetBean.secondLevelSelection;
        }
        CityBean cityBean = this.mCityBean;
        if (cityBean == null) {
            cityBean = CityBean.defaultCity();
        }
        FilterReqParamBean filterReqParamBean3 = this.mReqParams;
        filterReqParamBean3.cityId = cityBean.cityCode;
        SortBean sortBean = this.mSortBean;
        if (sortBean != null) {
            filterReqParamBean3.sortType = sortBean.value;
        } else {
            String str2 = this.mPresetBean.sortType;
            if (TextUtils.isEmpty(str2)) {
                str2 = "10";
            }
            this.mReqParams.sortType = str2;
        }
        FilterBean filterBean = this.mFastGroupIdSelected;
        if (filterBean != null) {
            this.mReqParams.groupId = filterBean.value;
        } else {
            this.mReqParams.groupId = this.mPresetBean.groupId;
        }
        this.mReqParams.assembleFilter(this.mFilterMap);
        String str3 = null;
        if (!bb2.d(this.mSelectDayList) && !bb2.d(this.mTotalDayList)) {
            ArrayList<Day> arrayList = new ArrayList();
            for (Day day : this.mSelectDayList) {
                int indexOf = this.mTotalDayList.indexOf(day);
                if (indexOf >= 0) {
                    arrayList.add(this.mTotalDayList.get(indexOf));
                }
            }
            for (Day day2 : arrayList) {
                if (!TextUtils.isEmpty(day2.itemId)) {
                    str3 = day2.itemId;
                    str = day2.comboDispatchId;
                    break;
                }
            }
        }
        str = null;
        FilterReqParamBean filterReqParamBean4 = this.mReqParams;
        filterReqParamBean4.itemId = str3;
        filterReqParamBean4.comboDispatchId = str;
        filterReqParamBean4.skipOverrideKeyList = PresetBean.SKIP_OVER_RIDE_KEYS;
    }

    public void dispatchFastListChangedIfNeed() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1249259195")) {
            ipChange.ipc$dispatch("1249259195", new Object[]{this});
        } else if (bb2.d(this.mFastFilterList)) {
        } else {
            List<FilterBean> cloneFastListByCurSelection = cloneFastListByCurSelection(this.mFastFilterList);
            this.mFastFilterList = cloneFastListByCurSelection;
            this.mListener.onFastFilterChanged(cloneFastListByCurSelection);
        }
    }

    public void dispatchHorCalendarChangedIfNeed(boolean z) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-46729456")) {
            ipChange.ipc$dispatch("-46729456", new Object[]{this, Boolean.valueOf(z)});
        } else if (CalendarStyle.LINE == this.mCalendarStyle) {
            this.mListener.onHorCalendarChanged(this.mTotalDayList, this.mSelectDayList, z);
        }
    }

    public void dispatchReqParamsChangedIfNeed() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1616927585")) {
            ipChange.ipc$dispatch("-1616927585", new Object[]{this});
            return;
        }
        createRequestParams();
        FilterParamChangeListener filterParamChangeListener = this.mParamChangeListener;
        if (filterParamChangeListener != null) {
            filterParamChangeListener.notifyFilterParamChanged();
        }
    }

    @Override // cn.damai.projectfiltercopy.filterbtn.BtnInfoProvider
    public qd getBtnText(Type type) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1997763993")) {
            return (qd) ipChange.ipc$dispatch("-1997763993", new Object[]{this, type});
        }
        int i = C1537a.a[type.ordinal()];
        if (i != 1) {
            if (i != 2) {
                if (i != 3) {
                    if (i != 4) {
                        if (i != 5) {
                            return qd.d();
                        }
                        return qd.a(this.mCatAssembler.getBtnText());
                    }
                    return qd.e(this.mFilterMap, this.mGroupKeyInFilterBtn);
                }
                return qd.b(this.mCityBean);
            }
            return qd.c(this.mCalendarBean);
        }
        return qd.h(this.mSortBean, this.mBeanList);
    }

    public CalendarBean getCalendarBean() {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "765061217") ? (CalendarBean) ipChange.ipc$dispatch("765061217", new Object[]{this}) : this.mCalendarBean;
    }

    public CalendarInitBean getCalendarInit() {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "-728495550") ? (CalendarInitBean) ipChange.ipc$dispatch("-728495550", new Object[]{this}) : new CalendarInitBean(this.mYearBeanList, this.mCalendarEntityList);
    }

    public FilterItemBean getFilterBean() {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "74135295") ? (FilterItemBean) ipChange.ipc$dispatch("74135295", new Object[]{this}) : this.mFilterBean;
    }

    @Override // cn.damai.projectfiltercopy.filterbtn.BtnInfoProvider
    public float getLeftBtnTotalWidthWeight() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1580706637")) {
            return ((Float) ipChange.ipc$dispatch("-1580706637", new Object[]{this})).floatValue();
        }
        float f = 0.0f;
        for (Type type : this.supportBtnType) {
            if (Type.SORT != type && Type.DATE_HOR_CALENDAR != type) {
                f += type.widthWeight;
            }
        }
        return f;
    }

    public List<SortBean> getSortList() {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "118531883") ? (List) ipChange.ipc$dispatch("118531883", new Object[]{this}) : this.mBeanList;
    }

    public void init(FilterResponse filterResponse, @NonNull PresetBean presetBean, CalendarStyle calendarStyle) {
        FilterPrimaryBean filterPrimaryBean;
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-44860163")) {
            ipChange.ipc$dispatch("-44860163", new Object[]{this, filterResponse, presetBean, calendarStyle});
            return;
        }
        this.mCalendarStyle = calendarStyle;
        this.supportBtnType.clear();
        if (filterResponse == null || (filterPrimaryBean = filterResponse.primary) == null) {
            return;
        }
        this.mPresetBean = presetBean;
        List<CategoryLevelOne> list = filterPrimaryBean.guideCategory;
        this.mNewCategoryList = list;
        if (!bb2.d(list)) {
            this.supportBtnType.add(Type.NEW_CATEGORY);
        }
        this.mCatAssembler.init(this.mNewCategoryList, this.mPresetBean);
        this.mSelectedNewCategoryList = this.mCatAssembler.getSelect4Request();
        CalendarBean obtainPresetDate = presetBean.obtainPresetDate();
        this.mCalendarBean = obtainPresetDate;
        if (obtainPresetDate == null) {
            this.mCalendarBean = CalendarBean.defaultAllTime();
        }
        this.mYearBeanList = filterPrimaryBean.calendar;
        if (CalendarStyle.BTN == this.mCalendarStyle) {
            this.supportBtnType.add(Type.DATE);
        } else {
            this.supportBtnType.add(Type.DATE_HOR_CALENDAR);
        }
        List<Day> a = of.a(this.mCalendarEntityList, this.mYearBeanList);
        Day t = of.t();
        if (!bb2.d(a)) {
            int indexOf = a.indexOf(t);
            if (indexOf >= 0) {
                a.get(indexOf).isToday = true;
                this.mTotalDayList = a.subList(indexOf, a.size());
            } else {
                this.mTotalDayList = a;
            }
        }
        this.mSelectDayList = of.j(this.mCalendarBean);
        if (filterPrimaryBean.city) {
            this.supportBtnType.add(Type.CITY);
        }
        this.mCityBean = CityBean.defaultCity();
        List<SortBean> list2 = filterPrimaryBean.sortType;
        this.mBeanList = list2;
        if (!bb2.d(list2)) {
            SortBean obtainPresetSort = presetBean.obtainPresetSort(this.mBeanList);
            this.mSortBean = obtainPresetSort;
            if (obtainPresetSort == null) {
                this.mSortBean = this.mBeanList.get(0);
            }
            this.supportBtnType.add(Type.SORT);
        }
        List<FilterGroupBean> list3 = filterPrimaryBean.selection;
        if (!bb2.d(list3)) {
            this.supportBtnType.add(Type.FILTER);
            FilterGroupBean.itemBindOption(list3);
            FilterItemBean filterItemBean = new FilterItemBean();
            this.mFilterBean = filterItemBean;
            filterItemBean.selection = list3;
            for (FilterGroupBean filterGroupBean : list3) {
                this.mGroupKeyInFilterBtn.add(filterGroupBean.option);
                this.mGroupKeyGroupMap.put(filterGroupBean.option, filterGroupBean);
            }
        }
        FilterGroupBean.itemBindOption(filterResponse.secondary);
        List<FilterBean> extractFast = FilterGroupBean.extractFast(filterResponse.secondary);
        this.mFastGroupIdSelected = presetBean.obtainPresetGroupId(extractFast);
        this.mFastFilterList = cloneFastListByCurSelection(extractFast);
        createRequestParams();
    }

    @Override // cn.damai.projectfiltercopy.listener.RequestParamProvider
    @NonNull
    public FilterReqParamBean obtainRequestParam() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-318039398")) {
            return (FilterReqParamBean) ipChange.ipc$dispatch("-318039398", new Object[]{this});
        }
        if (this.mReqParams == null) {
            createRequestParams();
        }
        return this.mReqParams;
    }

    public void onFastCall(FilterBean filterBean) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-293790513")) {
            ipChange.ipc$dispatch("-293790513", new Object[]{this, filterBean});
            return;
        }
        if (TextUtils.equals("dateType", filterBean.option)) {
            if (filterBean.isSelected) {
                this.mCalendarBean = CalendarBean.defaultAllTime();
            } else {
                this.mCalendarBean = CalendarBean.transfer2ConstantCalendarBeanIfCann(new CalendarBean(filterBean.name, filterBean.value));
            }
            this.mSelectDayList = of.j(this.mCalendarBean);
            dispatchHorCalendarChangedIfNeed(true);
            this.mListener.onMainFilterChanged(Type.DATE);
        } else if (this.mGroupKeyInFilterBtn.contains(filterBean.option)) {
            FilterGroupBean filterGroupBean = this.mGroupKeyGroupMap.get(filterBean.option);
            if (filterGroupBean != null) {
                jh0.e(filterBean, this.mFilterMap, filterGroupBean.isSingleSelected);
            }
            this.mListener.onMainFilterChanged(Type.FILTER);
        } else if (TextUtils.equals("groupId", filterBean.option)) {
            if (filterBean.equals(this.mFastGroupIdSelected)) {
                this.mFastGroupIdSelected = null;
            } else {
                this.mFastGroupIdSelected = filterBean;
            }
        }
        dispatchFastListChangedIfNeed();
        dispatchReqParamsChangedIfNeed();
    }

    @Override // cn.damai.projectfiltercopy.FloatListener
    public void onFloatCall(Type type, FilterData filterData) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-487086273")) {
            ipChange.ipc$dispatch("-487086273", new Object[]{this, type, filterData});
            return;
        }
        int i = C1537a.a[type.ordinal()];
        if (i == 1) {
            this.mSortBean = filterData.mSortBean;
        } else if (i == 2) {
            CalendarBean calendarBean = filterData.calendarBean;
            this.mCalendarBean = calendarBean;
            this.mSelectDayList = of.j(calendarBean);
            dispatchHorCalendarChangedIfNeed(filterData.isHorCalendarShouldScroll2AdjustPos);
            dispatchFastListChangedIfNeed();
        } else if (i == 3) {
            this.mCityBean = filterData.mCityBean;
        } else if (i == 4) {
            this.mFilterMap.clear();
            if (!bb2.e(filterData.mFilterMap)) {
                this.mFilterMap.putAll(filterData.mFilterMap);
            }
            dispatchFastListChangedIfNeed();
        } else if (i == 5) {
            this.mSelectedNewCategoryList = filterData.mNewCategorySelected;
        }
        dispatchReqParamsChangedIfNeed();
    }

    public void onHorCalendarCall(Day day, List<? extends Day> list, HorDateClickResultListener horDateClickResultListener) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "2110298132")) {
            ipChange.ipc$dispatch("2110298132", new Object[]{this, day, list, horDateClickResultListener});
            return;
        }
        CalendarBean calendarBean = new CalendarBean();
        if (bb2.a(list) == 1) {
            Day day2 = list.get(0);
            if (day.equals(day2)) {
                return;
            }
            if (day.isAfterDay(day2)) {
                day2 = day;
                day = day2;
            }
            calendarBean.dateType = String.valueOf(5);
            calendarBean.startDate = day.toSimpleDateString();
            calendarBean.endDate = day2.toSimpleDateString();
            calendarBean.name = day.toSimpleShortDateString() + "-" + day2.toSimpleShortDateString();
        } else {
            calendarBean.dateType = String.valueOf(5);
            calendarBean.startDate = day.toSimpleDateString();
            calendarBean.endDate = day.toSimpleDateString();
            calendarBean.name = day.toSimpleShortDateString();
        }
        FilterData filterData = new FilterData();
        filterData.isHorCalendarShouldScroll2AdjustPos = false;
        filterData.calendarBean = calendarBean;
        if (horDateClickResultListener != null) {
            horDateClickResultListener.onProcessResult(calendarBean);
        }
        Type type = Type.DATE;
        onFloatCall(type, filterData);
        this.mListener.onMainFilterChanged(type);
    }

    @Override // cn.damai.projectfiltercopy.listener.RequestParamProvider
    public void setParamChangeListener(FilterParamChangeListener filterParamChangeListener) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "173951602")) {
            ipChange.ipc$dispatch("173951602", new Object[]{this, filterParamChangeListener});
        } else {
            this.mParamChangeListener = filterParamChangeListener;
        }
    }
}
