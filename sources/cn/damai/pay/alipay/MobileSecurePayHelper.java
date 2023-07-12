package cn.damai.pay.alipay;

import android.app.ProgressDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.pm.PackageInfo;
import android.net.Uri;
import android.os.Handler;
import android.os.Message;
import android.text.TextUtils;
import cn.damai.common.app.widget.DMDialog;
import cn.damai.commonbusiness.R$string;
import com.alipay.android.app.IAlixPay;
import com.alipay.sdk.m.u.n;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import org.json.JSONException;
import org.json.JSONObject;
import tb.cm2;

/* compiled from: Taobao */
/* loaded from: classes15.dex */
public class MobileSecurePayHelper {
    private static transient /* synthetic */ IpChange $ipChange = null;
    static final String TAG = "MobileSecurePayHelper";
    Context mContext;
    private ProgressDialog mProgress = null;
    private Handler mHandler = new Handler() { // from class: cn.damai.pay.alipay.MobileSecurePayHelper.3
        private static transient /* synthetic */ IpChange $ipChange;

        @Override // android.os.Handler
        public void handleMessage(Message message) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "-1197701704")) {
                ipChange.ipc$dispatch("-1197701704", new Object[]{this, message});
                return;
            }
            try {
                if (message.what == 2) {
                    MobileSecurePayHelper.this.closeProgress();
                    MobileSecurePayHelper mobileSecurePayHelper = MobileSecurePayHelper.this;
                    mobileSecurePayHelper.showInstallConfirmDialog(mobileSecurePayHelper.mContext, (String) message.obj);
                }
                super.handleMessage(message);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    };

    public MobileSecurePayHelper(Context context) {
        this.mContext = null;
        this.mContext = context;
    }

    public static PackageInfo getApkInfo(Context context, String str) {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "296642846") ? (PackageInfo) ipChange.ipc$dispatch("296642846", new Object[]{context, str}) : context.getPackageManager().getPackageArchiveInfo(str, 128);
    }

    private boolean isAppInstalled(Context context, String str) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "561701730")) {
            return ((Boolean) ipChange.ipc$dispatch("561701730", new Object[]{this, context, str})).booleanValue();
        }
        try {
            return context.getPackageManager().getPackageInfo(str, 64) != null;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    public String checkNewUpdate(PackageInfo packageInfo) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1434927155")) {
            return (String) ipChange.ipc$dispatch("1434927155", new Object[]{this, packageInfo});
        }
        try {
            JSONObject sendCheckNewUpdate = sendCheckNewUpdate(packageInfo.versionName);
            if (sendCheckNewUpdate.getString("needUpdate").equalsIgnoreCase("true")) {
                return sendCheckNewUpdate.getString("updateUrl");
            }
            return null;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    void closeProgress() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1931848434")) {
            ipChange.ipc$dispatch("-1931848434", new Object[]{this});
            return;
        }
        try {
            ProgressDialog progressDialog = this.mProgress;
            if (progressDialog != null) {
                progressDialog.dismiss();
                this.mProgress = null;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public boolean detectMobile_sp() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1346208992")) {
            return ((Boolean) ipChange.ipc$dispatch("1346208992", new Object[]{this})).booleanValue();
        }
        boolean isMobile_spExist = isMobile_spExist();
        if (TextUtils.isEmpty(getMsp(this.mContext))) {
            if (!isMobile_spExist) {
                File externalCacheDir = this.mContext.getExternalCacheDir();
                final String str = externalCacheDir.getAbsolutePath() + "/temp.apk";
                retrieveApkFromAssets(this.mContext, "alipay_plugin_2.5.0_1221.apk", str);
                Context context = this.mContext;
                this.mProgress = BaseHelper.showProgress(context, null, cm2.b(context, R$string.data_string_044), false, true);
                new Thread(new Runnable() { // from class: cn.damai.pay.alipay.MobileSecurePayHelper.1
                    private static transient /* synthetic */ IpChange $ipChange;

                    @Override // java.lang.Runnable
                    public void run() {
                        IpChange ipChange2 = $ipChange;
                        if (AndroidInstantRuntime.support(ipChange2, "1046985755")) {
                            ipChange2.ipc$dispatch("1046985755", new Object[]{this});
                            return;
                        }
                        String checkNewUpdate = MobileSecurePayHelper.this.checkNewUpdate(MobileSecurePayHelper.getApkInfo(MobileSecurePayHelper.this.mContext, str));
                        if (checkNewUpdate != null) {
                            MobileSecurePayHelper mobileSecurePayHelper = MobileSecurePayHelper.this;
                            mobileSecurePayHelper.retrieveApkFromNet(mobileSecurePayHelper.mContext, checkNewUpdate, str);
                        }
                        Message message = new Message();
                        message.what = 2;
                        message.obj = str;
                        MobileSecurePayHelper.this.mHandler.sendMessage(message);
                    }
                }).start();
            }
            return isMobile_spExist;
        }
        return true;
    }

    public String getMsp(Context context) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1900163707")) {
            return (String) ipChange.ipc$dispatch("1900163707", new Object[]{this, context});
        }
        if (isAppInstalled(context, "com.eg.android.AlipayGphone")) {
            return "com.eg.android.AlipayGphone.IAlixPay";
        }
        if (isAppInstalled(context, n.a)) {
            return IAlixPay.Stub.DESCRIPTOR;
        }
        return null;
    }

    public boolean isMobile_spExist() {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "-1024326252") ? ((Boolean) ipChange.ipc$dispatch("-1024326252", new Object[]{this})).booleanValue() : isAppInstalled(this.mContext, n.a);
    }

    public boolean retrieveApkFromAssets(Context context, String str, String str2) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1792944006")) {
            return ((Boolean) ipChange.ipc$dispatch("-1792944006", new Object[]{this, context, str, str2})).booleanValue();
        }
        try {
            InputStream open = context.getAssets().open(str);
            File file = new File(str2);
            file.createNewFile();
            FileOutputStream fileOutputStream = new FileOutputStream(file);
            byte[] bArr = new byte[1024];
            while (true) {
                int read = open.read(bArr);
                if (read > 0) {
                    fileOutputStream.write(bArr, 0, read);
                } else {
                    fileOutputStream.close();
                    open.close();
                    return true;
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
            return false;
        }
    }

    public boolean retrieveApkFromNet(Context context, String str, String str2) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1442572092")) {
            return ((Boolean) ipChange.ipc$dispatch("1442572092", new Object[]{this, context, str, str2})).booleanValue();
        }
        try {
            return new NetworkManager(this.mContext).urlDownloadToFile(context, str, str2);
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    public JSONObject sendCheckNewUpdate(String str) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1625323322")) {
            return (JSONObject) ipChange.ipc$dispatch("-1625323322", new Object[]{this, str});
        }
        try {
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("action", "update");
            JSONObject jSONObject2 = new JSONObject();
            jSONObject2.put("platform", "android");
            jSONObject2.put("version", str);
            jSONObject2.put("partner", "");
            jSONObject.put("data", jSONObject2);
            return sendRequest(jSONObject.toString());
        } catch (JSONException e) {
            e.printStackTrace();
            return null;
        }
    }

    public JSONObject sendRequest(String str) {
        String SendAndWaitResponse;
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1307095964")) {
            return (JSONObject) ipChange.ipc$dispatch("-1307095964", new Object[]{this, str});
        }
        NetworkManager networkManager = new NetworkManager(this.mContext);
        JSONObject jSONObject = null;
        try {
            synchronized (networkManager) {
                SendAndWaitResponse = networkManager.SendAndWaitResponse(str, Constant.server_url);
            }
            jSONObject = new JSONObject(SendAndWaitResponse);
        } catch (Exception e) {
            e.printStackTrace();
        }
        if (jSONObject != null) {
            BaseHelper.log(TAG, jSONObject.toString());
        }
        return jSONObject;
    }

    public void showInstallConfirmDialog(final Context context, final String str) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1285332507")) {
            ipChange.ipc$dispatch("-1285332507", new Object[]{this, context, str});
            return;
        }
        DMDialog dMDialog = new DMDialog(context);
        dMDialog.v(context.getResources().getString(R$string.confirm_install_hint));
        dMDialog.q(context.getResources().getString(R$string.confirm_install));
        dMDialog.l(R$string.Ensure, new DialogInterface.OnClickListener() { // from class: cn.damai.pay.alipay.MobileSecurePayHelper.2
            private static transient /* synthetic */ IpChange $ipChange;

            @Override // android.content.DialogInterface.OnClickListener
            public void onClick(DialogInterface dialogInterface, int i) {
                IpChange ipChange2 = $ipChange;
                if (AndroidInstantRuntime.support(ipChange2, "1213452921")) {
                    ipChange2.ipc$dispatch("1213452921", new Object[]{this, dialogInterface, Integer.valueOf(i)});
                    return;
                }
                BaseHelper.chmod("777", str);
                Intent intent = new Intent("android.intent.action.VIEW");
                intent.addFlags(268435456);
                intent.setDataAndType(Uri.parse("file://" + str), "application/vnd.android.package-archive");
                context.startActivity(intent);
            }
        });
        dMDialog.i(context.getResources().getString(R$string.Cancel), null);
        dMDialog.show();
    }
}
