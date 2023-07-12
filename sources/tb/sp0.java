package tb;

import androidx.exifinterface.media.ExifInterface;
import com.tencent.open.SocialConstants;
import com.youku.live.dago.liveplayback.widget.pip.PipUtils;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Locale;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.reflect.jvm.internal.impl.descriptors.CallableMemberDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.DeclarationDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.FunctionDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.Modality;
import kotlin.reflect.jvm.internal.impl.descriptors.ReceiverParameterDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.SourceElement;
import kotlin.reflect.jvm.internal.impl.descriptors.TypeParameterDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.ValueParameterDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.annotations.Annotations;
import kotlin.reflect.jvm.internal.impl.descriptors.impl.ValueParameterDescriptorImpl;
import kotlin.reflect.jvm.internal.impl.descriptors.impl.a;
import kotlin.reflect.jvm.internal.impl.types.TypeSubstitutor;
import kotlin.reflect.jvm.internal.impl.types.Variance;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: Taobao */
/* loaded from: classes3.dex */
public final class sp0 extends cd2 {
    @NotNull
    public static final a Factory = new a(null);

    /* compiled from: Taobao */
    /* loaded from: classes3.dex */
    public static final class a {
        private a() {
        }

        public /* synthetic */ a(k50 k50Var) {
            this();
        }

        private final ValueParameterDescriptor b(sp0 sp0Var, int i, TypeParameterDescriptor typeParameterDescriptor) {
            String lowerCase;
            String b = typeParameterDescriptor.getName().b();
            b41.h(b, "typeParameter.name.asString()");
            if (b41.d(b, "T")) {
                lowerCase = "instance";
            } else if (b41.d(b, ExifInterface.LONGITUDE_EAST)) {
                lowerCase = SocialConstants.PARAM_RECEIVER;
            } else {
                lowerCase = b.toLowerCase(Locale.ROOT);
                b41.h(lowerCase, "(this as java.lang.Strin….toLowerCase(Locale.ROOT)");
            }
            Annotations b2 = Annotations.Companion.b();
            ni1 f = ni1.f(lowerCase);
            b41.h(f, "identifier(name)");
            fd2 defaultType = typeParameterDescriptor.getDefaultType();
            b41.h(defaultType, "typeParameter.defaultType");
            SourceElement sourceElement = SourceElement.NO_SOURCE;
            b41.h(sourceElement, "NO_SOURCE");
            return new ValueParameterDescriptorImpl(sp0Var, null, i, b2, f, defaultType, false, false, false, null, sourceElement);
        }

        @NotNull
        public final sp0 a(@NotNull qp0 qp0Var, boolean z) {
            List<? extends TypeParameterDescriptor> g;
            Iterable<i21> G0;
            int q;
            b41.i(qp0Var, "functionClass");
            List<TypeParameterDescriptor> declaredTypeParameters = qp0Var.getDeclaredTypeParameters();
            sp0 sp0Var = new sp0(qp0Var, null, CallableMemberDescriptor.Kind.DECLARATION, z, null);
            ReceiverParameterDescriptor thisAsReceiverParameter = qp0Var.getThisAsReceiverParameter();
            g = kotlin.collections.m.g();
            ArrayList arrayList = new ArrayList();
            for (Object obj : declaredTypeParameters) {
                if (!(((TypeParameterDescriptor) obj).getVariance() == Variance.IN_VARIANCE)) {
                    break;
                }
                arrayList.add(obj);
            }
            G0 = CollectionsKt___CollectionsKt.G0(arrayList);
            q = kotlin.collections.n.q(G0, 10);
            ArrayList arrayList2 = new ArrayList(q);
            for (i21 i21Var : G0) {
                arrayList2.add(sp0.Factory.b(sp0Var, i21Var.c(), (TypeParameterDescriptor) i21Var.d()));
            }
            sp0Var.l(null, thisAsReceiverParameter, g, arrayList2, ((TypeParameterDescriptor) kotlin.collections.k.b0(declaredTypeParameters)).getDefaultType(), Modality.ABSTRACT, e70.PUBLIC);
            sp0Var.t(true);
            return sp0Var;
        }
    }

    private sp0(DeclarationDescriptor declarationDescriptor, sp0 sp0Var, CallableMemberDescriptor.Kind kind, boolean z) {
        super(declarationDescriptor, sp0Var, Annotations.Companion.b(), in1.INVOKE, kind, SourceElement.NO_SOURCE);
        z(true);
        B(z);
        s(false);
    }

