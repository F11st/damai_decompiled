package kotlin.reflect.jvm.internal.impl.load.java;

import kotlin.reflect.jvm.internal.impl.load.java.descriptors.JavaClassDescriptor;
import org.jetbrains.annotations.NotNull;
import tb.b41;

/* compiled from: Taobao */
/* loaded from: classes3.dex */
public interface JavaClassesTracker {

    /* compiled from: Taobao */
    /* loaded from: classes3.dex */
    public static final class a implements JavaClassesTracker {
        @NotNull
        public static final a INSTANCE = new a();

        private a() {
        }

        @Override // kotlin.reflect.jvm.internal.impl.load.java.JavaClassesTracker
        public void reportClass(@NotNull JavaClassDescriptor javaClassDescriptor) {
            b41.i(javaClassDescriptor, "classDescriptor");
        }
    }

    void reportClass(@NotNull JavaClassDescriptor javaClassDescriptor);
}
