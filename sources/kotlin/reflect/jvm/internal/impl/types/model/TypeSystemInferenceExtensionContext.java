package kotlin.reflect.jvm.internal.impl.types.model;

import com.tencent.open.SocialConstants;
import java.util.List;
import kotlin.reflect.jvm.internal.impl.types.model.TypeSystemContext;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import tb.b41;

/* compiled from: Taobao */
/* loaded from: classes3.dex */
public interface TypeSystemInferenceExtensionContext extends TypeSystemCommonSuperTypesContext, TypeSystemContext {

    /* compiled from: Taobao */
    /* loaded from: classes3.dex */
    public static final class a {
        @Nullable
        public static List<SimpleTypeMarker> a(@NotNull TypeSystemInferenceExtensionContext typeSystemInferenceExtensionContext, @NotNull SimpleTypeMarker simpleTypeMarker, @NotNull TypeConstructorMarker typeConstructorMarker) {
            b41.i(typeSystemInferenceExtensionContext, "this");
            b41.i(simpleTypeMarker, SocialConstants.PARAM_RECEIVER);
            b41.i(typeConstructorMarker, "constructor");
            return TypeSystemContext.a.a(typeSystemInferenceExtensionContext, simpleTypeMarker, typeConstructorMarker);
        }

        @NotNull
        public static TypeArgumentMarker b(@NotNull TypeSystemInferenceExtensionContext typeSystemInferenceExtensionContext, @NotNull TypeArgumentListMarker typeArgumentListMarker, int i) {
            b41.i(typeSystemInferenceExtensionContext, "this");
            b41.i(typeArgumentListMarker, SocialConstants.PARAM_RECEIVER);
            return TypeSystemContext.a.b(typeSystemInferenceExtensionContext, typeArgumentListMarker, i);
        }

        @Nullable
        public static TypeArgumentMarker c(@NotNull TypeSystemInferenceExtensionContext typeSystemInferenceExtensionContext, @NotNull SimpleTypeMarker simpleTypeMarker, int i) {
            b41.i(typeSystemInferenceExtensionContext, "this");
            b41.i(simpleTypeMarker, SocialConstants.PARAM_RECEIVER);
            return TypeSystemContext.a.c(typeSystemInferenceExtensionContext, simpleTypeMarker, i);
        }

        public static boolean d(@NotNull TypeSystemInferenceExtensionContext typeSystemInferenceExtensionContext, @NotNull KotlinTypeMarker kotlinTypeMarker) {
            b41.i(typeSystemInferenceExtensionContext, "this");
            b41.i(kotlinTypeMarker, SocialConstants.PARAM_RECEIVER);
            return TypeSystemContext.a.d(typeSystemInferenceExtensionContext, kotlinTypeMarker);
        }

        public static boolean e(@NotNull TypeSystemInferenceExtensionContext typeSystemInferenceExtensionContext, @NotNull KotlinTypeMarker kotlinTypeMarker) {
            b41.i(typeSystemInferenceExtensionContext, "this");
            b41.i(kotlinTypeMarker, SocialConstants.PARAM_RECEIVER);
            return TypeSystemContext.a.e(typeSystemInferenceExtensionContext, kotlinTypeMarker);
        }

        public static boolean f(@NotNull TypeSystemInferenceExtensionContext typeSystemInferenceExtensionContext, @NotNull SimpleTypeMarker simpleTypeMarker) {
            b41.i(typeSystemInferenceExtensionContext, "this");
            b41.i(simpleTypeMarker, SocialConstants.PARAM_RECEIVER);
            return TypeSystemContext.a.f(typeSystemInferenceExtensionContext, simpleTypeMarker);
        }

        public static boolean g(@NotNull TypeSystemInferenceExtensionContext typeSystemInferenceExtensionContext, @NotNull KotlinTypeMarker kotlinTypeMarker) {
            b41.i(typeSystemInferenceExtensionContext, "this");
            b41.i(kotlinTypeMarker, SocialConstants.PARAM_RECEIVER);
            return TypeSystemContext.a.g(typeSystemInferenceExtensionContext, kotlinTypeMarker);
        }

