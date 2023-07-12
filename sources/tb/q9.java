package tb;

import android.content.Intent;
import com.alibaba.fastjson.JSONObject;

/* compiled from: Taobao */
/* loaded from: classes6.dex */
public class q9 extends fn1 {
    private void q() {
        JSONObject jSONObject = new JSONObject();
        jSONObject.put("status", (Object) r9.KEY_STATUS_H5_BACK);
        k(this.k, jSONObject);
        this.c.getDataManager().respondToLinkage(this.e);
    }

    @Override // tb.fn1, tb.ib
    public void h(np2 np2Var) {
        super.h(np2Var);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // tb.fn1
    public void m(Intent intent, int i) {
        if (i == -1 && intent != null) {
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("status", (Object) r9.KEY_STATUS_H5_ASYNC_REQUEST);
            k(this.k, jSONObject);
            super.m(intent, i);
            return;
        }
        q();
    }
}
