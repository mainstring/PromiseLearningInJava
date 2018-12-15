import interfaces.PromiseStateInterface;
import interfaces.ResolverInterface;
import interfaces.ThenCallback;

public class Main {

    public static void main(String[] args) {

        WaitInterface wait = new WaitInterface(){
            @Override
            public Promise invoke(long time) {
                return new Promise( new ResolverInterface() {
                    @Override
                    public void  invoke(PromiseStateInterface resolve) {
                        setTimeout(resolve, time);
                    }
                });
            }
        };

        wait.invoke(3).then(new ThenCallback() {
            @Override
            public void invoke() {
//                console.log('Hello!');
                System.out.println("Hello!");
            }
        });
    }


    private static void setTimeout (PromiseStateInterface resolve, long time) {
        while(time>0) {
            try {

                Thread.sleep(1000); // milliseconds
                time--;

            } catch (Exception e) {
                return;
            }
        }
        resolve.invoke();
    }
}
