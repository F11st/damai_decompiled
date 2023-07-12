package kotlin.text;

import java.util.List;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import tb.b41;
import tb.n31;

/* compiled from: Taobao */
/* loaded from: classes3.dex */
public interface MatchResult {

    /* compiled from: Taobao */
    /* renamed from: kotlin.text.MatchResult$a */
    /* loaded from: classes3.dex */
    public static final class C8583a {
        @NotNull
        public static C8584b a(@NotNull MatchResult matchResult) {
            return new C8584b(matchResult);
        }
    }

    /* compiled from: Taobao */
    /* renamed from: kotlin.text.MatchResult$b */
    /* loaded from: classes3.dex */
    public static final class C8584b {
        @NotNull
        private final MatchResult a;

        public C8584b(@NotNull MatchResult matchResult) {
            b41.i(matchResult, "match");
            this.a = matchResult;
        }

        @NotNull
        public final MatchResult a() {
            return this.a;
        }
    }

    @NotNull
    C8584b getDestructured();

    @NotNull
    List<String> getGroupValues();

    @NotNull
    MatchGroupCollection getGroups();

    @NotNull
    n31 getRange();

    @NotNull
    String getValue();

    @Nullable
    MatchResult next();
}
