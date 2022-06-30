package uk.gov.companieshouse.waterpoloapi.model;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;

import java.util.ArrayList;
import java.util.List;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

@ExtendWith(MockitoExtension.class)
class TeamModelTest {

    private List<PlayerModel> testListPlayerModel = new ArrayList<PlayerModel>();
    private TeamModel testTeamModel;

    @BeforeEach
    void setUp() {
        testListPlayerModel.add(new PlayerModel("name", 0, "position"));
        testListPlayerModel.add(new PlayerModel("name2", 1, "position2"));
        testTeamModel = new TeamModel("name", "location", 0, 0, "captain", testListPlayerModel);
    }

    @Test
    void teamModel() {
        assertThat(testTeamModel.getTeamName(), is("name"));
        assertThat(testTeamModel.getTeamLocation(), is("location"));
        assertThat(testTeamModel.getTeamRank(), is(0));
        assertThat(testTeamModel.getTeamPoints(), is(0));
        assertThat(testTeamModel.getTeamCaptain(), is("captain"));
        assertThat(testTeamModel.getTeamSquad(), is(testListPlayerModel));
    }
}