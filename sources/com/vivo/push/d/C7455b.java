package com.vivo.push.d;

import com.vivo.push.AbstractC7496o;
import com.vivo.push.AbstractRunnableC7491l;
import com.vivo.push.a.C7411a;
import com.vivo.push.b.C7416d;
import com.vivo.push.b.C7418f;
import com.vivo.push.b.C7437y;
import com.vivo.push.model.C7494b;
import com.vivo.push.util.C7527t;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: Taobao */
/* renamed from: com.vivo.push.d.b */
/* loaded from: classes11.dex */
public final class C7455b extends AbstractRunnableC7491l {
    /* JADX INFO: Access modifiers changed from: package-private */
    public C7455b(AbstractC7496o abstractC7496o) {
        super(abstractC7496o);
    }

    @Override // com.vivo.push.AbstractRunnableC7491l
    protected final void a(AbstractC7496o abstractC7496o) {
        boolean b;
        C7494b a = C7527t.a(this.a);
        try {
            if (((C7416d) abstractC7496o).d()) {
                b = C7459f.a(this.a);
            } else {
                b = C7459f.b(this.a);
            }
            if (b) {
                C7494b a2 = C7527t.a(this.a);
                if (a == null || a2 == null || a2.a() == null || !a2.a().equals(a.a())) {
                    if (a != null && a.a() != null) {
                        C7411a.a(this.a, a.a(), new C7437y(a.a()));
                    }
                    if (a2 == null || a2.a() == null) {
                        return;
                    }
                    C7411a.a(this.a, a2.a(), new C7418f());
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
