package handler;

import constant.OrderEvent;
import constant.OrderState;

public class OrderContext {
    // 业务数据
    private Object data;

    private OrderState state;

    private OrderEvent event;

    public Object getData() {
        return data;
    }

    public void setData(Object data) {
        this.data = data;
    }

    public OrderState getState() {
        return state;
    }

    public void setState(OrderState state) {
        this.state = state;
    }

    public OrderEvent getEvent() {
        return event;
    }

    public void setEvent(OrderEvent event) {
        this.event = event;
    }
}
