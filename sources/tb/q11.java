package tb;

import android.content.Context;
import android.database.Cursor;
import android.net.Uri;
import android.os.Build;
import android.provider.MediaStore;
import android.view.View;
import android.view.ViewGroup;
import com.alibaba.security.realidentity.jsbridge.AbstractC3893a;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import io.flutter.wpkbridge.WPKFactory;
import java.util.Objects;
import kotlin.jvm.JvmStatic;
import kotlin.text.StringsKt__StringsKt;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: Taobao */
/* loaded from: classes7.dex */
public final class q11 {
    private static transient /* synthetic */ IpChange $ipChange;
    @NotNull
    public static final q11 INSTANCE = new q11();
    @NotNull
    private static String[] a = {"tbvideo-taobao-film.oss-cn-hangzhou.aliyuncs.com", "tbvideoinputfirst.oss-cn-hangzhou.aliyuncs.com", "tbvideoinputsecond.oss-cn-beijing.aliyuncs.com", "taobaodianying.oss-cn-zhangjiakou.aliyuncs.com", "bdworkflow.oss-cn-hangzhou.aliyuncs.com", "tbfilm-oss.oss-cn-zhangjiakou.aliyuncs.com", "tfavatar-oss.oss-cn-shanghai.aliyuncs.com", "dmassets.oss-cn-shanghai.aliyuncs.com", "perico.oss-cn-beijing.aliyuncs.com", "damaipimg.oss-cn-beijing.aliyuncs.com", "damai-comment.oss-cn-beijing.aliyuncs.com", "damai-intercms.oss-cn-beijing.aliyuncs.com", "damai-sentiment.oss-cn-beijing.aliyuncs.com", "damai-mec-comment.oss-cn-beijing.aliyuncs.com", "damai-mx-partner-admin.oss-cn-beijing.aliyuncs.com", "damai-finance-upload.oss-cn-beijing.aliyuncs.com", "ticklet.oss-cn-beijing.aliyuncs.com"};
    @NotNull
    private static String[] b = {"tbvideo-oss.taopiaopiao.com", "tbvideo-oss.taopiaopiao.com", "tbvideo.taopiaopiao.com", "oss.taopiaopiao.com", "bdworkflow.taopiaopiao.com", "tbfilm-oss.taopiaopiao.com", "tfavatar-oss.taopiaopiao.com", "assets.damai.cn", "perico.damai.cn", "pimg.damai.cn", "comment-cdn.damai.cn", "intercms.damai.cn", "sentiment.damai.cn", "mec-comment.damai.cn", "mx-partner-admin.damai.cn", "finance-upload.damai.cn", "ticklet.damai.cn"};

    private q11() {
    }

