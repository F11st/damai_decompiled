package kotlin.reflect.jvm.internal.impl.serialization.deserialization;

import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import tb.fd2;

/* compiled from: Taobao */
/* loaded from: classes3.dex */
public interface LocalClassifierTypeSettings {

    /* compiled from: Taobao */
    /* loaded from: classes3.dex */
    public static final class a implements LocalClassifierTypeSettings {
        @NotNull
        public static final a INSTANCE = new a();

        private a() {
        }

        @Override // kotlin.reflect.jvm.internal.impl.serialization.deserialization.LocalClassifierTypeSettings
        @Nullable
        public fd2 getReplacementTypeForLocalClassifiers() {
            return null;
        }
    }

    @Nullable
    fd2 getReplacementTypeForLocalClassifiers();
}
