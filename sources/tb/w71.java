package tb;

import kotlin.reflect.jvm.internal.impl.load.java.structure.JavaClass;
import kotlin.reflect.jvm.internal.impl.load.kotlin.KotlinClassFinder;
import kotlin.reflect.jvm.internal.impl.load.kotlin.KotlinJvmBinaryClass;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: Taobao */
/* loaded from: classes3.dex */
public final class w71 {
    @Nullable
    public static final KotlinJvmBinaryClass a(@NotNull KotlinClassFinder kotlinClassFinder, @NotNull JavaClass javaClass) {
        b41.i(kotlinClassFinder, "<this>");
        b41.i(javaClass, "javaClass");
        KotlinClassFinder.a findKotlinClassOrContent = kotlinClassFinder.findKotlinClassOrContent(javaClass);
        if (findKotlinClassOrContent == null) {
            return null;
        }
        return findKotlinClassOrContent.a();
    }

    @Nullable
    public static final KotlinJvmBinaryClass b(@NotNull KotlinClassFinder kotlinClassFinder, @NotNull hj hjVar) {
        b41.i(kotlinClassFinder, "<this>");
        b41.i(hjVar, "classId");
        KotlinClassFinder.a findKotlinClassOrContent = kotlinClassFinder.findKotlinClassOrContent(hjVar);
        if (findKotlinClassOrContent == null) {
            return null;
        }
        return findKotlinClassOrContent.a();
    }
}
