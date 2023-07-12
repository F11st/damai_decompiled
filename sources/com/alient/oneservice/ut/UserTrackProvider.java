package com.alient.oneservice.ut;

import android.view.View;
import java.util.Map;

/* compiled from: Taobao */
/* loaded from: classes12.dex */
public interface UserTrackProvider {
    void click(View view, TrackInfo trackInfo);

    void click(View view, TrackInfo trackInfo, boolean z);

    void click(TrackInfo trackInfo);

    void click(TrackInfo trackInfo, boolean z);

    void expose(View view, TrackInfo trackInfo);

    void expose(View view, String str, TrackInfo trackInfo);

    void expose(String str, TrackInfo trackInfo);

    void reportCustom(Map<String, String> map, String str, String str2);

    void reportOriginalCustomEvent(String str, String str2, String str3, String str4, String str5, Map<String, String> map);
}
