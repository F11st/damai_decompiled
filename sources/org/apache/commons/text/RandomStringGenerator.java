package org.apache.commons.text;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.concurrent.ThreadLocalRandom;
import org.apache.commons.lang3.Validate;

/* compiled from: Taobao */
/* loaded from: classes2.dex */
public final class RandomStringGenerator {
    private final List<Character> characterList;
    private final Set<CharacterPredicate> inclusivePredicates;
    private final int maximumCodePoint;
    private final int minimumCodePoint;
    private final TextRandomProvider random;

    /* compiled from: Taobao */
    /* loaded from: classes2.dex */
    public static class Builder implements org.apache.commons.text.Builder<RandomStringGenerator> {
        public static final int DEFAULT_LENGTH = 0;
        public static final int DEFAULT_MAXIMUM_CODE_POINT = 1114111;
        public static final int DEFAULT_MINIMUM_CODE_POINT = 0;
        private List<Character> characterList;
        private Set<CharacterPredicate> inclusivePredicates;
        private TextRandomProvider random;
        private int minimumCodePoint = 0;
        private int maximumCodePoint = DEFAULT_MAXIMUM_CODE_POINT;

        public Builder filteredBy(CharacterPredicate... characterPredicateArr) {
            if (characterPredicateArr != null && characterPredicateArr.length != 0) {
                Set<CharacterPredicate> set = this.inclusivePredicates;
                if (set == null) {
                    this.inclusivePredicates = new HashSet();
                } else {
                    set.clear();
                }
                Collections.addAll(this.inclusivePredicates, characterPredicateArr);
                return this;
            }
            this.inclusivePredicates = null;
            return this;
        }

        public Builder selectFrom(char... cArr) {
            this.characterList = new ArrayList();
            for (char c : cArr) {
                this.characterList.add(Character.valueOf(c));
            }
            return this;
        }

        public Builder usingRandom(TextRandomProvider textRandomProvider) {
            this.random = textRandomProvider;
            return this;
        }

        public Builder withinRange(int i, int i2) {
            Validate.isTrue(i <= i2, "Minimum code point %d is larger than maximum code point %d", Integer.valueOf(i), Integer.valueOf(i2));
            Validate.isTrue(i >= 0, "Minimum code point %d is negative", i);
            Validate.isTrue(i2 <= 1114111, "Value %d is larger than Character.MAX_CODE_POINT.", i2);
            this.minimumCodePoint = i;
            this.maximumCodePoint = i2;
            return this;
        }

        @Override // org.apache.commons.text.Builder
        public RandomStringGenerator build() {
            return new RandomStringGenerator(this.minimumCodePoint, this.maximumCodePoint, this.inclusivePredicates, this.random, this.characterList);
        }

        public Builder withinRange(char[]... cArr) {
            this.characterList = new ArrayList();
            for (char[] cArr2 : cArr) {
                Validate.isTrue(cArr2.length == 2, "Each pair must contain minimum and maximum code point", new Object[0]);
                char c = cArr2[0];
                char c2 = cArr2[1];
                Validate.isTrue(c <= c2, "Minimum code point %d is larger than maximum code point %d", Integer.valueOf(c), Integer.valueOf(c2));
                for (int i = c; i <= c2; i++) {
                    this.characterList.add(Character.valueOf((char) i));
                }
            }
            return this;
        }
    }

    private int generateRandomNumber(int i, int i2) {
        TextRandomProvider textRandomProvider = this.random;
        if (textRandomProvider != null) {
            return textRandomProvider.nextInt((i2 - i) + 1) + i;
        }
        return ThreadLocalRandom.current().nextInt(i, i2 + 1);
    }

    /* JADX WARN: Code restructure failed: missing block: B:31:0x005b, code lost:
        if (r5 == false) goto L32;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public java.lang.String generate(int r8) {
        /*
            r7 = this;
            if (r8 != 0) goto L5
            java.lang.String r8 = ""
            return r8
        L5:
            r0 = 1
            r1 = 0
            if (r8 <= 0) goto Lb
            r2 = 1
            goto Lc
        Lb:
            r2 = 0
        Lc:
            long r3 = (long) r8
            java.lang.String r5 = "Length %d is smaller than zero."
            org.apache.commons.lang3.Validate.isTrue(r2, r5, r3)
            java.lang.StringBuilder r2 = new java.lang.StringBuilder
            r2.<init>(r8)
        L17:
            java.util.List<java.lang.Character> r8 = r7.characterList
            if (r8 == 0) goto L28
            boolean r8 = r8.isEmpty()
            if (r8 != 0) goto L28
            java.util.List<java.lang.Character> r8 = r7.characterList
            int r8 = r7.generateRandomNumber(r8)
            goto L30
        L28:
            int r8 = r7.minimumCodePoint
            int r5 = r7.maximumCodePoint
            int r8 = r7.generateRandomNumber(r8, r5)
        L30:
            int r5 = java.lang.Character.getType(r8)
            if (r5 == 0) goto L64
            r6 = 18
            if (r5 == r6) goto L64
            r6 = 19
            if (r5 == r6) goto L64
            java.util.Set<org.apache.commons.text.CharacterPredicate> r5 = r7.inclusivePredicates
            if (r5 == 0) goto L5e
            java.util.Iterator r5 = r5.iterator()
        L46:
            boolean r6 = r5.hasNext()
            if (r6 == 0) goto L5a
            java.lang.Object r6 = r5.next()
            org.apache.commons.text.CharacterPredicate r6 = (org.apache.commons.text.CharacterPredicate) r6
            boolean r6 = r6.test(r8)
            if (r6 == 0) goto L46
            r5 = 1
            goto L5b
        L5a:
            r5 = 0
        L5b:
            if (r5 != 0) goto L5e
            goto L64
        L5e:
            r2.appendCodePoint(r8)
            r5 = 1
            long r3 = r3 - r5
        L64:
            r5 = 0
            int r8 = (r3 > r5 ? 1 : (r3 == r5 ? 0 : -1))
            if (r8 != 0) goto L17
            java.lang.String r8 = r2.toString()
            return r8
        */
        throw new UnsupportedOperationException("Method not decompiled: org.apache.commons.text.RandomStringGenerator.generate(int):java.lang.String");
    }

    private RandomStringGenerator(int i, int i2, Set<CharacterPredicate> set, TextRandomProvider textRandomProvider, List<Character> list) {
        this.minimumCodePoint = i;
        this.maximumCodePoint = i2;
        this.inclusivePredicates = set;
        this.random = textRandomProvider;
        this.characterList = list;
    }

    private int generateRandomNumber(List<Character> list) {
        int size = list.size();
        TextRandomProvider textRandomProvider = this.random;
        if (textRandomProvider != null) {
            return String.valueOf(list.get(textRandomProvider.nextInt(size))).codePointAt(0);
        }
        return String.valueOf(list.get(ThreadLocalRandom.current().nextInt(0, size))).codePointAt(0);
    }

    public String generate(int i, int i2) {
        Validate.isTrue(i >= 0, "Minimum length %d is smaller than zero.", i);
        Validate.isTrue(i <= i2, "Maximum length %d is smaller than minimum length %d.", Integer.valueOf(i2), Integer.valueOf(i));
        return generate(generateRandomNumber(i, i2));
    }
}
