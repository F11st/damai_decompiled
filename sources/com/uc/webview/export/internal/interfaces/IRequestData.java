package com.uc.webview.export.internal.interfaces;

import com.uc.webview.export.annotations.Reflection;
import java.util.Map;

/* compiled from: Taobao */
@Reflection
/* loaded from: classes11.dex */
public interface IRequestData {
    Map<String, String> getHeaders();

    String getMethod();

    String getUrl();

    void setHeaders(Map<String, String> map);

    void setMethod(String str);

    void setUrl(String str);
}
