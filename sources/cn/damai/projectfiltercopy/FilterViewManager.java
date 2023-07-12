package cn.damai.projectfiltercopy;

import android.content.Context;
import android.graphics.Rect;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import cn.damai.commonbusiness.calendarcopy.bean.CalendarBean;
import cn.damai.commonbusiness.calendarcopy.bean.Day;
import cn.damai.projectfiltercopy.FilterViewManager;
import cn.damai.projectfiltercopy.adapter.DaysAdapter;
import cn.damai.projectfiltercopy.adapter.FastFilterAdapter;
import cn.damai.projectfiltercopy.adapter.OnHorCalendarListener;
import cn.damai.projectfiltercopy.bean.CalendarStyle;
import cn.damai.projectfiltercopy.bean.FilterBean;
import cn.damai.projectfiltercopy.bean.FilterResponse;
import cn.damai.projectfiltercopy.bean.PresetBean;
import cn.damai.projectfiltercopy.bean.Type;
import cn.damai.projectfiltercopy.floatcontainer.FloatContainer;
import cn.damai.projectfiltercopy.listener.FilterBtnAction;
import cn.damai.projectfiltercopy.listener.HorDateClickResultListener;
import cn.damai.projectfiltercopy.listener.RequestParamProvider;
import cn.damai.projectfiltercopy.listener.UiBizListener;
import cn.damai.projectfiltercopy.model.FilterModel;
import cn.damai.tetris.component.drama.viewholdercopy.OnItemBindListener;
import com.alibaba.pictures.R$id;
import com.alibaba.pictures.R$layout;
import com.alibaba.pictures.bricks.channel.bean.StyleFilter;
import com.alibaba.pictures.bricks.view.TopRoundLinearLayout;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import java.util.ArrayList;
import java.util.List;
import tb.bb2;
import tb.fj0;
import tb.gk0;
import tb.jh0;
import tb.k62;
import tb.kj0;

/* compiled from: Taobao */
/* loaded from: classes6.dex */
public class FilterViewManager implements FilterBtnAction {
    private static transient /* synthetic */ IpChange $ipChange;
    private Context a;
    private View b;
    private ViewGroup c;
    private ViewGroup d;
    private ViewGroup e;
    private FloatContainer f;
    private RecyclerView g;
    private FastFilterAdapter h;
    private View i;
    private RecyclerView j;
    private DaysAdapter k;
    private TextView l;
    private FilterModel m;
    private List<fj0> n = new ArrayList();
    private FilterBtnAction o;
    private kj0 p;

    /* compiled from: Taobao */
    /* renamed from: cn.damai.projectfiltercopy.FilterViewManager$a */
    /* loaded from: classes6.dex */
    public class C1519a implements OnHorCalendarListener {
        private static transient /* synthetic */ IpChange $ipChange;

