package com.taobao.android.dinamicx.videoc.expose.core;

import androidx.annotation.NonNull;
import java.util.Collection;
import java.util.List;

/* compiled from: Taobao */
/* loaded from: classes12.dex */
public interface IExposureZoneRunner<ExposeKey, ExposeData> {
    void clear();

    <ZoneType extends IExposureZone<ExposeKey, ExposeData>> ZoneType findZoneBySceneName(@NonNull Class<ZoneType> cls, @NonNull String str);

    IExposureZone<ExposeKey, ExposeData> findZoneBySceneName(@NonNull String str);

    <ZoneType extends IExposureZone<ExposeKey, ExposeData>> List<ZoneType> findZonesBySceneName(@NonNull Class<ZoneType> cls, @NonNull String str);

    List<IExposureZone<ExposeKey, ExposeData>> findZonesBySceneName(@NonNull String str);

    void registerExposureZone(@NonNull IExposureZone<ExposeKey, ExposeData> iExposureZone);

    void runZone();

    void runZone(@NonNull IExposureZone<ExposeKey, ExposeData> iExposureZone);

    void runZone(@NonNull String str);

    void stopZone();

    void stopZone(@NonNull IExposureZone<ExposeKey, ExposeData> iExposureZone);

    void stopZone(@NonNull String str);

    void unregisterExposureZone(@NonNull IExposureZone<ExposeKey, ExposeData> iExposureZone);

    Collection<IExposureZone<ExposeKey, ExposeData>> zones();
}
