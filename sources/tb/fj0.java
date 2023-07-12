package tb;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import cn.damai.commonbusiness.calendarcopy.bean.CalendarBean;
import cn.damai.projectfiltercopy.FloatListener;
import cn.damai.projectfiltercopy.bean.CalendarInitBean;
import cn.damai.projectfiltercopy.bean.CityBean;
import cn.damai.projectfiltercopy.bean.FilterBean;
import cn.damai.projectfiltercopy.bean.FilterData;
import cn.damai.projectfiltercopy.bean.FilterItemBean;
import cn.damai.projectfiltercopy.bean.SortBean;
import cn.damai.projectfiltercopy.bean.Type;
import cn.damai.projectfiltercopy.filterbtn.FilterBtn;
import cn.damai.projectfiltercopy.floatcontainer.FloatContainer;
import cn.damai.projectfiltercopy.floatview.CityFloatLayer;
import cn.damai.projectfiltercopy.floatview.FloatLayer;
import cn.damai.projectfiltercopy.floatview.View$OnClickListenerC1532b;
import cn.damai.projectfiltercopy.listener.FilterBtnAction;
import cn.damai.projectfiltercopy.listener.FilterBtnClickListener;
import cn.damai.projectfiltercopy.listener.FilterBtnClickProxyHListener;
import cn.damai.projectfiltercopy.model.CategoryDataAssembler;
import cn.damai.projectfiltercopy.model.CategoryNewT;
import cn.damai.projectfiltercopy.model.CityModel;
import cn.damai.projectfiltercopy.model.DateModel;
import cn.damai.projectfiltercopy.model.FilterModel;
import cn.damai.projectfiltercopy.model.FilterT;
import cn.damai.projectfiltercopy.model.GetTFromModel;
import cn.damai.projectfiltercopy.model.SortT;
import cn.damai.tetris.component.drama.viewholdercopy.OnItemBindListener;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import java.util.HashMap;
import java.util.List;

/* compiled from: Taobao */
/* loaded from: classes6.dex */
public class fj0<T> implements FloatListener, FilterBtnClickListener {
    private static transient /* synthetic */ IpChange $ipChange;
    public final Type a;
    public final FilterModel b;
    public final FloatContainer c;
    public final FilterBtn d;
    public final FloatLayer<T> e;
    public final GetTFromModel<T> f;
    private OnItemBindListener<Type> g;

    public fj0(Type type, FilterModel filterModel, FloatContainer floatContainer, FilterBtn filterBtn, FloatLayer<T> floatLayer, GetTFromModel<T> getTFromModel) {
        this.a = type;
        this.c = floatContainer;
        this.d = filterBtn;
        this.e = floatLayer;
        this.f = getTFromModel;
        this.b = filterModel;
        floatLayer.setListener(this);
    }

