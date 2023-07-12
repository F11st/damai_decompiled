package com.taobao.orange.candidate;

import android.os.RemoteException;
import android.text.TextUtils;
import com.taobao.orange.aidl.OrangeCandidateCompareStub;
import com.taobao.orange.aidl.ParcelableCandidateCompare;
import com.taobao.orange.util.OLog;
import com.taobao.orange.util.OrangeUtils;
import com.youku.alixplayer.config.FeatureManager;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import tb.jn1;

/* compiled from: Taobao */
/* loaded from: classes11.dex */
public class UnitAnalyze {
    private static final Pattern BASE_FORMAT;
    private static final String CANDIDATE_HASH_BUCKET = "did_hash";
    private static final Map<String, OPERATOR> OPERATOR_SYMBOL_MAP = new HashMap();
    private static final String TAG = "UnitAnalyze";
    public String key;
    private OPERATOR opr;
    private String val;

    /* compiled from: Taobao */
    /* renamed from: com.taobao.orange.candidate.UnitAnalyze$1  reason: invalid class name */
    /* loaded from: classes11.dex */
    static /* synthetic */ class AnonymousClass1 {
        static final /* synthetic */ int[] $SwitchMap$com$taobao$orange$candidate$UnitAnalyze$OPERATOR;

        static {
            int[] iArr = new int[OPERATOR.values().length];
            $SwitchMap$com$taobao$orange$candidate$UnitAnalyze$OPERATOR = iArr;
            try {
                iArr[OPERATOR.EQUALS.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                $SwitchMap$com$taobao$orange$candidate$UnitAnalyze$OPERATOR[OPERATOR.NOT_EQUALS.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                $SwitchMap$com$taobao$orange$candidate$UnitAnalyze$OPERATOR[OPERATOR.GREATER.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                $SwitchMap$com$taobao$orange$candidate$UnitAnalyze$OPERATOR[OPERATOR.GREATER_EQUALS.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                $SwitchMap$com$taobao$orange$candidate$UnitAnalyze$OPERATOR[OPERATOR.LESS.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                $SwitchMap$com$taobao$orange$candidate$UnitAnalyze$OPERATOR[OPERATOR.LESS_EQUALS.ordinal()] = 6;
            } catch (NoSuchFieldError unused6) {
            }
            try {
                $SwitchMap$com$taobao$orange$candidate$UnitAnalyze$OPERATOR[OPERATOR.FUZZY.ordinal()] = 7;
            } catch (NoSuchFieldError unused7) {
            }
            try {
                $SwitchMap$com$taobao$orange$candidate$UnitAnalyze$OPERATOR[OPERATOR.NOT_FUZZY.ordinal()] = 8;
            } catch (NoSuchFieldError unused8) {
            }
        }
    }

    /* compiled from: Taobao */
    /* loaded from: classes11.dex */
    enum OPERATOR {
        EQUALS("="),
        GREATER_EQUALS(jn1.GE),
        LESS_EQUALS(jn1.LE),
        GREATER(jn1.G),
        LESS(jn1.L),
        NOT_EQUALS(jn1.NOT_EQUAL2),
        FUZZY("~="),
        NOT_FUZZY("!~");
        
        private String symbol;

        OPERATOR(String str) {
            this.symbol = str;
        }

        public String getSymbol() {
            return this.symbol;
        }
    }

    static {
        OPERATOR[] values;
        ArrayList arrayList = new ArrayList();
        for (OPERATOR operator : OPERATOR.values()) {
            OPERATOR_SYMBOL_MAP.put(operator.getSymbol(), operator);
            arrayList.add(operator.getSymbol());
        }
        BASE_FORMAT = Pattern.compile(String.format("^\\s*(\\w+)\\s*(%s)\\s*(.+)\\s*$", OrangeUtils.formatOperateSymbols(arrayList)));
    }

    private UnitAnalyze(String str) {
        Matcher matcher = BASE_FORMAT.matcher(str);
        if (matcher.find()) {
            this.key = matcher.group(1);
            this.opr = OPERATOR_SYMBOL_MAP.get(matcher.group(2));
            this.val = matcher.group(3);
            if (this.key.equals("did_hash") && this.opr != OPERATOR.EQUALS) {
                throw new IllegalArgumentException(String.format("invalid hash candidate:%s", str));
            }
            return;
        }
        throw new IllegalArgumentException(String.format("fail parse candidate:%s", str));
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static UnitAnalyze complie(String str) {
        return new UnitAnalyze(str);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public boolean match(String str, ParcelableCandidateCompare parcelableCandidateCompare) throws RemoteException {
        boolean equals;
        if (TextUtils.isEmpty(str)) {
            if (OLog.isPrintLog(1)) {
                OLog.d(TAG, "match no clientVal", "key", this.key);
            }
            return false;
        } else if (parcelableCandidateCompare == null) {
            if (OLog.isPrintLog(1)) {
                OLog.d(TAG, "match no compare", "key", this.key);
            }
            return false;
        } else {
            if (OLog.isPrintLog(0)) {
                OLog.v(TAG, "match start", "key", this.key, "clientVal", str, FeatureManager.FEATURE_KEY_OPR, this.opr.getSymbol(), "serverVal", this.val, "compare", parcelableCandidateCompare instanceof OrangeCandidateCompareStub ? ((OrangeCandidateCompareStub) parcelableCandidateCompare).getName() : null);
            }
            switch (AnonymousClass1.$SwitchMap$com$taobao$orange$candidate$UnitAnalyze$OPERATOR[this.opr.ordinal()]) {
                case 1:
                    equals = parcelableCandidateCompare.equals(str, this.val);
                    break;
                case 2:
                    equals = parcelableCandidateCompare.equalsNot(str, this.val);
                    break;
                case 3:
                    equals = parcelableCandidateCompare.greater(str, this.val);
                    break;
                case 4:
                    equals = parcelableCandidateCompare.greaterEquals(str, this.val);
                    break;
                case 5:
                    equals = parcelableCandidateCompare.less(str, this.val);
                    break;
                case 6:
                    equals = parcelableCandidateCompare.lessEquals(str, this.val);
                    break;
                case 7:
                    equals = parcelableCandidateCompare.fuzzy(str, this.val);
                    break;
                case 8:
                    equals = parcelableCandidateCompare.fuzzyNot(str, this.val);
                    break;
                default:
                    equals = false;
                    break;
            }
            if (!equals && OLog.isPrintLog(1)) {
                OLog.d(TAG, "match fail", "key", this.key);
            }
            return equals;
        }
    }

    public String toString() {
        return String.format("%s%s%s", this.key, this.opr.getSymbol(), this.val);
    }
}
