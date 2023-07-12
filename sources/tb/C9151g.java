package tb;

import com.taobao.android.abilitykit.AKBaseAbility;
import com.taobao.android.abilitykit.AKIBuilderAbility;
import java.util.HashMap;

/* compiled from: Taobao */
/* renamed from: tb.g */
/* loaded from: classes8.dex */
public class C9151g {
    private final HashMap<String, AKIBuilderAbility> a = new HashMap<>(50);

    public AKBaseAbility<C9586q> a(String str) {
        AKIBuilderAbility aKIBuilderAbility = C9539p.a.get(str);
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
