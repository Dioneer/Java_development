package Pegas.Lection3;

public class Main {
  static class Box{
       private Object obj;
       public Box(Object obj){
           this.obj = obj;
       }

       public Object getObj() {
           return obj;
       }

       public void setObj(Object obj) {
           this.obj = obj;
       }
       public void printInfo(){
           System.out.printf("Box (%s): %s", obj.getClass().getSimpleName(), obj.toString());
       }
   }

    public static void main(String[] args) {
        Box box1 = new Box(3);
        Box box2 = new Box(4);
        System.out.println((Integer) box2.getObj()+ (Integer)box1.getObj());
    }
}
