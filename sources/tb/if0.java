package tb;

import java.util.Collection;
import java.util.List;
import kotlin.reflect.jvm.internal.impl.descriptors.CallableDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.CallableMemberDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.ClassDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.DeclarationDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.FunctionDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.Modality;
import kotlin.reflect.jvm.internal.impl.descriptors.ReceiverParameterDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.SimpleFunctionDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.SourceElement;
import kotlin.reflect.jvm.internal.impl.descriptors.TypeParameterDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.ValueParameterDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.annotations.Annotations;
import kotlin.reflect.jvm.internal.impl.descriptors.impl.AbstractC8316a;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import tb.kf0;

/* compiled from: Taobao */
/* loaded from: classes3.dex */
public class if0 extends cd2 {

    /* compiled from: Taobao */
    /* renamed from: tb.if0$a */
    /* loaded from: classes3.dex */
    class C9261a implements FunctionDescriptor.CopyBuilder<SimpleFunctionDescriptor> {
        C9261a() {
        }

        /* JADX WARN: Removed duplicated region for block: B:104:0x0151  */
        /* JADX WARN: Removed duplicated region for block: B:30:0x004c  */
        /* JADX WARN: Removed duplicated region for block: B:34:0x0058  */
        /* JADX WARN: Removed duplicated region for block: B:35:0x005d  */
        /* JADX WARN: Removed duplicated region for block: B:36:0x0062  */
        /* JADX WARN: Removed duplicated region for block: B:37:0x0067  */
        /* JADX WARN: Removed duplicated region for block: B:38:0x006c  */
        /* JADX WARN: Removed duplicated region for block: B:39:0x0071  */
        /* JADX WARN: Removed duplicated region for block: B:40:0x0076  */
        /* JADX WARN: Removed duplicated region for block: B:41:0x007b  */
        /* JADX WARN: Removed duplicated region for block: B:42:0x0080  */
        /* JADX WARN: Removed duplicated region for block: B:43:0x0085  */
        /* JADX WARN: Removed duplicated region for block: B:44:0x008a  */
        /* JADX WARN: Removed duplicated region for block: B:47:0x009e  */
        /* JADX WARN: Removed duplicated region for block: B:78:0x0109  */
        /* JADX WARN: Removed duplicated region for block: B:80:0x010e  */
        /* JADX WARN: Removed duplicated region for block: B:81:0x0111  */
        /* JADX WARN: Removed duplicated region for block: B:82:0x0116  */
        /* JADX WARN: Removed duplicated region for block: B:83:0x011b  */
        /* JADX WARN: Removed duplicated region for block: B:84:0x0120  */
        /* JADX WARN: Removed duplicated region for block: B:85:0x0123  */
        /* JADX WARN: Removed duplicated region for block: B:86:0x0126  */
        /* JADX WARN: Removed duplicated region for block: B:87:0x0129  */
        /* JADX WARN: Removed duplicated region for block: B:88:0x012c  */
        /* JADX WARN: Removed duplicated region for block: B:89:0x012f  */
        /* JADX WARN: Removed duplicated region for block: B:90:0x0132  */
        /* JADX WARN: Removed duplicated region for block: B:93:0x013a A[ADDED_TO_REGION] */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct code enable 'Show inconsistent code' option in preferences
        */
        private static /* synthetic */ void a(int r24) {
            /*
                Method dump skipped, instructions count: 566
                To view this dump change 'Code comments level' option to 'DEBUG'
            */
            throw new UnsupportedOperationException("Method not decompiled: tb.if0.C9261a.a(int):void");
        }

        @Override // kotlin.reflect.jvm.internal.impl.descriptors.FunctionDescriptor.CopyBuilder
        @Nullable
        /* renamed from: b */
        public SimpleFunctionDescriptor build() {
            return if0.this;
        }

        @Override // kotlin.reflect.jvm.internal.impl.descriptors.FunctionDescriptor.CopyBuilder
        @NotNull
        public FunctionDescriptor.CopyBuilder<SimpleFunctionDescriptor> setAdditionalAnnotations(@NotNull Annotations annotations) {
            if (annotations == null) {
                a(29);
            }
            return this;
        }

        @Override // kotlin.reflect.jvm.internal.impl.descriptors.FunctionDescriptor.CopyBuilder
        @NotNull
        public FunctionDescriptor.CopyBuilder<SimpleFunctionDescriptor> setCopyOverrides(boolean z) {
            return this;
        }

        @Override // kotlin.reflect.jvm.internal.impl.descriptors.FunctionDescriptor.CopyBuilder
        @NotNull
        public FunctionDescriptor.CopyBuilder<SimpleFunctionDescriptor> setDispatchReceiverParameter(@Nullable ReceiverParameterDescriptor receiverParameterDescriptor) {
            return this;
        }

