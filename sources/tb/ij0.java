package tb;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.annotation.Nullable;
import cn.damai.projectfiltercopy.bean.FilterBean;
import cn.damai.projectfiltercopy.bean.FilterData;
import cn.damai.projectfiltercopy.bean.FilterGroupBean;
import cn.damai.projectfiltercopy.bean.FilterItemBean;
import cn.damai.projectfiltercopy.bean.Type;
import cn.damai.projectfiltercopy.floatview.AbstractC1530a;
import com.alibaba.pictures.R$id;
import com.alibaba.pictures.R$layout;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/* compiled from: Taobao */
/* loaded from: classes6.dex */
public class ij0 extends AbstractC1530a<HashMap<String, List<FilterBean>>> implements View.OnClickListener {
    private static transient /* synthetic */ IpChange $ipChange;
    private final View d;
    private FilterItemBean e;
    private boolean f;
    private ViewGroup g;
    private HashMap<String, List<C9263a>> h;
    private HashMap<String, List<C9263a>> i;
    private HashMap<String, FilterGroupBean> j;
    private View k;
    private long l;

    /* compiled from: Taobao */
    /* renamed from: tb.ij0$a */
    /* loaded from: classes6.dex */
    public static class C9263a {
        private static transient /* synthetic */ IpChange $ipChange;
        public final String a;
        public final FilterBean b;
        public final TextView c;
        public final int d;
        public boolean e = false;

        public C9263a(String str, FilterBean filterBean, TextView textView, int i) {
            this.a = str;
            this.b = filterBean;
            this.c = textView;
            this.d = i;
        }

