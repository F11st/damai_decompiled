package kotlin.reflect.jvm.internal.impl.descriptors.runtime.structure;

import java.lang.reflect.Modifier;
import kotlin.reflect.jvm.internal.impl.load.java.structure.JavaModifierListOwner;
import org.jetbrains.annotations.NotNull;
import tb.b41;
import tb.ty2;
import tb.uy2;
import tb.w51;
import tb.x51;
import tb.y51;

/* compiled from: Taobao */
/* loaded from: classes3.dex */
public interface ReflectJavaModifierListOwner extends JavaModifierListOwner {

    /* compiled from: Taobao */
    /* renamed from: kotlin.reflect.jvm.internal.impl.descriptors.runtime.structure.ReflectJavaModifierListOwner$a */
    /* loaded from: classes3.dex */
    public static final class C8323a {
        @NotNull
        public static uy2 a(@NotNull ReflectJavaModifierListOwner reflectJavaModifierListOwner) {
            b41.i(reflectJavaModifierListOwner, "this");
            int modifiers = reflectJavaModifierListOwner.getModifiers();
            if (Modifier.isPublic(modifiers)) {
                return ty2.C9744h.INSTANCE;
            }
            if (Modifier.isPrivate(modifiers)) {
                return ty2.C9741e.INSTANCE;
            }
            if (Modifier.isProtected(modifiers)) {
                return Modifier.isStatic(modifiers) ? y51.INSTANCE : x51.INSTANCE;
            }
            return w51.INSTANCE;
        }

        public static boolean b(@NotNull ReflectJavaModifierListOwner reflectJavaModifierListOwner) {
            b41.i(reflectJavaModifierListOwner, "this");
            return Modifier.isAbstract(reflectJavaModifierListOwner.getModifiers());
        }

        public static boolean c(@NotNull ReflectJavaModifierListOwner reflectJavaModifierListOwner) {
            b41.i(reflectJavaModifierListOwner, "this");
            return Modifier.isFinal(reflectJavaModifierListOwner.getModifiers());
        }

        public static boolean d(@NotNull ReflectJavaModifierListOwner reflectJavaModifierListOwner) {
            b41.i(reflectJavaModifierListOwner, "this");
            return Modifier.isStatic(reflectJavaModifierListOwner.getModifiers());
        }
    }

    int getModifiers();
}
