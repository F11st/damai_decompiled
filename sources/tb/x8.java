package tb;

import android.content.Context;
import android.text.TextUtils;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import com.taobao.login4android.Login;
import java.util.List;
import kotlin.text.StringsKt__StringsKt;
import org.jetbrains.annotations.NotNull;

/* compiled from: Taobao */
/* loaded from: classes8.dex */
public final class x8 {
    @NotNull
    public static final C9911a Companion = new C9911a(null);

    /* compiled from: Taobao */
    /* renamed from: tb.x8$a */
    /* loaded from: classes8.dex */
    public static final class C9911a {
        private static transient /* synthetic */ IpChange $ipChange;

        private C9911a() {
        }

        public /* synthetic */ C9911a(k50 k50Var) {
            this();
        }

        public final void a(@NotNull String str, @NotNull Context context) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "787196741")) {
                ipChange.ipc$dispatch("787196741", new Object[]{this, str, context});
                return;
            }
            b41.i(str, "itemid");
            b41.i(context, "mContext");
            String c = vd1.c(Login.getUserId());
            String str2 = "saved_audience_";
            if (!TextUtils.isEmpty(c) && c.length() == 32) {
                StringBuilder sb = new StringBuilder();
                sb.append("saved_audience_");
                b41.h(c, "md5");
                String substring = c.substring(8, 24);
                b41.h(substring, "this as java.lang.String…ing(startIndex, endIndex)");
                sb.append(substring);
                sb.append('_');
                str2 = sb.toString();
            }
            ue2 b = ue2.b(context);
            b.f(str2 + str);
        }

        @NotNull
        public final String[] b(@NotNull String str, @NotNull Context context) {
            List t0;
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "-1340246165")) {
                return (String[]) ipChange.ipc$dispatch("-1340246165", new Object[]{this, str, context});
            }
            b41.i(str, "itemid");
            b41.i(context, "mContext");
            String c = vd1.c(Login.getUserId());
            String str2 = "saved_audience_";
            if (!TextUtils.isEmpty(c) && c.length() == 32) {
                StringBuilder sb = new StringBuilder();
                sb.append("saved_audience_");
                b41.h(c, "md5");
                String substring = c.substring(8, 24);
                b41.h(substring, "this as java.lang.String…ing(startIndex, endIndex)");
                sb.append(substring);
                sb.append('_');
                str2 = sb.toString();
            }
            ue2 b = ue2.b(context);
            String d = b.d(str2 + str);
            b41.h(d, "getInstance(mContext).getString(key + itemid)");
            t0 = StringsKt__StringsKt.t0(d, new String[]{","}, false, 0, 6, null);
            Object[] array = t0.toArray(new String[0]);
            b41.g(array, "null cannot be cast to non-null type kotlin.Array<T of kotlin.collections.ArraysKt__ArraysJVMKt.toTypedArray>");
            return (String[]) array;
        }
    }
}
