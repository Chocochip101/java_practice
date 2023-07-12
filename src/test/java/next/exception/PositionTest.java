package next.exception;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import org.junit.jupiter.api.Test;

public class PositionTest {
    @Test
    public void create_00() {
        Position p = new Position("a1");
        assertThat(p.getX()).isEqualTo(0);
        assertThat(p.getY()).isEqualTo(0);
    }
    
    @Test
    public void create_77() {
        Position p = new Position("h8");
        assertThat(p.getX()).isEqualTo(7);
        assertThat(p.getY()).isEqualTo(7);
    }

    @Test
    public void 길이가_2가_아닌_경우() {
        assertThatThrownBy(() -> new Position("a"))
                .isInstanceOf(InValidPositionException.class);
    }
    
    @Test
    public void notValid_0보다_작은_X() {
        assertThatThrownBy(() -> new Position("Z1"))
                .isInstanceOf(InValidPositionException.class);
    }
    
    @Test
    public void notValid_7보다_큰_X() {
        assertThatThrownBy(() -> new Position("i1"))
                .isInstanceOf(InValidPositionException.class);
    }
    
    @Test
    public void notValid_0보다_작은_Y() {
        new Position("a0");
        assertThatThrownBy(() -> new Position("a0"))
                .isInstanceOf(InValidPositionException.class);
    }
    
    @Test
    public void notValid_7보다_큰_Y() {
        assertThatThrownBy(() -> new Position("a9"))
                .isInstanceOf(InValidPositionException.class);
    }

}
