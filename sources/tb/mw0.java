package tb;

import android.graphics.Paint;
import android.graphics.Typeface;
import android.text.style.LineBackgroundSpan;
import android.text.style.LineHeightSpan;
import android.text.style.MetricAffectingSpan;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: Taobao */
/* loaded from: classes7.dex */
public final class mw0 extends MetricAffectingSpan implements LineBackgroundSpan, LineHeightSpan {
    private static transient /* synthetic */ IpChange $ipChange;
    @NotNull
    public static final a Companion = new a(null);

    /* compiled from: Taobao */
    /* loaded from: classes7.dex */
    public static final class a {
        private static transient /* synthetic */ IpChange $ipChange;

        private a() {
        }

        public /* synthetic */ a(k50 k50Var) {
            this();
        }

        public final void a(@Nullable Paint paint, int i) {
            Typeface create;
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "-1499252879")) {
                ipChange.ipc$dispatch("-1499252879", new Object[]{this, paint, Integer.valueOf(i)});
                return;
            }
            Typeface typeface = paint != null ? paint.getTypeface() : null;
            int style = i | (typeface != null ? typeface.getStyle() : 0);
            if (typeface == null) {
                create = Typeface.defaultFromStyle(style);
                b41.h(create, "{\n                Typefa…Style(want)\n            }");
            } else {
                create = Typeface.create(typeface, style);
                b41.h(create, "{\n                Typefa…(old, want)\n            }");
            }
            int i2 = style & (~create.getStyle());
            if ((i2 & 1) != 0) {
                b41.f(paint);
                paint.setFakeBoldText(true);
            }
            if ((i2 & 2) != 0) {
                b41.f(paint);
                paint.setTextSkewX(-0.25f);
            }
            b41.f(paint);
            paint.setTypeface(create);
        }
    }
}
