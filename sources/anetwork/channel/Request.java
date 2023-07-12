package anetwork.channel;

import anet.channel.request.BodyEntry;
import java.net.URI;
import java.net.URL;
import java.util.List;
import java.util.Map;

/* compiled from: Taobao */
/* loaded from: classes.dex */
public interface Request {
    void addHeader(String str, String str2);

    String getBizId();

    BodyEntry getBodyEntry();

    @Deprecated
    IBodyHandler getBodyHandler();

    String getCharset();

    int getConnectTimeout();

    Map<String, String> getExtProperties();

    String getExtProperty(String str);

    boolean getFollowRedirects();

    List<Header> getHeaders();

    Header[] getHeaders(String str);

    String getMethod();

    List<Param> getParams();

    int getReadTimeout();

    int getRetryTime();

    String getSeqNo();

    @Deprecated
    URI getURI();

    @Deprecated
    URL getURL();

    String getUrlString();

    @Deprecated
    boolean isCookieEnabled();

    void removeHeader(Header header);

    @Deprecated
    void setBizId(int i);

    void setBizId(String str);

    void setBodyEntry(BodyEntry bodyEntry);

    @Deprecated
    void setBodyHandler(IBodyHandler iBodyHandler);

    void setCharset(String str);

    void setConnectTimeout(int i);

    @Deprecated
    void setCookieEnabled(boolean z);

    void setExtProperty(String str, String str2);

    void setFollowRedirects(boolean z);

    void setHeader(Header header);

    void setHeaders(List<Header> list);

    void setMethod(String str);

    void setParams(List<Param> list);

    void setReadTimeout(int i);

    void setRetryTime(int i);

    void setSeqNo(String str);

    void setTraceContext(Map<String, String> map);

    @Deprecated
    void setUri(URI uri);
}
