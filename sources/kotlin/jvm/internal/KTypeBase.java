package kotlin.jvm.internal;

import java.lang.reflect.Type;
import kotlin.SinceKotlin;
import kotlin.reflect.KType;
import org.jetbrains.annotations.Nullable;

/* compiled from: Taobao */
@SinceKotlin(version = "1.4")
/* loaded from: classes3.dex */
public interface KTypeBase extends KType {
    @Nullable
    Type getJavaType();
}
