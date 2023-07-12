package kotlin.text;

import java.util.List;
import java.util.regex.Matcher;
import kotlin.text.MatchResult;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import tb.b41;
import tb.n31;
import tb.u1;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: Taobao */
/* loaded from: classes3.dex */
public final class MatcherMatchResult implements MatchResult {
    @NotNull
    private final Matcher a;
    @NotNull
    private final CharSequence b;
    @NotNull
    private final MatchGroupCollection c;
    @Nullable
    private List<String> d;

    /* compiled from: Taobao */
    /* renamed from: kotlin.text.MatcherMatchResult$a */
    /* loaded from: classes3.dex */
    public static final class C8585a extends u1<String> {
        C8585a() {
        }

        @Override // kotlin.collections.AbstractCollection
        public int a() {
            return MatcherMatchResult.this.b().groupCount() + 1;
        }

        public /* bridge */ boolean b(String str) {
            return super.contains(str);
        }

        @Override // tb.u1, java.util.List
        @NotNull
        /* renamed from: c */
        public String get(int i) {
            String group = MatcherMatchResult.this.b().group(i);
            return group == null ? "" : group;
        }

        @Override // kotlin.collections.AbstractCollection, java.util.Collection
        public final /* bridge */ boolean contains(Object obj) {
            if (obj instanceof String) {
                return b((String) obj);
            }
            return false;
        }

        public /* bridge */ int d(String str) {
            return super.indexOf(str);
        }

        public /* bridge */ int e(String str) {
            return super.lastIndexOf(str);
        }

        @Override // tb.u1, java.util.List
        public final /* bridge */ int indexOf(Object obj) {
            if (obj instanceof String) {
                return d((String) obj);
            }
            return -1;
        }

        @Override // tb.u1, java.util.List
        public final /* bridge */ int lastIndexOf(Object obj) {
            if (obj instanceof String) {
                return e((String) obj);
            }
            return -1;
        }
    }

    public MatcherMatchResult(@NotNull Matcher matcher, @NotNull CharSequence charSequence) {
        b41.i(matcher, "matcher");
        b41.i(charSequence, "input");
        this.a = matcher;
        this.b = charSequence;
        this.c = new MatcherMatchResult$groups$1(this);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final java.util.regex.MatchResult b() {
        return this.a;
    }

    @Override // kotlin.text.MatchResult
    @NotNull
    public MatchResult.C8584b getDestructured() {
        return MatchResult.C8583a.a(this);
    }

    @Override // kotlin.text.MatchResult
    @NotNull
    public List<String> getGroupValues() {
        if (this.d == null) {
            this.d = new C8585a();
        }
        List<String> list = this.d;
        b41.f(list);
        return list;
    }

    @Override // kotlin.text.MatchResult
    @NotNull
    public MatchGroupCollection getGroups() {
        return this.c;
    }

    @Override // kotlin.text.MatchResult
    @NotNull
    public n31 getRange() {
        n31 h;
        h = C8594e.h(b());
        return h;
    }

    @Override // kotlin.text.MatchResult
    @NotNull
    public String getValue() {
        String group = b().group();
        b41.h(group, "matchResult.group()");
        return group;
    }

    @Override // kotlin.text.MatchResult
    @Nullable
    public MatchResult next() {
        MatchResult f;
        int end = b().end() + (b().end() == b().start() ? 1 : 0);
        if (end <= this.b.length()) {
            Matcher matcher = this.a.pattern().matcher(this.b);
            b41.h(matcher, "matcher.pattern().matcher(input)");
            f = C8594e.f(matcher, end, this.b);
            return f;
        }
        return null;
    }
}
