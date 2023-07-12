package tb;

import android.content.Context;
import android.view.View;
import com.alibaba.gaiax.render.view.basic.GXIconFont;
import com.alibaba.gaiax.render.view.basic.GXImageView;
import com.alibaba.gaiax.render.view.basic.GXProgressView;
import com.alibaba.gaiax.render.view.basic.GXRichText;
import com.alibaba.gaiax.render.view.basic.GXShadowLayout;
import com.alibaba.gaiax.render.view.basic.GXText;
import com.alibaba.gaiax.render.view.basic.GXView;
import com.alibaba.gaiax.render.view.container.GXGridView;
import com.alibaba.gaiax.render.view.container.GXScrollView;
import com.alibaba.gaiax.render.view.container.slider.GXSliderView;
import com.taobao.weex.ui.component.WXBasicComponentType;
import io.flutter.wpkbridge.WPKFactory;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Objects;
import kotlin.jvm.functions.Function1;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: Taobao */
/* loaded from: classes6.dex */
public final class us0 {
    @NotNull
    public static final us0 INSTANCE = new us0();
    @NotNull
    private static final Map<String, Function1<Context, View>> a = new LinkedHashMap();

    private us0() {
    }

    public static /* synthetic */ View b(us0 us0Var, Context context, String str, String str2, int i, Object obj) {
        if ((i & 4) != 0) {
            str2 = null;
        }
        return us0Var.a(context, str, str2);
    }

    private final <T extends View> View d(String str, Context context) {
        if (str != null) {
            Object newInstance = Class.forName(str).getConstructor(Context.class).newInstance(context);
            Objects.requireNonNull(newInstance, "null cannot be cast to non-null type T of com.alibaba.gaiax.render.view.GXViewFactory.newInstance");
            return (View) newInstance;
        }
        return new GXView(context);
    }

    @NotNull
    public final <T extends View> T a(@NotNull Context context, @NotNull String str, @Nullable String str2) {
        b41.i(context, WPKFactory.INIT_KEY_CONTEXT);
        b41.i(str, "type");
        Map<String, Function1<Context, View>> map = a;
        if (map.containsKey(str)) {
            Function1<Context, View> function1 = map.get(str);
            T t = function1 == null ? null : (T) function1.invoke(context);
            Objects.requireNonNull(t, "null cannot be cast to non-null type T of com.alibaba.gaiax.render.view.GXViewFactory.createView");
            return t;
        } else if (b41.d("custom", str) && str2 != null) {
            return (T) d(str2, context);
        } else {
            switch (str.hashCode()) {
                case -1550589943:
                    if (str.equals(WXBasicComponentType.RICHTEXT)) {
                        return new GXRichText(context);
                    }
                    break;
                case -1001078227:
                    if (str.equals("progress")) {
                        return new GXProgressView(context);
                    }
                    break;
                case -907680051:
                    if (str.equals("scroll")) {
                        return new GXScrollView(context);
                    }
                    break;
                case -903579360:
                    if (str.equals("shadow")) {
                        return new GXShadowLayout(context);
                    }
                    break;
                case -899647263:
                    if (str.equals("slider")) {
                        return new GXSliderView(context);
                    }
                    break;
                case -737385400:
                    if (str.equals("iconfont")) {
                        return new GXIconFont(context);
                    }
                    break;
                case 3181382:
                    if (str.equals("grid")) {
                        return new GXGridView(context);
                    }
                    break;
                case 3556653:
                    if (str.equals("text")) {
                        return new GXText(context);
                    }
                    break;
                case 3619493:
                    if (str.equals("view")) {
                        return new GXView(context);
                    }
                    break;
                case 100313435:
                    if (str.equals("image")) {
                        return new GXImageView(context);
                    }
                    break;
                case 1139459189:
                    if (str.equals("gaia-template")) {
                        return new GXView(context);
                    }
                    break;
            }
            throw new IllegalArgumentException("unknown type");
        }
    }

    @NotNull
    public final Map<String, Function1<Context, View>> c() {
        return a;
    }
}
