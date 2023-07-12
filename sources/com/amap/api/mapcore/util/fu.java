package com.amap.api.mapcore.util;

import android.content.Context;
import com.alimm.xadsdk.request.builder.IRequestConst;
import com.amap.api.maps.AMapException;
import java.util.Hashtable;
import java.util.Locale;
import java.util.Map;

/* compiled from: Taobao */
/* loaded from: classes10.dex */
public abstract class fu<T, V> extends AbstractC4517dp {
    protected T d;
    protected int e = 1;
    protected Context f;
    protected String g;

    public fu(Context context, T t) {
        a(context, t);
    }

    private void a(Context context, T t) {
        this.f = context;
        this.d = t;
        this.e = 1;
        setSoTimeout(30000);
        setConnectionTimeout(30000);
    }

    private V g() throws ft {
        V v = null;
        int i = 0;
        while (i < this.e) {
            try {
                setProxy(gl.a(this.f));
                v = a(makeHttpRequest());
                i = this.e;
            } catch (ft e) {
                i++;
                if (i >= this.e) {
                    throw new ft(e.a());
                }
            } catch (gb e2) {
                i++;
                if (i < this.e) {
                    try {
                        Thread.sleep(1000L);
                    } catch (InterruptedException unused) {
                        if (!AMapException.ERROR_CONNECTION.equals(e2.getMessage()) && !AMapException.ERROR_SOCKET.equals(e2.getMessage()) && !AMapException.ERROR_UNKNOW_SERVICE.equals(e2.getMessage())) {
                            throw new ft(e2.a());
                        }
                        throw new ft(com.amap.api.services.core.AMapException.AMAP_CLIENT_NETWORK_EXCEPTION);
                    }
                } else {
                    f();
                    if (!AMapException.ERROR_CONNECTION.equals(e2.getMessage()) && !AMapException.ERROR_SOCKET.equals(e2.getMessage()) && !AMapException.ERROR_UNKNOWN.equals(e2.a()) && !AMapException.ERROR_UNKNOW_SERVICE.equals(e2.getMessage())) {
                        throw new ft(e2.a());
                    }
                    throw new ft(com.amap.api.services.core.AMapException.AMAP_CLIENT_NETWORK_EXCEPTION);
                }
            }
        }
        return v;
    }

    protected abstract String a();

    protected abstract V b(String str) throws ft;

    protected V b(byte[] bArr) throws ft {
        String str;
        try {
            str = new String(bArr, "utf-8");
        } catch (Exception e) {
            e.printStackTrace();
            str = null;
        }
        if (str == null || "".equals(str)) {
            return null;
        }
        fw.a(str, this.g);
        return b(str);
    }

    public V e() throws ft {
        if (this.d != null) {
            try {
                return g();
            } catch (ft e) {
                eq.a(e);
                throw e;
            }
        }
        return null;
    }

    protected V f() {
        return null;
    }

    @Override // com.amap.api.mapcore.util.ii
    public Map<String, String> getRequestHead() {
        gm e = eq.e();
        String b = e != null ? e.b() : null;
        Hashtable hashtable = new Hashtable(16);
        hashtable.put(IRequestConst.USER_AGENT, C4614m.c);
        hashtable.put("Accept-Encoding", "gzip");
        hashtable.put("platinfo", String.format(Locale.US, "platform=Android&sdkversion=%s&product=%s", b, "3dmap"));
        hashtable.put("X-INFO", gf.b(this.f));
        hashtable.put("key", C4554gc.f(this.f));
        hashtable.put("logversion", "2.1");
        return hashtable;
    }

    private V a(byte[] bArr) throws ft {
        return b(bArr);
    }
}
