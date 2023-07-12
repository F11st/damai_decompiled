package me.ele.altriax.launcher.bootstrap;

import android.content.Context;
import androidx.annotation.NonNull;

/* compiled from: Taobao */
/* loaded from: classes11.dex */
public interface AppDelegate {
    void attachBaseContext(Context context);

    void onAppSecurityGuard();

    void onAttach();

    void onCreate();

    void onMain();

    void onSchemaWaked();

    void onSchemaWebWaked();

    void setFirstActivityFilter(@NonNull String str);
}
