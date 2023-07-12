package com.youku.gaiax.impl.register;

import com.alibaba.gaiax.GXRegisterCenter;
import com.youku.gaiax.impl.utils.ExceptionUtils;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;
import tb.b41;

/* compiled from: Taobao */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0006\u0010\u0007J\u0014\u0010\u0004\u001a\u00020\u00052\n\u0010\u0004\u001a\u00060\u0002j\u0002`\u0003H\u0016¨\u0006\b"}, d2 = {"Lcom/youku/gaiax/impl/register/GXExtensionException;", "Lcom/alibaba/gaiax/GXRegisterCenter$GXIExtensionException;", "Ljava/lang/Exception;", "Lkotlin/Exception;", "exception", "Ltb/wt2;", "<init>", "()V", "GaiaX-Android"}, k = 1, mv = {1, 5, 1})
/* loaded from: classes2.dex */
public final class GXExtensionException implements GXRegisterCenter.GXIExtensionException {
    @Override // com.alibaba.gaiax.GXRegisterCenter.GXIExtensionException
    public void exception(@NotNull Exception exc) {
        b41.i(exc, "exception");
        ExceptionUtils.INSTANCE.throwExceptionOrAlarm(exc, "5001");
    }
}
