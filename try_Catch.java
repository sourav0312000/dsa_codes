import java.util.Random;
public class try_Catch
    
{
    public static void main(String[] args) {
        Random r=new Random();
        for(int i=0;i<10;i++){
            try{
            int a=r.nextInt(5);
            int b=r.nextInt(5);
            int c=b/a;
            System.out.println("Result: "+c);
            }catch(Exception e){
            System.out.println("Error: "+e.getMessage());
            }
        }
    }
}

