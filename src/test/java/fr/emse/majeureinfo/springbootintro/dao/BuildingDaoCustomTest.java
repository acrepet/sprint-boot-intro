package fr.emse.majeureinfo.springbootintro.dao;

import com.ninja_squad.dbsetup.DbSetup;
import com.ninja_squad.dbsetup.DbSetupTracker;
import com.ninja_squad.dbsetup.Operations;
import com.ninja_squad.dbsetup.destination.DataSourceDestination;
import com.ninja_squad.dbsetup.operation.DeleteAll;
import com.ninja_squad.dbsetup.operation.Insert;
import com.ninja_squad.dbsetup.operation.Operation;
import fr.emse.majeureinfo.springbootintro.CommonOperations;
import fr.emse.majeureinfo.springbootintro.model.Building;
import fr.emse.majeureinfo.springbootintro.model.Status;
import org.assertj.core.api.Java6Assertions;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.TestPropertySource;
import org.springframework.test.context.junit4.SpringRunner;

import javax.sql.DataSource;

import java.util.List;

import static com.ninja_squad.dbsetup.Operations.deleteAllFrom;
import static org.assertj.core.api.Java6Assertions.assertThat;


@RunWith(SpringRunner.class)
@DataJpaTest
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
@TestPropertySource("/test.properties")
public class BuildingDaoCustomTest {

    @Autowired
    private BuildingDao buildingDao;


    @Qualifier("dataSource")
    @Autowired
    private DataSource dataSource;

    protected static final DbSetupTracker TRACKER = new DbSetupTracker();

    protected void dbSetup(Operation operation) {
        DbSetup setup = new DbSetup(new DataSourceDestination(dataSource),
                Operations.sequenceOf(CommonOperations.DELETE_ALL, operation));
        TRACKER.launchIfNecessary(setup);
    }

    @Before
    public void prepare() {
        Operation lighton =
                Insert.into("LIGHT")
                        .columns("id", "level", "status")
                        .values(1L, 22, Status.ON)
                        .build();
        Operation lightoff =
                Insert.into("LIGHT")
                        .columns("id", "level", "status")
                        .values(2L, 22, Status.OFF)
                        .build();
        Operation building =
                Insert.into("BUILDING")
                        .columns("id", "name")
                        .values(1L, "Ada Lovelace")
                        .build();
        Operation room =
                Insert.into("ROOM")
                        .columns("id", "light_id", "building_id")
                        .values(1L, 1L, 1L)
                        .build();
        Operation room2 =
                Insert.into("ROOM")
                        .columns("id", "light_id", "building_id")
                        .values(2L, 2L, 1L)
                        .build();
        dbSetup(Operations.sequenceOf(lighton, lightoff, building, room, room2));
    }

    @Test
    public void shouldFindWithCountedRooms() {
        TRACKER.skipNextLaunch();
        List<BuildingWithRoomsCountersDTO> dtos = buildingDao.findWithCountedRooms();
        assertThat(dtos).extracting(BuildingWithRoomsCountersDTO::getNbWithLightsOn).containsExactly(1L);
        assertThat(dtos).extracting(BuildingWithRoomsCountersDTO::getNb).containsExactly(2L);
    }


}