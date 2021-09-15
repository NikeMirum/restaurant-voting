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

### API documentation performed by Swagger

- http://localhost:8080/swagger-ui.html
- http://localhost:8080/v3/api-docs

### Authorization data for users

- **Admin**  login: admin@gmail.com, pass: admin
- **User**  login: user@yandex.ru, pass: password