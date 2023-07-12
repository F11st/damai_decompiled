package tb;

import java.util.ArrayList;
import java.util.List;
import kotlin.jvm.JvmName;
import kotlin.reflect.KClass;
import kotlin.reflect.KClassifier;
import kotlin.reflect.KType;
import org.jetbrains.annotations.NotNull;

/* compiled from: Taobao */
@JvmName(name = "KClasses")
/* loaded from: classes3.dex */
public final class h71 {
    @NotNull
    public static final List<KClass<?>> a(@NotNull KClass<?> kClass) {
        b41.i(kClass, "$this$superclasses");
        List<KType> supertypes = kClass.getSupertypes();
        ArrayList arrayList = new ArrayList();
        for (KType kType : supertypes) {
            KClassifier classifier = kType.getClassifier();
            if (!(classifier instanceof KClass)) {
                classifier = null;
            }
            KClass kClass2 = (KClass) classifier;
            if (kClass2 != null) {
                arrayList.add(kClass2);
            }
        }
        return arrayList;
    }
}