        C1519a() {
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void b(CalendarBean calendarBean) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "1462238954")) {
                ipChange.ipc$dispatch("1462238954", new Object[]{this, calendarBean});
            } else {
                FilterViewManager.this.p.l(calendarBean.startDate, calendarBean.endDate);
            }
        }

        @Override // cn.damai.projectfiltercopy.adapter.OnHorCalendarListener
        public void onCalendarClick(@NonNull Day day, @Nullable List<? extends Day> list) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "1901587058")) {
                ipChange.ipc$dispatch("1901587058", new Object[]{this, day, list});
            } else {
                FilterViewManager.this.m.onHorCalendarCall(day, list, new HorDateClickResultListener() { // from class: tb.mj0
                    @Override // cn.damai.projectfiltercopy.listener.HorDateClickResultListener
                    public final void onProcessResult(CalendarBean calendarBean) {
                        FilterViewManager.C1519a.this.b(calendarBean);
                    }
                });
            }
        }
    }

    /* compiled from: Taobao */
    /* renamed from: cn.damai.projectfiltercopy.FilterViewManager$b */
    /* loaded from: classes6.dex */
    public class C1520b implements OnItemBindListener<FilterBean> {
        private static transient /* synthetic */ IpChange $ipChange;

        C1520b() {
        }

        @Override // cn.damai.tetris.component.drama.viewholdercopy.OnItemBindListener
        /* renamed from: a */
        public void exposeItem(View view, FilterBean filterBean, int i) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "-2086750305")) {
                ipChange.ipc$dispatch("-2086750305", new Object[]{this, view, filterBean, Integer.valueOf(i)});
            } else {
                FilterViewManager.this.p.s(view, filterBean, i);
            }
        }

        @Override // cn.damai.tetris.component.drama.viewholdercopy.OnItemClickListener
        /* renamed from: b */
        public void onItemClick(FilterBean filterBean, int i) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "291089620")) {
                ipChange.ipc$dispatch("291089620", new Object[]{this, filterBean, Integer.valueOf(i)});
                return;
            }
            FilterViewManager.this.p.h(filterBean, i);
            FilterViewManager.this.m.onFastCall(filterBean);
        }
    }

    /* compiled from: Taobao */
    /* renamed from: cn.damai.projectfiltercopy.FilterViewManager$c */
    /* loaded from: classes6.dex */
    public class C1521c implements OnItemBindListener<Type> {
        private static transient /* synthetic */ IpChange $ipChange;

        C1521c() {
        }

        @Override // cn.damai.tetris.component.drama.viewholdercopy.OnItemBindListener
        /* renamed from: a */
        public void exposeItem(View view, Type type, int i) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "2126774547")) {
                ipChange.ipc$dispatch("2126774547", new Object[]{this, view, type, Integer.valueOf(i)});
            } else {
                FilterViewManager.this.p.t(view, type);
            }
        }

        @Override // cn.damai.tetris.component.drama.viewholdercopy.OnItemClickListener
        /* renamed from: b */
        public void onItemClick(Type type, int i) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "1076100744")) {
                ipChange.ipc$dispatch("1076100744", new Object[]{this, type, Integer.valueOf(i)});
            } else {
                FilterViewManager.this.p.i(type);
            }
        }
    }

    public FilterViewManager(Context context, ViewGroup viewGroup, kj0 kj0Var) {
        this.a = context;
        this.p = kj0Var;
        View inflate = LayoutInflater.from(context).inflate(R$layout.copy_item_filter_view_container, (ViewGroup) null);
        this.b = inflate;
        inflate.setLayoutParams(new ViewGroup.LayoutParams(-1, -2));
        this.l = (TextView) this.b.findViewById(R$id.filter_view_title);
        this.i = this.b.findViewById(R$id.filter_horizontal_calendar_layout);
        RecyclerView recyclerView = (RecyclerView) this.b.findViewById(R$id.filter_horizontal_calendar);
        this.j = recyclerView;
        recyclerView.addItemDecoration(new RecyclerView.ItemDecoration() { // from class: cn.damai.projectfiltercopy.FilterViewManager.1
            private static transient /* synthetic */ IpChange $ipChange;

            @Override // androidx.recyclerview.widget.RecyclerView.ItemDecoration
            public void getItemOffsets(@NonNull Rect rect, @NonNull View view, @NonNull RecyclerView recyclerView2, @NonNull RecyclerView.State state) {
                IpChange ipChange = $ipChange;
                if (AndroidInstantRuntime.support(ipChange, "-1633466141")) {
                    ipChange.ipc$dispatch("-1633466141", new Object[]{this, rect, view, recyclerView2, state});
                } else if (recyclerView2.getChildAdapterPosition(view) == 0) {
                    rect.left = k62.a(FilterViewManager.this.a, 9.0f);
                } else {
                    rect.left = 0;
                }
            }
        });
        this.j.setLayoutManager(new LinearLayoutManager(this.a, 0, false));
        DaysAdapter daysAdapter = new DaysAdapter(new C1519a());
        this.k = daysAdapter;
        this.j.setAdapter(daysAdapter);
        this.c = (ViewGroup) this.b.findViewById(R$id.filter_btn_container);
        this.d = (ViewGroup) this.b.findViewById(R$id.filter_btn_container2);
        this.e = (ViewGroup) this.b.findViewById(R$id.filter_horizontal_calendar_btn_layout);
        RecyclerView recyclerView2 = (RecyclerView) this.b.findViewById(R$id.filter_fast_filter_list);
        this.g = recyclerView2;
        recyclerView2.addItemDecoration(new RecyclerView.ItemDecoration() { // from class: cn.damai.projectfiltercopy.FilterViewManager.3
            private static transient /* synthetic */ IpChange $ipChange;

            @Override // androidx.recyclerview.widget.RecyclerView.ItemDecoration
            public void getItemOffsets(@NonNull Rect rect, @NonNull View view, @NonNull RecyclerView recyclerView3, @NonNull RecyclerView.State state) {
                IpChange ipChange = $ipChange;
                boolean z = true;
                if (AndroidInstantRuntime.support(ipChange, "892029541")) {
                    ipChange.ipc$dispatch("892029541", new Object[]{this, rect, view, recyclerView3, state});
                    return;
                }
                int childAdapterPosition = recyclerView3.getChildAdapterPosition(view);
                z = (FilterViewManager.this.h == null || childAdapterPosition != FilterViewManager.this.h.getItemCount() - 1) ? false : false;
                rect.left = childAdapterPosition == 0 ? jh0.MARGIN_12 : 0;
                rect.right = z ? jh0.MARGIN_12 : jh0.MARGIN_9;
            }
        });
        this.g.setItemAnimator(null);
        this.g.setLayoutManager(new LinearLayoutManager(this.a, 0, false));
        FastFilterAdapter fastFilterAdapter = new FastFilterAdapter(this.a, new C1520b());
        this.h = fastFilterAdapter;
        this.g.setAdapter(fastFilterAdapter);
        this.f = new gk0(context, viewGroup);
        this.m = new FilterModel(new UiBizListener() { // from class: cn.damai.projectfiltercopy.FilterViewManager.5
            private static transient /* synthetic */ IpChange $ipChange;

            @Override // cn.damai.projectfiltercopy.listener.UiBizListener
            public void onFastFilterChanged(List<FilterBean> list) {
                IpChange ipChange = $ipChange;
                if (AndroidInstantRuntime.support(ipChange, "-925336792")) {
                    ipChange.ipc$dispatch("-925336792", new Object[]{this, list});
                } else {
                    FilterViewManager.this.h.c(list);
                }
            }

            @Override // cn.damai.projectfiltercopy.listener.UiBizListener
            public void onHorCalendarChanged(List<Day> list, @Nullable List<Day> list2, boolean z) {
                IpChange ipChange = $ipChange;
                if (AndroidInstantRuntime.support(ipChange, "1680226314")) {
                    ipChange.ipc$dispatch("1680226314", new Object[]{this, list, list2, Boolean.valueOf(z)});
                    return;
                }
                FilterViewManager.this.k.f(list, list2);
                if (!z || bb2.d(list)) {
                    return;
                }
                int indexOf = !bb2.d(list2) ? list.indexOf(list2.get(0)) : 0;
                final int i = indexOf >= 0 ? indexOf : 0;
                FilterViewManager.this.j.post(new Runnable() { // from class: cn.damai.projectfiltercopy.FilterViewManager.5.1
                    private static transient /* synthetic */ IpChange $ipChange;

                    @Override // java.lang.Runnable
                    public void run() {
                        IpChange ipChange2 = $ipChange;
                        if (AndroidInstantRuntime.support(ipChange2, "-1747874624")) {
                            ipChange2.ipc$dispatch("-1747874624", new Object[]{this});
                            return;
                        }
                        RecyclerView.LayoutManager layoutManager = FilterViewManager.this.j.getLayoutManager();
                        if (layoutManager instanceof LinearLayoutManager) {
                            ((LinearLayoutManager) layoutManager).scrollToPositionWithOffset(i, k62.a(FilterViewManager.this.a, 9.0f));
                        }
                    }
                });
            }

            @Override // cn.damai.projectfiltercopy.listener.UiBizListener
            public void onMainFilterChanged(Type type) {
                IpChange ipChange = $ipChange;
                if (AndroidInstantRuntime.support(ipChange, "-1244058098")) {
                    ipChange.ipc$dispatch("-1244058098", new Object[]{this, type});
                    return;
                }
                for (fj0 fj0Var : FilterViewManager.this.n) {
                    if (type == fj0Var.a) {
                        fj0Var.d.setState(false);
                    }
                }
            }
        });
    }

    @Override // cn.damai.projectfiltercopy.listener.FilterBtnAction
    public int computeFloatTopPadding(Type type) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1439710893")) {
            return ((Integer) ipChange.ipc$dispatch("1439710893", new Object[]{this, type})).intValue();
        }
        FilterBtnAction filterBtnAction = this.o;
        if (filterBtnAction != null) {
            return filterBtnAction.computeFloatTopPadding(type);
        }
        return 0;
    }

    @Override // cn.damai.projectfiltercopy.listener.FilterBtnAction
    public void doBeforeFilterBtnClick(Type type) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "154465773")) {
            ipChange.ipc$dispatch("154465773", new Object[]{this, type});
            return;
        }
        FilterBtnAction filterBtnAction = this.o;
        if (filterBtnAction != null) {
            filterBtnAction.doBeforeFilterBtnClick(type);
        }
    }

    public int h() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "511352137")) {
            return ((Integer) ipChange.ipc$dispatch("511352137", new Object[]{this})).intValue();
        }
        if (this.i.getVisibility() == 0) {
            return k62.a(this.a, 106.0f);
        }
        return k62.a(this.a, 44.0f);
    }

    public RequestParamProvider i() {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "1083206220") ? (RequestParamProvider) ipChange.ipc$dispatch("1083206220", new Object[]{this}) : this.m;
    }

    public int j() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "3467019")) {
            return ((Integer) ipChange.ipc$dispatch("3467019", new Object[]{this})).intValue();
        }
        if (this.l.getVisibility() == 8) {
            return 0;
        }
        return this.l.getHeight();
    }

    public View k() {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "531485712") ? (View) ipChange.ipc$dispatch("531485712", new Object[]{this}) : this.b;
    }

    public void l(FilterResponse filterResponse, StyleFilter styleFilter, PresetBean presetBean) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1846946342")) {
            ipChange.ipc$dispatch("1846946342", new Object[]{this, filterResponse, styleFilter, presetBean});
            return;
        }
        this.m.init(filterResponse, presetBean, styleFilter.calendarStyle());
        this.n.clear();
        if (TextUtils.isEmpty(styleFilter.title)) {
            this.l.setVisibility(8);
        } else {
            this.l.setText(styleFilter.title);
            this.l.setVisibility(0);
        }
        List<Type> list = this.m.supportBtnType;
        if (list.contains(Type.DATE_HOR_CALENDAR)) {
            Context context = this.a;
            FloatContainer floatContainer = this.f;
            FilterModel filterModel = this.m;
            this.n.add(fj0.d(context, floatContainer, filterModel, filterModel.getCalendarInit()));
        }
        if (list.contains(Type.DATE)) {
            Context context2 = this.a;
            FloatContainer floatContainer2 = this.f;
            FilterModel filterModel2 = this.m;
            this.n.add(fj0.c(context2, floatContainer2, filterModel2, filterModel2.getCalendarInit()));
        }
        if (list.contains(Type.CITY)) {
            this.n.add(fj0.b(this.a, this.f, this.m));
        }
        if (list.contains(Type.NEW_CATEGORY)) {
            this.n.add(fj0.f(this.a, this.f, this.m));
        }
        if (list.contains(Type.FILTER)) {
            Context context3 = this.a;
            FloatContainer floatContainer3 = this.f;
            FilterModel filterModel3 = this.m;
            this.n.add(fj0.e(context3, floatContainer3, filterModel3, filterModel3.getFilterBean()));
        }
        if (list.contains(Type.SORT)) {
            Context context4 = this.a;
            FloatContainer floatContainer4 = this.f;
            FilterModel filterModel4 = this.m;
            this.n.add(fj0.g(context4, floatContainer4, filterModel4, filterModel4.getSortList()));
        }
        for (fj0 fj0Var : this.n) {
            fj0Var.h(new C1521c());
            fj0Var.e.setFilterUt(this.p);
            fj0Var.a(this.c, this.d, this.e, this);
        }
        List<FilterBean> list2 = this.m.mFastFilterList;
        if (bb2.d(list2)) {
            this.g.setVisibility(8);
        } else {
            this.g.setVisibility(0);
            this.h.c(list2);
        }
        if (CalendarStyle.LINE == styleFilter.calendarStyle()) {
            this.i.setVisibility(0);
            this.p.v(this.i);
            DaysAdapter daysAdapter = this.k;
            FilterModel filterModel5 = this.m;
            daysAdapter.f(filterModel5.mTotalDayList, filterModel5.mSelectDayList);
        } else {
            this.i.setVisibility(8);
        }
        if (styleFilter.isTopRoundCorner()) {
            View view = this.b;
            if (view instanceof TopRoundLinearLayout) {
                ((TopRoundLinearLayout) view).setTopRadius(k62.a(this.a, 12.0f));
            }
        }
    }

    public void m(FilterBtnAction filterBtnAction) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1472808597")) {
            ipChange.ipc$dispatch("1472808597", new Object[]{this, filterBtnAction});
        } else {
            this.o = filterBtnAction;
        }
    }
}
