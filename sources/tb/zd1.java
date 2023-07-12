package tb;

import com.taobao.android.abilitykit.AKBaseAbility;
import com.taobao.android.abilitykit.AKIBuilderAbility;
import kotlin.Lazy;
import kotlin.jvm.internal.PropertyReference1Impl;
import kotlin.reflect.KProperty;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: Taobao */
/* loaded from: classes8.dex */
public final class zd1<DATA> implements AKIBuilderAbility<DATA> {
    static final /* synthetic */ KProperty[] d = {a12.i(new PropertyReference1Impl(a12.b(zd1.class), "wrapper", "getWrapper()Lcom/taobao/android/abilitykit/mega/MegaWrapper;"))};
    private final Lazy a;
    private final String b;
    private final String c;

    private final ae1 c() {
        Lazy lazy = this.a;
        KProperty kProperty = d[0];
        return (ae1) lazy.getValue();
    }

    @Override // com.taobao.android.abilitykit.AKIBuilderAbility
    @NotNull
    public AKBaseAbility<?> build(@Nullable DATA data) {
        return c();
    }
}
