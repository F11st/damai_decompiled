package com.alipay.mobile.binarize;

import android.annotation.TargetApi;
import android.content.Context;
import android.content.SharedPreferences;
import android.graphics.Point;
import android.graphics.Rect;
import android.hardware.Camera;
import android.os.Handler;
import android.os.HandlerThread;
import com.alipay.ma.MaBuryRecord;
import com.alipay.ma.MaLogger;
import com.alipay.ma.analyze.api.MaEngineAPI;
import com.alipay.ma.decode.DecodeResult;
import com.uc.webview.export.extension.UCCore;
import java.util.Map;

/* compiled from: Taobao */
@TargetApi(24)
/* loaded from: classes10.dex */
public class RSMaEngineAPI extends MaEngineAPI {
    private HandlerThread e;
    private Handler f;
    private BinarizeHandler g;
    private volatile boolean h;
    private byte[] i;
    private int j;
    private int k;
    private boolean l;
    private volatile boolean m;
    private boolean n;
    private Context o;
    private DecodeResult[] p;
    private SharedPreferences q;
    public boolean rsBinarized;
    public int rsBinarizedCount = 0;
    public long rsInitCost = 0;
    public long rsInitStartTime = 0;
    public int classicFrameCount = 0;
    public int rsFrameCount = 0;

    /* JADX INFO: Access modifiers changed from: private */
    public DecodeResult[] l(byte[] bArr, Camera camera, Rect rect, Camera.Size size, int i, boolean z, int i2, float f) {
        return super.doProcess(bArr, camera, rect, size, i, z, i2, f);
    }

