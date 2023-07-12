package cn.damai.ticklet.ui.observer;

/* compiled from: Taobao */
/* loaded from: classes7.dex */
public interface Observerable {
    void notifyObserver();

    void registerObserver(Observer observer);

    void removeObserver(Observer observer);
}
