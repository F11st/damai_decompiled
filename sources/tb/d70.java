package tb;

import cn.damai.common.app.ShareperfenceConstants;
import java.util.Collection;
import java.util.LinkedHashSet;
import java.util.Set;
import kotlin.reflect.jvm.internal.impl.builtins.AbstractC8271b;
import kotlin.reflect.jvm.internal.impl.descriptors.CallableDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.CallableMemberDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.ClassDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.ClassKind;
import kotlin.reflect.jvm.internal.impl.descriptors.ClassifierDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.DeclarationDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.DeclarationDescriptorWithSource;
import kotlin.reflect.jvm.internal.impl.descriptors.DeclarationDescriptorWithVisibility;
import kotlin.reflect.jvm.internal.impl.descriptors.Modality;
import kotlin.reflect.jvm.internal.impl.descriptors.ModuleDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.PackageFragmentDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.PackageViewDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.PropertySetterDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.ReceiverParameterDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.SourceFile;
import kotlin.reflect.jvm.internal.impl.descriptors.VariableDescriptor;
import kotlin.reflect.jvm.internal.impl.resolve.descriptorUtil.DescriptorUtilsKt;
import kotlin.reflect.jvm.internal.impl.types.TypeConstructor;
import kotlin.reflect.jvm.internal.impl.types.checker.KotlinTypeChecker;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: Taobao */
/* loaded from: classes3.dex */
public class d70 {
    public static final hp0 JVM_NAME = new hp0("kotlin.jvm.JvmName");

    public static boolean A(@Nullable DeclarationDescriptor declarationDescriptor) {
        return D(declarationDescriptor, ClassKind.ENUM_CLASS);
    }

    public static boolean B(@NotNull DeclarationDescriptor declarationDescriptor) {
        if (declarationDescriptor == null) {
            a(36);
        }
        return D(declarationDescriptor, ClassKind.ENUM_ENTRY);
    }

    public static boolean C(@Nullable DeclarationDescriptor declarationDescriptor) {
        return D(declarationDescriptor, ClassKind.INTERFACE);
    }

    private static boolean D(@Nullable DeclarationDescriptor declarationDescriptor, @NotNull ClassKind classKind) {
        if (classKind == null) {
            a(37);
        }
        return (declarationDescriptor instanceof ClassDescriptor) && ((ClassDescriptor) declarationDescriptor).getKind() == classKind;
    }

    public static boolean E(@NotNull DeclarationDescriptor declarationDescriptor) {
        if (declarationDescriptor == null) {
            a(1);
        }
        while (declarationDescriptor != null) {
            if (u(declarationDescriptor) || y(declarationDescriptor)) {
                return true;
            }
            declarationDescriptor = declarationDescriptor.getContainingDeclaration();
        }
        return false;
    }

    private static boolean F(@NotNull z71 z71Var, @NotNull DeclarationDescriptor declarationDescriptor) {
        if (z71Var == null) {
            a(30);
        }
        if (declarationDescriptor == null) {
            a(31);
        }
        ClassifierDescriptor declarationDescriptor2 = z71Var.c().getDeclarationDescriptor();
        if (declarationDescriptor2 != null) {
            DeclarationDescriptor original = declarationDescriptor2.getOriginal();
            return (original instanceof ClassifierDescriptor) && (declarationDescriptor instanceof ClassifierDescriptor) && ((ClassifierDescriptor) declarationDescriptor).getTypeConstructor().equals(((ClassifierDescriptor) original).getTypeConstructor());
        }
        return false;
    }

    public static boolean G(@Nullable DeclarationDescriptor declarationDescriptor) {
        return (D(declarationDescriptor, ClassKind.CLASS) || D(declarationDescriptor, ClassKind.INTERFACE)) && ((ClassDescriptor) declarationDescriptor).getModality() == Modality.SEALED;
    }

