package tb;

import android.content.Context;
import android.text.TextUtils;
import android.util.LruCache;
import androidx.annotation.NonNull;
import androidx.annotation.RestrictTo;
import com.taobao.android.dinamicx.C6368e;
import com.taobao.android.dinamicx.DXRuntimeContext;
import com.taobao.android.dinamicx.DinamicXEngine;
import com.taobao.android.dinamicx.monitor.DXAppMonitor;
import com.taobao.android.dinamicx.template.download.C6399b;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.List;

/* compiled from: Taobao */
/* loaded from: classes11.dex */
public class dz {
    private static File b;
    private final LruCache<String, byte[]> a = new LruCache<>(50);

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: Taobao */
    /* renamed from: tb.dz$a */
    /* loaded from: classes11.dex */
    public static class C9062a {
        private static final dz a = new dz();
        private static dz b = null;
    }

    public static dz c() {
        return (!DinamicXEngine.x() || C9062a.b == null) ? C9062a.a : C9062a.b;
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY})
    public static void h(dz dzVar) {
        if (C9062a.b == null) {
            dz unused = C9062a.b = dzVar;
        }
    }

    private void i(String str, long j) {
        DXAppMonitor.s(2, "DinamicX_File", "Template", str, null, DXAppMonitor.g((float) j), j, true);
    }

    public String a() {
        return r10.ASSET_DIR;
    }

    public String b() {
        File file = b;
        return file == null ? "" : file.getAbsolutePath();
    }

    public void d(@NonNull Context context) {
        if (context == null) {
            s00.d("DinamicX_File", "DXFileManager", "context is null");
        }
        File file = b;
        if (file == null || !file.exists()) {
            File file2 = new File(context.getFilesDir(), r10.DEFAULT_ROOT_DIR);
            b = file2;
            if (file2.exists() || b.mkdirs()) {
                return;
            }
            b.mkdirs();
        }
    }

    public byte[] e(String str, DXRuntimeContext dXRuntimeContext) {
        List<C6368e.C6369a> list;
        byte[] bArr;
        long nanoTime = System.nanoTime();
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        try {
            synchronized (this.a) {
                bArr = this.a.get(str);
                if ((bArr == null || bArr.length == 0) && (bArr = C6399b.c(str)) != null && bArr.length > 0) {
                    this.a.put(str, bArr);
                }
                i("Template_Read", System.nanoTime() - nanoTime);
            }
            return bArr;
        } catch (IOException e) {
            if (dXRuntimeContext == null || dXRuntimeContext.getDxError() == null || (list = dXRuntimeContext.getDxError().c) == null) {
                return null;
            }
            C6368e.C6369a c6369a = new C6368e.C6369a("Template", "Template_Read", C6368e.DX_TEMPLATE_IO_READ_ERROR);
            if (e instanceof FileNotFoundException) {
                c6369a.e = "fileNotFound " + str;
            } else {
                c6369a.e = ry.a(e);
            }
            list.add(c6369a);
            return null;
        }
    }

    public void f(String str, byte[] bArr) {
        if (TextUtils.isEmpty(str) || bArr == null) {
            return;
        }
        synchronized (this.a) {
            if (this.a.get(str) != null) {
                return;
            }
            this.a.put(str, bArr);
        }
    }

    public boolean g(String str, byte[] bArr) {
        long nanoTime = System.nanoTime();
        boolean h = C6399b.h(str, bArr);
        if (h) {
            i("Template_Write", System.nanoTime() - nanoTime);
        }
        return h;
    }
}
