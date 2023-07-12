package org.apache.commons.codec.language.bm;

import java.util.Collections;
import java.util.EnumMap;
import java.util.HashSet;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.Set;
import java.util.regex.Pattern;
import org.apache.commons.codec.language.bm.Languages;

/* compiled from: Taobao */
/* loaded from: classes2.dex */
public class Lang {
    private static final String LANGUAGE_RULES_RN = "org/apache/commons/codec/language/bm/%s_lang.txt";
    private static final Map<NameType, Lang> Langs = new EnumMap(NameType.class);
    private final Languages languages;
    private final List<LangRule> rules;

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: Taobao */
    /* loaded from: classes2.dex */
    public static final class LangRule {
        private final boolean acceptOnMatch;
        private final Set<String> languages;
        private final Pattern pattern;

        public boolean matches(String str) {
            return this.pattern.matcher(str).find();
        }

        private LangRule(Pattern pattern, Set<String> set, boolean z) {
            this.pattern = pattern;
            this.languages = set;
            this.acceptOnMatch = z;
        }
    }

    static {
        NameType[] values;
        for (NameType nameType : NameType.values()) {
            Langs.put(nameType, loadFromResource(String.format(LANGUAGE_RULES_RN, nameType.getName()), Languages.getInstance(nameType)));
        }
    }

    private Lang(List<LangRule> list, Languages languages) {
        this.rules = Collections.unmodifiableList(list);
        this.languages = languages;
    }

    public static Lang instance(NameType nameType) {
        return Langs.get(nameType);
    }

