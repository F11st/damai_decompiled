package com.amap.api.col.s;

import android.content.Context;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import com.amap.api.col.s.HandlerC4447t;
import com.amap.api.col.s.bt;
import com.amap.api.services.core.AMapException;
import com.amap.api.services.core.LatLonPoint;
import com.amap.api.services.core.PoiItem;
import com.amap.api.services.interfaces.IPoiSearch;
import com.amap.api.services.poisearch.PoiResult;
import com.amap.api.services.poisearch.PoiSearch;
import java.util.HashMap;
import java.util.List;

/* compiled from: Taobao */
/* loaded from: classes10.dex */
public final class bd implements IPoiSearch {
    private static HashMap<Integer, PoiResult> i;
    private PoiSearch.SearchBound a;
    private PoiSearch.Query b;
    private Context c;
    private PoiSearch.OnPoiSearchListener d;
    private String e = "zh-CN";
    private PoiSearch.Query f;
    private PoiSearch.SearchBound g;
    private int h;
    private Handler j;

    public bd(Context context, PoiSearch.Query query) throws AMapException {
        this.j = null;
        bu a = bt.a(context, C4434h.a(false));
        if (a.a == bt.EnumC4398c.SuccessCode) {
            this.c = context.getApplicationContext();
            setQuery(query);
            this.j = HandlerC4447t.a();
            return;
        }
        String str = a.b;
        throw new AMapException(str, 1, str, a.a.a());
    }

    private boolean c() {
        PoiSearch.SearchBound bound = getBound();
        if (bound != null) {
            if (bound.getShape().equals("Bound")) {
                return bound.getCenter() != null;
            } else if (bound.getShape().equals("Polygon")) {
                List<LatLonPoint> polyGonList = bound.getPolyGonList();
                if (polyGonList == null || polyGonList.size() == 0) {
                    return false;
                }
                for (int i2 = 0; i2 < polyGonList.size(); i2++) {
                    if (polyGonList.get(i2) == null) {
                        return false;
                    }
                }
                return true;
            } else if (bound.getShape().equals("Rectangle")) {
                LatLonPoint lowerLeft = bound.getLowerLeft();
                LatLonPoint upperRight = bound.getUpperRight();
                return lowerLeft != null && upperRight != null && lowerLeft.getLatitude() < upperRight.getLatitude() && lowerLeft.getLongitude() < upperRight.getLongitude();
            } else {
                return true;
            }
        }
        return true;
    }

    @Override // com.amap.api.services.interfaces.IPoiSearch
    public final PoiSearch.SearchBound getBound() {
        return this.a;
    }

    @Override // com.amap.api.services.interfaces.IPoiSearch
    public final String getLanguage() {
        return this.e;
    }

    @Override // com.amap.api.services.interfaces.IPoiSearch
    public final PoiSearch.Query getQuery() {
        return this.b;
    }

    @Override // com.amap.api.services.interfaces.IPoiSearch
    public final PoiResult searchPOI() throws AMapException {
        try {
            C4444r.a(this.c);
            if (!b() && !a()) {
                throw new AMapException("无效的参数 - IllegalArgumentException");
            }
            if (c()) {
                PoiSearch.Query query = this.b;
                if (query != null) {
                    if ((!query.queryEquals(this.f) && this.a == null) || (!this.b.queryEquals(this.f) && !this.a.equals(this.g))) {
                        this.h = 0;
                        this.f = this.b.m226clone();
                        PoiSearch.SearchBound searchBound = this.a;
                        if (searchBound != null) {
                            this.g = searchBound.m227clone();
                        }
                        HashMap<Integer, PoiResult> hashMap = i;
                        if (hashMap != null) {
                            hashMap.clear();
                        }
                    }
                    PoiSearch.SearchBound searchBound2 = this.a;
                    PoiSearch.SearchBound m227clone = searchBound2 != null ? searchBound2.m227clone() : null;
                    ah.a().a(this.b.getQueryString());
                    this.b.setPageNum(ah.a().k(this.b.getPageNum()));
                    this.b.setPageSize(ah.a().l(this.b.getPageSize()));
                    if (this.h == 0) {
                        PoiResult b = new C4465z(this.c, new ac(this.b.m226clone(), m227clone)).b();
                        a(b);
                        return b;
                    }
                    PoiResult a = a(this.b.getPageNum());
                    if (a == null) {
                        PoiResult b2 = new C4465z(this.c, new ac(this.b.m226clone(), m227clone)).b();
                        i.put(Integer.valueOf(this.b.getPageNum()), b2);
                        return b2;
                    }
                    return a;
                }
                throw new AMapException("无效的参数 - IllegalArgumentException");
            }
            throw new AMapException("无效的参数 - IllegalArgumentException");
        } catch (AMapException e) {
            C4435i.a(e, "PoiSearch", "searchPOI");
            throw new AMapException(e.getErrorMessage());
        }
    }

