package fr.emse.majeureinfo.springbootintro.web;

import fr.emse.majeureinfo.springbootintro.dao.RoomDao;
import fr.emse.majeureinfo.springbootintro.model.Room;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.transaction.Transactional;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping(value = "/api/rooms")
@Transactional
public class RoomController {

    private final RoomDao roomDao;


    public RoomController(RoomDao roomDao) {
        this.roomDao = roomDao;
    }

    @GetMapping
    public List<RoomDto> list() {
        return roomDao.findAll()
                .stream()
                .map(RoomDto::new)
                .collect(Collectors.toList());
    }

    @GetMapping(value={"/{roomId}","/{roomId}/context"})
    public RoomDto get(@PathVariable("roomId") Long roomId) {
        return new RoomDto(checkIfRoomExists(roomId));
    }

    @PutMapping("/{roomId}/switch-light-and-list")
    @ResponseStatus(HttpStatus.OK)
    public List<RoomDto> switchLightAndList(@PathVariable("roomId") Long roomId) {
        Room room = checkIfRoomExists(roomId);
        room.switchLight();
        return this.list();
    }

    @PutMapping("/{roomId}/switch-ringer-and-list")
    @ResponseStatus(HttpStatus.OK)
    public List<RoomDto> switchRingerAndList(@PathVariable("roomId") Long roomId) {
        Room room = checkIfRoomExists(roomId);
        room.switchRinger();
        return this.list();
    }


    @GetMapping(value={"/list-with-on-light"})
    public List<RoomDto> listWithOnLight(){
        return roomDao.findWithOnLights()
                .stream()
                .map(RoomDto::new)
                .collect(Collectors.toList());
    }

    private Room checkIfRoomExists(Long roomId){
        if (roomId == null) throw new NotFoundException("Room ID must not be null");
        Room room = roomDao.findOne(roomId);
        if (room == null) throw new NotFoundException("No room with ID " + roomId);
        return room;
    }
}
