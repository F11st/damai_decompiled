package com.youku.asyncview;

import android.annotation.TargetApi;
import android.content.Context;
import android.content.ContextWrapper;
import android.content.Intent;
import android.content.res.Resources;
import android.os.Bundle;
import java.lang.ref.WeakReference;

/* compiled from: Taobao */
/* loaded from: classes2.dex */
public class ViewContext extends ContextWrapper {
    private WeakReference<Context> mCurrContextRef;

    public ViewContext(Context context) {
        super(context.getApplicationContext());
        this.mCurrContextRef = new WeakReference<>(context);
    }

    public Context getCurrentContext() {
        WeakReference<Context> weakReference = this.mCurrContextRef;
        if (weakReference != null) {
            return weakReference.get();
        }
        return null;
    }

    @Override // android.content.ContextWrapper, android.content.Context
    public Resources getResources() {
        WeakReference<Context> weakReference = this.mCurrContextRef;
        Context context = weakReference != null ? weakReference.get() : null;
        return context != null ? context.getResources() : super.getResources();
    }

    @Override // android.content.ContextWrapper, android.content.Context
    public Resources.Theme getTheme() {
        WeakReference<Context> weakReference = this.mCurrContextRef;
        Context context = weakReference != null ? weakReference.get() : null;
        return context != null ? context.getTheme() : super.getTheme();
    }

    public void setCurrentContext(Context context) {
        this.mCurrContextRef = new WeakReference<>(context);
    }

    @Override // android.content.ContextWrapper, android.content.Context
    public void startActivities(Intent[] intentArr) {
        WeakReference<Context> weakReference = this.mCurrContextRef;
        Context context = weakReference != null ? weakReference.get() : null;
        if (context != null) {
            context.startActivities(intentArr);
        } else {
            super.startActivities(intentArr);
        }
    }

    @Override // android.content.ContextWrapper, android.content.Context
    public void startActivity(Intent intent) {
        WeakReference<Context> weakReference = this.mCurrContextRef;
        Context context = weakReference != null ? weakReference.get() : null;
        if (context != null) {
            context.startActivity(intent);
        } else {
            super.startActivity(intent);
        }
    }

    @Override // android.content.ContextWrapper, android.content.Context
    @TargetApi(16)
    public void startActivities(Intent[] intentArr, Bundle bundle) {
        WeakReference<Context> weakReference = this.mCurrContextRef;
        Context context = weakReference != null ? weakReference.get() : null;
        if (context != null) {
            context.startActivities(intentArr, bundle);
        } else {
            super.startActivities(intentArr, bundle);
        }
    }

    @Override // android.content.ContextWrapper, android.content.Context
    @TargetApi(16)
    public void startActivity(Intent intent, Bundle bundle) {
        WeakReference<Context> weakReference = this.mCurrContextRef;
        Context context = weakReference != null ? weakReference.get() : null;
        if (context != null) {
            context.startActivity(intent, bundle);
        } else {
            super.startActivity(intent, bundle);
        }
    }
}
