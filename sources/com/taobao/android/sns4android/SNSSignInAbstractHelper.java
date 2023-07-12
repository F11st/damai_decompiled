package com.taobao.android.sns4android;

import android.app.Activity;
import android.content.Intent;
import com.ali.user.mobile.log.UserTrackAdapter;
import java.util.Map;
import java.util.Properties;
import org.json.JSONObject;

/* compiled from: Taobao */
/* loaded from: classes12.dex */
public abstract class SNSSignInAbstractHelper {
    public SNSSignInListener snsSignInListener;

    public void auth(Activity activity, SNSSignInListener sNSSignInListener) {
    }

    public void auth(Activity activity, SNSSignInListener sNSSignInListener, JSONObject jSONObject) {
        auth(activity, sNSSignInListener);
    }

    public void onActivityResult(int i, int i2, Intent intent) {
    }

    public void resultUT(String str, String str2) {
        Properties properties = new Properties();
        properties.setProperty("result", str2);
        UserTrackAdapter.sendUT(str, "GetAuthKey_Result", properties);
    }

    public SNSSignInAbstractHelper setSNSSignInListener(SNSSignInListener sNSSignInListener) {
        this.snsSignInListener = sNSSignInListener;
        return this;
    }

    public abstract void signIn(Activity activity);

    public void signIn(Activity activity, Map<String, String> map) {
        signIn(activity);
    }

    public void signOut(Activity activity) {
    }
}
