package okhttp3.internal.ws;

import com.alimm.xadsdk.request.builder.IRequestConst;
import com.squareup.okhttp.internal.ws.WebSocketProtocol;
import java.io.Closeable;
import java.io.IOException;
import java.net.ProtocolException;
import java.net.SocketTimeoutException;
import java.util.ArrayDeque;
import java.util.Collections;
import java.util.List;
import java.util.Objects;
import java.util.Random;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ScheduledFuture;
import java.util.concurrent.ScheduledThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import javax.annotation.Nullable;
import okhttp3.C8823o;
import okhttp3.C8827q;
import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.EventListener;
import okhttp3.OkHttpClient;
import okhttp3.Protocol;
import okhttp3.WebSocket;
import okhttp3.internal.C8753a;
import okhttp3.internal.connection.C8766c;
import okhttp3.internal.ws.RealWebSocket;
import okhttp3.internal.ws.WebSocketReader;
import okio.BufferedSink;
import okio.BufferedSource;
import okio.ByteString;
import okio.C8844h;
import org.apache.commons.lang3.time.DateUtils;
import tb.g13;
import tb.w31;

/* compiled from: Taobao */
/* loaded from: classes2.dex */
public final class RealWebSocket implements WebSocket, WebSocketReader.FrameCallback {
    private static final List<Protocol> x = Collections.singletonList(Protocol.HTTP_1_1);
    private final C8823o a;
    final g13 b;
    private final Random c;
    private final long d;
    private final String e;
    private Call f;
    private final Runnable g;
    private WebSocketReader h;
    private C8811b i;
    private ScheduledExecutorService j;
    private AbstractC8809d k;
    private long n;
    private boolean o;
    private ScheduledFuture<?> p;
    private String r;
    private boolean s;
    private int t;
    private int u;
    private int v;
    private boolean w;
    private final ArrayDeque<ByteString> l = new ArrayDeque<>();
    private final ArrayDeque<Object> m = new ArrayDeque<>();
    private int q = -1;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: Taobao */
    /* loaded from: classes2.dex */
    public final class CancelRunnable implements Runnable {
        CancelRunnable() {
        }

