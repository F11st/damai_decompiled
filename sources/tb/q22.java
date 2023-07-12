package tb;

import com.alibaba.gaiax.studio.third.socket.java_websocket.framing.Framedata;
import com.alibaba.gaiax.studio.third.socket.websocket.response.Response;
import java.nio.ByteBuffer;
import java.util.ArrayDeque;
import java.util.Queue;

/* compiled from: Taobao */
/* loaded from: classes6.dex */
public class q22 {
    private static Queue<gf0> a = new ArrayDeque(7);
    private static Queue<em2> b = new ArrayDeque(7);
    private static Queue<ke> c = new ArrayDeque(7);
    private static Queue<ns1> d = new ArrayDeque(7);
    private static Queue<bt1> e = new ArrayDeque(7);

    public static Response<ByteBuffer> a() {
        ke poll = c.poll();
        return poll == null ? new ke() : poll;
    }

    public static gf0 b() {
        gf0 poll = a.poll();
        return poll == null ? new gf0() : poll;
    }

    public static Response<Framedata> c() {
        ns1 poll = d.poll();
        return poll == null ? new ns1() : poll;
    }

    public static Response<Framedata> d() {
        bt1 poll = e.poll();
        return poll == null ? new bt1() : poll;
    }

    public static Response<String> e() {
        em2 poll = b.poll();
        return poll == null ? new em2() : poll;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static void f(ke keVar) {
        c.offer(keVar);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static void g(ns1 ns1Var) {
        d.offer(ns1Var);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static void h(bt1 bt1Var) {
        e.offer(bt1Var);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static void i(em2 em2Var) {
        b.offer(em2Var);
    }
}