        @Override // kotlin.reflect.jvm.internal.impl.descriptors.FunctionDescriptor.CopyBuilder
        @NotNull
        public FunctionDescriptor.CopyBuilder<SimpleFunctionDescriptor> setDropOriginalInContainingParts() {
            return this;
        }

        @Override // kotlin.reflect.jvm.internal.impl.descriptors.FunctionDescriptor.CopyBuilder
        @NotNull
        public FunctionDescriptor.CopyBuilder<SimpleFunctionDescriptor> setExtensionReceiverParameter(@Nullable ReceiverParameterDescriptor receiverParameterDescriptor) {
            return this;
        }

        @Override // kotlin.reflect.jvm.internal.impl.descriptors.FunctionDescriptor.CopyBuilder
        @NotNull
        public FunctionDescriptor.CopyBuilder<SimpleFunctionDescriptor> setHiddenForResolutionEverywhereBesideSupercalls() {
            return this;
        }

        @Override // kotlin.reflect.jvm.internal.impl.descriptors.FunctionDescriptor.CopyBuilder
        @NotNull
        public FunctionDescriptor.CopyBuilder<SimpleFunctionDescriptor> setHiddenToOvercomeSignatureClash() {
            return this;
        }

        @Override // kotlin.reflect.jvm.internal.impl.descriptors.FunctionDescriptor.CopyBuilder
        @NotNull
        public FunctionDescriptor.CopyBuilder<SimpleFunctionDescriptor> setKind(@NotNull CallableMemberDescriptor.Kind kind) {
            if (kind == null) {
                a(6);
            }
            return this;
        }

        @Override // kotlin.reflect.jvm.internal.impl.descriptors.FunctionDescriptor.CopyBuilder
        @NotNull
        public FunctionDescriptor.CopyBuilder<SimpleFunctionDescriptor> setModality(@NotNull Modality modality) {
            if (modality == null) {
                a(2);
            }
            return this;
        }

        @Override // kotlin.reflect.jvm.internal.impl.descriptors.FunctionDescriptor.CopyBuilder
        @NotNull
        public FunctionDescriptor.CopyBuilder<SimpleFunctionDescriptor> setName(@NotNull ni1 ni1Var) {
            if (ni1Var == null) {
                a(9);
            }
            return this;
        }

        @Override // kotlin.reflect.jvm.internal.impl.descriptors.FunctionDescriptor.CopyBuilder
        @NotNull
        public FunctionDescriptor.CopyBuilder<SimpleFunctionDescriptor> setOriginal(@Nullable CallableMemberDescriptor callableMemberDescriptor) {
            return this;
        }

        @Override // kotlin.reflect.jvm.internal.impl.descriptors.FunctionDescriptor.CopyBuilder
        @NotNull
        public FunctionDescriptor.CopyBuilder<SimpleFunctionDescriptor> setOwner(@NotNull DeclarationDescriptor declarationDescriptor) {
            if (declarationDescriptor == null) {
                a(0);
            }
            return this;
        }

        @Override // kotlin.reflect.jvm.internal.impl.descriptors.FunctionDescriptor.CopyBuilder
        @NotNull
        public FunctionDescriptor.CopyBuilder<SimpleFunctionDescriptor> setPreserveSourceElement() {
            return this;
        }

        @Override // kotlin.reflect.jvm.internal.impl.descriptors.FunctionDescriptor.CopyBuilder
        @NotNull
        public FunctionDescriptor.CopyBuilder<SimpleFunctionDescriptor> setReturnType(@NotNull z71 z71Var) {
            if (z71Var == null) {
                a(19);
            }
            return this;
        }

        @Override // kotlin.reflect.jvm.internal.impl.descriptors.FunctionDescriptor.CopyBuilder
        @NotNull
        public FunctionDescriptor.CopyBuilder<SimpleFunctionDescriptor> setSignatureChange() {
            return this;
        }

        @Override // kotlin.reflect.jvm.internal.impl.descriptors.FunctionDescriptor.CopyBuilder
        @NotNull
        public FunctionDescriptor.CopyBuilder<SimpleFunctionDescriptor> setSubstitution(@NotNull br2 br2Var) {
            if (br2Var == null) {
                a(13);
            }
            return this;
        }

        @Override // kotlin.reflect.jvm.internal.impl.descriptors.FunctionDescriptor.CopyBuilder
        @NotNull
        public FunctionDescriptor.CopyBuilder<SimpleFunctionDescriptor> setTypeParameters(@NotNull List<TypeParameterDescriptor> list) {
            if (list == null) {
                a(17);
            }
            return this;
        }

        @Override // kotlin.reflect.jvm.internal.impl.descriptors.FunctionDescriptor.CopyBuilder
        @NotNull
        public FunctionDescriptor.CopyBuilder<SimpleFunctionDescriptor> setValueParameters(@NotNull List<ValueParameterDescriptor> list) {
            if (list == null) {
                a(11);
            }
            return this;
        }

