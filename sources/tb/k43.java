package tb;

import com.efs.sdk.base.Constants;
import com.efs.sdk.base.processor.action.ILogEncryptAction;

/* compiled from: Taobao */
/* loaded from: classes10.dex */
public final class k43 implements ILogEncryptAction {
    @Override // com.efs.sdk.base.processor.action.ILogEncryptAction
    public final byte[] decrypt(String str, byte[] bArr) {
        try {
            return v23.c(bArr, str);
        } catch (Exception e) {
            w63.c(Constants.TAG, "aes decrypt error", e);
            return null;
        }
    }

    @Override // com.efs.sdk.base.processor.action.ILogEncryptAction
    public final byte[] encrypt(String str, byte[] bArr) {
        try {
            return v23.d(bArr, str);
        } catch (Exception e) {
            w63.c(Constants.TAG, "aes encrypt error", e);
            return null;
        }
    }

    @Override // com.efs.sdk.base.processor.action.ILogEncryptAction
    public final int getDeVal() {
        return 2;
    }
}
