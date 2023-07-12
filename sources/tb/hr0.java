package tb;

import android.content.Context;
import android.graphics.Shader;
import android.graphics.drawable.GradientDrawable;
import android.widget.TextView;
import com.alibaba.gaiax.template.GXStyleConvert;
import java.util.List;
import kotlin.collections.C8214m;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: Taobao */
/* loaded from: classes6.dex */
public final class hr0 {
    @NotNull
    private final GradientDrawable.Orientation a;
    @NotNull
    private final List<mq0> b;

    public hr0(@NotNull GradientDrawable.Orientation orientation, @NotNull List<mq0> list) {
        b41.i(orientation, "direction");
        b41.i(list, "colors");
        this.a = orientation;
        this.b = list;
    }

    private final jr0 b() {
        int i = 0;
        if (this.b.size() == 1) {
            int d = mq0.d(this.b.get(0), null, 1, null);
            return new jr0(this.a, new int[]{d, d});
        }
        int[] iArr = new int[this.b.size()];
        for (Object obj : this.b) {
            int i2 = i + 1;
            if (i < 0) {
                C8214m.p();
            }
            iArr[i] = mq0.d((mq0) obj, null, 1, null);
            i = i2;
        }
        return new jr0(this.a, iArr);
    }

    private final Shader d(TextView textView, float f, float f2) {
        int i = 0;
        if (this.b.size() == 1) {
            int c = this.b.get(0).c(textView.getContext());
            return GXStyleConvert.Companion.a().i(f, f2, this.a, new int[]{c, c});
        }
        int[] iArr = new int[this.b.size()];
        for (Object obj : this.b) {
            int i2 = i + 1;
            if (i < 0) {
                C8214m.p();
            }
            iArr[i] = ((mq0) obj).c(textView.getContext());
            i = i2;
        }
        return GXStyleConvert.Companion.a().i(f, f2, this.a, iArr);
    }

    @Nullable
    public final GradientDrawable a(@Nullable Context context) {
        return b();
    }

    @Nullable
    public final Shader c(@NotNull TextView textView) {
        b41.i(textView, "view");
        return d(textView, textView.getLayoutParams().width, textView.getLayoutParams().height);
    }
}
