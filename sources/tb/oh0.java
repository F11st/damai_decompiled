package tb;

import android.content.Context;
import com.alibaba.poplayer.PopLayer;
import com.alibaba.poplayer.norm.IConfigAdapter;
import org.json.JSONObject;

/* compiled from: Taobao */
/* loaded from: classes8.dex */
public class oh0 implements IConfigAdapter {
    public final IConfigAdapter a;
    public JSONObject b;

    public oh0(IConfigAdapter iConfigAdapter, JSONObject jSONObject) {
        this.a = iConfigAdapter;
        this.b = jSONObject;
    }

    @Override // com.alibaba.poplayer.norm.IConfigAdapter
    public void addConfigObserver(Context context, PopLayer popLayer) {
    }

    @Override // com.alibaba.poplayer.norm.IConfigAdapter
    public String getConfigItemByKey(Context context, String str) {
        return this.b.optString(str, this.a.getConfigItemByKey(context, str));
    }

    @Override // com.alibaba.poplayer.norm.IConfigAdapter
    public void initializeConfigContainer(Context context, PopLayer popLayer) {
    }
}
