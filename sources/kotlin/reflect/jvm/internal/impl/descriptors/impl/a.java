package kotlin.reflect.jvm.internal.impl.descriptors.impl;

import com.meizu.cloud.pushsdk.constants.PushConstants;
import com.youku.live.dago.liveplayback.widget.pip.PipUtils;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.jvm.functions.Function0;
import kotlin.reflect.jvm.internal.impl.descriptors.CallableDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.CallableMemberDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.DeclarationDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.DeclarationDescriptorVisitor;
import kotlin.reflect.jvm.internal.impl.descriptors.FunctionDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.Modality;
import kotlin.reflect.jvm.internal.impl.descriptors.ReceiverParameterDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.SourceElement;
import kotlin.reflect.jvm.internal.impl.descriptors.TypeParameterDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.ValueParameterDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.VariableDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.annotations.Annotations;
import kotlin.reflect.jvm.internal.impl.descriptors.impl.ValueParameterDescriptorImpl;
import kotlin.reflect.jvm.internal.impl.types.TypeSubstitutor;
import kotlin.reflect.jvm.internal.impl.types.Variance;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import tb.b70;
import tb.br2;
import tb.dh0;
import tb.e70;
import tb.f6;
import tb.f70;
import tb.iz1;
import tb.ni1;
import tb.rz0;
import tb.u40;
import tb.xd2;
import tb.z71;

/* compiled from: Taobao */
/* loaded from: classes3.dex */
public abstract class a extends u40 implements FunctionDescriptor {
    private final CallableMemberDescriptor.Kind A;
    @Nullable
    private FunctionDescriptor B;
    protected Map<CallableDescriptor.UserDataKey<?>, Object> C;
    private List<TypeParameterDescriptor> e;
    private List<ValueParameterDescriptor> f;
    private z71 g;
    private ReceiverParameterDescriptor h;
    private ReceiverParameterDescriptor i;
    private Modality j;
    private f70 k;
    private boolean l;
    private boolean m;
    private boolean n;
    private boolean o;
    private boolean p;
    private boolean q;
    private boolean r;
    private boolean s;
    private boolean t;
    private boolean u;
    private boolean v;
    private boolean w;
    private Collection<? extends FunctionDescriptor> x;
    private volatile Function0<Collection<FunctionDescriptor>> y;
    private final FunctionDescriptor z;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: Taobao */
    /* renamed from: kotlin.reflect.jvm.internal.impl.descriptors.impl.a$a  reason: collision with other inner class name */
    /* loaded from: classes3.dex */
    public class C0415a implements Function0<Collection<FunctionDescriptor>> {
        final /* synthetic */ TypeSubstitutor a;

        C0415a(TypeSubstitutor typeSubstitutor) {
            this.a = typeSubstitutor;
        }

