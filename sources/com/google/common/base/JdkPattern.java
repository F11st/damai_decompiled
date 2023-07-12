package com.google.common.base;

import com.google.common.annotations.GwtIncompatible;
import java.io.Serializable;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import tb.du1;

/* compiled from: Taobao */
@GwtIncompatible
/* loaded from: classes10.dex */
final class JdkPattern extends AbstractC4830b implements Serializable {
    private static final long serialVersionUID = 0;
    private final Pattern pattern;

    /* compiled from: Taobao */
    /* renamed from: com.google.common.base.JdkPattern$a */
    /* loaded from: classes10.dex */
    private static final class C4825a extends AbstractC4829a {
        final Matcher a;

        C4825a(Matcher matcher) {
            this.a = (Matcher) du1.p(matcher);
        }

        @Override // com.google.common.base.AbstractC4829a
        public boolean a() {
            return this.a.find();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public JdkPattern(Pattern pattern) {
        this.pattern = (Pattern) du1.p(pattern);
    }

    @Override // com.google.common.base.AbstractC4830b
    public int flags() {
        return this.pattern.flags();
    }

    @Override // com.google.common.base.AbstractC4830b
    public AbstractC4829a matcher(CharSequence charSequence) {
        return new C4825a(this.pattern.matcher(charSequence));
    }

    @Override // com.google.common.base.AbstractC4830b
    public String pattern() {
        return this.pattern.pattern();
    }

    @Override // com.google.common.base.AbstractC4830b
    public String toString() {
        return this.pattern.toString();
    }
}
