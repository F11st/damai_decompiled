package com.amap.api.col.s;

import android.content.Context;
import android.os.Handler;
import android.os.Message;
import com.amap.api.col.s.bt;
import com.amap.api.col.s.t;
import com.amap.api.services.cloud.CloudItemDetail;
import com.amap.api.services.cloud.CloudResult;
import com.amap.api.services.cloud.CloudSearch;
import com.amap.api.services.core.AMapException;
import com.amap.api.services.core.LatLonPoint;
import com.amap.api.services.interfaces.ICloudSearch;
import java.util.HashMap;
import java.util.List;

/* compiled from: Taobao */
/* loaded from: classes10.dex */
public final class ax implements ICloudSearch {
    private Context a;
    private CloudSearch.OnCloudSearchListener b;
    private CloudSearch.Query c;
    private int d;
    private HashMap<Integer, CloudResult> e;
    private Handler f;

    public ax(Context context) throws AMapException {
        bu a = bt.a(context, h.a(false));
        if (a.a == bt.c.SuccessCode) {
            this.a = context.getApplicationContext();
            this.f = t.a();
            return;
        }
        String str = a.b;
        throw new AMapException(str, 1, str, a.a.a());
    }

    @Override // com.amap.api.services.interfaces.ICloudSearch
    public final void searchCloudAsyn(final CloudSearch.Query query) {
        try {
            ao.a().a(new Runnable() { // from class: com.amap.api.col.s.ax.1
                @Override // java.lang.Runnable
                public final void run() {
                    Message obtainMessage = t.a().obtainMessage();
                    try {
                        try {
                            obtainMessage.arg1 = 12;
                            obtainMessage.what = 700;
                            t.d dVar = new t.d();
                            dVar.b = ax.this.b;
                            obtainMessage.obj = dVar;
                            dVar.a = ax.this.a(query);
                            obtainMessage.arg2 = 1000;
                        } catch (AMapException e) {
                            obtainMessage.arg2 = e.getErrorCode();
                        }
                    } finally {
                        ax.this.f.sendMessage(obtainMessage);
                    }
                }
            });
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    @Override // com.amap.api.services.interfaces.ICloudSearch
    public final void searchCloudDetailAsyn(final String str, final String str2) {
        try {
            ao.a().a(new Runnable() { // from class: com.amap.api.col.s.ax.2
                @Override // java.lang.Runnable
                public final void run() {
                    Message obtainMessage = t.a().obtainMessage();
                    try {
                        try {
                            obtainMessage.arg1 = 12;
                            obtainMessage.what = 701;
                            t.c cVar = new t.c();
                            cVar.b = ax.this.b;
                            obtainMessage.obj = cVar;
                            cVar.a = ax.this.a(str, str2);
                            obtainMessage.arg2 = 1000;
                        } catch (AMapException e) {
                            obtainMessage.arg2 = e.getErrorCode();
                        }
                    } finally {
                        ax.this.f.sendMessage(obtainMessage);
                    }
                }
            });
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    @Override // com.amap.api.services.interfaces.ICloudSearch
    public final void setOnCloudSearchListener(CloudSearch.OnCloudSearchListener onCloudSearchListener) {
        this.b = onCloudSearchListener;
    }

    private boolean b(int i) {
        return i <= this.d && i > 0;
    }

    private static boolean b(CloudSearch.Query query) {
        if (query == null || i.a(query.getTableID()) || query.getBound() == null) {
            return false;
        }
        if (query.getBound() != null && query.getBound().getShape().equals("Bound") && query.getBound().getCenter() == null) {
            return false;
        }
        if (query.getBound() != null && query.getBound().getShape().equals("Rectangle")) {
            LatLonPoint lowerLeft = query.getBound().getLowerLeft();
            LatLonPoint upperRight = query.getBound().getUpperRight();
            if (lowerLeft == null || upperRight == null || lowerLeft.getLatitude() >= upperRight.getLatitude() || lowerLeft.getLongitude() >= upperRight.getLongitude()) {
                return false;
            }
        }
        if (query.getBound() == null || !query.getBound().getShape().equals("Polygon")) {
            return true;
        }
        List<LatLonPoint> polyGonList = query.getBound().getPolyGonList();
        for (int i = 0; i < polyGonList.size(); i++) {
            if (polyGonList.get(i) == null) {
                return false;
            }
        }
        return true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r1v13, types: [com.amap.api.services.cloud.CloudResult] */
    /* JADX WARN: Type inference failed for: r1v20 */
    /* JADX WARN: Type inference failed for: r1v21 */
    /* JADX WARN: Type inference failed for: r1v7, types: [int] */
    /* JADX WARN: Type inference failed for: r1v8 */
    public CloudResult a(CloudSearch.Query query) throws AMapException {
        CloudResult cloudResult = null;
        try {
        } catch (Throwable th) {
            th = th;
        }
        if (b(query)) {
            if (!query.queryEquals(this.c)) {
                this.d = 0;
                this.c = query.m223clone();
                HashMap<Integer, CloudResult> hashMap = this.e;
                if (hashMap != null) {
                    hashMap.clear();
                }
            }
            ?? r1 = this.d;
            try {
            } catch (Throwable th2) {
                th = th2;
                cloudResult = r1;
                i.a(th, "CloudSearch", "searchCloud");
                if (!(th instanceof AMapException)) {
                    th.printStackTrace();
                    return cloudResult;
                }
                throw th;
            }
            if (r1 == 0) {
                CloudResult b = new g(this.a, query).b();
                a(b, query);
                r1 = b;
            } else {
                cloudResult = a(query.getPageNum());
                if (cloudResult == null) {
                    CloudResult b2 = new g(this.a, query).b();
                    this.e.put(Integer.valueOf(query.getPageNum()), b2);
                    r1 = b2;
                }
                return cloudResult;
            }
            return r1;
        }
        throw new AMapException("无效的参数 - IllegalArgumentException");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public CloudItemDetail a(String str, String str2) throws AMapException {
        if (str != null && !str.trim().equals("")) {
            if (str2 != null && !str2.trim().equals("")) {
                try {
                    return new f(this.a, new ab(str, str2)).b();
                } catch (Throwable th) {
                    i.a(th, "CloudSearch", "searchCloudDetail");
                    if (!(th instanceof AMapException)) {
                        th.printStackTrace();
                        return null;
                    }
                    throw th;
                }
            }
            throw new AMapException("无效的参数 - IllegalArgumentException");
        }
        throw new AMapException("无效的参数 - IllegalArgumentException");
    }

    private void a(CloudResult cloudResult, CloudSearch.Query query) {
        HashMap<Integer, CloudResult> hashMap = new HashMap<>();
        this.e = hashMap;
        if (this.d > 0) {
            hashMap.put(Integer.valueOf(query.getPageNum()), cloudResult);
        }
    }

    private CloudResult a(int i) {
        if (b(i)) {
            return this.e.get(Integer.valueOf(i));
        }
        throw new IllegalArgumentException("page out of range");
    }
}
