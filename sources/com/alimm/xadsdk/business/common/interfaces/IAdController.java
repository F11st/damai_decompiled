package com.alimm.xadsdk.business.common.interfaces;

import androidx.annotation.NonNull;
import com.alimm.xadsdk.business.common.model.AdInfo;
import java.util.Map;

/* compiled from: Taobao */
/* loaded from: classes12.dex */
public interface IAdController {
    void dispose();

    void getAdAsync(Map<String, String> map, @NonNull Callback callback);

    AdInfo getAdSync();

    void onAdClick(@NonNull String str);

    void onAdError(@NonNull String str, int i, String str2);

    void onAdFinish(@NonNull String str);

    void onAdInteractionClick(@NonNull String str);

    void onAdInteractionEnd(@NonNull String str);

    void onAdInteractionStart(@NonNull String str);

    void onAdSkip(@NonNull String str);

    void onAdStart(@NonNull String str);
}
