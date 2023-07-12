package okhttp3.internal.http2;

import android.taobao.windvane.connect.HttpConnector;
import android.taobao.windvane.runtimepermission.PermissionChecker;
import cn.damai.login.authlogin.req.GetAuthorizationTokenRequest;
import com.taobao.weex.adapter.URIAdapter;
import com.youku.network.HttpIntent;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import mtopsdk.common.util.HttpHeaderConstant;
import okio.Buffer;
import okio.BufferedSource;
import okio.ByteString;
import okio.Source;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: Taobao */
/* loaded from: classes2.dex */
public final class b {
    static final okhttp3.internal.http2.a[] a;
    static final Map<ByteString, Integer> b;

    /* compiled from: Taobao */
    /* loaded from: classes2.dex */
    static final class a {
        private final List<okhttp3.internal.http2.a> a;
        private final BufferedSource b;
        private final int c;
        private int d;
        okhttp3.internal.http2.a[] e;
        int f;
        int g;
        int h;

        /* JADX INFO: Access modifiers changed from: package-private */
        public a(int i, Source source) {
            this(i, i, source);
        }

        private void a() {
            int i = this.d;
            int i2 = this.h;
            if (i < i2) {
                if (i == 0) {
                    b();
                } else {
                    d(i2 - i);
                }
            }
        }

        private void b() {
            Arrays.fill(this.e, (Object) null);
            this.f = this.e.length - 1;
            this.g = 0;
            this.h = 0;
        }

        private int c(int i) {
            return this.f + 1 + i;
        }

        private int d(int i) {
            int i2;
            int i3 = 0;
            if (i > 0) {
                int length = this.e.length;
                while (true) {
                    length--;
                    i2 = this.f;
                    if (length < i2 || i <= 0) {
                        break;
                    }
                    okhttp3.internal.http2.a[] aVarArr = this.e;
                    i -= aVarArr[length].c;
                    this.h -= aVarArr[length].c;
                    this.g--;
                    i3++;
                }
                okhttp3.internal.http2.a[] aVarArr2 = this.e;
                System.arraycopy(aVarArr2, i2 + 1, aVarArr2, i2 + 1 + i3, this.g);
                this.f += i3;
            }
            return i3;
        }

        private ByteString f(int i) throws IOException {
            if (h(i)) {
                return b.a[i].a;
            }
            int c = c(i - b.a.length);
            if (c >= 0) {
                okhttp3.internal.http2.a[] aVarArr = this.e;
                if (c < aVarArr.length) {
                    return aVarArr[c].a;
                }
            }
            throw new IOException("Header index too large " + (i + 1));
        }

        private void g(int i, okhttp3.internal.http2.a aVar) {
            this.a.add(aVar);
            int i2 = aVar.c;
            if (i != -1) {
                i2 -= this.e[c(i)].c;
            }
            int i3 = this.d;
            if (i2 > i3) {
                b();
                return;
            }
            int d = d((this.h + i2) - i3);
            if (i == -1) {
                int i4 = this.g + 1;
                okhttp3.internal.http2.a[] aVarArr = this.e;
                if (i4 > aVarArr.length) {
                    okhttp3.internal.http2.a[] aVarArr2 = new okhttp3.internal.http2.a[aVarArr.length * 2];
                    System.arraycopy(aVarArr, 0, aVarArr2, aVarArr.length, aVarArr.length);
                    this.f = this.e.length - 1;
                    this.e = aVarArr2;
                }
                int i5 = this.f;
                this.f = i5 - 1;
                this.e[i5] = aVar;
                this.g++;
            } else {
                this.e[i + c(i) + d] = aVar;
            }
            this.h += i2;
        }

        private boolean h(int i) {
            return i >= 0 && i <= b.a.length - 1;
        }

        private int i() throws IOException {
            return this.b.readByte() & 255;
        }

        private void l(int i) throws IOException {
            if (h(i)) {
                this.a.add(b.a[i]);
                return;
            }
            int c = c(i - b.a.length);
            if (c >= 0) {
                okhttp3.internal.http2.a[] aVarArr = this.e;
                if (c < aVarArr.length) {
                    this.a.add(aVarArr[c]);
                    return;
                }
            }
            throw new IOException("Header index too large " + (i + 1));
        }

        private void n(int i) throws IOException {
            g(-1, new okhttp3.internal.http2.a(f(i), j()));
        }

        private void o() throws IOException {
            g(-1, new okhttp3.internal.http2.a(b.a(j()), j()));
        }

        private void p(int i) throws IOException {
            this.a.add(new okhttp3.internal.http2.a(f(i), j()));
        }

