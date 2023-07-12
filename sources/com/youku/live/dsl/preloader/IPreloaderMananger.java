package com.youku.live.dsl.preloader;

import android.content.Context;

/* compiled from: Taobao */
/* loaded from: classes12.dex */
public interface IPreloaderMananger {
    IPreloader createLivePlayControlPreloader(String str, String str2, Context context);

    boolean createPlayerPreloader();

    IPreloader getLivePlayControlPreloader(String str);
}
