package domain.calculation.audience;

import domain.Order;

public interface ITargetAudience {

    double calculatePrice(Order order);

}
