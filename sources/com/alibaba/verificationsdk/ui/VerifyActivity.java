package com.alibaba.verificationsdk.ui;

import android.app.Activity;
import android.app.AlertDialog;
import android.app.Dialog;
import android.content.SharedPreferences;
import android.content.res.Resources;
import android.graphics.Color;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.os.Handler;
import android.os.Message;
import android.text.TextUtils;
import android.text.method.PasswordTransformationMethod;
import android.util.DisplayMetrics;
import android.view.Display;
import android.view.KeyEvent;
import android.view.MotionEvent;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;
import com.alibaba.verificationsdk.utils.DownloadListener;
import com.alibaba.verificationsdk.utils.ZIPExtracListener;
import com.alibaba.verificationsdk.widgets.ALiLoadingView;
import com.alibaba.verificationsdk.widgets.BallView;
import com.alibaba.verificationsdk.widgets.DrawView;
import com.alibaba.wireless.security.open.SecurityGuardManager;
import com.alibaba.wireless.security.open.nocaptcha.INoCaptchaComponent;
import com.taobao.tao.log.statistics.TLogEventConst;
import com.youku.arch.v3.data.Constants;
import com.youku.upsplayer.util.YKUpsConvert;
import java.io.File;
import java.io.FileInputStream;
import java.security.MessageDigest;
import java.util.HashMap;
import java.util.Locale;
import org.apache.commons.codec.digest.MessageDigestAlgorithms;
import org.apache.commons.lang3.time.DateUtils;
import org.json.JSONObject;
import tb.i22;
import tb.kx2;
import tb.qi0;
import tb.ra1;

