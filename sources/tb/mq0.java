package tb;

import android.content.Context;
import android.graphics.Color;
import android.graphics.drawable.GradientDrawable;
import androidx.core.internal.view.SupportMenu;
import androidx.core.view.InputDeviceCompat;
import com.alibaba.gaiax.GXRegisterCenter;
import com.youku.live.livesdk.wkit.component.Constants;
import java.util.List;
import java.util.Objects;
import kotlin.text.StringsKt__StringsKt;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: Taobao */
/* loaded from: classes6.dex */
public final class mq0 {
    public static final int COLOR_TYPE_DYNAMIC = 1;
    public static final int COLOR_TYPE_STATIC = 0;
    @NotNull
    public static final a Companion = new a(null);
    @NotNull
    private static final mq0 c = new mq0(0, 0);
    private final int a;
    @NotNull
    private final Object b;

    /* compiled from: Taobao */
    /* loaded from: classes6.dex */
    public static final class a {
        private a() {
        }

        public /* synthetic */ a(k50 k50Var) {
            this();
        }

        private final String d(String str) {
            boolean s;
            s = kotlin.text.o.s(str);
            if (!s) {
                return str;
            }
            return null;
        }

        private final Integer e(String str) {
            boolean F;
            F = kotlin.text.o.F(str, Constants.TYPE_LIVE_ROOM_BG_COLOR_PREFFIX, false, 2, null);
            if (F) {
                if (str.length() == 9) {
                    String substring = str.substring(7, str.length());
                    b41.h(substring, "(this as java.lang.Strin…ing(startIndex, endIndex)");
                    String substring2 = str.substring(1, str.length() - 2);
                    b41.h(substring2, "(this as java.lang.Strin…ing(startIndex, endIndex)");
                    return Integer.valueOf(Color.parseColor('#' + substring + substring2));
                }
                return Integer.valueOf(Color.parseColor(str));
            }
            return null;
        }

        private final Integer f(String str) {
            boolean F;
            boolean p;
            int f0;
            List t0;
            CharSequence M0;
            CharSequence M02;
            CharSequence M03;
            CharSequence M04;
            F = kotlin.text.o.F(str, "rgba(", false, 2, null);
            if (F) {
                p = kotlin.text.o.p(str, jn1.BRACKET_END_STR, false, 2, null);
                if (p) {
                    f0 = StringsKt__StringsKt.f0(str, jn1.BRACKET_END_STR, 0, false, 6, null);
                    Objects.requireNonNull(str, "null cannot be cast to non-null type java.lang.String");
                    String substring = str.substring(5, f0);
                    b41.h(substring, "(this as java.lang.Strin…ing(startIndex, endIndex)");
                    t0 = StringsKt__StringsKt.t0(substring, new String[]{","}, false, 0, 6, null);
                    String str2 = (String) t0.get(3);
                    Objects.requireNonNull(str2, "null cannot be cast to non-null type kotlin.CharSequence");
                    M0 = StringsKt__StringsKt.M0(str2);
                    String str3 = (String) t0.get(0);
                    Objects.requireNonNull(str3, "null cannot be cast to non-null type kotlin.CharSequence");
                    M02 = StringsKt__StringsKt.M0(str3);
                    int parseInt = Integer.parseInt(M02.toString());
                    String str4 = (String) t0.get(1);
                    Objects.requireNonNull(str4, "null cannot be cast to non-null type kotlin.CharSequence");
                    M03 = StringsKt__StringsKt.M0(str4);
                    int parseInt2 = Integer.parseInt(M03.toString());
                    String str5 = (String) t0.get(2);
                    Objects.requireNonNull(str5, "null cannot be cast to non-null type kotlin.CharSequence");
                    M04 = StringsKt__StringsKt.M0(str5);
                    return Integer.valueOf(Color.argb((int) (Float.parseFloat(M0.toString()) * 255), parseInt, parseInt2, Integer.parseInt(M04.toString())));
                }
            }
            return null;
        }

        private final Integer g(String str) {
            boolean F;
            boolean p;
            int f0;
            List t0;
            CharSequence M0;
            CharSequence M02;
            CharSequence M03;
            F = kotlin.text.o.F(str, "rgb(", false, 2, null);
            if (F) {
                p = kotlin.text.o.p(str, jn1.BRACKET_END_STR, false, 2, null);
                if (p) {
                    f0 = StringsKt__StringsKt.f0(str, jn1.BRACKET_END_STR, 0, false, 6, null);
                    Objects.requireNonNull(str, "null cannot be cast to non-null type java.lang.String");
                    String substring = str.substring(4, f0);
                    b41.h(substring, "(this as java.lang.Strin…ing(startIndex, endIndex)");
                    t0 = StringsKt__StringsKt.t0(substring, new String[]{","}, false, 0, 6, null);
                    String str2 = (String) t0.get(0);
                    Objects.requireNonNull(str2, "null cannot be cast to non-null type kotlin.CharSequence");
                    M0 = StringsKt__StringsKt.M0(str2);
                    int parseInt = Integer.parseInt(M0.toString());
                    String str3 = (String) t0.get(1);
                    Objects.requireNonNull(str3, "null cannot be cast to non-null type kotlin.CharSequence");
                    M02 = StringsKt__StringsKt.M0(str3);
                    int parseInt2 = Integer.parseInt(M02.toString());
                    String str4 = (String) t0.get(2);
                    Objects.requireNonNull(str4, "null cannot be cast to non-null type kotlin.CharSequence");
                    M03 = StringsKt__StringsKt.M0(str4);
                    return Integer.valueOf(Color.rgb(parseInt, parseInt2, Integer.parseInt(M03.toString())));
                }
            }
            return null;
        }

