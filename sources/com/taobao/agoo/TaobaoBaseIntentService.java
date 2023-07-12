package com.taobao.agoo;

import android.content.Context;
import android.content.Intent;
import org.android.agoo.control.BaseIntentService;

/* loaded from: classes8.dex */
public abstract class TaobaoBaseIntentService extends BaseIntentService {
    @Override // org.android.agoo.control.BaseIntentService
    protected abstract void onError(Context context, String str);

    @Override // org.android.agoo.control.BaseIntentService
    protected abstract void onMessage(Context context, Intent intent);

    @Override // org.android.agoo.control.BaseIntentService
    protected abstract void onRegistered(Context context, String str);

    protected abstract void onUnregistered(Context context, String str);

    @Override // org.android.agoo.control.BaseIntentService
    protected void onUserCommand(Context context, Intent intent) {
    }
}
