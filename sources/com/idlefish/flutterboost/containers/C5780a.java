package com.idlefish.flutterboost.containers;

import android.graphics.SurfaceTexture;
import android.os.Build;
import android.view.Surface;
import android.view.TextureView;
import com.idlefish.flutterboost.FlutterBoost;
import io.flutter.embedding.android.FlutterTextureView;
import io.flutter.embedding.engine.FlutterEngine;
import java.lang.reflect.Field;
import tb.do0;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: Taobao */
/* renamed from: com.idlefish.flutterboost.containers.a */
/* loaded from: classes10.dex */
public class C5780a {
    private SurfaceTexture a;
    private FlutterTextureView b;
    private boolean c = false;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: Taobao */
    /* renamed from: com.idlefish.flutterboost.containers.a$a */
    /* loaded from: classes10.dex */
    public class TextureView$SurfaceTextureListenerC5781a implements TextureView.SurfaceTextureListener {
        final /* synthetic */ TextureView.SurfaceTextureListener a;
        final /* synthetic */ FlutterTextureView b;

        TextureView$SurfaceTextureListenerC5781a(TextureView.SurfaceTextureListener surfaceTextureListener, FlutterTextureView flutterTextureView) {
            this.a = surfaceTextureListener;
            this.b = flutterTextureView;
        }

        @Override // android.view.TextureView.SurfaceTextureListener
        public void onSurfaceTextureAvailable(SurfaceTexture surfaceTexture, int i, int i2) {
            this.a.onSurfaceTextureAvailable(surfaceTexture, i, i2);
        }

        @Override // android.view.TextureView.SurfaceTextureListener
        public boolean onSurfaceTextureDestroyed(SurfaceTexture surfaceTexture) {
            try {
                Class<?> cls = this.b.getClass();
                Field declaredField = cls.getDeclaredField("isSurfaceAvailableForRendering");
                declaredField.setAccessible(true);
                declaredField.set(this.b, Boolean.FALSE);
                cls.getDeclaredField("isAttachedToFlutterRenderer").setAccessible(true);
            } catch (Exception e) {
                e.printStackTrace();
            }
            C5780a.this.c = true;
            return false;
        }

        @Override // android.view.TextureView.SurfaceTextureListener
        public void onSurfaceTextureSizeChanged(SurfaceTexture surfaceTexture, int i, int i2) {
            this.a.onSurfaceTextureSizeChanged(surfaceTexture, i, i2);
        }

        @Override // android.view.TextureView.SurfaceTextureListener
        public void onSurfaceTextureUpdated(SurfaceTexture surfaceTexture) {
            this.a.onSurfaceTextureUpdated(surfaceTexture);
            C5780a.this.a = surfaceTexture;
        }
    }

    public void c(FlutterTextureView flutterTextureView) {
        if (Build.VERSION.SDK_INT > 23 || flutterTextureView == null) {
            return;
        }
        TextureView.SurfaceTextureListener surfaceTextureListener = flutterTextureView.getSurfaceTextureListener();
        this.b = flutterTextureView;
        flutterTextureView.setSurfaceTextureListener(new TextureView$SurfaceTextureListenerC5781a(surfaceTextureListener, flutterTextureView));
    }

    public void d() {
        if (Build.VERSION.SDK_INT <= 23) {
            if (do0.h().e() == 1) {
                FlutterBoost.h().f().getRenderer().stopRenderingToSurface();
            }
            SurfaceTexture surfaceTexture = this.a;
            if (surfaceTexture != null) {
                surfaceTexture.release();
                this.a = null;
            }
        }
    }

    public void e() {
        FlutterTextureView flutterTextureView;
        if (Build.VERSION.SDK_INT > 23 || this.a == null || (flutterTextureView = this.b) == null || !this.c) {
            return;
        }
        try {
            Class<?> cls = flutterTextureView.getClass();
            Field declaredField = cls.getDeclaredField("isSurfaceAvailableForRendering");
            declaredField.setAccessible(true);
            declaredField.set(this.b, Boolean.TRUE);
            Field declaredField2 = cls.getDeclaredField("isAttachedToFlutterRenderer");
            declaredField2.setAccessible(true);
            if (declaredField2.getBoolean(this.b)) {
                FlutterEngine f = FlutterBoost.h().f();
                if (f != null) {
                    f.getRenderer().startRenderingToSurface(new Surface(this.a));
                    this.b.setSurfaceTexture(this.a);
                }
                this.a = null;
                this.c = false;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
