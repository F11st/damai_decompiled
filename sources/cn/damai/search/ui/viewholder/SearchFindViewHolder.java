package cn.damai.search.ui.viewholder;

import android.content.Context;
import android.graphics.Color;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;
import cn.damai.common.image.C0504a;
import cn.damai.common.image.DMImageCreator;
import cn.damai.homepage.R$id;
import cn.damai.homepage.R$layout;
import cn.damai.search.bean.SearchFindWord;
import cn.damai.search.bean.SearchFindWordList;
import cn.damai.search.helper.SearchListener;
import cn.damai.uikit.R$drawable;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import java.util.List;
import tb.m62;

/* compiled from: Taobao */
/* loaded from: classes6.dex */
public class SearchFindViewHolder extends RecyclerView.ViewHolder {
    private static transient /* synthetic */ IpChange $ipChange;
    private static final int[] g = {R$drawable.homepage_rank_icon_0, R$drawable.homepage_rank_icon_1, R$drawable.homepage_rank_icon_2, R$drawable.homepage_rank_icon_3};
    private static final String[] h = {"#FF42B0", "#FF4A72", "#FFAD00"};
    private Context a;
    private LayoutInflater b;
    private LinearLayout c;
    private LinearLayout d;
    private LinearLayout e;
    private SearchListener f;

    /* compiled from: Taobao */
    /* renamed from: cn.damai.search.ui.viewholder.SearchFindViewHolder$a */
    /* loaded from: classes15.dex */
    public class View$OnClickListenerC1624a implements View.OnClickListener {
        private static transient /* synthetic */ IpChange $ipChange;

