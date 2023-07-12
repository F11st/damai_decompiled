package com.alibaba.ability.env;

import android.content.Context;
import io.flutter.wpkbridge.WPKFactory;
import java.lang.ref.WeakReference;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: Taobao */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0006\bf\u0018\u00002\u00020\u0001J\n\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0016J\u0012\u0010\u0005\u001a\u00020\u00002\b\u0010\u0004\u001a\u0004\u0018\u00010\u0002H\u0016R\u001c\u0010\u000b\u001a\u00020\u00068&@&X¦\u000e¢\u0006\f\u001a\u0004\b\u0007\u0010\b\"\u0004\b\t\u0010\nR\u001c\u0010\u000e\u001a\u00020\u00068&@&X¦\u000e¢\u0006\f\u001a\u0004\b\f\u0010\b\"\u0004\b\r\u0010\nR$\u0010\u0014\u001a\n\u0012\u0004\u0012\u00020\u0002\u0018\u00010\u000f8&@&X¦\u000e¢\u0006\f\u001a\u0004\b\u0010\u0010\u0011\"\u0004\b\u0012\u0010\u0013¨\u0006\u0015"}, d2 = {"Lcom/alibaba/ability/env/IAbilityEnv;", "", "Landroid/content/Context;", "getContext", WPKFactory.INIT_KEY_CONTEXT, "withContext", "", "getNamespace", "()Ljava/lang/String;", "setNamespace", "(Ljava/lang/String;)V", "namespace", "getBusinessID", "setBusinessID", "businessID", "Ljava/lang/ref/WeakReference;", "getContextRef", "()Ljava/lang/ref/WeakReference;", "setContextRef", "(Ljava/lang/ref/WeakReference;)V", "contextRef", "megability_interface_release"}, k = 1, mv = {1, 4, 1})
/* loaded from: classes9.dex */
public interface IAbilityEnv {

    /* compiled from: Taobao */
    /* renamed from: com.alibaba.ability.env.IAbilityEnv$a */
    /* loaded from: classes9.dex */
    public static final class C3001a {
        @Nullable
        public static Context a(@NotNull IAbilityEnv iAbilityEnv) {
            WeakReference<Context> contextRef = iAbilityEnv.getContextRef();
            if (contextRef != null) {
                return contextRef.get();
            }
            return null;
        }

        @NotNull
        public static IAbilityEnv b(@NotNull IAbilityEnv iAbilityEnv, @Nullable Context context) {
            if (context != null) {
                iAbilityEnv.setContextRef(new WeakReference<>(context));
            }
            return iAbilityEnv;
        }
    }

    @NotNull
    String getBusinessID();

    @Nullable
    Context getContext();

    @Nullable
    WeakReference<Context> getContextRef();

    @NotNull
    String getNamespace();

    void setBusinessID(@NotNull String str);

    void setContextRef(@Nullable WeakReference<Context> weakReference);

    void setNamespace(@NotNull String str);

    @NotNull
    IAbilityEnv withContext(@Nullable Context context);
}
