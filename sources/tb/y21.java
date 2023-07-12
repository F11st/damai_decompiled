package tb;

import android.text.TextUtils;
import java.util.HashMap;

/* compiled from: Taobao */
/* loaded from: classes6.dex */
public class y21 extends ib {
    @Override // tb.ib
    public void h(np2 np2Var) {
        CharSequence charSequence = (CharSequence) f(0);
        CharSequence charSequence2 = (CharSequence) f(1);
        if (TextUtils.isEmpty(charSequence) || charSequence2 == null) {
            return;
        }
        HashMap hashMap = new HashMap();
        hashMap.put("value", charSequence2.toString());
        np2Var.o(new d60(this.e, this.c));
        j(hashMap);
        l(hashMap);
        if ("dialog".equalsIgnoreCase(charSequence.toString()) && g()) {
            this.c.getDataManager().respondToLinkage(this.e, np2Var);
        }
    }
}
