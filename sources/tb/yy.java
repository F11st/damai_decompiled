package tb;

import com.taobao.android.dinamicx.DXRuntimeContext;

/* compiled from: Taobao */
/* loaded from: classes11.dex */
public class yy {
    private int a;
    private int b;
    byte[] c;

    public byte[] a() {
        return this.c;
    }

    public boolean b(ut utVar, DXRuntimeContext dXRuntimeContext) {
        int i = this.b;
        if (i < 0) {
            nz.c("读取新表达式相关逻辑失败");
            return false;
        }
        this.c = new byte[i];
        utVar.i(this.a);
        for (int i2 = 0; i2 < this.b; i2++) {
            this.c[i2] = utVar.d();
        }
        return true;
    }

    public void c(int i) {
        this.b = i;
    }

    public void d(int i) {
        this.a = i;
    }
}
