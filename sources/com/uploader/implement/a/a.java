package com.uploader.implement.a;

import android.content.Context;
import android.util.Pair;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import java.lang.ref.WeakReference;
import org.android.agoo.message.MessageService;
import tb.i33;
import tb.k33;
import tb.l33;

/* compiled from: Taobao */
/* loaded from: classes11.dex */
public abstract class a implements g, com.uploader.implement.d.a {
    final Context b;
    WeakReference<d> c;
    private volatile int d = 0;
    final int a = hashCode();

    /* JADX INFO: Access modifiers changed from: package-private */
    public a(Context context) {
        this.b = context;
    }

    private void j(@Nullable com.uploader.implement.d.b bVar, k33 k33Var, int i) {
        int i2 = this.d;
        if (com.uploader.implement.a.d(8)) {
            StringBuilder sb = new StringBuilder();
            sb.append(this.a);
            sb.append(" stop, session:");
            sb.append(bVar == null ? "null" : Integer.valueOf(bVar.hashCode()));
            sb.append(" oldState:");
            sb.append(i2);
            sb.append(" error:");
            sb.append(k33Var);
            sb.append(" reason:");
            sb.append(i);
            com.uploader.implement.a.a(8, "AbstractUploaderAction", sb.toString());
        }
        if (bVar != null) {
            f();
            bVar.a((com.uploader.implement.d.a) null);
            bVar.a();
        }
        int i3 = 4;
        if (i == 2) {
            k(this.d == 2 ? 5 : 4);
        } else {
            k(3);
            d t = t();
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
        if (com.uploader.implement.a.d(2)) {
            com.uploader.implement.a.a(2, "AbstractUploaderAction", this.a + " setState, oldState:" + this.d + " state:" + i);
        }
        this.d = i;
        return true;
    }

    private void q(com.uploader.implement.d.b bVar, e eVar, k33 k33Var) {
        if (k33Var == null) {
            return;
        }
        if (!k33Var.d) {
            j(bVar, k33Var, 1);
            return;
        }
        k33 d = d(bVar, eVar, k33Var);
        if (d != null) {
            j(bVar, d, 1);
        }
    }

    private void s(com.uploader.implement.d.b bVar) {
        boolean n = n();
        if (com.uploader.implement.a.d(2)) {
            com.uploader.implement.a.a(2, "AbstractUploaderAction", this.a + " begin, session:" + bVar.hashCode() + " state:" + this.d + " stepUp:" + n);
        }
        if (n) {
            k(2);
        }
        k33 e = e(bVar, null, true);
        if (e != null) {
            j(bVar, e, 1);
        }
    }

    private d t() {
        WeakReference<d> weakReference = this.c;
        if (weakReference == null) {
            return null;
        }
        return weakReference.get();
    }

    abstract Pair<Integer, Integer> a(@NonNull com.uploader.implement.d.b bVar, @NonNull e eVar);

    @Override // com.uploader.implement.d.a
    public final void a(com.uploader.implement.d.b bVar, e eVar, f fVar) {
        i33 i33Var = (i33) fVar;
        int a = i33Var.a();
        if (com.uploader.implement.a.d(2)) {
            com.uploader.implement.a.a(2, "AbstractUploaderAction", this.a + " onReceive, session:" + bVar.hashCode() + " request:" + eVar.hashCode() + " response:" + i33Var.hashCode() + " state:" + this.d + " type:" + a + " content:" + i33Var.c().toString());
        }
        if (this.d == 3) {
            if (com.uploader.implement.a.d(8)) {
                com.uploader.implement.a.a(8, "AbstractUploaderAction", this.a + " onReceive, state is finish");
                return;
            }
            return;
        }
        Pair<k33, ? extends Object> b = b(bVar, eVar, i33Var);
        k33 k33Var = (k33) b.first;
        switch (a) {
            case 1:
                if (k33Var == null) {
                    if (n()) {
                        k(2);
                        k33Var = e(bVar, eVar, true);
                        break;
                    } else {
                        k(3);
                        bVar.a(eVar, true);
                        d t = t();
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
                    k33Var = c(bVar, eVar, (Pair) obj2);
                    break;
                }
                break;
            case 4:
                k(3);
                bVar.a((com.uploader.implement.d.a) null);
                bVar.a(eVar, true);
                g(0, b.second);
                d t2 = t();
                if (t2 != null) {
                    t2.a(this);
                    break;
                }
                break;
            case 5:
                if (k33Var != null && "300".equals(k33Var.a) && "2".equals(k33Var.b)) {
                    k(1);
                    k33Var = e(bVar, null, true);
                    break;
                }
                break;
            case 6:
                Object obj3 = b.second;
                k33Var = new k33("300", "3", obj3 == null ? "" : obj3.toString(), true);
                break;
        }
        q(bVar, eVar, k33Var);
    }

    @NonNull
    abstract Pair<k33, ? extends Object> b(@NonNull com.uploader.implement.d.b bVar, e eVar, @NonNull i33 i33Var);

    @Override // com.uploader.implement.d.a
    public final void b(com.uploader.implement.d.b bVar, e eVar) {
        if (com.uploader.implement.a.d(2)) {
            com.uploader.implement.a.a(2, "AbstractUploaderAction", this.a + " onSend, session:" + bVar.hashCode() + " request:" + eVar.hashCode());
        }
        if (this.d == 3) {
            if (com.uploader.implement.a.d(8)) {
                com.uploader.implement.a.a(8, "AbstractUploaderAction", this.a + " onSend, state is finish");
                return;
            }
            return;
        }
        Pair<Integer, Integer> a = a(bVar, eVar);
        if (a == null) {
            return;
        }
        q(bVar, eVar, c(bVar, eVar, a));
    }

    abstract k33 c(@NonNull com.uploader.implement.d.b bVar, e eVar, Pair<Integer, Integer> pair);

    abstract k33 d(@NonNull com.uploader.implement.d.b bVar, e eVar, k33 k33Var);

    abstract k33 e(@NonNull com.uploader.implement.d.b bVar, e eVar, boolean z);

    abstract void f();

    abstract void g(int i, Object obj);

    public final void h(d dVar) {
        this.c = new WeakReference<>(dVar);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final void i(com.uploader.implement.d.b bVar, k33 k33Var) {
        if (this.d != 3) {
            if (k33Var != null) {
                j(bVar, k33Var, 1);
            } else {
                s(bVar);
            }
        } else if (com.uploader.implement.a.d(8)) {
            com.uploader.implement.a.a(8, "AbstractUploaderAction", this.a + " begin, state is finish");
        }
    }

    abstract boolean l(com.uploader.implement.d.b bVar);

    public final void m(@NonNull com.uploader.implement.d.b bVar) {
        int i = this.d == 0 ? 5 : 6;
        if (com.uploader.implement.a.d(8)) {
            com.uploader.implement.a.a(8, "AbstractUploaderAction", this.a + " onStart, state:" + this.d + " notifyType:" + i + " session:" + bVar.hashCode());
        }
        int i2 = this.d;
        if (i2 != 0 && i2 != 1) {
            if (i2 != 2) {
                if (i2 != 4) {
                    if (i2 != 5) {
                        if (com.uploader.implement.a.d(8)) {
                            com.uploader.implement.a.a(8, "AbstractUploaderAction", this.a + " no need to begin,  state:" + this.d);
                        }
                        g(i, null);
                    }
                }
            }
            if (!k(2)) {
                f();
                bVar.a((com.uploader.implement.d.a) null);
                bVar.a();
            }
            bVar.a(this);
            k33 e = e(bVar, null, true);
            if (e != null) {
                j(bVar, e, 1);
            }
            g(i, null);
        }
        if (!k(1)) {
            f();
            bVar.a((com.uploader.implement.d.a) null);
            bVar.a();
        }
        bVar.a(this);
        if (!l(bVar)) {
            s(bVar);
        }
        if (com.uploader.implement.a.d(2)) {
            com.uploader.implement.a.a(2, "AbstractUploaderAction", this.a + " submit timeConsuming, session:" + bVar.hashCode() + " state:" + this.d);
        }
        g(i, null);
    }

    abstract boolean n();

    public final int o() {
        return this.d;
    }

    public final void p(@Nullable com.uploader.implement.d.b bVar) {
        if (this.d == 3) {
            if (com.uploader.implement.a.d(8)) {
                com.uploader.implement.a.a(8, "AbstractUploaderAction", this.a + " onCancel, state is finish");
                return;
            }
            return;
        }
        j(bVar, null, 0);
    }

    public void r() {
        g(7, null);
    }

    @Override // com.uploader.implement.d.a
    public final void b(com.uploader.implement.d.b bVar, e eVar, k33 k33Var) {
        if (com.uploader.implement.a.d(2)) {
            com.uploader.implement.a.a(2, "AbstractUploaderAction", this.a + " onError, session:" + bVar.hashCode() + " request:" + eVar.hashCode() + " error:" + k33Var.toString());
        }
        if (this.d == 3) {
            if (com.uploader.implement.a.d(8)) {
                com.uploader.implement.a.a(8, "AbstractUploaderAction", this.a + " onError, state is finish");
                return;
            }
            return;
        }
        if (MessageService.MSG_DB_COMPLETE.equals(k33Var.a)) {
            boolean a = l33.a(this.b);
            if (com.uploader.implement.a.d(2)) {
                com.uploader.implement.a.a(2, "AbstractUploaderAction", this.a + " onError, connection error, isConnected:" + a + " error:" + k33Var.toString());
            }
            if (!a || "-1".equals(k33Var.b)) {
                j(bVar, k33Var, 2);
                return;
            }
        }
        q(bVar, eVar, k33Var);
    }
}
