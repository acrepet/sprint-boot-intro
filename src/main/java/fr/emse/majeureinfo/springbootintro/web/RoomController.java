package fr.emse.majeureinfo.springbootintro.web;

import fr.emse.majeureinfo.springbootintro.dao.LightDao;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.transaction.Transactional;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping(value = "/api/rooms")
@Transactional
public class RoomController {

    private final LightDao lightDao;


    public RoomController(LightDao lightDao) {
        this.lightDao = lightDao;
    }

    @GetMapping
    public List<LightDTO> list() {
        return lightDao.findAll().stream().map(LightDTO::new).collect(Collectors.toList());
    }

}
