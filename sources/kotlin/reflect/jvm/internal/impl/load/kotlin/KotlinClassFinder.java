package kotlin.reflect.jvm.internal.impl.load.kotlin;

import kotlin.reflect.jvm.internal.impl.load.java.structure.JavaClass;
import kotlin.reflect.jvm.internal.impl.serialization.deserialization.KotlinMetadataFinder;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import tb.b41;
import tb.hj;
import tb.k50;

/* compiled from: Taobao */
/* loaded from: classes3.dex */
public interface KotlinClassFinder extends KotlinMetadataFinder {

    /* compiled from: Taobao */
    /* renamed from: kotlin.reflect.jvm.internal.impl.load.kotlin.KotlinClassFinder$a */
    /* loaded from: classes3.dex */
    public static abstract class AbstractC8373a {

        /* compiled from: Taobao */
        /* renamed from: kotlin.reflect.jvm.internal.impl.load.kotlin.KotlinClassFinder$a$a */
        /* loaded from: classes3.dex */
        public static final class C8374a extends AbstractC8373a {
            @NotNull
            private final byte[] a;

            @NotNull
            public final byte[] b() {
                return this.a;
            }
        }

        /* compiled from: Taobao */
        /* renamed from: kotlin.reflect.jvm.internal.impl.load.kotlin.KotlinClassFinder$a$b */
        /* loaded from: classes3.dex */
        public static final class C8375b extends AbstractC8373a {
            @NotNull
            private final KotlinJvmBinaryClass a;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public C8375b(@NotNull KotlinJvmBinaryClass kotlinJvmBinaryClass, @Nullable byte[] bArr) {
                super(null);
                b41.i(kotlinJvmBinaryClass, "kotlinJvmBinaryClass");
                this.a = kotlinJvmBinaryClass;
            }

            @NotNull
            public final KotlinJvmBinaryClass b() {
                return this.a;
            }

            public /* synthetic */ C8375b(KotlinJvmBinaryClass kotlinJvmBinaryClass, byte[] bArr, int i, k50 k50Var) {
                this(kotlinJvmBinaryClass, (i & 2) != 0 ? null : bArr);
            }
        }

        private AbstractC8373a() {
        }

        public /* synthetic */ AbstractC8373a(k50 k50Var) {
            this();
        }

        @Nullable
        public final KotlinJvmBinaryClass a() {
            C8375b c8375b = this instanceof C8375b ? (C8375b) this : null;
            if (c8375b == null) {
                return null;
            }
            return c8375b.b();
        }
    }

    @Nullable
    AbstractC8373a findKotlinClassOrContent(@NotNull JavaClass javaClass);

    @Nullable
    AbstractC8373a findKotlinClassOrContent(@NotNull hj hjVar);
}
