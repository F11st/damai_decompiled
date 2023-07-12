package tb;

import android.app.Activity;
import android.content.Context;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import io.flutter.wpkbridge.WPKFactory;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: Taobao */
/* loaded from: classes7.dex */
public final class n41 {
    private static transient /* synthetic */ IpChange $ipChange;
    @NotNull
    public static final n41 INSTANCE = new n41();

    private n41() {
    }

    @NotNull
    public final y22 a(@NotNull Context context, int i, int i2, int i3, int i4, int i5, @Nullable String str, @Nullable y22 y22Var) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-584827918")) {
            return (y22) ipChange.ipc$dispatch("-584827918", new Object[]{this, context, Integer.valueOf(i), Integer.valueOf(i2), Integer.valueOf(i3), Integer.valueOf(i4), Integer.valueOf(i5), str, y22Var});
        }
        b41.i(context, WPKFactory.INIT_KEY_CONTEXT);
        return b(context, i, i2, i3, i4, i5, str, y22Var, -1, -1);
    }

    @NotNull
    public final y22 b(@NotNull Context context, int i, int i2, int i3, int i4, int i5, @Nullable String str, @Nullable y22 y22Var, int i6, int i7) {
        int measuredWidth;
        int measuredHeight;
        int i8;
        int d;
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-389227566")) {
            return (y22) ipChange.ipc$dispatch("-389227566", new Object[]{this, context, Integer.valueOf(i), Integer.valueOf(i2), Integer.valueOf(i3), Integer.valueOf(i4), Integer.valueOf(i5), str, y22Var, Integer.valueOf(i6), Integer.valueOf(i7)});
        }
        b41.i(context, WPKFactory.INIT_KEY_CONTEXT);
        Activity activity = context instanceof Activity ? (Activity) context : null;
        if (activity == null) {
            measuredWidth = i6;
            measuredHeight = i7;
        } else {
            measuredWidth = activity.getWindow().getDecorView().getMeasuredWidth();
            measuredHeight = activity.getWindow().getDecorView().getMeasuredHeight();
        }
        if (measuredWidth == 0) {
            measuredWidth = e32.e(context);
        }
        if (measuredHeight == 0) {
            measuredHeight = e32.d(context);
        }
        y22 y22Var2 = y22Var == null ? new y22() : y22Var;
        if (i == 11) {
            if (e32.INSTANCE.j(context)) {
                int d2 = ye2.INSTANCE.d(context, 1);
                i8 = ((measuredWidth - (i4 * 2)) - ((d2 - 1) * i5)) / d2;
                y22Var2.h(i8);
                y22Var2.g(i3);
                y22Var2.f(measuredWidth);
                y22Var2.e(measuredHeight);
                return y22Var2;
            }
            i8 = i2;
            y22Var2.h(i8);
            y22Var2.g(i3);
            y22Var2.f(measuredWidth);
            y22Var2.e(measuredHeight);
            return y22Var2;
        }
        if (i == 41) {
            if (e32.INSTANCE.j(context)) {
                int d3 = ye2.INSTANCE.d(context, 4);
                i8 = (int) (((measuredWidth - i4) - (d3 * i5)) / (d3 + 0.5f));
            } else {
                d = ty1.d(measuredWidth, measuredHeight);
                i8 = (int) (((d - i4) - (i5 * 4)) / 4.5f);
            }
            y22Var2.h(i8);
            y22Var2.g(i3);
            y22Var2.f(measuredWidth);
            y22Var2.e(measuredHeight);
            return y22Var2;
        }
        i8 = i2;
        y22Var2.h(i8);
        y22Var2.g(i3);
        y22Var2.f(measuredWidth);
        y22Var2.e(measuredHeight);
        return y22Var2;
    }
}
