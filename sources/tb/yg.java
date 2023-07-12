package tb;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import cn.damai.projectfiltercopy.FloatListener;
import cn.damai.projectfiltercopy.adapter.CategoryMainAdapter;
import cn.damai.projectfiltercopy.adapter.CategorySubAdapter;
import cn.damai.projectfiltercopy.bean.CategoryLevelOne;
import cn.damai.projectfiltercopy.bean.CategoryLevelTwo;
import cn.damai.projectfiltercopy.bean.FilterData;
import cn.damai.projectfiltercopy.bean.Type;
import cn.damai.projectfiltercopy.model.CategoryDataAssembler;
import cn.damai.projectfiltercopy.model.CategoryUpdate;
import cn.damai.projectfiltercopy.model.OnCategoryUpdateListener;
import com.alibaba.pictures.R$id;
import com.alibaba.pictures.R$layout;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: Taobao */
/* loaded from: classes6.dex */
public final class yg extends cn.damai.projectfiltercopy.floatview.a<CategoryDataAssembler> {
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

        @Override // cn.damai.projectfiltercopy.model.OnCategoryUpdateListener
        public void categoryUpdate(@NotNull CategoryUpdate categoryUpdate) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "-574964016")) {
                ipChange.ipc$dispatch("-574964016", new Object[]{this, categoryUpdate});
                return;
            }
            b41.i(categoryUpdate, "update");
            yg.this.f.c(categoryUpdate.getCloneOneList());
            yg.this.g.c(categoryUpdate.getCloneTwoList());
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public yg(@Nullable Context context, @NotNull CategoryDataAssembler categoryDataAssembler) {
        super(context);
        b41.i(categoryDataAssembler, "mDataAssembler");
        this.d = categoryDataAssembler;
        categoryDataAssembler.setMListener(new a());
        this.f = new CategoryMainAdapter(context, new CategoryMainAdapter.OnCategoryMainListener() { // from class: tb.sg
            @Override // cn.damai.projectfiltercopy.adapter.CategoryMainAdapter.OnCategoryMainListener
            public final void onSubClick(int i, CategoryLevelOne categoryLevelOne) {
                yg.j(yg.this, i, categoryLevelOne);
            }
        });
        this.g = new CategorySubAdapter(context, new CategorySubAdapter.OnCategorySubListener() { // from class: tb.tg
            @Override // cn.damai.projectfiltercopy.adapter.CategorySubAdapter.OnCategorySubListener
            public final void onSubClick(int i, CategoryLevelTwo categoryLevelTwo) {
                yg.k(yg.this, i, categoryLevelTwo);
            }
        });
    }

    private final void g() {
        View findViewById;
        View findViewById2;
        RecyclerView recyclerView;
        RecyclerView recyclerView2;
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1670498530")) {
            ipChange.ipc$dispatch("1670498530", new Object[]{this});
        } else if (this.e == null) {
            View inflate = LayoutInflater.from(this.a).inflate(R$layout.copy_item_filter_category_float_new, (ViewGroup) null);
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
                findViewById2.setOnClickListener(new View.OnClickListener() { // from class: tb.rg
                    @Override // android.view.View.OnClickListener
                    public final void onClick(View view3) {
                        yg.i(yg.this, view3);
                    }
                });
            }
            View view3 = this.e;
            if (view3 == null || (findViewById = view3.findViewById(R$id.item_filter_confirm)) == null) {
                return;
            }
            findViewById.setOnClickListener(new View.OnClickListener() { // from class: tb.qg
                @Override // android.view.View.OnClickListener
                public final void onClick(View view4) {
                    yg.h(yg.this, view4);
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void h(yg ygVar, View view) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "770259239")) {
            ipChange.ipc$dispatch("770259239", new Object[]{ygVar, view});
            return;
        }
        b41.i(ygVar, "this$0");
        ygVar.i = view;
        ygVar.d.doConfirm();
        kj0 filterUt = ygVar.getFilterUt();
        if (filterUt != null) {
            filterUt.f("confirm");
        }
        FloatListener listener = ygVar.getListener();
        Type type = Type.NEW_CATEGORY;
        FilterData filterData = new FilterData();
        filterData.mNewCategorySelected = ygVar.d.getSelect4Request();
        wt2 wt2Var = wt2.INSTANCE;
        listener.onFloatCall(type, filterData);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void i(yg ygVar, View view) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-32879946")) {
            ipChange.ipc$dispatch("-32879946", new Object[]{ygVar, view});
            return;
        }
        b41.i(ygVar, "this$0");
        ygVar.d.doReset(true);
        kj0 filterUt = ygVar.getFilterUt();
        if (filterUt != null) {
            filterUt.f("reset");
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void j(yg ygVar, int i, CategoryLevelOne categoryLevelOne) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-48638045")) {
            ipChange.ipc$dispatch("-48638045", new Object[]{ygVar, Integer.valueOf(i), categoryLevelOne});
            return;
        }
        b41.i(ygVar, "this$0");
        CategoryDataAssembler categoryDataAssembler = ygVar.d;
        b41.h(categoryLevelOne, "mainBean");
        categoryDataAssembler.selectOne(categoryLevelOne, true);
        kj0 filterUt = ygVar.getFilterUt();
        if (filterUt != null) {
            filterUt.m(categoryLevelOne, i);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void k(yg ygVar, int i, CategoryLevelTwo categoryLevelTwo) {
        kj0 filterUt;
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-10414879")) {
            ipChange.ipc$dispatch("-10414879", new Object[]{ygVar, Integer.valueOf(i), categoryLevelTwo});
            return;
        }
        b41.i(ygVar, "this$0");
        CategoryDataAssembler categoryDataAssembler = ygVar.d;
        b41.h(categoryLevelTwo, "subBean");
        if (!categoryDataAssembler.selectTwo(categoryLevelTwo, true) || (filterUt = ygVar.getFilterUt()) == null) {
            return;
        }
        filterUt.n(categoryLevelTwo, i, ygVar.d.indexOneSelect());
    }

    @Override // cn.damai.projectfiltercopy.floatview.FloatLayer
    @NotNull
    public Type getType() {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "565404176") ? (Type) ipChange.ipc$dispatch("565404176", new Object[]{this}) : Type.NEW_CATEGORY;
    }

    @Override // cn.damai.projectfiltercopy.floatview.FloatLayer
    @Nullable
    public View getView() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "519571575")) {
            return (View) ipChange.ipc$dispatch("519571575", new Object[]{this});
        }
        if (this.e == null) {
            g();
        }
        return this.e;
    }

    @Override // cn.damai.projectfiltercopy.floatview.FloatLayer
    public void hide() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1166928936")) {
            ipChange.ipc$dispatch("-1166928936", new Object[]{this});
            return;
        }
        View view = this.i;
        if (view != null) {
            long currentTimeMillis = System.currentTimeMillis() - this.h;
            kj0 filterUt = getFilterUt();
            if (filterUt != null) {
                filterUt.q(view, currentTimeMillis);
            }
        }
    }

    @Override // cn.damai.projectfiltercopy.floatview.FloatLayer
    /* renamed from: l */
    public void show(@Nullable CategoryDataAssembler categoryDataAssembler) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-2128110530")) {
            ipChange.ipc$dispatch("-2128110530", new Object[]{this, categoryDataAssembler});
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