        @Override // java.lang.Runnable
        public void run() {
            RealWebSocket.this.cancel();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: Taobao */
    /* loaded from: classes2.dex */
    public final class PingRunnable implements Runnable {
        PingRunnable() {
        }

        @Override // java.lang.Runnable
        public void run() {
            RealWebSocket.this.k();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: Taobao */
    /* renamed from: okhttp3.internal.ws.RealWebSocket$a */
    /* loaded from: classes2.dex */
    public class C8806a implements Callback {
        final /* synthetic */ C8823o a;

        C8806a(C8823o c8823o) {
            this.a = c8823o;
        }

        @Override // okhttp3.Callback
        public void onFailure(Call call, IOException iOException) {
            RealWebSocket.this.e(iOException, null);
        }

        @Override // okhttp3.Callback
        public void onResponse(Call call, C8827q c8827q) {
            C8766c f = w31.a.f(c8827q);
            try {
                RealWebSocket.this.b(c8827q, f);
                AbstractC8809d i = f.i();
                try {
                    RealWebSocket.this.f("OkHttp WebSocket " + this.a.i().A(), i);
                    g13 g13Var = RealWebSocket.this.b;
                    throw null;
                } catch (Exception e) {
                    RealWebSocket.this.e(e, null);
                }
            } catch (IOException e2) {
                if (f != null) {
                    f.q();
                }
                RealWebSocket.this.e(e2, c8827q);
                C8753a.g(c8827q);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: Taobao */
    /* renamed from: okhttp3.internal.ws.RealWebSocket$b */
    /* loaded from: classes2.dex */
    public static final class C8807b {
        final int a;
        final ByteString b;
        final long c;

        C8807b(int i, ByteString byteString, long j) {
            this.a = i;
            this.b = byteString;
            this.c = j;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: Taobao */
    /* renamed from: okhttp3.internal.ws.RealWebSocket$c */
    /* loaded from: classes2.dex */
    public static final class C8808c {
        final int a;
        final ByteString b;

        C8808c(int i, ByteString byteString) {
            this.a = i;
            this.b = byteString;
        }
    }

    /* compiled from: Taobao */
    /* renamed from: okhttp3.internal.ws.RealWebSocket$d */
    /* loaded from: classes2.dex */
    public static abstract class AbstractC8809d implements Closeable {
        public final boolean a;
        public final BufferedSource b;
        public final BufferedSink c;

        public AbstractC8809d(boolean z, BufferedSource bufferedSource, BufferedSink bufferedSink) {
            this.a = z;
            this.b = bufferedSource;
            this.c = bufferedSink;
        }
    }

    public RealWebSocket(C8823o c8823o, g13 g13Var, Random random, long j) {
        if ("GET".equals(c8823o.g())) {
            this.a = c8823o;
            this.c = random;
            this.d = j;
            byte[] bArr = new byte[16];
            random.nextBytes(bArr);
            this.e = ByteString.of(bArr).base64();
            this.g = new Runnable() { // from class: tb.fz1
                @Override // java.lang.Runnable
                public final void run() {
                    RealWebSocket.this.g();
                }
            };
            return;
        }
        throw new IllegalArgumentException("Request must be GET: " + c8823o.g());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void g() {
        do {
            try {
            } catch (IOException e) {
                e(e, null);
                return;
            }
        } while (j());
    }

    private void h() {
        ScheduledExecutorService scheduledExecutorService = this.j;
        if (scheduledExecutorService != null) {
            scheduledExecutorService.execute(this.g);
        }
    }

    private synchronized boolean i(ByteString byteString, int i) {
        if (!this.s && !this.o) {
            if (this.n + byteString.size() > 16777216) {
                close(1001, null);
                return false;
            }
            this.n += byteString.size();
            this.m.add(new C8808c(i, byteString));
            h();
            return true;
        }
        return false;
    }

    void b(C8827q c8827q, @Nullable C8766c c8766c) throws IOException {
        if (c8827q.e() == 101) {
            String g = c8827q.g(IRequestConst.CONNECTION);
            if ("Upgrade".equalsIgnoreCase(g)) {
                String g2 = c8827q.g("Upgrade");
                if ("websocket".equalsIgnoreCase(g2)) {
                    String g3 = c8827q.g("Sec-WebSocket-Accept");
                    String base64 = ByteString.encodeUtf8(this.e + WebSocketProtocol.ACCEPT_MAGIC).sha1().base64();
                    if (base64.equals(g3)) {
                        if (c8766c == null) {
                            throw new ProtocolException("Web Socket exchange missing: bad interceptor?");
                        }
                        return;
                    }
                    throw new ProtocolException("Expected 'Sec-WebSocket-Accept' header value '" + base64 + "' but was '" + g3 + "'");
                }
                throw new ProtocolException("Expected 'Upgrade' header value 'websocket' but was '" + g2 + "'");
            }
            throw new ProtocolException("Expected 'Connection' header value 'Upgrade' but was '" + g + "'");
        }
        throw new ProtocolException("Expected HTTP 101 response but was '" + c8827q.e() + " " + c8827q.k() + "'");
    }

    synchronized boolean c(int i, String str, long j) {
        C8810a.c(i);
        ByteString byteString = null;
        if (str != null) {
            byteString = ByteString.encodeUtf8(str);
            if (byteString.size() > 123) {
                throw new IllegalArgumentException("reason.size() > 123: " + str);
            }
        }
        if (!this.s && !this.o) {
            this.o = true;
            this.m.add(new C8807b(i, byteString, j));
            h();
            return true;
        }
        return false;
    }

    @Override // okhttp3.WebSocket
    public void cancel() {
        this.f.cancel();
    }

    @Override // okhttp3.WebSocket
    public boolean close(int i, String str) {
        return c(i, str, DateUtils.MILLIS_PER_MINUTE);
    }

    public void d(OkHttpClient okHttpClient) {
        OkHttpClient b = okHttpClient.newBuilder().g(EventListener.NONE).j(x).b();
        C8823o b2 = this.a.h().d("Upgrade", "websocket").d(IRequestConst.CONNECTION, "Upgrade").d("Sec-WebSocket-Key", this.e).d("Sec-WebSocket-Version", "13").b();
        Call h = w31.a.h(b, b2);
        this.f = h;
        h.enqueue(new C8806a(b2));
    }

    public void e(Exception exc, @Nullable C8827q c8827q) {
        synchronized (this) {
            if (this.s) {
                return;
            }
            this.s = true;
            AbstractC8809d abstractC8809d = this.k;
            this.k = null;
            ScheduledFuture<?> scheduledFuture = this.p;
            if (scheduledFuture != null) {
                scheduledFuture.cancel(false);
            }
            ScheduledExecutorService scheduledExecutorService = this.j;
            if (scheduledExecutorService != null) {
                scheduledExecutorService.shutdown();
            }
            try {
                throw null;
            } catch (Throwable th) {
                C8753a.g(abstractC8809d);
                throw th;
            }
        }
    }

    public void f(String str, AbstractC8809d abstractC8809d) throws IOException {
        synchronized (this) {
            this.k = abstractC8809d;
            this.i = new C8811b(abstractC8809d.a, abstractC8809d.c, this.c);
            ScheduledThreadPoolExecutor scheduledThreadPoolExecutor = new ScheduledThreadPoolExecutor(1, C8753a.I(str, false));
            this.j = scheduledThreadPoolExecutor;
            if (this.d != 0) {
                PingRunnable pingRunnable = new PingRunnable();
                long j = this.d;
                scheduledThreadPoolExecutor.scheduleAtFixedRate(pingRunnable, j, j, TimeUnit.MILLISECONDS);
            }
            if (!this.m.isEmpty()) {
                h();
            }
        }
        this.h = new WebSocketReader(abstractC8809d.a, abstractC8809d.b, this);
    }

    boolean j() throws IOException {
        AbstractC8809d abstractC8809d;
        Object obj;
        synchronized (this) {
            if (this.s) {
                return false;
            }
            C8811b c8811b = this.i;
            ByteString poll = this.l.poll();
            if (poll == null) {
                obj = this.m.poll();
                if (obj instanceof C8807b) {
                    if (this.q != -1) {
                        abstractC8809d = this.k;
                        this.k = null;
                        this.j.shutdown();
                    } else {
                        this.p = this.j.schedule(new CancelRunnable(), ((C8807b) obj).c, TimeUnit.MILLISECONDS);
                    }
                } else if (obj == null) {
                    return false;
                }
                abstractC8809d = null;
            } else {
                abstractC8809d = null;
                obj = null;
            }
            try {
                if (poll != null) {
                    c8811b.f(poll);
                } else if (obj instanceof C8808c) {
                    ByteString byteString = ((C8808c) obj).b;
                    BufferedSink c = C8844h.c(c8811b.a(((C8808c) obj).a, byteString.size()));
                    c.write(byteString);
                    c.close();
                    synchronized (this) {
                        this.n -= byteString.size();
                    }
                } else if (obj instanceof C8807b) {
                    C8807b c8807b = (C8807b) obj;
                    c8811b.b(c8807b.a, c8807b.b);
                    if (abstractC8809d != null) {
                        throw null;
                    }
                } else {
                    throw new AssertionError();
                }
                return true;
            } finally {
                C8753a.g(abstractC8809d);
            }
        }
    }

    void k() {
        synchronized (this) {
            if (this.s) {
                return;
            }
            C8811b c8811b = this.i;
            int i = this.w ? this.t : -1;
            this.t++;
            this.w = true;
            if (i != -1) {
                e(new SocketTimeoutException("sent ping but didn't receive pong within " + this.d + "ms (after " + (i - 1) + " successful ping/pongs)"), null);
                return;
            }
            try {
                c8811b.e(ByteString.EMPTY);
            } catch (IOException e) {
                e(e, null);
            }
        }
    }

    @Override // okhttp3.internal.ws.WebSocketReader.FrameCallback
    public void onReadClose(int i, String str) {
        AbstractC8809d abstractC8809d;
        if (i != -1) {
            synchronized (this) {
                if (this.q == -1) {
                    this.q = i;
                    this.r = str;
                    if (this.o && this.m.isEmpty()) {
                        abstractC8809d = this.k;
                        this.k = null;
                        ScheduledFuture<?> scheduledFuture = this.p;
                        if (scheduledFuture != null) {
                            scheduledFuture.cancel(false);
                        }
                        this.j.shutdown();
                    } else {
                        abstractC8809d = null;
                    }
                } else {
                    throw new IllegalStateException("already closed");
                }
            }
            try {
                throw null;
            } catch (Throwable th) {
                C8753a.g(abstractC8809d);
                throw th;
            }
        }
        throw new IllegalArgumentException();
    }

    @Override // okhttp3.internal.ws.WebSocketReader.FrameCallback
    public void onReadMessage(String str) throws IOException {
        throw null;
    }

    @Override // okhttp3.internal.ws.WebSocketReader.FrameCallback
    public synchronized void onReadPing(ByteString byteString) {
        if (!this.s && (!this.o || !this.m.isEmpty())) {
            this.l.add(byteString);
            h();
            this.u++;
        }
    }

    @Override // okhttp3.internal.ws.WebSocketReader.FrameCallback
    public synchronized void onReadPong(ByteString byteString) {
        this.v++;
        this.w = false;
    }

    @Override // okhttp3.WebSocket
    public synchronized long queueSize() {
        return this.n;
    }

    @Override // okhttp3.WebSocket
    public C8823o request() {
        return this.a;
    }

    @Override // okhttp3.WebSocket
    public boolean send(String str) {
        Objects.requireNonNull(str, "text == null");
        return i(ByteString.encodeUtf8(str), 1);
    }

    @Override // okhttp3.internal.ws.WebSocketReader.FrameCallback
    public void onReadMessage(ByteString byteString) throws IOException {
        throw null;
    }

    @Override // okhttp3.WebSocket
    public boolean send(ByteString byteString) {
        Objects.requireNonNull(byteString, "bytes == null");
        return i(byteString, 2);
    }
}
