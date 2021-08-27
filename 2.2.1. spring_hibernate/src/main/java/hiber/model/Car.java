package hiber.model;

import javax.persistence.*;

@Entity
@Table(name = "Cars")
public class Car {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column
    private String model;

    @Column
    private int series;

    @OneToOne
    @JoinColumn
    private User user;

    public Car(){
    }

    public Long getId(){
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setModel(String model){
        this.model = model;
    }

    public String getModel(){
        return model;
    }

    public int getSeries(){
        return series;
    }

    public void setSeries(int series) {
        this.series = series;
    }

    public User getUser(){
        return user;
    }

    public User setUser(User user) {
        this.user = user;
        return user;
    }

}
