package cn.damai.commonbusiness.qrcode.widget;

import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.graphics.Point;
import android.graphics.Rect;
import android.hardware.Camera;
import android.os.Build;
import android.text.Html;
import android.text.Spanned;
import android.util.AttributeSet;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;
import androidx.core.content.PermissionChecker;
import cn.damai.commonbusiness.R$id;
import cn.damai.commonbusiness.R$layout;
import cn.damai.commonbusiness.qrcode.QRCodeActivity;
import cn.damai.commonbusiness.qrcode.widget.ScaleFinderView;
import cn.damai.commonbusiness.qrcode.widget.ScanTitleBar;
import cn.damai.commonbusiness.util.Utils;
import cn.damai.onearch.errpage.bean.ErrControlViewInfo;
import com.alipay.mobile.bqcscanservice.BQCScanResult;
import com.alipay.mobile.bqcscanservice.MPaasLogger;
import com.alipay.mobile.mascanengine.IOnMaSDKDecodeInfo;
import com.alipay.mobile.mascanengine.MaScanResult;
import com.alipay.mobile.mascanengine.MaScanType;
import com.alipay.mobile.mascanengine.MultiMaScanResult;
import com.alipay.mobile.mascanengine.impl.MaPictureEngineServiceImpl;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import tb.b62;
import tb.ey1;

/* compiled from: Taobao */
/* loaded from: classes4.dex */
public class ToolScanTopView extends RelativeLayout implements ScaleFinderView.OnZoomOperatedListener, ScanTitleBar.OnScanTitleBarClickListener, IOnMaSDKDecodeInfo {
    private static transient /* synthetic */ IpChange $ipChange = null;
    public static final String TAG = "ToolScanTopView";
    private int autoZoomState;
    private int frameNum;
    private Runnable hideTorchRunnable;
    private int high_threshold;
    private int low_threshold;
    private QRCodeActivity mActivity;
    private Rect mFinalRect;
    protected TopViewCallback mTopViewCallback;
    private ScaleFinderView scaleFinderView;
    private ScanRayView scanRayView;
    private Runnable showTorchRunnable;

    /* compiled from: Taobao */
    /* loaded from: classes4.dex */
    public interface TopViewCallback {
        void clearSurface();

        void onAlbumResult(MaScanResult[] maScanResultArr);

        void scanSuccess();

        void selectPic();

        void setOnAlbumRecognized(boolean z);

        void startPreview();

        void stopPreview(boolean z);

        void turnEnvDetection(boolean z);

        boolean turnTorch();
    }

    /* compiled from: Taobao */
    /* renamed from: cn.damai.commonbusiness.qrcode.widget.ToolScanTopView$a */
    /* loaded from: classes4.dex */
    public class DialogInterface$OnCancelListenerC0792a implements DialogInterface.OnCancelListener {
        private static transient /* synthetic */ IpChange $ipChange;

        DialogInterface$OnCancelListenerC0792a() {
        }

