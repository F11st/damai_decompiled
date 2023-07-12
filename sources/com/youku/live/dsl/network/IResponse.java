package com.youku.live.dsl.network;

/* compiled from: Taobao */
/* loaded from: classes12.dex */
public interface IResponse {
    byte[] getRawData();

    String getRetCode();

    String getRetMessage();

    String getSource();

    boolean isRequestSuccess();

    boolean isResponseSuccess();
}
