package com.taobao.weex.appfram.pickers;

import android.content.Context;
import android.content.DialogInterface;
import android.os.Build;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Checkable;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AlertDialog;
import com.taobao.weex.annotation.JSMethod;
import com.taobao.weex.appfram.pickers.DatePickerImpl;
import com.taobao.weex.bridge.JSCallback;
import com.taobao.weex.common.WXModule;
import com.taobao.weex.common.WXThread;
import com.taobao.weex.utils.WXResourceUtils;
import com.taobao.weex.utils.WXViewUtils;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/* compiled from: Taobao */
/* loaded from: classes11.dex */
public class WXPickersModule extends WXModule {
    private static final String CANCEL = "cancel";
    private static final String DATA = "data";
    private static final String ERROR = "error";
    private static final String KEY_CANCEL_TITLE = "cancelTitle";
    private static final String KEY_CANCEL_TITLE_COLOR = "cancelTitleColor";
    private static final String KEY_CONFIRM_TITLE = "confirmTitle";
    private static final String KEY_CONFIRM_TITLE_COLOR = "confirmTitleColor";
    private static final String KEY_INDEX = "index";
    private static final String KEY_ITEMS = "items";
    private static final String KEY_MAX = "max";
    private static final String KEY_MIN = "min";
    private static final String KEY_SELECTION_COLOR = "selectionColor";
    private static final String KEY_TEXT_COLOR = "textColor";
    private static final String KEY_TITLE = "title";
    private static final String KEY_TITLE_BACKGROUND_COLOR = "titleBackgroundColor";
    private static final String KEY_TITLE_COLOR = "titleColor";
    private static final String KEY_VALUE = "value";
    private static final String RESULT = "result";
    private static final String SUCCESS = "success";
    private int selected;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: Taobao */
    /* renamed from: com.taobao.weex.appfram.pickers.WXPickersModule$a */
    /* loaded from: classes11.dex */
    public class C6955a implements DatePickerImpl.OnPickListener {
        final /* synthetic */ JSCallback a;

        C6955a(WXPickersModule wXPickersModule, JSCallback jSCallback) {
            this.a = jSCallback;
        }

