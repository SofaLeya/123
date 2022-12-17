import java.util.ArrayList;
import java.util.HashMap;

public class ExpensesManager {
    HashMap<String, ArrayList<Double>> expensesByCategories; // Замените на таблицу с именем expensesByCategories
    ArrayList<Double> expenses;
    ExpensesManager() {
        expensesByCategories = new HashMap<>(); // Создайте таблицу
        expenses = new ArrayList<>();
    }

    // Добавьте в метод ещё один параметр — category
    double saveExpense(double moneyBeforeSalary, double expense, String category) {
        moneyBeforeSalary = moneyBeforeSalary - expense;
        System.out.println("Значение сохранено! Ваш текущий баланс в рублях: " + moneyBeforeSalary);
        // Замените на работу с таблицей
        if (expensesByCategories.containsKey(category)) { // Проверьте наличие категории
            ArrayList<Double>expenses = expensesByCategories.get(category); // Получите список трат в этой категории
            expenses.add(expense);// Добавьте трату
            expensesByCategories.put(category, expenses);
        } else {
            ArrayList<Double>expenses = new ArrayList<>();
            expenses.add(expense);
            expensesByCategories.put(category, expenses); // Сохраните категорию и новый список трат в хеш-таблицу
        }
        if (moneyBeforeSalary < 1000) {
            System.out.println("На вашем счету осталось совсем немного. Стоит начать экономить!");
        }
        return moneyBeforeSalary;
    }


    void printAllExpensesByCategories() {
        // Замените логику для работы с таблицами
        for (String category : expensesByCategories.keySet()) {

            for (Double expense : expensesByCategories.get(category)) {

                System.out.println("Трата № " + category + ". Потрачено " + expensesByCategories.get(category) + " рублей");
            }
        }
    }

    // Метод должен принимать название категории и называться findMaxExpenseInCategory
    double findMaxExpenseInCategory(String category) {
        double maxExpense = 0.00;
        /* Замените логику для работы с таблицами
        Если категория есть, то ищем максмальную трату.
        Иначе печатаем "Такой категории пока нет." */
        if (expensesByCategories.containsKey(category)) {

            for (String categor : expensesByCategories.keySet()) {

                for (Double expense : expensesByCategories.get(categor)) {

                    if (expense > maxExpense) {
                        maxExpense = expense;
                    }
                }
            }

        } else {
            System.out.println("Такой категории пока нет.");
        }
        return maxExpense;
    }

    void removeAllExpenses() {
        expensesByCategories.clear(); // Таблица называется иначе
        System.out.println("Траты удалены.");
    }
}