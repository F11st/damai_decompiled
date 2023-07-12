package com.uploader.implement.a;

import android.content.Context;
import android.util.Pair;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.uploader.implement.C7364a;
import com.uploader.implement.d.InterfaceC7403a;
import com.uploader.implement.d.InterfaceC7404b;
import java.lang.ref.WeakReference;
import org.android.agoo.message.MessageService;
import tb.i33;
import tb.k33;
import tb.l33;

/* compiled from: Taobao */
/* renamed from: com.uploader.implement.a.a */
/* loaded from: classes11.dex */
public abstract class AbstractC7365a implements InterfaceC7375g, InterfaceC7403a {
    final Context b;
    WeakReference<InterfaceC7372d> c;
    private volatile int d = 0;
    final int a = hashCode();

    /* JADX INFO: Access modifiers changed from: package-private */
    public AbstractC7365a(Context context) {
        this.b = context;
    }

    private void j(@Nullable InterfaceC7404b interfaceC7404b, k33 k33Var, int i) {
        int i2 = this.d;
        if (C7364a.d(8)) {
            StringBuilder sb = new StringBuilder();
            sb.append(this.a);
            sb.append(" stop, session:");
            sb.append(interfaceC7404b == null ? "null" : Integer.valueOf(interfaceC7404b.hashCode()));
            sb.append(" oldState:");
            sb.append(i2);
            sb.append(" error:");
            sb.append(k33Var);
            sb.append(" reason:");
            sb.append(i);
            C7364a.a(8, "AbstractUploaderAction", sb.toString());
        }
        if (interfaceC7404b != null) {
            f();
            interfaceC7404b.a((InterfaceC7403a) null);
            interfaceC7404b.a();
        }
        int i3 = 4;
        if (i == 2) {
            k(this.d == 2 ? 5 : 4);
        } else {
            k(3);
            InterfaceC7372d t = t();
            if (t != null) {
                t.a(this);
            }
            i3 = i == 0 ? 1 : 2;
        }
        g(i3, k33Var);
    }

    private boolean k(int i) {
        if (this.d == i) {
            return false;
        }
        if (C7364a.d(2)) {
            C7364a.a(2, "AbstractUploaderAction", this.a + " setState, oldState:" + this.d + " state:" + i);
        }
        this.d = i;
        return true;
    }

    private void q(InterfaceC7404b interfaceC7404b, InterfaceC7373e interfaceC7373e, k33 k33Var) {
        if (k33Var == null) {
            return;
        }
        if (!k33Var.d) {
            j(interfaceC7404b, k33Var, 1);
            return;
        }
        k33 d = d(interfaceC7404b, interfaceC7373e, k33Var);
        if (d != null) {
            j(interfaceC7404b, d, 1);
        }
    }

    private void s(InterfaceC7404b interfaceC7404b) {
        boolean n = n();
        if (C7364a.d(2)) {
            C7364a.a(2, "AbstractUploaderAction", this.a + " begin, session:" + interfaceC7404b.hashCode() + " state:" + this.d + " stepUp:" + n);
        }
        if (n) {
            k(2);
        }
        k33 e = e(interfaceC7404b, null, true);
        if (e != null) {
            j(interfaceC7404b, e, 1);
        }
    }

    private InterfaceC7372d t() {
        WeakReference<InterfaceC7372d> weakReference = this.c;
        if (weakReference == null) {
            return null;
        }
        return weakReference.get();
    }

    abstract Pair<Integer, Integer> a(@NonNull InterfaceC7404b interfaceC7404b, @NonNull InterfaceC7373e interfaceC7373e);

    @Override // com.uploader.implement.d.InterfaceC7403a
    public final void a(InterfaceC7404b interfaceC7404b, InterfaceC7373e interfaceC7373e, InterfaceC7374f interfaceC7374f) {
        i33 i33Var = (i33) interfaceC7374f;
        int a = i33Var.a();
        if (C7364a.d(2)) {
            C7364a.a(2, "AbstractUploaderAction", this.a + " onReceive, session:" + interfaceC7404b.hashCode() + " request:" + interfaceC7373e.hashCode() + " response:" + i33Var.hashCode() + " state:" + this.d + " type:" + a + " content:" + i33Var.c().toString());
        }
        if (this.d == 3) {
            if (C7364a.d(8)) {
                C7364a.a(8, "AbstractUploaderAction", this.a + " onReceive, state is finish");
                return;
            }
            return;
        }
        Pair<k33, ? extends Object> b = b(interfaceC7404b, interfaceC7373e, i33Var);
        k33 k33Var = (k33) b.first;
        switch (a) {
            case 1:
                if (k33Var == null) {
                    if (n()) {
                        k(2);
                        k33Var = e(interfaceC7404b, interfaceC7373e, true);
                        break;
                    } else {
                        k(3);
                        interfaceC7404b.a(interfaceC7373e, true);
                        InterfaceC7372d t = t();
                        if (t != null) {
                            t.a(this);
                            break;
                        }
                    }
                }
                break;
            case 2:
                Object obj = b.second;
                if (obj != null) {
                    g(3, obj);
                    break;
                }
                break;
            case 3:
                Object obj2 = b.second;
                if (obj2 != null) {
                    k33Var = c(interfaceC7404b, interfaceC7373e, (Pair) obj2);
                    break;
                }
                break;
            case 4:
                k(3);
                interfaceC7404b.a((InterfaceC7403a) null);
                interfaceC7404b.a(interfaceC7373e, true);
                g(0, b.second);
                InterfaceC7372d t2 = t();
                if (t2 != null) {
                    t2.a(this);
                    break;
                }
                break;
            case 5:
                if (k33Var != null && "300".equals(k33Var.a) && "2".equals(k33Var.b)) {
                    k(1);
                    k33Var = e(interfaceC7404b, null, true);
                    break;
                }
                break;
            case 6:
                Object obj3 = b.second;
                k33Var = new k33("300", "3", obj3 == null ? "" : obj3.toString(), true);
                break;
        }
        q(interfaceC7404b, interfaceC7373e, k33Var);
    }

