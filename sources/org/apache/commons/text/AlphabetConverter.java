package org.apache.commons.text;

import java.io.UnsupportedEncodingException;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import java.util.Map;
import java.util.Objects;

/* compiled from: Taobao */
/* loaded from: classes2.dex */
public final class AlphabetConverter {
    private static final String ARROW = " -> ";
    private final int encodedLetterLength;
    private final Map<String, String> encodedToOriginal;
    private final Map<Integer, String> originalToEncoded;

    private AlphabetConverter(Map<Integer, String> map, Map<String, String> map2, int i) {
        this.originalToEncoded = map;
        this.encodedToOriginal = map2;
        this.encodedLetterLength = i;
    }

    private void addSingleEncoding(int i, String str, Collection<Integer> collection, Iterator<Integer> it, Map<Integer, String> map) {
        if (i > 0) {
            for (Integer num : collection) {
                int intValue = num.intValue();
                if (!it.hasNext()) {
                    return;
                }
                if (i != this.encodedLetterLength || !map.containsKey(Integer.valueOf(intValue))) {
                    addSingleEncoding(i - 1, str + codePointToString(intValue), collection, it, map);
                }
            }
            return;
        }
        Integer next = it.next();
        while (true) {
            Integer num2 = next;
            if (map.containsKey(num2)) {
                String codePointToString = codePointToString(num2.intValue());
                this.originalToEncoded.put(num2, codePointToString);
                this.encodedToOriginal.put(codePointToString, codePointToString);
                if (!it.hasNext()) {
                    return;
                }
                next = it.next();
            } else {
                String codePointToString2 = codePointToString(num2.intValue());
                this.originalToEncoded.put(num2, str);
                this.encodedToOriginal.put(str, codePointToString2);
                return;
            }
        }
    }

    private static String codePointToString(int i) {
        if (Character.charCount(i) == 1) {
            return String.valueOf((char) i);
        }
        return new String(Character.toChars(i));
    }

    private static Integer[] convertCharsToIntegers(Character[] chArr) {
        if (chArr == null || chArr.length == 0) {
            return new Integer[0];
        }
        Integer[] numArr = new Integer[chArr.length];
        for (int i = 0; i < chArr.length; i++) {
            numArr[i] = Integer.valueOf(chArr[i].charValue());
        }
        return numArr;
    }

    public static AlphabetConverter createConverter(Integer[] numArr, Integer[] numArr2, Integer[] numArr3) {
        Integer num;
        LinkedHashSet<Integer> linkedHashSet = new LinkedHashSet(Arrays.asList(numArr));
        LinkedHashSet linkedHashSet2 = new LinkedHashSet(Arrays.asList(numArr2));
        LinkedHashSet<Integer> linkedHashSet3 = new LinkedHashSet(Arrays.asList(numArr3));
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        LinkedHashMap linkedHashMap2 = new LinkedHashMap();
        HashMap hashMap = new HashMap();
        for (Integer num2 : linkedHashSet3) {
            int intValue = num2.intValue();
            if (linkedHashSet.contains(Integer.valueOf(intValue))) {
                if (linkedHashSet2.contains(Integer.valueOf(intValue))) {
                    hashMap.put(Integer.valueOf(intValue), codePointToString(intValue));
                } else {
                    throw new IllegalArgumentException("Can not use 'do not encode' list because encoding alphabet does not contain '" + codePointToString(intValue) + "'");
                }
            } else {
                throw new IllegalArgumentException("Can not use 'do not encode' list because original alphabet does not contain '" + codePointToString(intValue) + "'");
            }
        }
        if (linkedHashSet2.size() >= linkedHashSet.size()) {
            Iterator it = linkedHashSet2.iterator();
            for (Integer num3 : linkedHashSet) {
                int intValue2 = num3.intValue();
                String codePointToString = codePointToString(intValue2);
                if (hashMap.containsKey(Integer.valueOf(intValue2))) {
                    linkedHashMap.put(Integer.valueOf(intValue2), codePointToString);
                    linkedHashMap2.put(codePointToString, codePointToString);
                } else {
                    Object next = it.next();
                    while (true) {
                        num = (Integer) next;
                        if (!linkedHashSet3.contains(num)) {
                            break;
                        }
                        next = it.next();
                    }
                    String codePointToString2 = codePointToString(num.intValue());
                    linkedHashMap.put(Integer.valueOf(intValue2), codePointToString2);
                    linkedHashMap2.put(codePointToString2, codePointToString);
                }
            }
            return new AlphabetConverter(linkedHashMap, linkedHashMap2, 1);
        } else if (linkedHashSet2.size() - linkedHashSet3.size() >= 2) {
            int size = (linkedHashSet.size() - linkedHashSet3.size()) / (linkedHashSet2.size() - linkedHashSet3.size());
            int i = 1;
            while (size / linkedHashSet2.size() >= 1) {
                size /= linkedHashSet2.size();
                i++;
            }
            int i2 = i + 1;
            AlphabetConverter alphabetConverter = new AlphabetConverter(linkedHashMap, linkedHashMap2, i2);
            alphabetConverter.addSingleEncoding(i2, "", linkedHashSet2, linkedHashSet.iterator(), hashMap);
            return alphabetConverter;
        } else {
            throw new IllegalArgumentException("Must have at least two encoding characters (excluding those in the 'do not encode' list), but has " + (linkedHashSet2.size() - linkedHashSet3.size()));
        }
    }

