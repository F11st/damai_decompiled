package tb;

import java.util.Map;

/* compiled from: Taobao */
/* loaded from: classes11.dex */
public class p73 {
    public Map<String, String> a;
    public byte[] b;
    public int c;
    public int d;

    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("ProtocolData[");
        sb.append(hashCode());
        sb.append("] header==null:");
        sb.append(this.a == null);
        sb.append(" offset:");
        sb.append(this.c);
        sb.append(" length:");
        sb.append(this.d);
        return sb.toString();
    }
}