        private void q() throws IOException {
            this.a.add(new okhttp3.internal.http2.a(b.a(j()), j()));
        }

        public List<okhttp3.internal.http2.a> e() {
            ArrayList arrayList = new ArrayList(this.a);
            this.a.clear();
            return arrayList;
        }

        ByteString j() throws IOException {
            int i = i();
            boolean z = (i & 128) == 128;
            int m = m(i, 127);
            if (z) {
                return ByteString.of(g.f().c(this.b.readByteArray(m)));
            }
            return this.b.readByteString(m);
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        public void k() throws IOException {
            while (!this.b.exhausted()) {
                int readByte = this.b.readByte() & 255;
                if (readByte == 128) {
                    throw new IOException("index == 0");
                }
                if ((readByte & 128) == 128) {
                    l(m(readByte, 127) - 1);
                } else if (readByte == 64) {
                    o();
                } else if ((readByte & 64) == 64) {
                    n(m(readByte, 63) - 1);
                } else if ((readByte & 32) == 32) {
                    int m = m(readByte, 31);
                    this.d = m;
                    if (m >= 0 && m <= this.c) {
                        a();
                    } else {
                        throw new IOException("Invalid dynamic table size update " + this.d);
                    }
                } else if (readByte != 16 && readByte != 0) {
                    p(m(readByte, 15) - 1);
                } else {
                    q();
                }
            }
        }

        int m(int i, int i2) throws IOException {
            int i3 = i & i2;
            if (i3 < i2) {
                return i3;
            }
            int i4 = 0;
            while (true) {
                int i5 = i();
                if ((i5 & 128) == 0) {
                    return i2 + (i5 << i4);
                }
                i2 += (i5 & 127) << i4;
                i4 += 7;
            }
        }

        a(int i, int i2, Source source) {
            this.a = new ArrayList();
            okhttp3.internal.http2.a[] aVarArr = new okhttp3.internal.http2.a[8];
            this.e = aVarArr;
            this.f = aVarArr.length - 1;
            this.g = 0;
            this.h = 0;
            this.c = i;
            this.d = i2;
            this.b = okio.h.d(source);
        }
    }

    /* compiled from: Taobao */
    /* renamed from: okhttp3.internal.http2.b$b  reason: collision with other inner class name */
    /* loaded from: classes2.dex */
    static final class C0442b {
        private final Buffer a;
        private final boolean b;
        private int c;
        private boolean d;
        int e;
        okhttp3.internal.http2.a[] f;
        int g;
        int h;
        int i;

        /* JADX INFO: Access modifiers changed from: package-private */
        public C0442b(Buffer buffer) {
            this(4096, true, buffer);
        }

        private void a() {
            int i = this.e;
            int i2 = this.i;
            if (i < i2) {
                if (i == 0) {
                    b();
                } else {
                    c(i2 - i);
                }
            }
        }

        private void b() {
            Arrays.fill(this.f, (Object) null);
            this.g = this.f.length - 1;
            this.h = 0;
            this.i = 0;
        }

        private int c(int i) {
            int i2;
            int i3 = 0;
            if (i > 0) {
                int length = this.f.length;
                while (true) {
                    length--;
                    i2 = this.g;
                    if (length < i2 || i <= 0) {
                        break;
                    }
                    okhttp3.internal.http2.a[] aVarArr = this.f;
                    i -= aVarArr[length].c;
                    this.i -= aVarArr[length].c;
                    this.h--;
                    i3++;
                }
                okhttp3.internal.http2.a[] aVarArr2 = this.f;
                System.arraycopy(aVarArr2, i2 + 1, aVarArr2, i2 + 1 + i3, this.h);
                okhttp3.internal.http2.a[] aVarArr3 = this.f;
                int i4 = this.g;
                Arrays.fill(aVarArr3, i4 + 1, i4 + 1 + i3, (Object) null);
                this.g += i3;
            }
            return i3;
        }