        @Override // android.content.DialogInterface.OnCancelListener
        public void onCancel(DialogInterface dialogInterface) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "-1559697378")) {
                ipChange.ipc$dispatch("-1559697378", new Object[]{this, dialogInterface});
            } else if (ToolScanTopView.this.mActivity == null || ToolScanTopView.this.mActivity.isFinishing()) {
            } else {
                ToolScanTopView.this.mActivity.restartScan();
            }
        }
    }

    public ToolScanTopView(Context context) {
        this(context, null);
    }

    private void init(Context context) {
        Spanned fromHtml;
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1147905239")) {
            ipChange.ipc$dispatch("-1147905239", new Object[]{this, context});
            return;
        }
        LayoutInflater.from(context).inflate(R$layout.view_ma_tool_top, (ViewGroup) this, true);
        ScaleFinderView scaleFinderView = (ScaleFinderView) findViewById(R$id.scale_finder_view);
        this.scaleFinderView = scaleFinderView;
        scaleFinderView.setOnZoomOperatedListener(this);
        ScanRayView scanRayView = (ScanRayView) findViewById(R$id.scan_ray_view);
        this.scanRayView = scanRayView;
        scanRayView.setFinderView(this.scaleFinderView);
        if (Build.VERSION.SDK_INT >= 24) {
            fromHtml = Html.fromHtml("<font color='#ff1268'>「</font>将二维码放入框内即可扫描<font color='#ff1268'>」</font>", 0);
        } else {
            fromHtml = Html.fromHtml("<font color='#ff1268'>「</font>将二维码放入框内即可扫描<font color='#ff1268'>」</font>");
        }
        ((TextView) findViewById(R$id.scan_tip)).setText(fromHtml);
    }

    private void showAlertText(BQCScanResult[] bQCScanResultArr) {
        String jSONArray;
        int i;
        BQCScanResult[] bQCScanResultArr2 = bQCScanResultArr;
        IpChange ipChange = $ipChange;
        int i2 = 0;
        if (AndroidInstantRuntime.support(ipChange, "491263996")) {
            ipChange.ipc$dispatch("491263996", new Object[]{this, bQCScanResultArr2});
            return;
        }
        JSONArray jSONArray2 = new JSONArray();
        if (bQCScanResultArr2 != null && bQCScanResultArr2.length != 0) {
            int length = bQCScanResultArr2.length;
            int i3 = 0;
            while (i3 < length) {
                BQCScanResult bQCScanResult = bQCScanResultArr2[i3];
                try {
                    if (bQCScanResult instanceof MultiMaScanResult) {
                        MaScanResult[] maScanResultArr = ((MultiMaScanResult) bQCScanResult).maScanResults;
                        int length2 = maScanResultArr.length;
                        while (i2 < length2) {
                            MaScanResult maScanResult = maScanResultArr[i2];
                            MaScanResult[] maScanResultArr2 = maScanResultArr;
                            JSONObject jSONObject = new JSONObject();
                            jSONObject.put("type", maScanResult.type.toString());
                            jSONObject.put("text", maScanResult.text);
                            i = length;
                            try {
                                if (maScanResult.type == MaScanType.QR) {
                                    jSONObject.put("version", maScanResult.version);
                                    jSONObject.put("level", String.valueOf(maScanResult.ecLevel));
                                    jSONObject.put("bitErrors", maScanResult.bitErrors);
                                    jSONObject.put("strategy", maScanResult.strategy);
                                    jSONObject.put("charset", maScanResult.charset);
                                    Rect rect = maScanResult.rect;
                                    if (rect != null) {
                                        jSONObject.put("rect", rect.toString());
                                    }
                                }
                                jSONArray2.put(jSONObject);
                                i2++;
                                maScanResultArr = maScanResultArr2;
                                length = i;
                            } catch (Exception e) {
                                e = e;
                                MPaasLogger.e(TAG, new String[]{e.getMessage()});
                                i3++;
                                bQCScanResultArr2 = bQCScanResultArr;
                                length = i;
                                i2 = 0;
                            }
                        }
                        i = length;
                    } else {
                        i = length;
                        if (bQCScanResult instanceof MaScanResult) {
                            MaScanResult maScanResult2 = (MaScanResult) bQCScanResult;
                            JSONObject jSONObject2 = new JSONObject();
                            jSONObject2.put("type", maScanResult2.type.toString());
                            jSONObject2.put("text", maScanResult2.text);
                            if (maScanResult2.type == MaScanType.QR) {
                                jSONObject2.put("version", maScanResult2.version);
                                jSONObject2.put("level", String.valueOf(maScanResult2.ecLevel));
                                jSONObject2.put("bitErrors", maScanResult2.bitErrors);
                                jSONObject2.put("strategy", maScanResult2.strategy);
                                Rect rect2 = maScanResult2.rect;
                                if (rect2 != null) {
                                    jSONObject2.put("rect", rect2.toString());
                                }
                            }
                            jSONArray2.put(jSONObject2);
                        } else {
                            JSONObject jSONObject3 = new JSONObject();
                            jSONObject3.put("result", "未识别到码");
                            jSONArray2.put(jSONObject3);
                        }
                    }
                } catch (Exception e2) {
                    e = e2;
                    i = length;
                }
                i3++;
                bQCScanResultArr2 = bQCScanResultArr;
                length = i;
                i2 = 0;
            }
        } else {
            JSONObject jSONObject4 = new JSONObject();
            try {
                jSONObject4.put("text", "test");
                jSONArray2.put(jSONObject4);
            } catch (Exception e3) {
                e3.printStackTrace();
            }
        }
        try {
            jSONArray = jSONArray2.toString(2);
        } catch (JSONException unused) {
            jSONArray = jSONArray2.toString();
        }
        QRCodeActivity qRCodeActivity = this.mActivity;
        if (qRCodeActivity == null || qRCodeActivity.isFinishing()) {
            return;
        }
        new AlertDialog.Builder(this.mActivity).setTitle(ErrControlViewInfo.TYPE_ALL).setMessage(jSONArray).setCancelable(true).setOnCancelListener(new DialogInterface$OnCancelListenerC0792a()).create().show();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void startContinuousZoom(int i) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "311634380")) {
            ipChange.ipc$dispatch("311634380", new Object[]{this, Integer.valueOf(i)});
            return;
        }
        QRCodeActivity qRCodeActivity = this.mActivity;
        if (qRCodeActivity != null) {
            qRCodeActivity.startContinueZoom(i);
        }
    }

    public void attachActivity(QRCodeActivity qRCodeActivity) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1238602191")) {
            ipChange.ipc$dispatch("-1238602191", new Object[]{this, qRCodeActivity});
        } else {
            this.mActivity = qRCodeActivity;
        }
    }

    public void detachActivity() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1403214093")) {
            ipChange.ipc$dispatch("1403214093", new Object[]{this});
        } else {
            this.mActivity = null;
        }
    }

    public float getCropWidth() {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "1367762975") ? ((Float) ipChange.ipc$dispatch("1367762975", new Object[]{this})).floatValue() : this.scanRayView.getWidth() * 1.1f;
    }

    public Rect getScanRect(Camera camera, int i, int i2) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "210304122")) {
            return (Rect) ipChange.ipc$dispatch("210304122", new Object[]{this, camera, Integer.valueOf(i), Integer.valueOf(i2)});
        }
        if (camera == null) {
            return null;
        }
        try {
            Camera.Size previewSize = camera.getParameters().getPreviewSize();
            if (previewSize == null) {
                return null;
            }
            return getScanRect(new Point(previewSize.width, previewSize.height), i, i2);
        } catch (Exception unused) {
            return null;
        }
    }

    public Rect getScanRegion() {
        int i;
        int i2;
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-48471875")) {
            return (Rect) ipChange.ipc$dispatch("-48471875", new Object[]{this});
        }
        Rect rect = this.mFinalRect;
        if (rect != null && (i = rect.left) > 0 && (i2 = rect.top) > 0 && rect.right > i && rect.bottom > i2) {
            return rect;
        }
        return null;
    }

    @Override // cn.damai.commonbusiness.qrcode.widget.ScanTitleBar.OnScanTitleBarClickListener
    public void onAlbumClicked() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "2111310456")) {
            ipChange.ipc$dispatch("2111310456", new Object[]{this});
        } else if (PermissionChecker.checkSelfPermission(this.mActivity, "android.permission.READ_EXTERNAL_STORAGE") != 0) {
            Toast.makeText(this.mActivity, "未赋予权限", 0).show();
        } else {
            TopViewCallback topViewCallback = this.mTopViewCallback;
            if (topViewCallback != null) {
                topViewCallback.selectPic();
            }
        }
    }

    @Override // com.alipay.mobile.mascanengine.IOnMaSDKDecodeInfo
    public void onGetAvgGray(int i) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1400155826")) {
            ipChange.ipc$dispatch("1400155826", new Object[]{this, Integer.valueOf(i)});
        } else if (i != 0) {
            if (i < this.low_threshold) {
                if (this.showTorchRunnable == null) {
                    this.showTorchRunnable = new Runnable() { // from class: cn.damai.commonbusiness.qrcode.widget.ToolScanTopView.3
                        private static transient /* synthetic */ IpChange $ipChange;

                        @Override // java.lang.Runnable
                        public void run() {
                            IpChange ipChange2 = $ipChange;
                            if (AndroidInstantRuntime.support(ipChange2, "869649025")) {
                                ipChange2.ipc$dispatch("869649025", new Object[]{this});
                            }
                        }
                    };
                }
                this.mActivity.runOnUiThread(this.showTorchRunnable);
            } else if (i > this.high_threshold) {
                if (this.hideTorchRunnable == null) {
                    this.hideTorchRunnable = new Runnable() { // from class: cn.damai.commonbusiness.qrcode.widget.ToolScanTopView.4
                        private static transient /* synthetic */ IpChange $ipChange;

                        @Override // java.lang.Runnable
                        public void run() {
                            IpChange ipChange2 = $ipChange;
                            if (AndroidInstantRuntime.support(ipChange2, "673135520")) {
                                ipChange2.ipc$dispatch("673135520", new Object[]{this});
                            }
                        }
                    };
                }
                this.mActivity.runOnUiThread(this.hideTorchRunnable);
            }
        }
    }

    @Override // com.alipay.mobile.mascanengine.IOnMaSDKDecodeInfo
    public void onGetMaProportion(float f) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1722194966")) {
            ipChange.ipc$dispatch("-1722194966", new Object[]{this, Float.valueOf(f)});
            return;
        }
        QRCodeActivity qRCodeActivity = this.mActivity;
        if (qRCodeActivity == null || qRCodeActivity.isFinishing()) {
            return;
        }
        Log.d(TAG, "The ma proportion is " + f);
        if (this.autoZoomState > 1) {
            return;
        }
        double d = f;
        if (d > 0.05d && d < 0.4d) {
            int i = this.frameNum + 1;
            this.frameNum = i;
            if (i >= 5) {
                this.autoZoomState = 2;
                final int i2 = (int) (75.0f - (f * 75.0f));
                this.mActivity.runOnUiThread(new Runnable() { // from class: cn.damai.commonbusiness.qrcode.widget.ToolScanTopView.2
                    private static transient /* synthetic */ IpChange $ipChange;

                    @Override // java.lang.Runnable
                    public void run() {
                        IpChange ipChange2 = $ipChange;
                        if (AndroidInstantRuntime.support(ipChange2, "1066162530")) {
                            ipChange2.ipc$dispatch("1066162530", new Object[]{this});
                        } else {
                            ToolScanTopView.this.startContinuousZoom(i2);
                        }
                    }
                });
                return;
            }
        }
        this.autoZoomState = 0;
    }

    @Override // com.alipay.mobile.mascanengine.IOnMaSDKDecodeInfo
    public void onGetMaProportionAndSource(float f, int i) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "2009430597")) {
            ipChange.ipc$dispatch("2009430597", new Object[]{this, Float.valueOf(f), Integer.valueOf(i)});
        }
    }

    @Override // com.alipay.mobile.mascanengine.IOnMaSDKDecodeInfo
    public void onGetRecognizeStage(int i) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1240153169")) {
            ipChange.ipc$dispatch("-1240153169", new Object[]{this, Integer.valueOf(i)});
        }
    }

    @Override // com.alipay.mobile.mascanengine.IOnMaSDKDecodeInfo
    public void onGetWhetherFrameBlur(float f, float f2, boolean z) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1655694065")) {
            ipChange.ipc$dispatch("-1655694065", new Object[]{this, Float.valueOf(f), Float.valueOf(f2), Boolean.valueOf(z)});
        }
    }

    @Override // com.alipay.mobile.mascanengine.IOnMaSDKDecodeInfo
    public void onGetWhetherFrameBlurSVM(boolean z, long j, long j2) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "857636281")) {
            ipChange.ipc$dispatch("857636281", new Object[]{this, Boolean.valueOf(z), Long.valueOf(j), Long.valueOf(j2)});
        }
    }

    public void onPictureSelected(final String str) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "322520075")) {
            ipChange.ipc$dispatch("322520075", new Object[]{this, str});
        } else if (this.mActivity != null) {
            b62.b(new Runnable() { // from class: cn.damai.commonbusiness.qrcode.widget.ToolScanTopView.5
                private static transient /* synthetic */ IpChange $ipChange;

                @Override // java.lang.Runnable
                public void run() {
                    MaScanResult[] maScanResultArr;
                    IpChange ipChange2 = $ipChange;
                    if (AndroidInstantRuntime.support(ipChange2, "476622015")) {
                        ipChange2.ipc$dispatch("476622015", new Object[]{this});
                        return;
                    }
                    MultiMaScanResult processMultiMa = new MaPictureEngineServiceImpl().processMultiMa(Utils.c(ToolScanTopView.this.mActivity, str), 4, false);
                    TopViewCallback topViewCallback = ToolScanTopView.this.mTopViewCallback;
                    if (topViewCallback == null || processMultiMa == null || (maScanResultArr = processMultiMa.maScanResults) == null) {
                        return;
                    }
                    topViewCallback.onAlbumResult(maScanResultArr);
                }
            });
        }
    }

    public void onResultMa(final BQCScanResult[] bQCScanResultArr) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "617424492")) {
            ipChange.ipc$dispatch("617424492", new Object[]{this, bQCScanResultArr});
            return;
        }
        QRCodeActivity qRCodeActivity = this.mActivity;
        if (qRCodeActivity != null) {
            qRCodeActivity.runOnUiThread(new Runnable() { // from class: cn.damai.commonbusiness.qrcode.widget.ToolScanTopView.1
                private static transient /* synthetic */ IpChange $ipChange;

                @Override // java.lang.Runnable
                public void run() {
                    MaScanResult[] maScanResultArr;
                    IpChange ipChange2 = $ipChange;
                    if (AndroidInstantRuntime.support(ipChange2, "1262676035")) {
                        ipChange2.ipc$dispatch("1262676035", new Object[]{this});
                        return;
                    }
                    BQCScanResult[] bQCScanResultArr2 = bQCScanResultArr;
                    if (bQCScanResultArr2 == null || bQCScanResultArr2.length == 0) {
                        return;
                    }
                    BQCScanResult bQCScanResult = bQCScanResultArr2[0];
                    String str = null;
                    if (bQCScanResult != null) {
                        if ((bQCScanResult instanceof MultiMaScanResult) && (maScanResultArr = ((MultiMaScanResult) bQCScanResult).maScanResults) != null && maScanResultArr[0] != null) {
                            str = maScanResultArr[0].text;
                        } else if (bQCScanResult instanceof MaScanResult) {
                            str = ((MaScanResult) bQCScanResult).text;
                        }
                        ey1.a(str, ToolScanTopView.this.mActivity);
                    }
                }
            });
        }
    }

    public void onStartScan() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-110644677")) {
            ipChange.ipc$dispatch("-110644677", new Object[]{this});
        } else {
            this.scanRayView.startScaleAnimation();
        }
    }

    @Override // cn.damai.commonbusiness.qrcode.widget.ScaleFinderView.OnZoomOperatedListener
    public void onZoomReverted() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-627321350")) {
            ipChange.ipc$dispatch("-627321350", new Object[]{this});
            return;
        }
        if (this.autoZoomState != 0) {
            this.autoZoomState = 3;
        }
        QRCodeActivity qRCodeActivity = this.mActivity;
        if (qRCodeActivity != null) {
            qRCodeActivity.revertZoom();
        }
    }

    public void setTopViewCallback(TopViewCallback topViewCallback) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "272385442")) {
            ipChange.ipc$dispatch("272385442", new Object[]{this, topViewCallback});
        } else {
            this.mTopViewCallback = topViewCallback;
        }
    }

    @Override // cn.damai.commonbusiness.qrcode.widget.ScaleFinderView.OnZoomOperatedListener
    public void setZoom(float f) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1169985574")) {
            ipChange.ipc$dispatch("-1169985574", new Object[]{this, Float.valueOf(f)});
            return;
        }
        if (this.autoZoomState != 0) {
            this.autoZoomState = 4;
        }
        QRCodeActivity qRCodeActivity = this.mActivity;
        if (qRCodeActivity != null) {
            qRCodeActivity.setZoom((int) f);
        }
    }

    public ToolScanTopView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public ToolScanTopView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.low_threshold = 70;
        this.high_threshold = 140;
        this.frameNum = 0;
        init(context);
    }

    public Rect getScanRect(Point point, int i, int i2) {
        Rect rect;
        int i3 = i;
        int i4 = i2;
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-2053921648")) {
            return (Rect) ipChange.ipc$dispatch("-2053921648", new Object[]{this, point, Integer.valueOf(i), Integer.valueOf(i2)});
        }
        int[] iArr = new int[2];
        this.scanRayView.getLocationOnScreen(iArr);
        Rect rect2 = new Rect(iArr[0], iArr[1], iArr[0] + this.scanRayView.getWidth(), iArr[1] + this.scanRayView.getHeight());
        double yVar = com.alibaba.wireless.security.aopsdk.replace.android.graphics.Point.gety(point) / i3;
        double xVar = com.alibaba.wireless.security.aopsdk.replace.android.graphics.Point.getx(point) / i4;
        int width = (int) (this.scanRayView.getWidth() * 0.05d);
        int height = (int) (this.scanRayView.getHeight() * 0.05d);
        Rect rect3 = new Rect((int) ((rect2.top - height) * xVar), (int) ((rect2.left - width) * yVar), (int) ((rect2.bottom + height) * xVar), (int) ((rect2.right + width) * yVar));
        int i5 = rect3.left;
        if (i5 < 0) {
            i5 = 0;
        }
        int i6 = rect3.top;
        if (i6 < 0) {
            i6 = 0;
        }
        int width2 = com.alibaba.wireless.security.aopsdk.replace.android.graphics.Rect.width(rect3);
        int xVar2 = com.alibaba.wireless.security.aopsdk.replace.android.graphics.Point.getx(point);
        if (width2 <= xVar2) {
            xVar2 = com.alibaba.wireless.security.aopsdk.replace.android.graphics.Rect.width(rect3);
        }
        int height2 = com.alibaba.wireless.security.aopsdk.replace.android.graphics.Rect.height(rect3);
        int yVar2 = com.alibaba.wireless.security.aopsdk.replace.android.graphics.Point.gety(point);
        if (height2 <= yVar2) {
            yVar2 = com.alibaba.wireless.security.aopsdk.replace.android.graphics.Rect.height(rect3);
        }
        Rect rect4 = new Rect(i5, i6, xVar2, yVar2);
        int i7 = rect3.left;
        if (i7 < 0) {
            i7 = 0;
        }
        int i8 = rect3.top;
        if (i8 < 0) {
            i8 = 0;
        }
        if (com.alibaba.wireless.security.aopsdk.replace.android.graphics.Rect.width(rect3) <= i3) {
            i3 = com.alibaba.wireless.security.aopsdk.replace.android.graphics.Rect.width(rect3);
        }
        if (com.alibaba.wireless.security.aopsdk.replace.android.graphics.Rect.height(rect3) <= i4) {
            i4 = com.alibaba.wireless.security.aopsdk.replace.android.graphics.Rect.height(rect3);
        }
        this.mFinalRect = new Rect(i7, i8, i3, i4);
        Rect rect5 = new Rect((rect4.left / 4) * 4, (rect4.top / 4) * 4, (rect4.right / 4) * 4, (rect4.bottom / 4) * 4);
        int max = Math.max(rect5.right, rect5.bottom);
        int abs = (Math.abs(rect5.right - rect5.bottom) / 8) * 4;
        if (rect5.right > rect5.bottom) {
            rect = new Rect(rect5.left, rect5.top - abs, max, max);
        } else {
            rect = new Rect(rect5.left - abs, rect5.top, max, max);
        }
        int i9 = rect.left;
        int i10 = rect.top;
        Rect rect6 = new Rect(i9, i10, rect.right + i9, rect.bottom + i10);
        this.mFinalRect = rect6;
        int xVar3 = com.alibaba.wireless.security.aopsdk.replace.android.graphics.Point.getx(point);
        int i11 = rect6.left;
        int i12 = rect6.right;
        int i13 = ((xVar3 - i11) - i12) / 2;
        int yVar3 = com.alibaba.wireless.security.aopsdk.replace.android.graphics.Point.gety(point);
        int i14 = rect6.top;
        int i15 = rect6.bottom;
        int i16 = ((yVar3 - i14) - i15) / 2;
        int i17 = i11 + i13;
        rect6.left = i17;
        rect6.right = i12 + i13;
        rect6.top = i14 + i16;
        rect6.bottom = i15 + i16;
        MPaasLogger.d(TAG, new String[]{"getScanRegion(left:", String.valueOf(i17), ", top:", String.valueOf(this.mFinalRect.top), ", right:", String.valueOf(this.mFinalRect.right), ", bottom:", String.valueOf(this.mFinalRect.bottom)});
        MPaasLogger.d(TAG, new String[]{"getScanRect(left:", String.valueOf(rect.left), ", top:", String.valueOf(rect.top), ", right:", String.valueOf(rect.right), ", bottom:", String.valueOf(rect.bottom)});
        return rect;
    }

    @Override // cn.damai.commonbusiness.qrcode.widget.ScaleFinderView.OnZoomOperatedListener
    public void startContinuousZoom(float f) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "311631497")) {
            ipChange.ipc$dispatch("311631497", new Object[]{this, Float.valueOf(f)});
            return;
        }
        QRCodeActivity qRCodeActivity = this.mActivity;
        if (qRCodeActivity != null) {
            qRCodeActivity.startContinueZoom((int) f);
        }
    }
}
