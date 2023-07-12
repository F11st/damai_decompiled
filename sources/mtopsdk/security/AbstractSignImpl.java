package mtopsdk.security;

import androidx.annotation.NonNull;
import java.util.HashMap;
import mtopsdk.mtop.domain.EnvModeEnum;
import mtopsdk.mtop.global.MtopConfig;

/* compiled from: Taobao */
/* loaded from: classes11.dex */
public abstract class AbstractSignImpl implements ISign {
    MtopConfig mtopConfig = null;
    EnvModeEnum envMode = null;

    /* compiled from: Taobao */
    /* renamed from: mtopsdk.security.AbstractSignImpl$1  reason: invalid class name */
    /* loaded from: classes11.dex */
    static /* synthetic */ class AnonymousClass1 {
        static final /* synthetic */ int[] $SwitchMap$mtopsdk$mtop$domain$EnvModeEnum;

        static {
            int[] iArr = new int[EnvModeEnum.values().length];
            $SwitchMap$mtopsdk$mtop$domain$EnvModeEnum = iArr;
            try {
                iArr[EnvModeEnum.ONLINE.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                $SwitchMap$mtopsdk$mtop$domain$EnvModeEnum[EnvModeEnum.PREPARE.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                $SwitchMap$mtopsdk$mtop$domain$EnvModeEnum[EnvModeEnum.TEST.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                $SwitchMap$mtopsdk$mtop$domain$EnvModeEnum[EnvModeEnum.TEST_SANDBOX.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public String getAuthCode() {
        MtopConfig mtopConfig = this.mtopConfig;
        return mtopConfig != null ? mtopConfig.authCode : "";
    }

    @Override // mtopsdk.security.ISign
    public String getAvmpSign(String str, String str2, int i) {
        return null;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public int getEnv() {
        EnvModeEnum envModeEnum = this.envMode;
        if (envModeEnum == null) {
            return 0;
        }
        int i = AnonymousClass1.$SwitchMap$mtopsdk$mtop$domain$EnvModeEnum[envModeEnum.ordinal()];
        if (i != 2) {
            return (i == 3 || i == 4) ? 2 : 0;
        }
        return 1;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public String getInstanceId() {
        MtopConfig mtopConfig = this.mtopConfig;
        return mtopConfig != null ? mtopConfig.instanceId : "";
    }

    @Override // mtopsdk.security.ISign
    public String getMiniWua(HashMap<String, String> hashMap, HashMap<String, String> hashMap2) {
        return null;
    }

    @Override // mtopsdk.security.ISign
    public String getSecBodyDataEx(String str, String str2, String str3, HashMap<String, String> hashMap, int i) {
        return null;
    }

    @Override // mtopsdk.security.ISign
    public String getSign(HashMap<String, String> hashMap, String str) {
        return null;
    }

    @Override // mtopsdk.security.ISign
    public HashMap<String, String> getUnifiedSign(HashMap<String, String> hashMap, HashMap<String, String> hashMap2, String str, String str2, boolean z) {
        return null;
    }

    @Override // mtopsdk.security.ISign
    public String getWua(HashMap<String, String> hashMap, String str) {
        return null;
    }

    @Override // mtopsdk.security.ISign
    public void init(@NonNull MtopConfig mtopConfig) {
        this.mtopConfig = mtopConfig;
        if (mtopConfig != null) {
            this.envMode = mtopConfig.envMode;
        }
    }
}
