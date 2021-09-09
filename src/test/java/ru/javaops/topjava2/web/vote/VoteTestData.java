package ru.javaops.topjava2.web.vote;

import ru.javaops.topjava2.model.Vote;
import ru.javaops.topjava2.web.MatcherFactory;

import java.time.LocalDate;

import static ru.javaops.topjava2.web.restaurant.RestaurantTestData.restaurant1;
import static ru.javaops.topjava2.web.restaurant.RestaurantTestData.restaurant2;
import static ru.javaops.topjava2.web.user.UserTestData.admin;
import static ru.javaops.topjava2.web.user.UserTestData.user;

public class VoteTestData {
    public static final MatcherFactory.Matcher<Vote> MATCHER = MatcherFactory.usingIgnoringFieldsComparator(Vote.class, "restaurant", "user");

    public static final int VOTE1_ID = 1;
    public static final LocalDate CURRENT_DATE = LocalDate.now();
    public static final LocalDate OLD_DATE = LocalDate.of(2021, 9, 1);

    public static final Vote vote1 = new Vote(VOTE1_ID, user, restaurant1, CURRENT_DATE);
    public static final Vote vote2 = new Vote(VOTE1_ID, admin, restaurant1, CURRENT_DATE);
    public static final Vote vote3 = new Vote(VOTE1_ID, user, restaurant1, OLD_DATE);
    public static final Vote vote4 = new Vote(VOTE1_ID, admin, restaurant2, OLD_DATE);
}
