package com.taobao.android.dinamic.expressionv2;

import android.util.LruCache;
import android.util.Pair;
import android.view.View;
import androidx.annotation.Nullable;
import com.taobao.android.dinamic.C6313b;
import com.taobao.android.dinamic.dinamic.DinamicEventHandler;
import com.taobao.android.dinamic.expressionv2.DinamicASTNode;
import com.taobao.android.dinamic.log.DinamicLog;
import java.util.List;
import tb.b90;
import tb.m80;
import tb.p80;
import tb.v80;
import tb.x80;

/* compiled from: Taobao */
/* renamed from: com.taobao.android.dinamic.expressionv2.g */
/* loaded from: classes11.dex */
public class C6337g implements DinamicProcessor {
    private static LruCache<String, DinamicASTNode> a = new LruCache<>(32);

    @Nullable
    private static Object a(DinamicASTNode dinamicASTNode, String str, v80 v80Var) {
        return dinamicASTNode.c();
    }

    public static DinamicASTNode[] b(View view, String str, v80 v80Var) {
        DinamicASTNode dinamicASTNode = m80.a ? a.get(str) : null;
        if (dinamicASTNode == null) {
            Pair<List, List> a2 = new b90().a(str);
            if (a2 != null) {
                C6331a c6331a = new C6331a();
                c6331a.b(v80Var);
                DinamicASTNode a3 = c6331a.a(a2);
                if (a3 != null) {
                    if (m80.a) {
                        a.put(str, a3);
                    }
                    return c(view, a3);
                }
            }
            return null;
        }
        dinamicASTNode.b(v80Var);
        return c(view, dinamicASTNode);
    }

    private static DinamicASTNode[] c(View view, DinamicASTNode dinamicASTNode) {
        int size;
        if (dinamicASTNode != null) {
            DinamicASTNode.DinamicASTNodeType dinamicASTNodeType = dinamicASTNode.a;
            if (dinamicASTNodeType == DinamicASTNode.DinamicASTNodeType.DinamicASTNodeTypeMethod) {
                try {
                    ((C6334d) dinamicASTNode).d();
                    return new DinamicASTNode[]{dinamicASTNode};
                } catch (ClassCastException unused) {
                    DinamicLog.d(C6313b.TAG, "root node class cast error!");
                    return null;
                }
            } else if (dinamicASTNodeType != DinamicASTNode.DinamicASTNodeType.DinamicASTNodeTypeSerialBlock || (size = dinamicASTNode.b.size()) <= 0) {
                return null;
            } else {
                for (int i = 0; i < size; i++) {
                    DinamicASTNode dinamicASTNode2 = dinamicASTNode.b.get(i);
                    if (dinamicASTNode2 instanceof C6334d) {
                        ((C6334d) dinamicASTNode2).d();
                    }
                }
                return (DinamicASTNode[]) dinamicASTNode.b.toArray(new DinamicASTNode[size]);
            }
        }
        return null;
    }

    public static void d(View view, String str, v80 v80Var) {
        DinamicASTNode dinamicASTNode = m80.a ? a.get(str) : null;
        if (dinamicASTNode == null) {
            Pair<List, List> a2 = new b90().a(str);
            if (a2 != null) {
                C6331a c6331a = new C6331a();
                c6331a.b(v80Var);
                DinamicASTNode a3 = c6331a.a(a2);
                if (a3 != null) {
                    if (m80.a) {
                        a.put(str, a3);
                    }
                    e(view, a3);
                    return;
                }
                return;
            }
            return;
        }
        dinamicASTNode.b(v80Var);
        e(view, dinamicASTNode);
    }

    private static void e(View view, DinamicASTNode dinamicASTNode) {
        if (dinamicASTNode != null) {
            DinamicASTNode.DinamicASTNodeType dinamicASTNodeType = dinamicASTNode.a;
            if (dinamicASTNodeType == DinamicASTNode.DinamicASTNodeType.DinamicASTNodeTypeMethod) {
                try {
                    ((C6334d) dinamicASTNode).f(view);
                } catch (ClassCastException unused) {
                    DinamicLog.d(C6313b.TAG, "root node class cast error!");
                }
            } else if (dinamicASTNodeType == DinamicASTNode.DinamicASTNodeType.DinamicASTNodeTypeSerialBlock) {
                int size = dinamicASTNode.b.size();
                for (int i = 0; i < size; i++) {
                    DinamicASTNode dinamicASTNode2 = dinamicASTNode.b.get(i);
                    if (dinamicASTNode2.a == DinamicASTNode.DinamicASTNodeType.DinamicASTNodeTypeMethod) {
                        try {
                            ((C6334d) dinamicASTNode2).f(view);
                        } catch (ClassCastException unused2) {
                            DinamicLog.d(C6313b.TAG, "child node class cast error!");
                            return;
                        }
                    }
                }
            }
        }
    }

    public static void f(View view, String str, v80 v80Var, x80 x80Var) {
        try {
            DinamicASTNode[] b = b(view, str, v80Var);
            if (b == null || b.length <= 0) {
                return;
            }
            for (int i = 0; i < b.length; i++) {
                DinamicEventHandler b2 = C6313b.b(b[i].d);
                if (b2 != null && (b[i] instanceof C6334d)) {
                    b2.prepareBindEvent(view, ((C6334d) b[i]).e(), v80Var.d());
                }
            }
        } catch (Throwable unused) {
            v80Var.e().b().a(p80.ERROR_CODE_EVENT_HANDLER_EXCEPTION, x80Var.a);
        }
    }

    public static Object g(String str, String str2, v80 v80Var) {
        DinamicASTNode dinamicASTNode = m80.a ? a.get(str) : null;
        if (dinamicASTNode == null) {
            Pair<List, List> a2 = new b90().a(str);
            if (a2 != null) {
                C6331a c6331a = new C6331a();
                c6331a.b(v80Var);
                DinamicASTNode a3 = c6331a.a(a2);
                if (a3 != null) {
                    if (m80.a) {
                        a.put(str, a3);
                    }
                    Object a4 = a(a3, str, v80Var);
                    if (a4 != null) {
                        return a4;
                    }
                } else {
                    DinamicLog.h("build AST Tree error!");
                }
            } else {
                DinamicLog.h("token error!");
            }
        } else {
            dinamicASTNode.b(v80Var);
            Object a5 = a(dinamicASTNode, str, v80Var);
            if (a5 != null && a5 != m80.NL) {
                return a5;
            }
        }
        return null;
    }
}
