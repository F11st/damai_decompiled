package kotlin.reflect.jvm.internal.impl.load.java.lazy.types;

import com.meizu.cloud.pushsdk.notification.model.AdvanceSetting;
import com.taobao.alivfssdk.utils.AVFSCacheConstants;
import com.taobao.weex.bridge.WXBridgeManager;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import kotlin.Pair;
import kotlin.collections.C8215n;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.jvm.functions.Function1;
import kotlin.reflect.jvm.internal.impl.descriptors.ClassDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.ClassifierDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.annotations.Annotations;
import kotlin.reflect.jvm.internal.impl.renderer.DescriptorRenderer;
import kotlin.reflect.jvm.internal.impl.renderer.DescriptorRendererOptions;
import kotlin.reflect.jvm.internal.impl.resolve.scopes.MemberScope;
import kotlin.reflect.jvm.internal.impl.types.RawType;
import kotlin.reflect.jvm.internal.impl.types.TypeProjection;
import kotlin.reflect.jvm.internal.impl.types.checker.KotlinTypeChecker;
import kotlin.reflect.jvm.internal.impl.types.typeUtil.TypeUtilsKt;
import kotlin.text.StringsKt__StringsKt;
import org.jetbrains.annotations.NotNull;
import tb.ak0;
import tb.b41;
import tb.b81;
import tb.fd2;
import tb.jn1;
import tb.z71;

/* compiled from: Taobao */
/* loaded from: classes3.dex */
public final class RawTypeImpl extends ak0 implements RawType {
    private RawTypeImpl(fd2 fd2Var, fd2 fd2Var2, boolean z) {
        super(fd2Var, fd2Var2);
        if (z) {
            return;
        }
        KotlinTypeChecker.DEFAULT.isSubtypeOf(fd2Var, fd2Var2);
    }

    private static final boolean p(String str, String str2) {
        String o0;
        o0 = StringsKt__StringsKt.o0(str2, "out ");
        return b41.d(str, o0) || b41.d(str2, jn1.MUL);
    }

    private static final List<String> q(DescriptorRenderer descriptorRenderer, z71 z71Var) {
        int q;
        List<TypeProjection> b = z71Var.b();
        q = C8215n.q(b, 10);
        ArrayList arrayList = new ArrayList(q);
        for (TypeProjection typeProjection : b) {
            arrayList.add(descriptorRenderer.h(typeProjection));
        }
        return arrayList;
    }

    private static final String r(String str, String str2) {
        boolean J;
        String J0;
        String G0;
        J = StringsKt__StringsKt.J(str, '<', false, 2, null);
        if (J) {
            StringBuilder sb = new StringBuilder();
            J0 = StringsKt__StringsKt.J0(str, '<', null, 2, null);
            sb.append(J0);
            sb.append('<');
            sb.append(str2);
            sb.append('>');
            G0 = StringsKt__StringsKt.G0(str, '>', null, 2, null);
            sb.append(G0);
            return sb.toString();
        }
        return str;
    }

    @Override // tb.ak0, tb.z71
    @NotNull
    public MemberScope getMemberScope() {
        ClassifierDescriptor declarationDescriptor = c().getDeclarationDescriptor();
        ClassDescriptor classDescriptor = declarationDescriptor instanceof ClassDescriptor ? (ClassDescriptor) declarationDescriptor : null;
        if (classDescriptor != null) {
            MemberScope memberScope = classDescriptor.getMemberScope(new RawSubstitution(null, 1, null));
            b41.h(memberScope, "classDescriptor.getMemberScope(RawSubstitution())");
            return memberScope;
        }
        throw new IllegalStateException(b41.r("Incorrect classifier: ", c().getDeclarationDescriptor()).toString());
    }

    @Override // tb.ak0
    @NotNull
    public fd2 j() {
        return k();
    }

    @Override // tb.ak0
    @NotNull
    public String m(@NotNull DescriptorRenderer descriptorRenderer, @NotNull DescriptorRendererOptions descriptorRendererOptions) {
        String Z;
        List H0;
        b41.i(descriptorRenderer, "renderer");
        b41.i(descriptorRendererOptions, WXBridgeManager.OPTIONS);
        String g = descriptorRenderer.g(k());
        String g2 = descriptorRenderer.g(l());
        if (descriptorRendererOptions.getDebugMode()) {
            return "raw (" + g + ".." + g2 + ')';
        } else if (l().b().isEmpty()) {
            return descriptorRenderer.d(g, g2, TypeUtilsKt.h(this));
        } else {
            List<String> q = q(descriptorRenderer, k());
            List<String> q2 = q(descriptorRenderer, l());
            Z = CollectionsKt___CollectionsKt.Z(q, AVFSCacheConstants.COMMA_SEP, null, null, 0, null, new Function1<String, CharSequence>() { // from class: kotlin.reflect.jvm.internal.impl.load.java.lazy.types.RawTypeImpl$render$newArgs$1
                @Override // kotlin.jvm.functions.Function1
                @NotNull
                public final CharSequence invoke(@NotNull String str) {
                    b41.i(str, AdvanceSetting.NETWORK_TYPE);
                    return b41.r("(raw) ", str);
                }
            }, 30, null);
            H0 = CollectionsKt___CollectionsKt.H0(q, q2);
            boolean z = true;
            if (!(H0 instanceof Collection) || !H0.isEmpty()) {
                Iterator it = H0.iterator();
                while (true) {
                    if (!it.hasNext()) {
                        break;
                    }
                    Pair pair = (Pair) it.next();
                    if (!p((String) pair.getFirst(), (String) pair.getSecond())) {
                        z = false;
                        break;
                    }
                }
            }
            if (z) {
                g2 = r(g2, Z);
            }
            String r = r(g, Z);
            return b41.d(r, g2) ? r : descriptorRenderer.d(r, g2, TypeUtilsKt.h(this));
        }
    }

    @Override // tb.gu2
    @NotNull
    /* renamed from: n */
    public RawTypeImpl g(boolean z) {
        return new RawTypeImpl(k().j(z), l().j(z));
    }

    @Override // tb.gu2
    @NotNull
    /* renamed from: o */
    public ak0 h(@NotNull b81 b81Var) {
        b41.i(b81Var, "kotlinTypeRefiner");
        return new RawTypeImpl((fd2) b81Var.g(k()), (fd2) b81Var.g(l()), true);
    }

    @Override // tb.gu2
    @NotNull
    /* renamed from: s */
    public RawTypeImpl i(@NotNull Annotations annotations) {
        b41.i(annotations, "newAnnotations");
        return new RawTypeImpl(k().k(annotations), l().k(annotations));
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public RawTypeImpl(@NotNull fd2 fd2Var, @NotNull fd2 fd2Var2) {
        this(fd2Var, fd2Var2, false);
        b41.i(fd2Var, "lowerBound");
        b41.i(fd2Var2, "upperBound");
    }
}
