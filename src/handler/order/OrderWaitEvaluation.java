package handler.order;

import constant.OrderEvent;
import handler.OrderContext;
import handler.StateHandler;

import static constant.OrderState.COMPLETED;

public class OrderWaitEvaluation implements StateHandler {

    @Override
    public void doAction(OrderContext context) throws RuntimeException {
        OrderEvent event = context.getEvent();
        switch (event) {
            case EVALUATION: {
                evaluation(context);
                break;
            }
            default: {
                throw new RuntimeException(
                        "Order event cannot get correct handler, event: " + event
                );
            }
        }
    }

    private void evaluation(OrderContext context) {
        System.out.println("用户已评价");
        context.setState(COMPLETED);
    }

}
