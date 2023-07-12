package com.taobao.android.dinamic.tempate.manager;

import android.content.Context;
import android.support.v4.media.session.PlaybackStateCompat;
import android.util.Log;
import android.util.LruCache;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.taobao.android.dinamic.C6313b;
import com.taobao.android.dinamic.parser.C6339a;
import com.taobao.android.dinamic.tempate.DinamicTemplate;
import com.taobao.android.dinamic.tempate.manager.TemplateCache;
import com.taobao.weex.annotation.JSMethod;
import java.io.File;
import java.io.FilenameFilter;
import java.io.IOException;
import tb.ul2;

/* compiled from: Taobao */
/* renamed from: com.taobao.android.dinamic.tempate.manager.a */
/* loaded from: classes12.dex */
public class C6350a {
    private String a;
    private String b;
    private TemplateCache c;
    protected LruCache<String, DinamicTemplate> d;

    /* compiled from: Taobao */
    /* renamed from: com.taobao.android.dinamic.tempate.manager.a$a */
    /* loaded from: classes12.dex */
    class C6351a implements FilenameFilter {
        int a = -1;
        final /* synthetic */ String b;
        final /* synthetic */ int c;
        final /* synthetic */ DinamicTemplate d;

        C6351a(C6350a c6350a, String str, int i, DinamicTemplate dinamicTemplate) {
            this.b = str;
            this.c = i;
            this.d = dinamicTemplate;
        }

        @Override // java.io.FilenameFilter
        public boolean accept(File file, String str) {
            int lastIndexOf;
            if (!str.startsWith(this.b) || (lastIndexOf = str.lastIndexOf(JSMethod.NOT_SET)) == -1) {
                return false;
            }
            try {
                int intValue = Integer.valueOf(str.substring(lastIndexOf + 1)).intValue();
                if (intValue > this.a && intValue < this.c) {
                    this.a = intValue;
                    this.d.version = String.valueOf(intValue);
                }
                return true;
            } catch (NumberFormatException unused) {
                return false;
            }
        }
    }

    public C6350a(@NonNull Context context, String str) {
        this.a = "default_layout";
        this.b = "default_layout.db";
        if (context != null) {
            context.getApplicationContext();
        }
        this.a = str + "_layout";
        this.b = str + "_layout.db";
        this.d = new LruCache<>(16);
        this.c = new TemplateCache.C6349c().h(context).i(this.b).l(this.a).k(16).j(PlaybackStateCompat.ACTION_SET_SHUFFLE_MODE).g();
    }

    private TemplateCache c() {
        return this.c;
    }

    public DinamicTemplate a(DinamicTemplate dinamicTemplate) {
        int intValue;
        DinamicTemplate dinamicTemplate2;
        String str = dinamicTemplate.name;
        try {
            intValue = Integer.valueOf(dinamicTemplate.version).intValue();
            dinamicTemplate2 = this.d.get(str);
        } catch (NumberFormatException unused) {
        }
        if (dinamicTemplate2 != null) {
            return dinamicTemplate2;
        }
        DinamicTemplate dinamicTemplate3 = new DinamicTemplate();
        String[] list = this.c.g().list(new C6351a(this, str, intValue, dinamicTemplate3));
        if (list != null && list.length != 0) {
            dinamicTemplate3.name = str;
            return dinamicTemplate3;
        }
        return null;
    }

    public byte[] b(DinamicTemplate dinamicTemplate, String str, String str2, ul2 ul2Var) {
        return c().h(dinamicTemplate, str, str2, ul2Var);
    }

    public boolean d(@NonNull String str) {
        return c().i.get(str) != null || new File(this.c.g(), str).exists();
    }

    public byte[] e(String str, String str2) {
        String str3 = str + "/" + str2 + ".xml";
        try {
            return C6339a.a(C6313b.a().getAssets().open(str3));
        } catch (IOException e) {
            Log.e("LayoutFileManager", "readAssert exception: " + str3, e);
            return null;
        }
    }

    @Nullable
    public byte[] f(@NonNull String str) {
        TemplateCache c = c();
        byte[] bArr = null;
        try {
            byte[] bArr2 = c.i.get(str);
            if (bArr2 != null) {
                return bArr2;
            }
            try {
                return c.c(str, new ul2());
            } catch (Throwable th) {
                th = th;
                bArr = bArr2;
                Log.e("LayoutFileManager", "read local layout file exception", th);
                return bArr;
            }
        } catch (Throwable th2) {
            th = th2;
        }
    }

    public byte[] g(String str, String str2) {
        byte[] bArr = null;
        try {
            byte[] bArr2 = c().i.get(str2);
            if (bArr2 != null) {
                return bArr2;
            }
            try {
                return e(str, str2);
            } catch (Throwable th) {
                th = th;
                bArr = bArr2;
                Log.e("LayoutFileManager", "read local layout file from asset exception", th);
                return bArr;
            }
        } catch (Throwable th2) {
            th = th2;
        }
    }

    public byte[] h(@NonNull String str) throws IOException {
        TemplateCache c = c();
        byte[] bArr = c.i.get(str);
        if (bArr != null) {
            return bArr;
        }
        File file = new File(c.g(), str);
        if (file.exists()) {
            byte[] l = c.l(file);
            c.i.put(str, l);
            return l;
        }
        return null;
    }

    public void i(TemplateCache.HttpLoader httpLoader) {
        if (httpLoader != null) {
            this.c.j = httpLoader;
        }
    }
}
