package uk.gov.companieshouse.waterpoloapi.model;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

@ExtendWith(MockitoExtension.class)
class PlayerModelTest {

    private PlayerModel testPlayerModel;

    @BeforeEach
    void setUp() {
        testPlayerModel = new PlayerModel("name", 0, "position");
    }

    @Test
    void playerModel() {
        assertThat(testPlayerModel.getName(), is("name"));
        assertThat(testPlayerModel.getAge(), is(0));
        assertThat(testPlayerModel.getPosition(), is("position"));
    }
}