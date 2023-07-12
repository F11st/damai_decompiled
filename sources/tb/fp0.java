package tb;

import com.google.common.annotations.GwtCompatible;
import com.google.errorprone.annotations.CanIgnoreReturnValue;
import java.util.Iterator;

/* compiled from: Taobao */
@GwtCompatible
/* loaded from: classes10.dex */
public abstract class fp0<T> extends com.google.common.collect.t implements Iterator<T> {
    protected abstract Iterator<T> a();

    @Override // java.util.Iterator
    public boolean hasNext() {
        return a().hasNext();
    }

    @CanIgnoreReturnValue
    public T next() {
        return a().next();
    }
}
