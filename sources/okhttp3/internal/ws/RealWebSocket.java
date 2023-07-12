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
import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.EventListener;
import okhttp3.OkHttpClient;
import okhttp3.Protocol;
import okhttp3.WebSocket;
import okhttp3.internal.ws.RealWebSocket;
import okhttp3.internal.ws.WebSocketReader;
import okhttp3.o;
import okhttp3.q;
import okio.BufferedSink;
import okio.BufferedSource;
import okio.ByteString;
import okio.h;
import org.apache.commons.lang3.time.DateUtils;
import tb.g13;
import tb.w31;

/* compiled from: Taobao */
/* loaded from: classes2.dex */
public final class RealWebSocket implements WebSocket, WebSocketReader.FrameCallback {
    private static final List<Protocol> x = Collections.singletonList(Protocol.HTTP_1_1);
    private final o a;
    final g13 b;
    private final Random c;
    private final long d;
    private final String e;
    private Call f;
    private final Runnable g;
    private WebSocketReader h;
    private okhttp3.internal.ws.b i;
    private ScheduledExecutorService j;
    private d k;
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
    /* loaded from: classes2.dex */
    public class a implements Callback {
        final /* synthetic */ o a;

        a(o oVar) {
            this.a = oVar;
        }

        @Override // okhttp3.Callback
        public void onFailure(Call call, IOException iOException) {
            RealWebSocket.this.e(iOException, null);
        }

