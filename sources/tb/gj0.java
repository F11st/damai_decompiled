package tb;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import cn.damai.commonbusiness.calendar.bean.CalendarBean;
import cn.damai.commonbusiness.calendar.bean.CalendarYearBean;
import cn.damai.projectfilter.FloatListener;
import cn.damai.projectfilter.bean.CityBean;
import cn.damai.projectfilter.bean.FilterBean;
import cn.damai.projectfilter.bean.FilterData;
import cn.damai.projectfilter.bean.FilterItemBean;
import cn.damai.projectfilter.bean.SortBean;
import cn.damai.projectfilter.bean.Type;
import cn.damai.projectfilter.filterbtn.FilterBtn;
import cn.damai.projectfilter.floatcontainer.FloatContainer;
import cn.damai.projectfilter.floatview.CityFloatLayer;
import cn.damai.projectfilter.floatview.FloatLayer;
import cn.damai.projectfilter.listener.FilterBtnAction;
import cn.damai.projectfilter.listener.FilterBtnClickListener;
import cn.damai.projectfilter.listener.FilterBtnClickProxyHListener;
import cn.damai.projectfilter.model.CategoryDataAssembler;
import cn.damai.projectfilter.model.CategoryNewT;
import cn.damai.projectfilter.model.CityModel;
import cn.damai.projectfilter.model.DateModel;
import cn.damai.projectfilter.model.FilterModel;
import cn.damai.projectfilter.model.FilterT;
import cn.damai.projectfilter.model.GetTFromModel;
import cn.damai.projectfilter.model.SortT;
import cn.damai.tetris.component.drama.viewholder.OnItemBindListener;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import java.util.HashMap;
import java.util.List;

/* compiled from: Taobao */
/* loaded from: classes6.dex */
public class gj0<T> implements FloatListener, FilterBtnClickListener {
    private static transient /* synthetic */ IpChange $ipChange;
    public final Type a;
    public final FilterModel b;
    public final FloatContainer c;
    public final FilterBtn d;
    public final FloatLayer<T> e;
    public final GetTFromModel<T> f;
    private OnItemBindListener<Type> g;

    public gj0(Type type, FilterModel filterModel, FloatContainer floatContainer, FilterBtn filterBtn, FloatLayer<T> floatLayer, GetTFromModel<T> getTFromModel) {
        this.a = type;
        this.c = floatContainer;
        this.d = filterBtn;
        this.e = floatLayer;
        this.f = getTFromModel;
        this.b = filterModel;
        floatLayer.setListener(this);
    }

    public static gj0<CityBean> b(Context context, FloatContainer floatContainer, FilterModel filterModel) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-789594991")) {
            return (gj0) ipChange.ipc$dispatch("-789594991", new Object[]{context, floatContainer, filterModel});
        }
        Type type = Type.CITY;
        return new gj0<>(type, filterModel, floatContainer, new ej0(context, type, filterModel), new CityFloatLayer(context), new CityModel(filterModel));
    }

    public static gj0<CalendarBean> c(Context context, FloatContainer floatContainer, FilterModel filterModel, List<CalendarYearBean> list) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1571195835")) {
            return (gj0) ipChange.ipc$dispatch("-1571195835", new Object[]{context, floatContainer, filterModel, list});
        }
        Type type = Type.DATE;
        return new gj0<>(type, filterModel, floatContainer, new ej0(context, type, filterModel), new Cif(context, list), new DateModel(filterModel));
    }

    public static gj0<HashMap<String, List<FilterBean>>> d(Context context, FloatContainer floatContainer, FilterModel filterModel, FilterItemBean filterItemBean) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "930485260")) {
            return (gj0) ipChange.ipc$dispatch("930485260", new Object[]{context, floatContainer, filterModel, filterItemBean});
        }
        Type type = Type.FILTER;
        return new gj0<>(type, filterModel, floatContainer, new ej0(context, type, filterModel), new hj0(context, filterItemBean), new FilterT(filterModel));
    }

    public static gj0<CategoryDataAssembler> e(Context context, FloatContainer floatContainer, FilterModel filterModel) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1631710012")) {
            return (gj0) ipChange.ipc$dispatch("-1631710012", new Object[]{context, floatContainer, filterModel});
        }
        Type type = Type.NEW_CATEGORY;
        return new gj0<>(type, filterModel, floatContainer, new ej0(context, type, filterModel), new zg(context, filterModel.mCatAssembler), new CategoryNewT(filterModel));
    }

    public static gj0<SortBean> f(Context context, FloatContainer floatContainer, FilterModel filterModel, List<SortBean> list) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1676534219")) {
            return (gj0) ipChange.ipc$dispatch("-1676534219", new Object[]{context, floatContainer, filterModel, list});
        }
        Type type = Type.SORT;
        return new gj0<>(type, filterModel, floatContainer, new ej0(context, type, filterModel), new te2(context, list), new SortT(filterModel));
    }

    public void a(ViewGroup viewGroup, ViewGroup viewGroup2, FilterBtnAction filterBtnAction) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1014704308")) {
            ipChange.ipc$dispatch("-1014704308", new Object[]{this, viewGroup, viewGroup2, filterBtnAction});
            return;
        }
        View view = this.d.getView();
        view.setOnClickListener(new FilterBtnClickProxyHListener(this.a, this, filterBtnAction));
        if (this.d.getType() == Type.FILTER) {
            viewGroup2.addView(view);
        } else {
            viewGroup.addView(view);
        }
        OnItemBindListener<Type> onItemBindListener = this.g;
        if (onItemBindListener != null) {
            onItemBindListener.exposeItem(view, this.a, 0);
        }
        this.d.setState(false);
    }

    public void g(OnItemBindListener<Type> onItemBindListener) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-913259575")) {
            ipChange.ipc$dispatch("-913259575", new Object[]{this, onItemBindListener});
        } else {
            this.g = onItemBindListener;
        }
    }

    @Override // cn.damai.projectfilter.listener.FilterBtnClickListener
    public void onFilterBtnClick(View view, int i) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1263159153")) {
            ipChange.ipc$dispatch("-1263159153", new Object[]{this, view, Integer.valueOf(i)});
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

    @Override // cn.damai.projectfilter.FloatListener
    public void onFloatCall(Type type, FilterData filterData) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-997166012")) {
            ipChange.ipc$dispatch("-997166012", new Object[]{this, type, filterData});
            return;
        }
        this.b.onFloatCall(type, filterData);
        this.c.hide();
    }
}
