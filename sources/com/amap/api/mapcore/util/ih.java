package com.amap.api.mapcore.util;

import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import com.amap.api.maps.AMapException;
import java.net.Proxy;
import java.util.Map;

/* compiled from: Taobao */
/* loaded from: classes10.dex */
public class ih extends id {
    private static ih c;
    private jj d;
    private Handler e;

    /* compiled from: Taobao */
    /* renamed from: com.amap.api.mapcore.util.ih$1  reason: invalid class name */
    /* loaded from: classes10.dex */
    class AnonymousClass1 extends jk {
        final /* synthetic */ ii a;
        final /* synthetic */ boolean b;
        final /* synthetic */ ij c;
        final /* synthetic */ ih d;

        @Override // com.amap.api.mapcore.util.jk
        public void runTask() {
            try {
                this.d.a(this.d.c(this.a, this.b), this.c);
            } catch (gb e) {
                this.d.a(e, this.c);
            }
        }
    }

    /* compiled from: Taobao */
    /* renamed from: com.amap.api.mapcore.util.ih$a */
    /* loaded from: classes10.dex */
    static class HandlerC4591a extends Handler {
        /* synthetic */ HandlerC4591a(Looper looper, AnonymousClass1 anonymousClass1) {
            this(looper);
        }

        @Override // android.os.Handler
        public void handleMessage(Message message) {
            try {
                int i = message.what;
                if (i == 0) {
                    ((C4592im) message.obj).b.a();
                } else if (i != 1) {
                } else {
                    C4592im c4592im = (C4592im) message.obj;
                    c4592im.b.a(c4592im.a);
                }
            } catch (Throwable th) {
                th.printStackTrace();
            }
        }

        private HandlerC4591a(Looper looper) {
            super(looper);
        }

        public HandlerC4591a() {
        }
    }

    private ih(boolean z, int i) {
        if (z) {
            try {
                this.d = jj.b(i);
            } catch (Throwable th) {
                hd.c(th, "NetManger", "NetManger1");
                th.printStackTrace();
                return;
            }
        }
        if (Looper.myLooper() == null) {
            this.e = new HandlerC4591a(Looper.getMainLooper(), null);
        } else {
            this.e = new HandlerC4591a();
        }
    }

    public static ih b() {
        return a(true, 5);
    }

    public ik c(ii iiVar, boolean z) throws gb {
        ik ikVar;
        byte[] bArr;
        int a = ig.a(2, iiVar);
        try {
            ikVar = c(iiVar, z, a);
        } catch (gb e) {
            if (!ig.a(a)) {
                throw e;
            }
            ikVar = null;
        }
        if ((ikVar == null || (bArr = ikVar.a) == null || bArr.length <= 0) && ig.a(a)) {
            try {
                return c(iiVar, z, 3);
            } catch (gb e2) {
                throw e2;
            }
        }
        return ikVar;
    }

    public byte[] d(ii iiVar) throws gb {
        try {
            ik c2 = c(iiVar, false);
            if (c2 != null) {
                return c2.a;
            }
            return null;
        } catch (gb e) {
            throw e;
        }
    }

    public byte[] e(ii iiVar) throws gb {
        try {
            ik c2 = c(iiVar, true);
            if (c2 != null) {
                return c2.a;
            }
            return null;
        } catch (gb e) {
            throw e;
        }
    }

    @Override // com.amap.api.mapcore.util.id
    public byte[] b(ii iiVar) throws gb {
        try {
            ik a = a(iiVar, false);
            if (a != null) {
                return a.a;
            }
            return null;
        } catch (gb e) {
            throw e;
        } catch (Throwable th) {
            th.printStackTrace();
            hd.e().b(th, "NetManager", "makeSyncPostRequest");
            throw new gb(AMapException.ERROR_UNKNOWN);
        }
    }

    public static ih a(boolean z) {
        return a(z, 5);
    }

    private static synchronized ih a(boolean z, int i) {
        ih ihVar;
        synchronized (ih.class) {
            try {
                ih ihVar2 = c;
                if (ihVar2 == null) {
                    c = new ih(z, i);
                } else if (z && ihVar2.d == null) {
                    ihVar2.d = jj.b(i);
                }
                try {
                    if (gg.b() == null) {
                        gg.a(gt.a());
                    }
                } catch (Throwable unused) {
                }
                ihVar = c;
            }
        }
        return ihVar;
    }

    public Map<String, String> b(ii iiVar, boolean z) throws gb {
        Map<String, String> map;
        int a = ig.a(2, iiVar);
        try {
            map = b(iiVar, z, a);
        } catch (gb e) {
            if (!ig.a(a)) {
                throw e;
            }
            map = null;
        }
        if (map == null && ig.a(a)) {
            try {
                return b(iiVar, z, 3);
            } catch (gb e2) {
                throw e2;
            }
        }
        return map;
    }

    public ik c(ii iiVar, boolean z, int i) throws gb {
        try {
            c(iiVar);
            Proxy proxy = iiVar.c;
            if (proxy == null) {
                proxy = null;
            }
            return new ig(iiVar.a, iiVar.b, proxy, z).b(iiVar.getURL(), iiVar.c(), iiVar.isIPRequest(), iiVar.getIPDNSName(), iiVar.getRequestHead(), iiVar.getParams(), iiVar.isIgnoreGZip(), i);
        } catch (gb e) {
            throw e;
        } catch (Throwable th) {
            th.printStackTrace();
            throw new gb(AMapException.ERROR_UNKNOWN);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(gb gbVar, ij ijVar) {
        C4592im c4592im = new C4592im();
        c4592im.a = gbVar;
        c4592im.b = ijVar;
        Message obtain = Message.obtain();
        obtain.obj = c4592im;
        obtain.what = 1;
        this.e.sendMessage(obtain);
    }

    public Map<String, String> b(ii iiVar, boolean z, int i) throws gb {
        try {
            c(iiVar);
            Proxy proxy = iiVar.c;
            if (proxy == null) {
                proxy = null;
            }
            return new ig(iiVar.a, iiVar.b, proxy, z).a(iiVar.getURL(), iiVar.c(), iiVar.isIPRequest(), iiVar.getIPDNSName(), iiVar.getRequestHead(), iiVar.getParams(), iiVar.isIgnoreGZip(), i);
        } catch (gb e) {
            throw e;
        } catch (Throwable th) {
            th.printStackTrace();
            throw new gb(AMapException.ERROR_UNKNOWN);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(ik ikVar, ij ijVar) {
        ijVar.a(ikVar.b, ikVar.a);
        C4592im c4592im = new C4592im();
        c4592im.b = ijVar;
        Message obtain = Message.obtain();
        obtain.obj = c4592im;
        obtain.what = 0;
        this.e.sendMessage(obtain);
    }
}
