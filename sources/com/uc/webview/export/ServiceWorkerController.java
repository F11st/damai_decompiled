package com.uc.webview.export;

import com.uc.webview.export.annotations.Api;
import com.uc.webview.export.internal.SDKFactory;
import com.uc.webview.export.internal.interfaces.IServiceWorkerController;
import java.util.HashMap;

/* compiled from: Taobao */
@Api
/* loaded from: classes11.dex */
public class ServiceWorkerController {
    private static HashMap<Integer, ServiceWorkerController> a;
    private IServiceWorkerController b;

    private ServiceWorkerController(IServiceWorkerController iServiceWorkerController) {
        this.b = iServiceWorkerController;
    }

    private static synchronized ServiceWorkerController a(int i) throws RuntimeException {
        ServiceWorkerController serviceWorkerController;
        synchronized (ServiceWorkerController.class) {
            if (a == null) {
                a = new HashMap<>();
            }
            serviceWorkerController = a.get(Integer.valueOf(i));
            if (serviceWorkerController == null) {
                serviceWorkerController = new ServiceWorkerController(SDKFactory.c(i));
                a.put(Integer.valueOf(i), serviceWorkerController);
            }
        }
        return serviceWorkerController;
    }

    public static ServiceWorkerController getInstance() {
        return a(SDKFactory.e());
    }

    protected Object clone() throws CloneNotSupportedException {
        throw new CloneNotSupportedException("doesn't implement Cloneable");
    }

    public ServiceWorkerWebSettings getServiceWorkerWebSettings() {
        return this.b.getServiceWorkerWebSettings();
    }

    public void setServiceWorkerClient(ServiceWorkerClient serviceWorkerClient) {
        this.b.setServiceWorkerClient(serviceWorkerClient);
    }

    public static ServiceWorkerController getInstance(WebView webView) {
        return a(webView.getCurrentViewCoreType());
    }
}