        View$OnClickListenerC1624a() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "-1410237100")) {
                ipChange.ipc$dispatch("-1410237100", new Object[]{this, view});
            } else if (SearchFindViewHolder.this.f != null) {
                SearchFindViewHolder.this.f.onSearchFindTextClick(view);
            }
        }
    }

    public SearchFindViewHolder(Context context, LayoutInflater layoutInflater) {
        super(layoutInflater.inflate(R$layout.search_list_find, (ViewGroup) null));
        this.itemView.setLayoutParams(new RecyclerView.LayoutParams(-1, -2));
        this.a = context;
        this.b = layoutInflater;
        this.c = (LinearLayout) this.itemView.findViewById(R$id.layout_pic_item_container);
        TextView textView = (TextView) this.itemView.findViewById(R$id.tv_title);
        textView.setText(textView.getText().toString());
        this.d = (LinearLayout) this.itemView.findViewById(R$id.layout_left);
        this.e = (LinearLayout) this.itemView.findViewById(R$id.layout_right);
    }

    private String b(int i) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "587679622")) {
            return (String) ipChange.ipc$dispatch("587679622", new Object[]{this, Integer.valueOf(i)});
        }
        String[] strArr = h;
        return i < strArr.length ? strArr[i] : "#98A7C2";
    }

    private void d(String str, ImageView imageView) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "434987572")) {
            ipChange.ipc$dispatch("434987572", new Object[]{this, str, imageView});
            return;
        }
        DMImageCreator c = C0504a.b().c(str);
        int i = cn.damai.homepage.R$drawable.search_hot_item_pic;
        c.i(i).c(i).g(imageView);
    }

    private void e(int i, String str, TextView textView) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1988916253")) {
            ipChange.ipc$dispatch("-1988916253", new Object[]{this, Integer.valueOf(i), str, textView});
        } else if (TextUtils.isEmpty(str) || textView == null) {
        } else {
            if (i == 1) {
                textView.setText(str);
                textView.setBackgroundResource(cn.damai.homepage.R$drawable.bg_border_corner_0c);
                textView.setVisibility(0);
            } else if (i == 2) {
                textView.setText(str);
                textView.setBackgroundResource(cn.damai.homepage.R$drawable.bg_border_corner_ec);
                textView.setVisibility(0);
            } else if (i != 3) {
                textView.setVisibility(8);
            } else {
                textView.setText(str);
                textView.setBackgroundResource(cn.damai.homepage.R$drawable.bg_border_corner_a2);
                textView.setVisibility(0);
            }
        }
    }

    private boolean g(SearchFindWordList searchFindWordList) {
        List<SearchFindWord> list;
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "376667564")) {
            return ((Boolean) ipChange.ipc$dispatch("376667564", new Object[]{this, searchFindWordList})).booleanValue();
        }
        if (searchFindWordList == null || (list = searchFindWordList.hotWords) == null || list.size() <= 4) {
            return false;
        }
        for (int i = 0; i < 4; i++) {
            SearchFindWord searchFindWord = searchFindWordList.hotWords.get(i);
            if (searchFindWord == null || !searchFindWord.isPicItem()) {
                return false;
            }
        }
        return true;
    }

    private void onClick(View view) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1150923769")) {
            ipChange.ipc$dispatch("-1150923769", new Object[]{this, view});
        } else if (view == null) {
        } else {
            view.setOnClickListener(new View$OnClickListenerC1624a());
        }
    }

    public void c(SearchFindWordList searchFindWordList) {
        View inflate;
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-2144585700")) {
            ipChange.ipc$dispatch("-2144585700", new Object[]{this, searchFindWordList});
        } else if (searchFindWordList != null) {
            this.d.removeAllViews();
            this.e.removeAllViews();
            boolean g2 = g(searchFindWordList);
            if (g2) {
                this.c.setVisibility(0);
                this.c.removeAllViews();
            } else {
                this.c.setVisibility(8);
            }
            for (int i = 0; i < searchFindWordList.hotWords.size(); i++) {
                SearchFindWord searchFindWord = searchFindWordList.hotWords.get(i);
                if (searchFindWord != null && !TextUtils.isEmpty(searchFindWord.keyword)) {
                    searchFindWord.pos = i;
                    if (g2 && i < 4) {
                        inflate = this.b.inflate(R$layout.layout_hot_text_pic, (ViewGroup) null);
                        ((TextView) inflate.findViewById(R$id.tv_keyname)).setText(searchFindWord.keyword);
                        ImageView imageView = (ImageView) inflate.findViewById(R$id.iv_pic);
                        ImageView imageView2 = (ImageView) inflate.findViewById(R$id.iv_number);
                        int[] iArr = g;
                        if (i < iArr.length) {
                            imageView2.setVisibility(0);
                            imageView2.setImageResource(iArr[i]);
                        } else {
                            imageView2.setVisibility(8);
                        }
                        d(searchFindWord.pic, imageView);
                        this.c.addView(inflate);
                        LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) inflate.getLayoutParams();
                        layoutParams.weight = 1.0f;
                        if (i != 0) {
                            layoutParams.leftMargin = m62.a(this.a, 3.0f);
                        }
                    } else {
                        inflate = this.b.inflate(R$layout.layout_hot_text, (ViewGroup) null);
                        TextView textView = (TextView) inflate.findViewById(R$id.tv_position);
                        textView.setText((i + 1) + "");
                        textView.setTextColor(Color.parseColor(b(i)));
                        ((TextView) inflate.findViewById(R$id.tv_keyname)).setText(searchFindWord.keyword);
                        e(searchFindWord.getLabelType(), searchFindWord.reason, (TextView) inflate.findViewById(R$id.tv_label));
                        if (i % 2 == 0) {
                            this.d.addView(inflate);
                        } else {
                            this.e.addView(inflate);
                        }
                    }
                    inflate.setTag(searchFindWord);
                    onClick(inflate);
                }
            }
        }
    }

    public void f(SearchListener searchListener) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "306011239")) {
            ipChange.ipc$dispatch("306011239", new Object[]{this, searchListener});
        } else {
            this.f = searchListener;
        }
    }
}
