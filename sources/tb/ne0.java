package tb;

import android.content.res.AssetManager;
import android.util.TypedValue;
import androidx.annotation.NonNull;
import com.taobao.tcommon.core.BytesPool;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;

/* compiled from: Taobao */
/* loaded from: classes11.dex */
public class ne0 extends p22 {
    public final boolean g;
    protected boolean h;

    private ne0(int i, boolean z, byte[] bArr, int i2, InputStream inputStream, int i3, TypedValue typedValue) {
        super(i, bArr, i2, inputStream, i3, typedValue);
        boolean z2 = true;
        if (i == 1) {
            this.g = (!z || bArr == null || bArr.length - i2 < i3) ? false : false;
        } else {
            this.g = z;
        }
    }

    public static ne0 c(@NonNull p22 p22Var, yg2 yg2Var) throws Exception {
        int i = p22Var.a;
        if (i != 3) {
            if (i == 1) {
                return new ne0(p22Var.c, p22Var.d, p22Var.b);
            }
            throw new RuntimeException("unrecognized response type: " + p22Var.a);
        }
        InputStream inputStream = p22Var.e;
        if (!(inputStream instanceof FileInputStream) && !(inputStream instanceof AssetManager.AssetInputStream)) {
            BytesPool build = ur1.o().c().build();
            if (yg2Var == null) {
                return zg2.a(inputStream, build, new int[]{p22Var.b});
            }
            zg2.b(inputStream, build, yg2Var);
            return yg2Var.a();
        }
        return new ne0(inputStream, p22Var.b, p22Var.f);
    }

    public boolean a() {
        int i;
        int i2;
        if (this.h || (i = this.b) <= 0) {
            return false;
        }
        return this.a == 1 ? this.c != null && (i2 = this.d) >= 0 && i2 < i : this.e != null;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public synchronized void b(boolean z) {
        InputStream inputStream;
        if (this.h) {
            if (z) {
                xt2.i("EncodedData", "has been released when trying to release it[type: %d]", Integer.valueOf(this.a));
            }
            return;
        }
        if (!z) {
            xt2.i("EncodedData", "final release called from finalize[type: %d]", Integer.valueOf(this.a));
        }
        int i = this.a;
        if (i == 1) {
            BytesPool build = ur1.o().c().build();
            if (build != null) {
                build.release(this.c);
            }
        } else if (i == 3 && (inputStream = this.e) != null) {
            try {
                inputStream.close();
            } catch (IOException unused) {
            }
        }
        this.h = true;
    }

    @Override // tb.p22, com.taobao.rxm.common.Releasable
    public synchronized void release() {
        b(true);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public ne0(ne0 ne0Var) {
        this(ne0Var.a, ne0Var.g, ne0Var.c, ne0Var.d, ne0Var.e, ne0Var.b, ne0Var.f);
    }

    public ne0(InputStream inputStream, int i, TypedValue typedValue) {
        this(3, true, null, 0, inputStream, i, typedValue);
    }

    public ne0(boolean z, byte[] bArr, int i, int i2) {
        this(1, z, bArr, i, null, i2, null);
    }

    public ne0(byte[] bArr, int i, int i2) {
        this(1, true, bArr, i, null, i2, null);
    }
}
