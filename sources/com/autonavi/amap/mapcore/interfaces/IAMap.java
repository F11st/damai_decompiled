package com.autonavi.amap.mapcore.interfaces;

import android.location.Location;
import android.os.Handler;
import android.os.RemoteException;
import android.util.Pair;
import android.view.MotionEvent;
import android.view.View;
import com.amap.api.maps.AMap;
import com.amap.api.maps.CameraUpdate;
import com.amap.api.maps.CustomRenderer;
import com.amap.api.maps.InfoWindowAnimationManager;
import com.amap.api.maps.LocationSource;
import com.amap.api.maps.Projection;
import com.amap.api.maps.UiSettings;
import com.amap.api.maps.model.AMapCameraInfo;
import com.amap.api.maps.model.AMapGestureListener;
import com.amap.api.maps.model.Arc;
import com.amap.api.maps.model.ArcOptions;
import com.amap.api.maps.model.BuildingOverlay;
import com.amap.api.maps.model.CameraPosition;
import com.amap.api.maps.model.Circle;
import com.amap.api.maps.model.CircleOptions;
import com.amap.api.maps.model.CrossOverlay;
import com.amap.api.maps.model.CrossOverlayOptions;
import com.amap.api.maps.model.CustomMapStyleOptions;
import com.amap.api.maps.model.GL3DModel;
import com.amap.api.maps.model.GL3DModelOptions;
import com.amap.api.maps.model.GroundOverlay;
import com.amap.api.maps.model.GroundOverlayOptions;
import com.amap.api.maps.model.HeatMapLayer;
import com.amap.api.maps.model.HeatMapLayerOptions;
import com.amap.api.maps.model.IndoorBuildingInfo;
import com.amap.api.maps.model.LatLng;
import com.amap.api.maps.model.LatLngBounds;
import com.amap.api.maps.model.Marker;
import com.amap.api.maps.model.MarkerOptions;
import com.amap.api.maps.model.MultiPointOverlay;
import com.amap.api.maps.model.MultiPointOverlayOptions;
import com.amap.api.maps.model.MyLocationStyle;
import com.amap.api.maps.model.MyTrafficStyle;
import com.amap.api.maps.model.NavigateArrow;
import com.amap.api.maps.model.NavigateArrowOptions;
import com.amap.api.maps.model.Polygon;
import com.amap.api.maps.model.PolygonOptions;
import com.amap.api.maps.model.Polyline;
import com.amap.api.maps.model.PolylineOptions;
import com.amap.api.maps.model.RouteOverlay;
import com.amap.api.maps.model.Text;
import com.amap.api.maps.model.TextOptions;
import com.amap.api.maps.model.TileOverlay;
import com.amap.api.maps.model.TileOverlayOptions;
import com.amap.api.maps.model.particle.ParticleOverlay;
import com.amap.api.maps.model.particle.ParticleOverlayOptions;
import com.autonavi.amap.api.mapcore.IGLMapState;
import com.autonavi.amap.mapcore.DPoint;
import java.util.ArrayList;
import java.util.List;
import javax.microedition.khronos.egl.EGLConfig;
import javax.microedition.khronos.opengles.GL10;

/* compiled from: Taobao */
/* loaded from: classes10.dex */
public interface IAMap {
    void accelerateNetworkInChinese(boolean z);

    Arc addArc(ArcOptions arcOptions) throws RemoteException;

    BuildingOverlay addBuildingOverlay();

    Circle addCircle(CircleOptions circleOptions) throws RemoteException;

    CrossOverlay addCrossVector(CrossOverlayOptions crossOverlayOptions);

    GL3DModel addGLModel(GL3DModelOptions gL3DModelOptions);

    GroundOverlay addGroundOverlay(GroundOverlayOptions groundOverlayOptions) throws RemoteException;

    HeatMapLayer addHeatMapLayer(HeatMapLayerOptions heatMapLayerOptions) throws RemoteException;