    public static boolean H(@NotNull ClassDescriptor classDescriptor, @NotNull ClassDescriptor classDescriptor2) {
        if (classDescriptor == null) {
            a(28);
        }
        if (classDescriptor2 == null) {
            a(29);
        }
        return I(classDescriptor.getDefaultType(), classDescriptor2.getOriginal());
    }

    public static boolean I(@NotNull z71 z71Var, @NotNull DeclarationDescriptor declarationDescriptor) {
        if (z71Var == null) {
            a(32);
        }
        if (declarationDescriptor == null) {
            a(33);
        }
        if (F(z71Var, declarationDescriptor)) {
            return true;
        }
        for (z71 z71Var2 : z71Var.c().getSupertypes()) {
            if (I(z71Var2, declarationDescriptor)) {
                return true;
            }
        }
        return false;
    }

    public static boolean J(@Nullable DeclarationDescriptor declarationDescriptor) {
        return declarationDescriptor != null && (declarationDescriptor.getContainingDeclaration() instanceof PackageFragmentDescriptor);
    }

    public static boolean K(@NotNull VariableDescriptor variableDescriptor, @NotNull z71 z71Var) {
        if (variableDescriptor == null) {
            a(63);
        }
        if (z71Var == null) {
            a(64);
        }
        if (variableDescriptor.isVar() || a81.a(z71Var)) {
            return false;
        }
        if (fr2.b(z71Var)) {
            return true;
        }
        AbstractC8271b g = DescriptorUtilsKt.g(variableDescriptor);
        if (!AbstractC8271b.q0(z71Var)) {
            KotlinTypeChecker kotlinTypeChecker = KotlinTypeChecker.DEFAULT;
            if (!kotlinTypeChecker.equalTypes(g.W(), z71Var) && !kotlinTypeChecker.equalTypes(g.K().getDefaultType(), z71Var) && !kotlinTypeChecker.equalTypes(g.i(), z71Var)) {
                eu2 eu2Var = eu2.INSTANCE;
                if (!eu2.d(z71Var)) {
                    return false;
                }
            }
        }
        return true;
    }

    @NotNull
    public static <D extends CallableMemberDescriptor> D L(@NotNull D d) {
        if (d == null) {
            a(59);
        }
        while (d.getKind() == CallableMemberDescriptor.Kind.FAKE_OVERRIDE) {
            Collection<? extends CallableMemberDescriptor> overriddenDescriptors = d.getOverriddenDescriptors();
            if (!overriddenDescriptors.isEmpty()) {
                d = (D) overriddenDescriptors.iterator().next();
            } else {
                throw new IllegalStateException("Fake override should have at least one overridden descriptor: " + d);
            }
        }
        return d;
    }

    @NotNull
    public static <D extends DeclarationDescriptorWithVisibility> D M(@NotNull D d) {
        if (d == null) {
            a(61);
        }
        if (d instanceof CallableMemberDescriptor) {
            return L((CallableMemberDescriptor) d);
        }
        if (d == null) {
            a(62);
        }
        return d;
    }

