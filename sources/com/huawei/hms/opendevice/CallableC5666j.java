package com.huawei.hms.opendevice;

import android.content.Context;
import com.huawei.hms.aaid.constant.ErrorEnum;
import com.huawei.hms.aaid.entity.AAIDResult;
import java.util.concurrent.Callable;

/* compiled from: Taobao */
/* renamed from: com.huawei.hms.opendevice.j */
/* loaded from: classes10.dex */
public class CallableC5666j implements Callable<AAIDResult> {
    public Context a;

    public CallableC5666j(Context context) {
        this.a = context;
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // java.util.concurrent.Callable
    public AAIDResult call() throws Exception {
        Context context = this.a;
        if (context != null) {
            String c = C5673o.c(context);
            AAIDResult aAIDResult = new AAIDResult();
            aAIDResult.setId(c);
            return aAIDResult;
        }
        throw ErrorEnum.ERROR_ARGUMENTS_INVALID.toApiException();
    }
}
