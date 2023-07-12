package com.amap.api.mapcore.util;

import android.os.RemoteException;
import androidx.core.internal.view.SupportMenu;
import com.amap.api.maps.model.BuildingOverlayOptions;
import com.amap.api.maps.model.LatLng;
import com.autonavi.amap.api.mapcore.overlays.IBuildingDelegate;
import com.autonavi.amap.mapcore.interfaces.IOverlay;
import com.autonavi.base.amap.api.mapcore.overlays.IOverlayDelegate;
import com.autonavi.base.amap.mapcore.AMapNativeBuildingRenderer;
import com.autonavi.base.amap.mapcore.MapConfig;
import java.util.ArrayList;
import java.util.List;

/* compiled from: Taobao */
/* loaded from: classes10.dex */
public class cp implements IBuildingDelegate, IOverlayDelegate {
    private r b;
    private BuildingOverlayOptions c;
    private List<BuildingOverlayOptions> e;
    private String g;
    private float h;
    private boolean i;
    private de j;
    long a = -1;
    private List<BuildingOverlayOptions> d = new ArrayList();
    private boolean f = true;

    public cp(r rVar) {
        try {
            this.b = rVar;
            if (this.c == null) {
                BuildingOverlayOptions buildingOverlayOptions = new BuildingOverlayOptions();
                this.c = buildingOverlayOptions;
                buildingOverlayOptions.setVisible(true);
                ArrayList arrayList = new ArrayList();
                arrayList.add(new LatLng(84.9d, -179.9d));
                arrayList.add(new LatLng(84.9d, 179.9d));
                arrayList.add(new LatLng(-84.9d, 179.9d));
                arrayList.add(new LatLng(-84.9d, -179.9d));
                this.c.setBuildingLatlngs(arrayList);
                this.c.setBuildingTopColor(SupportMenu.CATEGORY_MASK);
                this.c.setBuildingSideColor(-12303292);
                this.c.setVisible(true);
                this.c.setZIndex(1.0f);
                this.d.add(this.c);
                a(true);
            }
            try {
                this.g = getId();
            } catch (Exception e) {
                hd.c(e, "BuildingOverlayDelegateImp", "create");
                e.printStackTrace();
            }
        } catch (Exception e2) {
            e2.printStackTrace();
        }
    }

    private void a(boolean z) {
        try {
            synchronized (this) {
                if (z) {
                    this.d.set(0, this.c);
                } else {
                    this.d.removeAll(this.e);
                    this.d.set(0, this.c);
                    this.d.addAll(this.e);
                }
                this.i = true;
            }
        } catch (Exception e) {
            e.printStackTrace();
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

    @Override // com.autonavi.amap.api.mapcore.overlays.IBuildingDelegate, com.autonavi.amap.mapcore.interfaces.IOverlay
    public void destroy() {
        synchronized (this) {
            long j = this.a;
            if (j != -1) {
                AMapNativeBuildingRenderer.nativeDestory(j);
                List<BuildingOverlayOptions> list = this.d;
                if (list != null) {
                    list.clear();
                }
                this.e = null;
                this.c = null;
                this.a = -1L;
            }
        }
    }

    @Override // com.autonavi.base.amap.api.mapcore.overlays.IOverlayDelegate
    public void draw(MapConfig mapConfig) throws RemoteException {
        de deVar;
        if (mapConfig == null) {
            return;
        }
        try {
            if (this.a != -1) {
                synchronized (this) {
                    long j = this.a;
                    if (j != -1) {
                        if (this.i) {
                            AMapNativeBuildingRenderer.nativeClearBuildingOptions(j);
                            for (int i = 0; i < this.d.size(); i++) {
                                AMapNativeBuildingRenderer.addBuildingOptions(this.a, this.d.get(i));
                            }
                            this.i = false;
                        }
                        AMapNativeBuildingRenderer.render(this.a, mapConfig.getViewMatrix(), mapConfig.getProjectionMatrix(), (int) mapConfig.getSX(), (int) mapConfig.getSY(), mapConfig.getSZ(), mapConfig.getCurTileIds());
                    }
                }
                return;
            }
            long nativeCreate = AMapNativeBuildingRenderer.nativeCreate();
            this.a = nativeCreate;
            if (nativeCreate == -1 || (deVar = this.j) == null) {
                return;
            }
            AMapNativeBuildingRenderer.nativeSetGLShaderManager(nativeCreate, deVar.a());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override // com.autonavi.amap.mapcore.interfaces.IOverlay
    public boolean equalsRemote(IOverlay iOverlay) throws RemoteException {
        return false;
    }

    @Override // com.autonavi.amap.api.mapcore.overlays.IBuildingDelegate
    public List<BuildingOverlayOptions> getCustomOptions() {
        return this.e;
    }

    @Override // com.autonavi.amap.api.mapcore.overlays.IBuildingDelegate
    public BuildingOverlayOptions getDefaultOptions() {
        BuildingOverlayOptions buildingOverlayOptions;
        synchronized (this) {
            buildingOverlayOptions = this.c;
        }
        return buildingOverlayOptions;
    }

    @Override // com.autonavi.amap.api.mapcore.overlays.IBuildingDelegate, com.autonavi.amap.mapcore.interfaces.IOverlay
    public String getId() {
        if (this.g == null) {
            this.g = this.b.a("Building");
        }
        return this.g;
    }

    @Override // com.autonavi.amap.api.mapcore.overlays.IBuildingDelegate, com.autonavi.amap.mapcore.interfaces.IOverlay
    public float getZIndex() {
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

    @Override // com.autonavi.amap.api.mapcore.overlays.IBuildingDelegate, com.autonavi.amap.mapcore.interfaces.IOverlay
    public boolean isVisible() {
        return this.f;
    }

    @Override // com.autonavi.amap.mapcore.interfaces.IOverlay
    public void remove() throws RemoteException {
        r rVar = this.b;
        if (rVar == null || rVar.a(this.g, true)) {
            return;
        }
        destroy();
    }

    @Override // com.autonavi.amap.mapcore.interfaces.IOverlay
    public void setAboveMaskLayer(boolean z) {
    }

    @Override // com.autonavi.amap.api.mapcore.overlays.IBuildingDelegate
    public void setCustomOptions(List<BuildingOverlayOptions> list) {
        if (list == null || list.size() <= 0) {
            return;
        }
        synchronized (this) {
            this.e = list;
        }
        a(false);
    }

    @Override // com.autonavi.amap.api.mapcore.overlays.IBuildingDelegate
    public void setDefaultOptions(BuildingOverlayOptions buildingOverlayOptions) {
        if (buildingOverlayOptions != null) {
            synchronized (this) {
                this.c = buildingOverlayOptions;
            }
            a(true);
        }
    }

    @Override // com.autonavi.amap.api.mapcore.overlays.IBuildingDelegate, com.autonavi.amap.mapcore.interfaces.IOverlay
    public void setVisible(boolean z) {
        this.f = z;
    }

    @Override // com.autonavi.amap.api.mapcore.overlays.IBuildingDelegate, com.autonavi.amap.mapcore.interfaces.IOverlay
    public void setZIndex(float f) {
        try {
            this.h = f;
            this.b.e();
            synchronized (this) {
                this.c.setZIndex(this.h);
            }
            a(true);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void a(de deVar) {
        this.j = deVar;
    }
}
