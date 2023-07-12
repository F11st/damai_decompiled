package com.alibaba.pictures.bricks.channel.bridge;

import android.content.Context;
import android.content.DialogInterface;
import android.view.View;
import cn.damai.commonbusiness.citycopy.net.CityListResponse;
import com.alibaba.pictures.bricks.channel.bean.LocationInfo;
import com.alibaba.pictures.bricks.channel.bean.NewLocationInfo;
import java.util.List;
import java.util.Map;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import tb.kc;

/* compiled from: Taobao */
/* loaded from: classes7.dex */
public interface ComponentFilterBridge {
    @NotNull
    String getApiName();

    @NotNull
    String getApiVersion();

    @NotNull
    String getCityId();

    @NotNull
    String getCityName();

    @NotNull
    String getComboChannel();

    @Nullable
    Double[] getDMCoordinates();

    @Nullable
    CityListResponse getLocalCityList();

    @Nullable
    String getSpValue(@NotNull String str);

    @NotNull
    String getTtid();

    @Nullable
    String getUserCode();

    void reportClick(@NotNull kc.b bVar);

    void reportExposureSingleCustomEvent(@Nullable String str, @Nullable String str2, @Nullable String str3, @Nullable String str4, long j, @Nullable Map<String, String> map, int i);

    void requestCityList(@NotNull OnBizListener<CityListResponse> onBizListener);

    void saveLocationInfo(@NotNull LocationInfo locationInfo);

    void saveSpValue(@NotNull String str, @Nullable String str2);

    void setExposureTag(@Nullable View view, @Nullable String str, @NotNull String str2, @NotNull String str3, @Nullable Map<String, String> map);

    void setNewLocationData(@NotNull NewLocationInfo newLocationInfo);

    void showPermissionDialog(@NotNull Context context, @NotNull String str, @Nullable List<String> list, boolean z, @Nullable DialogInterface.OnClickListener onClickListener, @Nullable DialogInterface.OnClickListener onClickListener2);
}
