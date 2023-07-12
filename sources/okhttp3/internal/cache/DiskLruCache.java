package okhttp3.internal.cache;

import com.taobao.alivfssdk.utils.AVFSCacheConstants;
import java.io.Closeable;
import java.io.EOFException;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.Flushable;
import java.io.IOException;
import java.util.Arrays;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.concurrent.Executor;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import java.util.regex.Pattern;
import javax.annotation.Nullable;
import okhttp3.internal.C8753a;
import okhttp3.internal.io.FileSystem;
import okio.BufferedSink;
import okio.BufferedSource;
import okio.C8844h;
import okio.Sink;
import okio.Source;
import tb.jn1;
import tb.ps1;

/* compiled from: Taobao */
/* loaded from: classes2.dex */
public final class DiskLruCache implements Closeable, Flushable {
    static final Pattern u = Pattern.compile("[a-z0-9_-]{1,120}");
    final FileSystem a;
    final File b;
    private final File c;
    private final File d;
    private final File e;
    private final int f;
    private long g;
    final int h;
    BufferedSink j;
    int l;
    boolean m;
    boolean n;
    boolean o;
    boolean p;
    boolean q;
    private final Executor s;
    private long i = 0;
    final LinkedHashMap<String, C8757c> k = new LinkedHashMap<>(0, 0.75f, true);
    private long r = 0;
    private final Runnable t = new Runnable() { // from class: okhttp3.internal.cache.DiskLruCache.1
        @Override // java.lang.Runnable
        public void run() {
            synchronized (DiskLruCache.this) {
                DiskLruCache diskLruCache = DiskLruCache.this;
                if ((!diskLruCache.n) || diskLruCache.o) {
                    return;
                }
                try {
                    diskLruCache.s();
                } catch (IOException unused) {
                    DiskLruCache.this.p = true;
                }
                try {
                    if (DiskLruCache.this.k()) {
                        DiskLruCache.this.p();
                        DiskLruCache.this.l = 0;
                    }
                } catch (IOException unused2) {
                    DiskLruCache diskLruCache2 = DiskLruCache.this;
                    diskLruCache2.q = true;
                    diskLruCache2.j = C8844h.c(C8844h.b());
                }
            }
        }
    };

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: Taobao */
    /* renamed from: okhttp3.internal.cache.DiskLruCache$a */
    /* loaded from: classes2.dex */
    public class C8754a extends C8763c {
        C8754a(Sink sink) {
            super(sink);
        }

        @Override // okhttp3.internal.cache.C8763c
        protected void onException(IOException iOException) {
            DiskLruCache.this.m = true;
        }
    }

    /* compiled from: Taobao */
    /* renamed from: okhttp3.internal.cache.DiskLruCache$b */
    /* loaded from: classes2.dex */
    public final class C8755b {
        final C8757c a;
        final boolean[] b;
        private boolean c;

        /* compiled from: Taobao */
        /* renamed from: okhttp3.internal.cache.DiskLruCache$b$a */
        /* loaded from: classes2.dex */
        class C8756a extends C8763c {
            C8756a(Sink sink) {
                super(sink);
            }

            @Override // okhttp3.internal.cache.C8763c
            protected void onException(IOException iOException) {
                synchronized (DiskLruCache.this) {
                    C8755b.this.c();
                }
            }
        }

        C8755b(C8757c c8757c) {
            this.a = c8757c;
            this.b = c8757c.e ? null : new boolean[DiskLruCache.this.h];
        }

        public void a() throws IOException {
            synchronized (DiskLruCache.this) {
                if (!this.c) {
                    if (this.a.f == this) {
                        DiskLruCache.this.d(this, false);
                    }
                    this.c = true;
                } else {
                    throw new IllegalStateException();
                }
            }
        }

        public void b() throws IOException {
            synchronized (DiskLruCache.this) {
                if (!this.c) {
                    if (this.a.f == this) {
                        DiskLruCache.this.d(this, true);
                    }
                    this.c = true;
                } else {
                    throw new IllegalStateException();
                }
            }
        }

