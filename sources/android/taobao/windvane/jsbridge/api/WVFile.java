package android.taobao.windvane.jsbridge.api;

import android.taobao.windvane.cache.WVCacheManager;
import android.taobao.windvane.jsbridge.WVApiPlugin;
import android.taobao.windvane.jsbridge.WVCallBackContext;
import android.taobao.windvane.jsbridge.WVResult;
import android.taobao.windvane.jsbridge.utils.WVUtils;
import android.text.TextUtils;
import com.alibaba.aliweex.adapter.module.location.ILocatable;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import org.json.JSONObject;
import tb.kh1;

/* compiled from: Taobao */
/* loaded from: classes.dex */
public class WVFile extends WVApiPlugin {
    public static final long FILE_MAX_SIZE = 5242880;

    private boolean canWriteFile(long j, String str, boolean z) {
        long length;
        if (z) {
            length = j + str.length();
        } else {
            length = str.length();
        }
        return length <= FILE_MAX_SIZE;
    }

    @Override // android.taobao.windvane.jsbridge.WVApiPlugin
    public boolean execute(String str, String str2, WVCallBackContext wVCallBackContext) {
        if (kh1.OPERATION_READ.equals(str)) {
            read(str2, wVCallBackContext);
            return true;
        } else if (kh1.OPERATION_WRITE.equals(str)) {
            write(str2, wVCallBackContext);
            return true;
        } else {
            return false;
        }
    }

    public final void read(String str, WVCallBackContext wVCallBackContext) {
        String str2;
        String str3;
        String str4 = "";
        if (TextUtils.isEmpty(str)) {
            str2 = "";
        } else {
            try {
                JSONObject jSONObject = new JSONObject(str);
                String optString = jSONObject.optString("fileName");
                String optString2 = jSONObject.optString("share", "false");
                if (optString == null || optString.contains(File.separator)) {
                    throw new Exception();
                }
                str4 = optString2;
                str2 = optString;
            } catch (Exception unused) {
                wVCallBackContext.error(new WVResult("HY_PARAM_ERR"));
                return;
            }
        }
        String cacheDir = WVCacheManager.getInstance().getCacheDir(false);
        if (cacheDir == null) {
            WVResult wVResult = new WVResult();
            wVResult.addData("error", "GET_DIR_FAILED");
            wVCallBackContext.error(wVResult);
            return;
        }
        if (!"true".equalsIgnoreCase(str4)) {
            String str5 = cacheDir + File.separator;
            str3 = str5 + WVUtils.getHost(this.mWebView.getUrl());
        } else {
            str3 = (cacheDir + File.separator) + "wvShareFiles";
        }
        try {
            FileInputStream fileInputStream = new FileInputStream(new File(str3 + File.separator + str2));
            byte[] bArr = new byte[fileInputStream.available()];
            fileInputStream.read(bArr);
            String str6 = new String(bArr, "UTF-8");
            fileInputStream.close();
            WVResult wVResult2 = new WVResult();
            wVResult2.addData("data", str6);
            wVCallBackContext.success(wVResult2);
        } catch (FileNotFoundException unused2) {
            WVResult wVResult3 = new WVResult();
            wVResult3.addData("error", "FILE_NOT_FOUND");
            wVCallBackContext.error(wVResult3);
        } catch (Exception e) {
            WVResult wVResult4 = new WVResult();
            wVResult4.addData("error", "READ_FILE_FAILED");
            wVCallBackContext.error(wVResult4);
            e.printStackTrace();
        }
    }

    public final void write(String str, WVCallBackContext wVCallBackContext) {
        String optString;
        String str2;
        String str3;
        String str4;
        String str5 = "";
        if (TextUtils.isEmpty(str)) {
            str3 = "";
            str2 = str3;
            optString = str2;
        } else {
            try {
                JSONObject jSONObject = new JSONObject(str);
                String optString2 = jSONObject.optString("mode", kh1.OPERATION_WRITE);
                String optString3 = jSONObject.optString("data");
                optString = jSONObject.optString("fileName");
                String optString4 = jSONObject.optString("share", "false");
                if (optString2 == null || optString == null || optString.contains(File.separator)) {
                    throw new Exception();
                }
                str2 = optString3;
                str3 = optString2;
                str5 = optString4;
            } catch (Exception unused) {
                WVResult wVResult = new WVResult();
                wVResult.addData("error", ILocatable.ErrorMsg.PARAMS_ERROR);
                wVCallBackContext.error(wVResult);
                return;
            }
        }
        String cacheDir = WVCacheManager.getInstance().getCacheDir(false);
        if (cacheDir == null) {
            WVResult wVResult2 = new WVResult();
            wVResult2.addData("error", "GET_DIR_FAILED");
            wVCallBackContext.error(wVResult2);
            return;
        }
        if (!"true".equalsIgnoreCase(str5)) {
            String str6 = cacheDir + File.separator;
            str4 = str6 + WVUtils.getHost(this.mWebView.getUrl());
        } else {
            str4 = (cacheDir + File.separator) + "wvShareFiles";
        }
        File file = new File(str4);
        if (!file.exists()) {
            file.mkdirs();
        }
        File file2 = new File(str4 + File.separator + optString);
        if (file2.exists()) {
            if (kh1.OPERATION_WRITE.equalsIgnoreCase(str3)) {
                WVResult wVResult3 = new WVResult();
                wVResult3.addData("error", "FILE_EXIST");
                wVCallBackContext.error(wVResult3);
                return;
            }
        } else {
            try {
                file2.createNewFile();
            } catch (IOException unused2) {
                WVResult wVResult4 = new WVResult();
                wVResult4.addData("error", "MAKE_FILE_FAILED");
                wVCallBackContext.error(wVResult4);
                return;
            }
        }
        try {
            boolean equalsIgnoreCase = "append".equalsIgnoreCase(str3);
            if (!canWriteFile(file2.length(), str2, equalsIgnoreCase)) {
                WVResult wVResult5 = new WVResult();
                wVResult5.addData("error", "FILE_TOO_LARGE");
                wVCallBackContext.error(wVResult5);
                return;
            }
            FileOutputStream fileOutputStream = new FileOutputStream(file2, equalsIgnoreCase);
            fileOutputStream.write(str2.getBytes());
            fileOutputStream.close();
            wVCallBackContext.success();
        } catch (Exception e) {
            WVResult wVResult6 = new WVResult();
            wVResult6.addData("error", "WRITE_FILE_FAILED");
            wVCallBackContext.error(wVResult6);
            e.printStackTrace();
        }
    }
}
