package hallym.hashtag.domain.room.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.ColumnDefault;

import javax.persistence.*;

@Data
@Builder
@Entity
@Table(name = "room")
@AllArgsConstructor
@NoArgsConstructor
public class Room {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long rno;

    private Floor floor;

    private String name;

    private String content;

    @ColumnDefault("false")
    private boolean studyRoom;

    @ColumnDefault("false")
    private boolean reserve;

    public void setReserve(boolean reserve) {
        this.reserve = reserve;
    }
}