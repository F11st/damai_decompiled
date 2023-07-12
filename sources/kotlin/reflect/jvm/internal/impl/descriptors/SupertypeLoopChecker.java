package kotlin.reflect.jvm.internal.impl.descriptors;

import java.util.Collection;
import kotlin.jvm.functions.Function1;
import kotlin.reflect.jvm.internal.impl.types.TypeConstructor;
import org.jetbrains.annotations.NotNull;
import tb.b41;
import tb.wt2;
import tb.z71;

/* compiled from: Taobao */
/* loaded from: classes3.dex */
public interface SupertypeLoopChecker {

    /* compiled from: Taobao */
    /* loaded from: classes3.dex */
    public static final class a implements SupertypeLoopChecker {
        @NotNull
        public static final a INSTANCE = new a();

        private a() {
        }

        /* JADX WARN: Multi-variable type inference failed */
        @Override // kotlin.reflect.jvm.internal.impl.descriptors.SupertypeLoopChecker
        @NotNull
        public Collection<z71> findLoopsInSupertypesAndDisconnect(@NotNull TypeConstructor typeConstructor, @NotNull Collection<? extends z71> collection, @NotNull Function1<? super TypeConstructor, ? extends Iterable<? extends z71>> function1, @NotNull Function1<? super z71, wt2> function12) {
            b41.i(typeConstructor, "currentTypeConstructor");
            b41.i(collection, "superTypes");
            b41.i(function1, "neighbors");
            b41.i(function12, "reportLoop");
            return collection;
        }
    }

    @NotNull
    Collection<z71> findLoopsInSupertypesAndDisconnect(@NotNull TypeConstructor typeConstructor, @NotNull Collection<? extends z71> collection, @NotNull Function1<? super TypeConstructor, ? extends Iterable<? extends z71>> function1, @NotNull Function1<? super z71, wt2> function12);
}
