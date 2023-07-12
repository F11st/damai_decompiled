package tb;

import android.annotation.SuppressLint;
import android.content.Context;
import android.util.Log;
import com.alibaba.pictures.dolores.business.IDoloresRequestRouter;
import com.alibaba.pictures.dolores.business.IRequestInterceptor;
import com.alibaba.pictures.dolores.cache.ICacheManager;
import com.alibaba.pictures.dolores.config.IGlobalConfig;
import com.alibaba.pictures.dolores.convert.IJSONConverter;
import com.alibaba.pictures.dolores.log.IDoloresLog;
import com.alibaba.pictures.dolores.login.IDoloresLoginDelegate;
import com.alibaba.pictures.dolores.time.TimeSyncer;
import com.alibaba.pictures.dolores.transfer.IDataTransformerFactory;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import io.flutter.wpkbridge.WPKFactory;
import kotlin.jvm.JvmStatic;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: Taobao */
/* loaded from: classes7.dex */
public final class sb0 {
    private static transient /* synthetic */ IpChange $ipChange;
    @NotNull
    public static final a Companion = new a(null);
    @NotNull
    private static final String g = "DoloresBusiness";
    @Nullable
    private static IRequestInterceptor h;
    @Nullable
    private static IDoloresLoginDelegate i;
    private static boolean j;
    @Nullable
    private static IJSONConverter k;
    @Nullable
    private static IGlobalConfig l;
    @SuppressLint({"StaticFieldLeak"})
    private static sb0 m;
    @Nullable
    private IDoloresLog a;
    @Nullable
    private IDoloresRequestRouter b;
    @Nullable
    private String c;
    @Nullable
    private ICacheManager d;
    @Nullable
    private IDataTransformerFactory e;
    @NotNull
    private Context f;

    /* compiled from: Taobao */
    /* loaded from: classes7.dex */
    public static final class a {
        private static transient /* synthetic */ IpChange $ipChange;

        private a() {
        }

        @Nullable
        public final IGlobalConfig a() {
            IpChange ipChange = $ipChange;
            return AndroidInstantRuntime.support(ipChange, "1939972191") ? (IGlobalConfig) ipChange.ipc$dispatch("1939972191", new Object[]{this}) : sb0.l;
        }

        @Nullable
        public final IRequestInterceptor b() {
            IpChange ipChange = $ipChange;
            return AndroidInstantRuntime.support(ipChange, "-259709427") ? (IRequestInterceptor) ipChange.ipc$dispatch("-259709427", new Object[]{this}) : sb0.h;
        }

        @Nullable
        public final IJSONConverter c() {
            IpChange ipChange = $ipChange;
            return AndroidInstantRuntime.support(ipChange, "-1600585625") ? (IJSONConverter) ipChange.ipc$dispatch("-1600585625", new Object[]{this}) : sb0.k;
        }

        @Nullable
        public final IDoloresLoginDelegate d() {
            IpChange ipChange = $ipChange;
            return AndroidInstantRuntime.support(ipChange, "974524155") ? (IDoloresLoginDelegate) ipChange.ipc$dispatch("974524155", new Object[]{this}) : sb0.i;
        }

        @NotNull
        public final String e() {
            IpChange ipChange = $ipChange;
            return AndroidInstantRuntime.support(ipChange, "-1882574933") ? (String) ipChange.ipc$dispatch("-1882574933", new Object[]{this}) : sb0.g;
        }

