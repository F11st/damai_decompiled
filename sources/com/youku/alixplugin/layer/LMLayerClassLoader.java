package com.youku.alixplugin.layer;

import android.content.Context;
import android.text.TextUtils;
import android.util.Log;
import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.List;

/* compiled from: Taobao */
/* loaded from: classes7.dex */
public class LMLayerClassLoader implements ILMLayerClassLoader<ILMLayer<?>> {
    private Context ctx;
    private List<LMLayerInfo> layerInfos;

    public LMLayerClassLoader(Context context, List<LMLayerInfo> list) {
        this.layerInfos = new ArrayList();
        this.ctx = context;
        if (list != null) {
            this.layerInfos = list;
        }
    }

    @Override // com.youku.alixplugin.layer.ILMLayerClassLoader
    public List<LMLayerInfo> getLayerInfos() {
        return this.layerInfos;
    }

    @Override // com.youku.alixplugin.layer.ILMLayerClassLoader
    public List<LMLayerInfo> getLayers() throws LMLayerDataSourceException {
        return this.layerInfos;
    }

    @Override // com.youku.alixplugin.layer.ILMLayerClassLoader
    public LMLayerInfo getMapedLayerInfo(String str) throws LMLayerDataSourceException {
        List<LMLayerInfo> list = this.layerInfos;
        if (list == null || list.size() <= 0) {
            return null;
        }
        for (LMLayerInfo lMLayerInfo : this.layerInfos) {
            if (str.equals(lMLayerInfo.getPluginId())) {
                return lMLayerInfo;
            }
        }
        return null;
    }

    @Override // com.youku.alixplugin.layer.ILMLayerClassLoader
    public void release() {
        this.layerInfos.clear();
    }

    @Override // com.youku.alixplugin.layer.ILMLayerClassLoader
    public void release(int i) {
        this.layerInfos.remove(i);
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // com.youku.alixplugin.layer.ILMLayerClassLoader
    public synchronized ILMLayer<?> getMapedLayer(String str) throws LMLayerDataSourceException {
        LMLayerInfo mapedLayerInfo = getMapedLayerInfo(str);
        if (mapedLayerInfo == null) {
            return null;
        }
        String viewClass = mapedLayerInfo.getViewClass();
        if (!TextUtils.isEmpty(viewClass)) {
            try {
                try {
                    try {
                        Object newInstance = Class.forName(viewClass).getDeclaredConstructor(Context.class).newInstance(this.ctx);
                        if (newInstance instanceof ILMLayer) {
                            return (ILMLayer) newInstance;
                        }
                        Log.e("", "load plugin error!");
                        return null;
                    } catch (IllegalAccessException e) {
                        e.printStackTrace();
                        return null;
                    } catch (IllegalArgumentException e2) {
                        e2.printStackTrace();
                        return null;
                    }
                } catch (InstantiationException e3) {
                    e3.printStackTrace();
                    return null;
                } catch (NoSuchMethodException e4) {
                    e4.printStackTrace();
                    return null;
                }
            } catch (ClassNotFoundException e5) {
                e5.printStackTrace();
                Log.e("", String.format("插件类: %s 不存在!", viewClass));
                return null;
            } catch (InvocationTargetException e6) {
                e6.printStackTrace();
                return null;
            }
        }
        throw new IllegalArgumentException(String.format("插件: %s 未配置!", str));
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // com.youku.alixplugin.layer.ILMLayerClassLoader
    public ILMLayer<?> getMapedLayer(LMLayerInfo lMLayerInfo) {
        String viewClass = lMLayerInfo.getViewClass();
        if (!TextUtils.isEmpty(viewClass)) {
            try {
                LMUtilLog.debugLog(LMLayerClassLoader.class, "execute-init-reflect-begin-ViewClassName=" + viewClass);
                Object newInstance = Class.forName(viewClass).getDeclaredConstructor(Context.class, LMLayerInfo.class).newInstance(this.ctx, lMLayerInfo);
                if (newInstance instanceof ILMLayer) {
                    LMUtilLog.debugLog(LMLayerClassLoader.class, "execute-init-reflect-finish-ViewClassName=" + viewClass);
                    return (ILMLayer) newInstance;
                }
                Log.e("", "load plugin error!");
                LMUtilLog.debugLog(LMLayerClassLoader.class, "execute-init-reflect-load plugin error!-ViewClassName");
                return null;
            } catch (ClassNotFoundException e) {
                e.printStackTrace();
                Log.e("", String.format("插件类: %s 不存在!", viewClass));
                LMUtilLog.debugLog(LMLayerClassLoader.class, "ClassNotFoundException:" + e.getMessage());
                return null;
            } catch (IllegalAccessException e2) {
                e2.printStackTrace();
                LMUtilLog.debugLog(LMLayerClassLoader.class, "IllegalAccessException" + e2.getMessage());
                return null;
            } catch (IllegalArgumentException e3) {
                e3.printStackTrace();
                LMUtilLog.debugLog(LMLayerClassLoader.class, "IllegalArgumentException" + e3.getMessage());
                return null;
            } catch (InstantiationException e4) {
                e4.printStackTrace();
                LMUtilLog.debugLog(LMLayerClassLoader.class, "InstantiationException" + e4.getMessage());
                return null;
            } catch (NoSuchMethodException e5) {
                e5.printStackTrace();
                LMUtilLog.debugLog(LMLayerClassLoader.class, "NoSuchMethodException" + e5.getMessage());
                return null;
            } catch (InvocationTargetException e6) {
                e6.getCause().printStackTrace();
                LMUtilLog.debugLog(LMLayerClassLoader.class, "InvocationTargetException" + e6.getMessage());
                return null;
            }
        }
        throw new IllegalArgumentException(String.format("插件: %s 未配置!", lMLayerInfo.getPluginId()));
    }
}
