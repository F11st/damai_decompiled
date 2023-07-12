package tb;

import com.taobao.phenix.intf.IPhenixTicket;

/* compiled from: Taobao */
/* loaded from: classes11.dex */
public class ds1 implements IPhenixTicket {
    private a22 a;
    protected String b = "";
    boolean c = false;

    public ds1(a22 a22Var) {
        this.a = a22Var;
    }

    public boolean a() {
        return this.c;
    }

    public void b(boolean z) {
        this.c = z;
        if (z) {
            this.a = null;
        }
    }

    public void c(String str) {
        this.b = str;
    }

    @Override // com.taobao.phenix.intf.IPhenixTicket
    public boolean cancel() {
        a22 a22Var;
        synchronized (this) {
            a22Var = this.a;
            this.a = null;
        }
        if (a22Var != null) {
            a22Var.b();
            return false;
        }
        return false;
    }

    @Override // com.taobao.phenix.intf.IPhenixTicket
    public boolean theSame(String str) {
        String str2 = this.b;
        return str2 != null && str2.compareToIgnoreCase(str) == 0;
    }
}
