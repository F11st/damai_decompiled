package tb;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import cn.damai.commonbusiness.R$id;
import cn.damai.commonbusiness.R$layout;
import cn.damai.projectfilter.FloatListener;
import cn.damai.projectfilter.adapter.CategoryMainAdapter;
import cn.damai.projectfilter.adapter.CategorySubAdapter;
import cn.damai.projectfilter.bean.CategoryLevelOne;
import cn.damai.projectfilter.bean.CategoryLevelTwo;
import cn.damai.projectfilter.bean.FilterData;
import cn.damai.projectfilter.bean.Type;
import cn.damai.projectfilter.model.CategoryDataAssembler;
import cn.damai.projectfilter.model.CategoryUpdate;
import cn.damai.projectfilter.model.OnCategoryUpdateListener;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: Taobao */
/* loaded from: classes6.dex */
public final class zg extends cn.damai.projectfilter.floatview.a<CategoryDataAssembler> {
    private static transient /* synthetic */ IpChange $ipChange;
    @NotNull
    private final CategoryDataAssembler d;
    @Nullable
    private View e;
    @NotNull
    private final CategoryMainAdapter f;
    @NotNull
    private final CategorySubAdapter g;
    private long h;
    @Nullable
    private View i;

    /* compiled from: Taobao */
    /* loaded from: classes6.dex */
    public static final class a implements OnCategoryUpdateListener {
        private static transient /* synthetic */ IpChange $ipChange;

        a() {
        }