    @Override // com.amap.api.services.interfaces.IPoiSearch
    public final void searchPOIAsyn() {
        try {
            ao.a().a(new Runnable() { // from class: com.amap.api.col.s.bd.1
                @Override // java.lang.Runnable
                public final void run() {
                    HandlerC4447t.C4455h c4455h;
                    Message obtainMessage = bd.this.j.obtainMessage();
                    obtainMessage.arg1 = 6;
                    obtainMessage.what = 600;
                    Bundle bundle = new Bundle();
                    PoiResult poiResult = null;
                    try {
                        try {
                            poiResult = bd.this.searchPOI();
                            bundle.putInt("errorCode", 1000);
                            c4455h = new HandlerC4447t.C4455h();
                        } catch (AMapException e) {
                            bundle.putInt("errorCode", e.getErrorCode());
                            c4455h = new HandlerC4447t.C4455h();
                        }
                        c4455h.b = bd.this.d;
                        c4455h.a = poiResult;
                        obtainMessage.obj = c4455h;
                        obtainMessage.setData(bundle);
                        bd.this.j.sendMessage(obtainMessage);
                    } catch (Throwable th) {
                        HandlerC4447t.C4455h c4455h2 = new HandlerC4447t.C4455h();
                        c4455h2.b = bd.this.d;
                        c4455h2.a = poiResult;
                        obtainMessage.obj = c4455h2;
                        obtainMessage.setData(bundle);
                        bd.this.j.sendMessage(obtainMessage);
                        throw th;
                    }
                }
            });
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    @Override // com.amap.api.services.interfaces.IPoiSearch
    public final PoiItem searchPOIId(String str) throws AMapException {
        C4444r.a(this.c);
        PoiSearch.Query query = this.b;
        return new C4464y(this.c, str, query != null ? query.m226clone() : null).b();
    }

    @Override // com.amap.api.services.interfaces.IPoiSearch
    public final void searchPOIIdAsyn(final String str) {
        ao.a().a(new Runnable() { // from class: com.amap.api.col.s.bd.2
            @Override // java.lang.Runnable
            public final void run() {
                HandlerC4447t.C4454g c4454g;
                Message obtainMessage = HandlerC4447t.a().obtainMessage();
                obtainMessage.arg1 = 6;
                obtainMessage.what = 602;
                Bundle bundle = new Bundle();
                PoiItem poiItem = null;
                try {
                    try {
                        poiItem = bd.this.searchPOIId(str);
                        bundle.putInt("errorCode", 1000);
                        c4454g = new HandlerC4447t.C4454g();
                    } catch (AMapException e) {
                        C4435i.a(e, "PoiSearch", "searchPOIIdAsyn");
                        bundle.putInt("errorCode", e.getErrorCode());
                        c4454g = new HandlerC4447t.C4454g();
                    }
                    c4454g.b = bd.this.d;
                    c4454g.a = poiItem;
                    obtainMessage.obj = c4454g;
                    obtainMessage.setData(bundle);
                    bd.this.j.sendMessage(obtainMessage);
                } catch (Throwable th) {
                    HandlerC4447t.C4454g c4454g2 = new HandlerC4447t.C4454g();
                    c4454g2.b = bd.this.d;
                    c4454g2.a = poiItem;
                    obtainMessage.obj = c4454g2;
                    obtainMessage.setData(bundle);
                    bd.this.j.sendMessage(obtainMessage);
                    throw th;
                }
            }
        });
    }

    @Override // com.amap.api.services.interfaces.IPoiSearch
    public final void setBound(PoiSearch.SearchBound searchBound) {
        this.a = searchBound;
    }

    @Override // com.amap.api.services.interfaces.IPoiSearch
    public final void setLanguage(String str) {
        if ("en".equals(str)) {
            this.e = "en";
        } else {
            this.e = "zh-CN";
        }
    }

    @Override // com.amap.api.services.interfaces.IPoiSearch
    public final void setOnPoiSearchListener(PoiSearch.OnPoiSearchListener onPoiSearchListener) {
        this.d = onPoiSearchListener;
    }

    @Override // com.amap.api.services.interfaces.IPoiSearch
    public final void setQuery(PoiSearch.Query query) {
        this.b = query;
    }

    private boolean a() {
        PoiSearch.Query query = this.b;
        if (query == null) {
            return false;
        }
        return (C4435i.a(query.getQueryString()) && C4435i.a(this.b.getCategory())) ? false : true;
    }

    private boolean b() {
        PoiSearch.SearchBound bound = getBound();
        return bound != null && bound.getShape().equals("Bound");
    }

    private boolean b(int i2) {
        return i2 <= this.h && i2 >= 0;
    }

    private void a(PoiResult poiResult) {
        int i2;
        i = new HashMap<>();
        PoiSearch.Query query = this.b;
        if (query == null || poiResult == null || (i2 = this.h) <= 0 || i2 <= query.getPageNum()) {
            return;
        }
        i.put(Integer.valueOf(this.b.getPageNum()), poiResult);
    }

    private PoiResult a(int i2) {
        if (b(i2)) {
            return i.get(Integer.valueOf(i2));
        }
        throw new IllegalArgumentException("page out of range");
    }
}
