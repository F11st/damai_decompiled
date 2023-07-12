package com.taobao.android.sopatch.transfer;

/* compiled from: Taobao */
/* loaded from: classes12.dex */
public interface Transfer<A, B> {
    A antiTransfer(B b);

    B transfer(A a);
}
