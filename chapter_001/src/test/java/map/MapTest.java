package map;
//переопределяем только eguals

import org.junit.Test;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

public class MapTest {
    public static final class User {
        private String name;
        private int children;
        private String birthday;


        public User(String name, int children, String birthday) {
            this.name = name;
            this.children = children;
            this.birthday = birthday;

        }

          @SuppressWarnings("checkstyle:EqualsHashCode")
          @Override
          //Проверить на равенство ссылки объектов this и параметра метода o.
          //if (this == o) return true;
          //Проверить, определена ли ссылка o, т. е. является ли она null.
          //Если в дальнейшем при сравнении типов объектов будет использоваться
          // оператор instanceof, этот пункт можно пропустить,
          // т. к. этот параметр возвращает false в данном случае null instanceof Object.
          //Сравнить типы объектов this и o с помощью оператора instanceof или метода getClass(),
          // руководствуясь описанием выше и собственным чутьем.
          //Если метод equals переопределяется в подклассе, не забудьте сделать
          // вызов super.equals(o)
          //Выполнить преобразование типа параметра o к требуемому классу.
          //Выполнить сравнение всех значимых полей объектов:
          //для примитивных типов (кроме float и double), используя оператор ==
          //для ссылочных полей необходимо вызвать их метод equals
          //для массивов можно воспользоваться перебором по циклу, либо методом Arrays.equals()
          //для типов float и double необходимо использовать методы сравнения соответствующих
          // оберточных классов Float.compare() и Double.compare()
          //И, наконец, ответить на три вопроса: является ли реализованный метод симметричным?
          // Транзитивным? Согласованным? Два других принципа (рефлексивность и определенность),
          // как правило, выполняются автоматически.
          public boolean equals(Object o) {
              if (this == o) {
                  return true;
              }
              if (o == null || getClass() != o.getClass()) {
                  return false;
              }

              User user = (User) o;

              // if (children != user.children) {
              //  return false;
              // }
              if (!Objects.equals(name, user.name)) {
                  return false;
              }
              return true;
              //return birthday != null ? birthday.equals(user.birthday) : user.birthday == null;
          }

        @Override
        public int hashCode() {
            int result = name != null ? name.hashCode() : 0;
            result = 31 * result + children;
            //  result = 31 * result + (birthday != null ? birthday.hashCode() : 0);
            return result;
        }

    }

    @Test

    public void map() {
        User first = new User("Maria7744", 2, "07ff1979");
        User second = new User("Maria7744", 2, "07ff1979");
        Map<User, String> map = new HashMap<>();
        map.put(first, "first");
        map.put(second, "second");
        System.out.println(map.get(first));


    }
}





