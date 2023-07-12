package com.taobao.power_image.request;

import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Rect;
import android.view.Surface;
import com.taobao.power_image.dispatcher.PowerImageDispatcher;
import com.taobao.power_image.loader.PowerImageResult;
import io.flutter.view.TextureRegistry;
import java.lang.ref.WeakReference;
import java.util.Map;

/* compiled from: Taobao */
/* loaded from: classes11.dex */
public class PowerImageTextureRequest extends PowerImageBaseRequest {
    public static final int MAX_RESIZE_HEIGHT = 1920;
    public static final int MAX_RESIZE_WIDTH = 1920;
    private final WeakReference<TextureRegistry> d;
    private volatile boolean e;
    private volatile TextureRegistry.SurfaceTextureEntry f;
    private volatile Surface g;
    private volatile int h;
    private volatile int i;
    private int j;
    private int k;

    /* compiled from: Taobao */
    /* renamed from: com.taobao.power_image.request.PowerImageTextureRequest$1  reason: invalid class name */
    /* loaded from: classes11.dex */
    class AnonymousClass1 implements Runnable {
        final /* synthetic */ PowerImageResult val$result;

        AnonymousClass1(PowerImageResult powerImageResult) {
        }

        @Override // java.lang.Runnable
        public void run() {
            TextureRegistry textureRegistry = (TextureRegistry) PowerImageTextureRequest.this.d.get();
            if (PowerImageTextureRequest.this.f == null && textureRegistry != null) {
                PowerImageTextureRequest.this.f = textureRegistry.createSurfaceTexture();
            }
            if (PowerImageTextureRequest.this.f != null) {
                if (PowerImageTextureRequest.this.e) {
                    PowerImageTextureRequest.this.c("PowerImageTextureRequest:onLoadResult isStopped 2");
                    return;
                }
                throw null;
            }
            PowerImageTextureRequest.this.c("PowerImageTextureRequest:onLoadResult SurfaceTextureEntry create failed");
        }
    }

    /* compiled from: Taobao */
    /* renamed from: com.taobao.power_image.request.PowerImageTextureRequest$3  reason: invalid class name */
    /* loaded from: classes11.dex */
    class AnonymousClass3 implements Runnable {
        final /* synthetic */ Bitmap val$imageBitmap;

        AnonymousClass3(Bitmap bitmap) {
            this.val$imageBitmap = bitmap;
        }