        public static boolean h(@NotNull TypeSystemInferenceExtensionContext typeSystemInferenceExtensionContext, @NotNull KotlinTypeMarker kotlinTypeMarker) {
            b41.i(typeSystemInferenceExtensionContext, "this");
            b41.i(kotlinTypeMarker, SocialConstants.PARAM_RECEIVER);
            return TypeSystemContext.a.h(typeSystemInferenceExtensionContext, kotlinTypeMarker);
        }

        public static boolean i(@NotNull TypeSystemInferenceExtensionContext typeSystemInferenceExtensionContext, @NotNull SimpleTypeMarker simpleTypeMarker) {
            b41.i(typeSystemInferenceExtensionContext, "this");
            b41.i(simpleTypeMarker, SocialConstants.PARAM_RECEIVER);
            return TypeSystemContext.a.i(typeSystemInferenceExtensionContext, simpleTypeMarker);
        }

        public static boolean j(@NotNull TypeSystemInferenceExtensionContext typeSystemInferenceExtensionContext, @NotNull KotlinTypeMarker kotlinTypeMarker) {
            b41.i(typeSystemInferenceExtensionContext, "this");
            b41.i(kotlinTypeMarker, SocialConstants.PARAM_RECEIVER);
            return TypeSystemContext.a.j(typeSystemInferenceExtensionContext, kotlinTypeMarker);
        }

        public static boolean k(@NotNull TypeSystemInferenceExtensionContext typeSystemInferenceExtensionContext, @NotNull KotlinTypeMarker kotlinTypeMarker) {
            b41.i(typeSystemInferenceExtensionContext, "this");
            b41.i(kotlinTypeMarker, SocialConstants.PARAM_RECEIVER);
            return TypeSystemContext.a.k(typeSystemInferenceExtensionContext, kotlinTypeMarker);
        }

        @NotNull
        public static SimpleTypeMarker l(@NotNull TypeSystemInferenceExtensionContext typeSystemInferenceExtensionContext, @NotNull KotlinTypeMarker kotlinTypeMarker) {
            b41.i(typeSystemInferenceExtensionContext, "this");
            b41.i(kotlinTypeMarker, SocialConstants.PARAM_RECEIVER);
            return TypeSystemContext.a.l(typeSystemInferenceExtensionContext, kotlinTypeMarker);
        }

        public static int m(@NotNull TypeSystemInferenceExtensionContext typeSystemInferenceExtensionContext, @NotNull TypeArgumentListMarker typeArgumentListMarker) {
            b41.i(typeSystemInferenceExtensionContext, "this");
            b41.i(typeArgumentListMarker, SocialConstants.PARAM_RECEIVER);
            return TypeSystemContext.a.m(typeSystemInferenceExtensionContext, typeArgumentListMarker);
        }

        @NotNull
        public static TypeConstructorMarker n(@NotNull TypeSystemInferenceExtensionContext typeSystemInferenceExtensionContext, @NotNull KotlinTypeMarker kotlinTypeMarker) {
            b41.i(typeSystemInferenceExtensionContext, "this");
            b41.i(kotlinTypeMarker, SocialConstants.PARAM_RECEIVER);
            return TypeSystemContext.a.n(typeSystemInferenceExtensionContext, kotlinTypeMarker);
        }

        @NotNull
        public static SimpleTypeMarker o(@NotNull TypeSystemInferenceExtensionContext typeSystemInferenceExtensionContext, @NotNull KotlinTypeMarker kotlinTypeMarker) {
            b41.i(typeSystemInferenceExtensionContext, "this");
            b41.i(kotlinTypeMarker, SocialConstants.PARAM_RECEIVER);
            return TypeSystemContext.a.o(typeSystemInferenceExtensionContext, kotlinTypeMarker);
        }
    }
}