    @JvmStatic
    public static final int c(@Nullable View view) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "502694360")) {
            return ((Integer) ipChange.ipc$dispatch("502694360", new Object[]{view})).intValue();
        }
        Objects.requireNonNull(view);
        int paddingTop = view.getPaddingTop() + view.getPaddingBottom();
        ViewGroup.LayoutParams layoutParams = view.getLayoutParams();
        return INSTANCE.b(view, view.getHeight(), layoutParams != null ? layoutParams.height : 0, paddingTop);
    }

    @JvmStatic
    public static final int d(@Nullable View view) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1259564949")) {
            return ((Integer) ipChange.ipc$dispatch("1259564949", new Object[]{view})).intValue();
        }
        Objects.requireNonNull(view);
        int paddingLeft = view.getPaddingLeft() + view.getPaddingRight();
        ViewGroup.LayoutParams layoutParams = view.getLayoutParams();
        return INSTANCE.b(view, view.getWidth(), layoutParams != null ? layoutParams.width : 0, paddingLeft);
    }

    @JvmStatic
    public static final boolean e(@Nullable View view) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1893192458")) {
            return ((Boolean) ipChange.ipc$dispatch("1893192458", new Object[]{view})).booleanValue();
        }
        if (view != null) {
            q11 q11Var = INSTANCE;
            if (q11Var.h(d(view)) && q11Var.h(c(view))) {
                return true;
            }
        }
        return false;
    }

    @JvmStatic
    public static final boolean f(@Nullable View view) {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "1729185407") ? ((Boolean) ipChange.ipc$dispatch("1729185407", new Object[]{view})).booleanValue() : view != null && view.getMeasuredWidth() > 0 && view.getMeasuredHeight() > 0;
    }

    private final boolean h(int i) {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "-1151650580") ? ((Boolean) ipChange.ipc$dispatch("-1151650580", new Object[]{this, Integer.valueOf(i)})).booleanValue() : i > 0 || i == Integer.MIN_VALUE;
    }

    @Nullable
    public final Uri a(@NotNull Context context, @NotNull String str) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-934450812")) {
            return (Uri) ipChange.ipc$dispatch("-934450812", new Object[]{this, context, str});
        }
        b41.i(context, WPKFactory.INIT_KEY_CONTEXT);
        b41.i(str, AbstractC3893a.V);
        Cursor query = context.getContentResolver().query(MediaStore.Images.Media.EXTERNAL_CONTENT_URI, new String[]{"_id"}, "_data=? ", new String[]{str}, null);
        if (query == null || !query.moveToFirst()) {
            return null;
        }
        int i = query.getInt(query.getColumnIndex("_id"));
        query.close();
        Uri parse = Uri.parse("content://media/external/images/media");
        return Uri.withAppendedPath(parse, "" + i);
    }

    public final int b(@Nullable View view, int i, int i2, int i3) {
        int i4;
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-966102871")) {
            return ((Integer) ipChange.ipc$dispatch("-966102871", new Object[]{this, view, Integer.valueOf(i), Integer.valueOf(i2), Integer.valueOf(i3)})).intValue();
        }
        Objects.requireNonNull(view);
        int i5 = i2 - i3;
        if (i5 > 0) {
            return i5;
        }
        if (!view.isLayoutRequested() && (i4 = i - i3) > 0) {
            return i4;
        }
        return 0;
    }

    public final boolean g(@NotNull Context context, @Nullable String str) {
        int f0;
        boolean K;
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "802701573")) {
            return ((Boolean) ipChange.ipc$dispatch("802701573", new Object[]{this, context, str})).booleanValue();
        }
        b41.i(context, WPKFactory.INIT_KEY_CONTEXT);
        if (str != null && Build.VERSION.SDK_INT == 29) {
            f0 = StringsKt__StringsKt.f0(str, "/", 0, false, 6, null);
            String substring = str.substring(0, f0);
            b41.h(substring, "(this as java.lang.Strin…ing(startIndex, endIndex)");
            String packageName = context.getPackageName();
            b41.h(packageName, "context.packageName");
            K = StringsKt__StringsKt.K(substring, packageName, false, 2, null);
            if (!K) {
                return true;
            }
        }
        return false;
    }

    public final boolean i(@Nullable View view) {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "-1308351878") ? ((Boolean) ipChange.ipc$dispatch("-1308351878", new Object[]{this, view})).booleanValue() : view != null && h(d(view)) && h(c(view)) && view.getMeasuredWidth() > 0 && view.getMeasuredHeight() > 0;
    }

    /* JADX WARN: Code restructure failed: missing block: B:19:0x0042, code lost:
        r14 = kotlin.collections.ArraysKt___ArraysKt.B(tb.q11.a, r5);
     */
    @org.jetbrains.annotations.Nullable
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final java.lang.String j(@org.jetbrains.annotations.Nullable android.net.Uri r14, @org.jetbrains.annotations.Nullable java.lang.String r15) {
        /*
            r13 = this;
            com.android.alibaba.ip.runtime.IpChange r0 = tb.q11.$ipChange
            java.lang.String r1 = "1990470130"
            boolean r2 = com.android.alibaba.ip.runtime.AndroidInstantRuntime.support(r0, r1)
            r3 = 0
            if (r2 == 0) goto L1d
            r2 = 3
            java.lang.Object[] r2 = new java.lang.Object[r2]
            r2[r3] = r13
            r3 = 1
            r2[r3] = r14
            r14 = 2
            r2[r14] = r15
            java.lang.Object r14 = r0.ipc$dispatch(r1, r2)
            java.lang.String r14 = (java.lang.String) r14
            return r14
        L1d:
            r0 = 0
            if (r14 == 0) goto L7b
            tb.mg1 r1 = tb.mg1.INSTANCE
            boolean r1 = r1.f()
            if (r1 == 0) goto L7b
            if (r15 != 0) goto L2b
            goto L7b
        L2b:
            java.lang.String r5 = r14.getHost()     // Catch: java.lang.Exception -> L71
            if (r5 == 0) goto L7b
            java.lang.String r14 = "oss.taopiaopiao.com"
            boolean r14 = tb.b41.d(r5, r14)     // Catch: java.lang.Exception -> L71
            if (r14 != 0) goto L70
            java.lang.String r14 = "gw.alicdn.com"
            boolean r14 = tb.b41.d(r5, r14)     // Catch: java.lang.Exception -> L71
            if (r14 == 0) goto L42
            goto L70
        L42:
            java.lang.String[] r14 = tb.q11.a     // Catch: java.lang.Exception -> L71
            int r14 = kotlin.collections.C8202e.B(r14, r5)     // Catch: java.lang.Exception -> L71
            if (r14 < 0) goto L7b
            java.lang.String[] r1 = tb.q11.b     // Catch: java.lang.Exception -> L71
            int r2 = r1.length     // Catch: java.lang.Exception -> L71
            if (r14 >= r2) goto L7b
            r6 = r1[r14]     // Catch: java.lang.Exception -> L71
            java.lang.String r8 = "?"
            r9 = 0
            r10 = 0
            r11 = 6
            r12 = 0
            r7 = r15
            int r14 = kotlin.text.C8596g.Z(r7, r8, r9, r10, r11, r12)     // Catch: java.lang.Exception -> L71
            if (r14 <= 0) goto L67
            java.lang.String r15 = r15.substring(r3, r14)     // Catch: java.lang.Exception -> L71
            java.lang.String r14 = "(this as java.lang.Strin…ing(startIndex, endIndex)"
            tb.b41.h(r15, r14)     // Catch: java.lang.Exception -> L71
        L67:
            r4 = r15
            r7 = 0
            r8 = 4
            r9 = 0
            java.lang.String r14 = kotlin.text.C8596g.B(r4, r5, r6, r7, r8, r9)     // Catch: java.lang.Exception -> L71
            return r14
        L70:
            return r0
        L71:
            r14 = move-exception
            tb.lg1 r15 = tb.lg1.INSTANCE
            java.lang.String r14 = r14.toString()
            r15.c(r14)
        L7b:
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: tb.q11.j(android.net.Uri, java.lang.String):java.lang.String");
    }
}
