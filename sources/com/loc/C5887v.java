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
/* renamed from: com.loc.v */
/* loaded from: classes10.dex */
public final class C5887v implements Closeable {
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
    private final LinkedHashMap<String, C5894f> l = new LinkedHashMap<>(0, 0.75f, true);
    private long n = 0;
    private final Callable<Void> o = new CallableC5889b();
    private final int f = 1;
    private final int h = 1;

    /* compiled from: Taobao */
    /* renamed from: com.loc.v$a */
    /* loaded from: classes10.dex */
    static class ThreadFactoryC5888a implements ThreadFactory {
        private final AtomicInteger a = new AtomicInteger(1);

        ThreadFactoryC5888a() {
        }

        @Override // java.util.concurrent.ThreadFactory
        public final Thread newThread(Runnable runnable) {
            return new Thread(runnable, "disklrucache#" + this.a.getAndIncrement());
        }
    }

    /* compiled from: Taobao */
    /* renamed from: com.loc.v$b */
    /* loaded from: classes10.dex */
    final class CallableC5889b implements Callable<Void> {
        CallableC5889b() {
        }

        /* JADX INFO: Access modifiers changed from: private */
        @Override // java.util.concurrent.Callable
        /* renamed from: a */
        public Void call() throws Exception {
            synchronized (C5887v.this) {
                if (C5887v.this.j == null) {
                    return null;
                }
                C5887v.this.G();
                if (C5887v.this.E()) {
                    C5887v.this.D();
                    C5887v.v(C5887v.this);
                }
                return null;
            }
        }
    }

    /* compiled from: Taobao */
    /* renamed from: com.loc.v$c */
    /* loaded from: classes10.dex */
    static class C5890c extends OutputStream {
        C5890c() {
        }

        @Override // java.io.OutputStream
        public final void write(int i) throws IOException {
        }
    }

    /* compiled from: Taobao */
    /* renamed from: com.loc.v$d */
    /* loaded from: classes10.dex */
    public final class C5891d {
        private final C5894f a;
        private final boolean[] b;
        private boolean c;

        /* compiled from: Taobao */
        /* renamed from: com.loc.v$d$a */
        /* loaded from: classes10.dex */
        private class C5892a extends FilterOutputStream {
            private C5892a(OutputStream outputStream) {
                super(outputStream);
            }

            /* synthetic */ C5892a(C5891d c5891d, OutputStream outputStream, byte b) {
                this(outputStream);
            }

            @Override // java.io.FilterOutputStream, java.io.OutputStream, java.io.Closeable, java.lang.AutoCloseable
            public final void close() {
                try {
                    ((FilterOutputStream) this).out.close();
                } catch (IOException unused) {
                    C5891d.f(C5891d.this);
                }
            }

            @Override // java.io.FilterOutputStream, java.io.OutputStream, java.io.Flushable
            public final void flush() {
                try {
                    ((FilterOutputStream) this).out.flush();
                } catch (IOException unused) {
                    C5891d.f(C5891d.this);
                }
            }

            @Override // java.io.FilterOutputStream, java.io.OutputStream
            public final void write(int i) {
                try {
                    ((FilterOutputStream) this).out.write(i);
                } catch (IOException unused) {
                    C5891d.f(C5891d.this);
                }
            }

            @Override // java.io.FilterOutputStream, java.io.OutputStream
            public final void write(byte[] bArr, int i, int i2) {
                try {
                    ((FilterOutputStream) this).out.write(bArr, i, i2);
                } catch (IOException unused) {
                    C5891d.f(C5891d.this);
                }
            }
        }

        private C5891d(C5894f c5894f) {
            this.a = c5894f;
            this.b = c5894f.c ? null : new boolean[C5887v.this.h];
        }

        /* synthetic */ C5891d(C5887v c5887v, C5894f c5894f, byte b) {
            this(c5894f);
        }

