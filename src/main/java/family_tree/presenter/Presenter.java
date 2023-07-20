package family_tree.presenter;

import family_tree.model.Service;
import family_tree.view.View;

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

    public void getPersonList() {
        String answer = service.getPersonList();
        view.print(answer);
    }

    public void sortByBirthDate() {
        service.sortByBirthDate();
        view.print("Дерево успешно отсортировано по дате рождения.");
    }

    public void saveData(String filename) {
        boolean success = service.saveData();
        if (success) {
            view.print("Данные успешно сохранены в файл: " + filename);
        } else {
            view.print("Не удалось сохранить данные.");
        }
    }

    public void loadData(String filename) {
        boolean success = service.loadData();
        if (success) {
            view.print("Данные успешно загружены из файла: " + filename);
        } else {
            view.print("Не удалось загрузить данные.");
        }
    }
}