    private static /* synthetic */ void a(int i) {
        String str;
        int i2;
        switch (i) {
            case 4:
            case 7:
            case 9:
            case 10:
            case 12:
            case 22:
            case 40:
            case 42:
            case 43:
            case 47:
            case 49:
            case 50:
            case 51:
            case 52:
            case 53:
            case 60:
            case 62:
            case 69:
            case 73:
            case 80:
            case 81:
            case 83:
            case 86:
            case 91:
            case 93:
                str = "@NotNull method %s.%s must not return null";
                break;
            default:
                str = "Argument for @NotNull parameter '%s' of %s.%s must not be null";
                break;
        }
        switch (i) {
            case 4:
            case 7:
            case 9:
            case 10:
            case 12:
            case 22:
            case 40:
            case 42:
            case 43:
            case 47:
            case 49:
            case 50:
            case 51:
            case 52:
            case 53:
            case 60:
            case 62:
            case 69:
            case 73:
            case 80:
            case 81:
            case 83:
            case 86:
            case 91:
            case 93:
                i2 = 2;
                break;
            default:
                i2 = 3;
                break;
        }
        Object[] objArr = new Object[i2];
        switch (i) {
            case 1:
            case 2:
            case 3:
            case 5:
            case 6:
            case 8:
            case 11:
            case 13:
            case 14:
            case 15:
            case 21:
            case 23:
            case 24:
            case 34:
            case 35:
            case 36:
            case 57:
            case 58:
            case 59:
            case 61:
            case 79:
            case 92:
            case 94:
                objArr[0] = "descriptor";
                break;
            case 4:
            case 7:
            case 9:
            case 10:
            case 12:
            case 22:
            case 40:
            case 42:
            case 43:
            case 47:
            case 49:
            case 50:
            case 51:
            case 52:
            case 53:
            case 60:
            case 62:
            case 69:
            case 73:
            case 80:
            case 81:
            case 83:
            case 86:
            case 91:
            case 93:
                objArr[0] = "kotlin/reflect/jvm/internal/impl/resolve/DescriptorUtils";
                break;
            case 16:
                objArr[0] = ShareperfenceConstants.FIRST;
                break;
            case 17:
                objArr[0] = "second";
                break;
            case 18:
            case 19:
                objArr[0] = "aClass";
                break;
            case 20:
                objArr[0] = "kotlinType";
                break;
            case 25:
                objArr[0] = "declarationDescriptor";
                break;
            case 26:
            case 28:
                objArr[0] = "subClass";
                break;
            case 27:
            case 29:
            case 33:
                objArr[0] = "superClass";
                break;
            case 30:
            case 32:
            case 45:
            case 64:
                objArr[0] = "type";
                break;
            case 31:
                objArr[0] = "other";
                break;
            case 37:
                objArr[0] = "classKind";
                break;
            case 38:
            case 39:
            case 41:
            case 44:
            case 48:
            case 54:
            case 65:
            case 66:
            case 67:
            case 74:
            case 75:
                objArr[0] = "classDescriptor";
                break;
            case 46:
                objArr[0] = "typeConstructor";
                break;
            case 55:
                objArr[0] = "innerClassName";
                break;
            case 56:
                objArr[0] = "location";
                break;
            case 63:
                objArr[0] = "variable";
                break;
            case 68:
                objArr[0] = "f";
                break;
            case 70:
                objArr[0] = "current";
                break;
            case 71:
                objArr[0] = "result";
                break;
            case 72:
                objArr[0] = "memberDescriptor";
                break;
            case 76:
            case 77:
            case 78:
                objArr[0] = "annotated";
                break;
            case 82:
            case 84:
            case 87:
            case 89:
                objArr[0] = "scope";
                break;
            case 85:
            case 88:
            case 90:
                objArr[0] = "name";
                break;
            default:
                objArr[0] = "containingDeclaration";
                break;
        }
        switch (i) {
            case 4:
                objArr[1] = "getFqNameSafe";
                break;
            case 7:
                objArr[1] = "getFqNameUnsafe";
                break;
            case 9:
            case 10:
                objArr[1] = "getFqNameFromTopLevelClass";
                break;
            case 12:
                objArr[1] = "getClassIdForNonLocalClass";
                break;
            case 22:
                objArr[1] = "getContainingModule";
                break;
            case 40:
                objArr[1] = "getSuperclassDescriptors";
                break;
            case 42:
            case 43:
                objArr[1] = "getSuperClassType";
                break;
            case 47:
                objArr[1] = "getClassDescriptorForTypeConstructor";
                break;
            case 49:
            case 50:
            case 51:
            case 52:
            case 53:
                objArr[1] = "getDefaultConstructorVisibility";
                break;
            case 60:
                objArr[1] = "unwrapFakeOverride";
                break;
            case 62:
                objArr[1] = "unwrapFakeOverrideToAnyDeclaration";
                break;
            case 69:
                objArr[1] = "getAllOverriddenDescriptors";
                break;
            case 73:
                objArr[1] = "getAllOverriddenDeclarations";
                break;
            case 80:
            case 81:
                objArr[1] = "getContainingSourceFile";
                break;
            case 83:
                objArr[1] = "getAllDescriptors";
                break;
            case 86:
                objArr[1] = "getFunctionByName";
                break;
            case 91:
                objArr[1] = "getPropertyByName";
                break;
            case 93:
                objArr[1] = "getDirectMember";
                break;
            default:
                objArr[1] = "kotlin/reflect/jvm/internal/impl/resolve/DescriptorUtils";
                break;
        }
        switch (i) {
            case 1:
                objArr[2] = "isLocal";
                break;
            case 2:
                objArr[2] = "getFqName";
                break;
            case 3:
                objArr[2] = "getFqNameSafe";
                break;
            case 4:
            case 7:
            case 9:
            case 10:
            case 12:
            case 22:
            case 40:
            case 42:
            case 43:
            case 47:
            case 49:
            case 50:
            case 51:
            case 52:
            case 53:
            case 60:
            case 62:
            case 69:
            case 73:
            case 80:
            case 81:
            case 83:
            case 86:
            case 91:
            case 93:
                break;
            case 5:
                objArr[2] = "getFqNameSafeIfPossible";
                break;
            case 6:
                objArr[2] = "getFqNameUnsafe";
                break;
            case 8:
                objArr[2] = "getFqNameFromTopLevelClass";
                break;
            case 11:
                objArr[2] = "getClassIdForNonLocalClass";
                break;
            case 13:
                objArr[2] = "isExtension";
                break;
            case 14:
                objArr[2] = "isOverride";
                break;
            case 15:
                objArr[2] = "isStaticDeclaration";
                break;
            case 16:
            case 17:
                objArr[2] = "areInSameModule";
                break;
            case 18:
            case 19:
                objArr[2] = "getParentOfType";
                break;
            case 20:
            case 23:
                objArr[2] = "getContainingModuleOrNull";
                break;
            case 21:
                objArr[2] = "getContainingModule";
                break;
            case 24:
                objArr[2] = "getContainingClass";
                break;
            case 25:
                objArr[2] = "isAncestor";
                break;
            case 26:
            case 27:
                objArr[2] = "isDirectSubclass";
                break;
            case 28:
            case 29:
                objArr[2] = "isSubclass";
                break;
            case 30:
            case 31:
                objArr[2] = "isSameClass";
                break;
            case 32:
            case 33:
                objArr[2] = "isSubtypeOfClass";
                break;
            case 34:
                objArr[2] = "isAnonymousObject";
                break;
            case 35:
                objArr[2] = "isAnonymousFunction";
                break;
            case 36:
                objArr[2] = "isEnumEntry";
                break;
            case 37:
                objArr[2] = "isKindOf";
                break;
            case 38:
                objArr[2] = "hasAbstractMembers";
                break;
            case 39:
                objArr[2] = "getSuperclassDescriptors";
                break;
            case 41:
                objArr[2] = "getSuperClassType";
                break;
            case 44:
                objArr[2] = "getSuperClassDescriptor";
                break;
            case 45:
                objArr[2] = "getClassDescriptorForType";
                break;
            case 46:
                objArr[2] = "getClassDescriptorForTypeConstructor";
                break;
            case 48:
                objArr[2] = "getDefaultConstructorVisibility";
                break;
            case 54:
            case 55:
            case 56:
                objArr[2] = "getInnerClassByName";
                break;
            case 57:
                objArr[2] = "isStaticNestedClass";
                break;
            case 58:
                objArr[2] = "isTopLevelOrInnerClass";
                break;
            case 59:
                objArr[2] = "unwrapFakeOverride";
                break;
            case 61:
                objArr[2] = "unwrapFakeOverrideToAnyDeclaration";
                break;
            case 63:
            case 64:
                objArr[2] = "shouldRecordInitializerForProperty";
                break;
            case 65:
                objArr[2] = "classCanHaveAbstractFakeOverride";
                break;
            case 66:
                objArr[2] = "classCanHaveAbstractDeclaration";
                break;
            case 67:
                objArr[2] = "classCanHaveOpenMembers";
                break;
            case 68:
                objArr[2] = "getAllOverriddenDescriptors";
                break;
            case 70:
            case 71:
                objArr[2] = "collectAllOverriddenDescriptors";
                break;
            case 72:
                objArr[2] = "getAllOverriddenDeclarations";
                break;
            case 74:
                objArr[2] = "isSingletonOrAnonymousObject";
                break;
            case 75:
                objArr[2] = "canHaveDeclaredConstructors";
                break;
            case 76:
                objArr[2] = "getJvmName";
                break;
            case 77:
                objArr[2] = "findJvmNameAnnotation";
                break;
            case 78:
                objArr[2] = "hasJvmNameAnnotation";
                break;
            case 79:
                objArr[2] = "getContainingSourceFile";
                break;
            case 82:
                objArr[2] = "getAllDescriptors";
                break;
            case 84:
            case 85:
                objArr[2] = "getFunctionByName";
                break;
            case 87:
            case 88:
                objArr[2] = "getFunctionByNameOrNull";
                break;
            case 89:
            case 90:
                objArr[2] = "getPropertyByName";
                break;
            case 92:
                objArr[2] = "getDirectMember";
                break;
            case 94:
                objArr[2] = "isMethodOfAny";
                break;
            default:
                objArr[2] = "getDispatchReceiverParameterIfNeeded";
                break;
        }
        String format = String.format(str, objArr);
        switch (i) {
            case 4:
            case 7:
            case 9:
            case 10:
            case 12:
            case 22:
            case 40:
            case 42:
            case 43:
            case 47:
            case 49:
            case 50:
            case 51:
            case 52:
            case 53:
            case 60:
            case 62:
            case 69:
            case 73:
            case 80:
            case 81:
            case 83:
            case 86:
            case 91:
            case 93:
                throw new IllegalStateException(format);
            default:
                throw new IllegalArgumentException(format);
        }
    }

