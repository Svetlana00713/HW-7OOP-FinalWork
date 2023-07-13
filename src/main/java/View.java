import java.util.List;

public interface View {
    void setPresenter(Presenter Presenter);

    void start();

    void print(List text);
}
