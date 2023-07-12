package com.amap.api.mapcore.util;

import android.graphics.Bitmap;
import android.opengl.GLES20;
import android.opengl.Matrix;
import android.os.Build;
import android.os.RemoteException;
import com.amap.api.maps.model.BitmapDescriptor;
import com.amap.api.maps.model.particle.ColorGenerate;
import com.amap.api.maps.model.particle.ParticleEmissionModule;
import com.amap.api.maps.model.particle.ParticleOverLifeModule;
import com.amap.api.maps.model.particle.ParticleOverlayOptions;
import com.amap.api.maps.model.particle.ParticleShapeModule;
import com.amap.api.maps.model.particle.VelocityGenerate;
import com.autonavi.amap.api.mapcore.overlays.IParticleLatyer;
import com.autonavi.amap.mapcore.interfaces.IOverlay;
import com.autonavi.base.amap.api.mapcore.overlays.IOverlayDelegate;
import com.autonavi.base.amap.mapcore.AMapNativeParticleSystem;
import com.autonavi.base.amap.mapcore.MapConfig;
import java.util.ArrayList;
import java.util.List;

/* compiled from: Taobao */
/* loaded from: classes10.dex */
public class cx implements IParticleLatyer, IOverlayDelegate {
    private de e;
    private r f;
    private String i;
    private BitmapDescriptor j;
    private long d = 0;
    private boolean g = true;
    private float h = 1.0f;
    private boolean k = false;
    private List<x> l = new ArrayList();
    private int m = 0;
    private ParticleOverlayOptions n = new ParticleOverlayOptions();
    private boolean o = false;
    float a = 1.0f;
    int b = 0;
    int c = 0;
    private float p = -1.0f;
    private float q = -1.0f;
    private float[] r = new float[16];
    private float[] s = new float[16];
    private float[] t = new float[16];

    public cx(r rVar) {
        this.f = rVar;
        try {
            this.i = getId();
        } catch (RemoteException e) {
            hd.c(e, "ParticleLayerDelegateImp", "create");
            e.printStackTrace();
        }
    }

    private void b() {
        r rVar;
        List<x> list = this.l;
        if (list != null) {
            for (x xVar : list) {
                if (xVar != null && (rVar = this.f) != null) {
                    rVar.a(xVar);
                }
            }
            this.l.clear();
        }
    }

    private int c() {
        int[] iArr = {0};
        GLES20.glGenTextures(1, iArr, 0);
        return iArr[0];
    }

    private void d() {
        if (this.d != 0) {
            setMaxParticles(this.n.getMaxParticles());
            setDuration(this.n.getDuration());
            setLoop(this.n.isLoop());
            setPreWram(true);
            setParticleLifeTime(this.n.getParticleLifeTime());
            setParticleStartSpeed(this.n.getParticleStartSpeed());
            if (this.n.getParticleEmissionModule() != null) {
                setParticleEmission(this.n.getParticleEmissionModule());
            }
            if (this.n.getParticleShapeModule() != null) {
                setParticleShapeModule(this.n.getParticleShapeModule());
            }
            if (this.n.getParticleStartColor() != null) {
                setStartColor(this.n.getParticleStartColor());
            }
            if (this.n.getParticleOverLifeModule() != null) {
                setParticleOverLifeModule(this.n.getParticleOverLifeModule());
            }
            setStartParticleSize(this.n.getStartParticleW(), this.n.getstartParticleH());
        }
    }

    public void a(ParticleOverlayOptions particleOverlayOptions) {
        synchronized (this) {
            if (particleOverlayOptions != null) {
                setCustomTexture(particleOverlayOptions.getIcon());
                this.n.setMaxParticles(particleOverlayOptions.getMaxParticles());
                this.n.setLoop(particleOverlayOptions.isLoop());
                this.n.setDuration(particleOverlayOptions.getDuration());
                this.n.setParticleLifeTime(particleOverlayOptions.getParticleLifeTime());
                this.n.setParticleEmissionModule(particleOverlayOptions.getParticleEmissionModule());
                this.n.setParticleShapeModule(particleOverlayOptions.getParticleShapeModule());
                this.n.setParticleStartSpeed(particleOverlayOptions.getParticleStartSpeed());
                this.n.setParticleStartColor(particleOverlayOptions.getParticleStartColor());
                this.n.setParticleOverLifeModule(particleOverlayOptions.getParticleOverLifeModule());
                this.n.setStartParticleSize(particleOverlayOptions.getStartParticleW(), particleOverlayOptions.getstartParticleH());
                this.n.zIndex(particleOverlayOptions.getZIndex());
                this.h = this.n.getZIndex();
                this.n.setVisible(particleOverlayOptions.isVisibile());
                this.g = this.n.isVisibile();
                this.o = true;
            }
        }
    }

