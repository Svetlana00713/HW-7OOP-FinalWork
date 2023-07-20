package family_tree.view;

import family_tree.presenter.Presenter;

public interface View {
    void setPresenter(Presenter Presenter);

    void start();

    void print(String text);
}

