package com.nethard.eleven.service.mapper;

import com.nethard.eleven.domain.*;
import com.nethard.eleven.service.dto.PlayerDTO;

import org.mapstruct.*;
import java.util.List;

/**
 * Mapper for the entity Player and its DTO PlayerDTO.
 */
@Mapper(componentModel = "spring", uses = {UserMapper.class, })
public interface PlayerMapper {

    @Mapping(source = "user.id", target = "userId")
    PlayerDTO playerToPlayerDTO(Player player);

    List<PlayerDTO> playersToPlayerDTOs(List<Player> players);

    @Mapping(source = "userId", target = "user")
    @Mapping(target = "teams", ignore = true)
    Player playerDTOToPlayer(PlayerDTO playerDTO);

    List<Player> playerDTOsToPlayers(List<PlayerDTO> playerDTOs);
}
