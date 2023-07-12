package com.taobao.android.dinamic.expressionv2;

import com.taobao.android.dinamic.expressionv2.DinamicASTNode;
import com.taobao.android.dinamic.log.DinamicLog;

/* compiled from: Taobao */
/* renamed from: com.taobao.android.dinamic.expressionv2.b */
/* loaded from: classes11.dex */
public class C6332b extends DinamicASTNode {
    public C6332b() {
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