    /* JADX WARN: Code restructure failed: missing block: B:27:0x00aa, code lost:
        throw new java.lang.IllegalArgumentException("Malformed line '" + r4 + "' in language resource '" + r9 + "'");
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static org.apache.commons.codec.language.bm.Lang loadFromResource(java.lang.String r9, org.apache.commons.codec.language.bm.Languages r10) {
        /*
            java.util.ArrayList r0 = new java.util.ArrayList
            r0.<init>()
            java.lang.Class<org.apache.commons.codec.language.bm.Lang> r1 = org.apache.commons.codec.language.bm.Lang.class
            java.lang.ClassLoader r1 = r1.getClassLoader()
            java.io.InputStream r1 = r1.getResourceAsStream(r9)
            if (r1 == 0) goto Lb9
            java.util.Scanner r2 = new java.util.Scanner
            java.lang.String r3 = "UTF-8"
            r2.<init>(r1, r3)
            r1 = 0
        L19:
            r3 = 0
        L1a:
            boolean r4 = r2.hasNextLine()     // Catch: java.lang.Throwable -> Lb4
            if (r4 == 0) goto Lab
            java.lang.String r4 = r2.nextLine()     // Catch: java.lang.Throwable -> Lb4
            r5 = 1
            if (r3 == 0) goto L30
        */
        //  java.lang.String r5 = "*/"
        /*
            boolean r4 = r4.endsWith(r5)     // Catch: java.lang.Throwable -> Lb4
            if (r4 == 0) goto L1a
            goto L19
        L30:
            java.lang.String r6 = "/*"
            boolean r6 = r4.startsWith(r6)     // Catch: java.lang.Throwable -> Lb4
            if (r6 == 0) goto L3a
            r3 = 1
            goto L1a
        L3a:
            java.lang.String r6 = "//"
            int r6 = r4.indexOf(r6)     // Catch: java.lang.Throwable -> Lb4
            if (r6 < 0) goto L47
            java.lang.String r6 = r4.substring(r1, r6)     // Catch: java.lang.Throwable -> Lb4
            goto L48
        L47:
            r6 = r4
        L48:
            java.lang.String r6 = r6.trim()     // Catch: java.lang.Throwable -> Lb4
            int r7 = r6.length()     // Catch: java.lang.Throwable -> Lb4
            if (r7 != 0) goto L53
            goto L1a
        L53:
            java.lang.String r7 = "\\s+"
            java.lang.String[] r6 = r6.split(r7)     // Catch: java.lang.Throwable -> Lb4
            int r7 = r6.length     // Catch: java.lang.Throwable -> Lb4
            r8 = 3
            if (r7 != r8) goto L87
            r4 = r6[r1]     // Catch: java.lang.Throwable -> Lb4
            java.util.regex.Pattern r4 = java.util.regex.Pattern.compile(r4)     // Catch: java.lang.Throwable -> Lb4
            r5 = r6[r5]     // Catch: java.lang.Throwable -> Lb4
            java.lang.String r7 = "\\+"
            java.lang.String[] r5 = r5.split(r7)     // Catch: java.lang.Throwable -> Lb4
            r7 = 2
            r6 = r6[r7]     // Catch: java.lang.Throwable -> Lb4
            java.lang.String r7 = "true"
            boolean r6 = r6.equals(r7)     // Catch: java.lang.Throwable -> Lb4
            org.apache.commons.codec.language.bm.Lang$LangRule r7 = new org.apache.commons.codec.language.bm.Lang$LangRule     // Catch: java.lang.Throwable -> Lb4
            java.util.HashSet r8 = new java.util.HashSet     // Catch: java.lang.Throwable -> Lb4
            java.util.List r5 = java.util.Arrays.asList(r5)     // Catch: java.lang.Throwable -> Lb4
            r8.<init>(r5)     // Catch: java.lang.Throwable -> Lb4
            r5 = 0
            r7.<init>(r4, r8, r6)     // Catch: java.lang.Throwable -> Lb4
            r0.add(r7)     // Catch: java.lang.Throwable -> Lb4
            goto L1a
        L87:
            java.lang.IllegalArgumentException r10 = new java.lang.IllegalArgumentException     // Catch: java.lang.Throwable -> Lb4
            java.lang.StringBuilder r0 = new java.lang.StringBuilder     // Catch: java.lang.Throwable -> Lb4
            r0.<init>()     // Catch: java.lang.Throwable -> Lb4
            java.lang.String r1 = "Malformed line '"
            r0.append(r1)     // Catch: java.lang.Throwable -> Lb4
            r0.append(r4)     // Catch: java.lang.Throwable -> Lb4
            java.lang.String r1 = "' in language resource '"
            r0.append(r1)     // Catch: java.lang.Throwable -> Lb4
            r0.append(r9)     // Catch: java.lang.Throwable -> Lb4
            java.lang.String r9 = "'"
            r0.append(r9)     // Catch: java.lang.Throwable -> Lb4
            java.lang.String r9 = r0.toString()     // Catch: java.lang.Throwable -> Lb4
            r10.<init>(r9)     // Catch: java.lang.Throwable -> Lb4
            throw r10     // Catch: java.lang.Throwable -> Lb4
        Lab:
            r2.close()
            org.apache.commons.codec.language.bm.Lang r9 = new org.apache.commons.codec.language.bm.Lang
            r9.<init>(r0, r10)
            return r9
        Lb4:
            r9 = move-exception
            r2.close()
            throw r9
        Lb9:
            java.lang.IllegalStateException r9 = new java.lang.IllegalStateException
            java.lang.String r10 = "Unable to resolve required resource:org/apache/commons/codec/language/bm/%s_lang.txt"
            r9.<init>(r10)
            throw r9
        */
        throw new UnsupportedOperationException("Method not decompiled: org.apache.commons.codec.language.bm.Lang.loadFromResource(java.lang.String, org.apache.commons.codec.language.bm.Languages):org.apache.commons.codec.language.bm.Lang");
    }

    public String guessLanguage(String str) {
        Languages.LanguageSet guessLanguages = guessLanguages(str);
        return guessLanguages.isSingleton() ? guessLanguages.getAny() : Languages.ANY;
    }

    public Languages.LanguageSet guessLanguages(String str) {
        String lowerCase = str.toLowerCase(Locale.ENGLISH);
        HashSet hashSet = new HashSet(this.languages.getLanguages());
        for (LangRule langRule : this.rules) {
            if (langRule.matches(lowerCase)) {
                if (langRule.acceptOnMatch) {
                    hashSet.retainAll(langRule.languages);
                } else {
                    hashSet.removeAll(langRule.languages);
                }
            }
        }
        Languages.LanguageSet from = Languages.LanguageSet.from(hashSet);
        return from.equals(Languages.NO_LANGUAGES) ? Languages.ANY_LANGUAGE : from;
    }
}
