package kotlin.text;

import java.util.regex.Matcher;
import tb.n31;
import tb.ty1;

/* compiled from: Taobao */
/* loaded from: classes3.dex */
public final class e {
    /* JADX INFO: Access modifiers changed from: private */
    public static final MatchResult f(Matcher matcher, int i, CharSequence charSequence) {
        if (matcher.find(i)) {
            return new MatcherMatchResult(matcher, charSequence);
        }
        return null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final MatchResult g(Matcher matcher, CharSequence charSequence) {
        if (matcher.matches()) {
            return new MatcherMatchResult(matcher, charSequence);
        }
        return null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final n31 h(java.util.regex.MatchResult matchResult) {
        n31 h;
        h = ty1.h(matchResult.start(), matchResult.end());
        return h;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final n31 i(java.util.regex.MatchResult matchResult, int i) {
        n31 h;
        h = ty1.h(matchResult.start(i), matchResult.end(i));
        return h;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final int j(Iterable<? extends FlagEnum> iterable) {
        int i = 0;
        for (FlagEnum flagEnum : iterable) {
            i |= flagEnum.getValue();
        }
        return i;
    }
}
