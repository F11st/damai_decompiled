package tb;

import com.taobao.accs.common.Constants;
import com.taobao.weex.ui.component.AbstractEditComponent;
import com.taobao.weex.ui.component.WXBasicComponentType;
import java.util.Set;
import kotlin.jvm.JvmField;
import kotlin.text.Regex;
import org.jetbrains.annotations.NotNull;

/* compiled from: Taobao */
/* loaded from: classes3.dex */
public final class in1 {
    @JvmField
    @NotNull
    public static final ni1 AND;
    @JvmField
    @NotNull
    public static final Set<ni1> ASSIGNMENT_OPERATIONS;
    @JvmField
    @NotNull
    public static final Set<ni1> BINARY_OPERATION_NAMES;
    @JvmField
    @NotNull
    public static final ni1 COMPARE_TO;
    @JvmField
    @NotNull
    public static final Regex COMPONENT_REGEX;
    @JvmField
    @NotNull
    public static final ni1 CONTAINS;
    @JvmField
    @NotNull
    public static final ni1 DEC;
    @JvmField
    @NotNull
    public static final Set<ni1> DELEGATED_PROPERTY_OPERATORS;
    @JvmField
    @NotNull
    public static final ni1 DIV;
    @JvmField
    @NotNull
    public static final ni1 DIV_ASSIGN;
    @JvmField
    @NotNull
    public static final ni1 EQUALS;
    @JvmField
    @NotNull
    public static final ni1 GET;
    @JvmField
    @NotNull
    public static final ni1 GET_VALUE;
    @JvmField
    @NotNull
    public static final ni1 HAS_NEXT;
    @JvmField
    @NotNull
    public static final ni1 INC;
    @NotNull
    public static final in1 INSTANCE = new in1();
    @JvmField
    @NotNull
    public static final ni1 INV;
    @JvmField
    @NotNull
    public static final ni1 INVOKE;
    @JvmField
    @NotNull
    public static final ni1 ITERATOR;
    @JvmField
    @NotNull
    public static final ni1 MINUS;
    @JvmField
    @NotNull
    public static final ni1 MINUS_ASSIGN;
    @JvmField
    @NotNull
    public static final ni1 MOD;
    @JvmField
    @NotNull
    public static final ni1 MOD_ASSIGN;
    @JvmField
    @NotNull
    public static final ni1 NEXT;
    @JvmField
    @NotNull
    public static final ni1 NOT;
    @JvmField
    @NotNull
    public static final ni1 OR;
    @JvmField
    @NotNull
    public static final ni1 PLUS;
    @JvmField
    @NotNull
    public static final ni1 PLUS_ASSIGN;
    @JvmField
    @NotNull
    public static final ni1 PROVIDE_DELEGATE;
    @JvmField
    @NotNull
    public static final ni1 RANGE_TO;
    @JvmField
    @NotNull
    public static final ni1 REM;
    @JvmField
    @NotNull
    public static final ni1 REM_ASSIGN;
    @JvmField
    @NotNull
    public static final ni1 SET;
    @JvmField
    @NotNull
    public static final ni1 SET_VALUE;
    @JvmField
    @NotNull
    public static final ni1 SHL;
    @JvmField
    @NotNull
    public static final ni1 SHR;
    @JvmField
    @NotNull
    public static final Set<ni1> SIMPLE_UNARY_OPERATION_NAMES;
    @JvmField
    @NotNull
    public static final ni1 TIMES;
    @JvmField
    @NotNull
    public static final ni1 TIMES_ASSIGN;
    @JvmField
    @NotNull
    public static final ni1 TO_STRING;
    @JvmField
    @NotNull
    public static final ni1 UNARY_MINUS;
    @JvmField
    @NotNull
    public static final Set<ni1> UNARY_OPERATION_NAMES;
    @JvmField
    @NotNull
    public static final ni1 UNARY_PLUS;
    @JvmField
    @NotNull
    public static final ni1 USHR;
    @JvmField
    @NotNull
    public static final ni1 XOR;

