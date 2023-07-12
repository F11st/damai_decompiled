package tb;

import android.os.Build;
import androidx.annotation.NonNull;
import java.lang.Comparable;
import java.util.Arrays;
import java.util.Objects;

/* compiled from: Taobao */
/* loaded from: classes6.dex */
public final class py1<T extends Comparable<? super T>> {
    private final T a;
    private final T b;

    public py1(@NonNull T t, @NonNull T t2) {
        if (t == null) {
            throw new IllegalArgumentException("lower must not be null");
        }
        if (t2 != null) {
            this.a = t;
            this.b = t2;
            if (t.compareTo(t2) > 0) {
                throw new IllegalArgumentException("lower must be less than or equal to upper");
            }
            return;
        }
        throw new IllegalArgumentException("upper must not be null");
    }

    public static <T extends Comparable<? super T>> py1<T> c(T t, T t2) {
        return new py1<>(t, t2);
    }

    public boolean a(@NonNull T t) {
        if (t != null) {
            return (t.compareTo(this.a) >= 0) && (t.compareTo(this.b) <= 0);
        }
        throw new IllegalArgumentException("value must not be null");
    }

    public boolean b(@NonNull py1<T> py1Var) {
        if (py1Var != null) {
            return (py1Var.a.compareTo(this.a) >= 0) && (py1Var.b.compareTo(this.b) <= 0);
        }
        throw new IllegalArgumentException("value must not be null");
    }

    public T d() {
        return this.a;
    }

    public T e() {
        return this.b;
    }

    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (this == obj) {
            return true;
        }
        if (obj instanceof py1) {
            py1 py1Var = (py1) obj;
            return this.a.equals(py1Var.a) && this.b.equals(py1Var.b);
        }
        return false;
    }

    public int hashCode() {
        return Build.VERSION.SDK_INT >= 19 ? Objects.hash(this.a, this.b) : Arrays.hashCode(new Object[]{this.a, this.b});
    }

    public String toString() {
        return String.format("[%s, %s]", this.a, this.b);
    }
}
