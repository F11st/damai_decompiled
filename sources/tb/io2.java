package tb;

import io.reactivex.annotations.NonNull;
import io.reactivex.internal.functions.ObjectHelper;
import java.util.concurrent.TimeUnit;

/* compiled from: Taobao */
/* loaded from: classes3.dex */
public final class io2<T> {
    final T a;
    final long b;
    final TimeUnit c;

    public io2(@NonNull T t, long j, @NonNull TimeUnit timeUnit) {
        this.a = t;
        this.b = j;
        this.c = (TimeUnit) ObjectHelper.requireNonNull(timeUnit, "unit is null");
    }

    public long a() {
        return this.b;
    }

    @NonNull
    public T b() {
        return this.a;
    }

    public boolean equals(Object obj) {
        if (obj instanceof io2) {
            io2 io2Var = (io2) obj;
            return ObjectHelper.equals(this.a, io2Var.a) && this.b == io2Var.b && ObjectHelper.equals(this.c, io2Var.c);
        }
        return false;
    }

    public int hashCode() {
        T t = this.a;
        int hashCode = t != null ? t.hashCode() : 0;
        long j = this.b;
        return (((hashCode * 31) + ((int) (j ^ (j >>> 31)))) * 31) + this.c.hashCode();
    }

    public String toString() {
        return "Timed[time=" + this.b + ", unit=" + this.c + ", value=" + this.a + jn1.ARRAY_END_STR;
    }
}
