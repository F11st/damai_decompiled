package org.android.netutil;

import androidx.annotation.Keep;

/* compiled from: Taobao */
@Keep
/* loaded from: classes2.dex */
public abstract class AsyncTask {
    protected boolean done;

    protected void onTaskFinish() {
        this.done = true;
    }
}
