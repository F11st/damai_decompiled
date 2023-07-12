package com.uploader.implement.b.a;

import com.uploader.implement.C7364a;
import com.uploader.implement.C7399c;
import com.uploader.implement.b.InterfaceC7395b;
import com.uploader.implement.b.a.C7385c;
import java.lang.ref.WeakReference;
import org.android.agoo.message.MessageService;
import tb.k33;
import tb.p73;

/* compiled from: Taobao */
/* renamed from: com.uploader.implement.b.a.d */
/* loaded from: classes11.dex */
public class C7389d extends AbstractC7381a {
    final C7385c d;

    /* JADX INFO: Access modifiers changed from: package-private */
    public C7389d(C7399c c7399c, C7393f c7393f) {
        super(c7399c, c7393f);
        C7385c c7385c = new C7385c(c7399c, c7393f);
        this.d = c7385c;
        c7385c.e(new C7390a(this));
    }

    @Override // com.uploader.implement.b.InterfaceC7398e
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
        InterfaceC7395b e = e();
        if (e != null) {
            e.a(this, i);
        }
        this.d.d(i, bArr, i2);
    }

    @Override // com.uploader.implement.b.InterfaceC7398e
    public boolean b() {
        if (C7364a.d(2)) {
            C7364a.a(2, "LongLivedConnection", this.c + " connectAsync");
        }
        this.d.b();
        return true;
    }

    @Override // com.uploader.implement.b.InterfaceC7398e
    public boolean c() {
        if (C7364a.d(2)) {
            C7364a.a(2, "LongLivedConnection", this.c + " closeAsync");
        }
        this.d.h();
        return true;
    }

    @Override // com.uploader.implement.b.InterfaceC7398e
    public boolean d() {
        return this.d.i();
    }

    /* compiled from: Taobao */
    /* renamed from: com.uploader.implement.b.a.d$a */
    /* loaded from: classes11.dex */
    static class C7390a implements C7385c.InterfaceC7386a {
        private final WeakReference<C7389d> a;

        C7390a(C7389d c7389d) {
            this.a = new WeakReference<>(c7389d);
        }

        @Override // com.uploader.implement.b.a.C7385c.InterfaceC7386a
        public void a(int i) {
            InterfaceC7395b e;
            k33 k33Var;
            C7389d c7389d = this.a.get();
            if (c7389d == null || (e = c7389d.e()) == null) {
                return;
            }
            if (i == -2032) {
                String num = Integer.toString(i);
                k33Var = new k33("300", num, "error=" + i, true);
            } else {
                String num2 = (i == -2601 || i == -2613 || i == -2413) ? "-1" : Integer.toString(i);
                k33Var = new k33(MessageService.MSG_DB_COMPLETE, num2, "error=" + i, true);
            }
            e.a(c7389d, k33Var);
        }

        @Override // com.uploader.implement.b.a.C7385c.InterfaceC7386a
        public void b(int i) {
            InterfaceC7395b e;
            C7389d c7389d = this.a.get();
            if (c7389d == null || (e = c7389d.e()) == null) {
                return;
            }
            e.b(c7389d, i);
        }

        @Override // com.uploader.implement.b.a.C7385c.InterfaceC7386a
        public void a() {
            InterfaceC7395b e;
            C7389d c7389d = this.a.get();
            if (c7389d == null || (e = c7389d.e()) == null) {
                return;
            }
            e.a(c7389d);
        }

        @Override // com.uploader.implement.b.a.C7385c.InterfaceC7386a
        public void a(int i, int i2) {
            InterfaceC7395b e;
            C7389d c7389d = this.a.get();
            if (c7389d == null || (e = c7389d.e()) == null) {
                return;
            }
            String num = Integer.toString(i2);
            e.a(c7389d, new k33(MessageService.MSG_DB_COMPLETE, num, "onSendFailed" + i2, false));
        }

        @Override // com.uploader.implement.b.a.C7385c.InterfaceC7386a
        public void a(byte[] bArr, int i) {
            InterfaceC7395b e;
            C7389d c7389d = this.a.get();
            if (c7389d == null || (e = c7389d.e()) == null) {
                return;
            }
            p73 p73Var = new p73();
            p73Var.b = bArr;
            p73Var.c = 0;
            p73Var.d = i;
            e.a(c7389d, p73Var);
        }
    }
}
