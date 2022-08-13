package hellojpa;

import javax.persistence.*;

@Entity
public class Member {
    @Id @GeneratedValue
    @Column(name = "MEMBER_ID")
    private Long id;
    @Column(name = "USERNAME")
    private String name;

    @ManyToOne //JPA에게 알려주어야 한다. Member 입장에서 Many고 Team은 One
    @JoinColumn(name="TEAM_ID") //join 한다고도 알려주자
    private Team team;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Team getTeam() {
        return team;
    }

    public void setTeam(Team team) {
        this.team = team;
    }

    public void changeTeam(Team team) { //set 보다는 다른이름으로
        this.team = team;
        team.getMembers().add(this); //실수를 줄이는 방식
    }

    @Override
    public String toString() {
        return "Member{" +
            "id=" + id +
            ", name='" + name + '\'' +
            ", team=" + team +
            '}';
    }
}