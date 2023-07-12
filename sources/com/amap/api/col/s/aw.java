package com.amap.api.col.s;

import android.content.Context;
import android.os.Handler;
import android.os.Message;
import com.amap.api.col.s.HandlerC4447t;
import com.amap.api.col.s.bt;
import com.amap.api.services.busline.BusStationQuery;
import com.amap.api.services.busline.BusStationResult;
import com.amap.api.services.busline.BusStationSearch;
import com.amap.api.services.core.AMapException;
import com.amap.api.services.interfaces.IBusStationSearch;
import java.util.ArrayList;

/* compiled from: Taobao */
/* loaded from: classes10.dex */
public final class aw implements IBusStationSearch {
    private Context a;
    private BusStationSearch.OnBusStationSearchListener b;
    private BusStationQuery c;
    private BusStationQuery d;
    private ArrayList<BusStationResult> e = new ArrayList<>();
    private int f;
    private Handler g;

    public aw(Context context, BusStationQuery busStationQuery) throws AMapException {
        bu a = bt.a(context, C4434h.a(false));
        if (a.a == bt.EnumC4398c.SuccessCode) {
            this.a = context.getApplicationContext();
            this.c = busStationQuery;
            this.g = HandlerC4447t.a();
            return;
        }
        String str = a.b;
        throw new AMapException(str, 1, str, a.a.a());
    }

    @Override // com.amap.api.services.interfaces.IBusStationSearch
    public final BusStationQuery getQuery() {
        return this.c;
    }

    @Override // com.amap.api.services.interfaces.IBusStationSearch
    public final BusStationResult searchBusStation() throws AMapException {
        try {
            C4444r.a(this.a);
            if (a()) {
                if (!this.c.weakEquals(this.d)) {
                    this.d = this.c.m222clone();
                    this.f = 0;
                    ArrayList<BusStationResult> arrayList = this.e;
                    if (arrayList != null) {
                        arrayList.clear();
                    }
                }
                if (this.f == 0) {
                    BusStationResult busStationResult = (BusStationResult) new C4410d(this.a, this.c).b();
                    this.f = busStationResult.getPageCount();
                    a(busStationResult);
                    return busStationResult;
                }
                BusStationResult b = b(this.c.getPageNumber());
                if (b == null) {
                    BusStationResult busStationResult2 = (BusStationResult) new C4410d(this.a, this.c).b();
                    this.e.set(this.c.getPageNumber(), busStationResult2);
                    return busStationResult2;
                }
                return b;
            }
            throw new AMapException("无效的参数 - IllegalArgumentException");
        } catch (AMapException e) {
            C4435i.a(e, "BusStationSearch", "searchBusStation");
            throw new AMapException(e.getErrorMessage());
        } catch (Throwable th) {
            C4435i.a(th, "BusStationSearch", "searchBusStation");
            return null;
        }
    }

    @Override // com.amap.api.services.interfaces.IBusStationSearch
    public final void searchBusStationAsyn() {
        try {
            ao.a().a(new Runnable() { // from class: com.amap.api.col.s.aw.1
                @Override // java.lang.Runnable
                public final void run() {
                    Message obtainMessage = HandlerC4447t.a().obtainMessage();
                    try {
                        try {
                            obtainMessage.arg1 = 7;
                            HandlerC4447t.C4449b c4449b = new HandlerC4447t.C4449b();
                            c4449b.b = aw.this.b;
                            obtainMessage.obj = c4449b;
                            BusStationResult searchBusStation = aw.this.searchBusStation();
                            obtainMessage.what = 1000;
                            c4449b.a = searchBusStation;
                        } catch (AMapException e) {
                            obtainMessage.what = e.getErrorCode();
                        }
                    } finally {
                        aw.this.g.sendMessage(obtainMessage);
                    }
                }
            });
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    @Override // com.amap.api.services.interfaces.IBusStationSearch
    public final void setOnBusStationSearchListener(BusStationSearch.OnBusStationSearchListener onBusStationSearchListener) {
        this.b = onBusStationSearchListener;
    }

    @Override // com.amap.api.services.interfaces.IBusStationSearch
    public final void setQuery(BusStationQuery busStationQuery) {
        if (busStationQuery.weakEquals(this.c)) {
            return;
        }
        this.c = busStationQuery;
    }

    private void a(BusStationResult busStationResult) {
        int i;
        this.e = new ArrayList<>();
        int i2 = 0;
        while (true) {
            i = this.f;
            if (i2 > i) {
                break;
            }
            this.e.add(null);
            i2++;
        }
        if (i > 0) {
            this.e.set(this.c.getPageNumber(), busStationResult);
        }
    }

    private BusStationResult b(int i) {
        if (a(i)) {
            return this.e.get(i);
        }
        throw new IllegalArgumentException("page out of range");
    }

    private boolean a(int i) {
        return i <= this.f && i >= 0;
    }

    private boolean a() {
        BusStationQuery busStationQuery = this.c;
        return (busStationQuery == null || C4435i.a(busStationQuery.getQueryString())) ? false : true;
    }
}
