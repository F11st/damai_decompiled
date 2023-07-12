package com.youku.alixplugin.layer;

/* compiled from: Taobao */
/* loaded from: classes7.dex */
public class LMLayerDataSourceException extends LMLayerException {
    private static final long serialVersionUID = 1;

    public LMLayerDataSourceException(String str) {
        super(String.format("数据源初始化失败: %s !", str));
    }
}
