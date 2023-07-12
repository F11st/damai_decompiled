package kotlin.text;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collections;
import java.util.EnumSet;
import java.util.List;
import java.util.Set;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import kotlin.ExperimentalStdlibApi;
import kotlin.PublishedApi;
import kotlin.SinceKotlin;
import kotlin.WasExperimental;
import kotlin.collections.r;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.sequences.Sequence;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import tb.b41;
import tb.k50;
import tb.ty1;

/* compiled from: Taobao */
/* loaded from: classes3.dex */
public final class Regex implements Serializable {
    @NotNull
    public static final a Companion = new a(null);
    @Nullable
    private Set<? extends RegexOption> _options;
    @NotNull
    private final Pattern nativePattern;

    /* compiled from: Taobao */
    /* loaded from: classes3.dex */
    private static final class Serialized implements Serializable {
        @NotNull
        public static final a Companion = new a(null);
        private static final long serialVersionUID = 0;
        private final int flags;
        @NotNull
        private final String pattern;

        /* compiled from: Taobao */
        /* loaded from: classes3.dex */
        public static final class a {
            private a() {
            }

            public /* synthetic */ a(k50 k50Var) {
                this();
            }
        }

        public Serialized(@NotNull String str, int i) {
            b41.i(str, "pattern");
            this.pattern = str;
            this.flags = i;
        }

        private final Object readResolve() {
            Pattern compile = Pattern.compile(this.pattern, this.flags);
            b41.h(compile, "compile(pattern, flags)");
            return new Regex(compile);
        }

        public final int getFlags() {
            return this.flags;
        }

        @NotNull
        public final String getPattern() {
            return this.pattern;
        }
    }

    /* compiled from: Taobao */
    /* loaded from: classes3.dex */
    public static final class a {
        private a() {
        }

        public /* synthetic */ a(k50 k50Var) {
            this();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public final int b(int i) {
            return (i & 2) != 0 ? i | 64 : i;
        }
    }

    @PublishedApi
    public Regex(@NotNull Pattern pattern) {
        b41.i(pattern, "nativePattern");
        this.nativePattern = pattern;
    }

    public static /* synthetic */ MatchResult find$default(Regex regex, CharSequence charSequence, int i, int i2, Object obj) {
        if ((i2 & 2) != 0) {
            i = 0;
        }
        return regex.find(charSequence, i);
    }

    public static /* synthetic */ Sequence findAll$default(Regex regex, CharSequence charSequence, int i, int i2, Object obj) {
        if ((i2 & 2) != 0) {
            i = 0;
        }
        return regex.findAll(charSequence, i);
    }

    public static /* synthetic */ List split$default(Regex regex, CharSequence charSequence, int i, int i2, Object obj) {
        if ((i2 & 2) != 0) {
            i = 0;
        }
        return regex.split(charSequence, i);
    }

    public static /* synthetic */ Sequence splitToSequence$default(Regex regex, CharSequence charSequence, int i, int i2, Object obj) {
        if ((i2 & 2) != 0) {
            i = 0;
        }
        return regex.splitToSequence(charSequence, i);
    }

    private final Object writeReplace() {
        String pattern = this.nativePattern.pattern();
        b41.h(pattern, "nativePattern.pattern()");
        return new Serialized(pattern, this.nativePattern.flags());
    }

    public final boolean containsMatchIn(@NotNull CharSequence charSequence) {
        b41.i(charSequence, "input");
        return this.nativePattern.matcher(charSequence).find();
    }

    @Nullable
    public final MatchResult find(@NotNull CharSequence charSequence, int i) {
        MatchResult f;
        b41.i(charSequence, "input");
        Matcher matcher = this.nativePattern.matcher(charSequence);
        b41.h(matcher, "nativePattern.matcher(input)");
        f = e.f(matcher, i, charSequence);
        return f;
    }

    @NotNull
    public final Sequence<MatchResult> findAll(@NotNull final CharSequence charSequence, final int i) {
        b41.i(charSequence, "input");
        if (i >= 0 && i <= charSequence.length()) {
            return kotlin.sequences.d.j(new Function0<MatchResult>() { // from class: kotlin.text.Regex$findAll$1
                /* JADX INFO: Access modifiers changed from: package-private */
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(0);
                }

                @Override // kotlin.jvm.functions.Function0
                @Nullable
                public final MatchResult invoke() {
                    return Regex.this.find(charSequence, i);
                }
            }, Regex$findAll$2.INSTANCE);
        }
        throw new IndexOutOfBoundsException("Start index out of bounds: " + i + ", input length: " + charSequence.length());
    }

