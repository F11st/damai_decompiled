package com.alibaba.android.vlayout;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import java.util.Arrays;
import java.util.Comparator;
import java.util.LinkedList;
import java.util.List;
import java.util.ListIterator;

/* compiled from: Taobao */
/* loaded from: classes6.dex */
public class d extends com.alibaba.android.vlayout.b {
    @NonNull
    private List<b> a = new LinkedList();
    @NonNull
    private List<com.alibaba.android.vlayout.a> b = new LinkedList();
    @NonNull
    private List<com.alibaba.android.vlayout.a> c = new LinkedList();
    private b[] d = null;
    @NonNull
    private Comparator<b> e = new a(this);

    /* compiled from: Taobao */
    /* loaded from: classes15.dex */
    class a implements Comparator<b> {
        a(d dVar) {
        }

        @Override // java.util.Comparator
        /* renamed from: a */
        public int compare(b bVar, b bVar2) {
            return bVar.b() - bVar2.b();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: Taobao */
    /* loaded from: classes15.dex */
    public static class b {
        com.alibaba.android.vlayout.a a;

        b(com.alibaba.android.vlayout.a aVar) {
            this.a = aVar;
        }

        public int a() {
            return this.a.getRange().e().intValue();
        }

        public int b() {
            return this.a.getRange().d().intValue();
        }
    }

    @Override // com.alibaba.android.vlayout.b
    @Nullable
    public com.alibaba.android.vlayout.a a(int i) {
        b bVar;
        b[] bVarArr = this.d;
        if (bVarArr == null || bVarArr.length == 0) {
            return null;
        }
        int i2 = 0;
        int length = bVarArr.length - 1;
        while (true) {
            if (i2 > length) {
                bVar = null;
                break;
            }
            int i3 = (i2 + length) / 2;
            bVar = this.d[i3];
            if (bVar.b() <= i) {
                if (bVar.a() >= i) {
                    if (bVar.b() <= i && bVar.a() >= i) {
                        break;
                    }
                } else {
                    i2 = i3 + 1;
                }
            } else {
                length = i3 - 1;
            }
        }
        if (bVar == null) {
            return null;
        }
        return bVar.a;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.alibaba.android.vlayout.b
    @NonNull
    public List<com.alibaba.android.vlayout.a> b() {
        return this.b;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.alibaba.android.vlayout.b
    public List<com.alibaba.android.vlayout.a> c() {
        return this.c;
    }

    @Override // com.alibaba.android.vlayout.b
    public void d(@Nullable List<com.alibaba.android.vlayout.a> list) {
        this.b.clear();
        this.c.clear();
        this.a.clear();
        if (list != null) {
            ListIterator<com.alibaba.android.vlayout.a> listIterator = list.listIterator();
            while (listIterator.hasNext()) {
                com.alibaba.android.vlayout.a next = listIterator.next();
                this.b.add(next);
                this.a.add(new b(next));
            }
            while (listIterator.hasPrevious()) {
                this.c.add(listIterator.previous());
            }
            List<b> list2 = this.a;
            b[] bVarArr = (b[]) list2.toArray(new b[list2.size()]);
            this.d = bVarArr;
            Arrays.sort(bVarArr, this.e);
        }
    }
}
