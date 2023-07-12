package tb;

import android.content.Context;
import android.text.TextUtils;
import com.alibaba.wireless.security.open.SecurityGuardManager;
import com.alibaba.wireless.security.open.SecurityGuardParamContext;
import com.ta.utdid2.device.UTDevice;
import com.uploader.export.IUploaderEnvironment;
import java.util.HashMap;

/* compiled from: Taobao */
@Deprecated
/* loaded from: classes11.dex */
public class bv2 implements IUploaderEnvironment {
    private volatile String authCode;
    private final Context context;
    private volatile String utdid;
    private volatile int environment = 0;
    private volatile String onlineAppKey = "21646297";
    private volatile String prepareAppKey = "21646297";
    private volatile String dailyAppKey = "4272";
    private final int instanceType = 0;

    public bv2(Context context) {
        this.context = context;
    }

    @Override // com.uploader.export.IUploaderEnvironment
    public byte[] decrypt(Context context, String str, byte[] bArr) {
        try {
            return SecurityGuardManager.getInstance(context).getStaticDataEncryptComp().staticBinarySafeDecryptNoB64(16, str, bArr, this.authCode);
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    @Override // com.uploader.export.IUploaderEnvironment
    public boolean enableFlowControl() {
        return false;
    }

    @Override // com.uploader.export.IUploaderEnvironment
    public String getAppKey() {
        int environment = getEnvironment();
        if (environment != 0) {
            if (environment != 1) {
                if (environment != 2) {
                    return this.onlineAppKey;
                }
                return this.dailyAppKey;
            }
            return this.prepareAppKey;
        }
        return this.onlineAppKey;
    }

    @Override // com.uploader.export.IUploaderEnvironment
    public String getAppVersion() {
        try {
            String str = this.context.getPackageManager().getPackageInfo(this.context.getPackageName(), 0).versionName;
            return TextUtils.isEmpty(str) ? "0" : str;
        } catch (Throwable unused) {
            return "0";
        }
    }

    @Override // com.uploader.export.IUploaderEnvironment
    public String getDomain() {
        return null;
    }

    @Override // com.uploader.export.IUploaderEnvironment
    public int getEnvironment() {
        return this.environment;
    }

    @Override // com.uploader.export.IUploaderEnvironment
    public int getInstanceType() {
        return 0;
    }

    @Override // com.uploader.export.IUploaderEnvironment
    public byte[] getSslTicket(Context context, String str) {
        try {
            return SecurityGuardManager.getInstance(context).getDynamicDataStoreComp().getByteArray(str);
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    @Override // com.uploader.export.IUploaderEnvironment
    public String getUserId() {
        return null;
    }

    @Override // com.uploader.export.IUploaderEnvironment
    public String getUtdid() {
        if (this.utdid != null) {
            return this.utdid;
        }
        try {
            this.utdid = UTDevice.getUtdid(this.context);
        } catch (Throwable th) {
            th.printStackTrace();
        }
        return this.utdid;
    }

    @Override // com.uploader.export.IUploaderEnvironment
    public int putSslTicket(Context context, String str, byte[] bArr) {
        try {
            return SecurityGuardManager.getInstance(context).getDynamicDataStoreComp().putByteArray(str, bArr);
        } catch (Exception e) {
            e.printStackTrace();
            return -1;
        }
    }

    public void setAppKey(String str, String str2, String str3) {
        this.onlineAppKey = str;
        this.prepareAppKey = str2;
        this.dailyAppKey = str3;
    }

    public void setAuthCode(String str) {
        this.authCode = str;
    }

    public void setEnvironment(int i) {
        this.environment = i;
    }

    @Override // com.uploader.export.IUploaderEnvironment
    public String signature(String str) {
        HashMap hashMap = new HashMap(1);
        hashMap.put("INPUT", str);
        SecurityGuardParamContext securityGuardParamContext = new SecurityGuardParamContext();
        securityGuardParamContext.appKey = getAppKey();
        securityGuardParamContext.paramMap = hashMap;
        securityGuardParamContext.requestType = 3;
        try {
            return SecurityGuardManager.getInstance(this.context).getSecureSignatureComp().signRequest(securityGuardParamContext, this.authCode);
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }
}
