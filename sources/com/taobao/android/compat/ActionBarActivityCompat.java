package com.taobao.android.compat;

import android.annotation.TargetApi;
import android.os.Build;
import android.os.Bundle;
import androidx.appcompat.app.ActionBarActivity;
import javax.annotation.Nullable;

/* compiled from: Taobao */
/* loaded from: classes5.dex */
public class ActionBarActivityCompat extends ActionBarActivity implements ActivityCompatJellyBean {
    private static final boolean COMPAT;
    private boolean mDestroyed;

    static {
        COMPAT = Build.VERSION.SDK_INT < 14;
    }

    private ApplicationCompat getApplicationCompat() {
        return (ApplicationCompat) getApplication();
    }

    @Override // com.taobao.android.compat.ActivityCompatJellyBean
    @TargetApi(17)
    public boolean isDestroyed() {
        if (Build.VERSION.SDK_INT < 17) {
            return this.mDestroyed;
        }
        try {
            return super.isDestroyed();
        } catch (Throwable unused) {
            return this.mDestroyed;
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    /* JADX WARN: Multi-variable type inference failed */
    public void onCreate(@Nullable Bundle bundle) {
        super.onCreate(bundle);
        if (COMPAT) {
            getApplicationCompat().dispatchActivityCreatedCompat(this, bundle);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    /* JADX WARN: Multi-variable type inference failed */
    public void onDestroy() {
        this.mDestroyed = true;
        super.onDestroy();
        if (COMPAT) {
            getApplicationCompat().dispatchActivityDestroyedCompat(this);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    /* JADX WARN: Multi-variable type inference failed */
    public void onPause() {
        super.onPause();
        if (COMPAT) {
            getApplicationCompat().dispatchActivityPausedCompat(this);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    /* JADX WARN: Multi-variable type inference failed */
    public void onResume() {
        super.onResume();
        if (COMPAT) {
            getApplicationCompat().dispatchActivityResumedCompat(this);
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    protected void onSaveInstanceState(Bundle bundle) {
        super.onSaveInstanceState(bundle);
        if (COMPAT) {
            getApplicationCompat().dispatchActivitySaveInstanceStateCompat(this, bundle);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    /* JADX WARN: Multi-variable type inference failed */
    public void onStart() {
        super.onStart();
        if (COMPAT) {
            getApplicationCompat().dispatchActivityStartedCompat(this);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    /* JADX WARN: Multi-variable type inference failed */
    public void onStop() {
        super.onStop();
        if (COMPAT) {
            getApplicationCompat().dispatchActivityStoppedCompat(this);
        }
    }
}
