package kotlin.reflect.jvm.internal.impl.builtins;

import com.alibaba.wireless.security.SecExceptionCode;
import com.youku.live.dago.module.DagoPlayerInteract;
import com.youku.uplayer.AliMediaPlayer;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.EnumMap;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.reflect.jvm.internal.impl.builtins.C8277c;
import kotlin.reflect.jvm.internal.impl.descriptors.ClassDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.ClassifierDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.DeclarationDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.FindClassInModuleKt;
import kotlin.reflect.jvm.internal.impl.descriptors.ModuleDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.PackageFragmentDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.PackageViewDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.PropertyDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.PropertyGetterDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.PropertySetterDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.annotations.Annotations;
import kotlin.reflect.jvm.internal.impl.descriptors.deserialization.AdditionalClassPartsProvider;
import kotlin.reflect.jvm.internal.impl.descriptors.deserialization.ClassDescriptorFactory;
import kotlin.reflect.jvm.internal.impl.descriptors.deserialization.PlatformDependentDeclarationFilter;
import kotlin.reflect.jvm.internal.impl.descriptors.impl.ModuleDescriptorImpl;
import kotlin.reflect.jvm.internal.impl.incremental.components.NoLookupLocation;
import kotlin.reflect.jvm.internal.impl.resolve.descriptorUtil.DescriptorUtilsKt;
import kotlin.reflect.jvm.internal.impl.resolve.scopes.MemberScope;
import kotlin.reflect.jvm.internal.impl.storage.MemoizedFunctionToNotNull;
import kotlin.reflect.jvm.internal.impl.storage.NotNullLazyValue;
import kotlin.reflect.jvm.internal.impl.storage.StorageManager;
import kotlin.reflect.jvm.internal.impl.types.KotlinTypeFactory;
import kotlin.reflect.jvm.internal.impl.types.TypeConstructor;
import kotlin.reflect.jvm.internal.impl.types.Variance;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import tb.c70;
import tb.d70;
import tb.eu2;
import tb.fd2;
import tb.fr2;
import tb.hj;
import tb.hp0;
import tb.ip0;
import tb.jn1;
import tb.ni1;
import tb.z71;
import tb.zd;
import tb.zq2;

/* compiled from: Taobao */
/* renamed from: kotlin.reflect.jvm.internal.impl.builtins.b */
/* loaded from: classes3.dex */
public abstract class AbstractC8271b {
    public static final ni1 BUILTINS_MODULE_NAME = ni1.i("<built-ins module>");
    private ModuleDescriptorImpl a;
    private NotNullLazyValue<ModuleDescriptorImpl> b;
    private final NotNullLazyValue<C8276e> c;
    private final NotNullLazyValue<Collection<PackageViewDescriptor>> d;
    private final MemoizedFunctionToNotNull<ni1, ClassDescriptor> e;
    private final StorageManager f;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: Taobao */
    /* renamed from: kotlin.reflect.jvm.internal.impl.builtins.b$a */
    /* loaded from: classes3.dex */
    public class C8272a implements Function0<Collection<PackageViewDescriptor>> {
        C8272a() {
        }

        @Override // kotlin.jvm.functions.Function0
        /* renamed from: a */
        public Collection<PackageViewDescriptor> invoke() {
            return Arrays.asList(AbstractC8271b.this.r().getPackage(C8277c.BUILT_INS_PACKAGE_FQ_NAME), AbstractC8271b.this.r().getPackage(C8277c.COLLECTIONS_PACKAGE_FQ_NAME), AbstractC8271b.this.r().getPackage(C8277c.RANGES_PACKAGE_FQ_NAME), AbstractC8271b.this.r().getPackage(C8277c.ANNOTATION_PACKAGE_FQ_NAME));
        }
    }

    /* compiled from: Taobao */
    /* renamed from: kotlin.reflect.jvm.internal.impl.builtins.b$b */
    /* loaded from: classes3.dex */
    class C8273b implements Function0<C8276e> {
        C8273b() {
        }

        @Override // kotlin.jvm.functions.Function0
        /* renamed from: a */
        public C8276e invoke() {
            PrimitiveType[] values;
            EnumMap enumMap = new EnumMap(PrimitiveType.class);
            HashMap hashMap = new HashMap();
            HashMap hashMap2 = new HashMap();
            for (PrimitiveType primitiveType : PrimitiveType.values()) {
                fd2 q = AbstractC8271b.this.q(primitiveType.getTypeName().b());
                fd2 q2 = AbstractC8271b.this.q(primitiveType.getArrayTypeName().b());
                enumMap.put((EnumMap) primitiveType, (PrimitiveType) q2);
                hashMap.put(q, q2);
                hashMap2.put(q2, q);
            }
            return new C8276e(enumMap, hashMap, hashMap2, null);
        }
    }

    /* compiled from: Taobao */
    /* renamed from: kotlin.reflect.jvm.internal.impl.builtins.b$c */
    /* loaded from: classes3.dex */
    class C8274c implements Function1<ni1, ClassDescriptor> {
        C8274c() {
        }

        @Override // kotlin.jvm.functions.Function1
        /* renamed from: a */
        public ClassDescriptor invoke(ni1 ni1Var) {
            ClassifierDescriptor contributedClassifier = AbstractC8271b.this.s().getContributedClassifier(ni1Var, NoLookupLocation.FROM_BUILTINS);
            if (contributedClassifier != null) {
                if (contributedClassifier instanceof ClassDescriptor) {
                    return (ClassDescriptor) contributedClassifier;
                }
                throw new AssertionError("Must be a class descriptor " + ni1Var + ", but was " + contributedClassifier);
            }
            throw new AssertionError("Built-in class " + C8277c.BUILT_INS_PACKAGE_FQ_NAME.c(ni1Var) + " is not found");
        }
    }

    /* compiled from: Taobao */
    /* renamed from: kotlin.reflect.jvm.internal.impl.builtins.b$d */
    /* loaded from: classes3.dex */
    class C8275d implements Function0<Void> {
        final /* synthetic */ ModuleDescriptorImpl a;

        C8275d(ModuleDescriptorImpl moduleDescriptorImpl) {
            this.a = moduleDescriptorImpl;
        }

