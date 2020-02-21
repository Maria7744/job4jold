package list;


public class SimpleNewQueue<T> {


    private final SimpleStack<T> list1 = new SimpleStack<>();


    private final SimpleStack<T> list2 = new SimpleStack<>();


    public void push(T value) {


        list1.push(value);


    }


    public T poll() {


        if (list2.size() == 0) {


            int stack1Size = list1.size();


            for (int i = 0; i < stack1Size; i++) {


                list2.push(list1.poll());

            }

        }

        return list2.poll();

    }


    public int size() {


        return list1.size() + list2.size();


    }


}



