package tb;

import java.lang.ref.ReferenceQueue;
import java.lang.ref.WeakReference;
import kotlin.jvm.JvmField;
import org.jetbrains.annotations.Nullable;

/* compiled from: Taobao */
/* loaded from: classes9.dex */
public final class bw0<T> extends WeakReference<T> {
    @JvmField
    public final int a;

    public bw0(T t, @Nullable ReferenceQueue<T> referenceQueue) {
        super(t, referenceQueue);
        this.a = t != null ? t.hashCode() : 0;
    }
}