        public void a(boolean z) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "-703031877")) {
                ipChange.ipc$dispatch("-703031877", new Object[]{this, Boolean.valueOf(z)});
                return;
            }
            this.e = z;
            this.c.setSelected(z);
            this.c.setTextColor(z ? jh0.C_FF2869 : jh0.C_333333);
        }
    }

    public ij0(Context context, FilterItemBean filterItemBean) {
        super(context);
        this.f = false;
        this.h = new HashMap<>();
        this.i = new HashMap<>();
        this.j = new HashMap<>();
        this.e = filterItemBean;
        View inflate = LayoutInflater.from(context).inflate(R$layout.copy_item_filter_filter_float, (ViewGroup) null);
        this.d = inflate;
        inflate.setLayoutParams(new ViewGroup.LayoutParams(-1, -2));
        this.g = (ViewGroup) inflate.findViewById(R$id.item_filter_container);
        View findViewById = inflate.findViewById(R$id.item_filter_reset);
        this.k = inflate.findViewById(R$id.item_filter_confirm);
        findViewById.setOnClickListener(this);
        this.k.setOnClickListener(this);
    }

    private void a(String str, C9263a c9263a) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1022607650")) {
            ipChange.ipc$dispatch("1022607650", new Object[]{this, str, c9263a});
            return;
        }
        List<C9263a> list = this.h.get(str);
        if (list == null) {
            list = new ArrayList<>();
            this.h.put(str, list);
        }
        list.add(c9263a);
        c9263a.a(true);
    }

    private void b() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1760069225")) {
            ipChange.ipc$dispatch("1760069225", new Object[]{this});
            return;
        }
        for (String str : this.h.keySet()) {
            List<C9263a> list = this.h.get(str);
            if (!bb2.d(list)) {
                for (C9263a c9263a : list) {
                    c9263a.a(false);
                }
            }
        }
        this.h.clear();
    }

    private void c() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1613323822")) {
            ipChange.ipc$dispatch("-1613323822", new Object[]{this});
        } else if (!this.f) {
            this.f = true;
            FilterItemBean filterItemBean = this.e;
            List<FilterGroupBean> list = filterItemBean != null ? filterItemBean.selection : null;
            if (bb2.d(list)) {
                return;
            }
            for (FilterGroupBean filterGroupBean : list) {
                if (filterGroupBean.isValid()) {
                    ArrayList arrayList = new ArrayList();
                    this.i.put(filterGroupBean.option, arrayList);
                    this.j.put(filterGroupBean.option, filterGroupBean);
                    View inflate = LayoutInflater.from(this.a).inflate(R$layout.copy_item_filter_one_filter_container, this.g, false);
                    ViewGroup viewGroup = (ViewGroup) inflate.findViewById(R$id.item_filter_flex);
                    ((TextView) inflate.findViewById(R$id.item_filter_flex_title)).setText(filterGroupBean.name);
                    List<FilterBean> list2 = filterGroupBean.lineItem;
                    int size = list2.size();
                    for (int i = 0; i < size; i++) {
                        FilterBean filterBean = list2.get(i);
                        View inflate2 = LayoutInflater.from(this.a).inflate(R$layout.copy_item_filter_one_filter_item, viewGroup, false);
                        TextView textView = (TextView) inflate2.findViewById(R$id.item_filter_text);
                        textView.setText(filterBean.name);
                        textView.setSelected(false);
                        C9263a c9263a = new C9263a(filterGroupBean.option, filterBean, textView, i);
                        arrayList.add(c9263a);
                        inflate2.setTag(c9263a);
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
        if (AndroidInstantRuntime.support(ipChange, "-1353681173")) {
            return (HashMap) ipChange.ipc$dispatch("-1353681173", new Object[]{this});
        }
        HashMap<String, List<FilterBean>> hashMap = new HashMap<>();
        for (String str : this.h.keySet()) {
            List<C9263a> list = this.h.get(str);
            if (!bb2.d(list)) {
                ArrayList arrayList = new ArrayList();
                hashMap.put(str, arrayList);
                for (C9263a c9263a : list) {
                    arrayList.add(c9263a.b);
                }
            }
        }
        return hashMap;
    }

    private void e(String str, C9263a c9263a) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "54878132")) {
            ipChange.ipc$dispatch("54878132", new Object[]{this, str, c9263a});
            return;
        }
        List<C9263a> list = this.h.get(str);
        if (!bb2.d(list)) {
            list.remove(c9263a);
        }
        c9263a.a(false);
    }

    @Override // cn.damai.projectfiltercopy.floatview.FloatLayer
    /* renamed from: f */
    public void show(@Nullable HashMap<String, List<FilterBean>> hashMap) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "857400276")) {
            ipChange.ipc$dispatch("857400276", new Object[]{this, hashMap});
            return;
        }
        this.l = System.currentTimeMillis();
        c();
        b();
        if (hashMap == null || bb2.e(hashMap)) {
            return;
        }
        for (String str : hashMap.keySet()) {
            List<FilterBean> list = hashMap.get(str);
            List<C9263a> list2 = this.i.get(str);
            if (!bb2.d(list) && !bb2.d(list2)) {
                for (C9263a c9263a : list2) {
                    if (list.contains(c9263a.b)) {
                        a(str, c9263a);
                    }
                }
            }
        }
    }

    @Override // cn.damai.projectfiltercopy.floatview.FloatLayer
    public Type getType() {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "703473490") ? (Type) ipChange.ipc$dispatch("703473490", new Object[]{this}) : Type.FILTER;
    }

    @Override // cn.damai.projectfiltercopy.floatview.FloatLayer
    public View getView() {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "-1766140299") ? (View) ipChange.ipc$dispatch("-1766140299", new Object[]{this}) : this.d;
    }

    @Override // cn.damai.projectfiltercopy.floatview.FloatLayer
    public void hide() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-704855270")) {
            ipChange.ipc$dispatch("-704855270", new Object[]{this});
        } else {
            getFilterUt().u(this.k, System.currentTimeMillis() - this.l);
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        C9263a c9263a;
        String str;
        FilterGroupBean filterGroupBean;
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1119177293")) {
            ipChange.ipc$dispatch("1119177293", new Object[]{this, view});
            return;
        }
        int id = view.getId();
        if (id == R$id.item_filter_confirm) {
            FilterData filterData = new FilterData();
            filterData.mFilterMap = d();
            getListener().onFloatCall(getType(), filterData);
            getFilterUt().j("confirm");
        } else if (id == R$id.item_filter_reset) {
            getFilterUt().j("reset");
            b();
        } else if (id == R$id.item_filter_one_item_id) {
            Object tag = view.getTag();
            if (!(tag instanceof C9263a) || (filterGroupBean = this.j.get((str = (c9263a = (C9263a) tag).a))) == null) {
                return;
            }
            if (c9263a.e) {
                e(str, c9263a);
            } else {
                if (filterGroupBean.isSingleSelected) {
                    List<C9263a> list = this.h.get(str);
                    if (!bb2.d(list)) {
                        for (C9263a c9263a2 : list) {
                            c9263a2.a(false);
                        }
                        list.clear();
                    }
                }
                a(str, c9263a);
            }
            getFilterUt().k(c9263a.b, c9263a.d);
        }
    }
}
