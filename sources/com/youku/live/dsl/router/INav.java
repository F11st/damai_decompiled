package com.youku.live.dsl.router;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;

/* compiled from: Taobao */
/* loaded from: classes12.dex */
public interface INav {
    INav from(Context context);

    boolean toUri(Uri uri);

    boolean toUri(String str);

    INav withCategory(String str);

    INav withExtras(Bundle bundle);

    INav withFlags(int i);
}
