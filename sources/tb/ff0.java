package tb;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import cn.damai.common.nav.DMNav;
import cn.damai.common.nav.NavUri;
import cn.damai.login.LoginManager;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import io.flutter.wpkbridge.WPKFactory;
import java.util.List;
import java.util.ListIterator;
import java.util.Locale;
import java.util.Set;
import kotlin.collections.C8214m;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.text.Regex;
import kotlin.text.StringsKt__StringsKt;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: Taobao */
/* loaded from: classes4.dex */
public final class ff0 {
    private static transient /* synthetic */ IpChange $ipChange;
    @NotNull
    private final Context a;
    @Nullable
    private final String b;
    @Nullable
    private final String c;
    @Nullable
    private final String d;
    @Nullable
    private final Bundle e;
    @NotNull
    private final StringBuilder f;

    public ff0(@NotNull Context context, @Nullable String str, @Nullable String str2, @Nullable String str3, @Nullable Bundle bundle) {
        b41.i(context, WPKFactory.INIT_KEY_CONTEXT);
        this.a = context;
        this.b = str;
        this.c = str2;
        this.d = str3;
        this.e = bundle;
        this.f = new StringBuilder();
        if (bundle != null) {
            a(c(bundle));
        } else if (context instanceof Activity) {
            a(b((Activity) context));
        }
    }

    private final void a(String str) {
        boolean K;
        IpChange ipChange = $ipChange;
        boolean z = true;
        boolean z2 = false;
        if (AndroidInstantRuntime.support(ipChange, "725228833")) {
            ipChange.ipc$dispatch("725228833", new Object[]{this, str});
            return;
        }
        StringBuilder sb = this.f;
        sb.delete(0, sb.length());
        String str2 = this.d;
        if (str2 != null) {
            Locale locale = Locale.getDefault();
            b41.h(locale, "getDefault()");
            String lowerCase = str2.toLowerCase(locale);
            b41.h(lowerCase, "this as java.lang.String).toLowerCase(locale)");
            K = StringsKt__StringsKt.K(lowerCase, "apiname", false, 2, null);
            if (K) {
                this.f.append(this.d);
            } else {
                StringBuilder sb2 = this.f;
                sb2.append("apiName:" + this.d);
            }
            z2 = true;
        }
        if (this.b != null) {
            if (z2) {
                this.f.append(",");
            }
            StringBuilder sb3 = this.f;
            sb3.append("errorCode:" + this.b);
        } else {
            z = z2;
        }
        if (this.c != null) {
            if (z) {
                this.f.append(",");
            }
            StringBuilder sb4 = this.f;
            sb4.append("errorMsg:" + this.c);
        }
        if (TextUtils.isEmpty(str)) {
            return;
        }
        if (z) {
            this.f.append(",");
        }
        this.f.append(str);
    }

