package com.youku.live.dsl.network;

import android.app.Activity;

/* compiled from: Taobao */
/* loaded from: classes12.dex */
public interface INetRequest {
    INetRequest async(Activity activity, INetCallback iNetCallback);

    INetRequest async(Activity activity, INetCallback iNetCallback, INetError iNetError);

    INetRequest async(INetCallback iNetCallback);

    INetRequest async(INetCallback iNetCallback, INetError iNetError);

    INetRequest async2(Activity activity, INetCallback iNetCallback);

    INetRequest async2(Activity activity, INetCallback iNetCallback, INetError iNetError);

    INetRequest async2(INetCallback iNetCallback);

    INetRequest async2(INetCallback iNetCallback, INetError iNetError);

    INetRequest sync(Activity activity, INetCallback iNetCallback);

    INetRequest sync(Activity activity, INetCallback iNetCallback, INetError iNetError);

    INetRequest sync(INetCallback iNetCallback);

    INetRequest sync(INetCallback iNetCallback, INetError iNetError);
}
