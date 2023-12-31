package tb;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.annotation.Nullable;
import cn.damai.commonbusiness.R$id;
import cn.damai.commonbusiness.R$layout;
import cn.damai.projectfilter.bean.FilterBean;
import cn.damai.projectfilter.bean.FilterData;
import cn.damai.projectfilter.bean.FilterGroupBean;
import cn.damai.projectfilter.bean.FilterItemBean;
import cn.damai.projectfilter.bean.Type;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/* compiled from: Taobao */
/* loaded from: classes6.dex */
public class hj0 extends cn.damai.projectfilter.floatview.a<HashMap<String, List<FilterBean>>> implements View.OnClickListener {
    private static transient /* synthetic */ IpChange $ipChange;
    private final View d;
    private FilterItemBean e;
    private boolean f;
    private ViewGroup g;
    private HashMap<String, List<a>> h;
    private HashMap<String, List<a>> i;
    private HashMap<String, FilterGroupBean> j;
    private View k;
    private long l;

    /* compiled from: Taobao */
    /* loaded from: classes6.dex */
    public static class a {
        private static transient /* synthetic */ IpChange $ipChange;
        public final String a;
        public final FilterBean b;
        public final TextView c;
        public final int d;
        public boolean e = false;

        public a(String str, FilterBean filterBean, TextView textView, int i) {
            this.a = str;
            this.b = filterBean;
            this.c = textView;
            this.d = i;
        }

