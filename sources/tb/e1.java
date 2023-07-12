package tb;

import java.util.HashMap;
import java.util.Map;

/* compiled from: Taobao */
/* loaded from: classes10.dex */
public abstract class e1 extends c1 {
    protected HashMap<String, Object> b;

    public e1(String str) {
        super(str);
        this.b = new HashMap<>();
    }

    public void a(String str, Object obj) {
        this.b.put(str, obj);
    }

    public void b(Map<String, Object> map) {
        this.b.putAll(map);
    }

    @Override // com.efs.sdk.base.protocol.ILogProtocol
    public int getBodyType() {
        return 0;
    }

    @Override // com.efs.sdk.base.protocol.ILogProtocol
    public String getFilePath() {
        return null;
    }

    @Override // com.efs.sdk.base.protocol.ILogProtocol
    public byte getLogProtocol() {
        return (byte) 1;
    }
}