/* compiled from: Taobao */
/* loaded from: classes8.dex */
public class VerifyActivity extends Activity {
    public static final int ALIAUTH_CLIENT_ERROR_GENERIC = 50000;
    public static final int ALIAUTH_SERVICE_ERROR_MAXTRY = 60000;
    public static final String APP_DATA = "app_data";
    private static int K = 0;
    private static int L = 0;
    private static String M = null;
    private static String N = null;
    private static String O = "device_type";
    private static String P = "dpi";
    private static String Q = "lang";
    private static String R = "captcha_type";
    private static String S = "phone_number";
    private static String T = "session_id";
    private static String U = "extend_data";
    private static String V = "userInputCaptcha";
    public static final int VERIFY_FAILED = 0;
    public static final int VERIFY_SUCC = 1;
    private static String W = null;
    private static int X = 3;
    private static IActivityCallback Y;
    private static VerifyType Z;
    private static String a0;
    private static String b0;
    private static String c0;
    private ALiLoadingView b;
    private LinearLayout c;
    private FrameLayout f;
    private FrameLayout.LayoutParams j;
    private INoCaptchaComponent m;
    private i22 x;
    private ALiLoadingView y;
    private boolean a = false;
    private TextView d = null;
    private TextView e = null;
    private BallView g = null;
    private DrawView h = null;
    private ImageView i = null;
    private boolean k = false;
    private View l = null;
    private View n = null;
    private TextView o = null;
    private View p = null;
    private TextView q = null;
    private t r = null;
    private s s = null;
    private EditText t = null;
    private EditText u = null;
    private String v = null;
    private SharedPreferences w = null;
    private FrameLayout z = null;
    private Button A = null;
    Runnable B = new Runnable() { // from class: com.alibaba.verificationsdk.ui.VerifyActivity.1
        @Override // java.lang.Runnable
        public void run() {
            VerifyActivity.this.D.sendEmptyMessage(10000);
        }
    };
    Runnable C = new Runnable() { // from class: com.alibaba.verificationsdk.ui.VerifyActivity.2
        @Override // java.lang.Runnable
        public void run() {
            VerifyActivity.this.finish();
        }
    };
    Handler D = new h();
    Handler E = new i();
    Handler F = new j();
    Runnable G = new Runnable() { // from class: com.alibaba.verificationsdk.ui.VerifyActivity.21
        @Override // java.lang.Runnable
        public void run() {
            Message message = new Message();
            String str = null;
            try {
                try {
                    int i2 = l.a[VerifyActivity.Z.ordinal()];
                    if (i2 == 2) {
                        HashMap<String, String> hashMap = new HashMap<>();
                        hashMap.put(VerifyActivity.R, "1");
                        hashMap.put(VerifyActivity.S, VerifyActivity.b0);
                        hashMap.put("info_token", VerifyActivity.a0);
                        if (!TextUtils.isEmpty(VerifyActivity.c0)) {
                            hashMap.put("HOSTENV", VerifyActivity.c0);
                        }
                        str = VerifyActivity.this.m.noCaptchaForwardAuth("alibaba.security.jaq.captcha.send", hashMap, VerifyActivity.N, 12);
                    } else if (i2 == 3) {
                        HashMap<String, String> hashMap2 = new HashMap<>();
                        hashMap2.put(VerifyActivity.S, VerifyActivity.b0);
                        hashMap2.put("info_token", VerifyActivity.a0);
                        if (!TextUtils.isEmpty(VerifyActivity.c0)) {
                            hashMap2.put("HOSTENV", VerifyActivity.c0);
                        }
                        str = VerifyActivity.this.m.noCaptchaForwardAuth("alibaba.security.jaq.captcha.audio.send", hashMap2, VerifyActivity.N, 12);
                    }
                    JSONObject jSONObject = new JSONObject(str);
                    if (jSONObject.optBoolean("error", true)) {
                        message.what = 100015;
                        message.arg1 = ERROR_TYPE.ERROR_FROM_SERVER.ordinal();
                        message.arg2 = jSONObject.optInt("code");
                    } else {
                        int optInt = jSONObject.optInt("send_status");
                        if (optInt > 0) {
                            message.what = 100014;
                        } else {
                            message.what = 100015;
                            message.arg1 = ERROR_TYPE.ERROR_FROM_BUSSINESS.ordinal();
                            message.arg2 = optInt;
                        }
                    }
                    message.obj = jSONObject;
                } catch (Exception e2) {
                    e2.printStackTrace();
                    message.what = 100015;
                    message.arg1 = ERROR_TYPE.ERROR_FROM_CLIENT.ordinal();
                    message.arg2 = VerifyActivity.ALIAUTH_CLIENT_ERROR_GENERIC;
                    message.obj = e2.getMessage();
                }
            } finally {
                VerifyActivity.this.F.sendMessage(message);
            }
        }
    };
    Runnable H = new Runnable() { // from class: com.alibaba.verificationsdk.ui.VerifyActivity.22
        @Override // java.lang.Runnable
        public void run() {
            Message message = new Message();
            try {
                try {
                    HashMap<String, String> hashMap = new HashMap<>();
                    int i2 = l.a[VerifyActivity.Z.ordinal()];
                    String str = "1";
                    if (i2 != 2 && i2 == 3) {
                        str = "2";
                    }
                    hashMap.put(VerifyActivity.R, str);
                    hashMap.put(VerifyActivity.S, VerifyActivity.b0);
                    hashMap.put(VerifyActivity.T, VerifyActivity.this.v);
                    String str2 = null;
                    if (VerifyActivity.this.u != null && !TextUtils.isEmpty(VerifyActivity.this.u.getText().toString())) {
                        str2 = VerifyActivity.this.u.getText().toString();
                    }
                    JSONObject jSONObject = new JSONObject();
                    jSONObject.put(VerifyActivity.V, str2);
                    hashMap.put(VerifyActivity.U, jSONObject.toString());
                    hashMap.put("info_token", VerifyActivity.a0);
                    if (!TextUtils.isEmpty(VerifyActivity.c0)) {
                        hashMap.put("HOSTENV", VerifyActivity.c0);
                    }
                    JSONObject jSONObject2 = new JSONObject(VerifyActivity.this.m.noCaptchaForwardAuth("alibaba.security.jaq.captcha.verify", hashMap, VerifyActivity.N, 12));
                    if (jSONObject2.optBoolean("error", true)) {
                        message.what = 100005;
                        message.arg1 = ERROR_TYPE.ERROR_FROM_SERVER.ordinal();
                        message.arg2 = jSONObject2.optInt("code");
                    } else {
                        int optInt = jSONObject2.optInt("verify_status");
                        if (optInt > 0) {
                            message.what = com.taobao.android.dinamicx.e.DX_ERROR_CODE_AST_EVENT_EXECUTE_EXCEPTION;
                        } else {
                            message.what = 100005;
                            message.arg1 = ERROR_TYPE.ERROR_FROM_BUSSINESS.ordinal();
                            message.arg2 = optInt;
                        }
                    }
                    message.obj = jSONObject2;
                } catch (Exception e2) {
                    e2.printStackTrace();
                    message.what = 100005;
                    message.arg1 = ERROR_TYPE.ERROR_FROM_CLIENT.ordinal();
                    message.arg2 = VerifyActivity.ALIAUTH_CLIENT_ERROR_GENERIC;
                    message.obj = e2.getMessage();
                }
            } finally {
                VerifyActivity.this.E.sendMessage(message);
            }
        }
    };
    Handler I = new k();
    Runnable J = new Runnable() { // from class: com.alibaba.verificationsdk.ui.VerifyActivity.24
        @Override // java.lang.Runnable
        public void run() {
            Message message = new Message();
            try {
                try {
                    HashMap<String, String> hashMap = new HashMap<>();
                    hashMap.put(VerifyActivity.O, "android");
                    int i2 = VerifyActivity.this.getApplicationContext().getResources().getDisplayMetrics().densityDpi;
                    String str = "xhdpi";
                    if (i2 == 120) {
                        str = "ldpi";
                    } else if (i2 == 160) {
                        str = "mdpi";
                    } else if (i2 == 213) {
                        str = "tv";
                    } else if (i2 == 240) {
                        str = "hdpi";
                    } else if (i2 != 320) {
                        if (i2 == 480) {
                            str = "xxhdpi";
                        } else if (i2 == 640) {
                            str = "xxxhdpi";
                        }
                    }
                    hashMap.put(VerifyActivity.P, str);
                    hashMap.put(VerifyActivity.Q, Locale.getDefault().toString());
                    hashMap.put("info_token", VerifyActivity.a0);
                    if (!TextUtils.isEmpty(VerifyActivity.c0)) {
                        hashMap.put("HOSTENV", VerifyActivity.c0);
                    }
                    String noCaptchaForwardAuth = VerifyActivity.this.m.noCaptchaForwardAuth("alibaba.security.jaq.resource.fetch", hashMap, VerifyActivity.N, 12);
                    ra1.b("VerifyActivity", "get resource result: " + noCaptchaForwardAuth);
                    JSONObject jSONObject = new JSONObject(noCaptchaForwardAuth);
                    if (jSONObject.optBoolean("error", true)) {
                        message.what = 100025;
                        message.arg1 = ERROR_TYPE.ERROR_FROM_SERVER.ordinal();
                    } else {
                        message.what = 100024;
                    }
                    message.obj = jSONObject;
                } catch (Exception e2) {
                    e2.printStackTrace();
                    message.what = 100025;
                    message.arg1 = ERROR_TYPE.ERROR_FROM_CLIENT.ordinal();
                    message.obj = e2.getMessage();
                }
            } finally {
                VerifyActivity.this.I.sendMessage(message);
            }
        }
    };

