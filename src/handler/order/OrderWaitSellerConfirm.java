package handler.order;

import constant.OrderEvent;
import constant.OrderState;
import handler.OrderContext;
import handler.StateHandler;

import static constant.OrderState.COMPLETED;
import static constant.OrderState.WAIT_SELLER_DELIVERING;

public class OrderWaitSellerConfirm implements StateHandler {

    @Override
    public void doAction(OrderContext context) throws RuntimeException {
        OrderEvent event = context.getEvent();
        switch (event) {
            case SELLER_CONFIRM: {
                sellerConfirm(context);
                break;
            }
            default: {
                throw new RuntimeException(
                        "Order event cannot get correct handler, event: " + event
                );
            }
        }
    }

    private void sellerConfirm(OrderContext context) {
        System.out.println("卖家已确认接单");
        context.setState(WAIT_SELLER_DELIVERING);
    }

}
