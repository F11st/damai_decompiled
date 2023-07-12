package com.amap.api.col.s;

import android.content.Context;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import com.amap.api.col.s.bt;
import com.amap.api.services.core.AMapException;
import com.amap.api.services.interfaces.IDistanceSearch;
import com.amap.api.services.route.DistanceResult;
import com.amap.api.services.route.DistanceSearch;

/* compiled from: Taobao */
/* loaded from: classes10.dex */
public class ay implements IDistanceSearch {
    private static final String a = "ay";
    private Context b;
    private Handler c;
    private DistanceSearch.OnDistanceSearchListener d;

    public ay(Context context) throws AMapException {
        bu a2 = bt.a(context, h.a(false));
        if (a2.a == bt.c.SuccessCode) {
            this.b = context.getApplicationContext();
            this.c = t.a();
            return;
        }
        String str = a2.b;
        throw new AMapException(str, 1, str, a2.a.a());
    }

    @Override // com.amap.api.services.interfaces.IDistanceSearch
    public DistanceResult calculateRouteDistance(DistanceSearch.DistanceQuery distanceQuery) throws AMapException {
        try {
            r.a(this.b);
            if (distanceQuery != null) {
                if (!a(distanceQuery)) {
                    DistanceSearch.DistanceQuery m228clone = distanceQuery.m228clone();
                    DistanceResult b = new j(this.b, m228clone).b();
                    if (b != null) {
                        b.setDistanceQuery(m228clone);
                    }
                    return b;
                }
                throw new AMapException("无效的参数 - IllegalArgumentException");
            }
            throw new AMapException("无效的参数 - IllegalArgumentException");
        } catch (AMapException e) {
            i.a(e, a, "calculateWalkRoute");
            throw e;
        }
    }

    @Override // com.amap.api.services.interfaces.IDistanceSearch
    public void calculateRouteDistanceAsyn(final DistanceSearch.DistanceQuery distanceQuery) {
        ao.a().a(new Runnable() { // from class: com.amap.api.col.s.ay.1
            @Override // java.lang.Runnable
            public final void run() {
                Message obtainMessage = t.a().obtainMessage();
                obtainMessage.what = 400;
                obtainMessage.arg1 = 16;
                Bundle bundle = new Bundle();
                DistanceResult distanceResult = null;
                try {
                    try {
                        distanceResult = ay.this.calculateRouteDistance(distanceQuery);
                        bundle.putInt("errorCode", 1000);
                    } catch (AMapException e) {
                        bundle.putInt("errorCode", e.getErrorCode());
                    }
                } finally {
                    obtainMessage.obj = ay.this.d;
                    bundle.putParcelable("result", distanceResult);
                    obtainMessage.setData(bundle);
                    ay.this.c.sendMessage(obtainMessage);
                }
            }
        });
    }

    @Override // com.amap.api.services.interfaces.IDistanceSearch
    public void setDistanceSearchListener(DistanceSearch.OnDistanceSearchListener onDistanceSearchListener) {
        this.d = onDistanceSearchListener;
    }

    private static boolean a(DistanceSearch.DistanceQuery distanceQuery) {
        return distanceQuery.getDestination() == null || distanceQuery.getOrigins() == null || distanceQuery.getOrigins().size() <= 0;
    }
}
