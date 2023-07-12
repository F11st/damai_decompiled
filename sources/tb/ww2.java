package tb;

import com.alibaba.android.umbrella.trace.UmbrellaTracker;
import com.taobao.android.ultron.datamodel.imp.C6661a;
import com.taobao.android.ultron.datamodel.imp.DMComponent;
import java.util.Map;

/* compiled from: Taobao */
/* loaded from: classes11.dex */
public class ww2 {
    private C6661a a;

    public ww2(C6661a c6661a) {
        this.a = c6661a;
    }

    public xw2 a() {
        xw2 validate;
        Map<String, DMComponent> l = this.a.l();
        if (l != null && l.size() > 0) {
            for (DMComponent dMComponent : l.values()) {
                if (dMComponent.getStatus() != 0 && (validate = dMComponent.validate()) != null && !validate.c()) {
                    UmbrellaTracker.commitFailureStability("formValidationFailed", "ValidateModule", "1.0", this.a.a(), null, null, "errorcode", validate.b());
                    return validate;
                }
            }
        }
        return new xw2();
    }
}
