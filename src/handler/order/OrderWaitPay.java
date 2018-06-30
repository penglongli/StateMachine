package handler.order;

import constant.OrderEvent;
import constant.OrderState;
import handler.OrderContext;
import handler.StateHandler;

import static constant.OrderState.CANCELED;
import static constant.OrderState.COMPLETED;
import static constant.OrderState.WAIT_SELLER_CONFIRM;

public class OrderWaitPay implements StateHandler {

    @Override
    public void doAction(OrderContext context) throws RuntimeException {
        OrderEvent event = context.getEvent();
        switch (event) {
            case CANCEL: {
                cancel(context);
                break;
            }
            case PAY: {
                pay(context);
                break;
            }
            default: {
                throw new RuntimeException(
                        "Order event cannot get correct handler, event: " + event
                );
            }
        }
    }

    private void cancel(OrderContext context) {
        System.out.println("用户取消订单");
        context.setState(CANCELED);
    }

    private void pay(OrderContext context) {
        System.out.println("用户已支付");
        context.setState(WAIT_SELLER_CONFIRM);
    }
}