    static {
        Set<ni1> g;
        Set<ni1> g2;
        Set<ni1> g3;
        Set<ni1> g4;
        Set<ni1> g5;
        ni1 f = ni1.f("getValue");
        b41.h(f, "identifier(\"getValue\")");
        GET_VALUE = f;
        ni1 f2 = ni1.f("setValue");
        b41.h(f2, "identifier(\"setValue\")");
        SET_VALUE = f2;
        ni1 f3 = ni1.f("provideDelegate");
        b41.h(f3, "identifier(\"provideDelegate\")");
        PROVIDE_DELEGATE = f3;
        ni1 f4 = ni1.f("equals");
        b41.h(f4, "identifier(\"equals\")");
        EQUALS = f4;
        ni1 f5 = ni1.f("compareTo");
        b41.h(f5, "identifier(\"compareTo\")");
        COMPARE_TO = f5;
        ni1 f6 = ni1.f("contains");
        b41.h(f6, "identifier(\"contains\")");
        CONTAINS = f6;
        ni1 f7 = ni1.f("invoke");
        b41.h(f7, "identifier(\"invoke\")");
        INVOKE = f7;
        ni1 f8 = ni1.f("iterator");
        b41.h(f8, "identifier(\"iterator\")");
        ITERATOR = f8;
        ni1 f9 = ni1.f(gn1.TYPE_OPEN_URL_METHOD_GET);
        b41.h(f9, "identifier(\"get\")");
        GET = f9;
        ni1 f10 = ni1.f("set");
        b41.h(f10, "identifier(\"set\")");
        SET = f10;
        ni1 f11 = ni1.f(AbstractEditComponent.ReturnTypes.NEXT);
        b41.h(f11, "identifier(\"next\")");
        NEXT = f11;
        ni1 f12 = ni1.f(xl2.HAS_NEXT);
        b41.h(f12, "identifier(\"hasNext\")");
        HAS_NEXT = f12;
        ni1 f13 = ni1.f("toString");
        b41.h(f13, "identifier(\"toString\")");
        TO_STRING = f13;
        COMPONENT_REGEX = new Regex("component\\d+");
        ni1 f14 = ni1.f(m80.AND_PREFIX);
        b41.h(f14, "identifier(\"and\")");
        AND = f14;
        ni1 f15 = ni1.f(m80.OR_PREFIX);
        b41.h(f15, "identifier(\"or\")");
        OR = f15;
        ni1 f16 = ni1.f("xor");
        b41.h(f16, "identifier(\"xor\")");
        XOR = f16;
        ni1 f17 = ni1.f("inv");
        b41.h(f17, "identifier(\"inv\")");
        INV = f17;
        ni1 f18 = ni1.f("shl");
        b41.h(f18, "identifier(\"shl\")");
        SHL = f18;
        ni1 f19 = ni1.f("shr");
        b41.h(f19, "identifier(\"shr\")");
        SHR = f19;
        ni1 f20 = ni1.f("ushr");
        b41.h(f20, "identifier(\"ushr\")");
        USHR = f20;
        ni1 f21 = ni1.f("inc");
        b41.h(f21, "identifier(\"inc\")");
        INC = f21;
        ni1 f22 = ni1.f("dec");
        b41.h(f22, "identifier(\"dec\")");
        DEC = f22;
        ni1 f23 = ni1.f("plus");
        b41.h(f23, "identifier(\"plus\")");
        PLUS = f23;
        ni1 f24 = ni1.f("minus");
        b41.h(f24, "identifier(\"minus\")");
        MINUS = f24;
        ni1 f25 = ni1.f(m80.NOT_PREFIX);
        b41.h(f25, "identifier(\"not\")");
        NOT = f25;
        ni1 f26 = ni1.f("unaryMinus");
        b41.h(f26, "identifier(\"unaryMinus\")");
        UNARY_MINUS = f26;
        ni1 f27 = ni1.f("unaryPlus");
        b41.h(f27, "identifier(\"unaryPlus\")");
        UNARY_PLUS = f27;
        ni1 f28 = ni1.f(Constants.KEY_TIMES);
        b41.h(f28, "identifier(\"times\")");
        TIMES = f28;
        ni1 f29 = ni1.f(WXBasicComponentType.DIV);
        b41.h(f29, "identifier(\"div\")");
        DIV = f29;
        ni1 f30 = ni1.f("mod");
        b41.h(f30, "identifier(\"mod\")");
        MOD = f30;
        ni1 f31 = ni1.f("rem");
        b41.h(f31, "identifier(\"rem\")");
        REM = f31;
        ni1 f32 = ni1.f("rangeTo");
        b41.h(f32, "identifier(\"rangeTo\")");
        RANGE_TO = f32;
        ni1 f33 = ni1.f("timesAssign");
        b41.h(f33, "identifier(\"timesAssign\")");
        TIMES_ASSIGN = f33;
        ni1 f34 = ni1.f("divAssign");
        b41.h(f34, "identifier(\"divAssign\")");
        DIV_ASSIGN = f34;
        ni1 f35 = ni1.f("modAssign");
        b41.h(f35, "identifier(\"modAssign\")");
        MOD_ASSIGN = f35;
        ni1 f36 = ni1.f("remAssign");
        b41.h(f36, "identifier(\"remAssign\")");
        REM_ASSIGN = f36;
        ni1 f37 = ni1.f("plusAssign");
        b41.h(f37, "identifier(\"plusAssign\")");
        PLUS_ASSIGN = f37;
        ni1 f38 = ni1.f("minusAssign");
        b41.h(f38, "identifier(\"minusAssign\")");
        MINUS_ASSIGN = f38;
        g = kotlin.collections.e0.g(f21, f22, f27, f26, f25);
        UNARY_OPERATION_NAMES = g;
        g2 = kotlin.collections.e0.g(f27, f26, f25);
        SIMPLE_UNARY_OPERATION_NAMES = g2;
        g3 = kotlin.collections.e0.g(f28, f23, f24, f29, f30, f31, f32);
        BINARY_OPERATION_NAMES = g3;
        g4 = kotlin.collections.e0.g(f33, f34, f35, f36, f37, f38);
        ASSIGNMENT_OPERATIONS = g4;
        g5 = kotlin.collections.e0.g(f, f2, f3);
        DELEGATED_PROPERTY_OPERATORS = g5;
    }

    private in1() {
    }
}
