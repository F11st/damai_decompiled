package tb;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.text.TextUtils;
import android.util.DisplayMetrics;
import android.widget.Toast;
import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.alibaba.pictures.bricks.util.TComparator;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import com.huawei.hms.support.api.entity.core.CommonCode;
import io.flutter.wpkbridge.WPKFactory;
import java.util.List;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: Taobao */
/* loaded from: classes7.dex */
public final class ap2 {
    private static transient /* synthetic */ IpChange $ipChange;
    @NotNull
    public static final ap2 INSTANCE = new ap2();

    private ap2() {
    }

    /* JADX WARN: Code restructure failed: missing block: B:15:0x0038, code lost:
        r1 = new java.util.ArrayList<>();
        r13 = r13.iterator();
     */
    /* JADX WARN: Code restructure failed: missing block: B:17:0x0045, code lost:
        if (r13.hasNext() == false) goto L27;
     */
    /* JADX WARN: Code restructure failed: missing block: B:18:0x0047, code lost:
        r2 = (java.lang.String) r13.next();
        r3 = kotlin.text.o.F(r2, "tel:", false, 2, null);
     */
    /* JADX WARN: Code restructure failed: missing block: B:19:0x0053, code lost:
        if (r3 == false) goto L25;
     */
    /* JADX WARN: Code restructure failed: missing block: B:20:0x0055, code lost:
        r3 = r2.substring(4, r2.length());
        tb.b41.h(r3, "this as java.lang.String…ing(startIndex, endIndex)");
     */
    /* JADX WARN: Code restructure failed: missing block: B:21:0x0064, code lost:
        r3 = r2;
     */
    /* JADX WARN: Code restructure failed: missing block: B:22:0x0065, code lost:
        r1.add(new com.alibaba.pictures.bricks.bean.BottomAction(r3, r2));
     */
    /* JADX WARN: Code restructure failed: missing block: B:24:0x006e, code lost:
        return r1;
     */
    @org.jetbrains.annotations.Nullable
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final java.util.ArrayList<com.alibaba.pictures.bricks.bean.BottomAction> a(@org.jetbrains.annotations.Nullable java.lang.String r13) {
        /*
            r12 = this;
            com.android.alibaba.ip.runtime.IpChange r0 = tb.ap2.$ipChange
            java.lang.String r1 = "17929716"
            boolean r2 = com.android.alibaba.ip.runtime.AndroidInstantRuntime.support(r0, r1)
            r3 = 1
            r4 = 2
            r5 = 0
            if (r2 == 0) goto L1a
            java.lang.Object[] r2 = new java.lang.Object[r4]
            r2[r5] = r12
            r2[r3] = r13
            java.lang.Object r13 = r0.ipc$dispatch(r1, r2)
            java.util.ArrayList r13 = (java.util.ArrayList) r13
            return r13
        L1a:
            r0 = 0
            if (r13 == 0) goto L73
            java.lang.String r1 = ","
            java.lang.String[] r7 = new java.lang.String[]{r1}     // Catch: java.lang.Exception -> L6f
            r8 = 0
            r9 = 0
            r10 = 6
            r11 = 0
            r6 = r13
            java.util.List r13 = kotlin.text.g.t0(r6, r7, r8, r9, r10, r11)     // Catch: java.lang.Exception -> L6f
            if (r13 == 0) goto L36
            boolean r1 = r13.isEmpty()     // Catch: java.lang.Exception -> L6f
            if (r1 == 0) goto L35
            goto L36
        L35:
            r3 = 0
        L36:
            if (r3 != 0) goto L73
            java.util.ArrayList r1 = new java.util.ArrayList     // Catch: java.lang.Exception -> L6f
            r1.<init>()     // Catch: java.lang.Exception -> L6f
            java.util.Iterator r13 = r13.iterator()     // Catch: java.lang.Exception -> L6f
        L41:
            boolean r2 = r13.hasNext()     // Catch: java.lang.Exception -> L6f
            if (r2 == 0) goto L6e
            java.lang.Object r2 = r13.next()     // Catch: java.lang.Exception -> L6f
            java.lang.String r2 = (java.lang.String) r2     // Catch: java.lang.Exception -> L6f
            java.lang.String r3 = "tel:"
            boolean r3 = kotlin.text.g.F(r2, r3, r5, r4, r0)     // Catch: java.lang.Exception -> L6f
            if (r3 == 0) goto L64
            r3 = 4
            int r6 = r2.length()     // Catch: java.lang.Exception -> L6f
            java.lang.String r3 = r2.substring(r3, r6)     // Catch: java.lang.Exception -> L6f
            java.lang.String r6 = "this as java.lang.String…ing(startIndex, endIndex)"
            tb.b41.h(r3, r6)     // Catch: java.lang.Exception -> L6f
            goto L65
        L64:
            r3 = r2
        L65:
            com.alibaba.pictures.bricks.bean.BottomAction r6 = new com.alibaba.pictures.bricks.bean.BottomAction     // Catch: java.lang.Exception -> L6f
            r6.<init>(r3, r2)     // Catch: java.lang.Exception -> L6f
            r1.add(r6)     // Catch: java.lang.Exception -> L6f
            goto L41
        L6e:
            return r1
        L6f:
            r13 = move-exception
            r13.printStackTrace()
        L73:
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: tb.ap2.a(java.lang.String):java.util.ArrayList");
    }

    @NotNull
    public final DisplayMetrics b(@NotNull Context context) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1713107041")) {
            return (DisplayMetrics) ipChange.ipc$dispatch("-1713107041", new Object[]{this, context});
        }
        b41.i(context, WPKFactory.INIT_KEY_CONTEXT);
        DisplayMetrics displayMetrics = context.getResources().getDisplayMetrics();
        b41.h(displayMetrics, "context.resources.displayMetrics");
        return displayMetrics;
    }

    @Nullable
    public final Object c(@Nullable List<?> list, int i) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-122215718")) {
            return ipChange.ipc$dispatch("-122215718", new Object[]{this, list, Integer.valueOf(i)});
        }
        if (list == null || list.size() <= i || i < 0) {
            return null;
        }
        return list.get(i);
    }

    public final int d(@Nullable List<?> list) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1589233966")) {
            return ((Integer) ipChange.ipc$dispatch("-1589233966", new Object[]{this, list})).intValue();
        }
        if (list != null) {
            return list.size();
        }
        return 0;
    }

    public final boolean e(@NotNull Context context) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1378311175")) {
            return ((Boolean) ipChange.ipc$dispatch("1378311175", new Object[]{this, context})).booleanValue();
        }
        b41.i(context, WPKFactory.INIT_KEY_CONTEXT);
        String[] strArr = lr1.a;
        b41.h(strArr, "LOCATION");
        return !kr1.e(strArr, context);
    }

    public final <T> boolean f(@Nullable List<? extends T> list, @Nullable List<? extends T> list2, @NotNull TComparator<T> tComparator) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1231324272")) {
            return ((Boolean) ipChange.ipc$dispatch("-1231324272", new Object[]{this, list, list2, tComparator})).booleanValue();
        }
        b41.i(tComparator, "tCompare");
        int d = d(list);
        if (d == d(list2)) {
            if (d > 0) {
                for (int i = 0; i < d; i++) {
                    if (!tComparator.same(list != null ? list.get(i) : null, list2 != null ? list2.get(i) : null)) {
                        return false;
                    }
                }
            }
            return true;
        }
        return false;
    }

    public final boolean g(@NotNull Intent intent, @NotNull Context context) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-690953439")) {
            return ((Boolean) ipChange.ipc$dispatch("-690953439", new Object[]{this, intent, context})).booleanValue();
        }
        b41.i(intent, CommonCode.Resolution.HAS_RESOLUTION_FROM_APK);
        b41.i(context, WPKFactory.INIT_KEY_CONTEXT);
        return context.getPackageManager().resolveActivity(intent, 65536) != null;
    }

    public final void h(@Nullable Activity activity, @Nullable String str) {
        boolean s;
        boolean F;
        Uri parse;
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-130251895")) {
            ipChange.ipc$dispatch("-130251895", new Object[]{this, activity, str});
        } else if (activity == null || activity.isFinishing() || str == null) {
        } else {
            s = kotlin.text.o.s(str);
            if (s) {
                return;
            }
            try {
                F = kotlin.text.o.F(str, "tel", false, 2, null);
                if (F) {
                    parse = Uri.parse(str);
                } else {
                    parse = Uri.parse("tel:" + str);
                }
                Intent intent = new Intent("android.intent.action.DIAL", parse);
                ap2 ap2Var = INSTANCE;
                if (ap2Var.g(intent, activity)) {
                    activity.startActivity(intent);
                } else {
                    ap2Var.l(activity, "无法拨号，请手动拨打");
                }
            } catch (Exception e) {
                e.printStackTrace();
                INSTANCE.l(activity, "无法拨号，请手动拨打");
            }
        }
    }

    @Nullable
    public final JSONObject i(@Nullable String str) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-746960177")) {
            return (JSONObject) ipChange.ipc$dispatch("-746960177", new Object[]{this, str});
        }
        try {
            if (TextUtils.isEmpty(str)) {
                return null;
            }
            return JSON.parseObject(str);
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    @Nullable
    public final <T> T j(@Nullable JSON json, @Nullable Class<T> cls) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1920751463")) {
            return (T) ipChange.ipc$dispatch("-1920751463", new Object[]{this, json, cls});
        }
        try {
            return (T) JSON.toJavaObject(json, cls);
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    @Nullable
    public final String k(@Nullable Object obj) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "763889777")) {
            return (String) ipChange.ipc$dispatch("763889777", new Object[]{this, obj});
        }
        if (obj != null) {
            try {
                return JSON.toJSONString(obj);
            } catch (Exception e) {
                e.printStackTrace();
                return null;
            }
        }
        return null;
    }

    public final void l(@NotNull Context context, @NotNull String str) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1827086890")) {
            ipChange.ipc$dispatch("-1827086890", new Object[]{this, context, str});
            return;
        }
        b41.i(context, WPKFactory.INIT_KEY_CONTEXT);
        b41.i(str, "text");
        Toast.makeText(context, str, 0).show();
    }
}
