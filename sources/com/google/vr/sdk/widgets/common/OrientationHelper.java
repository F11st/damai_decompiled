package com.google.vr.sdk.widgets.common;

import android.app.Activity;
import android.os.Bundle;

/* compiled from: Taobao */
/* loaded from: classes10.dex */
class OrientationHelper {
    private Activity activity;
    private boolean isOrientationLocked;
    private int originalRequestedOrientation;

    public OrientationHelper(Activity activity) {
        this.activity = activity;
    }

    public boolean isInPortraitOrientation() {
        return this.activity.getResources().getConfiguration().orientation == 1;
    }

    public void lockOrientation() {
        if (this.isOrientationLocked) {
            return;
        }
        this.originalRequestedOrientation = this.activity.getRequestedOrientation();
        this.activity.setRequestedOrientation(isInPortraitOrientation() ? 1 : 0);
        this.isOrientationLocked = true;
    }

    public void onRestoreInstanceState(Bundle bundle) {
        this.originalRequestedOrientation = bundle.getInt("originalRequestedOrientation");
        this.isOrientationLocked = bundle.getBoolean("isOrientationLocked");
    }

    public Bundle onSaveInstanceState() {
        Bundle bundle = new Bundle();
        bundle.putBoolean("isOrientationLocked", this.isOrientationLocked);
        bundle.putInt("originalRequestedOrientation", this.originalRequestedOrientation);
        return bundle;
    }

    public void restoreOriginalOrientation() {
        this.isOrientationLocked = false;
        this.activity.setRequestedOrientation(this.originalRequestedOrientation);
    }
}
