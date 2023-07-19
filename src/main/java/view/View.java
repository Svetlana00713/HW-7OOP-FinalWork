package view;

import presenter.Presenter;

public interface View {
    void setPresenter(Presenter Presenter);

    void start();

    void print(String text);
}

