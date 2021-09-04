package ru.javaops.topjava2.to;

import lombok.EqualsAndHashCode;
import lombok.Value;
import ru.javaops.topjava2.HasId;
import ru.javaops.topjava2.model.Dish;

import java.io.Serial;
import java.io.Serializable;
import java.util.List;

@Value
@EqualsAndHashCode(callSuper = true)
public class RestaurantTo extends NamedTo implements HasId, Serializable {
    @Serial
    private static final long serialVersionUID = 1L;

    List<Dish> dishes;

}
