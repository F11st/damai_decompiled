package tb;

import android.view.View;
import androidx.constraintlayout.core.motion.utils.TypedValues;
import cn.damai.common.user.C0528b;
import cn.damai.common.user.C0529c;
import cn.damai.rank.RankSquareCMSActivity;
import cn.damai.tetris.component.rank.bean.CategoryTabBean;
import cn.damai.tetris.component.rank.bean.TypeTabBean;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import java.util.HashMap;
import org.jetbrains.annotations.NotNull;

/* compiled from: Taobao */
/* loaded from: classes7.dex */
public final class bz1 extends C0528b {
    private static transient /* synthetic */ IpChange $ipChange;
    @NotNull
    public static final C8984a Instance = new C8984a(null);
    @NotNull
    private final String b;
    @NotNull
    private final String c;

    /* compiled from: Taobao */
    /* renamed from: tb.bz1$a */
    /* loaded from: classes7.dex */
    public static final class C8984a {
        private static transient /* synthetic */ IpChange $ipChange;

        private C8984a() {
        }

        public /* synthetic */ C8984a(k50 k50Var) {
            this();
        }

        public final void a(@NotNull View view, @NotNull String str) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "32934109")) {
                ipChange.ipc$dispatch("32934109", new Object[]{this, view, str});
                return;
            }
            b41.i(view, "cityBtn");
            b41.i(str, RankSquareCMSActivity.PRESET_CITY_NAME);
            HashMap<String, String> g = d23.g();
            d23.h(g, "city", str);
            C0529c.e().G(view, "city", "top", "ranklist_square", g);
        }

        public final void b(@NotNull String str) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "-588274388")) {
                ipChange.ipc$dispatch("-588274388", new Object[]{this, str});
                return;
            }
            b41.i(str, RankSquareCMSActivity.PRESET_CITY_NAME);
            HashMap<String, String> g = d23.g();
            d23.h(g, "city", str);
            C0529c.e().x(new bz1("ranklist_square", str).e("ranklist_square", "top", "city", g, Boolean.TRUE));
        }
    }

    public bz1(@NotNull String str, @NotNull String str2) {
        b41.i(str, "mSpmB");
        b41.i(str2, "mCityName");
        this.b = str;
        this.c = str2;
    }

    public final void f(@NotNull View view, @NotNull CategoryTabBean categoryTabBean) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1276314263")) {
            ipChange.ipc$dispatch("-1276314263", new Object[]{this, view, categoryTabBean});
            return;
        }
        b41.i(view, "view");
        b41.i(categoryTabBean, "tabBean");
        HashMap<String, String> g = d23.g();
        d23.h(g, "city", this.c);
        C0529c e = C0529c.e();
        e.G(view, "category_" + categoryTabBean.pos, "category", this.b, g);
    }

    public final void g(@NotNull View view, int i, @NotNull TypeTabBean typeTabBean) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "400159661")) {
            ipChange.ipc$dispatch("400159661", new Object[]{this, view, Integer.valueOf(i), typeTabBean});
            return;
        }
        b41.i(view, "view");
        b41.i(typeTabBean, "weiDu");
        HashMap<String, String> g = d23.g();
        d23.h(g, "city", this.c);
        d23.h(g, "titlelabel", typeTabBean.name);
        C0529c e = C0529c.e();
        e.G(view, "category_" + i + "_dimension_" + typeTabBean.pos, TypedValues.Custom.S_DIMENSION, this.b, g);
    }

    public final void h(@NotNull CategoryTabBean categoryTabBean, int i) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-549471375")) {
            ipChange.ipc$dispatch("-549471375", new Object[]{this, categoryTabBean, Integer.valueOf(i)});
            return;
        }
        b41.i(categoryTabBean, "tabBean");
        HashMap<String, String> g = d23.g();
        d23.h(g, "city", this.c);
        d23.h(g, "titlelabel", categoryTabBean.name);
        String str = this.b;
        C0529c.e().x(e(str, "category", "category_" + i, g, Boolean.FALSE));
    }

    public final void i(@NotNull CategoryTabBean categoryTabBean, @NotNull TypeTabBean typeTabBean) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "896152324")) {
            ipChange.ipc$dispatch("896152324", new Object[]{this, categoryTabBean, typeTabBean});
            return;
        }
        b41.i(categoryTabBean, "tabBean");
        b41.i(typeTabBean, "weiDu");
        HashMap<String, String> g = d23.g();
        d23.h(g, "city", this.c);
        d23.h(g, "titlelabel", typeTabBean.name);
        String str = this.b;
        C0529c.e().x(e(str, TypedValues.Custom.S_DIMENSION, "category_" + categoryTabBean.pos + "_dimension_" + typeTabBean.pos, g, Boolean.FALSE));
    }
}
