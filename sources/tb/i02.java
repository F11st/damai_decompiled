package tb;

import java.lang.reflect.Field;
import java.lang.reflect.Type;
import kotlin.reflect.jvm.internal.impl.load.java.structure.JavaField;
import org.jetbrains.annotations.NotNull;
import tb.o02;

/* compiled from: Taobao */
/* loaded from: classes3.dex */
public final class i02 extends k02 implements JavaField {
    @NotNull
    private final Field a;

    public i02(@NotNull Field field) {
        b41.i(field, "member");
        this.a = field;
    }

    @Override // tb.k02
    @NotNull
    /* renamed from: f */
    public Field d() {
        return this.a;
    }

    @Override // kotlin.reflect.jvm.internal.impl.load.java.structure.JavaField
    @NotNull
    /* renamed from: g */
    public o02 getType() {
        o02.C9490a c9490a = o02.Factory;
        Type genericType = d().getGenericType();
        b41.h(genericType, "member.genericType");
        return c9490a.a(genericType);
    }

    @Override // kotlin.reflect.jvm.internal.impl.load.java.structure.JavaField
    public boolean getHasConstantNotNullInitializer() {
        return false;
    }

    @Override // kotlin.reflect.jvm.internal.impl.load.java.structure.JavaField
    public boolean isEnumEntry() {
        return d().isEnumConstant();
    }
}
