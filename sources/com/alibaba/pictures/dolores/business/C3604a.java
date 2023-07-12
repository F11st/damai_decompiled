package com.alibaba.pictures.dolores.business;

import com.alibaba.pictures.dolores.utils.ReqMethodEnum;
import com.alibaba.pictures.dolores.utils.ReqProtocolEnum;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLConnection;
import java.util.Map;
import java.util.Objects;
import kotlin.text.C8604o;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import tb.b41;
import tb.k50;
import tb.na;
import tb.p01;
import tb.rq;

/* compiled from: Taobao */
/* renamed from: com.alibaba.pictures.dolores.business.a */
/* loaded from: classes7.dex */
public final class C3604a {
    private static transient /* synthetic */ IpChange $ipChange;
    @NotNull
    public static final C3605a Companion = new C3605a(null);
    @Nullable
    private na<?> a;
    private long b;
    private ReqMethodEnum c;
    private ReqProtocolEnum d;
    private Map<String, String> e;
    @Nullable
    private final HttpURLConnection f;

    /* compiled from: Taobao */
    /* renamed from: com.alibaba.pictures.dolores.business.a$a */
    /* loaded from: classes7.dex */
    public static final class C3605a {
        private C3605a() {
        }

        public /* synthetic */ C3605a(k50 k50Var) {
            this();
        }
    }

    public C3604a(@Nullable String str, @Nullable Long l) {
        this.b = 3000L;
        this.c = ReqMethodEnum.POST;
        this.d = ReqProtocolEnum.HTTP_SECURE;
        if (str != null) {
            str.length();
        }
        if (l != null) {
            this.b = l.longValue();
        }
    }

    private final HttpURLConnection d(String str) throws IOException {
        boolean D;
        boolean D2;
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1689248910")) {
            return (HttpURLConnection) ipChange.ipc$dispatch("-1689248910", new Object[]{this, str});
        }
        ReqProtocolEnum reqProtocolEnum = ReqProtocolEnum.HTTP_SECURE;
        D = C8604o.D(str, reqProtocolEnum.getProtocol(), true);
        if (D) {
            ReqProtocolEnum reqProtocolEnum2 = this.d;
            ReqProtocolEnum reqProtocolEnum3 = ReqProtocolEnum.HTTP;
            if (reqProtocolEnum2 == reqProtocolEnum3) {
                C8604o.A(str, reqProtocolEnum.getProtocol(), reqProtocolEnum3.getProtocol(), true);
            }
        } else {
            ReqProtocolEnum reqProtocolEnum4 = ReqProtocolEnum.HTTP;
            D2 = C8604o.D(str, reqProtocolEnum4.getProtocol(), true);
            if (D2) {
                if (this.d == reqProtocolEnum) {
                    C8604o.A(str, reqProtocolEnum4.getProtocol(), reqProtocolEnum.getProtocol(), true);
                }
            } else {
                str = this.d.getProtocol() + str;
            }
        }
        URLConnection openConnection = new URL(str).openConnection();
        Objects.requireNonNull(openConnection, "null cannot be cast to non-null type java.net.HttpURLConnection");
        HttpURLConnection httpURLConnection = (HttpURLConnection) openConnection;
        httpURLConnection.setConnectTimeout((int) this.b);
        httpURLConnection.setReadTimeout((int) this.b);
        httpURLConnection.setUseCaches(false);
        httpURLConnection.setDoInput(true);
        httpURLConnection.setRequestMethod(this.c.getMethodName());
        return httpURLConnection;
    }

    public final void a() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1457956694")) {
            ipChange.ipc$dispatch("-1457956694", new Object[]{this});
            return;
        }
        try {
            HttpURLConnection httpURLConnection = this.f;
            if (httpURLConnection != null) {
                httpURLConnection.disconnect();
            }
        } catch (Exception e) {
            rq.b("HttpUrlBusiness", e);
        }
    }

    @Nullable
    public final na<?> b() {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "1329772598") ? (na) ipChange.ipc$dispatch("1329772598", new Object[]{this}) : this.a;
    }

    public final void c(@NotNull Map<String, String> map) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "2028460204")) {
            ipChange.ipc$dispatch("2028460204", new Object[]{this, map});
            return;
        }
        b41.i(map, "extHeader");
        this.e = map;
    }

    public final void e(@NotNull ReqProtocolEnum reqProtocolEnum) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1728752927")) {
            ipChange.ipc$dispatch("1728752927", new Object[]{this, reqProtocolEnum});
            return;
        }
        b41.i(reqProtocolEnum, "protocolEnum");
        this.d = reqProtocolEnum;
    }

    @Nullable
    public final byte[] f(@NotNull InputStream inputStream) throws IOException {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "835069557")) {
            return (byte[]) ipChange.ipc$dispatch("835069557", new Object[]{this, inputStream});
        }
        b41.i(inputStream, "inputStream");
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        try {
            try {
                byte[] bArr = new byte[1024];
                while (true) {
                    int read = inputStream.read(bArr);
                    if (read != -1) {
                        byteArrayOutputStream.write(bArr, 0, read);
                    } else {
                        return byteArrayOutputStream.toByteArray();
                    }
                }
            } catch (Exception e) {
                rq.b("HttpUrlBusiness", e);
                inputStream.close();
                byteArrayOutputStream.close();
                return null;
            }
        } finally {
            inputStream.close();
            byteArrayOutputStream.close();
        }
    }

    public final void g(@NotNull ReqMethodEnum reqMethodEnum) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1624477411")) {
            ipChange.ipc$dispatch("1624477411", new Object[]{this, reqMethodEnum});
            return;
        }
        b41.i(reqMethodEnum, "methodEnum");
        this.c = reqMethodEnum;
    }

    public final void h(@Nullable na<?> naVar) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1287093136")) {
            ipChange.ipc$dispatch("1287093136", new Object[]{this, naVar});
        } else {
            this.a = naVar;
        }
    }

    @NotNull
    public final p01 i() {
        String str;
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-878842420")) {
            return (p01) ipChange.ipc$dispatch("-878842420", new Object[]{this});
        }
        p01 p01Var = new p01();
        try {
            na<?> naVar = this.a;
            if (naVar != null && (str = naVar.a) != null) {
                HttpURLConnection d = d(str);
                d.connect();
                p01Var.m(Integer.valueOf(d.getResponseCode()));
                Integer d2 = p01Var.d();
                if (d2 != null && d2.intValue() == 200) {
                    p01Var.k(Boolean.TRUE);
                    InputStream inputStream = d.getInputStream();
                    b41.h(inputStream, "inputStream");
                    byte[] f = f(inputStream);
                    if (f != null) {
                        p01Var.l(f);
                    }
                }
                p01Var.k(Boolean.FALSE);
                p01Var.l(null);
            }
        } catch (IOException e) {
            p01Var.m(-1);
            p01Var.n("请求抛出异常" + e.getMessage());
            p01Var.k(Boolean.FALSE);
        }
        return p01Var;
    }

    public C3604a() {
        this(null, null);
    }
}