    public static fj0<CityBean> b(Context context, FloatContainer floatContainer, FilterModel filterModel) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "431922897")) {
            return (fj0) ipChange.ipc$dispatch("431922897", new Object[]{context, floatContainer, filterModel});
        }
        Type type = Type.CITY;
        return new fj0<>(type, filterModel, floatContainer, new dj0(context, type, filterModel), new CityFloatLayer(context), new CityModel(filterModel));
    }

    public static fj0<CalendarBean> c(Context context, FloatContainer floatContainer, FilterModel filterModel, CalendarInitBean calendarInitBean) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1714884150")) {
            return (fj0) ipChange.ipc$dispatch("-1714884150", new Object[]{context, floatContainer, filterModel, calendarInitBean});
        }
        Type type = Type.DATE;
        return new fj0<>(type, filterModel, floatContainer, new dj0(context, type, filterModel), new hf(context, calendarInitBean), new DateModel(filterModel));
    }

    public static fj0<CalendarBean> d(Context context, FloatContainer floatContainer, FilterModel filterModel, CalendarInitBean calendarInitBean) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-71877427")) {
            return (fj0) ipChange.ipc$dispatch("-71877427", new Object[]{context, floatContainer, filterModel, calendarInitBean});
        }
        Type type = Type.DATE_HOR_CALENDAR;
        return new fj0<>(type, filterModel, floatContainer, new cj0(context, type, filterModel), new hf(context, calendarInitBean), new DateModel(filterModel));
    }

    public static fj0<HashMap<String, List<FilterBean>>> e(Context context, FloatContainer floatContainer, FilterModel filterModel, FilterItemBean filterItemBean) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "841084599")) {
            return (fj0) ipChange.ipc$dispatch("841084599", new Object[]{context, floatContainer, filterModel, filterItemBean});
        }
        Type type = Type.FILTER;
        return new fj0<>(type, filterModel, floatContainer, new dj0(context, type, filterModel), new ij0(context, filterItemBean), new FilterT(filterModel));
    }

    public static fj0<CategoryDataAssembler> f(Context context, FloatContainer floatContainer, FilterModel filterModel) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "178699386")) {
            return (fj0) ipChange.ipc$dispatch("178699386", new Object[]{context, floatContainer, filterModel});
        }
        Type type = Type.NEW_CATEGORY;
        return new fj0<>(type, filterModel, floatContainer, new dj0(context, type, filterModel), new yg(context, filterModel.mCatAssembler), new CategoryNewT(filterModel));
    }

    public static fj0<SortBean> g(Context context, FloatContainer floatContainer, FilterModel filterModel, List<SortBean> list) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1016657269")) {
            return (fj0) ipChange.ipc$dispatch("1016657269", new Object[]{context, floatContainer, filterModel, list});
        }
        Type type = Type.SORT;
        return new fj0<>(type, filterModel, floatContainer, new dj0(context, type, filterModel), new View$OnClickListenerC1532b(context, list), new SortT(filterModel));
    }

    public void a(ViewGroup viewGroup, ViewGroup viewGroup2, ViewGroup viewGroup3, FilterBtnAction filterBtnAction) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1602717335")) {
            ipChange.ipc$dispatch("1602717335", new Object[]{this, viewGroup, viewGroup2, viewGroup3, filterBtnAction});
            return;
        }
        View view = this.d.getView();
        view.setOnClickListener(new FilterBtnClickProxyHListener(this.a, this, filterBtnAction));
        Type type = this.d.getType();
        if (type == Type.SORT) {
            viewGroup2.addView(view);
        } else if (type == Type.DATE_HOR_CALENDAR) {
            viewGroup3.addView(view);
        } else {
            viewGroup.addView(view);
        }
        OnItemBindListener<Type> onItemBindListener = this.g;
        if (onItemBindListener != null) {
            onItemBindListener.exposeItem(view, this.a, 0);
        }
        this.d.setState(false);
    }

    public void h(OnItemBindListener<Type> onItemBindListener) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "657931699")) {
            ipChange.ipc$dispatch("657931699", new Object[]{this, onItemBindListener});
        } else {
            this.g = onItemBindListener;
        }
    }

    @Override // cn.damai.projectfiltercopy.listener.FilterBtnClickListener
    public void onFilterBtnClick(View view, int i) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1459233862")) {
            ipChange.ipc$dispatch("-1459233862", new Object[]{this, view, Integer.valueOf(i)});
            return;
        }
        OnItemBindListener<Type> onItemBindListener = this.g;
        if (onItemBindListener != null) {
            onItemBindListener.onItemClick(this.a, 0);
        }
        boolean isShowing = this.c.isShowing();
        FilterBtn showAnchor = this.c.getShowAnchor();
        if (isShowing && (showAnchor == null || this.d == showAnchor)) {
            this.c.hide();
            return;
        }
        this.e.show(this.f.getT(this.a));
        this.c.show(this.d, this.e, i);
    }

    @Override // cn.damai.projectfiltercopy.FloatListener
    public void onFloatCall(Type type, FilterData filterData) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1578258033")) {
            ipChange.ipc$dispatch("-1578258033", new Object[]{this, type, filterData});
            return;
        }
        this.b.onFloatCall(type, filterData);
        this.c.hide();
    }
}
