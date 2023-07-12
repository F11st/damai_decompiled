package com.taobao.android.job.core;

import com.taobao.android.job.core.graph.Node;
import com.taobao.android.job.core.graph.TraverserAction;
import com.taobao.android.job.core.task.ExecutionSummary;
import com.youku.live.livesdk.wkit.component.Constants;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;
import org.apache.commons.lang3.StringUtils;

/* compiled from: Taobao */
/* loaded from: classes11.dex */
class DAGStageTraverserAction<T, R> implements TraverserAction<T, R> {
    private final StringBuilder builder;
    private final Map<T, ExecutionSummary> executions;

    /* JADX INFO: Access modifiers changed from: package-private */
    public DAGStageTraverserAction(StringBuilder sb, Map<T, ExecutionSummary> map) {
        this.builder = sb;
        this.executions = map;
    }

    private static <T, R> Set<Node<T, R>> getExecutedNodes(Set<Node<T, R>> set) {
        HashSet hashSet = new HashSet(set.size());
        for (Node<T, R> node : set) {
            if (!node.isSkipped()) {
                hashSet.add(node);
            }
        }
        return hashSet;
    }

    @Override // com.taobao.android.job.core.graph.TraverserAction
    public void onNewLevel(int i) {
        this.builder.append(StringUtils.LF);
    }

    @Override // com.taobao.android.job.core.graph.TraverserAction
    public void onNewPath(int i) {
        StringBuilder sb = this.builder;
        sb.append(StringUtils.LF);
        sb.append("Path #");
        sb.append(i);
    }

    @Override // com.taobao.android.job.core.graph.TraverserAction
    public void onNode(Node<T, R> node) {
        if (node.isSkipped()) {
            return;
        }
        Set executedNodes = getExecutedNodes(node.getInComingNodes());
        StringBuilder sb = this.builder;
        sb.append(node);
        sb.append(Constants.TYPE_LIVE_ROOM_BG_COLOR_PREFFIX);
        sb.append(this.executions.get(node.getValue()));
        sb.append(executedNodes);
        sb.append("|");
    }
}
