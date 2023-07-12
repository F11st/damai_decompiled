package tb;

import com.alibaba.gaiax.studio.third.socket.websocket.request.Request;
import java.util.ArrayDeque;
import java.util.Queue;

/* compiled from: Taobao */
/* loaded from: classes6.dex */
public class b22 {
    private static Queue<nh2> a;

    static {
        new ArrayDeque(7);
        new ArrayDeque(7);
        a = new ArrayDeque(7);
        new ArrayDeque(7);
        new ArrayDeque(7);
        new ArrayDeque(7);
        new ArrayDeque(7);
    }

    public static Request<String> a() {
        nh2 poll = a.poll();
        return poll == null ? new nh2() : poll;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static void b(nh2 nh2Var) {
        a.offer(nh2Var);
    }
}
