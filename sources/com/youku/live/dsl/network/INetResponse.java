package com.youku.live.dsl.network;

/* compiled from: Taobao */
/* loaded from: classes12.dex */
public interface INetResponse {
    byte[] getRawData();

    String getRetCode();

    String getRetMessage();

    String getSource();

    boolean isSuccess();
}
