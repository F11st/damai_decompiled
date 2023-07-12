package kotlin.reflect;

import java.lang.reflect.Type;
import kotlin.ExperimentalStdlibApi;
import org.jetbrains.annotations.NotNull;

/* compiled from: Taobao */
@ExperimentalStdlibApi
/* loaded from: classes3.dex */
interface TypeImpl extends Type {
    @Override // kotlin.reflect.TypeImpl
    @NotNull
    String getTypeName();
}
