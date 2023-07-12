package tb;

import com.efs.sdk.base.Constants;
import com.efs.sdk.base.protocol.ILogProtocol;
import java.io.File;

/* compiled from: Taobao */
/* loaded from: classes10.dex */
public final class j43 {
    public n33 a;
    public w43 b = new w43();
    public byte[] c;
    public File d;

    public j43(String str, byte b) {
        this.a = new n33(str, b);
    }

    public static j43 b(ILogProtocol iLogProtocol) {
        j43 j43Var = null;
        try {
            j43 j43Var2 = new j43(iLogProtocol.getLogType(), iLogProtocol.getLogProtocol());
            try {
                int bodyType = iLogProtocol.getBodyType();
                if (bodyType == 0) {
                    j43Var2.f(0);
                    j43Var2.e(iLogProtocol.generate());
                } else if (bodyType != 1) {
                    w63.b(Constants.TAG, "Can not support body type: " + iLogProtocol.getBodyType(), null);
                } else {
                    j43Var2.f(1);
                    j43Var2.d = new File(iLogProtocol.getFilePath());
                }
                return j43Var2;
            } catch (Exception e) {
                e = e;
                j43Var = j43Var2;
                w63.c(Constants.TAG, "log send error", e);
                return j43Var;
            }
        } catch (Exception e2) {
            e = e2;
        }
    }

    private void j() {
        byte[] bArr;
        n33 n33Var = this.a;
        int i = n33Var.c;
        if (i == 0 && (bArr = this.c) != null) {
            n33Var.f = bArr.length;
        } else if (i == 1 && this.d.exists()) {
            this.a.f = this.d.length();
        }
    }

    public final long a() {
        j();
        return this.a.f;
    }

    public final void c(int i) {
        this.a.e = i;
        j();
    }

    public final void d(String str) {
        this.a.d = str;
    }

    public final void e(byte[] bArr) {
        this.c = bArr;
        j();
    }

    public final void f(int i) {
        this.a.c = i;
    }

    public final boolean g() {
        return !"none".equals(this.a.d);
    }

    public final boolean h() {
        return 1 != this.a.e;
    }

    public final void i() {
        this.b.a = true;
    }
}
