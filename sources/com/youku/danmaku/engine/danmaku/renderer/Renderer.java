package com.youku.danmaku.engine.danmaku.renderer;

import com.youku.danmaku.engine.danmaku.model.BaseDanmaku;
import com.youku.danmaku.engine.danmaku.model.DanmakuRenderModel;
import com.youku.danmaku.engine.danmaku.model.IDanmakus;
import com.youku.danmaku.engine.danmaku.model.IDisplayer;
import com.youku.danmaku.engine.danmaku.renderer.IRenderer;
import java.util.List;

/* compiled from: Taobao */
/* loaded from: classes2.dex */
public abstract class Renderer implements IRenderer {
    @Override // com.youku.danmaku.engine.danmaku.renderer.IRenderer
    public void draw(IDisplayer iDisplayer, IDanmakus iDanmakus, long j, IRenderer.RenderingState renderingState) {
    }

    @Override // com.youku.danmaku.engine.danmaku.renderer.IRenderer
    public void draw(IDisplayer iDisplayer, IRenderer.RenderingState renderingState, DanmakuRenderModel danmakuRenderModel) {
    }

    @Override // com.youku.danmaku.engine.danmaku.renderer.IRenderer
    public List<BaseDanmaku> getSpecialDanmaku() {
        return null;
    }
}
