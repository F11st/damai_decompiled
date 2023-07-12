package com.taobao.alivfssdk.cache;

import android.app.Application;
import android.content.Context;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.taobao.alivfsadapter.AVFSAdapterManager;
import com.taobao.alivfssdk.utils.C6292a;
import java.io.File;
import java.io.IOException;
import java.util.concurrent.ConcurrentHashMap;
import tb.C9152g0;
import tb.C9248i0;

/* compiled from: Taobao */
/* renamed from: com.taobao.alivfssdk.cache.b */
/* loaded from: classes8.dex */
public class C6261b {
    private static volatile C6261b d;
    private final androidx.collection.LruCache<String, C6258a> a;
    private final ConcurrentHashMap<String, C9152g0> b = new ConcurrentHashMap<>();
    private final Context c;

    /* compiled from: Taobao */
    /* renamed from: com.taobao.alivfssdk.cache.b$a */
    /* loaded from: classes8.dex */
    class C6262a extends androidx.collection.LruCache<String, C6258a> {
        C6262a(C6261b c6261b, int i) {
            super(i);
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // androidx.collection.LruCache
        /* renamed from: a */
        public void entryRemoved(boolean z, String str, C6258a c6258a, C6258a c6258a2) {
        }
    }

    C6261b() {
        Application e = AVFSAdapterManager.g().e();
        Context applicationContext = e.getApplicationContext();
        if (applicationContext == null) {
            this.c = e;
        } else {
            this.c = applicationContext;
        }
        this.a = new C6262a(this, 5);
    }

    @NonNull
    private C6258a b(File file, String str) {
        C6258a c6258a;
        synchronized (this.a) {
            c6258a = this.a.get(str);
            if (c6258a == null) {
                c6258a = new C6258a(str, file == null ? null : new File(file, str));
                C9152g0 c9152g0 = this.b.get(str);
                if (c9152g0 != null) {
                    c6258a.f(c9152g0);
                }
                this.a.put(str, c6258a);
            }
        }
        return c6258a;
    }

    public static C6261b d() {
        if (d == null) {
            synchronized (C6261b.class) {
                if (d == null) {
                    d = new C6261b();
                }
            }
        }
        return d;
    }

    @Nullable
    public C6258a a(@NonNull String str) {
        File file;
        if (str != null) {
            try {
                file = e();
            } catch (IOException e) {
                C9248i0.d("AVFSCacheManager", e, new Object[0]);
                file = null;
            }
            return b(file, str);
        }
        throw new IllegalArgumentException("moduleName cannot be null");
    }

    public Context c() {
        return this.c;
    }

    public File e() throws IOException {
        try {
            return f(true);
        } catch (IOException e) {
            C9248i0.d("AVFSCacheManager", e, new Object[0]);
            return f(false);
        }
    }

    public File f(boolean z) throws IOException {
        if (z) {
            try {
                File externalFilesDir = this.c.getExternalFilesDir("AVFSCache");
                if (externalFilesDir != null) {
                    return externalFilesDir;
                }
                throw new IOException("Couldn't create directory AVFSCache");
            } catch (Exception e) {
                throw new IOException(e);
            }
        }
        File file = new File(this.c.getFilesDir(), "AVFSCache");
        C6292a.a(file);
        return file;
    }

    public void g(@NonNull String str) {
        if (str != null) {
            synchronized (this.a) {
                C6258a remove = this.a.remove(str);
                if (remove == null) {
                    return;
                }
                remove.clearAll();
                return;
            }
        }
        throw new IllegalArgumentException("moduleName cannot be null");
    }
}
