package tb;

import android.app.Activity;
import android.app.Application;
import android.content.Context;
import android.text.TextUtils;
import com.alibaba.fastjson.JSONObject;
import com.alibaba.yymidservice.popup.popupcenter.view.DialogCustomView;
import com.alibaba.yymidservice.popup.request.PopupReportRequest;
import com.alibaba.yymidservice.popup.request.bean.PopupDetailBean;
import com.youku.middlewareservice.provider.info.AppInfoProviderProxy;
import io.flutter.wpkbridge.WPKFactory;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.concurrent.atomic.AtomicBoolean;
import kotlin.jvm.JvmOverloads;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: Taobao */
/* loaded from: classes8.dex */
public final class lt1 {
    @NotNull
    public static final C9421a Companion = new C9421a(null);
    @NotNull
    public static final String fileName = "popup_scene_type_config";
    @Nullable
    private static lt1 g;
    @Nullable
    private Activity b;
    @Nullable
    private ArrayList<String> d;
    @Nullable
    private ArrayList<String> e;
    @NotNull
    private Map<String, DialogCustomView> a = new LinkedHashMap();
    @NotNull
    private String c = "";
    @NotNull
    private AtomicBoolean f = new AtomicBoolean(false);

    /* compiled from: Taobao */
    /* renamed from: tb.lt1$a */
    /* loaded from: classes8.dex */
    public static final class C9421a {
        private C9421a() {
        }

        public /* synthetic */ C9421a(k50 k50Var) {
            this();
        }

        @NotNull
        public final synchronized lt1 a() {
            lt1 lt1Var;
            if (lt1.g == null) {
                lt1.g = new lt1();
            }
            lt1Var = lt1.g;
            b41.f(lt1Var);
            return lt1Var;
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ String d(lt1 lt1Var, Activity activity, String str, ArrayList arrayList, int i, Object obj) {
        if ((i & 2) != 0) {
            str = null;
        }
        if ((i & 4) != 0) {
            arrayList = null;
        }
        return lt1Var.c(activity, str, arrayList);
    }

    private final boolean f() {
        String string;
        String string2;
        try {
            InputStream open = AppInfoProviderProxy.getApplication().getAssets().open("popup_scene_type_config.json");
            b41.h(open, "getApplication().assets.open(\"$fileName.json\")");
            String c = wi0.c(open);
            if (TextUtils.isEmpty(c)) {
                return false;
            }
            yh0 yh0Var = yh0.INSTANCE;
            JSONObject a = yh0Var.a(c);
            if (a.containsKey("sceneTypes") && (string2 = a.getString("sceneTypes")) != null) {
                this.d = pt1.a((String[]) yh0Var.c(string2, String[].class));
            }
            if (!a.containsKey("localPopupPages") || (string = a.getString("localPopupPages")) == null) {
                return false;
            }
            this.e = pt1.a((String[]) yh0Var.c(string, String[].class));
            return false;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ DialogCustomView j(lt1 lt1Var, Activity activity, String str, ArrayList arrayList, int i, Object obj) {
        if ((i & 2) != 0) {
            str = null;
        }
        if ((i & 4) != 0) {
            arrayList = null;
        }
        return lt1Var.i(activity, str, arrayList);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ ArrayList m(lt1 lt1Var, Activity activity, String str, ArrayList arrayList, int i, Object obj) {
        if ((i & 2) != 0) {
            str = null;
        }
        if ((i & 4) != 0) {
            arrayList = null;
        }
        return lt1Var.l(activity, str, arrayList);
    }

    private final void n(Application application, ArrayList<String> arrayList) {
        f();
        ct1.Companion.a().k(arrayList);
        application.registerActivityLifecycleCallbacks(new ks1());
        HashMap hashMap = new HashMap();
        yh0 yh0Var = yh0.INSTANCE;
        hashMap.put("sceneTypeLocals", yh0Var.e(this.d));
        hashMap.put("localPopupPages", yh0Var.e(this.e));
        hashMap.put("sceneTypeOrange", yh0Var.e(arrayList));
    }

    @JvmOverloads
    @NotNull
    public final String c(@NotNull Activity activity, @Nullable String str, @Nullable ArrayList<String> arrayList) {
        b41.i(activity, "activity");
        String str2 = "";
        if (arrayList != null && arrayList.size() > 0) {
            StringBuilder sb = new StringBuilder();
            sb.append('_');
            sb.append(arrayList.size());
            sb.append('_');
            sb.append(arrayList.hashCode());
            str2 = sb.toString();
        }
        if (str != null) {
            return str + str2;
        }
        return activity.getClass().getSimpleName() + '_' + activity.hashCode() + str2;
    }

    @NotNull
    public final String e() {
        return this.c;
    }

    @Nullable
    public final ArrayList<String> g() {
        return this.e;
    }

    @Nullable
    public final ArrayList<String> h() {
        return this.d;
    }

    @JvmOverloads
    @Nullable
    public final DialogCustomView i(@NotNull Activity activity, @Nullable String str, @Nullable ArrayList<String> arrayList) {
        b41.i(activity, "activity");
        if (this.a.containsKey(c(activity, str, arrayList))) {
            return this.a.get(c(activity, str, arrayList));
        }
        return null;
    }

    @Nullable
    public final Activity k() {
        return this.b;
    }

    @JvmOverloads
    @Nullable
    public final ArrayList<PopupDetailBean> l(@NotNull Activity activity, @Nullable String str, @Nullable ArrayList<String> arrayList) {
        b41.i(activity, "activity");
        return ct1.Companion.a().c(c(activity, str, arrayList));
    }

    @NotNull
    public final AtomicBoolean o() {
        return this.f;
    }

    /* JADX WARN: Removed duplicated region for block: B:10:0x0013  */
    @kotlin.jvm.JvmOverloads
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final void p(@org.jetbrains.annotations.NotNull android.app.Application r2, @org.jetbrains.annotations.Nullable java.lang.String r3, @org.jetbrains.annotations.Nullable java.util.ArrayList<java.lang.String> r4) {
        /*
            r1 = this;
            java.lang.String r0 = "application"
            tb.b41.i(r2, r0)
            if (r3 == 0) goto L10
            boolean r0 = kotlin.text.C8596g.s(r3)
            if (r0 == 0) goto Le
            goto L10
        Le:
            r0 = 0
            goto L11
        L10:
            r0 = 1
        L11:
            if (r0 != 0) goto L15
            r1.c = r3
        L15:
            r1.n(r2, r4)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: tb.lt1.p(android.app.Application, java.lang.String, java.util.ArrayList):void");
    }

    @JvmOverloads
    public final void q(@NotNull Context context, @NotNull String str, @Nullable String str2, @Nullable org.json.JSONObject jSONObject) {
        b41.i(context, WPKFactory.INIT_KEY_CONTEXT);
        b41.i(str, "comboCityId");
        new PopupReportRequest().a(context, str, str2, jSONObject);
    }

    public final void r(@NotNull String str) {
        b41.i(str, "cityIdStr");
        this.c = str;
    }

    public final void s(@Nullable Activity activity) {
        this.b = activity;
    }
}
