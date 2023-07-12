package com.uploader.implement.b.a;

import com.uploader.implement.b.a.c;
import java.lang.ref.WeakReference;
import org.android.agoo.message.MessageService;
import tb.k33;
import tb.p73;

/* compiled from: Taobao */
/* loaded from: classes11.dex */
public class d extends com.uploader.implement.b.a.a {
    final c d;

    /* JADX INFO: Access modifiers changed from: package-private */
    public d(com.uploader.implement.c cVar, f fVar) {
        super(cVar, fVar);
        c cVar2 = new c(cVar, fVar);
        this.d = cVar2;
        cVar2.e(new a(this));
    }

    @Override // com.uploader.implement.b.e
    public void a(p73 p73Var, int i) {
        byte[] bArr;
        int i2 = p73Var.d;
        int i3 = p73Var.c;
        if (i3 != 0) {
            bArr = new byte[i2];
            System.arraycopy(p73Var.b, i3, bArr, 0, i2);
        } else {
            bArr = p73Var.b;
        }
        com.uploader.implement.b.b e = e();
        if (e != null) {
            e.a(this, i);
        }
        this.d.d(i, bArr, i2);
    }

    @Override // com.uploader.implement.b.e
    public boolean b() {
        if (com.uploader.implement.a.d(2)) {
            com.uploader.implement.a.a(2, "LongLivedConnection", this.c + " connectAsync");
        }
        this.d.b();
        return true;
    }

    @Override // com.uploader.implement.b.e
    public boolean c() {
        if (com.uploader.implement.a.d(2)) {
            com.uploader.implement.a.a(2, "LongLivedConnection", this.c + " closeAsync");
        }
        this.d.h();
        return true;
    }

    @Override // com.uploader.implement.b.e
    public boolean d() {
        return this.d.i();
    }

    /* compiled from: Taobao */
    /* loaded from: classes11.dex */
    static class a implements c.a {
        private final WeakReference<d> a;

        a(d dVar) {
            this.a = new WeakReference<>(dVar);
        }

        @Override // com.uploader.implement.b.a.c.a
        public void a(int i) {
            com.uploader.implement.b.b e;
            k33 k33Var;
            d dVar = this.a.get();
            if (dVar == null || (e = dVar.e()) == null) {
                return;
            }
            if (i == -2032) {
                String num = Integer.toString(i);
                k33Var = new k33("300", num, "error=" + i, true);
            } else {
                String num2 = (i == -2601 || i == -2613 || i == -2413) ? "-1" : Integer.toString(i);
                k33Var = new k33(MessageService.MSG_DB_COMPLETE, num2, "error=" + i, true);
            }
            e.a(dVar, k33Var);
        }

        @Override // com.uploader.implement.b.a.c.a
        public void b(int i) {
            com.uploader.implement.b.b e;
            d dVar = this.a.get();
            if (dVar == null || (e = dVar.e()) == null) {
                return;
            }
            e.b(dVar, i);
        }

        @Override // com.uploader.implement.b.a.c.a
        public void a() {
            com.uploader.implement.b.b e;
            d dVar = this.a.get();
            if (dVar == null || (e = dVar.e()) == null) {
                return;
            }
            e.a(dVar);
        }

        @Override // com.uploader.implement.b.a.c.a
        public void a(int i, int i2) {
            com.uploader.implement.b.b e;
            d dVar = this.a.get();
            if (dVar == null || (e = dVar.e()) == null) {
                return;
            }
            String num = Integer.toString(i2);
            e.a(dVar, new k33(MessageService.MSG_DB_COMPLETE, num, "onSendFailed" + i2, false));
        }

        @Override // com.uploader.implement.b.a.c.a
        public void a(byte[] bArr, int i) {
            com.uploader.implement.b.b e;
            d dVar = this.a.get();
            if (dVar == null || (e = dVar.e()) == null) {
                return;
            }
            p73 p73Var = new p73();
            p73Var.b = bArr;
            p73Var.c = 0;
            p73Var.d = i;
            e.a(dVar, p73Var);
        }
    }
}
