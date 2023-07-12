package com.taobao.weex.devtools.adapter;

import android.graphics.Color;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Filter;
import android.widget.Filterable;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;
import com.taobao.weex.utils.WXLogUtils;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

/* compiled from: Taobao */
/* loaded from: classes11.dex */
public class JsLogAdapter extends RecyclerView.Adapter<ItemHolder> implements WXLogUtils.JsLogWatcher, Filterable {
    private static JsLogAdapter sInstance;
    private List<LogItem> originLogItems = new CopyOnWriteArrayList();
    private List<LogItem> displayedLogItems = new CopyOnWriteArrayList();
    private int currentLogLevel = 2;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: Taobao */
    /* loaded from: classes11.dex */
    public class ItemHolder extends RecyclerView.ViewHolder {
        public ItemHolder(View view) {
            super(view);
        }

        private TextView getTextView() {
            View view = this.itemView;
            if (view instanceof ViewGroup) {
                ViewGroup viewGroup = (ViewGroup) view;
                if (viewGroup.getChildCount() == 2 && (viewGroup.getChildAt(0) instanceof TextView)) {
                    return (TextView) viewGroup.getChildAt(0);
                }
                return null;
            }
            return null;
        }

        public void render(LogItem logItem) {
            TextView textView = getTextView();
            if (textView != null) {
                int i = logItem.level;
                if (i == 2 || i == 3) {
                    textView.setTextColor(Color.parseColor("#B4000000"));
                } else if (i == 4) {
                    textView.setTextColor(Color.parseColor("#1E00CA"));
                } else if (i == 5) {
                    textView.setTextColor(Color.parseColor("#E9B200"));
                } else if (i == 6) {
                    textView.setTextColor(Color.parseColor("#EF0000"));
                }
                textView.setText(logItem.msg);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: Taobao */
    /* loaded from: classes11.dex */
    public class LogItem {
        int level;
        String msg;

        LogItem() {
        }
    }

    private JsLogAdapter() {
    }

    public static synchronized JsLogAdapter getInstance() {
        JsLogAdapter jsLogAdapter;
        synchronized (JsLogAdapter.class) {
            if (sInstance == null) {
                sInstance = new JsLogAdapter();
            }
            jsLogAdapter = sInstance;
        }
        return jsLogAdapter;
    }

    @Override // android.widget.Filterable
    public Filter getFilter() {
        return new Filter() { // from class: com.taobao.weex.devtools.adapter.JsLogAdapter.1
            @Override // android.widget.Filter
            protected Filter.FilterResults performFiltering(CharSequence charSequence) {
                Filter.FilterResults filterResults = new Filter.FilterResults();
                filterResults.values = new ArrayList();
                for (LogItem logItem : JsLogAdapter.this.originLogItems) {
                    if (logItem.level >= JsLogAdapter.this.currentLogLevel) {
                        if (TextUtils.isEmpty(charSequence)) {
                            ((List) filterResults.values).add(logItem);
                        } else if (logItem.msg.toLowerCase().contains(charSequence.toString())) {
                            ((List) filterResults.values).add(logItem);
                        }
                    }
                }
                filterResults.count = ((List) filterResults.values).size();
                return filterResults;
            }

            @Override // android.widget.Filter
            protected void publishResults(CharSequence charSequence, Filter.FilterResults filterResults) {
                JsLogAdapter.this.displayedLogItems.clear();
                JsLogAdapter.this.displayedLogItems.addAll((List) filterResults.values);
                JsLogAdapter.this.notifyDataSetChanged();
            }
        };
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public int getItemCount() {
        return this.displayedLogItems.size();
    }

    public int getLogLevel() {
        return this.currentLogLevel;
    }

    @Override // com.taobao.weex.utils.WXLogUtils.JsLogWatcher
    public void onJsLog(int i, String str) {
        while (this.originLogItems.size() >= 2000) {
            this.originLogItems.remove(0);
        }
        LogItem logItem = new LogItem();
        logItem.level = i;
        logItem.msg = str;
        this.originLogItems.add(logItem);
        if (i >= this.currentLogLevel) {
            this.displayedLogItems.add(logItem);
            notifyItemInserted(this.displayedLogItems.size() - 1);
        }
    }

    public void setLogLevel(int i) {
        this.currentLogLevel = i;
        getFilter().filter("");
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public void onBindViewHolder(ItemHolder itemHolder, int i) {
        itemHolder.render(this.displayedLogItems.get(i));
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public ItemHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
        LinearLayout linearLayout = new LinearLayout(viewGroup.getContext());
        linearLayout.setOrientation(1);
        TextView textView = new TextView(viewGroup.getContext());
        textView.setLayoutParams(new ViewGroup.LayoutParams(-1, -2));
        linearLayout.addView(textView);
        View view = new View(viewGroup.getContext());
        view.setBackgroundColor(-7829368);
        view.setLayoutParams(new ViewGroup.LayoutParams(-1, 1));
        linearLayout.addView(view);
        return new ItemHolder(linearLayout);
    }
}
