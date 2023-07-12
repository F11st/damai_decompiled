package tb;

import android.app.Application;
import com.alibaba.fastjson.JSONObject;
import com.taobao.update.datasource.UpdateListener;

/* compiled from: Taobao */
/* loaded from: classes11.dex */
public class ne2 extends mu2 implements UpdateListener {

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: Taobao */
    /* renamed from: tb.ne2$a */
    /* loaded from: classes11.dex */
    public static class C9471a {
        private static final ne2 a = new ne2();
    }

    public static ne2 instance() {
        return C9471a.a;
    }

    public void init(Application application) {
    }

    @Override // com.taobao.update.datasource.UpdateListener
    public void onUpdate(boolean z, JSONObject jSONObject, String str) {
        bk2.a(jSONObject.toJSONString());
    }

    @Override // com.taobao.update.datasource.UpdateListener
    public void patchProcessListener(UpdateListener.PatchListener patchListener) {
    }

    public String registerName() {
        return lu2.SOPATCH;
    }
}
