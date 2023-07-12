package me.ele.altriax.launcher.bootstrap;

import android.app.Application;
import android.content.Context;
import androidx.annotation.NonNull;

/* compiled from: Taobao */
/* loaded from: classes11.dex */
public class Bootstrap implements AppDelegate {
    private final AppDelegateInner delegate;

    /* compiled from: Taobao */
    /* loaded from: classes11.dex */
    public static class Builder {
        private final Application application;
        private final Options options;

        public Builder(Application application, Options options) {
            this.application = application;
            this.options = options;
        }

        public AppDelegate build() {
            return new Bootstrap(this.application, this.options);
        }
    }

    @Override // me.ele.altriax.launcher.bootstrap.AppDelegate
    public void attachBaseContext(Context context) {
        this.delegate.attachBaseContext(context);
    }

    @Override // me.ele.altriax.launcher.bootstrap.AppDelegate
    public void onAppSecurityGuard() {
        this.delegate.onAppSecurityGuard();
    }

    @Override // me.ele.altriax.launcher.bootstrap.AppDelegate
    public void onAttach() {
        this.delegate.onAttach();
    }

    @Override // me.ele.altriax.launcher.bootstrap.AppDelegate
    public void onCreate() {
        this.delegate.onCreate();
    }

    @Override // me.ele.altriax.launcher.bootstrap.AppDelegate
    public void onMain() {
        this.delegate.onMain();
    }

    @Override // me.ele.altriax.launcher.bootstrap.AppDelegate
    public void onSchemaWaked() {
        this.delegate.onSchemaWaked();
    }

    @Override // me.ele.altriax.launcher.bootstrap.AppDelegate
    public void onSchemaWebWaked() {
        this.delegate.onSchemaWebWaked();
    }

    @Override // me.ele.altriax.launcher.bootstrap.AppDelegate
    public void setFirstActivityFilter(@NonNull String str) {
        this.delegate.setFirstActivityFilter(str);
    }

    private Bootstrap(Application application, Options options) {
        me.ele.altriax.launcher.bootstrap.ele.AppDelegate appDelegate = new me.ele.altriax.launcher.bootstrap.ele.AppDelegate();
        this.delegate = appDelegate;
        appDelegate.bindApp(application, options);
    }
}
