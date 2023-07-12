package cn.damai.category.calendar.model;

import android.content.Context;
import androidx.lifecycle.MutableLiveData;
import cn.damai.category.common.bean.CalendarBean;
import cn.damai.category.common.bean.CategoryPerformBean;
import cn.damai.category.common.bean.CategoryProjectBean;
import cn.damai.category.common.request.CategoryRequest;
import cn.damai.common.net.mtop.netfit.DMMtopRequestListener;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import tb.lf;

/* compiled from: Taobao */
/* loaded from: classes.dex */
public class CalendarModel {
    private static transient /* synthetic */ IpChange $ipChange;
    private Context mContext;
    private MutableLiveData<CategoryProjectBean> mCalendarProjectBean = new MutableLiveData<>();
    private MutableLiveData<CategoryPerformBean> mCategoryPerformBean = new MutableLiveData<>();
    private MutableLiveData<CalendarBean> mCalendarBean = new MutableLiveData<>();
    private lf mRepository = new lf();

    public CalendarModel(Context context) {
        this.mContext = context;
    }

    public void calendarRequest(String str, String str2) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1713825454")) {
            ipChange.ipc$dispatch("1713825454", new Object[]{this, str, str2});
        } else {
            this.mRepository.a(str, str2, new DMMtopRequestListener<CalendarBean>(CalendarBean.class) { // from class: cn.damai.category.calendar.model.CalendarModel.3
                private static transient /* synthetic */ IpChange $ipChange;

                @Override // cn.damai.common.net.mtop.netfit.DMMtopRequestListener
                public void onFail(String str3, String str4) {
                    IpChange ipChange2 = $ipChange;
                    if (AndroidInstantRuntime.support(ipChange2, "1028119269")) {
                        ipChange2.ipc$dispatch("1028119269", new Object[]{this, str3, str4});
                    } else {
                        CalendarModel.this.mCalendarBean.setValue(null);
                    }
                }

                @Override // cn.damai.common.net.mtop.netfit.DMMtopRequestListener
                public void onSuccess(CalendarBean calendarBean) {
                    IpChange ipChange2 = $ipChange;
                    if (AndroidInstantRuntime.support(ipChange2, "-578133848")) {
                        ipChange2.ipc$dispatch("-578133848", new Object[]{this, calendarBean});
                    } else {
                        CalendarModel.this.mCalendarBean.setValue(calendarBean);
                    }
                }
            });
        }
    }

    public MutableLiveData<CalendarBean> getCalendarBean() {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "-800706547") ? (MutableLiveData) ipChange.ipc$dispatch("-800706547", new Object[]{this}) : this.mCalendarBean;
    }

    public MutableLiveData<CategoryProjectBean> getCalendarProjectBean() {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "-171354486") ? (MutableLiveData) ipChange.ipc$dispatch("-171354486", new Object[]{this}) : this.mCalendarProjectBean;
    }

    public MutableLiveData<CategoryPerformBean> getCategoryPerformBean() {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "815664914") ? (MutableLiveData) ipChange.ipc$dispatch("815664914", new Object[]{this}) : this.mCategoryPerformBean;
    }

    public void getCategoryPerformRequest(CategoryRequest categoryRequest) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1487474155")) {
            ipChange.ipc$dispatch("-1487474155", new Object[]{this, categoryRequest});
        } else {
            this.mRepository.b(categoryRequest, new DMMtopRequestListener<CategoryPerformBean>(CategoryPerformBean.class) { // from class: cn.damai.category.calendar.model.CalendarModel.2
                private static transient /* synthetic */ IpChange $ipChange;

                @Override // cn.damai.common.net.mtop.netfit.DMMtopRequestListener
                public void onFail(String str, String str2) {
                    IpChange ipChange2 = $ipChange;
                    if (AndroidInstantRuntime.support(ipChange2, "1035878628")) {
                        ipChange2.ipc$dispatch("1035878628", new Object[]{this, str, str2});
                    }
                }

                @Override // cn.damai.common.net.mtop.netfit.DMMtopRequestListener
                public void onSuccess(CategoryPerformBean categoryPerformBean) {
                    IpChange ipChange2 = $ipChange;
                    if (AndroidInstantRuntime.support(ipChange2, "-20257050")) {
                        ipChange2.ipc$dispatch("-20257050", new Object[]{this, categoryPerformBean});
                    } else {
                        CalendarModel.this.mCategoryPerformBean.setValue(categoryPerformBean);
                    }
                }
            });
        }
    }

    public void getProjectListRequest(CategoryRequest categoryRequest) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1938862359")) {
            ipChange.ipc$dispatch("-1938862359", new Object[]{this, categoryRequest});
        } else {
            this.mRepository.c(categoryRequest, new DMMtopRequestListener<CategoryProjectBean>(CategoryProjectBean.class) { // from class: cn.damai.category.calendar.model.CalendarModel.1
                private static transient /* synthetic */ IpChange $ipChange;

                @Override // cn.damai.common.net.mtop.netfit.DMMtopRequestListener
                public void onFail(String str, String str2) {
                    IpChange ipChange2 = $ipChange;
                    if (AndroidInstantRuntime.support(ipChange2, "1043637987")) {
                        ipChange2.ipc$dispatch("1043637987", new Object[]{this, str, str2});
                    } else {
                        CalendarModel.this.mCalendarProjectBean.setValue(null);
                    }
                }

                @Override // cn.damai.common.net.mtop.netfit.DMMtopRequestListener
                public void onSuccess(CategoryProjectBean categoryProjectBean) {
                    IpChange ipChange2 = $ipChange;
                    if (AndroidInstantRuntime.support(ipChange2, "410380397")) {
                        ipChange2.ipc$dispatch("410380397", new Object[]{this, categoryProjectBean});
                    } else {
                        CalendarModel.this.mCalendarProjectBean.setValue(categoryProjectBean);
                    }
                }
            });
        }
    }
}
