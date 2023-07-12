package com.taobao.phenix.request;

import com.taobao.pexode.mimetype.MimeType;
import java.util.Map;
import tb.jn1;
import tb.oe0;

/* compiled from: Taobao */
/* loaded from: classes11.dex */
public class ImageStatistics {
    public static final String KEY_BITMAP_DECODE = "decode";
    public static final String KEY_BITMAP_PROCESS = "bitmapProcess";
    public static final String KEY_BITMAP_SCALE = "scaleTime";
    public static final String KEY_DECODE_WAIT_SIZE = "decodeWaitSize";
    public static final String KEY_MASTER_WAIT_SIZE = "masterWaitSize";
    public static final String KEY_NETWORK_CONNECT = "connect";
    public static final String KEY_NETWORK_DOWNLOAD = "download";
    public static final String KEY_NETWORK_WAIT_SIZE = "networkWaitSize";
    public static final String KEY_READ_DISK_CACHE = "cacheLookup";
    public static final String KEY_READ_LOCAL_FILE = "localFile";
    public static final String KEY_READ_MEMORY_CACHE = "memoryLookup";
    public static final String KEY_SCHEDULE_TIME = "scheduleTime";
    public static final String KEY_TOTAL_TIME = "totalTime";
    public static final String KEY_WAIT_FOR_MAIN = "waitForMain";
    public long A;
    public boolean B;
    public boolean C;
    private final boolean a;
    private boolean b;
    private final b c;
    private FromType d;
    private MimeType e;
    private int f;
    private Map<String, String> g;
    private Map<String, Integer> h;
    private long i;
    private int j;
    private int k;
    private int l;
    private int m;
    private int n;
    private int o;
    private int p;
    public String q;
    public String r;
    public long s;
    public long t;
    public long u;
    public long v;
    public long w;
    public long x;
    public boolean y;
    public long z;

    /* compiled from: Taobao */
    /* loaded from: classes11.dex */
    public enum FromType {
        FROM_UNKNOWN(-1),
        FROM_NETWORK(0),
        FROM_MEMORY_CACHE(1),
        FROM_DISK_CACHE(2),
        FROM_LARGE_SCALE(3),
        FROM_LOCAL_FILE(4);
        
        public final int value;

        FromType(int i) {
            this.value = i;
        }
    }

    public ImageStatistics(b bVar, boolean z) {
        this.d = FromType.FROM_UNKNOWN;
        this.y = false;
        this.C = false;
        this.c = bVar;
        this.a = z;
    }

    public void A(int i) {
        this.f = i;
    }

    public void a(boolean z) {
        this.b = z;
    }

    public void b(FromType fromType) {
        this.d = fromType;
    }

    public int c() {
        return this.m;
    }

    public int d() {
        return this.n;
    }

    public Map<String, Integer> e() {
        return this.h;
    }

    public int f() {
        return this.k;
    }

    public int g() {
        return this.l;
    }

    public int h() {
        return this.j;
    }

    public Map<String, String> i() {
        return this.g;
    }

    public MimeType j() {
        if (this.e == null) {
            this.e = oe0.h(this.c.i());
        }
        return this.e;
    }

    public FromType k() {
        return this.d;
    }

    public int l() {
        return this.k;
    }

    public int m() {
        return this.l;
    }

    public long n() {
        return this.i;
    }

    public int o() {
        return this.f;
    }

    public b p() {
        return this.c;
    }

    public boolean q() {
        return this.b;
    }

    public boolean r() {
        return this.a;
    }

    public void s(boolean z) {
        if (z) {
            this.m++;
        } else {
            this.n++;
        }
    }

    public void t(boolean z) {
        if (z) {
            this.k++;
        } else {
            this.l++;
        }
    }

    public String toString() {
        return "ImageStatistics(FromType=" + this.d + ", Duplicated=" + this.b + ", Retrying=" + this.a + ", Size=" + this.f + ", Format=" + this.e + ", DetailCost=" + this.h + jn1.BRACKET_END_STR;
    }

    public void u(boolean z) {
        if (z) {
            this.o++;
        } else {
            this.p++;
        }
    }

    public void v(MimeType mimeType) {
        this.e = mimeType;
    }

    public void w(Map<String, Integer> map) {
        this.h = map;
    }

    public void x(int i) {
        this.j = i;
    }

    public void y(Map<String, String> map) {
        this.g = map;
    }

    public void z(long j) {
        this.i = j;
    }

    public ImageStatistics(b bVar) {
        this(bVar, false);
    }
}
