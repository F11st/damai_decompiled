package com.taobao.android.dinamicx;

import androidx.annotation.NonNull;
import com.taobao.android.dinamicx.widget.DXWidgetNode;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

/* compiled from: Taobao */
/* loaded from: classes11.dex */
public class DXRenderPipelineBase extends b {
    public static final int DXPIPELINE_STAGE_DIFF = 6;
    public static final int DXPIPELINE_STAGE_END = 8;
    public static final int DXPIPELINE_STAGE_FLATTEN = 5;
    public static final int DXPIPELINE_STAGE_ID_LE = 0;
    public static final int DXPIPELINE_STAGE_LAYOUT = 4;
    public static final int DXPIPELINE_STAGE_LOAD = 1;
    public static final int DXPIPELINE_STAGE_MEASURE = 3;
    public static final int DXPIPELINE_STAGE_PARSE = 2;
    public static final int DXPIPELINE_STAGE_RENDER = 7;
    protected String d;
    protected DXRenderPipelineFlow e;

    /* compiled from: Taobao */
    @Retention(RetentionPolicy.SOURCE)
    /* loaded from: classes12.dex */
    public @interface DXPipelineStage {
    }

    public DXRenderPipelineBase(@NonNull d dVar) {
        super(dVar);
    }

    public int c(DXWidgetNode dXWidgetNode, int i) {
        if (dXWidgetNode == null) {
            return 1;
        }
        if (dXWidgetNode.getStatInPrivateFlags(1024) || dXWidgetNode.getStatInPrivateFlags(1)) {
            return 2;
        }
        if (dXWidgetNode.getStatInPrivateFlags(4) || dXWidgetNode.getStatInPrivateFlags(16384)) {
            return 3;
        }
        if (dXWidgetNode.getStatInPrivateFlags(16)) {
            return 4;
        }
        if (dXWidgetNode.getStatInPrivateFlags(32)) {
            return 5;
        }
        return i;
    }

    public void d(DXRenderPipelineFlow dXRenderPipelineFlow) {
        this.e = dXRenderPipelineFlow;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public DXRenderPipelineBase(@NonNull d dVar, int i, String str) {
        super(dVar);
        this.d = str;
    }
}
