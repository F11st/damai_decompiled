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
    private volatile d b;
    private final Object c;
    private int d;
    private boolean e;

    /* compiled from: Taobao */
    /* loaded from: classes10.dex */
    public interface UpdateSurfaceCallback {
        void updateSurface(int i, int i2, long j, float[] fArr);
    }

    /* compiled from: Taobao */
    /* loaded from: classes10.dex */
    class a implements UpdateSurfaceCallback {
        final /* synthetic */ long a;

        a(long j) {
            this.a = j;
        }

        @Override // com.google.vr.cardboard.ExternalSurfaceManager.UpdateSurfaceCallback
        public void updateSurface(int i, int i2, long j, float[] fArr) {
            ExternalSurfaceManager.nativeUpdateSurface(this.a, i, i2, j, fArr);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: Taobao */
    /* loaded from: classes10.dex */
    public static class b {
        private final int a;
        private final c b;
        private final float[] c;
        private volatile SurfaceTexture g;
        private volatile Surface h;
        private final AtomicBoolean d = new AtomicBoolean(false);
        private final AtomicBoolean e = new AtomicBoolean(false);
        private final int[] f = new int[1];
        private volatile boolean i = false;

        /* JADX INFO: Access modifiers changed from: package-private */
        /* compiled from: Taobao */
        /* loaded from: classes10.dex */
        public class a implements SurfaceTexture.OnFrameAvailableListener {
            a() {
            }

            @Override // android.graphics.SurfaceTexture.OnFrameAvailableListener
            public void onFrameAvailable(SurfaceTexture surfaceTexture) {
                b.this.d.set(true);
                if (b.this.b != null) {
                    b.this.b.b();
                }
            }
        }

        b(int i, c cVar) {
            float[] fArr = new float[16];
            this.c = fArr;
            this.a = i;
            this.b = cVar;
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
                this.g.setOnFrameAvailableListener(new a());
                this.h = new Surface(this.g);
            } else {
                this.g.attachToGLContext(this.f[0]);
            }
            this.i = true;
            c cVar = this.b;
            if (cVar != null) {
                cVar.c();
            }
        }

        void f() {
            if (this.i) {
                c cVar = this.b;
                if (cVar != null) {
                    cVar.a();
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
    /* loaded from: classes10.dex */
    public static class c {
        private final Runnable a;
        private final Runnable b;
        private final Handler c;

        public c(Runnable runnable, Runnable runnable2, Handler handler) {
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
        this(new a(j));
    }

    private int b(c cVar) {
        int i;
        synchronized (this.c) {
            d dVar = new d(this.b);
            i = this.d;
            this.d = i + 1;
            dVar.a.put(Integer.valueOf(i), new b(i, cVar));
            this.b = dVar;
        }
        return i;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static native void nativeUpdateSurface(long j, int i, int i2, long j2, float[] fArr);

    @UsedByNative
    public void consumerAttachToCurrentGLContext() {
        this.e = true;
        for (b bVar : this.b.a.values()) {
            bVar.e();
        }
    }

    @UsedByNative
    public void consumerDetachFromCurrentGLContext() {
        this.e = false;
        for (b bVar : this.b.a.values()) {
            bVar.f();
        }
    }

    @UsedByNative
    public void consumerUpdateManagedSurfaces() {
        d dVar = this.b;
        if (this.e) {
            for (b bVar : dVar.a.values()) {
                bVar.e();
                bVar.h(this.a);
            }
        }
        for (b bVar2 : dVar.b.values()) {
            bVar2.g(this.a);
        }
    }

    @UsedByNative
    public int createExternalSurface() {
        return b(null);
    }

    @UsedByNative
    public Surface getSurface(int i) {
        d dVar = this.b;
        if (dVar.a.containsKey(Integer.valueOf(i))) {
            return dVar.a.get(Integer.valueOf(i)).d();
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
            d dVar = new d(this.b);
            b remove = dVar.a.remove(Integer.valueOf(i));
            if (remove != null) {
                dVar.b.put(Integer.valueOf(i), remove);
                this.b = dVar;
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
            d dVar = this.b;
            this.b = new d();
            for (b bVar : dVar.a.values()) {
                bVar.g(this.a);
            }
            for (b bVar2 : dVar.b.values()) {
                bVar2.g(this.a);
            }
        }
    }

    public ExternalSurfaceManager(UpdateSurfaceCallback updateSurfaceCallback) {
        this.b = new d();
        this.c = new Object();
        this.d = 1;
        this.a = updateSurfaceCallback;
    }

    @UsedByNative
    public int createExternalSurface(Runnable runnable, Runnable runnable2, Handler handler) {
        if (runnable != null && handler != null) {
            return b(new c(runnable, runnable2, handler));
        }
        throw new IllegalArgumentException("Surface listener and handler must both be non-null for external Surface creation");
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: Taobao */
    /* loaded from: classes10.dex */
    public static class d {
        final HashMap<Integer, b> a;
        final HashMap<Integer, b> b;

        d() {
            this.a = new HashMap<>();
            this.b = new HashMap<>();
        }

        d(d dVar) {
            this.a = new HashMap<>(dVar.a);
            HashMap<Integer, b> hashMap = new HashMap<>(dVar.b);
            this.b = hashMap;
            Iterator<Map.Entry<Integer, b>> it = hashMap.entrySet().iterator();
            while (it.hasNext()) {
                if (it.next().getValue().e.get()) {
                    it.remove();
                }
            }
        }
    }
}
