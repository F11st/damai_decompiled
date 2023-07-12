package kotlin;

import org.jetbrains.annotations.NotNull;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: Taobao */
/* renamed from: kotlin.c */
/* loaded from: classes3.dex */
public class C8179c extends C8177b {
    @NotNull
    public static <T> Lazy<T> c(T t) {
        return new InitializedLazyImpl(t);
    }
}