        @Override // kotlin.reflect.jvm.internal.impl.descriptors.FunctionDescriptor.CopyBuilder
        @NotNull
        public FunctionDescriptor.CopyBuilder<SimpleFunctionDescriptor> setVisibility(@NotNull f70 f70Var) {
            if (f70Var == null) {
                a(4);
            }
            return this;
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public if0(@NotNull ClassDescriptor classDescriptor, @NotNull kf0.C9354d c9354d) {
        super(classDescriptor, null, Annotations.Companion.b(), ni1.i("<ERROR FUNCTION>"), CallableMemberDescriptor.Kind.DECLARATION, SourceElement.NO_SOURCE);
        if (classDescriptor == null) {
            a(0);
        }
        if (c9354d == null) {
            a(1);
        }
    }

    private static /* synthetic */ void a(int i) {
        String str = (i == 6 || i == 7) ? "@NotNull method %s.%s must not return null" : "Argument for @NotNull parameter '%s' of %s.%s must not be null";
        Object[] objArr = new Object[(i == 6 || i == 7) ? 2 : 3];
        switch (i) {
            case 1:
                objArr[0] = "ownerScope";
                break;
            case 2:
                objArr[0] = "newOwner";
                break;
            case 3:
                objArr[0] = "kind";
                break;
            case 4:
                objArr[0] = "annotations";
                break;
            case 5:
                objArr[0] = "source";
                break;
            case 6:
            case 7:
                objArr[0] = "kotlin/reflect/jvm/internal/impl/types/error/ErrorSimpleFunctionDescriptorImpl";
                break;
            case 8:
                objArr[0] = "overriddenDescriptors";
                break;
            default:
                objArr[0] = "containingDeclaration";
                break;
        }
        if (i == 6) {
            objArr[1] = "createSubstitutedCopy";
        } else if (i != 7) {
            objArr[1] = "kotlin/reflect/jvm/internal/impl/types/error/ErrorSimpleFunctionDescriptorImpl";
        } else {
            objArr[1] = rz0.ARG_COPY;
        }
        switch (i) {
            case 2:
            case 3:
            case 4:
            case 5:
                objArr[2] = "createSubstitutedCopy";
                break;
            case 6:
            case 7:
                break;
            case 8:
                objArr[2] = "setOverriddenDescriptors";
                break;
            default:
                objArr[2] = "<init>";
                break;
        }
        String format = String.format(str, objArr);
        if (i != 6 && i != 7) {
            throw new IllegalArgumentException(format);
        }
        throw new IllegalStateException(format);
    }

    @Override // tb.cd2, kotlin.reflect.jvm.internal.impl.descriptors.impl.AbstractC8316a
    @NotNull
    /* renamed from: E */
    public SimpleFunctionDescriptor e(DeclarationDescriptor declarationDescriptor, Modality modality, f70 f70Var, CallableMemberDescriptor.Kind kind, boolean z) {
        return this;
    }

    @Override // tb.cd2, kotlin.reflect.jvm.internal.impl.descriptors.impl.AbstractC8316a
    @NotNull
    protected AbstractC8316a f(@NotNull DeclarationDescriptor declarationDescriptor, @Nullable FunctionDescriptor functionDescriptor, @NotNull CallableMemberDescriptor.Kind kind, @Nullable ni1 ni1Var, @NotNull Annotations annotations, @NotNull SourceElement sourceElement) {
        if (declarationDescriptor == null) {
            a(2);
        }
        if (kind == null) {
            a(3);
        }
        if (annotations == null) {
            a(4);
        }
        if (sourceElement == null) {
            a(5);
        }
        return this;
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.impl.AbstractC8316a, kotlin.reflect.jvm.internal.impl.descriptors.CallableDescriptor
    public <V> V getUserData(CallableDescriptor.UserDataKey<V> userDataKey) {
        return null;
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.impl.AbstractC8316a, kotlin.reflect.jvm.internal.impl.descriptors.FunctionDescriptor
    public boolean isSuspend() {
        return false;
    }

    @Override // tb.cd2, kotlin.reflect.jvm.internal.impl.descriptors.impl.AbstractC8316a, kotlin.reflect.jvm.internal.impl.descriptors.FunctionDescriptor
    @NotNull
    public FunctionDescriptor.CopyBuilder<? extends SimpleFunctionDescriptor> newCopyBuilder() {
        return new C9261a();
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.impl.AbstractC8316a, kotlin.reflect.jvm.internal.impl.descriptors.CallableMemberDescriptor
    public void setOverriddenDescriptors(@NotNull Collection<? extends CallableMemberDescriptor> collection) {
        if (collection == null) {
            a(8);
        }
    }
}