    Marker addMarker(MarkerOptions markerOptions) throws RemoteException;

    ArrayList<Marker> addMarkers(ArrayList<MarkerOptions> arrayList, boolean z) throws RemoteException;

    MultiPointOverlay addMultiPointOverlay(MultiPointOverlayOptions multiPointOverlayOptions) throws RemoteException;

    RouteOverlay addNaviRouteOverlay();

    NavigateArrow addNavigateArrow(NavigateArrowOptions navigateArrowOptions) throws RemoteException;

    void addOnCameraChangeListener(AMap.OnCameraChangeListener onCameraChangeListener) throws RemoteException;

    void addOnIndoorBuildingActiveListener(AMap.OnIndoorBuildingActiveListener onIndoorBuildingActiveListener) throws RemoteException;

    void addOnInfoWindowClickListener(AMap.OnInfoWindowClickListener onInfoWindowClickListener) throws RemoteException;

    void addOnMapClickListener(AMap.OnMapClickListener onMapClickListener) throws RemoteException;

    void addOnMapLoadedListener(AMap.OnMapLoadedListener onMapLoadedListener) throws RemoteException;

    void addOnMapLongClickListener(AMap.OnMapLongClickListener onMapLongClickListener) throws RemoteException;

    void addOnMapTouchListener(AMap.OnMapTouchListener onMapTouchListener) throws RemoteException;

    void addOnMarkerClickListener(AMap.OnMarkerClickListener onMarkerClickListener) throws RemoteException;

    void addOnMarkerDragListener(AMap.OnMarkerDragListener onMarkerDragListener) throws RemoteException;

    void addOnMyLocationChangeListener(AMap.OnMyLocationChangeListener onMyLocationChangeListener) throws RemoteException;

    void addOnPOIClickListener(AMap.OnPOIClickListener onPOIClickListener) throws RemoteException;

    void addOnPolylineClickListener(AMap.OnPolylineClickListener onPolylineClickListener) throws RemoteException;

    ParticleOverlay addParticleOverlay(ParticleOverlayOptions particleOverlayOptions);

    Polygon addPolygon(PolygonOptions polygonOptions) throws RemoteException;

    Polyline addPolyline(PolylineOptions polylineOptions) throws RemoteException;

    Text addText(TextOptions textOptions) throws RemoteException;

    TileOverlay addTileOverlay(TileOverlayOptions tileOverlayOptions) throws RemoteException;

    void animateCamera(CameraUpdate cameraUpdate) throws RemoteException;

    void animateCameraWithCallback(CameraUpdate cameraUpdate, AMap.CancelableCallback cancelableCallback) throws RemoteException;

    void animateCameraWithDurationAndCallback(CameraUpdate cameraUpdate, long j, AMap.CancelableCallback cancelableCallback) throws RemoteException;

    Pair<Float, LatLng> calculateZoomToSpanLevel(int i, int i2, int i3, int i4, LatLng latLng, LatLng latLng2);

    boolean canStopMapRender();

    void changeSurface(GL10 gl10, int i, int i2);

    void checkMapState(IGLMapState iGLMapState);

    void clear() throws RemoteException;

    void clear(boolean z) throws RemoteException;

    long createGLOverlay(int i);

    void createSurface(GL10 gl10, EGLConfig eGLConfig);

    void destroy();

    void destroySurface(int i);

    void drawFrame(GL10 gl10);

    Projection getAMapProjection() throws RemoteException;

    UiSettings getAMapUiSettings() throws RemoteException;

    AMapCameraInfo getCamerInfo();

    float getCameraAngle();

    CameraPosition getCameraPosition() throws RemoteException;

    String getCurrentWorldVectorMapStyle();

    long getGlOverlayMgrPtr();

    InfoWindowAnimationManager getInfoWindowAnimationManager();

    void getLatLngRect(DPoint[] dPointArr);

