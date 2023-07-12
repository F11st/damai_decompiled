package tb;

import com.youku.arch.v3.event.Subject;
import java.util.Collection;
import java.util.Collections;
import java.util.List;
import java.util.Set;
import kotlin.collections.C8214m;
import kotlin.jvm.functions.Function1;
import kotlin.reflect.jvm.internal.impl.builtins.AbstractC8271b;
import kotlin.reflect.jvm.internal.impl.builtins.C8269a;
import kotlin.reflect.jvm.internal.impl.descriptors.CallableMemberDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.ClassDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.ClassifierDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.DeclarationDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.DeclarationDescriptorVisitor;
import kotlin.reflect.jvm.internal.impl.descriptors.Modality;
import kotlin.reflect.jvm.internal.impl.descriptors.ModuleDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.PackageViewDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.PropertyDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.SimpleFunctionDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.SourceElement;
import kotlin.reflect.jvm.internal.impl.descriptors.TypeParameterDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.annotations.Annotations;
import kotlin.reflect.jvm.internal.impl.incremental.components.LookupLocation;
import kotlin.reflect.jvm.internal.impl.resolve.descriptorUtil.DescriptorUtilsKt;
import kotlin.reflect.jvm.internal.impl.resolve.scopes.MemberScope;
import kotlin.reflect.jvm.internal.impl.types.TypeConstructor;
import kotlin.reflect.jvm.internal.impl.types.TypeProjection;
import kotlin.reflect.jvm.internal.impl.types.TypeSubstitutor;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: Taobao */
/* loaded from: classes3.dex */
public class kf0 {
    private static final PropertyDescriptor d;
    private static final Set<PropertyDescriptor> e;
    private static final ModuleDescriptor a = new C9351a();
    private static final C9353c b = new C9353c(ni1.i("<ERROR CLASS>"));
    public static final fd2 ERROR_TYPE_FOR_LOOP_IN_SUPERTYPES = j("<LOOP IN SUPERTYPES>");
    private static final z71 c = j("<ERROR PROPERTY TYPE>");

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: Taobao */
    /* renamed from: tb.kf0$a */
    /* loaded from: classes3.dex */
    public static class C9351a implements ModuleDescriptor {
        C9351a() {
        }

        /* JADX WARN: Removed duplicated region for block: B:20:0x002c  */
        /* JADX WARN: Removed duplicated region for block: B:24:0x0037  */
        /* JADX WARN: Removed duplicated region for block: B:25:0x003c  */
        /* JADX WARN: Removed duplicated region for block: B:26:0x0041  */
        /* JADX WARN: Removed duplicated region for block: B:27:0x0046  */
        /* JADX WARN: Removed duplicated region for block: B:28:0x004b  */
        /* JADX WARN: Removed duplicated region for block: B:29:0x0050  */
        /* JADX WARN: Removed duplicated region for block: B:32:0x0056  */
        /* JADX WARN: Removed duplicated region for block: B:47:0x008c  */
        /* JADX WARN: Removed duplicated region for block: B:49:0x0093  */
        /* JADX WARN: Removed duplicated region for block: B:50:0x0098  */
        /* JADX WARN: Removed duplicated region for block: B:51:0x009d  */
        /* JADX WARN: Removed duplicated region for block: B:52:0x00a2  */
        /* JADX WARN: Removed duplicated region for block: B:53:0x00a7  */
        /* JADX WARN: Removed duplicated region for block: B:56:0x00af A[ADDED_TO_REGION] */
        /* JADX WARN: Removed duplicated region for block: B:62:0x00bc  */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct code enable 'Show inconsistent code' option in preferences
        */
        private static /* synthetic */ void a(int r12) {
            /*
                Method dump skipped, instructions count: 304
                To view this dump change 'Code comments level' option to 'DEBUG'
            */
            throw new UnsupportedOperationException("Method not decompiled: tb.kf0.C9351a.a(int):void");
        }

        @Override // kotlin.reflect.jvm.internal.impl.descriptors.DeclarationDescriptor
        public <R, D> R accept(@NotNull DeclarationDescriptorVisitor<R, D> declarationDescriptorVisitor, D d) {
            if (declarationDescriptorVisitor == null) {
                a(11);
                return null;
            }
            return null;
        }

        @Override // kotlin.reflect.jvm.internal.impl.descriptors.annotations.Annotated
        @NotNull
        public Annotations getAnnotations() {
            Annotations b = Annotations.Companion.b();
            if (b == null) {
                a(1);
            }
            return b;
        }

        @Override // kotlin.reflect.jvm.internal.impl.descriptors.ModuleDescriptor
        @NotNull
        public AbstractC8271b getBuiltIns() {
            C8269a E0 = C8269a.E0();
            if (E0 == null) {
                a(14);
            }
            return E0;
        }

        @Override // kotlin.reflect.jvm.internal.impl.descriptors.ModuleDescriptor
        @Nullable
        public <T> T getCapability(@NotNull zg1<T> zg1Var) {
            if (zg1Var == null) {
                a(0);
                return null;
            }
            return null;
        }

        @Override // kotlin.reflect.jvm.internal.impl.descriptors.DeclarationDescriptor
        @Nullable
        public DeclarationDescriptor getContainingDeclaration() {
            return null;
        }

