package com.amap.api.col.s;

import android.content.Context;
import android.os.Handler;
import android.os.Message;
import com.amap.api.col.s.HandlerC4447t;
import com.amap.api.col.s.bt;
import com.amap.api.services.busline.BusLineQuery;
import com.amap.api.services.busline.BusLineResult;
import com.amap.api.services.busline.BusLineSearch;
import com.amap.api.services.core.AMapException;
import com.amap.api.services.interfaces.IBusLineSearch;
import java.util.ArrayList;

/* compiled from: Taobao */
/* loaded from: classes10.dex */
public final class av implements IBusLineSearch {
    private Context a;
    private BusLineSearch.OnBusLineSearchListener b;
    private BusLineQuery c;
    private BusLineQuery d;
    private int e;
    private ArrayList<BusLineResult> f = new ArrayList<>();
    private Handler g;

    public av(Context context, BusLineQuery busLineQuery) throws AMapException {
        this.g = null;
        bu a = bt.a(context, C4434h.a(false));
        if (a.a == bt.EnumC4398c.SuccessCode) {
            this.a = context.getApplicationContext();
            this.c = busLineQuery;
            if (busLineQuery != null) {
                this.d = busLineQuery.m221clone();
            }
            this.g = HandlerC4447t.a();
            return;
        }
        String str = a.b;
        throw new AMapException(str, 1, str, a.a.a());
    }

    @Override // com.amap.api.services.interfaces.IBusLineSearch
    public final BusLineQuery getQuery() {
        return this.c;
    }

    @Override // com.amap.api.services.interfaces.IBusLineSearch
    public final BusLineResult searchBusLine() throws AMapException {
        try {
            C4444r.a(this.a);
            if (this.d != null && a()) {
                if (!this.c.weakEquals(this.d)) {
                    this.d = this.c.m221clone();
                    this.e = 0;
                    ArrayList<BusLineResult> arrayList = this.f;
                    if (arrayList != null) {
                        arrayList.clear();
                    }
                }
                if (this.e == 0) {
                    BusLineResult busLineResult = (BusLineResult) new C4410d(this.a, this.c.m221clone()).b();
                    a(busLineResult);
                    return busLineResult;
                }
                BusLineResult b = b(this.c.getPageNumber());
                if (b == null) {
                    BusLineResult busLineResult2 = (BusLineResult) new C4410d(this.a, this.c).b();
                    this.f.set(this.c.getPageNumber(), busLineResult2);
                    return busLineResult2;
                }
                return b;
            }
            throw new AMapException("无效的参数 - IllegalArgumentException");
        } catch (AMapException e) {
            C4435i.a(e, "BusLineSearch", "searchBusLine");
            throw new AMapException(e.getErrorMessage());
        }
    }

    @Override // com.amap.api.services.interfaces.IBusLineSearch
    public final void searchBusLineAsyn() {
        try {
            ao.a().a(new Runnable() { // from class: com.amap.api.col.s.av.1
                @Override // java.lang.Runnable
                public final void run() {
                    Message obtainMessage = HandlerC4447t.a().obtainMessage();
                    try {
                        try {
                            obtainMessage.arg1 = 3;
                            obtainMessage.what = 1000;
                            HandlerC4447t.C4448a c4448a = new HandlerC4447t.C4448a();
                            obtainMessage.obj = c4448a;
                            c4448a.b = av.this.b;
                            c4448a.a = av.this.searchBusLine();
                        } catch (AMapException e) {
                            obtainMessage.what = e.getErrorCode();
                        }
                    } finally {
                        av.this.g.sendMessage(obtainMessage);
                    }
                }
            });
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    @Override // com.amap.api.services.interfaces.IBusLineSearch
    public final void setOnBusLineSearchListener(BusLineSearch.OnBusLineSearchListener onBusLineSearchListener) {
        this.b = onBusLineSearchListener;
    }

    @Override // com.amap.api.services.interfaces.IBusLineSearch
    public final void setQuery(BusLineQuery busLineQuery) {
        if (this.c.weakEquals(busLineQuery)) {
            return;
        }
        this.c = busLineQuery;
        this.d = busLineQuery.m221clone();
    }

    private void a(BusLineResult busLineResult) {
        int i;
        this.f = new ArrayList<>();
        int i2 = 0;
        while (true) {
            i = this.e;
            if (i2 >= i) {
                break;
            }
            this.f.add(null);
            i2++;
        }
        if (i < 0 || !a(this.c.getPageNumber())) {
            return;
        }
        this.f.set(this.c.getPageNumber(), busLineResult);
    }

    private BusLineResult b(int i) {
        if (a(i)) {
            return this.f.get(i);
        }
        throw new IllegalArgumentException("page out of range");
    }

    private boolean a(int i) {
        return i < this.e && i >= 0;
    }

    private boolean a() {
        BusLineQuery busLineQuery = this.c;
        return (busLineQuery == null || C4435i.a(busLineQuery.getQueryString())) ? false : true;
    }
}
