package kotlin.text;

import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.C8177b;
import kotlin.Lazy;
import kotlin.collections.C8225w;
import kotlin.jvm.functions.Function0;
import org.jetbrains.annotations.NotNull;
import tb.k50;
import tb.ry1;

/* compiled from: Taobao */
/* loaded from: classes3.dex */
public enum CharDirectionality {
    UNDEFINED(-1),
    LEFT_TO_RIGHT(0),
    RIGHT_TO_LEFT(1),
    RIGHT_TO_LEFT_ARABIC(2),
    EUROPEAN_NUMBER(3),
    EUROPEAN_NUMBER_SEPARATOR(4),
    EUROPEAN_NUMBER_TERMINATOR(5),
    ARABIC_NUMBER(6),
    COMMON_NUMBER_SEPARATOR(7),
    NONSPACING_MARK(8),
    BOUNDARY_NEUTRAL(9),
    PARAGRAPH_SEPARATOR(10),
    SEGMENT_SEPARATOR(11),
    WHITESPACE(12),
    OTHER_NEUTRALS(13),
    LEFT_TO_RIGHT_EMBEDDING(14),
    LEFT_TO_RIGHT_OVERRIDE(15),
    RIGHT_TO_LEFT_EMBEDDING(16),
    RIGHT_TO_LEFT_OVERRIDE(17),
    POP_DIRECTIONAL_FORMAT(18);
    
    @NotNull
    public static final C8582a Companion = new C8582a(null);
    @NotNull
    private static final Lazy<Map<Integer, CharDirectionality>> directionalityMap$delegate;
    private final int value;

    /* compiled from: Taobao */
    /* renamed from: kotlin.text.CharDirectionality$a */
    /* loaded from: classes3.dex */
    public static final class C8582a {
        private C8582a() {
        }

        public /* synthetic */ C8582a(k50 k50Var) {
            this();
        }
    }

    static {
        Lazy<Map<Integer, CharDirectionality>> b;
        b = C8177b.b(new Function0<Map<Integer, ? extends CharDirectionality>>() { // from class: kotlin.text.CharDirectionality$Companion$directionalityMap$2
            @Override // kotlin.jvm.functions.Function0
            @NotNull
            public final Map<Integer, ? extends CharDirectionality> invoke() {
                int e;
                CharDirectionality[] values = CharDirectionality.values();
                e = C8225w.e(values.length);
                LinkedHashMap linkedHashMap = new LinkedHashMap(ry1.a(e, 16));
                for (CharDirectionality charDirectionality : values) {
                    linkedHashMap.put(Integer.valueOf(charDirectionality.getValue()), charDirectionality);
                }
                return linkedHashMap;
            }
        });
        directionalityMap$delegate = b;
    }

    CharDirectionality(int i) {
        this.value = i;
    }

    public final int getValue() {
        return this.value;
    }
}
