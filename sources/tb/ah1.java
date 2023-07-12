package tb;

import com.taobao.android.dinamic.DViewGenerator;
import com.taobao.android.dinamic.tempate.DTemplateManager;

/* compiled from: Taobao */
/* loaded from: classes11.dex */
public class ah1 {
    public DViewGenerator a;
    public DTemplateManager b;

    public static ah1 a(String str) {
        ah1 ah1Var = new ah1();
        ah1Var.a = new DViewGenerator(str);
        ah1Var.b = new DTemplateManager(str);
        return ah1Var;
    }
}
