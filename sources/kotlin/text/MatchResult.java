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
    /* loaded from: classes3.dex */
    public static final class a {
        @NotNull
        public static b a(@NotNull MatchResult matchResult) {
            return new b(matchResult);
        }
    }

    /* compiled from: Taobao */
    /* loaded from: classes3.dex */
    public static final class b {
        @NotNull
        private final MatchResult a;

        public b(@NotNull MatchResult matchResult) {
            b41.i(matchResult, "match");
            this.a = matchResult;
        }

        @NotNull
        public final MatchResult a() {
            return this.a;
        }
    }

    @NotNull
    b getDestructured();

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
