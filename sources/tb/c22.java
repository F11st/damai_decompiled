package tb;

import android.text.TextUtils;
import anet.channel.request.BodyEntry;
import anet.channel.util.ALog;
import anetwork.channel.Header;
import anetwork.channel.IBodyHandler;
import anetwork.channel.Param;
import anetwork.channel.Request;
import anetwork.channel.entity.BodyHandlerEntry;
import java.net.URI;
import java.net.URL;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/* compiled from: Taobao */
/* loaded from: classes.dex */
public class c22 implements Request {
    @Deprecated
    private URI a;
    @Deprecated
    private URL b;
    private String c;
    private List<Header> e;
    private List<Param> g;
    private int k;
    private int l;
    private String m;
    private String n;
    private Map<String, String> o;
    private boolean d = true;
    private String f = "GET";
    private int h = 2;
    private String i = "utf-8";
    private BodyEntry j = null;

    @Deprecated
    public c22(URI uri) {
        this.a = uri;
        this.c = uri.toString();
    }

    @Override // anetwork.channel.Request
    public void addHeader(String str, String str2) {
        if (str == null || str2 == null) {
            return;
        }
        if (this.e == null) {
            this.e = new ArrayList();
        }
        this.e.add(new sb(str, str2));
    }

    @Override // anetwork.channel.Request
    public String getBizId() {
        return this.m;
    }

    @Override // anetwork.channel.Request
    public BodyEntry getBodyEntry() {
        return this.j;
    }

    @Override // anetwork.channel.Request
    @Deprecated
    public IBodyHandler getBodyHandler() {
        return null;
    }

    @Override // anetwork.channel.Request
    public String getCharset() {
        return this.i;
    }

    @Override // anetwork.channel.Request
    public int getConnectTimeout() {
        return this.k;
    }

    @Override // anetwork.channel.Request
    public Map<String, String> getExtProperties() {
        return this.o;
    }

    @Override // anetwork.channel.Request
    public String getExtProperty(String str) {
        Map<String, String> map = this.o;
        if (map == null) {
            return null;
        }
        return map.get(str);
    }

    @Override // anetwork.channel.Request
    public boolean getFollowRedirects() {
        return this.d;
    }

    @Override // anetwork.channel.Request
    public List<Header> getHeaders() {
        return this.e;
    }

    @Override // anetwork.channel.Request
    public String getMethod() {
        return this.f;
    }

    @Override // anetwork.channel.Request
    public List<Param> getParams() {
        return this.g;
    }

    @Override // anetwork.channel.Request
    public int getReadTimeout() {
        return this.l;
    }

    @Override // anetwork.channel.Request
    public int getRetryTime() {
        return this.h;
    }

    @Override // anetwork.channel.Request
    public String getSeqNo() {
        return this.n;
    }

    @Override // anetwork.channel.Request
    @Deprecated
    public URI getURI() {
        URI uri = this.a;
        if (uri != null) {
            return uri;
        }
        if (this.c != null) {
            try {
                this.a = new URI(this.c);
            } catch (Exception e) {
                ALog.d("anet.RequestImpl", "uri error", this.n, e, new Object[0]);
            }
        }
        return this.a;
    }

    @Override // anetwork.channel.Request
    @Deprecated
    public URL getURL() {
        URL url = this.b;
        if (url != null) {
            return url;
        }
        if (this.c != null) {
            try {
                this.b = new URL(this.c);
            } catch (Exception e) {
                ALog.d("anet.RequestImpl", "url error", this.n, e, new Object[0]);
            }
        }
        return this.b;
    }

    @Override // anetwork.channel.Request
    public String getUrlString() {
        return this.c;
    }

    @Override // anetwork.channel.Request
    @Deprecated
    public boolean isCookieEnabled() {
        return !"false".equals(getExtProperty("EnableCookie"));
    }

    @Override // anetwork.channel.Request
    public void removeHeader(Header header) {
        List<Header> list = this.e;
        if (list != null) {
            list.remove(header);
        }
    }

    @Override // anetwork.channel.Request
    @Deprecated
    public void setBizId(int i) {
        this.m = String.valueOf(i);
    }

    @Override // anetwork.channel.Request
    public void setBodyEntry(BodyEntry bodyEntry) {
        this.j = bodyEntry;
    }

    @Override // anetwork.channel.Request
    public void setBodyHandler(IBodyHandler iBodyHandler) {
        this.j = new BodyHandlerEntry(iBodyHandler);
    }

    @Override // anetwork.channel.Request
    public void setCharset(String str) {
        this.i = str;
    }

    @Override // anetwork.channel.Request
    public void setConnectTimeout(int i) {
        this.k = i;
    }

    @Override // anetwork.channel.Request
    @Deprecated
    public void setCookieEnabled(boolean z) {
        setExtProperty("EnableCookie", z ? "true" : "false");
    }

    @Override // anetwork.channel.Request
    public void setExtProperty(String str, String str2) {
        if (TextUtils.isEmpty(str)) {
            return;
        }
        if (this.o == null) {
            this.o = new HashMap();
        }
        this.o.put(str, str2);
    }

    @Override // anetwork.channel.Request
    public void setFollowRedirects(boolean z) {
        this.d = z;
    }

    @Override // anetwork.channel.Request
    public void setHeader(Header header) {
        if (header == null) {
            return;
        }
        if (this.e == null) {
            this.e = new ArrayList();
        }
        int i = 0;
        int size = this.e.size();
        while (true) {
            if (i >= size) {
                break;
            }
            if (header.getName().equalsIgnoreCase(this.e.get(i).getName())) {
                this.e.set(i, header);
                break;
            }
            i++;
        }
        if (i < this.e.size()) {
            this.e.add(header);
        }
    }

    @Override // anetwork.channel.Request
    public void setHeaders(List<Header> list) {
        this.e = list;
    }

    @Override // anetwork.channel.Request
    public void setMethod(String str) {
        this.f = str;
    }

    @Override // anetwork.channel.Request
    public void setParams(List<Param> list) {
        this.g = list;
    }

    @Override // anetwork.channel.Request
    public void setReadTimeout(int i) {
        this.l = i;
    }

    @Override // anetwork.channel.Request
    public void setRetryTime(int i) {
        this.h = i;
    }

    @Override // anetwork.channel.Request
    public void setSeqNo(String str) {
        this.n = str;
    }

    @Override // anetwork.channel.Request
    public void setTraceContext(Map<String, String> map) {
        this.o.putAll(map);
    }

    @Override // anetwork.channel.Request
    @Deprecated
    public void setUri(URI uri) {
        this.a = uri;
    }

    @Override // anetwork.channel.Request
    public Header[] getHeaders(String str) {
        if (str == null) {
            return null;
        }
        ArrayList arrayList = new ArrayList();
        if (this.e != null) {
            for (int i = 0; i < this.e.size(); i++) {
                if (this.e.get(i) != null && this.e.get(i).getName() != null && this.e.get(i).getName().equalsIgnoreCase(str)) {
                    arrayList.add(this.e.get(i));
                }
            }
            if (arrayList.size() > 0) {
                Header[] headerArr = new Header[arrayList.size()];
                arrayList.toArray(headerArr);
                return headerArr;
            }
            return null;
        }
        return null;
    }

    @Override // anetwork.channel.Request
    public void setBizId(String str) {
        this.m = str;
    }

    @Deprecated
    public c22(URL url) {
        this.b = url;
        this.c = url.toString();
    }

    public c22(String str) {
        this.c = str;
    }
}
