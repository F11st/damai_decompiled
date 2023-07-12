package tb;

import androidx.annotation.NonNull;
import com.taobao.android.abilitykit.AKAbilityToolInterface;
import com.taobao.android.abilitykit.AKIAbilityRemoteDebugLog;
import com.taobao.android.abilitykit.AKIBuilderAbility;
import java.util.Map;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: Taobao */
/* renamed from: tb.p */
/* loaded from: classes8.dex */
public class C9539p {
    static Map<String, AKIBuilderAbility> a;
    static AKIAbilityRemoteDebugLog b;
    static AKAbilityToolInterface c;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: Taobao */
    /* renamed from: tb.p$a */
    /* loaded from: classes8.dex */
    public static class C9540a implements AKAbilityToolInterface {
        C9540a() {
        }

        @Override // com.taobao.android.abilitykit.AKAbilityToolInterface
        @NotNull
        public String adjustedBizID(@Nullable C9192h c9192h) {
            return c9192h == null ? "AbilityKit" : c9192h.f().getBusinessID();
        }
    }

    public static AKIAbilityRemoteDebugLog a() {
        return b;
    }

    @NonNull
    public static AKAbilityToolInterface b() {
        if (c == null) {
            c = new C9540a();
        }
        return c;
    }
}
