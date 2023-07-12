package tb;

import com.meizu.cloud.pushsdk.notification.model.AdvanceSetting;
import java.util.ArrayList;
import java.util.List;
import kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf$Class;
import kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf$Function;
import kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf$Property;
import kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf$Type;
import kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf$TypeAlias;
import kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf$TypeParameter;
import kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf$ValueParameter;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: Taobao */
/* loaded from: classes3.dex */
public final class jx1 {
    @Nullable
    public static final ProtoBuf$Type a(@NotNull ProtoBuf$Type protoBuf$Type, @NotNull er2 er2Var) {
        b41.i(protoBuf$Type, "<this>");
        b41.i(er2Var, "typeTable");
        if (protoBuf$Type.hasAbbreviatedType()) {
            return protoBuf$Type.getAbbreviatedType();
        }
        if (protoBuf$Type.hasAbbreviatedTypeId()) {
            return er2Var.a(protoBuf$Type.getAbbreviatedTypeId());
        }
        return null;
    }

    @NotNull
    public static final ProtoBuf$Type b(@NotNull ProtoBuf$TypeAlias protoBuf$TypeAlias, @NotNull er2 er2Var) {
        b41.i(protoBuf$TypeAlias, "<this>");
        b41.i(er2Var, "typeTable");
        if (protoBuf$TypeAlias.hasExpandedType()) {
            ProtoBuf$Type expandedType = protoBuf$TypeAlias.getExpandedType();
            b41.h(expandedType, "expandedType");
            return expandedType;
        } else if (protoBuf$TypeAlias.hasExpandedTypeId()) {
            return er2Var.a(protoBuf$TypeAlias.getExpandedTypeId());
        } else {
            throw new IllegalStateException("No expandedType in ProtoBuf.TypeAlias".toString());
        }
    }

    @Nullable
    public static final ProtoBuf$Type c(@NotNull ProtoBuf$Type protoBuf$Type, @NotNull er2 er2Var) {
        b41.i(protoBuf$Type, "<this>");
        b41.i(er2Var, "typeTable");
        if (protoBuf$Type.hasFlexibleUpperBound()) {
            return protoBuf$Type.getFlexibleUpperBound();
        }
        if (protoBuf$Type.hasFlexibleUpperBoundId()) {
            return er2Var.a(protoBuf$Type.getFlexibleUpperBoundId());
        }
        return null;
    }

    public static final boolean d(@NotNull ProtoBuf$Function protoBuf$Function) {
        b41.i(protoBuf$Function, "<this>");
        return protoBuf$Function.hasReceiverType() || protoBuf$Function.hasReceiverTypeId();
    }

    public static final boolean e(@NotNull ProtoBuf$Property protoBuf$Property) {
        b41.i(protoBuf$Property, "<this>");
        return protoBuf$Property.hasReceiverType() || protoBuf$Property.hasReceiverTypeId();
    }

    @Nullable
    public static final ProtoBuf$Type f(@NotNull ProtoBuf$Class protoBuf$Class, @NotNull er2 er2Var) {
        b41.i(protoBuf$Class, "<this>");
        b41.i(er2Var, "typeTable");
        if (protoBuf$Class.hasInlineClassUnderlyingType()) {
            return protoBuf$Class.getInlineClassUnderlyingType();
        }
        if (protoBuf$Class.hasInlineClassUnderlyingTypeId()) {
            return er2Var.a(protoBuf$Class.getInlineClassUnderlyingTypeId());
        }
        return null;
    }

    @Nullable
    public static final ProtoBuf$Type g(@NotNull ProtoBuf$Type protoBuf$Type, @NotNull er2 er2Var) {
        b41.i(protoBuf$Type, "<this>");
        b41.i(er2Var, "typeTable");
        if (protoBuf$Type.hasOuterType()) {
            return protoBuf$Type.getOuterType();
        }
        if (protoBuf$Type.hasOuterTypeId()) {
            return er2Var.a(protoBuf$Type.getOuterTypeId());
        }
        return null;
    }

    @Nullable
    public static final ProtoBuf$Type h(@NotNull ProtoBuf$Function protoBuf$Function, @NotNull er2 er2Var) {
        b41.i(protoBuf$Function, "<this>");
        b41.i(er2Var, "typeTable");
        if (protoBuf$Function.hasReceiverType()) {
            return protoBuf$Function.getReceiverType();
        }
        if (protoBuf$Function.hasReceiverTypeId()) {
            return er2Var.a(protoBuf$Function.getReceiverTypeId());
        }
        return null;
    }

    @Nullable
    public static final ProtoBuf$Type i(@NotNull ProtoBuf$Property protoBuf$Property, @NotNull er2 er2Var) {
        b41.i(protoBuf$Property, "<this>");
        b41.i(er2Var, "typeTable");
        if (protoBuf$Property.hasReceiverType()) {
            return protoBuf$Property.getReceiverType();
        }
        if (protoBuf$Property.hasReceiverTypeId()) {
            return er2Var.a(protoBuf$Property.getReceiverTypeId());
        }
        return null;
    }

    @NotNull
    public static final ProtoBuf$Type j(@NotNull ProtoBuf$Function protoBuf$Function, @NotNull er2 er2Var) {
        b41.i(protoBuf$Function, "<this>");
        b41.i(er2Var, "typeTable");
        if (protoBuf$Function.hasReturnType()) {
            ProtoBuf$Type returnType = protoBuf$Function.getReturnType();
            b41.h(returnType, "returnType");
            return returnType;
        } else if (protoBuf$Function.hasReturnTypeId()) {
            return er2Var.a(protoBuf$Function.getReturnTypeId());
        } else {
            throw new IllegalStateException("No returnType in ProtoBuf.Function".toString());
        }
    }

