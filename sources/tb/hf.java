package tb;

import android.content.Context;
import android.util.Log;
import android.view.View;
import androidx.annotation.Nullable;
import cn.damai.commonbusiness.calendarcopy.CalendarPopView;
import cn.damai.commonbusiness.calendarcopy.bean.CalendarBean;
import cn.damai.projectfiltercopy.bean.CalendarInitBean;
import cn.damai.projectfiltercopy.bean.FilterData;
import cn.damai.projectfiltercopy.bean.Type;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import com.taobao.weex.common.Constants;
import com.youku.middlewareservice.provider.info.AppInfoProviderProxy;

/* compiled from: Taobao */
/* loaded from: classes6.dex */
public class hf extends cn.damai.projectfiltercopy.floatview.a<CalendarBean> implements View.OnClickListener {
    private static transient /* synthetic */ IpChange $ipChange;
    private CalendarPopView d;
    long e;

    /* compiled from: Taobao */
    /* loaded from: classes6.dex */
    public class a implements CalendarPopView.OnDateClickListener {
        private static transient /* synthetic */ IpChange $ipChange;

        a() {
        }

        @Override // cn.damai.commonbusiness.calendarcopy.CalendarPopView.OnDateClickListener
        public void onClose() {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "1205467586")) {
                ipChange.ipc$dispatch("1205467586", new Object[]{this});
            }
        }

        @Override // cn.damai.commonbusiness.calendarcopy.CalendarPopView.OnDateClickListener
        public void onDateClick(int i, String str, String str2, int i2, String str3) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "1543427478")) {
                ipChange.ipc$dispatch("1543427478", new Object[]{this, Integer.valueOf(i), str, str2, Integer.valueOf(i2), str3});
                return;
            }
            Log.d(Constants.Name.FILTER, "onDateClick  status " + i + ", start: " + str + ", end : " + str2 + " , name : " + str3);
            FilterData filterData = new FilterData();
            CalendarBean calendarBean = new CalendarBean();
            filterData.calendarBean = calendarBean;
            calendarBean.dateType = String.valueOf(i);
            CalendarBean calendarBean2 = filterData.calendarBean;
            calendarBean2.startDate = str;
            calendarBean2.endDate = str2;
            calendarBean2.name = str3;
            hf.this.getListener().onFloatCall(hf.this.getType(), filterData);
        }
    }

    public hf(Context context, CalendarInitBean calendarInitBean) {
        super(context);
        this.d = new CalendarPopView(AppInfoProviderProxy.getApplication(), true, true, 60, new a(), calendarInitBean);
    }

    @Override // cn.damai.projectfiltercopy.floatview.FloatLayer
    /* renamed from: a */
    public void show(@Nullable CalendarBean calendarBean) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "910435386")) {
            ipChange.ipc$dispatch("910435386", new Object[]{this, calendarBean});
            return;
        }
        if (this.d.r() == null) {
            this.d.B(getFilterUt());
        }
        this.d.A(calendarBean);
        this.d.F();
        this.e = System.currentTimeMillis();
    }

    @Override // cn.damai.projectfiltercopy.floatview.FloatLayer
    public Type getType() {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "-574076776") ? (Type) ipChange.ipc$dispatch("-574076776", new Object[]{this}) : Type.DATE;
    }

    @Override // cn.damai.projectfiltercopy.floatview.FloatLayer
    public View getView() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1139548433")) {
            return (View) ipChange.ipc$dispatch("-1139548433", new Object[]{this});
        }
        CalendarPopView calendarPopView = this.d;
        if (calendarPopView != null) {
            return calendarPopView.t();
        }
        return null;
    }

    @Override // cn.damai.projectfiltercopy.floatview.FloatLayer
    public void hide() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1930830432")) {
            ipChange.ipc$dispatch("1930830432", new Object[]{this});
            return;
        }
        this.d.u();
        getFilterUt().p(this.e);
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-931311341")) {
            ipChange.ipc$dispatch("-931311341", new Object[]{this, view});
        }
    }
}
