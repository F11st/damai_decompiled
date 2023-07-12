package tb;

import com.taobao.android.abilitykit.AKBaseAbility;
import com.taobao.android.abilitykit.AKIBuilderAbility;
import java.util.HashMap;

/* compiled from: Taobao */
/* loaded from: classes8.dex */
public class g {
    private final HashMap<String, AKIBuilderAbility> a = new HashMap<>(50);

    public AKBaseAbility<q> a(String str) {
        AKIBuilderAbility aKIBuilderAbility = p.a.get(str);
        if (aKIBuilderAbility != null) {
            return aKIBuilderAbility.build(null);
        }
        AKIBuilderAbility aKIBuilderAbility2 = this.a.get(str);
        if (aKIBuilderAbility2 == null) {
            return null;
        }
        return aKIBuilderAbility2.build(null);
    }
}
