package ru.javaops.topjava23.model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import lombok.*;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.time.LocalDate;

@Entity
@Table(name = "vote", uniqueConstraints = {@UniqueConstraint(name = "UniqueUserAndDate", columnNames = {"user_id", "date_entry"})})
@Getter
@Setter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@ToString(callSuper = true, exclude = {"user", "restaurant"})
public class Vote extends BaseEntity {

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id", nullable = false)
    @OnDelete(action = OnDeleteAction.CASCADE)
//    https://stackoverflow.com/questions/20119142/jackson-multiple-back-reference-properties-with-name-defaultreference#comment75246822_20271621
    @JsonBackReference(value = "user-vote")
    private User user;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "restaurant_id", nullable = false)
    @OnDelete(action = OnDeleteAction.CASCADE)
    @JsonBackReference
    private Restaurant restaurant;

    @Column(name = "date_entry", nullable = false)
    @NotNull
    private LocalDate date;

    public Vote(Integer id, User user, Restaurant restaurant, LocalDate date) {
        super(id);
        this.user = user;
        this.restaurant = restaurant;
        this.date = date;
    }
}
