package com.google.common.base;

import com.google.common.annotations.GwtCompatible;
import com.google.errorprone.annotations.CanIgnoreReturnValue;
import java.io.IOException;
import java.util.Arrays;
import java.util.Iterator;
import org.checkerframework.checker.nullness.compatqual.NullableDecl;
import tb.du1;

/* compiled from: Taobao */
@GwtCompatible
/* loaded from: classes10.dex */
public class d {
    private final String a;

    /* compiled from: Taobao */
    /* loaded from: classes10.dex */
    class a extends d {
        final /* synthetic */ String b;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        a(d dVar, String str) {
            super(dVar, null);
            this.b = str;
        }

        @Override // com.google.common.base.d
        CharSequence h(@NullableDecl Object obj) {
            return obj == null ? this.b : d.this.h(obj);
        }

        @Override // com.google.common.base.d
        public d i(String str) {
            throw new UnsupportedOperationException("already specified useForNull");
        }
    }

    /* synthetic */ d(d dVar, a aVar) {
        this(dVar);
    }

    public static d f(char c) {
        return new d(String.valueOf(c));
    }

    public static d g(String str) {
        return new d(str);
    }

    @CanIgnoreReturnValue
    public <A extends Appendable> A a(A a2, Iterator<?> it) throws IOException {
        du1.p(a2);
        if (it.hasNext()) {
            a2.append(h(it.next()));
            while (it.hasNext()) {
                a2.append(this.a);
                a2.append(h(it.next()));
            }
        }
        return a2;
    }

    @CanIgnoreReturnValue
    public final StringBuilder b(StringBuilder sb, Iterator<?> it) {
        try {
            a(sb, it);
            return sb;
        } catch (IOException e) {
            throw new AssertionError(e);
        }
    }

    public final String c(Iterable<?> iterable) {
        return d(iterable.iterator());
    }

    public final String d(Iterator<?> it) {
        return b(new StringBuilder(), it).toString();
    }

    public final String e(Object[] objArr) {
        return c(Arrays.asList(objArr));
    }

    CharSequence h(Object obj) {
        du1.p(obj);
        return obj instanceof CharSequence ? (CharSequence) obj : obj.toString();
    }

    public d i(String str) {
        du1.p(str);
        return new a(this, str);
    }

    private d(String str) {
        this.a = (String) du1.p(str);
    }

    private d(d dVar) {
        this.a = dVar.a;
    }
}
