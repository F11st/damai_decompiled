package com.amap.api.col.s;

import android.content.Context;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import com.amap.api.col.s.bt;
import com.amap.api.services.core.AMapException;
import com.amap.api.services.interfaces.IRouteSearchV2;
import com.amap.api.services.route.DriveRouteResultV2;
import com.amap.api.services.route.RouteSearchV2;

/* compiled from: Taobao */
/* loaded from: classes10.dex */
public final class bg implements IRouteSearchV2 {
    private RouteSearchV2.OnRouteSearchListener a;
    private Context b;
    private Handler c;

    public bg(Context context) throws AMapException {
        bu a = bt.a(context, h.a(false));
        if (a.a == bt.c.SuccessCode) {
            this.b = context.getApplicationContext();
            this.c = t.a();
            return;
        }
        String str = a.b;
        throw new AMapException(str, 1, str, a.a.a());
    }

    @Override // com.amap.api.services.interfaces.IRouteSearchV2
    public final DriveRouteResultV2 calculateDriveRoute(RouteSearchV2.DriveRouteQuery driveRouteQuery) throws AMapException {
        try {
            r.a(this.b);
            if (driveRouteQuery != null) {
                if (a(driveRouteQuery.getFromAndTo())) {
                    ah.a().a(driveRouteQuery.getPassedByPoints());
                    ah.a().b(driveRouteQuery.getAvoidpolygons());
                    RouteSearchV2.DriveRouteQuery m236clone = driveRouteQuery.m236clone();
                    DriveRouteResultV2 b = new n(this.b, m236clone).b();
                    if (b != null) {
                        b.setDriveQuery(m236clone);
                    }
                    return b;
                }
                throw new AMapException("无效的参数 - IllegalArgumentException");
            }
            throw new AMapException("无效的参数 - IllegalArgumentException");
        } catch (AMapException e) {
            i.a(e, "RouteSearch", "calculateDriveRoute");
            throw e;
        }
    }

    @Override // com.amap.api.services.interfaces.IRouteSearchV2
    public final void calculateDriveRouteAsyn(final RouteSearchV2.DriveRouteQuery driveRouteQuery) {
        try {
            ao.a().a(new Runnable() { // from class: com.amap.api.col.s.bg.1
                @Override // java.lang.Runnable
                public final void run() {
                    Message obtainMessage = t.a().obtainMessage();
                    obtainMessage.what = 101;
                    obtainMessage.arg1 = 101;
                    Bundle bundle = new Bundle();
                    DriveRouteResultV2 driveRouteResultV2 = null;
                    try {
                        try {
                            driveRouteResultV2 = bg.this.calculateDriveRoute(driveRouteQuery);
                            bundle.putInt("errorCode", 1000);
                        } catch (AMapException e) {
                            bundle.putInt("errorCode", e.getErrorCode());
                        }
                    } finally {
                        obtainMessage.obj = bg.this.a;
                        bundle.putParcelable("result", driveRouteResultV2);
                        obtainMessage.setData(bundle);
                        bg.this.c.sendMessage(obtainMessage);
                    }
                }
            });
        } catch (Throwable th) {
            i.a(th, "RouteSearch", "calculateDriveRouteAsyn");
        }
    }

    @Override // com.amap.api.services.interfaces.IRouteSearchV2
    public final void setRouteSearchListener(RouteSearchV2.OnRouteSearchListener onRouteSearchListener) {
        this.a = onRouteSearchListener;
    }

    private static boolean a(RouteSearchV2.FromAndTo fromAndTo) {
        return (fromAndTo == null || fromAndTo.getFrom() == null || fromAndTo.getTo() == null) ? false : true;
    }
}
