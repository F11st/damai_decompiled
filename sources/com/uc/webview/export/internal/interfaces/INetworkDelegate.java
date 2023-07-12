package com.uc.webview.export.internal.interfaces;

import com.uc.webview.export.annotations.Reflection;

/* compiled from: Taobao */
@Reflection
/* loaded from: classes11.dex */
public interface INetworkDelegate {
    IResponseData onReceiveResponse(IResponseData iResponseData);

    IRequestData onSendRequest(IRequestData iRequestData);
}
