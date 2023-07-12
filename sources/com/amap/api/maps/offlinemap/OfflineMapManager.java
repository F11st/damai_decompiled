package com.amap.api.maps.offlinemap;

import android.content.Context;
import android.os.Handler;
import com.amap.api.mapcore.util.az;
import com.amap.api.mapcore.util.ba;
import com.amap.api.mapcore.util.be;
import com.amap.api.mapcore.util.eo;
import com.amap.api.mapcore.util.eq;
import com.amap.api.mapcore.util.gi;
import com.amap.api.mapcore.util.hd;
import com.amap.api.maps.AMap;
import com.amap.api.maps.AMapException;
import java.util.ArrayList;
import java.util.Iterator;

/* compiled from: Taobao */
/* loaded from: classes10.dex */
public final class OfflineMapManager {
    be a;
    ba b;
    private Context c;
    private OfflineMapDownloadListener d;
    private OfflineLoadedListener e;
    private Handler f;
    private Handler g;

    /* compiled from: Taobao */
    /* loaded from: classes10.dex */
    public interface OfflineLoadedListener {
        void onVerifyComplete();
    }

    /* compiled from: Taobao */
    /* loaded from: classes10.dex */
    public interface OfflineMapDownloadListener {
        void onCheckUpdate(boolean z, String str);

        void onDownload(int i, int i2, String str);

        void onRemove(boolean z, String str, String str2);
    }

    public OfflineMapManager(Context context, OfflineMapDownloadListener offlineMapDownloadListener) {
        this.d = offlineMapDownloadListener;
        this.c = context.getApplicationContext();
        this.f = new Handler(this.c.getMainLooper());
        this.g = new Handler(this.c.getMainLooper());
        a(context);
        gi.a().a(this.c);
    }

