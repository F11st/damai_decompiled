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
    /* loaded from: classes3.dex */
    public static abstract class a {

        /* compiled from: Taobao */
        /* renamed from: kotlin.reflect.jvm.internal.impl.load.kotlin.KotlinClassFinder$a$a  reason: collision with other inner class name */
        /* loaded from: classes3.dex */
        public static final class C0420a extends a {
            @NotNull
            private final byte[] a;

            @NotNull
            public final byte[] b() {
                return this.a;
            }
        }

        /* compiled from: Taobao */
        /* loaded from: classes3.dex */
        public static final class b extends a {
            @NotNull
            private final KotlinJvmBinaryClass a;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public b(@NotNull KotlinJvmBinaryClass kotlinJvmBinaryClass, @Nullable byte[] bArr) {
                super(null);
                b41.i(kotlinJvmBinaryClass, "kotlinJvmBinaryClass");
                this.a = kotlinJvmBinaryClass;
            }

            @NotNull
            public final KotlinJvmBinaryClass b() {
                return this.a;
            }

            public /* synthetic */ b(KotlinJvmBinaryClass kotlinJvmBinaryClass, byte[] bArr, int i, k50 k50Var) {
                this(kotlinJvmBinaryClass, (i & 2) != 0 ? null : bArr);
            }
        }

        private a() {
        }

        public /* synthetic */ a(k50 k50Var) {
            this();
        }

        @Nullable
        public final KotlinJvmBinaryClass a() {
            b bVar = this instanceof b ? (b) this : null;
            if (bVar == null) {
                return null;
            }
            return bVar.b();
        }
    }

    @Nullable
    a findKotlinClassOrContent(@NotNull JavaClass javaClass);

    @Nullable
    a findKotlinClassOrContent(@NotNull hj hjVar);
}
