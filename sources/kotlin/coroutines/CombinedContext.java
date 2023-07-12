package kotlin.coroutines;

import com.taobao.alivfssdk.utils.AVFSCacheConstants;
import java.io.Serializable;
import kotlin.SinceKotlin;
import kotlin.coroutines.CoroutineContext;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Ref$IntRef;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import tb.b41;
import tb.jn1;
import tb.k50;
import tb.wt2;

/* compiled from: Taobao */
@SinceKotlin(version = "1.3")
/* loaded from: classes3.dex */
public final class CombinedContext implements Serializable, CoroutineContext {
    @NotNull
    private final CoroutineContext.Element element;
    @NotNull
    private final CoroutineContext left;

    /* compiled from: Taobao */
    /* loaded from: classes3.dex */
    private static final class Serialized implements Serializable {
        @NotNull
        public static final a Companion = new a(null);
        private static final long serialVersionUID = 0;
        @NotNull
        private final CoroutineContext[] elements;

        /* compiled from: Taobao */
        /* loaded from: classes3.dex */
        public static final class a {
            private a() {
            }

            public /* synthetic */ a(k50 k50Var) {
                this();
            }
        }

        public Serialized(@NotNull CoroutineContext[] coroutineContextArr) {
            b41.i(coroutineContextArr, "elements");
            this.elements = coroutineContextArr;
        }

        private final Object readResolve() {
            CoroutineContext[] coroutineContextArr = this.elements;
            CoroutineContext coroutineContext = EmptyCoroutineContext.INSTANCE;
            for (CoroutineContext coroutineContext2 : coroutineContextArr) {
                coroutineContext = coroutineContext.plus(coroutineContext2);
            }
            return coroutineContext;
        }

        @NotNull
        public final CoroutineContext[] getElements() {
            return this.elements;
        }
    }

    public CombinedContext(@NotNull CoroutineContext coroutineContext, @NotNull CoroutineContext.Element element) {
        b41.i(coroutineContext, "left");
        b41.i(element, "element");
        this.left = coroutineContext;
        this.element = element;
    }

    private final boolean contains(CoroutineContext.Element element) {
        return b41.d(get(element.getKey()), element);
    }

    private final boolean containsAll(CombinedContext combinedContext) {
        while (contains(combinedContext.element)) {
            CoroutineContext coroutineContext = combinedContext.left;
            if (coroutineContext instanceof CombinedContext) {
                combinedContext = (CombinedContext) coroutineContext;
            } else {
                b41.g(coroutineContext, "null cannot be cast to non-null type kotlin.coroutines.CoroutineContext.Element");
                return contains((CoroutineContext.Element) coroutineContext);
            }
        }
        return false;
    }

    private final int size() {
        int i = 2;
        CombinedContext combinedContext = this;
        while (true) {
            CoroutineContext coroutineContext = combinedContext.left;
            combinedContext = coroutineContext instanceof CombinedContext ? (CombinedContext) coroutineContext : null;
            if (combinedContext == null) {
                return i;
            }
            i++;
        }
    }

    private final Object writeReplace() {
        int size = size();
        final CoroutineContext[] coroutineContextArr = new CoroutineContext[size];
        final Ref$IntRef ref$IntRef = new Ref$IntRef();
        fold(wt2.INSTANCE, new Function2<wt2, CoroutineContext.Element, wt2>() { // from class: kotlin.coroutines.CombinedContext$writeReplace$1
            /* JADX INFO: Access modifiers changed from: package-private */
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(2);
            }

            @Override // kotlin.jvm.functions.Function2
            public /* bridge */ /* synthetic */ wt2 invoke(wt2 wt2Var, CoroutineContext.Element element) {
                invoke2(wt2Var, element);
                return wt2.INSTANCE;
            }

            /* renamed from: invoke  reason: avoid collision after fix types in other method */
            public final void invoke2(@NotNull wt2 wt2Var, @NotNull CoroutineContext.Element element) {
                b41.i(wt2Var, "<anonymous parameter 0>");
                b41.i(element, "element");
                CoroutineContext[] coroutineContextArr2 = coroutineContextArr;
                Ref$IntRef ref$IntRef2 = ref$IntRef;
                int i = ref$IntRef2.element;
                ref$IntRef2.element = i + 1;
                coroutineContextArr2[i] = element;
            }
        });
        if (ref$IntRef.element == size) {
            return new Serialized(coroutineContextArr);
        }
        throw new IllegalStateException("Check failed.".toString());
    }

    public boolean equals(@Nullable Object obj) {
        if (this != obj) {
            if (obj instanceof CombinedContext) {
                CombinedContext combinedContext = (CombinedContext) obj;
                if (combinedContext.size() != size() || !combinedContext.containsAll(this)) {
                }
            }
            return false;
        }
        return true;
    }

    @Override // kotlin.coroutines.CoroutineContext
    public <R> R fold(R r, @NotNull Function2<? super R, ? super CoroutineContext.Element, ? extends R> function2) {
        b41.i(function2, "operation");
        return function2.invoke((Object) this.left.fold(r, function2), this.element);
    }

    @Override // kotlin.coroutines.CoroutineContext
    @Nullable
    public <E extends CoroutineContext.Element> E get(@NotNull CoroutineContext.Key<E> key) {
        b41.i(key, "key");
        CombinedContext combinedContext = this;
        while (true) {
            E e = (E) combinedContext.element.get(key);
            if (e != null) {
                return e;
            }
            CoroutineContext coroutineContext = combinedContext.left;
            if (coroutineContext instanceof CombinedContext) {
                combinedContext = (CombinedContext) coroutineContext;
            } else {
                return (E) coroutineContext.get(key);
            }
        }
    }

    public int hashCode() {
        return this.left.hashCode() + this.element.hashCode();
    }

    @Override // kotlin.coroutines.CoroutineContext
    @NotNull
    public CoroutineContext minusKey(@NotNull CoroutineContext.Key<?> key) {
        b41.i(key, "key");
        if (this.element.get(key) != null) {
            return this.left;
        }
        CoroutineContext minusKey = this.left.minusKey(key);
        return minusKey == this.left ? this : minusKey == EmptyCoroutineContext.INSTANCE ? this.element : new CombinedContext(minusKey, this.element);
    }

    @Override // kotlin.coroutines.CoroutineContext
    @NotNull
    public CoroutineContext plus(@NotNull CoroutineContext coroutineContext) {
        return CoroutineContext.DefaultImpls.a(this, coroutineContext);
    }

    @NotNull
    public String toString() {
        return jn1.ARRAY_START + ((String) fold("", new Function2<String, CoroutineContext.Element, String>() { // from class: kotlin.coroutines.CombinedContext$toString$1
            @Override // kotlin.jvm.functions.Function2
            @NotNull
            public final String invoke(@NotNull String str, @NotNull CoroutineContext.Element element) {
                b41.i(str, "acc");
                b41.i(element, "element");
                if (str.length() == 0) {
                    return element.toString();
                }
                return str + AVFSCacheConstants.COMMA_SEP + element;
            }
        })) + jn1.ARRAY_END;
    }
}
