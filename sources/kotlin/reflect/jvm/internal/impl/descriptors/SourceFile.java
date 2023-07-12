package kotlin.reflect.jvm.internal.impl.descriptors;

import org.jetbrains.annotations.Nullable;

/* compiled from: Taobao */
/* loaded from: classes3.dex */
public interface SourceFile {
    public static final SourceFile NO_SOURCE_FILE = new C8297a();

    /* compiled from: Taobao */
    /* renamed from: kotlin.reflect.jvm.internal.impl.descriptors.SourceFile$a */
    /* loaded from: classes3.dex */
    static class C8297a implements SourceFile {
        C8297a() {
        }

        @Override // kotlin.reflect.jvm.internal.impl.descriptors.SourceFile
        @Nullable
        public String getName() {
            return null;
        }
    }

    @Nullable
    String getName();
}
