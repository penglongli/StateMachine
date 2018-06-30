package handler;

public interface StateHandler {

    void doAction(OrderContext context) throws RuntimeException;
}
