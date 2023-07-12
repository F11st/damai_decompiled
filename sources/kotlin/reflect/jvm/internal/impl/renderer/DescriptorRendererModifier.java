package kotlin.reflect.jvm.internal.impl.renderer;

import java.util.ArrayList;
import java.util.Set;
import kotlin.collections.ArraysKt___ArraysKt;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.jvm.JvmField;
import org.jetbrains.annotations.NotNull;
import tb.k50;

/* compiled from: Taobao */
/* loaded from: classes3.dex */
public enum DescriptorRendererModifier {
    VISIBILITY(true),
    MODALITY(true),
    OVERRIDE(true),
    ANNOTATIONS(false),
    INNER(true),
    MEMBER_KIND(true),
    DATA(true),
    INLINE(true),
    EXPECT(true),
    ACTUAL(true),
    CONST(true),
    LATEINIT(true),
    FUN(true),
    VALUE(true);
    
    @JvmField
    @NotNull
    public static final Set<DescriptorRendererModifier> ALL;
    @JvmField
    @NotNull
    public static final Set<DescriptorRendererModifier> ALL_EXCEPT_ANNOTATIONS;
    @NotNull
    public static final C8480a Companion = new C8480a(null);
    private final boolean includeByDefault;

    /* compiled from: Taobao */
    /* renamed from: kotlin.reflect.jvm.internal.impl.renderer.DescriptorRendererModifier$a */
    /* loaded from: classes3.dex */
    public static final class C8480a {
        private C8480a() {
        }

        public /* synthetic */ C8480a(k50 k50Var) {
            this();
        }
    }

    static {
        Set<DescriptorRendererModifier> E0;
        Set<DescriptorRendererModifier> j0;
        DescriptorRendererModifier[] values = values();
        ArrayList arrayList = new ArrayList();
        for (DescriptorRendererModifier descriptorRendererModifier : values) {
            if (descriptorRendererModifier.getIncludeByDefault()) {
                arrayList.add(descriptorRendererModifier);
            }
        }
        E0 = CollectionsKt___CollectionsKt.E0(arrayList);
        ALL_EXCEPT_ANNOTATIONS = E0;
        j0 = ArraysKt___ArraysKt.j0(values());
        ALL = j0;
    }

    DescriptorRendererModifier(boolean z) {
        this.includeByDefault = z;
    }

    public final boolean getIncludeByDefault() {
        return this.includeByDefault;
    }
}