        @Override // kotlin.jvm.functions.Function0
        /* renamed from: a */
        public Void invoke() {
            if (AbstractC8271b.this.a != null) {
                throw new AssertionError("Built-ins module is already set: " + AbstractC8271b.this.a + " (attempting to reset to " + this.a + jn1.BRACKET_END_STR);
            }
            AbstractC8271b.this.a = this.a;
            return null;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: Taobao */
    /* renamed from: kotlin.reflect.jvm.internal.impl.builtins.b$e */
    /* loaded from: classes3.dex */
    public static class C8276e {
        public final Map<PrimitiveType, fd2> a;
        public final Map<z71, fd2> b;
        public final Map<fd2, fd2> c;

        /* synthetic */ C8276e(Map map, Map map2, Map map3, C8272a c8272a) {
            this(map, map2, map3);
        }

        private static /* synthetic */ void a(int i) {
            Object[] objArr = new Object[3];
            if (i == 1) {
                objArr[0] = "primitiveKotlinTypeToKotlinArrayType";
            } else if (i != 2) {
                objArr[0] = "primitiveTypeToArrayKotlinType";
            } else {
                objArr[0] = "kotlinArrayTypeToPrimitiveKotlinType";
            }
            objArr[1] = "kotlin/reflect/jvm/internal/impl/builtins/KotlinBuiltIns$Primitives";
            objArr[2] = "<init>";
            throw new IllegalArgumentException(String.format("Argument for @NotNull parameter '%s' of %s.%s must not be null", objArr));
        }

        private C8276e(@NotNull Map<PrimitiveType, fd2> map, @NotNull Map<z71, fd2> map2, @NotNull Map<fd2, fd2> map3) {
            if (map == null) {
                a(0);
            }
            if (map2 == null) {
                a(1);
            }
            if (map3 == null) {
                a(2);
            }
            this.a = map;
            this.b = map2;
            this.c = map3;
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public AbstractC8271b(@NotNull StorageManager storageManager) {
        if (storageManager == null) {
            a(0);
        }
        this.f = storageManager;
        this.d = storageManager.createLazyValue(new C8272a());
        this.c = storageManager.createLazyValue(new C8273b());
        this.e = storageManager.createMemoizedFunction(new C8274c());
    }

    @Nullable
    private static z71 A(@NotNull z71 z71Var, @NotNull ModuleDescriptor moduleDescriptor) {
        hj h;
        hj a;
        ClassDescriptor a2;
        if (z71Var == null) {
            a(71);
        }
        if (moduleDescriptor == null) {
            a(72);
        }
        ClassifierDescriptor declarationDescriptor = z71Var.c().getDeclarationDescriptor();
        if (declarationDescriptor == null) {
            return null;
        }
        eu2 eu2Var = eu2.INSTANCE;
        if (!eu2Var.b(declarationDescriptor.getName()) || (h = DescriptorUtilsKt.h(declarationDescriptor)) == null || (a = eu2Var.a(h)) == null || (a2 = FindClassInModuleKt.a(moduleDescriptor, a)) == null) {
            return null;
        }
        return a2.getDefaultType();
    }

    public static boolean A0(@NotNull z71 z71Var) {
        if (z71Var == null) {
            a(142);
        }
        return k0(z71Var, C8277c.C8278a.unit);
    }

    public static boolean B0(@NotNull z71 z71Var) {
        if (z71Var == null) {
            a(132);
        }
        return v0(z71Var) || y0(z71Var) || w0(z71Var) || x0(z71Var);
    }

    @Nullable
    public static PrimitiveType N(@NotNull z71 z71Var) {
        if (z71Var == null) {
            a(92);
        }
        ClassifierDescriptor declarationDescriptor = z71Var.c().getDeclarationDescriptor();
        if (declarationDescriptor == null) {
            return null;
        }
        return P(declarationDescriptor);
    }

    @Nullable
    public static PrimitiveType P(@NotNull DeclarationDescriptor declarationDescriptor) {
        if (declarationDescriptor == null) {
            a(77);
        }
        if (C8277c.C8278a.primitiveArrayTypeShortNames.contains(declarationDescriptor.getName())) {
            return C8277c.C8278a.arrayClassFqNameToPrimitiveType.get(d70.m(declarationDescriptor));
        }
        return null;
    }

    @NotNull
    private ClassDescriptor Q(@NotNull PrimitiveType primitiveType) {
        if (primitiveType == null) {
            a(16);
        }
        return p(primitiveType.getTypeName().b());
    }

    @Nullable
    public static PrimitiveType S(@NotNull DeclarationDescriptor declarationDescriptor) {
        if (declarationDescriptor == null) {
            a(76);
        }
        if (C8277c.C8278a.primitiveTypeShortNames.contains(declarationDescriptor.getName())) {
            return C8277c.C8278a.fqNameToPrimitiveType.get(d70.m(declarationDescriptor));
        }
        return null;
    }

    private static /* synthetic */ void a(int i) {
        String str;
        int i2;
        switch (i) {
            case 3:
            case 4:
            case 5:
            case 6:
            case 7:
            case 8:
            case 11:
            case 13:
            case 15:
            case 18:
            case 19:
            case 20:
            case 21:
            case 22:
            case 23:
            case 24:
            case 25:
            case 26:
            case 27:
            case 28:
            case 29:
            case 30:
            case 31:
            case 32:
            case 33:
            case 34:
            case 35:
            case 36:
            case 37:
            case 38:
            case 39:
            case 40:
            case 41:
            case 42:
            case 43:
            case 44:
            case 45:
            case 47:
            case 48:
            case 49:
            case 50:
            case 51:
            case 52:
            case 54:
            case 55:
            case 56:
            case 57:
            case 58:
            case 59:
            case 60:
            case 61:
            case 62:
            case 63:
            case 64:
            case 65:
            case 66:
            case 68:
            case 69:
            case 70:
            case 74:
            case 81:
            case 84:
            case 86:
            case 87:
                str = "@NotNull method %s.%s must not return null";
                break;
            case 9:
            case 10:
            case 12:
            case 14:
            case 16:
            case 17:
            case 46:
            case 53:
            case 67:
            case 71:
            case 72:
            case 73:
            case 75:
            case 76:
            case 77:
            case 78:
            case 79:
            case 80:
            case 82:
            case 83:
            case 85:
            default:
                str = "Argument for @NotNull parameter '%s' of %s.%s must not be null";
                break;
        }
        switch (i) {
            case 3:
            case 4:
            case 5:
            case 6:
            case 7:
            case 8:
            case 11:
            case 13:
            case 15:
            case 18:
            case 19:
            case 20:
            case 21:
            case 22:
            case 23:
            case 24:
            case 25:
            case 26:
            case 27:
            case 28:
            case 29:
            case 30:
            case 31:
            case 32:
            case 33:
            case 34:
            case 35:
            case 36:
            case 37:
            case 38:
            case 39:
            case 40:
            case 41:
            case 42:
            case 43:
            case 44:
            case 45:
            case 47:
            case 48:
            case 49:
            case 50:
            case 51:
            case 52:
            case 54:
            case 55:
            case 56:
            case 57:
            case 58:
            case 59:
            case 60:
            case 61:
            case 62:
            case 63:
            case 64:
            case 65:
            case 66:
            case 68:
            case 69:
            case 70:
            case 74:
            case 81:
            case 84:
            case 86:
            case 87:
                i2 = 2;
                break;
            case 9:
            case 10:
            case 12:
            case 14:
            case 16:
            case 17:
            case 46:
            case 53:
            case 67:
            case 71:
            case 72:
            case 73:
            case 75:
            case 76:
            case 77:
            case 78:
            case 79:
            case 80:
            case 82:
            case 83:
            case 85:
            default:
                i2 = 3;
                break;
        }
        Object[] objArr = new Object[i2];
        switch (i) {
            case 1:
            case 72:
                objArr[0] = "module";
                break;
            case 2:
                objArr[0] = "computation";
                break;
            case 3:
            case 4:
            case 5:
            case 6:
            case 7:
            case 8:
            case 11:
            case 13:
            case 15:
            case 18:
            case 19:
            case 20:
            case 21:
            case 22:
            case 23:
            case 24:
            case 25:
            case 26:
            case 27:
            case 28:
            case 29:
            case 30:
            case 31:
            case 32:
            case 33:
            case 34:
            case 35:
            case 36:
            case 37:
            case 38:
            case 39:
            case 40:
            case 41:
            case 42:
            case 43:
            case 44:
            case 45:
            case 47:
            case 48:
            case 49:
            case 50:
            case 51:
            case 52:
            case 54:
            case 55:
            case 56:
            case 57:
            case 58:
            case 59:
            case 60:
            case 61:
            case 62:
            case 63:
            case 64:
            case 65:
            case 66:
            case 68:
            case 69:
            case 70:
            case 74:
            case 81:
            case 84:
            case 86:
            case 87:
                objArr[0] = "kotlin/reflect/jvm/internal/impl/builtins/KotlinBuiltIns";
                break;
            case 9:
            case 10:
            case 76:
            case 77:
            case 89:
            case 96:
            case 103:
            case 107:
            case 108:
            case 145:
            case 146:
            case 148:
            case AliMediaPlayer.UPLAYER_PROPERTY_TYPE_PATTAYA_HD2_UP_GEAR_NEED_BUFFER /* 156 */:
            case 157:
            case AliMediaPlayer.UPLAYER_PROPERTY_TYPE_PATTAYA_DISALBE_ADAPT_SPEED /* 158 */:
            case AliMediaPlayer.UPLAYER_PROPERTY_TYPE_PATTAYA_ADAPT_SPEED_MAX_SAFE_BUFFER_FACTOR /* 159 */:
                objArr[0] = "descriptor";
                break;
            case 12:
            case 98:
            case 100:
            case 102:
            case 104:
            case 106:
            case 135:
                objArr[0] = "fqName";
                break;
            case 14:
                objArr[0] = "simpleName";
                break;
            case 16:
            case 17:
            case 53:
            case 88:
            case 90:
            case 91:
            case 92:
            case 93:
            case 94:
            case 95:
            case 97:
            case 99:
            case 105:
            case 109:
            case 110:
            case 111:
            case 113:
            case 114:
            case 115:
            case 116:
            case 117:
            case 118:
            case 119:
            case 120:
            case 121:
            case 122:
            case 123:
            case 124:
            case 125:
            case 126:
            case 127:
            case 128:
            case SecExceptionCode.SEC_ERROR_INIT_INDEX_ERROR /* 129 */:
            case 130:
            case 131:
            case 132:
            case 133:
            case 134:
            case 136:
            case 137:
            case SecExceptionCode.SEC_ERROR_INIT_PLUGIN_CLASS_ERROR /* 138 */:
            case SecExceptionCode.SEC_ERROR_INIT_CLAZZ_NULL_ERROR /* 139 */:
            case 140:
            case 141:
            case 142:
            case AliMediaPlayer.UPLAYER_PROPERTY_TYPE_DISABLE_LIMITSPEED_P2P /* 143 */:
            case AliMediaPlayer.UPLAYER_PROPERTY_TYPE_PATTAYA_MAX_GEAR_KEEP /* 144 */:
            case DagoPlayerInteract.UNIT_ANCHOR_INFO_WIDTH /* 147 */:
            case 149:
            case 150:
            case 151:
            case AliMediaPlayer.UPLAYER_PROPERTY_TYPE_PATTAYA_USING_FIXED_GEAR /* 152 */:
            case AliMediaPlayer.UPLAYER_PROPERTY_TYPE_PATTAYA_FIXED_GEAR_INDEX /* 153 */:
            case AliMediaPlayer.UPLAYER_PROPERTY_TYPE_PATTAYA_SD_UP_GEAR_NEED_BUFFER /* 154 */:
            case AliMediaPlayer.UPLAYER_PROPERTY_TYPE_PATTAYA_HD_UPGEAR_NEED_BUFFER /* 155 */:
            case 161:
                objArr[0] = "type";
                break;
            case 46:
                objArr[0] = "classSimpleName";
                break;
            case 67:
                objArr[0] = "arrayType";
                break;
            case 71:
                objArr[0] = "notNullArrayType";
                break;
            case 73:
                objArr[0] = "primitiveType";
                break;
            case 75:
                objArr[0] = "kotlinType";
                break;
            case 78:
            case 82:
                objArr[0] = "projectionType";
                break;
            case 79:
            case 83:
            case 85:
                objArr[0] = "argument";
                break;
            case 80:
                objArr[0] = "annotations";
                break;
            case 101:
                objArr[0] = "typeConstructor";
                break;
            case 112:
                objArr[0] = "classDescriptor";
                break;
            case 160:
                objArr[0] = "declarationDescriptor";
                break;
            default:
                objArr[0] = "storageManager";
                break;
        }
        switch (i) {
            case 3:
                objArr[1] = "getAdditionalClassPartsProvider";
                break;
            case 4:
                objArr[1] = "getPlatformDependentDeclarationFilter";
                break;
            case 5:
                objArr[1] = "getClassDescriptorFactories";
                break;
            case 6:
                objArr[1] = "getStorageManager";
                break;
            case 7:
                objArr[1] = "getBuiltInsModule";
                break;
            case 8:
                objArr[1] = "getBuiltInPackagesImportedByDefault";
                break;
            case 9:
            case 10:
            case 12:
            case 14:
            case 16:
            case 17:
            case 46:
            case 53:
            case 67:
            case 71:
            case 72:
            case 73:
            case 75:
            case 76:
            case 77:
            case 78:
            case 79:
            case 80:
            case 82:
            case 83:
            case 85:
            default:
                objArr[1] = "kotlin/reflect/jvm/internal/impl/builtins/KotlinBuiltIns";
                break;
            case 11:
                objArr[1] = "getBuiltInsPackageScope";
                break;
            case 13:
                objArr[1] = "getBuiltInClassByFqName";
                break;
            case 15:
                objArr[1] = "getBuiltInClassByName";
                break;
            case 18:
                objArr[1] = "getSuspendFunction";
                break;
            case 19:
                objArr[1] = "getKFunction";
                break;
            case 20:
                objArr[1] = "getKSuspendFunction";
                break;
            case 21:
                objArr[1] = "getKClass";
                break;
            case 22:
                objArr[1] = "getKCallable";
                break;
            case 23:
                objArr[1] = "getKProperty";
                break;
            case 24:
                objArr[1] = "getKProperty0";
                break;
            case 25:
                objArr[1] = "getKProperty1";
                break;
            case 26:
                objArr[1] = "getKProperty2";
                break;
            case 27:
                objArr[1] = "getKMutableProperty0";
                break;
            case 28:
                objArr[1] = "getKMutableProperty1";
                break;
            case 29:
                objArr[1] = "getKMutableProperty2";
                break;
            case 30:
                objArr[1] = "getIterator";
                break;
            case 31:
                objArr[1] = "getIterable";
                break;
            case 32:
                objArr[1] = "getMutableIterable";
                break;
            case 33:
                objArr[1] = "getMutableIterator";
                break;
            case 34:
                objArr[1] = "getCollection";
                break;
            case 35:
                objArr[1] = "getMutableCollection";
                break;
            case 36:
                objArr[1] = "getList";
                break;
            case 37:
                objArr[1] = "getMutableList";
                break;
            case 38:
                objArr[1] = "getSet";
                break;
            case 39:
                objArr[1] = "getMutableSet";
                break;
            case 40:
                objArr[1] = "getMap";
                break;
            case 41:
                objArr[1] = "getMutableMap";
                break;
            case 42:
                objArr[1] = "getMapEntry";
                break;
            case 43:
                objArr[1] = "getMutableMapEntry";
                break;
            case 44:
                objArr[1] = "getListIterator";
                break;
            case 45:
                objArr[1] = "getMutableListIterator";
                break;
            case 47:
                objArr[1] = "getBuiltInTypeByClassName";
                break;
            case 48:
                objArr[1] = "getNothingType";
                break;
            case 49:
                objArr[1] = "getNullableNothingType";
                break;
            case 50:
                objArr[1] = "getAnyType";
                break;
            case 51:
                objArr[1] = "getNullableAnyType";
                break;
            case 52:
                objArr[1] = "getDefaultBound";
                break;
            case 54:
                objArr[1] = "getPrimitiveKotlinType";
                break;
            case 55:
                objArr[1] = "getNumberType";
                break;
            case 56:
                objArr[1] = "getByteType";
                break;
            case 57:
                objArr[1] = "getShortType";
                break;
            case 58:
                objArr[1] = "getIntType";
                break;
            case 59:
                objArr[1] = "getLongType";
                break;
            case 60:
                objArr[1] = "getFloatType";
                break;
            case 61:
                objArr[1] = "getDoubleType";
                break;
            case 62:
                objArr[1] = "getCharType";
                break;
            case 63:
                objArr[1] = "getBooleanType";
                break;
            case 64:
                objArr[1] = "getUnitType";
                break;
            case 65:
                objArr[1] = "getStringType";
                break;
            case 66:
                objArr[1] = "getIterableType";
                break;
            case 68:
            case 69:
            case 70:
                objArr[1] = "getArrayElementType";
                break;
            case 74:
                objArr[1] = "getPrimitiveArrayKotlinType";
                break;
            case 81:
            case 84:
                objArr[1] = "getArrayType";
                break;
            case 86:
                objArr[1] = "getEnumType";
                break;
            case 87:
                objArr[1] = "getAnnotationType";
                break;
        }
        switch (i) {
            case 1:
                objArr[2] = "setBuiltInsModule";
                break;
            case 2:
                objArr[2] = "setPostponedBuiltinsModuleComputation";
                break;
            case 3:
            case 4:
            case 5:
            case 6:
            case 7:
            case 8:
            case 11:
            case 13:
            case 15:
            case 18:
            case 19:
            case 20:
            case 21:
            case 22:
            case 23:
            case 24:
            case 25:
            case 26:
            case 27:
            case 28:
            case 29:
            case 30:
            case 31:
            case 32:
            case 33:
            case 34:
            case 35:
            case 36:
            case 37:
            case 38:
            case 39:
            case 40:
            case 41:
            case 42:
            case 43:
            case 44:
            case 45:
            case 47:
            case 48:
            case 49:
            case 50:
            case 51:
            case 52:
            case 54:
            case 55:
            case 56:
            case 57:
            case 58:
            case 59:
            case 60:
            case 61:
            case 62:
            case 63:
            case 64:
            case 65:
            case 66:
            case 68:
            case 69:
            case 70:
            case 74:
            case 81:
            case 84:
            case 86:
            case 87:
                break;
            case 9:
                objArr[2] = "isBuiltIn";
                break;
            case 10:
                objArr[2] = "isUnderKotlinPackage";
                break;
            case 12:
                objArr[2] = "getBuiltInClassByFqName";
                break;
            case 14:
                objArr[2] = "getBuiltInClassByName";
                break;
            case 16:
                objArr[2] = "getPrimitiveClassDescriptor";
                break;
            case 17:
                objArr[2] = "getPrimitiveArrayClassDescriptor";
                break;
            case 46:
                objArr[2] = "getBuiltInTypeByClassName";
                break;
            case 53:
                objArr[2] = "getPrimitiveKotlinType";
                break;
            case 67:
                objArr[2] = "getArrayElementType";
                break;
            case 71:
            case 72:
                objArr[2] = "getElementTypeForUnsignedArray";
                break;
            case 73:
                objArr[2] = "getPrimitiveArrayKotlinType";
                break;
            case 75:
                objArr[2] = "getPrimitiveArrayKotlinTypeByPrimitiveKotlinType";
                break;
            case 76:
            case 93:
                objArr[2] = "getPrimitiveType";
                break;
            case 77:
                objArr[2] = "getPrimitiveArrayType";
                break;
            case 78:
            case 79:
            case 80:
            case 82:
            case 83:
                objArr[2] = "getArrayType";
                break;
            case 85:
                objArr[2] = "getEnumType";
                break;
            case 88:
                objArr[2] = "isArray";
                break;
            case 89:
            case 90:
                objArr[2] = "isArrayOrPrimitiveArray";
                break;
            case 91:
                objArr[2] = "isPrimitiveArray";
                break;
            case 92:
                objArr[2] = "getPrimitiveArrayElementType";
                break;
            case 94:
                objArr[2] = "isPrimitiveType";
                break;
            case 95:
                objArr[2] = "isPrimitiveTypeOrNullablePrimitiveType";
                break;
            case 96:
                objArr[2] = "isPrimitiveClass";
                break;
            case 97:
            case 98:
            case 99:
            case 100:
                objArr[2] = "isConstructedFromGivenClass";
                break;
            case 101:
            case 102:
                objArr[2] = "isTypeConstructorForGivenClass";
                break;
            case 103:
            case 104:
                objArr[2] = "classFqNameEquals";
                break;
            case 105:
            case 106:
                objArr[2] = "isNotNullConstructedFromGivenClass";
                break;
            case 107:
                objArr[2] = "isSpecialClassWithNoSupertypes";
                break;
            case 108:
            case 109:
                objArr[2] = "isAny";
                break;
            case 110:
            case 112:
                objArr[2] = "isBoolean";
                break;
            case 111:
                objArr[2] = "isBooleanOrNullableBoolean";
                break;
            case 113:
                objArr[2] = "isNumber";
                break;
            case 114:
                objArr[2] = "isChar";
                break;
            case 115:
                objArr[2] = "isCharOrNullableChar";
                break;
            case 116:
                objArr[2] = "isInt";
                break;
            case 117:
                objArr[2] = "isByte";
                break;
            case 118:
                objArr[2] = "isLong";
                break;
            case 119:
                objArr[2] = "isLongOrNullableLong";
                break;
            case 120:
                objArr[2] = "isShort";
                break;
            case 121:
                objArr[2] = "isFloat";
                break;
            case 122:
                objArr[2] = "isFloatOrNullableFloat";
                break;
            case 123:
                objArr[2] = "isDouble";
                break;
            case 124:
                objArr[2] = "isUByte";
                break;
            case 125:
                objArr[2] = "isUShort";
                break;
            case 126:
                objArr[2] = "isUInt";
                break;
            case 127:
                objArr[2] = "isULong";
                break;
            case 128:
                objArr[2] = "isUByteArray";
                break;
            case SecExceptionCode.SEC_ERROR_INIT_INDEX_ERROR /* 129 */:
                objArr[2] = "isUShortArray";
                break;
            case 130:
                objArr[2] = "isUIntArray";
                break;
            case 131:
                objArr[2] = "isULongArray";
                break;
            case 132:
                objArr[2] = "isUnsignedArrayType";
                break;
            case 133:
                objArr[2] = "isDoubleOrNullableDouble";
                break;
            case 134:
            case 135:
                objArr[2] = "isConstructedFromGivenClassAndNotNullable";
                break;
            case 136:
                objArr[2] = "isNothing";
                break;
            case 137:
                objArr[2] = "isNullableNothing";
                break;
            case SecExceptionCode.SEC_ERROR_INIT_PLUGIN_CLASS_ERROR /* 138 */:
                objArr[2] = "isNothingOrNullableNothing";
                break;
            case SecExceptionCode.SEC_ERROR_INIT_CLAZZ_NULL_ERROR /* 139 */:
                objArr[2] = "isAnyOrNullableAny";
                break;
            case 140:
                objArr[2] = "isNullableAny";
                break;
            case 141:
                objArr[2] = "isDefaultBound";
                break;
            case 142:
                objArr[2] = "isUnit";
                break;
            case AliMediaPlayer.UPLAYER_PROPERTY_TYPE_DISABLE_LIMITSPEED_P2P /* 143 */:
                objArr[2] = "isUnitOrNullableUnit";
                break;
            case AliMediaPlayer.UPLAYER_PROPERTY_TYPE_PATTAYA_MAX_GEAR_KEEP /* 144 */:
                objArr[2] = "isBooleanOrSubtype";
                break;
            case 145:
                objArr[2] = "isMemberOfAny";
                break;
            case 146:
            case DagoPlayerInteract.UNIT_ANCHOR_INFO_WIDTH /* 147 */:
                objArr[2] = "isEnum";
                break;
            case 148:
            case 149:
                objArr[2] = "isComparable";
                break;
            case 150:
                objArr[2] = "isCollectionOrNullableCollection";
                break;
            case 151:
                objArr[2] = "isListOrNullableList";
                break;
            case AliMediaPlayer.UPLAYER_PROPERTY_TYPE_PATTAYA_USING_FIXED_GEAR /* 152 */:
                objArr[2] = "isSetOrNullableSet";
                break;
            case AliMediaPlayer.UPLAYER_PROPERTY_TYPE_PATTAYA_FIXED_GEAR_INDEX /* 153 */:
                objArr[2] = "isMapOrNullableMap";
                break;
            case AliMediaPlayer.UPLAYER_PROPERTY_TYPE_PATTAYA_SD_UP_GEAR_NEED_BUFFER /* 154 */:
                objArr[2] = "isIterableOrNullableIterable";
                break;
            case AliMediaPlayer.UPLAYER_PROPERTY_TYPE_PATTAYA_HD_UPGEAR_NEED_BUFFER /* 155 */:
                objArr[2] = "isThrowableOrNullableThrowable";
                break;
            case AliMediaPlayer.UPLAYER_PROPERTY_TYPE_PATTAYA_HD2_UP_GEAR_NEED_BUFFER /* 156 */:
                objArr[2] = "isThrowable";
                break;
            case 157:
                objArr[2] = "isKClass";
                break;
            case AliMediaPlayer.UPLAYER_PROPERTY_TYPE_PATTAYA_DISALBE_ADAPT_SPEED /* 158 */:
                objArr[2] = "isNonPrimitiveArray";
                break;
            case AliMediaPlayer.UPLAYER_PROPERTY_TYPE_PATTAYA_ADAPT_SPEED_MAX_SAFE_BUFFER_FACTOR /* 159 */:
                objArr[2] = "isCloneable";
                break;
            case 160:
                objArr[2] = "isDeprecated";
                break;
            case 161:
                objArr[2] = "isNotNullOrNullableFunctionSupertype";
                break;
            default:
                objArr[2] = "<init>";
                break;
        }
        String format = String.format(str, objArr);
        switch (i) {
            case 3:
            case 4:
            case 5:
            case 6:
            case 7:
            case 8:
            case 11:
            case 13:
            case 15:
            case 18:
            case 19:
            case 20:
            case 21:
            case 22:
            case 23:
            case 24:
            case 25:
            case 26:
            case 27:
            case 28:
            case 29:
            case 30:
            case 31:
            case 32:
            case 33:
            case 34:
            case 35:
            case 36:
            case 37:
            case 38:
            case 39:
            case 40:
            case 41:
            case 42:
            case 43:
            case 44:
            case 45:
            case 47:
            case 48:
            case 49:
            case 50:
            case 51:
            case 52:
            case 54:
            case 55:
            case 56:
            case 57:
            case 58:
            case 59:
            case 60:
            case 61:
            case 62:
            case 63:
            case 64:
            case 65:
            case 66:
            case 68:
            case 69:
            case 70:
            case 74:
            case 81:
            case 84:
            case 86:
            case 87:
                throw new IllegalStateException(format);
            case 9:
            case 10:
            case 12:
            case 14:
            case 16:
            case 17:
            case 46:
            case 53:
            case 67:
            case 71:
            case 72:
            case 73:
            case 75:
            case 76:
            case 77:
            case 78:
            case 79:
            case 80:
            case 82:
            case 83:
            case 85:
            default:
                throw new IllegalArgumentException(format);
        }
    }

    public static boolean a0(@NotNull ClassDescriptor classDescriptor) {
        if (classDescriptor == null) {
            a(108);
        }
        return e(classDescriptor, C8277c.C8278a.any);
    }

    public static boolean b0(@NotNull z71 z71Var) {
        if (z71Var == null) {
            a(SecExceptionCode.SEC_ERROR_INIT_CLAZZ_NULL_ERROR);
        }
        return f0(z71Var, C8277c.C8278a.any);
    }

    public static boolean c0(@NotNull z71 z71Var) {
        if (z71Var == null) {
            a(88);
        }
        return f0(z71Var, C8277c.C8278a.array);
    }

    public static boolean d0(@NotNull ClassDescriptor classDescriptor) {
        if (classDescriptor == null) {
            a(89);
        }
        return e(classDescriptor, C8277c.C8278a.array) || P(classDescriptor) != null;
    }

    private static boolean e(@NotNull ClassifierDescriptor classifierDescriptor, @NotNull ip0 ip0Var) {
        if (classifierDescriptor == null) {
            a(103);
        }
        if (ip0Var == null) {
            a(104);
        }
        return classifierDescriptor.getName().equals(ip0Var.i()) && ip0Var.equals(d70.m(classifierDescriptor));
    }

    public static boolean e0(@NotNull DeclarationDescriptor declarationDescriptor) {
        if (declarationDescriptor == null) {
            a(9);
        }
        return d70.r(declarationDescriptor, BuiltInsPackageFragment.class, false) != null;
    }

    private static boolean f0(@NotNull z71 z71Var, @NotNull ip0 ip0Var) {
        if (z71Var == null) {
            a(97);
        }
        if (ip0Var == null) {
            a(98);
        }
        return u0(z71Var.c(), ip0Var);
    }

    private static boolean g0(@NotNull z71 z71Var, @NotNull ip0 ip0Var) {
        if (z71Var == null) {
            a(134);
        }
        if (ip0Var == null) {
            a(135);
        }
        return f0(z71Var, ip0Var) && !z71Var.d();
    }

    public static boolean h0(@NotNull z71 z71Var) {
        if (z71Var == null) {
            a(141);
        }
        return n0(z71Var);
    }

    public static boolean i0(@NotNull DeclarationDescriptor declarationDescriptor) {
        if (declarationDescriptor == null) {
            a(160);
        }
        if (declarationDescriptor.getOriginal().getAnnotations().hasAnnotation(C8277c.C8278a.deprecated)) {
            return true;
        }
        if (declarationDescriptor instanceof PropertyDescriptor) {
            PropertyDescriptor propertyDescriptor = (PropertyDescriptor) declarationDescriptor;
            boolean isVar = propertyDescriptor.isVar();
            PropertyGetterDescriptor getter = propertyDescriptor.getGetter();
            PropertySetterDescriptor setter = propertyDescriptor.getSetter();
            if (getter != null && i0(getter)) {
                if (!isVar) {
                    return true;
                }
                if (setter != null && i0(setter)) {
                    return true;
                }
            }
            return false;
        }
        return false;
    }

    public static boolean j0(@NotNull ClassDescriptor classDescriptor) {
        if (classDescriptor == null) {
            a(157);
        }
        return e(classDescriptor, C8277c.C8278a.kClass);
    }

    private static boolean k0(@NotNull z71 z71Var, @NotNull ip0 ip0Var) {
        if (z71Var == null) {
            a(105);
        }
        if (ip0Var == null) {
            a(106);
        }
        return !z71Var.d() && f0(z71Var, ip0Var);
    }

    public static boolean l0(@NotNull z71 z71Var) {
        if (z71Var == null) {
            a(136);
        }
        return m0(z71Var) && !fr2.m(z71Var);
    }

    public static boolean m0(@NotNull z71 z71Var) {
        if (z71Var == null) {
            a(SecExceptionCode.SEC_ERROR_INIT_PLUGIN_CLASS_ERROR);
        }
        return f0(z71Var, C8277c.C8278a.nothing);
    }

    public static boolean n0(@NotNull z71 z71Var) {
        if (z71Var == null) {
            a(140);
        }
        return b0(z71Var) && z71Var.d();
    }

    public static boolean o0(@NotNull z71 z71Var) {
        if (z71Var == null) {
            a(91);
        }
        ClassifierDescriptor declarationDescriptor = z71Var.c().getDeclarationDescriptor();
        return (declarationDescriptor == null || P(declarationDescriptor) == null) ? false : true;
    }

    @NotNull
    private ClassDescriptor p(@NotNull String str) {
        if (str == null) {
            a(14);
        }
        ClassDescriptor invoke = this.e.invoke(ni1.f(str));
        if (invoke == null) {
            a(15);
        }
        return invoke;
    }

    public static boolean p0(@NotNull ClassDescriptor classDescriptor) {
        if (classDescriptor == null) {
            a(96);
        }
        return S(classDescriptor) != null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    @NotNull
    public fd2 q(@NotNull String str) {
        if (str == null) {
            a(46);
        }
        fd2 defaultType = p(str).getDefaultType();
        if (defaultType == null) {
            a(47);
        }
        return defaultType;
    }

    public static boolean q0(@NotNull z71 z71Var) {
        if (z71Var == null) {
            a(94);
        }
        return !z71Var.d() && r0(z71Var);
    }

    public static boolean r0(@NotNull z71 z71Var) {
        if (z71Var == null) {
            a(95);
        }
        ClassifierDescriptor declarationDescriptor = z71Var.c().getDeclarationDescriptor();
        return (declarationDescriptor instanceof ClassDescriptor) && p0((ClassDescriptor) declarationDescriptor);
    }

    public static boolean s0(@NotNull ClassDescriptor classDescriptor) {
        if (classDescriptor == null) {
            a(107);
        }
        return e(classDescriptor, C8277c.C8278a.any) || e(classDescriptor, C8277c.C8278a.nothing);
    }

    public static boolean t0(@Nullable z71 z71Var) {
        return z71Var != null && k0(z71Var, C8277c.C8278a.string);
    }

    public static boolean u0(@NotNull TypeConstructor typeConstructor, @NotNull ip0 ip0Var) {
        if (typeConstructor == null) {
            a(101);
        }
        if (ip0Var == null) {
            a(102);
        }
        ClassifierDescriptor declarationDescriptor = typeConstructor.getDeclarationDescriptor();
        return (declarationDescriptor instanceof ClassDescriptor) && e(declarationDescriptor, ip0Var);
    }

    public static boolean v0(@NotNull z71 z71Var) {
        if (z71Var == null) {
            a(128);
        }
        return g0(z71Var, C8277c.C8278a.uByteArrayFqName.j());
    }

    public static boolean w0(@NotNull z71 z71Var) {
        if (z71Var == null) {
            a(130);
        }
        return g0(z71Var, C8277c.C8278a.uIntArrayFqName.j());
    }

    public static boolean x0(@NotNull z71 z71Var) {
        if (z71Var == null) {
            a(131);
        }
        return g0(z71Var, C8277c.C8278a.uLongArrayFqName.j());
    }

    public static boolean y0(@NotNull z71 z71Var) {
        if (z71Var == null) {
            a(SecExceptionCode.SEC_ERROR_INIT_INDEX_ERROR);
        }
        return g0(z71Var, C8277c.C8278a.uShortArrayFqName.j());
    }

    public static boolean z0(@NotNull DeclarationDescriptor declarationDescriptor) {
        if (declarationDescriptor == null) {
            a(10);
        }
        while (declarationDescriptor != null) {
            if (declarationDescriptor instanceof PackageFragmentDescriptor) {
                return ((PackageFragmentDescriptor) declarationDescriptor).getFqName().i(C8277c.BUILT_INS_PACKAGE_NAME);
            }
            declarationDescriptor = declarationDescriptor.getContainingDeclaration();
        }
        return false;
    }

    @NotNull
    public fd2 B() {
        fd2 R = R(PrimitiveType.FLOAT);
        if (R == null) {
            a(60);
        }
        return R;
    }

    @NotNull
    public ClassDescriptor C(int i) {
        return p(C8277c.b(i));
    }

    public void C0(@NotNull ModuleDescriptorImpl moduleDescriptorImpl) {
        if (moduleDescriptorImpl == null) {
            a(1);
        }
        this.f.compute(new C8275d(moduleDescriptorImpl));
    }

    @NotNull
    public fd2 D() {
        fd2 R = R(PrimitiveType.INT);
        if (R == null) {
            a(58);
        }
        return R;
    }

    @NotNull
    public ClassDescriptor E() {
        ClassDescriptor o = o(C8277c.C8278a.kClass.l());
        if (o == null) {
            a(21);
        }
        return o;
    }

    @NotNull
    public fd2 F() {
        fd2 R = R(PrimitiveType.LONG);
        if (R == null) {
            a(59);
        }
        return R;
    }

    @NotNull
    public ClassDescriptor G() {
        return p("Nothing");
    }

    @NotNull
    public fd2 H() {
        fd2 defaultType = G().getDefaultType();
        if (defaultType == null) {
            a(48);
        }
        return defaultType;
    }

    @NotNull
    public fd2 I() {
        fd2 j = i().j(true);
        if (j == null) {
            a(51);
        }
        return j;
    }

    @NotNull
    public fd2 J() {
        fd2 j = H().j(true);
        if (j == null) {
            a(49);
        }
        return j;
    }

    @NotNull
    public ClassDescriptor K() {
        return p("Number");
    }

    @NotNull
    public fd2 L() {
        fd2 defaultType = K().getDefaultType();
        if (defaultType == null) {
            a(55);
        }
        return defaultType;
    }

    @NotNull
    protected PlatformDependentDeclarationFilter M() {
        PlatformDependentDeclarationFilter.C8309b c8309b = PlatformDependentDeclarationFilter.C8309b.INSTANCE;
        if (c8309b == null) {
            a(4);
        }
        return c8309b;
    }

    @NotNull
    public fd2 O(@NotNull PrimitiveType primitiveType) {
        if (primitiveType == null) {
            a(73);
        }
        fd2 fd2Var = this.c.invoke().a.get(primitiveType);
        if (fd2Var == null) {
            a(74);
        }
        return fd2Var;
    }

    @NotNull
    public fd2 R(@NotNull PrimitiveType primitiveType) {
        if (primitiveType == null) {
            a(53);
        }
        fd2 defaultType = Q(primitiveType).getDefaultType();
        if (defaultType == null) {
            a(54);
        }
        return defaultType;
    }

    @NotNull
    public fd2 T() {
        fd2 R = R(PrimitiveType.SHORT);
        if (R == null) {
            a(57);
        }
        return R;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @NotNull
    public StorageManager U() {
        StorageManager storageManager = this.f;
        if (storageManager == null) {
            a(6);
        }
        return storageManager;
    }

    @NotNull
    public ClassDescriptor V() {
        return p("String");
    }

    @NotNull
    public fd2 W() {
        fd2 defaultType = V().getDefaultType();
        if (defaultType == null) {
            a(65);
        }
        return defaultType;
    }

    @NotNull
    public ClassDescriptor X(int i) {
        ClassDescriptor o = o(C8277c.COROUTINES_PACKAGE_FQ_NAME_RELEASE.c(ni1.f(C8277c.d(i))));
        if (o == null) {
            a(18);
        }
        return o;
    }

    @NotNull
    public ClassDescriptor Y() {
        return p("Unit");
    }

    @NotNull
    public fd2 Z() {
        fd2 defaultType = Y().getDefaultType();
        if (defaultType == null) {
            a(64);
        }
        return defaultType;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void f(boolean z) {
        ModuleDescriptorImpl moduleDescriptorImpl = new ModuleDescriptorImpl(BUILTINS_MODULE_NAME, this.f, this, null);
        this.a = moduleDescriptorImpl;
        moduleDescriptorImpl.m(BuiltInsLoader.Companion.a().createPackageFragmentProvider(this.f, this.a, v(), M(), g(), z));
        ModuleDescriptorImpl moduleDescriptorImpl2 = this.a;
        moduleDescriptorImpl2.s(moduleDescriptorImpl2);
    }

    @NotNull
    protected AdditionalClassPartsProvider g() {
        AdditionalClassPartsProvider.C8307a c8307a = AdditionalClassPartsProvider.C8307a.INSTANCE;
        if (c8307a == null) {
            a(3);
        }
        return c8307a;
    }

    @NotNull
    public ClassDescriptor h() {
        return p("Any");
    }

    @NotNull
    public fd2 i() {
        fd2 defaultType = h().getDefaultType();
        if (defaultType == null) {
            a(50);
        }
        return defaultType;
    }

    @NotNull
    public ClassDescriptor j() {
        return p("Array");
    }

    @NotNull
    public z71 k(@NotNull z71 z71Var) {
        z71 A;
        if (z71Var == null) {
            a(67);
        }
        if (c0(z71Var)) {
            if (z71Var.b().size() == 1) {
                z71 type = z71Var.b().get(0).getType();
                if (type == null) {
                    a(68);
                }
                return type;
            }
            throw new IllegalStateException();
        }
        z71 o = fr2.o(z71Var);
        fd2 fd2Var = this.c.invoke().c.get(o);
        if (fd2Var != null) {
            return fd2Var;
        }
        ModuleDescriptor i = d70.i(o);
        if (i == null || (A = A(o, i)) == null) {
            throw new IllegalStateException("not array: " + z71Var);
        }
        return A;
    }

    @NotNull
    public fd2 l(@NotNull Variance variance, @NotNull z71 z71Var) {
        if (variance == null) {
            a(82);
        }
        if (z71Var == null) {
            a(83);
        }
        fd2 m = m(variance, z71Var, Annotations.Companion.b());
        if (m == null) {
            a(84);
        }
        return m;
    }

    @NotNull
    public fd2 m(@NotNull Variance variance, @NotNull z71 z71Var, @NotNull Annotations annotations) {
        if (variance == null) {
            a(78);
        }
        if (z71Var == null) {
            a(79);
        }
        if (annotations == null) {
            a(80);
        }
        fd2 g = KotlinTypeFactory.g(annotations, j(), Collections.singletonList(new zq2(variance, z71Var)));
        if (g == null) {
            a(81);
        }
        return g;
    }

    @NotNull
    public fd2 n() {
        fd2 R = R(PrimitiveType.BOOLEAN);
        if (R == null) {
            a(63);
        }
        return R;
    }

    @NotNull
    public ClassDescriptor o(@NotNull hp0 hp0Var) {
        if (hp0Var == null) {
            a(12);
        }
        ClassDescriptor c = c70.c(r(), hp0Var, NoLookupLocation.FROM_BUILTINS);
        if (c == null) {
            a(13);
        }
        return c;
    }

    @NotNull
    public ModuleDescriptorImpl r() {
        if (this.a == null) {
            this.a = this.b.invoke();
        }
        ModuleDescriptorImpl moduleDescriptorImpl = this.a;
        if (moduleDescriptorImpl == null) {
            a(7);
        }
        return moduleDescriptorImpl;
    }

    @NotNull
    public MemberScope s() {
        MemberScope memberScope = r().getPackage(C8277c.BUILT_INS_PACKAGE_FQ_NAME).getMemberScope();
        if (memberScope == null) {
            a(11);
        }
        return memberScope;
    }

    @NotNull
    public fd2 t() {
        fd2 R = R(PrimitiveType.BYTE);
        if (R == null) {
            a(56);
        }
        return R;
    }

    @NotNull
    public fd2 u() {
        fd2 R = R(PrimitiveType.CHAR);
        if (R == null) {
            a(62);
        }
        return R;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @NotNull
    public Iterable<ClassDescriptorFactory> v() {
        List singletonList = Collections.singletonList(new zd(this.f, r()));
        if (singletonList == null) {
            a(5);
        }
        return singletonList;
    }

    @NotNull
    public ClassDescriptor w() {
        ClassDescriptor o = o(C8277c.C8278a.collection);
        if (o == null) {
            a(34);
        }
        return o;
    }

    @NotNull
    public ClassDescriptor x() {
        return p("Comparable");
    }

    @NotNull
    public fd2 y() {
        fd2 I = I();
        if (I == null) {
            a(52);
        }
        return I;
    }

    @NotNull
    public fd2 z() {
        fd2 R = R(PrimitiveType.DOUBLE);
        if (R == null) {
            a(61);
        }
        return R;
    }
}
