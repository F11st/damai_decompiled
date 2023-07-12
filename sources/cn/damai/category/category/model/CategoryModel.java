package cn.damai.category.category.model;

import android.content.Context;
import androidx.lifecycle.MutableLiveData;
import cn.damai.category.category.bean.CategoryBrandBean;
import cn.damai.category.category.bean.CategoryNewProjectBean;
import cn.damai.category.category.bean.CategoryNewTitleListBean;
import cn.damai.category.category.bean.CategoryStarBean;
import cn.damai.category.category.bean.StarListBean;
import cn.damai.category.category.repository.CategoryRepository;
import cn.damai.category.category.request.BrandRequest;
import cn.damai.category.category.request.FollowRequest;
import cn.damai.category.category.request.StarListRequest;
import cn.damai.category.category.request.StarRequest;
import cn.damai.category.common.bean.CalendarBean;
import cn.damai.category.common.bean.CategoryPerformBean;
import cn.damai.category.common.request.CategoryPerformRequest;
import cn.damai.category.common.request.CategoryRequest;
import cn.damai.common.net.mtop.netfit.DMMtopRequestListener;
import cn.damai.commonbusiness.city.net.CityListResponse;
import cn.damai.commonbusiness.search.bean.FollowDataBean;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;

/* compiled from: Taobao */
/* loaded from: classes.dex */
public class CategoryModel {
    private static transient /* synthetic */ IpChange $ipChange;
    private Context mContext;
    private MutableLiveData<CategoryNewTitleListBean> mCategoryTitleBean = new MutableLiveData<>();
    private MutableLiveData<CalendarBean> mCalendarBean = new MutableLiveData<>();
    private MutableLiveData<CityListResponse> mCityBean = new MutableLiveData<>();
    private MutableLiveData<CategoryNewProjectBean> mCalendarProjectBean = new MutableLiveData<>();
    private MutableLiveData<CategoryPerformBean> mCategoryPerformBean = new MutableLiveData<>();
    private MutableLiveData<CategoryStarBean> mCategoryStarBean = new MutableLiveData<>();
    private MutableLiveData<FollowDataBean> mFollowDataBean = new MutableLiveData<>();
    private MutableLiveData<CategoryBrandBean> mCategoryBrandBean = new MutableLiveData<>();
    private MutableLiveData<StarListBean> mStarListBean = new MutableLiveData<>();
    private CategoryRepository mRepository = new CategoryRepository();

    public CategoryModel(Context context) {
        this.mContext = context;
    }

