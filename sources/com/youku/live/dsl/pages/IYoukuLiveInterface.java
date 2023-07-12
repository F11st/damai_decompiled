package com.youku.live.dsl.pages;

import android.app.Activity;
import android.app.Application;
import android.content.Intent;
import android.os.Bundle;
import android.os.PersistableBundle;
import androidx.annotation.NonNull;

/* compiled from: Taobao */
/* loaded from: classes12.dex */
public interface IYoukuLiveInterface {
    void finish();

    void onActivityResult(int i, int i2, Intent intent);

    boolean onBackPressed();

    void onCreate(Bundle bundle);

    void onDestroy();

    void onPause();

    void onRequestPermissionsResult(int i, @NonNull String[] strArr, @NonNull int[] iArr);

    void onRestoreInstanceState(Bundle bundle);

    void onRestoreInstanceState(Bundle bundle, PersistableBundle persistableBundle);

    void onResume();

    void onSaveInstanceState(Bundle bundle);

    void onSaveInstanceState(Bundle bundle, PersistableBundle persistableBundle);

    void onStart();

    void onStop();

    void setActivity(Activity activity);

    void setApplication(Application application);
}
