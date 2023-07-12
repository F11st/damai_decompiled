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
import okhttp3.internal.io.FileSystem;
import okio.BufferedSink;
import okio.BufferedSource;
import okio.Sink;
import okio.Source;
import okio.h;
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
    final LinkedHashMap<String, c> k = new LinkedHashMap<>(0, 0.75f, true);
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
                    diskLruCache2.j = h.c(h.b());
                }
            }
        }
    };

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: Taobao */
    /* loaded from: classes2.dex */
    public class a extends okhttp3.internal.cache.c {
        a(Sink sink) {
            super(sink);
        }

        @Override // okhttp3.internal.cache.c
        protected void onException(IOException iOException) {
            DiskLruCache.this.m = true;
        }
    }

    /* compiled from: Taobao */
    /* loaded from: classes2.dex */
    public final class b {
        final c a;
        final boolean[] b;
        private boolean c;

        /* compiled from: Taobao */
        /* loaded from: classes2.dex */
        class a extends okhttp3.internal.cache.c {
            a(Sink sink) {
                super(sink);
            }

            @Override // okhttp3.internal.cache.c
            protected void onException(IOException iOException) {
                synchronized (DiskLruCache.this) {
                    b.this.c();
                }
            }
        }

        b(c cVar) {
            this.a = cVar;
            this.b = cVar.e ? null : new boolean[DiskLruCache.this.h];
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
                    c cVar = this.a;
                    if (cVar.f != this) {
                        return h.b();
                    }
                    if (!cVar.e) {
                        this.b[i] = true;
                    }
                    try {
                        return new a(DiskLruCache.this.a.sink(cVar.d[i]));
                    } catch (FileNotFoundException unused) {
                        return h.b();
                    }
                }
                throw new IllegalStateException();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: Taobao */
    /* loaded from: classes2.dex */
    public final class c {
        final String a;
        final long[] b;
        final File[] c;
        final File[] d;
        boolean e;
        b f;
        long g;

        c(String str) {
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

        d c() {
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
                            return new d(this.a, this.g, sourceArr, jArr);
                        }
                    } catch (FileNotFoundException unused) {
                        while (true) {
                            DiskLruCache diskLruCache2 = DiskLruCache.this;
                            if (i < diskLruCache2.h && sourceArr[i] != null) {
                                okhttp3.internal.a.g(sourceArr[i]);
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
    /* loaded from: classes2.dex */
    public final class d implements Closeable {
        private final String a;
        private final long b;
        private final Source[] c;

        d(String str, long j, Source[] sourceArr, long[] jArr) {
            this.a = str;
            this.b = j;
            this.c = sourceArr;
        }

        @Nullable
        public b a() throws IOException {
            return DiskLruCache.this.h(this.a, this.b);
        }

        public Source b(int i) {
            return this.c[i];
        }

        @Override // java.io.Closeable, java.lang.AutoCloseable
        public void close() {
            for (Source source : this.c) {
                okhttp3.internal.a.g(source);
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
                return new DiskLruCache(fileSystem, file, i, i2, j, new ThreadPoolExecutor(0, 1, 60L, TimeUnit.SECONDS, new LinkedBlockingQueue(), okhttp3.internal.a.I("OkHttp DiskLruCache", true)));
            }
            throw new IllegalArgumentException("valueCount <= 0");
        }
        throw new IllegalArgumentException("maxSize <= 0");
    }

    private BufferedSink l() throws FileNotFoundException {
        return h.c(new a(this.a.appendingSink(this.c)));
    }

    private void m() throws IOException {
        this.a.delete(this.d);
        Iterator<c> it = this.k.values().iterator();
        while (it.hasNext()) {
            c next = it.next();
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
        BufferedSource d2 = h.d(this.a.source(this.c));
        try {
            String readUtf8LineStrict = d2.readUtf8LineStrict();
            String readUtf8LineStrict2 = d2.readUtf8LineStrict();
            String readUtf8LineStrict3 = d2.readUtf8LineStrict();
            String readUtf8LineStrict4 = d2.readUtf8LineStrict();
            String readUtf8LineStrict5 = d2.readUtf8LineStrict();
            if (!"libcore.io.DiskLruCache".equals(readUtf8LineStrict) || !"1".equals(readUtf8LineStrict2) || !Integer.toString(this.f).equals(readUtf8LineStrict3) || !Integer.toString(this.h).equals(readUtf8LineStrict4) || !"".equals(readUtf8LineStrict5)) {
                throw new IOException("unexpected journal header: [" + readUtf8LineStrict + AVFSCacheConstants.COMMA_SEP + readUtf8LineStrict2 + AVFSCacheConstants.COMMA_SEP + readUtf8LineStrict4 + AVFSCacheConstants.COMMA_SEP + readUtf8LineStrict5 + jn1.ARRAY_END_STR);
            }
            int i = 0;
            while (true) {
                try {
                    o(d2.readUtf8LineStrict());
                    i++;
                } catch (EOFException unused) {
                    this.l = i - this.k.size();
                    if (!d2.exhausted()) {
                        p();
                    } else {
                        this.j = l();
                    }
                    a(null, d2);
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
            c cVar = this.k.get(substring);
            if (cVar == null) {
                cVar = new c(substring);
                this.k.put(substring, cVar);
            }
            if (indexOf2 != -1 && indexOf == 5 && str.startsWith("CLEAN")) {
                String[] split = str.substring(indexOf2 + 1).split(" ");
                cVar.e = true;
                cVar.f = null;
                cVar.b(split);
                return;
            } else if (indexOf2 == -1 && indexOf == 5 && str.startsWith("DIRTY")) {
                cVar.f = new b(cVar);
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
            for (c cVar : (c[]) this.k.values().toArray(new c[this.k.size()])) {
                b bVar = cVar.f;
                if (bVar != null) {
                    bVar.a();
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

    synchronized void d(b bVar, boolean z) throws IOException {
        c cVar = bVar.a;
        if (cVar.f == bVar) {
            if (z && !cVar.e) {
                for (int i = 0; i < this.h; i++) {
                    if (bVar.b[i]) {
                        if (!this.a.exists(cVar.d[i])) {
                            bVar.a();
                            return;
                        }
                    } else {
                        bVar.a();
                        throw new IllegalStateException("Newly created entry didn't create value for index " + i);
                    }
                }
            }
            for (int i2 = 0; i2 < this.h; i2++) {
                File file = cVar.d[i2];
                if (z) {
                    if (this.a.exists(file)) {
                        File file2 = cVar.c[i2];
                        this.a.rename(file, file2);
                        long j = cVar.b[i2];
                        long size = this.a.size(file2);
                        cVar.b[i2] = size;
                        this.i = (this.i - j) + size;
                    }
                } else {
                    this.a.delete(file);
                }
            }
            this.l++;
            cVar.f = null;
            if (cVar.e | z) {
                cVar.e = true;
                this.j.writeUtf8("CLEAN").writeByte(32);
                this.j.writeUtf8(cVar.a);
                cVar.d(this.j);
                this.j.writeByte(10);
                if (z) {
                    long j2 = this.r;
                    this.r = 1 + j2;
                    cVar.g = j2;
                }
            } else {
                this.k.remove(cVar.a);
                this.j.writeUtf8("REMOVE").writeByte(32);
                this.j.writeUtf8(cVar.a);
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
    public b g(String str) throws IOException {
        return h(str, -1L);
    }

    synchronized b h(String str, long j) throws IOException {
        j();
        c();
        t(str);
        c cVar = this.k.get(str);
        if (j == -1 || (cVar != null && cVar.g == j)) {
            if (cVar == null || cVar.f == null) {
                if (!this.p && !this.q) {
                    this.j.writeUtf8("DIRTY").writeByte(32).writeUtf8(str).writeByte(10);
                    this.j.flush();
                    if (this.m) {
                        return null;
                    }
                    if (cVar == null) {
                        cVar = new c(str);
                        this.k.put(str, cVar);
                    }
                    b bVar = new b(cVar);
                    cVar.f = bVar;
                    return bVar;
                }
                this.s.execute(this.t);
                return null;
            }
            return null;
        }
        return null;
    }

    public synchronized d i(String str) throws IOException {
        j();
        c();
        t(str);
        c cVar = this.k.get(str);
        if (cVar != null && cVar.e) {
            d c2 = cVar.c();
            if (c2 == null) {
                return null;
            }
            this.l++;
            this.j.writeUtf8("READ").writeByte(32).writeUtf8(str).writeByte(10);
            if (k()) {
                this.s.execute(this.t);
            }
            return c2;
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
        BufferedSink c2 = h.c(this.a.sink(this.d));
        c2.writeUtf8("libcore.io.DiskLruCache").writeByte(10);
        c2.writeUtf8("1").writeByte(10);
        c2.writeDecimalLong(this.f).writeByte(10);
        c2.writeDecimalLong(this.h).writeByte(10);
        c2.writeByte(10);
        for (c cVar : this.k.values()) {
            if (cVar.f != null) {
                c2.writeUtf8("DIRTY").writeByte(32);
                c2.writeUtf8(cVar.a);
                c2.writeByte(10);
            } else {
                c2.writeUtf8("CLEAN").writeByte(32);
                c2.writeUtf8(cVar.a);
                cVar.d(c2);
                c2.writeByte(10);
            }
        }
        a(null, c2);
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
        c cVar = this.k.get(str);
        if (cVar == null) {
            return false;
        }
        boolean r = r(cVar);
        if (r && this.i <= this.g) {
            this.p = false;
        }
        return r;
    }

    boolean r(c cVar) throws IOException {
        b bVar = cVar.f;
        if (bVar != null) {
            bVar.c();
        }
        for (int i = 0; i < this.h; i++) {
            this.a.delete(cVar.c[i]);
            long j = this.i;
            long[] jArr = cVar.b;
            this.i = j - jArr[i];
            jArr[i] = 0;
        }
        this.l++;
        this.j.writeUtf8("REMOVE").writeByte(32).writeUtf8(cVar.a).writeByte(10);
        this.k.remove(cVar.a);
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
