package com.taobao.android.dinamic.expressionv2;

import com.taobao.android.dinamic.expressionv2.DinamicASTNode;
import com.taobao.android.dinamic.log.DinamicLog;

/* compiled from: Taobao */
/* loaded from: classes11.dex */
public class b extends DinamicASTNode {
    public b() {
        this.a = DinamicASTNode.DinamicASTNodeType.DinamicASTNodeTypeBranchBlock;
        this.d = "branch";
    }

    @Override // com.taobao.android.dinamic.expressionv2.DinamicASTNode
    public Object c() {
        DinamicLog.h("DXBranchBlockNode:" + this.d);
        int size = this.b.size();
        DinamicLog.h("children.size():" + size);
        if (size > 1) {
            for (int i = 0; i < size; i++) {
                Object c = this.b.get(i).c();
                if (c != null) {
                    return c;
                }
            }
            return null;
        }
        return null;
    }
}
