package com.uploader.implement.b.a;

import com.uploader.implement.C7399c;
import com.uploader.implement.b.InterfaceC7395b;
import com.uploader.implement.b.InterfaceC7398e;
import java.lang.ref.WeakReference;
import tb.j33;

/* compiled from: Taobao */
/* renamed from: com.uploader.implement.b.a.a */
/* loaded from: classes11.dex */
public abstract class AbstractC7381a implements InterfaceC7398e {
    final j33 a;
    volatile WeakReference<InterfaceC7395b> b;
    final int c = hashCode();

    /* JADX INFO: Access modifiers changed from: package-private */
    public AbstractC7381a(C7399c c7399c, j33 j33Var) {
        this.a = j33Var;
    }

    @Override // com.uploader.implement.b.InterfaceC7398e
    public j33 a() {
        return this.a;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public InterfaceC7395b e() {
        WeakReference<InterfaceC7395b> weakReference = this.b;
        if (weakReference == null) {
            return null;
        }
        return weakReference.get();
    }

    @Override // com.uploader.implement.b.InterfaceC7398e
    public void a(InterfaceC7395b interfaceC7395b) {
        this.b = new WeakReference<>(interfaceC7395b);
    }
}