    /* compiled from: Taobao */
    /* loaded from: classes8.dex */
    private enum ERROR_TYPE {
        ERROR_FROM_SERVER,
        ERROR_FROM_CLIENT,
        ERROR_FROM_BUSSINESS
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: Taobao */
    /* loaded from: classes8.dex */
    public class a implements View.OnClickListener {
        a() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (VerifyActivity.this.r != null) {
                VerifyActivity.this.r.cancel();
            }
            VerifyActivity.this.i0(VerifyType.CALL);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: Taobao */
    /* loaded from: classes8.dex */
    public class b implements View.OnClickListener {
        b() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            VerifyActivity.this.p0();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: Taobao */
    /* loaded from: classes8.dex */
    public class c implements View.OnClickListener {
        c() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (VerifyActivity.Y != null) {
                VerifyActivity.Y.onNotifyBackPressed();
            }
            VerifyActivity.this.finish();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: Taobao */
    /* loaded from: classes8.dex */
    public class d implements View.OnClickListener {
        d() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            VerifyActivity.this.e0();
            if (!TextUtils.isEmpty(VerifyActivity.this.u.getText().toString())) {
                VerifyActivity.this.n.setClickable(false);
                VerifyActivity.this.n0();
                return;
            }
            VerifyActivity verifyActivity = VerifyActivity.this;
            Toast.makeText(verifyActivity, verifyActivity.getResources().getIdentifier("ali_vsdk_verify_no_code", "string", VerifyActivity.this.getPackageName()), 1).show();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: Taobao */
    /* loaded from: classes8.dex */
    public class e implements View.OnClickListener {
        e() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            VerifyActivity.this.l0();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: Taobao */
    /* loaded from: classes8.dex */
    public class f implements View.OnClickListener {
        final /* synthetic */ Dialog a;

