package cn.damai.category.category.repository;

import cn.damai.category.category.bean.CategoryBrandBean;
import cn.damai.category.category.bean.CategoryNewProjectBean;
import cn.damai.category.category.bean.CategoryNewTitleBean;
import cn.damai.category.category.bean.CategoryNewTitleListBean;
import cn.damai.category.category.bean.CategoryStarBean;
import cn.damai.category.category.bean.ConditionEntity;
import cn.damai.category.category.bean.StarListBean;
import cn.damai.category.category.request.BrandRequest;
import cn.damai.category.category.request.CategoryNewTypeRequest;
import cn.damai.category.category.request.FollowRequest;
import cn.damai.category.category.request.StarListRequest;
import cn.damai.category.category.request.StarRequest;
import cn.damai.category.common.bean.CalendarBean;
import cn.damai.category.common.bean.CategoryPerformBean;
import cn.damai.category.common.request.CategoryCalendarRequest;
import cn.damai.category.common.request.CategoryPerformRequest;
import cn.damai.category.common.request.CategoryRequest;
import cn.damai.common.net.mtop.netfit.DMMtopRequestListener;
import cn.damai.commonbusiness.city.net.CityListRequest;
import cn.damai.commonbusiness.city.net.CityListResponse;
import cn.damai.commonbusiness.search.Daojishi;
import cn.damai.commonbusiness.search.bean.FollowDataBean;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import java.io.Serializable;

/* compiled from: Taobao */
/* loaded from: classes.dex */
public class CategoryRepository implements Serializable {
    private static transient /* synthetic */ IpChange $ipChange = null;
    private static final long serialVersionUID = -7515839936326335569L;
    public String categoryId;
    public String categoryName;
    public boolean isSkip;
    public CategoryNewTitleBean showTitleBean;
    public CategoryNewTitleBean showTitleBean2;
    public int type;
    public ConditionEntity conditionEntity = new ConditionEntity();
    public boolean isShowJuli = false;
    public boolean isAizhe = true;
    public boolean isChangeCondition = false;
    public int tab = 0;
    public Daojishi daojishi = new Daojishi();
    public boolean isNeedShowClickUt = true;
    public boolean isNeedShowClickUt2 = true;
    public String mXiannvBdian = "xiannv_tab";
    public boolean isChediLikai = true;

    public void calendarRequest(String str, String str2, String str3, DMMtopRequestListener<CalendarBean> dMMtopRequestListener) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-790082578")) {
            ipChange.ipc$dispatch("-790082578", new Object[]{this, str, str2, str3, dMMtopRequestListener});
            return;
        }
        CategoryCalendarRequest categoryCalendarRequest = new CategoryCalendarRequest();
        categoryCalendarRequest.damaiID = str;
        categoryCalendarRequest.startDate = str2;
        categoryCalendarRequest.endDate = str3;
        categoryCalendarRequest.request(dMMtopRequestListener);
    }

    public void cityRequest(DMMtopRequestListener<CityListResponse> dMMtopRequestListener) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1143038337")) {
            ipChange.ipc$dispatch("-1143038337", new Object[]{this, dMMtopRequestListener});
        } else {
            new CityListRequest().request(dMMtopRequestListener);
        }
    }

    public void followRequest(FollowRequest followRequest, DMMtopRequestListener<FollowDataBean> dMMtopRequestListener) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1774549773")) {
            ipChange.ipc$dispatch("1774549773", new Object[]{this, followRequest, dMMtopRequestListener});
        } else {
            followRequest.request(dMMtopRequestListener);
        }
    }

    public void getBrandRequest(BrandRequest brandRequest, DMMtopRequestListener<CategoryBrandBean> dMMtopRequestListener) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-377113851")) {
            ipChange.ipc$dispatch("-377113851", new Object[]{this, brandRequest, dMMtopRequestListener});
        } else {
            brandRequest.request(dMMtopRequestListener);
        }
    }

    public void getCategoryNewTitle(DMMtopRequestListener<CategoryNewTitleListBean> dMMtopRequestListener) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "530675463")) {
            ipChange.ipc$dispatch("530675463", new Object[]{this, dMMtopRequestListener});
        } else {
            new CategoryNewTypeRequest().request(dMMtopRequestListener);
        }
    }

    public void getCategorySubRequest(CategoryPerformRequest categoryPerformRequest, DMMtopRequestListener<CategoryPerformBean> dMMtopRequestListener) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1228869353")) {
            ipChange.ipc$dispatch("-1228869353", new Object[]{this, categoryPerformRequest, dMMtopRequestListener});
        } else {
            categoryPerformRequest.request(dMMtopRequestListener);
        }
    }

    public void getPerfromListRequest(CategoryRequest categoryRequest, DMMtopRequestListener<CategoryNewProjectBean> dMMtopRequestListener) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1427977711")) {
            ipChange.ipc$dispatch("1427977711", new Object[]{this, categoryRequest, dMMtopRequestListener});
            return;
        }
        categoryRequest.apiVersion = "1.2";
        categoryRequest.request(dMMtopRequestListener);
    }

    public void getStarListRequest(StarListRequest starListRequest, DMMtopRequestListener<StarListBean> dMMtopRequestListener) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1475667211")) {
            ipChange.ipc$dispatch("-1475667211", new Object[]{this, starListRequest, dMMtopRequestListener});
        } else {
            starListRequest.request(dMMtopRequestListener);
        }
    }

    public void getStarRequest(StarRequest starRequest, DMMtopRequestListener<CategoryStarBean> dMMtopRequestListener) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-2076161295")) {
            ipChange.ipc$dispatch("-2076161295", new Object[]{this, starRequest, dMMtopRequestListener});
        } else {
            starRequest.request(dMMtopRequestListener);
        }
    }
}
