package ua.goit;

import java.util.*;
import java.io.IOException;
import java.net.URI;

public class Main {

    /*Завдання 1
Програма повинна містити методи для реалізації наступного функціоналу:
1. створення нового об'єкта в https://jsonplaceholder.typicode.com/users. Можливо, ви не побачите одразу змін на сайті.
Метод працює правильно, якщо у відповідь на JSON з об'єктом повернувся такий самий JSON, але зі значенням id більшим
на 1, ніж найбільший id на сайті.
2. оновлення об'єкту в https://jsonplaceholder.typicode.com/users. Можливо, ви не побачите одразу змін на сайті. Вважаємо,
що метод працює правильно, якщо у відповідь ви отримаєте оновлений JSON (він повинен бути таким самим, що ви відправили).
3. видалення об'єкта з https://jsonplaceholder.typicode.com/users. Тут будемо вважати коректним результат - статус
відповіді з групи 2xx (наприклад, 200).
4. отримання інформації про всіх користувачів https://jsonplaceholder.typicode.com/users
5. отримання інформації про користувача за id https://jsonplaceholder.typicode.com/users/{id}
6. отримання інформації про користувача за username - https://jsonplaceholder.typicode.com/users?username={username}

Завдання 2
Доповніть програму методом, що буде виводити всі коментарі до останнього поста певного користувача і записувати їх у файл.
https://jsonplaceholder.typicode.com/users/1/posts Останнім вважаємо пост з найбільшим id.
https://jsonplaceholder.typicode.com/posts/10/comments
Файл повинен називатись user-X-post-Y-comments.json, де Х - id користувача, Y - номер посту.

Завдання 3
Доповніть програму методом, що буде виводити всі відкриті задачі для користувача з ідентифікатором X.
https://jsonplaceholder.typicode.com/users/1/todos.
Відкритими вважаються всі задачі, у яких completed = false.*/

    private static final String BASE_URL = "https://jsonplaceholder.typicode.com/users";

    public static void main(String[] args) throws IOException, InterruptedException {

        User user = User.builder()
                .id(3)
                .name("Leanne Graham")
                .username("Bret")
                .email("odev@mail.com")
                .address(new User.Address("Street", "Suite", "City", "010101",
                        new User.Address.Geo("-37.3159", "-37.3159")))
                .phone("001-123-45-67")
                .website("user.org")
                .company(new User.Company("Company name", "catch Phrase", "bs"))
                .build();

        //Task 1.1
/*        final User createdUser = HttpUtil.sendPost(URI.create(BASE_URL), user);
        System.out.println("createdUser = " + createdUser);*/

        //Task 1.2
/*        final User updatedUser = HttpUtil.sendPut(URI.create(BASE_URL + "/" + user.getId()), user);
        System.out.println("updatedUser = " + updatedUser);*/

        //Task 1.3
/*        final HttpResponse<String> deletedUserResponse = HttpUtil.sendDelete(URI.create(BASE_URL + "/" + user.getId()));
        System.out.println("deletedUserResponse header = " + deletedUserResponse.headers());
        System.out.println("deletedUserResponse body = " + deletedUserResponse.body());
        System.out.println("deletedUserResponse status = " + deletedUserResponse.statusCode());*/

        //Task 1.4
/*        List<User> users = HttpUtil.sendGetAll(URI.create(BASE_URL));
        System.out.println(users.toString());*/

        //Task 1.5
/*        final User userById = HttpUtil.sendGet(URI.create(BASE_URL + "/" + user.getId()));
        System.out.println("User got by id " + userById);*/

        //Task 1.6
/*        final List<User> userByName = HttpUtil.sendGet(URI.create(BASE_URL + "?username=" + user.getUsername()));
        System.out.println("User got by id " + userByName);*/

        //Task 3
        List<Todos> todos = HttpUtil.sendGetTodos(URI.create(String.format("%s/%d/todos", BASE_URL, user.getId())));
        System.out.println(todos.toString());


    }
}
