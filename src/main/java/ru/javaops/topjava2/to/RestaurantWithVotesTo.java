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
public class RestaurantWithVotesTo extends NamedTo implements HasId, Serializable {
    @Serial
    private static final long serialVersionUID = 1L;

    List<Dish> dishes;

    Integer votesCount;

    public RestaurantWithVotesTo(Integer id, String name, List<Dish> dishes, Integer votesCount) {
        super(id, name);
        this.dishes = dishes;
        this.votesCount = votesCount;
    }
}