package com.huawei.hms.common;

import com.huawei.hms.support.api.client.Status;

/* compiled from: Taobao */
/* loaded from: classes10.dex */
public class ApiException extends Exception {
    protected final Status mStatus;

    /* JADX WARN: Illegal instructions before constructor call */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public ApiException(com.huawei.hms.support.api.client.Status r3) {
        /*
            r2 = this;
            java.lang.StringBuilder r0 = new java.lang.StringBuilder
            r0.<init>()
            int r1 = r3.getStatusCode()
            r0.append(r1)
            java.lang.String r1 = ": "
            r0.append(r1)
            java.lang.String r1 = r3.getStatusMessage()
            if (r1 == 0) goto L1c
            java.lang.String r1 = r3.getStatusMessage()
            goto L1e
        L1c:
            java.lang.String r1 = ""
        L1e:
            r0.append(r1)
            java.lang.String r0 = r0.toString()
            r2.<init>(r0)
            r2.mStatus = r3
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.huawei.hms.common.ApiException.<init>(com.huawei.hms.support.api.client.Status):void");
    }

    public int getStatusCode() {
        return this.mStatus.getStatusCode();
    }

    @Deprecated
    public String getStatusMessage() {
        return this.mStatus.getStatusMessage();
    }
}
