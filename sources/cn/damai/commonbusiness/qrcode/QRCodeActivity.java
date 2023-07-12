package cn.damai.commonbusiness.qrcode;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.res.AssetFileDescriptor;
import android.graphics.Rect;
import android.hardware.Camera;
import android.media.MediaPlayer;
import android.os.Build;
import android.os.Bundle;
import android.os.Vibrator;
import android.text.TextUtils;
import android.util.Log;
import android.view.SurfaceHolder;
import android.view.SurfaceView;
import android.view.View;
import cn.damai.commonbusiness.R$id;
import cn.damai.commonbusiness.R$layout;
import cn.damai.commonbusiness.R$raw;
import cn.damai.commonbusiness.R$string;
import cn.damai.commonbusiness.base.DamaiBaseActivity;
import cn.damai.commonbusiness.qrcode.util.QrcodeUtil;
import cn.damai.commonbusiness.qrcode.widget.APTextureView;
import cn.damai.commonbusiness.qrcode.widget.AutoZoomOperator;
import cn.damai.commonbusiness.qrcode.widget.ScanHandler;
import cn.damai.commonbusiness.qrcode.widget.ScanType;
import cn.damai.commonbusiness.qrcode.widget.ToolScanTopView;
import cn.damai.uikit.iconfont.DMIconFontTextView;
import com.alipay.ma.MaLogger;
import com.alipay.mobile.bqcscanservice.BQCCameraParam;
import com.alipay.mobile.bqcscanservice.BQCScanCallback;
import com.alipay.mobile.bqcscanservice.BQCScanEngine;
import com.alipay.mobile.bqcscanservice.BQCScanError;
import com.alipay.mobile.bqcscanservice.BQCScanResult;
import com.alipay.mobile.bqcscanservice.CameraHandler;
import com.alipay.mobile.bqcscanservice.MPaasLogger;
import com.alipay.mobile.bqcscanservice.MPaasScanService;
import com.alipay.mobile.mascanengine.IOnMaSDKDecodeInfo;
import com.alipay.mobile.mascanengine.MaScanCallback;
import com.alipay.mobile.mascanengine.MaScanResult;
import com.alipay.mobile.mascanengine.MultiMaScanResult;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import tb.b62;
import tb.cb1;
import tb.fy1;
import tb.gn1;
import tb.sc1;

