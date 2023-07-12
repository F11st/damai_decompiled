package kotlin.text;

import kotlin.SinceKotlin;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import tb.b41;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: Taobao */
/* renamed from: kotlin.text.m */
/* loaded from: classes3.dex */
public class C8602m extends C8601l {
    @SinceKotlin(version = "1.1")
    @Nullable
    public static Float h(@NotNull String str) {
        b41.i(str, "<this>");
        try {
            if (C8595f.value.matches(str)) {
                return Float.valueOf(Float.parseFloat(str));
            }
            return null;
        } catch (NumberFormatException unused) {
            return null;
        }
    }
}
