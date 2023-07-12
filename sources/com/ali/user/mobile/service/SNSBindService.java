package com.ali.user.mobile.service;

import android.app.Activity;
import com.ali.user.mobile.model.CommonCallback;
import com.ali.user.mobile.model.SNSSignInAccount;
import com.taobao.android.sns4android.SNSPlatform;

/* compiled from: Taobao */
/* loaded from: classes17.dex */
public interface SNSBindService {
    void bind(Activity activity, SNSPlatform sNSPlatform, CommonCallback commonCallback);

    void clean();

    void doBind(Activity activity, SNSSignInAccount sNSSignInAccount, CommonCallback commonCallback);

    void doChangeBind(SNSSignInAccount sNSSignInAccount, String str, String str2, CommonCallback commonCallback);
}