        private final Integer h(String str) {
            boolean q;
            boolean q2;
            boolean q3;
            boolean q4;
            boolean q5;
            boolean q6;
            boolean q7;
            boolean q8;
            boolean q9;
            boolean q10;
            boolean q11;
            boolean q12;
            q = kotlin.text.o.q(str, "BLACK", true);
            if (q) {
                return -16777216;
            }
            q2 = kotlin.text.o.q(str, "DKGRAY", true);
            if (q2) {
                return -12303292;
            }
            q3 = kotlin.text.o.q(str, "GRAY", true);
            if (q3) {
                return -7829368;
            }
            q4 = kotlin.text.o.q(str, "LTGRAY", true);
            if (q4) {
                return -3355444;
            }
            q5 = kotlin.text.o.q(str, "WHITE", true);
            if (q5) {
                return -1;
            }
            q6 = kotlin.text.o.q(str, "RED", true);
            if (q6) {
                return Integer.valueOf((int) SupportMenu.CATEGORY_MASK);
            }
            q7 = kotlin.text.o.q(str, "GREEN", true);
            if (q7) {
                return -16711936;
            }
            q8 = kotlin.text.o.q(str, "BLUE", true);
            if (q8) {
                return -16776961;
            }
            q9 = kotlin.text.o.q(str, "YELLOW", true);
            if (q9) {
                return Integer.valueOf((int) InputDeviceCompat.SOURCE_ANY);
            }
            q10 = kotlin.text.o.q(str, "CYAN", true);
            if (q10) {
                return -16711681;
            }
            q11 = kotlin.text.o.q(str, "MAGENTA", true);
            if (q11) {
                return -65281;
            }
            q12 = kotlin.text.o.q(str, "TRANSPARENT", true);
            return q12 ? 0 : null;
        }

        @Nullable
        public final mq0 a(@NotNull String str) {
            CharSequence M0;
            boolean K;
            List t0;
            b41.i(str, "targetColor");
            M0 = StringsKt__StringsKt.M0(str);
            String obj = M0.toString();
            K = StringsKt__StringsKt.K(obj, "%", false, 2, null);
            if (K) {
                t0 = StringsKt__StringsKt.t0(obj, new String[]{" "}, false, 0, 6, null);
                if (t0.size() == 2) {
                    obj = (String) t0.get(0);
                }
            }
            Integer e = e(obj);
            if (e == null) {
                Integer f = f(obj);
                if (f == null) {
                    Integer g = g(obj);
                    if (g == null) {
                        Integer h = h(obj);
                        if (h == null) {
                            String d = d(obj);
                            if (d == null) {
                                return null;
                            }
                            return new mq0(1, d, null);
                        }
                        return new mq0(0, Integer.valueOf(h.intValue()), null);
                    }
                    return new mq0(0, Integer.valueOf(g.intValue()), null);
                }
                return new mq0(0, Integer.valueOf(f.intValue()), null);
            }
            return new mq0(0, Integer.valueOf(e.intValue()), null);
        }

        @NotNull
        public final mq0 b(@NotNull String str) {
            b41.i(str, "color");
            Integer e = e(str);
            if (e != null) {
                return new mq0(0, Integer.valueOf(e.intValue()), null);
            }
            throw new IllegalArgumentException("Create hex color error");
        }

        @NotNull
        public final mq0 c() {
            return mq0.c;
        }
    }

    private mq0(int i, Object obj) {
        this.a = i;
        this.b = obj;
    }

    public /* synthetic */ mq0(int i, Object obj, k50 k50Var) {
        this(i, obj);
    }

    public static /* synthetic */ int d(mq0 mq0Var, Context context, int i, Object obj) {
        if ((i & 1) != 0) {
            context = null;
        }
        return mq0Var.c(context);
    }

    @Nullable
    public final nq0 b(@Nullable Context context) {
        int c2 = c(context);
        return new nq0(GradientDrawable.Orientation.LEFT_RIGHT, new int[]{c2, c2});
    }

    public final int c(@Nullable Context context) {
        Integer e = e(context);
        if (e == null) {
            return 0;
        }
        return e.intValue();
    }

    @Nullable
    public final Integer e(@Nullable Context context) {
        GXRegisterCenter.GXIExtensionColor c2;
        Integer convert;
        int i = this.a;
        if (i == 0) {
            return (Integer) this.b;
        }
        if (i != 1 || (c2 = GXRegisterCenter.Companion.a().c()) == null || (convert = c2.convert(context, (String) this.b)) == null) {
            return null;
        }
        return Integer.valueOf(convert.intValue());
    }
}
