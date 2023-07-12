package com.uploader.implement.b.a;

import java.lang.ref.WeakReference;
import tb.j33;

/* compiled from: Taobao */
/* loaded from: classes11.dex */
public abstract class a implements com.uploader.implement.b.e {
    final j33 a;
    volatile WeakReference<com.uploader.implement.b.b> b;
    final int c = hashCode();

    /* JADX INFO: Access modifiers changed from: package-private */
    public a(com.uploader.implement.c cVar, j33 j33Var) {
        this.a = j33Var;
    }

    @Override // com.uploader.implement.b.e
    public j33 a() {
        return this.a;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public com.uploader.implement.b.b e() {
        WeakReference<com.uploader.implement.b.b> weakReference = this.b;
        if (weakReference == null) {
            return null;
        }
        return weakReference.get();
    }

    @Override // com.uploader.implement.b.e
    public void a(com.uploader.implement.b.b bVar) {
        this.b = new WeakReference<>(bVar);
    }
}
