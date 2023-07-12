package kotlin;

import org.jetbrains.annotations.NotNull;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: Taobao */
/* loaded from: classes3.dex */
public class c extends b {
    @NotNull
    public static <T> Lazy<T> c(T t) {
        return new InitializedLazyImpl(t);
    }
}
