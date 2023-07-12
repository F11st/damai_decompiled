package tb;

import com.alibaba.poplayer.layermanager.config.ConfigItem;
import java.util.HashMap;
import java.util.Map;

/* compiled from: Taobao */
/* loaded from: classes8.dex */
public final class sc {
    public Map<String, ConfigItem> a = new HashMap();

    public ConfigItem a(String str) {
        return this.a.get(str);
    }

    public String toString() {
        StringBuilder sb = new StringBuilder(jn1.BLOCK_START_STR);
        for (String str : this.a.keySet()) {
            sb.append(jn1.BLOCK_START_STR);
            sb.append(str);
            sb.append(":");
            sb.append(this.a.get(str).toString());
            sb.append("}");
        }
        sb.append("}");
        return sb.toString();
    }
}
