package com.efs.sdk.base.processor.action;

/* compiled from: Taobao */
/* loaded from: classes10.dex */
public interface ILogEncryptAction {
    byte[] decrypt(String str, byte[] bArr);

    byte[] encrypt(String str, byte[] bArr);

    int getDeVal();
}
