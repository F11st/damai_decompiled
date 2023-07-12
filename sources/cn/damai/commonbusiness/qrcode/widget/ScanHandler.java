package cn.damai.commonbusiness.qrcode.widget;

import android.content.Context;
import android.media.AudioManager;
import android.media.MediaPlayer;
import android.os.Handler;
import android.os.HandlerThread;
import cn.damai.commonbusiness.R$raw;
import com.alipay.mobile.bqcscanservice.BQCCameraParam;
import com.alipay.mobile.bqcscanservice.BQCScanEngine;
import com.alipay.mobile.bqcscanservice.MPaasScanService;
import com.alipay.mobile.mascanengine.MaEngineService;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;

/* compiled from: Taobao */
/* loaded from: classes4.dex */
public class ScanHandler {
    private static transient /* synthetic */ IpChange $ipChange;
    private HandlerThread a;
    private Handler b;
    private Context c;
    private ScanResultCallbackProducer d;
    private MediaPlayer e;
    private MPaasScanService f;
    private int g;

    /* compiled from: Taobao */
    /* loaded from: classes4.dex */
    public interface ScanResultCallbackProducer {
        BQCScanEngine.EngineCallback makeScanResultCallback(ScanType scanType);
    }

    public ScanHandler() {
        HandlerThread handlerThread = new HandlerThread("Scan-Recognized", 10);
        this.a = handlerThread;
        handlerThread.start();
        this.b = new Handler(this.a.getLooper());
    }