        @Override // okhttp3.Callback
        public void onResponse(Call call, q qVar) {
            okhttp3.internal.connection.c f = w31.a.f(qVar);
            try {
                RealWebSocket.this.b(qVar, f);
                d i = f.i();
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
                RealWebSocket.this.e(e2, qVar);
                okhttp3.internal.a.g(qVar);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: Taobao */
    /* loaded from: classes2.dex */
    public static final class b {
        final int a;
        final ByteString b;
        final long c;

        b(int i, ByteString byteString, long j) {
            this.a = i;
            this.b = byteString;
            this.c = j;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: Taobao */
    /* loaded from: classes2.dex */
    public static final class c {
        final int a;
        final ByteString b;

        c(int i, ByteString byteString) {
            this.a = i;
            this.b = byteString;
        }
    }

    /* compiled from: Taobao */
    /* loaded from: classes2.dex */
    public static abstract class d implements Closeable {
        public final boolean a;
        public final BufferedSource b;
        public final BufferedSink c;

        public d(boolean z, BufferedSource bufferedSource, BufferedSink bufferedSink) {
            this.a = z;
            this.b = bufferedSource;
            this.c = bufferedSink;
        }
    }

    public RealWebSocket(o oVar, g13 g13Var, Random random, long j) {
        if ("GET".equals(oVar.g())) {
            this.a = oVar;
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
        throw new IllegalArgumentException("Request must be GET: " + oVar.g());
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
            this.m.add(new c(i, byteString));
            h();
            return true;
        }
        return false;
    }

    void b(q qVar, @Nullable okhttp3.internal.connection.c cVar) throws IOException {
        if (qVar.e() == 101) {
            String g = qVar.g(IRequestConst.CONNECTION);
            if ("Upgrade".equalsIgnoreCase(g)) {
                String g2 = qVar.g("Upgrade");
                if ("websocket".equalsIgnoreCase(g2)) {
                    String g3 = qVar.g("Sec-WebSocket-Accept");
                    String base64 = ByteString.encodeUtf8(this.e + WebSocketProtocol.ACCEPT_MAGIC).sha1().base64();
                    if (base64.equals(g3)) {
                        if (cVar == null) {
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
        throw new ProtocolException("Expected HTTP 101 response but was '" + qVar.e() + " " + qVar.k() + "'");
    }

    synchronized boolean c(int i, String str, long j) {
        okhttp3.internal.ws.a.c(i);
        ByteString byteString = null;
        if (str != null) {
            byteString = ByteString.encodeUtf8(str);
            if (byteString.size() > 123) {
                throw new IllegalArgumentException("reason.size() > 123: " + str);
            }
        }
        if (!this.s && !this.o) {
            this.o = true;
            this.m.add(new b(i, byteString, j));
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
        OkHttpClient b2 = okHttpClient.newBuilder().g(EventListener.NONE).j(x).b();
        o b3 = this.a.h().d("Upgrade", "websocket").d(IRequestConst.CONNECTION, "Upgrade").d("Sec-WebSocket-Key", this.e).d("Sec-WebSocket-Version", "13").b();
        Call h = w31.a.h(b2, b3);
        this.f = h;
        h.enqueue(new a(b3));
    }

    public void e(Exception exc, @Nullable q qVar) {
        synchronized (this) {
            if (this.s) {
                return;
            }
            this.s = true;
            d dVar = this.k;
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
                okhttp3.internal.a.g(dVar);
                throw th;
            }
        }
    }

    public void f(String str, d dVar) throws IOException {
        synchronized (this) {
            this.k = dVar;
            this.i = new okhttp3.internal.ws.b(dVar.a, dVar.c, this.c);
            ScheduledThreadPoolExecutor scheduledThreadPoolExecutor = new ScheduledThreadPoolExecutor(1, okhttp3.internal.a.I(str, false));
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
        this.h = new WebSocketReader(dVar.a, dVar.b, this);
    }

    boolean j() throws IOException {
        d dVar;
        Object obj;
        synchronized (this) {
            if (this.s) {
                return false;
            }
            okhttp3.internal.ws.b bVar = this.i;
            ByteString poll = this.l.poll();
            if (poll == null) {
                obj = this.m.poll();
                if (obj instanceof b) {
                    if (this.q != -1) {
                        dVar = this.k;
                        this.k = null;
                        this.j.shutdown();
                    } else {
                        this.p = this.j.schedule(new CancelRunnable(), ((b) obj).c, TimeUnit.MILLISECONDS);
                    }
                } else if (obj == null) {
                    return false;
                }
                dVar = null;
            } else {
                dVar = null;
                obj = null;
            }
            try {
                if (poll != null) {
                    bVar.f(poll);
                } else if (obj instanceof c) {
                    ByteString byteString = ((c) obj).b;
                    BufferedSink c2 = h.c(bVar.a(((c) obj).a, byteString.size()));
                    c2.write(byteString);
                    c2.close();
                    synchronized (this) {
                        this.n -= byteString.size();
                    }
                } else if (obj instanceof b) {
                    b bVar2 = (b) obj;
                    bVar.b(bVar2.a, bVar2.b);
                    if (dVar != null) {
                        throw null;
                    }
                } else {
                    throw new AssertionError();
                }
                return true;
            } finally {
                okhttp3.internal.a.g(dVar);
            }
        }
    }

    void k() {
        synchronized (this) {
            if (this.s) {
                return;
            }
            okhttp3.internal.ws.b bVar = this.i;
            int i = this.w ? this.t : -1;
            this.t++;
            this.w = true;
            if (i != -1) {
                e(new SocketTimeoutException("sent ping but didn't receive pong within " + this.d + "ms (after " + (i - 1) + " successful ping/pongs)"), null);
                return;
            }
            try {
                bVar.e(ByteString.EMPTY);
            } catch (IOException e) {
                e(e, null);
            }
        }
    }

    @Override // okhttp3.internal.ws.WebSocketReader.FrameCallback
    public void onReadClose(int i, String str) {
        d dVar;
        if (i != -1) {
            synchronized (this) {
                if (this.q == -1) {
                    this.q = i;
                    this.r = str;
                    if (this.o && this.m.isEmpty()) {
                        dVar = this.k;
                        this.k = null;
                        ScheduledFuture<?> scheduledFuture = this.p;
                        if (scheduledFuture != null) {
                            scheduledFuture.cancel(false);
                        }
                        this.j.shutdown();
                    } else {
                        dVar = null;
                    }
                } else {
                    throw new IllegalStateException("already closed");
                }
            }
            try {
                throw null;
            } catch (Throwable th) {
                okhttp3.internal.a.g(dVar);
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
    public o request() {
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