    private final String b(Activity activity) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1780049158")) {
            return (String) ipChange.ipc$dispatch("-1780049158", new Object[]{this, activity});
        }
        if (activity == null) {
            return null;
        }
        StringBuilder sb = new StringBuilder();
        sb.delete(0, sb.length());
        c(activity.getIntent() != null ? activity.getIntent().getExtras() : null);
        return sb.toString();
    }

    private final String c(Bundle bundle) {
        Set<String> keySet;
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-545744288")) {
            return (String) ipChange.ipc$dispatch("-545744288", new Object[]{this, bundle});
        }
        StringBuilder sb = new StringBuilder();
        sb.delete(0, sb.length());
        if (bundle != null && (keySet = bundle.keySet()) != null) {
            sb.append("errorJson={");
            for (String str : keySet) {
                Object obj = bundle.get(str);
                if (obj != null) {
                    sb.append(str);
                    sb.append(":");
                    sb.append(obj.toString());
                    sb.append(",");
                }
            }
            if (sb.length() > 1) {
                sb.delete(sb.length() - 1, sb.length());
            }
            sb.append("}");
        }
        String sb2 = sb.toString();
        b41.h(sb2, "pageBuilder.toString()");
        return sb2;
    }

    /* JADX WARN: Code restructure failed: missing block: B:13:0x009a, code lost:
        if (r1 != null) goto L16;
     */
    /* JADX WARN: Code restructure failed: missing block: B:14:0x009c, code lost:
        r1.recycle();
     */
    /* JADX WARN: Code restructure failed: missing block: B:19:0x00a7, code lost:
        if (r1 != null) goto L16;
     */
    /* JADX WARN: Code restructure failed: missing block: B:21:0x00aa, code lost:
        return r0;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private final java.lang.String d() {
        /*
            r13 = this;
            java.lang.String r0 = ""
            com.android.alibaba.ip.runtime.IpChange r1 = tb.ff0.$ipChange
            java.lang.String r2 = "1369529522"
            boolean r3 = com.android.alibaba.ip.runtime.AndroidInstantRuntime.support(r1, r2)
            r4 = 0
            r5 = 1
            if (r3 == 0) goto L19
            java.lang.Object[] r0 = new java.lang.Object[r5]
            r0[r4] = r13
            java.lang.Object r0 = r1.ipc$dispatch(r2, r0)
            java.lang.String r0 = (java.lang.String) r0
            return r0
        L19:
            r1 = 0
            android.content.Context r2 = r13.a     // Catch: java.lang.Throwable -> La0 java.lang.Exception -> La7
            java.lang.String r3 = "null cannot be cast to non-null type android.app.Activity"
            tb.b41.g(r2, r3)     // Catch: java.lang.Throwable -> La0 java.lang.Exception -> La7
            android.app.Activity r2 = (android.app.Activity) r2     // Catch: java.lang.Throwable -> La0 java.lang.Exception -> La7
            android.view.Window r2 = r2.getWindow()     // Catch: java.lang.Throwable -> La0 java.lang.Exception -> La7
            android.view.View r2 = r2.getDecorView()     // Catch: java.lang.Throwable -> La0 java.lang.Exception -> La7
            java.lang.String r3 = "context as Activity).window.decorView"
            tb.b41.h(r2, r3)     // Catch: java.lang.Throwable -> La0 java.lang.Exception -> La7
            r2.setDrawingCacheEnabled(r5)     // Catch: java.lang.Throwable -> La0 java.lang.Exception -> La7
            r2.buildDrawingCache()     // Catch: java.lang.Throwable -> La0 java.lang.Exception -> La7
            android.graphics.Bitmap r6 = r2.getDrawingCache()     // Catch: java.lang.Throwable -> La0 java.lang.Exception -> La7
            android.graphics.Matrix r11 = new android.graphics.Matrix     // Catch: java.lang.Throwable -> La0 java.lang.Exception -> La7
            r11.<init>()     // Catch: java.lang.Throwable -> La0 java.lang.Exception -> La7
            r2 = 1056964608(0x3f000000, float:0.5)
            r11.setScale(r2, r2)     // Catch: java.lang.Throwable -> La0 java.lang.Exception -> La7
            r7 = 0
            r8 = 0
            int r9 = r6.getWidth()     // Catch: java.lang.Throwable -> La0 java.lang.Exception -> La7
            int r10 = r6.getHeight()     // Catch: java.lang.Throwable -> La0 java.lang.Exception -> La7
            r12 = 0
            android.graphics.Bitmap r1 = android.graphics.Bitmap.createBitmap(r6, r7, r8, r9, r10, r11, r12)     // Catch: java.lang.Throwable -> La0 java.lang.Exception -> La7
            if (r1 == 0) goto L9a
            java.lang.String r2 = cn.damai.common.util.C0535a.m()     // Catch: java.lang.Throwable -> La0 java.lang.Exception -> La7
            boolean r3 = android.text.TextUtils.isEmpty(r2)     // Catch: java.lang.Throwable -> La0 java.lang.Exception -> La7
            if (r3 != 0) goto L9a
            java.lang.StringBuilder r3 = new java.lang.StringBuilder     // Catch: java.lang.Throwable -> La0 java.lang.Exception -> La7
            r3.<init>()     // Catch: java.lang.Throwable -> La0 java.lang.Exception -> La7
            r3.append(r2)     // Catch: java.lang.Throwable -> La0 java.lang.Exception -> La7
            java.lang.String r5 = "/feedback"
            r3.append(r5)     // Catch: java.lang.Throwable -> La0 java.lang.Exception -> La7
            java.lang.String r3 = r3.toString()     // Catch: java.lang.Throwable -> La0 java.lang.Exception -> La7
            cn.damai.common.util.C0535a.t(r3, r4)     // Catch: java.lang.Throwable -> La0 java.lang.Exception -> La7
            java.lang.StringBuilder r3 = new java.lang.StringBuilder     // Catch: java.lang.Throwable -> La0 java.lang.Exception -> La7
            r3.<init>()     // Catch: java.lang.Throwable -> La0 java.lang.Exception -> La7
            r3.append(r2)     // Catch: java.lang.Throwable -> La0 java.lang.Exception -> La7
            java.lang.String r2 = "/feedback/screen.jpg"
            r3.append(r2)     // Catch: java.lang.Throwable -> La0 java.lang.Exception -> La7
            java.lang.String r2 = r3.toString()     // Catch: java.lang.Throwable -> La0 java.lang.Exception -> La7
            cn.damai.common.util.C0535a.d(r2)     // Catch: java.lang.Throwable -> La0 java.lang.Exception -> La7
            java.io.FileOutputStream r3 = new java.io.FileOutputStream     // Catch: java.lang.Throwable -> La0 java.lang.Exception -> La7
            r3.<init>(r2)     // Catch: java.lang.Throwable -> La0 java.lang.Exception -> La7
            android.graphics.Bitmap$CompressFormat r4 = android.graphics.Bitmap.CompressFormat.JPEG     // Catch: java.lang.Throwable -> La0 java.lang.Exception -> La7
            r5 = 100
            r1.compress(r4, r5, r3)     // Catch: java.lang.Throwable -> La0 java.lang.Exception -> La7
            r3.flush()     // Catch: java.lang.Throwable -> La0 java.lang.Exception -> La7
            r3.close()     // Catch: java.lang.Throwable -> La0 java.lang.Exception -> La7
            r0 = r2
        L9a:
            if (r1 == 0) goto Laa
        L9c:
            r1.recycle()
            goto Laa
        La0:
            r0 = move-exception
            if (r1 == 0) goto La6
            r1.recycle()
        La6:
            throw r0
        La7:
            if (r1 == 0) goto Laa
            goto L9c
        Laa:
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: tb.ff0.d():java.lang.String");
    }

    private final void e(String str) {
        List g;
        boolean z;
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "107421826")) {
            ipChange.ipc$dispatch("107421826", new Object[]{this, str});
            return;
        }
        Bundle bundle = new Bundle();
        bundle.putString("name", "90");
        String str2 = this.c;
        if (str2 != null) {
            bundle.putString("descInfo", str2);
        }
        String sb = this.f.toString();
        if (sb == null) {
            sb = "";
        }
        if (!TextUtils.isEmpty(sb)) {
            bundle.putString("extra", sb);
        }
        String name = this.a.getClass().getName();
        if (!TextUtils.isEmpty(name)) {
            bundle.putString("fromPage", name);
            b41.h(name, "name");
            List<String> split = new Regex("\\.").split(name, 0);
            if (!split.isEmpty()) {
                ListIterator<String> listIterator = split.listIterator(split.size());
                while (listIterator.hasPrevious()) {
                    if (listIterator.previous().length() == 0) {
                        z = true;
                        continue;
                    } else {
                        z = false;
                        continue;
                    }
                    if (!z) {
                        g = CollectionsKt___CollectionsKt.v0(split, listIterator.nextIndex() + 1);
                        break;
                    }
                }
            }
            g = C8214m.g();
            Object[] array = g.toArray(new String[0]);
            b41.g(array, "null cannot be cast to non-null type kotlin.Array<T of kotlin.collections.ArraysKt__ArraysJVMKt.toTypedArray>");
            String[] strArr = (String[]) array;
            if (strArr.length > 2) {
                bundle.putString("module", strArr[2]);
            }
        }
        bundle.putString("screenView", str);
        DMNav.from(this.a).withExtras(bundle).toUri(NavUri.b("feed_back_report"));
    }

    public final void f() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "876203955")) {
            ipChange.ipc$dispatch("876203955", new Object[]{this});
        } else if (!LoginManager.k().q()) {
            LoginManager.k().w(this.a, new Intent());
        } else {
            try {
                if (!kr1.e(new String[]{"android.permission.READ_EXTERNAL_STORAGE", "android.permission.WRITE_EXTERNAL_STORAGE"}, this.a)) {
                    e(d());
                } else {
                    e("");
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    public /* synthetic */ ff0(Context context, String str, String str2, String str3, Bundle bundle, int i, k50 k50Var) {
        this(context, str, str2, (i & 8) != 0 ? null : str3, (i & 16) != 0 ? null : bundle);
    }
}
