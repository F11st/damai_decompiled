package tb;

import com.google.common.annotations.GwtCompatible;
import java.util.NoSuchElementException;
import org.checkerframework.checker.nullness.compatqual.NullableDecl;

/* compiled from: Taobao */
@GwtCompatible
/* loaded from: classes10.dex */
public abstract class g2<T> extends yt2<T> {
    @NullableDecl
    private T a;

    /* JADX INFO: Access modifiers changed from: protected */
    public g2(@NullableDecl T t) {
        this.a = t;
    }

    @NullableDecl
    protected abstract T a(T t);

    @Override // java.util.Iterator
    public final boolean hasNext() {
        return this.a != null;
    }

    @Override // java.util.Iterator
    public final T next() {
        if (hasNext()) {
            try {
                T t = this.a;
                this.a = a(t);
                return t;
            } catch (Throwable th) {
                this.a = a(this.a);
                throw th;
            }
        }
        throw new NoSuchElementException();
    }
}
