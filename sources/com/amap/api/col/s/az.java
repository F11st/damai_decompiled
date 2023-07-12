package com.amap.api.col.s;

import android.content.Context;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import com.amap.api.col.s.bt;
import com.amap.api.services.core.AMapException;
import com.amap.api.services.district.DistrictResult;
import com.amap.api.services.district.DistrictSearch;
import com.amap.api.services.district.DistrictSearchQuery;
import com.amap.api.services.interfaces.IDistrictSearch;
import java.util.HashMap;

/* compiled from: Taobao */
/* loaded from: classes10.dex */
public final class az implements IDistrictSearch {
    private static HashMap<Integer, DistrictResult> f;
    private Context a;
    private DistrictSearchQuery b;
    private DistrictSearch.OnDistrictSearchListener c;
    private DistrictSearchQuery d;
    private int e;
    private Handler g;

    public az(Context context) throws AMapException {
        bu a = bt.a(context, h.a(false));
        if (a.a == bt.c.SuccessCode) {
            this.a = context.getApplicationContext();
            this.g = t.a();
            return;
        }
        String str = a.b;
        throw new AMapException(str, 1, str, a.a.a());
    }

    @Override // com.amap.api.services.interfaces.IDistrictSearch
    public final DistrictSearchQuery getQuery() {
        return this.b;
    }

    @Override // com.amap.api.services.interfaces.IDistrictSearch
    public final DistrictResult searchDistrict() throws AMapException {
        DistrictResult a;
        int i;
        try {
            DistrictResult districtResult = new DistrictResult();
            r.a(this.a);
            if (!a()) {
                this.b = new DistrictSearchQuery();
            }
            districtResult.setQuery(this.b.m225clone());
            if (!this.b.weakEquals(this.d)) {
                this.e = 0;
                this.d = this.b.m225clone();
                HashMap<Integer, DistrictResult> hashMap = f;
                if (hashMap != null) {
                    hashMap.clear();
                }
            }
            if (this.e == 0) {
                a = new k(this.a, this.b.m225clone()).b();
                if (a == null) {
                    return a;
                }
                this.e = a.getPageCount();
                a(a);
            } else {
                a = a(this.b.getPageNum());
                if (a == null) {
                    a = new k(this.a, this.b.m225clone()).b();
                    DistrictSearchQuery districtSearchQuery = this.b;
                    if (districtSearchQuery != null && a != null && (i = this.e) > 0 && i > districtSearchQuery.getPageNum()) {
                        f.put(Integer.valueOf(this.b.getPageNum()), a);
                    }
                }
            }
            return a;
        } catch (AMapException e) {
            i.a(e, "DistrictSearch", "searchDistrict");
            throw e;
        }
    }

    @Override // com.amap.api.services.interfaces.IDistrictSearch
    public final void searchDistrictAnsy() {
        searchDistrictAsyn();
    }

    @Override // com.amap.api.services.interfaces.IDistrictSearch
    public final void searchDistrictAsyn() {
        try {
            ao.a().a(new Runnable() { // from class: com.amap.api.col.s.az.1
                @Override // java.lang.Runnable
                public final void run() {
                    Message obtainMessage = t.a().obtainMessage();
                    DistrictResult districtResult = new DistrictResult();
                    districtResult.setQuery(az.this.b);
                    try {
                        try {
                            districtResult = az.this.searchDistrict();
                            if (districtResult != null) {
                                districtResult.setAMapException(new AMapException());
                            }
                        } catch (AMapException e) {
                            districtResult.setAMapException(e);
                            obtainMessage.arg1 = 4;
                            obtainMessage.obj = az.this.c;
                            Bundle bundle = new Bundle();
                            bundle.putParcelable("result", districtResult);
                            obtainMessage.setData(bundle);
                            if (az.this.g != null) {
                                az.this.g.sendMessage(obtainMessage);
                            }
                        } catch (Throwable th) {
                            i.a(th, "DistrictSearch", "searchDistrictAnsyThrowable");
                            obtainMessage.arg1 = 4;
                            obtainMessage.obj = az.this.c;
                            Bundle bundle2 = new Bundle();
                            bundle2.putParcelable("result", districtResult);
                            obtainMessage.setData(bundle2);
                            if (az.this.g != null) {
                                az.this.g.sendMessage(obtainMessage);
                            }
                        }
                    } finally {
                        obtainMessage.arg1 = 4;
                        obtainMessage.obj = az.this.c;
                        Bundle bundle3 = new Bundle();
                        bundle3.putParcelable("result", districtResult);
                        obtainMessage.setData(bundle3);
                        if (az.this.g != null) {
                            az.this.g.sendMessage(obtainMessage);
                        }
                    }
                }
            });
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    @Override // com.amap.api.services.interfaces.IDistrictSearch
    public final void setOnDistrictSearchListener(DistrictSearch.OnDistrictSearchListener onDistrictSearchListener) {
        this.c = onDistrictSearchListener;
    }

    @Override // com.amap.api.services.interfaces.IDistrictSearch
    public final void setQuery(DistrictSearchQuery districtSearchQuery) {
        this.b = districtSearchQuery;
    }

    private void a(DistrictResult districtResult) {
        int i;
        f = new HashMap<>();
        DistrictSearchQuery districtSearchQuery = this.b;
        if (districtSearchQuery == null || districtResult == null || (i = this.e) <= 0 || i <= districtSearchQuery.getPageNum()) {
            return;
        }
        f.put(Integer.valueOf(this.b.getPageNum()), districtResult);
    }

    private boolean b(int i) {
        return i < this.e && i >= 0;
    }

    private boolean a() {
        return this.b != null;
    }

    private DistrictResult a(int i) throws AMapException {
        if (b(i)) {
            return f.get(Integer.valueOf(i));
        }
        throw new AMapException("无效的参数 - IllegalArgumentException");
    }
}
