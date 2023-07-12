package tb;

import android.animation.Animator;
import android.animation.ValueAnimator;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.text.TextUtils;
import android.view.View;
import android.view.animation.Interpolator;
import android.view.animation.LinearInterpolator;
import androidx.annotation.Nullable;
import androidx.core.view.animation.PathInterpolatorCompat;
import com.taobao.weex.common.Constants;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/* compiled from: Taobao */
/* loaded from: classes11.dex */
public class y10 {
    public static final int FUNC_EASE = 4;
    public static final int FUNC_EASE_IN = 1;
    public static final int FUNC_EASE_IN_OUT = 3;
    public static final int FUNC_EASE_OUT = 2;
    public static final int FUNC_LINEAR = 0;
    public static final int PROP_BACKGROUND_COLOR = 2;
    public static final int PROP_OPACITY = 1;
    public static final int PROP_TRANSFORM = 0;

    /* compiled from: Taobao */
    /* renamed from: tb.y10$a */
    /* loaded from: classes11.dex */
    static class C9944a implements ValueAnimator.AnimatorUpdateListener {
        final /* synthetic */ float a;
        final /* synthetic */ float b;
        final /* synthetic */ View c;

        C9944a(float f, float f2, View view) {
            this.a = f;
            this.b = f2;
            this.c = view;
        }

        @Override // android.animation.ValueAnimator.AnimatorUpdateListener
        public void onAnimationUpdate(ValueAnimator valueAnimator) {
            try {
                float f = this.a;
                this.c.setAlpha(f + ((this.b - f) * ((Float) valueAnimator.getAnimatedValue()).floatValue()));
            } catch (Exception unused) {
            }
        }
    }

    /* compiled from: Taobao */
    /* renamed from: tb.y10$b */
    /* loaded from: classes11.dex */
    static class C9945b implements Animator.AnimatorListener {
        final /* synthetic */ View a;
        final /* synthetic */ float b;

        C9945b(View view, float f) {
            this.a = view;
            this.b = f;
        }

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationCancel(Animator animator) {
            this.a.setAlpha(this.b);
        }

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationEnd(Animator animator) {
            this.a.setAlpha(this.b);
        }

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationRepeat(Animator animator) {
        }

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationStart(Animator animator) {
        }
    }

    /* compiled from: Taobao */
    /* renamed from: tb.y10$c */
    /* loaded from: classes11.dex */
    static class C9946c implements ValueAnimator.AnimatorUpdateListener {
        final /* synthetic */ int a;
        final /* synthetic */ int b;
        final /* synthetic */ View c;

        C9946c(int i, int i2, View view) {
            this.a = i;
            this.b = i2;
            this.c = view;
        }

        @Override // android.animation.ValueAnimator.AnimatorUpdateListener
        public void onAnimationUpdate(ValueAnimator valueAnimator) {
            try {
                float floatValue = ((Float) valueAnimator.getAnimatedValue()).floatValue();
                if (floatValue == 0.0f) {
                    return;
                }
                int red = Color.red(this.a);
                int green = Color.green(this.a);
                int blue = Color.blue(this.a);
                int alpha = Color.alpha(this.a);
                this.c.setBackgroundColor(Color.argb((int) (alpha + ((Color.alpha(this.b) - alpha) * floatValue)), (int) (red + ((Color.red(this.b) - red) * floatValue)), (int) (green + ((Color.green(this.b) - green) * floatValue)), (int) (blue + ((Color.blue(this.b) - blue) * floatValue))));
            } catch (Exception unused) {
            }
        }
    }

    /* compiled from: Taobao */
    /* renamed from: tb.y10$d */
    /* loaded from: classes11.dex */
    static class C9947d implements Animator.AnimatorListener {
        final /* synthetic */ View a;
        final /* synthetic */ int b;

        C9947d(View view, int i) {
            this.a = view;
            this.b = i;
        }

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationCancel(Animator animator) {
            this.a.setBackgroundColor(this.b);
        }

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationEnd(Animator animator) {
            this.a.setBackgroundColor(this.b);
        }

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationRepeat(Animator animator) {
        }

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationStart(Animator animator) {
        }
    }

    /* compiled from: Taobao */
    /* renamed from: tb.y10$e */
    /* loaded from: classes11.dex */
    public static class C9948e {
        public final int a;
        public final long b;
        public final long c;
        public final int d;

        public C9948e(int i, long j, long j2, int i2) {
            this.a = i;
            this.b = j;
            this.c = j2;
            this.d = i2;
        }

        public String toString() {
            return "TransitionProp{prop=" + this.a + ", delayInMs=" + this.b + ", durationInMs=" + this.c + ", func=" + this.d + '}';
        }
    }

    public static Interpolator a(int i) {
        if (i != 1) {
            if (i != 2) {
                if (i != 3) {
                    if (i != 4) {
                        return new LinearInterpolator();
                    }
                    return PathInterpolatorCompat.create(0.25f, 0.1f, 0.25f, 1.0f);
                }
                return PathInterpolatorCompat.create(0.42f, 0.0f, 0.58f, 1.0f);
            }
            return PathInterpolatorCompat.create(0.0f, 0.0f, 0.58f, 1.0f);
        }
        return PathInterpolatorCompat.create(0.42f, 0.0f, 1.0f, 1.0f);
    }