    public static boolean b(@NotNull DeclarationDescriptor declarationDescriptor, @NotNull DeclarationDescriptor declarationDescriptor2) {
        if (declarationDescriptor == null) {
            a(16);
        }
        if (declarationDescriptor2 == null) {
            a(17);
        }
        return g(declarationDescriptor).equals(g(declarationDescriptor2));
    }

    /* JADX WARN: Multi-variable type inference failed */
    private static <D extends CallableDescriptor> void c(@NotNull D d, @NotNull Set<D> set) {
        if (d == null) {
            a(70);
        }
        if (set == 0) {
            a(71);
        }
        if (set.contains(d)) {
            return;
        }
        for (CallableDescriptor callableDescriptor : d.getOriginal().getOverriddenDescriptors()) {
            CallableDescriptor original = callableDescriptor.getOriginal();
            c(original, set);
            set.add(original);
        }
    }

    @NotNull
    public static <D extends CallableDescriptor> Set<D> d(@NotNull D d) {
        if (d == null) {
            a(68);
        }
        LinkedHashSet linkedHashSet = new LinkedHashSet();
        c(d.getOriginal(), linkedHashSet);
        return linkedHashSet;
    }

    @NotNull
    public static ClassDescriptor e(@NotNull z71 z71Var) {
        if (z71Var == null) {
            a(45);
        }
        return f(z71Var.c());
    }

