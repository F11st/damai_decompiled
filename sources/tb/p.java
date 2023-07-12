package tb;

import androidx.annotation.NonNull;
import com.taobao.android.abilitykit.AKAbilityToolInterface;
import com.taobao.android.abilitykit.AKIAbilityRemoteDebugLog;
import com.taobao.android.abilitykit.AKIBuilderAbility;
import java.util.Map;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: Taobao */
/* loaded from: classes8.dex */
public class p {
    static Map<String, AKIBuilderAbility> a;
    static AKIAbilityRemoteDebugLog b;
    static AKAbilityToolInterface c;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: Taobao */
    /* loaded from: classes8.dex */
    public static class a implements AKAbilityToolInterface {
        a() {
        }

        @Override // com.taobao.android.abilitykit.AKAbilityToolInterface
        @NotNull
        public String adjustedBizID(@Nullable h hVar) {
            return hVar == null ? "AbilityKit" : hVar.f().getBusinessID();
        }
    }

    public static AKIAbilityRemoteDebugLog a() {
        return b;
    }

    @NonNull
    public static AKAbilityToolInterface b() {
        if (c == null) {
            c = new a();
        }
        return c;
    }
}
