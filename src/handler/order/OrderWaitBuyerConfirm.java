package handler.order;

import constant.OrderEvent;
import handler.OrderContext;
import handler.StateHandler;

import static constant.OrderState.*;

// 等待买家确认收货
public class OrderWaitBuyerConfirm implements StateHandler {

    @Override
    public void doAction(OrderContext context) throws RuntimeException {
        OrderEvent event = context.getEvent();
        switch (event) {
            case BUYER_CONFIRM: {
                buyerConfirm(context);
                break;
            }
            default: {
                throw new RuntimeException(
                        "Order event cannot get correct handler, event: " + event
                );
            }
        }
    }

    private void buyerConfirm(OrderContext context) {
        System.out.println("用户已经确认收货");
        context.setState(WAIT_EVALUATION);
    }
}
