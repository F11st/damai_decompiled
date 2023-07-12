package tb;

import com.alibaba.yymidservice.popup.request.bean.PopupDetailBean;
import com.alibaba.yymidservice.popup.request.bean.PopupResponseBean;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.Map;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: Taobao */
/* loaded from: classes8.dex */
public final class ct1 {
    @NotNull
    public static final C9015a Companion = new C9015a(null);
    @Nullable
    private static ct1 f;
    @Nullable
    private ArrayList<String> c;
    @Nullable
    private ArrayList<String> d;
    @NotNull
    private Map<String, PopupResponseBean> a = new LinkedHashMap();
    @NotNull
    private Map<String, Boolean> b = new LinkedHashMap();
    @NotNull
    private Map<String, ArrayList<PopupDetailBean>> e = new LinkedHashMap();

    /* compiled from: Taobao */
    /* renamed from: tb.ct1$a */
    /* loaded from: classes8.dex */
    public static final class C9015a {
        private C9015a() {
        }

        public /* synthetic */ C9015a(k50 k50Var) {
            this();
        }

        @NotNull
        public final synchronized ct1 a() {
            ct1 ct1Var;
            if (ct1.f == null) {
                ct1.f = new ct1();
            }
            ct1Var = ct1.f;
            b41.f(ct1Var);
            return ct1Var;
        }
    }

    @Nullable
    public final synchronized ArrayList<PopupDetailBean> c(@NotNull String str) {
        b41.i(str, "cacheKey");
        if (this.e.containsKey(str)) {
            return this.e.get(str);
        }
        return null;
    }

    @NotNull
    public final Map<String, PopupResponseBean> d() {
        return this.a;
    }

    @Nullable
    public final ArrayList<String> e() {
        return this.d;
    }

    @Nullable
    public final ArrayList<String> f() {
        return this.c;
    }

    public final synchronized void g(@NotNull String str) {
        b41.i(str, "cacheKey");
        h(str);
        i(str);
    }

    public final synchronized void h(@NotNull String str) {
        b41.i(str, "cacheKey");
        if (this.a.containsKey(str)) {
            this.a.remove(str);
        }
    }

    public final synchronized void i(@NotNull String str) {
        b41.i(str, "cacheKey");
        if (this.b.containsKey(str)) {
            this.b.remove(str);
        }
    }

    public final synchronized void j(@NotNull String str, @Nullable ArrayList<PopupDetailBean> arrayList) {
        b41.i(str, "cacheKey");
        if (arrayList != null && arrayList.size() > 0) {
            this.e.put(str, arrayList);
        }
    }

    public final void k(@Nullable ArrayList<String> arrayList) {
        this.d = arrayList;
    }

    public final void l(@Nullable ArrayList<String> arrayList) {
        this.c = arrayList;
    }
}
