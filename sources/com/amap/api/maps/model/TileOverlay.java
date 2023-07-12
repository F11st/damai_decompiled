package com.amap.api.maps.model;

import com.autonavi.amap.mapcore.interfaces.ITileOverlay;

/* compiled from: Taobao */
/* loaded from: classes10.dex */
public final class TileOverlay {
    private ITileOverlay mTileOverlayDelegate;

    public TileOverlay(ITileOverlay iTileOverlay) {
        this.mTileOverlayDelegate = iTileOverlay;
    }

    public void clearTileCache() {
        this.mTileOverlayDelegate.clearTileCache();
    }

    public boolean equals(Object obj) {
        if (obj != null && (obj instanceof TileOverlay)) {
            try {
                return this.mTileOverlayDelegate.equalsRemote(((TileOverlay) obj).mTileOverlayDelegate);
            } catch (Throwable th) {
                th.printStackTrace();
            }
        }
        return false;
    }

    public String getId() {
        return this.mTileOverlayDelegate.getId();
    }

    public float getZIndex() {
        return this.mTileOverlayDelegate.getZIndex();
    }

    public int hashCode() {
        return this.mTileOverlayDelegate.hashCodeRemote();
    }

    public boolean isVisible() {
        return this.mTileOverlayDelegate.isVisible();
    }

    public void remove() {
        this.mTileOverlayDelegate.remove();
    }

    public void setVisible(boolean z) {
        this.mTileOverlayDelegate.setVisible(z);
    }

    public void setZIndex(float f) {
        this.mTileOverlayDelegate.setZIndex(f);
    }
}