        @Override // kotlin.jvm.functions.Function0
        /* renamed from: a */
        public Collection<FunctionDescriptor> invoke() {
            xd2 xd2Var = new xd2();
            for (FunctionDescriptor functionDescriptor : a.this.getOverriddenDescriptors()) {
                xd2Var.add(functionDescriptor.substitute(this.a));
            }
            return xd2Var;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: Taobao */
    /* loaded from: classes3.dex */
    public static class b implements Function0<List<VariableDescriptor>> {
        final /* synthetic */ List a;

        b(List list) {
            this.a = list;
        }

        @Override // kotlin.jvm.functions.Function0
        /* renamed from: a */
        public List<VariableDescriptor> invoke() {
            return this.a;
        }
    }

    /* compiled from: Taobao */
    /* loaded from: classes3.dex */
    public class c implements FunctionDescriptor.CopyBuilder<FunctionDescriptor> {
        @NotNull
        protected br2 a;
        @NotNull
        protected DeclarationDescriptor b;
        @NotNull
        protected Modality c;
        @NotNull
        protected f70 d;
        @Nullable
        protected FunctionDescriptor e;
        @NotNull
        protected CallableMemberDescriptor.Kind f;
        @NotNull
        protected List<ValueParameterDescriptor> g;
        @Nullable
        protected ReceiverParameterDescriptor h;
        @Nullable
        protected ReceiverParameterDescriptor i;
        @NotNull
        protected z71 j;
        @Nullable
        protected ni1 k;
        protected boolean l;
        protected boolean m;
        protected boolean n;
        protected boolean o;
        private boolean p;
        private List<TypeParameterDescriptor> q;
        private Annotations r;
        private boolean s;
        private Map<CallableDescriptor.UserDataKey<?>, Object> t;
        private Boolean u;
        protected boolean v;
        final /* synthetic */ a w;

        public c(@NotNull a aVar, @NotNull br2 br2Var, @NotNull DeclarationDescriptor declarationDescriptor, @NotNull Modality modality, @NotNull f70 f70Var, @NotNull CallableMemberDescriptor.Kind kind, @Nullable List<ValueParameterDescriptor> list, @NotNull ReceiverParameterDescriptor receiverParameterDescriptor, @Nullable z71 z71Var, ni1 ni1Var) {
            if (br2Var == null) {
                a(0);
            }
            if (declarationDescriptor == null) {
                a(1);
            }
            if (modality == null) {
                a(2);
            }
            if (f70Var == null) {
                a(3);
            }
            if (kind == null) {
                a(4);
            }
            if (list == null) {
                a(5);
            }
            if (z71Var == null) {
                a(6);
            }
            this.w = aVar;
            this.e = null;
            this.i = aVar.i;
            this.l = true;
            this.m = false;
            this.n = false;
            this.o = false;
            this.p = aVar.isHiddenToOvercomeSignatureClash();
            this.q = null;
            this.r = null;
            this.s = aVar.isHiddenForResolutionEverywhereBesideSupercalls();
            this.t = new LinkedHashMap();
            this.u = null;
            this.v = false;
            this.a = br2Var;
            this.b = declarationDescriptor;
            this.c = modality;
            this.d = f70Var;
            this.f = kind;
            this.g = list;
            this.h = receiverParameterDescriptor;
            this.j = z71Var;
            this.k = ni1Var;
        }

        private static /* synthetic */ void a(int i) {
            String str;
            int i2;
            switch (i) {
                case 8:
                case 10:
                case 12:
                case 14:
                case 15:
                case 17:
                case 19:
                case 21:
                case 23:
                case 24:
                case 25:
                case 26:
                case 27:
                case 28:
                case 29:
                case 30:
                case 31:
                case 33:
                case 35:
                case 37:
                case 38:
                case 39:
                    str = "@NotNull method %s.%s must not return null";
                    break;
                case 9:
                case 11:
                case 13:
                case 16:
                case 18:
                case 20:
                case 22:
                case 32:
                case 34:
                case 36:
                default:
                    str = "Argument for @NotNull parameter '%s' of %s.%s must not be null";
                    break;
            }
            switch (i) {
                case 8:
                case 10:
                case 12:
                case 14:
                case 15:
                case 17:
                case 19:
                case 21:
                case 23:
                case 24:
                case 25:
                case 26:
                case 27:
                case 28:
                case 29:
                case 30:
                case 31:
                case 33:
                case 35:
                case 37:
                case 38:
                case 39:
                    i2 = 2;
                    break;
                case 9:
                case 11:
                case 13:
                case 16:
                case 18:
                case 20:
                case 22:
                case 32:
                case 34:
                case 36:
                default:
                    i2 = 3;
                    break;
            }
            Object[] objArr = new Object[i2];
            switch (i) {
                case 1:
                    objArr[0] = "newOwner";
                    break;
                case 2:
                    objArr[0] = "newModality";
                    break;
                case 3:
                    objArr[0] = "newVisibility";
                    break;
                case 4:
                case 13:
                    objArr[0] = "kind";
                    break;
                case 5:
                    objArr[0] = "newValueParameterDescriptors";
                    break;
                case 6:
                    objArr[0] = "newReturnType";
                    break;
                case 7:
                    objArr[0] = "owner";
                    break;
                case 8:
                case 10:
                case 12:
                case 14:
                case 15:
                case 17:
                case 19:
                case 21:
                case 23:
                case 24:
                case 25:
                case 26:
                case 27:
                case 28:
                case 29:
                case 30:
                case 31:
                case 33:
                case 35:
                case 37:
                case 38:
                case 39:
                    objArr[0] = "kotlin/reflect/jvm/internal/impl/descriptors/impl/FunctionDescriptorImpl$CopyConfiguration";
                    break;
                case 9:
                    objArr[0] = "modality";
                    break;
                case 11:
                    objArr[0] = "visibility";
                    break;
                case 16:
                    objArr[0] = "name";
                    break;
                case 18:
                case 20:
                    objArr[0] = PushConstants.PARAMS;
                    break;
                case 22:
                    objArr[0] = "type";
                    break;
                case 32:
                    objArr[0] = "additionalAnnotations";
                    break;
                case 34:
                default:
                    objArr[0] = "substitution";
                    break;
                case 36:
                    objArr[0] = "userDataKey";
                    break;
            }
            switch (i) {
                case 8:
                    objArr[1] = "setOwner";
                    break;
                case 9:
                case 11:
                case 13:
                case 16:
                case 18:
                case 20:
                case 22:
                case 32:
                case 34:
                case 36:
                default:
                    objArr[1] = "kotlin/reflect/jvm/internal/impl/descriptors/impl/FunctionDescriptorImpl$CopyConfiguration";
                    break;
                case 10:
                    objArr[1] = "setModality";
                    break;
                case 12:
                    objArr[1] = "setVisibility";
                    break;
                case 14:
                    objArr[1] = "setKind";
                    break;
                case 15:
                    objArr[1] = "setCopyOverrides";
                    break;
                case 17:
                    objArr[1] = "setName";
                    break;
                case 19:
                    objArr[1] = "setValueParameters";
                    break;
                case 21:
                    objArr[1] = "setTypeParameters";
                    break;
                case 23:
                    objArr[1] = "setReturnType";
                    break;
                case 24:
                    objArr[1] = "setExtensionReceiverParameter";
                    break;
                case 25:
                    objArr[1] = "setDispatchReceiverParameter";
                    break;
                case 26:
                    objArr[1] = "setOriginal";
                    break;
                case 27:
                    objArr[1] = "setSignatureChange";
                    break;
                case 28:
                    objArr[1] = "setPreserveSourceElement";
                    break;
                case 29:
                    objArr[1] = "setDropOriginalInContainingParts";
                    break;
                case 30:
                    objArr[1] = "setHiddenToOvercomeSignatureClash";
                    break;
                case 31:
                    objArr[1] = "setHiddenForResolutionEverywhereBesideSupercalls";
                    break;
                case 33:
                    objArr[1] = "setAdditionalAnnotations";
                    break;
                case 35:
                    objArr[1] = "setSubstitution";
                    break;
                case 37:
                    objArr[1] = "putUserData";
                    break;
                case 38:
                    objArr[1] = "getSubstitution";
                    break;
                case 39:
                    objArr[1] = "setJustForTypeSubstitution";
                    break;
            }
            switch (i) {
                case 7:
                    objArr[2] = "setOwner";
                    break;
                case 8:
                case 10:
                case 12:
                case 14:
                case 15:
                case 17:
                case 19:
                case 21:
                case 23:
                case 24:
                case 25:
                case 26:
                case 27:
                case 28:
                case 29:
                case 30:
                case 31:
                case 33:
                case 35:
                case 37:
                case 38:
                case 39:
                    break;
                case 9:
                    objArr[2] = "setModality";
                    break;
                case 11:
                    objArr[2] = "setVisibility";
                    break;
                case 13:
                    objArr[2] = "setKind";
                    break;
                case 16:
                    objArr[2] = "setName";
                    break;
                case 18:
                    objArr[2] = "setValueParameters";
                    break;
                case 20:
                    objArr[2] = "setTypeParameters";
                    break;
                case 22:
                    objArr[2] = "setReturnType";
                    break;
                case 32:
                    objArr[2] = "setAdditionalAnnotations";
                    break;
                case 34:
                    objArr[2] = "setSubstitution";
                    break;
                case 36:
                    objArr[2] = "putUserData";
                    break;
                default:
                    objArr[2] = "<init>";
                    break;
            }
            String format = String.format(str, objArr);
            switch (i) {
                case 8:
                case 10:
                case 12:
                case 14:
                case 15:
                case 17:
                case 19:
                case 21:
                case 23:
                case 24:
                case 25:
                case 26:
                case 27:
                case 28:
                case 29:
                case 30:
                case 31:
                case 33:
                case 35:
                case 37:
                case 38:
                case 39:
                    throw new IllegalStateException(format);
                case 9:
                case 11:
                case 13:
                case 16:
                case 18:
                case 20:
                case 22:
                case 32:
                case 34:
                case 36:
                default:
                    throw new IllegalArgumentException(format);
            }
        }

        @Override // kotlin.reflect.jvm.internal.impl.descriptors.FunctionDescriptor.CopyBuilder
        @NotNull
        /* renamed from: A */
        public c setValueParameters(@NotNull List<ValueParameterDescriptor> list) {
            if (list == null) {
                a(18);
            }
            this.g = list;
            return this;
        }

        @Override // kotlin.reflect.jvm.internal.impl.descriptors.FunctionDescriptor.CopyBuilder
        @NotNull
        /* renamed from: B */
        public c setVisibility(@NotNull f70 f70Var) {
            if (f70Var == null) {
                a(11);
            }
            this.d = f70Var;
            return this;
        }

        @Override // kotlin.reflect.jvm.internal.impl.descriptors.FunctionDescriptor.CopyBuilder
        @Nullable
        public FunctionDescriptor build() {
            return this.w.g(this);
        }

        @Override // kotlin.reflect.jvm.internal.impl.descriptors.FunctionDescriptor.CopyBuilder
        @NotNull
        /* renamed from: h */
        public c setAdditionalAnnotations(@NotNull Annotations annotations) {
            if (annotations == null) {
                a(32);
            }
            this.r = annotations;
            return this;
        }

        @Override // kotlin.reflect.jvm.internal.impl.descriptors.FunctionDescriptor.CopyBuilder
        @NotNull
        /* renamed from: i */
        public c setCopyOverrides(boolean z) {
            this.l = z;
            return this;
        }

        @Override // kotlin.reflect.jvm.internal.impl.descriptors.FunctionDescriptor.CopyBuilder
        @NotNull
        /* renamed from: j */
        public c setDispatchReceiverParameter(@Nullable ReceiverParameterDescriptor receiverParameterDescriptor) {
            this.i = receiverParameterDescriptor;
            return this;
        }

        @Override // kotlin.reflect.jvm.internal.impl.descriptors.FunctionDescriptor.CopyBuilder
        @NotNull
        /* renamed from: k */
        public c setDropOriginalInContainingParts() {
            this.o = true;
            return this;
        }

        @Override // kotlin.reflect.jvm.internal.impl.descriptors.FunctionDescriptor.CopyBuilder
        @NotNull
        /* renamed from: l */
        public c setExtensionReceiverParameter(@Nullable ReceiverParameterDescriptor receiverParameterDescriptor) {
            this.h = receiverParameterDescriptor;
            return this;
        }

        public c m(boolean z) {
            this.u = Boolean.valueOf(z);
            return this;
        }

        @Override // kotlin.reflect.jvm.internal.impl.descriptors.FunctionDescriptor.CopyBuilder
        @NotNull
        /* renamed from: n */
        public c setHiddenForResolutionEverywhereBesideSupercalls() {
            this.s = true;
            return this;
        }

        @Override // kotlin.reflect.jvm.internal.impl.descriptors.FunctionDescriptor.CopyBuilder
        @NotNull
        /* renamed from: o */
        public c setHiddenToOvercomeSignatureClash() {
            this.p = true;
            return this;
        }

        @NotNull
        public c p(boolean z) {
            this.v = z;
            return this;
        }

        @Override // kotlin.reflect.jvm.internal.impl.descriptors.FunctionDescriptor.CopyBuilder
        @NotNull
        /* renamed from: q */
        public c setKind(@NotNull CallableMemberDescriptor.Kind kind) {
            if (kind == null) {
                a(13);
            }
            this.f = kind;
            return this;
        }

        @Override // kotlin.reflect.jvm.internal.impl.descriptors.FunctionDescriptor.CopyBuilder
        @NotNull
        /* renamed from: r */
        public c setModality(@NotNull Modality modality) {
            if (modality == null) {
                a(9);
            }
            this.c = modality;
            return this;
        }

        @Override // kotlin.reflect.jvm.internal.impl.descriptors.FunctionDescriptor.CopyBuilder
        @NotNull
        /* renamed from: s */
        public c setName(@NotNull ni1 ni1Var) {
            if (ni1Var == null) {
                a(16);
            }
            this.k = ni1Var;
            return this;
        }

        @Override // kotlin.reflect.jvm.internal.impl.descriptors.FunctionDescriptor.CopyBuilder
        @NotNull
        /* renamed from: t */
        public c setOriginal(@Nullable CallableMemberDescriptor callableMemberDescriptor) {
            this.e = (FunctionDescriptor) callableMemberDescriptor;
            return this;
        }

        @Override // kotlin.reflect.jvm.internal.impl.descriptors.FunctionDescriptor.CopyBuilder
        @NotNull
        /* renamed from: u */
        public c setOwner(@NotNull DeclarationDescriptor declarationDescriptor) {
            if (declarationDescriptor == null) {
                a(7);
            }
            this.b = declarationDescriptor;
            return this;
        }

        @Override // kotlin.reflect.jvm.internal.impl.descriptors.FunctionDescriptor.CopyBuilder
        @NotNull
        /* renamed from: v */
        public c setPreserveSourceElement() {
            this.n = true;
            return this;
        }

        @Override // kotlin.reflect.jvm.internal.impl.descriptors.FunctionDescriptor.CopyBuilder
        @NotNull
        /* renamed from: w */
        public c setReturnType(@NotNull z71 z71Var) {
            if (z71Var == null) {
                a(22);
            }
            this.j = z71Var;
            return this;
        }

        @Override // kotlin.reflect.jvm.internal.impl.descriptors.FunctionDescriptor.CopyBuilder
        @NotNull
        /* renamed from: x */
        public c setSignatureChange() {
            this.m = true;
            return this;
        }

        @Override // kotlin.reflect.jvm.internal.impl.descriptors.FunctionDescriptor.CopyBuilder
        @NotNull
        /* renamed from: y */
        public c setSubstitution(@NotNull br2 br2Var) {
            if (br2Var == null) {
                a(34);
            }
            this.a = br2Var;
            return this;
        }

        @Override // kotlin.reflect.jvm.internal.impl.descriptors.FunctionDescriptor.CopyBuilder
        @NotNull
        /* renamed from: z */
        public c setTypeParameters(@NotNull List<TypeParameterDescriptor> list) {
            if (list == null) {
                a(20);
            }
            this.q = list;
            return this;
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public a(@NotNull DeclarationDescriptor declarationDescriptor, @Nullable FunctionDescriptor functionDescriptor, @NotNull Annotations annotations, @NotNull ni1 ni1Var, @NotNull CallableMemberDescriptor.Kind kind, @NotNull SourceElement sourceElement) {
        super(declarationDescriptor, annotations, ni1Var, sourceElement);
        if (declarationDescriptor == null) {
            a(0);
        }
        if (annotations == null) {
            a(1);
        }
        if (ni1Var == null) {
            a(2);
        }
        if (kind == null) {
            a(3);
        }
        if (sourceElement == null) {
            a(4);
        }
        this.k = e70.UNKNOWN;
        this.l = false;
        this.m = false;
        this.n = false;
        this.o = false;
        this.p = false;
        this.q = false;
        this.r = false;
        this.s = false;
        this.t = false;
        this.u = false;
        this.v = true;
        this.w = false;
        this.x = null;
        this.y = null;
        this.B = null;
        this.C = null;
        this.z = functionDescriptor == null ? this : functionDescriptor;
        this.A = kind;
    }

    private static /* synthetic */ void a(int i) {
        String str;
        int i2;
        switch (i) {
            case 8:
            case 12:
            case 13:
            case 14:
            case 16:
            case 17:
            case 18:
            case 19:
            case 21:
            case 24:
            case 25:
                str = "@NotNull method %s.%s must not return null";
                break;
            case 9:
            case 10:
            case 11:
            case 15:
            case 20:
            case 22:
            case 23:
            default:
                str = "Argument for @NotNull parameter '%s' of %s.%s must not be null";
                break;
        }
        switch (i) {
            case 8:
            case 12:
            case 13:
            case 14:
            case 16:
            case 17:
            case 18:
            case 19:
            case 21:
            case 24:
            case 25:
                i2 = 2;
                break;
            case 9:
            case 10:
            case 11:
            case 15:
            case 20:
            case 22:
            case 23:
            default:
                i2 = 3;
                break;
        }
        Object[] objArr = new Object[i2];
        switch (i) {
            case 1:
                objArr[0] = "annotations";
                break;
            case 2:
                objArr[0] = "name";
                break;
            case 3:
                objArr[0] = "kind";
                break;
            case 4:
                objArr[0] = "source";
                break;
            case 5:
                objArr[0] = "typeParameters";
                break;
            case 6:
            case 26:
            case 28:
                objArr[0] = "unsubstitutedValueParameters";
                break;
            case 7:
            case 9:
                objArr[0] = "visibility";
                break;
            case 8:
            case 12:
            case 13:
            case 14:
            case 16:
            case 17:
            case 18:
            case 19:
            case 21:
            case 24:
            case 25:
                objArr[0] = "kotlin/reflect/jvm/internal/impl/descriptors/impl/FunctionDescriptorImpl";
                break;
            case 10:
                objArr[0] = "unsubstitutedReturnType";
                break;
            case 11:
                objArr[0] = "extensionReceiverParameter";
                break;
            case 15:
                objArr[0] = "overriddenDescriptors";
                break;
            case 20:
                objArr[0] = "originalSubstitutor";
                break;
            case 22:
            case 27:
            case 29:
                objArr[0] = "substitutor";
                break;
            case 23:
                objArr[0] = PipUtils.DAGO_PIP_MODE_CONFIGURATION;
                break;
            default:
                objArr[0] = "containingDeclaration";
                break;
        }
        switch (i) {
            case 8:
                objArr[1] = "initialize";
                break;
            case 9:
            case 10:
            case 11:
            case 15:
            case 20:
            case 22:
            case 23:
            default:
                objArr[1] = "kotlin/reflect/jvm/internal/impl/descriptors/impl/FunctionDescriptorImpl";
                break;
            case 12:
                objArr[1] = "getOverriddenDescriptors";
                break;
            case 13:
                objArr[1] = "getModality";
                break;
            case 14:
                objArr[1] = "getVisibility";
                break;
            case 16:
                objArr[1] = "getTypeParameters";
                break;
            case 17:
                objArr[1] = "getValueParameters";
                break;
            case 18:
                objArr[1] = "getOriginal";
                break;
            case 19:
                objArr[1] = "getKind";
                break;
            case 21:
                objArr[1] = "newCopyBuilder";
                break;
            case 24:
                objArr[1] = rz0.ARG_COPY;
                break;
            case 25:
                objArr[1] = "getSourceToUseForCopy";
                break;
        }
        switch (i) {
            case 5:
            case 6:
            case 7:
                objArr[2] = "initialize";
                break;
            case 8:
            case 12:
            case 13:
            case 14:
            case 16:
            case 17:
            case 18:
            case 19:
            case 21:
            case 24:
            case 25:
                break;
            case 9:
                objArr[2] = "setVisibility";
                break;
            case 10:
                objArr[2] = "setReturnType";
                break;
            case 11:
                objArr[2] = "setExtensionReceiverParameter";
                break;
            case 15:
                objArr[2] = "setOverriddenDescriptors";
                break;
            case 20:
                objArr[2] = "substitute";
                break;
            case 22:
                objArr[2] = "newCopyBuilder";
                break;
            case 23:
                objArr[2] = "doSubstitute";
                break;
            case 26:
            case 27:
            case 28:
            case 29:
                objArr[2] = "getSubstitutedValueParameters";
                break;
            default:
                objArr[2] = "<init>";
                break;
        }
        String format = String.format(str, objArr);
        switch (i) {
            case 8:
            case 12:
            case 13:
            case 14:
            case 16:
            case 17:
            case 18:
            case 19:
            case 21:
            case 24:
            case 25:
                throw new IllegalStateException(format);
            case 9:
            case 10:
            case 11:
            case 15:
            case 20:
            case 22:
            case 23:
            default:
                throw new IllegalArgumentException(format);
        }
    }

    @NotNull
    private SourceElement h(boolean z, @Nullable FunctionDescriptor functionDescriptor) {
        SourceElement sourceElement;
        if (z) {
            if (functionDescriptor == null) {
                functionDescriptor = getOriginal();
            }
            sourceElement = functionDescriptor.getSource();
        } else {
            sourceElement = SourceElement.NO_SOURCE;
        }
        if (sourceElement == null) {
            a(25);
        }
        return sourceElement;
    }

    @Nullable
    public static List<ValueParameterDescriptor> i(FunctionDescriptor functionDescriptor, @NotNull List<ValueParameterDescriptor> list, @NotNull TypeSubstitutor typeSubstitutor) {
        if (list == null) {
            a(26);
        }
        if (typeSubstitutor == null) {
            a(27);
        }
        return j(functionDescriptor, list, typeSubstitutor, false, false, null);
    }

    @Nullable
    public static List<ValueParameterDescriptor> j(FunctionDescriptor functionDescriptor, @NotNull List<ValueParameterDescriptor> list, @NotNull TypeSubstitutor typeSubstitutor, boolean z, boolean z2, @Nullable boolean[] zArr) {
        if (list == null) {
            a(28);
        }
        if (typeSubstitutor == null) {
            a(29);
        }
        ArrayList arrayList = new ArrayList(list.size());
        for (ValueParameterDescriptor valueParameterDescriptor : list) {
            z71 type = valueParameterDescriptor.getType();
            Variance variance = Variance.IN_VARIANCE;
            z71 q = typeSubstitutor.q(type, variance);
            z71 varargElementType = valueParameterDescriptor.getVarargElementType();
            z71 q2 = varargElementType == null ? null : typeSubstitutor.q(varargElementType, variance);
            if (q == null) {
                return null;
            }
            if ((q != valueParameterDescriptor.getType() || varargElementType != q2) && zArr != null) {
                zArr[0] = true;
            }
            arrayList.add(ValueParameterDescriptorImpl.e(functionDescriptor, z ? null : valueParameterDescriptor, valueParameterDescriptor.getIndex(), valueParameterDescriptor.getAnnotations(), valueParameterDescriptor.getName(), q, valueParameterDescriptor.declaresDefaultValue(), valueParameterDescriptor.isCrossinline(), valueParameterDescriptor.isNoinline(), q2, z2 ? valueParameterDescriptor.getSource() : SourceElement.NO_SOURCE, valueParameterDescriptor instanceof ValueParameterDescriptorImpl.WithDestructuringDeclaration ? new b(((ValueParameterDescriptorImpl.WithDestructuringDeclaration) valueParameterDescriptor).h()) : null));
        }
        return arrayList;
    }

    private void n() {
        Function0<Collection<FunctionDescriptor>> function0 = this.y;
        if (function0 != null) {
            this.x = function0.invoke();
            this.y = null;
        }
    }

    private void u(boolean z) {
        this.t = z;
    }

    private void v(boolean z) {
        this.s = z;
    }

    private void x(@Nullable FunctionDescriptor functionDescriptor) {
        this.B = functionDescriptor;
    }

    public void A(@NotNull z71 z71Var) {
        if (z71Var == null) {
            a(10);
        }
        this.g = z71Var;
    }

    public void B(boolean z) {
        this.u = z;
    }

    public void C(boolean z) {
        this.p = z;
    }

    public void D(@NotNull f70 f70Var) {
        if (f70Var == null) {
            a(9);
        }
        this.k = f70Var;
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.DeclarationDescriptor
    public <R, D> R accept(DeclarationDescriptorVisitor<R, D> declarationDescriptorVisitor, D d) {
        return declarationDescriptorVisitor.visitFunctionDescriptor(this, d);
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.CallableMemberDescriptor
    @NotNull
    /* renamed from: e */
    public FunctionDescriptor copy(DeclarationDescriptor declarationDescriptor, Modality modality, f70 f70Var, CallableMemberDescriptor.Kind kind, boolean z) {
        FunctionDescriptor build = newCopyBuilder().setOwner(declarationDescriptor).setModality(modality).setVisibility(f70Var).setKind(kind).setCopyOverrides(z).build();
        if (build == null) {
            a(24);
        }
        return build;
    }

    @NotNull
    protected abstract a f(@NotNull DeclarationDescriptor declarationDescriptor, @Nullable FunctionDescriptor functionDescriptor, @NotNull CallableMemberDescriptor.Kind kind, @Nullable ni1 ni1Var, @NotNull Annotations annotations, @NotNull SourceElement sourceElement);

    /* JADX INFO: Access modifiers changed from: protected */
    @Nullable
    public FunctionDescriptor g(@NotNull c cVar) {
        iz1 iz1Var;
        ReceiverParameterDescriptor receiverParameterDescriptor;
        z71 q;
        if (cVar == null) {
            a(23);
        }
        boolean[] zArr = new boolean[1];
        Annotations a = cVar.r != null ? f6.a(getAnnotations(), cVar.r) : getAnnotations();
        DeclarationDescriptor declarationDescriptor = cVar.b;
        FunctionDescriptor functionDescriptor = cVar.e;
        a f = f(declarationDescriptor, functionDescriptor, cVar.f, cVar.k, a, h(cVar.n, functionDescriptor));
        List<TypeParameterDescriptor> typeParameters = cVar.q == null ? getTypeParameters() : cVar.q;
        zArr[0] = zArr[0] | (!typeParameters.isEmpty());
        ArrayList arrayList = new ArrayList(typeParameters.size());
        TypeSubstitutor c2 = b70.c(typeParameters, cVar.a, f, arrayList, zArr);
        if (c2 == null) {
            return null;
        }
        ReceiverParameterDescriptor receiverParameterDescriptor2 = cVar.h;
        if (receiverParameterDescriptor2 != null) {
            z71 q2 = c2.q(receiverParameterDescriptor2.getType(), Variance.IN_VARIANCE);
            if (q2 == null) {
                return null;
            }
            iz1 iz1Var2 = new iz1(f, new dh0(f, q2, cVar.h.getValue()), cVar.h.getAnnotations());
            zArr[0] = (q2 != cVar.h.getType()) | zArr[0];
            iz1Var = iz1Var2;
        } else {
            iz1Var = null;
        }
        ReceiverParameterDescriptor receiverParameterDescriptor3 = cVar.i;
        if (receiverParameterDescriptor3 != null) {
            ReceiverParameterDescriptor substitute = receiverParameterDescriptor3.substitute(c2);
            if (substitute == null) {
                return null;
            }
            zArr[0] = zArr[0] | (substitute != cVar.i);
            receiverParameterDescriptor = substitute;
        } else {
            receiverParameterDescriptor = null;
        }
        List<ValueParameterDescriptor> j = j(f, cVar.g, c2, cVar.o, cVar.n, zArr);
        if (j == null || (q = c2.q(cVar.j, Variance.OUT_VARIANCE)) == null) {
            return null;
        }
        zArr[0] = zArr[0] | (q != cVar.j);
        if (zArr[0] || !cVar.v) {
            f.l(iz1Var, receiverParameterDescriptor, arrayList, j, q, cVar.c, cVar.d);
            f.z(this.l);
            f.w(this.m);
            f.r(this.n);
            f.y(this.o);
            f.C(this.p);
            f.B(this.u);
            f.q(this.q);
            f.p(this.r);
            f.s(this.v);
            f.v(cVar.p);
            f.u(cVar.s);
            f.t(cVar.u != null ? cVar.u.booleanValue() : this.w);
            if (!cVar.t.isEmpty() || this.C != null) {
                Map<CallableDescriptor.UserDataKey<?>, Object> map = cVar.t;
                Map<CallableDescriptor.UserDataKey<?>, Object> map2 = this.C;
                if (map2 != null) {
                    for (Map.Entry<CallableDescriptor.UserDataKey<?>, Object> entry : map2.entrySet()) {
                        if (!map.containsKey(entry.getKey())) {
                            map.put(entry.getKey(), entry.getValue());
                        }
                    }
                }
                if (map.size() == 1) {
                    f.C = Collections.singletonMap(map.keySet().iterator().next(), map.values().iterator().next());
                } else {
                    f.C = map;
                }
            }
            if (cVar.m || getInitialSignatureDescriptor() != null) {
                f.x((getInitialSignatureDescriptor() != null ? getInitialSignatureDescriptor() : this).substitute(c2));
            }
            if (cVar.l && !getOriginal().getOverriddenDescriptors().isEmpty()) {
                if (cVar.a.f()) {
                    Function0<Collection<FunctionDescriptor>> function0 = this.y;
                    if (function0 != null) {
                        f.y = function0;
                    } else {
                        f.setOverriddenDescriptors(getOverriddenDescriptors());
                    }
                } else {
                    f.y = new C0415a(c2);
                }
            }
            return f;
        }
        return this;
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.CallableDescriptor
    @Nullable
    public ReceiverParameterDescriptor getDispatchReceiverParameter() {
        return this.i;
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.CallableDescriptor
    @Nullable
    public ReceiverParameterDescriptor getExtensionReceiverParameter() {
        return this.h;
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.FunctionDescriptor
    @Nullable
    public FunctionDescriptor getInitialSignatureDescriptor() {
        return this.B;
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.CallableMemberDescriptor
    @NotNull
    public CallableMemberDescriptor.Kind getKind() {
        CallableMemberDescriptor.Kind kind = this.A;
        if (kind == null) {
            a(19);
        }
        return kind;
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.MemberDescriptor
    @NotNull
    public Modality getModality() {
        Modality modality = this.j;
        if (modality == null) {
            a(13);
        }
        return modality;
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.FunctionDescriptor, kotlin.reflect.jvm.internal.impl.descriptors.CallableMemberDescriptor, kotlin.reflect.jvm.internal.impl.descriptors.CallableDescriptor
    @NotNull
    public Collection<? extends FunctionDescriptor> getOverriddenDescriptors() {
        n();
        Collection<? extends FunctionDescriptor> collection = this.x;
        if (collection == null) {
            collection = Collections.emptyList();
        }
        if (collection == null) {
            a(12);
        }
        return collection;
    }

    public z71 getReturnType() {
        return this.g;
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.CallableDescriptor
    @NotNull
    public List<TypeParameterDescriptor> getTypeParameters() {
        List<TypeParameterDescriptor> list = this.e;
        if (list != null) {
            return list;
        }
        throw new IllegalStateException("typeParameters == null for " + this);
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.CallableDescriptor
    public <V> V getUserData(CallableDescriptor.UserDataKey<V> userDataKey) {
        Map<CallableDescriptor.UserDataKey<?>, Object> map = this.C;
        if (map == null) {
            return null;
        }
        return (V) map.get(userDataKey);
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.CallableDescriptor
    @NotNull
    public List<ValueParameterDescriptor> getValueParameters() {
        List<ValueParameterDescriptor> list = this.f;
        if (list == null) {
            a(17);
        }
        return list;
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.DeclarationDescriptorWithVisibility, kotlin.reflect.jvm.internal.impl.descriptors.MemberDescriptor
    @NotNull
    public f70 getVisibility() {
        f70 f70Var = this.k;
        if (f70Var == null) {
            a(14);
        }
        return f70Var;
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.CallableDescriptor
    public boolean hasSynthesizedParameterNames() {
        return this.w;
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.MemberDescriptor
    public boolean isActual() {
        return this.r;
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.MemberDescriptor
    public boolean isExpect() {
        return this.q;
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.MemberDescriptor
    public boolean isExternal() {
        return this.n;
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.FunctionDescriptor
    public boolean isHiddenForResolutionEverywhereBesideSupercalls() {
        return this.t;
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.FunctionDescriptor
    public boolean isHiddenToOvercomeSignatureClash() {
        return this.s;
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.FunctionDescriptor
    public boolean isInfix() {
        if (this.m) {
            return true;
        }
        for (FunctionDescriptor functionDescriptor : getOriginal().getOverriddenDescriptors()) {
            if (functionDescriptor.isInfix()) {
                return true;
            }
        }
        return false;
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.FunctionDescriptor
    public boolean isInline() {
        return this.o;
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.FunctionDescriptor
    public boolean isOperator() {
        if (this.l) {
            return true;
        }
        for (FunctionDescriptor functionDescriptor : getOriginal().getOverriddenDescriptors()) {
            if (functionDescriptor.isOperator()) {
                return true;
            }
        }
        return false;
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.FunctionDescriptor
    public boolean isSuspend() {
        return this.u;
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.FunctionDescriptor
    public boolean isTailrec() {
        return this.p;
    }

    public boolean k() {
        return this.v;
    }

    @NotNull
    public a l(@Nullable ReceiverParameterDescriptor receiverParameterDescriptor, @Nullable ReceiverParameterDescriptor receiverParameterDescriptor2, @NotNull List<? extends TypeParameterDescriptor> list, @NotNull List<ValueParameterDescriptor> list2, @Nullable z71 z71Var, @Nullable Modality modality, @NotNull f70 f70Var) {
        List<TypeParameterDescriptor> A0;
        List<ValueParameterDescriptor> A02;
        if (list == null) {
            a(5);
        }
        if (list2 == null) {
            a(6);
        }
        if (f70Var == null) {
            a(7);
        }
        A0 = CollectionsKt___CollectionsKt.A0(list);
        this.e = A0;
        A02 = CollectionsKt___CollectionsKt.A0(list2);
        this.f = A02;
        this.g = z71Var;
        this.j = modality;
        this.k = f70Var;
        this.h = receiverParameterDescriptor;
        this.i = receiverParameterDescriptor2;
        for (int i = 0; i < list.size(); i++) {
            TypeParameterDescriptor typeParameterDescriptor = list.get(i);
            if (typeParameterDescriptor.getIndex() != i) {
                throw new IllegalStateException(typeParameterDescriptor + " index is " + typeParameterDescriptor.getIndex() + " but position is " + i);
            }
        }
        for (int i2 = 0; i2 < list2.size(); i2++) {
            ValueParameterDescriptor valueParameterDescriptor = list2.get(i2);
            if (valueParameterDescriptor.getIndex() != i2 + 0) {
                throw new IllegalStateException(valueParameterDescriptor + "index is " + valueParameterDescriptor.getIndex() + " but position is " + i2);
            }
        }
        return this;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @NotNull
    public c m(@NotNull TypeSubstitutor typeSubstitutor) {
        if (typeSubstitutor == null) {
            a(22);
        }
        return new c(this, typeSubstitutor.j(), getContainingDeclaration(), getModality(), getVisibility(), getKind(), getValueParameters(), getExtensionReceiverParameter(), getReturnType(), null);
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.FunctionDescriptor
    @NotNull
    public FunctionDescriptor.CopyBuilder<? extends FunctionDescriptor> newCopyBuilder() {
        c m = m(TypeSubstitutor.EMPTY);
        if (m == null) {
            a(21);
        }
        return m;
    }

    public <V> void o(CallableDescriptor.UserDataKey<V> userDataKey, Object obj) {
        if (this.C == null) {
            this.C = new LinkedHashMap();
        }
        this.C.put(userDataKey, obj);
    }

    public void p(boolean z) {
        this.r = z;
    }

    public void q(boolean z) {
        this.q = z;
    }

    public void r(boolean z) {
        this.n = z;
    }

    public void s(boolean z) {
        this.v = z;
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // kotlin.reflect.jvm.internal.impl.descriptors.CallableMemberDescriptor
    public void setOverriddenDescriptors(@NotNull Collection<? extends CallableMemberDescriptor> collection) {
        if (collection == 0) {
            a(15);
        }
        this.x = collection;
        Iterator it = collection.iterator();
        while (it.hasNext()) {
            if (((FunctionDescriptor) it.next()).isHiddenForResolutionEverywhereBesideSupercalls()) {
                this.t = true;
                return;
            }
        }
    }

    public void t(boolean z) {
        this.w = z;
    }

    public void w(boolean z) {
        this.m = z;
    }

    public void y(boolean z) {
        this.o = z;
    }

    public void z(boolean z) {
        this.l = z;
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.FunctionDescriptor, kotlin.reflect.jvm.internal.impl.descriptors.Substitutable
    public FunctionDescriptor substitute(@NotNull TypeSubstitutor typeSubstitutor) {
        if (typeSubstitutor == null) {
            a(20);
        }
        return typeSubstitutor.k() ? this : m(typeSubstitutor).setOriginal(getOriginal()).setPreserveSourceElement().p(true).build();
    }

    @Override // tb.u40, tb.t40, kotlin.reflect.jvm.internal.impl.descriptors.DeclarationDescriptor
    @NotNull
    public FunctionDescriptor getOriginal() {
        FunctionDescriptor functionDescriptor = this.z;
        FunctionDescriptor original = functionDescriptor == this ? this : functionDescriptor.getOriginal();
        if (original == null) {
            a(18);
        }
        return original;
    }
}