    @Override // com.autonavi.base.amap.api.mapcore.overlays.IOverlayDelegate
    public boolean calMapFPoint() throws RemoteException {
        return false;
    }

    @Override // com.autonavi.base.amap.api.mapcore.overlays.IOverlayDelegate
    public boolean checkInBounds() {
        return true;
    }

    @Override // com.autonavi.amap.api.mapcore.overlays.IParticleLatyer, com.autonavi.amap.mapcore.interfaces.IOverlay
    public void destroy() {
        Bitmap bitmap;
        List<x> list = this.l;
        if (list != null && list.size() > 0) {
            for (int i = 0; i < this.l.size(); i++) {
                x xVar = this.l.get(i);
                if (xVar != null) {
                    r rVar = this.f;
                    if (rVar != null) {
                        rVar.a(xVar);
                    }
                    if (this.f.g() != null) {
                        this.f.g().removeTextureItem(xVar.p());
                    }
                }
            }
            this.l.clear();
        }
        BitmapDescriptor bitmapDescriptor = this.j;
        if (bitmapDescriptor != null && (bitmap = bitmapDescriptor.getBitmap()) != null) {
            eq.b(bitmap);
            this.j = null;
        }
        long j = this.d;
        if (j != 0) {
            AMapNativeParticleSystem.nativeDestroy(j);
        }
    }

    @Override // com.autonavi.base.amap.api.mapcore.overlays.IOverlayDelegate
    public void draw(MapConfig mapConfig) throws RemoteException {
        float f;
        float f2;
        de deVar;
        if (this.e == null) {
            this.e = this.f.b();
        }
        if (this.e == null) {
            return;
        }
        if (this.d == 0) {
            long nativeCreate = AMapNativeParticleSystem.nativeCreate();
            this.d = nativeCreate;
            if (nativeCreate != 0 && (deVar = this.e) != null) {
                AMapNativeParticleSystem.nativeSetGLShaderManager(nativeCreate, deVar.a());
            }
        }
        if (this.d != 0) {
            synchronized (this) {
                if (this.o) {
                    d();
                    this.o = false;
                }
            }
            int a = a();
            this.m = a;
            if (a == 0) {
                return;
            }
            AMapNativeParticleSystem.nativeSetTextureId(this.d, a);
            r rVar = this.f;
            if (rVar != null) {
                rVar.a(false);
            }
            if (this.b != mapConfig.getMapWidth() || this.c != mapConfig.getMapHeight()) {
                this.b = mapConfig.getMapWidth();
                int mapHeight = mapConfig.getMapHeight();
                this.c = mapHeight;
                int i = this.b;
                if (i > mapHeight) {
                    f = i;
                    f2 = mapHeight;
                } else {
                    f = mapHeight;
                    f2 = i;
                }
                float f3 = f / f2;
                this.a = f3;
                if (i > mapHeight) {
                    this.p = -f3;
                    this.q = 1.0f;
                } else {
                    this.p = -1.0f;
                    this.q = f3;
                }
                float[] fArr = this.r;
                float f4 = this.p;
                float f5 = this.q;
                Matrix.orthoM(fArr, 0, f4, -f4, -f5, f5, 3.0f, 7.0f);
                Matrix.setLookAtM(this.s, 0, 0.0f, 0.0f, 3.0f, 0.0f, 0.0f, 0.0f, 0.0f, 1.0f, 0.0f);
            }
            Matrix.multiplyMM(this.t, 0, this.r, 0, this.s, 0);
            Matrix.translateM(this.t, 0, this.p, this.q, 0.0f);
            Matrix.scaleM(this.t, 0, Math.abs(this.p * 2.0f) / this.b, Math.abs(this.q * 2.0f) / this.c, 0.0f);
            AMapNativeParticleSystem.nativeRender(this.d, (float[]) this.t.clone(), mapConfig.getProjectionMatrix(), (int) mapConfig.getSX(), (int) mapConfig.getSY(), mapConfig.getSZ(), this.b, this.c);
        }
    }

    @Override // com.autonavi.amap.mapcore.interfaces.IOverlay
    public boolean equalsRemote(IOverlay iOverlay) throws RemoteException {
        return false;
    }

    @Override // com.autonavi.amap.api.mapcore.overlays.IParticleLatyer
    public int getCurrentParticleNum() {
        long j = this.d;
        if (j != 0) {
            return AMapNativeParticleSystem.getCurrentParticleNum(j);
        }
        return 0;
    }

    @Override // com.autonavi.amap.mapcore.interfaces.IOverlay
    public String getId() throws RemoteException {
        if (this.i == null) {
            this.i = this.f.a("Particle");
        }
        return this.i;
    }

    @Override // com.autonavi.amap.mapcore.interfaces.IOverlay
    public float getZIndex() throws RemoteException {
        return this.h;
    }

