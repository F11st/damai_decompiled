package com.ali.user.open.ucc;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import com.ali.user.open.oauth.AppCredential;
import com.ali.user.open.ucc.model.UccParams;
import java.util.Map;

/* compiled from: Taobao */
/* loaded from: classes9.dex */
public interface UccServiceProvider {
    void applyToken(UccParams uccParams, Map<String, String> map, UccCallback uccCallback);

    void bind(Activity activity, UccParams uccParams, AppCredential appCredential, Map<String, String> map, UccCallback uccCallback);

    void bindWithIBB(Activity activity, UccParams uccParams, String str, Map<String, String> map, UccCallback uccCallback);

    Map<String, String> buildSessionInfo(String str, String str2);

    void cleanUp(Context context);

    void logout(Context context);

    void onActivityResult(int i, int i2, Intent intent);

    void refreshWhenLogin(String str, String str2, boolean z);
}
