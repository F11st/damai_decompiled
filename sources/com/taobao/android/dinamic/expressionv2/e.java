package com.taobao.android.dinamic.expressionv2;

import com.taobao.android.dinamic.expressionv2.DinamicASTNode;
import com.taobao.android.dinamic.log.DinamicLog;
import java.util.ArrayList;
import java.util.List;

/* compiled from: Taobao */
/* loaded from: classes11.dex */
public class e extends DinamicASTNode {
    public e() {
        this.a = DinamicASTNode.DinamicASTNodeType.DinamicASTNodeTypeSerialBlock;
        this.d = "branch";
    }

    @Override // com.taobao.android.dinamic.expressionv2.DinamicASTNode
    public Object c() {
        DinamicLog.h("DXSerialBlockNode:" + this.d);
        List<DinamicASTNode> list = this.b;
        if (list != null) {
            int size = list.size();
            ArrayList arrayList = new ArrayList();
            for (int i = 0; i < size; i++) {
                Object c = this.b.get(i).c();
                if (c != null) {
                    arrayList.add(c.toString());
                }
            }
            return arrayList;
        }
        return null;
    }
}
