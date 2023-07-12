package com.amap.api.col.s;

import android.content.Context;
import android.os.Message;
import android.text.TextUtils;
import com.amap.api.col.s.HandlerC4447t;
import com.amap.api.col.s.bt;
import com.amap.api.services.core.AMapException;
import com.amap.api.services.core.LatLonPoint;
import com.amap.api.services.interfaces.INearbySearch;
import com.amap.api.services.nearby.NearbySearch;
import com.amap.api.services.nearby.NearbySearchResult;
import com.amap.api.services.nearby.UploadInfo;
import com.amap.api.services.nearby.UploadInfoCallback;
import com.taobao.login4android.config.LoginSwitch;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Timer;
import java.util.TimerTask;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.regex.Pattern;

/* compiled from: Taobao */
/* loaded from: classes10.dex */
public final class bc implements INearbySearch {
    private static long e;
    private String b;
    private Context c;
    private HandlerC4447t d;
    private ExecutorService f;
    private UploadInfoCallback k;
    private TimerTask l;
    private List<NearbySearch.NearbyListener> a = new ArrayList();
    private LatLonPoint g = null;
    private String h = null;
    private boolean i = false;
    private Timer j = new Timer();

    /* compiled from: Taobao */
    /* renamed from: com.amap.api.col.s.bc$a */
    /* loaded from: classes10.dex */
    private class C4380a extends TimerTask {
        private C4380a() {
        }

        @Override // java.util.TimerTask, java.lang.Runnable
        public final void run() {
            try {
                if (bc.this.k != null) {
                    int b = bc.this.b(bc.this.k.OnUploadInfoCallback());
                    Message obtainMessage = bc.this.d.obtainMessage();
                    obtainMessage.arg1 = 10;
                    obtainMessage.obj = bc.this.a;
                    obtainMessage.what = b;
                    bc.this.d.sendMessage(obtainMessage);
                }
            } catch (Throwable th) {
                C4435i.a(th, "NearbySearch", "UpdateDataTask");
            }
        }

        /* synthetic */ C4380a(bc bcVar, byte b) {
            this();
        }
    }

    public bc(Context context) throws AMapException {
        bu a = bt.a(context, C4434h.a(false));
        if (a.a == bt.EnumC4398c.SuccessCode) {
            this.c = context.getApplicationContext();
            this.d = HandlerC4447t.a();
            return;
        }
        String str = a.b;
        throw new AMapException(str, 1, str, a.a.a());
    }

    @Override // com.amap.api.services.interfaces.INearbySearch
    public final synchronized void addNearbyListener(NearbySearch.NearbyListener nearbyListener) {
        try {
            this.a.add(nearbyListener);
        } catch (Throwable th) {
            C4435i.a(th, "NearbySearch", "addNearbyListener");
        }
    }

    @Override // com.amap.api.services.interfaces.INearbySearch
    public final void clearUserInfoAsyn() {
        try {
            ao.a().a(new Runnable() { // from class: com.amap.api.col.s.bc.1
                @Override // java.lang.Runnable
                public final void run() {
                    Message obtainMessage = bc.this.d.obtainMessage();
                    obtainMessage.arg1 = 8;
                    obtainMessage.obj = bc.this.a;
                    try {
                        try {
                            bc.this.a();
                            obtainMessage.what = 1000;
                            if (bc.this.d == null) {
                                return;
                            }
                        } catch (AMapException e2) {
                            obtainMessage.what = e2.getErrorCode();
                            C4435i.a(e2, "NearbySearch", "clearUserInfoAsyn");
                            if (bc.this.d == null) {
                                return;
                            }
                        }
                        bc.this.d.sendMessage(obtainMessage);
                    } catch (Throwable th) {
                        if (bc.this.d != null) {
                            bc.this.d.sendMessage(obtainMessage);
                        }
                        throw th;
                    }
                }
            });
        } catch (Throwable th) {
            C4435i.a(th, "NearbySearch", "clearUserInfoAsynThrowable");
        }
    }

    @Override // com.amap.api.services.interfaces.INearbySearch
    public final synchronized void destroy() {
        try {
            this.j.cancel();
        } catch (Throwable th) {
            C4435i.a(th, "NearbySearch", "destryoy");
        }
    }

    @Override // com.amap.api.services.interfaces.INearbySearch
    public final synchronized void removeNearbyListener(NearbySearch.NearbyListener nearbyListener) {
        if (nearbyListener == null) {
            return;
        }
        try {
            this.a.remove(nearbyListener);
        } catch (Throwable th) {
            C4435i.a(th, "NearbySearch", "removeNearbyListener");
        }
    }

    @Override // com.amap.api.services.interfaces.INearbySearch
    public final NearbySearchResult searchNearbyInfo(NearbySearch.NearbyQuery nearbyQuery) throws AMapException {
        try {
            C4444r.a(this.c);
            if (a(nearbyQuery)) {
                return new C4461v(this.c, nearbyQuery).b();
            }
            throw new AMapException("无效的参数 - IllegalArgumentException");
        } catch (AMapException e2) {
            throw e2;
        } catch (Throwable th) {
            C4435i.a(th, "NearbySearch", "searchNearbyInfo");
            throw new AMapException(AMapException.AMAP_CLIENT_UNKNOWN_ERROR);
        }
    }

