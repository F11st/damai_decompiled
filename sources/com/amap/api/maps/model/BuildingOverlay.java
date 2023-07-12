package com.amap.api.maps.model;

import android.text.TextUtils;
import androidx.core.internal.view.SupportMenu;
import com.amap.api.maps.interfaces.IGlOverlayLayer;
import com.autonavi.amap.api.mapcore.overlays.IBuildingDelegate;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.List;

/* compiled from: Taobao */
/* loaded from: classes10.dex */
public class BuildingOverlay extends BaseOverlay {
    private BuildingOverlayTotalOptions buildingOverlayTotalOptions = new BuildingOverlayTotalOptions();
    private WeakReference<IGlOverlayLayer> glOverlayLayerRef;
    private BuildingOverlayOptions mDefaultOptions;
    private IBuildingDelegate mDelegate;
    private List<BuildingOverlayOptions> optionList;

    /* JADX INFO: Access modifiers changed from: protected */
    /* compiled from: Taobao */
    /* loaded from: classes10.dex */
    public class BuildingOverlayTotalOptions extends BaseOptions {
        public List<BuildingOverlayOptions> allOptionList;
        private final String type = "BuildingOptions";
        public boolean isVisible = true;
        private float zIndex = 0.0f;

        protected BuildingOverlayTotalOptions() {
        }
    }

    public BuildingOverlay(IBuildingDelegate iBuildingDelegate) {
        this.mDelegate = iBuildingDelegate;
    }

