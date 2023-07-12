package com.real.android.nativehtml.android;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Spinner;
import android.widget.SpinnerAdapter;
import android.widget.TextView;
import com.real.android.nativehtml.common.dom.ContentType;
import com.real.android.nativehtml.common.dom.Element;
import com.real.android.nativehtml.common.dom.HtmlCollection;
import com.real.android.nativehtml.common.dom.HtmlSelectElement;
import com.real.android.nativehtml.common.util.HtmlCollectionImpl;
import tb.qb0;

/* compiled from: Taobao */
/* loaded from: classes5.dex */
public class AndroidSelectElement extends AndroidWrapperElement implements HtmlSelectElement {
    HtmlCollectionImpl children;
    Spinner spinner;

    /* compiled from: Taobao */
    /* loaded from: classes5.dex */
    private class SelectElementAdapter extends BaseAdapter {
        LayoutInflater inflater;

        private SelectElementAdapter() {
            this.inflater = (LayoutInflater) AndroidSelectElement.this.getContext().getSystemService("layout_inflater");
        }

        private View getResourceView(int i, View view, ViewGroup viewGroup, int i2) {
            if (view == null) {
                view = this.inflater.inflate(i2, viewGroup, false);
            }
            TextView textView = (TextView) view;
            textView.setText(((Element) getItem(i)).getTextContent());
            return textView;
        }

        @Override // android.widget.Adapter
        public int getCount() {
            return AndroidSelectElement.this.children.getLength();
        }

        @Override // android.widget.BaseAdapter, android.widget.SpinnerAdapter
        public View getDropDownView(int i, View view, ViewGroup viewGroup) {
            return getResourceView(i, view, viewGroup, 17367049);
        }

        @Override // android.widget.Adapter
        public Object getItem(int i) {
            return AndroidSelectElement.this.children.item(i);
        }

        @Override // android.widget.Adapter
        public long getItemId(int i) {
            return i;
        }

        @Override // android.widget.Adapter
        public View getView(int i, View view, ViewGroup viewGroup) {
            return getResourceView(i, view, viewGroup, 17367048);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public AndroidSelectElement(Context context, qb0 qb0Var) {
        super(context, qb0Var, "select", new Spinner(context));
        this.children = new HtmlCollectionImpl();
        Spinner spinner = (Spinner) this.child;
        this.spinner = spinner;
        spinner.setAdapter((SpinnerAdapter) new SelectElementAdapter());
    }

    @Override // com.real.android.nativehtml.android.AndroidWrapperElement, com.real.android.nativehtml.common.dom.Element
    public HtmlCollection getChildren() {
        return this.children;
    }

    @Override // com.real.android.nativehtml.common.dom.Element
    public ContentType getElementContentType() {
        return ContentType.DATA_ELEMENTS;
    }

    @Override // com.real.android.nativehtml.android.AndroidWrapperElement, com.real.android.nativehtml.common.dom.Element
    public void insertBefore(Element element, Element element2) {
        this.children.insertBefore(this, element, element2);
        ((SelectElementAdapter) this.spinner.getAdapter()).notifyDataSetChanged();
    }

    @Override // com.real.android.nativehtml.android.AbstractAndroidComponentElement, com.real.android.nativehtml.common.dom.Element
    public void setAttribute(String str, String str2) {
        super.setAttribute(str, str2);
    }
}
