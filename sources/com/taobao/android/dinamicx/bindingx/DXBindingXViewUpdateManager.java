package com.taobao.android.dinamicx.bindingx;

import android.graphics.drawable.ColorDrawable;
import android.os.Looper;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.annotation.NonNull;
import com.alibaba.android.bindingx.core.PlatformManager;
import com.alibaba.android.bindingx.plugin.android.INativeViewUpdater;
import com.alibaba.android.bindingx.plugin.android.NativeViewUpdateService;
import com.taobao.android.dinamicx.DinamicXEngine;
import com.taobao.android.dinamicx.widget.DXWidgetNode;
import java.util.Map;
import org.apache.commons.lang3.CharUtils;
import tb.nz;
import tb.ry;
import tb.y00;

/* compiled from: Taobao */
/* loaded from: classes11.dex */
public class DXBindingXViewUpdateManager implements INativeViewUpdater {
    private Object a(String str, View view) {
        char c = 65535;
        try {
            switch (str.hashCode()) {
                case -1971608035:
                    if (str.equals("transform.rotate")) {
                        c = '\t';
                        break;
                    }
                    break;
                case -1954617072:
                    if (str.equals("transform.scaleX")) {
                        c = 6;
                        break;
                    }
                    break;
                case -1954617071:
                    if (str.equals("transform.scaleY")) {
                        c = 7;
                        break;
                    }
                    break;
                case -1744318324:
                    if (str.equals("transform.translateX")) {
                        c = 3;
                        break;
                    }
                    break;
                case -1744318323:
                    if (str.equals("transform.translateY")) {
                        c = 4;
                        break;
                    }
                    break;
                case -1725620152:
                    if (str.equals("transform.scale")) {
                        c = '\b';
                        break;
                    }
                    break;
                case -1267206133:
                    if (str.equals("opacity")) {
                        c = 2;
                        break;
                    }
                    break;
                case -1221029593:
                    if (str.equals("height")) {
                        c = 1;
                        break;
                    }
                    break;
                case -990306853:
                    if (str.equals("transform.rotateX")) {
                        c = 11;
                        break;
                    }
                    break;
                case -990306852:
                    if (str.equals("transform.rotateY")) {
                        c = '\f';
                        break;
                    }
                    break;
                case -990306851:
                    if (str.equals("transform.rotateZ")) {
                        c = '\n';
                        break;
                    }
                    break;
                case -194815668:
                    if (str.equals("transform.translate")) {
                        c = 5;
                        break;
                    }
                    break;
                case 94842723:
                    if (str.equals("color")) {
                        c = 14;
                        break;
                    }
                    break;
                case 113126854:
                    if (str.equals("width")) {
                        c = 0;
                        break;
                    }
                    break;
                case 605322756:
                    if (str.equals("background-color")) {
                        c = CharUtils.CR;
                        break;
                    }
                    break;
            }
            switch (c) {
                case 0:
                    return "width:" + view.getLayoutParams().width;
                case 1:
                    return "height: " + view.getLayoutParams().height;
                case 2:
                    return "opacity: " + view.getAlpha();
                case 3:
                    return "translateX :" + view.getTranslationX();
                case 4:
                    return "translateY: " + view.getTranslationY();
                case 5:
                    return "translateX :" + view.getTranslationX() + " translateY: " + view.getTranslationY();
                case 6:
                    return "scaleX: " + view.getScaleX();
                case 7:
                    return "scaleY: " + view.getScaleY();
                case '\b':
                    return "scaleX: " + view.getScaleX() + "scaleY: " + view.getScaleY();
                case '\t':
                    return "rotate :" + view.getRotation();
                case '\n':
                    return "rotateZ :" + view.getRotation();
                case 11:
                    return "rotateX :" + view.getRotationX();
                case '\f':
                    return "rotateY :" + view.getRotationY();
                case '\r':
                    if (view.getBackground() instanceof ColorDrawable) {
                        return "background-color:  " + ((ColorDrawable) view.getBackground()).getColor();
                    }
                    return "targetView.getBackground() 不是ColorDrawable";
                case 14:
                    if (view instanceof TextView) {
                        int currentTextColor = ((TextView) view).getCurrentTextColor();
                        return "textColor:  " + currentTextColor;
                    }
                    return "targetView 不是TextView";
            }
        } catch (Exception e) {
            ry.b(e);
        }
        return str + " 当前属性不支持";
    }

    @Override // com.alibaba.android.bindingx.plugin.android.INativeViewUpdater
    public void update(@NonNull final View view, @NonNull String str, @NonNull final Object obj, @NonNull PlatformManager.IDeviceResolutionTranslator iDeviceResolutionTranslator, @NonNull Map<String, Object> map) {
        if (DinamicXEngine.x()) {
            nz.n("开始更新" + str + " 属性，需要更新到的值为 " + obj + " 更新前的值为 " + a(str, view) + " 其对应的view为 " + view);
        }
        if (!TextUtils.isEmpty(str) && view != null) {
            str.hashCode();
            if (str.equals("height")) {
                Runnable runnable = new Runnable() { // from class: com.taobao.android.dinamicx.bindingx.DXBindingXViewUpdateManager.2
                    @Override // java.lang.Runnable
                    public void run() {
                        try {
                            DXWidgetNode dXWidgetNode = (DXWidgetNode) view.getTag(DXWidgetNode.TAG_WIDGET_NODE);
                            if (dXWidgetNode == null) {
                                return;
                            }
                            int intValue = Double.valueOf("" + obj).intValue();
                            dXWidgetNode.setMeasuredDimension(dXWidgetNode.getMeasuredWidth(), intValue);
                            ViewGroup.LayoutParams layoutParams = view.getLayoutParams();
                            if (layoutParams == null) {
                                return;
                            }
                            layoutParams.height = intValue;
                            view.setLayoutParams(layoutParams);
                        } catch (Throwable th) {
                            ry.b(th);
                        }
                    }
                };
                if (Looper.myLooper() == Looper.getMainLooper()) {
                    runnable.run();
                    return;
                } else {
                    y00.m(runnable);
                    return;
                }
            } else if (str.equals("width")) {
                Runnable runnable2 = new Runnable() { // from class: com.taobao.android.dinamicx.bindingx.DXBindingXViewUpdateManager.1
                    @Override // java.lang.Runnable
                    public void run() {
                        try {
                            DXWidgetNode dXWidgetNode = (DXWidgetNode) view.getTag(DXWidgetNode.TAG_WIDGET_NODE);
                            if (dXWidgetNode == null) {
                                return;
                            }
                            int intValue = Double.valueOf("" + obj).intValue();
                            dXWidgetNode.setMeasuredDimension(intValue, dXWidgetNode.getMeasuredHeight());
                            ViewGroup.LayoutParams layoutParams = view.getLayoutParams();
                            if (layoutParams == null) {
                                return;
                            }
                            layoutParams.width = intValue;
                            view.setLayoutParams(layoutParams);
                        } catch (Throwable th) {
                            ry.b(th);
                        }
                    }
                };
                if (Looper.myLooper() == Looper.getMainLooper()) {
                    runnable2.run();
                    return;
                } else {
                    y00.m(runnable2);
                    return;
                }
            }
        }
        INativeViewUpdater e = NativeViewUpdateService.e(str);
        if (e != null) {
            e.update(view, str, obj, iDeviceResolutionTranslator, map);
        }
        if (DinamicXEngine.x()) {
            nz.n("更新完成" + str + " 属性，需要更新到的值为 " + obj + " 更新后的值为 " + a(str, view) + " 其对应的view为 " + view);
        }
    }
}