        @JvmStatic
        @NotNull
        public final sb0 f(@NotNull Context context) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "-767519414")) {
                return (sb0) ipChange.ipc$dispatch("-767519414", new Object[]{this, context});
            }
            b41.i(context, WPKFactory.INIT_KEY_CONTEXT);
            Log.d(e(), "init: ");
            if (sb0.m == null) {
                sb0.m = new sb0(context, null);
            }
            TimeSyncer.INSTANCE.h(context);
            sb0 sb0Var = sb0.m;
            b41.f(sb0Var);
            return sb0Var;
        }

        @JvmStatic
        @NotNull
        public final sb0 g() {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "1210723365")) {
                return (sb0) ipChange.ipc$dispatch("1210723365", new Object[]{this});
            }
            if (sb0.m != null) {
                sb0 sb0Var = sb0.m;
                b41.f(sb0Var);
                return sb0Var;
            }
            throw new RuntimeException("DoloresManager need init with context first!");
        }

        public /* synthetic */ a(k50 k50Var) {
            this();
        }
    }

    private sb0(Context context) {
        this.f = context;
    }

    @JvmStatic
    @NotNull
    public static final sb0 o(@NotNull Context context) {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "1993743362") ? (sb0) ipChange.ipc$dispatch("1993743362", new Object[]{context}) : Companion.f(context);
    }

    @JvmStatic
    @NotNull
    public static final sb0 p() {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "-195108243") ? (sb0) ipChange.ipc$dispatch("-195108243", new Object[0]) : Companion.g();
    }

    public static final void q(@Nullable IGlobalConfig iGlobalConfig) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "2041279625")) {
            ipChange.ipc$dispatch("2041279625", new Object[]{iGlobalConfig});
        } else {
            l = iGlobalConfig;
        }
    }

    public static final void r(@Nullable IRequestInterceptor iRequestInterceptor) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "347784541")) {
            ipChange.ipc$dispatch("347784541", new Object[]{iRequestInterceptor});
        } else {
            h = iRequestInterceptor;
        }
    }

    public static final void s(boolean z) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "54649832")) {
            ipChange.ipc$dispatch("54649832", new Object[]{Boolean.valueOf(z)});
        } else {
            j = z;
        }
    }

    public static final void t(@Nullable IDoloresLoginDelegate iDoloresLoginDelegate) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1464403253")) {
            ipChange.ipc$dispatch("-1464403253", new Object[]{iDoloresLoginDelegate});
        } else {
            i = iDoloresLoginDelegate;
        }
    }

    @Nullable
    public final ICacheManager h() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1648144868")) {
            return (ICacheManager) ipChange.ipc$dispatch("-1648144868", new Object[]{this});
        }
        if (this.d == null) {
            this.d = g50.Companion.a(this.f, "dolorescache.db", "dolorestable", 1, -1L);
        }
        return this.d;
    }

    @NotNull
    public final Context i() {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "650355728") ? (Context) ipChange.ipc$dispatch("650355728", new Object[]{this}) : this.f;
    }

    @Nullable
    public final IDataTransformerFactory j() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-235264477")) {
            return (IDataTransformerFactory) ipChange.ipc$dispatch("-235264477", new Object[]{this});
        }
        if (this.e == null) {
            this.e = new l50();
        }
        return this.e;
    }

    @Nullable
    public final String k(@NotNull IGlobalConfig.Key key, @Nullable String str) {
        String globalConfig;
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-665798715")) {
            return (String) ipChange.ipc$dispatch("-665798715", new Object[]{this, key, str});
        }
        b41.i(key, "key");
        IGlobalConfig iGlobalConfig = l;
        return (iGlobalConfig == null || (globalConfig = iGlobalConfig.getGlobalConfig(key, str)) == null) ? str : globalConfig;
    }

    @Nullable
    public final IDoloresLog l() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-154576584")) {
            return (IDoloresLog) ipChange.ipc$dispatch("-154576584", new Object[]{this});
        }
        if (this.a == null) {
            yb0 yb0Var = new yb0();
            yb0Var.a(j);
            wt2 wt2Var = wt2.INSTANCE;
            this.a = yb0Var;
        }
        return this.a;
    }

    @Nullable
    public final IDoloresRequestRouter m() {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "-997373617") ? (IDoloresRequestRouter) ipChange.ipc$dispatch("-997373617", new Object[]{this}) : this.b;
    }

    @Nullable
    public final String n() {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "1296370712") ? (String) ipChange.ipc$dispatch("1296370712", new Object[]{this}) : this.c;
    }

    public final void u(@Nullable String str) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1240029638")) {
            ipChange.ipc$dispatch("1240029638", new Object[]{this, str});
        } else {
            this.c = str;
        }
    }

    public /* synthetic */ sb0(Context context, k50 k50Var) {
        this(context);
    }
}
