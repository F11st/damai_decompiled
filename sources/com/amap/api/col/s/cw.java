package com.amap.api.col.s;

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
public final class cw implements Closeable {
    static final Pattern a = Pattern.compile("[a-z0-9_-]{1,120}");
    public static final Charset b = Charset.forName("US-ASCII");
    static final Charset c = Charset.forName("UTF-8");
    static ThreadPoolExecutor d;
    private static final ThreadFactory r;
    private static final OutputStream t;
    private final File e;
    private final File f;
    private final File g;
    private final File h;
    private long j;
    private Writer m;
    private int p;
    private long l = 0;
    private int n = 1000;
    private final LinkedHashMap<String, c> o = new LinkedHashMap<>(0, 0.75f, true);
    private long q = 0;
    private final Callable<Void> s = new Callable<Void>() { // from class: com.amap.api.col.s.cw.2
        /* JADX INFO: Access modifiers changed from: private */
        @Override // java.util.concurrent.Callable
        /* renamed from: a */
        public Void call() throws Exception {
            synchronized (cw.this) {
                if (cw.this.m == null) {
                    return null;
                }
                cw.this.k();
                if (cw.this.i()) {
                    cw.this.h();
                    cw.e(cw.this);
                }
                return null;
            }
        }
    };
    private final int i = 1;
    private final int k = 1;

    /* compiled from: Taobao */
    /* loaded from: classes10.dex */
    public final class a {
        private final c b;
        private final boolean[] c;
        private boolean d;
        private boolean e;

        /* compiled from: Taobao */
        /* renamed from: com.amap.api.col.s.cw$a$a  reason: collision with other inner class name */
        /* loaded from: classes10.dex */
        private class C0209a extends FilterOutputStream {
            /* synthetic */ C0209a(a aVar, OutputStream outputStream, byte b) {
                this(outputStream);
            }

            @Override // java.io.FilterOutputStream, java.io.OutputStream, java.io.Closeable, java.lang.AutoCloseable
            public final void close() {
                try {
                    ((FilterOutputStream) this).out.close();
                } catch (IOException unused) {
                    a.c(a.this);
                }
            }

            @Override // java.io.FilterOutputStream, java.io.OutputStream, java.io.Flushable
            public final void flush() {
                try {
                    ((FilterOutputStream) this).out.flush();
                } catch (IOException unused) {
                    a.c(a.this);
                }
            }

            @Override // java.io.FilterOutputStream, java.io.OutputStream
            public final void write(int i) {
                try {
                    ((FilterOutputStream) this).out.write(i);
                } catch (IOException unused) {
                    a.c(a.this);
                }
            }

            private C0209a(OutputStream outputStream) {
                super(outputStream);
            }

            @Override // java.io.FilterOutputStream, java.io.OutputStream
            public final void write(byte[] bArr, int i, int i2) {
                try {
                    ((FilterOutputStream) this).out.write(bArr, i, i2);
                } catch (IOException unused) {
                    a.c(a.this);
                }
            }
        }

        /* synthetic */ a(cw cwVar, c cVar, byte b) {
            this(cVar);
        }

        static /* synthetic */ boolean c(a aVar) {
            aVar.d = true;
            return true;
        }

        private a(c cVar) {
            this.b = cVar;
            this.c = cVar.d ? null : new boolean[cw.this.k];
        }

        public final OutputStream a() throws IOException {
            FileOutputStream fileOutputStream;
            C0209a c0209a;
            if (cw.this.k <= 0) {
                throw new IllegalArgumentException("Expected index 0 to be greater than 0 and less than the maximum value count of " + cw.this.k);
            }
            synchronized (cw.this) {
                if (this.b.e == this) {
                    if (!this.b.d) {
                        this.c[0] = true;
                    }
                    File b = this.b.b(0);
                    try {
                        fileOutputStream = new FileOutputStream(b);
                    } catch (FileNotFoundException unused) {
                        cw.this.e.mkdirs();
                        try {
                            fileOutputStream = new FileOutputStream(b);
                        } catch (FileNotFoundException unused2) {
                            return cw.t;
                        }
                    }
                    c0209a = new C0209a(this, fileOutputStream, (byte) 0);
                } else {
                    throw new IllegalStateException();
                }
            }
            return c0209a;
        }

