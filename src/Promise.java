import interfaces.PromiseStateInterface;
import interfaces.ResolverInterface;
import interfaces.ThenCallback;

public class Promise {

    PromiseStateInterface resolve = new PromiseStateInterface(){
        @Override
        public void invoke(){
            thenCallback.invoke();
        }
    };

    ThenCallback thenCallback;
    ResolverInterface resolverInterface;

    public Promise(ResolverInterface p) {

        resolverInterface = p;
    }

    public void then(ThenCallback t) {
        thenCallback = t;
        resolverInterface.invoke(resolve);
    }
}
