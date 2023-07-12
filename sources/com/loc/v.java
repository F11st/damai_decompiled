package com.loc;

import java.io.BufferedWriter;
import java.io.Closeable;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FilterOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.io.Writer;
import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.concurrent.Callable;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.regex.Pattern;
import org.apache.commons.lang3.StringUtils;

/* compiled from: Taobao */
/* loaded from: classes10.dex */
public final class v implements Closeable {
    private static final ThreadFactory q;
    static ThreadPoolExecutor r;
    private static final OutputStream s;
    private final File a;
    private final File c;
    private final File d;
    private final File e;
    private long g;
    private Writer j;
    private int m;
    static final Pattern p = Pattern.compile("[a-z0-9_-]{1,120}");
    public static final Charset b = Charset.forName("US-ASCII");
    private long i = 0;
    private int k = 1000;
    private final LinkedHashMap<String, f> l = new LinkedHashMap<>(0, 0.75f, true);
    private long n = 0;
    private final Callable<Void> o = new b();
    private final int f = 1;
    private final int h = 1;

    /* compiled from: Taobao */
    /* loaded from: classes10.dex */
    static class a implements ThreadFactory {
        private final AtomicInteger a = new AtomicInteger(1);

        a() {
        }

        @Override // java.util.concurrent.ThreadFactory
        public final Thread newThread(Runnable runnable) {
            return new Thread(runnable, "disklrucache#" + this.a.getAndIncrement());
        }
    }

    /* compiled from: Taobao */
    /* loaded from: classes10.dex */
    final class b implements Callable<Void> {
        b() {
        }

        /* JADX INFO: Access modifiers changed from: private */
        @Override // java.util.concurrent.Callable
        /* renamed from: a */
        public Void call() throws Exception {
            synchronized (v.this) {
                if (v.this.j == null) {
                    return null;
                }
                v.this.G();
                if (v.this.E()) {
                    v.this.D();
                    v.v(v.this);
                }
                return null;
            }
        }
    }

    /* compiled from: Taobao */
    /* loaded from: classes10.dex */
    static class c extends OutputStream {
        c() {
        }

        @Override // java.io.OutputStream
        public final void write(int i) throws IOException {
        }
    }

    /* compiled from: Taobao */
    /* loaded from: classes10.dex */
    public final class d {
        private final f a;
        private final boolean[] b;
        private boolean c;

        /* compiled from: Taobao */
        /* loaded from: classes10.dex */
        private class a extends FilterOutputStream {
            private a(OutputStream outputStream) {
                super(outputStream);
            }

            /* synthetic */ a(d dVar, OutputStream outputStream, byte b) {
                this(outputStream);
            }

            @Override // java.io.FilterOutputStream, java.io.OutputStream, java.io.Closeable, java.lang.AutoCloseable
            public final void close() {
                try {
                    ((FilterOutputStream) this).out.close();
                } catch (IOException unused) {
                    d.f(d.this);
                }
            }

            @Override // java.io.FilterOutputStream, java.io.OutputStream, java.io.Flushable
            public final void flush() {
                try {
                    ((FilterOutputStream) this).out.flush();
                } catch (IOException unused) {
                    d.f(d.this);
                }
            }

            @Override // java.io.FilterOutputStream, java.io.OutputStream
            public final void write(int i) {
                try {
                    ((FilterOutputStream) this).out.write(i);
                } catch (IOException unused) {
                    d.f(d.this);
                }
            }

            @Override // java.io.FilterOutputStream, java.io.OutputStream
            public final void write(byte[] bArr, int i, int i2) {
                try {
                    ((FilterOutputStream) this).out.write(bArr, i, i2);
                } catch (IOException unused) {
                    d.f(d.this);
                }
            }
        }

        private d(f fVar) {
            this.a = fVar;
            this.b = fVar.c ? null : new boolean[v.this.h];
        }

        /* synthetic */ d(v vVar, f fVar, byte b) {
            this(fVar);
        }

        static /* synthetic */ boolean f(d dVar) {
            dVar.c = true;
            return true;
        }