        static /* synthetic */ boolean f(C5891d c5891d) {
            c5891d.c = true;
            return true;
        }

        public final OutputStream b() throws IOException {
            FileOutputStream fileOutputStream;
            C5892a c5892a;
            if (C5887v.this.h <= 0) {
                throw new IllegalArgumentException("Expected index 0 to be greater than 0 and less than the maximum value count of " + C5887v.this.h);
            }
            synchronized (C5887v.this) {
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
                    C5887v.this.a.mkdirs();
                    try {
                        fileOutputStream = new FileOutputStream(i);
                    } catch (FileNotFoundException unused2) {
                        return C5887v.s;
                    }
                }
                c5892a = new C5892a(this, fileOutputStream, (byte) 0);
            }
            return c5892a;
        }

        public final void c() throws IOException {
            if (!this.c) {
                C5887v.this.g(this, true);
                return;
            }
            C5887v.this.g(this, false);
            C5887v.this.r(this.a.a);
        }

        public final void e() throws IOException {
            C5887v.this.g(this, false);
        }
    }

    /* compiled from: Taobao */
    /* renamed from: com.loc.v$e */
    /* loaded from: classes10.dex */
    public final class C5893e implements Closeable {
        private final InputStream[] a;

        private C5893e(C5887v c5887v, String str, long j, InputStream[] inputStreamArr, long[] jArr) {
            this.a = inputStreamArr;
        }

        /* synthetic */ C5893e(C5887v c5887v, String str, long j, InputStream[] inputStreamArr, long[] jArr, byte b) {
            this(c5887v, str, j, inputStreamArr, jArr);
        }

        public final InputStream a() {
            return this.a[0];
        }

        @Override // java.io.Closeable, java.lang.AutoCloseable
        public final void close() {
            for (InputStream inputStream : this.a) {
                C5887v.i(inputStream);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: Taobao */
    /* renamed from: com.loc.v$f */
    /* loaded from: classes10.dex */
    public final class C5894f {
        private final String a;
        private final long[] b;
        private boolean c;
        private C5891d d;
        private long e;

        private C5894f(String str) {
            this.a = str;
            this.b = new long[C5887v.this.h];
        }

        /* synthetic */ C5894f(C5887v c5887v, String str, byte b) {
            this(str);
        }

        private static IOException d(String[] strArr) throws IOException {
            throw new IOException("unexpected journal line: " + Arrays.toString(strArr));
        }

        static /* synthetic */ void f(C5894f c5894f, String[] strArr) throws IOException {
            if (strArr.length != C5887v.this.h) {
                throw d(strArr);
            }
            for (int i = 0; i < strArr.length; i++) {
                try {
                    c5894f.b[i] = Long.parseLong(strArr[i]);
                } catch (NumberFormatException unused) {
                    throw d(strArr);
                }
            }
        }

        static /* synthetic */ boolean g(C5894f c5894f) {
            c5894f.c = true;
            return true;
        }

        public final File c(int i) {
            File file = C5887v.this.a;
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
            File file = C5887v.this.a;
            return new File(file, this.a + "." + i + ".tmp");
        }
    }

    static {
        Charset.forName("UTF-8");
        ThreadFactoryC5888a threadFactoryC5888a = new ThreadFactoryC5888a();
        q = threadFactoryC5888a;
        r = new ThreadPoolExecutor(0, 1, 60L, TimeUnit.SECONDS, new LinkedBlockingQueue(), threadFactoryC5888a);
        s = new C5890c();
    }

    private C5887v(File file, long j) {
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
        throw new UnsupportedOperationException("Method not decompiled: com.loc.C5887v.B():void");
    }

    private void C() throws IOException {
        j(this.d);
        Iterator<C5894f> it = this.l.values().iterator();
        while (it.hasNext()) {
            C5894f next = it.next();
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
        for (C5894f c5894f : this.l.values()) {
            bufferedWriter.write(c5894f.d != null ? "DIRTY " + c5894f.a + '\n' : "CLEAN " + c5894f.a + c5894f.e() + '\n');
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

    public static C5887v b(File file, long j) throws IOException {
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
            C5887v c5887v = new C5887v(file, j);
            if (c5887v.c.exists()) {
                try {
                    c5887v.B();
                    c5887v.C();
                    c5887v.j = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(c5887v.c, true), b));
                    return c5887v;
                } catch (Throwable unused) {
                    c5887v.t();
                }
            }
            file.mkdirs();
            C5887v c5887v2 = new C5887v(file, j);
            c5887v2.D();
            return c5887v2;
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
    public synchronized void g(C5891d c5891d, boolean z) throws IOException {
        C5894f c5894f = c5891d.a;
        if (c5894f.d != c5891d) {
            throw new IllegalStateException();
        }
        if (z && !c5894f.c) {
            for (int i = 0; i < this.h; i++) {
                if (!c5891d.b[i]) {
                    c5891d.e();
                    throw new IllegalStateException("Newly created entry didn't create value for index ".concat(String.valueOf(i)));
                } else if (!c5894f.i(i).exists()) {
                    c5891d.e();
                    return;
                }
            }
        }
        for (int i2 = 0; i2 < this.h; i2++) {
            File i3 = c5894f.i(i2);
            if (!z) {
                j(i3);
            } else if (i3.exists()) {
                File c = c5894f.c(i2);
                i3.renameTo(c);
                long j = c5894f.b[i2];
                long length = c.length();
                c5894f.b[i2] = length;
                this.i = (this.i - j) + length;
            }
        }
        this.m++;
        c5894f.d = null;
        if (c5894f.c || z) {
            C5894f.g(c5894f);
            this.j.write("CLEAN " + c5894f.a + c5894f.e() + '\n');
            if (z) {
                long j2 = this.n;
                this.n = 1 + j2;
                c5894f.e = j2;
            }
        } else {
            this.l.remove(c5894f.a);
            this.j.write("REMOVE " + c5894f.a + '\n');
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
            } catch (RuntimeException e) {
                throw e;
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

    private synchronized C5891d s(String str) throws IOException {
        F();
        x(str);
        C5894f c5894f = this.l.get(str);
        if (c5894f == null) {
            c5894f = new C5894f(this, str, (byte) 0);
            this.l.put(str, c5894f);
        } else if (c5894f.d != null) {
            return null;
        }
        C5891d c5891d = new C5891d(this, c5894f, (byte) 0);
        c5894f.d = c5891d;
        Writer writer = this.j;
        writer.write("DIRTY " + str + '\n');
        this.j.flush();
        return c5891d;
    }

    static /* synthetic */ int v(C5887v c5887v) {
        c5887v.m = 0;
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

    public final synchronized C5893e a(String str) throws IOException {
        F();
        x(str);
        C5894f c5894f = this.l.get(str);
        if (c5894f == null) {
            return null;
        }
        if (c5894f.c) {
            InputStream[] inputStreamArr = new InputStream[this.h];
            for (int i = 0; i < this.h; i++) {
                try {
                    inputStreamArr[i] = new FileInputStream(c5894f.c(i));
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
            return new C5893e(this, str, c5894f.e, inputStreamArr, c5894f.b, (byte) 0);
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
            C5894f c5894f = (C5894f) it.next();
            if (c5894f.d != null) {
                c5894f.d.e();
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

    public final C5891d l(String str) throws IOException {
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
        C5894f c5894f = this.l.get(str);
        if (c5894f != null && c5894f.d == null) {
            for (int i = 0; i < this.h; i++) {
                File c = c5894f.c(i);
                if (c.exists() && !c.delete()) {
                    throw new IOException("failed to delete ".concat(String.valueOf(c)));
                }
                this.i -= c5894f.b[i];
                c5894f.b[i] = 0;
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
