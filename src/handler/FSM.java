package handler;

import constant.OrderState;
import handler.order.*;

public class FSM {

    public static void transfer(OrderContext context) throws RuntimeException {
        StateHandler handler = getHandler(context.getState());
        if (null == handler) {
            throw new RuntimeException(
                    "Cannot get handler by order state in context, order_state: "
                    + context.getState()
            );
        }

        handler.doAction(context);
    }

    // 此处可以使用表驱动法改写
    private static StateHandler getHandler(OrderState state) {
        switch (state) {
            case WAIT_PAY: {
                return new OrderWaitPay();
            }
            case WAIT_SELLER_CONFIRM: {
                return new OrderWaitSellerConfirm();
            }
            case WAIT_SELLER_DELIVERING: {
                return new OrderWaitSellerDeliver();
            }
            case WAIT_BUYER_CONFIRMED: {
                return new OrderWaitBuyerConfirm();
            }
            case WAIT_EVALUATION: {
                return new OrderWaitEvaluation();
            }
        }
        return null;
    }
}