        @Override // kotlin.reflect.jvm.internal.impl.descriptors.ModuleDescriptor
        @NotNull
        public List<ModuleDescriptor> getExpectedByModules() {
            List<ModuleDescriptor> g;
            g = C8214m.g();
            if (g == null) {
                a(9);
            }
            return g;
        }

        @Override // kotlin.reflect.jvm.internal.impl.descriptors.Named
        @NotNull
        public ni1 getName() {
            ni1 i = ni1.i("<ERROR MODULE>");
            if (i == null) {
                a(5);
            }
            return i;
        }

        @Override // kotlin.reflect.jvm.internal.impl.descriptors.DeclarationDescriptor
        @NotNull
        public DeclarationDescriptor getOriginal() {
            return this;
        }

        @Override // kotlin.reflect.jvm.internal.impl.descriptors.ModuleDescriptor
        @NotNull
        public PackageViewDescriptor getPackage(@NotNull hp0 hp0Var) {
            if (hp0Var == null) {
                a(7);
            }
            throw new IllegalStateException("Should not be called!");
        }

        @Override // kotlin.reflect.jvm.internal.impl.descriptors.ModuleDescriptor
        @NotNull
        public Collection<hp0> getSubPackagesOf(@NotNull hp0 hp0Var, @NotNull Function1<? super ni1, Boolean> function1) {
            List g;
            if (hp0Var == null) {
                a(2);
            }
            if (function1 == null) {
                a(3);
            }
            g = C8214m.g();
            if (g == null) {
                a(4);
            }
            return g;
        }

