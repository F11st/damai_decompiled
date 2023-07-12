package tb;

import com.efs.sdk.base.protocol.ILogProtocol;

/* compiled from: Taobao */
/* loaded from: classes10.dex */
public abstract class c1 implements ILogProtocol {
    private String a;

    public c1(String str) {
        this.a = str;
    }

    @Override // com.efs.sdk.base.protocol.ILogProtocol
    public String getLogType() {
        return this.a;
    }
}
