package com.alibaba.security.realidentity.activity;

import android.app.AlertDialog;
import android.app.Dialog;
import android.content.ContentUris;
import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.hardware.Camera;
import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import android.net.Uri;
import android.os.AsyncTask;
import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.provider.DocumentsContract;
import android.provider.MediaStore;
import android.text.TextUtils;
import android.util.DisplayMetrics;
import android.view.KeyEvent;
import android.view.MotionEvent;
import android.view.SurfaceHolder;
import android.view.SurfaceView;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;
import androidx.annotation.NonNull;
import androidx.core.app.ActivityCompat;
import com.alibaba.security.biometrics.R;
import com.alibaba.security.common.d.C3805b;
import com.alibaba.security.common.d.C3808e;
import com.alibaba.security.common.d.C3810g;
import com.alibaba.security.common.d.C3811h;
import com.alibaba.security.common.d.C3812i;
import com.alibaba.security.common.d.C3818l;
import com.alibaba.security.common.d.C3819m;
import com.alibaba.security.common.d.C3825q;
import com.alibaba.security.common.track.a.C3829a;
import com.alibaba.security.common.track.model.C3834a;
import com.alibaba.security.common.track.model.LastExitTrackMsg;
import com.alibaba.security.common.track.model.LastExitTrackMsgPage;
import com.alibaba.security.common.track.model.TrackLog;
import com.alibaba.security.realidentity.a.AbstractC3841b;
import com.alibaba.security.realidentity.a.C3847g;
import com.alibaba.security.realidentity.b.C3855b;
import com.alibaba.security.realidentity.jsbridge.AbstractC3893a;
import com.alibaba.security.realidentity.utils.C3922a;
import com.alibaba.security.realidentity.utils.ImageData;
import com.alibaba.security.realidentity.view.C3927a;
import com.alibaba.wireless.security.aopsdk.replace.android.os.Build;
import com.alibaba.wireless.security.aopsdk.replace.android.view.Display;
import com.youku.live.dago.liveplayback.widget.plugins.resize.AntiShakeOrientationEventListener;
import java.io.File;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Locale;
import java.util.Map;
import java.util.Set;
import tb.C9796v;

/* compiled from: Taobao */
/* loaded from: classes8.dex */
public class RPTakePhotoActivity extends RPBaseActivity implements DialogInterface.OnClickListener, SensorEventListener, SurfaceHolder.Callback, View.OnClickListener, ActivityCompat.OnRequestPermissionsResultCallback, C3922a.InterfaceC3923a {
    private static final int A = 102;
    private static final int B = 103;
    private static final int C = 1;
    private static final String a = "RPTakePhotoActivity";
    private static final int b = -1;
    private static final int c = 0;
    private static final int d = 1;
    private static final int e = 2;
    private static final int f = 3;
    private static final int g = 4;
    private static final int h = 5;
    private static final int i = 6;
    private static final int j = 7;
    private static final int k = 8;
    private static final int l = 9;
    private static final int m = 10;
    private static final int n = 11;
    private static final int o = 12;
    private static final int p = 13;
    private static final int q = 14;
    private static final int r = -1000;
    private static final int s = -100;
    private static final int t = 1;
    private static final int u = 2;
    private static final int v = 3;
    private static final int w = 4;
    private static final int x = 6;
    private static final int y = 100;
    private static final int z = 101;
    private C3855b F;
    private C3922a G;
    private WindowManager H;
    private SurfaceView I;
    private SurfaceHolder J;
    private ImageView K;
    private Intent L;
    private int[] Q;
    private int R;
    private String[] V;
    private String W;
    private ArrayList<ImageData> X;
    private HashMap<String, String> Y;
    private TextView Z;
    private TextView aa;
    private TextView ab;
    private TextView ac;
    private View ad;
    private ViewGroup ae;
    private ViewGroup af;
    private TextView ag;
    private ImageView ah;
    private TextView ai;
    private int aj;
    private ViewGroup ak;
    private ImageView al;
    private TextView am;
    private boolean aq;
    private HandlerC3852a ar;
    private SensorManager av;
    private Sensor aw;
    private int D = 0;
    private int E = 0;
    private boolean M = false;
    private boolean N = false;
    private boolean O = false;
    private boolean P = false;
    private String S = "";
    private int T = 1;
    private int U = 0;
    private boolean an = false;
    private int ao = 0;
    private int ap = 0;
    private final Camera.ShutterCallback as = new Camera.ShutterCallback() { // from class: com.alibaba.security.realidentity.activity.RPTakePhotoActivity.9
        @Override // android.hardware.Camera.ShutterCallback
        public final void onShutter() {
        }
    };
    private Camera.PictureCallback at = new Camera.PictureCallback() { // from class: com.alibaba.security.realidentity.activity.RPTakePhotoActivity.10
        @Override // android.hardware.Camera.PictureCallback
        public final void onPictureTaken(byte[] bArr, Camera camera) {
            if (bArr == null) {
                return;
            }
            try {
                Bitmap a2 = RPTakePhotoActivity.a(C3810g.a(C3810g.a(bArr, RPTakePhotoActivity.this)));
                RPTakePhotoActivity.this.W = C3810g.a(C3810g.a(a2), RPTakePhotoActivity.this);
                if (RPTakePhotoActivity.this.W != null) {
                    RPTakePhotoActivity.this.S = "camera";
                    RPTakePhotoActivity.this.ar.sendEmptyMessage(2);
                    return;
                }
                RPTakePhotoActivity.b(new TakePhotoTrackParams("exit", RPTakePhotoActivity.this.R), new TakePhotoResult("Camera.PictureCallback filePath is null"));
                AbstractC3841b.a().a("RPTakePhotoPage", "ViewExit", String.valueOf(RPTakePhotoActivity.this.R), "error", "5", null);
                RPTakePhotoActivity.this.L.putExtra("errorMsg", AbstractC3893a.aj);
                RPTakePhotoActivity rPTakePhotoActivity = RPTakePhotoActivity.this;
                rPTakePhotoActivity.a(rPTakePhotoActivity.L);
                RPTakePhotoActivity.this.finish();
            } catch (Exception e2) {
                RPTakePhotoActivity.b("Take Photo Camera.PictureCallback", C3805b.a(e2));
                RPTakePhotoActivity.b(new TakePhotoTrackParams("exit", RPTakePhotoActivity.this.R), new TakePhotoResult("Camera.PictureCallback exception"));
                AbstractC3841b.a().a("RPTakePhotoPage", "ViewExit", String.valueOf(RPTakePhotoActivity.this.R), "error", "5", null);
                RPTakePhotoActivity.this.L.putExtra("errorMsg", AbstractC3893a.aj);
                RPTakePhotoActivity rPTakePhotoActivity2 = RPTakePhotoActivity.this;
                rPTakePhotoActivity2.a(rPTakePhotoActivity2.L);
                RPTakePhotoActivity.this.finish();
            }
        }
    };
    private boolean au = false;
    private Camera.AutoFocusCallback ax = new Camera.AutoFocusCallback() { // from class: com.alibaba.security.realidentity.activity.RPTakePhotoActivity.6
        @Override // android.hardware.Camera.AutoFocusCallback
        public final void onAutoFocus(boolean z2, Camera camera) {
        }
    };

