package kotlin.collections;

import java.util.Iterator;
import java.util.NoSuchElementException;
import kotlin.jvm.internal.markers.KMappedMarker;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: Taobao */
/* loaded from: classes3.dex */
public abstract class a<T> implements Iterator<T>, KMappedMarker {
    @NotNull
    private State a = State.NotReady;
    @Nullable
    private T b;

    /* compiled from: Taobao */
    /* renamed from: kotlin.collections.a$a  reason: collision with other inner class name */
    /* loaded from: classes3.dex */
    public /* synthetic */ class C0409a {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;

        static {
            int[] iArr = new int[State.values().length];
            iArr[State.Done.ordinal()] = 1;
            iArr[State.Ready.ordinal()] = 2;
            $EnumSwitchMapping$0 = iArr;
        }
    }

    private final boolean d() {
        this.a = State.Failed;
        a();
        return this.a == State.Ready;
    }

    protected abstract void a();

    /* JADX INFO: Access modifiers changed from: protected */
    public final void b() {
        this.a = State.Done;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final void c(T t) {
        this.b = t;
        this.a = State.Ready;
    }

    @Override // java.util.Iterator
    public boolean hasNext() {
        State state = this.a;
        if (state != State.Failed) {
            int i = C0409a.$EnumSwitchMapping$0[state.ordinal()];
            if (i != 1) {
                if (i != 2) {
                    return d();
                }
                return true;
            }
            return false;
        }
        throw new IllegalArgumentException("Failed requirement.".toString());
    }

    @Override // java.util.Iterator
    public T next() {
        if (hasNext()) {
            this.a = State.NotReady;
            return this.b;
        }
        throw new NoSuchElementException();
    }

    @Override // java.util.Iterator
    public void remove() {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }
}
