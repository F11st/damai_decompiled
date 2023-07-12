package com.google.vr.cardboard;

import android.graphics.SurfaceTexture;
import android.opengl.GLES20;
import android.opengl.Matrix;
import android.os.Handler;
import android.util.Log;
import android.view.Surface;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.concurrent.atomic.AtomicBoolean;

/* compiled from: Taobao */
@UsedByNative
/* loaded from: classes10.dex */
public class ExternalSurfaceManager {
    private static final String f = "ExternalSurfaceManager";
    private final UpdateSurfaceCallback a;
    private volatile C5424d b;
    private final Object c;
    private int d;
    private boolean e;

    /* compiled from: Taobao */
    /* loaded from: classes10.dex */
    public interface UpdateSurfaceCallback {
        void updateSurface(int i, int i2, long j, float[] fArr);
    }

    /* compiled from: Taobao */
    /* renamed from: com.google.vr.cardboard.ExternalSurfaceManager$a */
    /* loaded from: classes10.dex */
    class C5420a implements UpdateSurfaceCallback {
        final /* synthetic */ long a;

        C5420a(long j) {
            this.a = j;
        }

        @Override // com.google.vr.cardboard.ExternalSurfaceManager.UpdateSurfaceCallback
        public void updateSurface(int i, int i2, long j, float[] fArr) {
            ExternalSurfaceManager.nativeUpdateSurface(this.a, i, i2, j, fArr);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: Taobao */
    /* renamed from: com.google.vr.cardboard.ExternalSurfaceManager$b */
    /* loaded from: classes10.dex */
    public static class C5421b {
        private final int a;
        private final C5423c b;
        private final float[] c;
        private volatile SurfaceTexture g;
        private volatile Surface h;
        private final AtomicBoolean d = new AtomicBoolean(false);
        private final AtomicBoolean e = new AtomicBoolean(false);
        private final int[] f = new int[1];
        private volatile boolean i = false;

        /* JADX INFO: Access modifiers changed from: package-private */
        /* compiled from: Taobao */
        /* renamed from: com.google.vr.cardboard.ExternalSurfaceManager$b$a */
        /* loaded from: classes10.dex */
        public class C5422a implements SurfaceTexture.OnFrameAvailableListener {
            C5422a() {
            }

            @Override // android.graphics.SurfaceTexture.OnFrameAvailableListener
            public void onFrameAvailable(SurfaceTexture surfaceTexture) {
                C5421b.this.d.set(true);
                if (C5421b.this.b != null) {
                    C5421b.this.b.b();
                }
            }
        }

        C5421b(int i, C5423c c5423c) {
            float[] fArr = new float[16];
            this.c = fArr;
            this.a = i;
            this.b = c5423c;
            Matrix.setIdentityM(fArr, 0);
        }

        Surface d() {
            if (this.i) {
                return this.h;
            }
            return null;
        }

        void e() {
            if (this.i) {
                return;
            }
            GLES20.glGenTextures(1, this.f, 0);
            if (this.g == null) {
                this.g = new SurfaceTexture(this.f[0]);
                this.g.setOnFrameAvailableListener(new C5422a());
                this.h = new Surface(this.g);
            } else {
                this.g.attachToGLContext(this.f[0]);
            }
            this.i = true;
            C5423c c5423c = this.b;
            if (c5423c != null) {
                c5423c.c();
            }
        }

        void f() {
            if (this.i) {
                C5423c c5423c = this.b;
                if (c5423c != null) {
                    c5423c.a();
                }
                this.g.detachFromGLContext();
                this.i = false;
            }
        }

        void g(UpdateSurfaceCallback updateSurfaceCallback) {
            if (this.e.getAndSet(true)) {
                return;
            }
            if (this.g != null) {
                this.g.release();
                this.g = null;
                this.h = null;
            }
            updateSurfaceCallback.updateSurface(this.a, 0, 0L, this.c);
        }

        void h(UpdateSurfaceCallback updateSurfaceCallback) {
            if (this.i && this.d.getAndSet(false)) {
                this.g.updateTexImage();
                this.g.getTransformMatrix(this.c);
                updateSurfaceCallback.updateSurface(this.a, this.f[0], this.g.getTimestamp(), this.c);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: Taobao */
    /* renamed from: com.google.vr.cardboard.ExternalSurfaceManager$c */
    /* loaded from: classes10.dex */
    public static class C5423c {
        private final Runnable a;
        private final Runnable b;
        private final Handler c;

        public C5423c(Runnable runnable, Runnable runnable2, Handler handler) {
            this.a = runnable;
            this.b = runnable2;
            this.c = handler;
        }

        public void a() {
            Runnable runnable = this.a;
            if (runnable != null) {
                this.c.removeCallbacks(runnable);
            }
            Runnable runnable2 = this.b;
            if (runnable2 != null) {
                this.c.removeCallbacks(runnable2);
            }
        }

        public void b() {
            Runnable runnable = this.b;
            if (runnable != null) {
                this.c.post(runnable);
            }
        }

        public void c() {
            Runnable runnable = this.a;
            if (runnable != null) {
                this.c.post(runnable);
            }
        }
    }

    @UsedByNative
    public ExternalSurfaceManager(long j) {
        this(new C5420a(j));
    }

    private int b(C5423c c5423c) {
        int i;
        synchronized (this.c) {
            C5424d c5424d = new C5424d(this.b);
            i = this.d;
            this.d = i + 1;
            c5424d.a.put(Integer.valueOf(i), new C5421b(i, c5423c));
            this.b = c5424d;
        }
        return i;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static native void nativeUpdateSurface(long j, int i, int i2, long j2, float[] fArr);

    @UsedByNative
    public void consumerAttachToCurrentGLContext() {
        this.e = true;
        for (C5421b c5421b : this.b.a.values()) {
            c5421b.e();
        }
    }

    @UsedByNative
    public void consumerDetachFromCurrentGLContext() {
        this.e = false;
        for (C5421b c5421b : this.b.a.values()) {
            c5421b.f();
        }
    }

    @UsedByNative
    public void consumerUpdateManagedSurfaces() {
        C5424d c5424d = this.b;
        if (this.e) {
            for (C5421b c5421b : c5424d.a.values()) {
                c5421b.e();
                c5421b.h(this.a);
            }
        }
        for (C5421b c5421b2 : c5424d.b.values()) {
            c5421b2.g(this.a);
        }
    }

    @UsedByNative
    public int createExternalSurface() {
        return b(null);
    }

    @UsedByNative
    public Surface getSurface(int i) {
        C5424d c5424d = this.b;
        if (c5424d.a.containsKey(Integer.valueOf(i))) {
            return c5424d.a.get(Integer.valueOf(i)).d();
        }
        String str = f;
        StringBuilder sb = new StringBuilder(58);
        sb.append("Surface with ID ");
        sb.append(i);
        sb.append(" does not exist, returning null");
        Log.e(str, sb.toString());
        return null;
    }

    @UsedByNative
    public void releaseExternalSurface(int i) {
        synchronized (this.c) {
            C5424d c5424d = new C5424d(this.b);
            C5421b remove = c5424d.a.remove(Integer.valueOf(i));
            if (remove != null) {
                c5424d.b.put(Integer.valueOf(i), remove);
                this.b = c5424d;
            } else {
                String str = f;
                StringBuilder sb = new StringBuilder(48);
                sb.append("Not releasing nonexistent surface ID ");
                sb.append(i);
                Log.e(str, sb.toString());
            }
        }
    }

    @UsedByNative
    public void shutdown() {
        synchronized (this.c) {
            C5424d c5424d = this.b;
            this.b = new C5424d();
            for (C5421b c5421b : c5424d.a.values()) {
                c5421b.g(this.a);
            }
            for (C5421b c5421b2 : c5424d.b.values()) {
                c5421b2.g(this.a);
            }
        }
    }

    public ExternalSurfaceManager(UpdateSurfaceCallback updateSurfaceCallback) {
        this.b = new C5424d();
        this.c = new Object();
        this.d = 1;
        this.a = updateSurfaceCallback;
    }

    @UsedByNative
    public int createExternalSurface(Runnable runnable, Runnable runnable2, Handler handler) {
        if (runnable != null && handler != null) {
            return b(new C5423c(runnable, runnable2, handler));
        }
        throw new IllegalArgumentException("Surface listener and handler must both be non-null for external Surface creation");
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: Taobao */
    /* renamed from: com.google.vr.cardboard.ExternalSurfaceManager$d */
    /* loaded from: classes10.dex */
    public static class C5424d {
        final HashMap<Integer, C5421b> a;
        final HashMap<Integer, C5421b> b;

        C5424d() {
            this.a = new HashMap<>();
            this.b = new HashMap<>();
        }

        C5424d(C5424d c5424d) {
            this.a = new HashMap<>(c5424d.a);
            HashMap<Integer, C5421b> hashMap = new HashMap<>(c5424d.b);
            this.b = hashMap;
            Iterator<Map.Entry<Integer, C5421b>> it = hashMap.entrySet().iterator();
            while (it.hasNext()) {
                if (it.next().getValue().e.get()) {
                    it.remove();
                }
            }
        }
    }
}
