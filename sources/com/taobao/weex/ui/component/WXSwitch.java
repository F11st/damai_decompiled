package com.taobao.weex.ui.component;

import android.content.Context;
import android.view.View;
import android.widget.CompoundButton;
import androidx.annotation.NonNull;
import com.taobao.weex.WXSDKInstance;
import com.taobao.weex.annotation.Component;
import com.taobao.weex.common.Constants;
import com.taobao.weex.layout.ContentBoxMeasurement;
import com.taobao.weex.ui.action.BasicComponentData;
import com.taobao.weex.ui.component.list.template.TemplateDom;
import com.taobao.weex.ui.view.WXSwitchView;
import com.taobao.weex.utils.WXLogUtils;
import com.taobao.weex.utils.WXUtils;
import java.util.HashMap;

/* compiled from: Taobao */
@Component(lazyload = false)
/* loaded from: classes11.dex */
public class WXSwitch extends WXComponent<WXSwitchView> {
    private CompoundButton.OnCheckedChangeListener mListener;

    @Deprecated
    public WXSwitch(WXSDKInstance wXSDKInstance, WXVContainer wXVContainer, String str, boolean z, BasicComponentData basicComponentData) {
        this(wXSDKInstance, wXVContainer, z, basicComponentData);
    }

    @Override // com.taobao.weex.ui.component.WXComponent
    public void addEvent(String str) {
        super.addEvent(str);
        if (str == null || !str.equals(Constants.Event.CHANGE) || getHostView() == null) {
            return;
        }
        if (this.mListener == null) {
            this.mListener = new CompoundButton.OnCheckedChangeListener() { // from class: com.taobao.weex.ui.component.WXSwitch.2
                @Override // android.widget.CompoundButton.OnCheckedChangeListener
                public void onCheckedChanged(CompoundButton compoundButton, boolean z) {
                    HashMap hashMap = new HashMap(2);
                    hashMap.put("value", Boolean.valueOf(z));
                    HashMap hashMap2 = new HashMap();
                    HashMap hashMap3 = new HashMap();
                    hashMap3.put(Constants.Name.CHECKED, Boolean.toString(z));
                    hashMap2.put(TemplateDom.KEY_ATTRS, hashMap3);
                    WXSwitch.this.fireEvent(Constants.Event.CHANGE, hashMap, hashMap2);
                }
            };
        }
        getHostView().setOnCheckedChangeListener(this.mListener);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.taobao.weex.ui.component.WXComponent
    public void removeEventFromView(String str) {
        super.removeEventFromView(str);
        if (getHostView() == null || !Constants.Event.CHANGE.equals(str)) {
            return;
        }
        getHostView().setOnCheckedChangeListener(null);
    }

    @WXComponentProp(name = Constants.Name.CHECKED)
    public void setChecked(boolean z) {
        getHostView().setOnCheckedChangeListener(null);
        getHostView().setChecked(z);
        getHostView().setOnCheckedChangeListener(this.mListener);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.taobao.weex.ui.component.WXComponent
    public boolean setProperty(String str, Object obj) {
        str.hashCode();
        if (!str.equals(Constants.Name.CHECKED)) {
            return super.setProperty(str, obj);
        }
        Boolean bool = WXUtils.getBoolean(obj, null);
        if (bool != null) {
            setChecked(bool.booleanValue());
            return true;
        }
        return true;
    }

    public WXSwitch(final WXSDKInstance wXSDKInstance, WXVContainer wXVContainer, boolean z, BasicComponentData basicComponentData) {
        super(wXSDKInstance, wXVContainer, z, basicComponentData);
        setContentBoxMeasurement(new ContentBoxMeasurement() { // from class: com.taobao.weex.ui.component.WXSwitch.1
            @Override // com.taobao.weex.layout.ContentBoxMeasurement
            public void layoutAfter(float f, float f2) {
            }

            @Override // com.taobao.weex.layout.ContentBoxMeasurement
            public void layoutBefore() {
            }

            @Override // com.taobao.weex.layout.ContentBoxMeasurement
            public void measureInternal(float f, float f2, int i, int i2) {
                int makeMeasureSpec;
                this.mMeasureWidth = 0.0f;
                this.mMeasureHeight = 0.0f;
                try {
                    WXSwitchView wXSwitchView = new WXSwitchView(wXSDKInstance.getContext());
                    int makeMeasureSpec2 = View.MeasureSpec.makeMeasureSpec(0, 0);
                    if (Float.isNaN(f)) {
                        makeMeasureSpec = View.MeasureSpec.makeMeasureSpec(0, 0);
                    } else {
                        makeMeasureSpec = View.MeasureSpec.makeMeasureSpec((int) f, Integer.MIN_VALUE);
                    }
                    wXSwitchView.measure(makeMeasureSpec, makeMeasureSpec2);
                    this.mMeasureWidth = wXSwitchView.getMeasuredWidth();
                    this.mMeasureHeight = wXSwitchView.getMeasuredHeight();
                } catch (RuntimeException e) {
                    WXLogUtils.e(WXLogUtils.getStackTrace(e));
                }
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.taobao.weex.ui.component.WXComponent
    public WXSwitchView initComponentHostView(@NonNull Context context) {
        return new WXSwitchView(context);
    }
}
