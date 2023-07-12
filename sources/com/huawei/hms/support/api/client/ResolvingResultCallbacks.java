package com.huawei.hms.support.api.client;

import android.app.Activity;
import com.huawei.hms.common.internal.Preconditions;
import com.huawei.hms.support.api.client.Result;
import com.huawei.hms.support.log.HMSLog;

/* compiled from: Taobao */
@Deprecated
/* loaded from: classes10.dex */
public abstract class ResolvingResultCallbacks<R extends Result> extends ResultCallbacks<R> {
    private final Activity a;
    private final int b;

    protected ResolvingResultCallbacks(Activity activity, int i) {
        this.a = (Activity) Preconditions.checkNotNull(activity, "Activity must not be null");
        this.b = i;
    }

    @Override // com.huawei.hms.support.api.client.ResultCallbacks
    public final void onFailure(Status status) {
        try {
            if (status.hasResolution()) {
                status.startResolutionForResult(this.a, this.b);
            } else {
                onUnresolvableFailure(status);
            }
        } catch (Exception e) {
            HMSLog.e("ResolvingResultCallbacks", "Failed to start resolution: " + e);
            onUnresolvableFailure(Status.RESULT_INTERNAL_ERROR);
        }
    }

    @Override // com.huawei.hms.support.api.client.ResultCallbacks
    public abstract void onSuccess(R r);

    public abstract void onUnresolvableFailure(Status status);
}