    public static AlphabetConverter createConverterFromChars(Character[] chArr, Character[] chArr2, Character[] chArr3) {
        return createConverter(convertCharsToIntegers(chArr), convertCharsToIntegers(chArr2), convertCharsToIntegers(chArr3));
    }

    public static AlphabetConverter createConverterFromMap(Map<Integer, String> map) {
        Map unmodifiableMap = Collections.unmodifiableMap(map);
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        int i = 1;
        for (Map.Entry entry : unmodifiableMap.entrySet()) {
            linkedHashMap.put(entry.getValue(), codePointToString(((Integer) entry.getKey()).intValue()));
            if (((String) entry.getValue()).length() > i) {
                i = ((String) entry.getValue()).length();
            }
        }
        return new AlphabetConverter(unmodifiableMap, linkedHashMap, i);
    }

    public String decode(String str) throws UnsupportedEncodingException {
        if (str == null) {
            return null;
        }
        StringBuilder sb = new StringBuilder();
        int i = 0;
        while (i < str.length()) {
            Integer valueOf = Integer.valueOf(str.codePointAt(i));
            String codePointToString = codePointToString(valueOf.intValue());
            if (codePointToString.equals(this.originalToEncoded.get(valueOf))) {
                sb.append(codePointToString);
                i++;
            } else if (this.encodedLetterLength + i <= str.length()) {
                String substring = str.substring(i, this.encodedLetterLength + i);
                String str2 = this.encodedToOriginal.get(substring);
                if (str2 != null) {
                    sb.append(str2);
                    i += this.encodedLetterLength;
                } else {
                    throw new UnsupportedEncodingException("Unexpected string without decoding (" + substring + ") in " + str);
                }
            } else {
                throw new UnsupportedEncodingException("Unexpected end of string while decoding " + str);
            }
        }
        return sb.toString();
    }

    public String encode(String str) throws UnsupportedEncodingException {
        if (str == null) {
            return null;
        }
        StringBuilder sb = new StringBuilder();
        int i = 0;
        while (i < str.length()) {
            int codePointAt = str.codePointAt(i);
            String str2 = this.originalToEncoded.get(Integer.valueOf(codePointAt));
            if (str2 != null) {
                sb.append(str2);
                i += Character.charCount(codePointAt);
            } else {
                throw new UnsupportedEncodingException("Couldn't find encoding for '" + codePointToString(codePointAt) + "' in " + str);
            }
        }
        return sb.toString();
    }

    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (obj == this) {
            return true;
        }
        if (obj instanceof AlphabetConverter) {
            AlphabetConverter alphabetConverter = (AlphabetConverter) obj;
            return this.originalToEncoded.equals(alphabetConverter.originalToEncoded) && this.encodedToOriginal.equals(alphabetConverter.encodedToOriginal) && this.encodedLetterLength == alphabetConverter.encodedLetterLength;
        }
        return false;
    }

    public int getEncodedCharLength() {
        return this.encodedLetterLength;
    }

    public Map<Integer, String> getOriginalToEncoded() {
        return Collections.unmodifiableMap(this.originalToEncoded);
    }

    public int hashCode() {
        return Objects.hash(this.originalToEncoded, this.encodedToOriginal, Integer.valueOf(this.encodedLetterLength));
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        for (Map.Entry<Integer, String> entry : this.originalToEncoded.entrySet()) {
            sb.append(codePointToString(entry.getKey().intValue()));
            sb.append(ARROW);
            sb.append(entry.getValue());
            sb.append(System.lineSeparator());
        }
        return sb.toString();
    }
}