    private void a(boolean z) {
        try {
            synchronized (this) {
                if (z) {
                    this.buildingOverlayTotalOptions.allOptionList.set(0, this.mDefaultOptions);
                } else {
                    this.buildingOverlayTotalOptions.allOptionList.removeAll(this.optionList);
                    this.buildingOverlayTotalOptions.allOptionList.set(0, this.mDefaultOptions);
                    this.buildingOverlayTotalOptions.allOptionList.addAll(this.optionList);
                }
                IGlOverlayLayer iGlOverlayLayer = this.glOverlayLayerRef.get();
                if (iGlOverlayLayer != null) {
                    iGlOverlayLayer.updateOption(this.overlayName, this.buildingOverlayTotalOptions);
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void destroy() {
        try {
            IBuildingDelegate iBuildingDelegate = this.mDelegate;
            if (iBuildingDelegate != null) {
                iBuildingDelegate.destroy();
            } else {
                IGlOverlayLayer iGlOverlayLayer = this.glOverlayLayerRef.get();
                if (iGlOverlayLayer != null) {
                    iGlOverlayLayer.removeOverlay(this.overlayName);
                }
            }
        } catch (Throwable unused) {
        }
    }

    public List<BuildingOverlayOptions> getCustomOptions() {
        IBuildingDelegate iBuildingDelegate = this.mDelegate;
        if (iBuildingDelegate != null) {
            return iBuildingDelegate.getCustomOptions();
        }
        return this.optionList;
    }

    public BuildingOverlayOptions getDefaultOptions() {
        IBuildingDelegate iBuildingDelegate = this.mDelegate;
        if (iBuildingDelegate != null) {
            return iBuildingDelegate.getDefaultOptions();
        }
        return this.mDefaultOptions;
    }

    public String getId() {
        IBuildingDelegate iBuildingDelegate = this.mDelegate;
        if (iBuildingDelegate != null) {
            return iBuildingDelegate.getId();
        }
        return this.overlayName;
    }

    public float getZIndex() {
        IBuildingDelegate iBuildingDelegate = this.mDelegate;
        if (iBuildingDelegate != null) {
            return iBuildingDelegate.getZIndex();
        }
        BuildingOverlayTotalOptions buildingOverlayTotalOptions = this.buildingOverlayTotalOptions;
        if (buildingOverlayTotalOptions != null) {
            return buildingOverlayTotalOptions.zIndex;
        }
        return 0.0f;
    }

    public boolean isVisible() {
        IBuildingDelegate iBuildingDelegate = this.mDelegate;
        if (iBuildingDelegate != null) {
            return iBuildingDelegate.isVisible();
        }
        BuildingOverlayTotalOptions buildingOverlayTotalOptions = this.buildingOverlayTotalOptions;
        if (buildingOverlayTotalOptions != null) {
            return buildingOverlayTotalOptions.isVisible;
        }
        return false;
    }

    public void setCustomOptions(List<BuildingOverlayOptions> list) {
        IBuildingDelegate iBuildingDelegate = this.mDelegate;
        if (iBuildingDelegate != null) {
            iBuildingDelegate.setCustomOptions(list);
        } else if (list == null || list.size() <= 0) {
        } else {
            synchronized (this) {
                this.optionList = list;
            }
            a(false);
        }
    }

    public void setDefaultOptions(BuildingOverlayOptions buildingOverlayOptions) {
        IBuildingDelegate iBuildingDelegate = this.mDelegate;
        if (iBuildingDelegate != null) {
            iBuildingDelegate.setDefaultOptions(buildingOverlayOptions);
        } else if (buildingOverlayOptions != null) {
            synchronized (this) {
                this.mDefaultOptions = buildingOverlayOptions;
            }
            a(true);
        }
    }

    public void setVisible(boolean z) {
        IBuildingDelegate iBuildingDelegate = this.mDelegate;
        if (iBuildingDelegate != null) {
            iBuildingDelegate.setVisible(z);
            return;
        }
        BuildingOverlayTotalOptions buildingOverlayTotalOptions = this.buildingOverlayTotalOptions;
        if (buildingOverlayTotalOptions != null) {
            buildingOverlayTotalOptions.isVisible = z;
            a();
        }
    }

    public void setZIndex(float f) {
        IBuildingDelegate iBuildingDelegate = this.mDelegate;
        if (iBuildingDelegate != null) {
            iBuildingDelegate.setZIndex(f);
            return;
        }
        BuildingOverlayOptions buildingOverlayOptions = this.mDefaultOptions;
        if (buildingOverlayOptions != null) {
            buildingOverlayOptions.setZIndex(f);
        }
        BuildingOverlayTotalOptions buildingOverlayTotalOptions = this.buildingOverlayTotalOptions;
        if (buildingOverlayTotalOptions != null) {
            buildingOverlayTotalOptions.zIndex = f;
            a();
        }
    }

    public BuildingOverlay(IGlOverlayLayer iGlOverlayLayer) {
        this.glOverlayLayerRef = new WeakReference<>(iGlOverlayLayer);
        this.buildingOverlayTotalOptions.allOptionList = new ArrayList();
        try {
            if (this.mDefaultOptions == null) {
                BuildingOverlayOptions buildingOverlayOptions = new BuildingOverlayOptions();
                this.mDefaultOptions = buildingOverlayOptions;
                buildingOverlayOptions.setVisible(true);
                ArrayList arrayList = new ArrayList();
                arrayList.add(new LatLng(84.9d, -179.9d));
                arrayList.add(new LatLng(84.9d, 179.9d));
                arrayList.add(new LatLng(-84.9d, 179.9d));
                arrayList.add(new LatLng(-84.9d, -179.9d));
                this.mDefaultOptions.setBuildingLatlngs(arrayList);
                this.mDefaultOptions.setBuildingTopColor(SupportMenu.CATEGORY_MASK);
                this.mDefaultOptions.setBuildingSideColor(-12303292);
                this.mDefaultOptions.setVisible(true);
                this.mDefaultOptions.setZIndex(1.0f);
                this.buildingOverlayTotalOptions.allOptionList.add(this.mDefaultOptions);
                a(true);
            }
        } catch (Throwable unused) {
        }
    }

    private void a() {
        try {
            IGlOverlayLayer iGlOverlayLayer = this.glOverlayLayerRef.get();
            if (TextUtils.isEmpty(this.overlayName) || iGlOverlayLayer == null) {
                return;
            }
            iGlOverlayLayer.updateOption(this.overlayName, this.buildingOverlayTotalOptions);
        } catch (Throwable unused) {
        }
    }
}
