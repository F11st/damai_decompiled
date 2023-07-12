package kotlin.collections;

import java.util.List;
import kotlin.PublishedApi;
import kotlin.SinceKotlin;
import kotlin.jvm.JvmName;
import kotlin.jvm.functions.Function1;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: Taobao */
/* renamed from: kotlin.collections.e */
/* loaded from: classes3.dex */
public final class C8202e extends ArraysKt___ArraysKt {
    public static /* bridge */ /* synthetic */ <T> T G(@NotNull T[] tArr) {
        return (T) ArraysKt___ArraysKt.G(tArr);
    }

    @NotNull
    public static /* bridge */ /* synthetic */ <T, R> List<R> J(@NotNull T[] tArr, @NotNull Function1<? super T, ? extends R> function1) {
        return ArraysKt___ArraysKt.J(tArr, function1);
    }

    public static /* bridge */ /* synthetic */ <T> T L(@NotNull T[] tArr) {
        return (T) ArraysKt___ArraysKt.L(tArr);
    }

    @Nullable
    public static /* bridge */ /* synthetic */ <T> T M(@NotNull T[] tArr) {
        return (T) ArraysKt___ArraysKt.M(tArr);
    }

    @SinceKotlin(version = "1.3")
    @NotNull
    public static /* bridge */ /* synthetic */ <T> T[] e(@NotNull T[] tArr, @NotNull T[] tArr2, int i, int i2, int i3) {
        return (T[]) C8207h.e(tArr, tArr2, i, i2, i3);
    }

    public static /* bridge */ /* synthetic */ Object[] f(Object[] objArr, Object[] objArr2, int i, int i2, int i3, int i4, Object obj) {
        return C8207h.f(objArr, objArr2, i, i2, i3, i4, obj);
    }

    @SinceKotlin(version = "1.3")
    @JvmName(name = "copyOfRange")
    @NotNull
    @PublishedApi
    public static /* bridge */ /* synthetic */ <T> T[] h(@NotNull T[] tArr, int i, int i2) {
        return (T[]) C8207h.h(tArr, i, i2);
    }

    public static /* bridge */ /* synthetic */ void i(@NotNull int[] iArr, int i, int i2, int i3) {
        C8207h.i(iArr, i, i2, i3);
    }

    public static /* bridge */ /* synthetic */ <T> T u(@NotNull T[] tArr) {
        return (T) ArraysKt___ArraysKt.u(tArr);
    }

    @Nullable
    public static /* bridge */ /* synthetic */ <T> T v(@NotNull T[] tArr) {
        return (T) ArraysKt___ArraysKt.v(tArr);
    }
}
