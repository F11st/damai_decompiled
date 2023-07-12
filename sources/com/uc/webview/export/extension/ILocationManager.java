package com.uc.webview.export.extension;

import android.location.LocationListener;
import com.uc.webview.export.annotations.Api;

/* compiled from: Taobao */
@Api
/* loaded from: classes11.dex */
public interface ILocationManager {
    void removeUpdates(LocationListener locationListener);

    void requestLocationUpdates(String str, long j, float f, LocationListener locationListener);

    void requestLocationUpdatesWithUrl(String str, long j, float f, LocationListener locationListener, String str2);
}
