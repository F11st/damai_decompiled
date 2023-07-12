package tb;

import android.app.Activity;
import android.content.Context;
import android.text.TextUtils;
import com.alibaba.responsive.R$dimen;
import com.youku.middlewareservice.provider.youku.mode.LargeFontModeProviderProxy;
import com.youku.modeconfig.FontModeManager;

/* compiled from: Taobao */
/* loaded from: classes8.dex */
public class o41 {
    public static x22 a(Context context, int i, int i2, int i3, int i4, int i5, String str, x22 x22Var) {
        return b(context, i, i2, i3, i4, i5, str, x22Var, -1, -1);
    }

    public static x22 b(Context context, int i, int i2, int i3, int i4, int i5, String str, x22 x22Var, int i6, int i7) {
        int i8;
        int i9;
        int min;
        float f;
        int i10;
        int c;
        int c2;
        int c3;
        int i11;
        int round;
        int i12;
        Activity activity;
        if (!(context instanceof Activity) || (activity = (Activity) context) == null || activity.getWindow() == null || activity.getWindow().getDecorView() == null) {
            i8 = i6;
            i9 = i7;
        } else {
            i8 = activity.getWindow().getDecorView().getMeasuredWidth();
            i9 = activity.getWindow().getDecorView().getMeasuredHeight();
        }
        if (i8 == 0) {
            i8 = d32.d(context);
        }
        if (i9 == 0) {
            i9 = d32.c(context);
        }
        x22 x22Var2 = x22Var == null ? new x22() : x22Var;
        if (i != 31) {
            switch (i) {
                case 11:
                    if (!d32.i(context) || (c = w22.d().c(context)) <= xe2.c()) {
                        min = i8 - (i4 * 2);
                    } else {
                        float c4 = c / xe2.c();
                        min = (int) (i8 / (c4 <= 3.0f ? c4 : 3.0f));
                    }
                    i10 = Math.round((min * 176.0f) / 351.0f);
                    break;
                case 12:
                    if (d32.i(context)) {
                        min = Math.round(((i8 * 268.0f) / 375.0f) / xe2.f(context, 1));
                    } else {
                        min = Math.round((i8 * 268.0f) / 375.0f);
                    }
                    i10 = i3;
                    break;
                case 13:
                    if (d32.i(context)) {
                        int f2 = xe2.f(context, 1);
                        min = ((i8 - (i4 * 2)) - ((f2 - 1) * i5)) / f2;
                        i10 = i3;
                        break;
                    }
                    min = i2;
                    i10 = i3;
                case 14:
                    min = (!d32.i(context) || (c2 = w22.d().c(context)) <= xe2.c()) ? i8 - (i4 * 2) : (int) (i8 / (c2 / xe2.c()));
                    i10 = Math.round((min * 130.0f) / 351.0f);
                    break;
                case 15:
                    if (!d32.i(context) || (c3 = w22.d().c(context)) <= xe2.c()) {
                        min = i8;
                    } else {
                        min = (int) (i8 / (c3 / xe2.c()));
                        if (b80.k()) {
                            min = (int) (min * 1.3d);
                        }
                    }
                    i10 = Math.round((min * 176.0f) / 351.0f);
                    break;
                case 16:
                    if (d32.i(context)) {
                        min = Math.round((((i8 * 268.0f) / 375.0f) / xe2.f(context, 1)) * 1.2f);
                    } else {
                        min = Math.round((i8 * 268.0f) / 375.0f);
                    }
                    i10 = i3;
                    break;
                default:
                    switch (i) {
                        case 21:
                            int f3 = xe2.f(context, 2);
                            i11 = ((i8 - (i4 * 2)) - ((f3 - 1) * i5)) / f3;
                            int a = b80.k() ? d32.a(context, 52.0f) : d32.a(context, 77.0f);
                            if (!TextUtils.isEmpty(str)) {
                                String[] split = str.split(":");
                                if (split.length == 2) {
                                    round = Math.round((((Integer.valueOf(split[1]).intValue() * i11) * 1.0f) / Integer.valueOf(split[0]).intValue()) + a);
                                }
                                round = i3;
                            } else {
                                round = Math.round((((i11 * 9) * 1.0f) / 16.0f) + a);
                            }
                            int i13 = i11;
                            i10 = round;
                            min = i13;
                            break;
                        case 22:
                            if (d32.i(context)) {
                                int f4 = xe2.f(context, 3);
                                min = ((i8 - (i4 * 2)) - ((f4 - 1) * i5)) / f4;
                                i10 = i3;
                                break;
                            } else {
                                f = ((Math.min(i8, i9) - (i4 * 2)) - (i5 * 2)) / (LargeFontModeProviderProxy.isNeedChangeLayout() ? 2.2f : 3.0f);
                                min = (int) f;
                                i10 = i3;
                            }
                        case 23:
                            if (d32.i(context)) {
                                int f5 = xe2.f(context, 3);
                                i12 = ((i8 - (i4 * 2)) - ((f5 - 1) * i5)) / f5;
                            } else {
                                i12 = (int) (((i8 - (i4 * 2)) - (i5 * 2)) / (LargeFontModeProviderProxy.isNeedChangeLayout() ? 2.2f : 3.0f));
                            }
                            min = Math.round((i12 * 90.0f) / 102.0f);
                            i10 = Math.round((min * 4.0f) / 3.0f);
                            break;
                        case 24:
                            int f6 = xe2.f(context, 2);
                            min = ((i8 - (i4 * 2)) - ((f6 - 1) * i5)) / f6;
                            if (!TextUtils.isEmpty(str)) {
                                String[] split2 = str.split(":");
                                if (split2.length == 2) {
                                    i10 = Math.round(((Integer.valueOf(split2[1]).intValue() * min) * 1.0f) / Integer.valueOf(split2[0]).intValue());
                                    break;
                                }
                                i10 = i3;
                                break;
                            } else {
                                i10 = Math.round((min * 4.0f) / 3.0f);
                                break;
                            }
                        case 25:
                            int f7 = xe2.f(context, 2);
                            i11 = ((i8 - (i4 * 2)) - ((f7 - 1) * i5)) / f7;
                            int a2 = b80.k() ? d32.a(context, 52.0f) : context.getResources().getDimensionPixelSize(R$dimen.l2s5_bottom_height);
                            if (FontModeManager.getInstance().isNeedChangeLayout()) {
                                a2 = (int) (a2 * FontModeManager.getInstance().getIconScale());
                            }
                            if (!TextUtils.isEmpty(str)) {
                                String[] split3 = str.split(":");
                                if (split3.length == 2) {
                                    round = Math.round((((Integer.valueOf(split3[1]).intValue() * i11) * 1.0f) / Integer.valueOf(split3[0]).intValue()) + a2);
                                }
                                round = i3;
                            } else {
                                round = Math.round((((i11 * 9) * 1.0f) / 16.0f) + a2);
                            }
                            int i132 = i11;
                            i10 = round;
                            min = i132;
                            break;
                        default:
                            min = i2;
                            i10 = i3;
                            break;
                    }
            }
        } else if (d32.i(context)) {
            int f8 = xe2.f(context, 4);
            f = ((i8 - i4) - (f8 * i5)) / (f8 + 0.5f);
            min = (int) f;
            i10 = i3;
        } else {
            min = (int) (((Math.min(i8, i9) - i4) - (i5 * 4)) / 4.5f);
            i10 = i3;
        }
        x22Var2.h(min);
        x22Var2.g(i10);
        x22Var2.f(i8);
        x22Var2.e(i9);
        return x22Var2;
    }
}
