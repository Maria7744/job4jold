package list;

import java.util.Queue;
import java.util.Stack;

public abstract class SimpleQuire implements Queue {
  
           
   
           
          
        Stack s1= new ArrayStack(4);
        Stack s2= new ArrayStack(4);
        public void enqueue(int a) {
            s1.push(a);
        }
    /*peek – позволяет получить значение элемента, находящегося в
    начале очереди.*/
        public Object peek() {
            if(s2.isEmpty()!=true)
                s2.peek();
            else
                while(s1.isEmpty() == false){
                    s2.push(s1.peek());
                    s1.pop();
                }
            return  s2.peek();
        }
        /* dequeue – удаляет элемент, находящийся в начале очереди.*/
        public void dequeue() {
            if (s2.isEmpty()!=true)
                s2.pop();
            else
                while(s1.isEmpty()==false){
                    s2.push(s1.peek());
                    s1.pop();
                }
            s2.pop();

        }
        /* getSize – возвращает количество элементов, находящихся в
    очереди.*/
        public int getSize() {
            return s1.size()+s2.size();
        }
   /* isEmpty – возвращает true, если в очереди нет ни одного элемента.*/
        public boolean isEmpty(){
            return getSize()==0;
        }


    }

