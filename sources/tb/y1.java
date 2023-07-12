package tb;

import java.util.AbstractCollection;
import java.util.Collection;
import kotlin.SinceKotlin;

/* compiled from: Taobao */
@SinceKotlin(version = "1.1")
/* loaded from: classes3.dex */
public abstract class y1<E> extends AbstractCollection<E> implements Collection<E> {
    public abstract int a();

    @Override // java.util.AbstractCollection, java.util.Collection
    public final /* bridge */ int size() {
        return a();
    }
}