    @Override // com.autonavi.amap.mapcore.interfaces.IOverlay
    public int hashCodeRemote() throws RemoteException {
        return 0;
    }

    @Override // com.autonavi.amap.mapcore.interfaces.IOverlay
    public boolean isAboveMaskLayer() {
        return false;
    }

    @Override // com.autonavi.base.amap.api.mapcore.overlays.IOverlayDelegate
    public boolean isDrawFinish() {
        return false;
    }

    @Override // com.autonavi.amap.mapcore.interfaces.IOverlay
    public boolean isVisible() throws RemoteException {
        return this.g;
    }

    @Override // com.autonavi.amap.api.mapcore.overlays.IParticleLatyer
    public void pause() {
    }

    @Override // com.autonavi.amap.mapcore.interfaces.IOverlay
    public void remove() throws RemoteException {
    }

    @Override // com.autonavi.amap.mapcore.interfaces.IOverlay
    public void setAboveMaskLayer(boolean z) {
    }

    @Override // com.autonavi.amap.api.mapcore.overlays.IParticleLatyer
    public void setCustomTexture(BitmapDescriptor bitmapDescriptor) {
        if (bitmapDescriptor == null) {
            return;
        }
        synchronized (this) {
            if (bitmapDescriptor.equals(this.j)) {
                return;
            }
            this.k = false;
            this.j = bitmapDescriptor;
        }
    }

    @Override // com.autonavi.amap.api.mapcore.overlays.IParticleLatyer
    public void setDuration(long j) {
        ParticleOverlayOptions particleOverlayOptions = this.n;
        if (particleOverlayOptions != null) {
            particleOverlayOptions.setDuration(j);
        }
        long j2 = this.d;
        if (j2 != 0) {
            AMapNativeParticleSystem.setDuration(j2, j);
        } else if (this.n != null) {
            synchronized (this) {
                this.o = true;
            }
        }
    }

    @Override // com.autonavi.amap.api.mapcore.overlays.IParticleLatyer
    public void setLoop(boolean z) {
        ParticleOverlayOptions particleOverlayOptions = this.n;
        if (particleOverlayOptions != null) {
            particleOverlayOptions.setLoop(z);
        }
        long j = this.d;
        if (j != 0) {
            AMapNativeParticleSystem.setLoop(j, z);
        } else if (this.n != null) {
            synchronized (this) {
                this.o = true;
            }
        }
    }

    @Override // com.autonavi.amap.api.mapcore.overlays.IParticleLatyer
    public void setMaxParticles(int i) {
        ParticleOverlayOptions particleOverlayOptions = this.n;
        if (particleOverlayOptions != null) {
            particleOverlayOptions.setMaxParticles(i);
        }
        long j = this.d;
        if (j != 0) {
            AMapNativeParticleSystem.setMaxParticles(j, i);
        } else if (this.n != null) {
            synchronized (this) {
                this.o = true;
            }
        }
    }

    @Override // com.autonavi.amap.api.mapcore.overlays.IParticleLatyer
    public void setParticleEmission(ParticleEmissionModule particleEmissionModule) {
        ParticleOverlayOptions particleOverlayOptions = this.n;
        if (particleOverlayOptions != null) {
            particleOverlayOptions.setParticleEmissionModule(particleEmissionModule);
        }
        if (this.d != 0 && particleEmissionModule != null) {
            if (particleEmissionModule.getNativeInstance() == 0) {
                particleEmissionModule.createNativeInstace();
            }
            AMapNativeParticleSystem.setParticleEmission(this.d, particleEmissionModule.getNativeInstance());
        } else if (this.n != null) {
            synchronized (this) {
                this.o = true;
            }
        }
    }

    @Override // com.autonavi.amap.api.mapcore.overlays.IParticleLatyer
    public void setParticleLifeTime(long j) {
        ParticleOverlayOptions particleOverlayOptions = this.n;
        if (particleOverlayOptions != null) {
            particleOverlayOptions.setParticleLifeTime(j);
        }
        long j2 = this.d;
        if (j2 != 0) {
            AMapNativeParticleSystem.setParticleLifeTime(j2, j);
        } else if (this.n != null) {
            synchronized (this) {
                this.o = true;
            }
        }
    }

    @Override // com.autonavi.amap.api.mapcore.overlays.IParticleLatyer
    public void setParticleOverLifeModule(ParticleOverLifeModule particleOverLifeModule) {
        ParticleOverlayOptions particleOverlayOptions = this.n;
        if (particleOverlayOptions != null) {
            particleOverlayOptions.setParticleOverLifeModule(particleOverLifeModule);
        }
        if (this.d != 0 && particleOverLifeModule != null) {
            if (particleOverLifeModule.getNativeInstance() == 0) {
                particleOverLifeModule.createNativeInstace();
            }
            AMapNativeParticleSystem.setParticleOverLifeModule(this.d, particleOverLifeModule.getNativeInstance());
        } else if (this.n != null) {
            synchronized (this) {
                this.o = true;
            }
        }
    }

