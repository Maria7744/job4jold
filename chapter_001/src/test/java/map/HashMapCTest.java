package map;

public class HashMapCTest {
    /*

    private User first = new User("mar", 3, new GregorianCalendar(1980, 3, 1));
    private User duplicate = new User("mar", 3, new GregorianCalendar(1980, 3, 1));
    private User second = new User("van", 1, new GregorianCalendar(1996, 2, 15));
    private User third = new User("fedor", 2, new GregorianCalendar(1995, 6, 24));


    /**
     * Проверяем что объект добавляется в контейнер.
     */
   /* @Test
    public void whenAddOneElemThenSizeOne() {
        HashMapC<User, Integer> map = new HashMapC<>();
        map.insert(this.first, 1);
        assertThat(map.size(), is(1));
    }

    /**
     * Проверяем что дубликаты не добавляется в контейнер.
     */
   /* @Test
    public void whenAddDuplicateThenSizeOne() {
        HashMapC<User, Integer> map = new HashMapC<>();
        map.insert(this.first, 1);
        map.insert(this.duplicate, 2);
        assertThat(map.size(), is(1));
    }

    /**
     * Проверяем что поиск элемента по значение отрабатывает
     * корректно.
     */
  /*  @Test
    public void whenCheckToContainsElementThenTrue() {
        HashMapC<User, Integer> map = new HashMapC<>();
        map.insert(this.first, 1);
        map.insert(this.second, 3);
        assertThat(map.get(this.first), is(1));
        assertThat(map.get(this.second), is(3));
        assertNull(map.get(this.third));
    }

    /**
     * Проверяем что удаление объекта из контейнера проходит
     * корректно.
     */
   /* @Test
    public void whenRemoveElementThenTrue() {
        HashMapC<User, Integer> map = new HashMapC<>();
        map.insert(this.first, 1);
        map.insert(this.second, 2);
        assertThat(map.delete(this.second), is(true));
        assertThat(map.size(), is(1));

    }



    /**
     * Првоеряем, что если такого объекта для удаления нет в
     * контейнере, то вернется false.
     */
    /*@Test
    public void whenRemoveElementThatNotPresentThenFalse() {
        HashMapC<User, Integer> map = new HashMapC<>();
        map.insert(this.first, 1);
        map.insert(this.second, 2);
        assertThat(map.delete(this.third), is(false));

    }

    /**
     * Проверяем что массив увеличивается.
     */
    /*@Test
    public void whenAddMoreThenDefaultCapacity16ThenNextAddWillOk() {
        HashMapC<String, Integer> map = new HashMapC<>();
        for (int i = 1; i <= 20; i++) {
            map.insert(String.valueOf(i), i);
        }
        assertThat(map.size(), is(20));
    }*/

    /**
     * Проверяем что итератор работает корректно.
     */
   /* @Test(expected = NoSuchElementException.class)
    public void whenThen() {
        HashMapC<User, Integer> map = new HashMapC<>();
        map.insert(this.first, 1);
        map.insert(this.second, 2);
        map.insert(this.third, 2);
        Iterator<User> it = map.iterator();
        assertThat(it.hasNext(), is(true));
        it.next();
        assertThat(it.hasNext(), is(true));
        it.next();
        assertThat(it.hasNext(), is(true));
        it.next();
        assertThat(it.hasNext(), is(false));
        it.next();
    }
    */
}


