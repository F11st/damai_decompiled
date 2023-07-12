package com.taobao.android.sns4android;

import com.ali.user.mobile.model.SNSSignInAccount;

/* compiled from: Taobao */
/* loaded from: classes12.dex */
public interface AuthCallback {
    void onFail(int i, String str);

    void onSuccess(SNSSignInAccount sNSSignInAccount);
}
