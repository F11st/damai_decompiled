package org.apache.commons.codec.language;

import com.youku.upsplayer.util.YKUpsConvert;
import java.util.Locale;
import org.apache.commons.codec.EncoderException;
import org.apache.commons.codec.StringEncoder;
import tb.qb1;
import tb.r10;

/* compiled from: Taobao */
/* loaded from: classes2.dex */
public class ColognePhonetic implements StringEncoder {
    private static final char[] AEIJOUY = {YKUpsConvert.CHAR_A, qb1.LEVEL_E, qb1.LEVEL_I, 'J', 'O', 'U', 'Y'};
    private static final char[] SCZ = {'S', 'C', 'Z'};
    private static final char[] WFPV = {qb1.LEVEL_W, YKUpsConvert.CHAR_F, 'P', qb1.LEVEL_V};
    private static final char[] GKQ = {'G', 'K', 'Q'};
    private static final char[] CKQ = {'C', 'K', 'Q'};
    private static final char[] AHKLOQRUX = {YKUpsConvert.CHAR_A, 'H', 'K', qb1.LEVEL_L, 'O', 'Q', 'R', 'U', 'X'};
    private static final char[] SZ = {'S', 'Z'};
    private static final char[] AHOUKQX = {YKUpsConvert.CHAR_A, 'H', 'O', 'U', 'K', 'Q', 'X'};
    private static final char[] TDX = {'T', qb1.LEVEL_D, 'X'};
    private static final char[][] PREPROCESS_MAP = {new char[]{196, YKUpsConvert.CHAR_A}, new char[]{220, 'U'}, new char[]{214, 'O'}, new char[]{223, 'S'}};

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: Taobao */
    /* loaded from: classes2.dex */
    public class CologneInputBuffer extends CologneBuffer {
        public CologneInputBuffer(char[] cArr) {
            super(cArr);
        }

        public void addLeft(char c) {
            this.length++;
            this.data[getNextPos()] = c;
        }

        @Override // org.apache.commons.codec.language.ColognePhonetic.CologneBuffer
        protected char[] copyData(int i, int i2) {
            char[] cArr = new char[i2];
            char[] cArr2 = this.data;
            System.arraycopy(cArr2, (cArr2.length - this.length) + i, cArr, 0, i2);
            return cArr;
        }

        public char getNextChar() {
            return this.data[getNextPos()];
        }

        protected int getNextPos() {
            return this.data.length - this.length;
        }

        public char removeNext() {
            this.length--;
            return getNextChar();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: Taobao */
    /* loaded from: classes2.dex */
    public class CologneOutputBuffer extends CologneBuffer {
        public CologneOutputBuffer(int i) {
            super(i);
        }

        public void addRight(char c) {
            char[] cArr = this.data;
            int i = this.length;
            cArr[i] = c;
            this.length = i + 1;
        }

        @Override // org.apache.commons.codec.language.ColognePhonetic.CologneBuffer
        protected char[] copyData(int i, int i2) {
            char[] cArr = new char[i2];
            System.arraycopy(this.data, i, cArr, 0, i2);
            return cArr;
        }
    }

    private static boolean arrayContains(char[] cArr, char c) {
        for (char c2 : cArr) {
            if (c2 == c) {
                return true;
            }
        }
        return false;
    }

    private String preprocess(String str) {
        char[] charArray = str.toUpperCase(Locale.GERMAN).toCharArray();
        for (int i = 0; i < charArray.length; i++) {
            if (charArray[i] > 'Z') {
                char[][] cArr = PREPROCESS_MAP;
                int length = cArr.length;
                int i2 = 0;
                while (true) {
                    if (i2 < length) {
                        char[] cArr2 = cArr[i2];
                        if (charArray[i] == cArr2[0]) {
                            charArray[i] = cArr2[1];
                            break;
                        }
                        i2++;
                    }
                }
            }
        }
        return new String(charArray);
    }

    public String colognePhonetic(String str) {
        if (str == null) {
            return null;
        }
        String preprocess = preprocess(str);
        CologneOutputBuffer cologneOutputBuffer = new CologneOutputBuffer(preprocess.length() * 2);
        CologneInputBuffer cologneInputBuffer = new CologneInputBuffer(preprocess.toCharArray());
        int length = cologneInputBuffer.length();
        char c = r10.DIR;
        char c2 = '-';
        while (length > 0) {
            char removeNext = cologneInputBuffer.removeNext();
            int length2 = cologneInputBuffer.length();
            char nextChar = length2 > 0 ? cologneInputBuffer.getNextChar() : '-';
            char c3 = '4';
            if (arrayContains(AEIJOUY, removeNext)) {
                c3 = YKUpsConvert.CHAR_ZERO;
            } else if (removeNext == 'H' || removeNext < 'A' || removeNext > 'Z') {
                if (c == '/') {
                    length = length2;
                } else {
                    c3 = '-';
                }
            } else if (removeNext == 'B' || (removeNext == 'P' && nextChar != 'H')) {
                c3 = '1';
            } else if ((removeNext == 'D' || removeNext == 'T') && !arrayContains(SCZ, nextChar)) {
                c3 = '2';
            } else if (arrayContains(WFPV, removeNext)) {
                c3 = '3';
            } else if (!arrayContains(GKQ, removeNext)) {
                if (removeNext != 'X' || arrayContains(CKQ, c2)) {
                    if (removeNext != 'S' && removeNext != 'Z') {
                        if (removeNext == 'C') {
                            if (c == '/') {
                            }
                        } else if (!arrayContains(TDX, removeNext)) {
                            c3 = removeNext == 'R' ? '7' : removeNext == 'L' ? '5' : (removeNext == 'M' || removeNext == 'N') ? '6' : removeNext;
                        }
                    }
                    c3 = '8';
                } else {
                    cologneInputBuffer.addLeft('S');
                    length2++;
                }
            }
            if (c3 != '-' && ((c != c3 && (c3 != '0' || c == '/')) || c3 < '0' || c3 > '8')) {
                cologneOutputBuffer.addRight(c3);
            }
            c2 = removeNext;
            length = length2;
            c = c3;
        }
        return cologneOutputBuffer.toString();
    }

    @Override // org.apache.commons.codec.Encoder
    public Object encode(Object obj) throws EncoderException {
        if (obj instanceof String) {
            return encode((String) obj);
        }
        throw new EncoderException("This method's parameter was expected to be of the type " + String.class.getName() + ". But actually it was of the type " + obj.getClass().getName() + ".");
    }

    public boolean isEncodeEqual(String str, String str2) {
        return colognePhonetic(str).equals(colognePhonetic(str2));
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: Taobao */
    /* loaded from: classes2.dex */
    public abstract class CologneBuffer {
        protected final char[] data;
        protected int length;

        public CologneBuffer(char[] cArr) {
            this.length = 0;
            this.data = cArr;
            this.length = cArr.length;
        }

        protected abstract char[] copyData(int i, int i2);

        public int length() {
            return this.length;
        }

        public String toString() {
            return new String(copyData(0, this.length));
        }

        public CologneBuffer(int i) {
            this.length = 0;
            this.data = new char[i];
            this.length = 0;
        }
    }

    @Override // org.apache.commons.codec.StringEncoder
    public String encode(String str) {
        return colognePhonetic(str);
    }
}
