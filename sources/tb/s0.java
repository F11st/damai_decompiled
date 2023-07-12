package tb;

import com.alibaba.ability.hub.IAbilityHub;
import org.jetbrains.annotations.NotNull;

/* compiled from: Taobao */
/* loaded from: classes9.dex */
public final class s0 {
    @NotNull
    public static final s0 INSTANCE = new s0();
    public static IAbilityHub a;

    private s0() {
    }

    @NotNull
    public static final IAbilityHub a() {
        IAbilityHub iAbilityHub = a;
        if (iAbilityHub == null) {
            b41.A("abilityHub");
        }
        return iAbilityHub;
    }
}