    public /* synthetic */ sp0(DeclarationDescriptor declarationDescriptor, sp0 sp0Var, CallableMemberDescriptor.Kind kind, boolean z, k50 k50Var) {
        this(declarationDescriptor, sp0Var, kind, z);
    }

    private final FunctionDescriptor J(List<ni1> list) {
        int q;
        boolean z;
        ni1 ni1Var;
        int size = getValueParameters().size() - list.size();
        boolean z2 = true;
        List<ValueParameterDescriptor> valueParameters = getValueParameters();
        b41.h(valueParameters, "valueParameters");
        q = kotlin.collections.n.q(valueParameters, 10);
        ArrayList arrayList = new ArrayList(q);
        for (ValueParameterDescriptor valueParameterDescriptor : valueParameters) {
            ni1 name = valueParameterDescriptor.getName();
            b41.h(name, "it.name");
            int index = valueParameterDescriptor.getIndex();
            int i = index - size;
            if (i >= 0 && (ni1Var = list.get(i)) != null) {
                name = ni1Var;
            }
            arrayList.add(valueParameterDescriptor.copy(this, name, index));
        }
        a.c m = m(TypeSubstitutor.EMPTY);
        if (!list.isEmpty()) {
            for (ni1 ni1Var2 : list) {
                if (ni1Var2 == null) {
                    z = true;
                    continue;
                } else {
                    z = false;
                    continue;
                }
                if (z) {
                    break;
                }
            }
        }
        z2 = false;
        a.c original = m.m(z2).setValueParameters(arrayList).setOriginal(getOriginal());
        b41.h(original, "newCopyBuilder(TypeSubst…   .setOriginal(original)");
        FunctionDescriptor g = super.g(original);
        b41.f(g);
        b41.h(g, "super.doSubstitute(copyConfiguration)!!");
        return g;
    }

    @Override // tb.cd2, kotlin.reflect.jvm.internal.impl.descriptors.impl.a
    @NotNull
    protected kotlin.reflect.jvm.internal.impl.descriptors.impl.a f(@NotNull DeclarationDescriptor declarationDescriptor, @Nullable FunctionDescriptor functionDescriptor, @NotNull CallableMemberDescriptor.Kind kind, @Nullable ni1 ni1Var, @NotNull Annotations annotations, @NotNull SourceElement sourceElement) {
        b41.i(declarationDescriptor, "newOwner");
        b41.i(kind, "kind");
        b41.i(annotations, "annotations");
        b41.i(sourceElement, "source");
        return new sp0(declarationDescriptor, (sp0) functionDescriptor, kind, isSuspend());
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // kotlin.reflect.jvm.internal.impl.descriptors.impl.a
    @Nullable
    public FunctionDescriptor g(@NotNull a.c cVar) {
        boolean z;
        int q;
        b41.i(cVar, PipUtils.DAGO_PIP_MODE_CONFIGURATION);
        sp0 sp0Var = (sp0) super.g(cVar);
        if (sp0Var == null) {
            return null;
        }
        List<ValueParameterDescriptor> valueParameters = sp0Var.getValueParameters();
        b41.h(valueParameters, "substituted.valueParameters");
        boolean z2 = false;
        if (!(valueParameters instanceof Collection) || !valueParameters.isEmpty()) {
            for (ValueParameterDescriptor valueParameterDescriptor : valueParameters) {
                z71 type = valueParameterDescriptor.getType();
                b41.h(type, "it.type");
                if (up0.c(type) != null) {
                    z = true;
                    continue;
                } else {
                    z = false;
                    continue;
                }
                if (z) {
                    break;
                }
            }
        }
        z2 = true;
        if (z2) {
            return sp0Var;
        }
        List<ValueParameterDescriptor> valueParameters2 = sp0Var.getValueParameters();
        b41.h(valueParameters2, "substituted.valueParameters");
        q = kotlin.collections.n.q(valueParameters2, 10);
        ArrayList arrayList = new ArrayList(q);
        for (ValueParameterDescriptor valueParameterDescriptor2 : valueParameters2) {
            z71 type2 = valueParameterDescriptor2.getType();
            b41.h(type2, "it.type");
            arrayList.add(up0.c(type2));
        }
        return sp0Var.J(arrayList);
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.impl.a, kotlin.reflect.jvm.internal.impl.descriptors.MemberDescriptor
    public boolean isExternal() {
        return false;
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.impl.a, kotlin.reflect.jvm.internal.impl.descriptors.FunctionDescriptor
    public boolean isInline() {
        return false;
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.impl.a, kotlin.reflect.jvm.internal.impl.descriptors.FunctionDescriptor
    public boolean isTailrec() {
        return false;
    }
}
