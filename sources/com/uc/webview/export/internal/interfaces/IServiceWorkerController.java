package com.uc.webview.export.internal.interfaces;

import com.uc.webview.export.ServiceWorkerClient;
import com.uc.webview.export.ServiceWorkerWebSettings;
import com.uc.webview.export.annotations.Interface;

/* compiled from: Taobao */
@Interface
/* loaded from: classes11.dex */
public interface IServiceWorkerController {
    ServiceWorkerWebSettings getServiceWorkerWebSettings();

    void setServiceWorkerClient(ServiceWorkerClient serviceWorkerClient);
}