    @NotNull
    public final Set<RegexOption> getOptions() {
        Set set = this._options;
        if (set == null) {
            final int flags = this.nativePattern.flags();
            EnumSet allOf = EnumSet.allOf(RegexOption.class);
            b41.h(allOf, "");
            r.z(allOf, new Function1<RegexOption, Boolean>() { // from class: kotlin.text.Regex$special$$inlined$fromInt$1
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(1);
                }

                @Override // kotlin.jvm.functions.Function1
                @NotNull
                public final Boolean invoke(RegexOption regexOption) {
                    RegexOption regexOption2 = regexOption;
                    return Boolean.valueOf((flags & regexOption2.getMask()) == regexOption2.getValue());
                }
            });
            Set<RegexOption> unmodifiableSet = Collections.unmodifiableSet(allOf);
            b41.h(unmodifiableSet, "unmodifiableSet(EnumSet.…mask == it.value }\n    })");
            this._options = unmodifiableSet;
            return unmodifiableSet;
        }
        return set;
    }

    @NotNull
    public final String getPattern() {
        String pattern = this.nativePattern.pattern();
        b41.h(pattern, "nativePattern.pattern()");
        return pattern;
    }

    @SinceKotlin(version = "1.7")
    @WasExperimental(markerClass = {ExperimentalStdlibApi.class})
    @Nullable
    public final MatchResult matchAt(@NotNull CharSequence charSequence, int i) {
        b41.i(charSequence, "input");
        Matcher region = this.nativePattern.matcher(charSequence).useAnchoringBounds(false).useTransparentBounds(true).region(i, charSequence.length());
        if (region.lookingAt()) {
            b41.h(region, "this");
            return new MatcherMatchResult(region, charSequence);
        }
        return null;
    }

    @Nullable
    public final MatchResult matchEntire(@NotNull CharSequence charSequence) {
        MatchResult g;
        b41.i(charSequence, "input");
        Matcher matcher = this.nativePattern.matcher(charSequence);
        b41.h(matcher, "nativePattern.matcher(input)");
        g = e.g(matcher, charSequence);
        return g;
    }

    public final boolean matches(@NotNull CharSequence charSequence) {
        b41.i(charSequence, "input");
        return this.nativePattern.matcher(charSequence).matches();
    }

    @SinceKotlin(version = "1.7")
    @WasExperimental(markerClass = {ExperimentalStdlibApi.class})
    public final boolean matchesAt(@NotNull CharSequence charSequence, int i) {
        b41.i(charSequence, "input");
        return this.nativePattern.matcher(charSequence).useAnchoringBounds(false).useTransparentBounds(true).region(i, charSequence.length()).lookingAt();
    }

    @NotNull
    public final String replace(@NotNull CharSequence charSequence, @NotNull String str) {
        b41.i(charSequence, "input");
        b41.i(str, "replacement");
        String replaceAll = this.nativePattern.matcher(charSequence).replaceAll(str);
        b41.h(replaceAll, "nativePattern.matcher(in…).replaceAll(replacement)");
        return replaceAll;
    }

    @NotNull
    public final String replaceFirst(@NotNull CharSequence charSequence, @NotNull String str) {
        b41.i(charSequence, "input");
        b41.i(str, "replacement");
        String replaceFirst = this.nativePattern.matcher(charSequence).replaceFirst(str);
        b41.h(replaceFirst, "nativePattern.matcher(in…replaceFirst(replacement)");
        return replaceFirst;
    }

    @NotNull
    public final List<String> split(@NotNull CharSequence charSequence, int i) {
        List<String> e;
        b41.i(charSequence, "input");
        StringsKt__StringsKt.q0(i);
        Matcher matcher = this.nativePattern.matcher(charSequence);
        if (i != 1 && matcher.find()) {
            ArrayList arrayList = new ArrayList(i > 0 ? ty1.d(i, 10) : 10);
            int i2 = 0;
            int i3 = i - 1;
            do {
                arrayList.add(charSequence.subSequence(i2, matcher.start()).toString());
                i2 = matcher.end();
                if (i3 >= 0 && arrayList.size() == i3) {
                    break;
                }
            } while (matcher.find());
            arrayList.add(charSequence.subSequence(i2, charSequence.length()).toString());
            return arrayList;
        }
        e = kotlin.collections.l.e(charSequence.toString());
        return e;
    }

    @SinceKotlin(version = "1.6")
    @WasExperimental(markerClass = {ExperimentalStdlibApi.class})
    @NotNull
    public final Sequence<String> splitToSequence(@NotNull CharSequence charSequence, int i) {
        b41.i(charSequence, "input");
        StringsKt__StringsKt.q0(i);
        return kotlin.sequences.d.b(new Regex$splitToSequence$1(this, charSequence, i, null));
    }

    @NotNull
    public final Pattern toPattern() {
        return this.nativePattern;
    }

    @NotNull
    public String toString() {
        String pattern = this.nativePattern.toString();
        b41.h(pattern, "nativePattern.toString()");
        return pattern;
    }

    @NotNull
    public final String replace(@NotNull CharSequence charSequence, @NotNull Function1<? super MatchResult, ? extends CharSequence> function1) {
        b41.i(charSequence, "input");
        b41.i(function1, "transform");
        int i = 0;
        MatchResult find$default = find$default(this, charSequence, 0, 2, null);
        if (find$default == null) {
            return charSequence.toString();
        }
        int length = charSequence.length();
        StringBuilder sb = new StringBuilder(length);
        do {
            sb.append(charSequence, i, find$default.getRange().getStart().intValue());
            sb.append(function1.invoke(find$default));
            i = find$default.getRange().getEndInclusive().intValue() + 1;
            find$default = find$default.next();
            if (i >= length) {
                break;
            }
        } while (find$default != null);
        if (i < length) {
            sb.append(charSequence, i, length);
        }
        String sb2 = sb.toString();
        b41.h(sb2, "sb.toString()");
        return sb2;
    }

    /* JADX WARN: Illegal instructions before constructor call */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public Regex(@org.jetbrains.annotations.NotNull java.lang.String r2) {
        /*
            r1 = this;
            java.lang.String r0 = "pattern"
            tb.b41.i(r2, r0)
            java.util.regex.Pattern r2 = java.util.regex.Pattern.compile(r2)
            java.lang.String r0 = "compile(pattern)"
            tb.b41.h(r2, r0)
            r1.<init>(r2)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: kotlin.text.Regex.<init>(java.lang.String):void");
    }

    /* JADX WARN: Illegal instructions before constructor call */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public Regex(@org.jetbrains.annotations.NotNull java.lang.String r2, @org.jetbrains.annotations.NotNull kotlin.text.RegexOption r3) {
        /*
            r1 = this;
            java.lang.String r0 = "pattern"
            tb.b41.i(r2, r0)
            java.lang.String r0 = "option"
            tb.b41.i(r3, r0)
            kotlin.text.Regex$a r0 = kotlin.text.Regex.Companion
            int r3 = r3.getValue()
            int r3 = kotlin.text.Regex.a.a(r0, r3)
            java.util.regex.Pattern r2 = java.util.regex.Pattern.compile(r2, r3)
            java.lang.String r3 = "compile(pattern, ensureUnicodeCase(option.value))"
            tb.b41.h(r2, r3)
            r1.<init>(r2)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: kotlin.text.Regex.<init>(java.lang.String, kotlin.text.RegexOption):void");
    }

    /* JADX WARN: Illegal instructions before constructor call */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public Regex(@org.jetbrains.annotations.NotNull java.lang.String r2, @org.jetbrains.annotations.NotNull java.util.Set<? extends kotlin.text.RegexOption> r3) {
        /*
            r1 = this;
            java.lang.String r0 = "pattern"
            tb.b41.i(r2, r0)
            java.lang.String r0 = "options"
            tb.b41.i(r3, r0)
            kotlin.text.Regex$a r0 = kotlin.text.Regex.Companion
            int r3 = kotlin.text.e.e(r3)
            int r3 = kotlin.text.Regex.a.a(r0, r3)
            java.util.regex.Pattern r2 = java.util.regex.Pattern.compile(r2, r3)
            java.lang.String r3 = "compile(pattern, ensureU…odeCase(options.toInt()))"
            tb.b41.h(r2, r3)
            r1.<init>(r2)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: kotlin.text.Regex.<init>(java.lang.String, java.util.Set):void");
    }
}