    @NonNull
    abstract Pair<k33, ? extends Object> b(@NonNull InterfaceC7404b interfaceC7404b, InterfaceC7373e interfaceC7373e, @NonNull i33 i33Var);

    @Override // com.uploader.implement.d.InterfaceC7403a
    public final void b(InterfaceC7404b interfaceC7404b, InterfaceC7373e interfaceC7373e) {
        if (C7364a.d(2)) {
            C7364a.a(2, "AbstractUploaderAction", this.a + " onSend, session:" + interfaceC7404b.hashCode() + " request:" + interfaceC7373e.hashCode());
        }
        if (this.d == 3) {
            if (C7364a.d(8)) {
                C7364a.a(8, "AbstractUploaderAction", this.a + " onSend, state is finish");
                return;
            }
            return;
        }
        Pair<Integer, Integer> a = a(interfaceC7404b, interfaceC7373e);
        if (a == null) {
            return;
        }
        q(interfaceC7404b, interfaceC7373e, c(interfaceC7404b, interfaceC7373e, a));
    }

    abstract k33 c(@NonNull InterfaceC7404b interfaceC7404b, InterfaceC7373e interfaceC7373e, Pair<Integer, Integer> pair);

    abstract k33 d(@NonNull InterfaceC7404b interfaceC7404b, InterfaceC7373e interfaceC7373e, k33 k33Var);

    abstract k33 e(@NonNull InterfaceC7404b interfaceC7404b, InterfaceC7373e interfaceC7373e, boolean z);

    abstract void f();

    abstract void g(int i, Object obj);

    public final void h(InterfaceC7372d interfaceC7372d) {
        this.c = new WeakReference<>(interfaceC7372d);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final void i(InterfaceC7404b interfaceC7404b, k33 k33Var) {
        if (this.d != 3) {
            if (k33Var != null) {
                j(interfaceC7404b, k33Var, 1);
            } else {
                s(interfaceC7404b);
            }
        } else if (C7364a.d(8)) {
            C7364a.a(8, "AbstractUploaderAction", this.a + " begin, state is finish");
        }
    }

    abstract boolean l(InterfaceC7404b interfaceC7404b);

    public final void m(@NonNull InterfaceC7404b interfaceC7404b) {
        int i = this.d == 0 ? 5 : 6;
        if (C7364a.d(8)) {
            C7364a.a(8, "AbstractUploaderAction", this.a + " onStart, state:" + this.d + " notifyType:" + i + " session:" + interfaceC7404b.hashCode());
        }
        int i2 = this.d;
        if (i2 != 0 && i2 != 1) {
            if (i2 != 2) {
                if (i2 != 4) {
                    if (i2 != 5) {
                        if (C7364a.d(8)) {
                            C7364a.a(8, "AbstractUploaderAction", this.a + " no need to begin,  state:" + this.d);
                        }
                        g(i, null);
                    }
                }
            }
            if (!k(2)) {
                f();
                interfaceC7404b.a((InterfaceC7403a) null);
                interfaceC7404b.a();
            }
            interfaceC7404b.a(this);
            k33 e = e(interfaceC7404b, null, true);
            if (e != null) {
                j(interfaceC7404b, e, 1);
            }
            g(i, null);
        }
        if (!k(1)) {
            f();
            interfaceC7404b.a((InterfaceC7403a) null);
            interfaceC7404b.a();
        }
        interfaceC7404b.a(this);
        if (!l(interfaceC7404b)) {
            s(interfaceC7404b);
        }
        if (C7364a.d(2)) {
            C7364a.a(2, "AbstractUploaderAction", this.a + " submit timeConsuming, session:" + interfaceC7404b.hashCode() + " state:" + this.d);
        }
        g(i, null);
    }

    abstract boolean n();

    public final int o() {
        return this.d;
    }

    public final void p(@Nullable InterfaceC7404b interfaceC7404b) {
        if (this.d == 3) {
            if (C7364a.d(8)) {
                C7364a.a(8, "AbstractUploaderAction", this.a + " onCancel, state is finish");
                return;
            }
            return;
        }
        j(interfaceC7404b, null, 0);
    }

    public void r() {
        g(7, null);
    }

    @Override // com.uploader.implement.d.InterfaceC7403a
    public final void b(InterfaceC7404b interfaceC7404b, InterfaceC7373e interfaceC7373e, k33 k33Var) {
        if (C7364a.d(2)) {
            C7364a.a(2, "AbstractUploaderAction", this.a + " onError, session:" + interfaceC7404b.hashCode() + " request:" + interfaceC7373e.hashCode() + " error:" + k33Var.toString());
        }
        if (this.d == 3) {
            if (C7364a.d(8)) {
                C7364a.a(8, "AbstractUploaderAction", this.a + " onError, state is finish");
                return;
            }
            return;
        }
        if (MessageService.MSG_DB_COMPLETE.equals(k33Var.a)) {
            boolean a = l33.a(this.b);
            if (C7364a.d(2)) {
                C7364a.a(2, "AbstractUploaderAction", this.a + " onError, connection error, isConnected:" + a + " error:" + k33Var.toString());
            }
            if (!a || "-1".equals(k33Var.b)) {
                j(interfaceC7404b, k33Var, 2);
                return;
            }
        }
        q(interfaceC7404b, interfaceC7373e, k33Var);
    }
}
