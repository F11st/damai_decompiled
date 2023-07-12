package com.youku.live.widgets.protocol.activity;

import android.content.Intent;
import android.os.Bundle;

/* compiled from: Taobao */
/* loaded from: classes13.dex */
public interface IActivityCreateStateChangedListener {
    void onActivityCreate(Bundle bundle);

    void onActivityDestroy();

    void onActivityNewIntent(Intent intent);
}
