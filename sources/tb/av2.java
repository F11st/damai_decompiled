package tb;

import android.content.Context;
import android.text.TextUtils;
import com.alibaba.wireless.security.open.SecurityGuardManager;
import com.alibaba.wireless.security.open.SecurityGuardParamContext;
import com.ta.utdid2.device.UTDevice;
import com.uploader.export.UploaderGlobal;
import java.util.HashMap;

/* compiled from: Taobao */
/* loaded from: classes11.dex */
public class av2 extends zu2 {
    private final Context context;
    private volatile int environment;
    private volatile String utdid;

    public av2(Context context, int i) {
        super(i);
        this.environment = 0;
        if (context == null) {
            this.context = UploaderGlobal.f();
        } else {
            this.context = context;
        }
    }

    @Override // com.uploader.export.IUploaderEnvironment
    public byte[] decrypt(Context context, String str, byte[] bArr) {
        try {
            return SecurityGuardManager.getInstance(context).getStaticDataEncryptComp().staticBinarySafeDecryptNoB64(16, str, bArr, getCurrentElement().e);
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
    public String getAppVersion() {
        try {
            String str = this.context.getPackageManager().getPackageInfo(this.context.getPackageName(), 0).versionName;
            return TextUtils.isEmpty(str) ? "0" : str;
        } catch (Throwable unused) {
            return "0";
        }
    }

    @Override // tb.zu2, com.uploader.export.IUploaderEnvironment
    public int getEnvironment() {
        return this.environment;
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
            return SecurityGuardManager.getInstance(this.context).getSecureSignatureComp().signRequest(securityGuardParamContext, getCurrentElement().e);
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    public av2(Context context) {
        this(context, 0);
    }
}
