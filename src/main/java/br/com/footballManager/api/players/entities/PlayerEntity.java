package br.com.footballManager.api.players.entities;

import br.com.footballManager.api.players.dto.PlayerDTO;
import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity(name = "players")
@NoArgsConstructor
public class PlayerEntity {

    public PlayerEntity(PlayerDTO player) {this.name = player.name();}

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;

    @Column
    private String name;

}
