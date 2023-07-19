package presenter;

import family_tree.model.Service;
import view.View;

public class Presenter {
    private View view;
    private Service service;

    public Presenter(View view) {
        service = new Service();
        this.view = view;
    }


    public void addPerson(String name, String gender, String birthDate) {
        String answer = service.addPerson(name, gender, birthDate, null, null);
        view.print(answer);
    }

    public void getByNameList() {
        String answer = service.getByNameList();
        view.print(answer);
    }
}


