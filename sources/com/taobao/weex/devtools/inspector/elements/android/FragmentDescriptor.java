package com.taobao.weex.devtools.inspector.elements.android;

import android.view.View;
import com.taobao.weex.devtools.common.Accumulator;
import com.taobao.weex.devtools.common.LogUtil;
import com.taobao.weex.devtools.common.android.FragmentAccessor;
import com.taobao.weex.devtools.common.android.FragmentCompat;
import com.taobao.weex.devtools.common.android.ResourcesUtil;
import com.taobao.weex.devtools.inspector.elements.AbstractChainedDescriptor;
import com.taobao.weex.devtools.inspector.elements.AttributeAccumulator;
import com.taobao.weex.devtools.inspector.elements.DescriptorMap;
import javax.annotation.Nullable;

/* compiled from: Taobao */
/* loaded from: classes11.dex */
final class FragmentDescriptor extends AbstractChainedDescriptor<Object> implements HighlightableDescriptor {
    private static final String ID_ATTRIBUTE_NAME = "id";
    private static final String TAG_ATTRIBUTE_NAME = "tag";
    private final FragmentAccessor mAccessor;

    private FragmentDescriptor(FragmentCompat fragmentCompat) {
        this.mAccessor = fragmentCompat.forFragment();
    }

    private static void maybeRegister(DescriptorMap descriptorMap, @Nullable FragmentCompat fragmentCompat) {
        if (fragmentCompat != null) {
            Class<?> fragmentClass = fragmentCompat.getFragmentClass();
            LogUtil.d("Adding support for %s", fragmentClass.getName());
            descriptorMap.register(fragmentClass, new FragmentDescriptor(fragmentCompat));
        }
    }

    public static DescriptorMap register(DescriptorMap descriptorMap) {
        maybeRegister(descriptorMap, FragmentCompat.getSupportLibInstance());
        maybeRegister(descriptorMap, FragmentCompat.getFrameworkInstance());
        return descriptorMap;
    }

    @Override // com.taobao.weex.devtools.inspector.elements.android.HighlightableDescriptor
    public View getViewForHighlighting(Object obj) {
        return this.mAccessor.getView(obj);
    }

    @Override // com.taobao.weex.devtools.inspector.elements.AbstractChainedDescriptor
    protected void onGetAttributes(Object obj, AttributeAccumulator attributeAccumulator) {
        int id = this.mAccessor.getId(obj);
        if (id != 0) {
            attributeAccumulator.store("id", ResourcesUtil.getIdStringQuietly(obj, this.mAccessor.getResources(obj), id));
        }
        String tag = this.mAccessor.getTag(obj);
        if (tag == null || tag.length() <= 0) {
            return;
        }
        attributeAccumulator.store("tag", tag);
    }

    @Override // com.taobao.weex.devtools.inspector.elements.AbstractChainedDescriptor
    protected void onGetChildren(Object obj, Accumulator<Object> accumulator) {
        View view = this.mAccessor.getView(obj);
        if (view != null) {
            accumulator.store(view);
        }
    }
}