        public void a(boolean z) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "-506957168")) {
                ipChange.ipc$dispatch("-506957168", new Object[]{this, Boolean.valueOf(z)});
                return;
            }
            this.e = z;
            this.c.setSelected(z);
            this.c.setTextColor(z ? kh0.C_FF2869 : kh0.C_333333);
        }
    }

    public hj0(Context context, FilterItemBean filterItemBean) {
        super(context);
        this.f = false;
        this.h = new HashMap<>();
        this.i = new HashMap<>();
        this.j = new HashMap<>();
        this.e = filterItemBean;
        View inflate = LayoutInflater.from(context).inflate(R$layout.item_filter_filter_float, (ViewGroup) null);
        this.d = inflate;
        inflate.setLayoutParams(new ViewGroup.LayoutParams(-1, -2));
        this.g = (ViewGroup) inflate.findViewById(R$id.item_filter_container);
        View findViewById = inflate.findViewById(R$id.item_filter_reset);
        this.k = inflate.findViewById(R$id.item_filter_confirm);
        findViewById.setOnClickListener(this);
        this.k.setOnClickListener(this);
    }

    private void a(String str, a aVar) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-989824372")) {
            ipChange.ipc$dispatch("-989824372", new Object[]{this, str, aVar});
            return;
        }
        List<a> list = this.h.get(str);
        if (list == null) {
            list = new ArrayList<>();
            this.h.put(str, list);
        }
        list.add(aVar);
        aVar.a(true);
    }

    private void b() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "884531636")) {
            ipChange.ipc$dispatch("884531636", new Object[]{this});
            return;
        }
        for (String str : this.h.keySet()) {
            List<a> list = this.h.get(str);
            if (!cb2.d(list)) {
                for (a aVar : list) {
                    aVar.a(false);
                }
            }
        }
        this.h.clear();
    }

    private void c() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "638276573")) {
            ipChange.ipc$dispatch("638276573", new Object[]{this});
        } else if (!this.f) {
            this.f = true;
            FilterItemBean filterItemBean = this.e;
            List<FilterGroupBean> list = filterItemBean != null ? filterItemBean.selection : null;
            if (cb2.d(list)) {
                return;
            }
            for (FilterGroupBean filterGroupBean : list) {
                if (filterGroupBean.isValid()) {
                    ArrayList arrayList = new ArrayList();
                    this.i.put(filterGroupBean.option, arrayList);
                    this.j.put(filterGroupBean.option, filterGroupBean);
                    View inflate = LayoutInflater.from(this.a).inflate(R$layout.item_filter_one_filter_container, this.g, false);
                    ViewGroup viewGroup = (ViewGroup) inflate.findViewById(R$id.item_filter_flex);
                    ((TextView) inflate.findViewById(R$id.item_filter_flex_title)).setText(filterGroupBean.name);
                    List<FilterBean> list2 = filterGroupBean.lineitem;
                    int size = list2.size();
                    for (int i = 0; i < size; i++) {
                        FilterBean filterBean = list2.get(i);
                        View inflate2 = LayoutInflater.from(this.a).inflate(R$layout.item_filter_one_filter_item, viewGroup, false);
                        TextView textView = (TextView) inflate2.findViewById(R$id.item_filter_text);
                        textView.setText(filterBean.name);
                        textView.setSelected(false);
                        a aVar = new a(filterGroupBean.option, filterBean, textView, i);
                        arrayList.add(aVar);
                        inflate2.setTag(aVar);
                        inflate2.setOnClickListener(this);
                        viewGroup.addView(inflate2, -2, -2);
                    }
                    this.g.addView(inflate, -1, -2);
                }
            }
        }
    }

    private HashMap<String, List<FilterBean>> d() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-517098762")) {
            return (HashMap) ipChange.ipc$dispatch("-517098762", new Object[]{this});
        }
        HashMap<String, List<FilterBean>> hashMap = new HashMap<>();
        for (String str : this.h.keySet()) {
            List<a> list = this.h.get(str);
            if (!cb2.d(list)) {
                ArrayList arrayList = new ArrayList();
                hashMap.put(str, arrayList);
                for (a aVar : list) {
                    arrayList.add(aVar.b);
                }
            }
        }
        return hashMap;
    }

    private void e(String str, a aVar) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1382375646")) {
            ipChange.ipc$dispatch("1382375646", new Object[]{this, str, aVar});
            return;
        }
        List<a> list = this.h.get(str);
        if (!cb2.d(list)) {
            list.remove(aVar);
        }
        aVar.a(false);
    }

    @Override // cn.damai.projectfilter.floatview.FloatLayer
    /* renamed from: f */
    public void show(@Nullable HashMap<String, List<FilterBean>> hashMap) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1279367263")) {
            ipChange.ipc$dispatch("1279367263", new Object[]{this, hashMap});
            return;
        }
        this.l = System.currentTimeMillis();
        c();
        b();
        if (hashMap == null || cb2.f(hashMap)) {
            return;
        }
        for (String str : hashMap.keySet()) {
            List<FilterBean> list = hashMap.get(str);
            List<a> list2 = this.i.get(str);
            if (!cb2.d(list) && !cb2.d(list2)) {
                for (a aVar : list2) {
                    if (list.contains(aVar.b)) {
                        a(str, aVar);
                    }
                }
            }
        }
    }

    @Override // cn.damai.projectfilter.floatview.FloatLayer
    public Type getType() {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "155017148") ? (Type) ipChange.ipc$dispatch("155017148", new Object[]{this}) : Type.FILTER;
    }

    @Override // cn.damai.projectfilter.floatview.FloatLayer
    public View getView() {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "17208384") ? (View) ipChange.ipc$dispatch("17208384", new Object[]{this}) : this.d;
    }

    @Override // cn.damai.projectfilter.floatview.FloatLayer
    public void hide() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1758043247")) {
            ipChange.ipc$dispatch("1758043247", new Object[]{this});
        } else {
            getFilterUt().w(this.k, System.currentTimeMillis() - this.l);
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        a aVar;
        String str;
        FilterGroupBean filterGroupBean;
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "568411618")) {
            ipChange.ipc$dispatch("568411618", new Object[]{this, view});
            return;
        }
        int id = view.getId();
        if (id == R$id.item_filter_confirm) {
            FilterData filterData = new FilterData();
            filterData.mFilterMap = d();
            getListener().onFloatCall(getType(), filterData);
            getFilterUt().m("confirm");
        } else if (id == R$id.item_filter_reset) {
            getFilterUt().m("reset");
            b();
        } else if (id == R$id.item_filter_one_item_id) {
            Object tag = view.getTag();
            if (!(tag instanceof a) || (filterGroupBean = this.j.get((str = (aVar = (a) tag).a))) == null) {
                return;
            }
            if (aVar.e) {
                e(str, aVar);
            } else {
                if (filterGroupBean.isSingleSelected) {
                    List<a> list = this.h.get(str);
                    if (!cb2.d(list)) {
                        for (a aVar2 : list) {
                            aVar2.a(false);
                        }
                        list.clear();
                    }
                }
                a(str, aVar);
            }
            getFilterUt().n(aVar.b, aVar.d);
        }
    }
}
