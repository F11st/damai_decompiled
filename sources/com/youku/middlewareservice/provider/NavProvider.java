package com.youku.middlewareservice.provider;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;

/* compiled from: Taobao */
/* loaded from: classes13.dex */
public interface NavProvider {
    void toUri(Context context, Uri uri);

    void toUri(Context context, Uri uri, Bundle bundle);

    void toUri(Context context, String str);

    void toUri(Context context, String str, Bundle bundle);
}