    public void j() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-726665223")) {
            ipChange.ipc$dispatch("-726665223", new Object[]{this});
        } else {
            this.a.quit();
        }
    }

    public void k() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1612377998")) {
            ipChange.ipc$dispatch("1612377998", new Object[]{this});
        } else {
            this.b.post(new Runnable() { // from class: cn.damai.commonbusiness.qrcode.widget.ScanHandler.5
                private static transient /* synthetic */ IpChange $ipChange;

                @Override // java.lang.Runnable
                public void run() {
                    IpChange ipChange2 = $ipChange;
                    if (AndroidInstantRuntime.support(ipChange2, "771328215")) {
                        ipChange2.ipc$dispatch("771328215", new Object[]{this});
                        return;
                    }
                    ScanHandler.this.g = 6;
                    ScanHandler.this.f.setScanEnable(false);
                }
            });
        }
    }

    public void l() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1030265175")) {
            ipChange.ipc$dispatch("1030265175", new Object[]{this});
        } else {
            this.b.post(new Runnable() { // from class: cn.damai.commonbusiness.qrcode.widget.ScanHandler.3
                private static transient /* synthetic */ IpChange $ipChange;

                @Override // java.lang.Runnable
                public void run() {
                    IpChange ipChange2 = $ipChange;
                    if (AndroidInstantRuntime.support(ipChange2, "1164355225")) {
                        ipChange2.ipc$dispatch("1164355225", new Object[]{this});
                        return;
                    }
                    ScanHandler.this.g = 4;
                    ScanHandler.this.f.setScanEnable(true);
                }
            });
        }
    }

    public void m(boolean z) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-730105759")) {
            ipChange.ipc$dispatch("-730105759", new Object[]{this, Boolean.valueOf(z)});
        } else {
            this.b.post(new Runnable() { // from class: cn.damai.commonbusiness.qrcode.widget.ScanHandler.2
                private static transient /* synthetic */ IpChange $ipChange;

                @Override // java.lang.Runnable
                public void run() {
                    IpChange ipChange2 = $ipChange;
                    if (AndroidInstantRuntime.support(ipChange2, "1360868730")) {
                        ipChange2.ipc$dispatch("1360868730", new Object[]{this});
                    } else if (ScanHandler.this.d == null) {
                    } else {
                        MaEngineService maEngineService = new MaEngineService();
                        MPaasScanService mPaasScanService = ScanHandler.this.f;
                        ScanType scanType = ScanType.SCAN_MA;
                        mPaasScanService.regScanEngine(scanType.toBqcScanType(), maEngineService.getEngineClazz(), ScanHandler.this.d.makeScanResultCallback(scanType));
                    }
                }
            });
        }
    }

    public void n() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "434963272")) {
            ipChange.ipc$dispatch("434963272", new Object[]{this});
        } else {
            this.b.post(new Runnable() { // from class: cn.damai.commonbusiness.qrcode.widget.ScanHandler.7
                private static transient /* synthetic */ IpChange $ipChange;

                @Override // java.lang.Runnable
                public void run() {
                    IpChange ipChange2 = $ipChange;
                    if (AndroidInstantRuntime.support(ipChange2, "378301205")) {
                        ipChange2.ipc$dispatch("378301205", new Object[]{this});
                        return;
                    }
                    ScanHandler.this.c = null;
                    ScanHandler.this.d = null;
                    if (ScanHandler.this.e != null) {
                        ScanHandler.this.e.release();
                        ScanHandler.this.e = null;
                    }
                }
            });
        }
    }

    public void o() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1197369852")) {
            ipChange.ipc$dispatch("-1197369852", new Object[]{this});
        } else {
            this.b.post(new Runnable() { // from class: cn.damai.commonbusiness.qrcode.widget.ScanHandler.8
                private static transient /* synthetic */ IpChange $ipChange;

                @Override // java.lang.Runnable
                public void run() {
                    IpChange ipChange2 = $ipChange;
                    if (AndroidInstantRuntime.support(ipChange2, "181787700")) {
                        ipChange2.ipc$dispatch("181787700", new Object[]{this});
                    } else {
                        ScanHandler.this.g = 0;
                    }
                }
            });
        }
    }

    public void p(final MPaasScanService mPaasScanService) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1966059209")) {
            ipChange.ipc$dispatch("-1966059209", new Object[]{this, mPaasScanService});
        } else {
            this.b.post(new Runnable() { // from class: cn.damai.commonbusiness.qrcode.widget.ScanHandler.1
                private static transient /* synthetic */ IpChange $ipChange;

                @Override // java.lang.Runnable
                public void run() {
                    IpChange ipChange2 = $ipChange;
                    if (AndroidInstantRuntime.support(ipChange2, "1557382235")) {
                        ipChange2.ipc$dispatch("1557382235", new Object[]{this});
                        return;
                    }
                    ScanHandler.this.f = mPaasScanService;
                    ScanHandler.this.g = 1;
                }
            });
        }
    }

    public void q(final Context context, final ScanResultCallbackProducer scanResultCallbackProducer) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-554260206")) {
            ipChange.ipc$dispatch("-554260206", new Object[]{this, context, scanResultCallbackProducer});
        } else {
            this.b.post(new Runnable() { // from class: cn.damai.commonbusiness.qrcode.widget.ScanHandler.9
                private static transient /* synthetic */ IpChange $ipChange;

                @Override // java.lang.Runnable
                public void run() {
                    IpChange ipChange2 = $ipChange;
                    if (AndroidInstantRuntime.support(ipChange2, "-14725805")) {
                        ipChange2.ipc$dispatch("-14725805", new Object[]{this});
                        return;
                    }
                    ScanHandler.this.c = context;
                    ScanHandler.this.d = scanResultCallbackProducer;
                }
            });
        }
    }

    public void r(final ScanType scanType, final BQCCameraParam.MaEngineType maEngineType) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1370773405")) {
            ipChange.ipc$dispatch("-1370773405", new Object[]{this, scanType, maEngineType});
        } else {
            this.b.post(new Runnable() { // from class: cn.damai.commonbusiness.qrcode.widget.ScanHandler.4
                private static transient /* synthetic */ IpChange $ipChange;

                @Override // java.lang.Runnable
                public void run() {
                    IpChange ipChange2 = $ipChange;
                    if (AndroidInstantRuntime.support(ipChange2, "967841720")) {
                        ipChange2.ipc$dispatch("967841720", new Object[]{this});
                        return;
                    }
                    ScanHandler.this.g = 5;
                    ScanHandler.this.f.setScanType(scanType.toBqcScanType(), maEngineType);
                }
            });
        }
    }

    public void s() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-477346361")) {
            ipChange.ipc$dispatch("-477346361", new Object[]{this});
        } else {
            this.b.post(new Runnable() { // from class: cn.damai.commonbusiness.qrcode.widget.ScanHandler.6
                private static transient /* synthetic */ IpChange $ipChange;

                @Override // java.lang.Runnable
                public void run() {
                    IpChange ipChange2 = $ipChange;
                    if (AndroidInstantRuntime.support(ipChange2, "574814710")) {
                        ipChange2.ipc$dispatch("574814710", new Object[]{this});
                    } else if (ScanHandler.this.c == null || ((AudioManager) ScanHandler.this.c.getSystemService("audio")).getStreamVolume(5) == 0) {
                    } else {
                        if (ScanHandler.this.e == null) {
                            ScanHandler scanHandler = ScanHandler.this;
                            scanHandler.e = MediaPlayer.create(scanHandler.c, R$raw.qrcode_completed);
                        }
                        if (ScanHandler.this.e != null) {
                            ScanHandler.this.e.start();
                        }
                    }
                }
            });
        }
    }
}
