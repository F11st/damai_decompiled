package tb;

import com.efs.sdk.base.Constants;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;
import java.util.Map;

/* compiled from: Taobao */
/* loaded from: classes10.dex */
public final class o43 extends e1 {
    private String c;
    private String d;
    private String e;
    private String f;

    public o43(String str, String str2, String str3) {
        super(Constants.LOG_TYPE_WA);
        this.c = str;
        this.d = str2;
        this.f = str3;
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:SS", Locale.CHINA);
        u23.c();
        this.e = simpleDateFormat.format(new Date(u23.e()));
    }

    @Override // com.efs.sdk.base.protocol.ILogProtocol
    public final byte[] generate() {
        String generateString = generateString();
        if (com.efs.sdk.base.a.d.a.a().h) {
            w63.a(Constants.TAG, generateString);
        }
        return generateString.getBytes();
    }

    @Override // com.efs.sdk.base.protocol.ILogProtocol
    public final String generateString() {
        StringBuilder sb = new StringBuilder();
        sb.append("lt=event`");
        sb.append("ev_ct=");
        sb.append(this.c);
        sb.append("`");
        sb.append("ev_ac=");
        sb.append(this.d);
        sb.append("`");
        sb.append("tm=");
        sb.append(this.e);
        sb.append("`");
        sb.append("dn=");
        sb.append(this.f);
        sb.append("`");
        for (Map.Entry<String, Object> entry : this.b.entrySet()) {
            sb.append(entry.getKey());
            sb.append("=");
            sb.append(entry.getValue());
            sb.append("`");
        }
        return sb.subSequence(0, sb.length() - 1).toString();
    }

    @Override // com.efs.sdk.base.protocol.ILogProtocol
    public final String getLinkId() {
        return "";
    }

    @Override // com.efs.sdk.base.protocol.ILogProtocol
    public final String getLinkKey() {
        return "";
    }

    @Override // com.efs.sdk.base.protocol.ILogProtocol
    public final void insertGlobal(i43 i43Var) {
        this.b.putAll(i43Var.a());
        this.b.putAll(com.efs.sdk.base.a.d.a.a().b());
    }
}