        void c() {
            if (this.a.f != this) {
                return;
            }
            int i = 0;
            while (true) {
                DiskLruCache diskLruCache = DiskLruCache.this;
                if (i < diskLruCache.h) {
                    try {
                        diskLruCache.a.delete(this.a.d[i]);
                    } catch (IOException unused) {
                    }
                    i++;
                } else {
                    this.a.f = null;
                    return;
                }
            }
        }

        public Sink d(int i) {
            synchronized (DiskLruCache.this) {
                if (!this.c) {
                    C8757c c8757c = this.a;
                    if (c8757c.f != this) {
                        return C8844h.b();
                    }
                    if (!c8757c.e) {
                        this.b[i] = true;
                    }
                    try {
                        return new C8756a(DiskLruCache.this.a.sink(c8757c.d[i]));
                    } catch (FileNotFoundException unused) {
                        return C8844h.b();
                    }
                }
                throw new IllegalStateException();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: Taobao */
    /* renamed from: okhttp3.internal.cache.DiskLruCache$c */
    /* loaded from: classes2.dex */
    public final class C8757c {
        final String a;
        final long[] b;
        final File[] c;
        final File[] d;
        boolean e;
        C8755b f;
        long g;

        C8757c(String str) {
            this.a = str;
            int i = DiskLruCache.this.h;
            this.b = new long[i];
            this.c = new File[i];
            this.d = new File[i];
            StringBuilder sb = new StringBuilder(str);
            sb.append('.');
            int length = sb.length();
            for (int i2 = 0; i2 < DiskLruCache.this.h; i2++) {
                sb.append(i2);
                this.c[i2] = new File(DiskLruCache.this.b, sb.toString());
                sb.append(".tmp");
                this.d[i2] = new File(DiskLruCache.this.b, sb.toString());
                sb.setLength(length);
            }
        }

        private IOException a(String[] strArr) throws IOException {
            throw new IOException("unexpected journal line: " + Arrays.toString(strArr));
        }

        void b(String[] strArr) throws IOException {
            if (strArr.length == DiskLruCache.this.h) {
                for (int i = 0; i < strArr.length; i++) {
                    try {
                        this.b[i] = Long.parseLong(strArr[i]);
                    } catch (NumberFormatException unused) {
                        throw a(strArr);
                    }
                }
                return;
            }
            throw a(strArr);
        }

        C8758d c() {
            if (Thread.holdsLock(DiskLruCache.this)) {
                Source[] sourceArr = new Source[DiskLruCache.this.h];
                long[] jArr = (long[]) this.b.clone();
                int i = 0;
                int i2 = 0;
                while (true) {
                    try {
                        DiskLruCache diskLruCache = DiskLruCache.this;
                        if (i2 < diskLruCache.h) {
                            sourceArr[i2] = diskLruCache.a.source(this.c[i2]);
                            i2++;
                        } else {
                            return new C8758d(this.a, this.g, sourceArr, jArr);
                        }
                    } catch (FileNotFoundException unused) {
                        while (true) {
                            DiskLruCache diskLruCache2 = DiskLruCache.this;
                            if (i < diskLruCache2.h && sourceArr[i] != null) {
                                C8753a.g(sourceArr[i]);
                                i++;
                            } else {
                                try {
                                    diskLruCache2.r(this);
                                    return null;
                                } catch (IOException unused2) {
                                    return null;
                                }
                            }
                        }
                    }
                }
            } else {
                throw new AssertionError();
            }
        }

        void d(BufferedSink bufferedSink) throws IOException {
            for (long j : this.b) {
                bufferedSink.writeByte(32).writeDecimalLong(j);
            }
        }
    }

    /* compiled from: Taobao */
    /* renamed from: okhttp3.internal.cache.DiskLruCache$d */
    /* loaded from: classes2.dex */
    public final class C8758d implements Closeable {
        private final String a;
        private final long b;
        private final Source[] c;

        C8758d(String str, long j, Source[] sourceArr, long[] jArr) {
            this.a = str;
            this.b = j;
            this.c = sourceArr;
        }

        @Nullable
        public C8755b a() throws IOException {
            return DiskLruCache.this.h(this.a, this.b);
        }

        public Source b(int i) {
            return this.c[i];
        }

        @Override // java.io.Closeable, java.lang.AutoCloseable
        public void close() {
            for (Source source : this.c) {
                C8753a.g(source);
            }
        }
    }

    DiskLruCache(FileSystem fileSystem, File file, int i, int i2, long j, Executor executor) {
        this.a = fileSystem;
        this.b = file;
        this.f = i;
        this.c = new File(file, "journal");
        this.d = new File(file, "journal.tmp");
        this.e = new File(file, "journal.bkp");
        this.h = i2;
        this.g = j;
        this.s = executor;
    }

    private static /* synthetic */ void a(Throwable th, AutoCloseable autoCloseable) {
        if (th == null) {
            autoCloseable.close();
            return;
        }
        try {
            autoCloseable.close();
        } catch (Throwable th2) {
            th.addSuppressed(th2);
        }
    }

    private synchronized void c() {
        if (isClosed()) {
            throw new IllegalStateException("cache is closed");
        }
    }

    public static DiskLruCache e(FileSystem fileSystem, File file, int i, int i2, long j) {
        if (j > 0) {
            if (i2 > 0) {
                return new DiskLruCache(fileSystem, file, i, i2, j, new ThreadPoolExecutor(0, 1, 60L, TimeUnit.SECONDS, new LinkedBlockingQueue(), C8753a.I("OkHttp DiskLruCache", true)));
            }
            throw new IllegalArgumentException("valueCount <= 0");
        }
        throw new IllegalArgumentException("maxSize <= 0");
    }

    private BufferedSink l() throws FileNotFoundException {
        return C8844h.c(new C8754a(this.a.appendingSink(this.c)));
    }

    private void m() throws IOException {
        this.a.delete(this.d);
        Iterator<C8757c> it = this.k.values().iterator();
        while (it.hasNext()) {
            C8757c next = it.next();
            int i = 0;
            if (next.f == null) {
                while (i < this.h) {
                    this.i += next.b[i];
                    i++;
                }
            } else {
                next.f = null;
                while (i < this.h) {
                    this.a.delete(next.c[i]);
                    this.a.delete(next.d[i]);
                    i++;
                }
                it.remove();
            }
        }
    }

    private void n() throws IOException {
        BufferedSource d = C8844h.d(this.a.source(this.c));
        try {
            String readUtf8LineStrict = d.readUtf8LineStrict();
            String readUtf8LineStrict2 = d.readUtf8LineStrict();
            String readUtf8LineStrict3 = d.readUtf8LineStrict();
            String readUtf8LineStrict4 = d.readUtf8LineStrict();
            String readUtf8LineStrict5 = d.readUtf8LineStrict();
            if (!"libcore.io.DiskLruCache".equals(readUtf8LineStrict) || !"1".equals(readUtf8LineStrict2) || !Integer.toString(this.f).equals(readUtf8LineStrict3) || !Integer.toString(this.h).equals(readUtf8LineStrict4) || !"".equals(readUtf8LineStrict5)) {
                throw new IOException("unexpected journal header: [" + readUtf8LineStrict + AVFSCacheConstants.COMMA_SEP + readUtf8LineStrict2 + AVFSCacheConstants.COMMA_SEP + readUtf8LineStrict4 + AVFSCacheConstants.COMMA_SEP + readUtf8LineStrict5 + jn1.ARRAY_END_STR);
            }
            int i = 0;
            while (true) {
                try {
                    o(d.readUtf8LineStrict());
                    i++;
                } catch (EOFException unused) {
                    this.l = i - this.k.size();
                    if (!d.exhausted()) {
                        p();
                    } else {
                        this.j = l();
                    }
                    a(null, d);
                    return;
                }
            }
        } finally {
        }
    }

    private void o(String str) throws IOException {
        String substring;
        int indexOf = str.indexOf(32);
        if (indexOf != -1) {
            int i = indexOf + 1;
            int indexOf2 = str.indexOf(32, i);
            if (indexOf2 == -1) {
                substring = str.substring(i);
                if (indexOf == 6 && str.startsWith("REMOVE")) {
                    this.k.remove(substring);
                    return;
                }
            } else {
                substring = str.substring(i, indexOf2);
            }
            C8757c c8757c = this.k.get(substring);
            if (c8757c == null) {
                c8757c = new C8757c(substring);
                this.k.put(substring, c8757c);
            }
            if (indexOf2 != -1 && indexOf == 5 && str.startsWith("CLEAN")) {
                String[] split = str.substring(indexOf2 + 1).split(" ");
                c8757c.e = true;
                c8757c.f = null;
                c8757c.b(split);
                return;
            } else if (indexOf2 == -1 && indexOf == 5 && str.startsWith("DIRTY")) {
                c8757c.f = new C8755b(c8757c);
                return;
            } else if (indexOf2 == -1 && indexOf == 4 && str.startsWith("READ")) {
                return;
            } else {
                throw new IOException("unexpected journal line: " + str);
            }
        }
        throw new IOException("unexpected journal line: " + str);
    }

    private void t(String str) {
        if (u.matcher(str).matches()) {
            return;
        }
        throw new IllegalArgumentException("keys must match regex [a-z0-9_-]{1,120}: \"" + str + "\"");
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public synchronized void close() throws IOException {
        if (this.n && !this.o) {
            for (C8757c c8757c : (C8757c[]) this.k.values().toArray(new C8757c[this.k.size()])) {
                C8755b c8755b = c8757c.f;
                if (c8755b != null) {
                    c8755b.a();
                }
            }
            s();
            this.j.close();
            this.j = null;
            this.o = true;
            return;
        }
        this.o = true;
    }

    synchronized void d(C8755b c8755b, boolean z) throws IOException {
        C8757c c8757c = c8755b.a;
        if (c8757c.f == c8755b) {
            if (z && !c8757c.e) {
                for (int i = 0; i < this.h; i++) {
                    if (c8755b.b[i]) {
                        if (!this.a.exists(c8757c.d[i])) {
                            c8755b.a();
                            return;
                        }
                    } else {
                        c8755b.a();
                        throw new IllegalStateException("Newly created entry didn't create value for index " + i);
                    }
                }
            }
            for (int i2 = 0; i2 < this.h; i2++) {
                File file = c8757c.d[i2];
                if (z) {
                    if (this.a.exists(file)) {
                        File file2 = c8757c.c[i2];
                        this.a.rename(file, file2);
                        long j = c8757c.b[i2];
                        long size = this.a.size(file2);
                        c8757c.b[i2] = size;
                        this.i = (this.i - j) + size;
                    }
                } else {
                    this.a.delete(file);
                }
            }
            this.l++;
            c8757c.f = null;
            if (c8757c.e | z) {
                c8757c.e = true;
                this.j.writeUtf8("CLEAN").writeByte(32);
                this.j.writeUtf8(c8757c.a);
                c8757c.d(this.j);
                this.j.writeByte(10);
                if (z) {
                    long j2 = this.r;
                    this.r = 1 + j2;
                    c8757c.g = j2;
                }
            } else {
                this.k.remove(c8757c.a);
                this.j.writeUtf8("REMOVE").writeByte(32);
                this.j.writeUtf8(c8757c.a);
                this.j.writeByte(10);
            }
            this.j.flush();
            if (this.i > this.g || k()) {
                this.s.execute(this.t);
            }
            return;
        }
        throw new IllegalStateException();
    }

    public void f() throws IOException {
        close();
        this.a.deleteContents(this.b);
    }

    @Override // java.io.Flushable
    public synchronized void flush() throws IOException {
        if (this.n) {
            c();
            s();
            this.j.flush();
        }
    }

    @Nullable
    public C8755b g(String str) throws IOException {
        return h(str, -1L);
    }

    synchronized C8755b h(String str, long j) throws IOException {
        j();
        c();
        t(str);
        C8757c c8757c = this.k.get(str);
        if (j == -1 || (c8757c != null && c8757c.g == j)) {
            if (c8757c == null || c8757c.f == null) {
                if (!this.p && !this.q) {
                    this.j.writeUtf8("DIRTY").writeByte(32).writeUtf8(str).writeByte(10);
                    this.j.flush();
                    if (this.m) {
                        return null;
                    }
                    if (c8757c == null) {
                        c8757c = new C8757c(str);
                        this.k.put(str, c8757c);
                    }
                    C8755b c8755b = new C8755b(c8757c);
                    c8757c.f = c8755b;
                    return c8755b;
                }
                this.s.execute(this.t);
                return null;
            }
            return null;
        }
        return null;
    }

    public synchronized C8758d i(String str) throws IOException {
        j();
        c();
        t(str);
        C8757c c8757c = this.k.get(str);
        if (c8757c != null && c8757c.e) {
            C8758d c = c8757c.c();
            if (c == null) {
                return null;
            }
            this.l++;
            this.j.writeUtf8("READ").writeByte(32).writeUtf8(str).writeByte(10);
            if (k()) {
                this.s.execute(this.t);
            }
            return c;
        }
        return null;
    }

    public synchronized boolean isClosed() {
        return this.o;
    }

    public synchronized void j() throws IOException {
        if (this.n) {
            return;
        }
        if (this.a.exists(this.e)) {
            if (this.a.exists(this.c)) {
                this.a.delete(this.e);
            } else {
                this.a.rename(this.e, this.c);
            }
        }
        if (this.a.exists(this.c)) {
            try {
                n();
                m();
                this.n = true;
                return;
            } catch (IOException e) {
                ps1 j = ps1.j();
                j.q(5, "DiskLruCache " + this.b + " is corrupt: " + e.getMessage() + ", removing", e);
                f();
                this.o = false;
            }
        }
        p();
        this.n = true;
    }

    boolean k() {
        int i = this.l;
        return i >= 2000 && i >= this.k.size();
    }

    synchronized void p() throws IOException {
        BufferedSink bufferedSink = this.j;
        if (bufferedSink != null) {
            bufferedSink.close();
        }
        BufferedSink c = C8844h.c(this.a.sink(this.d));
        c.writeUtf8("libcore.io.DiskLruCache").writeByte(10);
        c.writeUtf8("1").writeByte(10);
        c.writeDecimalLong(this.f).writeByte(10);
        c.writeDecimalLong(this.h).writeByte(10);
        c.writeByte(10);
        for (C8757c c8757c : this.k.values()) {
            if (c8757c.f != null) {
                c.writeUtf8("DIRTY").writeByte(32);
                c.writeUtf8(c8757c.a);
                c.writeByte(10);
            } else {
                c.writeUtf8("CLEAN").writeByte(32);
                c.writeUtf8(c8757c.a);
                c8757c.d(c);
                c.writeByte(10);
            }
        }
        a(null, c);
        if (this.a.exists(this.c)) {
            this.a.rename(this.c, this.e);
        }
        this.a.rename(this.d, this.c);
        this.a.delete(this.e);
        this.j = l();
        this.m = false;
        this.q = false;
    }

    public synchronized boolean q(String str) throws IOException {
        j();
        c();
        t(str);
        C8757c c8757c = this.k.get(str);
        if (c8757c == null) {
            return false;
        }
        boolean r = r(c8757c);
        if (r && this.i <= this.g) {
            this.p = false;
        }
        return r;
    }

    boolean r(C8757c c8757c) throws IOException {
        C8755b c8755b = c8757c.f;
        if (c8755b != null) {
            c8755b.c();
        }
        for (int i = 0; i < this.h; i++) {
            this.a.delete(c8757c.c[i]);
            long j = this.i;
            long[] jArr = c8757c.b;
            this.i = j - jArr[i];
            jArr[i] = 0;
        }
        this.l++;
        this.j.writeUtf8("REMOVE").writeByte(32).writeUtf8(c8757c.a).writeByte(10);
        this.k.remove(c8757c.a);
        if (k()) {
            this.s.execute(this.t);
        }
        return true;
    }

    void s() throws IOException {
        while (this.i > this.g) {
            r(this.k.values().iterator().next());
        }
        this.p = false;
    }
}
