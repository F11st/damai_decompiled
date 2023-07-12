package tb;

import android.view.View;
import com.alibaba.ability.env.IAbilityContext;
import com.alibaba.ability.env.IAbilityEnv;
import java.lang.ref.WeakReference;
import java.util.Map;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: Taobao */
/* loaded from: classes9.dex */
public final class p0 implements IAbilityContext {
    @Nullable
    private IAbilityEnv a;
    @Nullable
    private WeakReference<View> b;
    @Nullable
    private Object c;
    @Nullable
    private Map<String, Object> d;

    public p0() {
    }

    @Override // com.alibaba.ability.env.IAbilityContext
    @NotNull
    public IAbilityEnv getAbilityEnv() {
        return IAbilityContext.a.a(this);
    }

    @Override // com.alibaba.ability.env.IAbilityContext
    @Nullable
    public IAbilityEnv getEnv() {
        return this.a;
    }

    @Override // com.alibaba.ability.env.IAbilityContext
    @Nullable
    public View getInvokeView() {
        return IAbilityContext.a.b(this);
    }

    @Override // com.alibaba.ability.env.IAbilityContext
    @Nullable
    public WeakReference<View> getInvokeViewRef() {
        return this.b;
    }

    @Override // com.alibaba.ability.env.IAbilityContext
    @Nullable
    public Object getUserContext() {
        return this.c;
    }

    @Override // com.alibaba.ability.env.IAbilityContext
    @Nullable
    public <T> T getUserData(@NotNull String str) {
        b41.i(str, "key");
        return (T) IAbilityContext.a.c(this, str);
    }

    @Override // com.alibaba.ability.env.IAbilityContext
    @Nullable
    public Map<String, Object> getUserDataMap() {
        return this.d;
    }

    @Override // com.alibaba.ability.env.IAbilityContext
    public void setEnv(@Nullable IAbilityEnv iAbilityEnv) {
        this.a = iAbilityEnv;
    }

    @Override // com.alibaba.ability.env.IAbilityContext
    public void setInvokeViewRef(@Nullable WeakReference<View> weakReference) {
        this.b = weakReference;
    }

    @Override // com.alibaba.ability.env.IAbilityContext
    public void setUserContext(@Nullable Object obj) {
        this.c = obj;
    }

    @Override // com.alibaba.ability.env.IAbilityContext
    public void setUserDataMap(@Nullable Map<String, Object> map) {
        this.d = map;
    }

    @Override // com.alibaba.ability.env.IAbilityContext
    @NotNull
    public IAbilityContext withInvokeView(@Nullable View view) {
        return IAbilityContext.a.d(this, view);
    }

    @Override // com.alibaba.ability.env.IAbilityContext
    @NotNull
    public IAbilityContext withUserData(@NotNull String str, @NotNull Object obj) {
        b41.i(str, "key");
        b41.i(obj, "data");
        return IAbilityContext.a.e(this, str, obj);
    }

    public p0(@Nullable IAbilityEnv iAbilityEnv) {
        this();
        setEnv(iAbilityEnv);
    }
}