    @Override // com.autonavi.amap.api.mapcore.overlays.IParticleLatyer
    public void setParticleShapeModule(ParticleShapeModule particleShapeModule) {
        ParticleOverlayOptions particleOverlayOptions = this.n;
        if (particleOverlayOptions != null) {
            particleOverlayOptions.setParticleShapeModule(particleShapeModule);
        }
        if (this.d != 0 && particleShapeModule != null) {
            if (particleShapeModule.getNativeInstance() == 0) {
                particleShapeModule.createNativeInstace();
            }
            AMapNativeParticleSystem.setParticleShapeModule(this.d, particleShapeModule.getNativeInstance());
        } else if (this.n != null) {
            synchronized (this) {
                this.o = true;
            }
        }
    }

    @Override // com.autonavi.amap.api.mapcore.overlays.IParticleLatyer
    public void setParticleStartSpeed(VelocityGenerate velocityGenerate) {
        ParticleOverlayOptions particleOverlayOptions = this.n;
        if (particleOverlayOptions != null) {
            particleOverlayOptions.setParticleStartSpeed(velocityGenerate);
        }
        if (this.d != 0 && velocityGenerate != null) {
            if (velocityGenerate.getNativeInstance() == 0) {
                velocityGenerate.createNativeInstace();
            }
            AMapNativeParticleSystem.setParticleStartSpeed(this.d, velocityGenerate.getNativeInstance());
        } else if (this.n != null) {
            synchronized (this) {
                this.o = true;
            }
        }
    }

    @Override // com.autonavi.amap.api.mapcore.overlays.IParticleLatyer
    public void setPreWram(boolean z) {
        long j = this.d;
        if (j != 0) {
            AMapNativeParticleSystem.setPreWram(j, z);
        }
    }

    @Override // com.autonavi.amap.api.mapcore.overlays.IParticleLatyer
    public void setStartColor(ColorGenerate colorGenerate) {
        ParticleOverlayOptions particleOverlayOptions = this.n;
        if (particleOverlayOptions != null) {
            particleOverlayOptions.setParticleStartColor(colorGenerate);
        }
        if (this.d != 0 && colorGenerate != null) {
            if (colorGenerate.getNativeInstance() == 0) {
                colorGenerate.createNativeInstace();
            }
            AMapNativeParticleSystem.setStartColor(this.d, colorGenerate.getNativeInstance());
        } else if (this.n != null) {
            synchronized (this) {
                this.o = true;
            }
        }
    }

    @Override // com.autonavi.amap.api.mapcore.overlays.IParticleLatyer
    public void setStartParticleSize(int i, int i2) {
        ParticleOverlayOptions particleOverlayOptions = this.n;
        if (particleOverlayOptions != null) {
            particleOverlayOptions.setStartParticleSize(i, i2);
        }
        long j = this.d;
        if (j != 0) {
            AMapNativeParticleSystem.setStartParticleSize(j, i, i2);
        }
    }

    @Override // com.autonavi.amap.api.mapcore.overlays.IParticleLatyer, com.autonavi.amap.mapcore.interfaces.IOverlay
    public void setVisible(boolean z) throws RemoteException {
        this.g = z;
    }

    @Override // com.autonavi.amap.mapcore.interfaces.IOverlay
    public void setZIndex(float f) throws RemoteException {
        this.h = f;
    }

    @Override // com.autonavi.amap.api.mapcore.overlays.IParticleLatyer
    public void start() {
    }

    @Override // com.autonavi.amap.api.mapcore.overlays.IParticleLatyer
    public void stop() {
    }

    private int a() {
        if (!this.k) {
            int a = a(Build.VERSION.SDK_INT >= 12, this.j);
            this.k = true;
            return a;
        }
        return this.m;
    }

    private void a(x xVar) {
        if (xVar != null) {
            this.l.add(xVar);
            xVar.m();
        }
    }

    private int a(boolean z, BitmapDescriptor bitmapDescriptor) {
        x xVar;
        b();
        if (z) {
            xVar = this.f.a(bitmapDescriptor);
            if (xVar != null) {
                int k = xVar.k();
                a(xVar);
                return k;
            }
        } else {
            xVar = null;
        }
        int i = 0;
        if (xVar == null) {
            xVar = new x(bitmapDescriptor, 0);
        }
        Bitmap bitmap = bitmapDescriptor.getBitmap();
        if (bitmap != null && !bitmap.isRecycled()) {
            i = c();
            xVar.a(i);
            if (z) {
                this.f.g().addTextureItem(xVar);
            }
            a(xVar);
            eq.b(i, bitmap, true);
        }
        return i;
    }
}
