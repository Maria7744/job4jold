package src.ru.job4j.map;
/*
Главным условием, которое нарушается, если вы не переопределили hashCode,
        является второе: равные объекты должны иметь одинаковый хэш-код. Если вы не
        переопределите метод hashCode, оно будет нарушено: два различных экземпляра с точки
        зрения метода equals могут быть логически равны, однако для метода hashCode из класса Object
        это всего лишь два объекта, не имеющие между собой ничего общего. Поэтому метод hashCode,
        скорее всего, возвратит для этих объектов два случайных числа, а не о
        динаковых, как того требует контракт.*/
 public final class PhoneNumber {
     private final short areaCode;
     private final short prefix;
     private final short lineNumber;
    public PhoneNumber(int areaCode, int prefix, int lineNumber) {
        rangeCheck(areaCode, 999, "area code");
        rangeCheck(prefix, 999, "prefix");
        rangeCheck(lineNumber, 9999, "line number");
        this.areaCode = (short) areaCode;
        this.prefix = (short) prefix;
        this.lineNumber = (short) lineNumber;
    }
    private static void rangeCheck(int arg, int max, String name) {
        if (arg < 0 || arg > max)
        throw new IllegalArgumentException(name + ": " + arg);
    }
    @Override
    public boolean equals(Object o) { if (o == this)
        return true;
        if (!(o instanceof PhoneNumber))
            return false;
        PhoneNumber pn = (PhoneNumber) o;
        return pn.lineNumber == lineNumber && pn.prefix == prefix
                && pn.areaCode == areaCode;
    }
    @Override public int hashCode() {
        int result = 17;
        result = 31 * result + areaCode;
        result = 31 * result + prefix;
        result = 31 * result + lineNumber;
        return result;
    }
}
