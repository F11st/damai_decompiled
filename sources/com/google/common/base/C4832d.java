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
/* renamed from: com.google.common.base.d */
/* loaded from: classes10.dex */
public class C4832d {
    private final String a;

    /* compiled from: Taobao */
    /* renamed from: com.google.common.base.d$a */
    /* loaded from: classes10.dex */
    class C4833a extends C4832d {
        final /* synthetic */ String b;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        C4833a(C4832d c4832d, String str) {
            super(c4832d, null);
            this.b = str;
        }

        @Override // com.google.common.base.C4832d
        CharSequence h(@NullableDecl Object obj) {
            return obj == null ? this.b : C4832d.this.h(obj);
        }

        @Override // com.google.common.base.C4832d
        public C4832d i(String str) {
            throw new UnsupportedOperationException("already specified useForNull");
        }
    }

    /* synthetic */ C4832d(C4832d c4832d, C4833a c4833a) {
        this(c4832d);
    }

    public static C4832d f(char c) {
        return new C4832d(String.valueOf(c));
    }

    public static C4832d g(String str) {
        return new C4832d(str);
    }

    @CanIgnoreReturnValue
    public <A extends Appendable> A a(A a, Iterator<?> it) throws IOException {
        du1.p(a);
        if (it.hasNext()) {
            a.append(h(it.next()));
            while (it.hasNext()) {
                a.append(this.a);
                a.append(h(it.next()));
            }
        }
        return a;
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

    public C4832d i(String str) {
        du1.p(str);
        return new C4833a(this, str);
    }

    private C4832d(String str) {
        this.a = (String) du1.p(str);
    }

    private C4832d(C4832d c4832d) {
        this.a = c4832d.a;
    }
}