        private void d(okhttp3.internal.http2.a aVar) {
            int i = aVar.c;
            int i2 = this.e;
            if (i > i2) {
                b();
                return;
            }
            c((this.i + i) - i2);
            int i3 = this.h + 1;
            okhttp3.internal.http2.a[] aVarArr = this.f;
            if (i3 > aVarArr.length) {
                okhttp3.internal.http2.a[] aVarArr2 = new okhttp3.internal.http2.a[aVarArr.length * 2];
                System.arraycopy(aVarArr, 0, aVarArr2, aVarArr.length, aVarArr.length);
                this.g = this.f.length - 1;
                this.f = aVarArr2;
            }
            int i4 = this.g;
            this.g = i4 - 1;
            this.f[i4] = aVar;
            this.h++;
            this.i += i;
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        public void e(int i) {
            int min = Math.min(i, 16384);
            int i2 = this.e;
            if (i2 == min) {
                return;
            }
            if (min < i2) {
                this.c = Math.min(this.c, min);
            }
            this.d = true;
            this.e = min;
            a();
        }

        void f(ByteString byteString) throws IOException {
            if (this.b && g.f().e(byteString) < byteString.size()) {
                Buffer buffer = new Buffer();
                g.f().d(byteString, buffer);
                ByteString readByteString = buffer.readByteString();
                h(readByteString.size(), 127, 128);
                this.a.write(readByteString);
                return;
            }
            h(byteString.size(), 127, 0);
            this.a.write(byteString);
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        public void g(List<okhttp3.internal.http2.a> list) throws IOException {
            int i;
            int i2;
            if (this.d) {
                int i3 = this.c;
                if (i3 < this.e) {
                    h(i3, 31, 32);
                }
                this.d = false;
                this.c = Integer.MAX_VALUE;
                h(this.e, 31, 32);
            }
            int size = list.size();
            for (int i4 = 0; i4 < size; i4++) {
                okhttp3.internal.http2.a aVar = list.get(i4);
                ByteString asciiLowercase = aVar.a.toAsciiLowercase();
                ByteString byteString = aVar.b;
                Integer num = b.b.get(asciiLowercase);
                if (num != null) {
                    i = num.intValue() + 1;
                    if (i > 1 && i < 8) {
                        okhttp3.internal.http2.a[] aVarArr = b.a;
                        if (Objects.equals(aVarArr[i - 1].b, byteString)) {
                            i2 = i;
                        } else if (Objects.equals(aVarArr[i].b, byteString)) {
                            i2 = i;
                            i++;
                        }
                    }
                    i2 = i;
                    i = -1;
                } else {
                    i = -1;
                    i2 = -1;
                }
                if (i == -1) {
                    int i5 = this.g + 1;
                    int length = this.f.length;
                    while (true) {
                        if (i5 >= length) {
                            break;
                        }
                        if (Objects.equals(this.f[i5].a, asciiLowercase)) {
                            if (Objects.equals(this.f[i5].b, byteString)) {
                                i = b.a.length + (i5 - this.g);
                                break;
                            } else if (i2 == -1) {
                                i2 = (i5 - this.g) + b.a.length;
                            }
                        }
                        i5++;
                    }
                }
                if (i != -1) {
                    h(i, 127, 128);
                } else if (i2 == -1) {
                    this.a.writeByte(64);
                    f(asciiLowercase);
                    f(byteString);
                    d(aVar);
                } else if (asciiLowercase.startsWith(okhttp3.internal.http2.a.PSEUDO_PREFIX) && !okhttp3.internal.http2.a.TARGET_AUTHORITY.equals(asciiLowercase)) {
                    h(i2, 15, 0);
                    f(byteString);
                } else {
                    h(i2, 63, 64);
                    f(byteString);
                    d(aVar);
                }
            }
        }

        void h(int i, int i2, int i3) {
            if (i < i2) {
                this.a.writeByte(i | i3);
                return;
            }
            this.a.writeByte(i3 | i2);
            int i4 = i - i2;
            while (i4 >= 128) {
                this.a.writeByte(128 | (i4 & 127));
                i4 >>>= 7;
            }
            this.a.writeByte(i4);
        }

        C0442b(int i, boolean z, Buffer buffer) {
            this.c = Integer.MAX_VALUE;
            okhttp3.internal.http2.a[] aVarArr = new okhttp3.internal.http2.a[8];
            this.f = aVarArr;
            this.g = aVarArr.length - 1;
            this.h = 0;
            this.i = 0;
            this.e = i;
            this.b = z;
            this.a = buffer;
        }
    }

    static {
        ByteString byteString = okhttp3.internal.http2.a.TARGET_METHOD;
        ByteString byteString2 = okhttp3.internal.http2.a.TARGET_PATH;
        ByteString byteString3 = okhttp3.internal.http2.a.TARGET_SCHEME;
        ByteString byteString4 = okhttp3.internal.http2.a.RESPONSE_STATUS;
        a = new okhttp3.internal.http2.a[]{new okhttp3.internal.http2.a(okhttp3.internal.http2.a.TARGET_AUTHORITY, ""), new okhttp3.internal.http2.a(byteString, "GET"), new okhttp3.internal.http2.a(byteString, "POST"), new okhttp3.internal.http2.a(byteString2, "/"), new okhttp3.internal.http2.a(byteString2, "/index.html"), new okhttp3.internal.http2.a(byteString3, "http"), new okhttp3.internal.http2.a(byteString3, "https"), new okhttp3.internal.http2.a(byteString4, "200"), new okhttp3.internal.http2.a(byteString4, "204"), new okhttp3.internal.http2.a(byteString4, "206"), new okhttp3.internal.http2.a(byteString4, "304"), new okhttp3.internal.http2.a(byteString4, "400"), new okhttp3.internal.http2.a(byteString4, "404"), new okhttp3.internal.http2.a(byteString4, "500"), new okhttp3.internal.http2.a("accept-charset", ""), new okhttp3.internal.http2.a("accept-encoding", "gzip, deflate"), new okhttp3.internal.http2.a("accept-language", ""), new okhttp3.internal.http2.a("accept-ranges", ""), new okhttp3.internal.http2.a("accept", ""), new okhttp3.internal.http2.a("access-control-allow-origin", ""), new okhttp3.internal.http2.a("age", ""), new okhttp3.internal.http2.a(PermissionChecker.PERMISSION_ALLOW, ""), new okhttp3.internal.http2.a(GetAuthorizationTokenRequest.ACTION_AUTHORIZATION, ""), new okhttp3.internal.http2.a("cache-control", ""), new okhttp3.internal.http2.a("content-disposition", ""), new okhttp3.internal.http2.a(HttpHeaderConstant.CONTENT_ENCODING, ""), new okhttp3.internal.http2.a("content-language", ""), new okhttp3.internal.http2.a("content-length", ""), new okhttp3.internal.http2.a("content-location", ""), new okhttp3.internal.http2.a("content-range", ""), new okhttp3.internal.http2.a("content-type", ""), new okhttp3.internal.http2.a(HttpIntent.COOKIE, ""), new okhttp3.internal.http2.a("date", ""), new okhttp3.internal.http2.a("etag", ""), new okhttp3.internal.http2.a("expect", ""), new okhttp3.internal.http2.a(HttpConnector.EXPIRES, ""), new okhttp3.internal.http2.a("from", ""), new okhttp3.internal.http2.a("host", ""), new okhttp3.internal.http2.a("if-match", ""), new okhttp3.internal.http2.a(HttpHeaderConstant.IF_MODIFIED_SINCE, ""), new okhttp3.internal.http2.a(HttpHeaderConstant.IF_NONE_MATCH, ""), new okhttp3.internal.http2.a("if-range", ""), new okhttp3.internal.http2.a("if-unmodified-since", ""), new okhttp3.internal.http2.a("last-modified", ""), new okhttp3.internal.http2.a(URIAdapter.LINK, ""), new okhttp3.internal.http2.a("location", ""), new okhttp3.internal.http2.a("max-forwards", ""), new okhttp3.internal.http2.a("proxy-authenticate", ""), new okhttp3.internal.http2.a("proxy-authorization", ""), new okhttp3.internal.http2.a("range", ""), new okhttp3.internal.http2.a("referer", ""), new okhttp3.internal.http2.a("refresh", ""), new okhttp3.internal.http2.a("retry-after", ""), new okhttp3.internal.http2.a("server", ""), new okhttp3.internal.http2.a("set-cookie", ""), new okhttp3.internal.http2.a("strict-transport-security", ""), new okhttp3.internal.http2.a("transfer-encoding", ""), new okhttp3.internal.http2.a("user-agent", ""), new okhttp3.internal.http2.a("vary", ""), new okhttp3.internal.http2.a("via", ""), new okhttp3.internal.http2.a("www-authenticate", "")};
        b = b();
    }

    static ByteString a(ByteString byteString) throws IOException {
        int size = byteString.size();
        for (int i = 0; i < size; i++) {
            byte b2 = byteString.getByte(i);
            if (b2 >= 65 && b2 <= 90) {
                throw new IOException("PROTOCOL_ERROR response malformed: mixed case name: " + byteString.utf8());
            }
        }
        return byteString;
    }

    private static Map<ByteString, Integer> b() {
        LinkedHashMap linkedHashMap = new LinkedHashMap(a.length);
        int i = 0;
        while (true) {
            okhttp3.internal.http2.a[] aVarArr = a;
            if (i < aVarArr.length) {
                if (!linkedHashMap.containsKey(aVarArr[i].a)) {
                    linkedHashMap.put(aVarArr[i].a, Integer.valueOf(i));
                }
                i++;
            } else {
                return Collections.unmodifiableMap(linkedHashMap);
            }
        }
    }
}