    public void destroy() {
        try {
            ba baVar = this.b;
            if (baVar != null) {
                baVar.e();
            }
            b();
            Handler handler = this.f;
            if (handler != null) {
                handler.removeCallbacksAndMessages(null);
            }
            this.f = null;
            Handler handler2 = this.g;
            if (handler2 != null) {
                handler2.removeCallbacksAndMessages(null);
            }
            this.g = null;
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    public void downloadByCityCode(String str) throws AMapException {
        try {
            this.b.e(str);
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    public void downloadByCityName(String str) throws AMapException {
        try {
            this.b.d(str);
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    public void downloadByProvinceName(String str) throws AMapException {
        try {
            a();
            OfflineMapProvince itemByProvinceName = getItemByProvinceName(str);
            if (itemByProvinceName != null) {
                Iterator<OfflineMapCity> it = itemByProvinceName.getCityList().iterator();
                while (it.hasNext()) {
                    final String city = it.next().getCity();
                    this.g.post(new Runnable() { // from class: com.amap.api.maps.offlinemap.OfflineMapManager.2
                        @Override // java.lang.Runnable
                        public void run() {
                            try {
                                OfflineMapManager.this.b.d(city);
                            } catch (AMapException e) {
                                hd.c(e, "OfflineMapManager", "downloadByProvinceName");
                            }
                        }
                    });
                }
                return;
            }
            throw new AMapException("无效的参数 - IllegalArgumentException");
        } catch (Throwable th) {
            if (!(th instanceof AMapException)) {
                hd.c(th, "OfflineMapManager", "downloadByProvinceName");
                return;
            }
            throw th;
        }
    }

    public ArrayList<OfflineMapCity> getDownloadOfflineMapCityList() {
        return this.a.c();
    }

    public ArrayList<OfflineMapProvince> getDownloadOfflineMapProvinceList() {
        return this.a.d();
    }

    public ArrayList<OfflineMapCity> getDownloadingCityList() {
        return this.a.e();
    }

    public ArrayList<OfflineMapProvince> getDownloadingProvinceList() {
        return this.a.f();
    }

    public OfflineMapCity getItemByCityCode(String str) {
        return this.a.a(str);
    }

    public OfflineMapCity getItemByCityName(String str) {
        return this.a.b(str);
    }

    public OfflineMapProvince getItemByProvinceName(String str) {
        return this.a.c(str);
    }

    public ArrayList<OfflineMapCity> getOfflineMapCityList() {
        return this.a.b();
    }

    public ArrayList<OfflineMapProvince> getOfflineMapProvinceList() {
        return this.a.a();
    }

    public void pause() {
        this.b.d();
    }

    public void remove(String str) {
        try {
            if (this.b.b(str)) {
                this.b.c(str);
                return;
            }
            OfflineMapProvince c = this.a.c(str);
            if (c != null && c.getCityList() != null) {
                Iterator<OfflineMapCity> it = c.getCityList().iterator();
                while (it.hasNext()) {
                    final String city = it.next().getCity();
                    this.g.post(new Runnable() { // from class: com.amap.api.maps.offlinemap.OfflineMapManager.3
                        @Override // java.lang.Runnable
                        public void run() {
                            OfflineMapManager.this.b.c(city);
                        }
                    });
                }
                return;
            }
            OfflineMapDownloadListener offlineMapDownloadListener = this.d;
            if (offlineMapDownloadListener != null) {
                offlineMapDownloadListener.onRemove(false, str, "没有该城市");
            }
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    public void restart() {
    }

    public void setOnOfflineLoadedListener(OfflineLoadedListener offlineLoadedListener) {
        this.e = offlineLoadedListener;
    }

    public void stop() {
        this.b.c();
    }

    public void updateOfflineCityByCode(String str) throws AMapException {
        OfflineMapCity itemByCityCode = getItemByCityCode(str);
        if (itemByCityCode != null && itemByCityCode.getCity() != null) {
            a(itemByCityCode.getCity(), "cityname");
            return;
        }
        throw new AMapException("无效的参数 - IllegalArgumentException");
    }

    public void updateOfflineCityByName(String str) throws AMapException {
        a(str, "cityname");
    }

    public void updateOfflineMapProvinceByName(String str) throws AMapException {
        a(str, "cityname");
    }

    private void a(Context context) {
        Context applicationContext = context.getApplicationContext();
        this.c = applicationContext;
        ba.b = false;
        ba a = ba.a(applicationContext);
        this.b = a;
        a.a(new ba.a() { // from class: com.amap.api.maps.offlinemap.OfflineMapManager.1
            @Override // com.amap.api.mapcore.util.ba.a
            public void a(final az azVar) {
                if (OfflineMapManager.this.d == null || azVar == null) {
                    return;
                }
                OfflineMapManager.this.f.post(new Runnable() { // from class: com.amap.api.maps.offlinemap.OfflineMapManager.1.1
                    @Override // java.lang.Runnable
                    public void run() {
                        try {
                            OfflineMapManager.this.d.onDownload(azVar.c().b(), azVar.getcompleteCode(), azVar.getCity());
                        } catch (Throwable th) {
                            th.printStackTrace();
                        }
                    }
                });
            }

            @Override // com.amap.api.mapcore.util.ba.a
            public void b(final az azVar) {
                if (OfflineMapManager.this.d == null || azVar == null) {
                    return;
                }
                OfflineMapManager.this.f.post(new Runnable() { // from class: com.amap.api.maps.offlinemap.OfflineMapManager.1.2
                    @Override // java.lang.Runnable
                    public void run() {
                        try {
                            if (!azVar.c().equals(azVar.g) && !azVar.c().equals(azVar.a)) {
                                OfflineMapManager.this.d.onCheckUpdate(false, azVar.getCity());
                            }
                            OfflineMapManager.this.d.onCheckUpdate(true, azVar.getCity());
                        } catch (Throwable th) {
                            th.printStackTrace();
                        }
                    }
                });
            }

            @Override // com.amap.api.mapcore.util.ba.a
            public void c(final az azVar) {
                if (OfflineMapManager.this.d == null || azVar == null) {
                    return;
                }
                OfflineMapManager.this.f.post(new Runnable() { // from class: com.amap.api.maps.offlinemap.OfflineMapManager.1.3
                    @Override // java.lang.Runnable
                    public void run() {
                        try {
                            if (azVar.c().equals(azVar.a)) {
                                OfflineMapManager.this.d.onRemove(true, azVar.getCity(), "");
                            } else {
                                OfflineMapManager.this.d.onRemove(false, azVar.getCity(), "");
                            }
                        } catch (Throwable th) {
                            th.printStackTrace();
                        }
                    }
                });
            }

            @Override // com.amap.api.mapcore.util.ba.a
            public void a() {
                if (OfflineMapManager.this.e != null) {
                    OfflineMapManager.this.f.post(new Runnable() { // from class: com.amap.api.maps.offlinemap.OfflineMapManager.1.4
                        @Override // java.lang.Runnable
                        public void run() {
                            try {
                                OfflineMapManager.this.e.onVerifyComplete();
                            } catch (Throwable th) {
                                th.printStackTrace();
                            }
                        }
                    });
                }
            }
        });
        try {
            this.b.a();
            this.a = this.b.f;
            eo.b(context);
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    private void b() {
        this.d = null;
    }

    public OfflineMapManager(Context context, OfflineMapDownloadListener offlineMapDownloadListener, AMap aMap) {
        this.d = offlineMapDownloadListener;
        this.c = context.getApplicationContext();
        this.f = new Handler(this.c.getMainLooper());
        this.g = new Handler(this.c.getMainLooper());
        try {
            a(context);
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    private void a(String str, String str2) throws AMapException {
        this.b.a(str);
    }

    private void a() throws AMapException {
        if (!eq.d(this.c)) {
            throw new AMapException(AMapException.ERROR_CONNECTION);
        }
    }
}