    /* compiled from: Taobao */
    /* renamed from: com.alibaba.security.realidentity.activity.RPTakePhotoActivity$8  reason: invalid class name */
    /* loaded from: classes8.dex */
    final class AnonymousClass8 implements View.OnTouchListener {
        AnonymousClass8() {
        }

        @Override // android.view.View.OnTouchListener
        public final boolean onTouch(View view, MotionEvent motionEvent) {
            if (motionEvent.getAction() == 1) {
                if (RPTakePhotoActivity.this.R != 3 || RPTakePhotoActivity.this.M) {
                    RPTakePhotoActivity.this.ar.sendEmptyMessage(6);
                } else {
                    RPTakePhotoActivity.this.l();
                }
            }
            return true;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: Taobao */
    /* loaded from: classes8.dex */
    public static class TakePhotoResult implements Serializable {
        private String reason;

        public String getReason() {
            return this.reason;
        }

        public void setReason(String str) {
            this.reason = str;
        }

        private TakePhotoResult(String str) {
            this.reason = str;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: Taobao */
    /* loaded from: classes8.dex */
    public static class TakePhotoTrackParams implements Serializable {
        private String action;
        private int cart_type;

        public TakePhotoTrackParams(String str, int i) {
            this.action = str;
            this.cart_type = i;
        }

        public String getAction() {
            return this.action;
        }

        public int getCart_type() {
            return this.cart_type;
        }

        public void setAction(String str) {
            this.action = str;
        }

        public void setCart_type(int i) {
            this.cart_type = i;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: Taobao */
    /* renamed from: com.alibaba.security.realidentity.activity.RPTakePhotoActivity$a */
    /* loaded from: classes8.dex */
    public static class HandlerC3852a extends Handler {
        private final RPTakePhotoActivity a;

        public HandlerC3852a(RPTakePhotoActivity rPTakePhotoActivity) {
            super(Looper.getMainLooper());
            this.a = rPTakePhotoActivity;
        }

        @Override // android.os.Handler
        public final void handleMessage(Message message) {
            int i = message.what;
            if (i == 2) {
                RPTakePhotoActivity.k(this.a);
            } else if (i == 3) {
                RPTakePhotoActivity.a(this.a, message);
            } else if (i == 4) {
                RPTakePhotoActivity.l(this.a);
            } else if (i != 6) {
            } else {
                RPTakePhotoActivity.j(this.a);
            }
        }
    }

    private void j() {
        Intent intent = getIntent();
        this.L = intent;
        if (intent != null) {
            this.Y = new HashMap<>();
            this.X = new ArrayList<>();
            String stringExtra = this.L.getStringExtra(AbstractC3893a.J);
            this.V = this.L.getStringArrayExtra(AbstractC3893a.B);
            this.aq = this.L.getBooleanExtra(AbstractC3893a.A, false);
            this.L.setAction(stringExtra);
            int[] intArrayExtra = this.L.getIntArrayExtra(AbstractC3893a.C);
            this.Q = intArrayExtra;
            int i2 = (intArrayExtra == null || intArrayExtra.length <= 0) ? -1000 : intArrayExtra[0];
            this.R = i2;
            if (i2 == -1000) {
                b(new TakePhotoTrackParams("exit", i2), new TakePhotoResult("NoType"));
                AbstractC3841b.a().a("RPTakePhotoPage", "ViewExit", String.valueOf(this.R), "error", "4", null);
                finish();
                return;
            }
            return;
        }
        b(new TakePhotoTrackParams("exit", this.R), new TakePhotoResult("Intent is null"));
        AbstractC3841b.a().a("RPTakePhotoPage", "ViewExit", String.valueOf(this.R), "error", "4", null);
        finish();
    }

    private void k() {
        if (this.M) {
            this.al.setVisibility(0);
            this.ab.setVisibility(0);
            if (this.V.length == 1) {
                this.ab.setVisibility(8);
            }
            this.ad.setVisibility(0);
            this.ac.setText(getString(R.string.close_gesture));
            this.M = false;
            return;
        }
        l();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void l() {
        this.al.setVisibility(8);
        this.ab.setVisibility(8);
        this.ad.setVisibility(8);
        this.ac.setText(getString(R.string.open_gesture));
        this.M = true;
    }

    private void m() {
        this.al.setVisibility(0);
        this.ab.setVisibility(0);
        if (this.V.length == 1) {
            this.ab.setVisibility(8);
        }
        this.ad.setVisibility(0);
        this.ac.setText(getString(R.string.close_gesture));
        this.M = false;
    }

    private void n() {
        Iterator<Map.Entry<String, String>> it = this.Y.entrySet().iterator();
        Set<Map.Entry<String, String>> entrySet = this.Y.entrySet();
        int i2 = this.T;
        String[] strArr = this.V;
        if (i2 == strArr.length || i2 > strArr.length) {
            this.T = 0;
        }
        if (entrySet.size() == 1) {
            this.ab.setVisibility(8);
            return;
        }
        while (it.hasNext()) {
            String str = this.Y.get(this.V[this.T]);
            if (!TextUtils.isEmpty(str)) {
                this.al.setImageURI(Uri.fromFile(new File(str)));
                int i3 = this.T;
                this.U = i3;
                this.T = i3 + 1;
                return;
            }
            int i4 = this.T + 1;
            this.T = i4;
            if (i4 == this.V.length) {
                this.T = 0;
            }
        }
    }

    private void o() {
        AbstractC3841b.a().a("RPPreviewPhotoPage", "ViewExit", String.valueOf(this.R), "cancel", null, null);
        this.ag.setEnabled(false);
        this.O = false;
        if (this.R == 3) {
            this.ac.setEnabled(true);
        }
        a(this.ah);
        this.af.setVisibility(8);
        this.ae.setVisibility(0);
        if (this.O) {
            return;
        }
        this.I.setVisibility(0);
    }

    private void p() {
        String[] strArr;
        ImageData imageData = new ImageData();
        imageData.a = this.W;
        int i2 = this.R;
        imageData.b = i2;
        imageData.d = this.S;
        if (i2 == 3 && (strArr = this.V) != null && strArr.length > 0) {
            imageData.c = strArr[this.U];
        }
        this.X.add(imageData);
        this.L.putExtra(AbstractC3893a.K, this.X);
    }

    private void q() {
        int[] iArr = this.Q;
        if (iArr.length > 0) {
            int i2 = this.aj;
            iArr[i2] = -100;
            if (i2 < iArr.length - 1) {
                this.R = iArr[i2 + 1];
                this.aj = i2 + 1;
            }
        }
        if (iArr[iArr.length - 1] == -100) {
            a(this.L);
            finish();
            return;
        }
        if (!this.O) {
            a(this.R);
            this.I.setVisibility(0);
        }
        this.af.setVisibility(8);
        this.ae.setVisibility(0);
    }

    private void r() {
        int i2 = 0;
        while (true) {
            String[] strArr = this.V;
            if (i2 >= strArr.length) {
                return;
            }
            String str = this.Y.get(strArr[i2]);
            if (!TextUtils.isEmpty(str)) {
                this.al.setImageURI(Uri.fromFile(new File(str)));
                this.al.setBackgroundColor(getResources().getColor(R.C3734color.rpsdk_transparency_65));
                this.al.setScaleType(ImageView.ScaleType.FIT_CENTER);
                this.ac.setVisibility(0);
                this.U = i2;
                this.T = i2 + 1;
                return;
            }
            if (i2 == this.V.length - 1) {
                b(new TakePhotoTrackParams("exit", this.R), new TakePhotoResult("imgDownloadFail"));
                AbstractC3841b.a().a("RPTakePhotoPage", "ViewExit", String.valueOf(this.R), "error", "2", null);
                Toast.makeText(this, getString(R.string.load_gesture_img_faild), 0).show();
                a(this.L);
                finish();
            }
            i2++;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void s() {
        String[] strArr = {"android.permission.READ_EXTERNAL_STORAGE"};
        if (this.E <= 0 && !C3819m.a(this, strArr)) {
            this.E++;
            C3819m.a(this, strArr, 103, "人脸识别服务需要您授权存储权限", new Runnable() { // from class: com.alibaba.security.realidentity.activity.RPTakePhotoActivity.13
                @Override // java.lang.Runnable
                public final void run() {
                    RPTakePhotoActivity.this.s();
                }
            }, new Runnable() { // from class: com.alibaba.security.realidentity.activity.RPTakePhotoActivity.14
                @Override // java.lang.Runnable
                public final void run() {
                    RPTakePhotoActivity.this.s();
                }
            });
        } else if (!C3819m.a(this, strArr)) {
            AlertDialog create = new AlertDialog.Builder(this).setTitle("无法打开相册").setMessage("无法读取相册图片，请检查是否开启了存储读取权限").setPositiveButton("确定", this).setNeutralButton("退出", new DialogInterface.OnClickListener() { // from class: com.alibaba.security.realidentity.activity.RPTakePhotoActivity.2
                @Override // android.content.DialogInterface.OnClickListener
                public final void onClick(DialogInterface dialogInterface, int i2) {
                    dialogInterface.dismiss();
                }
            }).create();
            create.setCancelable(false);
            create.show();
        } else {
            Intent intent = new Intent();
            intent.setType("image/*");
            intent.setAction("android.intent.action.GET_CONTENT");
            startActivityForResult(intent, 101);
        }
    }

    private static LastExitTrackMsg t() {
        LastExitTrackMsg lastExitTrackMsg = new LastExitTrackMsg();
        lastExitTrackMsg.setPage(LastExitTrackMsgPage.TAKE_PHOTO.getMsg());
        lastExitTrackMsg.setView("");
        lastExitTrackMsg.setParams("");
        return lastExitTrackMsg;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void u() {
        if (this.P) {
            return;
        }
        String[] strArr = {"android.permission.CAMERA"};
        if (this.D <= 0 && !C3819m.a(this, strArr)) {
            this.D++;
            C3819m.a(this, strArr, 102, "人脸识别服务需要您授权相机权限", new Runnable() { // from class: com.alibaba.security.realidentity.activity.RPTakePhotoActivity.3
                @Override // java.lang.Runnable
                public final void run() {
                    RPTakePhotoActivity.this.u();
                }
            }, new Runnable() { // from class: com.alibaba.security.realidentity.activity.RPTakePhotoActivity.4
                @Override // java.lang.Runnable
                public final void run() {
                    RPTakePhotoActivity.this.u();
                }
            });
        } else if (!C3819m.a(this, strArr)) {
            AlertDialog create = new AlertDialog.Builder(this).setTitle("无法连接相机").setMessage("无法打开摄像头，请检查是否开启了相关权限").setPositiveButton("确定", this).setNeutralButton("退出", new DialogInterface.OnClickListener() { // from class: com.alibaba.security.realidentity.activity.RPTakePhotoActivity.5
                @Override // android.content.DialogInterface.OnClickListener
                public final void onClick(DialogInterface dialogInterface, int i2) {
                    dialogInterface.dismiss();
                }
            }).create();
            create.setCancelable(false);
            create.show();
        } else {
            this.F = null;
            this.F = new C3855b(this);
            this.F.a(C3855b.d());
            Build.getMODEL().toLowerCase(Locale.US).replace(" ", "");
            try {
                C3855b c3855b = this.F;
                if (c3855b != null) {
                    c3855b.a(this.J);
                    this.P = true;
                    this.F.b();
                    this.K.setEnabled(true);
                }
            } catch (Exception unused) {
                AlertDialog create2 = new AlertDialog.Builder(this).setTitle("无法连接相机").setMessage("无法打开摄像头，请检查是否开启了相关权限").setPositiveButton("确定", this).setNeutralButton("退出", this).create();
                create2.setCancelable(false);
                create2.show();
            }
        }
    }

    private void v() {
        String valueOf = String.valueOf(this.R);
        AbstractC3841b.a().a("RPTakePhotoPage", "ViewExit", valueOf, "goPreview", null, null);
        AbstractC3841b.a().a("RPPreviewPhotoPage", "ViewEnter", valueOf, null, null, null);
        this.I.setVisibility(8);
        this.ai.setEnabled(true);
        this.ag.setEnabled(true);
        this.O = true;
        this.P = false;
        ViewGroup viewGroup = this.af;
        if (viewGroup != null) {
            viewGroup.setVisibility(0);
        }
        ViewGroup viewGroup2 = this.ae;
        if (viewGroup2 != null) {
            viewGroup2.setVisibility(8);
        }
        this.ah.setImageBitmap(BitmapFactory.decodeFile(this.W));
    }

    private void w() {
        Build.getMODEL().toLowerCase(Locale.US).replace(" ", "");
        SensorManager sensorManager = (SensorManager) getSystemService("sensor");
        this.av = sensorManager;
        if (sensorManager != null) {
            Sensor defaultSensor = com.alibaba.wireless.security.aopsdk.replace.android.hardware.SensorManager.getDefaultSensor(sensorManager, 1);
            this.aw = defaultSensor;
            this.av.registerListener(this, defaultSensor, 3);
            this.G = new C3922a(this);
        }
    }

    private void x() {
        AbstractC3841b.a().a("RPTakePhotoPage", "ViewExit", String.valueOf(this.R), "error", "1", null);
        finish();
    }

    @Override // android.hardware.SensorEventListener
    public void onAccuracyChanged(Sensor sensor, int i2) {
    }

    @Override // android.app.Activity
    protected void onActivityResult(int i2, int i3, Intent intent) {
        String a2;
        if (i2 == 101 && i3 == -1) {
            Uri data = intent.getData();
            if (Build.VERSION.SDK_INT >= 19) {
                if (DocumentsContract.isDocumentUri(this, data)) {
                    String documentId = DocumentsContract.getDocumentId(data);
                    if ("com.android.providers.media.documents".equals(data.getAuthority())) {
                        a2 = C3808e.a(this, MediaStore.Images.Media.EXTERNAL_CONTENT_URI, "_id=?", new String[]{documentId.split(":")[1]});
                    } else {
                        if ("com.android.providers.downloads.documents".equals(data.getAuthority())) {
                            a2 = C3808e.a(this, ContentUris.withAppendedId(Uri.parse("content://downloads/public_downloads"), Long.valueOf(documentId).longValue()), null, null);
                        }
                        a2 = null;
                    }
                } else if ("content".equalsIgnoreCase(data.getScheme())) {
                    a2 = C3808e.a(this, data, null, null);
                } else {
                    if ("file".equals(data.getScheme())) {
                        a2 = data.getPath();
                    }
                    a2 = null;
                }
            } else {
                a2 = C3808e.a(this, data, null, null);
            }
            this.W = a2;
            if (a2 != null) {
                this.S = "photoAlbum";
                this.ar.sendEmptyMessage(2);
            } else {
                b(new TakePhotoTrackParams("exit", this.R), new TakePhotoResult("onActivityResult filePath is null"));
                AbstractC3841b.a().a("RPTakePhotoPage", "ViewExit", String.valueOf(this.R), "error", "5", null);
                this.L.putExtra("errorMsg", AbstractC3893a.aj);
                finish();
                a(this.L);
            }
        }
        super.onActivityResult(i2, i3, intent);
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        String[] strArr;
        int id = view.getId();
        if (id == R.id.cancel_text) {
            b(new TakePhotoTrackParams("exit", this.R), new TakePhotoResult("cancel"));
            AbstractC3841b.a().a("RPTakePhotoPage", "ViewExit", String.valueOf(this.R), "cancel", null, null);
            this.L.putExtra(AbstractC3893a.ac, true);
            a(this.L);
            finish();
        } else if (id == R.id.tv_close_examples) {
            if (this.M) {
                this.al.setVisibility(0);
                this.ab.setVisibility(0);
                if (this.V.length == 1) {
                    this.ab.setVisibility(8);
                }
                this.ad.setVisibility(0);
                this.ac.setText(getString(R.string.close_gesture));
                this.M = false;
                return;
            }
            l();
        } else if (id == R.id.tv_switch_gesture) {
            Iterator<Map.Entry<String, String>> it = this.Y.entrySet().iterator();
            Set<Map.Entry<String, String>> entrySet = this.Y.entrySet();
            int i2 = this.T;
            String[] strArr2 = this.V;
            if (i2 == strArr2.length || i2 > strArr2.length) {
                this.T = 0;
            }
            if (entrySet.size() == 1) {
                this.ab.setVisibility(8);
                return;
            }
            while (it.hasNext()) {
                String str = this.Y.get(this.V[this.T]);
                if (!TextUtils.isEmpty(str)) {
                    this.al.setImageURI(Uri.fromFile(new File(str)));
                    int i3 = this.T;
                    this.U = i3;
                    this.T = i3 + 1;
                    return;
                }
                int i4 = this.T + 1;
                this.T = i4;
                if (i4 == this.V.length) {
                    this.T = 0;
                }
            }
        } else if (id == R.id.reget_button) {
            o();
        } else if (id == R.id.pick_photo_text && this.an) {
            C3927a.C3928a c3928a = new C3927a.C3928a(this);
            c3928a.b = "图片上传说明";
            c3928a.c = "请确保图片符合以下要求：";
            c3928a.d = "1. 身份证正反面分开上传\n2. 图片需原件拍照件或扫描件";
            c3928a.h = true;
            c3928a.i = false;
            C3927a.InterfaceC3930c interfaceC3930c = new C3927a.InterfaceC3930c() { // from class: com.alibaba.security.realidentity.activity.RPTakePhotoActivity.12
                @Override // com.alibaba.security.realidentity.view.C3927a.InterfaceC3930c
                public final void a(Dialog dialog) {
                    dialog.dismiss();
                    RPTakePhotoActivity.this.s();
                }
            };
            c3928a.j = "继续";
            c3928a.l = interfaceC3930c;
            C3927a.InterfaceC3929b interfaceC3929b = new C3927a.InterfaceC3929b() { // from class: com.alibaba.security.realidentity.activity.RPTakePhotoActivity.11
                @Override // com.alibaba.security.realidentity.view.C3927a.InterfaceC3929b
                public final void a(Dialog dialog) {
                    dialog.dismiss();
                }
            };
            c3928a.m = "取消";
            c3928a.o = interfaceC3929b;
            new C3927a(c3928a);
        } else if (id == R.id.next_button) {
            AbstractC3841b.a().a("RPPreviewPhotoPage", "ViewExit", String.valueOf(this.R), "confirm", null, null);
            this.ai.setEnabled(false);
            this.O = false;
            a(this.ah);
            a(this.al);
            ImageData imageData = new ImageData();
            imageData.a = this.W;
            int i5 = this.R;
            imageData.b = i5;
            imageData.d = this.S;
            if (i5 == 3 && (strArr = this.V) != null && strArr.length > 0) {
                imageData.c = strArr[this.U];
            }
            this.X.add(imageData);
            this.L.putExtra(AbstractC3893a.K, this.X);
            int[] iArr = this.Q;
            if (iArr.length > 0) {
                int i6 = this.aj;
                iArr[i6] = -100;
                if (i6 < iArr.length - 1) {
                    this.R = iArr[i6 + 1];
                    this.aj = i6 + 1;
                }
            }
            if (iArr[iArr.length - 1] == -100) {
                a(this.L);
                finish();
                return;
            }
            if (!this.O) {
                a(this.R);
                this.I.setVisibility(0);
            }
            this.af.setVisibility(8);
            this.ae.setVisibility(0);
        }
    }

    @Override // android.app.Activity
    protected void onCreate(Bundle bundle) {
        requestWindowFeature(1);
        getWindow().setFlags(1024, 1024);
        super.onCreate(bundle);
        if (Build.VERSION.SDK_INT != 26) {
            setRequestedOrientation(1);
        }
        setContentView(R.C3736layout.rp_alrealidentity_activity_rp_take_photo);
        this.H = (WindowManager) getApplicationContext().getSystemService(C9796v.ATTACH_MODE_WINDOW);
        this.ar = new HandlerC3852a(this);
        this.ae = (ViewGroup) findViewById(R.id.rp_take_photo_layout);
        this.ak = (ViewGroup) findViewById(R.id.take_modle_parent);
        this.ad = findViewById(R.id.detile_parent);
        this.al = (ImageView) findViewById(R.id.take_photo_background_img);
        TextView textView = (TextView) findViewById(R.id.tv_switch_gesture);
        this.ab = textView;
        textView.setOnClickListener(this);
        TextView textView2 = (TextView) findViewById(R.id.tv_close_examples);
        this.ac = textView2;
        textView2.setOnClickListener(this);
        this.Z = (TextView) findViewById(R.id.tv_card_tips);
        this.aa = (TextView) findViewById(R.id.tv_take_photo_hint);
        findViewById(R.id.cancel_text).setOnClickListener(this);
        ImageView imageView = (ImageView) findViewById(R.id.take_photo);
        this.K = imageView;
        imageView.setEnabled(false);
        TextView textView3 = (TextView) findViewById(R.id.pick_photo_text);
        this.am = textView3;
        textView3.setOnClickListener(this);
        this.I = (SurfaceView) findViewById(R.id.my_surfaceView);
        this.ao = this.ad.getLayoutParams().height;
        this.ap = ((RelativeLayout.LayoutParams) this.ak.getLayoutParams()).leftMargin;
        this.af = (ViewGroup) findViewById(R.id.rp_preview_layout);
        TextView textView4 = (TextView) findViewById(R.id.reget_button);
        this.ag = textView4;
        textView4.setOnClickListener(this);
        TextView textView5 = (TextView) findViewById(R.id.next_button);
        this.ai = textView5;
        textView5.setOnClickListener(this);
        this.ah = (ImageView) findViewById(R.id.picture);
        SurfaceHolder holder = this.I.getHolder();
        this.J = holder;
        holder.addCallback(this);
        Intent intent = getIntent();
        this.L = intent;
        if (intent != null) {
            this.Y = new HashMap<>();
            this.X = new ArrayList<>();
            String stringExtra = this.L.getStringExtra(AbstractC3893a.J);
            this.V = this.L.getStringArrayExtra(AbstractC3893a.B);
            this.aq = this.L.getBooleanExtra(AbstractC3893a.A, false);
            this.L.setAction(stringExtra);
            int[] intArrayExtra = this.L.getIntArrayExtra(AbstractC3893a.C);
            this.Q = intArrayExtra;
            int i2 = (intArrayExtra == null || intArrayExtra.length <= 0) ? -1000 : intArrayExtra[0];
            this.R = i2;
            if (i2 == -1000) {
                b(new TakePhotoTrackParams("exit", i2), new TakePhotoResult("NoType"));
                AbstractC3841b.a().a("RPTakePhotoPage", "ViewExit", String.valueOf(this.R), "error", "4", null);
                finish();
            }
        } else {
            b(new TakePhotoTrackParams("exit", this.R), new TakePhotoResult("Intent is null"));
            AbstractC3841b.a().a("RPTakePhotoPage", "ViewExit", String.valueOf(this.R), "error", "4", null);
            finish();
        }
        a(this.R);
        a(this.V);
        this.K.setOnTouchListener(new AnonymousClass8());
        this.I.setOnClickListener(new View.OnClickListener() { // from class: com.alibaba.security.realidentity.activity.RPTakePhotoActivity.1
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                RPTakePhotoActivity.this.a();
            }
        });
        a();
        C3825q.a(getWindow().getDecorView());
        b(new TakePhotoTrackParams("enter", this.R), (TakePhotoResult) null);
        C3829a.C3830a.a.a = null;
    }

    @Override // android.app.Activity
    protected void onDestroy() {
        SensorManager sensorManager = this.av;
        if (sensorManager != null) {
            sensorManager.unregisterListener(this);
            this.ax = null;
        }
        this.Y.clear();
        this.Y = null;
        this.X.clear();
        this.X = null;
        C3855b c3855b = this.F;
        if (c3855b != null) {
            c3855b.a();
            this.F = null;
        }
        this.L = null;
        this.ar.removeCallbacksAndMessages(null);
        this.V = null;
        this.Q = null;
        this.at = null;
        this.ak.removeAllViews();
        this.af.removeAllViews();
        this.ae.removeAllViews();
        super.onDestroy();
    }

    @Override // android.app.Activity, android.view.KeyEvent.Callback
    public boolean onKeyDown(int i2, KeyEvent keyEvent) {
        if (i2 == 4) {
            if (this.O) {
                o();
                return true;
            }
            AbstractC3841b.a().a("RPTakePhotoPage", "ViewExit", String.valueOf(this.R), "cancel", null, null);
            b(new TakePhotoTrackParams("exit", this.R), new TakePhotoResult("album cancel"));
            this.L.putExtra(AbstractC3893a.ac, true);
            a(this.L);
            LastExitTrackMsg lastExitTrackMsg = new LastExitTrackMsg();
            lastExitTrackMsg.setPage(LastExitTrackMsgPage.TAKE_PHOTO.getMsg());
            lastExitTrackMsg.setView("");
            lastExitTrackMsg.setParams("");
            C3829a.C3830a.a.a = lastExitTrackMsg;
        }
        return super.onKeyDown(i2, keyEvent);
    }

    @Override // android.app.Activity, androidx.core.app.ActivityCompat.OnRequestPermissionsResultCallback
    public void onRequestPermissionsResult(int i2, @NonNull String[] strArr, @NonNull int[] iArr) {
        super.onRequestPermissionsResult(i2, strArr, iArr);
        if (i2 == 102) {
            u();
        } else if (i2 == 103) {
            s();
        }
    }

    @Override // android.app.Activity
    public void onResume() {
        super.onResume();
        if (this.O) {
            return;
        }
        this.I.setVisibility(0);
    }

    @Override // android.hardware.SensorEventListener
    public void onSensorChanged(SensorEvent sensorEvent) {
        Sensor sensor;
        C3922a c3922a = this.G;
        if (c3922a == null || (sensor = sensorEvent.sensor) == null) {
            return;
        }
        if (c3922a.f) {
            c3922a.m = 0;
            c3922a.g = false;
            c3922a.a = 0;
            c3922a.b = 0;
            c3922a.c = 0;
        } else if (sensor.getType() == 1) {
            float[] fArr = sensorEvent.values;
            int i2 = (int) fArr[0];
            int i3 = (int) fArr[1];
            int i4 = (int) fArr[2];
            Calendar calendar = Calendar.getInstance();
            c3922a.e = calendar;
            long timeInMillis = calendar.getTimeInMillis();
            c3922a.e.get(13);
            if (c3922a.m != 0) {
                int abs = Math.abs(c3922a.a - i2);
                int abs2 = Math.abs(c3922a.b - i3);
                int abs3 = Math.abs(c3922a.c - i4);
                if (Math.sqrt((abs * abs) + (abs2 * abs2) + (abs3 * abs3)) > 1.4d) {
                    c3922a.m = 2;
                } else {
                    if (c3922a.m == 2) {
                        c3922a.d = timeInMillis;
                        c3922a.g = true;
                    }
                    if (c3922a.g && timeInMillis - c3922a.d > 500 && !c3922a.f) {
                        c3922a.g = false;
                        C3922a.InterfaceC3923a interfaceC3923a = c3922a.n;
                        if (interfaceC3923a != null) {
                            interfaceC3923a.a();
                        }
                    }
                    c3922a.m = 1;
                }
            } else {
                c3922a.d = timeInMillis;
                c3922a.m = 1;
            }
            c3922a.a = i2;
            c3922a.b = i3;
            c3922a.c = i4;
        }
    }

    @Override // android.app.Activity
    protected void onStop() {
        super.onStop();
        if (this.O) {
            return;
        }
        this.I.setVisibility(8);
    }

    @Override // android.view.SurfaceHolder.Callback
    public void surfaceChanged(SurfaceHolder surfaceHolder, int i2, int i3, int i4) {
    }

    @Override // android.view.SurfaceHolder.Callback
    public void surfaceCreated(SurfaceHolder surfaceHolder) {
        if (this.O) {
            return;
        }
        u();
        com.alibaba.wireless.security.aopsdk.replace.android.os.Build.getMODEL().toLowerCase(Locale.US).replace(" ", "");
        SensorManager sensorManager = (SensorManager) getSystemService("sensor");
        this.av = sensorManager;
        if (sensorManager != null) {
            Sensor defaultSensor = com.alibaba.wireless.security.aopsdk.replace.android.hardware.SensorManager.getDefaultSensor(sensorManager, 1);
            this.aw = defaultSensor;
            this.av.registerListener(this, defaultSensor, 3);
            this.G = new C3922a(this);
        }
        this.au = true;
    }

    @Override // android.view.SurfaceHolder.Callback
    public void surfaceDestroyed(SurfaceHolder surfaceHolder) {
        if (this.O) {
            return;
        }
        SensorManager sensorManager = this.av;
        if (sensorManager != null) {
            sensorManager.unregisterListener(this);
        }
        C3855b c3855b = this.F;
        if (c3855b != null) {
            c3855b.c();
            this.F.a();
            this.F = null;
            this.P = false;
        }
        this.au = false;
    }

    private void c() {
        this.ae = (ViewGroup) findViewById(R.id.rp_take_photo_layout);
        this.ak = (ViewGroup) findViewById(R.id.take_modle_parent);
        this.ad = findViewById(R.id.detile_parent);
        this.al = (ImageView) findViewById(R.id.take_photo_background_img);
        TextView textView = (TextView) findViewById(R.id.tv_switch_gesture);
        this.ab = textView;
        textView.setOnClickListener(this);
        TextView textView2 = (TextView) findViewById(R.id.tv_close_examples);
        this.ac = textView2;
        textView2.setOnClickListener(this);
        this.Z = (TextView) findViewById(R.id.tv_card_tips);
        this.aa = (TextView) findViewById(R.id.tv_take_photo_hint);
        findViewById(R.id.cancel_text).setOnClickListener(this);
        ImageView imageView = (ImageView) findViewById(R.id.take_photo);
        this.K = imageView;
        imageView.setEnabled(false);
        TextView textView3 = (TextView) findViewById(R.id.pick_photo_text);
        this.am = textView3;
        textView3.setOnClickListener(this);
        this.I = (SurfaceView) findViewById(R.id.my_surfaceView);
        this.ao = this.ad.getLayoutParams().height;
        this.ap = ((RelativeLayout.LayoutParams) this.ak.getLayoutParams()).leftMargin;
        this.af = (ViewGroup) findViewById(R.id.rp_preview_layout);
        TextView textView4 = (TextView) findViewById(R.id.reget_button);
        this.ag = textView4;
        textView4.setOnClickListener(this);
        TextView textView5 = (TextView) findViewById(R.id.next_button);
        this.ai = textView5;
        textView5.setOnClickListener(this);
        this.ah = (ImageView) findViewById(R.id.picture);
    }

    private void d() {
        this.ae = (ViewGroup) findViewById(R.id.rp_take_photo_layout);
        this.ak = (ViewGroup) findViewById(R.id.take_modle_parent);
        this.ad = findViewById(R.id.detile_parent);
        this.al = (ImageView) findViewById(R.id.take_photo_background_img);
        TextView textView = (TextView) findViewById(R.id.tv_switch_gesture);
        this.ab = textView;
        textView.setOnClickListener(this);
        TextView textView2 = (TextView) findViewById(R.id.tv_close_examples);
        this.ac = textView2;
        textView2.setOnClickListener(this);
        this.Z = (TextView) findViewById(R.id.tv_card_tips);
        this.aa = (TextView) findViewById(R.id.tv_take_photo_hint);
        findViewById(R.id.cancel_text).setOnClickListener(this);
        ImageView imageView = (ImageView) findViewById(R.id.take_photo);
        this.K = imageView;
        imageView.setEnabled(false);
        TextView textView3 = (TextView) findViewById(R.id.pick_photo_text);
        this.am = textView3;
        textView3.setOnClickListener(this);
        this.I = (SurfaceView) findViewById(R.id.my_surfaceView);
        this.ao = this.ad.getLayoutParams().height;
        this.ap = ((RelativeLayout.LayoutParams) this.ak.getLayoutParams()).leftMargin;
    }

    private void e() {
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-1, -2);
        layoutParams.height = this.ao;
        layoutParams.addRule(15);
        this.ad.setLayoutParams(layoutParams);
        this.ad.setRotation(90.0f);
        DisplayMetrics displayMetrics = new DisplayMetrics();
        Display.getMetrics(this.H.getDefaultDisplay(), displayMetrics);
        int i2 = com.alibaba.wireless.security.aopsdk.replace.android.util.DisplayMetrics.getwidthPixels(displayMetrics);
        int i3 = this.ad.getLayoutParams().height;
        this.ad.setTranslationX((i2 - (i3 + (i3 / 2))) / 2.0f);
        RelativeLayout.LayoutParams layoutParams2 = (RelativeLayout.LayoutParams) this.ak.getLayoutParams();
        layoutParams2.leftMargin = this.ap;
        this.ak.setLayoutParams(layoutParams2);
    }

    private void f() {
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-1, -2);
        layoutParams.height = this.ao;
        layoutParams.addRule(10);
        this.ad.setLayoutParams(layoutParams);
        this.ad.setRotation(0.0f);
        this.ad.setTranslationX(0.0f);
        RelativeLayout.LayoutParams layoutParams2 = (RelativeLayout.LayoutParams) this.ak.getLayoutParams();
        layoutParams2.leftMargin = 0;
        this.ak.setLayoutParams(layoutParams2);
    }

    private void g() {
        this.af = (ViewGroup) findViewById(R.id.rp_preview_layout);
        TextView textView = (TextView) findViewById(R.id.reget_button);
        this.ag = textView;
        textView.setOnClickListener(this);
        TextView textView2 = (TextView) findViewById(R.id.next_button);
        this.ai = textView2;
        textView2.setOnClickListener(this);
        this.ah = (ImageView) findViewById(R.id.picture);
    }

    private void h() {
        this.K.setOnTouchListener(new AnonymousClass8());
    }

    private void i() {
        this.K.setEnabled(false);
        SensorManager sensorManager = this.av;
        if (sensorManager != null) {
            sensorManager.unregisterListener(this);
        }
        if (this.au) {
            this.au = false;
            if (this.R == 3) {
                this.O = false;
                this.ac.setEnabled(false);
            }
            try {
                this.F.a.takePicture(this.as, null, this.at);
            } catch (Exception e2) {
                C3847g.C3848a.a.a(TrackLog.createSdkExceptionLog("takePhoto camera exception", C3805b.a(e2), ""));
                a(this.L);
                AbstractC3841b.a().a("RPTakePhotoPage", "ViewExit", String.valueOf(this.R), "error", "3", null);
                finish();
            }
        }
    }

    private void b() {
        SurfaceHolder holder = this.I.getHolder();
        this.J = holder;
        holder.addCallback(this);
    }

    private static Bitmap b(Bitmap bitmap) {
        if (com.alibaba.wireless.security.aopsdk.replace.android.os.Build.getMODEL().toLowerCase(Locale.US).replace(" ", "").contains("nexus5x")) {
            return C3810g.a(bitmap, (int) AntiShakeOrientationEventListener.SCREEN_ORIENTATION_LANDSCAPE);
        }
        return C3810g.a(bitmap, 90);
    }

    private void a(String[] strArr) {
        if (strArr != null) {
            for (String str : strArr) {
                new AsyncTask<String, Void, Void>() { // from class: com.alibaba.security.realidentity.activity.RPTakePhotoActivity.7
                    private Void a(String... strArr2) {
                        String a2 = C3810g.a(strArr2[0], RPTakePhotoActivity.this);
                        if (TextUtils.isEmpty(a2) || RPTakePhotoActivity.this.Y == null) {
                            return null;
                        }
                        RPTakePhotoActivity.this.Y.put(strArr2[0], a2);
                        return null;
                    }

                    @Override // android.os.AsyncTask
                    protected final /* synthetic */ Void doInBackground(String[] strArr2) {
                        String[] strArr3 = strArr2;
                        String a2 = C3810g.a(strArr3[0], RPTakePhotoActivity.this);
                        if (TextUtils.isEmpty(a2) || RPTakePhotoActivity.this.Y == null) {
                            return null;
                        }
                        RPTakePhotoActivity.this.Y.put(strArr3[0], a2);
                        return null;
                    }
                }.execute(str);
            }
        }
    }

    static /* synthetic */ void l(RPTakePhotoActivity rPTakePhotoActivity) {
        AbstractC3841b.a().a("RPTakePhotoPage", "ViewExit", String.valueOf(rPTakePhotoActivity.R), "error", "1", null);
        rPTakePhotoActivity.finish();
    }

    private static int a(int[] iArr) {
        if (iArr == null || iArr.length <= 0) {
            return -1000;
        }
        return iArr[0];
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void b(String str, String str2) {
        TrackLog createSdkExceptionLog = TrackLog.createSdkExceptionLog(str, str2, "");
        createSdkExceptionLog.setCode(-1);
        C3847g.C3848a.a.a(createSdkExceptionLog);
    }

    static /* synthetic */ void k(RPTakePhotoActivity rPTakePhotoActivity) {
        String valueOf = String.valueOf(rPTakePhotoActivity.R);
        AbstractC3841b.a().a("RPTakePhotoPage", "ViewExit", valueOf, "goPreview", null, null);
        AbstractC3841b.a().a("RPPreviewPhotoPage", "ViewEnter", valueOf, null, null, null);
        rPTakePhotoActivity.I.setVisibility(8);
        rPTakePhotoActivity.ai.setEnabled(true);
        rPTakePhotoActivity.ag.setEnabled(true);
        rPTakePhotoActivity.O = true;
        rPTakePhotoActivity.P = false;
        ViewGroup viewGroup = rPTakePhotoActivity.af;
        if (viewGroup != null) {
            viewGroup.setVisibility(0);
        }
        ViewGroup viewGroup2 = rPTakePhotoActivity.ae;
        if (viewGroup2 != null) {
            viewGroup2.setVisibility(8);
        }
        rPTakePhotoActivity.ah.setImageBitmap(BitmapFactory.decodeFile(rPTakePhotoActivity.W));
    }

    private void a(int i2) {
        String valueOf = String.valueOf(i2);
        AbstractC3841b.a().a("RPTakePhotoPage", "ViewEnter", valueOf, null, null, null);
        this.ad.setBackgroundResource(R.C3734color.rpsdk_detile_parent_normalbg);
        this.ab.setVisibility(8);
        this.ac.setVisibility(8);
        this.ad.setVisibility(0);
        this.al.setVisibility(0);
        this.al.setScaleType(ImageView.ScaleType.FIT_XY);
        this.al.setBackgroundResource(0);
        this.ac.setText(getString(R.string.close_gesture));
        this.M = false;
        a(false);
        if (i2 == 1) {
            this.Z.setText(getString(R.string.identity_front_title));
            this.aa.setText(getString(R.string.identity_hint));
            this.al.setImageResource(R.C3735drawable.rp_frontcardpic);
            a(true);
            e();
        } else if (i2 == 2) {
            this.Z.setText(getString(R.string.identity_back_title));
            this.aa.setText(getString(R.string.identity_hint));
            this.al.setImageResource(R.C3735drawable.rp_backcardpic);
            a(true);
            e();
        } else if (i2 == 3) {
            this.Z.setText(getString(R.string.gesture_tips_title));
            this.aa.setText(getString(R.string.gesture_tips_hint));
            this.ab.setVisibility(0);
            if (this.V.length == 1) {
                this.ab.setVisibility(8);
            }
            this.ar.sendEmptyMessageDelayed(3, 300L);
            f();
        } else if (i2 == 4) {
            this.Z.setText(getString(R.string.passport_tips_title));
            this.aa.setText(getString(R.string.passport_tips_hint));
            this.al.setImageResource(R.C3735drawable.rp_backcardhk);
            f();
        } else if (i2 == 5) {
            this.Z.setText(getString(R.string.id_hk_front_title));
            this.aa.setText(getString(R.string.id_hk_hint));
            this.al.setImageResource(R.C3735drawable.rp_hkpassport_bg);
            e();
        } else if (i2 == 6) {
            this.Z.setText(getString(R.string.hk_id_tips_title));
            this.aa.setText(getString(R.string.hk_id_tips_hint));
            this.al.setImageResource(R.C3735drawable.rp_hkpassport_bg);
            e();
        } else if (i2 == 7) {
            this.Z.setText(getString(R.string.id_tw_back_title));
            this.aa.setText(getString(R.string.id_tw_hint));
            this.al.setImageResource(R.C3735drawable.rp_backcardhk);
            e();
        } else if (i2 == 8) {
            this.Z.setText(getString(R.string.id_hk_back_title));
            this.aa.setText(getString(R.string.id_hk_hint));
            this.al.setImageResource(R.C3735drawable.rp_backcardhk);
            e();
        } else if (i2 == 9) {
            this.Z.setText(getString(R.string.identity_fg_front_title));
            this.aa.setText(getString(R.string.identity_fg_hint));
            this.al.setImageResource(R.C3735drawable.rp_backcardpic);
            e();
        } else if (i2 == 10) {
            this.Z.setText(getString(R.string.identity_fg_back_title));
            this.aa.setText(getString(R.string.identity_fg_hint));
            this.al.setImageResource(R.C3735drawable.rp_backcardpic);
            e();
        } else if (i2 == 11) {
            this.Z.setText(getString(R.string.identity_hk_front_title));
            this.aa.setText(getString(R.string.identity_hk_hint));
            this.al.setImageResource(R.C3735drawable.rp_frontcardpic);
            e();
        } else if (i2 == 12) {
            this.Z.setText(getString(R.string.identity_hk_back_title));
            this.aa.setText(getString(R.string.identity_hk_hint));
            this.al.setImageResource(R.C3735drawable.rp_backcardpic);
            e();
        } else if (i2 == 13) {
            this.Z.setText(getString(R.string.identity_tw_front_title));
            this.aa.setText(getString(R.string.identity_tw_hint));
            this.al.setImageResource(R.C3735drawable.rp_frontcardpic);
            e();
        } else if (i2 == 14) {
            this.Z.setText(getString(R.string.identity_tw_back_title));
            this.aa.setText(getString(R.string.identity_tw_hint));
            this.al.setImageResource(R.C3735drawable.rp_backcardpic);
            e();
        } else if (i2 == -1) {
            this.al.setVisibility(8);
            this.ad.setVisibility(8);
            f();
        } else {
            Toast.makeText(getApplicationContext(), "没有该拍照类型，type=".concat(String.valueOf(i2)), 0).show();
            AbstractC3841b.a().a("RPTakePhotoPage", "ViewExit", valueOf, "error", null, null);
            finish();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void b(TakePhotoTrackParams takePhotoTrackParams, TakePhotoResult takePhotoResult) {
        TrackLog trackLog = new TrackLog();
        trackLog.setLayer(C3834a.C3835a.a);
        trackLog.setService(C3834a.C3837c.a);
        trackLog.setMethod("takePhoto");
        trackLog.setParams(C3811h.a(takePhotoTrackParams));
        trackLog.setMsg("");
        trackLog.setResult(takePhotoResult != null ? C3811h.a(takePhotoResult) : "");
        C3847g.C3848a.a.a(trackLog);
    }

    static /* synthetic */ void j(RPTakePhotoActivity rPTakePhotoActivity) {
        rPTakePhotoActivity.K.setEnabled(false);
        SensorManager sensorManager = rPTakePhotoActivity.av;
        if (sensorManager != null) {
            sensorManager.unregisterListener(rPTakePhotoActivity);
        }
        if (rPTakePhotoActivity.au) {
            rPTakePhotoActivity.au = false;
            if (rPTakePhotoActivity.R == 3) {
                rPTakePhotoActivity.O = false;
                rPTakePhotoActivity.ac.setEnabled(false);
            }
            try {
                rPTakePhotoActivity.F.a.takePicture(rPTakePhotoActivity.as, null, rPTakePhotoActivity.at);
            } catch (Exception e2) {
                C3847g.C3848a.a.a(TrackLog.createSdkExceptionLog("takePhoto camera exception", C3805b.a(e2), ""));
                rPTakePhotoActivity.a(rPTakePhotoActivity.L);
                AbstractC3841b.a().a("RPTakePhotoPage", "ViewExit", String.valueOf(rPTakePhotoActivity.R), "error", "3", null);
                rPTakePhotoActivity.finish();
            }
        }
    }

    @Override // android.content.DialogInterface.OnClickListener
    public void onClick(DialogInterface dialogInterface, int i2) {
        this.L.putExtra("errorMsg", AbstractC3893a.al);
        AbstractC3841b.a().a("RPTakePhotoPage", "ViewExit", String.valueOf(this.R), "error", "1", null);
        if (i2 == -1) {
            Intent intent = new Intent();
            intent.setAction("android.settings.APPLICATION_DETAILS_SETTINGS");
            intent.setData(Uri.fromParts("package", C3818l.a(this), null));
            startActivity(intent);
        }
        a(this.L);
        finish();
    }

    private void a(boolean z2) {
        boolean z3 = false;
        if (z2 && this.aq) {
            this.am.setVisibility(0);
        } else {
            this.am.setVisibility(8);
        }
        if (z2 && this.aq) {
            z3 = true;
        }
        this.an = z3;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(Intent intent) {
        C3812i.a(this).a(intent);
    }

    private static void a(ImageView imageView) {
        Bitmap bitmap;
        if (imageView != null) {
            Drawable drawable = imageView.getDrawable();
            if (drawable != null && (drawable instanceof BitmapDrawable) && (bitmap = ((BitmapDrawable) drawable).getBitmap()) != null) {
                bitmap.recycle();
            }
            imageView.setImageBitmap(null);
            if (drawable != null) {
                drawable.setCallback(null);
            }
        }
    }

    @Override // com.alibaba.security.realidentity.utils.C3922a.InterfaceC3923a
    public final void a() {
        try {
            C3855b c3855b = this.F;
            if (c3855b != null) {
                c3855b.a(this.ax);
            }
        } catch (Exception e2) {
            b("onFocus exception", C3805b.a(e2));
        }
    }

    private static void a(String str, Exception exc) {
        C3847g.C3848a.a.a(TrackLog.createSdkExceptionLog(str, C3805b.a(exc), ""));
    }

    private void a(Message message) {
        int i2 = message.arg1;
        if (i2 != 100 && !this.N) {
            if (this.ar != null) {
                this.K.setEnabled(false);
                this.ac.setEnabled(false);
                this.ab.setText("示例图加载中，请稍等...");
                this.ar.sendEmptyMessageDelayed(3, 100L);
            }
        } else if (this.N && i2 == 100) {
        } else {
            this.N = true;
            if (this.R != 3) {
                return;
            }
            this.K.setEnabled(true);
            this.ac.setEnabled(true);
            this.ab.setText("换一张");
            int i3 = 0;
            while (true) {
                String[] strArr = this.V;
                if (i3 >= strArr.length) {
                    return;
                }
                String str = this.Y.get(strArr[i3]);
                if (!TextUtils.isEmpty(str)) {
                    this.al.setImageURI(Uri.fromFile(new File(str)));
                    this.al.setBackgroundColor(getResources().getColor(R.C3734color.rpsdk_transparency_65));
                    this.al.setScaleType(ImageView.ScaleType.FIT_CENTER);
                    this.ac.setVisibility(0);
                    this.U = i3;
                    this.T = i3 + 1;
                    return;
                }
                if (i3 == this.V.length - 1) {
                    b(new TakePhotoTrackParams("exit", this.R), new TakePhotoResult("imgDownloadFail"));
                    AbstractC3841b.a().a("RPTakePhotoPage", "ViewExit", String.valueOf(this.R), "error", "2", null);
                    Toast.makeText(this, getString(R.string.load_gesture_img_faild), 0).show();
                    a(this.L);
                    finish();
                }
                i3++;
            }
        }
    }

    private static void a(TrackLog trackLog) {
        C3847g.C3848a.a.a(trackLog);
    }

    static /* synthetic */ Bitmap a(Bitmap bitmap) {
        if (com.alibaba.wireless.security.aopsdk.replace.android.os.Build.getMODEL().toLowerCase(Locale.US).replace(" ", "").contains("nexus5x")) {
            return C3810g.a(bitmap, (int) AntiShakeOrientationEventListener.SCREEN_ORIENTATION_LANDSCAPE);
        }
        return C3810g.a(bitmap, 90);
    }

    static /* synthetic */ void a(RPTakePhotoActivity rPTakePhotoActivity, Message message) {
        int i2 = message.arg1;
        if (i2 != 100 && !rPTakePhotoActivity.N) {
            if (rPTakePhotoActivity.ar != null) {
                rPTakePhotoActivity.K.setEnabled(false);
                rPTakePhotoActivity.ac.setEnabled(false);
                rPTakePhotoActivity.ab.setText("示例图加载中，请稍等...");
                rPTakePhotoActivity.ar.sendEmptyMessageDelayed(3, 100L);
            }
        } else if (rPTakePhotoActivity.N && i2 == 100) {
        } else {
            rPTakePhotoActivity.N = true;
            if (rPTakePhotoActivity.R != 3) {
                return;
            }
            rPTakePhotoActivity.K.setEnabled(true);
            rPTakePhotoActivity.ac.setEnabled(true);
            rPTakePhotoActivity.ab.setText("换一张");
            int i3 = 0;
            while (true) {
                String[] strArr = rPTakePhotoActivity.V;
                if (i3 >= strArr.length) {
                    return;
                }
                String str = rPTakePhotoActivity.Y.get(strArr[i3]);
                if (!TextUtils.isEmpty(str)) {
                    rPTakePhotoActivity.al.setImageURI(Uri.fromFile(new File(str)));
                    rPTakePhotoActivity.al.setBackgroundColor(rPTakePhotoActivity.getResources().getColor(R.C3734color.rpsdk_transparency_65));
                    rPTakePhotoActivity.al.setScaleType(ImageView.ScaleType.FIT_CENTER);
                    rPTakePhotoActivity.ac.setVisibility(0);
                    rPTakePhotoActivity.U = i3;
                    rPTakePhotoActivity.T = i3 + 1;
                    return;
                }
                if (i3 == rPTakePhotoActivity.V.length - 1) {
                    b(new TakePhotoTrackParams("exit", rPTakePhotoActivity.R), new TakePhotoResult("imgDownloadFail"));
                    AbstractC3841b.a().a("RPTakePhotoPage", "ViewExit", String.valueOf(rPTakePhotoActivity.R), "error", "2", null);
                    Toast.makeText(rPTakePhotoActivity, rPTakePhotoActivity.getString(R.string.load_gesture_img_faild), 0).show();
                    rPTakePhotoActivity.a(rPTakePhotoActivity.L);
                    rPTakePhotoActivity.finish();
                }
                i3++;
            }
        }
    }
}
