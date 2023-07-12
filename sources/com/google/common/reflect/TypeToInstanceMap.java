package com.google.common.reflect;

import com.google.common.annotations.Beta;
import com.google.errorprone.annotations.CanIgnoreReturnValue;
import java.util.Map;
import org.checkerframework.checker.nullness.compatqual.NullableDecl;

/* compiled from: Taobao */
@Beta
/* loaded from: classes10.dex */
public interface TypeToInstanceMap<B> extends Map<TypeToken<? extends B>, B> {
    @NullableDecl
    <T extends B> T getInstance(TypeToken<T> typeToken);

    @NullableDecl
    <T extends B> T getInstance(Class<T> cls);

    @CanIgnoreReturnValue
    @NullableDecl
    <T extends B> T putInstance(TypeToken<T> typeToken, @NullableDecl T t);

    @CanIgnoreReturnValue
    @NullableDecl
    <T extends B> T putInstance(Class<T> cls, @NullableDecl T t);
}
