package com.alibaba.aliweex.adapter.component;

import android.content.Context;
import android.util.TypedValue;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.alibaba.aliweex.R$drawable;
import com.alibaba.aliweex.R$id;
import com.alibaba.aliweex.adapter.component.TabLayout;
import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.taobao.weex.WXSDKInstance;
import com.taobao.weex.adapter.IWXImgLoaderAdapter;
import com.taobao.weex.common.WXImageStrategy;
import com.taobao.weex.dom.WXImageQuality;
import com.taobao.weex.ui.action.BasicComponentData;
import com.taobao.weex.ui.component.WXComponentProp;
import com.taobao.weex.ui.component.WXEmbed;
import com.taobao.weex.ui.component.WXVContainer;
import com.taobao.weex.ui.component.list.template.TemplateDom;
import com.taobao.weex.ui.view.border.BorderDrawable;
import com.taobao.weex.utils.WXResourceUtils;
import com.taobao.weex.utils.WXViewUtils;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/* compiled from: Taobao */
/* loaded from: classes5.dex */
public class WXTabbar extends WXVContainer<TabLayout> implements TabLayout.OnTabSelectedListener {
    public static final String EVENT_TABSELECTED = "tabselected";
    public static final String SELECT_INDEX = "selectedIndex";
    public static final String TAB_ITEMS = "tabItems";
    private BorderDrawable mBackgroundDrawable;
    protected List<C3035a> mItems;

    /* JADX INFO: Access modifiers changed from: protected */
    /* compiled from: Taobao */
    /* renamed from: com.alibaba.aliweex.adapter.component.WXTabbar$a */
    /* loaded from: classes15.dex */
    public static class C3035a {
        public static final int DEFAULT_FONTSIZE = 24;
        public static final int DEFAULT_ICON_SIZE = 68;
        public static final String FONT_SIZE = "fontSize";
        public static final String ICON_SIZE = "iconSize";
        View a;
        TextView b;
        ImageView c;
        TextView d;
        int e;
        int f;
        String g;
        String h;
        String i;
        WXSDKInstance j;

        private C3035a() {
        }

        public static C3035a a(JSONObject jSONObject, Context context, WXSDKInstance wXSDKInstance) {
            C3035a c3035a = new C3035a();
            c3035a.j = wXSDKInstance;
            String string = jSONObject.getString("title");
            int color = WXResourceUtils.getColor(jSONObject.getString("titleColor"));
            int color2 = WXResourceUtils.getColor(jSONObject.getString("titleSelectedColor"));
            String string2 = jSONObject.getString("image");
            String string3 = jSONObject.getString("selectedImage");
            int intValue = jSONObject.getIntValue("badge");
            int intValue2 = jSONObject.containsKey(ICON_SIZE) ? jSONObject.getIntValue(ICON_SIZE) : 68;
            int intValue3 = jSONObject.containsKey("fontSize") ? jSONObject.getIntValue("fontSize") : 24;
            c3035a.i = jSONObject.getString("itemId");
            c3035a.e = color;
            c3035a.f = color2;
            c3035a.g = string2;
            c3035a.h = string3;
            LinearLayout linearLayout = new LinearLayout(context);
            linearLayout.setOrientation(1);
            linearLayout.setHorizontalGravity(17);
            linearLayout.setGravity(48);
            linearLayout.setLayoutParams(new ViewGroup.LayoutParams(-1, -1));
            RelativeLayout relativeLayout = new RelativeLayout(context);
            relativeLayout.setGravity(17);
            LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-1, -2);
            ImageView imageView = new ImageView(context);
            int i = R$id.tabbar_image;
            imageView.setId(i);
            int round = Math.round(WXViewUtils.getRealPxByWidth(intValue2));
            RelativeLayout.LayoutParams layoutParams2 = new RelativeLayout.LayoutParams(round, round);
            layoutParams.height = round;
            layoutParams2.addRule(14);
            imageView.setLayoutParams(layoutParams2);
            relativeLayout.addView(imageView);
            TextView textView = null;
            if (intValue > 0) {
                textView = new TextView(context);
                RelativeLayout.LayoutParams layoutParams3 = new RelativeLayout.LayoutParams(-2, -2);
                layoutParams3.addRule(1, i);
                layoutParams3.topMargin = (int) TypedValue.applyDimension(1, -5.0f, context.getResources().getDisplayMetrics());
                textView.setTextColor(-1);
                textView.setText(String.valueOf(intValue));
                textView.setTextSize(1, 10.0f);
                textView.setGravity(17);
                textView.setBackgroundResource(R$drawable.badge);
                relativeLayout.addView(textView, layoutParams3);
            }
            linearLayout.addView(relativeLayout, layoutParams);
            TextView textView2 = new TextView(context);
            textView2.setText(string);
            textView2.setTextSize(0, WXViewUtils.getRealPxByWidth(intValue3));
            LinearLayout.LayoutParams layoutParams4 = new LinearLayout.LayoutParams(-2, -2);
            layoutParams4.gravity = 1;
            textView2.setGravity(1);
            textView2.setLayoutParams(layoutParams4);
            textView2.setTextColor(color);
            linearLayout.addView(textView2);
            c3035a.b = textView2;
            c3035a.c = imageView;
            c3035a.d = textView;
            c3035a.a = linearLayout;
            return c3035a;
        }