/* compiled from: Taobao */
/* loaded from: classes4.dex */
public class QRCodeActivity extends DamaiBaseActivity implements ScanHandler.ScanResultCallbackProducer {
    private static transient /* synthetic */ IpChange $ipChange = null;
    private static final float BEEP_VOLUME = 0.5f;
    private static final int LOCAL_PICS_REQUEST = 2;
    private static final long VIBRATE_DURATION = 200;
    private boolean albumRecognizing;
    private AutoZoomOperator autoZoomOperator;
    private MPaasScanService bqcScanService;
    private boolean bqcServiceSetup;
    private CameraHandler cameraScanHandler;
    DMIconFontTextView mFlashLight;
    private ToolScanTopView mScanTopView;
    private SurfaceHolder mSurfaceHolder;
    private SurfaceView mSurfaceView;
    private APTextureView mTextureView;
    private MediaPlayer mediaPlayer;
    private boolean playBeep;
    private ScanHandler scanHandler;
    private Rect scanRect;
    private boolean vibrate;
    private final String TAG = "ToolsCaptureActivity";
    private ScanType mScanType = ScanType.SCAN_MA;
    private BQCCameraParam.MaEngineType mEngineType = BQCCameraParam.MaEngineType.DEFAULT;
    private boolean firstAutoStarted = false;
    private boolean isPermissionGranted = false;
    private int pauseOrResume = 0;
    private boolean scanSuccess = false;
    private long postcode = -1;
    private boolean mUseNewSurface = false;
    private BQCScanCallback bqcCallback = new BQCScanCallback() { // from class: cn.damai.commonbusiness.qrcode.QRCodeActivity.1
        private static transient /* synthetic */ IpChange $ipChange;

        @Override // com.alipay.mobile.bqcscanservice.BQCScanCallback
        public void onCameraAutoFocus(boolean z) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "59024238")) {
                ipChange.ipc$dispatch("59024238", new Object[]{this, Boolean.valueOf(z)});
            }
        }

        @Override // com.alipay.mobile.bqcscanservice.BQCScanCallback
        public void onCameraClose() {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "-552419017")) {
                ipChange.ipc$dispatch("-552419017", new Object[]{this});
            }
        }

        @Override // com.alipay.mobile.bqcscanservice.BQCScanCallback
        public void onCameraErrorResult(int i2) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "1019146233")) {
                ipChange.ipc$dispatch("1019146233", new Object[]{this, Integer.valueOf(i2)});
            }
        }

        @Override // com.alipay.mobile.bqcscanservice.BQCScanCallback
        public void onCameraFrameRecognized(boolean z, long j2) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "-1669219492")) {
                ipChange.ipc$dispatch("-1669219492", new Object[]{this, Boolean.valueOf(z), Long.valueOf(j2)});
            }
        }

        @Override // com.alipay.mobile.bqcscanservice.BQCScanCallback
        public void onCameraManualFocusResult(boolean z) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "-1943052940")) {
                ipChange.ipc$dispatch("-1943052940", new Object[]{this, Boolean.valueOf(z)});
            }
        }

        @Override // com.alipay.mobile.bqcscanservice.BQCScanCallback
        public void onCameraOpened() {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "2090073842")) {
                ipChange.ipc$dispatch("2090073842", new Object[]{this});
            } else {
                int unused = QRCodeActivity.this.pauseOrResume;
            }
        }

        @Override // com.alipay.mobile.bqcscanservice.BQCScanCallback
        public void onCameraParametersSetFailed() {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "298652698")) {
                ipChange.ipc$dispatch("298652698", new Object[]{this});
            }
        }

        @Override // com.alipay.mobile.bqcscanservice.BQCScanCallback
        public void onCameraReady() {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "1783275948")) {
                ipChange.ipc$dispatch("1783275948", new Object[]{this});
            }
        }

        @Override // com.alipay.mobile.bqcscanservice.BQCScanCallback
        public void onEngineLoadSuccess() {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "1899816367")) {
                ipChange.ipc$dispatch("1899816367", new Object[]{this});
            }
        }

        @Override // com.alipay.mobile.bqcscanservice.BQCScanCallback
        public void onError(BQCScanError bQCScanError) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "991862163")) {
                ipChange.ipc$dispatch("991862163", new Object[]{this, bQCScanError});
                return;
            }
            Log.d("ToolsCaptureActivity", "onError(),error=" + bQCScanError.msg);
            if (QRCodeActivity.this.pauseOrResume == -1 || QRCodeActivity.this.isFinishing()) {
                return;
            }
            if (TextUtils.equals(bQCScanError.msg, "Requested camera does not exist")) {
                QRCodeActivity.this.runOnUiThread(new Runnable() { // from class: cn.damai.commonbusiness.qrcode.QRCodeActivity.1.3
                    private static transient /* synthetic */ IpChange $ipChange;

                    @Override // java.lang.Runnable
                    public void run() {
                        IpChange ipChange2 = $ipChange;
                        if (AndroidInstantRuntime.support(ipChange2, "1885010705")) {
                            ipChange2.ipc$dispatch("1885010705", new Object[]{this});
                        } else {
                            QRCodeActivity.this.showFrontCameraScanGuideDialog("getString(R.string.back_camera_error_msg)");
                        }
                    }
                });
            } else {
                QRCodeActivity.this.runOnUiThread(new Runnable() { // from class: cn.damai.commonbusiness.qrcode.QRCodeActivity.1.4
                    private static transient /* synthetic */ IpChange $ipChange;

                    @Override // java.lang.Runnable
                    public void run() {
                        IpChange ipChange2 = $ipChange;
                        if (AndroidInstantRuntime.support(ipChange2, "1688497200")) {
                            ipChange2.ipc$dispatch("1688497200", new Object[]{this});
                        } else {
                            QRCodeActivity.this.showAlertDialog("getString(R.string.camera_open_error)");
                        }
                    }
                });
            }
        }

        @Override // com.alipay.mobile.bqcscanservice.BQCScanCallback
        public void onFirstFrameRecognized() {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "1192780717")) {
                ipChange.ipc$dispatch("1192780717", new Object[]{this});
            }
        }

        @Override // com.alipay.mobile.bqcscanservice.BQCScanCallback
        public void onOuterEnvDetected(boolean z) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "388491208")) {
                ipChange.ipc$dispatch("388491208", new Object[]{this, Boolean.valueOf(z)});
            }
        }

        @Override // com.alipay.mobile.bqcscanservice.BQCScanCallback
        public void onParametersSetted(final long j2) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "1487651871")) {
                ipChange.ipc$dispatch("1487651871", new Object[]{this, Long.valueOf(j2)});
            } else if (QRCodeActivity.this.isFinishing()) {
            } else {
                QRCodeActivity.this.runOnUiThread(new Runnable() { // from class: cn.damai.commonbusiness.qrcode.QRCodeActivity.1.1
                    private static transient /* synthetic */ IpChange $ipChange;

                    @Override // java.lang.Runnable
                    public void run() {
                        IpChange ipChange2 = $ipChange;
                        if (AndroidInstantRuntime.support(ipChange2, "-2016929581")) {
                            ipChange2.ipc$dispatch("-2016929581", new Object[]{this});
                            return;
                        }
                        QRCodeActivity.this.postcode = j2;
                        QRCodeActivity.this.bqcServiceSetup = true;
                        QRCodeActivity.this.configPreviewAndRecognitionEngine();
                    }
                });
            }
        }

        @Override // com.alipay.mobile.bqcscanservice.BQCScanCallback
        public void onPreOpenCamera() {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "-382320552")) {
                ipChange.ipc$dispatch("-382320552", new Object[]{this});
            }
        }

        @Override // com.alipay.mobile.bqcscanservice.BQCScanCallback
        public void onPreviewFrameShow() {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "-634485314")) {
                ipChange.ipc$dispatch("-634485314", new Object[]{this});
            } else if (QRCodeActivity.this.pauseOrResume == -1 || QRCodeActivity.this.isFinishing()) {
            } else {
                QRCodeActivity.this.runOnUiThread(new Runnable() { // from class: cn.damai.commonbusiness.qrcode.QRCodeActivity.1.2
                    private static transient /* synthetic */ IpChange $ipChange;

                    @Override // java.lang.Runnable
                    public void run() {
                        IpChange ipChange2 = $ipChange;
                        if (AndroidInstantRuntime.support(ipChange2, "2081524210")) {
                            ipChange2.ipc$dispatch("2081524210", new Object[]{this});
                        } else {
                            QRCodeActivity.this.initScanRect();
                        }
                    }
                });
            }
        }

        @Override // com.alipay.mobile.bqcscanservice.BQCScanCallback
        public void onSetEnable() {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "-1224613243")) {
                ipChange.ipc$dispatch("-1224613243", new Object[]{this});
            }
        }

        @Override // com.alipay.mobile.bqcscanservice.BQCScanCallback
        public void onStartingPreview() {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "-381083390")) {
                ipChange.ipc$dispatch("-381083390", new Object[]{this});
            }
        }

        @Override // com.alipay.mobile.bqcscanservice.BQCScanCallback
        public void onSurfaceAvaliable() {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "1260054634")) {
                ipChange.ipc$dispatch("1260054634", new Object[]{this});
            } else if (QRCodeActivity.this.pauseOrResume == -1 || QRCodeActivity.this.bqcScanService == null) {
            } else {
                QRCodeActivity.this.cameraScanHandler.onSurfaceViewAvailable();
            }
        }

        @Override // com.alipay.mobile.bqcscanservice.BQCScanCallback
        public void onSurfaceUpdated() {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "-794702638")) {
                ipChange.ipc$dispatch("-794702638", new Object[]{this});
            }
        }
    };
    private boolean mIsFlashlightOpen = false;
    private ToolScanTopView.TopViewCallback topViewCallback = new d();
    private final MediaPlayer.OnCompletionListener beepListener = new c(this);

    /* compiled from: Taobao */
    /* loaded from: classes4.dex */
    interface MaScanCallbackWithDecodeInfoSupport extends IOnMaSDKDecodeInfo, MaScanCallback {
    }

    /* compiled from: Taobao */
    /* loaded from: classes4.dex */
    public class a implements MPaasLogger.BqcLogger {
        private static transient /* synthetic */ IpChange $ipChange;

        a(QRCodeActivity qRCodeActivity) {
        }

        @Override // com.alipay.mobile.bqcscanservice.MPaasLogger.BqcLogger
        public boolean checkStringBuilderValid(StringBuilder sb) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "121540706")) {
                return ((Boolean) ipChange.ipc$dispatch("121540706", new Object[]{this, sb})).booleanValue();
            }
            return true;
        }

        @Override // com.alipay.mobile.bqcscanservice.MPaasLogger.BqcLogger
        public void d(String str, StringBuilder sb) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "436945278")) {
                ipChange.ipc$dispatch("436945278", new Object[]{this, str, sb});
                return;
            }
            Log.d("[scan]" + str, sb.toString());
        }

        @Override // com.alipay.mobile.bqcscanservice.MPaasLogger.BqcLogger
        public void e(String str, StringBuilder sb) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "-1887082561")) {
                ipChange.ipc$dispatch("-1887082561", new Object[]{this, str, sb});
                return;
            }
            Log.e("[scan]" + str, sb.toString());
        }

        @Override // com.alipay.mobile.bqcscanservice.MPaasLogger.BqcLogger
        public StringBuilder getLocalStringBuilder() {
            IpChange ipChange = $ipChange;
            return AndroidInstantRuntime.support(ipChange, "-78534259") ? (StringBuilder) ipChange.ipc$dispatch("-78534259", new Object[]{this}) : new StringBuilder();
        }

        @Override // com.alipay.mobile.bqcscanservice.MPaasLogger.BqcLogger
        public void i(String str, StringBuilder sb) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "1701707971")) {
                ipChange.ipc$dispatch("1701707971", new Object[]{this, str, sb});
                return;
            }
            Log.i("[scan]" + str, sb.toString());
        }

        @Override // com.alipay.mobile.bqcscanservice.MPaasLogger.BqcLogger
        public boolean isDebuggable() {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "1835826415")) {
                return ((Boolean) ipChange.ipc$dispatch("1835826415", new Object[]{this})).booleanValue();
            }
            return true;
        }

        @Override // com.alipay.mobile.bqcscanservice.MPaasLogger.BqcLogger
        public void v(String str, StringBuilder sb) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "1554117136")) {
                ipChange.ipc$dispatch("1554117136", new Object[]{this, str, sb});
                return;
            }
            Log.v("[scan]" + str, sb.toString());
        }

        @Override // com.alipay.mobile.bqcscanservice.MPaasLogger.BqcLogger
        public void w(String str, StringBuilder sb) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "-769910703")) {
                ipChange.ipc$dispatch("-769910703", new Object[]{this, str, sb});
                return;
            }
            Log.w("[scan]" + str, sb.toString());
        }

        @Override // com.alipay.mobile.bqcscanservice.MPaasLogger.BqcLogger
        public void e(String str, StringBuilder sb, Throwable th) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "99559830")) {
                ipChange.ipc$dispatch("99559830", new Object[]{this, str, sb, th});
                return;
            }
            Log.d("[scan]" + str, sb.toString(), th);
        }
    }

    /* compiled from: Taobao */
    /* loaded from: classes4.dex */
    public class b implements MaLogger.MaEngineLogger {
        private static transient /* synthetic */ IpChange $ipChange;

        b(QRCodeActivity qRCodeActivity) {
        }

        @Override // com.alipay.ma.MaLogger.MaEngineLogger
        public void d(String str, String str2) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "-210046666")) {
                ipChange.ipc$dispatch("-210046666", new Object[]{this, str, str2});
                return;
            }
            Log.d("[scan]" + str, str2);
        }

        @Override // com.alipay.ma.MaLogger.MaEngineLogger
        public void e(String str, String str2) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "1251533333")) {
                ipChange.ipc$dispatch("1251533333", new Object[]{this, str, str2});
                return;
            }
            Log.e("[scan]" + str, str2);
        }

        @Override // com.alipay.ma.MaLogger.MaEngineLogger
        public void i(String str, String str2) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "-1492081263")) {
                ipChange.ipc$dispatch("-1492081263", new Object[]{this, str, str2});
                return;
            }
            Log.i("[scan]" + str, str2);
        }

        @Override // com.alipay.ma.MaLogger.MaEngineLogger
        public boolean isDebuggable() {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "991354544")) {
                return ((Boolean) ipChange.ipc$dispatch("991354544", new Object[]{this})).booleanValue();
            }
            return true;
        }

        @Override // com.alipay.ma.MaLogger.MaEngineLogger
        public void v(String str, String str2) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "328589540")) {
                ipChange.ipc$dispatch("328589540", new Object[]{this, str, str2});
                return;
            }
            Log.v("[scan]" + str, str2);
        }

        @Override // com.alipay.ma.MaLogger.MaEngineLogger
        public void w(String str, String str2) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "1790169539")) {
                ipChange.ipc$dispatch("1790169539", new Object[]{this, str, str2});
                return;
            }
            Log.w("[scan]" + str, str2);
        }

        @Override // com.alipay.ma.MaLogger.MaEngineLogger
        public void e(String str, String str2, Throwable th) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "-258432768")) {
                ipChange.ipc$dispatch("-258432768", new Object[]{this, str, str2, th});
                return;
            }
            Log.e("[scan]" + str, str2, th);
        }
    }

    /* compiled from: Taobao */
    /* loaded from: classes4.dex */
    public class c implements MediaPlayer.OnCompletionListener {
        private static transient /* synthetic */ IpChange $ipChange;

        c(QRCodeActivity qRCodeActivity) {
        }

        @Override // android.media.MediaPlayer.OnCompletionListener
        public void onCompletion(MediaPlayer mediaPlayer) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "-393398147")) {
                ipChange.ipc$dispatch("-393398147", new Object[]{this, mediaPlayer});
            } else {
                mediaPlayer.seekTo(0);
            }
        }
    }

    /* compiled from: Taobao */
    /* loaded from: classes4.dex */
    public class d implements ToolScanTopView.TopViewCallback {
        private static transient /* synthetic */ IpChange $ipChange;

        d() {
        }

        @Override // cn.damai.commonbusiness.qrcode.widget.ToolScanTopView.TopViewCallback
        public void clearSurface() {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "-1976496096")) {
                ipChange.ipc$dispatch("-1976496096", new Object[]{this});
            }
        }

        @Override // cn.damai.commonbusiness.qrcode.widget.ToolScanTopView.TopViewCallback
        public void onAlbumResult(MaScanResult[] maScanResultArr) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "-869718603")) {
                ipChange.ipc$dispatch("-869718603", new Object[]{this, maScanResultArr});
                return;
            }
            QRCodeActivity.this.scanSuccess = true;
            QRCodeActivity.this.albumRecognizing = false;
            if (QRCodeActivity.this.scanHandler != null) {
                QRCodeActivity.this.scanHandler.k();
            }
            if (QRCodeActivity.this.mScanTopView != null) {
                QRCodeActivity.this.mScanTopView.onResultMa(maScanResultArr);
            }
        }

        @Override // cn.damai.commonbusiness.qrcode.widget.ToolScanTopView.TopViewCallback
        public void scanSuccess() {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "-1288747196")) {
                ipChange.ipc$dispatch("-1288747196", new Object[]{this});
            } else {
                QRCodeActivity.this.scanSuccess = true;
            }
        }

        @Override // cn.damai.commonbusiness.qrcode.widget.ToolScanTopView.TopViewCallback
        public void selectPic() {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "1188147036")) {
                ipChange.ipc$dispatch("1188147036", new Object[]{this});
                return;
            }
            Intent intent = new Intent("android.intent.action.GET_CONTENT");
            intent.setType("image/*");
            QRCodeActivity.this.startActivityForResult(intent, 2);
        }

        @Override // cn.damai.commonbusiness.qrcode.widget.ToolScanTopView.TopViewCallback
        public void setOnAlbumRecognized(boolean z) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "-2002842792")) {
                ipChange.ipc$dispatch("-2002842792", new Object[]{this, Boolean.valueOf(z)});
            } else {
                QRCodeActivity.this.albumRecognizing = z;
            }
        }

        @Override // cn.damai.commonbusiness.qrcode.widget.ToolScanTopView.TopViewCallback
        public void startPreview() {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "-1519044870")) {
                ipChange.ipc$dispatch("-1519044870", new Object[]{this});
                return;
            }
            if (QRCodeActivity.this.scanHandler == null) {
                QRCodeActivity.this.scanHandler = new ScanHandler();
                QRCodeActivity.this.scanHandler.p(QRCodeActivity.this.bqcScanService);
            }
            if (QRCodeActivity.this.bqcScanService == null || QRCodeActivity.this.bqcScanService.getCamera() != null) {
                return;
            }
            QRCodeActivity.this.autoStartScan();
        }

        @Override // cn.damai.commonbusiness.qrcode.widget.ToolScanTopView.TopViewCallback
        public void stopPreview(boolean z) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "-878405968")) {
                ipChange.ipc$dispatch("-878405968", new Object[]{this, Boolean.valueOf(z)});
            } else {
                QRCodeActivity.this.realStopPreview();
            }
        }

        @Override // cn.damai.commonbusiness.qrcode.widget.ToolScanTopView.TopViewCallback
        public void turnEnvDetection(boolean z) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "1102106953")) {
                ipChange.ipc$dispatch("1102106953", new Object[]{this, Boolean.valueOf(z)});
            }
        }

        @Override // cn.damai.commonbusiness.qrcode.widget.ToolScanTopView.TopViewCallback
        public boolean turnTorch() {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "-1477393617")) {
                return ((Boolean) ipChange.ipc$dispatch("-1477393617", new Object[]{this})).booleanValue();
            }
            if (QRCodeActivity.this.bqcScanService != null) {
                QRCodeActivity.this.bqcScanService.setTorch(!QRCodeActivity.this.bqcScanService.isTorchOn());
                return QRCodeActivity.this.bqcScanService.isTorchOn();
            }
            return false;
        }
    }

    /* compiled from: Taobao */
    /* loaded from: classes4.dex */
    public class e implements MPaasLogger.BqcLogger {
        private static transient /* synthetic */ IpChange $ipChange;

        e(QRCodeActivity qRCodeActivity) {
        }

        @Override // com.alipay.mobile.bqcscanservice.MPaasLogger.BqcLogger
        public boolean checkStringBuilderValid(StringBuilder sb) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "-957907872")) {
                return ((Boolean) ipChange.ipc$dispatch("-957907872", new Object[]{this, sb})).booleanValue();
            }
            return true;
        }

        @Override // com.alipay.mobile.bqcscanservice.MPaasLogger.BqcLogger
        public void d(String str, StringBuilder sb) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "-1500128132")) {
                ipChange.ipc$dispatch("-1500128132", new Object[]{this, str, sb});
            } else {
                Log.d(str, sb.toString());
            }
        }

        @Override // com.alipay.mobile.bqcscanservice.MPaasLogger.BqcLogger
        public void e(String str, StringBuilder sb) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "470811325")) {
                ipChange.ipc$dispatch("470811325", new Object[]{this, str, sb});
            } else {
                Log.e(str, sb.toString());
            }
        }

        @Override // com.alipay.mobile.bqcscanservice.MPaasLogger.BqcLogger
        public void e(String str, StringBuilder sb, Throwable th) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "2123888984")) {
                ipChange.ipc$dispatch("2123888984", new Object[]{this, str, sb, th});
            }
        }

        @Override // com.alipay.mobile.bqcscanservice.MPaasLogger.BqcLogger
        public StringBuilder getLocalStringBuilder() {
            IpChange ipChange = $ipChange;
            return AndroidInstantRuntime.support(ipChange, "1732175") ? (StringBuilder) ipChange.ipc$dispatch("1732175", new Object[]{this}) : new StringBuilder();
        }

        @Override // com.alipay.mobile.bqcscanservice.MPaasLogger.BqcLogger
        public void i(String str, StringBuilder sb) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "-235365439")) {
                ipChange.ipc$dispatch("-235365439", new Object[]{this, str, sb});
            } else {
                Log.i(str, sb.toString());
            }
        }

        @Override // com.alipay.mobile.bqcscanservice.MPaasLogger.BqcLogger
        public boolean isDebuggable() {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "-1968009235")) {
                return ((Boolean) ipChange.ipc$dispatch("-1968009235", new Object[]{this})).booleanValue();
            }
            return true;
        }

        @Override // com.alipay.mobile.bqcscanservice.MPaasLogger.BqcLogger
        public void v(String str, StringBuilder sb) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "-382956274")) {
                ipChange.ipc$dispatch("-382956274", new Object[]{this, str, sb});
            } else {
                Log.v(str, sb.toString());
            }
        }

        @Override // com.alipay.mobile.bqcscanservice.MPaasLogger.BqcLogger
        public void w(String str, StringBuilder sb) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "1587983183")) {
                ipChange.ipc$dispatch("1587983183", new Object[]{this, str, sb});
            } else {
                Log.w(str, sb.toString());
            }
        }
    }

    /* compiled from: Taobao */
    /* loaded from: classes4.dex */
    public class f implements MaLogger.MaEngineLogger {
        private static transient /* synthetic */ IpChange $ipChange;

        f(QRCodeActivity qRCodeActivity) {
        }

        @Override // com.alipay.ma.MaLogger.MaEngineLogger
        public void d(String str, String str2) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "1315805176")) {
                ipChange.ipc$dispatch("1315805176", new Object[]{this, str, str2});
            } else {
                Log.d(str, str2);
            }
        }

        @Override // com.alipay.ma.MaLogger.MaEngineLogger
        public void e(String str, String str2) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "-1517582121")) {
                ipChange.ipc$dispatch("-1517582121", new Object[]{this, str, str2});
            } else {
                Log.e(str, str2);
            }
        }

        @Override // com.alipay.ma.MaLogger.MaEngineLogger
        public void i(String str, String str2) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "33770579")) {
                ipChange.ipc$dispatch("33770579", new Object[]{this, str, str2});
            } else {
                Log.i(str, str2);
            }
        }

        @Override // com.alipay.ma.MaLogger.MaEngineLogger
        public boolean isDebuggable() {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "1482486190")) {
                return ((Boolean) ipChange.ipc$dispatch("1482486190", new Object[]{this})).booleanValue();
            }
            return true;
        }

        @Override // com.alipay.ma.MaLogger.MaEngineLogger
        public void v(String str, String str2) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "1854441382")) {
                ipChange.ipc$dispatch("1854441382", new Object[]{this, str, str2});
            } else {
                Log.v(str, str2);
            }
        }

        @Override // com.alipay.ma.MaLogger.MaEngineLogger
        public void w(String str, String str2) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "-978945915")) {
                ipChange.ipc$dispatch("-978945915", new Object[]{this, str, str2});
            } else {
                Log.w(str, str2);
            }
        }

        @Override // com.alipay.ma.MaLogger.MaEngineLogger
        public void e(String str, String str2, Throwable th) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "-381606018")) {
                ipChange.ipc$dispatch("-381606018", new Object[]{this, str, str2, th});
            } else {
                Log.e(str, str2, th);
            }
        }
    }

    /* compiled from: Taobao */
    /* loaded from: classes4.dex */
    public class g implements SurfaceHolder.Callback {
        private static transient /* synthetic */ IpChange $ipChange;

        g() {
        }

        @Override // android.view.SurfaceHolder.Callback
        public void surfaceChanged(SurfaceHolder surfaceHolder, int i, int i2, int i3) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "686267591")) {
                ipChange.ipc$dispatch("686267591", new Object[]{this, surfaceHolder, Integer.valueOf(i), Integer.valueOf(i2), Integer.valueOf(i3)});
            }
        }

        @Override // android.view.SurfaceHolder.Callback
        public void surfaceCreated(SurfaceHolder surfaceHolder) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "472265128")) {
                ipChange.ipc$dispatch("472265128", new Object[]{this, surfaceHolder});
                return;
            }
            QRCodeActivity.this.mSurfaceHolder = surfaceHolder;
            QRCodeActivity.this.configPreviewAndRecognitionEngine();
        }

        @Override // android.view.SurfaceHolder.Callback
        public void surfaceDestroyed(SurfaceHolder surfaceHolder) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "216488343")) {
                ipChange.ipc$dispatch("216488343", new Object[]{this, surfaceHolder});
            } else {
                QRCodeActivity.this.mSurfaceHolder = null;
            }
        }
    }

    /* compiled from: Taobao */
    /* loaded from: classes4.dex */
    public class h implements MaScanCallbackWithDecodeInfoSupport {
        private static transient /* synthetic */ IpChange $ipChange;

        h() {
        }

        @Override // com.alipay.mobile.mascanengine.IOnMaSDKDecodeInfo
        public void onGetAvgGray(int i) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "-59670755")) {
                ipChange.ipc$dispatch("-59670755", new Object[]{this, Integer.valueOf(i)});
            } else if (QRCodeActivity.this.mScanTopView != null) {
                QRCodeActivity.this.mScanTopView.onGetAvgGray(i);
            }
        }

        @Override // com.alipay.mobile.mascanengine.IOnMaSDKDecodeInfo
        public void onGetMaProportion(float f) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "-730522017")) {
                ipChange.ipc$dispatch("-730522017", new Object[]{this, Float.valueOf(f)});
            } else if (QRCodeActivity.this.mScanTopView != null) {
                QRCodeActivity.this.mScanTopView.onGetMaProportion(f);
            }
        }

        @Override // com.alipay.mobile.mascanengine.IOnMaSDKDecodeInfo
        public void onGetMaProportionAndSource(float f, int i) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "59139706")) {
                ipChange.ipc$dispatch("59139706", new Object[]{this, Float.valueOf(f), Integer.valueOf(i)});
            }
        }

        @Override // com.alipay.mobile.mascanengine.IOnMaSDKDecodeInfo
        public void onGetRecognizeStage(int i) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "-1725188892")) {
                ipChange.ipc$dispatch("-1725188892", new Object[]{this, Integer.valueOf(i)});
            }
        }

        @Override // com.alipay.mobile.mascanengine.IOnMaSDKDecodeInfo
        public void onGetWhetherFrameBlur(float f, float f2, boolean z) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "1282501572")) {
                ipChange.ipc$dispatch("1282501572", new Object[]{this, Float.valueOf(f), Float.valueOf(f2), Boolean.valueOf(z)});
            }
        }

        @Override // com.alipay.mobile.mascanengine.IOnMaSDKDecodeInfo
        public void onGetWhetherFrameBlurSVM(boolean z, long j, long j2) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "1210365668")) {
                ipChange.ipc$dispatch("1210365668", new Object[]{this, Boolean.valueOf(z), Long.valueOf(j), Long.valueOf(j2)});
            }
        }

        @Override // com.alipay.mobile.mascanengine.MaScanCallback
        public boolean onMaCodeInterceptor(List<String> list) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "843652726")) {
                return ((Boolean) ipChange.ipc$dispatch("843652726", new Object[]{this, list})).booleanValue();
            }
            return false;
        }

        @Override // com.alipay.mobile.mascanengine.MaScanCallback
        public void onResultMa(MultiMaScanResult multiMaScanResult) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "-1370068862")) {
                ipChange.ipc$dispatch("-1370068862", new Object[]{this, multiMaScanResult});
                return;
            }
            QRCodeActivity.this.scanSuccess = true;
            if (QRCodeActivity.this.scanHandler != null) {
                QRCodeActivity.this.scanHandler.k();
                QRCodeActivity.this.scanHandler.s();
            }
            if (QRCodeActivity.this.mScanTopView != null) {
                QRCodeActivity.this.playBeepSoundAndVibrate();
                QRCodeActivity.this.mScanTopView.onResultMa((BQCScanResult[]) Arrays.asList(multiMaScanResult).toArray());
            }
        }

        @Override // com.alipay.mobile.mascanengine.MaScanCallback
        public void onScanResultType(int i, MultiMaScanResult multiMaScanResult) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "-8337440")) {
                ipChange.ipc$dispatch("-8337440", new Object[]{this, Integer.valueOf(i), multiMaScanResult});
            }
        }
    }

    /* compiled from: Taobao */
    /* loaded from: classes4.dex */
    public class i implements DialogInterface.OnClickListener {
        private static transient /* synthetic */ IpChange $ipChange;

        i() {
        }

        @Override // android.content.DialogInterface.OnClickListener
        public void onClick(DialogInterface dialogInterface, int i) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "-974854855")) {
                ipChange.ipc$dispatch("-974854855", new Object[]{this, dialogInterface, Integer.valueOf(i)});
            } else {
                QRCodeActivity.this.autoStartScan(1);
            }
        }
    }

    /* compiled from: Taobao */
    /* loaded from: classes4.dex */
    public class j implements DialogInterface.OnClickListener {
        private static transient /* synthetic */ IpChange $ipChange;

        j() {
        }

        @Override // android.content.DialogInterface.OnClickListener
        public void onClick(DialogInterface dialogInterface, int i) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "-5273832")) {
                ipChange.ipc$dispatch("-5273832", new Object[]{this, dialogInterface, Integer.valueOf(i)});
            } else {
                QRCodeActivity.this.finish();
            }
        }
    }

    /* compiled from: Taobao */
    /* loaded from: classes4.dex */
    public class k implements DialogInterface.OnClickListener {
        private static transient /* synthetic */ IpChange $ipChange;

        k() {
        }

        @Override // android.content.DialogInterface.OnClickListener
        public void onClick(DialogInterface dialogInterface, int i) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "964307191")) {
                ipChange.ipc$dispatch("964307191", new Object[]{this, dialogInterface, Integer.valueOf(i)});
            } else {
                QRCodeActivity.this.finish();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void autoStartScan() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1133777784")) {
            ipChange.ipc$dispatch("-1133777784", new Object[]{this});
        } else {
            autoStartScan(0);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void configPreviewAndRecognitionEngine() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-541937648")) {
            ipChange.ipc$dispatch("-541937648", new Object[]{this});
        } else if (!this.mUseNewSurface) {
            APTextureView aPTextureView = this.mTextureView;
            if (aPTextureView == null || !this.bqcServiceSetup) {
                return;
            }
            this.bqcScanService.setDisplay(aPTextureView);
            this.cameraScanHandler.onSurfaceViewAvailable();
            if (this.scanHandler == null) {
                ScanHandler scanHandler = new ScanHandler();
                this.scanHandler = scanHandler;
                scanHandler.p(this.bqcScanService);
            }
            this.scanHandler.m(false);
            setScanType(this.mScanType, this.mEngineType, true);
        } else if (!this.bqcServiceSetup || this.mSurfaceHolder == null) {
        } else {
            if (this.scanHandler == null) {
                ScanHandler scanHandler2 = new ScanHandler();
                this.scanHandler = scanHandler2;
                scanHandler2.p(this.bqcScanService);
            }
            this.bqcScanService.setDisplay(this.mSurfaceView);
            this.cameraScanHandler.onSurfaceViewAvailable();
            this.scanHandler.m(false);
            setScanType(this.mScanType, this.mEngineType, true);
        }
    }

    private void enableSdkLog() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "342172613")) {
            ipChange.ipc$dispatch("342172613", new Object[]{this});
            return;
        }
        MPaasScanService mPaasScanService = this.bqcScanService;
        if (mPaasScanService != null) {
            mPaasScanService.setTraceLogger(new a(this));
        }
        MaLogger.registerLogger(new b(this));
    }

    private void initBeepSound() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "956198823")) {
            ipChange.ipc$dispatch("956198823", new Object[]{this});
            return;
        }
        try {
            if (this.playBeep && this.mediaPlayer == null) {
                setVolumeControlStream(3);
                MediaPlayer mediaPlayer = new MediaPlayer();
                this.mediaPlayer = mediaPlayer;
                mediaPlayer.setAudioStreamType(3);
                this.mediaPlayer.setOnCompletionListener(this.beepListener);
                AssetFileDescriptor openRawResourceFd = getResources().openRawResourceFd(R$raw.qrcode_completed);
                try {
                    this.mediaPlayer.setDataSource(openRawResourceFd.getFileDescriptor(), openRawResourceFd.getStartOffset(), openRawResourceFd.getLength());
                    openRawResourceFd.close();
                    this.mediaPlayer.setVolume(0.5f, 0.5f);
                    this.mediaPlayer.prepare();
                } catch (IOException unused) {
                    this.mediaPlayer = null;
                }
            }
        } catch (Exception e2) {
            e2.printStackTrace();
        }
    }

    private Map<String, Object> initCameraControlParams() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "2059285215")) {
            return (Map) ipChange.ipc$dispatch("2059285215", new Object[]{this});
        }
        HashMap hashMap = new HashMap();
        hashMap.put(BQCCameraParam.ConfigParam.KEY_SUPPORT_PICTURE_SIZE, "no");
        hashMap.put(BQCCameraParam.ConfigParam.KEY_ENABLE_COMPATIBLE, "no");
        hashMap.put(BQCCameraParam.ConfigParam.KEY_MERGE_CAMERA_PARAM, ",,,,yes,,no,wx,,");
        return hashMap;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void initScanRect() {
        int width;
        int height;
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "831801889")) {
            ipChange.ipc$dispatch("831801889", new Object[]{this});
            return;
        }
        if (!this.mUseNewSurface) {
            width = this.mTextureView.getWidth();
            height = this.mTextureView.getHeight();
        } else {
            width = this.mSurfaceView.getWidth();
            height = this.mSurfaceView.getHeight();
        }
        this.mScanTopView.onStartScan();
        if (this.scanRect == null) {
            this.scanRect = this.mScanTopView.getScanRect(this.bqcScanService.getCamera(), width, height);
            float cropWidth = this.mScanTopView.getCropWidth();
            Log.d("ToolsCaptureActivity", "cropWidth: " + cropWidth);
        }
        this.bqcScanService.setScanRegion(this.scanRect);
        this.bqcScanService.setFocusArea(this.mScanTopView.getScanRegion());
    }

    private void initViews() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "2021123354")) {
            ipChange.ipc$dispatch("2021123354", new Object[]{this});
            return;
        }
        Log.d("ToolsCaptureActivity", "mUseNewSurface= " + this.mUseNewSurface);
        if (this.mUseNewSurface) {
            SurfaceView surfaceView = (SurfaceView) findViewById(R$id.surfaceView);
            this.mSurfaceView = surfaceView;
            surfaceView.setVisibility(0);
            this.mSurfaceView.getHolder().addCallback(new g());
        } else {
            APTextureView aPTextureView = (APTextureView) findViewById(R$id.textureView);
            this.mTextureView = aPTextureView;
            aPTextureView.setVisibility(0);
        }
        configPreviewAndRecognitionEngine();
        ToolScanTopView toolScanTopView = (ToolScanTopView) findViewById(R$id.top_view);
        this.mScanTopView = toolScanTopView;
        toolScanTopView.setTopViewCallback(this.topViewCallback);
        this.mScanTopView.attachActivity(this);
    }

    private static boolean isSkiaGlOpen() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1324533549")) {
            return ((Boolean) ipChange.ipc$dispatch("1324533549", new Object[0])).booleanValue();
        }
        if (Build.VERSION.SDK_INT < 26) {
            return false;
        }
        String str = null;
        try {
            str = (String) Class.forName("android.os.SystemProperties").getMethod(gn1.TYPE_OPEN_URL_METHOD_GET, String.class).invoke(null, "debug.hwui.renderer");
        } catch (ClassNotFoundException unused) {
            Log.e("skiaGlUsedDetect", "ClassNotFoundException error");
        } catch (IllegalAccessException unused2) {
            Log.e("skiaGlUsedDetect", "IllegalAccessException error");
        } catch (NoSuchMethodException unused3) {
            Log.e("skiaGlUsedDetect", "NoSuchMethodException error");
        } catch (InvocationTargetException unused4) {
            Log.e("skiaGlUsedDetect", "InvocationTargetException error");
        }
        return !TextUtils.isEmpty(str) && TextUtils.equals(str, "skiagl");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void playBeepSoundAndVibrate() {
        MediaPlayer mediaPlayer;
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-680930925")) {
            ipChange.ipc$dispatch("-680930925", new Object[]{this});
            return;
        }
        if (this.playBeep && (mediaPlayer = this.mediaPlayer) != null) {
            mediaPlayer.start();
        }
        if (this.vibrate) {
            ((Vibrator) getSystemService("vibrator")).vibrate(VIBRATE_DURATION);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void realStopPreview() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-2041714448")) {
            ipChange.ipc$dispatch("-2041714448", new Object[]{this});
            return;
        }
        this.cameraScanHandler.closeCamera();
        this.scanHandler.k();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void showAlertDialog(String str) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-738045317")) {
            ipChange.ipc$dispatch("-738045317", new Object[]{this, str});
            return;
        }
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setMessage(str).setPositiveButton(getString(R$string.ok), new k());
        builder.show();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void showFrontCameraScanGuideDialog(String str) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1212433350")) {
            ipChange.ipc$dispatch("1212433350", new Object[]{this, str});
            return;
        }
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setMessage(str).setNegativeButton("取消", new j()).setPositiveButton("back", new i());
        builder.show();
    }

    @Override // cn.damai.common.app.base.BaseActivity
    public void dealHeaderClick(int i2) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-150916454")) {
            ipChange.ipc$dispatch("-150916454", new Object[]{this, Integer.valueOf(i2)});
        }
    }

    @Override // cn.damai.common.app.base.BaseActivity
    public int getLayoutId() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1867479280")) {
            return ((Integer) ipChange.ipc$dispatch("-1867479280", new Object[]{this})).intValue();
        }
        return 0;
    }

    @Override // cn.damai.commonbusiness.base.ResponseErrorPage.ErrorRefreshListener
    public void handleError(int i2) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "375685739")) {
            ipChange.ipc$dispatch("375685739", new Object[]{this, Integer.valueOf(i2)});
        }
    }

    @Override // cn.damai.common.app.base.BaseActivity
    public void initPresenter() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "132217120")) {
            ipChange.ipc$dispatch("132217120", new Object[]{this});
        }
    }

    @Override // cn.damai.common.app.base.BaseActivity
    public void initView() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-766158467")) {
            ipChange.ipc$dispatch("-766158467", new Object[]{this});
        }
    }

    public boolean isTorchOn() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1816720117")) {
            return ((Boolean) ipChange.ipc$dispatch("-1816720117", new Object[]{this})).booleanValue();
        }
        MPaasScanService mPaasScanService = this.bqcScanService;
        if (mPaasScanService != null) {
            return mPaasScanService.isTorchOn();
        }
        return false;
    }

    @Override // cn.damai.commonbusiness.qrcode.widget.ScanHandler.ScanResultCallbackProducer
    public BQCScanEngine.EngineCallback makeScanResultCallback(ScanType scanType) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "669513966")) {
            return (BQCScanEngine.EngineCallback) ipChange.ipc$dispatch("669513966", new Object[]{this, scanType});
        }
        if (scanType == ScanType.SCAN_MA) {
            return new h();
        }
        return null;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // cn.damai.commonbusiness.base.DamaiBaseActivity, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, android.app.Activity
    public void onActivityResult(int i2, int i3, Intent intent) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1637044772")) {
            ipChange.ipc$dispatch("1637044772", new Object[]{this, Integer.valueOf(i2), Integer.valueOf(i3), intent});
            return;
        }
        super.onActivityResult(i2, i3, intent);
        if (i2 == 1000 && i3 == -1) {
            String f2 = QrcodeUtil.f(this, intent.getData());
            if (this.mScanTopView == null || TextUtils.isEmpty(f2)) {
                return;
            }
            this.mScanTopView.onPictureSelected(f2);
        }
    }

    @Override // cn.damai.common.app.base.BaseActivity, android.view.View.OnClickListener
    public void onClick(View view) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1907491293")) {
            ipChange.ipc$dispatch("-1907491293", new Object[]{this, view});
            return;
        }
        int id = view.getId();
        if (id == R$id.header_left_back) {
            finish();
        } else if (id == R$id.scan_album_image) {
            QrcodeUtil.g(this);
        } else if (id == R$id.capture_flashlight) {
            try {
                if (this.mIsFlashlightOpen) {
                    turnLightOff();
                    this.mFlashLight.setText(getResources().getString(R$string.iconfont_shoudiantong24));
                    this.mIsFlashlightOpen = false;
                } else {
                    turnLightOn();
                    this.mFlashLight.setText(getResources().getString(R$string.iconfont_shoudiantongkai24));
                    this.mIsFlashlightOpen = true;
                }
            } catch (Exception e2) {
                e2.printStackTrace();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // cn.damai.commonbusiness.base.DamaiBaseActivity, cn.damai.common.app.base.BaseActivity, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1920070557")) {
            ipChange.ipc$dispatch("1920070557", new Object[]{this, bundle});
            return;
        }
        super.onCreate(bundle);
        setDamaiUTKeyBuilder(fy1.f().g(fy1.HOME_SCAN_PAGE));
        getWindow().addFlags(2097280);
        overridePendingTransition(0, 0);
        if (Build.VERSION.SDK_INT >= 21) {
            getWindow().getDecorView().setSystemUiVisibility(1280);
            getWindow().addFlags(Integer.MIN_VALUE);
            getWindow().setStatusBarColor(0);
        }
        setContentView(R$layout.activity_scan);
        this.mUseNewSurface = isSkiaGlOpen();
        b62.c();
        this.autoZoomOperator = new AutoZoomOperator(this);
        MPaasScanService a2 = sc1.a(this);
        this.bqcScanService = a2;
        a2.serviceInit(null);
        HashMap hashMap = new HashMap();
        hashMap.put(BQCCameraParam.ServicePropertyParam.USE_NEW_SURFACE, this.mUseNewSurface ? BQCCameraParam.VALUE_YES : "no");
        this.bqcScanService.setServiceParameters(hashMap);
        this.cameraScanHandler = this.bqcScanService.getCameraHandler();
        ScanHandler scanHandler = new ScanHandler();
        this.scanHandler = scanHandler;
        scanHandler.p(this.bqcScanService);
        enableSdkLog();
        DMIconFontTextView dMIconFontTextView = (DMIconFontTextView) findViewById(R$id.capture_flashlight);
        this.mFlashLight = dMIconFontTextView;
        dMIconFontTextView.setOnClickListener(this);
        ((DMIconFontTextView) findViewById(R$id.scan_album_image)).setOnClickListener(this);
        findViewById(R$id.header_left_back).setOnClickListener(this);
        initBeepSound();
        this.isPermissionGranted = true;
        this.firstAutoStarted = true;
        try {
            autoStartScan();
        } catch (Exception e2) {
            Log.e("ToolsCaptureActivity", "autoStartScan: Exception " + e2.getMessage());
        }
        MPaasLogger.registerBqcLogger(new e(this));
        MaLogger.registerLogger(new f(this));
        initViews();
    }

    @Override // cn.damai.commonbusiness.base.DamaiBaseActivity, cn.damai.common.app.base.BaseActivity, androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onDestroy() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-936801763")) {
            ipChange.ipc$dispatch("-936801763", new Object[]{this});
            return;
        }
        super.onDestroy();
        MPaasScanService mPaasScanService = this.bqcScanService;
        if (mPaasScanService != null) {
            mPaasScanService.serviceOut(null);
        }
        MaLogger.unRegisterLogger();
        ScanHandler scanHandler = this.scanHandler;
        if (scanHandler != null) {
            scanHandler.n();
            this.scanHandler.j();
        }
        ToolScanTopView toolScanTopView = this.mScanTopView;
        if (toolScanTopView != null) {
            toolScanTopView.detachActivity();
        }
        AutoZoomOperator autoZoomOperator = this.autoZoomOperator;
        if (autoZoomOperator != null) {
            autoZoomOperator.c();
        }
        b62.a();
    }

    @Override // cn.damai.commonbusiness.base.DamaiBaseActivity, cn.damai.common.app.base.BaseActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onPause() {
        CameraHandler cameraHandler;
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "497959713")) {
            ipChange.ipc$dispatch("497959713", new Object[]{this});
            return;
        }
        super.onPause();
        this.pauseOrResume = -1;
        this.firstAutoStarted = false;
        if (this.isPermissionGranted) {
            realStopPreview();
        }
        if (this.bqcScanService != null && (cameraHandler = this.cameraScanHandler) != null) {
            cameraHandler.release(this.postcode);
        }
        ScanHandler scanHandler = this.scanHandler;
        if (scanHandler != null) {
            scanHandler.o();
        }
    }

    @Override // androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, android.app.Activity
    public void onRequestPermissionsResult(int i2, String[] strArr, int[] iArr) {
        IpChange ipChange = $ipChange;
        int i3 = 0;
        if (AndroidInstantRuntime.support(ipChange, "-1720833749")) {
            ipChange.ipc$dispatch("-1720833749", new Object[]{this, Integer.valueOf(i2), strArr, iArr});
            return;
        }
        if (i2 == 1 && strArr != null && iArr != null) {
            while (true) {
                if (i3 >= strArr.length || i3 >= iArr.length) {
                    break;
                }
                if (TextUtils.equals(strArr[i3], "android.permission.CAMERA")) {
                    if (iArr[i3] != 0) {
                        showPermissionDenied();
                        break;
                    }
                    this.firstAutoStarted = true;
                    try {
                        autoStartScan();
                    } catch (Exception e2) {
                        Log.e("ToolsCaptureActivity", "autoStartScan: Exception " + e2.getMessage());
                    }
                }
                i3++;
            }
        }
        super.onRequestPermissionsResult(i2, strArr, iArr);
    }

    @Override // cn.damai.commonbusiness.base.DamaiBaseActivity, cn.damai.common.app.base.BaseActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onResume() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-95331578")) {
            ipChange.ipc$dispatch("-95331578", new Object[]{this});
            return;
        }
        super.onResume();
        this.pauseOrResume = 1;
        if (this.scanHandler == null) {
            ScanHandler scanHandler = new ScanHandler();
            this.scanHandler = scanHandler;
            scanHandler.p(this.bqcScanService);
        }
        if (this.firstAutoStarted || this.scanSuccess || this.mScanTopView == null || !this.isPermissionGranted) {
            return;
        }
        try {
            autoStartScan();
        } catch (Exception e2) {
            Log.e("ToolsCaptureActivity", "autoStartScan: Exception " + e2.getMessage());
        }
    }

    public void restartScan() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1485426604")) {
            ipChange.ipc$dispatch("1485426604", new Object[]{this});
            return;
        }
        ScanHandler scanHandler = this.scanHandler;
        if (scanHandler != null) {
            scanHandler.l();
            this.scanSuccess = false;
        }
    }

    public void revertZoom() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1303728891")) {
            ipChange.ipc$dispatch("1303728891", new Object[]{this});
            return;
        }
        MPaasScanService mPaasScanService = this.bqcScanService;
        if (mPaasScanService != null) {
            mPaasScanService.setZoom(Integer.MIN_VALUE);
        }
    }

    public void setScanType(ScanType scanType, BQCCameraParam.MaEngineType maEngineType, boolean z) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1696358644")) {
            ipChange.ipc$dispatch("-1696358644", new Object[]{this, scanType, maEngineType, Boolean.valueOf(z)});
        } else if ((z || this.mScanType != scanType) && this.bqcScanService != null) {
            this.scanHandler.k();
            this.mScanType = scanType;
            this.mEngineType = maEngineType;
            this.scanHandler.r(scanType, maEngineType);
            if (this.albumRecognizing || this.scanSuccess) {
                return;
            }
            this.scanHandler.l();
        }
    }

    @Override // cn.damai.common.app.base.BaseActivity
    protected String setTitle() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "539021700")) {
            return (String) ipChange.ipc$dispatch("539021700", new Object[]{this});
        }
        return null;
    }

    public void setZoom(int i2) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "331857152")) {
            ipChange.ipc$dispatch("331857152", new Object[]{this, Integer.valueOf(i2)});
            return;
        }
        MPaasScanService mPaasScanService = this.bqcScanService;
        if (mPaasScanService != null) {
            mPaasScanService.setZoom(i2);
        }
    }

    void showPermissionDenied() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1004702421")) {
            ipChange.ipc$dispatch("-1004702421", new Object[]{this});
        } else if (isFinishing()) {
        } else {
            showAlertDialog("没有权限");
        }
    }

    public void startContinueZoom(int i2) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1862632583")) {
            ipChange.ipc$dispatch("1862632583", new Object[]{this, Integer.valueOf(i2)});
            return;
        }
        AutoZoomOperator autoZoomOperator = this.autoZoomOperator;
        if (autoZoomOperator != null) {
            autoZoomOperator.f(i2, 0);
        }
    }

    public void startPreview() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "886530092")) {
            ipChange.ipc$dispatch("886530092", new Object[]{this});
            return;
        }
        Map<String, Object> initCameraControlParams = initCameraControlParams();
        initCameraControlParams.put(BQCCameraParam.ConfigParam.KEY_SUPPORT_FRAME_CALLBACK, BQCCameraParam.VALUE_YES);
        this.cameraScanHandler.configAndOpenCamera(initCameraControlParams);
        if (this.albumRecognizing) {
            return;
        }
        this.bqcScanService.setScanEnable(true);
    }

    public void turnLightOff() {
        Camera camera;
        Camera.Parameters parameters;
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "41693980")) {
            ipChange.ipc$dispatch("41693980", new Object[]{this});
            return;
        }
        MPaasScanService mPaasScanService = this.bqcScanService;
        if (mPaasScanService == null || (camera = mPaasScanService.getCamera()) == null || (parameters = camera.getParameters()) == null) {
            return;
        }
        List<String> supportedFlashModes = parameters.getSupportedFlashModes();
        String flashMode = parameters.getFlashMode();
        if (supportedFlashModes == null) {
            return;
        }
        cb1.g("ToolsCaptureActivity", "Flash mode: " + flashMode);
        cb1.g("ToolsCaptureActivity", "Flash modes: " + supportedFlashModes);
        if ("off".equals(flashMode)) {
            return;
        }
        if (supportedFlashModes.contains("off")) {
            parameters.setFlashMode("off");
            camera.setParameters(parameters);
            return;
        }
        cb1.c("ToolsCaptureActivity", "FLASH_MODE_OFF not supported");
    }

    public void turnLightOn() {
        Camera camera;
        Camera.Parameters parameters;
        List<String> supportedFlashModes;
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1802639104")) {
            ipChange.ipc$dispatch("1802639104", new Object[]{this});
            return;
        }
        MPaasScanService mPaasScanService = this.bqcScanService;
        if (mPaasScanService == null || (camera = mPaasScanService.getCamera()) == null || (parameters = camera.getParameters()) == null || (supportedFlashModes = parameters.getSupportedFlashModes()) == null) {
            return;
        }
        String flashMode = parameters.getFlashMode();
        cb1.g("ToolsCaptureActivity", "Flash mode: " + flashMode);
        cb1.g("ToolsCaptureActivity", "Flash modes: " + supportedFlashModes);
        if ("torch".equals(flashMode)) {
            return;
        }
        if (supportedFlashModes.contains("torch")) {
            parameters.setFlashMode("torch");
            camera.setParameters(parameters);
            return;
        }
        cb1.c("ToolsCaptureActivity", "FLASH_MODE_TORCH not supported");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void autoStartScan(int i2) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-787343493")) {
            ipChange.ipc$dispatch("-787343493", new Object[]{this, Integer.valueOf(i2)});
            return;
        }
        if (i2 == 1) {
            CameraHandler.mConsiderContext = true;
        }
        this.cameraScanHandler.init(this, this.bqcCallback, i2);
        this.scanHandler.q(this, this);
        startPreview();
    }
}
