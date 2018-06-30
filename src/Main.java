import handler.FSM;
import handler.OrderContext;

import static constant.OrderEvent.*;
import static constant.OrderState.*;

public class Main {

    public static void main(String[] args) {
        OrderContext context = new OrderContext();

        // 买家付款
        context.setState(WAIT_PAY);
        context.setEvent(PAY);
        FSM.transfer(context);

        // 卖家接单
        context.setEvent(SELLER_CONFIRM);
        FSM.transfer(context);

        // 卖家发货
        context.setEvent(DELIVER);
        FSM.transfer(context);

        // 买家确认
        context.setEvent(BUYER_CONFIRM);
        FSM.transfer(context);

        // 买家评价
        context.setEvent(EVALUATION);
        FSM.transfer(context);
    }
}