        public final OutputStream b() throws IOException {
            FileOutputStream fileOutputStream;
            a aVar;
            if (v.this.h <= 0) {
                throw new IllegalArgumentException("Expected index 0 to be greater than 0 and less than the maximum value count of " + v.this.h);
            }
            synchronized (v.this) {
                if (this.a.d != this) {
                    throw new IllegalStateException();
                }
                if (!this.a.c) {
                    this.b[0] = true;
                }
                File i = this.a.i(0);
                try {
                    fileOutputStream = new FileOutputStream(i);
                } catch (FileNotFoundException unused) {
                    v.this.a.mkdirs();
                    try {
                        fileOutputStream = new FileOutputStream(i);
                    } catch (FileNotFoundException unused2) {
                        return v.s;
                    }
                }
                aVar = new a(this, fileOutputStream, (byte) 0);
            }
            return aVar;
        }

        public final void c() throws IOException {
            if (!this.c) {
                v.this.g(this, true);
                return;
            }
            v.this.g(this, false);
            v.this.r(this.a.a);
        }

        public final void e() throws IOException {
            v.this.g(this, false);
        }
    }

    /* compiled from: Taobao */
    /* loaded from: classes10.dex */
    public final class e implements Closeable {
        private final InputStream[] a;

        private e(v vVar, String str, long j, InputStream[] inputStreamArr, long[] jArr) {
            this.a = inputStreamArr;
        }

        /* synthetic */ e(v vVar, String str, long j, InputStream[] inputStreamArr, long[] jArr, byte b) {
            this(vVar, str, j, inputStreamArr, jArr);
        }

        public final InputStream a() {
            return this.a[0];
        }

