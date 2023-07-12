package tb;

import java.util.Iterator;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.markers.KMappedMarker;
import org.jetbrains.annotations.NotNull;

/* compiled from: Taobao */
/* loaded from: classes3.dex */
public final class j21<T> implements Iterable<i21<? extends T>>, KMappedMarker {
    @NotNull
    private final Function0<Iterator<T>> a;

    /* JADX WARN: Multi-variable type inference failed */
    public j21(@NotNull Function0<? extends Iterator<? extends T>> function0) {
        b41.i(function0, "iteratorFactory");
        this.a = function0;
    }

    @Override // java.lang.Iterable
    @NotNull
    public Iterator<i21<T>> iterator() {
        return new k21(this.a.invoke());
    }
}
