package tb;

import android.content.Context;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.alibaba.android.ultron.vfw.adapter.RecyclerViewAdapter;
import com.alibaba.android.ultron.vfw.core.IServiceManager;
import com.alibaba.android.ultron.vfw.event.ComponentLifecycleCallback;
import com.alibaba.android.ultron.vfw.event.OnDynamicEventListener;
import com.alibaba.android.ultron.vfw.template.TemplateDownloadListener;
import com.alibaba.android.ultron.vfw.viewholder.IViewHolderCreator;
import com.alibaba.android.ultron.vfw.viewholder.RecyclerViewHolder;
import com.alibaba.android.ultron.vfw.web.IWebEventBridge;
import com.taobao.android.ultron.common.model.IDMComponent;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;

/* compiled from: Taobao */
/* loaded from: classes6.dex */
public class ay2 implements IServiceManager {
    public static final int ALL = 7;
    public static final int BODY = 2;
    public static final int FOOTER = 4;
    public static final int HEADER = 1;
    public static final String KEY_VIEW_ENGINE = "ViewEngine";
    private Context a;
    private RecyclerViewAdapter b;
    private RecyclerView c;
    private ViewGroup d;
    private ViewGroup e;
    private h30 f;
    private cy2 g;
    private vl2 h;
    private Map<Class<?>, Object> i;
    private List<RecyclerViewHolder> j;
    private List<RecyclerViewHolder> k;
    private IDMComponent l;
    private IDMComponent m;
    private int n;
    private int o;
    private RecyclerViewHolder p;
    private RecyclerViewHolder q;
    private String r;
    private Map<String, Object> s;
    private TemplateDownloadListener t;
    private i90 u;
    private Map<String, IWebEventBridge> v;
    private String w;
    private int x;

    /* compiled from: Taobao */
    /* loaded from: classes6.dex */
    class a extends RecyclerView.OnScrollListener {
        a() {
        }

        @Override // androidx.recyclerview.widget.RecyclerView.OnScrollListener
        public void onScrolled(RecyclerView recyclerView, int i, int i2) {
            super.onScrolled(recyclerView, i, i2);
            RecyclerView.LayoutManager layoutManager = recyclerView.getLayoutManager();
            if (layoutManager instanceof LinearLayoutManager) {
                int findFirstVisibleItemPosition = ((LinearLayoutManager) layoutManager).findFirstVisibleItemPosition();
                if (findFirstVisibleItemPosition > ay2.this.n) {
                    ay2 ay2Var = ay2.this;
                    ay2Var.K(ay2Var.p);
                } else {
                    ay2 ay2Var2 = ay2.this;
                    ay2Var2.q(ay2Var2.p);
                }
                if (findFirstVisibleItemPosition > ay2.this.o) {
                    ay2 ay2Var3 = ay2.this;
                    ay2Var3.K(ay2Var3.q);
                    return;
                }
                ay2 ay2Var4 = ay2.this;
                ay2Var4.q(ay2Var4.q);
            }
        }
    }

