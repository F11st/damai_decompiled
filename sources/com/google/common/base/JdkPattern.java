package com.google.common.base;

import com.google.common.annotations.GwtIncompatible;
import java.io.Serializable;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import tb.du1;

/* compiled from: Taobao */
@GwtIncompatible
/* loaded from: classes10.dex */
final class JdkPattern extends b implements Serializable {
    private static final long serialVersionUID = 0;
    private final Pattern pattern;

    /* compiled from: Taobao */
    /* loaded from: classes10.dex */
    private static final class a extends com.google.common.base.a {
        final Matcher a;

        a(Matcher matcher) {
            this.a = (Matcher) du1.p(matcher);
        }

        @Override // com.google.common.base.a
        public boolean a() {
            return this.a.find();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public JdkPattern(Pattern pattern) {
        this.pattern = (Pattern) du1.p(pattern);
    }

    @Override // com.google.common.base.b
    public int flags() {
        return this.pattern.flags();
    }

    @Override // com.google.common.base.b
    public com.google.common.base.a matcher(CharSequence charSequence) {
        return new a(this.pattern.matcher(charSequence));
    }

    @Override // com.google.common.base.b
    public String pattern() {
        return this.pattern.pattern();
    }

    @Override // com.google.common.base.b
    public String toString() {
        return this.pattern.toString();
    }
}