    Handler getMainHandler();

    String getMapContentApprovalNumber();

    int getMapHeight();

    void getMapPrintScreen(AMap.onMapPrintScreenListener onmapprintscreenlistener);

    List<Marker> getMapScreenMarkers() throws RemoteException;

    void getMapScreenShot(AMap.OnMapScreenShotListener onMapScreenShotListener);

    int getMapTextZIndex() throws RemoteException;

    int getMapType() throws RemoteException;

    int getMapWidth();

    float getMaxZoomLevel();

    float getMinZoomLevel();

    Location getMyLocation() throws RemoteException;

    MyLocationStyle getMyLocationStyle() throws RemoteException;

    long getNativeMapController();

    float[] getProjectionMatrix();

    int getRenderMode();

    int getSX();

    int getSY();

    String getSatelliteImageApprovalNumber();

    float getScalePerPixel() throws RemoteException;

    float getSkyHeight();

    View getView() throws RemoteException;

    float[] getViewMatrix();

    String getWorldVectorMapLanguage();

    String getWorldVectorMapStyle();

    float getZoomToSpanLevel(LatLng latLng, LatLng latLng2);

    boolean isIndoorEnabled() throws RemoteException;

    boolean isMaploaded();

    boolean isMyLocationEnabled() throws RemoteException;

    boolean isTouchPoiEnable();

    boolean isTrafficEnabled() throws RemoteException;

    void loadWorldVectorMap(boolean z);

    void moveCamera(CameraUpdate cameraUpdate) throws RemoteException;

    void onActivityPause();

    void onActivityResume();

    void onChangeFinish();

    void onFling();

    void onIndoorBuildingActivity(int i, byte[] bArr);

    boolean onTouchEvent(MotionEvent motionEvent);

    void queueEvent(Runnable runnable);

    void reloadMap();

    void removeOnCameraChangeListener(AMap.OnCameraChangeListener onCameraChangeListener) throws RemoteException;

    void removeOnIndoorBuildingActiveListener(AMap.OnIndoorBuildingActiveListener onIndoorBuildingActiveListener) throws RemoteException;

    void removeOnInfoWindowClickListener(AMap.OnInfoWindowClickListener onInfoWindowClickListener) throws RemoteException;

    void removeOnMapClickListener(AMap.OnMapClickListener onMapClickListener) throws RemoteException;

    void removeOnMapLoadedListener(AMap.OnMapLoadedListener onMapLoadedListener) throws RemoteException;

    void removeOnMapLongClickListener(AMap.OnMapLongClickListener onMapLongClickListener) throws RemoteException;

    void removeOnMapTouchListener(AMap.OnMapTouchListener onMapTouchListener) throws RemoteException;

    void removeOnMarkerClickListener(AMap.OnMarkerClickListener onMarkerClickListener) throws RemoteException;

    void removeOnMarkerDragListener(AMap.OnMarkerDragListener onMarkerDragListener) throws RemoteException;

    void removeOnMyLocationChangeListener(AMap.OnMyLocationChangeListener onMyLocationChangeListener) throws RemoteException;

    void removeOnPOIClickListener(AMap.OnPOIClickListener onPOIClickListener) throws RemoteException;

    void removeOnPolylineClickListener(AMap.OnPolylineClickListener onPolylineClickListener) throws RemoteException;

    void removecache() throws RemoteException;

    void removecache(AMap.OnCacheRemoveListener onCacheRemoveListener) throws RemoteException;

    void renderSurface(GL10 gl10);

    void requestRender();

    void resetMinMaxZoomPreference();

    void resetRenderTime();

    void set3DBuildingEnabled(boolean z) throws RemoteException;

    void setAMapGestureListener(AMapGestureListener aMapGestureListener);

    void setCenterToPixel(int i, int i2) throws RemoteException;

    void setCustomMapStyle(CustomMapStyleOptions customMapStyleOptions);

