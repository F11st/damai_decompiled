package kotlin.text;

import java.util.Iterator;
import kotlin.collections.AbstractCollection;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.jvm.functions.Function1;
import kotlin.sequences.Sequence;
import kotlin.sequences.SequencesKt___SequencesKt;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import tb.b41;
import tb.md1;
import tb.n31;
import tb.ts1;

/* compiled from: Taobao */
/* loaded from: classes3.dex */
public final class MatcherMatchResult$groups$1 extends AbstractCollection<md1> implements MatchNamedGroupCollection {
    final /* synthetic */ MatcherMatchResult a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public MatcherMatchResult$groups$1(MatcherMatchResult matcherMatchResult) {
        this.a = matcherMatchResult;
    }

    @Override // kotlin.collections.AbstractCollection
    public int a() {
        return this.a.b().groupCount() + 1;
    }

    public /* bridge */ boolean b(md1 md1Var) {
        return super.contains(md1Var);
    }

    @Override // kotlin.collections.AbstractCollection, java.util.Collection
    public final /* bridge */ boolean contains(Object obj) {
        if (obj == null ? true : obj instanceof md1) {
            return b((md1) obj);
        }
        return false;
    }

    @Override // kotlin.text.MatchGroupCollection
    @Nullable
    public md1 get(int i) {
        n31 i2;
        i2 = e.i(this.a.b(), i);
        if (i2.getStart().intValue() >= 0) {
            String group = this.a.b().group(i);
            b41.h(group, "matchResult.group(index)");
            return new md1(group, i2);
        }
        return null;
    }

    @Override // kotlin.collections.AbstractCollection, java.util.Collection
    public boolean isEmpty() {
        return false;
    }

    @Override // java.util.Collection, java.lang.Iterable
    @NotNull
    public Iterator<md1> iterator() {
        n31 h;
        Sequence I;
        Sequence v;
        h = kotlin.collections.m.h(this);
        I = CollectionsKt___CollectionsKt.I(h);
        v = SequencesKt___SequencesKt.v(I, new Function1<Integer, md1>() { // from class: kotlin.text.MatcherMatchResult$groups$1$iterator$1
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ md1 invoke(Integer num) {
                return invoke(num.intValue());
            }

            @Nullable
            public final md1 invoke(int i) {
                return MatcherMatchResult$groups$1.this.get(i);
            }
        });
        return v.iterator();
    }

    @Override // kotlin.text.MatchNamedGroupCollection
    @Nullable
    public md1 get(@NotNull String str) {
        b41.i(str, "name");
        return ts1.IMPLEMENTATIONS.c(this.a.b(), str);
    }
}
