package com.taobao.alivfssdk.cache;

import android.app.Application;
import androidx.annotation.Nullable;
import com.taobao.alivfssdk.fresco.common.file.C6285a;
import com.taobao.orange.OConfigListener;
import com.taobao.orange.OrangeConfig;
import java.io.Closeable;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;
import tb.C9121f0;
import tb.C9152g0;
import tb.C9248i0;

/* compiled from: Taobao */
/* renamed from: com.taobao.alivfssdk.cache.a */
/* loaded from: classes8.dex */
public class C6258a implements Closeable {
    private static boolean i;
    private final String b;
    private IAVFSCache c;
    private IAVFSCache d;
    private IAVFSCache e;
    private final File g;
    private ClassLoader h;
    private Set<String> a = new HashSet();
    private final C9152g0 f = C9152g0.a();

    /* compiled from: Taobao */
    /* renamed from: com.taobao.alivfssdk.cache.a$b */
    /* loaded from: classes8.dex */
    private static class C6260b implements OConfigListener {
        private C6260b() {
        }

        /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:25:0x005e -> B:33:0x006d). Please submit an issue!!! */
        @Override // com.taobao.orange.OConfigListener
        public void onConfigUpdate(String str, Map<String, String> map) {
            String config;
            if (!"ali_database_es".equals(str) || (config = OrangeConfig.getInstance().getConfig("ali_database_es", "lsm_white_list", "")) == null || config.length() <= 0) {
                return;
            }
            Application a = C9121f0.a();
            FileWriter fileWriter = null;
            try {
            } catch (IOException e) {
                e.printStackTrace();
            }
            try {
                try {
                    FileWriter fileWriter2 = new FileWriter(a.getFilesDir().getAbsolutePath() + File.pathSeparator + "alivfs.cfg");
                    try {
                        fileWriter2.write(config);
                        fileWriter2.close();
                    } catch (IOException e2) {
                        e = e2;
                        fileWriter = fileWriter2;
                        e.printStackTrace();
                        if (fileWriter != null) {
                            fileWriter.close();
                        }
                    } catch (Throwable th) {
                        th = th;
                        fileWriter = fileWriter2;
                        if (fileWriter != null) {
                            try {
                                fileWriter.close();
                            } catch (IOException e3) {
                                e3.printStackTrace();
                            }
                        }
                        throw th;
                    }
                } catch (IOException e4) {
                    e = e4;
                }
            } catch (Throwable th2) {
                th = th2;
            }
        }
    }

    public C6258a(@Nullable String str, @Nullable File file) {
        this.b = str;
        this.g = file;
        if (file == null) {
            C6271e a = C6271e.a();
            this.e = a;
            this.d = a;
            this.c = a;
        }
    }

    public ClassLoader a() {
        return this.h;
    }

    /* JADX WARN: Removed duplicated region for block: B:47:0x00b4  */
    /* JADX WARN: Removed duplicated region for block: B:48:0x00c1  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public com.taobao.alivfssdk.cache.IAVFSCache c() {
        /*
            Method dump skipped, instructions count: 247
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.taobao.alivfssdk.cache.C6258a.c():com.taobao.alivfssdk.cache.IAVFSCache");
    }

    public void clearAll() {
        try {
            close();
        } catch (IOException e) {
            C9248i0.d("AVFSCache", e, new Object[0]);
        }
        File file = this.g;
        if (file != null) {
            C6285a.a(file);
        }
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public void close() throws IOException {
        IAVFSCache iAVFSCache = this.c;
        if (iAVFSCache != null) {
            iAVFSCache.close();
            this.c = null;
        }
        IAVFSCache iAVFSCache2 = this.d;
        if (iAVFSCache2 != null) {
            iAVFSCache2.close();
            this.d = null;
        }
        IAVFSCache iAVFSCache3 = this.e;
        if (iAVFSCache3 != null) {
            iAVFSCache3.close();
            this.e = null;
        }
    }

    public String e() {
        return this.b;
    }

    public C6258a f(C9152g0 c9152g0) {
        this.f.b(c9152g0);
        return this;
    }

    protected void finalize() throws Throwable {
        super.finalize();
    }
}
