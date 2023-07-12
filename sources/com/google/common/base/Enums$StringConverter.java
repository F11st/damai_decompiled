package com.google.common.base;

import java.io.Serializable;
import java.lang.Enum;
import org.checkerframework.checker.nullness.compatqual.NullableDecl;
import tb.du1;

/* compiled from: Taobao */
/* loaded from: classes10.dex */
final class Enums$StringConverter<T extends Enum<T>> extends Converter<String, T> implements Serializable {
    private static final long serialVersionUID = 0;
    private final Class<T> enumClass;

    Enums$StringConverter(Class<T> cls) {
        this.enumClass = (Class) du1.p(cls);
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.google.common.base.Converter
    protected /* bridge */ /* synthetic */ String doBackward(Object obj) {
        return doBackward((Enums$StringConverter<T>) ((Enum) obj));
    }

    @Override // com.google.common.base.Converter, com.google.common.base.Function
    public boolean equals(@NullableDecl Object obj) {
        if (obj instanceof Enums$StringConverter) {
            return this.enumClass.equals(((Enums$StringConverter) obj).enumClass);
        }
        return false;
    }

    public int hashCode() {
        return this.enumClass.hashCode();
    }

    public String toString() {
        return "Enums.stringConverter(" + this.enumClass.getName() + ".class)";
    }

    protected String doBackward(T t) {
        return t.name();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.google.common.base.Converter
    public T doForward(String str) {
        return (T) Enum.valueOf(this.enumClass, str);
    }
}
