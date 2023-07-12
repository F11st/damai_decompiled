package com.amap.api.col.s;

import android.content.Context;
import com.amap.api.col.s.ae;
import com.amap.api.col.s.df;
import com.amap.api.services.core.AMapException;
import com.amap.api.services.core.ServiceSettings;
import java.util.Map;

/* compiled from: Taobao */
/* loaded from: classes10.dex */
public abstract class a<T, V> extends br {
    protected T b;
    protected Context e;
    protected boolean a = true;
    protected int c = 1;
    protected String d = "";
    private int k = 1;
    protected String f = "";

    public a(Context context, T t) {
        a(context, t);
    }

    /* JADX WARN: Multi-variable type inference failed */
    private V A() throws AMapException {
        V v;
        ae aeVar;
        ae.c a;
        Object obj;
        try {
            ae.b d = d();
            boolean b = ae.a().b(d);
            boolean z = false;
            int i = 0;
            V v2 = null;
            boolean z2 = false;
            while (i < this.c) {
                long currentTimeMillis = System.currentTimeMillis();
                try {
                    try {
                        try {
                            int protocol = ServiceSettings.getInstance().getProtocol();
                            bq.a().a(this.e);
                            de b2 = de.b();
                            if (b && (a = ae.a().a(d)) != null && (obj = a.a) != 0) {
                                try {
                                    an.a(this.e, d.a, a.b);
                                    v2 = obj;
                                    z2 = true;
                                } catch (bj e) {
                                    e = e;
                                    v2 = obj;
                                    z2 = true;
                                    an.a(this.e, z(), System.currentTimeMillis() - currentTimeMillis, z);
                                    i++;
                                    if (i < this.c) {
                                        try {
                                            Thread.sleep(this.k * 1000);
                                            if (b && !z2) {
                                                ae.a().a(d, v2);
                                            }
                                            z = false;
                                        } catch (InterruptedException unused) {
                                            if (!com.amap.api.maps.AMapException.ERROR_CONNECTION.equals(e.getMessage()) && !com.amap.api.maps.AMapException.ERROR_SOCKET.equals(e.getMessage()) && !com.amap.api.maps.AMapException.ERROR_UNKNOW_SERVICE.equals(e.getMessage())) {
                                                throw new AMapException(e.a(), 1, e.c());
                                            }
                                            throw new AMapException(AMapException.AMAP_CLIENT_NETWORK_EXCEPTION, 1, e.c());
                                        }
                                    } else {
                                        if (!com.amap.api.maps.AMapException.ERROR_CONNECTION.equals(e.getMessage()) && !com.amap.api.maps.AMapException.ERROR_SOCKET.equals(e.getMessage()) && !com.amap.api.maps.AMapException.ERROR_UNKNOWN.equals(e.a()) && !com.amap.api.maps.AMapException.ERROR_UNKNOW_SERVICE.equals(e.getMessage())) {
                                            throw new AMapException(e.a(), 1, e.c());
                                        }
                                        throw new AMapException(AMapException.AMAP_CLIENT_NETWORK_EXCEPTION, 1, e.c());
                                    }
                                } catch (AMapException e2) {
                                    e = e2;
                                    v2 = obj;
                                    z2 = true;
                                    an.a(this.e, z(), System.currentTimeMillis() - currentTimeMillis, z);
                                    i++;
                                    if (i >= this.c) {
                                        throw e;
                                    }
                                    if (b && !z2) {
                                        aeVar = ae.a();
                                        aeVar.a(d, v2);
                                    }
                                    z = false;
                                } catch (Throwable th) {
                                    th = th;
                                    v = obj;
                                    z2 = true;
                                    if (b) {
                                        ae.a().a(d, v);
                                    }
                                    throw th;
                                }
                            }
                            if (v2 == null) {
                                byte[] a2 = a(protocol, b2, this);
                                long currentTimeMillis2 = System.currentTimeMillis();
                                v2 = b(a2);
                                an.a(this.e, z(), currentTimeMillis2 - currentTimeMillis, true);
                            }
                            i = this.c;
                        } catch (bj e3) {
                            e = e3;
                        } catch (AMapException e4) {
                            e = e4;
                        }
                        if (b && !z2) {
                            aeVar = ae.a();
                            aeVar.a(d, v2);
                        }
                        z = false;
                    } catch (Throwable th2) {
                        th = th2;
                        v = v2;
                        if (b && !z2) {
                            ae.a().a(d, v);
                        }
                        throw th;
                    }
                } catch (Throwable th3) {
                    th = th3;
                    v = null;
                }
            }
            return v2;
        } catch (AMapException e5) {
            throw e5;
        } catch (Throwable th4) {
            th4.printStackTrace();
            throw new AMapException(AMapException.AMAP_CLIENT_UNKNOWN_ERROR);
        }
    }

    private void a(Context context, T t) {
        this.e = context;
        this.b = t;
        this.c = 1;
        b(ServiceSettings.getInstance().getSoTimeOut());
        a(ServiceSettings.getInstance().getConnectionTimeOut());
    }

    private String j() {
        return this.f;
    }

    private String z() {
        String a = a();
        if (a != null) {
            try {
                int indexOf = a.indexOf(".com/");
                int indexOf2 = a.indexOf("?");
                if (indexOf2 == -1) {
                    return a.substring(indexOf + 5);
                }
                return a.substring(indexOf + 5, indexOf2);
            } catch (Throwable unused) {
                return null;
            }
        }
        return null;
    }

    protected abstract V a(String str) throws AMapException;

    protected abstract String a_();

    public final V b() throws AMapException {
        if (this.b != null) {
            try {
                return A();
            } catch (AMapException e) {
                an.a(z(), j(), e);
                throw e;
            }
        }
        return null;
    }

    @Override // com.amap.api.col.s.df
    public final String c() {
        return "sea";
    }

    protected ae.b d() {
        return null;
    }

    @Override // com.amap.api.col.s.df
    public Map<String, String> e() {
        return null;
    }

    @Override // com.amap.api.col.s.df
    public Map<String, String> f() {
        return null;
    }

    private V b(byte[] bArr) throws AMapException {
        return a(bArr);
    }

    protected V a(byte[] bArr) throws AMapException {
        String str;
        try {
            str = new String(bArr, "utf-8");
        } catch (Exception e) {
            i.a(e, "ProtocalHandler", "loadData");
            str = null;
        }
        if (str == null || str.equals("")) {
            return null;
        }
        i.b(str);
        return a(str);
    }

    private byte[] a(int i, de deVar, br brVar) throws bj {
        dg e;
        a(i == 1 ? df.c.HTTP : df.c.HTTPS);
        if (this.a) {
            e = cz.a(brVar);
        } else {
            e = de.e(brVar);
        }
        if (e != null) {
            byte[] bArr = e.a;
            this.f = e.d;
            return bArr;
        }
        return null;
    }
}
