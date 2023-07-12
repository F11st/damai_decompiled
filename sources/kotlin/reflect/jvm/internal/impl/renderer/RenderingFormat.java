package kotlin.reflect.jvm.internal.impl.renderer;

import kotlin.text.C8604o;
import org.jetbrains.annotations.NotNull;
import tb.b41;
import tb.jn1;
import tb.k50;

/* compiled from: Taobao */
/* loaded from: classes3.dex */
public enum RenderingFormat {
    PLAIN { // from class: kotlin.reflect.jvm.internal.impl.renderer.RenderingFormat.PLAIN
        @Override // kotlin.reflect.jvm.internal.impl.renderer.RenderingFormat
        @NotNull
        public String escape(@NotNull String str) {
            b41.i(str, "string");
            return str;
        }
    },
    HTML { // from class: kotlin.reflect.jvm.internal.impl.renderer.RenderingFormat.HTML
        @Override // kotlin.reflect.jvm.internal.impl.renderer.RenderingFormat
        @NotNull
        public String escape(@NotNull String str) {
            String z;
            String z2;
            b41.i(str, "string");
            z = C8604o.z(str, jn1.L, "&lt;", false, 4, null);
            z2 = C8604o.z(z, jn1.G, "&gt;", false, 4, null);
            return z2;
        }
    };

    /* synthetic */ RenderingFormat(k50 k50Var) {
        this();
    }

    @NotNull
    public abstract String escape(@NotNull String str);
}