    @NotNull
    public static ClassDescriptor f(@NotNull TypeConstructor typeConstructor) {
        if (typeConstructor == null) {
            a(46);
        }
        ClassDescriptor classDescriptor = (ClassDescriptor) typeConstructor.getDeclarationDescriptor();
        if (classDescriptor == null) {
            a(47);
        }
        return classDescriptor;
    }

    @NotNull
    public static ModuleDescriptor g(@NotNull DeclarationDescriptor declarationDescriptor) {
        if (declarationDescriptor == null) {
            a(21);
        }
        ModuleDescriptor h = h(declarationDescriptor);
        if (h == null) {
            a(22);
        }
        return h;
    }

    @Nullable
    public static ModuleDescriptor h(@NotNull DeclarationDescriptor declarationDescriptor) {
        if (declarationDescriptor == null) {
            a(23);
        }
        while (declarationDescriptor != null) {
            if (declarationDescriptor instanceof ModuleDescriptor) {
                return (ModuleDescriptor) declarationDescriptor;
            }
            if (declarationDescriptor instanceof PackageViewDescriptor) {
                return ((PackageViewDescriptor) declarationDescriptor).getModule();
            }
            declarationDescriptor = declarationDescriptor.getContainingDeclaration();
        }
        return null;
    }

    @Nullable
    public static ModuleDescriptor i(@NotNull z71 z71Var) {
        if (z71Var == null) {
            a(20);
        }
        ClassifierDescriptor declarationDescriptor = z71Var.c().getDeclarationDescriptor();
        if (declarationDescriptor == null) {
            return null;
        }
        return h(declarationDescriptor);
    }

