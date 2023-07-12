package com.huawei.hms.adapter.sysobs;

import android.content.Intent;

/* compiled from: Taobao */
/* loaded from: classes10.dex */
public interface SystemObserver {
    boolean onNoticeResult(int i);

    boolean onSolutionResult(Intent intent, String str);

    boolean onUpdateResult(int i);
}
