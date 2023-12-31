package com.youku.opengl.widget;

import android.opengl.GLES20;
import java.util.concurrent.LinkedBlockingQueue;

/* compiled from: Taobao */
/* loaded from: classes13.dex */
public class j {
    private final LinkedBlockingQueue<b> a;
    private final LinkedBlockingQueue<b> b;
    private int c = -1;
    private b d;
    private a e;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: Taobao */
    /* loaded from: classes13.dex */
    public interface a {
        void a(long j);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: Taobao */
    /* loaded from: classes13.dex */
    public static class b {
        int a;
        long b;

        b() {
        }
    }

    public j(int i) {
        int i2 = i + 3;
        this.a = new LinkedBlockingQueue<>(i2);
        this.b = new LinkedBlockingQueue<>(i2);
    }

    private void a(int i) {
        GLES20.glActiveTexture(33984);
        GLES20.glDeleteTextures(1, new int[]{i}, 0);
    }

    /* JADX WARN: Removed duplicated region for block: B:17:0x0026  */
    /* JADX WARN: Removed duplicated region for block: B:29:? A[RETURN, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private void g() {
        /*
            r5 = this;
            r0 = 0
            java.util.concurrent.LinkedBlockingQueue<com.youku.opengl.widget.j$b> r1 = r5.a     // Catch: java.lang.InterruptedException -> L1f
            java.lang.Object r1 = r1.peek()     // Catch: java.lang.InterruptedException -> L1f
            if (r1 == 0) goto L1d
            java.util.concurrent.LinkedBlockingQueue<com.youku.opengl.widget.j$b> r1 = r5.a     // Catch: java.lang.InterruptedException -> L1f
            java.lang.Object r1 = r1.take()     // Catch: java.lang.InterruptedException -> L1f
            com.youku.opengl.widget.j$b r1 = (com.youku.opengl.widget.j.b) r1     // Catch: java.lang.InterruptedException -> L1f
            com.youku.opengl.widget.j$a r2 = r5.e     // Catch: java.lang.InterruptedException -> L1b
            if (r2 == 0) goto L24
            long r3 = r1.b     // Catch: java.lang.InterruptedException -> L1b
            r2.a(r3)     // Catch: java.lang.InterruptedException -> L1b
            goto L24
        L1b:
            r2 = move-exception
            goto L21
        L1d:
            r1 = r0
            goto L24
        L1f:
            r2 = move-exception
            r1 = r0
        L21:
            r2.printStackTrace()
        L24:
            if (r1 == 0) goto L36
            com.youku.opengl.widget.j$b r2 = r5.d
            if (r2 == 0) goto L34
            int r3 = r2.a
            r4 = -1
            if (r3 == r4) goto L32
            r5.b(r2)
        L32:
            r5.d = r0
        L34:
            r5.d = r1
        L36:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.youku.opengl.widget.j.g():void");
    }

    private void h() {
        com.youku.opengl.a.a.a("YkGLVideoFrameQueue", "clearFrameQueue");
        if (this.a.size() > 0) {
            while (true) {
                b poll = this.a.poll();
                if (poll == null) {
                    break;
                }
                a(poll.a);
            }
        }
        if (this.b.size() <= 0) {
            return;
        }
        while (true) {
            b poll2 = this.b.poll();
            if (poll2 == null) {
                return;
            }
            a(poll2.a);
        }
    }

    private void i() {
        if (this.c == -1) {
            int[] iArr = {0};
            GLES20.glGenFramebuffers(1, iArr, 0);
            this.c = iArr[0];
        }
    }

    private void j() {
        com.youku.opengl.a.a.a("YkGLVideoFrameQueue", "releaseFrameBuffer");
        int i = this.c;
        if (i != -1) {
            GLES20.glDeleteFramebuffers(1, new int[]{i}, 0);
            this.c = -1;
        }
    }

    public b a(long j) {
        if (this.d == null) {
            g();
        }
        b bVar = this.d;
        if (bVar == null || Math.abs(bVar.b - j) >= 5) {
            while (true) {
                b peek = this.a.peek();
                if (peek == null) {
                    break;
                } else if (Math.abs(peek.b - j) < 5) {
                    g();
                    break;
                } else if (peek.b > j) {
                    break;
                } else {
                    g();
                }
            }
            return this.d;
        }
        return this.d;
    }

    public void a() {
        i();
    }

    public void a(a aVar) {
        this.e = aVar;
    }

    public void a(b bVar) {
        if (bVar == null) {
            return;
        }
        try {
            this.a.put(bVar);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public void b() {
        com.youku.opengl.a.a.a("YkGLVideoFrameQueue", "onDestroy begin");
        h();
        j();
        com.youku.opengl.a.a.a("YkGLVideoFrameQueue", "onDestroy end");
    }

    public void b(b bVar) {
        if (bVar == null) {
            return;
        }
        try {
            this.b.put(bVar);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public int c() {
        return this.c;
    }

    public int d() {
        return this.a.size();
    }

    /* JADX WARN: Removed duplicated region for block: B:10:0x0018  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public com.youku.opengl.widget.j.b e() {
        /*
            r3 = this;
            java.util.concurrent.LinkedBlockingQueue<com.youku.opengl.widget.j$b> r0 = r3.b
            java.lang.Object r0 = r0.peek()
            if (r0 == 0) goto L15
            java.util.concurrent.LinkedBlockingQueue<com.youku.opengl.widget.j$b> r0 = r3.b     // Catch: java.lang.InterruptedException -> L11
            java.lang.Object r0 = r0.take()     // Catch: java.lang.InterruptedException -> L11
            com.youku.opengl.widget.j$b r0 = (com.youku.opengl.widget.j.b) r0     // Catch: java.lang.InterruptedException -> L11
            goto L16
        L11:
            r0 = move-exception
            r0.printStackTrace()
        L15:
            r0 = 0
        L16:
            if (r0 != 0) goto L25
            com.youku.opengl.widget.j$b r0 = new com.youku.opengl.widget.j$b
            r0.<init>()
            r1 = 3553(0xde1, float:4.979E-42)
            int r1 = com.youku.opengl.a.e.a(r1)
            r0.a = r1
        L25:
            r1 = -1
            r0.b = r1
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.youku.opengl.widget.j.e():com.youku.opengl.widget.j$b");
    }

    public b f() {
        return this.d;
    }
}