    @NotNull
    public static SourceFile j(@NotNull DeclarationDescriptor declarationDescriptor) {
        if (declarationDescriptor == null) {
            a(79);
        }
        if (declarationDescriptor instanceof PropertySetterDescriptor) {
            declarationDescriptor = ((PropertySetterDescriptor) declarationDescriptor).getCorrespondingProperty();
        }
        if (declarationDescriptor instanceof DeclarationDescriptorWithSource) {
            SourceFile containingFile = ((DeclarationDescriptorWithSource) declarationDescriptor).getSource().getContainingFile();
            if (containingFile == null) {
                a(80);
            }
            return containingFile;
        }
        SourceFile sourceFile = SourceFile.NO_SOURCE_FILE;
        if (sourceFile == null) {
            a(81);
        }
        return sourceFile;
    }

    @NotNull
    public static f70 k(@NotNull ClassDescriptor classDescriptor, boolean z) {
        if (classDescriptor == null) {
            a(48);
        }
        ClassKind kind = classDescriptor.getKind();
        if (kind != ClassKind.ENUM_CLASS && !kind.isSingleton()) {
            if (G(classDescriptor)) {
                if (z) {
                    f70 f70Var = e70.PROTECTED;
                    if (f70Var == null) {
                        a(50);
                    }
                    return f70Var;
                }
                f70 f70Var2 = e70.PRIVATE;
                if (f70Var2 == null) {
                    a(51);
                }
                return f70Var2;
            } else if (u(classDescriptor)) {
                f70 f70Var3 = e70.DEFAULT_VISIBILITY;
                if (f70Var3 == null) {
                    a(52);
                }
                return f70Var3;
            } else {
                f70 f70Var4 = e70.PUBLIC;
                if (f70Var4 == null) {
                    a(53);
                }
                return f70Var4;
            }
        }
        f70 f70Var5 = e70.PRIVATE;
        if (f70Var5 == null) {
            a(49);
        }
        return f70Var5;
    }

    @Nullable
    public static ReceiverParameterDescriptor l(@NotNull DeclarationDescriptor declarationDescriptor) {
        if (declarationDescriptor == null) {
            a(0);
        }
        if (declarationDescriptor instanceof ClassDescriptor) {
            return ((ClassDescriptor) declarationDescriptor).getThisAsReceiverParameter();
        }
        return null;
    }

    @NotNull
    public static ip0 m(@NotNull DeclarationDescriptor declarationDescriptor) {
        if (declarationDescriptor == null) {
            a(2);
        }
        hp0 o = o(declarationDescriptor);
        return o != null ? o.j() : p(declarationDescriptor);
    }

    @NotNull
    public static hp0 n(@NotNull DeclarationDescriptor declarationDescriptor) {
        if (declarationDescriptor == null) {
            a(3);
        }
        hp0 o = o(declarationDescriptor);
        if (o == null) {
            o = p(declarationDescriptor).l();
        }
        if (o == null) {
            a(4);
        }
        return o;
    }