    private byte[] m(byte[] bArr, int i, int i2, Rect rect) {
        int min;
        int i3 = rect.left;
        int i4 = rect.top;
        int i5 = rect.right;
        this.j = i5;
        int i6 = rect.bottom;
        this.k = i6;
        if (i5 % 8 != 0) {
            this.j = (i5 / 8) * 8;
        }
        if (i6 % 8 != 0) {
            this.k = (i6 / 8) * 8;
        }
        int min2 = Math.min((i - i3) - 1, this.j);
        if (min2 > 0 && (min = Math.min((i2 - i4) - 1, this.k)) > 0) {
            byte[] bArr2 = this.i;
            if (bArr2 == null) {
                this.i = new byte[this.j * this.k];
            } else {
                int length = bArr2.length;
                int i7 = this.j;
                int i8 = this.k;
                if (length != i7 * i8) {
                    this.i = new byte[i7 * i8];
                }
            }
            for (int i9 = i4; i9 < min + i4; i9++) {
                System.arraycopy(bArr, (i9 * i) + i3, this.i, (i9 - i4) * this.j, min2);
            }
            int i10 = 0;
            int i11 = 0;
            for (int i12 = 0; i12 < this.k; i12 += 32) {
                int i13 = 0;
                while (true) {
                    int i14 = this.j;
                    if (i13 < i14) {
                        i11++;
                        i10 += this.i[(i14 * i12) + i13] & 255;
                        i13 += 32;
                    }
                }
            }
            this.c = i10 / i11;
            return this.i;
        }
        return null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public int n() {
        Context context;
        if (this.q == null && (context = this.o) != null) {
            this.q = context.getSharedPreferences("scan_rs_pref", 0);
        }
        SharedPreferences sharedPreferences = this.q;
        if (sharedPreferences != null) {
            return sharedPreferences.getInt("pref_rs_exception", 0);
        }
        return 0;
    }

    private DecodeResult[] o(byte[] bArr, final Camera camera, final Rect rect, final Camera.Size size, final int i, final float f) {
        DecodeResult[] decodeResultArr = this.p;
        if (decodeResultArr != null) {
            return decodeResultArr;
        }
        MaLogger.d("RSMaEngineAPI", "rs before binarize");
        if (rect != null) {
            if (rect.left < 0) {
                rect.left = 0;
            }
            if (rect.top < 0) {
                rect.top = 0;
            }
            int i2 = rect.right;
            int i3 = size.width;
            if (i2 > i3) {
                rect.right = i3;
            }
            int i4 = rect.bottom;
            int i5 = size.height;
            if (i4 > i5) {
                rect.bottom = i5;
            }
            m(bArr, i3, i5, rect);
            int i6 = this.j;
            rect.right = i6;
            int i7 = this.k;
            rect.bottom = i7;
            this.g.doBinarize(this.i, i6, i7);
            this.rsBinarizedCount++;
            MaLogger.d("RSMaEngineAPI", "rs after binarize");
            DecodeResult[] decodeResultArr2 = this.p;
            if (decodeResultArr2 != null) {
                return decodeResultArr2;
            }
            if (this.h) {
                return null;
            }
            this.f.post(new Runnable() { // from class: com.alipay.mobile.binarize.RSMaEngineAPI.2
                @Override // java.lang.Runnable
                public void run() {
                    DecodeResult[] l;
                    RSMaEngineAPI.this.h = true;
                    while (!RSMaEngineAPI.this.g.isBinarizePoolEmpty()) {
                        MaLogger.d("RSMaEngineAPI", "rs start recognize");
                        BinarizeResult popFirstBinarizeResult = RSMaEngineAPI.this.g.popFirstBinarizeResult();
                        if (popFirstBinarizeResult == null) {
                            break;
                        }
                        RSMaEngineAPI rSMaEngineAPI = RSMaEngineAPI.this;
                        rSMaEngineAPI.rsFrameCount++;
                        try {
                            l = rSMaEngineAPI.l(popFirstBinarizeResult.bitMatrixData, camera, rect, size, i, true, popFirstBinarizeResult.methodId, f);
                        } catch (Exception e) {
                            MaLogger.w("RSMaEngineAPI", "doProcessBinary exception:" + e);
                        }
                        if (l != null) {
                            RSMaEngineAPI.this.p = l;
                            RSMaEngineAPI rSMaEngineAPI2 = RSMaEngineAPI.this;
                            rSMaEngineAPI2.rsBinarized = true;
                            rSMaEngineAPI2.h = false;
                            MaLogger.d("RSMaEngineAPI", "recognize rs binarize code");
                            break;
                        }
                        continue;
                    }
                    RSMaEngineAPI.this.h = false;
                }
            });
        }
        return null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void p(int i) {
        Context context;
        if (this.q == null && (context = this.o) != null) {
            this.q = context.getSharedPreferences("scan_rs_pref", 0);
        }
        SharedPreferences sharedPreferences = this.q;
        if (sharedPreferences != null) {
            sharedPreferences.edit().putInt("pref_rs_exception", i).apply();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.alipay.ma.analyze.api.MaEngineAPI
    public int a() {
        if (this.l) {
            return this.c;
        }
        return super.a();
    }

    @Override // com.alipay.ma.analyze.api.MaEngineAPI
    public void destroy() {
        super.destroy();
        if (this.l) {
            this.e.quit();
            StringBuilder sb = new StringBuilder();
            sb.append("destroy, binarizeHandler == null:");
            sb.append(this.g == null);
            MaLogger.d("RSMaEngineAPI", sb.toString());
            if (this.g != null) {
                try {
                    int n = n();
                    p(n + 1);
                    this.g.destroy();
                    p(n);
                } catch (Exception e) {
                    MaLogger.d("RSMaEngineAPI", "release binarizer exception2 " + e);
                    MaBuryRecord.recordRsBinarizeException("release");
                }
            }
            this.h = false;
            this.m = false;
        }
        this.n = true;
    }

    @Override // com.alipay.ma.analyze.api.MaEngineAPI
    public DecodeResult[] doProcess(byte[] bArr, Camera camera, Rect rect, Camera.Size size, int i, boolean z, int i2, float f) {
        if (this.l && this.m) {
            MaLogger.d("RSMaEngineAPI", "process binary");
            try {
                return o(bArr, camera, rect, size, i, f);
            } catch (Exception e) {
                MaLogger.d("RSMaEngineAPI", "process binarize exception " + e);
                this.l = false;
                this.e.quit();
                if (this.g != null) {
                    this.g.destroy();
                }
                this.m = false;
                MaBuryRecord.recordRsBinarizeException("binarize");
                return null;
            }
        }
        this.classicFrameCount++;
        return super.doProcess(bArr, camera, rect, size, i, false, 0, f);
    }

    @Override // com.alipay.ma.analyze.api.MaEngineAPI
    public boolean init(Context context, Map<String, Object> map) {
        this.o = context;
        if (map != null && map.containsKey(BinarizeUtils.KEY_ENABLE_RS_BINARIZE)) {
            boolean z = ((Boolean) map.get(BinarizeUtils.KEY_ENABLE_RS_BINARIZE)).booleanValue() && BinarizeUtils.supportRsBinarize();
            this.l = z;
            if (z && n() >= 2) {
                MaBuryRecord.recordRsExceptionLimitation();
                this.l = false;
            }
        } else {
            this.l = false;
        }
        this.n = false;
        this.m = false;
        this.classicFrameCount = 0;
        this.rsFrameCount = 0;
        if (this.l) {
            MaLogger.d("RSMaEngineAPI", "before init");
            this.o = context;
            this.rsBinarizedCount = 0;
            this.rsInitStartTime = System.currentTimeMillis();
            HandlerThread handlerThread = new HandlerThread("Scan-Recognize", 10);
            this.e = handlerThread;
            handlerThread.start();
            Handler handler = new Handler(this.e.getLooper());
            this.f = handler;
            handler.post(new Runnable() { // from class: com.alipay.mobile.binarize.RSMaEngineAPI.1
                @Override // java.lang.Runnable
                public void run() {
                    int n = RSMaEngineAPI.this.n();
                    RSMaEngineAPI.this.p(n + 1);
                    try {
                        RSMaEngineAPI.this.g = new BinarizeHandler(RSMaEngineAPI.this.o);
                        RSMaEngineAPI.this.m = true;
                        RSMaEngineAPI.this.rsInitCost = System.currentTimeMillis() - RSMaEngineAPI.this.rsInitStartTime;
                    } catch (Exception e) {
                        MaLogger.d("RSMaEngineAPI", "init binarizer exception " + e);
                        MaBuryRecord.recordRsBinarizeException(UCCore.LEGACY_EVENT_INIT);
                    }
                    if (RSMaEngineAPI.this.n && RSMaEngineAPI.this.g != null) {
                        try {
                            RSMaEngineAPI.this.g.destroy();
                            RSMaEngineAPI.this.m = false;
                        } catch (Exception e2) {
                            MaLogger.d("RSMaEngineAPI", "release binarizer exception1 " + e2);
                            MaBuryRecord.recordRsBinarizeException("release");
                        }
                    }
                    RSMaEngineAPI.this.p(n);
                }
            });
            this.h = false;
        }
        return super.init(context, map);
    }

    @Override // com.alipay.ma.analyze.api.MaEngineAPI
    public void resetRecognizeResults() {
        this.p = null;
    }

    @Override // com.alipay.ma.analyze.api.MaEngineAPI
    public boolean useRsBinary() {
        return this.l;
    }

    @Override // com.alipay.ma.analyze.api.MaEngineAPI
    public DecodeResult[] doProcess(byte[] bArr, Rect rect, Point point, int i, int i2, boolean z, int i3, float f) {
        this.classicFrameCount++;
        return super.doProcess(bArr, rect, point, i, i2, z, i3, f);
    }
}