        private void d(boolean z) {
            IWXImgLoaderAdapter imgLoaderAdapter = this.j.getImgLoaderAdapter();
            if (imgLoaderAdapter != null) {
                imgLoaderAdapter.setImage(z ? this.h : this.g, this.c, WXImageQuality.ORIGINAL, new WXImageStrategy());
            }
        }

        public String b() {
            return this.i;
        }

        public View c() {
            return this.a;
        }

        public void e(boolean z) {
            this.b.setTextColor(z ? this.f : this.e);
            d(z);
        }
    }

    public WXTabbar(WXSDKInstance wXSDKInstance, WXVContainer wXVContainer, BasicComponentData basicComponentData) {
        super(wXSDKInstance, wXVContainer, basicComponentData);
        this.mItems = new ArrayList();
    }

    private int getSelectedIndex() {
        Object obj = getAttrs().get(SELECT_INDEX);
        if (obj == null) {
            return 0;
        }
        return Integer.parseInt((String) obj);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.taobao.weex.ui.component.WXComponent
    public void onFinishLayout() {
        super.onFinishLayout();
        TabLayout tabLayout = (TabLayout) getHostView();
        if (tabLayout != null) {
            tabLayout.updateSize();
        }
    }

    @Override // com.alibaba.aliweex.adapter.component.TabLayout.OnTabSelectedListener
    public void onTabReselected(TabLayout.C3026b c3026b) {
    }

    @Override // com.alibaba.aliweex.adapter.component.TabLayout.OnTabSelectedListener
    public void onTabSelected(TabLayout.C3026b c3026b) {
        updateTabState(c3026b.c(), true);
        HashMap hashMap = new HashMap(2);
        hashMap.put("index", Integer.valueOf(c3026b.c()));
        hashMap.put("timeStamp", Long.valueOf(System.currentTimeMillis()));
        HashMap hashMap2 = new HashMap();
        HashMap hashMap3 = new HashMap();
        hashMap3.put(SELECT_INDEX, Integer.valueOf(c3026b.c()));
        hashMap2.put(TemplateDom.KEY_ATTRS, hashMap3);
        getInstance().fireEvent(getRef(), EVENT_TABSELECTED, hashMap, hashMap2);
    }

    @Override // com.alibaba.aliweex.adapter.component.TabLayout.OnTabSelectedListener
    public void onTabUnselected(TabLayout.C3026b c3026b) {
        updateTabState(c3026b.c(), false);
    }

    @WXComponentProp(name = SELECT_INDEX)
    public void setSelectIndex(int i) {
        TabLayout tabLayout;
        TabLayout.C3026b tabAt;
        if (i < 0 || i >= this.mItems.size() || (tabLayout = (TabLayout) getHostView()) == null || (tabAt = tabLayout.getTabAt(i)) == null) {
            return;
        }
        tabAt.d();
    }

    @WXComponentProp(name = TAB_ITEMS)
    public void setTabItems(String str) {
        JSONArray parseArray = JSON.parseArray(str);
        TabLayout tabLayout = (TabLayout) getHostView();
        tabLayout.removeAllTabs();
        this.mItems.clear();
        if (parseArray == null || parseArray.size() == 0) {
            return;
        }
        int selectedIndex = getSelectedIndex();
        int size = parseArray.size();
        int i = 0;
        while (i < size) {
            C3035a a = C3035a.a(parseArray.getJSONObject(i), getContext(), getInstance());
            a.e(false);
            this.mItems.add(a);
            tabLayout.addTab(tabLayout.newTab().e(a.c()), i == selectedIndex);
            i++;
        }
    }

    @Override // com.taobao.weex.ui.component.WXComponent
    public void updateProperties(Map<String, Object> map) {
        super.updateProperties(map);
    }

    protected void updateTabState(int i, boolean z) {
        WXEmbed.EmbedManager embedManager;
        WXEmbed embed;
        TextView textView;
        C3035a c3035a = this.mItems.get(i);
        c3035a.e(z);
        if (!z && (textView = c3035a.d) != null) {
            textView.setVisibility(4);
        }
        if (!(getInstance() instanceof WXEmbed.EmbedManager) || (embedManager = (WXEmbed.EmbedManager) getInstance()) == null || (embed = embedManager.getEmbed(c3035a.b())) == null) {
            return;
        }
        embed.setVisibility(z ? "visible" : "hidden");
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.taobao.weex.ui.component.WXComponent
    public TabLayout initComponentHostView(Context context) {
        TabLayout tabLayout = new TabLayout(context, this);
        tabLayout.setOnTabSelectedListener(this);
        return tabLayout;
    }
}
