package cn.damai.wxapi;

import android.app.Activity;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import cn.damai.commonbusiness.R$string;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import com.tencent.connect.auth.QQToken;
import com.tencent.connect.common.Constants;
import com.tencent.connect.share.QQShare;
import com.tencent.tauth.IUiListener;
import com.tencent.tauth.Tencent;
import com.tencent.tauth.UiError;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import org.json.JSONObject;
import tb.cb1;
import tb.cm2;
import tb.z20;

/* compiled from: Taobao */
/* loaded from: classes17.dex */
public class TencentUtil {
    private static transient /* synthetic */ IpChange $ipChange = null;
    public static String APP_ID = "206444";
    public static String APP_KEY = "1ceaddb327b8bfbf4383eef18f0c7d22";
    public static final String CALLBACK_URL = "http://www.damai.com";
    public static String provider = "cn.damai.interactProvider";
    private Activity mActivity;
    private IUiListener mListener = new IUiListener() { // from class: cn.damai.wxapi.TencentUtil.1
        private static transient /* synthetic */ IpChange $ipChange;

        @Override // com.tencent.tauth.IUiListener
        public void onCancel() {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "1983411999")) {
                ipChange.ipc$dispatch("1983411999", new Object[]{this});
            } else {
                TencentUtil.this.mOauthListener.onError(cm2.b(TencentUtil.this.mActivity, R$string.data_string_014));
            }
        }

        @Override // com.tencent.tauth.IUiListener
        public void onComplete(Object obj) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "1045147356")) {
                ipChange.ipc$dispatch("1045147356", new Object[]{this, obj});
                return;
            }
            JSONObject jSONObject = (JSONObject) obj;
            cb1.a("--------json----" + jSONObject);
            if (jSONObject == null) {
                TencentUtil.this.mOauthListener.onError(cm2.b(TencentUtil.this.mActivity, R$string.data_string_014));
                return;
            }
            String optString = jSONObject.optString(Constants.PARAM_ACCESS_TOKEN);
            String optString2 = jSONObject.optString(Constants.PARAM_EXPIRES_IN);
            String optString3 = jSONObject.optString("openid");
            z20.X(optString + "," + optString2 + "," + optString3);
            if (!TextUtils.isEmpty(optString) && !TextUtils.isEmpty(optString2) && !TextUtils.isEmpty(optString3)) {
                TencentUtil.this.mTencent.setAccessToken(optString, optString2);
                TencentUtil.this.mTencent.setOpenId(optString3);
            }
            TencentUtil.this.mOauthListener.onSuccess(optString, optString3);
        }

        @Override // com.tencent.tauth.IUiListener
        public void onError(UiError uiError) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "1845605199")) {
                ipChange.ipc$dispatch("1845605199", new Object[]{this, uiError});
            } else {
                TencentUtil.this.mOauthListener.onError(cm2.b(TencentUtil.this.mActivity, R$string.data_string_014));
            }
        }

        @Override // com.tencent.tauth.IUiListener
        public void onWarning(int i) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "235770670")) {
                ipChange.ipc$dispatch("235770670", new Object[]{this, Integer.valueOf(i)});
            } else if (i == -19) {
                TencentUtil.this.mOauthListener.onError(cm2.b(TencentUtil.this.mActivity, R$string.data_string_012));
                Log.e("TencentUtil", "onWarning: 请授权手Q访问分享的文件的读取权限!");
            }
        }
    };
    private OnQQOauthLintener mOauthListener;
    private QQShare mQQshare;
    private Tencent mTencent;

    /* compiled from: Taobao */
    /* loaded from: classes17.dex */
    public interface OnQQOauthLintener {
        void onError(String str);

        void onSuccess(String str, String str2);
    }

    public TencentUtil(Activity activity) {
        this.mActivity = activity;
        this.mTencent = Tencent.createInstance(APP_ID, activity, provider);
        Tencent.setIsPermissionGranted(true);
    }

    public static void clearQQAccessToken(Activity activity) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-418987851")) {
            ipChange.ipc$dispatch("-418987851", new Object[]{activity});
            return;
        }
        z20.a();
        new TencentUtil(activity).qqLogout();
    }

    public void checkDir(String str) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1623016816")) {
            ipChange.ipc$dispatch("1623016816", new Object[]{this, str});
            return;
        }
        File file = new File(this.mActivity.getExternalFilesDir(null).getAbsolutePath() + "/Images/tmp/");
        if (!file.exists()) {
            try {
                file.mkdirs();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        File file2 = new File(str);
        if (file2.exists()) {
            return;
        }
        try {
            file2.createNewFile();
        } catch (IOException e2) {
            e2.printStackTrace();
        }
    }

    public void copy(File file, File file2) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1688772924")) {
            ipChange.ipc$dispatch("-1688772924", new Object[]{this, file, file2});
            return;
        }
        try {
            FileInputStream fileInputStream = new FileInputStream(file);
            FileOutputStream fileOutputStream = new FileOutputStream(file2);
            byte[] bArr = new byte[1024];
            while (true) {
                int read = fileInputStream.read(bArr);
                if (read > 0) {
                    fileOutputStream.write(bArr, 0, read);
                } else {
                    fileOutputStream.close();
                    fileInputStream.close();
                    return;
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public Tencent getTencent() {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "1540529875") ? (Tencent) ipChange.ipc$dispatch("1540529875", new Object[]{this}) : this.mTencent;
    }

    public void loginByQQ(OnQQOauthLintener onQQOauthLintener) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1585200235")) {
            ipChange.ipc$dispatch("1585200235", new Object[]{this, onQQOauthLintener});
            return;
        }
        this.mOauthListener = onQQOauthLintener;
        this.mTencent.logout(this.mActivity);
        this.mTencent.setAccessToken("0", "0");
        if (!this.mTencent.isSessionValid()) {
            this.mTencent.login(this.mActivity, "all", this.mListener);
            return;
        }
        QQToken qQToken = this.mTencent.getQQToken();
        if (qQToken != null && qQToken.isSessionValid()) {
            this.mOauthListener.onSuccess(qQToken.getAccessToken(), qQToken.getOpenId());
        } else {
            this.mTencent.login(this.mActivity, "all", this.mListener);
        }
    }

    public void qqLogout() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "24728993")) {
            ipChange.ipc$dispatch("24728993", new Object[]{this});
        } else {
            this.mTencent.logout(this.mActivity);
        }
    }

    public void shareImageToQQ(String str, IUiListener iUiListener) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "561985245")) {
            ipChange.ipc$dispatch("561985245", new Object[]{this, str, iUiListener});
            return;
        }
        Bundle bundle = new Bundle();
        bundle.putInt("req_type", 5);
        bundle.putString("imageLocalUrl", str);
        bundle.putString("appName", cm2.b(this.mActivity, R$string.data_string_013));
        this.mTencent.shareToQQ(this.mActivity, bundle, iUiListener);
    }

    public void shareMsgToQQ(String str, String str2, String str3, String str4, IUiListener iUiListener) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-199186907")) {
            ipChange.ipc$dispatch("-199186907", new Object[]{this, str, str2, str3, str4, iUiListener});
            return;
        }
        Bundle bundle = new Bundle();
        bundle.putInt("req_type", 1);
        bundle.putString("title", str);
        bundle.putString("targetUrl", str4);
        bundle.putString("summary", str2);
        bundle.putString("imageUrl", str3);
        bundle.putString("appName", cm2.b(this.mActivity, R$string.data_string_013));
        this.mTencent.shareToQQ(this.mActivity, bundle, iUiListener);
    }

    public void shareToQQSpace(String str, String str2, String str3, String str4, IUiListener iUiListener) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1819342740")) {
            ipChange.ipc$dispatch("1819342740", new Object[]{this, str, str2, str3, str4, iUiListener});
            return;
        }
        ArrayList<String> arrayList = new ArrayList<>();
        if (!TextUtils.isEmpty(str3)) {
            arrayList.add(str3);
        }
        Bundle bundle = new Bundle();
        bundle.putString("title", str);
        bundle.putString("summary", str2);
        bundle.putString("targetUrl", str4);
        if (arrayList.size() > 0) {
            bundle.putStringArrayList("imageUrl", arrayList);
        }
        bundle.putString("appName", cm2.b(this.mActivity, R$string.data_string_013));
        bundle.putInt("req_type", 1);
        this.mTencent.shareToQzone(this.mActivity, bundle, iUiListener);
    }
}