        @Override // cn.damai.projectfilter.model.OnCategoryUpdateListener
        public void categoryUpdate(@NotNull CategoryUpdate categoryUpdate) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "703115376")) {
                ipChange.ipc$dispatch("703115376", new Object[]{this, categoryUpdate});
                return;
            }
            b41.i(categoryUpdate, "update");
            zg.this.f.c(categoryUpdate.getCloneOneList());
            zg.this.g.c(categoryUpdate.getCloneTwoList());
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public zg(@Nullable Context context, @NotNull CategoryDataAssembler categoryDataAssembler) {
        super(context);
        b41.i(categoryDataAssembler, "mDataAssembler");
        this.d = categoryDataAssembler;
        categoryDataAssembler.setMListener(new a());
        this.f = new CategoryMainAdapter(context, new CategoryMainAdapter.OnCategoryMainListener() { // from class: tb.wg
            @Override // cn.damai.projectfilter.adapter.CategoryMainAdapter.OnCategoryMainListener
            public final void onSubClick(int i, CategoryLevelOne categoryLevelOne) {
                zg.j(zg.this, i, categoryLevelOne);
            }
        });
        this.g = new CategorySubAdapter(context, new CategorySubAdapter.OnCategorySubListener() { // from class: tb.xg
            @Override // cn.damai.projectfilter.adapter.CategorySubAdapter.OnCategorySubListener
            public final void onSubClick(int i, CategoryLevelTwo categoryLevelTwo) {
                zg.k(zg.this, i, categoryLevelTwo);
            }
        });
    }

    private final void g() {
        View findViewById;
        View findViewById2;
        RecyclerView recyclerView;
        RecyclerView recyclerView2;
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1776631789")) {
            ipChange.ipc$dispatch("1776631789", new Object[]{this});
        } else if (this.e == null) {
            View inflate = LayoutInflater.from(this.a).inflate(R$layout.item_filter_category_float_new, (ViewGroup) null);
            this.e = inflate;
            if (inflate != null && (recyclerView2 = (RecyclerView) inflate.findViewById(R$id.float_category_list_main_lv)) != null) {
                recyclerView2.setAdapter(this.f);
                recyclerView2.setLayoutManager(new LinearLayoutManager(this.a, 1, false));
            }
            View view = this.e;
            if (view != null && (recyclerView = (RecyclerView) view.findViewById(R$id.float_category_list_sub_lv)) != null) {
                recyclerView.setAdapter(this.g);
                recyclerView.setLayoutManager(new LinearLayoutManager(this.a, 1, false));
            }
            View view2 = this.e;
            if (view2 != null && (findViewById2 = view2.findViewById(R$id.item_filter_reset)) != null) {
                findViewById2.setOnClickListener(new View.OnClickListener() { // from class: tb.ug
                    @Override // android.view.View.OnClickListener
                    public final void onClick(View view3) {
                        zg.i(zg.this, view3);
                    }
                });
            }
            View view3 = this.e;
            if (view3 == null || (findViewById = view3.findViewById(R$id.item_filter_confirm)) == null) {
                return;
            }
            findViewById.setOnClickListener(new View.OnClickListener() { // from class: tb.vg
                @Override // android.view.View.OnClickListener
                public final void onClick(View view4) {
                    zg.h(zg.this, view4);
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void h(zg zgVar, View view) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1369587783")) {
            ipChange.ipc$dispatch("1369587783", new Object[]{zgVar, view});
            return;
        }
        b41.i(zgVar, "this$0");
        zgVar.i = view;
        zgVar.d.doConfirm();
        lj0 filterUt = zgVar.getFilterUt();
        if (filterUt != null) {
            filterUt.i("confirm");
        }
        FloatListener listener = zgVar.getListener();
        Type type = Type.NEW_CATEGORY;
        FilterData filterData = new FilterData();
        filterData.mNewCategorySelected = zgVar.d.getSelect4Request();
        wt2 wt2Var = wt2.INSTANCE;
        listener.onFloatCall(type, filterData);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void i(zg zgVar, View view) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "316692236")) {
            ipChange.ipc$dispatch("316692236", new Object[]{zgVar, view});
            return;
        }
        b41.i(zgVar, "this$0");
        zgVar.d.doReset(true);
        lj0 filterUt = zgVar.getFilterUt();
        if (filterUt != null) {
            filterUt.i("reset");
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void j(zg zgVar, int i, CategoryLevelOne categoryLevelOne) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1257660046")) {
            ipChange.ipc$dispatch("1257660046", new Object[]{zgVar, Integer.valueOf(i), categoryLevelOne});
            return;
        }
        b41.i(zgVar, "this$0");
        CategoryDataAssembler categoryDataAssembler = zgVar.d;
        b41.h(categoryLevelOne, "mainBean");
        categoryDataAssembler.selectOne(categoryLevelOne, true);
        lj0 filterUt = zgVar.getFilterUt();
        if (filterUt != null) {
            filterUt.o(categoryLevelOne, i);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void k(zg zgVar, int i, CategoryLevelTwo categoryLevelTwo) {
        lj0 filterUt;
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "2111716566")) {
            ipChange.ipc$dispatch("2111716566", new Object[]{zgVar, Integer.valueOf(i), categoryLevelTwo});
            return;
        }
        b41.i(zgVar, "this$0");
        CategoryDataAssembler categoryDataAssembler = zgVar.d;
        b41.h(categoryLevelTwo, "subBean");
        if (!categoryDataAssembler.selectTwo(categoryLevelTwo, true) || (filterUt = zgVar.getFilterUt()) == null) {
            return;
        }
        filterUt.p(categoryLevelTwo, i, zgVar.d.indexOneSelect());
    }

    @Override // cn.damai.projectfilter.floatview.FloatLayer
    @NotNull
    public Type getType() {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "-77463312") ? (Type) ipChange.ipc$dispatch("-77463312", new Object[]{this}) : Type.NEW_CATEGORY;
    }

    @Override // cn.damai.projectfilter.floatview.FloatLayer
    @Nullable
    public View getView() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1239560588")) {
            return (View) ipChange.ipc$dispatch("1239560588", new Object[]{this});
        }
        if (this.e == null) {
            g();
        }
        return this.e;
    }

    @Override // cn.damai.projectfilter.floatview.FloatLayer
    public void hide() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-472856669")) {
            ipChange.ipc$dispatch("-472856669", new Object[]{this});
            return;
        }
        View view = this.i;
        if (view != null) {
            long currentTimeMillis = System.currentTimeMillis() - this.h;
            lj0 filterUt = getFilterUt();
            if (filterUt != null) {
                filterUt.s(view, currentTimeMillis);
            }
        }
    }

    @Override // cn.damai.projectfilter.floatview.FloatLayer
    /* renamed from: l */
    public void show(@Nullable CategoryDataAssembler categoryDataAssembler) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1461732766")) {
            ipChange.ipc$dispatch("1461732766", new Object[]{this, categoryDataAssembler});
            return;
        }
        this.h = System.currentTimeMillis();
        g();
        if (categoryDataAssembler != null) {
            categoryDataAssembler.doMatchIfNeed();
            CategoryUpdate update = categoryDataAssembler.getUpdate();
            this.f.c(update.getCloneOneList());
            this.g.c(update.getCloneTwoList());
        }
    }
}
