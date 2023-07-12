package com.ut.mini.behavior.expression;

import com.alibaba.analytics.utils.Logger;
import java.util.List;

/* compiled from: Taobao */
/* loaded from: classes11.dex */
class InOperator extends BinaryOperator {
    private static final String TAG = "InOperator";

    @Override // com.ut.mini.behavior.expression.BinaryOperator
    public boolean apply(Object obj, Object obj2) {
        if (obj != null && (obj instanceof String)) {
            String str = (String) obj;
            if (obj2 instanceof List) {
                try {
                    List<String> list = (List) obj2;
                    if (list != null && list.size() >= 1) {
                        for (String str2 : list) {
                            if (str2.startsWith("%") && str2.endsWith("%")) {
                                if (str.contains(str2.substring(1, str2.length() - 1))) {
                                    return true;
                                }
                            } else if (str2.startsWith("%")) {
                                if (str.endsWith(str2.substring(1))) {
                                    return true;
                                }
                            } else if (str2.endsWith("%")) {
                                if (str.startsWith(str2.substring(0, str2.length() - 1))) {
                                    return true;
                                }
                            } else if (str.equals(str2)) {
                                return true;
                            }
                        }
                    }
                    return false;
                } catch (Exception e) {
                    Logger.h(TAG, e, new Object[0]);
                    return false;
                }
            }
            return false;
        }
        return false;
    }

    @Override // com.ut.mini.behavior.expression.BinaryOperator
    public String getOperatorSymbol() {
        return "in";
    }
}