    @Override // com.amap.api.services.interfaces.INearbySearch
    public final void searchNearbyInfoAsyn(final NearbySearch.NearbyQuery nearbyQuery) {
        try {
            ao.a().a(new Runnable() { // from class: com.amap.api.col.s.bc.3
                @Override // java.lang.Runnable
                public final void run() {
                    Message obtainMessage = bc.this.d.obtainMessage();
                    obtainMessage.arg1 = 9;
                    HandlerC4447t.C4453f c4453f = new HandlerC4447t.C4453f();
                    c4453f.a = bc.this.a;
                    obtainMessage.obj = c4453f;
                    try {
                        try {
                            c4453f.b = bc.this.searchNearbyInfo(nearbyQuery);
                            obtainMessage.what = 1000;
                            if (bc.this.d == null) {
                                return;
                            }
                        } catch (AMapException e2) {
                            obtainMessage.what = e2.getErrorCode();
                            C4435i.a(e2, "NearbySearch", "searchNearbyInfoAsyn");
                            if (bc.this.d == null) {
                                return;
                            }
                        }
                        bc.this.d.sendMessage(obtainMessage);
                    } catch (Throwable th) {
                        if (bc.this.d != null) {
                            bc.this.d.sendMessage(obtainMessage);
                        }
                        throw th;
                    }
                }
            });
        } catch (Throwable th) {
            C4435i.a(th, "NearbySearch", "searchNearbyInfoAsynThrowable");
        }
    }

    @Override // com.amap.api.services.interfaces.INearbySearch
    public final void setUserID(String str) {
        this.b = str;
    }

    @Override // com.amap.api.services.interfaces.INearbySearch
    public final synchronized void startUploadNearbyInfoAuto(UploadInfoCallback uploadInfoCallback, int i) {
        TimerTask timerTask;
        if (i < 7000) {
            i = LoginSwitch.LOGOUT_POST_DEFAULT;
        }
        try {
            this.k = uploadInfoCallback;
            if (this.i && (timerTask = this.l) != null) {
                timerTask.cancel();
            }
            this.i = true;
            C4380a c4380a = new C4380a(this, (byte) 0);
            this.l = c4380a;
            this.j.schedule(c4380a, 0L, i);
        } catch (Throwable th) {
            C4435i.a(th, "NearbySearch", "startUploadNearbyInfoAuto");
        }
    }

    @Override // com.amap.api.services.interfaces.INearbySearch
    public final synchronized void stopUploadNearbyInfoAuto() {
        try {
            TimerTask timerTask = this.l;
            if (timerTask != null) {
                timerTask.cancel();
            }
            this.i = false;
            this.l = null;
        }
    }

    @Override // com.amap.api.services.interfaces.INearbySearch
    public final void uploadNearbyInfoAsyn(final UploadInfo uploadInfo) {
        if (this.f == null) {
            this.f = Executors.newSingleThreadExecutor();
        }
        this.f.submit(new Runnable() { // from class: com.amap.api.col.s.bc.2
            @Override // java.lang.Runnable
            public final void run() {
                try {
                    Message obtainMessage = bc.this.d.obtainMessage();
                    obtainMessage.arg1 = 10;
                    obtainMessage.obj = bc.this.a;
                    obtainMessage.what = bc.this.a(uploadInfo);
                    bc.this.d.sendMessage(obtainMessage);
                } catch (Throwable th) {
                    C4435i.a(th, "NearbySearch", "uploadNearbyInfoAsyn");
                }
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public int a() throws AMapException {
        try {
            if (!this.i) {
                if (a(this.b)) {
                    C4444r.a(this.c);
                    return new C4460u(this.c, this.b).b().intValue();
                }
                throw new AMapException(AMapException.AMAP_CLIENT_USERID_ILLEGAL);
            }
            throw new AMapException(AMapException.AMAP_CLIENT_UPLOADAUTO_STARTED_ERROR);
        } catch (AMapException e2) {
            throw e2;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public int b(UploadInfo uploadInfo) {
        try {
            C4444r.a(this.c);
            if (uploadInfo == null) {
                return 2202;
            }
            long time = new Date().getTime();
            if (time - e < 6500) {
                return 2203;
            }
            e = time;
            String userID = uploadInfo.getUserID();
            if (a(userID)) {
                if (TextUtils.isEmpty(this.h)) {
                    this.h = userID;
                }
                if (userID.equals(this.h)) {
                    LatLonPoint point = uploadInfo.getPoint();
                    if (point != null && !point.equals(this.g)) {
                        new C4462w(this.c, uploadInfo).b();
                        this.g = point.copy();
                        return 1000;
                    }
                    return 2204;
                }
                return 2201;
            }
            return 2201;
        } catch (AMapException e2) {
            return e2.getErrorCode();
        } catch (Throwable unused) {
            return 1900;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public int a(UploadInfo uploadInfo) {
        if (this.i) {
            return 2200;
        }
        return b(uploadInfo);
    }

    private static boolean a(String str) {
        if (TextUtils.isEmpty(str)) {
            return false;
        }
        return Pattern.compile("^[a-z0-9A-Z_-]{1,32}$").matcher(str).find();
    }

    private static boolean a(NearbySearch.NearbyQuery nearbyQuery) {
        return (nearbyQuery == null || nearbyQuery.getCenterPoint() == null) ? false : true;
    }
}
