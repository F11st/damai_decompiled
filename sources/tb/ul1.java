package tb;

import io.reactivex.annotations.NonNull;
import io.reactivex.annotations.Nullable;
import io.reactivex.internal.functions.ObjectHelper;
import io.reactivex.internal.util.NotificationLite;

/* compiled from: Taobao */
/* loaded from: classes3.dex */
public final class ul1<T> {
    static final ul1<Object> b = new ul1<>(null);
    final Object a;

    private ul1(Object obj) {
        this.a = obj;
    }

    @NonNull
    public static <T> ul1<T> a() {
        return (ul1<T>) b;
    }

    @NonNull
    public static <T> ul1<T> b(@NonNull Throwable th) {
        ObjectHelper.requireNonNull(th, "error is null");
        return new ul1<>(NotificationLite.error(th));
    }

    @NonNull
    public static <T> ul1<T> c(@NonNull T t) {
        ObjectHelper.requireNonNull(t, "value is null");
        return new ul1<>(t);
    }

    @Nullable
    public Throwable d() {
        Object obj = this.a;
        if (NotificationLite.isError(obj)) {
            return NotificationLite.getError(obj);
        }
        return null;
    }

    @Nullable
    public T e() {
        Object obj = this.a;
        if (obj == null || NotificationLite.isError(obj)) {
            return null;
        }
        return (T) this.a;
    }

    public boolean equals(Object obj) {
        if (obj instanceof ul1) {
            return ObjectHelper.equals(this.a, ((ul1) obj).a);
        }
        return false;
    }

    public boolean f() {
        return this.a == null;
    }

    public boolean g() {
        return NotificationLite.isError(this.a);
    }

    public boolean h() {
        Object obj = this.a;
        return (obj == null || NotificationLite.isError(obj)) ? false : true;
    }

    public int hashCode() {
        Object obj = this.a;
        if (obj != null) {
            return obj.hashCode();
        }
        return 0;
    }

    public String toString() {
        Object obj = this.a;
        if (obj == null) {
            return "OnCompleteNotification";
        }
        if (NotificationLite.isError(obj)) {
            return "OnErrorNotification[" + NotificationLite.getError(obj) + jn1.ARRAY_END_STR;
        }
        return "OnNextNotification[" + this.a + jn1.ARRAY_END_STR;
    }
}