    public void calendarRequest(String str, String str2, String str3) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1015630072")) {
            ipChange.ipc$dispatch("1015630072", new Object[]{this, str, str2, str3});
        } else {
            this.mRepository.calendarRequest(str, str2, str3, new DMMtopRequestListener<CalendarBean>(CalendarBean.class) { // from class: cn.damai.category.category.model.CategoryModel.2
                private static transient /* synthetic */ IpChange $ipChange;

                @Override // cn.damai.common.net.mtop.netfit.DMMtopRequestListener
                public void onFail(String str4, String str5) {
                    IpChange ipChange2 = $ipChange;
                    if (AndroidInstantRuntime.support(ipChange2, "-197068572")) {
                        ipChange2.ipc$dispatch("-197068572", new Object[]{this, str4, str5});
                    }
                }

                @Override // cn.damai.common.net.mtop.netfit.DMMtopRequestListener
                public void onSuccess(CalendarBean calendarBean) {
                    IpChange ipChange2 = $ipChange;
                    if (AndroidInstantRuntime.support(ipChange2, "178314569")) {
                        ipChange2.ipc$dispatch("178314569", new Object[]{this, calendarBean});
                    } else {
                        CategoryModel.this.mCalendarBean.setValue(calendarBean);
                    }
                }
            });
        }
    }

    public void categoryNewTitleRequest() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1563637998")) {
            ipChange.ipc$dispatch("-1563637998", new Object[]{this});
        } else {
            this.mRepository.getCategoryNewTitle(new DMMtopRequestListener<CategoryNewTitleListBean>(CategoryNewTitleListBean.class) { // from class: cn.damai.category.category.model.CategoryModel.1
                private static transient /* synthetic */ IpChange $ipChange;

                @Override // cn.damai.common.net.mtop.netfit.DMMtopRequestListener
                public void onFail(String str, String str2) {
                    IpChange ipChange2 = $ipChange;
                    if (AndroidInstantRuntime.support(ipChange2, "-189309213")) {
                        ipChange2.ipc$dispatch("-189309213", new Object[]{this, str, str2});
                    } else {
                        CategoryModel.this.mCategoryTitleBean.setValue(null);
                    }
                }

                @Override // cn.damai.common.net.mtop.netfit.DMMtopRequestListener
                public void onSuccess(CategoryNewTitleListBean categoryNewTitleListBean) {
                    IpChange ipChange2 = $ipChange;
                    if (AndroidInstantRuntime.support(ipChange2, "1310041985")) {
                        ipChange2.ipc$dispatch("1310041985", new Object[]{this, categoryNewTitleListBean});
                    } else {
                        CategoryModel.this.mCategoryTitleBean.setValue(categoryNewTitleListBean);
                    }
                }
            });
        }
    }

    public void followRequest(String str, String str2, String str3) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-2112461077")) {
            ipChange.ipc$dispatch("-2112461077", new Object[]{this, str, str2, str3});
            return;
        }
        FollowRequest followRequest = new FollowRequest();
        followRequest.operateType = str;
        followRequest.targetId = str2;
        followRequest.targetType = str3;
        this.mRepository.followRequest(followRequest, new DMMtopRequestListener<FollowDataBean>(FollowDataBean.class) { // from class: cn.damai.category.category.model.CategoryModel.7
            private static transient /* synthetic */ IpChange $ipChange;

            @Override // cn.damai.common.net.mtop.netfit.DMMtopRequestListener
            public void onFail(String str4, String str5) {
                IpChange ipChange2 = $ipChange;
                if (AndroidInstantRuntime.support(ipChange2, "-235865367")) {
                    ipChange2.ipc$dispatch("-235865367", new Object[]{this, str4, str5});
                } else {
                    CategoryModel.this.mFollowDataBean.setValue(null);
                }
            }

            @Override // cn.damai.common.net.mtop.netfit.DMMtopRequestListener
            public void onSuccess(FollowDataBean followDataBean) {
                IpChange ipChange2 = $ipChange;
                if (AndroidInstantRuntime.support(ipChange2, "-339923625")) {
                    ipChange2.ipc$dispatch("-339923625", new Object[]{this, followDataBean});
                } else {
                    CategoryModel.this.mFollowDataBean.setValue(followDataBean);
                }
            }
        });
    }

    public void getBrandRequest(BrandRequest brandRequest) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1136717809")) {
            ipChange.ipc$dispatch("1136717809", new Object[]{this, brandRequest});
        } else {
            this.mRepository.getBrandRequest(brandRequest, new DMMtopRequestListener<CategoryBrandBean>(CategoryBrandBean.class) { // from class: cn.damai.category.category.model.CategoryModel.8
                private static transient /* synthetic */ IpChange $ipChange;

                @Override // cn.damai.common.net.mtop.netfit.DMMtopRequestListener
                public void onFail(String str, String str2) {
                    IpChange ipChange2 = $ipChange;
                    if (AndroidInstantRuntime.support(ipChange2, "-243624726")) {
                        ipChange2.ipc$dispatch("-243624726", new Object[]{this, str, str2});
                    } else {
                        CategoryModel.this.mCategoryBrandBean.setValue(null);
                    }
                }

                @Override // cn.damai.common.net.mtop.netfit.DMMtopRequestListener
                public void onSuccess(CategoryBrandBean categoryBrandBean) {
                    IpChange ipChange2 = $ipChange;
                    if (AndroidInstantRuntime.support(ipChange2, "-961118695")) {
                        ipChange2.ipc$dispatch("-961118695", new Object[]{this, categoryBrandBean});
                    } else {
                        CategoryModel.this.mCategoryBrandBean.setValue(categoryBrandBean);
                    }
                }
            });
        }
    }

    public MutableLiveData<CalendarBean> getCalendarBean() {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "-1746999283") ? (MutableLiveData) ipChange.ipc$dispatch("-1746999283", new Object[]{this}) : this.mCalendarBean;
    }

    public MutableLiveData<CategoryNewProjectBean> getCalendarProjectBean() {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "-881746294") ? (MutableLiveData) ipChange.ipc$dispatch("-881746294", new Object[]{this}) : this.mCalendarProjectBean;
    }

    public MutableLiveData<CategoryBrandBean> getCategoryBrandBean() {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "-2001048520") ? (MutableLiveData) ipChange.ipc$dispatch("-2001048520", new Object[]{this}) : this.mCategoryBrandBean;
    }

    public MutableLiveData<CategoryPerformBean> getCategoryPerformBean() {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "105273106") ? (MutableLiveData) ipChange.ipc$dispatch("105273106", new Object[]{this}) : this.mCategoryPerformBean;
    }

    public MutableLiveData<CategoryStarBean> getCategoryStarBean() {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "-730802497") ? (MutableLiveData) ipChange.ipc$dispatch("-730802497", new Object[]{this}) : this.mCategoryStarBean;
    }

    public void getCategorySubRequest(CategoryPerformRequest categoryPerformRequest) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1815729121")) {
            ipChange.ipc$dispatch("-1815729121", new Object[]{this, categoryPerformRequest});
        } else {
            this.mRepository.getCategorySubRequest(categoryPerformRequest, new DMMtopRequestListener<CategoryPerformBean>(CategoryPerformBean.class) { // from class: cn.damai.category.category.model.CategoryModel.5
                private static transient /* synthetic */ IpChange $ipChange;

                @Override // cn.damai.common.net.mtop.netfit.DMMtopRequestListener
                public void onFail(String str, String str2) {
                    IpChange ipChange2 = $ipChange;
                    if (AndroidInstantRuntime.support(ipChange2, "-220346649")) {
                        ipChange2.ipc$dispatch("-220346649", new Object[]{this, str, str2});
                    } else {
                        CategoryModel.this.mCategoryPerformBean.setValue(null);
                    }
                }

                @Override // cn.damai.common.net.mtop.netfit.DMMtopRequestListener
                public void onSuccess(CategoryPerformBean categoryPerformBean) {
                    IpChange ipChange2 = $ipChange;
                    if (AndroidInstantRuntime.support(ipChange2, "-497806807")) {
                        ipChange2.ipc$dispatch("-497806807", new Object[]{this, categoryPerformBean});
                    } else {
                        CategoryModel.this.mCategoryPerformBean.setValue(categoryPerformBean);
                    }
                }
            });
        }
    }

    public MutableLiveData<CategoryNewTitleListBean> getCategoryTitleBean() {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "527707593") ? (MutableLiveData) ipChange.ipc$dispatch("527707593", new Object[]{this}) : this.mCategoryTitleBean;
    }

    public MutableLiveData<CityListResponse> getCityBeanBean() {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "-1256557494") ? (MutableLiveData) ipChange.ipc$dispatch("-1256557494", new Object[]{this}) : this.mCityBean;
    }

    public void getCityRequest() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1372646831")) {
            ipChange.ipc$dispatch("-1372646831", new Object[]{this});
        } else {
            this.mRepository.cityRequest(new DMMtopRequestListener<CityListResponse>(CityListResponse.class) { // from class: cn.damai.category.category.model.CategoryModel.3
                private static transient /* synthetic */ IpChange $ipChange;

                @Override // cn.damai.common.net.mtop.netfit.DMMtopRequestListener
                public void onFail(String str, String str2) {
                    IpChange ipChange2 = $ipChange;
                    if (AndroidInstantRuntime.support(ipChange2, "-204827931")) {
                        ipChange2.ipc$dispatch("-204827931", new Object[]{this, str, str2});
                    }
                }

                @Override // cn.damai.common.net.mtop.netfit.DMMtopRequestListener
                public void onSuccess(CityListResponse cityListResponse) {
                    IpChange ipChange2 = $ipChange;
                    if (AndroidInstantRuntime.support(ipChange2, "-1924585262")) {
                        ipChange2.ipc$dispatch("-1924585262", new Object[]{this, cityListResponse});
                    } else {
                        CategoryModel.this.mCityBean.setValue(cityListResponse);
                    }
                }
            });
        }
    }

    public MutableLiveData<FollowDataBean> getFollowDataBean() {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "-687190134") ? (MutableLiveData) ipChange.ipc$dispatch("-687190134", new Object[]{this}) : this.mFollowDataBean;
    }

    public void getPerformListRequest(CategoryRequest categoryRequest) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1055716145")) {
            ipChange.ipc$dispatch("1055716145", new Object[]{this, categoryRequest});
        } else {
            this.mRepository.getPerfromListRequest(categoryRequest, new DMMtopRequestListener<CategoryNewProjectBean>(CategoryNewProjectBean.class) { // from class: cn.damai.category.category.model.CategoryModel.4
                private static transient /* synthetic */ IpChange $ipChange;

                @Override // cn.damai.common.net.mtop.netfit.DMMtopRequestListener
                public void onFail(String str, String str2) {
                    IpChange ipChange2 = $ipChange;
                    if (AndroidInstantRuntime.support(ipChange2, "-212587290")) {
                        ipChange2.ipc$dispatch("-212587290", new Object[]{this, str, str2});
                    } else {
                        CategoryModel.this.mCalendarProjectBean.setValue(null);
                    }
                }

                @Override // cn.damai.common.net.mtop.netfit.DMMtopRequestListener
                public void onSuccess(CategoryNewProjectBean categoryNewProjectBean) {
                    IpChange ipChange2 = $ipChange;
                    if (AndroidInstantRuntime.support(ipChange2, "-563844997")) {
                        ipChange2.ipc$dispatch("-563844997", new Object[]{this, categoryNewProjectBean});
                    } else {
                        CategoryModel.this.mCalendarProjectBean.setValue(categoryNewProjectBean);
                    }
                }
            });
        }
    }

    public MutableLiveData<StarListBean> getStarListBean() {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "127137887") ? (MutableLiveData) ipChange.ipc$dispatch("127137887", new Object[]{this}) : this.mStarListBean;
    }

    public void getStarListRequest(StarListRequest starListRequest) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "99836929")) {
            ipChange.ipc$dispatch("99836929", new Object[]{this, starListRequest});
        } else {
            this.mRepository.getStarListRequest(starListRequest, new DMMtopRequestListener<StarListBean>(StarListBean.class) { // from class: cn.damai.category.category.model.CategoryModel.9
                private static transient /* synthetic */ IpChange $ipChange;

                @Override // cn.damai.common.net.mtop.netfit.DMMtopRequestListener
                public void onFail(String str, String str2) {
                    IpChange ipChange2 = $ipChange;
                    if (AndroidInstantRuntime.support(ipChange2, "-251384085")) {
                        ipChange2.ipc$dispatch("-251384085", new Object[]{this, str, str2});
                    } else {
                        CategoryModel.this.mStarListBean.setValue(null);
                    }
                }

                @Override // cn.damai.common.net.mtop.netfit.DMMtopRequestListener
                public void onSuccess(StarListBean starListBean) {
                    IpChange ipChange2 = $ipChange;
                    if (AndroidInstantRuntime.support(ipChange2, "-2037905443")) {
                        ipChange2.ipc$dispatch("-2037905443", new Object[]{this, starListBean});
                    } else {
                        CategoryModel.this.mStarListBean.setValue(starListBean);
                    }
                }
            });
        }
    }

    public void getStarRequest(StarRequest starRequest) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-266492027")) {
            ipChange.ipc$dispatch("-266492027", new Object[]{this, starRequest});
        } else {
            this.mRepository.getStarRequest(starRequest, new DMMtopRequestListener<CategoryStarBean>(CategoryStarBean.class) { // from class: cn.damai.category.category.model.CategoryModel.6
                private static transient /* synthetic */ IpChange $ipChange;

                @Override // cn.damai.common.net.mtop.netfit.DMMtopRequestListener
                public void onFail(String str, String str2) {
                    IpChange ipChange2 = $ipChange;
                    if (AndroidInstantRuntime.support(ipChange2, "-228106008")) {
                        ipChange2.ipc$dispatch("-228106008", new Object[]{this, str, str2});
                    } else {
                        CategoryModel.this.mCategoryStarBean.setValue(null);
                    }
                }

                @Override // cn.damai.common.net.mtop.netfit.DMMtopRequestListener
                public void onSuccess(CategoryStarBean categoryStarBean) {
                    IpChange ipChange2 = $ipChange;
                    if (AndroidInstantRuntime.support(ipChange2, "-213112160")) {
                        ipChange2.ipc$dispatch("-213112160", new Object[]{this, categoryStarBean});
                    } else {
                        CategoryModel.this.mCategoryStarBean.setValue(categoryStarBean);
                    }
                }
            });
        }
    }
}
