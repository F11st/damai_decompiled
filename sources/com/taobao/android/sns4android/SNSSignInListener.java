package com.taobao.android.sns4android;

import android.app.Activity;
import com.ali.user.mobile.model.SNSSignInAccount;

/* compiled from: Taobao */
/* loaded from: classes12.dex */
public interface SNSSignInListener {
    void onCancel(Activity activity, String str);

    void onError(Activity activity, String str, int i, String str2);

    void onSucceed(Activity activity, SNSSignInAccount sNSSignInAccount);
}
