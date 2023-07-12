package com.alibaba.pictures.piclocation.listener;

import com.amap.api.location.AMapLocation;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;

/* compiled from: Taobao */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\bf\u0018\u00002\u00020\u0001J\u0018\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H&¨\u0006\b"}, d2 = {"Lcom/alibaba/pictures/piclocation/listener/GetLocationInfoInterface;", "", "Lcom/amap/api/location/AMapLocation;", "aMapLocation", "", "getTime", "Ltb/wt2;", "getLocationInfoSuccess", "location_release"}, k = 1, mv = {1, 4, 2})
/* loaded from: classes7.dex */
public interface GetLocationInfoInterface {
    void getLocationInfoSuccess(@NotNull AMapLocation aMapLocation, long j);
}