        @Override // java.io.Closeable, java.lang.AutoCloseable
        public final void close() {
            for (InputStream inputStream : this.a) {
                v.i(inputStream);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: Taobao */
    /* loaded from: classes10.dex */
    public final class f {
        private final String a;
        private final long[] b;
        private boolean c;
        private d d;
        private long e;

        private f(String str) {
            this.a = str;
            this.b = new long[v.this.h];
        }

        /* synthetic */ f(v vVar, String str, byte b) {
            this(str);
        }

        private static IOException d(String[] strArr) throws IOException {
            throw new IOException("unexpected journal line: " + Arrays.toString(strArr));
        }

        static /* synthetic */ void f(f fVar, String[] strArr) throws IOException {
            if (strArr.length != v.this.h) {
                throw d(strArr);
            }
            for (int i = 0; i < strArr.length; i++) {
                try {
                    fVar.b[i] = Long.parseLong(strArr[i]);
                } catch (NumberFormatException unused) {
                    throw d(strArr);
                }
            }
        }

        static /* synthetic */ boolean g(f fVar) {
            fVar.c = true;
            return true;
        }

        public final File c(int i) {
            File file = v.this.a;
            return new File(file, this.a + "." + i);
        }

        public final String e() throws IOException {
            long[] jArr;
            StringBuilder sb = new StringBuilder();
            for (long j : this.b) {
                sb.append(' ');
                sb.append(j);
            }
            return sb.toString();
        }

        public final File i(int i) {
            File file = v.this.a;
            return new File(file, this.a + "." + i + ".tmp");
        }
    }

    static {
        Charset.forName("UTF-8");
        a aVar = new a();
        q = aVar;
        r = new ThreadPoolExecutor(0, 1, 60L, TimeUnit.SECONDS, new LinkedBlockingQueue(), aVar);
        s = new c();
    }

    private v(File file, long j) {
        this.a = file;
        this.c = new File(file, "journal");
        this.d = new File(file, "journal.tmp");
        this.e = new File(file, "journal.bkp");
        this.g = j;
    }

    /* JADX WARN: Code restructure failed: missing block: B:47:0x00ed, code lost:
        throw new java.io.IOException("unexpected journal line: ".concat(r3));
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private void B() throws java.io.IOException {
        /*
            Method dump skipped, instructions count: 309
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.loc.v.B():void");
    }

    private void C() throws IOException {
        j(this.d);
        Iterator<f> it = this.l.values().iterator();
        while (it.hasNext()) {
            f next = it.next();
            int i = 0;
            if (next.d == null) {
                while (i < this.h) {
                    this.i += next.b[i];
                    i++;
                }
            } else {
                next.d = null;
                while (i < this.h) {
                    j(next.c(i));
                    j(next.i(i));
                    i++;
                }
                it.remove();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public synchronized void D() throws IOException {
        Writer writer = this.j;
        if (writer != null) {
            writer.close();
        }
        BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(this.d), b));
        bufferedWriter.write("libcore.io.DiskLruCache");
        bufferedWriter.write(StringUtils.LF);
        bufferedWriter.write("1");
        bufferedWriter.write(StringUtils.LF);
        bufferedWriter.write(Integer.toString(this.f));
        bufferedWriter.write(StringUtils.LF);
        bufferedWriter.write(Integer.toString(this.h));
        bufferedWriter.write(StringUtils.LF);
        bufferedWriter.write(StringUtils.LF);
        for (f fVar : this.l.values()) {
            bufferedWriter.write(fVar.d != null ? "DIRTY " + fVar.a + '\n' : "CLEAN " + fVar.a + fVar.e() + '\n');
        }
        bufferedWriter.close();
        if (this.c.exists()) {
            k(this.c, this.e, true);
        }
        k(this.d, this.c, false);
        this.e.delete();
        this.j = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(this.c, true), b));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean E() {
        int i = this.m;
        return i >= 2000 && i >= this.l.size();
    }

    private void F() {
        if (this.j == null) {
            throw new IllegalStateException("cache is closed");
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void G() throws IOException {
        while (true) {
            if (this.i <= this.g && this.l.size() <= this.k) {
                return;
            }
            r(this.l.entrySet().iterator().next().getKey());
        }
    }

    public static v b(File file, long j) throws IOException {
        if (j > 0) {
            File file2 = new File(file, "journal.bkp");
            if (file2.exists()) {
                File file3 = new File(file, "journal");
                if (file3.exists()) {
                    file2.delete();
                } else {
                    k(file2, file3, false);
                }
            }
            v vVar = new v(file, j);
            if (vVar.c.exists()) {
                try {
                    vVar.B();
                    vVar.C();
                    vVar.j = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(vVar.c, true), b));
                    return vVar;
                } catch (Throwable unused) {
                    vVar.t();
                }
            }
            file.mkdirs();
            v vVar2 = new v(file, j);
            vVar2.D();
            return vVar2;
        }
        throw new IllegalArgumentException("maxSize <= 0");
    }

    public static void e() {
        ThreadPoolExecutor threadPoolExecutor = r;
        if (threadPoolExecutor == null || threadPoolExecutor.isShutdown()) {
            return;
        }
        r.shutdown();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public synchronized void g(d dVar, boolean z) throws IOException {
        f fVar = dVar.a;
        if (fVar.d != dVar) {
            throw new IllegalStateException();
        }
        if (z && !fVar.c) {
            for (int i = 0; i < this.h; i++) {
                if (!dVar.b[i]) {
                    dVar.e();
                    throw new IllegalStateException("Newly created entry didn't create value for index ".concat(String.valueOf(i)));
                } else if (!fVar.i(i).exists()) {
                    dVar.e();
                    return;
                }
            }
        }
        for (int i2 = 0; i2 < this.h; i2++) {
            File i3 = fVar.i(i2);
            if (!z) {
                j(i3);
            } else if (i3.exists()) {
                File c2 = fVar.c(i2);
                i3.renameTo(c2);
                long j = fVar.b[i2];
                long length = c2.length();
                fVar.b[i2] = length;
                this.i = (this.i - j) + length;
            }
        }
        this.m++;
        fVar.d = null;
        if (fVar.c || z) {
            f.g(fVar);
            this.j.write("CLEAN " + fVar.a + fVar.e() + '\n');
            if (z) {
                long j2 = this.n;
                this.n = 1 + j2;
                fVar.e = j2;
            }
        } else {
            this.l.remove(fVar.a);
            this.j.write("REMOVE " + fVar.a + '\n');
        }
        this.j.flush();
        if (this.i > this.g || E()) {
            z().submit(this.o);
        }
    }

    public static void i(Closeable closeable) {
        if (closeable != null) {
            try {
                closeable.close();
            } catch (RuntimeException e2) {
                throw e2;
            } catch (Exception unused) {
            }
        }
    }

    private static void j(File file) throws IOException {
        if (file.exists() && !file.delete()) {
            throw new IOException();
        }
    }

    private static void k(File file, File file2, boolean z) throws IOException {
        if (z) {
            j(file2);
        }
        if (!file.renameTo(file2)) {
            throw new IOException();
        }
    }

    private static void o(File file) throws IOException {
        File[] listFiles = file.listFiles();
        if (listFiles == null) {
            throw new IOException("not a readable directory: ".concat(String.valueOf(file)));
        }
        for (File file2 : listFiles) {
            if (file2.isDirectory()) {
                o(file2);
            }
            if (!file2.delete()) {
                throw new IOException("failed to delete file: ".concat(String.valueOf(file2)));
            }
        }
    }

    private synchronized d s(String str) throws IOException {
        F();
        x(str);
        f fVar = this.l.get(str);
        if (fVar == null) {
            fVar = new f(this, str, (byte) 0);
            this.l.put(str, fVar);
        } else if (fVar.d != null) {
            return null;
        }
        d dVar = new d(this, fVar, (byte) 0);
        fVar.d = dVar;
        Writer writer = this.j;
        writer.write("DIRTY " + str + '\n');
        this.j.flush();
        return dVar;
    }

    static /* synthetic */ int v(v vVar) {
        vVar.m = 0;
        return 0;
    }

    private static void x(String str) {
        if (p.matcher(str).matches()) {
            return;
        }
        throw new IllegalArgumentException("keys must match regex [a-z0-9_-]{1,120}: \"" + str + "\"");
    }

    private static ThreadPoolExecutor z() {
        try {
            ThreadPoolExecutor threadPoolExecutor = r;
            if (threadPoolExecutor == null || threadPoolExecutor.isShutdown()) {
                r = new ThreadPoolExecutor(0, 1, 60L, TimeUnit.SECONDS, new LinkedBlockingQueue(256), q);
            }
        } catch (Throwable th) {
            th.printStackTrace();
        }
        return r;
    }

    public final synchronized e a(String str) throws IOException {
        F();
        x(str);
        f fVar = this.l.get(str);
        if (fVar == null) {
            return null;
        }
        if (fVar.c) {
            InputStream[] inputStreamArr = new InputStream[this.h];
            for (int i = 0; i < this.h; i++) {
                try {
                    inputStreamArr[i] = new FileInputStream(fVar.c(i));
                } catch (FileNotFoundException unused) {
                    for (int i2 = 0; i2 < this.h && inputStreamArr[i2] != null; i2++) {
                        i(inputStreamArr[i2]);
                    }
                    return null;
                }
            }
            this.m++;
            this.j.append((CharSequence) ("READ " + str + '\n'));
            if (E()) {
                z().submit(this.o);
            }
            return new e(this, str, fVar.e, inputStreamArr, fVar.b, (byte) 0);
        }
        return null;
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public final synchronized void close() throws IOException {
        if (this.j == null) {
            return;
        }
        Iterator it = new ArrayList(this.l.values()).iterator();
        while (it.hasNext()) {
            f fVar = (f) it.next();
            if (fVar.d != null) {
                fVar.d.e();
            }
        }
        G();
        this.j.close();
        this.j = null;
    }

    public final void f(int i) {
        if (i < 10) {
            i = 10;
        } else if (i > 10000) {
            i = 10000;
        }
        this.k = i;
    }

    public final d l(String str) throws IOException {
        return s(str);
    }

    public final File m() {
        return this.a;
    }

    public final synchronized void p() throws IOException {
        F();
        G();
        this.j.flush();
    }

    public final synchronized boolean r(String str) throws IOException {
        F();
        x(str);
        f fVar = this.l.get(str);
        if (fVar != null && fVar.d == null) {
            for (int i = 0; i < this.h; i++) {
                File c2 = fVar.c(i);
                if (c2.exists() && !c2.delete()) {
                    throw new IOException("failed to delete ".concat(String.valueOf(c2)));
                }
                this.i -= fVar.b[i];
                fVar.b[i] = 0;
            }
            this.m++;
            this.j.append((CharSequence) ("REMOVE " + str + '\n'));
            this.l.remove(str);
            if (E()) {
                z().submit(this.o);
            }
            return true;
        }
        return false;
    }

    public final void t() throws IOException {
        close();
        o(this.a);
    }
}