    public ay2(Context context) {
        this(context, "ultron");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void K(RecyclerViewHolder recyclerViewHolder) {
        View view;
        if (recyclerViewHolder == null || (view = recyclerViewHolder.itemView) == null) {
            return;
        }
        view.setVisibility(0);
    }

    private void j() {
        HashMap hashMap = new HashMap();
        for (kd0 kd0Var : this.f.b()) {
            String str = kd0Var.b;
            if (!TextUtils.equals("native", str)) {
                if (hashMap.containsKey(str)) {
                    ((List) hashMap.get(str)).add(kd0Var);
                } else {
                    ArrayList arrayList = new ArrayList();
                    arrayList.add(kd0Var);
                    hashMap.put(str, arrayList);
                }
            }
        }
        if (hashMap.isEmpty()) {
            return;
        }
        for (Map.Entry entry : hashMap.entrySet()) {
            this.h.a((String) entry.getKey(), (List) entry.getValue(), this.t);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void q(RecyclerViewHolder recyclerViewHolder) {
        View view;
        if (recyclerViewHolder == null || (view = recyclerViewHolder.itemView) == null) {
            return;
        }
        view.setVisibility(8);
    }

    private void s() {
        this.b.setData(this.f.a());
        this.b.notifyDataSetChanged();
    }

    private void t() {
        ViewGroup viewGroup = this.e;
        if (viewGroup != null) {
            if (viewGroup.getChildCount() > 0) {
                this.e.removeAllViews();
            }
            if (this.k.size() > 0) {
                this.k.clear();
            }
            List<IDMComponent> c = this.f.c();
            if (c == null || c.size() <= 0) {
                return;
            }
            for (IDMComponent iDMComponent : c) {
                RecyclerViewHolder c2 = this.g.c(this.e, this.g.f(iDMComponent));
                View view = c2.itemView;
                if (view != null) {
                    this.e.addView(view);
                    this.k.add(c2);
                }
                this.g.b(c2, iDMComponent);
                if (iDMComponent == this.m) {
                    this.q = c2;
                    q(c2);
                }
            }
        }
    }

    private void u() {
        ViewGroup viewGroup = this.d;
        if (viewGroup == null) {
            return;
        }
        if (viewGroup.getChildCount() > 0) {
            this.d.removeAllViews();
        }
        if (this.j.size() > 0) {
            this.j.clear();
        }
        List<IDMComponent> d = this.f.d();
        if (d == null || d.isEmpty()) {
            return;
        }
        for (IDMComponent iDMComponent : d) {
            RecyclerViewHolder c = this.g.c(this.d, this.g.f(iDMComponent));
            View view = c.itemView;
            if (view != null) {
                this.d.addView(view);
                this.j.add(c);
            }
            this.g.b(c, iDMComponent);
            if (iDMComponent == this.l) {
                this.p = c;
                q(c);
            }
        }
    }

    private void w() {
        this.b.notifyDataSetChanged();
    }

    private void x() {
        List<IDMComponent> c = this.f.c();
        for (int i = 0; i < c.size(); i++) {
            this.g.b(this.k.get(i), c.get(i));
        }
    }

    private void y() {
        List<IDMComponent> d = this.f.d();
        for (int i = 0; i < d.size(); i++) {
            this.g.b(this.j.get(i), d.get(i));
        }
    }

    public void A(String str, IViewHolderCreator iViewHolderCreator) {
        this.g.i(str, iViewHolderCreator);
    }

    public void B(String str, IWebEventBridge iWebEventBridge) {
        if (this.v == null) {
            this.v = new HashMap();
        }
        this.v.put(str, iWebEventBridge);
    }

    public void C(int i) {
        this.c.getLayoutManager().scrollToPosition(i);
    }

    public void D(RecyclerViewAdapter recyclerViewAdapter) {
        RecyclerView recyclerView = this.c;
        Objects.requireNonNull(recyclerView, "The bindViewTree method must be called before setAdapter method.");
        this.b = recyclerViewAdapter;
        recyclerView.setAdapter(recyclerViewAdapter);
    }

    public void E(String str) {
        this.w = str;
    }

    public void F(ComponentLifecycleCallback componentLifecycleCallback) {
        this.g.k(componentLifecycleCallback);
    }

    public void G(h30 h30Var) {
        this.f = h30Var;
    }

    public void H(int i, IDMComponent iDMComponent) {
        this.o = i;
        this.m = iDMComponent;
    }

    public void I(int i, IDMComponent iDMComponent) {
        this.n = i;
        this.l = iDMComponent;
    }

    public void J(int i) {
        this.x = i;
    }

    public void g(String str, Object obj) {
        if (TextUtils.isEmpty(str)) {
            return;
        }
        this.s.put(str, obj);
    }

    @Override // com.alibaba.android.ultron.vfw.core.IServiceManager
    public <T> T getService(@NonNull Class<T> cls) {
        Object obj = this.i.get(cls);
        if (obj != null) {
            return cls.cast(obj);
        }
        return null;
    }

    public void h(LinearLayout linearLayout, @NonNull RecyclerView recyclerView, LinearLayout linearLayout2) {
        this.d = linearLayout;
        this.c = recyclerView;
        recyclerView.addOnScrollListener(new a());
        this.e = linearLayout2;
    }

    public void i() {
        cy2 cy2Var = this.g;
        if (cy2Var != null) {
            cy2Var.d();
        }
    }

    public String k() {
        return this.w;
    }

    public Context l() {
        return this.a;
    }

    public Map<String, Object> m() {
        return this.s;
    }

    public i90 n() {
        return this.u;
    }

    public int o() {
        return this.x;
    }

    public String p() {
        return this.r;
    }

    public void r(int i) {
        co2.c(co2.KEY_ULTRON_PROFILE, "viewengine rebuild start");
        co2.e("ViewEngine.rebuild", "viewengine rebuild start");
        j();
        co2.c("ViewEngine.rebuild", "download template");
        if ((i & 1) != 0) {
            u();
        }
        co2.c("ViewEngine.rebuild", "rebuildHeader");
        if ((i & 2) != 0) {
            s();
        }
        co2.c("ViewEngine.rebuild", "rebuildBody");
        if ((i & 4) != 0) {
            t();
        }
        co2.a("ViewEngine.rebuild", "rebuildFooter");
        co2.c(co2.KEY_ULTRON_PROFILE, "viewengine rebuild end");
    }

    @Override // com.alibaba.android.ultron.vfw.core.IServiceManager
    public <T> void registerService(@NonNull Class<T> cls, @NonNull T t) {
        this.i.put(cls, t);
    }

    public void v(int i) {
        if ((i & 1) != 0) {
            y();
        }
        if ((i & 2) != 0) {
            w();
        }
        if ((i & 4) != 0) {
            x();
        }
    }

    public void z(OnDynamicEventListener onDynamicEventListener) {
        registerService(OnDynamicEventListener.class, onDynamicEventListener);
    }

    public ay2(Context context, String str) {
        this.i = new HashMap();
        this.j = new ArrayList();
        this.k = new ArrayList();
        this.n = -1;
        this.o = -1;
        this.r = "ultron";
        this.w = "default";
        this.a = context;
        this.r = str;
        this.u = i90.c(this);
        cy2 cy2Var = new cy2(this);
        this.g = cy2Var;
        registerService(cy2.class, cy2Var);
        vl2 vl2Var = new vl2(this);
        this.h = vl2Var;
        registerService(vl2.class, vl2Var);
        HashMap hashMap = new HashMap();
        this.s = hashMap;
        hashMap.put(KEY_VIEW_ENGINE, this);
        this.f = new h30();
    }
}
