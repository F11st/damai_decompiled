package tb;

import java.util.Comparator;
import kotlin.reflect.jvm.internal.impl.descriptors.ClassDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.ConstructorDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.DeclarationDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.FunctionDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.PropertyDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.TypeAliasDescriptor;
import org.jetbrains.annotations.Nullable;

/* compiled from: Taobao */
/* loaded from: classes3.dex */
public class ge1 implements Comparator<DeclarationDescriptor> {
    public static final ge1 INSTANCE = new ge1();

    private ge1() {
    }

    @Nullable
    private static Integer b(DeclarationDescriptor declarationDescriptor, DeclarationDescriptor declarationDescriptor2) {
        int c = c(declarationDescriptor2) - c(declarationDescriptor);
        if (c != 0) {
            return Integer.valueOf(c);
        }
        if (d70.B(declarationDescriptor) && d70.B(declarationDescriptor2)) {
            return 0;
        }
        int compareTo = declarationDescriptor.getName().compareTo(declarationDescriptor2.getName());
        if (compareTo != 0) {
            return Integer.valueOf(compareTo);
        }
        return null;
    }

    private static int c(DeclarationDescriptor declarationDescriptor) {
        if (d70.B(declarationDescriptor)) {
            return 8;
        }
        if (declarationDescriptor instanceof ConstructorDescriptor) {
            return 7;
        }
        if (declarationDescriptor instanceof PropertyDescriptor) {
            return ((PropertyDescriptor) declarationDescriptor).getExtensionReceiverParameter() == null ? 6 : 5;
        } else if (declarationDescriptor instanceof FunctionDescriptor) {
            return ((FunctionDescriptor) declarationDescriptor).getExtensionReceiverParameter() == null ? 4 : 3;
        } else if (declarationDescriptor instanceof ClassDescriptor) {
            return 2;
        } else {
            return declarationDescriptor instanceof TypeAliasDescriptor ? 1 : 0;
        }
    }

    @Override // java.util.Comparator
    /* renamed from: a */
    public int compare(DeclarationDescriptor declarationDescriptor, DeclarationDescriptor declarationDescriptor2) {
        Integer b = b(declarationDescriptor, declarationDescriptor2);
        if (b != null) {
            return b.intValue();
        }
        return 0;
    }
}
