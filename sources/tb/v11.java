package tb;

import android.text.SpannableString;
import android.text.SpannableStringBuilder;
import com.alibaba.pictures.bricks.coupon.view.ImageConfig;
import com.alibaba.pictures.bricks.util.htmlparser.HtmlParserManager;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import java.util.ArrayList;
import java.util.List;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: Taobao */
/* loaded from: classes7.dex */
public final class v11 {
    private static transient /* synthetic */ IpChange $ipChange;
    @NotNull
    public static final v11 INSTANCE = new v11();

    private v11() {
    }

    private final String a(String str, int i) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "625499111")) {
            return (String) ipChange.ipc$dispatch("625499111", new Object[]{this, str, Integer.valueOf(i)});
        }
        x11 x11Var = x11.INSTANCE;
        ImageConfig b = x11Var.b(str, -1, -1);
        b.m(false);
        b.o(true);
        b.l(ImageConfig.DMImageCropType.cy500);
        b.k(i);
        return x11Var.c(str, b);
    }

    private final boolean b(int i, int i2) {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "-56233250") ? ((Boolean) ipChange.ipc$dispatch("-56233250", new Object[]{this, Integer.valueOf(i), Integer.valueOf(i2)})).booleanValue() : i > 0 && i2 > 0 && ((long) (i2 * i)) > 640000;
    }

    private final List<HtmlParserManager.C3555b> d(HtmlParserManager.C3555b c3555b, int i) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1881265819")) {
            return (List) ipChange.ipc$dispatch("1881265819", new Object[]{this, c3555b, Integer.valueOf(i)});
        }
        ArrayList arrayList = new ArrayList();
        if (b(c3555b.c(), c3555b.b()) && x11.INSTANCE.d(String.valueOf(c3555b.a()))) {
            int b = c3555b.b() / 500;
            if (c3555b.b() % 500 > 0) {
                b++;
            }
            for (int i2 = 0; i2 < b; i2++) {
                String a = a(String.valueOf(c3555b.a()), i2);
                if (!a.equals(String.valueOf(c3555b.a()))) {
                    HtmlParserManager.C3555b c3555b2 = new HtmlParserManager.C3555b();
                    c3555b2.m(c3555b.f());
                    c3555b2.l(i);
                    c3555b2.h(new SpannableStringBuilder().append((CharSequence) new SpannableString(a)));
                    arrayList.add(c3555b2);
                }
            }
        } else {
            arrayList.add(c3555b);
        }
        return arrayList;
    }

    @NotNull
    public final List<HtmlParserManager.C3555b> c(@Nullable List<HtmlParserManager.C3555b> list) {
        IpChange ipChange = $ipChange;
        int i = 0;
        if (AndroidInstantRuntime.support(ipChange, "-1991370257")) {
            return (List) ipChange.ipc$dispatch("-1991370257", new Object[]{this, list});
        }
        ArrayList arrayList = new ArrayList();
        if (list != null) {
            for (HtmlParserManager.C3555b c3555b : list) {
                if (c3555b.f() == 2) {
                    arrayList.addAll(INSTANCE.d(c3555b, i));
                } else {
                    arrayList.add(c3555b);
                }
                i++;
            }
        }
        return arrayList;
    }
}