        public final void b() throws IOException {
            if (this.d) {
                cw.this.a(this, false);
                cw.this.c(this.b.b);
            } else {
                cw.this.a(this, true);
            }
            this.e = true;
        }

        public final void c() throws IOException {
            cw.this.a(this, false);
        }
    }

    /* compiled from: Taobao */
    /* loaded from: classes10.dex */
    public final class b implements Closeable {
        private final String b;
        private final long c;
        private final InputStream[] d;
        private final long[] e;

        /* synthetic */ b(cw cwVar, String str, long j, InputStream[] inputStreamArr, long[] jArr, byte b) {
            this(str, j, inputStreamArr, jArr);
        }

        public final InputStream a() {
            return this.d[0];
        }

        @Override // java.io.Closeable, java.lang.AutoCloseable
        public final void close() {
            for (InputStream inputStream : this.d) {
                cw.a(inputStream);
            }
        }

        private b(String str, long j, InputStream[] inputStreamArr, long[] jArr) {
            this.b = str;
            this.c = j;
            this.d = inputStreamArr;
            this.e = jArr;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: Taobao */
    /* loaded from: classes10.dex */
    public final class c {
        private final String b;
        private final long[] c;
        private boolean d;
        private a e;
        private long f;

        /* synthetic */ c(cw cwVar, String str, byte b) {
            this(str);
        }

        private c(String str) {
            this.b = str;
            this.c = new long[cw.this.k];
        }

        public final File b(int i) {
            File file = cw.this.e;
            return new File(file, this.b + "." + i + ".tmp");
        }

        static /* synthetic */ boolean a(c cVar) {
            cVar.d = true;
            return true;
        }

        public final String a() throws IOException {
            long[] jArr;
            StringBuilder sb = new StringBuilder();
            for (long j : this.c) {
                sb.append(' ');
                sb.append(j);
            }
            return sb.toString();
        }

        private static IOException a(String[] strArr) throws IOException {
            throw new IOException("unexpected journal line: " + Arrays.toString(strArr));
        }

        public final File a(int i) {
            File file = cw.this.e;
            return new File(file, this.b + "." + i);
        }

        static /* synthetic */ void a(c cVar, String[] strArr) throws IOException {
            if (strArr.length == cw.this.k) {
                for (int i = 0; i < strArr.length; i++) {
                    try {
                        cVar.c[i] = Long.parseLong(strArr[i]);
                    } catch (NumberFormatException unused) {
                        throw a(strArr);
                    }
                }
                return;
            }
            throw a(strArr);
        }
    }

    static {
        ThreadFactory threadFactory = new ThreadFactory() { // from class: com.amap.api.col.s.cw.1
            private final AtomicInteger a = new AtomicInteger(1);

            @Override // java.util.concurrent.ThreadFactory
            public final Thread newThread(Runnable runnable) {
                return new Thread(runnable, "disklrucache#" + this.a.getAndIncrement());
            }
        };
        r = threadFactory;
        d = new ThreadPoolExecutor(0, 1, 60L, TimeUnit.SECONDS, new LinkedBlockingQueue(), threadFactory);
        t = new OutputStream() { // from class: com.amap.api.col.s.cw.3
            @Override // java.io.OutputStream
            public final void write(int i) throws IOException {
            }
        };
    }

    private cw(File file, long j) {
        this.e = file;
        this.f = new File(file, "journal");
        this.g = new File(file, "journal.tmp");
        this.h = new File(file, "journal.bkp");
        this.j = j;
    }

    static /* synthetic */ int e(cw cwVar) {
        cwVar.p = 0;
        return 0;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public synchronized void h() throws IOException {
        Writer writer = this.m;
        if (writer != null) {
            writer.close();
        }
        BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(this.g), b));
        bufferedWriter.write("libcore.io.DiskLruCache");
        bufferedWriter.write(StringUtils.LF);
        bufferedWriter.write("1");
        bufferedWriter.write(StringUtils.LF);
        bufferedWriter.write(Integer.toString(this.i));
        bufferedWriter.write(StringUtils.LF);
        bufferedWriter.write(Integer.toString(this.k));
        bufferedWriter.write(StringUtils.LF);
        bufferedWriter.write(StringUtils.LF);
        for (c cVar : this.o.values()) {
            if (cVar.e != null) {
                bufferedWriter.write("DIRTY " + cVar.b + '\n');
            } else {
                bufferedWriter.write("CLEAN " + cVar.b + cVar.a() + '\n');
            }
        }
        bufferedWriter.close();
        if (this.f.exists()) {
            a(this.f, this.h, true);
        }
        a(this.g, this.f, false);
        this.h.delete();
        this.m = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(this.f, true), b));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean i() {
        int i = this.p;
        return i >= 2000 && i >= this.o.size();
    }

