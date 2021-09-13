package ru.javaops.topjava23.web.vote;

import ru.javaops.topjava23.model.Vote;
import ru.javaops.topjava23.web.MatcherFactory;

import java.time.LocalDate;

import static ru.javaops.topjava23.web.restaurant.RestaurantTestHelper.restaurant1;
import static ru.javaops.topjava23.web.restaurant.RestaurantTestHelper.restaurant2;
import static ru.javaops.topjava23.web.user.UserTestHelper.admin;
import static ru.javaops.topjava23.web.user.UserTestHelper.user;

public class VoteTestHelper {
    public static final MatcherFactory.Matcher<Vote> MATCHER = MatcherFactory
            .usingIgnoringFieldsComparator(Vote.class, "restaurant", "user", "date");

    public static final int VOTE1_ID = 1;
    public static final int VOTE2_ID = 2;
    public static final int VOTE3_ID = 3;
    public static final LocalDate CURRENT_DATE = LocalDate.now();
    public static final LocalDate OLD_DATE = LocalDate.of(2021, 9, 1);

    public static final Vote vote1 = new Vote(VOTE1_ID, user, restaurant1, OLD_DATE);
    public static final Vote vote2 = new Vote(VOTE2_ID, admin, restaurant1, OLD_DATE);
    public static final Vote vote3 = new Vote(VOTE3_ID, user, restaurant1, CURRENT_DATE);

    public static Vote getNew() {
        return new Vote(null, admin, restaurant2, CURRENT_DATE);
    }

    public static Vote getUpdated() {
        return new Vote(VOTE3_ID, user, restaurant2, CURRENT_DATE);
    }
}
