package com.ut.mini.behavior.expression;

import com.ut.mini.UTEvent;
import com.ut.mini.behavior.data.Data;
import com.ut.mini.behavior.data.DataKey;
import com.ut.mini.behavior.data.LogicalType;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/* compiled from: Taobao */
/* loaded from: classes11.dex */
public class ExpressionEvaluator {
    private Map<String, BinaryOperator> mOperatorMap;

    /* compiled from: Taobao */
    /* loaded from: classes11.dex */
    private static class SingletonHolder {
        private static ExpressionEvaluator instance = new ExpressionEvaluator();

        private SingletonHolder() {
        }
    }

    private Map<String, BinaryOperator> buildOperator() {
        HashMap hashMap = new HashMap();
        EqualsOperator equalsOperator = new EqualsOperator();
        hashMap.put(equalsOperator.getOperatorSymbol(), equalsOperator);
        NotEqualsOperator notEqualsOperator = new NotEqualsOperator();
        hashMap.put(notEqualsOperator.getOperatorSymbol(), notEqualsOperator);
        GreaterThanOperator greaterThanOperator = new GreaterThanOperator();
        hashMap.put(greaterThanOperator.getOperatorSymbol(), greaterThanOperator);
        GreaterThanOrEqualsOperator greaterThanOrEqualsOperator = new GreaterThanOrEqualsOperator();
        hashMap.put(greaterThanOrEqualsOperator.getOperatorSymbol(), greaterThanOrEqualsOperator);
        LessThanOperator lessThanOperator = new LessThanOperator();
        hashMap.put(lessThanOperator.getOperatorSymbol(), lessThanOperator);
        LessThanOrEqualsOperator lessThanOrEqualsOperator = new LessThanOrEqualsOperator();
        hashMap.put(lessThanOrEqualsOperator.getOperatorSymbol(), lessThanOrEqualsOperator);
        NumberEqualsOperator numberEqualsOperator = new NumberEqualsOperator();
        hashMap.put(numberEqualsOperator.getOperatorSymbol(), numberEqualsOperator);
        InOperator inOperator = new InOperator();
        hashMap.put(inOperator.getOperatorSymbol(), inOperator);
        NinOperator ninOperator = new NinOperator();
        hashMap.put(ninOperator.getOperatorSymbol(), ninOperator);
        EkOperator ekOperator = new EkOperator();
        hashMap.put(ekOperator.getOperatorSymbol(), ekOperator);
        NekOperator nekOperator = new NekOperator();
        hashMap.put(nekOperator.getOperatorSymbol(), nekOperator);
        return hashMap;
    }

    private boolean evaluateDataSimple(Data data, Map<String, String> map) {
        BinaryOperator binaryOperator;
        if (data == null || map == null || (binaryOperator = this.mOperatorMap.get(data.operator)) == null) {
            return false;
        }
        return binaryOperator.apply(map.get(DataKey.getInstance().getDataKey(data.key)), data.value);
    }

    public static ExpressionEvaluator getInstance() {
        return SingletonHolder.instance;
    }

    public boolean evaluateData(Data data, Map<String, String> map) {
        if (data == null || map == null) {
            return false;
        }
        List<Data> list = data.dataList;
        if (list != null) {
            String str = data.operator;
            if (str == null) {
                str = LogicalType.AND.getValue();
            }
            if (str.equalsIgnoreCase(LogicalType.AND.getValue())) {
                for (Data data2 : list) {
                    if (!evaluateData(data2, map)) {
                        return false;
                    }
                }
                return true;
            }
            if (str.equalsIgnoreCase(LogicalType.OR.getValue())) {
                for (Data data3 : list) {
                    if (evaluateData(data3, map)) {
                        return true;
                    }
                }
            }
            return false;
        }
        return evaluateDataSimple(data, map);
    }

    private ExpressionEvaluator() {
        this.mOperatorMap = buildOperator();
    }

    private boolean evaluateDataSimple(Data data, UTEvent uTEvent) {
        BinaryOperator binaryOperator;
        if (data == null || uTEvent == null || (binaryOperator = this.mOperatorMap.get(data.operator)) == null) {
            return false;
        }
        return binaryOperator.apply(uTEvent.get(DataKey.getInstance().getDataKey(data.key)), data.value);
    }

    public boolean evaluateData(Data data, UTEvent uTEvent) {
        if (data == null || uTEvent == null) {
            return false;
        }
        List<Data> list = data.dataList;
        if (list != null) {
            String str = data.operator;
            if (str == null) {
                str = LogicalType.AND.getValue();
            }
            if (str.equalsIgnoreCase(LogicalType.AND.getValue())) {
                for (Data data2 : list) {
                    if (!evaluateData(data2, uTEvent)) {
                        return false;
                    }
                }
                return true;
            }
            if (str.equalsIgnoreCase(LogicalType.OR.getValue())) {
                for (Data data3 : list) {
                    if (evaluateData(data3, uTEvent)) {
                        return true;
                    }
                }
            }
            return false;
        }
        return evaluateDataSimple(data, uTEvent);
    }
}
