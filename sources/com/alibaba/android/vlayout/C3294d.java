package com.alibaba.android.vlayout;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import java.util.Arrays;
import java.util.Comparator;
import java.util.LinkedList;
import java.util.List;
import java.util.ListIterator;

/* compiled from: Taobao */
/* renamed from: com.alibaba.android.vlayout.d */
/* loaded from: classes6.dex */
public class C3294d extends AbstractC3290b {
    @NonNull
    private List<C3296b> a = new LinkedList();
    @NonNull
    private List<AbstractC3289a> b = new LinkedList();
    @NonNull
    private List<AbstractC3289a> c = new LinkedList();
    private C3296b[] d = null;
    @NonNull
    private Comparator<C3296b> e = new C3295a(this);

    /* compiled from: Taobao */
    /* renamed from: com.alibaba.android.vlayout.d$a */
    /* loaded from: classes15.dex */
    class C3295a implements Comparator<C3296b> {
        C3295a(C3294d c3294d) {
        }

        @Override // java.util.Comparator
        /* renamed from: a */
        public int compare(C3296b c3296b, C3296b c3296b2) {
            return c3296b.b() - c3296b2.b();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: Taobao */
    /* renamed from: com.alibaba.android.vlayout.d$b */
    /* loaded from: classes15.dex */
    public static class C3296b {
        AbstractC3289a a;

        C3296b(AbstractC3289a abstractC3289a) {
            this.a = abstractC3289a;
        }

        public int a() {
            return this.a.getRange().e().intValue();
        }

        public int b() {
            return this.a.getRange().d().intValue();
        }
    }

    @Override // com.alibaba.android.vlayout.AbstractC3290b
    @Nullable
    public AbstractC3289a a(int i) {
        C3296b c3296b;
        C3296b[] c3296bArr = this.d;
        if (c3296bArr == null || c3296bArr.length == 0) {
            return null;
        }
        int i2 = 0;
        int length = c3296bArr.length - 1;
        while (true) {
            if (i2 > length) {
                c3296b = null;
                break;
            }
            int i3 = (i2 + length) / 2;
            c3296b = this.d[i3];
            if (c3296b.b() <= i) {
                if (c3296b.a() >= i) {
                    if (c3296b.b() <= i && c3296b.a() >= i) {
                        break;
                    }
                } else {
                    i2 = i3 + 1;
                }
            } else {
                length = i3 - 1;
            }
        }
        if (c3296b == null) {
            return null;
        }
        return c3296b.a;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.alibaba.android.vlayout.AbstractC3290b
    @NonNull
    public List<AbstractC3289a> b() {
        return this.b;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.alibaba.android.vlayout.AbstractC3290b
    public List<AbstractC3289a> c() {
        return this.c;
    }

    @Override // com.alibaba.android.vlayout.AbstractC3290b
    public void d(@Nullable List<AbstractC3289a> list) {
        this.b.clear();
        this.c.clear();
        this.a.clear();
        if (list != null) {
            ListIterator<AbstractC3289a> listIterator = list.listIterator();
            while (listIterator.hasNext()) {
                AbstractC3289a next = listIterator.next();
                this.b.add(next);
                this.a.add(new C3296b(next));
            }
            while (listIterator.hasPrevious()) {
                this.c.add(listIterator.previous());
            }
            List<C3296b> list2 = this.a;
            C3296b[] c3296bArr = (C3296b[]) list2.toArray(new C3296b[list2.size()]);
            this.d = c3296bArr;
            Arrays.sort(c3296bArr, this.e);
        }
    }
}
