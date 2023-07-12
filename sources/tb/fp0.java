package tb;

import com.google.common.annotations.GwtCompatible;
import com.google.common.collect.AbstractC5205t;
import com.google.errorprone.annotations.CanIgnoreReturnValue;
import java.util.Iterator;

/* compiled from: Taobao */
@GwtCompatible
/* loaded from: classes10.dex */
public abstract class fp0<T> extends AbstractC5205t implements Iterator<T> {
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
