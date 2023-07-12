package tb;

import cn.damai.category.common.bean.CalendarBean;
import cn.damai.category.common.bean.CategoryPerformBean;
import cn.damai.category.common.bean.CategoryProjectBean;
import cn.damai.category.common.request.CategoryCalendarRequest;
import cn.damai.category.common.request.CategoryPerformRequest;
import cn.damai.category.common.request.CategoryRequest;
import cn.damai.common.net.mtop.netfit.DMMtopRequestListener;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;

/* compiled from: Taobao */
/* loaded from: classes.dex */
public class lf {
    private static transient /* synthetic */ IpChange $ipChange;

    public void a(String str, String str2, DMMtopRequestListener<CalendarBean> dMMtopRequestListener) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1421359096")) {
            ipChange.ipc$dispatch("1421359096", new Object[]{this, str, str2, dMMtopRequestListener});
            return;
        }
        CategoryCalendarRequest categoryCalendarRequest = new CategoryCalendarRequest();
        categoryCalendarRequest.startDate = str;
        categoryCalendarRequest.endDate = str2;
        categoryCalendarRequest.request(dMMtopRequestListener);
    }

    public void b(CategoryRequest categoryRequest, DMMtopRequestListener<CategoryPerformBean> dMMtopRequestListener) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-845353807")) {
            ipChange.ipc$dispatch("-845353807", new Object[]{this, categoryRequest, dMMtopRequestListener});
            return;
        }
        CategoryPerformRequest categoryPerformRequest = new CategoryPerformRequest();
        categoryPerformRequest.categoryId = categoryRequest.categoryId;
        categoryPerformRequest.dateType = categoryRequest.dateType;
        categoryPerformRequest.startDate = categoryRequest.startDate;
        categoryPerformRequest.endDate = categoryRequest.endDate;
        categoryPerformRequest.request(dMMtopRequestListener);
    }

    public void c(CategoryRequest categoryRequest, DMMtopRequestListener<CategoryProjectBean> dMMtopRequestListener) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "486303069")) {
            ipChange.ipc$dispatch("486303069", new Object[]{this, categoryRequest, dMMtopRequestListener});
            return;
        }
        categoryRequest.apiVersion = "1.0";
        categoryRequest.request(dMMtopRequestListener);
    }
}
