package tb;

import com.efs.sdk.base.Constants;
import com.efs.sdk.base.a.d.C4786a;
import org.json.JSONObject;

/* compiled from: Taobao */
/* loaded from: classes10.dex */
public class rd0 extends e1 {
    public rd0(String str) {
        super(str);
        a("type", str);
    }

    @Override // com.efs.sdk.base.protocol.ILogProtocol
    public byte[] generate() {
        String generateString = generateString();
        if (C4786a.a().h) {
            w63.a(Constants.TAG, generateString);
        }
        return generateString.getBytes();
    }

    @Override // com.efs.sdk.base.protocol.ILogProtocol
    public String generateString() {
        return new JSONObject(this.b).toString();
    }

    @Override // com.efs.sdk.base.protocol.ILogProtocol
    public String getLinkId() {
        if (this.b.containsKey(Constants.LOG_KEY_LINK_ID)) {
            return String.valueOf(this.b.get(Constants.LOG_KEY_LINK_ID));
        }
        return null;
    }

    @Override // com.efs.sdk.base.protocol.ILogProtocol
    public String getLinkKey() {
        if (this.b.containsKey(Constants.LOG_KEY_LINK_KEY)) {
            return String.valueOf(this.b.get(Constants.LOG_KEY_LINK_KEY));
        }
        return null;
    }

    @Override // com.efs.sdk.base.protocol.ILogProtocol
    public void insertGlobal(i43 i43Var) {
        this.b.putAll(i43Var.a());
        this.b.putAll(C4786a.a().b());
    }
}
