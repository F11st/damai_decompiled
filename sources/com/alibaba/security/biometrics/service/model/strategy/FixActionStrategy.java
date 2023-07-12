package com.alibaba.security.biometrics.service.model.strategy;

import com.alibaba.security.biometrics.service.model.detector.ABDetectType;
import java.util.LinkedList;
import java.util.List;

/* compiled from: Taobao */
/* loaded from: classes8.dex */
public class FixActionStrategy implements ActionStrategy {
    List<ABDetectType> detectTypeList;

    public FixActionStrategy(List<ABDetectType> list) {
        LinkedList linkedList = new LinkedList();
        this.detectTypeList = linkedList;
        linkedList.addAll(list);
    }

    public List<ABDetectType> getDetectTypeList() {
        return this.detectTypeList;
    }

    @Override // com.alibaba.security.biometrics.service.model.strategy.ActionStrategy
    public List<ABDetectType> getDetectTypes(int i) {
        if (i >= this.detectTypeList.size()) {
            return new LinkedList(this.detectTypeList);
        }
        LinkedList linkedList = new LinkedList();
        for (int i2 = 0; i2 < i; i2++) {
            linkedList.add(getDetectTypeList().get(i2));
        }
        return linkedList;
    }

    public void setDetectTypeList(List<ABDetectType> list) {
        this.detectTypeList = list;
    }
}