    void setCustomMapStyleID(String str);

    void setCustomMapStylePath(String str);

    void setCustomRenderer(CustomRenderer customRenderer) throws RemoteException;

    void setCustomTextureResourcePath(String str);

    void setIndoorBuildingInfo(IndoorBuildingInfo indoorBuildingInfo) throws RemoteException;

    void setIndoorEnabled(boolean z) throws RemoteException;

    void setInfoWindowAdapter(AMap.CommonInfoWindowAdapter commonInfoWindowAdapter) throws RemoteException;

    void setInfoWindowAdapter(AMap.InfoWindowAdapter infoWindowAdapter) throws RemoteException;

    void setLoadOfflineData(boolean z) throws RemoteException;

    void setLocationSource(LocationSource locationSource) throws RemoteException;

    void setMapCustomEnable(boolean z);

    void setMapLanguage(String str);

    void setMapStatusLimits(LatLngBounds latLngBounds);

    void setMapTextEnable(boolean z) throws RemoteException;

    void setMapTextZIndex(int i) throws RemoteException;

    void setMapType(int i) throws RemoteException;

    void setMaskLayerParams(int i, int i2, int i3, int i4, int i5, long j);

    void setMaxZoomLevel(float f);

    void setMinZoomLevel(float f);

    void setMyLocationEnabled(boolean z) throws RemoteException;

    void setMyLocationRotateAngle(float f) throws RemoteException;

    void setMyLocationStyle(MyLocationStyle myLocationStyle) throws RemoteException;

    void setMyLocationType(int i) throws RemoteException;

    void setMyTrafficStyle(MyTrafficStyle myTrafficStyle) throws RemoteException;

    void setNaviLabelEnable(boolean z, int i, int i2) throws RemoteException;

    void setOnCameraChangeListener(AMap.OnCameraChangeListener onCameraChangeListener) throws RemoteException;

    void setOnIndoorBuildingActiveListener(AMap.OnIndoorBuildingActiveListener onIndoorBuildingActiveListener) throws RemoteException;

    void setOnInfoWindowClickListener(AMap.OnInfoWindowClickListener onInfoWindowClickListener) throws RemoteException;

    void setOnMapClickListener(AMap.OnMapClickListener onMapClickListener) throws RemoteException;

    void setOnMapLongClickListener(AMap.OnMapLongClickListener onMapLongClickListener) throws RemoteException;

    void setOnMapTouchListener(AMap.OnMapTouchListener onMapTouchListener) throws RemoteException;

    void setOnMaploadedListener(AMap.OnMapLoadedListener onMapLoadedListener) throws RemoteException;

    void setOnMarkerClickListener(AMap.OnMarkerClickListener onMarkerClickListener) throws RemoteException;

    void setOnMarkerDragListener(AMap.OnMarkerDragListener onMarkerDragListener) throws RemoteException;

    void setOnMultiPointClickListener(AMap.OnMultiPointClickListener onMultiPointClickListener);

    void setOnMyLocationChangeListener(AMap.OnMyLocationChangeListener onMyLocationChangeListener) throws RemoteException;

    void setOnPOIClickListener(AMap.OnPOIClickListener onPOIClickListener) throws RemoteException;

    void setOnPolylineClickListener(AMap.OnPolylineClickListener onPolylineClickListener) throws RemoteException;

    void setRenderFps(int i);

    void setRenderMode(int i);

    void setRoadArrowEnable(boolean z) throws RemoteException;

    void setRunLowFrame(boolean z);

    void setTouchPoiEnable(boolean z);

    void setTrafficEnabled(boolean z) throws RemoteException;

    void setVisibilityEx(int i);

    void setWorldVectorMapStyle(String str);

    void setZOrderOnTop(boolean z) throws RemoteException;

    void setZoomScaleParam(float f);

    void stopAnimation() throws RemoteException;
}
