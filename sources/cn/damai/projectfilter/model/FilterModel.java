package cn.damai.projectfilter.model;

import android.text.TextUtils;
import androidx.annotation.NonNull;
import cn.damai.commonbusiness.calendar.bean.CalendarBean;
import cn.damai.commonbusiness.calendar.bean.CalendarYearBean;
import cn.damai.projectfilter.FloatListener;
import cn.damai.projectfilter.bean.CategoryBean;
import cn.damai.projectfilter.bean.CategoryLevelOne;
import cn.damai.projectfilter.bean.CategoryLevelTwo;
import cn.damai.projectfilter.bean.CityBean;
import cn.damai.projectfilter.bean.FilterBean;
import cn.damai.projectfilter.bean.FilterData;
import cn.damai.projectfilter.bean.FilterGroupBean;
import cn.damai.projectfilter.bean.FilterItemBean;
import cn.damai.projectfilter.bean.FilterPrimaryBean;
import cn.damai.projectfilter.bean.FilterReqParamBean;
import cn.damai.projectfilter.bean.FilterResponse;
import cn.damai.projectfilter.bean.PresetBean;
import cn.damai.projectfilter.bean.SortBean;
import cn.damai.projectfilter.bean.Type;
import cn.damai.projectfilter.filterbtn.BtnInfoProvider;
import cn.damai.projectfilter.listener.FilterParamChangeListener;
import cn.damai.projectfilter.listener.RequestParamProvider;
import cn.damai.projectfilter.listener.UiBizListener;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import tb.cb2;
import tb.kh0;
import tb.rd;

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
    @Deprecated
    public List<CategoryBean> mSelectedCategoryList;
    public List<CategoryLevelOne> mSelectedNewCategoryList;
    public SortBean mSortBean;
    private List<CalendarYearBean> mYearBeanList;
    public final List<String> mGroupKeyInFilterBtn = new ArrayList();
    public final HashMap<String, FilterGroupBean> mGroupKeyGroupMap = new HashMap<>();
    public final List<Type> supportType = new ArrayList();
    public final HashMap<String, List<FilterBean>> mFilterMap = new HashMap<>();
    public final CategoryDataAssembler mCatAssembler = new CategoryDataAssembler();

    /* compiled from: Taobao */
    /* renamed from: cn.damai.projectfilter.model.FilterModel$a */
    /* loaded from: classes15.dex */
    static /* synthetic */ class C1518a {
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
                a[Type.CATEGORY.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                a[Type.FILTER.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                a[Type.NEW_CATEGORY.ordinal()] = 6;
            } catch (NoSuchFieldError unused6) {
            }
        }
    }

    public FilterModel(UiBizListener uiBizListener) {
        this.mListener = uiBizListener;
    }

    private List<FilterBean> cloneFastListByCurSelection(List<FilterBean> list) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-775360851")) {
            return (List) ipChange.ipc$dispatch("-775360851", new Object[]{this, list});
        }
        if (cb2.d(list)) {
            return null;
        }
        List<FilterBean> a = kh0.a(list);
        kh0.b(a, this.mCalendarBean);
        kh0.c(a, this.mFilterMap, this.mGroupKeyInFilterBtn);
        kh0.d(a, this.mFastGroupIdSelected);
        return a;
    }

    private void createRequestParams() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1127889482")) {
            ipChange.ipc$dispatch("1127889482", new Object[]{this});
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
        String str = this.mPresetBean.categoryId;
        if (!TextUtils.isEmpty(str)) {
            this.mReqParams.categoryIds.add(str);
        }
        if (this.supportType.contains(Type.NEW_CATEGORY)) {
            if (cb2.g(this.mSelectedNewCategoryList)) {
                StringBuilder sb = new StringBuilder();
                StringBuilder sb2 = new StringBuilder();
                for (CategoryLevelOne categoryLevelOne : this.mSelectedNewCategoryList) {
                    List<CategoryLevelTwo> list = categoryLevelOne.lineItemList;
                    if (cb2.g(list)) {
                        if (cb2.a(list) == 1 && list.get(0).isAll()) {
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
        this.mReqParams.skipOverrideKeyList = PresetBean.SKIP_OVER_RIDE_KEYS;
    }

    public void dispatchFastListChangedIfNeed() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1965572592")) {
            ipChange.ipc$dispatch("-1965572592", new Object[]{this});
        } else if (cb2.d(this.mFastFilterList)) {
        } else {
            List<FilterBean> cloneFastListByCurSelection = cloneFastListByCurSelection(this.mFastFilterList);
            this.mFastFilterList = cloneFastListByCurSelection;
            this.mListener.onFastFilterChanged(cloneFastListByCurSelection);
        }
    }

    public void dispatchReqParamsChangedIfNeed() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1802502122")) {
            ipChange.ipc$dispatch("1802502122", new Object[]{this});
            return;
        }
        createRequestParams();
        FilterParamChangeListener filterParamChangeListener = this.mParamChangeListener;
        if (filterParamChangeListener != null) {
            filterParamChangeListener.notifyFilterParamChanged();
        }
    }

    @Override // cn.damai.projectfilter.filterbtn.BtnInfoProvider
    public rd getBtnText(Type type) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1485732380")) {
            return (rd) ipChange.ipc$dispatch("1485732380", new Object[]{this, type});
        }
        switch (C1518a.a[type.ordinal()]) {
            case 1:
                return rd.i(this.mSortBean, this.mBeanList);
            case 2:
                return rd.d(this.mCalendarBean);
            case 3:
                return rd.c(this.mCityBean);
            case 4:
                return rd.a(this.mSelectedCategoryList);
            case 5:
                return rd.f(this.mFilterMap, this.mGroupKeyInFilterBtn);
            case 6:
                return rd.b(this.mCatAssembler.getBtnText());
            default:
                return rd.e();
        }
    }

    public CalendarBean getCalendarBean() {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "-1871141823") ? (CalendarBean) ipChange.ipc$dispatch("-1871141823", new Object[]{this}) : this.mCalendarBean;
    }

    public FilterItemBean getFilterBean() {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "266772703") ? (FilterItemBean) ipChange.ipc$dispatch("266772703", new Object[]{this}) : this.mFilterBean;
    }

    @Override // cn.damai.projectfilter.filterbtn.BtnInfoProvider
    public int getLeftBtnCount() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-965575802")) {
            return ((Integer) ipChange.ipc$dispatch("-965575802", new Object[]{this})).intValue();
        }
        if (this.supportType.contains(Type.FILTER)) {
            return this.supportType.size() - 1;
        }
        return this.supportType.size();
    }

    public List<SortBean> getSortList() {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "1582325750") ? (List) ipChange.ipc$dispatch("1582325750", new Object[]{this}) : this.mBeanList;
    }

    public List<CalendarYearBean> getYearList() {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "-284712619") ? (List) ipChange.ipc$dispatch("-284712619", new Object[]{this}) : this.mYearBeanList;
    }

    public void init(FilterResponse filterResponse, @NonNull PresetBean presetBean) {
        FilterPrimaryBean filterPrimaryBean;
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1494748831")) {
            ipChange.ipc$dispatch("-1494748831", new Object[]{this, filterResponse, presetBean});
            return;
        }
        this.supportType.clear();
        if (filterResponse == null || (filterPrimaryBean = filterResponse.primary) == null) {
            return;
        }
        this.mPresetBean = presetBean;
        List<CategoryLevelOne> list = filterPrimaryBean.guideCategory;
        this.mNewCategoryList = list;
        if (!cb2.d(list)) {
            this.supportType.add(Type.NEW_CATEGORY);
        }
        this.mCatAssembler.init(this.mNewCategoryList, this.mPresetBean);
        this.mSelectedNewCategoryList = this.mCatAssembler.getSelect4Request();
        this.supportType.add(Type.DATE);
        CalendarBean obtainPresetDate = presetBean.obtainPresetDate();
        this.mCalendarBean = obtainPresetDate;
        if (obtainPresetDate == null) {
            this.mCalendarBean = CalendarBean.defaultAllTime();
        }
        this.mYearBeanList = filterPrimaryBean.calendar;
        this.mSelectedCategoryList = null;
        if (filterPrimaryBean.city) {
            this.supportType.add(Type.CITY);
        }
        this.mCityBean = CityBean.defaultCity();
        List<SortBean> list2 = filterPrimaryBean.sortType;
        this.mBeanList = list2;
        if (!cb2.d(list2)) {
            SortBean obtainPresetSort = presetBean.obtainPresetSort(this.mBeanList);
            this.mSortBean = obtainPresetSort;
            if (obtainPresetSort == null) {
                this.mSortBean = this.mBeanList.get(0);
            }
            this.supportType.add(Type.SORT);
        }
        List<FilterGroupBean> list3 = filterPrimaryBean.selection;
        if (!cb2.d(list3)) {
            this.supportType.add(Type.FILTER);
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

    @Override // cn.damai.projectfilter.listener.RequestParamProvider
    @NonNull
    public FilterReqParamBean obtainRequestParam() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1427490108")) {
            return (FilterReqParamBean) ipChange.ipc$dispatch("-1427490108", new Object[]{this});
        }
        if (this.mReqParams == null) {
            createRequestParams();
        }
        return this.mReqParams;
    }

    public void onFastCall(FilterBean filterBean) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1403194321")) {
            ipChange.ipc$dispatch("-1403194321", new Object[]{this, filterBean});
            return;
        }
        if (TextUtils.equals("dateType", filterBean.option)) {
            if (filterBean.isSelected) {
                this.mCalendarBean = CalendarBean.defaultAllTime();
            } else {
                this.mCalendarBean = CalendarBean.transfer2ConstantCalendarBeanIfCann(new CalendarBean(filterBean.name, filterBean.value));
            }
            this.mListener.onMainFilterChanged(Type.DATE);
        } else if (this.mGroupKeyInFilterBtn.contains(filterBean.option)) {
            FilterGroupBean filterGroupBean = this.mGroupKeyGroupMap.get(filterBean.option);
            if (filterGroupBean != null) {
                kh0.g(filterBean, this.mFilterMap, filterGroupBean.isSingleSelected);
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

    @Override // cn.damai.projectfilter.FloatListener
    public void onFloatCall(Type type, FilterData filterData) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1602762114")) {
            ipChange.ipc$dispatch("-1602762114", new Object[]{this, type, filterData});
            return;
        }
        switch (C1518a.a[type.ordinal()]) {
            case 1:
                this.mSortBean = filterData.mSortBean;
                break;
            case 2:
                this.mCalendarBean = filterData.calendarBean;
                dispatchFastListChangedIfNeed();
                break;
            case 3:
                this.mCityBean = filterData.mCityBean;
                break;
            case 4:
                this.mSelectedCategoryList = filterData.selected;
                break;
            case 5:
                this.mFilterMap.clear();
                if (!cb2.f(filterData.mFilterMap)) {
                    this.mFilterMap.putAll(filterData.mFilterMap);
                }
                dispatchFastListChangedIfNeed();
                break;
            case 6:
                this.mSelectedNewCategoryList = filterData.mNewCategorySelected;
                break;
        }
        dispatchReqParamsChangedIfNeed();
    }

    @Override // cn.damai.projectfilter.listener.RequestParamProvider
    public void setParamChangeListener(FilterParamChangeListener filterParamChangeListener) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-541263214")) {
            ipChange.ipc$dispatch("-541263214", new Object[]{this, filterParamChangeListener});
        } else {
            this.mParamChangeListener = filterParamChangeListener;
        }
    }
}