    @NotNull
    public static final ProtoBuf$Type k(@NotNull ProtoBuf$Property protoBuf$Property, @NotNull er2 er2Var) {
        b41.i(protoBuf$Property, "<this>");
        b41.i(er2Var, "typeTable");
        if (protoBuf$Property.hasReturnType()) {
            ProtoBuf$Type returnType = protoBuf$Property.getReturnType();
            b41.h(returnType, "returnType");
            return returnType;
        } else if (protoBuf$Property.hasReturnTypeId()) {
            return er2Var.a(protoBuf$Property.getReturnTypeId());
        } else {
            throw new IllegalStateException("No returnType in ProtoBuf.Property".toString());
        }
    }

    @NotNull
    public static final List<ProtoBuf$Type> l(@NotNull ProtoBuf$Class protoBuf$Class, @NotNull er2 er2Var) {
        int q;
        b41.i(protoBuf$Class, "<this>");
        b41.i(er2Var, "typeTable");
        List<ProtoBuf$Type> supertypeList = protoBuf$Class.getSupertypeList();
        if (!(!supertypeList.isEmpty())) {
            supertypeList = null;
        }
        if (supertypeList == null) {
            List<Integer> supertypeIdList = protoBuf$Class.getSupertypeIdList();
            b41.h(supertypeIdList, "supertypeIdList");
            q = kotlin.collections.n.q(supertypeIdList, 10);
            supertypeList = new ArrayList<>(q);
            for (Integer num : supertypeIdList) {
                b41.h(num, AdvanceSetting.NETWORK_TYPE);
                supertypeList.add(er2Var.a(num.intValue()));
            }
        }
        return supertypeList;
    }

    @Nullable
    public static final ProtoBuf$Type m(@NotNull ProtoBuf$Type.Argument argument, @NotNull er2 er2Var) {
        b41.i(argument, "<this>");
        b41.i(er2Var, "typeTable");
        if (argument.hasType()) {
            return argument.getType();
        }
        if (argument.hasTypeId()) {
            return er2Var.a(argument.getTypeId());
        }
        return null;
    }

    @NotNull
    public static final ProtoBuf$Type n(@NotNull ProtoBuf$ValueParameter protoBuf$ValueParameter, @NotNull er2 er2Var) {
        b41.i(protoBuf$ValueParameter, "<this>");
        b41.i(er2Var, "typeTable");
        if (protoBuf$ValueParameter.hasType()) {
            ProtoBuf$Type type = protoBuf$ValueParameter.getType();
            b41.h(type, "type");
            return type;
        } else if (protoBuf$ValueParameter.hasTypeId()) {
            return er2Var.a(protoBuf$ValueParameter.getTypeId());
        } else {
            throw new IllegalStateException("No type in ProtoBuf.ValueParameter".toString());
        }
    }

    @NotNull
    public static final ProtoBuf$Type o(@NotNull ProtoBuf$TypeAlias protoBuf$TypeAlias, @NotNull er2 er2Var) {
        b41.i(protoBuf$TypeAlias, "<this>");
        b41.i(er2Var, "typeTable");
        if (protoBuf$TypeAlias.hasUnderlyingType()) {
            ProtoBuf$Type underlyingType = protoBuf$TypeAlias.getUnderlyingType();
            b41.h(underlyingType, "underlyingType");
            return underlyingType;
        } else if (protoBuf$TypeAlias.hasUnderlyingTypeId()) {
            return er2Var.a(protoBuf$TypeAlias.getUnderlyingTypeId());
        } else {
            throw new IllegalStateException("No underlyingType in ProtoBuf.TypeAlias".toString());
        }
    }

    @NotNull
    public static final List<ProtoBuf$Type> p(@NotNull ProtoBuf$TypeParameter protoBuf$TypeParameter, @NotNull er2 er2Var) {
        int q;
        b41.i(protoBuf$TypeParameter, "<this>");
        b41.i(er2Var, "typeTable");
        List<ProtoBuf$Type> upperBoundList = protoBuf$TypeParameter.getUpperBoundList();
        if (!(!upperBoundList.isEmpty())) {
            upperBoundList = null;
        }
        if (upperBoundList == null) {
            List<Integer> upperBoundIdList = protoBuf$TypeParameter.getUpperBoundIdList();
            b41.h(upperBoundIdList, "upperBoundIdList");
            q = kotlin.collections.n.q(upperBoundIdList, 10);
            upperBoundList = new ArrayList<>(q);
            for (Integer num : upperBoundIdList) {
                b41.h(num, AdvanceSetting.NETWORK_TYPE);
                upperBoundList.add(er2Var.a(num.intValue()));
            }
        }
        return upperBoundList;
    }

    @Nullable
    public static final ProtoBuf$Type q(@NotNull ProtoBuf$ValueParameter protoBuf$ValueParameter, @NotNull er2 er2Var) {
        b41.i(protoBuf$ValueParameter, "<this>");
        b41.i(er2Var, "typeTable");
        if (protoBuf$ValueParameter.hasVarargElementType()) {
            return protoBuf$ValueParameter.getVarargElementType();
        }
        if (protoBuf$ValueParameter.hasVarargElementTypeId()) {
            return er2Var.a(protoBuf$ValueParameter.getVarargElementTypeId());
        }
        return null;
    }
}
