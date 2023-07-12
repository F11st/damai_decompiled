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
import okio.C8844h;
import okio.Source;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: Taobao */
/* renamed from: okhttp3.internal.http2.b */
/* loaded from: classes2.dex */
public final class C8790b {
    static final C8789a[] a;
    static final Map<ByteString, Integer> b;

    /* compiled from: Taobao */
    /* renamed from: okhttp3.internal.http2.b$a */
    /* loaded from: classes2.dex */
    static final class C8791a {
        private final List<C8789a> a;
        private final BufferedSource b;
        private final int c;
        private int d;
        C8789a[] e;
        int f;
        int g;
        int h;

        /* JADX INFO: Access modifiers changed from: package-private */
        public C8791a(int i, Source source) {
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
                    C8789a[] c8789aArr = this.e;
                    i -= c8789aArr[length].c;
                    this.h -= c8789aArr[length].c;
                    this.g--;
                    i3++;
                }
                C8789a[] c8789aArr2 = this.e;
                System.arraycopy(c8789aArr2, i2 + 1, c8789aArr2, i2 + 1 + i3, this.g);
                this.f += i3;
            }
            return i3;
        }

        private ByteString f(int i) throws IOException {
            if (h(i)) {
                return C8790b.a[i].a;
            }
            int c = c(i - C8790b.a.length);
            if (c >= 0) {
                C8789a[] c8789aArr = this.e;
                if (c < c8789aArr.length) {
                    return c8789aArr[c].a;
                }
            }
            throw new IOException("Header index too large " + (i + 1));
        }

        private void g(int i, C8789a c8789a) {
            this.a.add(c8789a);
            int i2 = c8789a.c;
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
                C8789a[] c8789aArr = this.e;
                if (i4 > c8789aArr.length) {
                    C8789a[] c8789aArr2 = new C8789a[c8789aArr.length * 2];
                    System.arraycopy(c8789aArr, 0, c8789aArr2, c8789aArr.length, c8789aArr.length);
                    this.f = this.e.length - 1;
                    this.e = c8789aArr2;
                }
                int i5 = this.f;
                this.f = i5 - 1;
                this.e[i5] = c8789a;
                this.g++;
            } else {
                this.e[i + c(i) + d] = c8789a;
            }
            this.h += i2;
        }

        private boolean h(int i) {
            return i >= 0 && i <= C8790b.a.length - 1;
        }

        private int i() throws IOException {
            return this.b.readByte() & 255;
        }

        private void l(int i) throws IOException {
            if (h(i)) {
                this.a.add(C8790b.a[i]);
                return;
            }
            int c = c(i - C8790b.a.length);
            if (c >= 0) {
                C8789a[] c8789aArr = this.e;
                if (c < c8789aArr.length) {
                    this.a.add(c8789aArr[c]);
                    return;
                }
            }
            throw new IOException("Header index too large " + (i + 1));
        }

        private void n(int i) throws IOException {
            g(-1, new C8789a(f(i), j()));
        }

        private void o() throws IOException {
            g(-1, new C8789a(C8790b.a(j()), j()));
        }

        private void p(int i) throws IOException {
            this.a.add(new C8789a(f(i), j()));
        }

        private void q() throws IOException {
            this.a.add(new C8789a(C8790b.a(j()), j()));
        }

        public List<C8789a> e() {
            ArrayList arrayList = new ArrayList(this.a);
            this.a.clear();
            return arrayList;
        }

        ByteString j() throws IOException {
            int i = i();
            boolean z = (i & 128) == 128;
            int m = m(i, 127);
            if (z) {
                return ByteString.of(C8800g.f().c(this.b.readByteArray(m)));
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

        C8791a(int i, int i2, Source source) {
            this.a = new ArrayList();
            C8789a[] c8789aArr = new C8789a[8];
            this.e = c8789aArr;
            this.f = c8789aArr.length - 1;
            this.g = 0;
            this.h = 0;
            this.c = i;
            this.d = i2;
            this.b = C8844h.d(source);
        }
    }

    /* compiled from: Taobao */
    /* renamed from: okhttp3.internal.http2.b$b */
    /* loaded from: classes2.dex */
    static final class C8792b {
        private final Buffer a;
        private final boolean b;
        private int c;
        private boolean d;
        int e;
        C8789a[] f;
        int g;
        int h;
        int i;

        /* JADX INFO: Access modifiers changed from: package-private */
        public C8792b(Buffer buffer) {
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
                    C8789a[] c8789aArr = this.f;
                    i -= c8789aArr[length].c;
                    this.i -= c8789aArr[length].c;
                    this.h--;
                    i3++;
                }
                C8789a[] c8789aArr2 = this.f;
                System.arraycopy(c8789aArr2, i2 + 1, c8789aArr2, i2 + 1 + i3, this.h);
                C8789a[] c8789aArr3 = this.f;
                int i4 = this.g;
                Arrays.fill(c8789aArr3, i4 + 1, i4 + 1 + i3, (Object) null);
                this.g += i3;
            }
            return i3;
        }

        private void d(C8789a c8789a) {
            int i = c8789a.c;
            int i2 = this.e;
            if (i > i2) {
                b();
                return;
            }
            c((this.i + i) - i2);
            int i3 = this.h + 1;
            C8789a[] c8789aArr = this.f;
            if (i3 > c8789aArr.length) {
                C8789a[] c8789aArr2 = new C8789a[c8789aArr.length * 2];
                System.arraycopy(c8789aArr, 0, c8789aArr2, c8789aArr.length, c8789aArr.length);
                this.g = this.f.length - 1;
                this.f = c8789aArr2;
            }
            int i4 = this.g;
            this.g = i4 - 1;
            this.f[i4] = c8789a;
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
            if (this.b && C8800g.f().e(byteString) < byteString.size()) {
                Buffer buffer = new Buffer();
                C8800g.f().d(byteString, buffer);
                ByteString readByteString = buffer.readByteString();
                h(readByteString.size(), 127, 128);
                this.a.write(readByteString);
                return;
            }
            h(byteString.size(), 127, 0);
            this.a.write(byteString);
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        public void g(List<C8789a> list) throws IOException {
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
                C8789a c8789a = list.get(i4);
                ByteString asciiLowercase = c8789a.a.toAsciiLowercase();
                ByteString byteString = c8789a.b;
                Integer num = C8790b.b.get(asciiLowercase);
                if (num != null) {
                    i = num.intValue() + 1;
                    if (i > 1 && i < 8) {
                        C8789a[] c8789aArr = C8790b.a;
                        if (Objects.equals(c8789aArr[i - 1].b, byteString)) {
                            i2 = i;
                        } else if (Objects.equals(c8789aArr[i].b, byteString)) {
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
                                i = C8790b.a.length + (i5 - this.g);
                                break;
                            } else if (i2 == -1) {
                                i2 = (i5 - this.g) + C8790b.a.length;
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
                    d(c8789a);
                } else if (asciiLowercase.startsWith(C8789a.PSEUDO_PREFIX) && !C8789a.TARGET_AUTHORITY.equals(asciiLowercase)) {
                    h(i2, 15, 0);
                    f(byteString);
                } else {
                    h(i2, 63, 64);
                    f(byteString);
                    d(c8789a);
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

        C8792b(int i, boolean z, Buffer buffer) {
            this.c = Integer.MAX_VALUE;
            C8789a[] c8789aArr = new C8789a[8];
            this.f = c8789aArr;
            this.g = c8789aArr.length - 1;
            this.h = 0;
            this.i = 0;
            this.e = i;
            this.b = z;
            this.a = buffer;
        }
    }

    static {
        ByteString byteString = C8789a.TARGET_METHOD;
        ByteString byteString2 = C8789a.TARGET_PATH;
        ByteString byteString3 = C8789a.TARGET_SCHEME;
        ByteString byteString4 = C8789a.RESPONSE_STATUS;
        a = new C8789a[]{new C8789a(C8789a.TARGET_AUTHORITY, ""), new C8789a(byteString, "GET"), new C8789a(byteString, "POST"), new C8789a(byteString2, "/"), new C8789a(byteString2, "/index.html"), new C8789a(byteString3, "http"), new C8789a(byteString3, "https"), new C8789a(byteString4, "200"), new C8789a(byteString4, "204"), new C8789a(byteString4, "206"), new C8789a(byteString4, "304"), new C8789a(byteString4, "400"), new C8789a(byteString4, "404"), new C8789a(byteString4, "500"), new C8789a("accept-charset", ""), new C8789a("accept-encoding", "gzip, deflate"), new C8789a("accept-language", ""), new C8789a("accept-ranges", ""), new C8789a("accept", ""), new C8789a("access-control-allow-origin", ""), new C8789a("age", ""), new C8789a(PermissionChecker.PERMISSION_ALLOW, ""), new C8789a(GetAuthorizationTokenRequest.ACTION_AUTHORIZATION, ""), new C8789a("cache-control", ""), new C8789a("content-disposition", ""), new C8789a(HttpHeaderConstant.CONTENT_ENCODING, ""), new C8789a("content-language", ""), new C8789a("content-length", ""), new C8789a("content-location", ""), new C8789a("content-range", ""), new C8789a("content-type", ""), new C8789a(HttpIntent.COOKIE, ""), new C8789a("date", ""), new C8789a("etag", ""), new C8789a("expect", ""), new C8789a(HttpConnector.EXPIRES, ""), new C8789a("from", ""), new C8789a("host", ""), new C8789a("if-match", ""), new C8789a(HttpHeaderConstant.IF_MODIFIED_SINCE, ""), new C8789a(HttpHeaderConstant.IF_NONE_MATCH, ""), new C8789a("if-range", ""), new C8789a("if-unmodified-since", ""), new C8789a("last-modified", ""), new C8789a(URIAdapter.LINK, ""), new C8789a("location", ""), new C8789a("max-forwards", ""), new C8789a("proxy-authenticate", ""), new C8789a("proxy-authorization", ""), new C8789a("range", ""), new C8789a("referer", ""), new C8789a("refresh", ""), new C8789a("retry-after", ""), new C8789a("server", ""), new C8789a("set-cookie", ""), new C8789a("strict-transport-security", ""), new C8789a("transfer-encoding", ""), new C8789a("user-agent", ""), new C8789a("vary", ""), new C8789a("via", ""), new C8789a("www-authenticate", "")};
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
            C8789a[] c8789aArr = a;
            if (i < c8789aArr.length) {
                if (!linkedHashMap.containsKey(c8789aArr[i].a)) {
                    linkedHashMap.put(c8789aArr[i].a, Integer.valueOf(i));
                }
                i++;
            } else {
                return Collections.unmodifiableMap(linkedHashMap);
            }
        }
    }
}
