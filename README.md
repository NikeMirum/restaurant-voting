[![Codacy Badge](https://app.codacy.com/project/badge/Grade/487c3e0b18af4e85869a333de12d627b)](https://www.codacy.com/gh/NikeMirum/restaurant-voting/dashboard?utm_source=github.com&amp;utm_medium=referral&amp;utm_content=NikeMirum/restaurant-voting&amp;utm_campaign=Badge_Grade)
![Build Status](https://travis-ci.com/NikeMirum/restaurant-voting.svg?branch=master)

[Graduation TopJava-23 project](https://javaops.ru/7view/topjava2)
===============================

### Graduation project [task](https://github.com/JavaOPs/topjava/blob/master/graduation.md) is to build a voting system for deciding where to have lunch:
* 2 types of users: admin and regular users
* Admin can input a restaurant and it's lunch menu of the day (2-5 items usually, just a dish name and price)
* Menu changes each day (admins do the updates)
* Users can vote on which restaurant they want to have lunch at
* Only one vote counted per user
* If user votes again the same day:
  - If it is before 11:00 we assume that he changed his mind.
  - If it is after 11:00 then it is too late, vote can't be changed
* Each restaurant provides a new menu each day.

### How it works
When the authorisation is done (see authorisation data below) depending on permissions, given by roles,
ADMIN and USER are having the following rights

#### ADMIN:
- Can manage users at AdminUserController (/api/admin/users)
- Can input restaurants by AdminRestaurantController (/api/admin/restaurants)
- Can input daily menu by AdminDishController per each restaurant (/api/restaurants/{restaurantId}/dishes)
by adding and editing dishes

#### ADMIN and USER:
- Can go into /api/restaurants, in which RestaurantTo objects, based by Restaurant objects with vote counts field 
can be received, controlled by ProfileAdminRestaurantController
- By VoteController Depending on GET query getVoteByUserToday() response, the vote, if user hasn't vot today yet,
  (VoteService#isVoteTodayAlreadyDone() = false) or re-vote(if it is not later than VOTING_TIME_DEADLINE) can be done.

### API documentation performed by Swagger
- http://localhost:8080/swagger-ui.html
- http://localhost:8080/v3/api-docs

### Authorization data for users
- **Admin**  login: admin@gmail.com, pass: admin
- **User**  login:user@yandex.ru, pass:password

### Notes
- For one of 43 tests passing in VoteService VOTING_TIME_DEADLINE constant should be more than current hour
or at least it should be tested earlier than 11am.
- Some methods in controllers are performed not only for current day but also for different day
just for the case if in future there would be necessity to upload menu for the future, see the history of even vote