    @Nullable
    private static hp0 o(@NotNull DeclarationDescriptor declarationDescriptor) {
        if (declarationDescriptor == null) {
            a(5);
        }
        if (!(declarationDescriptor instanceof ModuleDescriptor) && !kf0.r(declarationDescriptor)) {
            if (declarationDescriptor instanceof PackageViewDescriptor) {
                return ((PackageViewDescriptor) declarationDescriptor).getFqName();
            }
            if (declarationDescriptor instanceof PackageFragmentDescriptor) {
                return ((PackageFragmentDescriptor) declarationDescriptor).getFqName();
            }
            return null;
        }
        return hp0.ROOT;
    }

    @NotNull
    private static ip0 p(@NotNull DeclarationDescriptor declarationDescriptor) {
        if (declarationDescriptor == null) {
            a(6);
        }
        ip0 c = m(declarationDescriptor.getContainingDeclaration()).c(declarationDescriptor.getName());
        if (c == null) {
            a(7);
        }
        return c;
    }

    @Nullable
    public static <D extends DeclarationDescriptor> D q(@Nullable DeclarationDescriptor declarationDescriptor, @NotNull Class<D> cls) {
        if (cls == null) {
            a(18);
        }
        return (D) r(declarationDescriptor, cls, true);
    }

    @Nullable
    public static <D extends DeclarationDescriptor> D r(@Nullable DeclarationDescriptor declarationDescriptor, @NotNull Class<D> cls, boolean z) {
        if (cls == null) {
            a(19);
        }
        if (declarationDescriptor == null) {
            return null;
        }
        if (z) {
            declarationDescriptor = (D) declarationDescriptor.getContainingDeclaration();
        }
        while (declarationDescriptor != null) {
            if (cls.isInstance(declarationDescriptor)) {
                return (D) declarationDescriptor;
            }
            declarationDescriptor = (D) declarationDescriptor.getContainingDeclaration();
        }
        return null;
    }

    @Nullable
    public static ClassDescriptor s(@NotNull ClassDescriptor classDescriptor) {
        if (classDescriptor == null) {
            a(44);
        }
        for (z71 z71Var : classDescriptor.getTypeConstructor().getSupertypes()) {
            ClassDescriptor e = e(z71Var);
            if (e.getKind() != ClassKind.INTERFACE) {
                return e;
            }
        }
        return null;
    }

    public static boolean t(@Nullable DeclarationDescriptor declarationDescriptor) {
        return D(declarationDescriptor, ClassKind.ANNOTATION_CLASS);
    }

    public static boolean u(@NotNull DeclarationDescriptor declarationDescriptor) {
        if (declarationDescriptor == null) {
            a(34);
        }
        return v(declarationDescriptor) && declarationDescriptor.getName().equals(af2.NO_NAME_PROVIDED);
    }

    public static boolean v(@Nullable DeclarationDescriptor declarationDescriptor) {
        return D(declarationDescriptor, ClassKind.CLASS);
    }

    public static boolean w(@Nullable DeclarationDescriptor declarationDescriptor) {
        return v(declarationDescriptor) || A(declarationDescriptor);
    }

    public static boolean x(@Nullable DeclarationDescriptor declarationDescriptor) {
        return D(declarationDescriptor, ClassKind.OBJECT) && ((ClassDescriptor) declarationDescriptor).isCompanionObject();
    }

    public static boolean y(DeclarationDescriptor declarationDescriptor) {
        return (declarationDescriptor instanceof DeclarationDescriptorWithVisibility) && ((DeclarationDescriptorWithVisibility) declarationDescriptor).getVisibility() == e70.LOCAL;
    }

    public static boolean z(@NotNull ClassDescriptor classDescriptor, @NotNull ClassDescriptor classDescriptor2) {
        if (classDescriptor == null) {
            a(26);
        }
        if (classDescriptor2 == null) {
            a(27);
        }
        for (z71 z71Var : classDescriptor.getTypeConstructor().getSupertypes()) {
            if (F(z71Var, classDescriptor2.getOriginal())) {
                return true;
            }
        }
        return false;
    }
}