        @Override // kotlin.reflect.jvm.internal.impl.descriptors.ModuleDescriptor
        public boolean shouldSeeInternalsOf(@NotNull ModuleDescriptor moduleDescriptor) {
            if (moduleDescriptor == null) {
                a(12);
                return false;
            }
            return false;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: Taobao */
    /* renamed from: tb.kf0$b */
    /* loaded from: classes3.dex */
    public static class C9352b implements TypeConstructor {
        final /* synthetic */ C9353c a;
        final /* synthetic */ String b;

        C9352b(C9353c c9353c, String str) {
            this.a = c9353c;
            this.b = str;
        }

        private static /* synthetic */ void a(int i) {
            String str = i != 3 ? "@NotNull method %s.%s must not return null" : "Argument for @NotNull parameter '%s' of %s.%s must not be null";
            Object[] objArr = new Object[i != 3 ? 2 : 3];
            if (i != 3) {
                objArr[0] = "kotlin/reflect/jvm/internal/impl/types/ErrorUtils$2";
            } else {
                objArr[0] = "kotlinTypeRefiner";
            }
            if (i == 1) {
                objArr[1] = "getSupertypes";
            } else if (i == 2) {
                objArr[1] = "getBuiltIns";
            } else if (i == 3) {
                objArr[1] = "kotlin/reflect/jvm/internal/impl/types/ErrorUtils$2";
            } else if (i != 4) {
                objArr[1] = "getParameters";
            } else {
                objArr[1] = "refine";
            }
            if (i == 3) {
                objArr[2] = "refine";
            }
            String format = String.format(str, objArr);
            if (i == 3) {
                throw new IllegalArgumentException(format);
            }
        }

        @Override // kotlin.reflect.jvm.internal.impl.types.TypeConstructor
        @NotNull
        public AbstractC8271b getBuiltIns() {
            C8269a E0 = C8269a.E0();
            if (E0 == null) {
                a(2);
            }
            return E0;
        }

        @Override // kotlin.reflect.jvm.internal.impl.types.TypeConstructor
        @Nullable
        public ClassifierDescriptor getDeclarationDescriptor() {
            return this.a;
        }

        @Override // kotlin.reflect.jvm.internal.impl.types.TypeConstructor
        @NotNull
        public List<TypeParameterDescriptor> getParameters() {
            List<TypeParameterDescriptor> g;
            g = C8214m.g();
            if (g == null) {
                a(0);
            }
            return g;
        }

        @Override // kotlin.reflect.jvm.internal.impl.types.TypeConstructor
        @NotNull
        public Collection<z71> getSupertypes() {
            List g;
            g = C8214m.g();
            if (g == null) {
                a(1);
            }
            return g;
        }

        @Override // kotlin.reflect.jvm.internal.impl.types.TypeConstructor
        public boolean isDenotable() {
            return false;
        }

        @Override // kotlin.reflect.jvm.internal.impl.types.TypeConstructor
        @NotNull
        public TypeConstructor refine(@NotNull b81 b81Var) {
            if (b81Var == null) {
                a(3);
            }
            return this;
        }

        public String toString() {
            return this.b;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: Taobao */
    /* renamed from: tb.kf0$c */
    /* loaded from: classes3.dex */
    public static class C9353c extends gj {
        /* JADX WARN: Illegal instructions before constructor call */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct code enable 'Show inconsistent code' option in preferences
        */
        public C9353c(@org.jetbrains.annotations.NotNull tb.ni1 r11) {
            /*
                r10 = this;
                if (r11 != 0) goto L6
                r0 = 0
                c(r0)
            L6:
                kotlin.reflect.jvm.internal.impl.descriptors.ModuleDescriptor r2 = tb.kf0.q()
                kotlin.reflect.jvm.internal.impl.descriptors.Modality r4 = kotlin.reflect.jvm.internal.impl.descriptors.Modality.OPEN
                kotlin.reflect.jvm.internal.impl.descriptors.ClassKind r5 = kotlin.reflect.jvm.internal.impl.descriptors.ClassKind.CLASS
                java.util.List r6 = java.util.Collections.emptyList()
                kotlin.reflect.jvm.internal.impl.descriptors.SourceElement r0 = kotlin.reflect.jvm.internal.impl.descriptors.SourceElement.NO_SOURCE
                r8 = 0
                kotlin.reflect.jvm.internal.impl.storage.StorageManager r9 = kotlin.reflect.jvm.internal.impl.storage.LockBasedStorageManager.NO_LOCKS
                r1 = r10
                r3 = r11
                r7 = r0
                r1.<init>(r2, r3, r4, r5, r6, r7, r8, r9)
                kotlin.reflect.jvm.internal.impl.descriptors.annotations.Annotations$a r11 = kotlin.reflect.jvm.internal.impl.descriptors.annotations.Annotations.Companion
                kotlin.reflect.jvm.internal.impl.descriptors.annotations.Annotations r11 = r11.b()
                r1 = 1
                tb.dj r11 = tb.dj.G(r10, r11, r1, r0)
                java.util.List r0 = java.util.Collections.emptyList()
                tb.f70 r1 = tb.e70.INTERNAL
                r11.J(r0, r1)
                tb.ni1 r0 = r10.getName()
                java.lang.String r0 = r0.b()
                kotlin.reflect.jvm.internal.impl.resolve.scopes.MemberScope r0 = tb.kf0.h(r0)
                tb.jf0 r1 = new tb.jf0
                java.lang.String r2 = "<ERROR>"
                kotlin.reflect.jvm.internal.impl.types.TypeConstructor r2 = tb.kf0.d(r2, r10)
                r1.<init>(r2, r0)
                r11.A(r1)
                java.util.Set r1 = java.util.Collections.singleton(r11)
                r10.e(r0, r1, r11)
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: tb.kf0.C9353c.<init>(tb.ni1):void");
        }

        private static /* synthetic */ void c(int i) {
            String str = (i == 2 || i == 5 || i == 8) ? "@NotNull method %s.%s must not return null" : "Argument for @NotNull parameter '%s' of %s.%s must not be null";
            Object[] objArr = new Object[(i == 2 || i == 5 || i == 8) ? 2 : 3];
            switch (i) {
                case 1:
                    objArr[0] = "substitutor";
                    break;
                case 2:
                case 5:
                case 8:
                    objArr[0] = "kotlin/reflect/jvm/internal/impl/types/ErrorUtils$ErrorClassDescriptor";
                    break;
                case 3:
                    objArr[0] = "typeArguments";
                    break;
                case 4:
                case 7:
                    objArr[0] = "kotlinTypeRefiner";
                    break;
                case 6:
                    objArr[0] = "typeSubstitution";
                    break;
                default:
                    objArr[0] = "name";
                    break;
            }
            if (i == 2) {
                objArr[1] = "substitute";
            } else if (i == 5 || i == 8) {
                objArr[1] = "getMemberScope";
            } else {
                objArr[1] = "kotlin/reflect/jvm/internal/impl/types/ErrorUtils$ErrorClassDescriptor";
            }
            switch (i) {
                case 1:
                    objArr[2] = "substitute";
                    break;
                case 2:
                case 5:
                case 8:
                    break;
                case 3:
                case 4:
                case 6:
                case 7:
                    objArr[2] = "getMemberScope";
                    break;
                default:
                    objArr[2] = "<init>";
                    break;
            }
            String format = String.format(str, objArr);
            if (i != 2 && i != 5 && i != 8) {
                throw new IllegalArgumentException(format);
            }
            throw new IllegalStateException(format);
        }

        @Override // tb.l1, tb.wg1
        @NotNull
        public MemberScope a(@NotNull br2 br2Var, @NotNull b81 b81Var) {
            if (br2Var == null) {
                c(6);
            }
            if (b81Var == null) {
                c(7);
            }
            MemberScope h = kf0.h("Error scope for class " + getName() + " with arguments: " + br2Var);
            if (h == null) {
                c(8);
            }
            return h;
        }

        @Override // tb.l1, kotlin.reflect.jvm.internal.impl.descriptors.Substitutable
        @NotNull
        /* renamed from: d */
        public ClassDescriptor substitute(@NotNull TypeSubstitutor typeSubstitutor) {
            if (typeSubstitutor == null) {
                c(1);
            }
            return this;
        }

        @Override // tb.gj
        public String toString() {
            return getName().b();
        }
    }

    /* compiled from: Taobao */
    /* renamed from: tb.kf0$d */
    /* loaded from: classes3.dex */
    public static class C9354d implements MemberScope {
        private final String a;

        /* synthetic */ C9354d(String str, C9351a c9351a) {
            this(str);
        }

        /* JADX WARN: Removed duplicated region for block: B:12:0x0017  */
        /* JADX WARN: Removed duplicated region for block: B:16:0x0022  */
        /* JADX WARN: Removed duplicated region for block: B:17:0x0027  */
        /* JADX WARN: Removed duplicated region for block: B:18:0x002c  */
        /* JADX WARN: Removed duplicated region for block: B:19:0x0031  */
        /* JADX WARN: Removed duplicated region for block: B:20:0x0036  */
        /* JADX WARN: Removed duplicated region for block: B:21:0x0039  */
        /* JADX WARN: Removed duplicated region for block: B:22:0x003e  */
        /* JADX WARN: Removed duplicated region for block: B:25:0x004b  */
        /* JADX WARN: Removed duplicated region for block: B:33:0x0068  */
        /* JADX WARN: Removed duplicated region for block: B:35:0x006d  */
        /* JADX WARN: Removed duplicated region for block: B:36:0x0072  */
        /* JADX WARN: Removed duplicated region for block: B:37:0x0077  */
        /* JADX WARN: Removed duplicated region for block: B:38:0x007c  */
        /* JADX WARN: Removed duplicated region for block: B:39:0x007f  */
        /* JADX WARN: Removed duplicated region for block: B:40:0x0084  */
        /* JADX WARN: Removed duplicated region for block: B:41:0x0087  */
        /* JADX WARN: Removed duplicated region for block: B:42:0x008a  */
        /* JADX WARN: Removed duplicated region for block: B:43:0x008f  */
        /* JADX WARN: Removed duplicated region for block: B:46:0x0099 A[ADDED_TO_REGION] */
        /* JADX WARN: Removed duplicated region for block: B:48:0x009e  */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct code enable 'Show inconsistent code' option in preferences
        */
        private static /* synthetic */ void a(int r10) {
            /*
                r0 = 18
                r1 = 7
                if (r10 == r1) goto Ld
                if (r10 == r0) goto Ld
                switch(r10) {
                    case 10: goto Ld;
                    case 11: goto Ld;
                    case 12: goto Ld;
                    case 13: goto Ld;
                    default: goto La;
                }
            La:
                java.lang.String r2 = "Argument for @NotNull parameter '%s' of %s.%s must not be null"
                goto Lf
            Ld:
                java.lang.String r2 = "@NotNull method %s.%s must not return null"
            Lf:
                r3 = 2
                if (r10 == r1) goto L19
                if (r10 == r0) goto L19
                switch(r10) {
                    case 10: goto L19;
                    case 11: goto L19;
                    case 12: goto L19;
                    case 13: goto L19;
                    default: goto L17;
                }
            L17:
                r4 = 3
                goto L1a
            L19:
                r4 = 2
            L1a:
                java.lang.Object[] r4 = new java.lang.Object[r4]
                java.lang.String r5 = "kotlin/reflect/jvm/internal/impl/types/ErrorUtils$ErrorScope"
                r6 = 0
                switch(r10) {
                    case 1: goto L3e;
                    case 2: goto L39;
                    case 3: goto L3e;
                    case 4: goto L39;
                    case 5: goto L3e;
                    case 6: goto L39;
                    case 7: goto L36;
                    case 8: goto L3e;
                    case 9: goto L39;
                    case 10: goto L36;
                    case 11: goto L36;
                    case 12: goto L36;
                    case 13: goto L36;
                    case 14: goto L3e;
                    case 15: goto L39;
                    case 16: goto L31;
                    case 17: goto L2c;
                    case 18: goto L36;
                    case 19: goto L3e;
                    case 20: goto L27;
                    default: goto L22;
                }
            L22:
                java.lang.String r7 = "debugMessage"
                r4[r6] = r7
                goto L42
            L27:
                java.lang.String r7 = "p"
                r4[r6] = r7
                goto L42
            L2c:
                java.lang.String r7 = "nameFilter"
                r4[r6] = r7
                goto L42
            L31:
                java.lang.String r7 = "kindFilter"
                r4[r6] = r7
                goto L42
            L36:
                r4[r6] = r5
                goto L42
            L39:
                java.lang.String r7 = "location"
                r4[r6] = r7
                goto L42
            L3e:
                java.lang.String r7 = "name"
                r4[r6] = r7
            L42:
                java.lang.String r6 = "getContributedDescriptors"
                java.lang.String r7 = "getContributedFunctions"
                java.lang.String r8 = "getContributedVariables"
                r9 = 1
                if (r10 == r1) goto L68
                if (r10 == r0) goto L65
                switch(r10) {
                    case 10: goto L62;
                    case 11: goto L5d;
                    case 12: goto L58;
                    case 13: goto L53;
                    default: goto L50;
                }
            L50:
                r4[r9] = r5
                goto L6a
            L53:
                java.lang.String r5 = "getClassifierNames"
                r4[r9] = r5
                goto L6a
            L58:
                java.lang.String r5 = "getVariableNames"
                r4[r9] = r5
                goto L6a
            L5d:
                java.lang.String r5 = "getFunctionNames"
                r4[r9] = r5
                goto L6a
            L62:
                r4[r9] = r7
                goto L6a
            L65:
                r4[r9] = r6
                goto L6a
            L68:
                r4[r9] = r8
            L6a:
                switch(r10) {
                    case 1: goto L8f;
                    case 2: goto L8f;
                    case 3: goto L8a;
                    case 4: goto L8a;
                    case 5: goto L87;
                    case 6: goto L87;
                    case 7: goto L93;
                    case 8: goto L84;
                    case 9: goto L84;
                    case 10: goto L93;
                    case 11: goto L93;
                    case 12: goto L93;
                    case 13: goto L93;
                    case 14: goto L7f;
                    case 15: goto L7f;
                    case 16: goto L7c;
                    case 17: goto L7c;
                    case 18: goto L93;
                    case 19: goto L77;
                    case 20: goto L72;
                    default: goto L6d;
                }
            L6d:
                java.lang.String r5 = "<init>"
                r4[r3] = r5
                goto L93
            L72:
                java.lang.String r5 = "printScopeStructure"
                r4[r3] = r5
                goto L93
            L77:
                java.lang.String r5 = "definitelyDoesNotContainName"
                r4[r3] = r5
                goto L93
            L7c:
                r4[r3] = r6
                goto L93
            L7f:
                java.lang.String r5 = "recordLookup"
                r4[r3] = r5
                goto L93
            L84:
                r4[r3] = r7
                goto L93
            L87:
                r4[r3] = r8
                goto L93
            L8a:
                java.lang.String r5 = "getContributedClassifierIncludeDeprecated"
                r4[r3] = r5
                goto L93
            L8f:
                java.lang.String r5 = "getContributedClassifier"
                r4[r3] = r5
            L93:
                java.lang.String r2 = java.lang.String.format(r2, r4)
                if (r10 == r1) goto La4
                if (r10 == r0) goto La4
                switch(r10) {
                    case 10: goto La4;
                    case 11: goto La4;
                    case 12: goto La4;
                    case 13: goto La4;
                    default: goto L9e;
                }
            L9e:
                java.lang.IllegalArgumentException r10 = new java.lang.IllegalArgumentException
                r10.<init>(r2)
                goto La9
            La4:
                java.lang.IllegalStateException r10 = new java.lang.IllegalStateException
                r10.<init>(r2)
            La9:
                throw r10
            */
            throw new UnsupportedOperationException("Method not decompiled: tb.kf0.C9354d.a(int):void");
        }

        @Override // kotlin.reflect.jvm.internal.impl.resolve.scopes.MemberScope, kotlin.reflect.jvm.internal.impl.resolve.scopes.ResolutionScope
        @NotNull
        /* renamed from: b */
        public Set<? extends SimpleFunctionDescriptor> getContributedFunctions(@NotNull ni1 ni1Var, @NotNull LookupLocation lookupLocation) {
            if (ni1Var == null) {
                a(8);
            }
            if (lookupLocation == null) {
                a(9);
            }
            Set<? extends SimpleFunctionDescriptor> singleton = Collections.singleton(kf0.f(this));
            if (singleton == null) {
                a(10);
            }
            return singleton;
        }

        @Override // kotlin.reflect.jvm.internal.impl.resolve.scopes.MemberScope
        @NotNull
        /* renamed from: c */
        public Set<? extends PropertyDescriptor> getContributedVariables(@NotNull ni1 ni1Var, @NotNull LookupLocation lookupLocation) {
            if (ni1Var == null) {
                a(5);
            }
            if (lookupLocation == null) {
                a(6);
            }
            Set<? extends PropertyDescriptor> set = kf0.e;
            if (set == null) {
                a(7);
            }
            return set;
        }

        @Override // kotlin.reflect.jvm.internal.impl.resolve.scopes.MemberScope
        @NotNull
        public Set<ni1> getClassifierNames() {
            Set<ni1> emptySet = Collections.emptySet();
            if (emptySet == null) {
                a(13);
            }
            return emptySet;
        }

        @Override // kotlin.reflect.jvm.internal.impl.resolve.scopes.ResolutionScope
        @Nullable
        public ClassifierDescriptor getContributedClassifier(@NotNull ni1 ni1Var, @NotNull LookupLocation lookupLocation) {
            if (ni1Var == null) {
                a(1);
            }
            if (lookupLocation == null) {
                a(2);
            }
            return kf0.e(ni1Var.b());
        }

        @Override // kotlin.reflect.jvm.internal.impl.resolve.scopes.ResolutionScope
        @NotNull
        public Collection<DeclarationDescriptor> getContributedDescriptors(@NotNull z60 z60Var, @NotNull Function1<? super ni1, Boolean> function1) {
            if (z60Var == null) {
                a(16);
            }
            if (function1 == null) {
                a(17);
            }
            List emptyList = Collections.emptyList();
            if (emptyList == null) {
                a(18);
            }
            return emptyList;
        }

        @Override // kotlin.reflect.jvm.internal.impl.resolve.scopes.MemberScope
        @NotNull
        public Set<ni1> getFunctionNames() {
            Set<ni1> emptySet = Collections.emptySet();
            if (emptySet == null) {
                a(11);
            }
            return emptySet;
        }

        @Override // kotlin.reflect.jvm.internal.impl.resolve.scopes.MemberScope
        @NotNull
        public Set<ni1> getVariableNames() {
            Set<ni1> emptySet = Collections.emptySet();
            if (emptySet == null) {
                a(12);
            }
            return emptySet;
        }

        @Override // kotlin.reflect.jvm.internal.impl.resolve.scopes.ResolutionScope
        public void recordLookup(@NotNull ni1 ni1Var, @NotNull LookupLocation lookupLocation) {
            if (ni1Var == null) {
                a(14);
            }
            if (lookupLocation == null) {
                a(15);
            }
        }

        public String toString() {
            return "ErrorScope{" + this.a + '}';
        }

        private C9354d(@NotNull String str) {
            if (str == null) {
                a(0);
            }
            this.a = str;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: Taobao */
    /* renamed from: tb.kf0$e */
    /* loaded from: classes3.dex */
    public static class C9355e implements MemberScope {
        private final String a;

        /* synthetic */ C9355e(String str, C9351a c9351a) {
            this(str);
        }

        private static /* synthetic */ void a(int i) {
            Object[] objArr = new Object[3];
            switch (i) {
                case 1:
                case 3:
                case 5:
                case 7:
                case 11:
                case 13:
                    objArr[0] = "name";
                    break;
                case 2:
                case 4:
                case 6:
                case 8:
                case 12:
                    objArr[0] = "location";
                    break;
                case 9:
                    objArr[0] = "kindFilter";
                    break;
                case 10:
                    objArr[0] = "nameFilter";
                    break;
                case 14:
                    objArr[0] = "p";
                    break;
                default:
                    objArr[0] = "message";
                    break;
            }
            objArr[1] = "kotlin/reflect/jvm/internal/impl/types/ErrorUtils$ThrowingScope";
            switch (i) {
                case 1:
                case 2:
                    objArr[2] = "getContributedClassifier";
                    break;
                case 3:
                case 4:
                    objArr[2] = "getContributedClassifierIncludeDeprecated";
                    break;
                case 5:
                case 6:
                    objArr[2] = "getContributedVariables";
                    break;
                case 7:
                case 8:
                    objArr[2] = "getContributedFunctions";
                    break;
                case 9:
                case 10:
                    objArr[2] = "getContributedDescriptors";
                    break;
                case 11:
                case 12:
                    objArr[2] = "recordLookup";
                    break;
                case 13:
                    objArr[2] = "definitelyDoesNotContainName";
                    break;
                case 14:
                    objArr[2] = "printScopeStructure";
                    break;
                default:
                    objArr[2] = "<init>";
                    break;
            }
            throw new IllegalArgumentException(String.format("Argument for @NotNull parameter '%s' of %s.%s must not be null", objArr));
        }

        @Override // kotlin.reflect.jvm.internal.impl.resolve.scopes.MemberScope
        public Set<ni1> getClassifierNames() {
            throw new IllegalStateException();
        }

        @Override // kotlin.reflect.jvm.internal.impl.resolve.scopes.ResolutionScope
        @Nullable
        public ClassifierDescriptor getContributedClassifier(@NotNull ni1 ni1Var, @NotNull LookupLocation lookupLocation) {
            if (ni1Var == null) {
                a(1);
            }
            if (lookupLocation == null) {
                a(2);
            }
            throw new IllegalStateException(this.a + ", required name: " + ni1Var);
        }

        @Override // kotlin.reflect.jvm.internal.impl.resolve.scopes.ResolutionScope
        @NotNull
        public Collection<DeclarationDescriptor> getContributedDescriptors(@NotNull z60 z60Var, @NotNull Function1<? super ni1, Boolean> function1) {
            if (z60Var == null) {
                a(9);
            }
            if (function1 == null) {
                a(10);
            }
            throw new IllegalStateException(this.a);
        }

        @Override // kotlin.reflect.jvm.internal.impl.resolve.scopes.MemberScope, kotlin.reflect.jvm.internal.impl.resolve.scopes.ResolutionScope
        @NotNull
        public Collection<? extends SimpleFunctionDescriptor> getContributedFunctions(@NotNull ni1 ni1Var, @NotNull LookupLocation lookupLocation) {
            if (ni1Var == null) {
                a(7);
            }
            if (lookupLocation == null) {
                a(8);
            }
            throw new IllegalStateException(this.a + ", required name: " + ni1Var);
        }

        @Override // kotlin.reflect.jvm.internal.impl.resolve.scopes.MemberScope
        @NotNull
        public Collection<? extends PropertyDescriptor> getContributedVariables(@NotNull ni1 ni1Var, @NotNull LookupLocation lookupLocation) {
            if (ni1Var == null) {
                a(5);
            }
            if (lookupLocation == null) {
                a(6);
            }
            throw new IllegalStateException(this.a + ", required name: " + ni1Var);
        }

        @Override // kotlin.reflect.jvm.internal.impl.resolve.scopes.MemberScope
        @NotNull
        public Set<ni1> getFunctionNames() {
            throw new IllegalStateException();
        }

        @Override // kotlin.reflect.jvm.internal.impl.resolve.scopes.MemberScope
        @NotNull
        public Set<ni1> getVariableNames() {
            throw new IllegalStateException();
        }

        @Override // kotlin.reflect.jvm.internal.impl.resolve.scopes.ResolutionScope
        public void recordLookup(@NotNull ni1 ni1Var, @NotNull LookupLocation lookupLocation) {
            if (ni1Var == null) {
                a(11);
            }
            if (lookupLocation == null) {
                a(12);
            }
            throw new IllegalStateException();
        }

        public String toString() {
            return "ThrowingScope{" + this.a + '}';
        }

        private C9355e(@NotNull String str) {
            if (str == null) {
                a(0);
            }
            this.a = str;
        }
    }

    /* compiled from: Taobao */
    /* renamed from: tb.kf0$f */
    /* loaded from: classes3.dex */
    public static class C9356f implements TypeConstructor {
        private final TypeParameterDescriptor a;
        private final TypeConstructor b;

        private static /* synthetic */ void a(int i) {
            String str = (i == 1 || i == 2 || i == 3 || i == 4 || i == 6) ? "@NotNull method %s.%s must not return null" : "Argument for @NotNull parameter '%s' of %s.%s must not be null";
            Object[] objArr = new Object[(i == 1 || i == 2 || i == 3 || i == 4 || i == 6) ? 2 : 3];
            switch (i) {
                case 1:
                case 2:
                case 3:
                case 4:
                case 6:
                    objArr[0] = "kotlin/reflect/jvm/internal/impl/types/ErrorUtils$UninferredParameterTypeConstructor";
                    break;
                case 5:
                    objArr[0] = "kotlinTypeRefiner";
                    break;
                default:
                    objArr[0] = "descriptor";
                    break;
            }
            if (i == 1) {
                objArr[1] = "getTypeParameterDescriptor";
            } else if (i == 2) {
                objArr[1] = "getParameters";
            } else if (i == 3) {
                objArr[1] = "getSupertypes";
            } else if (i == 4) {
                objArr[1] = "getBuiltIns";
            } else if (i != 6) {
                objArr[1] = "kotlin/reflect/jvm/internal/impl/types/ErrorUtils$UninferredParameterTypeConstructor";
            } else {
                objArr[1] = "refine";
            }
            switch (i) {
                case 1:
                case 2:
                case 3:
                case 4:
                case 6:
                    break;
                case 5:
                    objArr[2] = "refine";
                    break;
                default:
                    objArr[2] = "<init>";
                    break;
            }
            String format = String.format(str, objArr);
            if (i != 1 && i != 2 && i != 3 && i != 4 && i != 6) {
                throw new IllegalArgumentException(format);
            }
            throw new IllegalStateException(format);
        }

        @NotNull
        public TypeParameterDescriptor b() {
            TypeParameterDescriptor typeParameterDescriptor = this.a;
            if (typeParameterDescriptor == null) {
                a(1);
            }
            return typeParameterDescriptor;
        }

        @Override // kotlin.reflect.jvm.internal.impl.types.TypeConstructor
        @NotNull
        public AbstractC8271b getBuiltIns() {
            AbstractC8271b g = DescriptorUtilsKt.g(this.a);
            if (g == null) {
                a(4);
            }
            return g;
        }

        @Override // kotlin.reflect.jvm.internal.impl.types.TypeConstructor
        @Nullable
        public ClassifierDescriptor getDeclarationDescriptor() {
            return this.b.getDeclarationDescriptor();
        }

        @Override // kotlin.reflect.jvm.internal.impl.types.TypeConstructor
        @NotNull
        public List<TypeParameterDescriptor> getParameters() {
            List<TypeParameterDescriptor> parameters = this.b.getParameters();
            if (parameters == null) {
                a(2);
            }
            return parameters;
        }

        @Override // kotlin.reflect.jvm.internal.impl.types.TypeConstructor
        @NotNull
        public Collection<z71> getSupertypes() {
            Collection<z71> supertypes = this.b.getSupertypes();
            if (supertypes == null) {
                a(3);
            }
            return supertypes;
        }

        @Override // kotlin.reflect.jvm.internal.impl.types.TypeConstructor
        public boolean isDenotable() {
            return this.b.isDenotable();
        }

        @Override // kotlin.reflect.jvm.internal.impl.types.TypeConstructor
        @NotNull
        public TypeConstructor refine(@NotNull b81 b81Var) {
            if (b81Var == null) {
                a(5);
            }
            return this;
        }
    }

    static {
        bx1 g = g();
        d = g;
        e = Collections.singleton(g);
    }

    private static /* synthetic */ void a(int i) {
        String str = (i == 4 || i == 6 || i == 19) ? "@NotNull method %s.%s must not return null" : "Argument for @NotNull parameter '%s' of %s.%s must not be null";
        Object[] objArr = new Object[(i == 4 || i == 6 || i == 19) ? 2 : 3];
        switch (i) {
            case 1:
            case 2:
            case 3:
            case 7:
            case 11:
            case 15:
                objArr[0] = "debugMessage";
                break;
            case 4:
            case 6:
            case 19:
                objArr[0] = "kotlin/reflect/jvm/internal/impl/types/ErrorUtils";
                break;
            case 5:
                objArr[0] = "ownerScope";
                break;
            case 8:
            case 9:
            case 16:
            case 17:
                objArr[0] = "debugName";
                break;
            case 10:
                objArr[0] = "typeConstructor";
                break;
            case 12:
            case 14:
                objArr[0] = "arguments";
                break;
            case 13:
                objArr[0] = "presentableName";
                break;
            case 18:
                objArr[0] = "errorClass";
                break;
            case 20:
                objArr[0] = "typeParameterDescriptor";
                break;
            default:
                objArr[0] = Subject.FUNCTION;
                break;
        }
        if (i == 4) {
            objArr[1] = "createErrorProperty";
        } else if (i == 6) {
            objArr[1] = "createErrorFunction";
        } else if (i != 19) {
            objArr[1] = "kotlin/reflect/jvm/internal/impl/types/ErrorUtils";
        } else {
            objArr[1] = "getErrorModule";
        }
        switch (i) {
            case 1:
                objArr[2] = "createErrorClass";
                break;
            case 2:
            case 3:
                objArr[2] = "createErrorScope";
                break;
            case 4:
            case 6:
            case 19:
                break;
            case 5:
                objArr[2] = "createErrorFunction";
                break;
            case 7:
                objArr[2] = "createErrorType";
                break;
            case 8:
                objArr[2] = "createErrorTypeWithCustomDebugName";
                break;
            case 9:
            case 10:
                objArr[2] = "createErrorTypeWithCustomConstructor";
                break;
            case 11:
            case 12:
                objArr[2] = "createErrorTypeWithArguments";
                break;
            case 13:
            case 14:
                objArr[2] = "createUnresolvedType";
                break;
            case 15:
                objArr[2] = "createErrorTypeConstructor";
                break;
            case 16:
            case 17:
            case 18:
                objArr[2] = "createErrorTypeConstructorWithCustomDebugName";
                break;
            case 20:
                objArr[2] = "createUninferredParameterType";
                break;
            default:
                objArr[2] = "containsErrorTypeInParameters";
                break;
        }
        String format = String.format(str, objArr);
        if (i != 4 && i != 6 && i != 19) {
            throw new IllegalArgumentException(format);
        }
        throw new IllegalStateException(format);
    }

    @NotNull
    public static ClassDescriptor e(@NotNull String str) {
        if (str == null) {
            a(1);
        }
        return new C9353c(ni1.i("<ERROR CLASS: " + str + jn1.G));
    }

    /* JADX INFO: Access modifiers changed from: private */
    @NotNull
    public static SimpleFunctionDescriptor f(@NotNull C9354d c9354d) {
        if (c9354d == null) {
            a(5);
        }
        if0 if0Var = new if0(b, c9354d);
        if0Var.l(null, null, Collections.emptyList(), Collections.emptyList(), j("<ERROR FUNCTION RETURN TYPE>"), Modality.OPEN, e70.PUBLIC);
        return if0Var;
    }

    @NotNull
    private static bx1 g() {
        bx1 h = bx1.h(b, Annotations.Companion.b(), Modality.OPEN, e70.PUBLIC, true, ni1.i("<ERROR PROPERTY>"), CallableMemberDescriptor.Kind.DECLARATION, SourceElement.NO_SOURCE, false, false, false, false, false, false);
        h.t(c, Collections.emptyList(), null, null);
        return h;
    }

    @NotNull
    public static MemberScope h(@NotNull String str) {
        if (str == null) {
            a(2);
        }
        return i(str, false);
    }

    @NotNull
    public static MemberScope i(@NotNull String str, boolean z) {
        if (str == null) {
            a(3);
        }
        if (z) {
            return new C9355e(str, null);
        }
        return new C9354d(str, null);
    }

    @NotNull
    public static fd2 j(@NotNull String str) {
        if (str == null) {
            a(7);
        }
        return n(str, Collections.emptyList());
    }

    @NotNull
    public static TypeConstructor k(@NotNull String str) {
        if (str == null) {
            a(15);
        }
        return m("[ERROR : " + str + jn1.ARRAY_END_STR, b);
    }

    @NotNull
    public static TypeConstructor l(@NotNull String str) {
        if (str == null) {
            a(16);
        }
        return m(str, b);
    }

    /* JADX INFO: Access modifiers changed from: private */
    @NotNull
    public static TypeConstructor m(@NotNull String str, @NotNull C9353c c9353c) {
        if (str == null) {
            a(17);
        }
        if (c9353c == null) {
            a(18);
        }
        return new C9352b(c9353c, str);
    }

    @NotNull
    public static fd2 n(@NotNull String str, @NotNull List<TypeProjection> list) {
        if (str == null) {
            a(11);
        }
        if (list == null) {
            a(12);
        }
        return new jf0(k(str), h(str), list, false);
    }

    @NotNull
    public static fd2 o(@NotNull String str, @NotNull TypeConstructor typeConstructor) {
        if (str == null) {
            a(9);
        }
        if (typeConstructor == null) {
            a(10);
        }
        return new jf0(typeConstructor, h(str));
    }

    @NotNull
    public static fd2 p(@NotNull String str) {
        if (str == null) {
            a(8);
        }
        return o(str, l(str));
    }

    @NotNull
    public static ModuleDescriptor q() {
        ModuleDescriptor moduleDescriptor = a;
        if (moduleDescriptor == null) {
            a(19);
        }
        return moduleDescriptor;
    }

    public static boolean r(@Nullable DeclarationDescriptor declarationDescriptor) {
        if (declarationDescriptor == null) {
            return false;
        }
        return s(declarationDescriptor) || s(declarationDescriptor.getContainingDeclaration()) || declarationDescriptor == a;
    }

    private static boolean s(@Nullable DeclarationDescriptor declarationDescriptor) {
        return declarationDescriptor instanceof C9353c;
    }

    public static boolean t(@Nullable z71 z71Var) {
        return z71Var != null && (z71Var.c() instanceof C9356f);
    }
}