        @Override // java.lang.Runnable
        public void run() {
            if (PowerImageTextureRequest.this.f != null && !PowerImageTextureRequest.this.e && this.val$imageBitmap != null) {
                synchronized (PowerImageTextureRequest.this.f) {
                    if (PowerImageTextureRequest.this.f != null && !PowerImageTextureRequest.this.e) {
                        PowerImageTextureRequest.this.q(this.val$imageBitmap);
                        if (PowerImageTextureRequest.this.g == null) {
                            PowerImageTextureRequest.this.g = new Surface(PowerImageTextureRequest.this.f.surfaceTexture());
                        }
                        PowerImageTextureRequest.this.f.surfaceTexture().setDefaultBufferSize(PowerImageTextureRequest.this.h, PowerImageTextureRequest.this.i);
                        if (PowerImageTextureRequest.this.g != null && PowerImageTextureRequest.this.g.isValid()) {
                            try {
                                Canvas lockCanvas = PowerImageTextureRequest.this.g.lockCanvas(null);
                                lockCanvas.drawBitmap(this.val$imageBitmap, new Rect(0, 0, this.val$imageBitmap.getWidth(), this.val$imageBitmap.getHeight()), new Rect(0, 0, PowerImageTextureRequest.this.h, PowerImageTextureRequest.this.i), (Paint) null);
                                PowerImageTextureRequest.this.g.unlockCanvasAndPost(lockCanvas);
                                PowerImageTextureRequest.this.e();
                            } catch (Exception e) {
                                e.printStackTrace();
                                PowerImageTextureRequest powerImageTextureRequest = PowerImageTextureRequest.this;
                                powerImageTextureRequest.c("PowerImageTextureRequest:performDraw drawBitmap " + e.getMessage());
                            }
                        } else {
                            PowerImageTextureRequest powerImageTextureRequest2 = PowerImageTextureRequest.this;
                            StringBuilder sb = new StringBuilder();
                            sb.append("PowerImageTextureRequest:performDraw drawBitmap ");
                            sb.append(PowerImageTextureRequest.this.g == null ? "surface:null " : "");
                            sb.append((PowerImageTextureRequest.this.g == null || PowerImageTextureRequest.this.g.isValid()) ? "" : "surface invalid");
                            powerImageTextureRequest2.c(sb.toString());
                        }
                        return;
                    }
                    PowerImageTextureRequest powerImageTextureRequest3 = PowerImageTextureRequest.this;
                    StringBuilder sb2 = new StringBuilder();
                    sb2.append("PowerImageTextureRequest:performDraw synchronized");
                    sb2.append(PowerImageTextureRequest.this.f == null ? "textureEntry:null " : "");
                    sb2.append(PowerImageTextureRequest.this.e ? "stopped:true " : "");
                    powerImageTextureRequest3.c(sb2.toString());
                    return;
                }
            }
            PowerImageTextureRequest powerImageTextureRequest4 = PowerImageTextureRequest.this;
            StringBuilder sb3 = new StringBuilder();
            sb3.append("PowerImageTextureRequest:performDraw ");
            sb3.append(PowerImageTextureRequest.this.f == null ? "textureEntry:null " : "");
            sb3.append(PowerImageTextureRequest.this.e ? "stopped:true " : "");
            sb3.append(this.val$imageBitmap == null ? "imageBitmap:null " : "");
            powerImageTextureRequest4.c(sb3.toString());
        }
    }

    public PowerImageTextureRequest(Map<String, Object> map, TextureRegistry textureRegistry) {
        super(map);
        this.d = new WeakReference<>(textureRegistry);
        this.e = false;
    }

    @Override // com.taobao.power_image.request.PowerImageBaseRequest
    public Map<String, Object> b() {
        Map<String, Object> b = super.b();
        b.put("width", Integer.valueOf(this.j));
        b.put("height", Integer.valueOf(this.k));
        if (this.f != null) {
            b.put("textureId", Long.valueOf(this.f.id()));
        }
        return b;
    }

    @Override // com.taobao.power_image.request.PowerImageBaseRequest
    void d(PowerImageResult powerImageResult) {
        c("PowerImageTextureRequest:onLoadResult(PowerImageResult result) result is null");
    }

    @Override // com.taobao.power_image.request.PowerImageBaseRequest
    public boolean h() {
        this.e = true;
        this.c = "releaseSucceed";
        this.d.clear();
        PowerImageDispatcher.c().f(new Runnable() { // from class: com.taobao.power_image.request.PowerImageTextureRequest.2
            @Override // java.lang.Runnable
            public void run() {
                if (PowerImageTextureRequest.this.f != null) {
                    synchronized (PowerImageTextureRequest.this.f) {
                        try {
                            if (PowerImageTextureRequest.this.f != null) {
                                PowerImageTextureRequest.this.f.release();
                                PowerImageTextureRequest.this.f = null;
                            }
                            if (PowerImageTextureRequest.this.g != null) {
                                PowerImageTextureRequest.this.g.release();
                                PowerImageTextureRequest.this.g = null;
                            }
                        } catch (Exception unused) {
                        }
                    }
                }
            }
        }, 2000L);
        return true;
    }

    void q(Bitmap bitmap) {
        if (bitmap == null) {
            return;
        }
        int width = bitmap.getWidth();
        int height = bitmap.getHeight();
        double d = width;
        double d2 = d / 1920.0d;
        double d3 = height;
        double d4 = d3 / 1920.0d;
        if (d2 <= 1.0d && d4 <= 1.0d) {
            this.h = width;
            this.i = height;
            return;
        }
        double max = Math.max(d2, d4);
        this.h = (int) (d / max);
        this.i = (int) (d3 / max);
    }
}
