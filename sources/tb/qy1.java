package tb;

import android.os.Build;
import androidx.annotation.NonNull;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import java.lang.Comparable;
import java.util.Arrays;
import java.util.Objects;

/* compiled from: Taobao */
/* loaded from: classes8.dex */
public final class qy1<T extends Comparable<? super T>> {
    private static transient /* synthetic */ IpChange $ipChange;
    private final T a;
    private final T b;

    public qy1(@NonNull T t, @NonNull T t2) {
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

    public static <T extends Comparable<? super T>> qy1<T> a(T t, T t2) {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "-986488266") ? (qy1) ipChange.ipc$dispatch("-986488266", new Object[]{t, t2}) : new qy1<>(t, t2);
    }

    public T b() {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "-1846022397") ? (T) ipChange.ipc$dispatch("-1846022397", new Object[]{this}) : this.a;
    }

    public boolean equals(Object obj) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1171354912")) {
            return ((Boolean) ipChange.ipc$dispatch("-1171354912", new Object[]{this, obj})).booleanValue();
        }
        if (obj == null) {
            return false;
        }
        if (this == obj) {
            return true;
        }
        if (obj instanceof qy1) {
            qy1 qy1Var = (qy1) obj;
            return this.a.equals(qy1Var.a) && this.b.equals(qy1Var.b);
        }
        return false;
    }

    public int hashCode() {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "1475100311") ? ((Integer) ipChange.ipc$dispatch("1475100311", new Object[]{this})).intValue() : Build.VERSION.SDK_INT >= 19 ? Objects.hash(this.a, this.b) : Arrays.hashCode(new Object[]{this.a, this.b});
    }

    public String toString() {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "-840587699") ? (String) ipChange.ipc$dispatch("-840587699", new Object[]{this}) : String.format("[%s, %s]", this.a, this.b);
    }
}
