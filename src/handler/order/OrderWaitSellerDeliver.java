package handler.order;

import constant.OrderEvent;
import handler.OrderContext;
import handler.StateHandler;

import static constant.OrderState.WAIT_BUYER_CONFIRMED;
import static constant.OrderState.WAIT_EVALUATION;
import static constant.OrderState.WAIT_SELLER_DELIVERING;

public class OrderWaitSellerDeliver implements StateHandler {

    @Override
    public void doAction(OrderContext context) throws RuntimeException {
        OrderEvent event = context.getEvent();
        switch (event) {
            case DELIVER: {
                deliver(context);
                break;
            }
            default: {
                throw new RuntimeException(
                        "Order event cannot get correct handler, event: " + event
                );
            }
        }
    }

    private void deliver(OrderContext context) {
        System.out.println("卖家已发货");
        context.setState(WAIT_BUYER_CONFIRMED);
    }
}