    private void j() {
        if (this.m == null) {
            throw new IllegalStateException("cache is closed");
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void k() throws IOException {
        while (true) {
            if (this.l <= this.j && this.o.size() <= this.n) {
                return;
            }
            c(this.o.entrySet().iterator().next().getKey());
        }
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public final synchronized void close() throws IOException {
        if (this.m == null) {
            return;
        }
        Iterator it = new ArrayList(this.o.values()).iterator();
        while (it.hasNext()) {
            c cVar = (c) it.next();
            if (cVar.e != null) {
                cVar.e.c();
            }
        }
        k();
        this.m.close();
        this.m = null;
    }

    private static ThreadPoolExecutor e() {
        try {
            ThreadPoolExecutor threadPoolExecutor = d;
            if (threadPoolExecutor == null || threadPoolExecutor.isShutdown()) {
                d = new ThreadPoolExecutor(0, 1, 60L, TimeUnit.SECONDS, new LinkedBlockingQueue(256), r);
            }
        } catch (Throwable th) {
            th.printStackTrace();
        }
        return d;
    }

    /* JADX WARN: Code restructure failed: missing block: B:47:0x00ed, code lost:
        throw new java.io.IOException("unexpected journal line: ".concat(r3));
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private void f() throws java.io.IOException {
        /*
            Method dump skipped, instructions count: 309
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.amap.api.col.s.cw.f():void");
    }

    private void g() throws IOException {
        a(this.g);
        Iterator<c> it = this.o.values().iterator();
        while (it.hasNext()) {
            c next = it.next();
            int i = 0;
            if (next.e != null) {
                next.e = null;
                while (i < this.k) {
                    a(next.a(i));
                    a(next.b(i));
                    i++;
                }
                it.remove();
            } else {
                while (i < this.k) {
                    this.l += next.c[i];
                    i++;
                }
            }
        }
    }

    public final a b(String str) throws IOException {
        return d(str);
    }

    public final synchronized boolean c(String str) throws IOException {
        j();
        e(str);
        c cVar = this.o.get(str);
        if (cVar != null && cVar.e == null) {
            for (int i = 0; i < this.k; i++) {
                File a2 = cVar.a(i);
                if (a2.exists() && !a2.delete()) {
                    throw new IOException("failed to delete ".concat(String.valueOf(a2)));
                }
                this.l -= cVar.c[i];
                cVar.c[i] = 0;
            }
            this.p++;
            this.m.append((CharSequence) ("REMOVE " + str + '\n'));
            this.o.remove(str);
            if (i()) {
                e().submit(this.s);
            }
            return true;
        }
        return false;
    }

    private synchronized a d(String str) throws IOException {
        j();
        e(str);
        c cVar = this.o.get(str);
        if (cVar != null) {
            if (cVar.e != null) {
                return null;
            }
        } else {
            cVar = new c(this, str, (byte) 0);
            this.o.put(str, cVar);
        }
        a aVar = new a(this, cVar, (byte) 0);
        cVar.e = aVar;
        Writer writer = this.m;
        writer.write("DIRTY " + str + '\n');
        this.m.flush();
        return aVar;
    }

    public final void a(int i) {
        if (i < 10) {
            i = 10;
        } else if (i > 10000) {
            i = 10000;
        }
        this.n = i;
    }

    public final synchronized void b() throws IOException {
        j();
        k();
        this.m.flush();
    }

    public static cw a(File file, long j) throws IOException {
        if (j > 0) {
            File file2 = new File(file, "journal.bkp");
            if (file2.exists()) {
                File file3 = new File(file, "journal");
                if (file3.exists()) {
                    file2.delete();
                } else {
                    a(file2, file3, false);
                }
            }
            cw cwVar = new cw(file, j);
            if (cwVar.f.exists()) {
                try {
                    cwVar.f();
                    cwVar.g();
                    cwVar.m = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(cwVar.f, true), b));
                    return cwVar;
                } catch (Throwable unused) {
                    cwVar.c();
                }
            }
            file.mkdirs();
            cw cwVar2 = new cw(file, j);
            cwVar2.h();
            return cwVar2;
        }
        throw new IllegalArgumentException("maxSize <= 0");
    }

    private static void e(String str) {
        if (a.matcher(str).matches()) {
            return;
        }
        throw new IllegalArgumentException("keys must match regex [a-z0-9_-]{1,120}: \"" + str + "\"");
    }

    private static void b(File file) throws IOException {
        File[] listFiles = file.listFiles();
        if (listFiles != null) {
            for (File file2 : listFiles) {
                if (file2.isDirectory()) {
                    b(file2);
                }
                if (!file2.delete()) {
                    throw new IOException("failed to delete file: ".concat(String.valueOf(file2)));
                }
            }
            return;
        }
        throw new IOException("not a readable directory: ".concat(String.valueOf(file)));
    }

    public final void c() throws IOException {
        close();
        b(this.e);
    }

    private static void a(File file) throws IOException {
        if (file.exists() && !file.delete()) {
            throw new IOException();
        }
    }

    private static void a(File file, File file2, boolean z) throws IOException {
        if (z) {
            a(file2);
        }
        if (!file.renameTo(file2)) {
            throw new IOException();
        }
    }

    public final synchronized b a(String str) throws IOException {
        j();
        e(str);
        c cVar = this.o.get(str);
        if (cVar == null) {
            return null;
        }
        if (cVar.d) {
            InputStream[] inputStreamArr = new InputStream[this.k];
            for (int i = 0; i < this.k; i++) {
                try {
                    inputStreamArr[i] = new FileInputStream(cVar.a(i));
                } catch (FileNotFoundException unused) {
                    for (int i2 = 0; i2 < this.k && inputStreamArr[i2] != null; i2++) {
                        a(inputStreamArr[i2]);
                    }
                    return null;
                }
            }
            this.p++;
            this.m.append((CharSequence) ("READ " + str + '\n'));
            if (i()) {
                e().submit(this.s);
            }
            return new b(this, str, cVar.f, inputStreamArr, cVar.c, (byte) 0);
        }
        return null;
    }

    public final File a() {
        return this.e;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public synchronized void a(a aVar, boolean z) throws IOException {
        c cVar = aVar.b;
        if (cVar.e == aVar) {
            if (z && !cVar.d) {
                for (int i = 0; i < this.k; i++) {
                    if (aVar.c[i]) {
                        if (!cVar.b(i).exists()) {
                            aVar.c();
                            return;
                        }
                    } else {
                        aVar.c();
                        throw new IllegalStateException("Newly created entry didn't create value for index ".concat(String.valueOf(i)));
                    }
                }
            }
            for (int i2 = 0; i2 < this.k; i2++) {
                File b2 = cVar.b(i2);
                if (z) {
                    if (b2.exists()) {
                        File a2 = cVar.a(i2);
                        b2.renameTo(a2);
                        long j = cVar.c[i2];
                        long length = a2.length();
                        cVar.c[i2] = length;
                        this.l = (this.l - j) + length;
                    }
                } else {
                    a(b2);
                }
            }
            this.p++;
            cVar.e = null;
            if (!(cVar.d | z)) {
                this.o.remove(cVar.b);
                this.m.write("REMOVE " + cVar.b + '\n');
            } else {
                c.a(cVar);
                this.m.write("CLEAN " + cVar.b + cVar.a() + '\n');
                if (z) {
                    long j2 = this.q;
                    this.q = 1 + j2;
                    cVar.f = j2;
                }
            }
            this.m.flush();
            if (this.l > this.j || i()) {
                e().submit(this.s);
            }
            return;
        }
        throw new IllegalStateException();
    }

    public static void a(Closeable closeable) {
        if (closeable != null) {
            try {
                closeable.close();
            } catch (RuntimeException e) {
                throw e;
            } catch (Exception unused) {
            }
        }
    }
}