        @Override // com.taobao.weex.appfram.pickers.DatePickerImpl.OnPickListener
        public void onPick(boolean z, @Nullable String str) {
            if (z) {
                HashMap hashMap = new HashMap(2);
                hashMap.put("result", "success");
                hashMap.put("data", str);
                this.a.invoke(hashMap);
                return;
            }
            HashMap hashMap2 = new HashMap(2);
            hashMap2.put("result", "cancel");
            hashMap2.put("data", null);
            this.a.invoke(hashMap2);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: Taobao */
    /* renamed from: com.taobao.weex.appfram.pickers.WXPickersModule$b */
    /* loaded from: classes11.dex */
    public class C6956b implements DatePickerImpl.OnPickListener {
        final /* synthetic */ JSCallback a;

        C6956b(WXPickersModule wXPickersModule, JSCallback jSCallback) {
            this.a = jSCallback;
        }

        @Override // com.taobao.weex.appfram.pickers.DatePickerImpl.OnPickListener
        public void onPick(boolean z, @Nullable String str) {
            if (z) {
                HashMap hashMap = new HashMap(2);
                hashMap.put("result", "success");
                hashMap.put("data", str);
                this.a.invoke(hashMap);
                return;
            }
            HashMap hashMap2 = new HashMap(2);
            hashMap2.put("result", "cancel");
            hashMap2.put("data", null);
            this.a.invoke(hashMap2);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: Taobao */
    /* renamed from: com.taobao.weex.appfram.pickers.WXPickersModule$c */
    /* loaded from: classes11.dex */
    public class DialogInterface$OnClickListenerC6957c implements DialogInterface.OnClickListener {
        final /* synthetic */ JSCallback a;

        DialogInterface$OnClickListenerC6957c(WXPickersModule wXPickersModule, JSCallback jSCallback) {
            this.a = jSCallback;
        }

        @Override // android.content.DialogInterface.OnClickListener
        public void onClick(DialogInterface dialogInterface, int i) {
            HashMap hashMap = new HashMap(2);
            hashMap.put("result", "cancel");
            hashMap.put("data", -1);
            this.a.invoke(hashMap);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: Taobao */
    /* renamed from: com.taobao.weex.appfram.pickers.WXPickersModule$d */
    /* loaded from: classes11.dex */
    public class DialogInterface$OnClickListenerC6958d implements DialogInterface.OnClickListener {
        final /* synthetic */ JSCallback a;

        DialogInterface$OnClickListenerC6958d(JSCallback jSCallback) {
            this.a = jSCallback;
        }

        @Override // android.content.DialogInterface.OnClickListener
        public void onClick(DialogInterface dialogInterface, int i) {
            HashMap hashMap = new HashMap(2);
            hashMap.put("result", "success");
            hashMap.put("data", Integer.valueOf(WXPickersModule.this.selected));
            this.a.invoke(hashMap);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public int getColor(Map<String, Object> map, String str, int i) {
        Object option = getOption(map, str, null);
        return option == null ? i : WXResourceUtils.getColor(option.toString(), i);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public <T> T getOption(Map<String, Object> map, String str, T t) {
        T t2 = (T) map.get(str);
        return t2 == null ? t : t2;
    }

    private TextView makeTitleView(Context context, Map<String, Object> map) {
        String str = (String) getOption(map, "title", null);
        if (str == null) {
            return null;
        }
        TextView textView = new TextView(context);
        textView.setLayoutParams(new ViewGroup.LayoutParams(-1, -2));
        textView.setTextSize(2, 20.0f);
        int dip2px = WXViewUtils.dip2px(12.0f);
        textView.setPadding(dip2px, dip2px, dip2px, dip2px);
        textView.getPaint().setFakeBoldText(true);
        textView.setBackgroundColor(getColor(map, KEY_TITLE_BACKGROUND_COLOR, 0));
        textView.setTextColor(getColor(map, KEY_TITLE_COLOR, -16777216));
        textView.setText(str);
        return textView;
    }

    private void performPickDate(Map<String, Object> map, JSCallback jSCallback) {
        DatePickerImpl.c(this.mWXSDKInstance.getContext(), (String) getOption(map, "value", ""), (String) getOption(map, "max", ""), (String) getOption(map, "min", ""), new C6956b(this, jSCallback), map);
    }

    private void performPickTime(Map<String, Object> map, JSCallback jSCallback) {
        DatePickerImpl.d(this.mWXSDKInstance.getContext(), (String) getOption(map, "value", ""), new C6955a(this, jSCallback), map);
    }

    private void performSinglePick(List<String> list, final Map<String, Object> map, JSCallback jSCallback) {
        this.selected = ((Integer) getOption(map, "index", 0)).intValue();
        final int color = getColor(map, KEY_TEXT_COLOR, 0);
        final int color2 = getColor(map, KEY_SELECTION_COLOR, 0);
        final ArrayAdapter<String> arrayAdapter = new ArrayAdapter<String>(this.mWXSDKInstance.getContext(), 17367055, list) { // from class: com.taobao.weex.appfram.pickers.WXPickersModule.3
            @Override // android.widget.ArrayAdapter, android.widget.Adapter
            @NonNull
            public View getView(int i, View view, @Nullable ViewGroup viewGroup) {
                int i2;
                View view2 = super.getView(i, view, viewGroup);
                if (view2 != null && (view2 instanceof Checkable)) {
                    boolean z = i == WXPickersModule.this.selected;
                    ((Checkable) view2).setChecked(z);
                    if (z) {
                        view2.setBackgroundColor(color2);
                    } else {
                        view2.setBackgroundColor(0);
                    }
                }
                if ((view2 instanceof TextView) && (i2 = color) != 0) {
                    ((TextView) view2).setTextColor(i2);
                }
                return view2;
            }
        };
        final AlertDialog create = new AlertDialog.Builder(this.mWXSDKInstance.getContext()).setAdapter(arrayAdapter, null).setPositiveButton(17039370, new DialogInterface$OnClickListenerC6958d(jSCallback)).setNegativeButton(17039360, new DialogInterface$OnClickListenerC6957c(this, jSCallback)).setCustomTitle(makeTitleView(this.mWXSDKInstance.getContext(), map)).create();
        if (Build.VERSION.SDK_INT >= 21) {
            create.create();
        }
        create.getListView().setOnItemClickListener(new AdapterView.OnItemClickListener() { // from class: com.taobao.weex.appfram.pickers.WXPickersModule.6
            @Override // android.widget.AdapterView.OnItemClickListener
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
                WXPickersModule.this.selected = i;
                arrayAdapter.notifyDataSetChanged();
            }
        });
        create.getWindow().getDecorView().post(WXThread.secure(new Runnable() { // from class: com.taobao.weex.appfram.pickers.WXPickersModule.7
            @Override // java.lang.Runnable
            public void run() {
                Button button = create.getButton(-1);
                Button button2 = create.getButton(-2);
                if (button != null) {
                    String str = (String) WXPickersModule.this.getOption(map, WXPickersModule.KEY_CONFIRM_TITLE, null);
                    int color3 = WXPickersModule.this.getColor(map, WXPickersModule.KEY_CONFIRM_TITLE_COLOR, 0);
                    if (str != null) {
                        button.setText(str);
                        button.setAllCaps(false);
                    }
                    if (color3 != 0) {
                        button.setTextColor(color3);
                        button.setAllCaps(false);
                    }
                }
                if (button2 != null) {
                    String str2 = (String) WXPickersModule.this.getOption(map, "cancelTitle", null);
                    int color4 = WXPickersModule.this.getColor(map, WXPickersModule.KEY_CANCEL_TITLE_COLOR, 0);
                    if (str2 != null) {
                        button2.setText(str2);
                    }
                    if (color4 != 0) {
                        button2.setTextColor(color4);
                    }
                }
            }
        }));
        create.show();
    }

    private List<String> safeConvert(List list) {
        ArrayList arrayList = new ArrayList(list.size());
        for (Object obj : list) {
            arrayList.add(String.valueOf(obj));
        }
        return arrayList;
    }

    @JSMethod
    public void pick(Map<String, Object> map, JSCallback jSCallback) {
        try {
            performSinglePick(safeConvert((List) getOption(map, KEY_ITEMS, new ArrayList())), map, jSCallback);
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    @JSMethod
    public void pickDate(Map<String, Object> map, JSCallback jSCallback) {
        performPickDate(map, jSCallback);
    }

    @JSMethod
    public void pickTime(Map<String, Object> map, JSCallback jSCallback) {
        performPickTime(map, jSCallback);
    }
}