    private static int b(String str) {
        if (str == null) {
            return 0;
        }
        char c = 65535;
        switch (str.hashCode()) {
            case -1965120668:
                if (str.equals("ease-in")) {
                    c = 0;
                    break;
                }
                break;
            case -1102672091:
                if (str.equals("linear")) {
                    c = 4;
                    break;
                }
                break;
            case -789192465:
                if (str.equals("ease-out")) {
                    c = 1;
                    break;
                }
                break;
            case -361990811:
                if (str.equals("ease-in-out")) {
                    c = 2;
                    break;
                }
                break;
            case 3105774:
                if (str.equals(Constants.TimeFunction.EASE)) {
                    c = 3;
                    break;
                }
                break;
        }
        if (c != 0) {
            if (c != 1) {
                if (c != 2) {
                    return c != 3 ? 0 : 4;
                }
                return 3;
            }
            return 2;
        }
        return 1;
    }

    private static int c(String str) {
        if (str != null) {
            char c = 65535;
            switch (str.hashCode()) {
                case -1267206133:
                    if (str.equals("opacity")) {
                        c = 0;
                        break;
                    }
                    break;
                case 605322756:
                    if (str.equals("background-color")) {
                        c = 1;
                        break;
                    }
                    break;
                case 1052666732:
                    if (str.equals("transform")) {
                        c = 2;
                        break;
                    }
                    break;
            }
            switch (c) {
                case 0:
                    return 1;
                case 1:
                    return 2;
                case 2:
                    return 0;
                default:
                    throw new IllegalArgumentException("Invalid Transition prop: " + str);
            }
        }
        throw new IllegalArgumentException("Invalid Transition prop: " + str);
    }

    private static ValueAnimator d(C9948e c9948e) {
        ValueAnimator ofFloat = ValueAnimator.ofFloat(0.0f, 1.0f);
        ofFloat.setDuration(c9948e.c);
        ofFloat.setStartDelay(c9948e.b);
        ofFloat.setInterpolator(a(c9948e.d));
        return ofFloat;
    }

    @Nullable
    public static List<C9948e> e(@Nullable String str, @Nullable String str2, @Nullable String str3, @Nullable String str4, @Nullable String str5) {
        long j;
        int i;
        boolean isEmpty = TextUtils.isEmpty(str);
        boolean isEmpty2 = TextUtils.isEmpty(str2);
        String[] strArr = null;
        if (isEmpty && isEmpty2) {
            return null;
        }
        if (!isEmpty) {
            String[] split = str.split(",");
            LinkedList linkedList = new LinkedList();
            for (String str6 : split) {
                String[] split2 = str6.trim().split("\\s");
                if (split2.length == 3) {
                    linkedList.add(new C9948e(c(split2[0].trim()), 0L, f(split2[1].trim()), b(split2[2].trim())));
                } else {
                    throw new IllegalArgumentException("split by space array's length != 3");
                }
            }
            return linkedList;
        } else if (TextUtils.isEmpty(str3)) {
            return null;
        } else {
            String[] split3 = str2.split(",");
            String[] split4 = str3.split(",");
            String[] split5 = TextUtils.isEmpty(str4) ? null : str4.split(",");
            String[] split6 = TextUtils.isEmpty(str5) ? null : str5.split(",");
            if (split4.length == 1 || split4.length == split3.length) {
                if (split5 != null && split5.length != 1 && split5.length != split3.length) {
                    split5 = null;
                }
                if (split6 == null || split6.length == 1 || split6.length == split3.length) {
                    strArr = split6;
                }
                LinkedList linkedList2 = new LinkedList();
                for (int i2 = 0; i2 < split3.length; i2++) {
                    int c = c(split3[i2].trim());
                    long f = f((split4.length != split3.length ? split4[0] : split4[i2]).trim());
                    if (split5 != null) {
                        j = f((split5.length != split3.length ? split5[0] : split5[i2]).trim());
                    } else {
                        j = 0;
                    }
                    long j2 = j;
                    if (strArr != null) {
                        i = b((strArr.length != split3.length ? strArr[0] : strArr[i2]).trim());
                    } else {
                        i = 0;
                    }
                    linkedList2.add(new C9948e(c, j2, f, i));
                }
                return linkedList2;
            }
            return null;
        }
    }

    private static long f(String str) {
        float parseFloat;
        if (str.endsWith("ms")) {
            parseFloat = Float.parseFloat(str.substring(0, str.length() - 2));
        } else if (str.endsWith("s")) {
            parseFloat = Float.parseFloat(str.substring(0, str.length() - 1)) * 1000.0f;
        } else {
            throw new IllegalArgumentException("Invalid transition time: " + str);
        }
        return parseFloat;
    }

    public static List<Animator> g(List<C9948e> list, View view, float f, int i) {
        ArrayList arrayList = new ArrayList();
        if (list != null && list.size() > 0) {
            boolean z = false;
            loop0: while (true) {
                boolean z2 = false;
                for (C9948e c9948e : list) {
                    int i2 = c9948e.a;
                    if (i2 != 1) {
                        if (i2 == 2 && !z2) {
                            int i3 = 16777215;
                            if (view.getBackground() instanceof ColorDrawable) {
                                i3 = ((ColorDrawable) view.getBackground()).getColor();
                            }
                            if (i == i3) {
                                break;
                            }
                            ValueAnimator d = d(c9948e);
                            d.addUpdateListener(new C9946c(i3, i, view));
                            d.addListener(new C9947d(view, i));
                            arrayList.add(d);
                            z2 = true;
                        }
                    } else if (!z) {
                        float alpha = view.getAlpha();
                        if (Float.compare(alpha, f) == 0) {
                            z = false;
                        } else {
                            ValueAnimator d2 = d(c9948e);
                            d2.addUpdateListener(new C9944a(alpha, f, view));
                            d2.addListener(new C9945b(view, f));
                            arrayList.add(d2);
                            z = true;
                        }
                    }
                }
            }
        }
        return arrayList;
    }
}