        f(Dialog dialog) {
            this.a = dialog;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            VerifyActivity.this.l0();
            this.a.dismiss();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: Taobao */
    /* loaded from: classes8.dex */
    public class g implements View.OnClickListener {
        final /* synthetic */ Dialog a;

        g(VerifyActivity verifyActivity, Dialog dialog) {
            this.a = dialog;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            this.a.dismiss();
        }
    }

    /* compiled from: Taobao */
    /* loaded from: classes8.dex */
    class h extends Handler {
        h() {
        }

        /* JADX WARN: Removed duplicated region for block: B:33:0x0245  */
        /* JADX WARN: Removed duplicated region for block: B:34:0x024b  */
        @Override // android.os.Handler
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct code enable 'Show inconsistent code' option in preferences
        */
        public void handleMessage(android.os.Message r24) {
            /*
                Method dump skipped, instructions count: 1708
                To view this dump change 'Code comments level' option to 'DEBUG'
            */
            throw new UnsupportedOperationException("Method not decompiled: com.alibaba.verificationsdk.ui.VerifyActivity.h.handleMessage(android.os.Message):void");
        }
    }

    /* compiled from: Taobao */
    /* loaded from: classes8.dex */
    class i extends Handler {
        i() {
        }

        @Override // android.os.Handler
        public void handleMessage(Message message) {
            HashMap hashMap = new HashMap();
            switch (message.what) {
                case com.taobao.android.dinamicx.e.DX_ERROR_CODE_AST_EVENT_HANDLER_NOT_FOUND /* 100003 */:
                    VerifyActivity.this.o.setText(VerifyActivity.this.x.h("MSA_submit_button_waiting", VerifyActivity.this.getResources().getIdentifier("ali_vsdk_verify_in_progress", "string", VerifyActivity.this.getPackageName())));
                    VerifyActivity.this.y.setVisibility(0);
                    VerifyActivity.this.y.startRotationAnimation();
                    new Thread(VerifyActivity.this.H).start();
                    return;
                case com.taobao.android.dinamicx.e.DX_ERROR_CODE_AST_EVENT_EXECUTE_EXCEPTION /* 100004 */:
                    VerifyActivity.this.o.setText(VerifyActivity.this.getResources().getIdentifier("ali_vsdk_verify_submit", "string", VerifyActivity.this.getPackageName()));
                    VerifyActivity.this.y.setVisibility(4);
                    VerifyActivity.this.y.stopRotationAnimation();
                    if (VerifyActivity.Y != null) {
                        hashMap.put(TLogEventConst.PARAM_SESSION_ID, VerifyActivity.this.v);
                        VerifyActivity.Y.onResult(1, hashMap);
                    }
                    VerifyActivity.this.finish();
                    return;
                case 100005:
                    if (VerifyActivity.this.p != null) {
                        VerifyActivity.this.p.setVisibility(0);
                    }
                    VerifyActivity.this.o.setText(VerifyActivity.this.getResources().getIdentifier("ali_vsdk_verify_submit", "string", VerifyActivity.this.getPackageName()));
                    VerifyActivity.this.y.setVisibility(4);
                    VerifyActivity.this.y.stopRotationAnimation();
                    VerifyActivity.this.n.setClickable(true);
                    if (VerifyActivity.this.q != null) {
                        VerifyActivity.this.q.setClickable(true);
                    }
                    if (VerifyActivity.Z != VerifyType.SMS) {
                        if (VerifyActivity.Z == VerifyType.CALL) {
                            VerifyActivity verifyActivity = VerifyActivity.this;
                            Toast.makeText(verifyActivity, verifyActivity.getResources().getIdentifier("ali_vsdk_verify_error_call", "string", VerifyActivity.this.getPackageName()), 1).show();
                        }
                    } else {
                        VerifyActivity verifyActivity2 = VerifyActivity.this;
                        Toast.makeText(verifyActivity2, verifyActivity2.getResources().getIdentifier("ali_vsdk_verify_error", "string", VerifyActivity.this.getPackageName()), 1).show();
                    }
                    ERROR_TYPE error_type = ERROR_TYPE.values()[message.arg1];
                    int i = l.b[error_type.ordinal()];
                    if (i == 1) {
                        JSONObject jSONObject = (JSONObject) message.obj;
                        ra1.a("VerifyActivity", jSONObject.optString("msg"));
                        ra1.a("VerifyActivity", jSONObject.optString("sub_msg"));
                        hashMap.put("errorMsg", jSONObject.optString("msg") + ": " + jSONObject.optString("sub_msg"));
                    } else if (i == 2) {
                        Object obj = message.obj;
                        if (obj == null) {
                            obj = "";
                        }
                        ra1.a("VerifyActivity", (String) obj);
                        hashMap.put("errorMsg", (String) message.obj);
                    } else if (i == 3) {
                        VerifyActivity verifyActivity3 = VerifyActivity.this;
                        ra1.a("VerifyActivity", verifyActivity3.getString(verifyActivity3.getResources().getIdentifier("ali_vsdk_verify_error", "string", VerifyActivity.this.getPackageName())));
                        VerifyActivity verifyActivity4 = VerifyActivity.this;
                        hashMap.put("errorMsg", verifyActivity4.getString(verifyActivity4.getResources().getIdentifier("ali_vsdk_verify_error", "string", VerifyActivity.this.getPackageName())));
                    }
                    if (VerifyActivity.Y == null || VerifyActivity.E() > 0) {
                        return;
                    }
                    hashMap.put("code", String.valueOf(message.arg2));
                    hashMap.put(TLogEventConst.PARAM_SESSION_ID, VerifyActivity.this.v);
                    hashMap.put("errorCode", error_type.name());
                    VerifyActivity.Y.onResult(0, hashMap);
                    return;
                default:
                    return;
            }
        }
    }

    /* compiled from: Taobao */
    /* loaded from: classes8.dex */
    class j extends Handler {
        j() {
        }

        @Override // android.os.Handler
        public void handleMessage(Message message) {
            HashMap hashMap = new HashMap();
            switch (message.what) {
                case 100013:
                    new Thread(VerifyActivity.this.G).start();
                    return;
                case 100014:
                    VerifyActivity.this.v = ((JSONObject) message.obj).optString("session_id");
                    return;
                case 100015:
                    VerifyActivity.this.v = null;
                    hashMap.put("code", String.valueOf(message.arg2));
                    ERROR_TYPE error_type = ERROR_TYPE.values()[message.arg1];
                    hashMap.put("errorCode", error_type.name());
                    int i = l.b[error_type.ordinal()];
                    if (i != 1) {
                        if (i != 2) {
                            return;
                        }
                        ra1.a("VerifyActivity", (String) message.obj);
                        hashMap.put("errorMsg", (String) message.obj);
                        return;
                    }
                    JSONObject jSONObject = (JSONObject) message.obj;
                    ra1.a("VerifyActivity", jSONObject.optString("msg"));
                    ra1.a("VerifyActivity", jSONObject.optString("sub_msg"));
                    hashMap.put("errorMsg", jSONObject.optString("msg") + ": " + jSONObject.optString("sub_msg"));
                    return;
                default:
                    return;
            }
        }
    }

    /* compiled from: Taobao */
    /* loaded from: classes8.dex */
    class k extends Handler {

        /* compiled from: Taobao */
        /* loaded from: classes8.dex */
        class a implements DownloadListener {
            final /* synthetic */ String a;
            final /* synthetic */ String b;

            /* compiled from: Taobao */
            /* renamed from: com.alibaba.verificationsdk.ui.VerifyActivity$k$a$a  reason: collision with other inner class name */
            /* loaded from: classes8.dex */
            class C0177a implements ZIPExtracListener {
                C0177a() {
                }

                @Override // com.alibaba.verificationsdk.utils.ZIPExtracListener
                public void unzipFinished(File file, File file2) {
                    ra1.b("VerifyActivity", "update resources finished! " + file2.getAbsolutePath());
                    VerifyActivity.this.w.edit().putString("version", a.this.b).apply();
                    if (file != null && file.exists()) {
                        file.delete();
                    }
                    VerifyActivity.this.I.sendEmptyMessage(100026);
                }

                @Override // com.alibaba.verificationsdk.utils.ZIPExtracListener
                public void unzipStart() {
                }
            }

            a(String str, String str2) {
                this.a = str;
                this.b = str2;
            }

            @Override // com.alibaba.verificationsdk.utils.DownloadListener
            public void downloadFinished(File file) {
                if (file != null && file.exists()) {
                    try {
                        MessageDigest messageDigest = MessageDigest.getInstance(MessageDigestAlgorithms.MD5);
                        FileInputStream fileInputStream = new FileInputStream(file);
                        byte[] bArr = new byte[8192];
                        while (true) {
                            int read = fileInputStream.read(bArr);
                            if (read <= 0) {
                                break;
                            } else if (messageDigest != null) {
                                messageDigest.update(bArr, 0, read);
                            }
                        }
                        if (!TextUtils.isEmpty(this.a) && messageDigest != null) {
                            if (this.a.equals(VerifyActivity.this.s0(messageDigest.digest()).toLowerCase())) {
                                new com.alibaba.verificationsdk.utils.b(file.getAbsolutePath(), VerifyActivity.W, null, true, new C0177a()).execute(new Void[0]);
                                return;
                            } else {
                                VerifyActivity.this.I.sendEmptyMessage(100026);
                                return;
                            }
                        }
                        VerifyActivity.this.I.sendEmptyMessage(100026);
                        return;
                    } catch (Exception e) {
                        e.printStackTrace();
                        VerifyActivity.this.I.sendEmptyMessage(100026);
                        return;
                    }
                }
                VerifyActivity.this.I.sendEmptyMessage(100026);
            }

            @Override // com.alibaba.verificationsdk.utils.DownloadListener
            public void downloadStart() {
            }
        }

        k() {
        }

        @Override // android.os.Handler
        public void handleMessage(Message message) {
            switch (message.what) {
                case 100023:
                    new Thread(VerifyActivity.this.J).start();
                    return;
                case 100024:
                    JSONObject jSONObject = (JSONObject) message.obj;
                    String optString = jSONObject.optString("md5");
                    String optString2 = jSONObject.optString("version");
                    String string = VerifyActivity.this.w.getString("version", "0.0.0.0");
                    if (!TextUtils.isEmpty(optString2) && kx2.b(string, optString2)) {
                        ra1.b("VerifyActivity", "new resource version is coming, upgrading now!");
                        new com.alibaba.verificationsdk.utils.a(jSONObject.optString("url"), VerifyActivity.this.getFilesDir().getAbsolutePath(), null, new a(optString, optString2)).execute(new Void[0]);
                        return;
                    }
                    VerifyActivity.this.I.sendEmptyMessage(100026);
                    return;
                case 100025:
                    int i = l.b[ERROR_TYPE.values()[message.arg1].ordinal()];
                    if (i == 1) {
                        JSONObject jSONObject2 = (JSONObject) message.obj;
                        ra1.a("VerifyActivity", jSONObject2.optString("msg"));
                        ra1.a("VerifyActivity", jSONObject2.optString("sub_msg"));
                    } else if (i == 2) {
                        Object obj = message.obj;
                        if (obj == null) {
                            obj = "";
                        }
                        ra1.a("VerifyActivity", (String) obj);
                    }
                    VerifyActivity.this.I.sendEmptyMessage(100026);
                    return;
                case 100026:
                    VerifyActivity.this.k0();
                    VerifyActivity.this.b.setVisibility(4);
                    VerifyActivity.this.b.stopRotationAnimation();
                    VerifyActivity.this.i0(VerifyActivity.Z);
                    return;
                default:
                    return;
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: Taobao */
    /* loaded from: classes8.dex */
    public static /* synthetic */ class l {
        static final /* synthetic */ int[] a;
        static final /* synthetic */ int[] b;

        static {
            int[] iArr = new int[ERROR_TYPE.values().length];
            b = iArr;
            try {
                iArr[ERROR_TYPE.ERROR_FROM_SERVER.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                b[ERROR_TYPE.ERROR_FROM_CLIENT.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                b[ERROR_TYPE.ERROR_FROM_BUSSINESS.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            int[] iArr2 = new int[VerifyType.values().length];
            a = iArr2;
            try {
                iArr2[VerifyType.NOCAPTCHA.ordinal()] = 1;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                a[VerifyType.SMS.ordinal()] = 2;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                a[VerifyType.CALL.ordinal()] = 3;
            } catch (NoSuchFieldError unused6) {
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: Taobao */
    /* loaded from: classes8.dex */
    public class m implements View.OnClickListener {
        m() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (VerifyActivity.Y != null) {
                VerifyActivity.Y.onNotifyBackPressed();
            }
            VerifyActivity.this.finish();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: Taobao */
    /* loaded from: classes8.dex */
    public class n implements View.OnTouchListener {
        n() {
        }

        /* JADX WARN: Code restructure failed: missing block: B:8:0x0034, code lost:
            if (r6 != 3) goto L8;
         */
        @Override // android.view.View.OnTouchListener
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct code enable 'Show inconsistent code' option in preferences
        */
        public boolean onTouch(android.view.View r6, android.view.MotionEvent r7) {
            /*
                Method dump skipped, instructions count: 650
                To view this dump change 'Code comments level' option to 'DEBUG'
            */
            throw new UnsupportedOperationException("Method not decompiled: com.alibaba.verificationsdk.ui.VerifyActivity.n.onTouch(android.view.View, android.view.MotionEvent):boolean");
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: Taobao */
    /* loaded from: classes8.dex */
    public class o implements View.OnClickListener {
        o() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (VerifyActivity.this.f != null) {
                VerifyActivity.this.f.removeView(VerifyActivity.this.z);
                VerifyActivity.this.f.invalidate();
                VerifyActivity.this.i0(VerifyActivity.Z);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: Taobao */
    /* loaded from: classes8.dex */
    public class p implements View.OnClickListener {
        p() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (VerifyActivity.Y != null) {
                VerifyActivity.Y.onNotifyBackPressed();
            }
            VerifyActivity.this.finish();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: Taobao */
    /* loaded from: classes8.dex */
    public class q implements View.OnClickListener {
        q() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            VerifyActivity.this.e0();
            if (!TextUtils.isEmpty(VerifyActivity.this.u.getText().toString())) {
                VerifyActivity.this.n.setClickable(false);
                VerifyActivity.this.n0();
                return;
            }
            VerifyActivity verifyActivity = VerifyActivity.this;
            Toast.makeText(verifyActivity, verifyActivity.getResources().getIdentifier("ali_vsdk_verify_no_code", "string", VerifyActivity.this.getPackageName()), 1).show();
        }
    }

    /* compiled from: Taobao */
    /* loaded from: classes8.dex */
    public class r extends PasswordTransformationMethod {

        /* compiled from: Taobao */
        /* loaded from: classes8.dex */
        private class a implements CharSequence {
            private CharSequence a;

            public a(r rVar, CharSequence charSequence) {
                this.a = charSequence;
            }

            @Override // java.lang.CharSequence
            public char charAt(int i) {
                if (i <= 2 || i >= 9) {
                    return this.a.charAt(i);
                }
                return '*';
            }

            @Override // java.lang.CharSequence
            public int length() {
                return this.a.length();
            }

            @Override // java.lang.CharSequence
            public CharSequence subSequence(int i, int i2) {
                return this.a.subSequence(i, i2);
            }
        }

        public r(VerifyActivity verifyActivity) {
        }

        @Override // android.text.method.PasswordTransformationMethod, android.text.method.TransformationMethod
        public CharSequence getTransformation(CharSequence charSequence, View view) {
            return new a(this, charSequence);
        }
    }

    /* compiled from: Taobao */
    /* loaded from: classes8.dex */
    class s extends CountDownTimer {
        public s(long j, long j2) {
            super(j, j2);
        }

        @Override // android.os.CountDownTimer
        public void onFinish() {
            if (VerifyActivity.this.z == null || VerifyActivity.this.f == null) {
                return;
            }
            FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-1, -1);
            VerifyActivity verifyActivity = VerifyActivity.this;
            verifyActivity.c0(verifyActivity.z, layoutParams);
        }

        @Override // android.os.CountDownTimer
        public void onTick(long j) {
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: Taobao */
    /* loaded from: classes8.dex */
    public class t extends CountDownTimer {
        public t(long j, long j2) {
            super(j, j2);
        }

        @Override // android.os.CountDownTimer
        public void onFinish() {
            if (VerifyActivity.this.q != null) {
                VerifyActivity.this.q.setClickable(true);
                VerifyActivity.this.q.setText(VerifyActivity.this.getResources().getIdentifier("ali_vsdk_verify_sms_send_code", "string", VerifyActivity.this.getPackageName()));
                VerifyActivity.this.q.setTextColor(Color.parseColor("#1475ea"));
            }
            if (VerifyActivity.this.p != null) {
                VerifyActivity.this.p.setVisibility(0);
            }
            VerifyActivity.E();
        }

        @Override // android.os.CountDownTimer
        public void onTick(long j) {
            if (VerifyActivity.this.q != null) {
                TextView textView = VerifyActivity.this.q;
                VerifyActivity verifyActivity = VerifyActivity.this;
                textView.setText(verifyActivity.getString(verifyActivity.getResources().getIdentifier("ali_vsdk_verify_sms_timeout", "string", VerifyActivity.this.getPackageName()), new Object[]{Long.valueOf(j / 1000)}));
                VerifyActivity.this.q.setTextColor(Color.parseColor("#adadad"));
            }
        }
    }

    static /* synthetic */ int E() {
        int i2 = X - 1;
        X = i2;
        return i2;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void e0() {
        InputMethodManager inputMethodManager = (InputMethodManager) getSystemService("input_method");
        if (!inputMethodManager.isActive() || getCurrentFocus() == null || getCurrentFocus().getWindowToken() == null) {
            return;
        }
        inputMethodManager.hideSoftInputFromWindow(getCurrentFocus().getWindowToken(), 2);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void k0() {
        String a2 = qi0.a(new File(W + File.separator + "config.json"));
        if (TextUtils.isEmpty(a2)) {
            return;
        }
        this.x.c(a2);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void l0() {
        this.n.setAlpha(1.0f);
        this.n.setClickable(true);
        this.n.setEnabled(true);
        this.o.setTextColor(-1);
        TextView textView = (TextView) findViewById(getResources().getIdentifier("tips_sub", "id", getPackageName()));
        this.e = textView;
        textView.setVisibility(0);
        this.q.setClickable(false);
        this.q.setText(getString(getResources().getIdentifier("ali_vsdk_verify_sms_timeout", "string", getPackageName()), new Object[]{60}));
        this.q.setTextColor(Color.parseColor("#adadad"));
        this.r.cancel();
        this.r.start();
        this.F.sendEmptyMessage(100013);
    }

    private void m0() {
        this.I.sendEmptyMessage(100023);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void n0() {
        this.E.sendEmptyMessage(com.taobao.android.dinamicx.e.DX_ERROR_CODE_AST_EVENT_HANDLER_NOT_FOUND);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void o0() {
        this.D.sendEmptyMessage(10001);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void p0() {
        this.q.setClickable(false);
        this.q.setText(getString(getResources().getIdentifier("ali_vsdk_verify_sms_timeout", "string", getPackageName()), new Object[]{60}));
        this.q.setTextColor(Color.parseColor("#adadad"));
        this.r.cancel();
        this.r.start();
        this.F.sendEmptyMessage(100013);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void q0() {
        this.D.sendEmptyMessage(100001);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void r0() {
        this.D.sendEmptyMessage(com.taobao.android.dinamicx.e.DX_ERROR_CODE_METHOD_NODE_EXECUTE_EXCEPTION);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public String s0(byte[] bArr) {
        char[] cArr = {YKUpsConvert.CHAR_ZERO, '1', '2', '3', '4', '5', '6', '7', '8', YKUpsConvert.CHAR_NINE, 'a', 'b', 'c', 'd', 'e', 'f'};
        StringBuilder sb = new StringBuilder(bArr.length * 2);
        for (int i2 = 0; i2 < bArr.length; i2++) {
            sb.append(cArr[(bArr[i2] & 240) >>> 4]);
            sb.append(cArr[bArr[i2] & 15]);
        }
        return sb.toString();
    }

    void b0(View view) {
        try {
            this.f.addView(view);
        } catch (Exception unused) {
        }
    }

    void c0(View view, FrameLayout.LayoutParams layoutParams) {
        try {
            this.f.addView(view, layoutParams);
        } catch (Exception unused) {
        }
    }

    protected int d0() {
        int dimensionPixelSize = Resources.getSystem().getDimensionPixelSize(Resources.getSystem().getIdentifier("status_bar_height", Constants.DIMEN, "android"));
        ra1.b("VerifyActivity", "get status bar height : " + dimensionPixelSize);
        return dimensionPixelSize;
    }

    void f0() {
        X = 3;
        setContentView(getResources().getIdentifier("ali_vsdk_activity_verify_call", "layout", getPackageName()));
        EditText editText = (EditText) findViewById(getResources().getIdentifier("number_et", "id", getPackageName()));
        this.t = editText;
        editText.setText(b0);
        this.t.setTransformationMethod(new r(this));
        this.u = (EditText) findViewById(getResources().getIdentifier("code_et", "id", getPackageName()));
        View findViewById = findViewById(getResources().getIdentifier("left_top_layout", "id", getPackageName()));
        this.l = findViewById;
        findViewById.setOnClickListener(new c());
        View findViewById2 = findViewById(getResources().getIdentifier("btn_submit", "id", getPackageName()));
        this.n = findViewById2;
        findViewById2.setEnabled(false);
        this.n.setClickable(false);
        this.o = (TextView) findViewById(getResources().getIdentifier("submit_tx", "id", getPackageName()));
        this.n.setOnClickListener(new d());
        this.u.setOnEditorActionListener(new TextView.OnEditorActionListener() { // from class: com.alibaba.verificationsdk.ui.VerifyActivity.14
            @Override // android.widget.TextView.OnEditorActionListener
            public boolean onEditorAction(TextView textView, int i2, KeyEvent keyEvent) {
                VerifyActivity.this.e0();
                if (i2 == VerifyActivity.this.getResources().getIdentifier("submit", "id", VerifyActivity.this.getPackageName()) || i2 == 0) {
                    if (!TextUtils.isEmpty(VerifyActivity.this.u.getText().toString())) {
                        VerifyActivity.this.n.setClickable(false);
                        VerifyActivity.this.n0();
                        return true;
                    }
                    VerifyActivity verifyActivity = VerifyActivity.this;
                    Toast.makeText(verifyActivity, verifyActivity.getResources().getIdentifier("ali_vsdk_verify_no_code", "string", VerifyActivity.this.getPackageName()), 1).show();
                    return true;
                }
                return false;
            }
        });
        this.y = (ALiLoadingView) findViewById(getResources().getIdentifier("submit_loading", "id", getPackageName()));
        this.q = (TextView) findViewById(getResources().getIdentifier("verify_send_code", "id", getPackageName()));
        this.r = new t(DateUtils.MILLIS_PER_MINUTE, 1000L);
        this.q.setOnClickListener(new e());
        AlertDialog create = new AlertDialog.Builder(this).create();
        create.show();
        create.getWindow().setContentView(getResources().getIdentifier("ali_vsdk_call_tips", "layout", getPackageName()));
        ((TextView) create.getWindow().findViewById(getResources().getIdentifier("message", "id", getPackageName()))).setText(getResources().getIdentifier("ali_vsdk_verify_call_goto_tips", "string", getPackageName()));
        create.getWindow().findViewById(getResources().getIdentifier("ok", "id", getPackageName())).setOnClickListener(new f(create));
        create.getWindow().findViewById(getResources().getIdentifier("cancel", "id", getPackageName())).setOnClickListener(new g(this, create));
        ImageView imageView = (ImageView) findViewById(getResources().getIdentifier("logo", "id", getPackageName()));
        this.i = imageView;
        this.x.i(imageView, "MSA_logo_power_by", getResources().getIdentifier("ali_vsdk_logo", "drawable", getPackageName()));
    }

    void g0() {
        setContentView(getResources().getIdentifier("ali_vsdk_activity_verify_nocaptcha", "layout", getPackageName()));
        ALiLoadingView aLiLoadingView = (ALiLoadingView) findViewById(getResources().getIdentifier("check_login_loading", "id", getPackageName()));
        this.b = aLiLoadingView;
        aLiLoadingView.startRotationAnimation();
        this.f = (FrameLayout) findViewById(getResources().getIdentifier("root", "id", getPackageName()));
        View findViewById = findViewById(getResources().getIdentifier("left_top_layout", "id", getPackageName()));
        this.l = findViewById;
        findViewById.setOnClickListener(new m());
        this.d = (TextView) findViewById(getResources().getIdentifier("tips", "id", getPackageName()));
        this.e = (TextView) findViewById(getResources().getIdentifier("tips_sub", "id", getPackageName()));
        LinearLayout linearLayout = (LinearLayout) findViewById(getResources().getIdentifier("content", "id", getPackageName()));
        this.c = linearLayout;
        linearLayout.setVisibility(4);
        this.g = new BallView(this);
        this.j = new FrameLayout.LayoutParams(-2, -2);
        DisplayMetrics displayMetrics = getApplicationContext().getResources().getDisplayMetrics();
        K = com.alibaba.wireless.security.aopsdk.replace.android.util.DisplayMetrics.getwidthPixels(displayMetrics);
        L = com.alibaba.wireless.security.aopsdk.replace.android.util.DisplayMetrics.getheightPixels(displayMetrics);
        ra1.b("VerifyActivity", "displayMetrics.widthPixels: " + com.alibaba.wireless.security.aopsdk.replace.android.util.DisplayMetrics.getwidthPixels(displayMetrics) + " displayMetrics.heightPixels: " + com.alibaba.wireless.security.aopsdk.replace.android.util.DisplayMetrics.getheightPixels(displayMetrics));
        Display defaultDisplay = getWindowManager().getDefaultDisplay();
        DisplayMetrics displayMetrics2 = new DisplayMetrics();
        com.alibaba.wireless.security.aopsdk.replace.android.view.Display.getMetrics(defaultDisplay, displayMetrics2);
        ra1.b("VerifyActivity", "displayMetrics.widthPixels: " + com.alibaba.wireless.security.aopsdk.replace.android.util.DisplayMetrics.getwidthPixels(displayMetrics2) + " displayMetrics.heightPixels: " + com.alibaba.wireless.security.aopsdk.replace.android.util.DisplayMetrics.getheightPixels(displayMetrics2));
        try {
            Class.forName("android.view.Display").getMethod("getRealMetrics", DisplayMetrics.class).invoke(defaultDisplay, displayMetrics2);
            ra1.b("VerifyActivity", "displayMetrics.widthPixels: " + com.alibaba.wireless.security.aopsdk.replace.android.util.DisplayMetrics.getwidthPixels(displayMetrics2) + " displayMetrics.heightPixels: " + com.alibaba.wireless.security.aopsdk.replace.android.util.DisplayMetrics.getheightPixels(displayMetrics2));
        } catch (Exception e2) {
            e2.printStackTrace();
        }
        ra1.b("VerifyActivity", "displayMetrics.densityDpi: " + displayMetrics2.densityDpi);
        ra1.b("VerifyActivity", "onCreate root.getTop(): " + this.f.getTop() + " root.getBottom(): " + this.f.getBottom());
        StringBuilder sb = new StringBuilder();
        sb.append("onCreate orientation: ");
        sb.append(getResources().getConfiguration().orientation == 2 ? "landscape" : "portrait");
        ra1.b("VerifyActivity", sb.toString());
        int i2 = K;
        int i3 = L;
        if (i2 > i3) {
            L = i2;
            K = i3;
        }
        ImageView imageView = (ImageView) findViewById(getResources().getIdentifier("logo", "id", getPackageName()));
        this.i = imageView;
        this.x.i(imageView, "MSA_logo_power_by", getResources().getIdentifier("ali_vsdk_logo", "drawable", getPackageName()));
        this.h = new DrawView(this);
        this.g.setOnTouchListener(new n());
        FrameLayout frameLayout = new FrameLayout(this);
        this.z = frameLayout;
        frameLayout.setBackgroundColor(-1);
        this.z.setAlpha(0.94f);
        Button button = new Button(this);
        this.A = button;
        button.setTextColor(Color.parseColor("#56adff"));
        this.A.setTextSize(19.0f);
        this.A.setText(getResources().getIdentifier("ali_vsdk_refresh", "string", getPackageName()));
        this.A.setSingleLine(true);
        this.A.setBackgroundResource(getResources().getIdentifier("ali_vsdk_rect_blue", "drawable", getPackageName()));
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-2, -2);
        layoutParams.gravity = 17;
        this.A.setPadding(60, 20, 60, 20);
        this.z.addView(this.A, layoutParams);
        this.z.setClickable(true);
        this.z.setEnabled(true);
        this.A.setOnClickListener(new o());
        getWindow().getDecorView().post(new Runnable() { // from class: com.alibaba.verificationsdk.ui.VerifyActivity.6
            @Override // java.lang.Runnable
            public void run() {
                VerifyActivity verifyActivity = VerifyActivity.this;
                verifyActivity.D.post(verifyActivity.B);
            }
        });
    }

    void h0() {
        X = 3;
        setContentView(getResources().getIdentifier("ali_vsdk_activity_verify_sms", "layout", getPackageName()));
        EditText editText = (EditText) findViewById(getResources().getIdentifier("number_et", "id", getPackageName()));
        this.t = editText;
        editText.setText(b0);
        this.t.setTransformationMethod(new r(this));
        this.u = (EditText) findViewById(getResources().getIdentifier("code_et", "id", getPackageName()));
        View findViewById = findViewById(getResources().getIdentifier("left_top_layout", "id", getPackageName()));
        this.l = findViewById;
        findViewById.setOnClickListener(new p());
        this.n = findViewById(getResources().getIdentifier("btn_submit", "id", getPackageName()));
        this.o = (TextView) findViewById(getResources().getIdentifier("submit_tx", "id", getPackageName()));
        this.n.setOnClickListener(new q());
        this.u.setOnEditorActionListener(new TextView.OnEditorActionListener() { // from class: com.alibaba.verificationsdk.ui.VerifyActivity.9
            @Override // android.widget.TextView.OnEditorActionListener
            public boolean onEditorAction(TextView textView, int i2, KeyEvent keyEvent) {
                VerifyActivity.this.e0();
                if (i2 == VerifyActivity.this.getResources().getIdentifier("submit", "id", VerifyActivity.this.getPackageName()) || i2 == 0) {
                    if (!TextUtils.isEmpty(VerifyActivity.this.u.getText().toString())) {
                        VerifyActivity.this.n.setClickable(false);
                        VerifyActivity.this.n0();
                        return true;
                    }
                    VerifyActivity verifyActivity = VerifyActivity.this;
                    Toast.makeText(verifyActivity, verifyActivity.getResources().getIdentifier("ali_vsdk_verify_no_code", "string", VerifyActivity.this.getPackageName()), 1).show();
                    return true;
                }
                return false;
            }
        });
        this.y = (ALiLoadingView) findViewById(getResources().getIdentifier("submit_loading", "id", getPackageName()));
        View findViewById2 = findViewById(getResources().getIdentifier("btn_call", "id", getPackageName()));
        this.p = findViewById2;
        findViewById2.setVisibility(4);
        this.p.setOnClickListener(new a());
        this.q = (TextView) findViewById(getResources().getIdentifier("verify_send_code", "id", getPackageName()));
        this.r = new t(DateUtils.MILLIS_PER_MINUTE, 1000L);
        this.q.setOnClickListener(new b());
        ImageView imageView = (ImageView) findViewById(getResources().getIdentifier("logo", "id", getPackageName()));
        this.i = imageView;
        this.x.i(imageView, "MSA_logo_power_by", getResources().getIdentifier("ali_vsdk_logo", "drawable", getPackageName()));
        p0();
    }

    void i0(VerifyType verifyType) {
        Z = verifyType;
        int i2 = l.a[Z.ordinal()];
        if (i2 == 1) {
            g0();
        } else if (i2 == 2) {
            h0();
        } else if (i2 != 3) {
        } else {
            f0();
        }
    }

    int j0(int i2) {
        return (i2 == 104 || i2 == 105) ? 0 : 1;
    }

    @Override // android.app.Activity
    public void onBackPressed() {
        IActivityCallback iActivityCallback = Y;
        if (iActivityCallback != null) {
            iActivityCallback.onNotifyBackPressed();
        }
        super.onBackPressed();
    }

    @Override // android.app.Activity
    protected void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(getResources().getIdentifier("ali_vsdk_activity_verify", "layout", getPackageName()));
        ALiLoadingView aLiLoadingView = (ALiLoadingView) findViewById(getResources().getIdentifier("check_login_loading", "id", getPackageName()));
        this.b = aLiLoadingView;
        aLiLoadingView.startRotationAnimation();
        String str = getFilesDir().getAbsolutePath() + File.separator + "res";
        W = str;
        this.x = new i22(this, str);
        this.w = getPreferences(0);
        m0();
        try {
            this.m = SecurityGuardManager.getInstance(getApplicationContext()).getNoCaptchaComp();
        } catch (Exception e2) {
            e2.printStackTrace();
        }
        this.s = new s(DateUtils.MILLIS_PER_MINUTE, 1000L);
    }

    @Override // android.app.Activity
    public void onDestroy() {
        super.onDestroy();
        t tVar = this.r;
        if (tVar != null) {
            tVar.cancel();
        }
        s sVar = this.s;
        if (sVar != null) {
            sVar.cancel();
        }
    }

    @Override // android.app.Activity
    public void onResume() {
        super.onResume();
        if (this.f != null) {
            ra1.b("VerifyActivity", "onResume root.getTop(): " + this.f.getTop() + " root.getBottom(): " + this.f.getBottom());
        }
    }

    @Override // android.app.Activity
    public void onStart() {
        super.onStart();
        if (this.f != null) {
            ra1.b("VerifyActivity", "onStart root.getTop(): " + this.f.getTop() + " root.getBottom(): " + this.f.getBottom());
        }
    }

    @Override // android.app.Activity
    public void onStop() {
        super.onStop();
        Handler handler = this.D;
        if (handler != null) {
            handler.removeCallbacks(this.B);
        }
    }

    @Override // android.app.Activity
    public boolean onTouchEvent(MotionEvent motionEvent) {
        return false;
    }
}
